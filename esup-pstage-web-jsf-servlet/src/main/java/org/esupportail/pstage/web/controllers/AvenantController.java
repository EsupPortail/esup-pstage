/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;
import org.esupportail.pstage.exceptions.ExportException;
import org.esupportail.pstage.services.export.CastorService;
import org.esupportail.pstage.web.utils.PDFUtils;
import org.esupportail.pstagedata.domain.dto.AvenantDTO;
import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.esupportail.pstagedata.domain.dto.EtudiantDTO;
import org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.ServiceDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.springframework.util.StringUtils;


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
	 * true si l'on choisi d'associer un texte libre a l'avenant
	 */
	private boolean modificationTexteLibre;

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

			if(this.avenant.isModificationMontantGratification()){
				if (this.avenant.getUniteDureeGratification() == null) {
					addErrorMessage("formCreaAvenantPage1:gratification", "CONVENTION.CREERCONVENTION.UNITEDUREEGRATIFICATION.OBLIGATOIRE");
					return null;
				} else if (this.avenant.getUniteGratification() == null) {
					// unite duree gratif obligatoire
					addErrorMessage("formCreaAvenantPage1:gratification", "CONVENTION.CREERCONVENTION.UNITEGRATIFICATION.OBLIGATOIRE");
					return null;
				}
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
			if(this.avenant.isModificationEnseignant()){
				if (this.avenant.getEnseignant() == null){
					// Si l'enseignant n'a pas été renseigné, on envoie l'erreur correspondante
					addErrorMessage("formCreaAvenantPage1:erreurEnseignant","CONVENTION.ETAPE11.ERREUR_ENSEIGNANT");
					return null;
				}
			}
			if(this.isModificationTexteLibre()){
				if (this.avenant.getMotifAvenant() == null){
					// Si l'enseignant n'a pas été renseigné, on envoie l'erreur correspondante
					addErrorMessage("formCreaAvenantPage1:erreurTexteLibre","CONVENTION.ETAPE11.ERREUR_TEXTELIBRE");
					return null;
				}
			}
		}
		else{
			// cas où il y a rupture, rentrer seulement la date de rupture

			java.util.Date dateDebutStage=conventionController.getConvention().getDateDebutStage();
			java.util.Date dateFinStage = conventionController.getConvention().getDateFinStage();
			java.util.Date dateRupture = this.avenant.getDateRupture();
			if (dateRupture != null){
				if (dateRupture.before(dateDebutStage) 
						|| dateRupture.after(dateFinStage)){
					// Si la date de debut d'interruption est inferieure a la date de debut du stage, ou superieure aux dates de fin d'interruption ou de stage
					// ou si la date de fin d'interruption est superieure a la date de fin de stage, ou inferieure aux dates de debut d'interruption ou de stage
					addErrorMessage("formCreaAvenantPage1:erreurDateRupture", "CONVENTION.ETAPE11.ERREUR_DATE_RUPTURE");
					return null;
				}
			}
			else {
				addErrorMessage("formCreaAvenantPage1:erreurDateRupture", "CONVENTION.ETAPE11.ERREUR_DATE_RUPTURE2");
				return null;
			}
		}

		// fin conditions, affiche page
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
		if (this.avenant.getMotifAvenant() != null && !this.avenant.getMotifAvenant().isEmpty()){
			this.modificationTexteLibre = true;
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
		conventionController.setListeResultatsRechercheEnseignant(new ArrayList<EnseignantDTO>());
	}

	/**
	 * @return String
	 */
	public String goToModifAvenantPage2(){
		if (logger.isDebugEnabled()) {
			logger.debug("AvenantController:: goToModifAvenantPage2");
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
			if(this.avenant.isModificationMontantGratification()){
				if (this.avenant.getUniteDureeGratification() == null) {
					addErrorMessage("formModifAvenantPage1:gratification", "CONVENTION.CREERCONVENTION.UNITEDUREEGRATIFICATION.OBLIGATOIRE");
					return null;
				} else if (this.avenant.getUniteGratification() == null) {
					// unite duree gratif obligatoire
					addErrorMessage("formModifAvenantPage1:gratification", "CONVENTION.CREERCONVENTION.UNITEGRATIFICATION.OBLIGATOIRE");
					return null;
				}
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
			if(this.avenant.isModificationEnseignant()){
				if (this.avenant.getEnseignant() == null){
					// Si l'enseignant n'a pas été renseigné, on envoie l'erreur correspondante
					addErrorMessage("formModifAvenantPage1:erreurCreation","CONVENTION.ETAPE11.ERREUR_ENSEIGNANT");
					return null;
				}
			}
			if(this.isModificationTexteLibre()){
				if (this.avenant.getMotifAvenant() == null){
					// Si l'enseignant n'a pas été renseigné, on envoie l'erreur correspondante
					addErrorMessage("formModifAvenantPage1:erreurTexteLibre","CONVENTION.ETAPE11.ERREUR_TEXTELIBRE");
					return null;
				}
			}
		} else {
			// cas où il y a rupture, rentrer seulement la date de rupture

			Date dateDebutStage=conventionController.getConvention().getDateDebutStage();
			Date dateFinStage = conventionController.getConvention().getDateFinStage();
			Date dateRupture = this.avenant.getDateRupture();
			if (dateRupture != null){
				if (dateRupture.before(dateDebutStage) 
						|| dateRupture.after(dateFinStage)){
					// Si la date de debut d'interruption est inferieure a la date de debut du stage, ou superieure aux dates de fin d'interruption ou de stage
					// ou si la date de fin d'interruption est superieure a la date de fin de stage, ou inferieure aux dates de debut d'interruption ou de stage
					addErrorMessage("formModifAvenantPage1:erreurDateRupture", "CONVENTION.ETAPE11.ERREUR_DATE_RUPTURE");
					return null;
				}
			}
			else {
				addErrorMessage("formModifAvenantPage1:erreurDateRupture", "CONVENTION.ETAPE11.ERREUR_DATE_RUPTURE2");
				return null;
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
			avenant.setIdUniteDureeGratification(this.avenant.getUniteDureeGratification().getId());
		}

		// Si c'est un gestionnaire qui crée, on valide automatiquement l'avenant
		if (getSessionController().getCurrentAuthEtudiant() == null) {
			avenant.setValidationAvenant(true);
		}

		avenant.setLoginCreation(getSessionController().getCurrentLogin());
		avenant.setIdConvention(conventionController.getConvention().getIdConvention());

		try{
			// Ajout Avenant
			int idAvenant = getAvenantDomainService().addAvenant(this.avenant);

			// Si c'est un étudiant qui crée l'avenant et qu'on est configurés en alertes mail pour les tuteurs et gestionnaires
			if (getSessionController().getCurrentAuthEtudiant() != null && getSessionController().isAvertissementPersonnelCreaAvenant()){

				String text=getString("ALERTES_MAIL.AVERTISSEMENT_PERSONNEL_CREA_AVENANT",
						idAvenant,
						this.avenant.getIdConvention(),
						getSessionController().getCurrentUser().getDisplayName());

				String sujet=getString("ALERTES_MAIL.AVERTISSEMENT_PERSONNEL_CREA_AVENANT.SUJET",
						this.avenant.getIdConvention());

				// Envoi d'une alerte à l'enseignant référent si telle est la configuration
				if (getSessionController().isAvertissementTuteurPedago()){
					if (conventionController.getConvention().getEnseignant().getMail() != null && !conventionController.getConvention().getEnseignant().getMail().isEmpty())
						getSmtpService().send(new InternetAddress(conventionController.getConvention().getEnseignant().getMail()),sujet,text,text);
				}
				// Envoi d'une alerte aux personnels du centre gestion configurés pour les recevoir
				List<PersonnelCentreGestionDTO> listePersonnels = getPersonnelCentreGestionDomainService().getPersonnelCentreGestionList(this.avenant.getIdConvention());

				if (listePersonnels != null){
					for (PersonnelCentreGestionDTO personnel : listePersonnels){
						if (personnel.isAlertesMail()){
							if (personnel.getMail()!=null && !personnel.getMail().isEmpty()){
								getSmtpService().send(new InternetAddress(personnel.getMail()),sujet,text,text);
							}
						}
					}
				}
			}

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
		}catch (AddressException ade){
			logger.error("AddressException", ade.fillInStackTrace());
			addErrorMessage("formCreaAvenantPage2:erreurAjoutAvenant", "GENERAL.ERREUR_MAIL");
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
				if(!StringUtils.hasText(enseignantTmp.getCodeAffectation())){
					enseignantTmp.setCodeAffectation("");
				}
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
			avenant.setIdUniteDureeGratification(this.avenant.getUniteDureeGratification().getId());
		}

		avenant.setLoginModif(getSessionController().getCurrentLogin());

		try{
			// Modification de l'avenant
			getAvenantDomainService().updateAvenant(this.avenant);

			// Si c'est un étudiant qui modifie l'avenant et qu'on est configurés en alertes mail pour les tuteurs et gestionnaires
			if (getSessionController().getCurrentAuthEtudiant() != null && getSessionController().isAvertissementPersonnelModifAvenant()){
				String text=getString("ALERTES_MAIL.AVERTISSEMENT_PERSONNEL_MODIF_AVENANT",
						this.avenant.getIdAvenant(),
						this.avenant.getIdConvention(),
						getSessionController().getCurrentUser().getDisplayName());
				String sujet=getString("ALERTES_MAIL.AVERTISSEMENT_PERSONNEL_MODIF_AVENANT.SUJET",
						this.avenant.getIdConvention());

				// Envoi d'une alerte à l'enseignant référent si telle est la configuration
				if (getSessionController().isAvertissementTuteurPedago()){
					if (conventionController.getConvention().getEnseignant().getMail() != null && !conventionController.getConvention().getEnseignant().getMail().isEmpty())
						getSmtpService().send(new InternetAddress(conventionController.getConvention().getEnseignant().getMail()),sujet,text,text);
				}
				// Envoi d'une alerte aux personnels du centre gestion configurés pour les recevoir
				List<PersonnelCentreGestionDTO> listePersonnels = getPersonnelCentreGestionDomainService().getPersonnelCentreGestionList(this.avenant.getIdConvention());

				if (listePersonnels != null){
					for (PersonnelCentreGestionDTO personnel : listePersonnels){
						if (personnel.isAlertesMail()){
							if (personnel.getMail()!=null && !personnel.getMail().isEmpty()){
								getSmtpService().send(new InternetAddress(personnel.getMail()),sujet,text,text);
							}
						}
					}
				}
			}

		} catch (DataUpdateException d){
			logger.error("DataUpdateException",d.fillInStackTrace());
			addErrorMessage("formModifAvenantPage1:erreurModifAvenant","CONVENTION.ETAPE11.ERREUR_MODIF");
			return null;
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formModifAvenantPage1:erreurModifAvenant", "CONVENTION.ETAPE11.ERREUR_WS");
			return null;
		}catch (AddressException ade){
			logger.error("AddressException", ade.fillInStackTrace());
			addErrorMessage("formModifAvenantPage1:erreurModifAvenant", "GENERAL.ERREUR_MAIL");
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
				if (getSessionController().isAvertissementEtudiantAvenant()){
					String text=getString("ALERTES_MAIL.AVERTISSEMENT_ETUDIANTS_AVENANT",
							this.avenant.getIdAvenant(),
							this.avenant.getIdConvention(),
							getSessionController().getCurrentUser().getDisplayName());
					String sujet=getString("ALERTES_MAIL.AVERTISSEMENT_ETUDIANTS_AVENANT.SUJET",
							this.avenant.getIdConvention());
					getSmtpService().send(new InternetAddress(conventionController.getConvention().getEtudiant().getMail()),
							sujet,text,text);
				}
			}catch (DataDeleteException d) {
				logger.error("DataUpdateException ",d.fillInStackTrace());
				addErrorMessage("formDetailsAvenant:erreurValidAvenant", "CONVENTION.ETAPE11.ERREUR_VALIDATION", d.getMessage());
				return null;
			}catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ",we.fillInStackTrace());
				addErrorMessage("formDetailsAvenant:erreurValidAvenant", "CONVENTION.ETAPE11.ERREUR_WS", we.getMessage());
				return null;
			}catch (AddressException ade){
				logger.error("AddressException", ade.fillInStackTrace());
				addErrorMessage("formDetailsAvenant:erreurValidAvenant", "GENERAL.ERREUR_MAIL");
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

	public void updateLieu(){
		etablissementController.setServiceSel(conventionController.getConvention().getService());
		etablissementController.setContactSel(conventionController.getConvention().getContact());
	}

	public void updateContact(){
		etablissementController.setContactSel(conventionController.getConvention().getContact());
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
		List<ContactDTO> l = new ArrayList<ContactDTO>();
		List<Integer> idsCentreGestion = new ArrayList<Integer>();
		
		idsCentreGestion = getSessionController().getCurrentIdsCentresGestion();
		if(idsCentreGestion != null && !idsCentreGestion.contains(conventionController.getConvention().getIdCentreGestion())){
			idsCentreGestion.add(conventionController.getConvention().getIdCentreGestion());
		}
		if (etablissementController.getServiceSel() != null){
			l = getStructureDomainService().getContactsFromIdService(etablissementController.getServiceSel().getIdService(), idsCentreGestion, getSessionController().getCodeUniversite());
		}

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

	/**
	 * @return the modificationTexteLibre
	 */
	public boolean isModificationTexteLibre() {
		return modificationTexteLibre;
	}

	/**
	 * @param modificationTexteLibre the modificationTexteLibre to set
	 */
	public void setModificationTexteLibre(boolean modificationTexteLibre) {
		this.modificationTexteLibre = modificationTexteLibre;
	}


}
