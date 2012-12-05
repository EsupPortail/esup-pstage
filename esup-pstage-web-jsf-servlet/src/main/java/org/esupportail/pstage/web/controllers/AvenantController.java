/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.esupportail.pstage.exceptions.ExportException;
import org.esupportail.pstage.services.export.CastorService;
import org.esupportail.pstage.web.utils.PDFUtils;
import org.esupportail.pstagedata.domain.beans.Enseignant;
import org.esupportail.pstagedata.domain.dto.AvenantDTO;
import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.esupportail.pstagedata.domain.dto.EtudiantDTO;
import org.esupportail.pstagedata.domain.dto.ServiceDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;


public class AvenantController extends AbstractContextAwareController {

	/* ***************************************************************
	 * Propriétés
	 ****************************************************************/
	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -239570715531002003L;
	/**
	 * Logger.
	 */
	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * True si aucun avenant n'a été ajouté
	 */
	private boolean listeAvenantVide;
	/**
	 * ListeAvenants
	 */
	@SuppressWarnings("unused")
	private List<AvenantDTO> listeAvenants;

	/**
	 * ListeServices
	 */
	@SuppressWarnings("unused")
	private List<ServiceDTO> listeServices;

	/**
	 * ListeSalaries
	 */
	@SuppressWarnings("unused")
	private List<ContactDTO> listeSalaries;

	/**
	 * Avenant
	 */
	private AvenantDTO avenant;

	/**
	 * EtablissementController
	 */
	private EtablissementController etablissementController;

	/**
	 * The ConventionController
	 */
	private ConventionController conventionController;

	/**
	 * Service to generate Xml.
	 */
	private CastorService castorService;
	
	/**
	 * editAvFR.
	 */
	private boolean editAvFR = false;
	
	/**
	 * Bean constructor.
	 */
	public AvenantController() {
		super();
	}

	/* ***************************************************************
	 * Actions
	 ****************************************************************/	
	/**
	 * @return boolean
	 */
	public boolean listeAvenantVide(){
		if ((getAvenantDomainService().getNombreAvenant(conventionController.getConvention().getIdConvention())) > 0){
			return false;
		}
		return true;
	}
	/**
	 * @return String
	 */
	public String goToListeAvenant(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: goToListeAvenant");
		}
		return "conventionEtape11ListeAvenant";
	}

	/**
	 * @return String
	 */
	public String goToCreaAvenantPage1(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: goToCreaAvenantPage1");
		}
		etablissementController.setFormService(new ServiceDTO());
		etablissementController.setFormContact(new ContactDTO());
		etablissementController.setServiceSel(conventionController.getConvention().getService());
		etablissementController.setContactSel(conventionController.getConvention().getContact());
		this.avenant = new AvenantDTO();

		return "conventionEtape11CreaAvenantPage1";
	}

	/**
	 * @return String
	 */
	public String rectifierAvenant(){
		if (logger.isDebugEnabled()){
			logger.debug("AvenantController:: rectifierAvenant");
		}
		// On ne reinitialise rien pour que l'utilisateur n'ait pas a tout retaper lors de sa rectification
		return "conventionEtape11CreaAvenantPage1";
	}

	/**
	 * @return String
	 */
	public String goToCreaAvenantPage2(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: goToCreaAvenantPage2");
		}
		if(!this.avenant.isRupture()
				&& !this.avenant.isModificationSujet()
				&& !this.avenant.isModificationPeriode()
				&& !this.avenant.isModificationMontantGratification()
				&& !this.avenant.isModificationLieu()
				&& !this.avenant.isModificationSalarie()
				&& !this.avenant.isModificationEnseignant()){
			addErrorMessage("formCreaAvenantPage1:erreurCreation", "CONVENTION.ETAPE11.ERREUR_TYPE");
			return null;
		}
		if(!this.avenant.isRupture()){
			if (this.avenant.isModificationPeriode()){
				java.util.Date dateDebutStage = this.avenant.getDateDebutStage();
				java.util.Date dateFinStage = this.avenant.getDateFinStage();
				java.util.Date dateDebutInterruption = this.avenant.getDateDebutInterruption();
				java.util.Date dateFinInterruption = this.avenant.getDateFinInterruption();
				if (dateFinStage != null && dateDebutStage != null){
					if (dateFinStage.before(dateDebutStage)){
						// Si la date de fin du stage est inferieure la date de debut
						addErrorMessage("formCreaAvenantPage1:erreurPeriode", "CONVENTION.ETAPE11.ERREUR_PERIODE");
						return null;
					}
				} else {
					addErrorMessage("formCreaAvenantPage1:erreurPeriode", "CONVENTION.ETAPE11.ERREUR_PERIODE2");
					return null;
				}
				if(this.avenant.isInterruptionStage()){
					if (dateDebutInterruption.before(dateDebutStage) 
							|| dateDebutInterruption.after(dateFinStage) 
							|| dateDebutInterruption.after(dateFinInterruption)
							|| dateFinInterruption.after(dateFinStage)
							|| dateFinInterruption.before(dateDebutStage)
							|| dateFinInterruption.before(dateDebutInterruption)){
						// Si la date de debut d'interruption est inferieure a la date de debut du stage, ou superieure aux dates de fin d'interruption ou de stage
						// ou si la date de fin d'interruption est superieure a la date de fin de stage, ou inferieure aux dates de debut d'interruption ou de stage
						addErrorMessage("formCreaAvenantPage1:erreurInterruption", "CONVENTION.ETAPE11.ERREUR_INTERRUPTION");
						return null;
					}
				}
			}
			if(this.avenant.isModificationLieu()){
				if (etablissementController.getServiceSel().getIdService() == conventionController.getConvention().getIdService()){
					// Si l'idService n'a pas été changé, on envoie l'erreur correspondante
					addErrorMessage("formCreaAvenantPage1:erreurService","CONVENTION.ETAPE11.ERREUR_SERVICE");
					return null;
				}
				if (etablissementController.getContactSel().getId() == conventionController.getConvention().getIdContact()){
					// Si l'idContact n'a pas été changé, on envoie l'erreur correspondante
					addErrorMessage("formCreaAvenantPage1:erreurSalarie","CONVENTION.ETAPE11.ERREUR_SALARIE");
					return null;
				}
				this.avenant.setIdService(etablissementController.getServiceSel().getIdService());
				this.avenant.setService(etablissementController.getServiceSel());
				this.avenant.setModificationSalarie(true);
			}
			if(this.avenant.isModificationSalarie()){
				if (etablissementController.getContactSel().getId() == conventionController.getConvention().getIdContact()){
					// Si l'idContact n'a pas été changé, on envoie l'erreur correspondante
					addErrorMessage("formCreaAvenantPage1:erreurSalarie","CONVENTION.ETAPE11.ERREUR_SALARIE");
					return null;
				}
				this.avenant.setIdContact(etablissementController.getContactSel().getId());
				this.avenant.setContact(etablissementController.getContactSel());
			}
		}
		return "conventionEtape11CreaAvenantPage2";
	}

	/**
	 * @return String
	 */
	public String goToDetailAvenant(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: goToDetailAvenant");
		}
		return "conventionEtape11DetailsAvenant";
	}

	/**
	 * @return String
	 */
	public String goToModifAvenantPage1(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: goToModifAvenantPage1");
		}
		etablissementController.setFormService(new ServiceDTO());
		etablissementController.setFormContact(new ContactDTO());
		if (this.avenant.getService() != null){
			etablissementController.setServiceSel(this.avenant.getService());
		} else {
			etablissementController.setServiceSel(conventionController.getConvention().getService());
		}
		if (this.avenant.getContact() != null){
			etablissementController.setContactSel(this.avenant.getContact());
		} else {
			etablissementController.setContactSel(conventionController.getConvention().getContact());
		}
		return "conventionEtape11ModifAvenantPage1";
	}
	
	/**
	 * 
	 */
	public void avantRechercheEnseignant(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: avantRechercheEnseignant");
		}
		conventionController.setResultatEnseignant(new EnseignantDTO());
		conventionController.setListeEnseignant(new ArrayList<EnseignantDTO>());
		conventionController.setListeResultatsRechercheEnseignant(new ArrayList<Enseignant>());
	}
	
	/**
	 * @return String
	 */
	public String goToModifAvenantPage2(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: goToModifAvenantPage2");
		}
		if(!this.avenant.isRupture()
				&& !this.avenant.isModificationSujet()
				&& !this.avenant.isModificationPeriode()
				&& !this.avenant.isModificationMontantGratification()
				&& !this.avenant.isModificationLieu()
				&& !this.avenant.isModificationSalarie()
				&& !this.avenant.isModificationEnseignant()){
			addErrorMessage("formModifAvenantPage1:erreurModification", "CONVENTION.ETAPE11.ERREUR_TYPE");
			return null;
		}
		if(!this.avenant.isRupture()){
			if (this.avenant.isModificationPeriode()){
				java.util.Date dateDebutStage = this.avenant.getDateDebutStage();
				java.util.Date dateFinStage = this.avenant.getDateFinStage();
				java.util.Date dateDebutInterruption = this.avenant.getDateDebutInterruption();
				java.util.Date dateFinInterruption = this.avenant.getDateFinInterruption();
				
				if (dateFinStage != null && dateDebutStage != null){
					if (dateFinStage.before(dateDebutStage)){
						// Si la date de fin du stage est inferieure la date de debut
						addErrorMessage("formModifAvenantPage1:erreurPeriode", "CONVENTION.ETAPE11.ERREUR_PERIODE");
						return null;
					}
				} else {
					addErrorMessage("formModifAvenantPage1:erreurPeriode", "CONVENTION.ETAPE11.ERREUR_PERIODE2");
					return null;
				}
				if(this.avenant.isInterruptionStage()){
					if (dateDebutInterruption.before(dateDebutStage) 
							|| dateDebutInterruption.after(dateFinStage) 
							|| dateDebutInterruption.after(dateFinInterruption)
							|| dateFinInterruption.after(dateFinStage)
							|| dateFinInterruption.before(dateDebutStage)
							|| dateFinInterruption.before(dateDebutInterruption)){
						// Si la date de debut d'interruption est inferieure a la date de debut du stage, ou superieure aux dates de fin d'interruption ou de stage
						// ou si la date de fin d'interruption est superieure a la date de fin de stage, ou inferieure aux dates de debut d'interruption ou de stage
						addErrorMessage("formModifAvenantPage1:erreurInterruption", "CONVENTION.ETAPE11.ERREUR_INTERRUPTION");
						return null;
					}
				}
			}
			if(this.avenant.isModificationLieu()){
				if (etablissementController.getServiceSel().getIdService() == conventionController.getConvention().getIdService()){
					// Si l'idService n'a pas été changé, on envoie l'erreur correspondante
					addErrorMessage("formModifAvenantPage1:erreurService","CONVENTION.ETAPE11.ERREUR_SERVICE");
					return null;
				}
				if (etablissementController.getContactSel().getId() == conventionController.getConvention().getIdContact()){
					// Si l'idContact n'a pas été changé, on envoie l'erreur correspondante
					addErrorMessage("formModifAvenantPage1:erreurSalarie","CONVENTION.ETAPE11.ERREUR_SALARIE");
					return null;
				}
				this.avenant.setIdService(etablissementController.getServiceSel().getIdService());
				this.avenant.setService(etablissementController.getServiceSel());
				this.avenant.setModificationSalarie(true);
			}
			if(this.avenant.isModificationSalarie()){
				if (etablissementController.getContactSel().getId() == conventionController.getConvention().getIdContact()){
					// Si l'idContact n'a pas été changé, on envoie l'erreur correspondante
					addErrorMessage("formModifAvenantPage1:erreurSalarie","CONVENTION.ETAPE11.ERREUR_SALARIE");
					return null;
				}
				this.avenant.setIdContact(etablissementController.getContactSel().getId());
				this.avenant.setContact(etablissementController.getContactSel());
			}
		}
		return "conventionEtape11ModifAvenantPage2";
	}

	/**
	 * @return String
	 */
	public String creerAvenant(){

		if(logger.isDebugEnabled()){
			logger.debug("public String creerAvenant()");
			logger.debug("Propriétés de l'avenant ajouté : "+ this.avenant);
		}
		
		if (this.avenant.isModificationEnseignant()){
			// S'il ya modification de l'enseignant, on crée le nouveau s'il n'existe pas deja
			EnseignantDTO enseignantTmp = this.avenant.getEnseignant();
			enseignantTmp.setLoginCreation(getSessionController().getCurrentLogin());
			enseignantTmp.setCodeAffectation("");
			enseignantTmp.setCodeUniversiteAffectation(getSessionController().getCodeUniversite());
			if (logger.isDebugEnabled()) {
				logger.debug("AvenantController:: goToAjouterConvention "); 
				if (enseignantTmp != null) { 
					logger.debug("this.avenant.getEnseignant() " + enseignantTmp.getUidEnseignant());
				}
			}
			try {
				int idEnseignant = this.getEnseignantDomainService().addEnseignant(enseignantTmp);

				if (logger.isInfoEnabled()) {
					logger.info("Ajout enseignant : " + enseignantTmp.getUidEnseignant());
				}

				if (idEnseignant > 0) {
					this.avenant.setIdEnseignant(idEnseignant);
				}

			} catch (DataAddException ae) {
				logger.error("DataAddException", ae.fillInStackTrace());
				addErrorMessage("formCreaAvenantPage2:erreurAjoutAvenant", "CONVENTION.CREERCONVENTION.ERREURAJOUT");
				return null;
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
				addErrorMessage("formCreaAvenantPage2:erreurAjoutAvenant", "CONVENTION.CREERCONVENTION.ENSEIGNANT.ERREUR", we.getMessage());
				return null;
			}
		}
		if (this.avenant.isModificationMontantGratification()){
			avenant.setIdUniteGratification(this.avenant.getUniteGratification().getId());
		}
		
		avenant.setLoginCreation(getSessionController().getCurrentLogin());

		avenant.setIdConvention(conventionController.getConvention().getIdConvention());

		try{
			// Ajout Avenant
			int idAvenant = getAvenantDomainService().addAvenant(this.avenant);

			if(logger.isDebugEnabled()){
				logger.debug("idAvenant : " + idAvenant);
			}
		} catch (DataAddException d){
			logger.error("DataAddException",d.fillInStackTrace());
			addErrorMessage("formCreaAvenantPage2:erreurAjoutAvenant","CONVENTION.ETAPE11.ERREUR_AJOUT");
			return null;
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formCreaAvenantPage2:erreurAjoutAvenant", "CONVENTION.ETAPE11.ERREUR_WS");
			return null;
		}

		this.avenant = new AvenantDTO();

		return "conventionEtape11ListeAvenant";
	}

	/**
	 * @return String
	 */
	public String modifierAvenant(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: modifierAvenant");
		}

		if (this.avenant.isModificationEnseignant()){
			// S'il ya modification de l'enseignant, on crée le nouveau s'il n'existe pas deja
			EnseignantDTO enseignantTmp = this.avenant.getEnseignant();
			enseignantTmp.setLoginCreation(getSessionController().getCurrentLogin());
			enseignantTmp.setCodeUniversiteAffectation(getSessionController().getCodeUniversite());
			if (logger.isDebugEnabled()) {
				logger.debug("AvenantController:: goToAjouterConvention "); 
				if (enseignantTmp != null) { 
					logger.debug("this.avenant.getEnseignant() " + enseignantTmp.getUidEnseignant());
				}
			}
			try {
				int idEnseignant = this.getEnseignantDomainService().addEnseignant(enseignantTmp);
				if (logger.isInfoEnabled()) {
					logger.info("Ajout enseignant : " + enseignantTmp.getUidEnseignant());
				}
				if (idEnseignant > 0) {
					this.avenant.setIdEnseignant(idEnseignant);
				}

			} catch (DataAddException ae) {
				logger.error("DataAddException", ae.fillInStackTrace());
				addErrorMessage("formModifAvenantPage1:erreurModifAvenant", "CONVENTION.CREERCONVENTION.ERREURAJOUT");
				return null;
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
				addErrorMessage("formModifAvenantPage1:erreurModifAvenant", "CONVENTION.CREERCONVENTION.ENSEIGNANT.ERREUR", we.getMessage());
				return null;
			}
		}

		if (this.avenant.isModificationMontantGratification()){
			avenant.setIdUniteGratification(this.avenant.getUniteGratification().getId());
		}
		
		avenant.setLoginModif(getSessionController().getCurrentLogin());
		
		try{
			// Modification de l'avenant
			getAvenantDomainService().updateAvenant(this.avenant);

		} catch (DataUpdateException d){
			logger.error("DataUpdateException",d.fillInStackTrace());
			addErrorMessage("formModifAvenantPage1:erreurModifAvenant","CONVENTION.ETAPE11.ERREUR_MODIF");
			return null;
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formModifAvenantPage1:erreurModifAvenant", "CONVENTION.ETAPE11.ERREUR_WS");
			return null;
		}

		return "conventionEtape11DetailsAvenant";
	}

	/**
	 * @return String
	 */
	public String supprimerAvenant(){
		if(this.avenant!=null){
			try{
				if(logger.isDebugEnabled()){
					logger.debug("Suppression Avenant : "+this.avenant);
				}
				getAvenantDomainService().deleteAvenant(this.avenant.getIdAvenant());
			}catch (DataDeleteException de) {
				logger.error("DataDeleteException ",de.fillInStackTrace());
				addErrorMessage("formSupprAvenant:erreurSupprAvenant", "CONVENTION.ETAPE11.ERREUR_SUPPRESSION", de.getMessage());
				return null;
			}catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ",we.fillInStackTrace());
				addErrorMessage("formSupprAvenant:erreurSupprAvenant", "CONVENTION.ETAPE11.ERREUR_WS", we.getMessage());
				return null;
			}
			this.avenant = new AvenantDTO();
		}
		return "conventionEtape11ListeAvenant";
	}

	/**
	 * @return boolean
	 */
	public String validerAvenant(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: validerAvenant");
		}
		if(this.avenant!=null){
			try{
				if(logger.isDebugEnabled()){
					logger.debug("Validation Avenant : "+this.avenant);
				}
				this.avenant.setValidationAvenant(true);
				getAvenantDomainService().updateAvenant(this.avenant);
			}catch (DataDeleteException d) {
				logger.error("DataUpdateException ",d.fillInStackTrace());
				addErrorMessage("formDetailsAvenant:erreurValidAvenant", "CONVENTION.ETAPE11.ERREUR_VALIDATION", d.getMessage());
				return null;
			}catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ",we.fillInStackTrace());
				addErrorMessage("formDetailsAvenant:erreurValidAvenant", "CONVENTION.ETAPE11.ERREUR_WS", we.getMessage());
				return null;
			}
		}
		return "conventionEtape11DetailsAvenant";
	}

	/**
	 * @return String
	 */
	public String devaliderAvenant(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: devaliderAvenant");
		}
		if(this.avenant!=null){
			try{
				if(logger.isDebugEnabled()){
					logger.debug("Devalidation Avenant : " + this.avenant);
				}
				this.avenant.setValidationAvenant(false);
				getAvenantDomainService().updateAvenant(this.avenant);
			}catch (DataDeleteException d) {
				logger.error("DataUpdateException ",d.fillInStackTrace());
				addErrorMessage("formDetailsAvenant:erreurDevalidAvenant", "CONVENTION.ETAPE11.ERREUR_VALIDATION", d.getMessage());
				return null;
			}catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ",we.fillInStackTrace());
				addErrorMessage("formDetailsAvenant:erreurDevalidAvenant", "CONVENTION.ETAPE11.ERREUR_WS", we.getMessage());
				return null;
			}
		}
		return "conventionEtape11DetailsAvenant";
	}
	
	/**
	 * @return String
	 */
	public String editPdfAvenantFr() {
		String retour = null;
		this.editAvFR = true;
		retour = editPdfAvenant();
		return retour;
	}
	/**
	 * @return String
	 */
	public String editPdfAvenant() {
		String retour = null;

		try	{

			/**
			 **  Methodes de creation des documents PDF selon l'edition demandee
			 **/
			//StringBuffer sbFilename = new StringBuffer();
			String nomDocxsl = "";
			String fileNameXml = "";
			String fileNameXmlfin = ".xml";
			//String xslXmlPath = castorService.getXslXmlPath();
			String language = "fr";
			String idAvenant = this.avenant.getIdAvenant().toString();
			this.avenant.setConvention(conventionController.getConvention());
			EtudiantDTO etudiant = conventionController.getConvention().getEtudiant();
			fileNameXml = "avenant_" + idAvenant;
			if (conventionController.getConvention().getCodeLangueConvention() != null) {
				language = conventionController.getConvention().getCodeLangueConvention();
			}
			if (this.editAvFR) {
				language = "fr";
			}
			nomDocxsl = "avenant" + "_" + language + ".xsl";
			if (etudiant != null) {
				fileNameXml = fileNameXml + ("_" + etudiant.getPrenom() + "_" + etudiant.getNom());
			}

			// appel castor pour fichier xml a partir de objet java convention

			castorService.objectToFileXml(this.avenant, fileNameXml + fileNameXmlfin);
			//fusion du xsl et xml en pdf
			String fileNamePdf = fileNameXml + ".pdf";

			PDFUtils.exportPDF(fileNameXml + fileNameXmlfin, FacesContext.getCurrentInstance(), 
					castorService.getXslXmlPath(),
					fileNamePdf, nomDocxsl);
			addInfoMessage(null, "CONVENTION.IMPRESSION.CONFIRMATION");
			this.editAvFR = false;
		} catch (ExportException e) {
			logger.error("ExportException ", e.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.EDIT.CONVENTION.ERREUR", e.getMessage());
		}
		return retour;
	}
	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/

	/**
	 * @param listeAvenantVide the listeAvenantVide to set
	 */
	public void setListeAvenantVide(boolean listeAvenantVide) {
		this.listeAvenantVide = listeAvenantVide;
	}
	/**
	 * @return the listeAvenantVide
	 */
	public boolean isListeAvenantVide() {
		listeAvenantVide = this.listeAvenantVide();
		return listeAvenantVide;
	}

	/**
	 * @return the listeAvenants
	 */
	public List<AvenantDTO> getListeAvenants() {
		List<AvenantDTO> l = getAvenantDomainService().getAvenant(conventionController.getConvention().getIdConvention());
		return l;
	}

	/**
	 * @return the listeServices
	 */
	public List<ServiceDTO> getListeServices() {
		List<ServiceDTO> l = getStructureDomainService().getServicesFromIdStructure(conventionController.getConvention().getIdStructure());
		return l;
	}

	/**
	 * @return the listeSalaries
	 */
	public List<ContactDTO> getListeSalaries() {
		List<Integer> idsCentreGestion = new ArrayList<Integer>();
		idsCentreGestion = getSessionController().getCurrentIdsCentresGestion();
		List<ContactDTO> l = getStructureDomainService().getContactsFromIdService(etablissementController.getServiceSel().getIdService(), idsCentreGestion, getSessionController().getCodeUniversite());
		return l;
	}
	
	/**
	 * @return String
	 */
	public String ajoutContact(){
		ContactDTO contactTmp = new ContactDTO();
		contactTmp.setIdCentreGestion(getConventionController().getConvention().getCentreGestion().getIdCentreGestion());
		getEtablissementController().setFormContact(contactTmp);
		return null;
	}
	
	/**
	 * @param avenant the avenant to set
	 */
	public void setAvenant(AvenantDTO avenant) {
		this.avenant = avenant;
	}

	/**
	 * @return the avenant
	 */
	public AvenantDTO getAvenant() {
		return avenant;
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
	 * @return the conventionController
	 */
	public ConventionController getConventionController() {
		return conventionController;
	}

	/**
	 * @param conventionController the conventionController to set
	 */
	public void setConventionController(ConventionController conventionController) {
		this.conventionController = conventionController;
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
	 * @return the editAvFR
	 */
	public boolean isEditAvFR() {
		return editAvFR;
	}

	/**
	 * @param editAvFR the editAvFR to set
	 */
	public void setEditAvFR(boolean editAvFR) {
		this.editAvFR = editAvFR;
	}
	
	
}
