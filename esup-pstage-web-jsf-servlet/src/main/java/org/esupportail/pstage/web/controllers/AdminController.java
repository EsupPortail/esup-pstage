/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import gouv.education.apogee.commun.transverse.dto.geographie.communedto.CommuneDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.domain.dto.AccordPartenariatDTO;
import org.esupportail.pstagedata.domain.dto.AdminStructureDTO;
import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.StatutJuridiqueDTO;
import org.esupportail.pstagedata.domain.dto.StructureDTO;
import org.esupportail.pstagedata.domain.dto.TypeStructureDTO;
import org.esupportail.pstagedata.exceptions.AccordAlreadyExistingForContactException;
import org.esupportail.pstagedata.exceptions.AccordAlreadyExistingForStructureException;
import org.esupportail.pstagedata.exceptions.AccountAlreadyExistingForCoupleMailStructureException;
import org.esupportail.pstagedata.exceptions.AdminStructureAccountException;
import org.esupportail.pstagedata.exceptions.AdminStructureLoginEppnAlreadyUsedException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.MailAlreadyUsedForStructureException;
import org.esupportail.pstagedata.exceptions.StructureNumSiretException;
import org.esupportail.pstagedata.exceptions.UnvalidNumSiretException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.springframework.util.StringUtils;


/**
 * AdminController
 */
public class AdminController extends AbstractContextAwareController {

	/* ***************************************************************
	 * Propri�t�s
	 ****************************************************************/

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 3430944955282121430L;
	/**
	 * Logger
	 */
	private final Logger logger = Logger.getLogger(this.getClass());
	/**
	 * Objet Administrateur utilis� pour l'ajout et la modification
	 * d'administrateurs de l'espace Entreprise
	 */
	private AdminStructureDTO formAdminStructure;
	/**
	 * Confirmation
	 */
	private String formAdminMdpConfirmation;
	/**
	 * Liste des administrateurs de l'espace Entreprise
	 */
	private List<AdminStructureDTO> listeAdminStructure;
	/**
	 * Set of rows keys updated and needed to be updated
	 */
	private Set<Integer> keysAdminStructure=new HashSet<Integer>();
	/**
	 * 
	 */
	private int currentRowAdminStructure;
	/**
	 * 0 : Compte local
	 * 1 : Compte CAS
	 * 2 : Compte Shibboleth
	 */
	private int typeCompteAdminStructure=0;
	/**
	 * Liste des types de comptes pour un administrateur
	 * de l'espace Entreprise
	 * 0 : Compte local
	 * 1 : Compte CAS
	 * 2 : Compte Shibboleth
	 */
	private List<SelectItem> listTypeCompteAdminStructure;

	/**
	 * L'accord de partenariat en cours de validation
	 */
	private AccordPartenariatDTO accordPartenariatAValider;
	/**
	 * Structure de l'accord � valider
	 */
	private StructureDTO structureAccordAValider;
	/**
	 * Contact de l'accord � valider
	 */
	private ContactDTO contactAccordAValider;
	/**
	 * Structure avec accord pour consultation 
	 */
	private StructureDTO structureAccord;
	/**
	 * Accord � supprimer
	 */
	private StructureDTO accordASupprimer;
	/**
	 * Liste dynamique mise � jour en fonction du type de structure
	 */
	private List<SelectItem> statutsJuridiquesListening=null;
	/**
	 * CommuneDTO
	 */
	private CommuneDTO accordAValiderStructureCommuneDTO;
	/**
	 * Liste dynamique mise � jour en fonction du d�partement saisi
	 */
	private List<SelectItem> communesListening=new ArrayList<SelectItem>();

	/**
	 * RechercheController
	 */
	private RechercheController rechercheController;

	/**
	 * Bean constructor.
	 */
	public AdminController() {
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
		reloadAdministrateurs();
	}
	
	/**
	 * Re-chargement liste des administrateurs
	 */
	public void reloadAdministrateurs(){
		this.listeAdminStructure=getAdminDomainService().getAdminsStructure();		
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
	public String goToAccordsAValider(){
		return "accordsAValider";
	}

	/**
	 * @return a String
	 */
	public String goToAccordsValides(){
		return "accordsValides";
	}

	/**
	 * @return a String
	 */
	public String goToVoirAccord(){
		return "visuAccord";
	}

	/**
	 * @return a String
	 */
	public String goToSuppressionAccord(){
		return "suppressionAccord";
	}

	/* *********************************************
	 * Gestion des administrateurs
	 **********************************************/
	/**
	 * @return a String
	 */
	public String goToAdministrateurs(){
		return "administrateurs";
	}
	/**
	 * @return a String
	 */
	public String beforeAjouterAdministrateur(){
		this.keysAdminStructure = new HashSet<Integer>();
		this.formAdminStructure=new AdminStructureDTO();
		this.formAdminMdpConfirmation="";
		return null;
	}
	/**
	 * Ajout d'un administrateur
	 * @return a String
	 */
	public String ajouterAdministrateur(){
		String ret=null;
		boolean ok = false;
		if(this.formAdminStructure!=null){
			this.formAdminStructure.setLoginCreation(getSessionController().getCurrentAuthAdminStructure().getLogin());
			this.formAdminStructure.setDateCreation(new Date());
			try{
				switch (this.typeCompteAdminStructure) {
				//Compte local
				case 0:
					if(StringUtils.hasText(this.formAdminStructure.getMail()) 
							&& StringUtils.hasText(this.formAdminStructure.getLogin())
							&& StringUtils.hasText(this.formAdminStructure.getMdp())
							&& StringUtils.hasText(this.formAdminMdpConfirmation)){
						if(this.formAdminStructure.getMdp().equalsIgnoreCase(this.formAdminMdpConfirmation)){
							if(logger.isInfoEnabled()){
								logger.info("Creation administrateur entreprise : Compte local : "+this.formAdminStructure);
							}
							this.formAdminStructure.setEppn(null);
							getAdminDomainService().addAdminStructure(this.formAdminStructure);
							ret="_ajoutAdministrateurEtape2Confirmation";
							ok=true;
						}else{
							addErrorMessage("formAdminStructure:include:mdpAdmin", "ADMINSTRUCTURE.MDP_CONFIRMATION.VALIDATION");
						}
					}
					break;
					//CAS
				case 1:
					if(StringUtils.hasText(this.formAdminStructure.getMail()) 
							&& StringUtils.hasText(this.formAdminStructure.getLogin())){
						if(logger.isInfoEnabled()){
							logger.info("Creation administrateur entreprise : Compte CAS : "+this.formAdminStructure);
						}
						this.formAdminStructure.setMdp(null);
						this.formAdminStructure.setEppn(null);
						getAdminDomainService().addAdminStructure(this.formAdminStructure);
						ret="_ajoutAdministrateurEtape2Confirmation";
						ok=true;
					}
					break;
					//Shibboleth
				case 2:
					if(StringUtils.hasText(this.formAdminStructure.getMail()) 
							&& StringUtils.hasText(this.formAdminStructure.getEppn())){
						if(logger.isInfoEnabled()){
							logger.info("Creation administrateur entreprise : Compte Shibboleth : "+this.formAdminStructure);
						}
						this.formAdminStructure.setLogin(null);
						this.formAdminStructure.setMdp(null);
						getAdminDomainService().addAdminStructure(this.formAdminStructure);
						ret="_ajoutAdministrateurEtape2Confirmation";
						ok=true;
					}
					break;
				default:
					break;
				}
				addInfoMessage(null, "ADMINSTRUCTURE.CONFIRMATION");
			}catch (DataAddException d) {
				if(logger.isInfoEnabled()){
					logger.info("DataAddException ",d.fillInStackTrace());
				}
				addErrorMessage(null, "ADMINSTRUCTURE.ERREUR", d.getMessage());
				ret="_ajoutAdministrateurEtape2Confirmation";
			}catch (WebServiceDataBaseException w){
				if(logger.isInfoEnabled()){
					logger.info("WebServiceDataBaseException ",w.fillInStackTrace());
				}
				addErrorMessage(null, "ADMINSTRUCTURE.ERREUR", w.getMessage());
				ret="_ajoutAdministrateurEtape2Confirmation";
			}catch (AdminStructureAccountException aa) {
				if(logger.isInfoEnabled()){
					logger.info("AdminStructureAccountException ", aa.fillInStackTrace());
				}
				addErrorMessage(null, "ADMINSTRUCTURE.ERREUR", aa.getMessage());
				ret="_ajoutAdministrateurEtape2Confirmation";
			}catch (AdminStructureLoginEppnAlreadyUsedException al) {
				if(logger.isInfoEnabled()){
					logger.info("AdminStructureLoginEppnAlreadyUsedException ");
				}
				if(al.isLogin()) addErrorMessage("formAdminStructure:include:loginAdmin", "ADMINSTRUCTURE.ERREURLOGIN");
				if(al.isEppn()) addErrorMessage("formAdminStructure:include:eppnAdmin", "ADMINSTRUCTURE.ERREUREPPN");
			}
		}
		if(ok){
			this.listeAdminStructure=getAdminDomainService().getAdminsStructure();
			this.formAdminStructure=new AdminStructureDTO();
			this.formAdminMdpConfirmation="";
		}
		return ret;
	}
	/**
	 * @return a String
	 */
	public String beforeModifAdministrateur(){
		this.keysAdminStructure = new HashSet<Integer>();
		if(this.formAdminStructure!=null){
			if(StringUtils.hasText(this.formAdminStructure.getLogin()) 
					&& StringUtils.hasText(this.formAdminStructure.getMdp())
					&& !StringUtils.hasText(this.formAdminStructure.getEppn())){
				this.typeCompteAdminStructure=0;
			}else
				if(StringUtils.hasText(this.formAdminStructure.getLogin()) 
						&& !StringUtils.hasText(this.formAdminStructure.getMdp())
						&& !StringUtils.hasText(this.formAdminStructure.getEppn())){
					this.typeCompteAdminStructure=1;
				}else
					if(!StringUtils.hasText(this.formAdminStructure.getLogin()) 
							&& !StringUtils.hasText(this.formAdminStructure.getMdp())
							&& StringUtils.hasText(this.formAdminStructure.getEppn())){
						this.typeCompteAdminStructure=2;
					}else{
						this.typeCompteAdminStructure=0;
					}
		}
		return null;
	}
	/**
	 * Reset du formulaire de l'admin structure
	 * @return String
	 */
	public String resetFormAdminStructure(){
		this.formAdminStructure=new AdminStructureDTO();
		this.formAdminMdpConfirmation="";
		return null;
	}
	/**
	 * Modification d'un administrateur
	 * @return a String
	 */
	public String modifierAdministrateur(){
		String ret=null;
		boolean ok=false;
		if(this.formAdminStructure!=null){
			this.formAdminStructure.setLoginModif(getSessionController().getCurrentAuthAdminStructure().getLogin());
			this.formAdminStructure.setDateModif(new Date());
			try{
				switch (this.typeCompteAdminStructure) {
				//Compte local
				case 0:
					if(StringUtils.hasText(this.formAdminStructure.getMail()) 
							&& StringUtils.hasText(this.formAdminStructure.getLogin())
							&& StringUtils.hasText(this.formAdminStructure.getMdp())
							&& StringUtils.hasText(this.formAdminMdpConfirmation)){
						if(this.formAdminStructure.getMdp().equalsIgnoreCase(this.formAdminMdpConfirmation)){
							if(logger.isInfoEnabled()){
								logger.info("Mise a jour administrateur entreprise : Compte local : "+this.formAdminStructure);
							}
							this.formAdminStructure.setEppn(null);
							getAdminDomainService().updateAdminStructure(this.formAdminStructure);
							ret="_modifAdministrateurEtape2Confirmation";
							ok=true;
						}else{
							addErrorMessage("formModifAdminStructure:include:mdpAdmin", "ADMINSTRUCTURE.MDP_CONFIRMATION.VALIDATION");
						}
					}
					break;
					//CAS
				case 1:
					if(StringUtils.hasText(this.formAdminStructure.getMail()) 
							&& StringUtils.hasText(this.formAdminStructure.getLogin())){
						if(logger.isInfoEnabled()){
							logger.info("Mise a jour administrateur entreprise : Compte CAS : "+this.formAdminStructure);
						}
						this.formAdminStructure.setMdp(null);
						this.formAdminStructure.setEppn(null);
						getAdminDomainService().updateAdminStructure(this.formAdminStructure);
						ret="_modifAdministrateurEtape2Confirmation";
						ok=true;
					}
					break;
					//Shibboleth
				case 2:
					if(StringUtils.hasText(this.formAdminStructure.getMail()) 
							&& StringUtils.hasText(this.formAdminStructure.getEppn())){
						if(logger.isInfoEnabled()){
							logger.info("Mise a jour administrateur entreprise : Compte Shibboleth : "+this.formAdminStructure);
						}
						this.formAdminStructure.setLogin(null);
						this.formAdminStructure.setMdp(null);
						getAdminDomainService().updateAdminStructure(this.formAdminStructure);
						ret="_modifAdministrateurEtape2Confirmation";
						ok=true;
					}
					break;
				default:
					break;
				}
				addInfoMessage(null, "ADMINSTRUCTURE.CONFIRMATION");
			}catch (DataUpdateException d) {
				if(logger.isInfoEnabled()){
					logger.info("DataUpdateException ",d.fillInStackTrace());
				}
				addErrorMessage(null, "ADMINSTRUCTURE.ERREUR", d.getMessage());
				ret="_modifAdministrateurEtape2Confirmation";
			}catch (WebServiceDataBaseException w){
				if(logger.isInfoEnabled()){
					logger.info("WebServiceDataBaseException ",w.fillInStackTrace());
				}
				addErrorMessage(null, "ADMINSTRUCTURE.ERREUR", w.getMessage());
				ret="_modifAdministrateurEtape2Confirmation";
			}catch (AdminStructureAccountException aa) {
				if(logger.isInfoEnabled()){
					logger.info("AdminStructureAccountException ", aa.fillInStackTrace());
				}
				addErrorMessage(null, "ADMINSTRUCTURE.ERREUR", aa.getMessage());
				ret="_modifAdministrateurEtape2Confirmation";
			}catch (AdminStructureLoginEppnAlreadyUsedException al) {
				if(logger.isInfoEnabled()){
					logger.info("AdminStructureLoginEppnAlreadyUsedException ");
				}
				if(al.isLogin()) addErrorMessage("formModifAdminStructure:include:loginAdmin", "ADMINSTRUCTURE.ERREURLOGIN");
				if(al.isEppn()) addErrorMessage("formModifAdminStructure:include:eppnAdmin", "ADMINSTRUCTURE.ERREUREPPN");
			}
		}	
		if(ok){
			this.listeAdminStructure.set(this.currentRowAdminStructure, this.formAdminStructure);
			this.keysAdminStructure = Collections.singleton(this.currentRowAdminStructure);
			this.formAdminStructure=new AdminStructureDTO();
			this.formAdminMdpConfirmation="";
		}
		return ret;
	}
	/**
	 * @return a String
	 */
	public String supprimerAdministrateur(){
		String ret="_supprAdministrateurEtape2Confirmation";
		if(this.formAdminStructure!=null){
			try{
				if(logger.isInfoEnabled()){
					logger.info("Suppression administrateur entreprise : "+this.formAdminStructure);
				}
				getAdminDomainService().deleteAdminStructure(this.formAdminStructure.getId());
				addInfoMessage(null, "ADMINSTRUCTURE.CONFIRMATION_SUPPRESSION");
			}catch (DataDeleteException de) {
				if(logger.isInfoEnabled()){
					logger.info("DataDeleteException ",de.fillInStackTrace());
				}
				addErrorMessage(null, "ADMINSTRUCTURE.ERREURSUPPRESSION", de.getMessage());
			}catch (WebServiceDataBaseException we) {
				if(logger.isInfoEnabled()){
					logger.info("WebServiceDataBaseException ",we.fillInStackTrace());
				}
				addErrorMessage(null, "ADMINSTRUCTURE.ERREURSUPPRESSION", we.getMessage());
			}
			this.listeAdminStructure=getAdminDomainService().getAdminsStructure();
			this.formAdminStructure=new AdminStructureDTO();
		}
		return ret;
	}

	/**
	 * Envoi vers la page de validation d'un accord
	 * @return a String
	 */
	public String goToValidationAccord(){
		String ret=null;
		if(this.structureAccordAValider!=null && this.structureAccordAValider.getAccordPartenariat()!=null){
			ret="validationAccord";
			//M�j de liste des statuts juridiques
			if(this.structureAccordAValider!=null){
				if(this.structureAccordAValider.getTypeStructure()!=null){
					this.statutsJuridiquesListening=getStatutsJuridiquesFromIdTypeStructure(
							this.structureAccordAValider.getTypeStructure().getId());
				}
			}
			if(getBeanUtils().isFrance(this.structureAccordAValider.getPays()) && getSessionController().isRecupererCommunesDepuisApogee()){
				List<SelectItem> lTmp = majCommunes(""+this.structureAccordAValider.getCodePostal());
				if(lTmp!=null && !lTmp.isEmpty()){
					this.communesListening=lTmp;
				}else{
					this.communesListening=new ArrayList<SelectItem>();
				}
				this.accordAValiderStructureCommuneDTO=getGeographieRepositoryDomain().getCommuneFromDepartementEtCodeCommune(this.structureAccordAValider.getCodePostal(), ""+this.structureAccordAValider.getCodeCommune());
				if(this.accordAValiderStructureCommuneDTO!=null){
					this.structureAccordAValider.setCommune(this.accordAValiderStructureCommuneDTO.getLibCommune());
					this.structureAccordAValider.setCodeCommune(this.accordAValiderStructureCommuneDTO.getCodeCommune());
				}else{
					this.accordAValiderStructureCommuneDTO=new CommuneDTO();
				}
			}
			this.accordPartenariatAValider=this.structureAccordAValider.getAccordPartenariat();
			this.contactAccordAValider=getStructureDomainService().getContactFromId(this.accordPartenariatAValider.getIdContact());
		}else{
			addErrorMessage(null, "ACCORD.ERREUR_VALIDATION","");
		}
		return ret;
	}

	/**
	 * @return a String
	 */ 
	public String goToConfirmValidation(){
		String ret=null;
		if(this.accordPartenariatAValider!=null 
				&& !this.accordPartenariatAValider.isEstValide()){
			AccordPartenariatDTO tmp = getStructureDomainService().getAccordFromId(this.accordPartenariatAValider.getIdAccordPartenariat());
			if(!tmp.isEstValide()){
				try{
					String login = getSessionController().getCurrentAuthAdminStructure().displayLogin();
					if(getBeanUtils().isFrance(this.structureAccordAValider.getPays()) && getSessionController().isRecupererCommunesDepuisApogee()){
						this.structureAccordAValider.setCodeCommune(this.accordAValiderStructureCommuneDTO.getCodeCommune());
						//R�cup�ration de la commune pour en avoir le libell�
						this.accordAValiderStructureCommuneDTO=getGeographieRepositoryDomain().getCommuneFromDepartementEtCodeCommune(this.structureAccordAValider.getCodePostal(), ""+this.accordAValiderStructureCommuneDTO.getCodeCommune());
						if(this.accordAValiderStructureCommuneDTO!=null){
							this.structureAccordAValider.setCommune(this.accordAValiderStructureCommuneDTO.getLibCommune());					
						}
					}
					structureAccordAValider.setIdEffectif(this.structureAccordAValider.getEffectif().getId());
					structureAccordAValider.setIdPays(this.structureAccordAValider.getPays().getId());
					if(this.statutsJuridiquesListening!=null && this.structureAccordAValider.getStatutJuridique()!=null)
						structureAccordAValider.setIdStatutJuridique(this.structureAccordAValider.getStatutJuridique().getId());
					else structureAccordAValider.setIdStatutJuridique(0);
					structureAccordAValider.setIdTypeStructure(this.structureAccordAValider.getTypeStructure().getId());
					if(this.structureAccordAValider.getNafN5()!=null)
						structureAccordAValider.setCodeNAF_N5(this.structureAccordAValider.getNafN5().getCode());
					else structureAccordAValider.setCodeNAF_N5(null);
					//M�j structure
					this.structureAccordAValider.setLoginModif(login);
					if(!getStructureDomainService().updateStructure(this.structureAccordAValider)){
						addErrorMessage(null, "ACCORD.ERREUR_VALIDATION", "updateStructure");
					}
					//M�j contact
					this.contactAccordAValider.setLoginModif(login);
					if(this.contactAccordAValider.getCivilite()!=null){
						this.contactAccordAValider.setIdCivilite(this.contactAccordAValider.getCivilite().getId());
					}
					if(!getStructureDomainService().updateContact(this.contactAccordAValider)){
						addErrorMessage(null, "ACCORD.ERREUR_VALIDATION", "updateContact");
					}
					
					if(getSessionController().getCurrentManageStructure()!=null &&
							getSessionController().getCurrentManageStructure().getIdStructure()==
						this.structureAccordAValider.getIdStructure()){
						getSessionController().setCurrentManageStructure(this.structureAccordAValider);
					}
					ret="_validationAccordEtape2Confirm";
				}catch (DataUpdateException e) {
					if(logger.isInfoEnabled()){
						logger.info("DataUpdateException ",e.fillInStackTrace());
					}
					addErrorMessage("formValidationAccord", "ACCORD.ERREUR_VALIDATION", e.getMessage());
				}catch (WebServiceDataBaseException e) {
					if(logger.isInfoEnabled()){
						logger.info("WebServiceDataBaseException ",e.fillInStackTrace());
					}
					addErrorMessage("formValidationAccord", "ACCORD.ERREUR_VALIDATION", e.getMessage());
				}catch (AccordAlreadyExistingForStructureException e) {
					if(logger.isInfoEnabled()){
						logger.info("AccordAlreadyExistingForStructureException ",e.fillInStackTrace());
					}
					addErrorMessage("formValidationAccord", "ACCORD.ERREUR_VALIDATION.ACCORDEXISTANT", e.getMessage());
				}catch (AccordAlreadyExistingForContactException e) {
					if(logger.isInfoEnabled()){
						logger.info("AccordAlreadyExistingForContactException ",e.fillInStackTrace());
					}
					addErrorMessage("formValidationAccord", "ACCORD.ERREUR_VALIDATION.ACCORDEXISTANT", e.getMessage());
				}catch (UnvalidNumSiretException e) {
					if(logger.isInfoEnabled()){
						logger.info("UnvalidNumSiretException ",e.fillInStackTrace());
					}
					addErrorMessage("formValidationAccord", "ACCORD.ERREUR_VALIDATION.ERREURSIRET", e.getMessage());
				}catch (AccountAlreadyExistingForCoupleMailStructureException e) {
					if(logger.isInfoEnabled()){
						logger.info("AccountAlreadyExistingForCoupleMailStructureException ",e.fillInStackTrace());
					}
					addErrorMessage("formValidationAccord", "ACCORD.ERREUR_VALIDATION.MAILEXISTANT", e.getMessage());
				}catch (MailAlreadyUsedForStructureException e) {
					if(logger.isInfoEnabled()){
						logger.info("MailAlreadyUsedForStructureException ",e.fillInStackTrace());
					}
					addErrorMessage("formValidationAccord", "ACCORD.ERREUR_VALIDATION.MAILEXISTANT", e.getMessage());
				}catch (StructureNumSiretException e) {
					if(logger.isInfoEnabled()){
						logger.info("StructureNumSiretException ",e.fillInStackTrace());
					}
					addErrorMessage("formValidationAccord", "ACCORD.ERREUR_VALIDATION.STRUCTURESIRET", e.getMessage());
				}
			}else{
				addErrorMessage(null, "ACCORD.DEJAVALIDE");
			}
		}
		return ret;
	}

	/**
	 * Mise � jour de la liste Statut juridique en fonction de la liste Type de Structure
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
	 * @param event
	 */
	public void valueCodeNafChanged(ValueChangeEvent event){
		String s = (String)event.getNewValue();
		this.structureAccordAValider.setNafN5(getNomenclatureDomainService().getNafN5FromCode(s));
	}
	/**
	 * @param id 
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getStatutsJuridiquesFromIdTypeStructure(int id){
		List<SelectItem> ls = null;
		List<StatutJuridiqueDTO> l = getNomenclatureDomainService().getStatutsJuridiquesFromIdTypeStructure(id);
		ls = new ArrayList<SelectItem>();
		if(l!=null && !l.isEmpty()){
			for(StatutJuridiqueDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
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
			addErrorMessage("formValidationAccord:include:dynaCodePostal", "STRUCTURE.CODE_POSTAL.VALIDATION");
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
	 * Validation d'un accord
	 * @return a String
	 */
	public String validationAccord(){
		String ret=null;
		if(this.accordPartenariatAValider!=null 
				&& !this.accordPartenariatAValider.isEstValide()){
			AccordPartenariatDTO tmp = getStructureDomainService().getAccordFromId(this.accordPartenariatAValider.getIdAccordPartenariat());
			if(!tmp.isEstValide()){
				try{
					String login = getSessionController().getCurrentAuthAdminStructure().displayLogin();
					if(getBeanUtils().isFrance(this.structureAccordAValider.getPays()) && getSessionController().isRecupererCommunesDepuisApogee()){
						this.structureAccordAValider.setCodeCommune(this.accordAValiderStructureCommuneDTO.getCodeCommune());
						//R�cup�ration de la commune pour en avoir le libell�
						this.accordAValiderStructureCommuneDTO=getGeographieRepositoryDomain().getCommuneFromDepartementEtCodeCommune(this.structureAccordAValider.getCodePostal(), ""+this.accordAValiderStructureCommuneDTO.getCodeCommune());
						if(this.accordAValiderStructureCommuneDTO!=null){
							this.structureAccordAValider.setCommune(this.accordAValiderStructureCommuneDTO.getLibCommune());					
						}
					}
					//M�j structure
					/*this.structureAccordAValider.setLoginModif(login);
					if(!getStructureDomainService().updateStructure(this.structureAccordAValider)){
						addErrorMessage(null, "ACCORD.ERREUR_VALIDATION", "updateStructure");
					}*/
					//M�j contact + g�n�ration login/mdp
					this.contactAccordAValider.setLoginModif(login);
					this.contactAccordAValider.setLogin(Utils.loginGeneration(this.structureAccordAValider.getRaisonSociale(),
							""+this.contactAccordAValider.getId()));
					String mdpGenere = Utils.encodeMD5("random" + Math.random()*10000).substring(0,8);
					this.contactAccordAValider.setMdp(getBlowfishUtils().encode(mdpGenere));
					/*if(this.contactAccordAValider.getCivilite()!=null){
						this.contactAccordAValider.setIdCivilite(this.contactAccordAValider.getCivilite().getId());
					}*/
					if(!getStructureDomainService().updateContact(this.contactAccordAValider)){
						addErrorMessage(null, "ACCORD.ERREUR_VALIDATION", "updateContact");
					}
					if(!getStructureDomainService().updateCompteContact(this.contactAccordAValider)){
						addErrorMessage(null, "ACCORD.ERREUR_VALIDATION", "updateCompteContact");
					}
					//M�j accord
					this.accordPartenariatAValider.setEstValide(true);
					this.accordPartenariatAValider.setLoginValidation(login);
					if(!getStructureDomainService().updateAccord(this.accordPartenariatAValider)){
						addErrorMessage(null, "ACCORD.ERREUR_VALIDATION", "updateAccord");
					}
					
					this.structureAccordAValider.setAccordPartenariat(accordPartenariatAValider);
					if(getSessionController().getCurrentManageStructure()!=null &&
							getSessionController().getCurrentManageStructure().getIdStructure()==
						this.structureAccordAValider.getIdStructure()){
						getSessionController().setCurrentManageStructure(this.structureAccordAValider);
					}
					if(this.rechercheController.getListeResultatsRechercheStructure()!=null){
						this.rechercheController.getListeResultatsRechercheStructure().remove(this.structureAccordAValider);
					}else{
						this.rechercheController.setListeResultatsRechercheStructure(null);
						this.rechercheController.setResultatRechercheStructure(null);
					}
					if(StringUtils.hasText(getSessionController().getMailingListEntr())){
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
								getString("MAIL.ADMIN.ACCORD.SUJETVALIDATION", getSessionController().getApplicationNameEntreprise(), this.structureAccordAValider.printAdresse(), infoPersonne),
								getString("MAIL.ADMIN.ACCORD.MESSAGEVALIDATION", getSessionController().getApplicationNameEntreprise(), this.structureAccordAValider.printAdresse(), infoPersonne),
								""
						);
					}
					try {
						InternetAddress ia = new InternetAddress(this.contactAccordAValider.getMail());
						ia.validate();

						getSmtpService().send(ia, getString("MAIL.COMPTEVALIDATIONACCORD.SUJET", getSessionController().getApplicationNameEntreprise()), 
							getString("MAIL.COMPTEVALIDATIONACCORD.MESSAGE",
								this.contactAccordAValider.getLogin(), getBlowfishUtils().decode(this.contactAccordAValider.getMdp()),
								getSessionController().getEntrepriseUrl(), getSessionController().getApplicationNameEntreprise()),
						"");
					} catch (AddressException e) {
						if(logger.isDebugEnabled()){
							e.printStackTrace();
						}
						addErrorMessage(null, "MAIL.VALIDATION");
					}
					ret="_validationAccordEtape3Confirmation";
					addInfoMessage(null, "ACCORD.VALIDATION.CONFIRMATION", this.structureAccordAValider.getRaisonSociale(), this.contactAccordAValider.getMail());
					this.structureAccordAValider=null;
					this.contactAccordAValider=null;
					this.accordPartenariatAValider=null;
				}catch (DataUpdateException e) {
					if(logger.isInfoEnabled()){
						logger.info("DataUpdateException ",e.fillInStackTrace());
					}
					addErrorMessage(null, "ACCORD.ERREUR_VALIDATION", e.getMessage());
				}catch (WebServiceDataBaseException e) {
					if(logger.isInfoEnabled()){
						logger.info("WebServiceDataBaseException ",e.fillInStackTrace());
					}
					addErrorMessage(null, "ACCORD.ERREUR_VALIDATION", e.getMessage());
				}catch (AccordAlreadyExistingForStructureException e) {
					if(logger.isInfoEnabled()){
						logger.info("AccordAlreadyExistingForStructureException ",e.fillInStackTrace());
					}
					addErrorMessage(null, "ACCORD.ERREUR_VALIDATION.ACCORDEXISTANT", e.getMessage());
				}catch (AccordAlreadyExistingForContactException e) {
					if(logger.isInfoEnabled()){
						logger.info("AccordAlreadyExistingForContactException ",e.fillInStackTrace());
					}
					addErrorMessage(null, "ACCORD.ERREUR_VALIDATION.ACCORDEXISTANT", e.getMessage());
				}catch (UnvalidNumSiretException e) {
					if(logger.isInfoEnabled()){
						logger.info("UnvalidNumSiretException ",e.fillInStackTrace());
					}
					addErrorMessage(null, "ACCORD.ERREUR_VALIDATION.ERREURSIRET", e.getMessage());
				}catch (AccountAlreadyExistingForCoupleMailStructureException e) {
					if(logger.isInfoEnabled()){
						logger.info("AccountAlreadyExistingForCoupleMailStructureException ",e.fillInStackTrace());
					}
					addErrorMessage(null, "ACCORD.ERREUR_VALIDATION.MAILEXISTANT", e.getMessage());
				}catch (MailAlreadyUsedForStructureException e) {
					if(logger.isInfoEnabled()){
						logger.info("MailAlreadyUsedForStructureException ",e.fillInStackTrace());
					}
					addErrorMessage(null, "ACCORD.ERREUR_VALIDATION.MAILEXISTANT", e.getMessage());
				}catch (StructureNumSiretException e) {
					if(logger.isInfoEnabled()){
						logger.info("StructureNumSiretException ",e.fillInStackTrace());
					}
					addErrorMessage(null, "ACCORD.ERREUR_VALIDATION.STRUCTURESIRET", e.getMessage());
				}
			}else{
				addErrorMessage(null, "ACCORD.DEJAVALIDE");
			}
		}
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String goToConsulterAccord(){
		String ret=null;
		if(this.structureAccord!=null && this.structureAccord.getIdStructure()>0
				&& this.structureAccord.getAccordPartenariat()!=null && this.structureAccord.getAccordPartenariat().getIdAccordPartenariat()>0){
			this.structureAccord.getAccordPartenariat().setContact(
					getStructureDomainService().getContactFromId(this.structureAccord.getAccordPartenariat().getIdContact()));
			ret="affichageAccord";
		}
		return ret;
	}
	
	/**
	 * @return String
	 */
	public String supprimerAccord(){
		String ret=null;
		try{
			if(this.accordASupprimer!=null && this.accordASupprimer.getAccordPartenariat()!=null
					&& this.accordASupprimer.getAccordPartenariat().getIdAccordPartenariat()>0){
				if(getStructureDomainService().deleteAccord(this.accordASupprimer.getAccordPartenariat().getIdAccordPartenariat())){
					addInfoMessage(null, "ACCORD.SUPPRESSION.CONFIRMATION", this.accordASupprimer.getRaisonSociale());
					this.accordASupprimer.setAccordPartenariat(null);
					if(StringUtils.hasText(getSessionController().getMailingListEntr())){
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
								getString("MAIL.ADMIN.ACCORD.SUJETSUPPR", getSessionController().getApplicationNameEntreprise(), this.accordASupprimer.printAdresse(), infoPersonne),
								getString("MAIL.ADMIN.ACCORD.MESSAGESUPPR", getSessionController().getApplicationNameEntreprise(), this.accordASupprimer.printAdresse(), infoPersonne),
								""
						);
					}
				}else{
					addErrorMessage(null, "ACCORD.SUPPRESSION.ERREUR", this.accordASupprimer.getRaisonSociale());
				}
			}
		}catch (DataDeleteException e) {
			logger.error("DataDeleteException", e.fillInStackTrace());
			addErrorMessage(null, "ACCORD.SUPPRESSION.ERREUR",this.accordASupprimer.getRaisonSociale());
		}catch (WebServiceDataBaseException e) {
			logger.error("WebServiceDataBaseException", e.fillInStackTrace());
			addErrorMessage(null, "ACCORD.SUPPRESSION.ERREUR",this.accordASupprimer.getRaisonSociale());
		}
		if(this.rechercheController.getListeResultatsRechercheStructure()!=null){
			this.rechercheController.getListeResultatsRechercheStructure().remove(this.accordASupprimer);
			this.rechercheController.setResultatRechercheStructure(null);
		}else{
			this.rechercheController.setListeResultatsRechercheStructure(null);
			this.rechercheController.setResultatRechercheStructure(null);
		}
		this.accordASupprimer=null;
		ret="_supprAccordEtape2Confirmation";
		return ret;
	}

	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/

	/**
	 * @return the formAdminStructure
	 */
	public AdminStructureDTO getFormAdminStructure() {
		return formAdminStructure;
	}

	/**
	 * @param formAdminStructure the formAdminStructure to set
	 */
	public void setFormAdminStructure(AdminStructureDTO formAdminStructure) {
		this.formAdminStructure = formAdminStructure;
	}

	/**
	 * @return the formAdminMdpConfirmation
	 */
	public String getFormAdminMdpConfirmation() {
		return formAdminMdpConfirmation;
	}

	/**
	 * @param formAdminMdpConfirmation the formAdminMdpConfirmation to set
	 */
	public void setFormAdminMdpConfirmation(String formAdminMdpConfirmation) {
		this.formAdminMdpConfirmation = formAdminMdpConfirmation;
	}

	/**
	 * @return the listeAdminStructure
	 */
	public List<AdminStructureDTO> getListeAdminStructure() {
		return listeAdminStructure;
	}

	/**
	 * @param listeAdminStructure the listeAdminStructure to set
	 */
	public void setListeAdminStructure(List<AdminStructureDTO> listeAdminStructure) {
		this.listeAdminStructure = listeAdminStructure;
	}

	/**
	 * @return the keysAdminStructure
	 */
	public Set<Integer> getKeysAdminStructure() {
		return keysAdminStructure;
	}

	/**
	 * @param keysAdminStructure the keysAdminStructure to set
	 */
	public void setKeysAdminStructure(Set<Integer> keysAdminStructure) {
		this.keysAdminStructure = keysAdminStructure;
	}

	/**
	 * @return the currentRowAdminStructure
	 */
	public int getCurrentRowAdminStructure() {
		return currentRowAdminStructure;
	}

	/**
	 * @param currentRowAdminStructure the currentRowAdminStructure to set
	 */
	public void setCurrentRowAdminStructure(int currentRowAdminStructure) {
		this.currentRowAdminStructure = currentRowAdminStructure;
	}

	/**
	 * @return the typeCompteAdminStructure
	 */
	public int getTypeCompteAdminStructure() {
		return typeCompteAdminStructure;
	}

	/**
	 * @param typeCompteAdminStructure the typeCompteAdminStructure to set
	 */
	public void setTypeCompteAdminStructure(int typeCompteAdminStructure) {
		this.typeCompteAdminStructure = typeCompteAdminStructure;
	}

	/**
	 * @return the listTypeCompteAdminStructure
	 */
	public List<SelectItem> getListTypeCompteAdminStructure() {
		listTypeCompteAdminStructure=new ArrayList<SelectItem>();
		listTypeCompteAdminStructure.add(new SelectItem(0,getFacesInfoMessage("ADMINSTRUCTURE.TYPECOMPTE_LOCAL").getSummary()));
		listTypeCompteAdminStructure.add(new SelectItem(1,getFacesInfoMessage("ADMINSTRUCTURE.TYPECOMPTE_CAS").getSummary()));
		listTypeCompteAdminStructure.add(new SelectItem(2,getFacesInfoMessage("ADMINSTRUCTURE.TYPECOMPTE_SHIBB").getSummary()));
		return listTypeCompteAdminStructure;
	}

	/**
	 * @param listTypeCompteAdminStructure the listTypeCompteAdminStructure to set
	 */
	public void setListTypeCompteAdminStructure(
			List<SelectItem> listTypeCompteAdminStructure) {
		this.listTypeCompteAdminStructure = listTypeCompteAdminStructure;
	}

	/**
	 * @return the accordPartenariatAValider
	 */
	public AccordPartenariatDTO getAccordPartenariatAValider() {
		return accordPartenariatAValider;
	}

	/**
	 * @param accordPartenariatAValider the accordPartenariatAValider to set
	 */
	public void setAccordPartenariatAValider(
			AccordPartenariatDTO accordPartenariatAValider) {
		this.accordPartenariatAValider = accordPartenariatAValider;
	}

	/**
	 * @return the structureAccordAValider
	 */
	public StructureDTO getStructureAccordAValider() {
		return structureAccordAValider;
	}

	/**
	 * @param structureAccordAValider the structureAccordAValider to set
	 */
	public void setStructureAccordAValider(StructureDTO structureAccordAValider) {
		this.structureAccordAValider = structureAccordAValider;
	}

	/**
	 * @return the contactAccordAValider
	 */
	public ContactDTO getContactAccordAValider() {
		return contactAccordAValider;
	}

	/**
	 * @param contactAccordAValider the contactAccordAValider to set
	 */
	public void setContactAccordAValider(ContactDTO contactAccordAValider) {
		this.contactAccordAValider = contactAccordAValider;
	}

	/**
	 * @return the structureAccord
	 */
	public StructureDTO getStructureAccord() {
		return structureAccord;
	}

	/**
	 * @param structureAccord the structureAccord to set
	 */
	public void setStructureAccord(StructureDTO structureAccord) {
		this.structureAccord = structureAccord;
	}

	/**
	 * @return the accordASupprimer
	 */
	public StructureDTO getAccordASupprimer() {
		return accordASupprimer;
	}

	/**
	 * @param accordASupprimer the accordASupprimer to set
	 */
	public void setAccordASupprimer(StructureDTO accordASupprimer) {
		this.accordASupprimer = accordASupprimer;
	}

	/**
	 * @return the statutsJuridiquesListening
	 */
	public List<SelectItem> getStatutsJuridiquesListening() {
		return statutsJuridiquesListening;
	}

	/**
	 * @param statutsJuridiquesListening the statutsJuridiquesListening to set
	 */
	public void setStatutsJuridiquesListening(
			List<SelectItem> statutsJuridiquesListening) {
		this.statutsJuridiquesListening = statutsJuridiquesListening;
	}

	/**
	 * @return the accordAValiderStructureCommuneDTO
	 */
	public CommuneDTO getAccordAValiderStructureCommuneDTO() {
		return accordAValiderStructureCommuneDTO;
	}

	/**
	 * @param accordAValiderStructureCommuneDTO the accordAValiderStructureCommuneDTO to set
	 */
	public void setAccordAValiderStructureCommuneDTO(
			CommuneDTO accordAValiderStructureCommuneDTO) {
		this.accordAValiderStructureCommuneDTO = accordAValiderStructureCommuneDTO;
	}

	/**
	 * @return the communesListening
	 */
	public List<SelectItem> getCommunesListening() {
		return communesListening;
	}

	/**
	 * @return the rechercheController
	 */
	public RechercheController getRechercheController() {
		return rechercheController;
	}

	/**
	 * @param rechercheController the rechercheController to set
	 */
	public void setRechercheController(RechercheController rechercheController) {
		this.rechercheController = rechercheController;
	}


}
