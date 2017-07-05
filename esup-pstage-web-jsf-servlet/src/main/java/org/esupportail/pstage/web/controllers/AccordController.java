/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import gouv.education.apogee.commun.transverse.dto.geographie.CommuneDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.esupportail.pstage.domain.beans.NousContacter;
import org.esupportail.pstagedata.domain.dto.AccordPartenariatDTO;
import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.ServiceDTO;
import org.esupportail.pstagedata.domain.dto.StatutJuridiqueDTO;
import org.esupportail.pstagedata.domain.dto.StructureDTO;
import org.esupportail.pstagedata.domain.dto.TypeStructureDTO;
import org.esupportail.pstagedata.exceptions.AccordAlreadyExistingForContactException;
import org.esupportail.pstagedata.exceptions.AccordAlreadyExistingForStructureException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.MailAlreadyUsedForStructureException;
import org.esupportail.pstagedata.exceptions.StructureNumSiretException;
import org.esupportail.pstagedata.exceptions.UnvalidNumSiretException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.primefaces.event.SelectEvent;
import org.springframework.util.StringUtils;


/**
 * AccordController
 */
/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class AccordController extends AbstractContextAwareController {

	/* ***************************************************************
	 * Propriétés
	 ****************************************************************/

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 3430944955282121430L;
	/**
	 * Logger
	 */
	private final transient Logger logger = Logger.getLogger(this.getClass());

	/**
	 * preAccord
	 */
	private AccordPartenariatDTO preAccord;
	/**
	 * accord
	 */
	private AccordPartenariatDTO accord;
	/**
	 * preAccord : structure trouvée
	 */
	private StructureDTO structureExistante;
	/**
	 * preAccord : liste de structure correspondant à la raison sociale saisie
	 */
	private List<StructureDTO> listeStructureExistante;
	/**
	 * preAccord : champ de confirmation du mail du contact
	 */
	private String contactMailConfirmation;
	/**
	 * Vrai si structure déjà existante
	 */
	private boolean structureDejaExistante=false;
	/**
	 * Vrai si accord déjà existant
	 */
	private boolean accordDejaExistant=false;
	/**
	 * Contact utilisé pour la demande de comtpe
	 */
	private ContactDTO contactDemandeCompte;
	/**
	 * Etape précédente lorsqu'on se trouve sur l'etape 3 ou l'etape 4
	 */
	private String etapePrecedente="_accordEtape1FormulaireAccord";
	/**
	 * Liste dynamique mise à jour en fonction du type de structure
	 */
	private List<SelectItem> statutsJuridiquesListening;
	/**
	 * CommuneDTO
	 */
	private CommuneDTO accordStructureCommuneDTO;
	/**
	 * Liste dynamique mise à jour en fonction du département saisi
	 */
	private List<SelectItem> communesListening=new ArrayList<SelectItem>();

	/**
	 * rendered en fonction du pays de la page _accordEtape2EtabTrouve.xhtml
	 */
	private boolean paysAccordFrance = false;

	/**
	 * Bean constructor.
	 */
	public AccordController() {
		super();
	}

	/* ***************************************************************
	 * Actions
	 ****************************************************************/

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

	/**
	 * @return true if the current user is allowed to view the page.
	 */
	public boolean isPageAuthorized() {
		return true;
	}

	/**
	 * SuggestionBox
	 * Liste des structures retourné pour l'autocomplétion
	 * @param begin
	 * @return la liste des structures commencant et/ou contenant begin
	 */
	public List<StructureDTO> suggest(Object begin){
		if(logger.isDebugEnabled()){
			logger.debug("public List<StructureDTO> suggest(Object begin) : begin = "+begin.toString());
		}
		ArrayList<StructureDTO> listResult = new ArrayList<StructureDTO>();
		String raisonSociale = ((String)begin).trim() +"";
		if(raisonSociale.length()>0){
			listResult = (ArrayList<StructureDTO>) getStructureDomainService().getStructuresFromRaisonSociale('%'+raisonSociale);
			if(listResult!=null){
				Iterator<StructureDTO> i = listResult.iterator();
				while(i.hasNext()){
					StructureDTO s = i.next();
					if(s.getIdPays()>0){
						s.setPays(getNomenclatureDomainService().getPaysFromId(s.getIdPays()));
					}
				}
			}
		}
		return listResult;
	}

	/**
	 * @return a String
	 */
	public String goToPreAccord(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToPreAccord() ");
		}
		this.structureExistante=null;
		this.listeStructureExistante=null;
		this.preAccord=new AccordPartenariatDTO();
		this.preAccord.setStructure(new StructureDTO());
		this.preAccord.getStructure().setPays(getBeanUtils().getFrance());
		this.preAccord.setContact(new ContactDTO());
		this.preAccord.getContact().setService(new ServiceDTO());

		this.accord=new AccordPartenariatDTO();
		this.accord.setStructure(new StructureDTO());
		this.accord.getStructure().setPays(getBeanUtils().getFrance());
		this.accord.setContact(new ContactDTO());
		this.accord.getContact().setService(new ServiceDTO());

		this.accordStructureCommuneDTO=new CommuneDTO();
		this.statutsJuridiquesListening=null;

		this.contactMailConfirmation="";

		getSessionController().setCreationAccordCurrentPage("_accordEtape1PreAccord");

		return "accord";
	}

	/**
	 *
	 */
	public void retourPreAccord(){
		this.structureExistante = null;
		this.listeStructureExistante = null;
		this.structureDejaExistante = false;
		getSessionController().setCreationAccordCurrentPage("_accordEtape1PreAccord");
	}

	/**
	 *
	 */
	public void goToEtabTrouve(){
		StructureDTO sTmp = this.preAccord.getStructure();
		this.accord.getStructure().setRaisonSociale(sTmp.getRaisonSociale());
		this.accord.getStructure().setNumeroSiret(sTmp.getNumeroSiret());
		this.accord.getStructure().setTypeStructure(sTmp.getTypeStructure());
		if(sTmp.getTypeStructure()!=null){
			this.accord.getStructure().setIdTypeStructure(sTmp.getTypeStructure().getId());
		}
		this.accord.getStructure().setPays(sTmp.getPays());

		this.etapePrecedente="_accordEtape1PreAccord";
		getSessionController().setCreationAccordCurrentPage("_accordEtape2EtabTrouve");

		if(logger.isDebugEnabled()){
			logger.debug("goToEtabTrouve() ");
			logger.debug("this.accord.getStructure() = "+this.accord.getStructure());
		}
		if(StringUtils.hasText(sTmp.getNumeroSiret())){
			StructureDTO tmpStruct = getStructureDomainService().getStructureFromNumSiret(sTmp.getNumeroSiret());
			if(tmpStruct!=null){
				if(logger.isDebugEnabled()){
					logger.debug("Structure trouvee via son numero SIRET.");
				}
				this.structureExistante = tmpStruct;

				return ;
			}
		}
		if(StringUtils.hasText(sTmp.getRaisonSociale())){

			List<StructureDTO> lStTmp = getStructureDomainService().getStructuresFromRaisonSociale(this.accord.getStructure().getRaisonSociale());

			if(lStTmp!=null){
				if(lStTmp.size()==1){
					if(logger.isDebugEnabled()){
						logger.debug("Structure trouvee via sa raison sociale.");
					}
					this.structureExistante=lStTmp.get(0);
				}else{
					if(logger.isDebugEnabled()){
						logger.debug("Plusieurs structure trouvees via la raison sociale saisie.");
					}
					this.listeStructureExistante=lStTmp;
				}

				return ;
			}
		}
		// Si jamais rien n'est trouve, on affichera "aucune correspondance trouvee"
	}

	/**
	 * @return String
	 */
	public void onEtablissementAccordSelect(SelectEvent event) {
		// On est obligés d'assigner le parametre "selection" de la dataTable à accord.structure car
		// si on lui met structureExistante, lorsque la dataTable N'EST PAS utilisée
		// dans la page (ie: un seul etab est trouvé), elle met systematiquement la valeur de son
		// paramètre "selection" à null
		this.structureDejaExistante = true;
		this.structureExistante = this.accord.getStructure();

		this.goToFormulaireAccord();

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(getSessionController().getBaseUrl()+"/stylesheets/depot/accord.xhtml");
		} catch (IOException ioe){
			logger.error(ioe);
			addErrorMessage(null, "Erreur lors de la tentative de redirection de page.");
		}
	}

	/**
	 * @return String
	 */
	public String deSelectionner(){
		StructureDTO sTmp = this.preAccord.getStructure();
		this.accord.setStructure(new StructureDTO());
		this.accord.getStructure().setRaisonSociale(sTmp.getRaisonSociale());
		this.accord.getStructure().setNumeroSiret(sTmp.getNumeroSiret());
		this.accord.getStructure().setTypeStructure(sTmp.getTypeStructure());
		this.accord.getStructure().setTypeStructure(sTmp.getTypeStructure());
		if(sTmp.getTypeStructure()!=null){
			this.accord.getStructure().setIdTypeStructure(sTmp.getTypeStructure().getId());
			//this.statutsJuridiquesListening=getStatutsJuridiquesFromIdTypeStructure(sTmp.getTypeStructure().getId());
		}
		this.accord.getStructure().setPays(sTmp.getPays());
		if(logger.isDebugEnabled()){
			logger.debug("public String deSelectionner(), this.accord.getStructure() = "+this.accord.getStructure());
		}
		return null;
	}

	/**
	 *
	 */
	public void goToFormulaireAccord(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToFormulaireAccord()");
		}

		if(this.structureDejaExistante){
			this.accord.setStructure(this.structureExistante);
		} else {
			this.accord.setStructure(this.preAccord.getStructure());
		}

		getSessionController().setCreationAccordCurrentPage("_accordEtape3FormulaireAccord");

		if (this.accord.getStructure() != null) {

			AccordPartenariatDTO acTmp = getStructureDomainService().getAccordFromIdStructure(this.accord.getStructure().getIdStructure());
			if (acTmp != null) {
				this.accordDejaExistant = true;
				this.contactDemandeCompte = new ContactDTO();
				this.contactDemandeCompte.setService(new ServiceDTO());
				getSessionController().setCreationAccordCurrentPage("_accordEtape4DemandeCompte");
				if (logger.isDebugEnabled()) {
					logger.debug("this.accordDejaExistant=true");
				}
			}
		}

		this.etapePrecedente="_accordEtape2EtabTrouve";

		if(logger.isDebugEnabled()){
			logger.debug("this.etapePrecedente="+this.etapePrecedente);
		}

		this.contactMailConfirmation="";
	}

	/**
	 * Liste dynamique mise à jour en fonction du type de structure
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getStatutsJuridiquesListening(){
		return this.statutsJuridiquesListening;
	}
	/**
	 * Mise à jour de la liste Statut juridique en fonction de la liste Type de Structure
	 * @param event
	 */
	public void valueTypeStructureChanged(ValueChangeEvent event){
		if(event.getNewValue() instanceof TypeStructureDTO){
			TypeStructureDTO t = (TypeStructureDTO)event.getNewValue();
			this.statutsJuridiquesListening=getStatutsJuridiquesFromIdTypeStructure(t.getId());
		}else{
			this.statutsJuridiquesListening=null;
		}
	}
	/**
	 * @param id
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getStatutsJuridiquesFromIdTypeStructure(int id){
		List<SelectItem> ls;
		List<StatutJuridiqueDTO> l = getNomenclatureDomainService().getStatutsJuridiquesFromIdTypeStructure(id);
		ls = new ArrayList<SelectItem>();
		if (l != null) {
			for(StatutJuridiqueDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return a String
	 */
	public String validerAccord(){
		if(logger.isDebugEnabled()){
			logger.debug("public String validerAccord()");
		}
		getSessionController().setCreationAccordCurrentPage("_accordEtape3FormulaireAccord");
		//Mail == Confirmation
		boolean mailConfirmationOK=false;
		if(this.accord.getContact()!=null &&
				StringUtils.hasText(this.accord.getContact().getMail()) &&
				StringUtils.hasText(this.contactMailConfirmation) &&
				this.accord.getContact().getMail().equals(this.contactMailConfirmation)){
			mailConfirmationOK=true;
		}
		boolean nafActiviteOK=false;
		if(this.structureDejaExistante ||
				(this.accord.getStructure().getNafN5()!=null
						&& this.accord.getStructure().getNafN5().getCode()!=null
						&& StringUtils.hasText(this.accord.getStructure().getNafN5().getCode())
						&& !StringUtils.hasText(this.accord.getStructure().getActivitePrincipale())) ||
				((this.accord.getStructure().getNafN5()==null
						|| (this.accord.getStructure().getNafN5()!=null && this.accord.getStructure().getNafN5().getCode()==null)
						|| (this.accord.getStructure().getNafN5()!=null && this.accord.getStructure().getNafN5().getCode()!=null && this.accord.getStructure().getNafN5().getCode().isEmpty()))
						&& StringUtils.hasText(this.accord.getStructure().getActivitePrincipale())) ||
				(this.accord.getStructure().getNafN5()!=null
						&& this.accord.getStructure().getNafN5().getCode()!=null
						&& StringUtils.hasText(this.accord.getStructure().getNafN5().getCode())
						&& StringUtils.hasText(this.accord.getStructure().getActivitePrincipale()))){
			nafActiviteOK=true;
		}
		if(mailConfirmationOK && nafActiviteOK){
			getSessionController().setCreationAccordCurrentPage("_accordEtape5Confirmation");
			//Récupération des ID
			ContactDTO contactTmp = this.accord.getContact();
			contactTmp.setIdCivilite(this.accord.getContact().getCivilite().getId());
			String loginCreation = "auto:NouvelAccord";
			contactTmp.setLoginCreation(loginCreation);
			if(logger.isDebugEnabled()){
				logger.debug("this.accord.getContact()="+contactTmp);
			}

			StructureDTO structureTmp = this.accord.getStructure();
			structureTmp.setIdEffectif(this.accord.getStructure().getEffectif().getId());
			structureTmp.setIdPays(this.accord.getStructure().getPays().getId());
			if(this.accord.getStructure().getStatutJuridique()!=null)
				structureTmp.setIdStatutJuridique(this.accord.getStructure().getStatutJuridique().getId());
			else structureTmp.setIdStatutJuridique(0);
			structureTmp.setIdTypeStructure(this.accord.getStructure().getTypeStructure().getId());
			if(this.accord.getStructure().getNafN5()!=null)
				structureTmp.setCodeNAF_N5(this.accord.getStructure().getNafN5().getCode());
			else structureTmp.setCodeNAF_N5(null);
			if(getBeanUtils().isFrance(this.accord.getStructure().getPays()) && getSessionController().isRecupererCommunesDepuisApogee()){
				if(StringUtils.hasText(this.accordStructureCommuneDTO.getCodeCommune())){
					structureTmp.setCodeCommune(this.accordStructureCommuneDTO.getCodeCommune());
					this.accordStructureCommuneDTO=getGeographieRepositoryDomain().getCommuneFromDepartementEtCodeCommune(structureTmp.getCodePostal(), ""+this.accordStructureCommuneDTO.getCodeCommune());
					if(this.accordStructureCommuneDTO!=null){
						structureTmp.setCommune(this.accordStructureCommuneDTO.getLibCommune());
					}
				}
			}
			structureTmp.setLoginCreation(loginCreation);
			structureTmp.setLoginInfosAJour(loginCreation);
			if(logger.isDebugEnabled()){
				logger.debug("this.accord.getStructure()="+structureTmp);
			}

			ServiceDTO serviceTmp = this.accord.getContact().getService();
			serviceTmp.setLoginCreation("auto:NouvelAccord");
			//Copie de l'adresse de la structure pour le nouveau service 
			serviceTmp=BeanUtils.copieAdresseStructureVersService(structureTmp,serviceTmp);
			if(logger.isDebugEnabled()){
				logger.debug("this.accord.getContact().getService()="+serviceTmp);
			}
			boolean accordEnregistre=false;
			try{
				if(logger.isInfoEnabled()){
					logger.info("Creation nouvel accord");
				}
				//Ajout Structure
				if(!this.structureDejaExistante) {
					structureTmp.setIdStructure(this.getStructureDomainService().addStructure(structureTmp));
					if(logger.isInfoEnabled()){
						logger.info("Ajout structure : "+structureTmp);
					}
				}
				//Ajout Service
				serviceTmp.setIdStructure(structureTmp.getIdStructure());
				serviceTmp.setIdService(this.getStructureDomainService().addService(serviceTmp));
				if(logger.isInfoEnabled()){
					logger.info("Ajout service : "+serviceTmp);
				}
				//Ajout Contact
				contactTmp.setIdService(serviceTmp.getIdService());
				contactTmp.setIdCentreGestion(getCentreGestionDomainService().getCentreEntreprise().getIdCentreGestion());
				contactTmp.setId(this.getStructureDomainService().addContact(contactTmp));
				if(logger.isInfoEnabled()){
					logger.info("Ajout contact : "+contactTmp);
				}
				//Ajout Accord
				this.accord.setIdStructure(structureTmp.getIdStructure());
				this.accord.setIdContact(contactTmp.getId());
				this.accord.setLoginCreation("auto:NouvelAccord");

				AccordPartenariatDTO accordTmp;
				accordTmp = getStructureDomainService().getAccordFromIdStructure(this.accord.getIdStructure());
				if(accordTmp!=null){
					throw new AccordAlreadyExistingForStructureException("Accord déjà existant pour cette structure : "+accord.getIdStructure());
				}
				accordTmp = getStructureDomainService().getAccordFromIdContact(this.accord.getIdContact());
				if(accordTmp!=null){
					throw new AccordAlreadyExistingForContactException("Accord déjà existant pour ce contact : "+accord.getIdContact());
				}

				this.accord.setIdAccordPartenariat(this.getStructureDomainService().addAccord(this.accord));

				if(logger.isInfoEnabled()){
					logger.info("Ajout accord : "+this.accord);
				}

				accordEnregistre=true;

			}catch (DataAddException d) {
				logger.error("DataAddException", d);
				addErrorMessage(null, "ACCORD.ERREUR");
				//Suppression des éléments ajoutés en base
				if(contactTmp.getId()>0){
					logger.info("Suppression Contact : " +contactTmp);
					this.getStructureDomainService().deleteContact(contactTmp.getId());
				}
				if(serviceTmp.getIdService()>0){
					logger.info("Suppression Service : " +serviceTmp);
					this.getStructureDomainService().deleteService(serviceTmp.getIdService());
				}
				if(structureTmp.getIdStructure()>0){
					logger.info("Suppression Structure : " +structureTmp);
					this.getStructureDomainService().deleteStructureBase(structureTmp.getIdStructure());
				}
			}catch (WebServiceDataBaseException w){
				try {
					logger.error("WebServiceDataBaseException", w);
					addErrorMessage(null, "ACCORD.ERREUR");
					//Suppression des éléments ajoutés en base
					if(contactTmp.getId()>0){
						if(logger.isInfoEnabled()){
							logger.info("Suppression Contact : " +contactTmp);
						}
						this.getStructureDomainService().deleteContact(contactTmp.getId());
					}
					if(serviceTmp.getIdService()>0){
						if(logger.isInfoEnabled()){
							logger.info("Suppression Service : " +serviceTmp);
						}
						this.getStructureDomainService().deleteService(serviceTmp.getIdService());
					}
					if(structureTmp.getIdStructure()>0){
						if(logger.isInfoEnabled()){
							logger.info("Suppression Structure : " +structureTmp);
						}
						this.getStructureDomainService().deleteStructureBase(structureTmp.getIdStructure());
					}
				} catch (WebServiceDataBaseException wb) {
					logger.error(wb);
					addErrorMessage(null, "ACCORD.ERREUR");
				}
			}catch (StructureNumSiretException se){
				logger.info("Structure déjà existante pour ce numéro siret "+structureTmp+", redirection vers _accordEtape1FormulaireAccord");
				logger.info(se);
				goToPreAccord();//Reset des objets Accord
				getSessionController().setCreationAccordCurrentPage("_accordEtape1FormulaireAccord");

			}catch (UnvalidNumSiretException ue) {
				logger.info("Numéro siret invalide pour "+structureTmp+", redirection vers _accordEtape1FormulaireAccord");
				logger.info(ue);
				goToPreAccord();//Reset des objets Accord
				getSessionController().setCreationAccordCurrentPage("_accordEtape1FormulaireAccord");
			}catch (AccordAlreadyExistingForStructureException as) {
				logger.info("Accord déjà existant pour la structure "+structureTmp+", redirection vers _accordEtape4DemandeCompte");
				logger.info(as);
				this.accordDejaExistant=true;
				this.contactDemandeCompte=this.accord.getContact();
				getSessionController().setCreationAccordCurrentPage("_accordEtape4DemandeCompte");
			}catch (AccordAlreadyExistingForContactException ac) {
				// Impossible ici
				logger.info(ac);
			}catch (MailAlreadyUsedForStructureException e) {
				logger.info(e);
				logger.info("MailAlreadyUsedForStructureException", e.getCause());
				addErrorMessage("formAccord:mailC", "CONTACT.GESTION.ERREURACCOUNT");
				getSessionController().setCreationAccordCurrentPage("_accordEtape3FormulaireAccord");
				return null;
			}
			if(accordEnregistre){
				if(logger.isInfoEnabled()){
					logger.info("Accord enregistre.");
				}

				if(StringUtils.hasText(getSessionController().getMailingListEntr())){
					getSmtpService().send(
							getSessionController().getMailingListEntrIA(),
							getString("MAIL.ADMIN.ACCORD.SUJETNOUVELACCORD", getSessionController().getApplicationNameEntreprise(), structureTmp.printAdresse()),
							getString("MAIL.ADMIN.ACCORD.MESSAGENOUVELACCORD", getSessionController().getApplicationNameEntreprise(), structureTmp.printAdresse()),
							""
					);
				}
			}
		}else{
			//Mail != Confirmation
			if(!mailConfirmationOK)
				addErrorMessage("formAccord:mailConfirmation", "CONTACT.MAIL_CONFIRMATION.VALIDATION");
			//CodeNAF et Activité Principale vide
			if(!nafActiviteOK && !this.structureDejaExistante)
				addErrorMessage("formAccord:ape", "FORM.CHAMP_OBLIGATOIRE");

		}
		return "accord";
	}

	/**
	 * @return String
	 */
	public void validerDemandeCompte(){
		if(logger.isDebugEnabled()){
			logger.debug("public String validerDemandeCompte()");
		}
		//Mail == Confirmation
		boolean mailConfirmationOK=false;
		if(this.contactDemandeCompte!=null &&
				StringUtils.hasText(this.contactDemandeCompte.getMail()) &&
				StringUtils.hasText(this.contactMailConfirmation) &&
				this.contactDemandeCompte.getMail().equals(this.contactMailConfirmation)){
			mailConfirmationOK=true;
		}
		if(mailConfirmationOK){
			getSessionController().setCreationAccordCurrentPage("_accordEtape5Confirmation");

			addInfoMessage("formAccord", "ACCORD.DEMANDEENVOYE");

			if(StringUtils.hasText(getSessionController().getMailingListEntr())){
				getSmtpService().send(getSessionController().getMailingListEntrIA(),
						getString("MAIL.ADMIN.ACCORD.SUJETDEMANDECOMPTE", getSessionController().getApplicationNameEntreprise(), this.contactDemandeCompte.print(), this.accord.getStructure().printAdresse()),
						getString("MAIL.ADMIN.ACCORD.MESSAGEDEMANDECOMPTE", getSessionController().getApplicationNameEntreprise(), this.contactDemandeCompte.print(),
								this.accord.getStructure().printAdresse()),"");
			}
		}else{
			//Mail != Confirmation
			addErrorMessage("formAccord:mailConfirmation", "CONTACT.MAIL_CONFIRMATION.VALIDATION");
		}
	}

	/**
	 *
	 */
	public String goToEtapePrecedente(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToEtapePrecedente(), this.etapePrecedente="+this.etapePrecedente);
		}
		this.accord.setStructure(this.preAccord.getStructure());
		getSessionController().setCreationAccordCurrentPage(this.etapePrecedente);
		return "accord";
	}

	/**
	 * @return a String
	 */
	public String goToDemandeCompte(){
		return "demandeCompte";
	}

	/**
	 * @return String
	 */
	public void nousContacterErreurEtablissement(){
		NousContacter tmp = new NousContacter();
		tmp.setSujet(getString("ACCORD.ERREUR_ETAB.SUJET")+
				this.structureExistante.getRaisonSociale()+", "+
				this.structureExistante.getNumeroSiret());
		getSessionController().setNousContacter(tmp);
		getSessionController().setNousContacterCurrentPage("_nousContacterEtape1");
//		return null;
	}

	/**
	 * @param event
	 */
	public void valueCodeNafChanged(ValueChangeEvent event){
		String s = (String)event.getNewValue();
		this.accord.getStructure().setNafN5(getNomenclatureDomainService().getNafN5FromCode(s));
	}

	/**
	 * @param event
	 */
	public void valueCodePostalChanged(ValueChangeEvent event){
		String s = (String)event.getNewValue();
		List<SelectItem> lTmp = majCommunes(s);
		if(lTmp!=null && !lTmp.isEmpty()){
			this.communesListening=lTmp;
		}else{
			this.communesListening=new ArrayList<SelectItem>();
			addErrorMessage("formAccord:dynaCodePostal", "STRUCTURE.CODE_POSTAL.VALIDATION");
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
	 * true si le pays choisi est la France
	 */
	public boolean isPaysAccordFrance(){
		if ((this.accord != null
				&& this.accord.getStructure() != null
				&& this.accord.getStructure().getPays() != null
				&& getBeanUtils().isFrance(this.accord.getStructure().getPays()))){
			return true;
		}
		return false;
	}

	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/

	/**
	 * @return the preAccord
	 */
	public AccordPartenariatDTO getPreAccord() {
		return preAccord;
	}

	/**
	 * @param preAccord the preAccord to set
	 */
	public void setPreAccord(AccordPartenariatDTO preAccord) {
		this.preAccord = preAccord;
	}

	/**
	 * @return the accord
	 */
	public AccordPartenariatDTO getAccord() {
		return accord;
	}

	/**
	 * @param accord the accord to set
	 */
	public void setAccord(AccordPartenariatDTO accord) {
		this.accord = accord;
	}

	/**
	 * @return the structureExistante
	 */
	public StructureDTO getStructureExistante() {
		return structureExistante;
	}

	/**
	 * @param structureExistante the structureExistante to set
	 */
	public void setStructureExistante(StructureDTO structureExistante) {
		this.structureExistante = structureExistante;
	}

	/**
	 * @return the listeStructureExistante
	 */
	public List<StructureDTO> getListeStructureExistante() {
		return listeStructureExistante;
	}

	/**
	 * @param listeStructureExistante the listeStructureExistante to set
	 */
	public void setListeStructureExistante(
			List<StructureDTO> listeStructureExistante) {
		this.listeStructureExistante = listeStructureExistante;
	}

	/**
	 * @return the contactMailConfirmation
	 */
	public String getContactMailConfirmation() {
		return contactMailConfirmation;
	}

	/**
	 * @param contactMailConfirmation the contactMailConfirmation to set
	 */
	public void setContactMailConfirmation(String contactMailConfirmation) {
		this.contactMailConfirmation = contactMailConfirmation;
	}

	/**
	 * @return the structureDejaExistante
	 */
	public boolean isStructureDejaExistante() {
		return structureDejaExistante;
	}

	/**
	 * @param structureDejaExistante the structureDejaExistante to set
	 */
	public void setStructureDejaExistante(boolean structureDejaExistante) {
		this.structureDejaExistante = structureDejaExistante;
	}

	/**
	 * @return the accordDejaExistant
	 */
	public boolean isAccordDejaExistant() {
		return accordDejaExistant;
	}

	/**
	 * @param accordDejaExistant the accordDejaExistant to set
	 */
	public void setAccordDejaExistant(boolean accordDejaExistant) {
		this.accordDejaExistant = accordDejaExistant;
	}

	/**
	 * @return the contactDemandeCompte
	 */
	public ContactDTO getContactDemandeCompte() {
		return contactDemandeCompte;
	}

	/**
	 * @param contactDemandeCompte the contactDemandeCompte to set
	 */
	public void setContactDemandeCompte(ContactDTO contactDemandeCompte) {
		this.contactDemandeCompte = contactDemandeCompte;
	}

	/**
	 * @return the etapePrecedente
	 */
	public String getEtapePrecedente() {
		return etapePrecedente;
	}

	/**
	 * @param etapePrecedente the etapePrecedente to set
	 */
	public void setEtapePrecedente(String etapePrecedente) {
		this.etapePrecedente = etapePrecedente;
	}

	/**
	 * @return the accordStructureCommuneDTO
	 */
	public CommuneDTO getAccordStructureCommuneDTO() {
		return accordStructureCommuneDTO;
	}

	/**
	 * @param accordStructureCommuneDTO the accordStructureCommuneDTO to set
	 */
	public void setAccordStructureCommuneDTO(CommuneDTO accordStructureCommuneDTO) {
		this.accordStructureCommuneDTO = accordStructureCommuneDTO;
	}

	/**
	 * @return the communesListening
	 */
	public List<SelectItem> getCommunesListening() {
		return communesListening;
	}

}
