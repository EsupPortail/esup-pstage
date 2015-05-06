/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import gouv.education.apogee.commun.transverse.dto.geographie.CommuneDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;
import org.esupportail.pstage.domain.DomainService;
import org.esupportail.pstage.utils.GenTicketStage;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.NafN5DTO;
import org.esupportail.pstagedata.domain.dto.PaysDTO;
import org.esupportail.pstagedata.domain.dto.ServiceDTO;
import org.esupportail.pstagedata.domain.dto.StatutJuridiqueDTO;
import org.esupportail.pstagedata.domain.dto.StructureDTO;
import org.esupportail.pstagedata.domain.dto.TicketStructureDTO;
import org.esupportail.pstagedata.domain.dto.TypeStructureDTO;
import org.esupportail.pstagedata.exceptions.AccountAlreadyExistingForCoupleMailStructureException;
import org.esupportail.pstagedata.exceptions.ContactDeleteException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.MailAlreadyUsedForStructureException;
import org.esupportail.pstagedata.exceptions.ServiceDeleteException;
import org.esupportail.pstagedata.exceptions.StructureDeleteException;
import org.esupportail.pstagedata.exceptions.StructureNumSiretException;
import org.esupportail.pstagedata.exceptions.UnvalidNumSiretException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.springframework.util.StringUtils;

/**
 * AccordController
 */
public class EtablissementController extends AbstractContextAwareController {

	/* ***************************************************************
	 * Propriétés
	 ***************************************************************/

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 3430944955282121430L;
	/**
	 * Logger
	 */
	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * RechercheController
	 */
	private RechercheController rechercheController;
	/* *******************************************************************
	 * Variables pour le formulaire d'établissement ajout/modif
	 */
	/**
	 * Objet Structure uniquement utilisé pour l'ajout/modification
	 */
	private StructureDTO formStructure = null;
	/**
	 * Liste dynamique mise à jour en fonction du type de structure
	 */
	private List<SelectItem> statutsJuridiquesListening = null;
	/**
	 * Objet TypeStructure temporaire utilisé pour le choix dynamique du Statut
	 * juridique à cause de a4j:support
	 */
	private TypeStructureDTO formStructureTmpTypeStructure;
	/**
	 * Objet StatutJuridiqueDTO temporaire utilis� pour l'affichage dynamique du
	 * Statut juridique à cause de a4j:support
	 */
	private StatutJuridiqueDTO formStructureTmpStatutJuridique;
	/**
	 * Objet PaysDTO temporaire utilisé pour l'affichage dynamique du drapeau à
	 * cause de a4j:support
	 */
	private PaysDTO formStructureTmpPays;
	/**
	 * Objet NafN5DTO temporaire utilis� pour l'affichage dynamique du libellé à
	 * cause de a4j:support
	 */
	private NafN5DTO formStructureTmpNafN5;
	/**
	 * Code postal temporaire utilisé pour la saisie de la commune à cause de
	 * a4j:support
	 */
	private String formStructureTmpCodePostal;
	/**
	 * CommuneDTO
	 */
	private CommuneDTO formStructureTmpCommuneDTO;
	/**
	 * Liste dynamique mise à jour en fonction du département saisi
	 */
	private List<SelectItem> communesListening = new ArrayList<SelectItem>();
	/**
	 * Affichage ou non du bouton annuler sur la page de modification d'un
	 * établissement
	 */
	private boolean modificationEtabBoutonAnnuler = false;
	/**
	 * code naf obligatoire ou non
	 */
	private boolean codeNafObligatoire;
	/* **
	 * FIN Variables pour le formulaire d'établissement ajout/modif
	 * ********************************************************************
	 */
	/* *******************************************************************
	 * Variables pour la gestion des contacts et services
	 */
	/**
	 * Liste des services de la structure actuellement gérée
	 */
	private List<ServiceDTO> listeServices;
	/**
	 * List<SelectItem> des services
	 */
	private List<SelectItem> servicesItems;
	/**
	 * Service actuellement géré
	 */
	private ServiceDTO formService;
	/**
	 * Objet PaysDTO temporaire utilisé pour l'affichage dynamique du drapeau
	 */
	private PaysDTO formServiceTmpPays;
	/**
	 * Code postal temporaire utilisé pour la saisie de la commune
	 */
	private String formServiceTmpCodePostal;
	/**
	 * CommuneDTO
	 */
	private CommuneDTO formServiceTmpCommuneDTO = new CommuneDTO();
	/**
	 * Liste dynamique mise à jour en fonction du département saisi
	 */
	private List<SelectItem> formServiceCommunesListening = new ArrayList<SelectItem>();
	/**
	 * Vrai l'adresse du service à ajouter/en cours de modification est la même
	 * que l'adresse de la structure
	 */
	private boolean memeAdresseStructure;
	/**
	 * Id du service sélectionné
	 */
	private int idServiceSel;
	/**
	 * Service sélectionné
	 */
	private ServiceDTO serviceSel;
	/**
	 * Liste des contacts pour le service actuellement géré
	 */
	private List<ContactDTO> listeContacts;
	/**
	 * Id du contact sélectionné (formulaire d'offre et convention)
	 */
	private int idContactSel;
	/**
	 * Contact sélectionné (form offre/convention)
	 */
	private ContactDTO contactSel;
	/**
	 * List<SelectItem> des contacts
	 */
	private List<SelectItem> contactsItems;
	/**
	 * Contact actuellement géré
	 */
	private ContactDTO formContact;
	/**
	 * Contacts Keys
	 */
	private Set<Integer> keysContacts = new HashSet<Integer>();
	/**
	 * afficherSelectionCentre à la modification d'un contact
	 */
	private boolean afficherSelectionCentreContact = false;
	/**
	 * currentCentresGestionContainsCentreContact
	 */
	private boolean currentCentresGestionContainsCentreContact = false;
	/**
	 * currentCentresGestionContainsCentreEntr
	 */
	private boolean currentCentresGestionContainsCentreEntr = true;
	/**
	 * Numéro de la ligne contact sélectionnée
	 */
	private int currentRowContact;
	/**
	 * Structure en cours de validation
	 */
	private StructureDTO currentStruct;
	/* **
	 * FIN Variables pour la gestion des contacts et services
	 * *******************************************************************
	 */
	// Changement de mot de passe
	/**
	 * Mot de passe actuel
	 */
	private String mdpActuel;
	/**
	 * Nouveau mot de passe
	 */
	private String mdpNouveau;
	/**
	 * Confirmation du mot de passe actuel
	 */
	private String mdpNouveauConfirmation;

	/**
	 * Bean constructor.
	 */
	public EtablissementController() {
		super();
	}

	/* ***************************************************************
	 * Actions**************************************************************
	 */

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + hashCode();
	}

	/**
	 * @see org.esupportail.pstage.web.controllers.AbstractDomainAwareBean#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		loadContactsServices();
	}

	public String recharge(){
		return "rechercheEtablissementStage";
	}

	public void avantValidation(){
		this.formStructure = getStructureDomainService().getStructureFromId(this.currentStruct.getIdStructure());
	}
	/**
	 * Validation de la structure
	 */
	public void validerStructure(){

		getSessionController().setValidationStructureCurrentPage("_validStructureEtape2");

		if (getStructureDomainService().updateStructureValidation(this.formStructure.getIdStructure(),getSessionController().getCurrentLogin())){
			this.currentStruct.setEstValidee(1);
			if (this.rechercheController.isToVerificationStructures())
				this.rechercheController.getListeResultatsRechercheStructure().remove(this.currentStruct);
			addInfoMessage(null, "STRUCTURE.MODERATION.CONFIRMATION");
		} else {
			addErrorMessage(null, "STRUCTURE.MODERATION.ERREUR");
		}
	}

	/**
	 * Dévalidation de la structure
	 */
	public void devaliderStructure(){
		getSessionController().setValidationStructureCurrentPage("_validStructureEtape2");

		if(getStructureDomainService().updateStructureStopValidation(this.formStructure.getIdStructure(),getSessionController().getCurrentLogin())){
			this.currentStruct.setEstValidee(2);
			addInfoMessage(null, "STRUCTURE.MODERATION.DEVALIDATION.CONFIRMATION");
		} else {
			addErrorMessage(null, "STRUCTURE.MODERATION.ERREUR");
		}
	}

	/**
	 * re-chargement de la liste des contacts
	 */
	public void reloadContacts() {
		if (getSessionController().getCurrentManageStructure() != null
				&& this.idServiceSel > 0) {
			this.listeContacts = getStructureDomainService()
					.getContactsFromIdService(
							this.idServiceSel,
							getSessionController()
							.getCurrentIdsCentresGestion(),
							getSessionController().getCodeUniversite());
			if (this.listeContacts != null && !this.listeContacts.isEmpty()) {
				Collections.sort(this.listeContacts,
						new Comparator<ContactDTO>() {
					/**
					 * @see java.util.Comparator#compare(java.lang.Object,
					 *      java.lang.Object)
					 */
					@Override
					public int compare(ContactDTO c1, ContactDTO c2) {
						return c1.getNom().compareTo(c2.getNom());
					}
				});
				// Recup centre si en session
				for (ContactDTO c : this.listeContacts) {
					CentreGestionDTO cgTmp = new CentreGestionDTO();
					cgTmp.setIdCentreGestion(c.getIdCentreGestion());
					if (getSessionController().getCurrentCentresGestion() != null
							&& !getSessionController()
							.getCurrentCentresGestion().isEmpty()
							&& ((ArrayList<CentreGestionDTO>) getSessionController()
									.getCurrentCentresGestion())
									.contains(cgTmp)) {
						c.setCentreGestion(getSessionController()
								.getCurrentCentresGestion().get(
										getSessionController()
										.getCurrentCentresGestion()
										.indexOf(cgTmp)));
					} else {
						CentreGestionDTO cgEntr = getCentreGestionDomainService()
								.getCentreEntreprise();
						if (cgEntr != null
								&& c.getIdCentreGestion() == cgEntr
								.getIdCentreGestion()) {
							c.setCentreGestion(cgEntr);
						}
					}
				}
			}
			this.contactSel = null;
			this.idContactSel = 0;
		}
	}

	/**
	 * re-chargement de la liste des services
	 */
	public void reloadServices() {
		if (getSessionController().getCurrentManageStructure() != null) {
			this.listeServices = getStructureDomainService().getServicesFromIdStructure(getSessionController().getCurrentManageStructure().getIdStructure());
			if (this.listeServices != null) {
				Collections.sort(this.listeServices,
						new Comparator<ServiceDTO>() {
					/**
					 * @see java.util.Comparator#compare(java.lang.Object,
					 *      java.lang.Object)
					 */
					@Override
					public int compare(ServiceDTO s1, ServiceDTO s2) {
						return s1.getNom().compareTo(s2.getNom());
					}
				});
			}
		}
	}

	/**
	 * chargement de la liste des contacts et services
	 */
	public void loadContactsServices() {
		if (getSessionController().getCurrentManageStructure() != null) {
			reloadServices();
			if (this.listeServices != null && !this.listeServices.isEmpty()) {
				// selection du 1er service par defaut
				this.serviceSel = this.listeServices.get(0);
				this.idServiceSel = this.serviceSel.getIdService();
				reloadContacts();
			} else {
				this.serviceSel = null;
				this.idServiceSel = 0;
			}
		}
	}

	/**
	 * @return true if the current user is allowed to view the page.
	 */
	public boolean isPageAuthorized() {
		return true;
	}

	/**
	 * @return a String
	 */
	public String goToFicheSignaletique() {
		String ret = "ficheSignaletique";
		getSessionController().setFicheSignaletiqueCurrentPage("_modifFicheSignaletiqueEtape1");
		return ret;
	}

	/**
	 * @return a String
	 */
	public void goToModifierFicheSignaletique() {
		//		String ret = "_modifFicheSignaletiqueEtape2";
		getSessionController().setFicheSignaletiqueCurrentPage("_modifFicheSignaletiqueEtape2");
		if (getSessionController().getCurrentManageStructure() != null) {
			this.formStructure = getSessionController().getCurrentManageStructure();
			goToModificationEtablissement();
		}
		//		return ret;
	}

	/**
	 * Modification de la fiche signaletique
	 * 
	 * @return String
	 */
	public void modifierFicheSignaletique() {
		//		String ret = null;
		String tmp = modifierEtablissement();
		if (tmp != null) {
			//			ret = "_modifFicheSignaletiqueEtape1";
			getSessionController().setFicheSignaletiqueCurrentPage("_modifFicheSignaletiqueEtape1");
			getSessionController().setCurrentManageStructure(this.formStructure);
			getSessionController().setMenuGestionEtab(true);
			this.formStructure = null;
		}
		//		return ret;
	}

	/**
	 * Bouton annuler de la fiche signal�tique
	 * 
	 * @return String
	 */
	public String annulerModifierFicheSignaletique() {
		//		String ret = "_modifFicheSignaletiqueEtape1";
		getSessionController().setFicheSignaletiqueCurrentPage("_modifFicheSignaletiqueEtape1");
		this.formStructure = null;
		return "ficheSignaletique";
	}

	/* *********************************************
	 * Ajout d'un établissement
	 * ********************************************/

	/**
	 * @return a String
	 */
	public String goToCreationEtablissement() {
		this.formStructure = new StructureDTO();
		this.formStructureTmpPays = getBeanUtils().getFrance();
		this.formStructureTmpTypeStructure = null;
		this.formStructureTmpStatutJuridique = null;
		this.formStructureTmpNafN5 = new NafN5DTO();
		this.formStructureTmpCodePostal = null;
		this.formStructureTmpCommuneDTO = new CommuneDTO();
		this.statutsJuridiquesListening = null;
		return "creationEtablissement";
	}

	/**
	 * Ajout d'un établissement
	 * 
	 * @return a String
	 */
	public String ajouterEtablissement() {
		String retour = null;
		boolean nafActiviteOK = false;
		this.formStructure.setNafN5(this.formStructureTmpNafN5);
		if ((this.formStructure.getNafN5() != null
				&& this.formStructure.getNafN5().getCode() != null
				&& StringUtils.hasText(this.formStructure.getNafN5().getCode()) && !StringUtils
				.hasText(this.formStructure.getActivitePrincipale()))
				|| ((this.formStructure.getNafN5() == null
				|| (this.formStructure.getNafN5() != null && this.formStructure
				.getNafN5().getCode() == null) || (this.formStructure
						.getNafN5() != null
						&& this.formStructure.getNafN5().getCode() != null && this.formStructure
						.getNafN5().getCode().isEmpty())) && StringUtils
						.hasText(this.formStructure.getActivitePrincipale()))
						|| (this.formStructure.getNafN5() != null
						&& this.formStructure.getNafN5().getCode() != null
						&& StringUtils.hasText(this.formStructure.getNafN5()
								.getCode()) && StringUtils
								.hasText(this.formStructure.getActivitePrincipale()))) {
			nafActiviteOK = true;
		}
		if (nafActiviteOK) {
			this.formStructure.setPays(this.formStructureTmpPays);
			this.formStructure
			.setTypeStructure(this.formStructureTmpTypeStructure);
			this.formStructure
			.setStatutJuridique(this.formStructureTmpStatutJuridique);
			this.formStructure.setCodePostal(this.formStructureTmpCodePostal);
			if (getBeanUtils().isFrance(this.formStructureTmpPays)
					&& getSessionController().isRecupererCommunesDepuisApogee()) {
				this.formStructure
				.setCodeCommune(this.formStructureTmpCommuneDTO
						.getCodeCommune());
				// Récupération de la commune pour en avoir le libellé
				this.formStructureTmpCommuneDTO = getGeographieRepositoryDomain()
						.getCommuneFromDepartementEtCodeCommune(
								this.formStructureTmpCodePostal,
								"" + this.formStructure.getCodeCommune());
				if (this.formStructureTmpCommuneDTO != null) {
					this.formStructure
					.setCommune(this.formStructureTmpCommuneDTO
							.getLibCommune());
				}
			}
			retour = "affichageRechercheEtablissement";
			StructureDTO structureTmp = this.formStructure;
			structureTmp
			.setIdEffectif(this.formStructure.getEffectif().getId());
			structureTmp.setIdPays(this.formStructure.getPays().getId());
			if (this.statutsJuridiquesListening != null
					&& this.formStructure.getStatutJuridique() != null)
				structureTmp.setIdStatutJuridique(this.formStructure
						.getStatutJuridique().getId());
			else
				structureTmp.setIdStatutJuridique(0);
			structureTmp.setIdTypeStructure(this.formStructure
					.getTypeStructure().getId());
			if (this.formStructure.getNafN5() != null)
				structureTmp.setCodeNAF_N5(this.formStructure.getNafN5()
						.getCode());
			else
				structureTmp.setCodeNAF_N5(null);
			structureTmp.setLoginCreation(getSessionController()
					.getCurrentLogin());
			structureTmp.setLoginInfosAJour(getSessionController()
					.getCurrentLogin());

			try {
				structureTmp.setIdStructure(this.getStructureDomainService()
						.addStructure(structureTmp));
				// ajout de la validation si la personne ajoutant n'est pas un etudiant (Pas de estValidee dans la methode add)
				if (getSessionController().getCurrentAuthEtudiant() == null){
					getStructureDomainService().updateStructureValidation(structureTmp.getIdStructure(), getSessionController().getCurrentLogin());
				}
				
				if (logger.isInfoEnabled()) {
					logger.info("Ajout structure : " + structureTmp);
				}
				addInfoMessage("formAffEtab", "STRUCTURE.AJOUT.CONFIRMATION");
				this.rechercheController
				.setResultatRechercheStructure(structureTmp);
				// this.formStructure=null;
				this.formStructureTmpPays = null;
				this.formStructureTmpTypeStructure = null;
				this.formStructureTmpStatutJuridique = null;
				this.formStructureTmpNafN5 = new NafN5DTO();
				this.statutsJuridiquesListening = null;
				this.formStructureTmpCommuneDTO = new CommuneDTO();

				if (getSessionController()
						.isMailingListEntrMailAvertissementAjoutEtab()
						&& StringUtils.hasText(getSessionController()
								.getMailingListEntr())) {
					// Envoi mail sur la mailing list entreprise
					String infoPersonne = "";
					if (getSessionController().isAdminPageAuthorized()
							&& getSessionController()
							.getCurrentAuthAdminStructure() != null) {
						infoPersonne += getSessionController()
								.getCurrentAuthAdminStructure().getNom()
								+ " "
								+ getSessionController()
								.getCurrentAuthAdminStructure()
								.getPrenom()
								+ " ("
								+ getSessionController().getCurrentLogin()
								+ ")";
					} else if (getSessionController().isPageAuthorized()
							&& getSessionController().getCurrentAuthContact() != null) {
						infoPersonne += getSessionController()
								.getCurrentAuthContact().getNom()
								+ " "
								+ getSessionController()
								.getCurrentAuthContact().getPrenom()
								+ " ("
								+ getSessionController().getCurrentLogin()
								+ ")";
					} else {
						infoPersonne += getSessionController()
								.getCurrentLogin();
					}
					getSmtpService().send(
							getSessionController().getMailingListEntrIA(),
							getString("MAIL.ADMIN.ETAB.SUJETAJOUT",
									getSessionController()
									.getApplicationNameEntreprise(),
									this.formStructure.printAdresse(),
									infoPersonne),
									getString("MAIL.ADMIN.ETAB.MESSAGEAJOUT",
											getSessionController()
											.getApplicationNameEntreprise(),
											this.formStructure.printAdresse(),
											infoPersonne), "");
				}
			} catch (DataAddException ae) {
				logger.error("DataAddException", ae.fillInStackTrace());
				addErrorMessage("formAjoutEtab", "STRUCTURE.ERREURAJOUT");
				retour = null;
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException",
						we.fillInStackTrace());
				addErrorMessage("formAjoutEtab", "STRUCTURE.ERREURAJOUT");
				retour = null;
			} catch (StructureNumSiretException se) {
				if (logger.isInfoEnabled()) {
					logger.info("Structure déjà existante pour ce numéro siret "
							+ structureTmp);
				}
				addErrorMessage("formAjoutEtab", "STRUCTURE.DEJA_EXISTANTE");
				retour = null;
			} catch (UnvalidNumSiretException ue) {
				// Impossible
				if (logger.isInfoEnabled()) {
					logger.info("Numéro siret invalide pour " + structureTmp);
				}
				addErrorMessage("formAjoutEtab",
						"STRUCTURE.NUM_SIRET.VALIDATION");
				retour = null;
			}
		} else {
			addErrorMessage("formAjoutEtab",
					"STRUCTURE.ERREURAJOUT.NAF");
		}
		return retour;
	}

	/**
	 * @param event
	 */
	public void valueCodeNafChanged(ValueChangeEvent event) {
		String s = (String) event.getNewValue();
		NafN5DTO tmp = getNomenclatureDomainService().getNafN5FromCode(s);
		this.formStructureTmpNafN5 = tmp == null ? new NafN5DTO() : tmp;
	}

	/**
	 * Liste dynamique mise à jour en fonction du type de structure
	 * 
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getStatutsJuridiquesListening() {
		return this.statutsJuridiquesListening;
	}

	/**
	 * Mise � jour de la liste Statut juridique en fonction de la liste Type de
	 * Structure
	 * 
	 * @param event
	 */
	public void valueTypeStructureChanged(ValueChangeEvent event) {
		if (event.getNewValue() instanceof TypeStructureDTO) {
			TypeStructureDTO t = (TypeStructureDTO) event.getNewValue();
			this.statutsJuridiquesListening = getStatutsJuridiquesFromIdTypeStructure(t
					.getId());
		} else {
			this.statutsJuridiquesListening = null;
		}
	}

	/**
	 * @param id
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getStatutsJuridiquesFromIdTypeStructure(int id) {
		List<SelectItem> ls = null;
		List<StatutJuridiqueDTO> l = getNomenclatureDomainService()
				.getStatutsJuridiquesFromIdTypeStructure(id);
		if (l != null && !l.isEmpty()) {
			ls = new ArrayList<SelectItem>();
			for (StatutJuridiqueDTO o : l) {
				ls.add(new SelectItem(o, o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * Formulaire établissement
	 * 
	 * @param event
	 */
	public void valueCodePostalChanged(ValueChangeEvent event) {
		String s = (String) event.getNewValue();
		List<SelectItem> lTmp = majCommunes(s);
		if (lTmp != null && !lTmp.isEmpty()) {
			this.communesListening = lTmp;
		} else {
			this.communesListening = new ArrayList<SelectItem>();
			addErrorMessage("formModifEtab:dynaCodePostal",
					"STRUCTURE.CODE_POSTAL.VALIDATION");
		}
	}

	/**
	 * Formulaire service
	 * 
	 * @param event
	 */
	public void formServiceValueCodePostalChanged(ValueChangeEvent event) {
		String s = (String) event.getNewValue();
		if (getSessionController().isRecupererCommunesDepuisApogee()) {
			List<SelectItem> lTmp = majCommunes(s);
			if (lTmp != null && !lTmp.isEmpty()) {
				this.formServiceCommunesListening = lTmp;
			} else {
				this.formServiceCommunesListening = new ArrayList<SelectItem>();
				addErrorMessage("formModifService:dynaCodePostal",
						"STRUCTURE.CODE_POSTAL.VALIDATION");
			}
		}
	}

	/**
	 * @param codePostal
	 * @return List<SelectItem>
	 */
	public List<SelectItem> majCommunes(String codePostal) {
		List<SelectItem> l = null;
		if (codePostal.length() == 5) {
			List<CommuneDTO> ls = getGeographieRepositoryDomain()
					.getCommuneFromDepartement(codePostal);
			if (ls != null) {
				l = new ArrayList<SelectItem>();
				for (CommuneDTO c : ls) {
					l.add(new SelectItem(c.getCodeCommune(), c.getLibCommune()));
				}
			}
		}
		return l;
	}

	/* *********************************************
	 * Modification d'un établissement
	 * ********************************************
	 */

	/**
	 * @return a String
	 */
	public String goToModificationEtablissement() {
		if (this.formStructure != null) {
			this.formStructure = (StructureDTO) this.formStructure.clone();
			this.formStructureTmpPays = this.formStructure.getPays();
			this.formStructureTmpTypeStructure = this.formStructure
					.getTypeStructure();
			this.formStructureTmpStatutJuridique = this.formStructure
					.getStatutJuridique();
			this.formStructureTmpNafN5 = this.formStructure.getNafN5() == null ? new NafN5DTO()
			: this.formStructure.getNafN5();
			this.formStructureTmpCodePostal = this.formStructure
					.getCodePostal();
			if (getBeanUtils().isFrance(this.formStructureTmpPays)
					&& getSessionController().isRecupererCommunesDepuisApogee()) {
				List<SelectItem> lTmp = majCommunes(""
						+ this.formStructure.getCodePostal());
				if (lTmp != null && !lTmp.isEmpty()) {
					this.communesListening = lTmp;
				} else {
					this.communesListening = new ArrayList<SelectItem>();
				}
				this.formStructureTmpCommuneDTO = getGeographieRepositoryDomain()
						.getCommuneFromDepartementEtCodeCommune(
								this.formStructureTmpCodePostal,
								"" + this.formStructure.getCodeCommune());
				if (this.formStructureTmpCommuneDTO != null) {
					this.formStructure
					.setCommune(this.formStructureTmpCommuneDTO
							.getLibCommune());
					this.formStructure
					.setCodeCommune(this.formStructureTmpCommuneDTO
							.getCodeCommune());
				} else {
					this.formStructureTmpCommuneDTO = new CommuneDTO();
				}
			} else {
				this.formStructureTmpCommuneDTO = new CommuneDTO();
			}
			// Màj de liste des statuts juridiques
			if (this.formStructure.getTypeStructure() != null) {
				this.statutsJuridiquesListening = getStatutsJuridiquesFromIdTypeStructure(this.formStructure
						.getTypeStructure().getId());
			}
		}
		return "modificationEtablissement";
	}

	/**
	 * Modification d'un établissement
	 * 
	 * @return a String
	 */
	public String modifierEtablissement() {
		String retour = null;
		boolean nafActiviteOK = false;

		// Recuperation de la structure telle qu'elle etait avant modification (pour affichage dans le mail)
		StructureDTO structurePreModif = getStructureDomainService().getStructureFromId(this.formStructure.getIdStructure());

		this.formStructure.setNafN5(this.formStructureTmpNafN5);

		if ((this.formStructure.getNafN5() != null
				&& this.formStructure.getNafN5().getCode() != null
				&& StringUtils.hasText(this.formStructure.getNafN5().getCode())
				&& !StringUtils.hasText(this.formStructure.getActivitePrincipale()) )
				|| ((this.formStructure.getNafN5() == null
				|| (this.formStructure.getNafN5() != null && this.formStructure.getNafN5().getCode() == null)
				|| (this.formStructure.getNafN5() != null && this.formStructure.getNafN5().getCode() != null && this.formStructure.getNafN5().getCode().isEmpty()))
				&& StringUtils.hasText(this.formStructure.getActivitePrincipale()) )
				|| (this.formStructure.getNafN5() != null
				&& this.formStructure.getNafN5().getCode() != null
				&& StringUtils.hasText(this.formStructure.getNafN5().getCode())
				&& StringUtils.hasText(this.formStructure.getActivitePrincipale())) ) {
			nafActiviteOK = true;
		}

		if (nafActiviteOK) {
			this.formStructure.setPays(this.formStructureTmpPays);
			this.formStructure
			.setTypeStructure(this.formStructureTmpTypeStructure);
			this.formStructure
			.setStatutJuridique(this.formStructureTmpStatutJuridique);
			this.formStructure.setCodePostal(this.formStructureTmpCodePostal);
			if (getBeanUtils().isFrance(this.formStructureTmpPays)
					&& getSessionController().isRecupererCommunesDepuisApogee()) {
				this.formStructure
				.setCodeCommune(this.formStructureTmpCommuneDTO
						.getCodeCommune());
				// Récupération de la commune pour en avoir le libellé
				this.formStructureTmpCommuneDTO = getGeographieRepositoryDomain()
						.getCommuneFromDepartementEtCodeCommune(
								this.formStructureTmpCodePostal,
								"" + this.formStructure.getCodeCommune());
				if (this.formStructureTmpCommuneDTO != null) {
					this.formStructure
					.setCommune(this.formStructureTmpCommuneDTO
							.getLibCommune());
				}
			}
			retour = "affichageRechercheEtablissement";
			StructureDTO structureTmp = this.formStructure;
			structureTmp.setIdEffectif(this.formStructure.getEffectif().getId());
			structureTmp.setIdPays(this.formStructure.getPays().getId());
			if (this.statutsJuridiquesListening != null
					&& this.formStructure.getStatutJuridique() != null)
				structureTmp.setIdStatutJuridique(this.formStructure.getStatutJuridique().getId());
			else
				structureTmp.setIdStatutJuridique(0);
			structureTmp.setIdTypeStructure(this.formStructure.getTypeStructure().getId());
			if (this.formStructure.getNafN5() != null)
				structureTmp.setCodeNAF_N5(this.formStructure.getNafN5().getCode());
			else
				structureTmp.setCodeNAF_N5(null);
			structureTmp.setDateModif(new Date());
			structureTmp.setLoginModif(getSessionController().getCurrentLogin());
			structureTmp.setLoginInfosAJour(getSessionController().getCurrentLogin());

			if (getSessionController().getCurrentAuthEtudiant() != null
				&& (structureTmp.getEstValidee() == 1 || structureTmp.getEstValidee() == 2)){
				getStructureDomainService().updateStructureStopValidation(structureTmp.getIdStructure(), getSessionController().getCurrentLogin());
				this.formStructure.setEstValidee(0);
			}
			try {
				if (this.getStructureDomainService().updateStructure(structureTmp)) {
					if (logger.isInfoEnabled()) {
						logger.info("Modif structure : " + structureTmp);
					}
					addInfoMessage("formAffEtab", "STRUCTURE.MODIF.CONFIRMATION");

					// Maj recherche
					if (this.rechercheController.getListeResultatsRechercheStructure() != null
							&& !this.rechercheController.getListeResultatsRechercheStructure().isEmpty()) {
						this.rechercheController
						.setResultatRechercheStructure(structureTmp);
						Iterator<StructureDTO> its = this.rechercheController.getListeResultatsRechercheStructure().iterator();
						while (its.hasNext()) {
							StructureDTO s = its.next();
							if (s.equals(structureTmp)) {
								its.remove();
								break;
							}
						}
						this.rechercheController.getListeResultatsRechercheStructure().add(
								structureTmp);
						this.rechercheController.reloadRechercheStructurePaginator();
					}
					// this.formStructure=null;
					this.formStructureTmpPays = null;
					this.formStructureTmpTypeStructure = null;
					this.formStructureTmpStatutJuridique = null;
					this.formStructureTmpNafN5 = new NafN5DTO();
					this.statutsJuridiquesListening = null;
					this.formStructureTmpCommuneDTO = new CommuneDTO();
					if (getSessionController().isMailingListEntrMailAvertissementModifEtab()
							&& StringUtils.hasText(getSessionController().getMailingListEntr())) {
						// Envoi mail sur la mailing list entreprise
						String infoPersonne = "";
						if (getSessionController().isAdminPageAuthorized()
								&& getSessionController().getCurrentAuthAdminStructure() != null) {
							infoPersonne += getSessionController().getCurrentAuthAdminStructure().getNom()
									+ " "
									+ getSessionController().getCurrentAuthAdminStructure().getPrenom()
									+ " ("
									+ getSessionController().getCurrentLogin()
									+ ")";
						} else if (getSessionController().isPageAuthorized()
								&& getSessionController().getCurrentAuthContact() != null) {
							infoPersonne += getSessionController().getCurrentAuthContact().getNom()
									+ " "
									+ getSessionController().getCurrentAuthContact().getPrenom()
									+ " ("
									+ getSessionController().getCurrentLogin()
									+ ")";
						} else {
							infoPersonne += getSessionController().getCurrentLogin();
						}
						getSmtpService().send(getSessionController().getMailingListEntrIA(),
								getString("MAIL.ADMIN.ETAB.SUJETMODIF",
										getSessionController().getApplicationNameEntreprise(),
										this.formStructure.printAdresse(),
										infoPersonne),
										getString("MAIL.ADMIN.ETAB.MESSAGEMODIF",
												getSessionController().getApplicationNameEntreprise(),
												this.formStructure.getIdStructure(),
												infoPersonne,
												structurePreModif.toString(),
												this.formStructure.toString()),
								"");
					}
				} else {
					addErrorMessage("formModifEtab", "STRUCTURE.ERREURMODIF");
				}
			} catch (DataUpdateException ue) {
				logger.error("DataUpdateException", ue.fillInStackTrace());
				addErrorMessage("formModifEtab", "STRUCTURE.ERREURMODIF");
				retour = null;
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException",
						we.fillInStackTrace());
				addErrorMessage("formModifEtab", "STRUCTURE.ERREURMODIF");
				retour = null;
			} catch (StructureNumSiretException se) {
				if (logger.isInfoEnabled()) {
					logger.info("Structure déjà existante pour ce numéro siret "
							+ structureTmp);
				}
				addErrorMessage("formModifEtab", "STRUCTURE.DEJA_EXISTANTE");
				retour = null;
			} catch (UnvalidNumSiretException ue) {
				// Impossible
				if (logger.isInfoEnabled()) {
					logger.info("Numéro siret invalide pour " + structureTmp);
				}
				addErrorMessage("formModifEtab",
						"STRUCTURE.NUM_SIRET.VALIDATION");
				retour = null;
			}
		}
		return retour;
	}

	/**
	 * Suppression d'un établissement
	 * 
	 * @return a String
	 */
	public void supprimerEtablissement() {
		if (this.formStructure != null
				&& this.formStructure.getIdStructure() > 0) {
			try {
				Boolean delete = getStructureDomainService().deleteStructure(this.formStructure.getIdStructure(),this.getCurrentUser().getId()); 
				if (delete) {
					addInfoMessage(null, "STRUCTURE.SUPPRESSION.CONFIRMATION",
							this.formStructure.getRaisonSociale());
					if (this.rechercheController.getListeResultatsRechercheStructure() != null
							&& !this.rechercheController.getListeResultatsRechercheStructure().isEmpty()) {
					
						this.rechercheController.getListeResultatsRechercheStructure().remove(this.formStructure);
						this.rechercheController.setResultatRechercheStructure(null);
						
					} else {
						this.rechercheController
						.setListeResultatsRechercheStructure(null);
						this.rechercheController.setResultatRechercheStructure(null);
					}
					
				} else {
					addErrorMessage(null, "STRUCTURE.SUPPRESSION.ERREUR",
							this.formStructure.getRaisonSociale());
				}
				
				getSessionController().setCurrentManageStructure(null);
				getSessionController().setMenuGestionEtab(false);
				this.listeServices = null;
				this.serviceSel = null;
				this.idServiceSel = 0;
				this.idContactSel = 0;
				this.contactSel = null;
				this.listeContacts = null;
				if (getSessionController()
						.isMailingListEntrMailAvertissementSupprEtab()
						&& StringUtils.hasText(getSessionController()
								.getMailingListEntr())) {
					// Envoi mail sur la mailing list entreprise
					String infoPersonne = "";
					if (getSessionController().isAdminPageAuthorized()
							&& getSessionController()
							.getCurrentAuthAdminStructure() != null) {
						infoPersonne += getSessionController()
								.getCurrentAuthAdminStructure().getNom()
								+ " "
								+ getSessionController()
								.getCurrentAuthAdminStructure()
								.getPrenom()
								+ " ("
								+ getSessionController().getCurrentLogin()
								+ ")";
					} else if (getSessionController().isPageAuthorized()
							&& getSessionController().getCurrentAuthContact() != null) {
						infoPersonne += getSessionController()
								.getCurrentAuthContact().getNom()
								+ " "
								+ getSessionController()
								.getCurrentAuthContact().getPrenom()
								+ " ("
								+ getSessionController().getCurrentLogin()
								+ ")";
					} else {
						infoPersonne += getSessionController()
								.getCurrentLogin();
					}
					getSmtpService().send(
							getSessionController().getMailingListEntrIA(),
							getString("MAIL.ADMIN.ETAB.SUJETSUPPR",
									getSessionController()
									.getApplicationNameEntreprise(),
									this.formStructure.printAdresse(),
									infoPersonne),
									getString("MAIL.ADMIN.ETAB.MESSAGESUPPR",
											getSessionController()
											.getApplicationNameEntreprise(),
											this.formStructure.printAdresse(),
											infoPersonne), "");
				}
			} catch (StructureDeleteException e) {
				logger.error("DataDeleteException", e.fillInStackTrace());
				addErrorMessage(null, "STRUCTURE.SUPPRESSION.ERREUR",
						this.formStructure.getRaisonSociale());
				addErrorMessage(null, "STRUCTURE.SUPPRESSION.ERREURAVANCEE",
						e.getNbOffres(), e.getNbConventions(),
						e.isAccordExistant() ? getString("FORM.OUI")
								: getString("FORM.NON"),
								e.getNbComptesContact());
			} catch (DataDeleteException e) {
				logger.error("DataDeleteException", e.fillInStackTrace());
				addErrorMessage(null, "STRUCTURE.SUPPRESSION.ERREUR",
						this.formStructure.getRaisonSociale());
			} catch (WebServiceDataBaseException e) {
				logger.error("WebServiceDataBaseException",
						e.fillInStackTrace());
				addErrorMessage(null, "STRUCTURE.SUPPRESSION.ERREUR",
						this.formStructure.getRaisonSociale());
			}
		}
		this.formStructure = null;
		this.getSessionController().setSuppressionStructureCurrentPage("_supprStructureEtape2Confirmation");
//		return "_supprStructureEtape2Confirmation";
	}

	/**
	 * Gestion des contacts et services (entreprise)
	 * 
	 * @return String
	 */
	public String goToGestionContacts() {
		return "gestionContacts";
	}

	/**
	 * Gestion des contacts et services (stage)
	 * 
	 * @return String
	 */
	public String goToContactsEtablissement() {
		loadContactsServices();
		return "contactsEtablissement";
	}

	/**
	 * Gestion Cvtheque (entreprise)
	 * 
	 * @return String
	 */
	public String goToGestionCvtheque() {
		TicketStructureDTO ticketStructure = new TicketStructureDTO();
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			String forwardUrl;
			String ticketStage = null;
			int idStructure = getSessionController()
					.getCurrentManageStructure().getIdStructure();
			// generation du ticket aleatoire longueur nbre aleatoire1 + nombre
			// aleatoire1 + idstructure + longueur nbre aleatoire2 + nombre
			// aleatoire2
			// generation longueur aleatoire1
			GenTicketStage genTicketStage1 = new GenTicketStage(1);
			String longueurAleatoire1 = genTicketStage1.generate();
			// generation nombre aleatoire � partir de la longueur aleatoire
			GenTicketStage genTicketStage2 = new GenTicketStage(
					Integer.parseInt(longueurAleatoire1));
			String nombreAleatoire1 = genTicketStage2.generate();
			// generation longueur aleatoire2
			GenTicketStage genTicketStage3 = new GenTicketStage(1);
			String longueurAleatoire2 = genTicketStage3.generate();
			// generation nombre aleatoire � partir de la longueur aleatoire
			GenTicketStage genTicketStage4 = new GenTicketStage(
					Integer.parseInt(longueurAleatoire2));
			String nombreAleatoire2 = genTicketStage4.generate();
			ticketStage = longueurAleatoire1 + nombreAleatoire1
					+ Integer.toString(idStructure) + nombreAleatoire2
					+ longueurAleatoire2;
			forwardUrl = getSessionController().getCvthequeUrl()
					+ "?args=ticket%3d" + ticketStage;

			// creation du ticketStructure dans la table TicketStructure

			ticketStructure.setTicket(ticketStage);
			ticketStructure.setIdStructure(idStructure);
			getStructureDomainService().addTicketStructure(ticketStructure);
			if (logger.isInfoEnabled()) {
				logger.info(" ticketStruture creation : "
						+ ticketStructure.getTicket() + " pour id Structure : "
						+ ticketStructure.getIdStructure());
			}

			// redirection vers cvtheque
			externalContext.redirect(forwardUrl);
			facesContext.responseComplete();
		} catch (DataAddException e) {
			logger.error("DataAddException", e.fillInStackTrace());
			addErrorMessage("formMenu:cvtheque", "TICKETSTRUCTURE.AJOUT.ERREUR");
		} catch (WebServiceDataBaseException e) {
			logger.error("WebServiceDataBaseException", e.fillInStackTrace());
			addErrorMessage("formMenu:cvtheque", "TICKETSTRUCTURE.AJOUT.ERREUR");
		} catch (IOException e) {
			logger.error("probleme lors de la redirection Cvtheque, exception : "
					+ e);
			addErrorMessage("formMenu:cvtheque",
					"TICKETSTRUCTURE.REDIRECT.ERREUR");
		}
		return null;
	}

	/**
	 * @return String
	 */
	public String ajoutService() {
		this.formService = new ServiceDTO();
		if (getSessionController().getCurrentManageStructure() != null) {
			this.formService.setPays(getSessionController()
					.getCurrentManageStructure().getPays());
			this.formServiceTmpPays = getSessionController()
					.getCurrentManageStructure().getPays();
		}
		this.formServiceTmpCodePostal = null;
		this.formServiceTmpCommuneDTO = new CommuneDTO();
		return null;
	}

	/**
	 * Ajout d'un service
	 * 
	 * @return String
	 */
	public void ajouterService() {
		try {
			if (this.memeAdresseStructure) {
				this.formService = BeanUtils.copieAdresseStructureVersService(
						getSessionController().getCurrentManageStructure(),
						this.formService);
			} else {
				this.formService.setPays(this.formServiceTmpPays);
				if (getBeanUtils().isFrance(this.formServiceTmpPays)
						&& getSessionController()
						.isRecupererCommunesDepuisApogee()) {
					this.formService
					.setCodePostal(this.formServiceTmpCodePostal);
					this.formService
					.setCodeCommune(this.formServiceTmpCommuneDTO
							.getCodeCommune());
					// Récupération de la commune pour en avoir le libellé
					this.formServiceTmpCommuneDTO = getGeographieRepositoryDomain()
							.getCommuneFromDepartementEtCodeCommune(
									this.formServiceTmpCodePostal,
									"" + this.formService.getCodeCommune());
					if (this.formServiceTmpCommuneDTO != null) {
						this.formService
						.setCommune(this.formServiceTmpCommuneDTO
								.getLibCommune());
					}
				}
			}
			if (this.formService.getPays() != null) {
				this.formService.setIdPays(this.formService.getPays().getId());
			}
			this.formService.setLoginCreation(getSessionController()
					.getCurrentLogin());
			this.formService.setLoginInfosAJour(getSessionController()
					.getCurrentLogin());
			this.formService.setIdStructure(getSessionController()
					.getCurrentManageStructure().getIdStructure());
			int i = getStructureDomainService().addService(this.formService);
			this.formService.setIdService(i);
			if (i > 0) {
				addInfoMessage(null, "SERVICE.AJOUT.CONFIRMATION");
				reloadServices();
				this.idServiceSel = i;
				this.serviceSel = this.formService;
				reloadContacts();
				if (logger.isInfoEnabled()) {
					logger.info(getSessionController().getCurrentLogin()
							+ " ajoute le service : "
							+ this.serviceSel
							+ " à l'établissement : "
							+ getSessionController()
							.getCurrentManageStructure());
				}
				this.formService = null;
				this.formServiceTmpCodePostal = null;
				this.formServiceTmpCommuneDTO = new CommuneDTO();
				this.formServiceTmpPays = getBeanUtils().getFrance();
			} else {
				addErrorMessage(null, "SERVICE.AJOUT.ERREUR");
			}
		} catch (DataAddException e) {
			logger.error("DataAddException", e.fillInStackTrace());
			addErrorMessage(null, "SERVICE.AJOUT.ERREUR");
		} catch (WebServiceDataBaseException e) {
			logger.error("DataUpdateException", e.fillInStackTrace());
			addErrorMessage(null, "SERVICE.AJOUT.ERREUR");
		}
		getSessionController().setAjoutServiceCurrentPage("_ajoutServiceEtape2Confirmation");
	}

	/**
	 * @return a String
	 */
	public void modifService() {
		if (this.formService != null) {
			this.formServiceTmpPays = this.formService.getPays();
			this.formServiceTmpCodePostal = this.formService.getCodePostal();
			if (getBeanUtils().isFrance(this.formServiceTmpPays)
					&& getSessionController().isRecupererCommunesDepuisApogee()) {
				List<SelectItem> lTmp = majCommunes(""+ this.formService.getCodePostal());
				if (lTmp != null && !lTmp.isEmpty()) {
					this.formServiceCommunesListening = lTmp;
				} else {
					this.formServiceCommunesListening = new ArrayList<SelectItem>();
				}
				this.formServiceTmpCommuneDTO = getGeographieRepositoryDomain().getCommuneFromDepartementEtCodeCommune(
						this.formServiceTmpCodePostal,this.formService.getCodeCommune());
				if (this.formServiceTmpCommuneDTO != null) {
					this.formService.setCommune(this.formServiceTmpCommuneDTO.getLibCommune());
					this.formService.setCodeCommune(this.formServiceTmpCommuneDTO.getCodeCommune());
				} else {
					this.formServiceTmpCommuneDTO = new CommuneDTO();
				}
			}
		}
		getSessionController().setModifServiceCurrentPage("_modifServiceEtape1");
		// return "_modifServiceEtape1";
	}

	/**
	 * Modification d'un service
	 * 
	 * @return String
	 */
	public void modifierService() {
		// String ret="_modifServiceEtape2Confirmation";
		try {
			if (this.memeAdresseStructure) {
				this.formService = BeanUtils.copieAdresseStructureVersService(
						getSessionController().getCurrentManageStructure(),
						this.formService);
			} else {
				this.formService.setPays(this.formServiceTmpPays);
				if (getBeanUtils().isFrance(this.formServiceTmpPays)
						&& getSessionController()
						.isRecupererCommunesDepuisApogee()) {
					this.formService
					.setCodePostal(this.formServiceTmpCodePostal);
					this.formService
					.setCodeCommune(this.formServiceTmpCommuneDTO
							.getCodeCommune());
					// Récupération de la commune pour en avoir le libellé
					this.formServiceTmpCommuneDTO = getGeographieRepositoryDomain()
							.getCommuneFromDepartementEtCodeCommune(
									this.formServiceTmpCodePostal,
									"" + this.formService.getCodeCommune());
					if (this.formServiceTmpCommuneDTO != null) {
						this.formService
						.setCommune(this.formServiceTmpCommuneDTO
								.getLibCommune());
					}
				}
			}
			this.formService.setIdPays(this.formService.getPays().getId());
			this.formService.setDateModif(new Date());
			this.formService.setLoginModif(getSessionController()
					.getCurrentLogin());
			this.formService.setLoginInfosAJour(getSessionController()
					.getCurrentLogin());
			this.formService.setIdStructure(getSessionController()
					.getCurrentManageStructure().getIdStructure());
			if (getStructureDomainService().updateService(this.formService)) {
				addInfoMessage(null, "SERVICE.MODIF.CONFIRMATION");
				reloadServices();
				if (logger.isInfoEnabled()) {
					logger.info(getSessionController().getCurrentLogin()
							+ " modifie le service : "
							+ this.serviceSel
							+ " de l'établissement : "
							+ getSessionController()
							.getCurrentManageStructure());
				}
				this.formService = null;
				this.formServiceTmpCodePostal = null;
				this.formServiceTmpCommuneDTO = new CommuneDTO();
				this.formServiceTmpPays = getBeanUtils().getFrance();
			} else {
				addErrorMessage(null, "SERVICE.MODIF.ERREUR");
			}
		} catch (DataUpdateException e) {
			logger.error("DataUpdateException", e.fillInStackTrace());
			addErrorMessage(null, "SERVICE.MODIF.ERREUR");
		} catch (WebServiceDataBaseException e) {
			logger.error("DataUpdateException", e.fillInStackTrace());
			addErrorMessage(null, "SERVICE.MODIF.ERREUR");
		}
		// return ret;
		getSessionController().setModifServiceCurrentPage("_modifServiceEtape2Confirmation");
	}

	/**
	 * Suppression d'un service
	 */
	public void supprimerService() {
		//		String ret = "_supprServiceEtape2Confirmation";
		try {
			if (getStructureDomainService().deleteService(
					this.formService.getIdService())) {
				addInfoMessage(null, "SERVICE.SUPPR.CONFIRMATION");
				// reloadServices();
				if (this.listeServices != null && !this.listeServices.isEmpty()) {
					this.idServiceSel = this.listeServices.get(0)
							.getIdService();
					this.serviceSel = this.listeServices.get(0);
					Iterator<ServiceDTO> its = this.listeServices.iterator();
					while (its.hasNext()) {
						ServiceDTO sTmp = its.next();
						if (sTmp.getIdService() == this.formService
								.getIdService()) {
							its.remove();
							break;
						}
					}
					reloadContacts();
					if (logger.isInfoEnabled()) {
						logger.info(getSessionController().getCurrentLogin()
								+ " supprime le service : "
								+ this.serviceSel
								+ " de l'établissement : "
								+ getSessionController()
								.getCurrentManageStructure());
					}
					this.formContact = null;
					this.formService = null;
				}
			} else {
				addErrorMessage(null, "SERVICE.SUPPR.ERREUR");
			}
		} catch (DataDeleteException e) {
			logger.error("DataDeleteException", e.fillInStackTrace());
			getSessionController().setSuppressionServiceCurrentPage("_supprServiceEtape2Confirmation");
			System.out.println("e.get message : " + e.getMessage());
			if (e.getMessage().contains("constraint")){
				addErrorMessage(null, "SERVICE.SUPPR.ERREUR.CONTACT");
			} else {
				addErrorMessage(null, "SERVICE.SUPPR.ERREUR");
			}
		} catch (WebServiceDataBaseException e) {
			logger.error("WebServiceDataBaseException", e.fillInStackTrace());
			addErrorMessage(null, "SERVICE.SUPPR.ERREUR");
		} catch (ServiceDeleteException e) {
			logger.error("ServiceDeleteException", e.fillInStackTrace());
			addErrorMessage(null, "SERVICE.SUPPR.ERREUR");
		}
		getSessionController().setSuppressionServiceCurrentPage("_supprServiceEtape2Confirmation");
	}

	/**
	 * Mise à jour de la liste des contacts en fonction du service sélectionné
	 * 
	 * @param event
	 */
	public void valueIdServiceChanged(ValueChangeEvent event) {
		this.idServiceSel = (Integer) event.getNewValue();
		this.serviceSel = getStructureDomainService().getServiceFromId(
				idServiceSel);
		reloadContacts();
		if (this.listeContacts != null && !this.listeContacts.isEmpty()) {
			this.contactSel = null;
			this.idContactSel = 0;
		}
	}

	/**
	 * Mise à jour de la liste des contacts en fonction du service sélectionné
	 * 
	 * @param event
	 */
	public void valueIdContactChanged(ValueChangeEvent event) {
		this.idContactSel = (Integer) event.getNewValue();
		this.contactSel = getStructureDomainService().getContactFromId(
				idContactSel);
	}

	/**
	 * @return String
	 */
	public String ajoutContact() {
		this.formContact = new ContactDTO();
		return null;
	}

	/**
	 * Ajout d'un contact
	 * 
	 * @return String
	 */
	public void ajouterContact() {
		//		String ret = "_ajoutContactEtape2Confirmation";
		if (this.idServiceSel > 0 && this.formContact != null
				&& StringUtils.hasText(this.formContact.getNom())
				&& this.formContact.getCivilite() != null) {
			if (StringUtils.hasText(this.formContact.getTel())
					|| StringUtils.hasText(this.formContact.getFax())
					|| StringUtils.hasText(this.formContact.getMail())) {
				try {
					this.formContact.setLoginCreation(getSessionController()
							.getCurrentLogin());
					this.formContact.setLoginInfosAJour(getSessionController()
							.getCurrentLogin());
					this.formContact.setIdCivilite(this.formContact
							.getCivilite().getId());
					this.formContact.setIdService(this.idServiceSel);
					if (this.formContact.getIdCentreGestion() <= 0) {
						if (getSessionController()
								.getCentreGestionRattachement() != null) {
							this.formContact
							.setIdCentreGestion(getSessionController()
									.getCentreGestionRattachement()
									.getIdCentreGestion());
						} else {
							CentreGestionDTO cgEntr = getCentreGestionDomainService()
									.getCentreEntreprise();
							if (cgEntr != null) {
								this.formContact
								.setIdCentreGestion(getCentreGestionDomainService()
										.getCentreEntreprise()
										.getIdCentreGestion());
							} else {
								addErrorMessage(null,
										"CONTACT.GESTION.AJOUT.ERREUR");
								//								return null;
								return;
							}
						}
					}
					int i = getStructureDomainService().addContact(
							this.formContact);
					if (i > 0) {
						this.formContact.setId(i);
						addInfoMessage(null,
								"CONTACT.GESTION.AJOUT.CONFIRMATION");
						reloadContacts();
						// Dernier contact ajouté toujours visible
						if (this.listeContacts != null
								&& !this.listeContacts.isEmpty()) {
							if (this.listeContacts.contains(this.formContact)) {
								Iterator<ContactDTO> ilc = this.listeContacts
										.iterator();
								while (ilc.hasNext()) {
									ContactDTO c = ilc.next();
									if (c.equals(this.formContact)) {
										ilc.remove();
										break;
									}
								}
							}
							// Recup centre si en session
							CentreGestionDTO cgTmp = new CentreGestionDTO();
							cgTmp.setIdCentreGestion(this.formContact
									.getIdCentreGestion());
							if (getSessionController()
									.getCurrentCentresGestion() != null
									&& !getSessionController()
									.getCurrentCentresGestion()
									.isEmpty()
									&& ((ArrayList<CentreGestionDTO>) getSessionController()
											.getCurrentCentresGestion())
											.contains(cgTmp)) {
								this.formContact
								.setCentreGestion(getSessionController()
										.getCurrentCentresGestion()
										.get(getSessionController()
												.getCurrentCentresGestion()
												.indexOf(cgTmp)));
							} else {
								CentreGestionDTO cgEntr = getCentreGestionDomainService()
										.getCentreEntreprise();
								if (cgEntr != null
										&& this.formContact
										.getIdCentreGestion() == cgEntr
										.getIdCentreGestion()) {
									this.formContact.setCentreGestion(cgEntr);
								}
							}

							this.listeContacts.add(this.formContact);
							Collections.sort(this.listeContacts,
									new Comparator<ContactDTO>() {
								/**
								 * @see java.util.Comparator#compare(java.lang.Object,
								 *      java.lang.Object)
								 */
								@Override
								public int compare(ContactDTO c1,
										ContactDTO c2) {
									return c1.getNom().compareTo(
											c2.getNom());
								}
							});
						} else {
							this.listeContacts = new ArrayList<ContactDTO>();
							this.listeContacts.add(this.formContact);
						}
						this.idContactSel = i;
						this.contactSel = this.formContact;
						if (logger.isInfoEnabled()) {
							logger.info(getSessionController()
									.getCurrentLogin()
									+ " ajoute le contact : "
									+ this.formContact
									+ " à l'établissement : "
									+ getSessionController()
									.getCurrentManageStructure());
						}
						this.formContact = null;
					} else {
						addErrorMessage(null, "CONTACT.GESTION.AJOUT.ERREUR");
					}
				} catch (DataAddException e) {
					logger.error("DataAddException", e.fillInStackTrace());
					addErrorMessage(null, "CONTACT.GESTION.AJOUT.ERREUR");
				} catch (WebServiceDataBaseException e) {
					logger.error("WebServiceDataBaseException",
							e.fillInStackTrace());
					addErrorMessage(null, "CONTACT.GESTION.AJOUT.ERREUR");
				} catch (MailAlreadyUsedForStructureException e) {
					logger.info("MailAlreadyUsedForStructureException",
							e.fillInStackTrace());
					addErrorMessage("formAjoutContact:mailC",
							"CONTACT.GESTION.ERREURACCOUNT");
					//					ret = null;
					return;
				}
			} else {
				addErrorMessage("formAjoutContact:msg1o3",
						"CONTACT.GESTION.UNDESTROIS");
				//				ret = null;
				return;
			}
		} else {
			//			ret = null;
			return;
		}
		//		return ret;
		getSessionController().setAjoutContactCurrentPage("_ajoutContactEtape2Confirmation");
	}

	/**
	 * Modification un contact
	 * 
	 * @return String
	 */
	public void modifierContact() {
		//		String ret = "_modifContactEtape2Confirmation";
		this.keysContacts = new HashSet<Integer>();
		if (this.idServiceSel > 0 && this.formContact != null
				&& StringUtils.hasText(this.formContact.getNom())
				&& this.formContact.getCivilite() != null) {
			if (StringUtils.hasText(this.formContact.getTel())
					|| StringUtils.hasText(this.formContact.getFax())
					|| StringUtils.hasText(this.formContact.getMail())) {
				try {
					this.formContact.setDateModif(new Date());
					this.formContact.setLoginModif(getSessionController()
							.getCurrentLogin());
					this.formContact.setLoginInfosAJour(getSessionController()
							.getCurrentLogin());
					this.formContact.setIdCivilite(this.formContact
							.getCivilite().getId());
					this.formContact.setIdService(this.idServiceSel);
					if (this.formContact.getIdCentreGestion() <= 0) {
						if (getSessionController()
								.getCentreGestionRattachement() != null) {
							this.formContact
							.setIdCentreGestion(getSessionController()
									.getCentreGestionRattachement()
									.getIdCentreGestion());
						} else {
							CentreGestionDTO cgEntr = getCentreGestionDomainService()
									.getCentreEntreprise();
							if (cgEntr != null) {
								this.formContact
								.setIdCentreGestion(getCentreGestionDomainService()
										.getCentreEntreprise()
										.getIdCentreGestion());
							} else {
								addErrorMessage(null,
										"CONTACT.GESTION.MODIF.ERREUR");
								return;
							}
						}
					}
					if (getStructureDomainService().updateContact(
							this.formContact)) {
						if (this.listeContacts != null
								&& !this.listeContacts.isEmpty()) {
							if (this.listeContacts.contains(this.formContact)) {
								Iterator<ContactDTO> ilc = this.listeContacts
										.iterator();
								while (ilc.hasNext()) {
									ContactDTO c = ilc.next();
									if (c.equals(this.formContact)) {
										ilc.remove();
										break;
									}
								}
							}
							// Recup centre si en session
							CentreGestionDTO cgTmp = new CentreGestionDTO();
							cgTmp.setIdCentreGestion(this.formContact
									.getIdCentreGestion());
							if (getSessionController()
									.getCurrentCentresGestion() != null
									&& !getSessionController()
									.getCurrentCentresGestion()
									.isEmpty()
									&& ((ArrayList<CentreGestionDTO>) getSessionController()
											.getCurrentCentresGestion())
											.contains(cgTmp)) {
								this.formContact
								.setCentreGestion(getSessionController()
										.getCurrentCentresGestion()
										.get(getSessionController()
												.getCurrentCentresGestion()
												.indexOf(cgTmp)));
							} else {
								CentreGestionDTO cgEntr = getCentreGestionDomainService()
										.getCentreEntreprise();
								if (cgEntr != null
										&& this.formContact
										.getIdCentreGestion() == cgEntr
										.getIdCentreGestion()) {
									this.formContact.setCentreGestion(cgEntr);
								}
							}
							this.listeContacts.add(this.formContact);
							Collections.sort(this.listeContacts,
									new Comparator<ContactDTO>() {
								/**
								 * @see java.util.Comparator#compare(java.lang.Object,
								 *      java.lang.Object)
								 */
								@Override
								public int compare(ContactDTO c1,
										ContactDTO c2) {
									return c1.getNom().compareTo(
											c2.getNom());
								}
							});
						}
						addInfoMessage(null,
								"CONTACT.GESTION.MODIF.CONFIRMATION");
						if (logger.isInfoEnabled()) {
							logger.info(getSessionController()
									.getCurrentLogin()
									+ " modifie le contact : "
									+ this.formContact
									+ " de l'établissement : "
									+ getSessionController()
									.getCurrentManageStructure());
						}
						this.formContact = null;
					} else {
						addErrorMessage(null, "CONTACT.GESTION.MODIF.ERREUR");
					}
					this.keysContacts = Collections
							.singleton(this.currentRowContact);
				} catch (DataUpdateException e) {
					logger.error("DataUpdateException", e.fillInStackTrace());
					addErrorMessage(null, "CONTACT.GESTION.MODIF.ERREUR");
				} catch (WebServiceDataBaseException e) {
					logger.error("WebServiceDataBaseException",
							e.fillInStackTrace());
					addErrorMessage(null, "CONTACT.GESTION.MODIF.ERREUR");
				} catch (MailAlreadyUsedForStructureException e) {
					logger.info("MailAlreadyUsedForStructureException",
							e.fillInStackTrace());
					addErrorMessage("formModifContact:mailC",
							"CONTACT.GESTION.ERREURACCOUNT");
					//					ret = null;
				}
			} else {
				addErrorMessage("formModifContact:msg1o3",
						"CONTACT.GESTION.UNDESTROIS");
				//				ret = null;

				return;
			}
		} else {
			//			ret = null;

			return;
		}
		//		return ret;
		getSessionController().setModifContactCurrentPage("_modifContactEtape2Confirmation");
	}

	/**
	 * Supprimer un contact
	 * 
	 * @return String
	 */
	public void supprimerContact() {
		//		String ret = "_supprContactEtape2Confirmation";
		try {
			if (getStructureDomainService().deleteContact(
					this.formContact.getId())) {
				addInfoMessage(null, "CONTACT.GESTION.SUPPR.CONFIRMATION");
				reloadContacts();
				if (this.listeContacts != null) {
					this.idContactSel = this.listeContacts.get(0).getId();
					this.contactSel = this.listeContacts.get(0);
				}
				if (logger.isInfoEnabled()) {
					logger.info(getSessionController().getCurrentLogin()
							+ " supprime le contact : "
							+ this.formContact
							+ " de l'établissement : "
							+ getSessionController()
							.getCurrentManageStructure());
				}
				this.formContact = null;
			} else {
				addErrorMessage(null, "CONTACT.GESTION.SUPPR.ERREUR");
			}
		} catch (DataDeleteException e) {
			logger.error("DataDeleteException", e.fillInStackTrace());
			addErrorMessage(null, "CONTACT.GESTION.SUPPR.ERREUR");
		} catch (WebServiceDataBaseException e) {
			logger.error("WebServiceDataBaseException", e.fillInStackTrace());
			addErrorMessage(null, "CONTACT.GESTION.SUPPR.ERREUR");
		} catch (ContactDeleteException e) {
			logger.info("ContactDeleteException", e.fillInStackTrace());
			addErrorMessage(null, "CONTACT.GESTION.SUPPR.ERREURREF");
		}
		//		return ret;
		getSessionController().setSuppressionContactCurrentPage("_supprContactEtape2Confirmation");
	}

	/**
	 * Création d'un compte pour un contact sélectionné
	 * 
	 * @return String
	 */
	public String creerCompte() {
		String ret = "gestionContacts";
		if (this.formContact != null) {
			try {
				InternetAddress ia = new InternetAddress(
						this.formContact.getMail());
				ia.validate();
				this.formContact.setDateModif(new Date());
				this.formContact.setLoginModif(getSessionController()
						.getCurrentLogin());
				this.formContact.setLoginInfosAJour(getSessionController()
						.getCurrentLogin());
				this.formContact.setIdCivilite(this.formContact.getCivilite()
						.getId());
				this.formContact.setIdService(this.idServiceSel);
				this.formContact
				.setIdCentreGestion(getCentreGestionDomainService()
						.getCentreEntreprise().getIdCentreGestion());
				this.formContact.setLogin(Utils.loginGeneration(
						getSessionController().getCurrentManageStructure()
						.getRaisonSociale(),
						"" + this.formContact.getId()));
				String mdpGenere = Utils.encodeMD5(
						"random" + Math.random() * 10000).substring(0, 8);
				this.formContact.setMdp(getBlowfishUtils().encode(mdpGenere));
				if (getStructureDomainService().updateCompteContact(
						this.formContact)) {
					addInfoMessage(
							null,
							"CONTACT.GESTION.COMPTE.CREATION.CONFIRMATION",
							this.formContact.getNom() + " "
									+ this.formContact.getPrenom(),
									this.formContact.getMail());
					if (logger.isInfoEnabled()) {
						logger.info(getSessionController().getCurrentLogin()
								+ " crée un compte pour le contact : "
								+ this.formContact
								+ " de l'établissement : "
								+ getSessionController()
								.getCurrentManageStructure());
					}
					if (logger.isInfoEnabled()) {
						logger.info("Creation de compte - Envoi du mail au contact");
					}
					getSmtpService().send(
							ia,
							getString("MAIL.COMPTECONTACT.CREATION.SUJET",
									getSessionController()
									.getApplicationNameEntreprise()),
									getString(
											"MAIL.COMPTECONTACT.CREATION.MESSAGE",
											this.formContact.getLogin(),
											getBlowfishUtils().decode(
													this.formContact.getMdp()),
													getSessionController().getEntrepriseUrl(),
													getSessionController()
													.getApplicationNameEntreprise()),
							"");
					this.formContact = null;
				} else {
					addErrorMessage(null,
							"CONTACT.GESTION.COMPTE.CREATION.ERREUR");
				}
			} catch (AddressException e) {
				if (logger.isDebugEnabled()) {
					e.printStackTrace();
				}
				addErrorMessage(null, "MAIL.VALIDATION");
			} catch (DataUpdateException e) {
				logger.error("DataUpdateException", e.fillInStackTrace());
				addErrorMessage(null, "CONTACT.GESTION.COMPTE.CREATION.ERREUR");
			} catch (WebServiceDataBaseException e) {
				logger.error("WebServiceDataBaseException",
						e.fillInStackTrace());
				addErrorMessage(null, "CONTACT.GESTION.COMPTE.CREATION.ERREUR");
			} catch (AccountAlreadyExistingForCoupleMailStructureException e) {
				logger.info(
						"AccountAlreadyExistingForCoupleMailStructureException",
						e.fillInStackTrace());
				addErrorMessage(null, "CONTACT.GESTION.ERREURACCOUNT");
			}
		}
		return ret;
	}

	/**
	 * Suppression du compte pour le contact s�lectionnn�
	 * 
	 * @return String
	 */
	public String supprimerCompte() {
		String ret = "gestionContacts";
		if (this.formContact != null) {
			try {
				this.formContact.setLogin(null);
				this.formContact.setMdp(null);
				if (getStructureDomainService().updateCompteContact(
						this.formContact)) {
					addInfoMessage(
							null,
							"CONTACT.GESTION.COMPTE.SUPPRESSION.CONFIRMATION",
							this.formContact.getNom() + " "
									+ this.formContact.getPrenom());
					reloadContacts();
					if (logger.isInfoEnabled()) {
						logger.info(getSessionController().getCurrentLogin()
								+ " supprime le compte du contact : "
								+ this.formContact
								+ " de l'établissement : "
								+ getSessionController()
								.getCurrentManageStructure());
					}
					this.formContact = null;
				} else {
					addErrorMessage(null,
							"CONTACT.GESTION.COMPTE.SUPPRESSION.ERREUR");
				}
			} catch (DataUpdateException e) {
				logger.error("DataUpdateException", e.fillInStackTrace());
				addErrorMessage(null,
						"CONTACT.GESTION.COMPTE.SUPPRESSION.ERREUR");
			} catch (WebServiceDataBaseException e) {
				logger.error("WebServiceDataBaseException",
						e.fillInStackTrace());
				addErrorMessage(null,
						"CONTACT.GESTION.COMPTE.SUPPRESSION.ERREUR");
			} catch (AccountAlreadyExistingForCoupleMailStructureException e) {
				logger.info(
						"AccountAlreadyExistingForCoupleMailStructureException",
						e.fillInStackTrace());
				addErrorMessage(null, "CONTACT.GESTION.ERREURACCOUNT");
			}
		}
		return ret;
	}

	/**
	 * R�-initialisation du mot de passe du contact s�lectionn�
	 * 
	 * @return String
	 */
	public void resetMdp() {
//		String ret = "gestionContacts";
		getSessionController().setResetMdpContactCurrentPage("_resetMdpContactEtape2Confirmation");
		if (this.formContact != null) {
			try {
				this.formContact.setDateModif(new Date());
				this.formContact.setLoginModif(getSessionController()
						.getCurrentLogin());
				this.formContact.setLoginInfosAJour(getSessionController()
						.getCurrentLogin());
				String mdpGenere = Utils.encodeMD5(
						"random" + Math.random() * 10000).substring(0, 8);
				this.formContact.setMdp(getBlowfishUtils().encode(mdpGenere));
				if (getStructureDomainService().updateCompteContact(
						this.formContact)) {
					addInfoMessage(
							null,
							"CONTACT.GESTION.COMPTE.RESETMDP.CONFIRMATION",
							this.formContact.getNom() + " "
									+ this.formContact.getPrenom());
					reloadContacts();
					if (logger.isInfoEnabled()) {
						logger.info(getSessionController().getCurrentLogin()
								+ " reset le mot de passe du contact : "
								+ this.formContact
								+ " de l'établissement : "
								+ getSessionController()
								.getCurrentManageStructure());
					}
					try {
						if (logger.isInfoEnabled()) {
							logger.info("Reset de mot de passe - Envoi du mail au contact");
						}
						InternetAddress ia = new InternetAddress(
								this.formContact.getMail());
						ia.validate();
						getSmtpService()
						.send(ia,
								getString(
										"MAIL.COMPTECONTACT.RESETMDP.SUJET",
										getSessionController()
										.getApplicationNameEntreprise()),
										getString(
												"MAIL.COMPTECONTACT.RESETMDP.MESSAGE",
												this.formContact.getLogin(),
												getBlowfishUtils().decode(
														this.formContact
														.getMdp()),
														getSessionController()
														.getEntrepriseUrl(),
														getSessionController()
														.getApplicationNameEntreprise()),
								"");
					} catch (AddressException e) {
						if (logger.isDebugEnabled()) {
							e.printStackTrace();
						}
						addErrorMessage(null, "MAIL.VALIDATION");
					}
					this.formContact = null;
				} else {
					addErrorMessage(null,
							"CONTACT.GESTION.COMPTE.RESETMDP.ERREUR");
				}
			} catch (DataUpdateException e) {
				logger.error("DataUpdateException", e.fillInStackTrace());
				addErrorMessage(null, "CONTACT.GESTION.COMPTE.RESETMDP.ERREUR");
			} catch (WebServiceDataBaseException e) {
				logger.error("WebServiceDataBaseException",
						e.fillInStackTrace());
				addErrorMessage(null, "CONTACT.GESTION.COMPTE.RESETMDP.ERREUR");
			} catch (AccountAlreadyExistingForCoupleMailStructureException e) {
				logger.info(
						"AccountAlreadyExistingForCoupleMailStructureException",
						e.fillInStackTrace());
				addErrorMessage(null, "CONTACT.GESTION.ERREURACCOUNT");
			}
		}
//		return ret;
	}

	/* ***************************************************************
	 * Changement de mot de passe
	 * **************************************************************
	 */

	/**
	 * @return String
	 */
	public String goToChangerMotDePasse() {
		this.mdpActuel = "";
		this.mdpNouveau = "";
		this.mdpNouveauConfirmation = "";
		return "changerMotDePasse";
	}

	/**
	 * @return String
	 */
	public void changerMotDePasse() {
		//		String ret = "_changementMotDePasseEtape2Confirmation";
		getSessionController().setModifMdpCurrentPage("_changementMotDePasseEtape2Confirmation");
		if (getSessionController().getCurrentAuthContact() != null) {
			if (StringUtils.hasText(mdpActuel)) {
				if (mdpActuel.equals(getSessionController()
						.getCurrentAuthContact().getMdp())) {
					if (StringUtils.hasText(mdpNouveau)
							&& StringUtils.hasText(mdpNouveauConfirmation)
							&& mdpNouveau.equals(mdpNouveauConfirmation)) {
						String n1 = getBlowfishUtils().encode(mdpNouveau);
						getSessionController().getCurrentAuthContact().setMdp(
								n1);
						this.mdpActuel = "";
						this.mdpNouveau = "";
						this.mdpNouveauConfirmation = "";
						try {
							if (getStructureDomainService()
									.updateCompteContact(
											getSessionController()
											.getCurrentAuthContact())) {
								InternetAddress cIA;
								try {
									cIA = new InternetAddress(
											getSessionController()
											.getCurrentAuthContact()
											.getMail());
									cIA.validate();
									getSmtpService()
									.send(cIA,
											getString(
													"MAIL.RECAPIDENTS.SUJET",
													getSessionController()
													.getApplicationNameEntreprise()),
													getString(
															"MAIL.RECAPIDENTS.MESSAGE",
															getSessionController()
															.getCurrentAuthContact()
															.getLogin(),
															getBlowfishUtils()
															.decode(getSessionController()
																	.getCurrentAuthContact()
																	.getMdp()),
																	getSessionController()
																	.getApplicationNameEntreprise()),
											"");
									if (logger.isInfoEnabled()) {
										logger.info("Recuperation de mot de passe pour : "
												+ getSessionController()
												.getCurrentAuthContact());
									}
									addInfoMessage(
											null,
											"CONTACT.GESTION.COMPTE.CHANGEMENTMOTDEPASSE.CONFIRMATION",
											getSessionController()
											.getCurrentAuthContact()
											.getMail());
								} catch (AddressException e) {
									logger.error(e.getMessage());
									e.printStackTrace();
									addErrorMessage(null,
											"CONTACT.GESTION.COMPTE.CHANGEMENTMOTDEPASSE.ERREUR");
								}
							}
						} catch (DataUpdateException e) {
							logger.error("DataUpdateException",
									e.fillInStackTrace());
							addErrorMessage(null,
									"CONTACT.GESTION.COMPTE.CHANGEMENTMOTDEPASSE.ERREUR");
						} catch (WebServiceDataBaseException e) {
							logger.error("WebServiceDataBaseException",
									e.fillInStackTrace());
							addErrorMessage(null,
									"CONTACT.GESTION.COMPTE.CHANGEMENTMOTDEPASSE.ERREUR");
						} catch (AccountAlreadyExistingForCoupleMailStructureException e) {
							logger.info(
									"AccountAlreadyExistingForCoupleMailStructureException",
									e.fillInStackTrace());
							addErrorMessage(null,
									"CONTACT.GESTION.ERREURACCOUNT");
						}
					} else {
						//						ret = null;
						getSessionController().setModifMdpCurrentPage("_changementMotDePasseEtape1");
						addErrorMessage("changementMotDePasse:mdpNew",
								"CONTACT.GESTION.COMPTE.CHANGEMENTMOTDEPASSE.MDPCONFIRMINCORRECT");
					}
				} else {
					//					ret = null;
					getSessionController().setModifMdpCurrentPage("_changementMotDePasseEtape1");
					addErrorMessage("changementMotDePasse:mdp",
							"CONTACT.GESTION.COMPTE.CHANGEMENTMOTDEPASSE.MDPACTUELINCORRECT");
				}
			}
		}
		//		return ret;
	}

	/* ***************************************************************
	 * Getters / Setters
	 * **************************************************************
	 */

	/**
	 * @return the formStructure
	 */
	public StructureDTO getFormStructure() {
		return formStructure;
	}

	/**
	 * @param formStructure
	 *            the formStructure to set
	 */
	public void setFormStructure(StructureDTO formStructure) {
		this.formStructure = formStructure;
	}

	/**
	 * @return the formStructureTmpTypeStructure
	 */
	public TypeStructureDTO getFormStructureTmpTypeStructure() {
		return formStructureTmpTypeStructure;
	}

	/**
	 * @param formStructureTmpTypeStructure
	 *            the formStructureTmpTypeStructure to set
	 */
	public void setFormStructureTmpTypeStructure(
			TypeStructureDTO formStructureTmpTypeStructure) {
		this.formStructureTmpTypeStructure = formStructureTmpTypeStructure;
	}

	/**
	 * @return the formStructureTmpStatutJuridique
	 */
	public StatutJuridiqueDTO getFormStructureTmpStatutJuridique() {
		return formStructureTmpStatutJuridique;
	}

	/**
	 * @param formStructureTmpStatutJuridique
	 *            the formStructureTmpStatutJuridique to set
	 */
	public void setFormStructureTmpStatutJuridique(
			StatutJuridiqueDTO formStructureTmpStatutJuridique) {
		this.formStructureTmpStatutJuridique = formStructureTmpStatutJuridique;
	}

	/**
	 * @return the formStructureTmpPays
	 */
	public PaysDTO getFormStructureTmpPays() {
		return formStructureTmpPays;
	}

	/**
	 * @param formStructureTmpPays
	 *            the formStructureTmpPays to set
	 */
	public void setFormStructureTmpPays(PaysDTO formStructureTmpPays) {
		this.formStructureTmpPays = formStructureTmpPays;
	}

	/**
	 * @return the formStructureTmpNafN5
	 */
	public NafN5DTO getFormStructureTmpNafN5() {
		return formStructureTmpNafN5;
	}

	/**
	 * @param formStructureTmpNafN5
	 *            the formStructureTmpNafN5 to set
	 */
	public void setFormStructureTmpNafN5(NafN5DTO formStructureTmpNafN5) {
		this.formStructureTmpNafN5 = formStructureTmpNafN5;
	}

	/**
	 * @return the formStructureTmpCodePostal
	 */
	public String getFormStructureTmpCodePostal() {
		return formStructureTmpCodePostal;
	}

	/**
	 * @param formStructureTmpCodePostal
	 *            the formStructureTmpCodePostal to set
	 */
	public void setFormStructureTmpCodePostal(String formStructureTmpCodePostal) {
		this.formStructureTmpCodePostal = formStructureTmpCodePostal;
	}

	/**
	 * @return the formStructureTmpCommuneDTO
	 */
	public CommuneDTO getFormStructureTmpCommuneDTO() {
		return formStructureTmpCommuneDTO;
	}

	/**
	 * @param formStructureTmpCommuneDTO
	 *            the formStructureTmpCommuneDTO to set
	 */
	public void setFormStructureTmpCommuneDTO(
			CommuneDTO formStructureTmpCommuneDTO) {
		this.formStructureTmpCommuneDTO = formStructureTmpCommuneDTO;
	}

	/**
	 * @return the communesListening
	 */
	public List<SelectItem> getCommunesListening() {
		return communesListening;
	}

	/**
	 * @return the modificationEtabBoutonAnnuler
	 */
	public boolean isModificationEtabBoutonAnnuler() {
		return modificationEtabBoutonAnnuler;
	}

	/**
	 * @param modificationEtabBoutonAnnuler
	 *            the modificationEtabBoutonAnnuler to set
	 */
	public void setModificationEtabBoutonAnnuler(
			boolean modificationEtabBoutonAnnuler) {
		this.modificationEtabBoutonAnnuler = modificationEtabBoutonAnnuler;
	}

	/**
	 * @return the listeServices
	 */
	public List<ServiceDTO> getListeServices() {
		return listeServices;
	}

	/**
	 * @param listeServices
	 *            the listeServices to set
	 */
	public void setListeServices(List<ServiceDTO> listeServices) {
		this.listeServices = listeServices;
	}

	/**
	 * @return the servicesItems
	 */
	public List<SelectItem> getServicesItems() {
		this.servicesItems = new ArrayList<SelectItem>();
		for (ServiceDTO s : this.listeServices) {
			this.servicesItems
			.add(new SelectItem(s.getIdService(), s.getNom()));
		}
		return this.servicesItems;
	}

	/**
	 * @return the formService
	 */
	public ServiceDTO getFormService() {
		return formService;
	}

	/**
	 * @param formService
	 *            the formService to set
	 */
	public void setFormService(ServiceDTO formService) {
		this.formService = formService;
	}

	/**
	 * @return the formServiceTmpPays
	 */
	public PaysDTO getFormServiceTmpPays() {
		return formServiceTmpPays;
	}

	/**
	 * @param formServiceTmpPays
	 *            the formServiceTmpPays to set
	 */
	public void setFormServiceTmpPays(PaysDTO formServiceTmpPays) {
		this.formServiceTmpPays = formServiceTmpPays;
	}

	/**
	 * @return the formServiceTmpCodePostal
	 */
	public String getFormServiceTmpCodePostal() {
		return formServiceTmpCodePostal;
	}

	/**
	 * @param formServiceTmpCodePostal
	 *            the formServiceTmpCodePostal to set
	 */
	public void setFormServiceTmpCodePostal(String formServiceTmpCodePostal) {
		this.formServiceTmpCodePostal = formServiceTmpCodePostal;
	}

	/**
	 * @return the formServiceTmpCommuneDTO
	 */
	public CommuneDTO getFormServiceTmpCommuneDTO() {
		return formServiceTmpCommuneDTO;
	}

	/**
	 * @param formServiceTmpCommuneDTO
	 *            the formServiceTmpCommuneDTO to set
	 */
	public void setFormServiceTmpCommuneDTO(CommuneDTO formServiceTmpCommuneDTO) {
		this.formServiceTmpCommuneDTO = formServiceTmpCommuneDTO;
	}

	/**
	 * @return the formServiceCommunesListening
	 */
	public List<SelectItem> getFormServiceCommunesListening() {
		return formServiceCommunesListening;
	}

	/**
	 * @return the memeAdresseStructure
	 */
	public boolean isMemeAdresseStructure() {
		return memeAdresseStructure;
	}

	/**
	 * @param memeAdresseStructure
	 *            the memeAdresseStructure to set
	 */
	public void setMemeAdresseStructure(boolean memeAdresseStructure) {
		this.memeAdresseStructure = memeAdresseStructure;
	}

	/**
	 * @return the idServiceSel
	 */
	public int getIdServiceSel() {
		return idServiceSel;
	}

	/**
	 * @param idServiceSel
	 *            the idServiceSel to set
	 */
	public void setIdServiceSel(int idServiceSel) {
		this.idServiceSel = idServiceSel;
	}

	/**
	 * @return the idContactSel
	 */
	public int getIdContactSel() {
		return idContactSel;
	}

	/**
	 * @param idContactSel
	 *            the idContactSel to set
	 */
	public void setIdContactSel(int idContactSel) {
		this.idContactSel = idContactSel;
	}

	/**
	 * @return the contactSel
	 */
	public ContactDTO getContactSel() {
		return contactSel;
	}

	/**
	 * @param contactSel
	 *            the contactSel to set
	 */
	public void setContactSel(ContactDTO contactSel) {
		this.contactSel = contactSel;
	}

	/**
	 * @return the contactsItems
	 */
	public List<SelectItem> getContactsItems() {
		this.contactsItems = new ArrayList<SelectItem>();
		for (ContactDTO c : this.listeContacts) {
			this.contactsItems.add(new SelectItem(c.getId(), c.getNom() + " "
					+ c.getPrenom()));
		}
		return this.contactsItems;
	}

	/**
	 * @param contactsItems
	 *            the contactsItems to set
	 */
	public void setContactsItems(List<SelectItem> contactsItems) {
		this.contactsItems = contactsItems;
	}

	/**
	 * @return the serviceSel
	 */
	public ServiceDTO getServiceSel() {
		return serviceSel;
	}

	/**
	 * @param serviceSel
	 *            the serviceSel to set
	 */
	public void setServiceSel(ServiceDTO serviceSel) {
		this.serviceSel = serviceSel;
	}

	/**
	 * @return the listeContacts
	 */
	public List<ContactDTO> getListeContacts() {
		return listeContacts;
	}

	/**
	 * @param listeContacts
	 *            the listeContacts to set
	 */
	public void setListeContacts(List<ContactDTO> listeContacts) {
		this.listeContacts = listeContacts;
	}

	/**
	 * @return the formContact
	 */
	public ContactDTO getFormContact() {
		return formContact;
	}

	/**
	 * @param formContact
	 *            the formContact to set
	 */
	public void setFormContact(ContactDTO formContact) {
		this.formContact = formContact;
	}

	/**
	 * @return the currentCentresGestionContainsCentreContact
	 */
	public boolean isCurrentCentresGestionContainsCentreContact() {
		currentCentresGestionContainsCentreContact = false;
		if (getSessionController().getCurrentIdsCentresGestion() != null
				&& !getSessionController().getCurrentIdsCentresGestion().isEmpty()
				&& ((ArrayList<Integer>) getSessionController().getCurrentIdsCentresGestion())
				.contains(this.formContact.getIdCentreGestion())) {
			CentreGestionDTO cgEntr = getCentreGestionDomainService()
					.getCentreEntreprise();
			if (cgEntr != null && cgEntr.getIdCentreGestion() != this.formContact
					.getIdCentreGestion())
				currentCentresGestionContainsCentreContact = true;
		}
		return currentCentresGestionContainsCentreContact;
	}

	/**
	 * @return the currentCentresGestionContainsCentreContact
	 */
	public boolean isCurrentCentresGestionContainsCentreEntr() {
		currentCentresGestionContainsCentreEntr = true;
		currentCentresGestionContainsCentreEntr = getSessionController()
				.isAdminPageAuthorized()
				|| getSessionController().isPageAuthorized();
		return currentCentresGestionContainsCentreEntr;
	}

	/**
	 * @return the afficherSelectionCentreContact
	 */
	public boolean isAfficherSelectionCentreContact() {
		return afficherSelectionCentreContact;
	}

	/**
	 * @param afficherSelectionCentreContact
	 *            the afficherSelectionCentreContact to set
	 */
	public void setAfficherSelectionCentreContact(
			boolean afficherSelectionCentreContact) {
		this.afficherSelectionCentreContact = afficherSelectionCentreContact;
	}

	/**
	 * @return the keysContacts
	 */
	public Set<Integer> getKeysContacts() {
		return keysContacts;
	}

	/**
	 * @param keysContacts
	 *            the keysContacts to set
	 */
	public void setKeysContacts(Set<Integer> keysContacts) {
		this.keysContacts = keysContacts;
	}

	/**
	 * @return the currentRowContact
	 */
	public int getCurrentRowContact() {
		return currentRowContact;
	}

	/**
	 * @param currentRowContact
	 *            the currentRowContact to set
	 */
	public void setCurrentRowContact(int currentRowContact) {
		this.currentRowContact = currentRowContact;
	}

	/**
	 * @return the rechercheController
	 */
	public RechercheController getRechercheController() {
		return rechercheController;
	}

	/**
	 * @param rechercheController
	 *            the rechercheController to set
	 */
	public void setRechercheController(RechercheController rechercheController) {
		this.rechercheController = rechercheController;
	}

	/**
	 * @return the mdpActuel
	 */
	public String getMdpActuel() {
		return mdpActuel;
	}

	/**
	 * @param mdpActuel
	 *            the mdpActuel to set
	 */
	public void setMdpActuel(String mdpActuel) {
		this.mdpActuel = mdpActuel;
	}

	/**
	 * @return the mdpNouveau
	 */
	public String getMdpNouveau() {
		return mdpNouveau;
	}

	/**
	 * @param mdpNouveau
	 *            the mdpNouveau to set
	 */
	public void setMdpNouveau(String mdpNouveau) {
		this.mdpNouveau = mdpNouveau;
	}

	/**
	 * @return the mdpNouveauConfirmation
	 */
	public String getMdpNouveauConfirmation() {
		return mdpNouveauConfirmation;
	}

	/**
	 * @param mdpNouveauConfirmation
	 *            the mdpNouveauConfirmation to set
	 */
	public void setMdpNouveauConfirmation(String mdpNouveauConfirmation) {
		this.mdpNouveauConfirmation = mdpNouveauConfirmation;
	}

	/**
	 * @param codeNafObligatoire
	 *            the codeNafObligatoire to set
	 */
	public void setCodeNafObligatoire(boolean codeNafObligatoire) {
		this.codeNafObligatoire = codeNafObligatoire;
	}

	/**
	 * @return the codeNafObligatoire
	 */
	public boolean isCodeNafObligatoire() {
		return codeNafObligatoire;
	}

	/**
	 * @return the currentStruct
	 */
	public StructureDTO getCurrentStruct() {
		return currentStruct;
	}

	/**
	 * @param currentStruct the currentStruct to set
	 */
	public void setCurrentStruct(StructureDTO currentStruct) {
		this.currentStruct = currentStruct;
	}
}
