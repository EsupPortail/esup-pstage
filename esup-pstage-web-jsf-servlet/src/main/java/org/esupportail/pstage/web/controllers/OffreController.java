/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import fr.wsclient.apogee.GeographieMetier.CommuneDTO;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;
import org.esupportail.pstage.exceptions.ExportException;
import org.esupportail.pstage.services.export.CastorService;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstage.web.beans.FileUploadBean;
import org.esupportail.pstage.web.beans.ImageUploadBean;
import org.esupportail.pstage.web.comparator.ComparatorSelectItem;
import org.esupportail.pstage.web.paginators.RechercheOffrePaginator;
import org.esupportail.pstage.web.utils.PDFUtils;
import org.esupportail.pstagedata.domain.dto.*;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.util.StringUtils;

import static org.hsqldb.HsqlDateTime.e;

/**
 * OffreController
 */
public class OffreController extends AbstractContextAwareController {

	/* ***************************************************************
	 * Propriétés
	 ****************************************************************/
	/**
	 * Navigation à renvoyer au cours de l'ajout d'offre selon si l'on est coté entreprise ou stage
	 */
	private String creationOffre;

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 3430944955282121430L;
	/**
	 * Logger
	 */
	private final transient Logger logger = Logger.getLogger(this.getClass());
	/**
	 * Page de retour après une modification ou suppression d'offre
	 */
	private String retour=null;
	/**
	 * Action pour renvoyer sur le récap de l'offre en cours
	 */
	private String recap=null;
	/**
	 * Offre actuellement gérée
	 */
	private OffreDTO currentOffre;
	/**
	 * Objet offre utilisé pour l'ajout/modification
	 */
	private OffreDTO formOffre;
	/**
	 * Liste des contrats mise à jour en fonction du type d'offre
	 */
	private List<SelectItem> contratsListening;
	/**
	 * Liste FapN3 mise à jour en fonction de la QualificationSimplifiee
	 */
	private List<SelectItem> fapN3Listening;
	/**
	 * Liste des communes mise à jour en fonction du code postal
	 */
	private List<SelectItem> formOffreCommunesListening=new ArrayList<SelectItem>();
	/**
	 * Vrai si offre avec un fichier ou un lien
	 */
	private boolean avecFichierOuLien;
	/**
	 * 1 si fichier, 2 si lien
	 */
	private int fichierOuLien=0;

	/**
	 * Liste des offres de l'entreprise actuellement gérée
	 */
	private List<OffreDTO> listeOffres;
	/**
	 * Liste des centres de gestion de la personne actuellement connectée sous de SelectItem
	 */
	private List<SelectItem> listeItemsCurrentCentresGestion;

	//Recherche
	/**
	 * CritereRechercheOffreDTO
	 */
	private CritereRechercheOffreDTO critereRechercheOffre=initCritereRechercheOffre();
	/**
	 * Liste des types d'offres et contrats pour la recherche
	 */
	private List<SelectItem> rechTypesContratsOffre;
	/**
	 * Type ou contrat sélectionné pour la recherche
	 */
	private String rechTypeOuContrat;
	/**
	 * Resultats de la recherche d'offre
	 */
	private List<OffreDTO> resultatsRechercheOffre;
	/**
	 * Vrai si recherche avancée, faux si recherche simple
	 */
	private boolean rechercheAvancee=false;
	/**
	 * RechercheOffrePaginator
	 */
	private RechercheOffrePaginator rechercheOffrePaginator;

	//Diffusion à d'autres centres
	/**
	 * Nombre d'éléments dans la liste offresDiffusion de currentOffre
	 */
	private int currentOffreSizeOffresDiffusion;
	/**
	 * Liste des centres établissement
	 */
	private List<SelectItem> listesCentresGestionEtablissement=new ArrayList<SelectItem>();
	/**
	 * Liste des centres établissement
	 */
	private List<CentreGestionDTO> listesCGEtab;

	/**
	 * Id du centre établissement sélectionné
	 */
	private int idCentreEtablissementSelect;

	/**
	 * Centre de gestion utilisé pour le dépot anonyme
	 */
	private CentreGestionDTO centreGestionDepotAnonyme;
	/**
	 * EtablissementController
	 */
	private EtablissementController etablissementController;

	/**
	 * Service to generate Xml.
	 */
	private CastorService castorService;

	/**
	 * Liste des durees de diffusion disponibles
	 */
	private List<SelectItem> dureesDiffusion;

	/**
	 * Duree de diffusion choisie
	 */
	private int dureeDiffusion;

	/**
	 * on diffuse l'offre après ajout/modif si vrai
	 */
	private boolean diffusionDirecte = false;

	/**
	 * Nombre d'offres à diffuser (pour affichage _menu.jsp partie entreprise)
	 */
	private int offreADiffuser=0;

	public DualListModel<CentreGestionDTO> getDualListCiblageCentres() {
		return dualListCiblageCentres;
	}

	public void setDualListCiblageCentres(DualListModel<CentreGestionDTO> dualListCiblageCentres) {
		this.dualListCiblageCentres = dualListCiblageCentres;
	}

	/**
	 * DualList des centres de gestion dispos/choisis pour le ciblage
	 */
	private DualListModel<CentreGestionDTO> dualListCiblageCentres;

	/**
	 * rendered en fonctione du type de contrat de la page __offreEtape2
	 */
	private boolean affichageDureeOffre = false;

	/**
	 * rendered en fonction du pays de la page __offreEtape2
	 */
	private boolean paysOffreFrance = false;
	/**
	 * retient dans quel recapitulatif offre nous sommes
	 * 'offre' = depot
	 * 'offreEtab' = depot depuis la consultation d'une structure
	 * 'offreCentre' = stage
	 * 'offreEtabCentre' = stage depuis la consultation d'une structure
	 */
	private String currentRecapOffre;

	/**
	 * true si l'on modifie directement les contacts de l'offre (et pas via une étape précédente)
	 */
	private boolean modificationContactOffre;


	/**
	 * Bean constructor.
	 */
	public OffreController() {
		super();
	}

	/* ***************************************************************
	 * Actions
	 ****************************************************************/

	/**
	 * Gestion des offres (entreprise)
	 *
	 * @return String
	 */
	public String goToGestionOffres() {
		return "gestionOffres";
	}

	/**
	 * Gestion des offres (stage)
	 *
	 * @return String
	 */
	public String goToOffresEtablissement() {
		loadOffres();
		return "offresEtablissement";
	}

	/**
	 * Chargement des offres
	 */
	public void loadOffres() {
		if (getSessionController().getCurrentManageStructure() != null) {
			this.listeOffres = getOffreDomainService()
					.getOffresFromIdStructureAndIdsCentreGestion(
							getSessionController().getCurrentManageStructure()
									.getIdStructure(),
							getSessionController()
									.getCurrentIdsCentresGestion(),
							getSessionController().getCurrentAuthEtudiant() != null);
			if (this.listeOffres != null && !this.listeOffres.isEmpty()) {
				for (OffreDTO o : this.listeOffres) {
					o.setStructure(getSessionController()
							.getCurrentManageStructure());
				}
			}
			sortListesOffres();
		}
	}

	/**
	 * Tri
	 */
	public void sortListesOffres() {
		if (this.listeOffres != null && !this.listeOffres.isEmpty()) {
			Collections.sort(this.listeOffres, new Comparator<OffreDTO>() {
				/**
				 * @see java.util.Comparator#compare(java.lang.Object,
				 *      java.lang.Object)
				 */
				@Override
				public int compare(OffreDTO o1, OffreDTO o2) {
					return o1.getIntitule().compareToIgnoreCase(
							o2.getIntitule());
				}
			});
		}
	}

	/* ***************************************************************
	 * Ajout d'une offre
	 * **************************************************************/

	/**
	 * @return String
	 */
	public String goToEntrepriseCreationOffre() {
		this.creationOffre = "creationOffre";
		this.formOffre = new OffreDTO();
		this.formOffre.setStructure(getSessionController().getCurrentManageStructure());
		this.formOffre.setIdStructure(this.formOffre.getStructure().getIdStructure());
		this.centreGestionDepotAnonyme = null;
		this.formOffre.setIdCentreGestion(getCentreGestionDomainService().getCentreEntreprise().getIdCentreGestion());
		// Indemnités à vrai par défaut
		this.formOffre.setRemuneration(true);
		this.avecFichierOuLien = false;
		this.fichierOuLien = 0;
		this.contratsListening = null;
		this.fapN3Listening = null;
		getSessionController().setCreationOffreCurrentPage("_creationOffreEtape1");
		return this.creationOffre;
	}

	/**
	 * permet de recharger la page courante de l'enchainement d'offre
	 * @return String
	 */
	public String goToCreationOffre() {
		return this.creationOffre;
	}

	/**
	 * Etape 01 : Sélection du centre de gestion
	 *
	 * @return String
	 */
	public String goToCreationOffreSelectionCentre() {
		this.creationOffre = "creationCentreEtabOffre";
		this.formOffre = new OffreDTO();
		this.centreGestionDepotAnonyme = null;
		getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape01Centre");
		return this.creationOffre;
	}

	/**
	 * Etape 02 : Sélection établissement
	 *
	 * @return String
	 */
	public String goToCreationOffreSelectionEtab() {
		String ret = "creationEtabOffre";
		this.formOffre = new OffreDTO();
		this.centreGestionDepotAnonyme = null;
		return ret;
	}

	/**
	 * Etape 03 : Création établissement
	 * @return a String
	 */
	public void goToCreationOffreCreaEtab() {
		this.etablissementController.goToCreationEtablissement();
		getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape03CreaEtab");
	}

	/**
	 * Bouton d'ajout d'une offre à l'étape 03
	 *
	 * @return String
	 */
	public void ajouterEtablissement() {
		String ret = this.etablissementController.ajouterEtablissement();
		if (ret != null
				&& this.etablissementController.getFormStructure() != null) {
			this.etablissementController.getRechercheController()
					.setResultatRechercheStructure(
							this.etablissementController.getFormStructure());
			this.etablissementController.setFormStructure(null);

			getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape04DetailsEtab");
		}
	}

	/**
	 * @return String
	 */
	public String goToCreationOffreModifEtab() {
		this.etablissementController.goToModificationEtablissement();
		getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape05ModifEtab");
		return "creationCentreEtabOffre";
	}

	/**
	 * @return String
	 */
	public void modifierEtablissement() {
		String ret = this.etablissementController.modifierEtablissement();
		FacesContext fc = FacesContext.getCurrentInstance();
		Iterator<FacesMessage> ifm = fc.getMessages("formModifEtab");
		while (ifm.hasNext()) {
			FacesMessage fm = ifm.next();
			fc.addMessage(
					"formCreationOffre:formModifEtab",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, fm
							.getSummary(), fm.getDetail()));
			ifm.remove();
		}
		ifm = fc.getMessages("formAffEtab");
		while (ifm.hasNext()) {
			FacesMessage fm = ifm.next();
			fc.addMessage("formCreationOffre:formAffEtab",
					new FacesMessage(fm.getSummary(), fm.getDetail()));
			ifm.remove();
		}
		if (StringUtils.hasText(ret)) {
			// ret="_creationOffreEtape04DetailsEtab";
			getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape04DetailsEtab");
		}
		// return ret;

	}

	/**
	 * @return String
	 */
	public void goToCreationOffreDetailsEtab(){
		getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape04DetailsEtab");
	}

	/**
	 * @return String
	 */
	public String goToCreationOffreEtape1(){

		this.formOffre.setIdStructure(this.formOffre.getStructure().getIdStructure());

		getSessionController().setCurrentManageStructure(this.formOffre.getStructure());
		getSessionController().setMenuGestionEtab(false);

		//Chargement contacts uniquement pour le centre sélectionné
		ArrayList<CentreGestionDTO> curCentresTmp = (ArrayList<CentreGestionDTO>) getSessionController().getCurrentCentresGestion();
		ArrayList<CentreGestionDTO> centreContacts = new ArrayList<>();

		CentreGestionDTO cgTmp = new CentreGestionDTO();
		cgTmp.setIdCentreGestion(this.formOffre.getIdCentreGestion());
		cgTmp.setNomCentre("");
		if(curCentresTmp != null
				&& !curCentresTmp.isEmpty()
				&& curCentresTmp.indexOf(cgTmp) >= 0){
			centreContacts.add(curCentresTmp.get(curCentresTmp.indexOf(cgTmp)));
		}
		if(centreGestionDepotAnonyme!=null
				&& centreGestionDepotAnonyme.getIdCentreGestion() > 0){
			centreContacts = new ArrayList<>();
			centreContacts.add(centreGestionDepotAnonyme);
		}

		getSessionController().setCentreGestionRattachement(centreContacts.get(0));

		this.etablissementController.loadContactsServices();
		//Indemnités à vrai par défaut
		this.formOffre.setRemuneration(true);

		this.avecFichierOuLien=false;
		this.fichierOuLien=0;
		this.formOffre.setLienAttache("http://");

		this.contratsListening=null;
		this.fapN3Listening=null;
		getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape1");
		getSessionController().setCreationOffreCurrentPage("_creationOffreEtape1");

		return this.creationOffre;
	}

	/**
	 * Envoi vers l'Etape 2 : Saisie de l'offre
	 * @return String
	 */
	public String goToCreationOffreEtape2(){
		getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape2");
		getSessionController().setCreationOffreCurrentPage("_creationOffreEtape2");

		// Oui par défaut pour la diffusion directe de l'offre :
//		this.diffusionDirecte = true;

		this.formOffre.setLieuPays(this.formOffre.getStructure().getPays());
		this.formOffre.setLieuCodePostal(this.formOffre.getStructure().getCodePostal());
		this.formOffre.setLieuCommune(this.formOffre.getStructure().getCommune());
		this.formOffre.setCodeCommune(this.formOffre.getStructure().getCodeCommune());
		if(getSessionController().isRecupererCommunesDepuisApogee() &&
				getBeanUtils().isFrance(this.formOffre.getLieuPays())){
			List<SelectItem> lTmp = majCommunes(""+this.formOffre.getLieuCodePostal());
			if(lTmp!=null && !lTmp.isEmpty()){
				this.formOffreCommunesListening=lTmp;
			}else{
				this.formOffreCommunesListening=new ArrayList<SelectItem>();
			}
		}

		if(this.avecFichierOuLien){
			switch (this.fichierOuLien) {
				case 1:
					this.formOffre.setAvecFichier(true);
					this.formOffre.setAvecLien(false);
					this.formOffre.setLienAttache("");
					break;
				case 2:
					this.deleteUploadedFile();
					this.formOffre.setAvecFichier(false);
					this.formOffre.setAvecLien(true);
					break;
				default:
					this.deleteUploadedFile();
					getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape1");
					getSessionController().setCreationOffreCurrentPage("_creationOffreEtape1");
					break;
			}
		} else {
			//Suppression de l'ancien fichier/lien
			this.deleteUploadedFile();
		}

		this.formOffre.setIdTypeOffre(this.formOffre.getTypeOffre().getId());
		//Màj liste des contrats
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContratsOffreFromIdTypeOffre(this.formOffre.getIdTypeOffre());
		if(l!=null && !l.isEmpty()){
			this.contratsListening=new ArrayList<>();
			for(ContratOffreDTO c : l){
				this.contratsListening.add(new SelectItem(c,c.getLibelle()));
			}
		}else{
			this.contratsListening=null;
		}

		// On initialise l'uniteDuree a vide pour eviter qu'elle soit remplie par defaut.
		this.formOffre.setUniteDuree(new UniteDureeDTO());

		//Reset de la durée de diffusion
		this.dureeDiffusion = 2;


		return this.creationOffre;
	}

	public boolean isAffichageDureeOffre(){
		if ((this.formOffre.getContratOffre() != null && this.formOffre.getContratOffre().equals(getBeanUtils().getCdd()))
				|| (this.formOffre.getTypeOffre() != null &&
				(this.formOffre.getTypeOffre().equals(getBeanUtils().getStage())
						|| this.formOffre.getTypeOffre().equals(getBeanUtils().getAlternance())
						|| this.formOffre.getTypeOffre().equals(getBeanUtils().getVieVia())))){
			return true;
		}

		return false;
	}

	public boolean isPaysOffreFrance(){
		if ((this.formOffre.getLieuPays() != null && getBeanUtils().isFrance(this.formOffre.getLieuPays()))){
			return true;
		}
		return false;
	}

	/**
	 * Envoi vers l'étape 3
	 * Saisie des contacts
	 * @return String
	 */
	public String goToCreationOffreEtape3(){
		getSessionController().setCreationOffreCurrentPage("_creationOffreEtape3");
		getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape3");

		return this.creationOffre;
	}

	/**
	 * Ajout de l'offre en base
	 */
	public void ajoutOffre(){
		this._ajoutOffre();
		if(this.formOffre.getIdOffre() > 0
				&& getSessionController().getCurrentManageStructure() != null
				&& getSessionController().getCurrentManageStructure().getIdStructure() == this.formOffre.getIdStructure()){
			if(this.listeOffres==null)
				this.listeOffres=new ArrayList<OffreDTO>();
			this.listeOffres.add(this.formOffre);
			this.currentOffre = this.formOffre;
			this.formOffre=new OffreDTO();
		}
		//		return ret;
	}

	/**
	 * Méthode d'ajout d'une offre subdivisée pour gérer l'ajout d'offre d'une entreprise et l'ajout d'offre d'un centre (ne nécessite pas la maj de la liste des offres)
	 * @return String
	 */
	public void _ajoutOffre(){
		//		String ret=null;
		if(this.centreGestionDepotAnonyme!=null){
			this.formOffre.setLoginCreation("depotAnonyme");
		}else{
			this.formOffre.setLoginCreation(getSessionController().getCurrentLogin());
		}
		if(this.formOffre.getLieuPays()!=null){
			if(getBeanUtils().isFrance(this.formOffre.getLieuPays()) && getSessionController().isRecupererCommunesDepuisApogee() && !"0".equals(this.formOffre.getCodeCommune())){
				//Récupération de la commune pour en avoir le libellé
				CommuneDTO c = getGeographieRepositoryDomain().getCommuneFromDepartementEtCodeCommune(this.formOffre.getLieuCodePostal(), ""+this.formOffre.getCodeCommune());
				if(c!=null){
					this.formOffre.setLieuCommune(c.getLibCommune());
				}
			}
			this.formOffre.setIdLieuPays(this.formOffre.getLieuPays().getId());
		}
		if(this.formOffre.getFapQualificationSimplifiee()!=null)this.formOffre.setIdQualificationSimplifiee(this.formOffre.getFapQualificationSimplifiee().getId());
		if(this.formOffre.getFapN1()!=null)this.formOffre.setCodeFAP_N3(this.formOffre.getFapN1().getCode());
		if(this.formOffre.getTypeOffre()!=null)this.formOffre.setIdTypeOffre(this.formOffre.getTypeOffre().getId());
		else this.formOffre.setIdTypeOffre(0);
		if(this.formOffre.getContratOffre()!=null)this.formOffre.setIdContratOffre(this.formOffre.getContratOffre().getId());
		else this.formOffre.setIdContratOffre(0);
		if(this.formOffre.getNiveauFormation()!=null)this.formOffre.setIdNiveauFormation(this.formOffre.getNiveauFormation().getId());
		else this.formOffre.setIdNiveauFormation(0);
		this.formOffre.setAnneeUniversitaire(getBeanUtils().getAnneeUniversitaireCourante(new Date()));
		this.formOffre.setCentreGestion(getCentreGestionDomainService().getCentreGestion(this.formOffre.getIdCentreGestion()));
		int idOffreAjoutee;
		if(this.avecFichierOuLien){
			this.formOffre.setIdTempsTravail(0);
			this.formOffre.setIdUniteDuree(0);
			this.formOffre.setModesCandidature(null);
			this.formOffre.setIdsModeCandidature(null);

			this.formOffre.setContactCand(null);
			this.formOffre.setContactInfo(null);
			this.formOffre.setIdContactCand(0);
			this.formOffre.setIdContactInfo(0);
			switch (this.fichierOuLien) {
				case 1:
					if(this.formOffre.getIdFichier()>0){
						try{
							this.formOffre.setAvecFichier(true);
							this.formOffre.setAvecLien(false);
							this.formOffre.setLienAttache("");
							idOffreAjoutee = getOffreDomainService().addOffre(this.formOffre);
							this.formOffre.setIdOffre(idOffreAjoutee);
							this.formOffre.setDateCreation(new Date());
							this.formOffre.setLoginCreation(getSessionController().getCurrentLogin());
							getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape4Confirmation");
							getSessionController().setCreationOffreCurrentPage("_creationOffreEtape4Confirmation");
							addInfoMessage(null, "OFFRE.CREATION.CONFIRMATION", this.formOffre.getIdOffre());
//							mailAjout();
						}catch (DataAddException|WebServiceDataBaseException e) {
							logger.error(e);
						}
					}else{
						addErrorMessage("formCreationOffre", "OFFRE.SELECTIONFICHIER.OBLIGATOIRE");
					}
					break;
				case 2:
					try{
						this.formOffre.setFichier(null);
						this.formOffre.setIdFichier(0);
						this.formOffre.setAvecFichier(false);
						this.formOffre.setAvecLien(true);
						idOffreAjoutee = getOffreDomainService().addOffre(this.formOffre);
						this.formOffre.setIdOffre(idOffreAjoutee);
						this.formOffre.setDateCreation(new Date());
						this.formOffre.setLoginCreation(getSessionController().getCurrentLogin());
						getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape4Confirmation");
						getSessionController().setCreationOffreCurrentPage("_creationOffreEtape4Confirmation");
						addInfoMessage(null, "OFFRE.CREATION.CONFIRMATION", this.formOffre.getIdOffre());
						mailAjout();
					}catch (DataAddException|WebServiceDataBaseException e) {
						logger.error(e);
						addErrorMessage(null, "OFFRE.CREATION.ERREURAJOUT");
					}
					break;
			}
		}else{

			if(this.formOffre.getTempsTravail()!=null)this.formOffre.setIdTempsTravail(this.formOffre.getTempsTravail().getId());
			else this.formOffre.setIdTempsTravail(0);
			if(this.formOffre.getUniteDuree()!=null)this.formOffre.setIdUniteDuree(this.formOffre.getUniteDuree().getId());
			else this.formOffre.setIdUniteDuree(0);
			if(this.formOffre.getModesCandidature()!=null){
				ArrayList<Integer> l = new ArrayList<Integer>();
				for(ModeCandidatureDTO m : this.formOffre.getModesCandidature()){
					l.add(m.getId());
				}
				if(!l.isEmpty())this.formOffre.setIdsModeCandidature(l);
				else this.formOffre.setIdsModeCandidature(null);
			}
			if(this.formOffre.getContactCand()!=null){
				try{
					this.formOffre.setIdContactCand(this.formOffre.getContactCand().getId());
					if(this.formOffre.getContactInfo()!=null)this.formOffre.setIdContactInfo(this.formOffre.getContactInfo().getId());
					this.formOffre.setFichier(null);
					this.formOffre.setIdFichier(0);
					idOffreAjoutee = getOffreDomainService().addOffre(this.formOffre);
					this.formOffre.setIdOffre(idOffreAjoutee);
					this.formOffre.setDateCreation(new Date());
					this.formOffre.setLoginCreation(getSessionController().getCurrentLogin());

					getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape4Confirmation");
					getSessionController().setCreationOffreCurrentPage("_creationOffreEtape4Confirmation");
					addInfoMessage(null, "OFFRE.CREATION.CONFIRMATION", this.formOffre.getIdOffre());
					mailAjout();
				}catch (DataAddException|WebServiceDataBaseException e) {
					logger.error(e);
					addErrorMessage(null, "OFFRE.CREATION.ERREURAJOUT");
				}
			}else{
				addErrorMessage("formCreationOffre:contactCand", "OFFRE.SELECTIONCONTACTCAND.OBLIGATOIRE");
			}
		}
		if(this.diffusionDirecte){
			this.currentOffre = this.formOffre;
			this.diffuserOffre();
		} else if (!this.formOffre.isEstDiffusee()){
			addInfoMessage(null, "OFFRE.CREATION.CONFIRMATION.DIFFUSION", this.formOffre.getIdOffre());
		}
		this.diffusionDirecte = false;

		//		return ret;
	}

	/**
	 *
	 */
	public void mailAjout(){
		//Envoi mail sur la mailing list entreprise
		String infoPersonne="";
		if(getSessionController().isAdminPageAuthorized() && getSessionController().getCurrentAuthAdminStructure()!=null){
			infoPersonne+=getSessionController().getCurrentAuthAdminStructure().getNom()+" "+getSessionController().getCurrentAuthAdminStructure().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
		}else if(getSessionController().isPageAuthorized() && getSessionController().getCurrentAuthContact()!=null){
			infoPersonne+=getSessionController().getCurrentAuthContact().getNom()+" "+getSessionController().getCurrentAuthContact().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
		}else{
			infoPersonne+=getSessionController().getCurrentLogin();
		}
		if(centreGestionDepotAnonyme!=null && centreGestionDepotAnonyme.getIdCentreGestion()>0){
			if(StringUtils.hasText(centreGestionDepotAnonyme.getMail())){
				InternetAddress ia = null;
				try {
					ia = new InternetAddress(centreGestionDepotAnonyme.getMail());
					infoPersonne="depot anonyme";
					getSmtpService().send(
							ia,
							getString("MAIL.ADMIN.OFFRE.SUJETAJOUT", getSessionController().getApplicationNameEntreprise(),this.formOffre.getStructure().printAdresse(), infoPersonne),
							getString("MAIL.ADMIN.OFFRE.MESSAGEAJOUT", getSessionController().getApplicationNameEntreprise(),this.formOffre.getIdOffre() +", "+this.formOffre.getIntitule(),this.formOffre.getStructure().printAdresse(), infoPersonne),
							""
					);
				} catch (AddressException e) {
					logger.info(e);
				}
			}
		}else if(getSessionController().isMailingListEntrMailAvertissementAjoutOffre() && StringUtils.hasText(getSessionController().getMailingListEntr())
				&& (getSessionController().isAdminPageAuthorized() || getSessionController().isPageAuthorized())){
			getSmtpService().send(
					getSessionController().getMailingListEntrIA(),
					getString("MAIL.ADMIN.OFFRE.SUJETAJOUT", getSessionController().getApplicationNameEntreprise(),this.formOffre.getStructure().printAdresse(), infoPersonne),
					getString("MAIL.ADMIN.OFFRE.MESSAGEAJOUT", getSessionController().getApplicationNameEntreprise(),this.formOffre.getIdOffre() +", "+this.formOffre.getIntitule(),getSessionController().getCurrentManageStructure().printAdresse(), infoPersonne),
					""
			);
		}
	}

	/* ***************************************************************
	 * Modification d'une offre
	 ****************************************************************/

	public void initVarsOffre(){
		this.etablissementController.reloadServices();
		this.etablissementController.reloadContacts();
	}

	/**
	 * @return String
	 */
	public String goToEntrepriseModificationOffre(){
		String ret=null;
		this.formOffre=(OffreDTO) this.currentOffre.clone();
		if(this.formOffre!=null){
			if(this.formOffre.isAvecFichier() || this.formOffre.isAvecLien()){
				this.avecFichierOuLien=true;
				if(this.formOffre.isAvecFichier()){
					this.fichierOuLien=1;
					if(this.currentOffre.getFichier()!=null){
						this.formOffre.setFichier((FichierDTO)this.currentOffre.getFichier().clone());
					}
				}
				else if(this.formOffre.isAvecLien())this.fichierOuLien=2;
			}else{
				this.avecFichierOuLien=false;
				this.fichierOuLien=0;
			}
			ret="modificationOffre";
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToModificationOffre(){
		String ret=null;
		if(this.currentOffre!=null){

			this.formOffre=(OffreDTO) this.currentOffre.clone();

			// Si l'on est cote depot en tant qu'entreprise
			if ("offre".equalsIgnoreCase(this.currentRecapOffre)) {
				this.retour = "recapitulatifOffre";
			} else {
				// Sinon on est dans l'un des 3 autres cas
				this.currentOffre = getOffreDomainService().getOffreFromId(this.currentOffre.getIdOffre());
				this.currentOffre.setStructure(getStructureDomainService().getStructureFromId(this.currentOffre.getIdStructure()));


				// Si l'on est dans le cas du recapitulatif d'offre cote stage avec etab
				if ("offreEtabCentre".equalsIgnoreCase(this.currentRecapOffre)) {
					// On conserve le squelette dans lequel on va revenir
					this.retour = "recapitulatifOffreEtabCentre";
					getSessionController().setCentreGestionRattachement(this.currentOffre.getCentreGestion());

					if (!isListeCurrentIdsCentresGestionContainsIdCGCurrentOffre()) {
						CentreGestionDTO c = getCentreGestionDomainService().getCentreGestion(this.currentOffre.getIdCentreGestion());
						if (c != null){
							this.currentOffre.setCentreGestion(c);
						} else {
							return ret;
						}
					} else {
						if (getSessionController().getCurrentIdsCentresGestion() != null &&
								!getSessionController().getCurrentIdsCentresGestion().isEmpty()) {
							for (CentreGestionDTO c : getSessionController().getCurrentCentresGestion()) {
								if (c.getIdCentreGestion() == this.currentOffre.getIdCentreGestion()) {
									this.currentOffre.setCentreGestion(c);
									break;
								}
							}
						}
					}
				} else {
					// On conserve le squelette dans lequel on va revenir
					this.retour = "recapitulatifOffreEtab";
				}
			}

			if(this.formOffre.isAvecFichier() || this.formOffre.isAvecLien()){
				this.avecFichierOuLien=true;
				if(this.formOffre.isAvecFichier()){
					this.fichierOuLien=1;
					if(this.currentOffre.getFichier()!=null){
						this.formOffre.setFichier((FichierDTO)this.currentOffre.getFichier().clone());
					}
				}
				else if(this.formOffre.isAvecLien())this.fichierOuLien=2;
			}else{
				this.avecFichierOuLien=false;
				this.fichierOuLien=0;
			}

			ret="modificationOffre";
		}
		return ret;
	}

	/**
	 * Vrai si currentIdsCentresGestion contains l'id du centre de gestion de l'offre courante : currentOffre
	 * Auquel cas modification possible du centre de gestion pour une offre
	 * @return boolean
	 */
	public boolean isListeCurrentIdsCentresGestionContainsIdCGCurrentOffre(){
		boolean ret=false;
		if(getSessionController().getCurrentIdsCentresGestion()!=null &&
				!getSessionController().getCurrentIdsCentresGestion().isEmpty() &&
				((ArrayList<Integer>)getSessionController().getCurrentIdsCentresGestion()).
						contains(this.currentOffre.getIdCentreGestion())){
			ret=true;
		}
		return ret;
	}

	/**
	 *
	 */
	public void goToModificationOffreModifEtab(){
		this.etablissementController.goToModificationEtablissement();
		getSessionController().setModificationOffreCurrentPage("_modificationOffreEtape05ModifEtab");
	}

	/**
	 *
	 */
	public void modifierOffreModifierEtablissement(){
		String ret=this.etablissementController.modifierEtablissement();

		this.currentOffre.setStructure(this.etablissementController.getFormStructure());
		FacesContext fc = FacesContext.getCurrentInstance();
		Iterator<FacesMessage> ifm = fc.getMessages("formModifEtab");
		while(ifm.hasNext()){
			FacesMessage fm = ifm.next();
			fc.addMessage("formModificationOffre:formModifEtab", new FacesMessage(FacesMessage.SEVERITY_ERROR,fm.getSummary(),fm.getDetail()));
			ifm.remove();
		}
		ifm = fc.getMessages("formAffEtab");
		while(ifm.hasNext()){
			FacesMessage fm = ifm.next();
			fc.addMessage("formModificationOffre:formAffEtab", new FacesMessage(fm.getSummary(),fm.getDetail()));
			ifm.remove();
		}

		if(StringUtils.hasText(ret)){
			getSessionController().setModificationOffreCurrentPage("_modificationOffreEtape04DetailsEtab");
		}

		//		return "";
	}

	/**
	 * @return String
	 */
	public void modificationOffreDetailsEtab(){

		this.formOffre.setCentreGestion(getCentreGestionDomainService().getCentreGestion(this.formOffre.getIdCentreGestion()));
		getSessionController().setCentreGestionRattachement(this.formOffre.getCentreGestion());

		this.modificationOffre();
	}


	/**
	 * Envoi vers l'Etape 2 : Saisie de l'offre
	 */
	public void goToModificationOffreEtape2(){
		getSessionController().setModificationOffreCurrentPage("_modificationOffreEtape2");
		if(this.formOffre.getIdLieuPays()<=0){
			this.formOffre.setLieuPays(this.formOffre.getStructure().getPays());
			if(getSessionController().isRecupererCommunesDepuisApogee() &&
					getBeanUtils().isFrance(this.formOffre.getLieuPays())){
				List<SelectItem> lTmp = majCommunes(""+this.formOffre.getLieuCodePostal());
				if(lTmp!=null && !lTmp.isEmpty()){
					this.formOffreCommunesListening=lTmp;
				}else{
					this.formOffreCommunesListening=new ArrayList<SelectItem>();
				}
			}
		}
		if(this.avecFichierOuLien){
			switch (this.fichierOuLien) {
				case 1:
					//Si l'offre modifiée était déjà avec fichier joint, on ne fait rien
					if(!this.currentOffre.isAvecFichier()){
						this.formOffre.setAvecFichier(true);
						this.formOffre.setAvecLien(false);
						this.formOffre.setLienAttache("");
						try {
							FichierDTO o = new FichierDTO();
							o.setNomFichier("");
							int idFichier = getOffreDomainService().addFichier(o);
							o.setIdFichier(idFichier);
							this.formOffre.setFichier(o);
							getSessionController().getOffreFileUploadBean().setPrefix(idFichier);
						} catch (DataAddException|WebServiceDataBaseException e) {
							logger.error(e);
						}
					}
					break;
				case 2:
					//Si l'offre modifiée était déjà avec lien, on ne fait rien
					if(!this.currentOffre.isAvecLien()){
						this.formOffre.setAvecFichier(false);
						this.formOffre.setAvecLien(true);
						this.formOffre.setLienAttache("http://");
					}
					break;
				default:
					getSessionController().setModificationOffreCurrentPage("_modificationOffreEtape1");
					break;
			}
		}
		this.formOffre.setIdTypeOffre(this.formOffre.getTypeOffre().getId());
		//Màj liste des contrats
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContratsOffreFromIdTypeOffre(this.formOffre.getIdTypeOffre());
		if(l!=null && !l.isEmpty()){
			this.contratsListening=new ArrayList<>();
			for(ContratOffreDTO c : l){
				this.contratsListening.add(new SelectItem(c,c.getLibelle()));
			}
		}else{
			this.contratsListening=null;
		}

		// Initialisations du temps travail et des modes candidature avec ceux deja saisis dans l'ob
		if (this.formOffre.getIdTempsTravail() != 0) {
			this.formOffre.setTempsTravail(getNomenclatureDomainService().getTempsTravailFromId(this.formOffre.getIdTempsTravail()));
		}
		if (this.formOffre.getIdsModeCandidature() != null && !this.formOffre.getIdsModeCandidature().isEmpty()){
			List<ModeCandidatureDTO> lmc = new ArrayList<>();
			for (Integer id : this.formOffre.getIdsModeCandidature()){
				lmc.add(getNomenclatureDomainService().getModeCandidatureFromId(id));
			}
			this.formOffre.setModesCandidature(lmc);
		}

		this.fapN3Listening=getFapN3FromNumQualif(this.formOffre.getIdQualificationSimplifiee());
		if(getSessionController().isRecupererCommunesDepuisApogee() &&
				getBeanUtils().isFrance(this.formOffre.getLieuPays())){
			List<SelectItem> lTmp = majCommunes(""+this.formOffre.getLieuCodePostal());
			if(lTmp!=null && !lTmp.isEmpty()){
				this.formOffreCommunesListening=lTmp;
			}else{
				this.formOffreCommunesListening=new ArrayList<SelectItem>();
			}
		}
	}


	/**
	 * Modification de l'offre 
	 */
	public void modificationOffre(){
		String ret=_modificationOffre();
		if(StringUtils.hasText(ret)){
			getSessionController().setModificationOffreCurrentPage(ret);
			this.currentOffre=(OffreDTO) this.formOffre.clone();
			if(this.formOffre.getFichier()!=null) this.currentOffre.setFichier((FichierDTO)(this.formOffre.getFichier().clone()));
			this.formOffre=null;
			if(this.listeOffres!=null && this.listeOffres.contains(this.currentOffre)){
				int id = this.listeOffres.indexOf(this.currentOffre);
				if(id>0){
					this.listeOffres.set(id,this.currentOffre);
				}
			}
			if(this.resultatsRechercheOffre!=null && this.resultatsRechercheOffre.contains(this.currentOffre)){
				//rechercherOffre();
				int id = this.resultatsRechercheOffre.indexOf(this.currentOffre);
				if(id>0){
					this.resultatsRechercheOffre.set(id,this.currentOffre);
					reloadRechercheOffrePaginator();
				}
			}
		}
		//		return ret;
	}

	/**
	 * Méthode modification de l'offre subDivisée en 2 pour gérer la modification par une entreprise et par un centre
	 * @return String
	 */
	public String _modificationOffre(){
		String ret=null;
		this.formOffre.setLoginModif(getSessionController().getCurrentLogin());
		if(this.formOffre.getLieuPays()!=null) {
			this.formOffre.setIdLieuPays(this.formOffre.getLieuPays().getId());

			if (getBeanUtils().isFrance(this.formOffre.getLieuPays()) && getSessionController().isRecupererCommunesDepuisApogee()) {
				if (!"0".equals(this.formOffre.getCodeCommune())) {
					//Récupération de la commune pour en avoir le libellé
					CommuneDTO c = getGeographieRepositoryDomain().getCommuneFromDepartementEtCodeCommune(this.formOffre.getLieuCodePostal(), "" + this.formOffre.getCodeCommune());
					if (c != null) {
						this.formOffre.setLieuCommune(c.getLibCommune());
					}
				}
			}
		}

		if(this.formOffre.getFapQualificationSimplifiee()!=null)this.formOffre.setIdQualificationSimplifiee(this.formOffre.getFapQualificationSimplifiee().getId());
		//if(this.formOffre.getFapN3()!=null)this.formOffre.setCodeFAP_N3(this.formOffre.getFapN3().getCode());
		if(this.formOffre.getFapN1()!=null)this.formOffre.setCodeFAP_N3(this.formOffre.getFapN1().getCode());
		if(this.formOffre.getTypeOffre()!=null)this.formOffre.setIdTypeOffre(this.formOffre.getTypeOffre().getId());
		else this.formOffre.setIdContratOffre(0);
		if(this.formOffre.getContratOffre()!=null)this.formOffre.setIdContratOffre(this.formOffre.getContratOffre().getId());
		else this.formOffre.setIdContratOffre(0);
		if(this.formOffre.getNiveauFormation()!=null)this.formOffre.setIdNiveauFormation(this.formOffre.getNiveauFormation().getId());
		else this.formOffre.setIdNiveauFormation(0);
		this.formOffre.setAnneeUniversitaire(getBeanUtils().getAnneeUniversitaireCourante(new Date()));
		if(this.avecFichierOuLien){
			this.formOffre.setTempsTravail(null);
			this.formOffre.setIdTempsTravail(0);
			this.formOffre.setUniteDuree(null);
			this.formOffre.setIdUniteDuree(0);
			this.formOffre.setModesCandidature(null);
			this.formOffre.setIdsModeCandidature(null);

			this.formOffre.setContactCand(null);
			this.formOffre.setContactInfo(null);
			this.formOffre.setIdContactCand(0);
			this.formOffre.setIdContactInfo(0);
			switch (this.fichierOuLien) {
				case 1:
					if(this.formOffre.getIdFichier()>0){
						try{
							this.formOffre.setAvecFichier(true);
							this.formOffre.setAvecLien(false);
							this.formOffre.setLienAttache(null);
							getOffreDomainService().updateOffre(this.formOffre);
							this.formOffre.setDateModif(new Date());
							this.formOffre.setLoginModif(getSessionController().getCurrentLogin());
							//Maj listes
							if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.formOffre)){
								this.listeOffres.set(this.listeOffres.indexOf(this.formOffre), this.formOffre);
							}
							if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.formOffre)){
								this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.formOffre), this.formOffre);
								checkListeResultats();
							}
							ret="_modificationOffreEtape4Confirmation";
							addInfoMessage(null, "OFFRE.MODIFICATION.CONFIRMATION", this.formOffre.getIdOffre());
							mailModif();
						}catch (DataAddException|WebServiceDataBaseException e) {
							logger.error(e);
						}
					}else{
						addErrorMessage("formModificationOffre:opUploadFile:uploadFile", "OFFRE.SELECTIONFICHIER.OBLIGATOIRE");
						return null;
					}
					break;
				case 2:
					try{
						this.formOffre.setFichier(null);
						this.formOffre.setIdFichier(0);
						this.formOffre.setAvecFichier(false);
						this.formOffre.setAvecLien(true);
						getOffreDomainService().updateOffre(this.formOffre);
						this.formOffre.setDateModif(new Date());
						this.formOffre.setLoginModif(getSessionController().getCurrentLogin());
						//Maj listes
						if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.formOffre)){
							this.listeOffres.set(this.listeOffres.indexOf(this.formOffre), this.formOffre);
						}
						if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.formOffre)){
							this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.formOffre), this.formOffre);
							checkListeResultats();
						}
						//Suppression de l'ancien fichier
						if(this.currentOffre.isAvecFichier() &&
								this.currentOffre.getIdFichier()>0){
							try{
								if(this.currentOffre.getFichier()!=null
										&& StringUtils.hasText(this.currentOffre.getFichier().getNomFichier())){
									getSessionController().getOffreFileUploadBean().deleteFileFromDirectory(
											this.currentOffre.getIdFichier(), this.currentOffre.getFichier().getNomFichier());
								}
								getOffreDomainService().deleteFichier(this.currentOffre.getIdFichier());
							}catch (DataDeleteException|WebServiceDataBaseException e) {
								logger.warn(e);
							}
						}
						mailModif();
						ret="_modificationOffreEtape4Confirmation";
						addInfoMessage(null, "OFFRE.MODIFICATION.CONFIRMATION", this.formOffre.getIdOffre());
					}catch (DataAddException|WebServiceDataBaseException e) {
						logger.error(e);
						addErrorMessage(null, "OFFRE.MODIFICATION.ERREURAJOUT");
						return null;
					}
					break;
			}
		}else{

			this.formOffre.setFichier(null);
			this.formOffre.setIdFichier(0);
			this.formOffre.setLienAttache(null);
			this.formOffre.setAvecFichier(false);
			this.formOffre.setAvecLien(false);

			if(this.formOffre.getTempsTravail()!=null)this.formOffre.setIdTempsTravail(this.formOffre.getTempsTravail().getId());
			else this.formOffre.setIdTempsTravail(0);
			if(this.formOffre.getUniteDuree()!=null)this.formOffre.setIdUniteDuree(this.formOffre.getUniteDuree().getId());
			else this.formOffre.setIdUniteDuree(0);
			if(this.formOffre.getModesCandidature()!=null){
				ArrayList<Integer> l = new ArrayList<Integer>();
				for(ModeCandidatureDTO m : this.formOffre.getModesCandidature()){
					l.add(m.getId());
				}
				if(!l.isEmpty())this.formOffre.setIdsModeCandidature(l);
				else this.formOffre.setIdsModeCandidature(null);
			}
			if(this.formOffre.getContactCand()!=null){
				try{
					this.formOffre.setIdContactCand(this.formOffre.getContactCand().getId());
					if(this.formOffre.getContactInfo()!=null){
						this.formOffre.setIdContactInfo(this.formOffre.getContactInfo().getId());
					} else {
						this.formOffre.setIdContactInfo(0);
					}
					this.formOffre.setFichier(null);
					this.formOffre.setIdFichier(0);
					if(getOffreDomainService().updateOffre(this.formOffre)){
						this.formOffre.setDateModif(new Date());
						this.formOffre.setLoginModif(getSessionController().getCurrentLogin());
						//Maj listes
						if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.formOffre)){
							this.listeOffres.set(this.listeOffres.indexOf(this.formOffre), this.formOffre);
						}
						if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.formOffre)){
							this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.formOffre), this.formOffre);
							checkListeResultats();
						}
						//Suppression de l'ancien fichier
						if(this.currentOffre.isAvecFichier() &&
								this.currentOffre.getIdFichier()>0){
							try{
								if(this.currentOffre.getFichier()!=null
										&& StringUtils.hasText(this.currentOffre.getFichier().getNomFichier())){
									getSessionController().getOffreFileUploadBean().deleteFileFromDirectory(
											this.currentOffre.getIdFichier(), this.currentOffre.getFichier().getNomFichier());
								}
								getOffreDomainService().deleteFichier(this.currentOffre.getIdFichier());
							}catch (DataDeleteException|WebServiceDataBaseException e) {
								logger.warn(e);
							}
						}
					}
					ret="_modificationOffreEtape4Confirmation";
					addInfoMessage(null, "OFFRE.MODIFICATION.CONFIRMATION", this.formOffre.getIdOffre());
					mailModif();
				}catch (DataUpdateException|WebServiceDataBaseException e) {
//					ret="_modificationOffreEtape4Confirmation";
					logger.error(e);
					addErrorMessage(null, "OFFRE.MODIFICATION.ERREURMODIF");
					return null;
				}
			}else{
				addErrorMessage("formModificationOffre:contactCand", "OFFRE.SELECTIONCONTACTCAND.OBLIGATOIRE");
				return null;
			}
		}

		return ret;
	}

	/**
	 *
	 */
	public void mailModif(){
		if(getSessionController().isMailingListEntrMailAvertissementModifOffre() && StringUtils.hasText(getSessionController().getMailingListEntr())
				&& (getSessionController().isAdminPageAuthorized() || getSessionController().isPageAuthorized())){
			//Envoi mail sur la mailing list entreprise
			String infoPersonne="";
			if(getSessionController().isAdminPageAuthorized() && getSessionController().getCurrentAuthAdminStructure()!=null){
				infoPersonne+=getSessionController().getCurrentAuthAdminStructure().getNom()+" "+getSessionController().getCurrentAuthAdminStructure().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
			}else if(getSessionController().isPageAuthorized() && getSessionController().getCurrentAuthContact()!=null){
				infoPersonne+=getSessionController().getCurrentAuthContact().getNom()+" "+getSessionController().getCurrentAuthContact().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
			}else{
				infoPersonne+=getSessionController().getCurrentLogin();
			}
			getSmtpService().send(
					getSessionController().getMailingListEntrIA(),
					getString("MAIL.ADMIN.OFFRE.SUJETMODIF", getSessionController().getApplicationNameEntreprise(),this.formOffre.getIdOffre() +", "+this.formOffre.getIntitule(), infoPersonne),
					getString("MAIL.ADMIN.OFFRE.MESSAGEMODIF", getSessionController().getApplicationNameEntreprise(),this.formOffre.getIdOffre() +", "+this.formOffre.getIntitule(),this.formOffre.getStructure().printAdresse(), infoPersonne),
					""
			);
		}
	}

	/**
	 * Suppression d'une offre
	 */
	public void supprimerOffre(){
		try{
			getSessionController().setSuppressionOffreCurrentPage("_confirmationDialog");
			if(getOffreDomainService().deleteOffreLogique(this.currentOffre.getIdOffre())){
				//Maj listes
				if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.currentOffre)){
					this.listeOffres.remove(this.listeOffres.indexOf(this.currentOffre));
				}
				if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.currentOffre)){
					this.resultatsRechercheOffre.remove(this.resultatsRechercheOffre.indexOf(this.currentOffre));
					checkListeResultats();
				}
				mailSuppr();
				this.currentOffre=null;
			}
			addInfoMessage(null, "OFFRE.SUPPR.CONFIRMATION");
		}catch (DataUpdateException|WebServiceDataBaseException e) {
			logger.error(e);
			addErrorMessage(null, "OFFRE.SUPPR.ERREUR");
		}
	}

	/**
	 *
	 */
	public void mailSuppr(){
		if(getSessionController().isMailingListEntrMailAvertissementSupprOffre() && StringUtils.hasText(getSessionController().getMailingListEntr())
				&& (getSessionController().isAdminPageAuthorized() || getSessionController().isPageAuthorized())){
			//Envoi mail sur la mailing list entreprise
			String infoPersonne="";
			if(getSessionController().isAdminPageAuthorized() && getSessionController().getCurrentAuthAdminStructure()!=null){
				infoPersonne+=getSessionController().getCurrentAuthAdminStructure().getNom()+" "+getSessionController().getCurrentAuthAdminStructure().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
			}else if(getSessionController().isPageAuthorized() && getSessionController().getCurrentAuthContact()!=null){
				infoPersonne+=getSessionController().getCurrentAuthContact().getNom()+" "+getSessionController().getCurrentAuthContact().getPrenom()+" ("+getSessionController().getCurrentLogin()+")";
			}else{
				infoPersonne+=getSessionController().getCurrentLogin();
			}
			getSmtpService().send(
					getSessionController().getMailingListEntrIA(),
					getString("MAIL.ADMIN.OFFRE.SUJETSUPPR", getSessionController().getApplicationNameEntreprise(),this.currentOffre.getIdOffre() +", "+this.currentOffre.getIntitule(), infoPersonne),
					getString("MAIL.ADMIN.OFFRE.MESSAGESUPPR", getSessionController().getApplicationNameEntreprise(),this.currentOffre.getIdOffre() +", "+this.currentOffre.getIntitule(),getSessionController().getCurrentManageStructure().printAdresse(), infoPersonne),
					""
			);
		}
	}

	@SuppressWarnings("unused")
	private boolean ciblageInterdit;

	public boolean isCiblageInterdit(){
		if (this.currentOffre != null){
			CentreGestionDTO cgEntr = getCentreGestionDomainService().getCentreEntreprise();
			if (cgEntr != null
					&& this.currentOffre.getIdCentreGestion() == cgEntr.getIdCentreGestion()
					&& getSessionController().getCurrentAuthPersonnel() != null
					&& !getSessionController().isPageAuthorized()
					&& !getSessionController().isAdminPageAuthorized()
					&& !getSessionController().isSuperAdminPageAuthorized()){
				return true;
			}
		}
		return false;
	}

	/**
	 * @return String
	 */
	public void diffuserOffre(){
		getSessionController().setDiffusionOffreCurrentPage("_confirmationDialog");
		if(this.currentOffre!=null && this.currentOffre.getIdOffre()>0){
			try{
				int x = (this.dureeDiffusion - 1);

				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
				int annee = Integer.parseInt(dateFormat.format(new Date()).split("/")[2]);
				int mois = Integer.parseInt(dateFormat.format(new Date()).split("/")[1]);
				int jour = Integer.parseInt(dateFormat.format(new Date()).split("/")[0]);

				// date du jour + x mois selon la DureeDiffusion choisie
				if ((mois+x) < 12){
					mois = mois + x;
				} else if((mois+x) > 12 && (mois+x) < 24){
					mois = mois + x - 12;
					annee = annee + 1;
				} else {
					mois = mois + x - 24;
					annee = annee + 2;
				}

				gc.set(annee,mois,jour);
				getOffreDomainService().updateDiffusionOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin(),gc.getTime());

				getOffreDomainService().updateValidationOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin());
				addInfoMessage(null, "OFFRE.GESTION.DIFFUSION.CONFIRMATION");
				getOffreDomainService().updateOffrePourvue(this.currentOffre.getIdOffre(), false);

				if (getSessionController().isModerationActive() && getSessionController().isAvertissementEntrepriseDiffusion()){

					String text=getString("ALERTES_MAIL.AVERTISSEMENT_ENTREPRISE_DIFFUSION",this.currentOffre.getIdOffre());

					String sujet=getString("ALERTES_MAIL.AVERTISSEMENT_ENTREPRISE_DIFFUSION.SUJET",this.currentOffre.getIdOffre());

					if (this.currentOffre.isAvecFichier() || this.currentOffre.isAvecLien()){
						// Il est necessaire de verifier d'abord si un fichier/lien est present car dans ce cas il n'y aura pas de contact
						// et donc pas de mail envoyé
					} else {
						if (this.currentOffre.getContactCand()!= null && this.currentOffre.getContactCand().getMail() != null
								&& !this.currentOffre.getContactCand().getMail().isEmpty()){
							getSmtpService().send(new InternetAddress(this.currentOffre.getContactCand().getMail()),
									sujet,text,text);
						} else {
							addErrorMessage(null, "OFFRE.GESTION.DIFFUSION.ALERTE.ERREUR_MAIL");
						}
					}
				}

				//Màj de l'objet courant
				this.currentOffre.setEstPourvue(false);
				this.currentOffre.setEstDiffusee(true);
				this.currentOffre.setDateDiffusion(new Date());
				this.currentOffre.setDateFinDiffusion(gc.getTime());
				this.currentOffre.setEstValidee(true);
				this.currentOffre.setEtatValidation(1);
				//Maj listes
				if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.currentOffre)){
					this.listeOffres.set(this.listeOffres.indexOf(this.currentOffre), this.currentOffre);
				}
				if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.currentOffre)){
					this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.currentOffre), this.currentOffre);
					checkListeResultats();
				}
			}catch (DataUpdateException|WebServiceDataBaseException e) {
				logger.error(e);
				addErrorMessage(null, "OFFRE.GESTION.DIFFUSION.ERREUR");
			}catch (AddressException ade){
				logger.error("AddressException", ade);
				addErrorMessage(null, "GENERAL.ERREUR_MAIL");
			}
		}
		//		return ret;
	}

	/**
	 * Arrêt de la diffusion de l'offre actuellement sélectionnée
	 */
	public void stopDiffusionOffre(){
		getSessionController().setStopDiffusionOffreCurrentPage("_confirmationDialog");
		if(this.currentOffre!=null){
			try{
				getOffreDomainService().updateStopDiffusionOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin());
				getOffreDomainService().updateStopValidationOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin());
				addInfoMessage(null, "OFFRE.GESTION.STOPDIFFUSION.CONFIRMATION");
				//Màj de l'objet courant
				this.currentOffre.setDateDiffusion(null);
				this.currentOffre.setDateFinDiffusion(null);
				this.currentOffre.setEstDiffusee(false);
				this.currentOffre.setEstValidee(false);
				this.currentOffre.setEtatValidation(0);
				//Maj listes
				if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.currentOffre)){
					this.listeOffres.set(this.listeOffres.indexOf(this.currentOffre), this.currentOffre);
				}
				if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.currentOffre)){
					this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.currentOffre), this.currentOffre);
					checkListeResultats();
				}
			}catch (DataUpdateException|WebServiceDataBaseException e) {
				logger.error(e);
				addErrorMessage(null, "OFFRE.GESTION.STOPDIFFUSION.ERREUR");
			}
		}
		//		return ret;
	}

	/**
	 * Indiquer l'offre comme pourvue
	 */
	public void offrePourvue(){
		getSessionController().setOffrePourvueCurrentPage("_confirmationDialog");
		if(this.currentOffre!=null){
			try{
				getOffreDomainService().updateOffrePourvue(this.currentOffre.getIdOffre(), !this.currentOffre.isEstPourvue());
				getOffreDomainService().updateStopDiffusionOffre(this.currentOffre.getIdOffre(), getSessionController().getCurrentLogin());

				//M�j de l'objet courant
				this.currentOffre.setEstPourvue(!this.currentOffre.isEstPourvue());
				this.currentOffre.setDateDiffusion(null);
				this.currentOffre.setDateFinDiffusion(null);
				this.currentOffre.setEstDiffusee(false);
				this.currentOffre.setEstValidee(false);
				this.currentOffre.setEtatValidation(0);
				//Maj listes
				if(this.listeOffres!=null && ((ArrayList<OffreDTO>)this.listeOffres).contains(this.currentOffre)){
					this.listeOffres.set(this.listeOffres.indexOf(this.currentOffre), this.currentOffre);
				}
				if(this.resultatsRechercheOffre!=null && ((ArrayList<OffreDTO>)this.resultatsRechercheOffre).contains(this.currentOffre)){
					this.resultatsRechercheOffre.set(this.resultatsRechercheOffre.indexOf(this.currentOffre), this.currentOffre);
					checkListeResultats();
				}
				if(this.currentOffre.isEstPourvue())addInfoMessage(null, "OFFRE.GESTION.POURVOIROFFRE.CONFIRMATION");
				if(!this.currentOffre.isEstPourvue())addInfoMessage(null, "OFFRE.GESTION.POURVOIROFFRE.CONFIRMATIONNON");
			}catch (DataUpdateException|WebServiceDataBaseException e) {
				logger.error(e);
				addErrorMessage(null, "OFFRE.GESTION.POURVOIROFFRE.ERREUR");
			}
		}
		//		return ret;
	}

	/**
	 * @return int : nombre d'éléments dans la liste offresDiffusion du currentOffre
	 */
	public int getCurrentOffreSizeOffresDiffusion(){
		currentOffreSizeOffresDiffusion = 0;
		if(this.currentOffre!=null && this.currentOffre.getOffresDiffusion()!=null){
			currentOffreSizeOffresDiffusion=this.currentOffre.getOffresDiffusion().size();
		}
		return currentOffreSizeOffresDiffusion;
	}

	/**
	 * @param l
	 * @param id
	 * @return SelectItem
	 */
	public SelectItem containsSelectItem(List<SelectItem> l, int id){
		if(l!=null && !l.isEmpty()){
			for(SelectItem si : l){
				if(si.getValue() instanceof Integer){
					if((Integer)(si.getValue())==id){
						return si;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Maj des listes pour le panel de diffusion
	 */
	public void majListesCentresDiffusion(){
		if(this.currentOffre!=null){
			this.dualListCiblageCentres = new DualListModel<>(new ArrayList<CentreGestionDTO>(),new ArrayList<CentreGestionDTO>());
			if(this.currentOffre.getOffresDiffusion()!=null && !this.currentOffre.getOffresDiffusion().isEmpty()){
				for(OffreDiffusionDTO od : this.currentOffre.getOffresDiffusion()){
					this.dualListCiblageCentres.getTarget().add(getCentreGestionDomainService().getCentreGestion(od.getIdCentreGestion()));
				}
			}
			if(this.listesCentresGestionEtablissement==null || this.listesCentresGestionEtablissement.isEmpty()){
				getListesCentresGestionEtablissement();
			}
			if(!this.listesCentresGestionEtablissement.isEmpty()){
				int id =(Integer) this.listesCentresGestionEtablissement.get(0).getValue();
				this.idCentreEtablissementSelect=id;
				if(this.listesCentresGestionEtablissement.size()>1){
					id=(Integer) this.listesCentresGestionEtablissement.get(1).getValue();
					if(id>0){
						this.idCentreEtablissementSelect=id;
					}
				}
				if(id>0){
					List<CentreGestionDTO> l = getCentreGestionDomainService().getCentreGestionList(
							getSessionController().getCodeUniversite());
					if(l!=null && !l.isEmpty()){
						this.dualListCiblageCentres.setSource(new ArrayList<CentreGestionDTO>());
						for(CentreGestionDTO cg : l){
							if(cg.getIdCentreGestion()!=id){
								// Si la liste des centres selectionnes ne contient pas le centre, on l'ajoute a la liste proposee
								if(!this.dualListCiblageCentres.getTarget().contains(cg)){
									this.dualListCiblageCentres.getSource().add(cg);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Action de diffusion de l'offre aux centres sélectionnés
	 */
	public void diffusionCentreOffre(){

		getSessionController().setDiffusionCentreOffreCurrentPage("_confirmationDialog");

		if(this.currentOffre!=null){
			if(this.idCentreEtablissementSelect==0 || this.dualListCiblageCentres.getTarget()==null
					|| this.dualListCiblageCentres.getTarget().isEmpty()){
				try{
					if(getOffreDomainService().deleteOffreDiffusionFromId(this.currentOffre.getIdOffre())){
						this.currentOffre.setOffresDiffusion(null);
						addInfoMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.CONFIRMATION");
					}
				}catch (DataDeleteException|WebServiceDataBaseException|DataAddException e) {
					logger.error(e);
					addErrorMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.ERREUR");
				}
			} else if(this.dualListCiblageCentres.getTarget()!=null
					&& !this.dualListCiblageCentres.getTarget().isEmpty()){
				List<OffreDiffusionDTO> l = new ArrayList<OffreDiffusionDTO>();
				for(CentreGestionDTO centre : this.dualListCiblageCentres.getTarget()){
					OffreDiffusionDTO od = new OffreDiffusionDTO();
					od.setIdCentreGestion(centre.getIdCentreGestion());
					od.setIdOffre(this.currentOffre.getIdOffre());
					od.setNomCentre(centre.getNomCentre());
					l.add(od);
				}
				this.currentOffre.setOffresDiffusion(l);
				try{
					getOffreDomainService().addOffreDiffusion(l);
					addInfoMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.CONFIRMATION");
				}catch (DataDeleteException|WebServiceDataBaseException|DataAddException e) {
					logger.error(e);
					addErrorMessage(null, "OFFRE.GESTION.DIFFUSIONCENTRE.ERREUR");
				}
			}
		}
	}

	/**
	 * Transfert d'une offre au centre entreprise avec contacts
	 * @return String
	 */
	public void transfererOffre(){
		getSessionController().setTransfertOffreCurrentPage("_confirmationDialog");
		if(this.currentOffre!=null){
			try{
				CentreGestionDTO cgEntr = getCentreGestionDomainService().getCentreEntreprise();
				if(cgEntr!=null){
					this.currentOffre.setIdCentreGestion(cgEntr.getIdCentreGestion());
					this.currentOffre.setCentreGestion(cgEntr);
					getOffreDomainService().updateOffre(this.currentOffre);
					if(this.currentOffre.getIdContactCand()>0){
						if(this.currentOffre.getContactCand()!=null){
							this.currentOffre.getContactCand().setIdCentreGestion(cgEntr.getIdCentreGestion());
							getStructureDomainService().updateContact(this.currentOffre.getContactCand());
						}
					}
					if(this.currentOffre.getIdContactInfo()>0){
						if(this.currentOffre.getContactInfo()!=null){
							this.currentOffre.getContactInfo().setIdCentreGestion(cgEntr.getIdCentreGestion());
							getStructureDomainService().updateContact(this.currentOffre.getContactInfo());
						}
					}
				}
				addInfoMessage(null, "OFFRE.GESTION.TRANSFERT.CONFIRMATION");
			}catch (DataUpdateException e) {
				logger.error(e);
				addErrorMessage(null, "OFFRE.GESTION.TRANSFERT.ERREUR");
			}catch (WebServiceDataBaseException e) {
				logger.error(e);
				addErrorMessage(null, "OFFRE.GESTION.TRANSFERT.ERREUR");
			}catch (Exception e) {
				logger.error(e);
				addErrorMessage(null, "OFFRE.GESTION.TRANSFERT.ERREUR");
			}
		}
		//		return ret;
	}

	/**
	 * Page de retour lors de la modif ou suppression
	 * @return String
	 */
	public String retourTo(){
		return getRetour();
	}

	/**
	 * Vers moteur de recherche offre (entreprise)
	 * @return String
	 */
	public String goToRechercheOffre(){
		String ret="rechercheOffre";
		if(this.critereRechercheOffre==null) this.critereRechercheOffre=initCritereRechercheOffre();
		return ret;
	}

	/**
	 * Vers moteur de recherche offre (stage)
	 * @return String
	 */
	public String goToRechercheOffreStage(){
		String ret="rechercheOffreStage";
		if(this.critereRechercheOffre==null)this.critereRechercheOffre=initCritereRechercheOffre();
//		resetRechercheOffre();
		return ret;
	}

	/**
	 * Vers moteur de recherche offre public (entreprise)
	 * @return String
	 */
	public String goToRechercheOffrePublic(){
		String ret="rechercheOffrePublic";
		if(this.critereRechercheOffre==null)this.critereRechercheOffre=initCritereRechercheOffre();
		return ret;
	}

	/**
	 * initCritereRechercheOffre
	 * @return CritereRechercheOffreDTO
	 */
	public CritereRechercheOffreDTO initCritereRechercheOffre(){
		CritereRechercheOffreDTO c;

		c = new CritereRechercheOffreDTO();
		c.setLieuPays(null);

		return c;
	}

	/**
	 * @return String
	 */
	public String rechercherOffrePublic(){
		String ret;
		if(this.critereRechercheOffre==null) this.critereRechercheOffre=initCritereRechercheOffre();
		if(getSessionController().getCurrentCentresGestion()==null
				|| getSessionController().getCurrentCentresGestion().isEmpty()){
			CentreGestionDTO cgEntr=getCentreGestionDomainService().getCentreEntreprise();
			ArrayList<CentreGestionDTO> lcg = new ArrayList<CentreGestionDTO>();
			lcg.add(cgEntr);
			getSessionController().setCurrentCentresGestion(lcg);
		}
		ret=rechercherOffre();
		return ret;
	}

	/**
	 * Recherche des offres
	 * @return String
	 */
	public String rechercherOffre(){
		String ret="resultatsRechercheOffre";
		// Si on est partie entreprise
		if (getSessionController().isAdminPageAuthorized()){
			List<CentreGestionDTO> l = getCentreGestionDomainService().getCentreFromUid(getSessionController().getCurrentAuthAdminStructure().getLogin(),
					getSessionController().getCodeUniversite());
			l.add(getCentreGestionDomainService().getCentreEntreprise());
			getSessionController().setCurrentCentresGestion(l);
		}

		List<Integer> idCG = getSessionController().getCurrentIdsCentresGestion();

		if (idCG == null) idCG = new ArrayList<>();

		boolean trouveCGEtab = false;
		//		if(getSessionController().getCurrentAuthEtudiant()!=null){
		CentreGestionDTO cgEtab = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite());
		if(cgEtab!=null && cgEtab.getIdCentreGestion()>0){
			if (!idCG.isEmpty()){
				for (Integer intCG : idCG) {
					if (intCG.equals(cgEtab.getIdCentreGestion())) {
						trouveCGEtab = true;
					}
				}
			}
			if (!trouveCGEtab) {
				idCG.add(cgEtab.getIdCentreGestion());
			}
		}
		//		}
		this.critereRechercheOffre.setIdsCentreGestion(idCG);
		if(StringUtils.hasText(this.rechTypeOuContrat)){
			if(this.rechTypeOuContrat.contains("t")){
				if(Utils.isNumber(this.rechTypeOuContrat.substring(1))){
					this.critereRechercheOffre.setTypeOffre(getNomenclatureDomainService().getTypeOffreFromId(
							Utils.convertStringToInt(this.rechTypeOuContrat.substring(1))));
					this.critereRechercheOffre.setContratOffre(null);
				}
			}
			if(this.rechTypeOuContrat.contains("c")){
				if(Utils.isNumber(this.rechTypeOuContrat.substring(1))){
					this.critereRechercheOffre.setContratOffre(getNomenclatureDomainService().getContratOffreFromId(
							Utils.convertStringToInt(this.rechTypeOuContrat.substring(1))));
					if(this.critereRechercheOffre.getContratOffre()!=null &&
							this.critereRechercheOffre.getContratOffre().getIdParent()>0){
						this.critereRechercheOffre.setTypeOffre(getNomenclatureDomainService().getTypeOffreFromId(
								this.critereRechercheOffre.getContratOffre().getIdParent()));
					}
				}
			}
		}else{
			this.critereRechercheOffre.setTypeOffre(null);
			this.critereRechercheOffre.setContratOffre(null);
		}
		if(this.critereRechercheOffre.isEstPrioERQTH()){
			this.critereRechercheOffre.setEstAccessERQTH(false);
		}
		if(getSessionController().isPageAuthorized() || getSessionController().isAdminPageAuthorized()){
			this.critereRechercheOffre.setInclureOffresEntreprise(true);
		}
		this.critereRechercheOffre.setEstFrance(false);
		if(this.critereRechercheOffre.getLieuPays()!=null
				&& this.critereRechercheOffre.getLieuPays().getId()!=0
				&& getBeanUtils()!=null
				&& getBeanUtils().isFranceRecherche(this.critereRechercheOffre.getLieuPays())){
			this.critereRechercheOffre.setLieuPays(getBeanUtils().getFrance());
			if (getBeanUtils().isFranceRecherche(this.critereRechercheOffre.getLieuPays())) {
				this.critereRechercheOffre.setEstFrance(true);
			}
		}
		this.resultatsRechercheOffre = getOffreDomainService().getOffresFromCriteres(this.critereRechercheOffre);
		if(!checkListeResultats()){
			ret=null;
		}
		return ret;
	}
	/**
	 * Passage du moteur simple à avancé et vice-versa
	 */
	public void rechercheSimpleAvancee(){
		if(this.rechercheAvancee) {
			this.rechercheAvancee = false;
		} else {
			this.rechercheAvancee=true;
		}
		resetRechercheOffre();
	}

	/**
	 * Reset des criteres de recherche d'offres
	 */
	public void resetRechercheOffre(){
		this.critereRechercheOffre=initCritereRechercheOffre();
		this.rechTypeOuContrat=null;
	}

	/**
	 * Re-chargement du paginator 
	 */
	public void reloadRechercheOffrePaginator(){
		this.rechercheOffrePaginator.reset();
		this.rechercheOffrePaginator.setListe(this.resultatsRechercheOffre);
		this.rechercheOffrePaginator.forceReload();
	}

	/**
	 * Contrôle la liste des résultats
	 * @return boolean : vrai si resultats
	 */
	private boolean checkListeResultats(){
		boolean ret=true;
		if(this.resultatsRechercheOffre==null || this.resultatsRechercheOffre.isEmpty()){
			this.resultatsRechercheOffre=null;
			ret=false;
			addInfoMessage("formRechOffre", "RECHERCHEOFFRE.AUCUNRESULTAT");
		}else if(this.resultatsRechercheOffre!=null && !this.resultatsRechercheOffre.isEmpty()){
			reloadRechercheOffrePaginator();
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToRecapitulatifOffrePostCreation(){
		if ("creationOffre".equalsIgnoreCase(this.creationOffre)){
			return this.goToRecapitulatifOffre();
		} else if ("creationCentreEtabOffre".equalsIgnoreCase(this.creationOffre)){
			return this.goToRecapitulatifOffreFromOffreLightAvecCentre();
		} else {
			return null;
		}
	}

	/**
	 * @return String
	 */
	public String goToRecapitulatifOffre(){
		String ret=null;
		if(this.currentOffre!=null){
			ret="recapitulatifOffre";
			this.currentRecapOffre = "offre";
			this.currentOffre.setOffresDiffusion(getOffreDomainService().getOffreDiffusionFromIdOffre(this.currentOffre.getIdOffre()));
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToRecapitulatifOffreFromOffreLight(){
		String ret=null;
		if(this.currentOffre!=null){
			this.currentOffre=getOffreDomainService().getOffreFromId(this.currentOffre.getIdOffre());
			this.currentOffre.setStructure(getStructureDomainService().getStructureFromId(this.currentOffre.getIdStructure()));
			this.currentOffre.setOffresDiffusion(getOffreDomainService().getOffreDiffusionFromIdOffre(this.currentOffre.getIdOffre()));
			ret="recapitulatifOffreEtab";
			this.currentRecapOffre = "offreEtab";
		}
		return ret;
	}
	/**
	 * @return String
	 */
	public String goToRecapitulatifOffreFromOffreLightAvecCentre(){
		String ret=null;
		if(this.currentOffre!=null){
			this.currentOffre=getOffreDomainService().getOffreFromId(this.currentOffre.getIdOffre());
			this.currentOffre.setStructure(getStructureDomainService().getStructureFromId(this.currentOffre.getIdStructure()));
			getSessionController().setCurrentManageStructure(this.currentOffre.getStructure());
			this.etablissementController.loadContactsServices();
			this.currentOffre.setOffresDiffusion(getOffreDomainService().getOffreDiffusionFromIdOffre(this.currentOffre.getIdOffre()));
			this.majListesCentresDiffusion();

			// Assignation du centre de l'offre
			if(!isListeCurrentIdsCentresGestionContainsIdCGCurrentOffre()){
				CentreGestionDTO c = getCentreGestionDomainService().getCentreGestion(this.currentOffre.getIdCentreGestion());
				if(c!=null)this.currentOffre.setCentreGestion(c);
				else return ret;
			}else{
				if(getSessionController().getCurrentIdsCentresGestion()!=null &&
						!getSessionController().getCurrentIdsCentresGestion().isEmpty()){
					for(CentreGestionDTO c : getSessionController().getCurrentCentresGestion()){
						if(c.getIdCentreGestion()==this.currentOffre.getIdCentreGestion()){
							this.currentOffre.setCentreGestion(c);
							break;
						}
					}
				}
			}

			ret="recapitulatifOffreEtabCentre";
			this.currentRecapOffre = "offreEtabCentre";
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToRecapitulatifOffrePublic(){
		String ret=null;
		if(this.currentOffre!=null){
			this.currentOffre=getOffreDomainService().getOffreFromId(this.currentOffre.getIdOffre());
			this.currentOffre.setStructure(getStructureDomainService().getStructureFromId(this.currentOffre.getIdStructure()));
			this.etablissementController.loadContactsServices();
			this.currentOffre.setOffresDiffusion(getOffreDomainService().getOffreDiffusionFromIdOffre(this.currentOffre.getIdOffre()));
			ret="recapitulatifOffreEtab";
			this.currentRecapOffre = "offreEtab";
		}
		return ret;
	}


	/**
	 * @param idOffre
	 * @return String
	 */
	public String goToOffreEtudiant(Integer idOffre){
		String ret="recapitulatifOffreEtab";
		this.currentRecapOffre = "offreEtab";
		this.currentOffre=null;
		OffreDTO oTmp=getOffreDomainService().getOffreFromId(idOffre);
		if(oTmp!=null){
			CentreGestionDTO cgEntr = getCentreGestionDomainService().getCentreEntreprise();
			if(getSessionController().getCurrentIdsCentresGestion()==null){
				getSessionController().setCurrentCentresGestion(new ArrayList<CentreGestionDTO>());
				getSessionController().getCurrentCentresGestion().add(cgEntr);
			}else if(!getSessionController().getCurrentIdsCentresGestion().contains(cgEntr.getIdCentreGestion())){
				getSessionController().getCurrentCentresGestion().add(cgEntr);
			}
			if(getSessionController().getCurrentIdsCentresGestion()!=null
					&& getSessionController().getCurrentIdsCentresGestion().contains(oTmp.getIdCentreGestion())){
				this.currentOffre=oTmp;
				goToRecapitulatifOffreFromOffreLight();
			}
		}
		return ret;
	}

	/**
	 * @param idOffreC
	 * @return String
	 */
	public String goToOffreEtudiantAvecCentre(Integer idOffreC){
		String ret="recapitulatifOffreEtabCentre";
		this.currentRecapOffre = "offreEtabCentre";
		this.currentOffre=null;
		OffreDTO oTmp=getOffreDomainService().getOffreFromId(idOffreC);
		if(oTmp!=null){
			CentreGestionDTO cgEntr = getCentreGestionDomainService().getCentreEntreprise();
			if(getSessionController().getCurrentIdsCentresGestion()==null){
				getSessionController().setCurrentCentresGestion(new ArrayList<CentreGestionDTO>());
				getSessionController().getCurrentCentresGestion().add(cgEntr);
			}else if(!getSessionController().getCurrentIdsCentresGestion().contains(cgEntr.getIdCentreGestion())){
				getSessionController().getCurrentCentresGestion().add(cgEntr);
			}
			if(getSessionController().getCurrentIdsCentresGestion()!=null
					&& getSessionController().getCurrentIdsCentresGestion().contains(oTmp.getIdCentreGestion())){
				this.currentOffre=getOffreDomainService().getOffreFromId(idOffreC);
				goToRecapitulatifOffreFromOffreLightAvecCentre();
			}
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToDetailsOffre(){
		return "detailsOffre";
	}

	/* ***************************************************************
	 * 
	 ****************************************************************/
	/**
	 * Upload du Fichier
	 */
	public void uploadFileOffre(FileUploadEvent event){
		if(logger.isDebugEnabled()){
			logger.debug("public String uploadLogoCentre() ");
		}
		FileUploadBean fileUlBean = getSessionController().getOffreFileUploadBean();

		// On met le prefix a -1 sinon '0_' est ajouté au nom
		fileUlBean.setPrefix(-1);
		// Methode s'occupant de l'upload du fichier
		fileUlBean.fileUploadListener(event);

		// Recuperation du nom final du fichier
		String nomFichier = fileUlBean.getNameUploadedFile();
		String nomReel = fileUlBean.getRealNameFile();

		//Si nom de fichier non vide (cas des fichiers volumineux)
		if(StringUtils.hasText(nomFichier)){
			FichierDTO f = new FichierDTO();
			f.setNomFichier(nomFichier);
			if(StringUtils.hasText(nomReel)){
				f.setNomReel(nomReel);
			} else {
				f.setNomReel("");
			}
			try {
				int idFichier = getOffreDomainService().addFichier(f);

				// Maintenant que l'upload s'est bien passé et que l'on a pu inserer le fichier en base,
				// on recupere le last insert id pour l'assigner a l'offre qui n'est pas encore creee donc
				// pas besoin d'update
				f.setIdFichier(idFichier);
				this.formOffre.setFichier(f);
				this.formOffre.setIdFichier(idFichier);

				// Pour que le fichier puisse etre recup par getFileServlet, il faut le prefixer de l'idFichier,
				// On le recupere donc pour le renommer
				String directory = getSessionController().getUploadFilesOffresPath()+ File.separator;
				File fichier = new File(directory + f.getNomFichier());
				boolean b = fichier.renameTo(new File(directory+ idFichier +"_"+f.getNomFichier()));

				if (b == false){
					addErrorMessage("panelUpload","GENERAL.ERREUR_RENAME_FILE");
				}
			} catch (DataAddException e) {
				logger.error(e);
				addErrorMessage("panelUpload",e.getMessage());
			} catch (DataUpdateException e) {
				logger.error(e);
				addErrorMessage("panelUpload",e.getMessage());
			} catch (WebServiceDataBaseException e) {
				logger.error(e);
				addErrorMessage("panelUpload",e.getMessage());
			}
		}
	}
	/**
	 * Action appellée après l'upload d'un fichier
	 */
	public void insertUploadedFile(){
		String nomFichier = getSessionController().getOffreFileUploadBean().getNameUploadedFile();
		String nomReel = getSessionController().getOffreFileUploadBean().getRealNameFile();
		//Si nom de fichier non vide (cas des fichiers volumineux)
		if(StringUtils.hasText(nomFichier)){
			this.formOffre.getFichier().setNomFichier(nomFichier);
			if(StringUtils.hasText(nomReel)){
				this.formOffre.getFichier().setNomReel(nomReel);
			}
			try {
				getOffreDomainService().updateFichier(this.formOffre.getFichier());
			} catch (DataAddException|WebServiceDataBaseException e) {
				logger.error(e);
			}
			this.formOffre.setIdFichier(this.formOffre.getFichier().getIdFichier());
		}
	}

	/**
	 * Suppression du fichier actuellement uploadé
	 */
	public void deleteUploadedFile(){

		if(this.formOffre.getIdFichier() > 0 ){
			try{
				if(this.formOffre.getFichier()!=null
						&& StringUtils.hasText(this.formOffre.getFichier().getNomFichier())){
					getSessionController().getOffreFileUploadBean().deleteFileFromDirectory(
							this.formOffre.getIdFichier(), this.formOffre.getFichier().getNomFichier());
				}
				getOffreDomainService().deleteFichier(this.formOffre.getIdFichier());
			}catch (DataDeleteException|WebServiceDataBaseException e) {
				logger.error(e);
			}
		}
		this.formOffre.setFichier(null);
		this.formOffre.setIdFichier(0);
		this.formOffre.setAvecFichier(false);

	}

	/**
	 * Mise à jour de la FapN3 en fonction de la QualificationSimplifiee selectionnée
	 * @param event
	 */
	public void valueFapQualificationSimplifieeChanged(ValueChangeEvent event){
		if(event.getNewValue() instanceof FapQualificationSimplifieeDTO){
			FapQualificationSimplifieeDTO f = (FapQualificationSimplifieeDTO)event.getNewValue();
			this.fapN3Listening=getFapN3FromNumQualif(f.getId());
		}else{
			this.fapN3Listening=null;
		}
	}
	/**
	 * @param num
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapN3FromNumQualif(int num){
		List<SelectItem> ls = null;
		List<FapN3DTO> l = getNomenclatureDomainService().getFapN3FromNumQualifSimplifiee(num);
		if(l!=null && !l.isEmpty()){
			ls = new ArrayList<SelectItem>();
			for(FapN3DTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/** Formulaire offre
	 * @param event
	 */
	public void formOffreValueCodePostalChanged(ValueChangeEvent event){
		String s = (String)event.getNewValue();
		if(getSessionController().isRecupererCommunesDepuisApogee()){
			List<SelectItem> lTmp = majCommunes(s);
			if(lTmp!=null && !lTmp.isEmpty()){
				this.formOffreCommunesListening=lTmp;
			}else{
				this.formOffreCommunesListening=new ArrayList<SelectItem>();
				addErrorMessage("formCreationOffre:dynaCodePostal", "STRUCTURE.CODE_POSTAL.VALIDATION");
			}
		}
	}

	/**
	 * @param codePostal
	 * @return List<SelectItem>
	 */
	public List<SelectItem> majCommunes(String codePostal){
		List<SelectItem> l = null;
		if(codePostal.length()==5){
			List<CommuneDTO> ls = getGeographieRepositoryDomain().getCommuneFromDepartement(codePostal);
			if(ls!=null){
				l = new ArrayList<SelectItem>();
				for(CommuneDTO c : ls){
					l.add(new SelectItem(c.getCodeCommune(),c.getLibCommune()));
				}
			}
		}
		return l;
	}


	/**
	 * @param event
	 */
	public void valueCentreEtablissementChanged(ValueChangeEvent event){
		if(event.getNewValue() instanceof Integer){
			if(this.listesCentresGestionEtablissement!=null && this.listesCGEtab!=null
					&& !this.listesCentresGestionEtablissement.isEmpty()
					&& !this.listesCGEtab.isEmpty()){
				int idCTmp = (Integer) event.getNewValue();
				if(idCTmp>0){
					CentreGestionDTO cTmp = new CentreGestionDTO();
					cTmp.setIdCentreGestion(idCTmp);
					CentreGestionDTO c = this.listesCGEtab.get(
							this.listesCGEtab.indexOf(cTmp));
					List<CentreGestionDTO> l = getCentreGestionDomainService().getCentreGestionList(c.getCodeUniversite());
					if(l!=null && !l.isEmpty()){
						this.dualListCiblageCentres.setSource(new ArrayList<CentreGestionDTO>());
						for(CentreGestionDTO cg : l){
							if(!cg.equals(cTmp)){
								this.dualListCiblageCentres.getSource().add(cg);
							}
						}
					}else{
						this.dualListCiblageCentres.setSource(new ArrayList<CentreGestionDTO>());
					}
				}else{
					this.dualListCiblageCentres.setSource(new ArrayList<CentreGestionDTO>());
				}
			}
		}else{
			this.dualListCiblageCentres.setSource(new ArrayList<CentreGestionDTO>());
		}
	}

	/**
	 * Utilisé en etape 3 d'une offre 
	 * @return boolean
	 */
	public boolean isFormOffreContainModeCourrier(){
		return isOffreContainMode(getBeanUtils().getModeCourrier(), this.formOffre);
	}

	/**
	 * Utilisé en etape 3 d'une offre 
	 * @return boolean
	 */
	public boolean isFormOffreContainModeTelephone(){
		return isOffreContainMode(getBeanUtils().getModeTelephone(), this.formOffre);
	}

	/**
	 * Utilisé en etape 3 d'une offre 
	 * @return boolean
	 */
	public boolean isFormOffreContainModeMail(){
		return isOffreContainMode(getBeanUtils().getModeMail(), this.formOffre);
	}

	/**
	 * Utilisé dans le recap d'une offre  
	 * @return boolean
	 */
	public boolean isCurrentOffreContainModeCourrier(){
		return isOffreContainMode(getBeanUtils().getModeCourrier(), this.currentOffre);
	}

	/**
	 * Utilisé dans le recap d'une offre 
	 * @return boolean
	 */
	public boolean isCurrentOffreContainModeTelephone(){
		return isOffreContainMode(getBeanUtils().getModeTelephone(), this.currentOffre);
	}

	/**
	 * Utilisé dans le recap d'une offre 
	 * @return boolean
	 */
	public boolean isCurrentOffreContainModeMail(){
		return isOffreContainMode(getBeanUtils().getModeMail(), this.currentOffre);
	}

	/**
	 * @param mc
	 * @param o
	 * @return boolean
	 */
	public boolean isOffreContainMode(ModeCandidatureDTO mc, OffreDTO o){
		boolean ret=false;
		if(o!=null){
			if(o.getModesCandidature()!=null &&
					!o.getModesCandidature().isEmpty()){
				for(ModeCandidatureDTO m : o.getModesCandidature()){
					if(m.equals(mc)){
						ret=true;
						break;
					}
				}
			}
		}
		return ret;
	}

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
	}


	/* ****************************************************************************
	 * DEPOT ANONYME
	 *****************************************************************************/

	private String codeAccesDepotAnonyme;

	private String urlAccesDepotAnonyme;

	public String getCodeAccesDepotAnonyme() {
		return codeAccesDepotAnonyme;
	}

	public void setCodeAccesDepotAnonyme(String codeAccesDepotAnonyme) {
		this.codeAccesDepotAnonyme = codeAccesDepotAnonyme;
	}

	public String getUrlAccesDepotAnonyme() {
		return urlAccesDepotAnonyme;
	}

	public void setUrlAccesDepotAnonyme(String urlAccesDepotAnonyme) {
		this.urlAccesDepotAnonyme = urlAccesDepotAnonyme;
	}

	/**
	 * code d'acces au depot anonyme pour une entreprise
	 */
	public void genererUrlDepotAnonyme() {
		// chiffrage de l'id de la convention via blowfish
		String idEncode = getBlowfishUtils().encode(
				"" + getCentreGestionDomainService().getCentreEntreprise().getIdCentreGestion());

		this.urlAccesDepotAnonyme =  getSessionController().getBaseUrl()
				+ "/stylesheets/depotAnonyme/welcome.xhtml" + "?id="
				+ idEncode;
	}

	/**
	 * Envoi vers l'enchainement de creation d'offre anonyme
	 * @return String
	 */
	public String goToDepotAnonyme(){
		String ret=null;
		this.centreGestionDepotAnonyme = getCentreGestionDomainService().getCentreEntreprise();
		if (this.centreGestionDepotAnonyme != null) {
			int idDecode = Utils.convertStringToInt(getBlowfishUtils().decode(this.codeAccesDepotAnonyme));
			if(idDecode == this.centreGestionDepotAnonyme.getIdCentreGestion()){
				this.formOffre=new OffreDTO();
				this.formOffre.setIdCentreGestion(idDecode);
				ret = "creationOffreAnon";
				this.creationOffre = "creationOffreAnon";
				getSessionController().setCreationOffreStageCurrentPage("_creationOffreEtape02Etab");
			} else {
				addErrorMessage("formAccueilDepotAnon","DEPOTANONYME.UNAUTHORIZED");
			}
		} else {
			addErrorMessage("formAccueilDepotAnon","DEPOTANONYME.CENTRE_ENTR_VIDE");
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String editPdfOffre() {
		String ret = null;
		try	{
			/**
			 **  Methodes de creation des documents PDF selon l'edition demandee
			 **/
			String nomDocxsl;
			String fileNameXml;
			String fileNameXmlfin = ".xml";
			OffreDTO offreEdit = this.currentOffre;
			String description;
			String competences;
			String observations;
			String commentaires;
			if (offreEdit != null) {
				if (offreEdit.getDescription() !=null) {
					if (StringUtils.hasText(offreEdit.getDescription())) {
						description = Utils.replaceHTML(offreEdit.getDescription());
						offreEdit.setDescription(description);
					}
				}
				if (offreEdit.getCompetences() != null) {
					if (StringUtils.hasText(offreEdit.getCompetences())) {
						competences = Utils.replaceHTML(offreEdit.getCompetences());
						offreEdit.setCompetences(competences);
					}

				}
				if (offreEdit.getCommentaireTempsTravail() != null) {
					if (StringUtils.hasText(offreEdit.getCommentaireTempsTravail())) {
						commentaires = Utils.replaceHTML(offreEdit.getCommentaireTempsTravail());
						offreEdit.setCommentaireTempsTravail(commentaires);
					}

				}
				if (offreEdit.getObservations() != null) {
					if (StringUtils.hasText(offreEdit.getObservations())) {
						observations = Utils.replaceHTML(offreEdit.getObservations());
						offreEdit.setObservations(observations);
					}

				}

				String idOffre = Integer.toString(offreEdit.getIdOffre());
				nomDocxsl = "offre" + ".xsl";
				fileNameXml = "offre_" + idOffre;
				// appel castor pour fichier xml a partir de objet java convention
				castorService.objectToFileXml(offreEdit, fileNameXml + fileNameXmlfin);
				//fusion du xsl et xml en pdf
				String fileNamePdf = fileNameXml + ".pdf";
				PDFUtils.exportPDF(fileNameXml + fileNameXmlfin, FacesContext.getCurrentInstance(),
						castorService.getXslXmlPath(),
						fileNamePdf, nomDocxsl);
				addInfoMessage(null, "CONVENTION.IMPRESSION.RECAP.CONFIRMATION");
			}

		} catch (ExportException e) {
			logger.error("editPdfRecap ", e);
			addErrorMessage(null, "CONVENTION.EDIT.RECAP.ERREUR", e.getMessage());
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToOffreADiffuser(){
		this.critereRechercheOffre=initCritereRechercheOffre();
		this.critereRechercheOffre.setEstDiffusee(false);
		String s = this.rechercherOffre();
		if(s != null) return s;
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "rechercheOffreStage";
	}

	/**
	 * event lors du choix d'une Offre côté stage menant à la page recapitulatifOffreCentre
	 */
	public void onOffreSelect(SelectEvent event) {

		String retour = this.goToRecapitulatifOffreFromOffreLightAvecCentre();

		try {
			if (retour != null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("recapitulatifOffreCentre.xhtml");
			}
		} catch (IOException ioe){
			logger.error("Erreur lors de la tentative de redirection de page.", ioe);
			addErrorMessage(null, "Erreur lors de la tentative de redirection de page.");
		}
	}

	/**
	 * event lors du choix d'une Offre côté stage menant à la page recapitulatifOffreEtabCentre
	 */
	public void onOffreEtabSelect(SelectEvent event) {

		String retour = this.goToRecapitulatifOffreFromOffreLightAvecCentre();

		try {
			if (retour != null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("recapitulatifOffreEtabCentre.xhtml");
			}
		} catch (IOException ioe){
			logger.error("Erreur lors de la tentative de redirection de page.", ioe);
			addErrorMessage(null, "Erreur lors de la tentative de redirection de page.");
		}
	}

	/**
	 * event lors du choix d'une Offre côté depot menant à la page recapitulatifOffreEtab
	 */
	public void onOffreEtabDepotSelect(SelectEvent event) {

		String retour = this.goToRecapitulatifOffreFromOffreLight();

		try {
			if (retour != null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("recapitulatifOffreEtab.xhtml");
			}
		} catch (IOException ioe){
			logger.error("Erreur lors de la tentative de redirection de page.", ioe);
			addErrorMessage(null, "Erreur lors de la tentative de redirection de page.");
		}
	}

	/**
	 * event lors du choix d'une Offre côté depot menant à la page recapitulatifOffreEtabCentre
	 */
	public void onOffreDepotSelect(SelectEvent event) {

		this.retour = "recapitulatifOffre";

		String retour = this.goToRecapitulatifOffre();

		try {
			if (retour != null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("recapitulatifOffre.xhtml");
			}
		} catch (IOException ioe){
			logger.error("Erreur lors de la tentative de redirection de page.", ioe);
			addErrorMessage(null, "Erreur lors de la tentative de redirection de page.");
		}
	}

	/**
	 * event lors du choix d'un établissement dans l'enchainement de création d'offre
	 */
	public void onCreaOffreEtabSelect(SelectEvent event) {

		this.goToCreationOffreDetailsEtab();

		try {
			if (this.creationOffre.equalsIgnoreCase("creationOffreAnon")){
				FacesContext.getCurrentInstance().getExternalContext().redirect(getSessionController().getBaseUrl()+"/stylesheets/depotAnonyme/creationOffreAnon.xhtml");
			} else {
				FacesContext.getCurrentInstance().getExternalContext().redirect("creationCentreEtabOffre.xhtml");
			}
		} catch (IOException ioe){
			logger.error("Erreur lors de la tentative de redirection de page.", ioe);
			addErrorMessage(null, "Erreur lors de la tentative de redirection de page.");
		}
	}
	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/

	/**
	 * @return the formOffre
	 */
	public OffreDTO getFormOffre() {
		return formOffre;
	}

	/**
	 * @param formOffre the formOffre to set
	 */
	public void setFormOffre(OffreDTO formOffre) {
		this.formOffre = formOffre;
	}

	/**
	 * @return the contratsListening
	 */
	public List<SelectItem> getContratsListening() {
		return contratsListening;
	}

	/**
	 * @param contratsListening the contratsListening to set
	 */
	public void setContratsListening(List<SelectItem> contratsListening) {
		this.contratsListening = contratsListening;
	}

	/**
	 * @return the fapN3Listening
	 */
	public List<SelectItem> getFapN3Listening() {
		return fapN3Listening;
	}

	/**
	 * @param fapN3Listening the fapN3Listening to set
	 */
	public void setFapN3Listening(List<SelectItem> fapN3Listening) {
		this.fapN3Listening = fapN3Listening;
	}

	/**
	 * @return the formOffreCommunesListening
	 */
	public List<SelectItem> getFormOffreCommunesListening() {
		return formOffreCommunesListening;
	}

	/**
	 * @param formOffreCommunesListening the formOffreCommunesListening to set
	 */
	public void setFormOffreCommunesListening(
			List<SelectItem> formOffreCommunesListening) {
		this.formOffreCommunesListening = formOffreCommunesListening;
	}

	/**
	 * @return the avecFichierOuLien
	 */
	public boolean isAvecFichierOuLien() {
		return avecFichierOuLien;
	}

	/**
	 * @param avecFichierOuLien the avecFichierOuLien to set
	 */
	public void setAvecFichierOuLien(boolean avecFichierOuLien) {
		this.avecFichierOuLien = avecFichierOuLien;
	}

	/**
	 * @return the fichierOuLien
	 */
	public int getFichierOuLien() {
		return fichierOuLien;
	}

	/**
	 * @param fichierOuLien the fichierOuLien to set
	 */
	public void setFichierOuLien(int fichierOuLien) {
		this.fichierOuLien = fichierOuLien;
	}

	/**
	 * @return the listeOffres
	 */
	public List<OffreDTO> getListeOffres() {
		return listeOffres;
	}

	/**
	 * @param listeOffres the listeOffres to set
	 */
	public void setListeOffres(List<OffreDTO> listeOffres) {
		this.listeOffres = listeOffres;
	}

	/**
	 * @return the retour
	 */
	public String getRetour() {
		if(!StringUtils.hasText(this.retour)) this.retour="defaut";
		return retour;
	}

	/**
	 * @param retour the retour to set
	 */
	public void setRetour(String retour) {
		this.retour = retour;
	}

	/**
	 * @return the recap
	 */
	public String getRecap() {
		String ret = recap;
		recap=null;
		return ret;
	}

	/**
	 * @param recap the recap to set
	 */
	public void setRecap(String recap) {
		this.recap = recap;
	}

	/**
	 * @return the currentOffre
	 */
	public OffreDTO getCurrentOffre() {
		return currentOffre;
	}

	/**
	 * @param currentOffre the currentOffre to set
	 */
	public void setCurrentOffre(OffreDTO currentOffre) {
		this.currentOffre = currentOffre;
	}

	/**
	 * @return the etablissementController
	 */
	public EtablissementController getEtablissementController() {
		return etablissementController;
	}

	/**
	 * @param etablissementController the etablissementController to set
	 */
	public void setEtablissementController(
			EtablissementController etablissementController) {
		this.etablissementController = etablissementController;
	}

	/**
	 * @return the listeItemsCurrentCentresGestion
	 */
	public List<SelectItem> getListeItemsCurrentCentresGestion() {
		listeItemsCurrentCentresGestion=null;
		if(getSessionController().getCurrentCentresGestion()!=null
				&& !getSessionController().getCurrentCentresGestion().isEmpty()){
			listeItemsCurrentCentresGestion=new ArrayList<SelectItem>();
			for(CentreGestionDTO cg : getSessionController().getCurrentCentresGestion()){
				listeItemsCurrentCentresGestion.add(new SelectItem(cg.getIdCentreGestion(), cg.getNomCentre()));
			}
		}
		return listeItemsCurrentCentresGestion;
	}

	/**
	 * @return the critereRechercheOffre
	 */
	public CritereRechercheOffreDTO getCritereRechercheOffre() {
		return critereRechercheOffre;
	}

	/**
	 * @param critereRechercheOffre the critereRechercheOffre to set
	 */
	public void setCritereRechercheOffre(
			CritereRechercheOffreDTO critereRechercheOffre) {
		this.critereRechercheOffre = critereRechercheOffre;
	}

	/**
	 * @return the rechTypesContratsOffre
	 */
	public List<SelectItem> getRechTypesContratsOffre() {
		rechTypesContratsOffre = new ArrayList<SelectItem>();
		List<TypeOffreDTO> lt = getNomenclatureDomainService().getTypesOffre();
		for(TypeOffreDTO t : lt){
			rechTypesContratsOffre.add(new SelectItem("t"+t.getId(),t.getLibelle()));
			List<ContratOffreDTO> lc = getNomenclatureDomainService().getContratsOffreFromIdTypeOffre(t.getId());
			if(lc!=null && !lc.isEmpty()){
				for(ContratOffreDTO c: lc){
					rechTypesContratsOffre.add(new SelectItem("c"+c.getId(), "--- "+c.getLibelle()));
				}
			}
		}
		return rechTypesContratsOffre;
	}

	/**
	 * @return the rechTypeOuContrat
	 */
	public String getRechTypeOuContrat() {
		return rechTypeOuContrat;
	}

	/**
	 * @param rechTypeOuContrat the rechTypeOuContrat to set
	 */
	public void setRechTypeOuContrat(String rechTypeOuContrat) {
		this.rechTypeOuContrat = rechTypeOuContrat;
	}

	/**
	 * @return the resultatsRechercheOffre
	 */
	public List<OffreDTO> getResultatsRechercheOffre() {
		return resultatsRechercheOffre;
	}

	/**
	 * @param resultatsRechercheOffre the resultatsRechercheOffre to set
	 */
	public void setResultatsRechercheOffre(List<OffreDTO> resultatsRechercheOffre) {
		this.resultatsRechercheOffre = resultatsRechercheOffre;
	}

	/**
	 * @return the rechercheAvancee
	 */
	public boolean isRechercheAvancee() {
		return rechercheAvancee;
	}

	/**
	 * @param rechercheAvancee the rechercheAvancee to set
	 */
	public void setRechercheAvancee(boolean rechercheAvancee) {
		this.rechercheAvancee = rechercheAvancee;
	}

	/**
	 * @return the rechercheOffrePaginator
	 */
	public RechercheOffrePaginator getRechercheOffrePaginator() {
		return rechercheOffrePaginator;
	}

	/**
	 * @param rechercheOffrePaginator the rechercheOffrePaginator to set
	 */
	public void setRechercheOffrePaginator(
			RechercheOffrePaginator rechercheOffrePaginator) {
		this.rechercheOffrePaginator = rechercheOffrePaginator;
	}

	/**
	 * @return the listesCentresGestionEtablissement
	 */
	public List<SelectItem> getListesCentresGestionEtablissement() {
		this.listesCentresGestionEtablissement = new ArrayList<SelectItem>();
		CentreGestionDTO cgEntr = getCentreGestionDomainService().getCentreEntreprise();
		if(cgEntr!=null && getSessionController().getCurrentCentresGestion()!=null
				&& !getSessionController().getCurrentCentresGestion().isEmpty()
				&& getSessionController().getCurrentCentresGestion().contains(cgEntr)){
			this.listesCentresGestionEtablissement.add(new SelectItem(0,getFacesInfoMessage("OFFRE.GESTION.DIFFUSIONCENTRE.DIFFUSERTLM").getDetail()));
			List<CentreGestionDTO> l = getCentreGestionDomainService().getCentresEtablissement(getSessionController().getCodeUniversite());
			this.listesCGEtab=l;
			if(l!=null && !l.isEmpty()){
				for(CentreGestionDTO cg : l){
					this.listesCentresGestionEtablissement.add(new SelectItem(cg.getIdCentreGestion(), cg.getNomCentre()));
				}
			}
		} else {
			this.listesCentresGestionEtablissement=new ArrayList<SelectItem>();
			CentreGestionDTO cgEtab = getCentreGestionDomainService().getCentreEtablissement(
					getSessionController().getCodeUniversite());
			this.listesCentresGestionEtablissement.add(new SelectItem(cgEtab.getIdCentreGestion(),""+cgEtab.getNomCentre()));
		}
		return this.listesCentresGestionEtablissement;
	}

	/**
	 * @param listesCentresGestionEtablissement the listesCentresGestionEtablissement to set
	 */
	public void setListesCentresGestionEtablissement(
			List<SelectItem> listesCentresGestionEtablissement) {
		this.listesCentresGestionEtablissement = listesCentresGestionEtablissement;
	}

	/**
	 * @return the idCentreEtablissementSelect
	 */
	public int getIdCentreEtablissementSelect() {
		return idCentreEtablissementSelect;
	}

	/**
	 * @param idCentreEtablissementSelect the idCentreEtablissementSelect to set
	 */
	public void setIdCentreEtablissementSelect(int idCentreEtablissementSelect) {
		this.idCentreEtablissementSelect = idCentreEtablissementSelect;
	}

	/**
	 * @return the centreGestionDepotAnonyme
	 */
	public CentreGestionDTO getCentreGestionDepotAnonyme() {
		return centreGestionDepotAnonyme;
	}

	/**
	 * @param centreGestionDepotAnonyme the centreGestionDepotAnonyme to set
	 */
	public void setCentreGestionDepotAnonyme(
			CentreGestionDTO centreGestionDepotAnonyme) {
		this.centreGestionDepotAnonyme = centreGestionDepotAnonyme;
	}

	/**
	 * @return the castorService
	 */
	public CastorService getCastorService() {
		return castorService;
	}

	/**
	 * @param castorService the castorService to set
	 */
	public void setCastorService(CastorService castorService) {
		this.castorService = castorService;
	}

	/**
	 * @return the dureesDiffusion
	 */
	public List<SelectItem> getDureesDiffusion() {
		this.dureesDiffusion = new ArrayList<SelectItem>();
		boolean isAdmin;
		if (this.currentOffre == null) this.currentOffre = this.formOffre;

		Map<Integer,DroitAdministrationDTO> droitAcces = getSessionController().getDroitsAccesMap();
		if (droitAcces.get(this.currentOffre.getIdCentreGestion()) == getBeanUtils().getDroitAdmin()
				|| getSessionController().isAdminPageAuthorized()
				|| getSessionController().isSuperAdminPageAuthorized()){
			isAdmin = true;
		} else {
			isAdmin = false;
		}

		for(DureeDiffusionDTO dd : getOffreDomainService().getDureeDiffusion()){
			if (dd.isAdminSeulement()) {
				if (isAdmin) this.dureesDiffusion.add(new SelectItem(dd.getId(), dd.getLibelle()));
			} else{
				this.dureesDiffusion.add(new SelectItem(dd.getId(), dd.getLibelle()));
			}
		}
		return dureesDiffusion;
	}

	/**
	 * @param dureesDiffusion the dureesDiffusion to set
	 */
	public void setDureesDiffusion(List<SelectItem> dureesDiffusion) {
		this.dureesDiffusion = dureesDiffusion;
	}

	/**
	 * @return the dureeDiffusion
	 */
	public int getDureeDiffusion() {
		return dureeDiffusion;
	}

	/**
	 * @param dureeDiffusion the dureeDiffusion to set
	 */
	public void setDureeDiffusion(int dureeDiffusion) {
		this.dureeDiffusion = dureeDiffusion;
	}

	/**
	 * @return the diffusionDirecte
	 */
	public boolean isDiffusionDirecte() {
		return diffusionDirecte;
	}

	/**
	 * @param diffusionDirecte the diffusionDirecte to set
	 */
	public void setDiffusionDirecte(boolean diffusionDirecte) {
		this.diffusionDirecte = diffusionDirecte;
	}

	/**
	 * @param offreADiffuser the offreADiffuser to set
	 */
	public void setOffreADiffuser(int offreADiffuser) {
		this.offreADiffuser= offreADiffuser;
	}
	/**
	 * @return the offreADiffuser
	 */
	public int getOffreADiffuser() {
		this.offreADiffuser=getOffreDomainService().countOffreADiffuser(getSessionController().getCurrentIdsCentresGestion());
		return this.offreADiffuser;
	}

	/**
	 * @return the creationOffre
	 */
	public String getCreationOffre() {
		return creationOffre;
	}

	/**
	 * @param creationOffre the creationOffre to set
	 */
	public void setCreationOffre(String creationOffre) {
		this.creationOffre = creationOffre;
	}

	public String getCurrentRecapOffre() {
		return currentRecapOffre;
	}

	public void setCurrentRecapOffre(String currentRecapOffre) {
		this.currentRecapOffre = currentRecapOffre;
	}

	public boolean isModificationContactOffre() {
		return modificationContactOffre;
	}

	public void setModificationContactOffre(boolean modificationContactOffre) {
		this.modificationContactOffre = modificationContactOffre;
	}
}
