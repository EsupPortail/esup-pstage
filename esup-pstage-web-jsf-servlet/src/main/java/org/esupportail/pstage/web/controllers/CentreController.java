/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.esupportail.pstage.exceptions.CommunicationApogeeException;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstage.web.beans.ImageUploadBean;
import org.esupportail.pstage.web.comparator.ComparatorSelectItem;
import org.esupportail.pstagedata.domain.dto.AffectationDTO;
import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.CentreGestionSuperviseurDTO;
import org.esupportail.pstagedata.domain.dto.ConfidentialiteDTO;
import org.esupportail.pstagedata.domain.dto.CritereGestionDTO;
import org.esupportail.pstagedata.domain.dto.DroitAdministrationDTO;
import org.esupportail.pstagedata.domain.dto.FicheEvaluationDTO;
import org.esupportail.pstagedata.domain.dto.FichierDTO;
import org.esupportail.pstagedata.domain.dto.NiveauCentreDTO;
import org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.QuestionSupplementaireDTO;
import org.esupportail.pstagedata.exceptions.AffectationAlreadyExistingForCodeException;
import org.esupportail.pstagedata.exceptions.CentreEntrepriseDejaExistantException;
import org.esupportail.pstagedata.exceptions.CentreEtablissementDejaExistantException;
import org.esupportail.pstagedata.exceptions.CentreReferenceException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.PersonalAlreadyExistingForCentreException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.springframework.util.StringUtils;



/**
 * CentreController
 */
/**
 * @author Florian Garot : florian.garot@univ-artois.fr
 *
 */

public class CentreController extends AbstractContextAwareController {

	/* ****************************************************************
	 * Propriétés
	 ****************************************************************/

	/**
	 * 
	 */
	private static final long serialVersionUID = 8058126798700641595L;

	/**
	 * Logger
	 */
	private final Logger logger = Logger.getLogger(this.getClass());

	/* ***************************************************************
	 * Centre de Gestion
	 ****************************************************************/
	/**
	 * Le nombre de criteres rattachés au centre
	 */
	private int nbCriteres;

	/**
	 * Le nombre de personnels rattachés au centre
	 */
	private int nbPersonnels;

	/**
	 * Le nombre de contacts rattachés au centre
	 */
	private int nbContacts;

	/**
	 * Le nombre de conventions rattachées au centre
	 */
	private int nbConventions;

	/**
	 * Le nombre d'offres rattachées au centre
	 */
	private int nbOffres;

	/**
	 * Centre gestion DTO
	 */
	private CentreGestionDTO centre;

	/**
	 * Liste Centre gestion DTO
	 */
	private List<CentreGestionDTO> centresGestion;

	/**
	 * Nomenclature des confidentialités
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> confidentialites;
	/**
	 * True si le centre etablissement existe et possede une confidentialite libre
	 */
	@SuppressWarnings("unused")
	private boolean confidentialiteAffichable;

	/**
	 * Confidentialité du centre Etablissement
	 */
	private ConfidentialiteDTO confidentialiteEtablissement;

	/**
	 * Nomenclature des niveaux de centre (critéres de gestion)
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> niveauxCentre;

	/**
	 * True si aucun centre n'a été ajouté
	 */
	private boolean listeCentreVide;

	/**
	 * True si l'ajout d'un centre est encore possible
	 */
	private boolean ajoutPossible;

	/* ***************************************************************
	 * Critere de Gestion
	 ****************************************************************/
	/**
	 * Critere
	 */
	private CritereGestionDTO critere;
	/**
	 * Liste<SelectItem> de la totalite des criteres (pour l'affichage)
	 */
	private List<SelectItem> listeCriteres;
	/**
	 * Map<String,String> de la totalite des criteres (pour la recherche par code lors de l'ajout)
	 */
	private Map<String,String> toutLesCriteres;
	/**
	 * Liste des Criteres choisis dans la listeCriteres lors d'un ajout
	 */
	private List<Object> listeCriteresChoisis;
	/**
	 * Liste des Criteres rattaches au centre
	 */
	private List<CritereGestionDTO> listeCriteresRattaches;
	/**
	 * True si aucun critere n'a été ajouté
	 */
	private boolean listeCritereVide;
	/* ***************************************************************
	 * Logo
	 ****************************************************************/
	/**
	 * Fichier contenant le logo uploadé
	 */
	private UploadedFile uploadedLogo;

	/**
	 * Fichier contenant le dossier oé seront stockés les logos
	 */
	private String logosDir;

	/**
	 * Fichier contenant l'application
	 */
	private String appliDir;

	/* ***************************************************************
	 * Personnel
	 ****************************************************************/
	/**
	 * Personnel à ajouter (rempli dans l'ajout)
	 */
	private PersonnelCentreGestionDTO personnel;
	/**
	 * Liste des personnels rattachés
	 */
	private List<PersonnelCentreGestionDTO> personnels;
	/**
	 * Code affectation choisi pendant la recherche
	 */
	private Object codeAffectationPersonnel;

	/**
	 * Liste des personnels trouvés lors d'une recherche
	 */
	private List<PersonnelCentreGestionDTO> recherchePersonnels;

	/**
	 * True si aucun personnel n'est rattaché au centre
	 */
	private boolean listePersonnelVide;
	/**
	 * True si la liste des affectations est vide
	 */
	private boolean listeAffectationVide;

	/**
	 * Centre Entreprise
	 */
	private CentreGestionDTO centreEntreprise;
	/**
	 * Centre utilisé pour le formulaire d'ajout/modification du centre entreprise
	 */
	private CentreGestionDTO formCentreEntreprise;
	/**
	 * ID du centre de gestion encodé md5 pour le dépot anonyme
	 */
	private String depotEncode;

	/* ***************************************************************
	 * FICHE EVAL
	 ****************************************************************/
	/**
	 * Fiche d'evaluation
	 */
	private FicheEvaluationDTO ficheEvaluation;
	/**
	 * QuestionSupplementaire
	 */
	private QuestionSupplementaireDTO questionSupplementaire;
	/**
	 * Liste Questions supplementaires de la fiche Etudiant 1
	 */
	private List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEtudiant1;
	/**
	 * Liste Questions supplementaires de la fiche Etudiant 2
	 */
	private List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEtudiant2;
	/**
	 * Liste Questions supplementaires de la fiche Etudiant 3
	 */
	private List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEtudiant3;
	/**
	 * Liste Questions supplementaires de la fiche Enseignant 1
	 */
	private List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEnseignant1;
	/**
	 * Liste Questions supplementaires de la fiche Enseignant 2
	 */
	private List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEnseignant2;
	/**
	 * Liste Questions supplementaires de la fiche Entreprise 1
	 */
	private List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEntreprise1;
	/**
	 * Liste Questions supplementaires de la fiche Entreprise 2
	 */
	private List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEntreprise2;
	/**
	 * Liste Questions supplementaires de la fiche Entreprise 3
	 */
	private List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEntreprise3;

	/**
	 * Bean constructor.
	 */
	public CentreController() {
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
	 * @return a String
	 */
	public String goToAccueil(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToAccueil() ");
		}
		return "accueilStage";
	}

	/**
	 * @return a String
	 */
	public String goToIndicateurStat(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToIndicateurStat() ");
		}
		return "indicateurStat";
	}

	/* ****************************************************************************
	 * LISTE DES CENTRES
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToListeCentre(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToListeCentre() ");
		}
		this.centresGestion = getCentreGestionDomainService().getCentreGestionList(getSessionController().getCodeUniversite());
		return "listeCentres";
	}

	/**
	 * @return boolean
	 */
	public boolean listeCentreVide(){
		if ((getCentreGestionDomainService().getNombreCentreGestion(getSessionController().getCodeUniversite())) > 0){
			return false;
		}
		return true;
	}

	/**
	 * @return List<CentreGestionDTO>
	 */
	public List<CentreGestionDTO> getCentresGestion(){
		return this.centresGestion;
	}

	/* ****************************************************************************
	 * AJOUT D'UN CENTRE
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToAjoutCentre(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToAjoutCentre() ");
		}

		// Instanciation du centre correspondant au formulaire rempli et de ses objets
		this.centre=new CentreGestionDTO();
		this.personnel=new PersonnelCentreGestionDTO();
		this.centre.setNiveauCentre(new NiveauCentreDTO());
		this.centre.setConfidentialite(new ConfidentialiteDTO());
		this.centre.setAutoriserImpressionConvention(true);

		return "ajoutCentre";
	}

	/**
	 * @return the ajoutPossible
	 */
	public boolean isAjoutPossible() {
		ajoutPossible = true;

		// Si le centre Etablissement a été créé ET que le critere de gestion est vide (un seul centre pour gérer l'etablissement)
		// On ne peut acceder à l'ajout étant donné qu'aucun centre supplémentaire ne peut être ajouté.
		if (getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite())!=null
				&& (getSessionController().getCritereGestion()).isEmpty()){
			if (logger.isInfoEnabled()){
				logger.info("Aucun centre supplémentaire ne peut être ajouté. Le critère de gestion est de type " + getSessionController().getCritereGestion());
			}
			ajoutPossible = false;
		}

		return ajoutPossible;
	}

	/**
	 * Traite le formulaire une fois valide et renvoie vers la liste des centres
	 * @return a String
	 */
	public String ajouterCentre(){
		centre.setLoginCreation(getSessionController().getCurrentLogin());

		// On ajoute au centre le codeUniversite precedemment recupere depuis le fichier de config
		centre.setCodeUniversite(getSessionController().getCodeUniversite());

		// On défini le codeConfidentialite à partir de l'objet Confidentialite attaché au centre
		// ou a partir du centre Etablissement si c'est lui qui la gere
		String codeConf = centre.getConfidentialite().getCode();
		if (codeConf != null && !(codeConf.isEmpty())){
			centre.setCodeConfidentialite(centre.getConfidentialite().getCode());
		} else {
			centre.setCodeConfidentialite((getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite())).getCodeConfidentialite());
		}

		// On défini le niveauCentre à partir de l'objet NiveauCentre attaché au centre
		centre.setIdNiveauCentre(centre.getNiveauCentre().getId());

		// On défini le modeValidationStage à partir de l'objet modeValidationStage attaché au centre
		//		centre.setIdModeValidationStage(centre.getModeValidationStage().getId());

		// Ajout temporaire du premier centre superviseur
		try{
			(getCentreGestionDomainService().getCentreGestionSuperviseur()).isEmpty();
		} catch (NullPointerException e){
			CentreGestionSuperviseurDTO tmp = new CentreGestionSuperviseurDTO();
			tmp.setNomCentreGestionSuperviseur("SuperViseur Temporaire");
			getCentreGestionDomainService().addCentreGestionSuperviseur(tmp);
		}

		// On recupére l'id du centre superviseur ajouté 
		centre.setIdCentreGestionSuperViseur(((getCentreGestionDomainService().getCentreGestionSuperviseur()).get(0)).getIdCentreGestionSuperviseur());

		if(logger.isDebugEnabled()){
			logger.debug("public String ajouterCentre()");
			logger.debug("Propriétés du centre ajouté : "+ centre);
		}

		// On met le viseur a null s'il est vide
		if (centre.getNomViseur() == "" && centre.getPrenomViseur() == ""){
			centre.setNomViseur(null);
			centre.setPrenomViseur(null);
		}

		try{
			// Ajout Centre
			int idCentreGestion = getCentreGestionDomainService().addCentreGestion(centre);
			
			centre.setIdCentreGestion(idCentreGestion);
			this.centresGestion.add(centre);
			if(logger.isDebugEnabled()){
				logger.debug("idCentreGestion : " + idCentreGestion);
			}
		} catch (DataAddException d){
			logger.error("DataAddException",d.fillInStackTrace());
			addErrorMessage("formAjoutCentre:erreurAjoutCentre","CENTRE.AJOUT_CENTRE.ERREUR");
			return null;
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formAjoutCentre:erreurAjoutCentre", "CENTRE.AJOUT_CENTRE.ERREUR");
			return null;
		} catch (CentreEtablissementDejaExistantException e) {
			logger.error("EtablissementDejaExistantException", e.fillInStackTrace());
			addErrorMessage("formAjoutCentre:erreurAjoutCentre", "CENTRE.AJOUT_CENTRE.ERREUR_ETABLISSEMENT");
			return null;
		}

		this.centre = new CentreGestionDTO();

		return "listeCentres";
	}

	/* ****************************************************************************
	 * CONSULTATION D'UN CENTRE
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToVoirCentre(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToVoirCentre() ");
		}
		this.listeCriteres = new ArrayList<SelectItem>();
		this.personnels = new ArrayList<PersonnelCentreGestionDTO>();
		return "voirCentre";
	}

	/* ****************************************************************************
	 * MODIFICATION D'UN CENTRE
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToModifCentre(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToModifCentre() ");
		}

		return "modifCentre";
	}
	/**
	 * Traite le formulaire une fois valide et renvoie vers la liste des centres
	 * @return a String
	 */
	public String modifierCentre(){

		centre.setLoginModif(getSessionController().getCurrentLogin());

		// On ajoute au centre le codeUniversite precedemment recupere depuis le fichier de config
		centre.setCodeUniversite(getSessionController().getCodeUniversite());

		// On défini le codeConfidentialite à partir de l'objet Confidentialite attaché au centre
		// ou a partir du centre Etablissement si c'est lui qui la gere
		String codeConf = centre.getConfidentialite().getCode();
		if (codeConf != null && !(codeConf.isEmpty())){
			centre.setCodeConfidentialite(centre.getConfidentialite().getCode());
		} else {
			centre.setCodeConfidentialite((getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite())).getCodeConfidentialite());
		}

		// On défini le niveauCentre à partir de l'objet NiveauCentre attaché au centre
		centre.setIdNiveauCentre(centre.getNiveauCentre().getId());

		// On défini le modeValidationStage à partir de l'objet modeValidationStage attaché au centre
		//		centre.setIdModeValidationStage(centre.getModeValidationStage().getId());

		// On met le viseur a null s'il est vide
		if (centre.getNomViseur() == "" && centre.getPrenomViseur() == ""){
			centre.setNomViseur(null);
			centre.setPrenomViseur(null);
			centre.setQualiteViseur(null);
		}

		try {
			// On recupére l'id du centre superviseur ajouté (temporaire)
			centre.setIdCentreGestionSuperViseur(((getCentreGestionDomainService().getCentreGestionSuperviseur()).get(0)).getIdCentreGestionSuperviseur());
		} catch (NullPointerException e ){
			addErrorMessage("formModifCentre:erreurModifCentre","CENTRE.AJOUT_CENTRE.ERREUR_SUPERVISEUR");
		}


		if(logger.isDebugEnabled()){
			logger.debug("public String modifierCentre()");
			logger.debug("Propriétés du centre modifié : "+ centre);
		}
		try{
			// Modification du Centre
			getCentreGestionDomainService().updateCentreGestion(centre);
			
		} catch (DataUpdateException d){
			logger.error("DataUpdateException",d.fillInStackTrace());
			addErrorMessage("formModifCentre:erreurModifCentre","CENTRE.AJOUT_CENTRE.ERREUR");
			return null;
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formModifCentre:erreurModifCentre", "CENTRE.AJOUT_CENTRE.ERREUR");
			return null;
		} catch (CentreEtablissementDejaExistantException e) {
			logger.error("EtablissementDejaExistantException", e.fillInStackTrace());
			addErrorMessage("formModifCentre:erreurModifCentre", "CENTRE.AJOUT_CENTRE.ERREUR_ETABLISSEMENT");
			return null;
		}

		return "voirCentre";
	}

	/* ****************************************************************************
	 * GESTION DU CENTRE ENTREPRISE
	 *****************************************************************************/

	/**
	 * @return String
	 */
	public String goToCentreEntreprise(){
		if(getCentreEntreprise()!=null){
			this.formCentreEntreprise=getCentreEntreprise();
		}else{
			this.formCentreEntreprise=new CentreGestionDTO();
		}
		getSessionController().setModifCentreEntrepriseCurrentPage("_modifCentreEntrepriseEtape1");
		return "centreEntreprise";
	}

	/**
	 * Action de création du centre entreprise si non existant
	 * 
	 */
	public void ajouterCentreEntreprise(){
		//		String ret=null;
		if(getCentreEntreprise()==null){
			if(StringUtils.hasText(this.formCentreEntreprise.getNomCentre()) &&
					this.formCentreEntreprise.getConfidentialite()!=null){
				try {
					this.formCentreEntreprise.setCodeConfidentialite(this.formCentreEntreprise.getConfidentialite().getCode());
					this.formCentreEntreprise.setCodeUniversite("entreprise");
					this.formCentreEntreprise.setIdNiveauCentre(getBeanUtils().getEntreprise().getId());
					this.formCentreEntreprise.setLoginCreation(getSessionController().getCurrentLogin());
					getCentreGestionDomainService().addCentreGestion(this.formCentreEntreprise);
					addInfoMessage("formCentreEntreprise", "CENTRE.CENTRE_ENTREPRISE.CONFIRMATION");
					getSessionController().setModifCentreEntrepriseCurrentPage("modifCentreEntrepriseEtape1");
					//					ret="_modifCentreEntrepriseEtape1";
				} catch (DataAddException d) {	
					logger.error("DataAddException", d.fillInStackTrace());				
					addErrorMessage("formCentreEntreprise", "CENTRE.CENTRE_ENTREPRISE.ERREURENTREPRISE", d.getMessage());
					//					return null;
				} catch (CentreEntrepriseDejaExistantException e) {
					logger.error("CentreEntrepriseDejaExistantException", e.fillInStackTrace());	
					addErrorMessage("formCentreEntreprise", "CENTRE.CENTRE_ENTREPRISE.ERREURENTREPRISE", e.getMessage());
					//					return null;
				} catch (WebServiceDataBaseException e) {
					logger.error("WebServiceDataBaseException", e.fillInStackTrace());	
					addErrorMessage("formCentreEntreprise", "CENTRE.CENTRE_ENTREPRISE.ERREURENTREPRISE", e.getMessage());
					//					return null;
				}
			}
		}
		//		return ret;
	}

	/**
	 * Action de modification du centre entreprise
	 */
	public void modifierCentreEntreprise(){
		//		String ret=null;
		if(getCentreEntreprise()!=null){
			if(StringUtils.hasText(this.formCentreEntreprise.getNomCentre()) &&
					this.formCentreEntreprise.getConfidentialite()!=null){
				try{
					this.formCentreEntreprise.setCodeConfidentialite(this.formCentreEntreprise.getConfidentialite().getCode());
					this.formCentreEntreprise.setCodeUniversite("entreprise");
					this.formCentreEntreprise.setIdNiveauCentre(getBeanUtils().getEntreprise().getId());
					this.formCentreEntreprise.setLoginModif(getSessionController().getCurrentLogin());
					getCentreGestionDomainService().updateCentreGestion(this.formCentreEntreprise);
					getSessionController().setModifCentreEntrepriseCurrentPage("_modifCentreEntrepriseEtape1");
					addInfoMessage("msgsEts", "CENTRE.CENTRE_ENTREPRISE.CONFIRMATION");
					//					ret="_modifCentreEntrepriseEtape1";
				} catch (DataAddException d){
					logger.error("DataAddException", d.fillInStackTrace());				
					addErrorMessage("formCentreEntreprise", "CENTRE.CENTRE_ENTREPRISE.ERREURENTREPRISE");
					//					return null;
				} catch (CentreEntrepriseDejaExistantException e) {
					logger.error("CentreEntrepriseDejaExistantException", e.fillInStackTrace());	
					addErrorMessage("formCentreEntreprise", "CENTRE.CENTRE_ENTREPRISE.ERREURENTREPRISE", e.getMessage());
					//					return null;
				} catch (WebServiceDataBaseException e) {
					logger.error("WebServiceDataBaseException", e.fillInStackTrace());	
					addErrorMessage("formCentreEntreprise", "CENTRE.CENTRE_ENTREPRISE.ERREURENTREPRISE", e.getMessage());
					//					return null;
				}
			}
		}
		//		return "centreEntreprise";
	}

	/* ****************************************************************************	 * 
	 * SUPPRESSION D'UN CENTRE
	 *****************************************************************************/
	/**
	 * Calcul du nombre de conventions, de contacts, de criteres et de personnels rattachés au centre pour le résumé avant suppression
	 * @return String
	 */
	public void avantSupprimer(){

		// nombre de criteres
		this.nbCriteres = 0;
		if (!(getBeanUtils().isEtablissement(this.centre))){
			this.nbCriteres = getCritereGestionDomainService().getNombreCritereGestion(this.centre.getIdCentreGestion());
		}

		// nombre de personnels
		setNbPersonnels (getPersonnelCentreGestionDomainService().getNombrePersonnelCentreGestion(this.centre.getIdCentreGestion()));
		// nombre de contacts
		setNbContacts(getStructureDomainService().getNombreContactByCentreGestion(this.centre.getIdCentreGestion()));

		// nombre de conventions
		setNbConventions(getConventionDomainService().getNombreConventionByCentreGestion(this.centre.getIdCentreGestion(), getSessionController().getCodeUniversite()));
		// nombre d'offres
		setNbOffres(getOffreDomainService().getNombreOffreByCentreGestion(this.centre.getIdCentreGestion()));
	}

	/**
	 * @return a String
	 */
	public String supprimerCentre(){
		if(this.centre!=null){
			try{
				if(logger.isInfoEnabled()){
					logger.info(getSessionController().getCurrentLogin()+" supprime le centre de gestion : "+this.centre);
				}
				List<CritereGestionDTO> list = new ArrayList<CritereGestionDTO>();
				list = getCritereGestionDomainService().getCritereGestionFromIdCentre(this.centre.getIdCentreGestion());
				if (list != null && !list.isEmpty()){
					for(CritereGestionDTO crit : list){
						this.critere = crit;
						this.repercutionCriteres();
					}
				}
				getCentreGestionDomainService().deleteCentreGestion(this.centre.getIdCentreGestion());

				this.centresGestion.remove(centre);
			} catch (CentreReferenceException e){
				logger.error("CentreReferenceException ",e.fillInStackTrace());
				addErrorMessage("formSupprCentre:erreurListeCentre","CENTRE.SUPPRESSION.ERREUR.REFERENCE",e.getMessage());
				return null;
			}catch (DataDeleteException de) {
				logger.error("DataDeleteException ",de.fillInStackTrace());
				addErrorMessage("formSupprCentre:erreurListeCentre", "CENTRE.SUPPRESSION.ERREUR");
				return null;
			}catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ",we.fillInStackTrace());
				addErrorMessage("formSupprCentre:erreurListeCentre", "CENTRE.SUPPRESSION.ERREUR");
				return null;
			}
			this.centre = new CentreGestionDTO();
		}
		return "listeCentres";
	}

	/* ****************************************************************************
	 * Liste des critéres rattachés
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToListeCritere(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToListeCritere() ");
		}
		return "listeCriteres";
	}

	/**
	 * @return List<CritereGestionDTO>
	 */
	public List<CritereGestionDTO> getListeCriteresRattaches(){
		this.listeCriteresRattaches = getCritereGestionDomainService().getCritereGestionFromIdCentre(this.centre.getIdCentreGestion());
		return this.listeCriteresRattaches;
	}

	/**
	 * @return boolean
	 */
	public boolean listeCritereVide(){
		if ((getCritereGestionDomainService().getNombreCritereGestion(this.centre.getIdCentreGestion())) > 0){
			return false;
		}
		return true;
	}

	/* ***************************************************************
	 * Ajout d'un critere
	 ****************************************************************/
	/**
	 * @return a String
	 */
	public String goToAjoutCritere(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToAjoutCritere() ");
		}

		String codeUniversite = getSessionController().getCodeUniversite();
		this.listeCriteres = new ArrayList<SelectItem>();
		this.toutLesCriteres = new HashMap<String,String>();
		LinkedHashMap <String,String> criteresDisponibles = new LinkedHashMap<String,String>();
		List<String> codesSaisis = new ArrayList<String>();


		if ((this.centre.getNiveauCentre().getLibelle()).equalsIgnoreCase(DonneesStatic.CG_UFR)){
			try{
				// Liste des codes ufr deja rattaches
				List<CritereGestionDTO> criteresSaisis = getCritereGestionDomainService().getCritereGestion();
				if (criteresSaisis != null && !criteresSaisis.isEmpty()){
					for(int i=0; i < criteresSaisis.size();i++){
						codesSaisis.add(criteresSaisis.get(i).getCode());
					}
				} else {
					logger.info("Liste de codes ufr saisis pour l'universite vide.");
				}

				// codes et libelles de toutes les UFR
				this.toutLesCriteres = getPersonalComponentRepositoryDomain().getComposantesRef(codeUniversite);
			} catch (CommunicationApogeeException cae){
				logger.error(cae.fillInStackTrace());
				addErrorMessage("formListeCritere:erreurListeCritere", "CENTRE.CRITERE.ERREUR_COMMUNICATION");
				return null;
			} catch (Exception e){
				logger.error(e.fillInStackTrace());
				addErrorMessage("formListeCritere:erreurListeCritere", "CENTRE.CRITERE.ERREUR");
				return null;
			}

			if (this.toutLesCriteres == null || this.toutLesCriteres.isEmpty()) {
				return null;
			}

			// Liste des codes ufr uniquement
			List<String> codesUfr = new ArrayList<String>();
			for(Iterator<String> iter = this.toutLesCriteres.keySet().iterator(); iter.hasNext(); ){
				codesUfr.add(iter.next().toString());
			}
			Collections.sort(codesUfr);

			//Creation d'une liste des codes disponibles (non rattaches)
			if (!codesSaisis.isEmpty()){
				for(String codeUfr : codesUfr){
					if(!codesSaisis.contains(codeUfr)){
						criteresDisponibles.put(codeUfr,this.toutLesCriteres.get(codeUfr));
					}
				}
			} else {
				for(String codeUfr : codesUfr){
					criteresDisponibles.put(codeUfr,this.toutLesCriteres.get(codeUfr));
				}
			}

		} else if ((this.centre.getNiveauCentre().getLibelle()).equalsIgnoreCase(DonneesStatic.CG_ETAPE)){
			try{
				// Liste des codes etape deja rattaches
				List<CritereGestionDTO> criteresSaisis = getCritereGestionDomainService().getCritereGestion();
				if (criteresSaisis != null && !criteresSaisis.isEmpty()){
					for(CritereGestionDTO critereSaisi : criteresSaisis){
						if (critereSaisi.getCodeVersionEtape() != null && !critereSaisi.getCodeVersionEtape().isEmpty()){
							// S'il y a un code version etape, on combine les deux codes
							codesSaisis.add(critereSaisi.getCode()+";"+critereSaisi.getCodeVersionEtape());
						} else {
							// Sinon on n'ajoute que le code etape
							codesSaisis.add(critereSaisi.getCode());
						}
					}
				} else {
					logger.info("Liste de codes etape saisis pour l'universite vide.");
				}

				// codes et libelles de toutes les ETAPES
				this.toutLesCriteres = getStudentComponentRepositoryDomain().getEtapesRef(codeUniversite);
			} catch (CommunicationApogeeException cae){
				logger.error(cae.fillInStackTrace());
				addErrorMessage("formListeCritere:erreurListeCritere", "CENTRE.CRITERE.ERREUR_COMMUNICATION");
				return null;
			}catch (Exception e){
				logger.error(e.fillInStackTrace());
				addErrorMessage("formListeCritere:erreurListeCritere", "CENTRE.CRITERE.ERREUR");
				return null;
			}

			if (this.toutLesCriteres == null || this.toutLesCriteres.isEmpty()) {
				return null;
			}
			// liste des codes ETAPES et version etapes
			List<String> codesEtape = new ArrayList<String>();
			for(Iterator<String> iter = this.toutLesCriteres.keySet().iterator();iter.hasNext();){
				String[] tabCodes = iter.next().split(";");
				if(tabCodes[1]!= null && !tabCodes[1].isEmpty()){
					codesEtape.add(tabCodes[0]);
					codesEtape.add(tabCodes[0]+";"+tabCodes[1]);
				} else {
					codesEtape.add(tabCodes[0]);
				}
			}

			if (logger.isDebugEnabled()){
				logger.debug("Codes deja saisis : " + codesSaisis);
				logger.debug("Codes recuperes depuis apogee : " + codesEtape);
			}
			//Creation d'une liste des codes disponibles (non rattaches)
			if (!codesSaisis.isEmpty()){
				// pour tous les codes existants
				for(String codeEtp : codesEtape){
					// si le code n'est pas saisi et qu'il est un combine code/codeVersion
					if(!codesSaisis.contains(codeEtp) && codeEtp.contains(";")){
						// on en extrait juste sa partie codeEtape et on verifie qu'elle n'est pas non plus rattachee avant d'ajouter le code
//						if(!codesSaisis.contains(tabCodes2[0])){
//							criteresDisponibles.put(codeEtp,this.toutLesCriteres.get(codeEtp));
//						}
						criteresDisponibles.put(codeEtp,this.toutLesCriteres.get(codeEtp));
					}
				}
			} else {
				for (String codeEtp : codesEtape){
					criteresDisponibles.put(codeEtp,this.toutLesCriteres.get(codeEtp));
				}
			}
		}

		String clef = null;
		String valeur = null;
		Iterator<String> i = criteresDisponibles.keySet().iterator();
		while (i.hasNext()){
			clef = i.next();
			valeur = (clef+ " - " +criteresDisponibles.get(clef));
			this.listeCriteres.add(new SelectItem(clef,valeur));
		}
		Collections.sort(this.listeCriteres, new ComparatorSelectItem());

		return "ajoutCritere";
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getListeCriteres(){
		return this.listeCriteres;
	}

	/**
	 * @return a String
	 */
	public String ajouterCriteres(){
		if(logger.isDebugEnabled()){
			logger.debug("public String ajouterCriteres() ");
		}
		List<CritereGestionDTO> liste = new ArrayList<CritereGestionDTO>();
		CritereGestionDTO tmp = new CritereGestionDTO();
		String code;

		if (this.listeCriteresChoisis == null || this.listeCriteresChoisis.isEmpty()){
			if(logger.isInfoEnabled()){
				logger.info("Ajout impossible : aucun critere choisi dans la liste.");
			}
			addErrorMessage("formAjoutCritere:erreurAjoutCritere", "CENTRE.CRITERE.ERREUR_CHOIX");
			return null;
		}
		for(int i=0;i < this.listeCriteresChoisis.size();i++){
			code = (String)listeCriteresChoisis.get(i);
			tmp.setLibelle(this.toutLesCriteres.get(code));
			if (code.contains(";")){
				String [] tabCodes = code.split(";");
				tmp.setCode(tabCodes[0]);
				tmp.setCodeVersionEtape(tabCodes[1]);
			} else {
				tmp.setCode(code);
				tmp.setCodeVersionEtape("");
			}
			tmp.setIdCentreGestion(this.centre.getIdCentreGestion());

			for (int j=0; j<this.listeCriteres.size(); j++){
				if (this.listeCriteres.get(j).getValue().equals(code)){
					this.listeCriteres.remove(j);
				}
			}
			
			liste.add(tmp);

			if (tmp.getCodeVersionEtape() != ""){
				CritereGestionDTO critereSansVet = getCritereGestionDomainService().getCritereGestionSansVetFromCodeEtape(tmp.getCode());
				if (critereSansVet != null){
					// Il existe un critere avec le codeEtape et sans codeVersion d'etape
					if (critereSansVet.getLibelle().equalsIgnoreCase(tmp.getLibelle())){
						// S'il a le meme libelle que le critere en cours d'ajout, on update toutes les conventions concernees pour leur donner le codeVersionEtape qui va bien
						getConventionDomainService().updateConventionSetCodeVersionEtape(tmp.getCode(), tmp.getCodeVersionEtape());
						// Puis on supprime l'ancien critere qui ne sera plus utilisé
						this.critere = new CritereGestionDTO();
						this.critere.setCode(tmp.getCode());
						this.critere.setCodeVersionEtape("");
						this.repercutionCriteres();
					}
				}
			}
		}
		try {
			// Mise à jour des ids de centre de gestion des conventions concernées par rapport au nouveau rattachement de leur codeEtape/versionEtape
			if ((this.centre.getNiveauCentre().getLibelle()).equalsIgnoreCase(DonneesStatic.CG_UFR)){
				for(CritereGestionDTO crit : liste){
					getCritereGestionDomainService().addCritere(crit);
					code = crit.getCode();
					getConventionDomainService().updateCentreConventionByUfr(code, this.centre.getIdCentreGestion(),getSessionController().getCodeUniversite());
				}
			} else {
				for(CritereGestionDTO crit : liste){
					getCritereGestionDomainService().addCritere(crit);
					code = crit.getCode()+";"+crit.getCodeVersionEtape();
					getConventionDomainService().updateCentreConventionByEtape(code, this.centre.getIdCentreGestion(),getSessionController().getCodeUniversite());
				}
			}
		} catch (DataAddException e) {
			logger.error(e.fillInStackTrace());
		} catch (WebServiceDataBaseException e) {
			logger.error(e.fillInStackTrace());
		}

		return "listeCriteres";
	}


	/* ***************************************************************
	 * Suppression d'un critere
	 ****************************************************************/

	/**
	 * @return boolean
	 */
	public boolean isCritereNotFound(){
		if (this.critere!=null){
			String codeUniversite = getSessionController().getCodeUniversite();
			this.toutLesCriteres = new HashMap<String,String>();

			if ((this.centre.getNiveauCentre().getLibelle()).equalsIgnoreCase(DonneesStatic.CG_UFR)){
				try{
					// codes et libelles de toutes les UFR
					this.toutLesCriteres = getPersonalComponentRepositoryDomain().getComposantesRef(codeUniversite);
				} catch (CommunicationApogeeException cae){
					logger.error(cae.fillInStackTrace());
					return false;
				} catch (Exception e){
					logger.error(e.fillInStackTrace());
					return false;
				}
			} else if ((this.centre.getNiveauCentre().getLibelle()).equalsIgnoreCase(DonneesStatic.CG_ETAPE)){
				try{
					// codes et libelles de toutes les ETAPES
					this.toutLesCriteres = getStudentComponentRepositoryDomain().getEtapesRef(codeUniversite);
				} catch (CommunicationApogeeException cae){
					logger.error(cae.fillInStackTrace());
					return false;
				}catch (Exception e){
					logger.error(e.fillInStackTrace());
					return false;
				}
			}
			if (this.toutLesCriteres != null 
					&& !this.toutLesCriteres.isEmpty()
					&& !this.toutLesCriteres.containsValue(this.critere.getLibelle())
					&& !this.toutLesCriteres.containsKey(this.critere.getCode()+";"+this.critere.getCodeVersionEtape())){
				return true;
			}
		}

		return false;
	}		

	/**
	 * @return a String
	 */
	public String supprimerCritere(){
		if(this.critere != null){
			if(logger.isInfoEnabled()){
				logger.info("Suppression du critere de gestion : " + this.critere);
			}
			repercutionCriteres();
		}
		return "listeCriteres";
	}

	/**
	 * Repercution sur les conventions de la suppression d'un critere ou d'un centre
	 */
	public void repercutionCriteres(){
		try {
			String codeEtape;
			// On associe son codeVersionEtape si le critere en dispose
			if (this.critere.getCodeVersionEtape() != null && !this.critere.getCodeVersionEtape().isEmpty()){
				// On combine les codes pour simuler 2 parametres dans un seul, ceci afin de ne pas avoir
				// a modifier toutes les methodes suite a l'ajout du codeVersionEtape
				codeEtape = this.critere.getCode()+";"+this.critere.getCodeVersionEtape();
			} else {
				codeEtape = this.critere.getCode();
			}
			if (this.centre.getNiveauCentre().getLibelle().equalsIgnoreCase(DonneesStatic.CG_UFR)){
				// Si le centre est une UFR
				// Partout ou le code critere est trouvé dans les conventions, on remet l'id du centre Etablissement
				getConventionDomainService().updateCentreConventionByUfr(this.critere.getCode(), getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite()).getIdCentreGestion(),getSessionController().getCodeUniversite());
			} else {
				// Sinon, le centre est une Etape
				// Si le critere de gestion du fichier de config est MIXTE, alors on vérifie d'abord qu'il n'y a pas d'UFR pouvant recuperer la convention avant l'etablissement
				if (getSessionController().getCritereGestion().equalsIgnoreCase(DonneesStatic.CG_MIXTE)){
					// On recupere la liste des criteres actuellement rattachés
					List<CritereGestionDTO> list = getCritereGestionDomainService().getCritereGestion();
					// On recupere le code UFR correspondant au codeEtape du critere en cours de suppression
					String codeUfr = getConventionDomainService().getCodeUFRFromCodeEtape(this.critere.getCode(), getSessionController().getCodeUniversite());
					if(StringUtils.hasText(codeUfr)){
						boolean ufrFound = false;
						for (CritereGestionDTO crit : list){
							// Si l'on trouve le code UFR dans la liste des criteres deja rattachés, alors on assigne le centre auquel est rattaché ce code a tout les centres touchés par la suppression
							if (crit.getCode().equalsIgnoreCase(codeUfr)){
								getConventionDomainService().updateCentreConventionByEtape(codeEtape,crit.getIdCentreGestion(),getSessionController().getCodeUniversite());
								ufrFound = true;
								break;
							}
						}
						if (!ufrFound){
							// Sinon, de meme que pour les ufr, on remplace l'idCentreGestion du centre auquel était rattaché le critere par celui de l'Etablissement
							getConventionDomainService().updateCentreConventionByEtape(codeEtape, getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite()).getIdCentreGestion(),getSessionController().getCodeUniversite());
						}
					}
				} else {
					// Sinon, de meme que pour les ufr, on remplace l'idCentreGestion du centre auquel était rattaché le critere par celui de l'Etablissement
					getConventionDomainService().updateCentreConventionByEtape(codeEtape, getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite()).getIdCentreGestion(),getSessionController().getCodeUniversite());
				}
			}
			getCritereGestionDomainService().deleteCritere(codeEtape);
			if (this.listeCriteres != null && !this.listeCriteres.isEmpty()){
				this.listeCriteres.add(new SelectItem(this.critere.getCode(),(this.critere.getCode() +" - "+this.critere.getLibelle())));
				Collections.sort(this.listeCriteres, new ComparatorSelectItem());
			}
		} catch (DataUpdateException e) {
			logger.error("DataUpdateException", e.fillInStackTrace());
			addErrorMessage("formSupprCritere:erreurCritere", "CENTRE.CRITERE.SUPPRESSION.ERREUR",this.critere.getCode());
		} catch (WebServiceDataBaseException e) {
			logger.error("WebServiceDataBaseException", e.fillInStackTrace());
			addErrorMessage("formSupprCritere:erreurCritere", "CENTRE.CRITERE.SUPPRESSION.ERREUR",this.critere.getCode());
		}
	}
	/* ****************************************************************************
	 * AJOUT/MODIFICATION DU LOGO
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToModifLogo(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToModifLogo() ");
		}
		return "modifLogo";
	}

	/**
	 * Methode appelée avant l'affichage du panel_logo
	 */
	public void avantAjoutLogo(){
		if(logger.isDebugEnabled()){
			logger.debug("public String avantModifLogo() ");
		}
		if (!(this.centre.getIdFichier() > 0)){
			try {
				getSessionController().setImageUploadBean(new ImageUploadBean(getSessionController().getUploadFilesLogosCentrePath()));
				FichierDTO o = new FichierDTO();
				o.setNomFichier("");
				o.setNomReel("");
				int idFichier = getOffreDomainService().addFichier(o);
				o.setIdFichier(idFichier);
				this.centre.setFichier(o);
				getSessionController().getImageUploadBean().setPrefix(idFichier);
			} catch (DataAddException e) {
				logger.error(e.fillInStackTrace());
			} catch (WebServiceDataBaseException e) {
				logger.error(e.fillInStackTrace());
			}
		}
	}

	/**
	 * Action appellée après l'upload d'un fichier
	 */
	public String insertLogo() {
		String nomFichier = getSessionController().getImageUploadBean().getNameUploadedImage();
		String nomReel = getSessionController().getImageUploadBean().getRealNameImage();
		//Si nom de fichier non vide (cas des fichiers volumineux)
		if(StringUtils.hasText(nomFichier)){
			this.centre.getFichier().setNomFichier(nomFichier);
			if(StringUtils.hasText(nomReel)){
				this.centre.getFichier().setNomReel(nomReel);
			}
			try {
				getOffreDomainService().updateFichier(this.centre.getFichier());
				getCentreGestionDomainService().updateIdFichier(this.centre.getIdCentreGestion(), this.centre.getFichier().getIdFichier());
				this.centre.setIdFichier(this.centre.getFichier().getIdFichier());
				return "modifLogo";
			} catch (DataUpdateException d){
				logger.error("DataUpdateException",d.fillInStackTrace());
				addErrorMessage("panelUpload:erreurLogo",d.getMessage());
			} catch (WebServiceDataBaseException e) {
				logger.error(e.fillInStackTrace());
				addErrorMessage("panelUpload:erreurLogo",e.getMessage());
			}
		}
		return null;
	}

	/**
	 * @return String
	 */
	public String cleanFichiers(){
		if(logger.isDebugEnabled()){
			logger.debug("public String cleanFichiers() ");
		}
		getOffreDomainService().cleanFichiers();
		return "modifLogo";
	}
	/* ****************************************************************************
	 * SUPPRESSION DU LOGO
	 *****************************************************************************/	
	/**
	 * @return a String
	 */
	public String deleteLogo() {
		try{
			getSessionController().getImageUploadBean().deleteImageFromDirectory(
					this.centre.getFichier().getIdFichier(), this.centre.getFichier().getNomFichier());
			getCentreGestionDomainService().setIdFichierNull(this.centre.getIdCentreGestion());
			getOffreDomainService().deleteFichier(this.centre.getIdFichier());
			this.centre.setIdFichier(0);
			this.centre.setFichier(null);
			return "modifLogo";
		}catch (DataDeleteException e) {
			logger.warn(e.fillInStackTrace());
		}catch (WebServiceDataBaseException e) {
			logger.warn(e.fillInStackTrace());
		}
		return null;
	}

	/* ****************************************************************************
	 * Liste des personnels rattachés
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToListePersonnel(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToListePersonnel() ");
		}
		if(this.personnels == null || this.personnels.isEmpty()){
			this.personnels = getPersonnelCentreGestionDomainService().getPersonnelCentreGestionList(this.centre.getIdCentreGestion());
		}

		return "listePersonnels";
	}

	/**
	 * @return boolean
	 */
	public boolean listePersonnelVide(){
		if ((getPersonnelCentreGestionDomainService().getNombrePersonnelCentreGestion(this.centre.getIdCentreGestion())) > 0){
			return false;
		}
		return true;
	}

	/**
	 * @return List<PersonnelCentreGestionDTO>
	 */
	public List<PersonnelCentreGestionDTO> getPersonnels(){
		return this.personnels;
	}

	/**
	 * @return boolean
	 */
	public boolean listeAffectationVide(){
		if ((getPersonnelCentreGestionDomainService().getNombreAffectation()) > 0){
			return false;
		}
		return true;
	}

	/* ****************************************************************************
	 * Recherche d'un personnel
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToRattachPersonnelRecherche(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToRattachPersonnelRecherche() ");
		}

		// On initialise tout les objets en rapport avec le personnel récupéré depuis le LDAP
		this.recherchePersonnels = new ArrayList<PersonnelCentreGestionDTO>();
		this.personnel = new PersonnelCentreGestionDTO();
		AffectationDTO a = new AffectationDTO();
		a.setCode(" ");
		a.setLibelle(" ");
		a.setCodeUniversite(getSessionController().getCodeUniversite());
		this.personnel.setAffectation(a);
		this.personnel.setDroitAdmin(new DroitAdministrationDTO());
		this.personnel.setCodeAffectation(" ");

		return "rattachPersonnelRecherche";
	}

	/**
	 * @return a String
	 */
	public String rechercherPersonnel(){
		if(logger.isDebugEnabled()){
			logger.debug("public String rechercherPersonnel() ");
		}
		try{
			this.recherchePersonnels = new ArrayList<PersonnelCentreGestionDTO>();

			if (this.codeAffectationPersonnel == null 
					&& (this.personnel.getNom() == null || this.personnel.getNom().isEmpty()) 
					&& (this.personnel.getPrenom() == null || this.personnel.getPrenom().isEmpty())){
				addErrorMessage("formRechercheViseur:erreurRecherche","CENTRE.PERSONNEL.ERREUR_CHAMPS");
				return null;
			}
			String codeUniversite = getSessionController().getCodeUniversite();
			String codeAffectation = "";
			if (this.codeAffectationPersonnel != null) {
				codeAffectation = (String) this.codeAffectationPersonnel;
			}
			try {
				LinkedHashMap<String,String> map = (LinkedHashMap<String, String>) getPersonalComponentRepositoryDomain().getComposantesRef(getSessionController().getCodeUniversite());

				AffectationDTO a;
				String libelleAffectation = null;
				List<PersonnelCentreGestionDTO> lp = getPersonalDataRepositoryDomain().getPersonnelCentreGestionRefByName(codeUniversite,this.personnel.getNom(),this.personnel.getPrenom(),codeAffectation);

				for(PersonnelCentreGestionDTO tmp : lp){
					a = new AffectationDTO();
					a.setCodeUniversite(getSessionController().getCodeUniversite());

					if (tmp.getAffectation().getCode() == null && tmp.getAffectation().getLibelle() == null){
						// Le code et le libelle sont vides
						a.setLibelle(" ");
						a.setCode(" ");
						tmp.setAffectation(a);
						tmp.setCodeAffectation(a.getCode());
					}

					if(tmp.getAffectation().getCode() == null){
						// Si seul le code est vide on utilise le libelle pour le retrouver
						if (map != null && !map.isEmpty()){
							for (Iterator<String> i = map.keySet().iterator() ; i.hasNext() ; ){
								String key = i.next();
								if ((map.get(key)).equalsIgnoreCase(tmp.getAffectation().getLibelle())){
									codeAffectation = key;
								}
							}
						}
						a.setCode(codeAffectation==null?" ":codeAffectation);
						a.setLibelle(tmp.getAffectation().getLibelle());
						tmp.setAffectation(a);
						tmp.setCodeAffectation(a.getCode());
					}

					if (tmp.getAffectation().getLibelle() == null){
						// Si seul le libelle est vide on utilise le code pour le retrouver
						if (map != null && map.get(codeAffectation) != null) {
							libelleAffectation = map.get(codeAffectation);
						}
						a.setCode(tmp.getAffectation().getCode());
						a.setLibelle(libelleAffectation==null?" ":libelleAffectation);
						tmp.setAffectation(a);
						tmp.setCodeAffectation(a.getCode());
					}

					tmp.setCivilite(getNomenclatureDomainService().getCiviliteFromId(tmp.getIdCivilite()));

					this.recherchePersonnels.add(tmp);

				}
			} catch (CommunicationApogeeException e) {
				addErrorMessage("formRecherchePersonnel:erreurRecherche", "APOGEE.ERREUR");
				return null;
			}

		} catch (NullPointerException e){

			this.personnel = new PersonnelCentreGestionDTO();
			this.recherchePersonnels = new ArrayList<PersonnelCentreGestionDTO>();
			addErrorMessage("formRecherchePersonnel:erreurRecherche", "CENTRE.PERSONNEL.RECHERCHE.VIDE");

			return null;
		}

		return "rattachPersonnelResultat";
	}

	/**
	 * @return a String
	 */
	public void avantRechercheViseur(){
		if(logger.isDebugEnabled()){
			logger.debug("public void avantRechercheViseur() ");
		}
		this.recherchePersonnels = new ArrayList<PersonnelCentreGestionDTO>();
		this.personnel = new PersonnelCentreGestionDTO();
	}

	/**
	 * 
	 */
	public String rechercherViseur(){
		if(logger.isDebugEnabled()){
			logger.debug("public String rechercherViseur() ");
		}
		this.recherchePersonnels = new ArrayList<PersonnelCentreGestionDTO>();

		if (this.codeAffectationPersonnel == null 
				&& (this.personnel.getNom() == null || this.personnel.getNom().isEmpty()) 
				&& (this.personnel.getPrenom() == null || this.personnel.getPrenom().isEmpty())){
			addErrorMessage("formRechercheViseur:erreurRecherche","CENTRE.PERSONNEL.ERREUR_CHAMPS");
			return null;
		}

		// Déclaration des codes nécessaires à chaque recuperation dans le ldap
		String codeUniversite = getSessionController().getCodeUniversite();

		String codeAffectation = "";

		if (this.codeAffectationPersonnel != null) {
			codeAffectation = (String) this.codeAffectationPersonnel;
		}

		try {
			LinkedHashMap<String,String> map = (LinkedHashMap<String, String>) getPersonalComponentRepositoryDomain().getComposantesRef(getSessionController().getCodeUniversite());

			AffectationDTO a;
			String libelleAffectation = null;
			List<PersonnelCentreGestionDTO> lp = getPersonalDataRepositoryDomain().getPersonnelCentreGestionRefByName(codeUniversite,this.personnel.getNom(),this.personnel.getPrenom(),codeAffectation);

			for(PersonnelCentreGestionDTO tmp : lp){
				a = new AffectationDTO();
				a.setCodeUniversite(getSessionController().getCodeUniversite());

				if (tmp.getAffectation().getCode() == null && tmp.getAffectation().getLibelle() == null){
					// Le code et le libelle sont vides
					a.setLibelle(" ");
					a.setCode(" ");
					tmp.setAffectation(a);
					tmp.setCodeAffectation(a.getCode());
				}

				if(tmp.getAffectation().getCode() == null){
					// Si seul le code est vide on utilise le libelle pour le retrouver
					if (map != null && !map.isEmpty()){
						for (Iterator<String> i = map.keySet().iterator() ; i.hasNext() ; ){
							String key = i.next();
							if ((map.get(key)).equalsIgnoreCase(tmp.getAffectation().getLibelle())){
								codeAffectation = key;
							}
						}
					}
					a.setCode(codeAffectation==null?" ":codeAffectation);
					a.setLibelle(tmp.getAffectation().getLibelle());
					tmp.setAffectation(a);
					tmp.setCodeAffectation(a.getCode());
				}

				if (tmp.getAffectation().getLibelle() == null){
					// Si seul le libelle est vide on utilise le code pour le retrouver
					if (map != null && map.get(codeAffectation) != null) {
						libelleAffectation = map.get(codeAffectation);
					}
					a.setCode(tmp.getAffectation().getCode());
					a.setLibelle(libelleAffectation==null?" ":libelleAffectation);
					tmp.setAffectation(a);
					tmp.setCodeAffectation(a.getCode());
				}

				this.recherchePersonnels.add(tmp);

			}
		} catch (CommunicationApogeeException e) {
			addErrorMessage("formRechercheViseur:erreurRecherche", "APOGEE.ERREUR");
			return null;
		} catch (NullPointerException e){
			this.personnel = new PersonnelCentreGestionDTO();
			this.recherchePersonnels = new ArrayList<PersonnelCentreGestionDTO>();
			addErrorMessage("formRechercheViseur:erreurRecherche", "CENTRE.PERSONNEL.RECHERCHE.VIDE");
			return null;
		}

		return null;
	}

	/**
	 * @return a String
	 */
	public String goToRattachPersonnelResultat(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToRattachPersonnelResultat() ");
		}
		return "rattachPersonnelResultat";
	}

	/* ****************************************************************************
	 * Ajout d'un personnel
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToRattachPersonnelAjout(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToRattachPersonnelAjout() ");
		}

		// Instanciation des objets du personnel correspondant au formulaire rempli
		this.personnel.setDroitAdmin(new DroitAdministrationDTO());

		return "rattachPersonnelAjout";
	}

	/**
	 * @return a String
	 */
	public String ajouterPersonnel(){
		if(logger.isDebugEnabled()){
			logger.debug("public String ajouterPersonnel() ");
		}
		this.personnel.setLoginCreation(getSessionController().getCurrentLogin());

		this.personnel.setIdCentreGestion(this.centre.getIdCentreGestion());

		// On défini l'idDroitAdministration à partir de l'objet DroitAdministration attaché au personnel
		this.personnel.setIdDroitAdmin(this.personnel.getDroitAdmin().getId());
		try{

			if((this.personnel.getAffectation().getCode() == "" || this.personnel.getAffectation().getCode() == null)
					&& (this.personnel.getAffectation().getLibelle() != "" || this.personnel.getAffectation().getLibelle() != null)){
				// Si l'affectation dispose d'un libelle mais pas d'un code, on n'ajoute rien
				// Ainsi, on ajoute que lorsqu'il ya le code ou le code ET le libelle, ou bien aucun des deux.
			} else {
				// Ajout de son affectation dans la base si elle n'y est pas deja (catch)
				this.personnel.getAffectation().setCodeUniversite(getSessionController().getCodeUniversite());
				getPersonnelCentreGestionDomainService().addAffectation(this.personnel.getAffectation());
			}

		} catch (AffectationAlreadyExistingForCodeException ue) {
			if(logger.isInfoEnabled()){
				logger.info("Affectation deja existante pour le code : "+this.personnel.getAffectation().getCode());
			}
		} catch (DataAddException d){
			logger.error("DataAddException",d.fillInStackTrace());
			addErrorMessage("formAjoutPersonnel:erreurAjout","CENTRE.PERSONNEL.ERREUR");
			return null;
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formAjoutPersonnel:erreurAjout", "CENTRE.WS.ERREUR");
			return null;
		}catch (Exception e){
			logger.error("Exception",e.fillInStackTrace());
			addErrorMessage("formAjoutPersonnel:erreurAjout","CENTRE.PERSONNEL.ERREUR");
			return null;
		}
		this.personnel.setCodeUniversiteAffectation(getSessionController().getCodeUniversite());
		try {
			// Ajout Personnel en base
			int idPersonnelCentreGestion = getPersonnelCentreGestionDomainService().addPersonnelCentreGestion(this.personnel);
			// Ajout Personnel dans la liste du Controller
			this.personnel.setId(idPersonnelCentreGestion);
			if (this.personnels == null){
				this.personnels = new ArrayList<PersonnelCentreGestionDTO>();
			}
			this.personnels.add(this.personnel);

			//Méj liste des centres pour la personne connectée
			if(this.personnel.getUidPersonnel().equals(getSessionController().getCurrentLogin())){
				if(getSessionController().getCurrentCentresGestion()==null){
					getSessionController().setCurrentCentresGestion(new ArrayList<CentreGestionDTO>());
				}
				if(!getSessionController().getCurrentCentresGestion().contains(this.centre.getIdCentreGestion()) && getSessionController().getCurrentAuthPersonnel()!=null){
					CentreGestionDTO cgA = getCentreGestionDomainService().getCentreGestion(this.centre.getIdCentreGestion());
					if(!getSessionController().getCurrentCentresGestion().contains(cgA)){
						getSessionController().getCurrentCentresGestion().add(cgA);
					}
					if(getSessionController().getCurrentCentresGestion()!=null && !getSessionController().getCurrentCentresGestion().isEmpty()){
						Collections.sort(getSessionController().getCurrentCentresGestion(), new Comparator<CentreGestionDTO>(){
							/**
							 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
							 */
							@Override
							public int compare(CentreGestionDTO c1, CentreGestionDTO c2) {
								return c1.getNomCentre().compareTo(c2.getNomCentre());
							}
						});
					}
				}
				Map<Integer, DroitAdministrationDTO> droitsAccesMap = getSessionController().getDroitsAccesMap();
				if(droitsAccesMap!=null &&
						!droitsAccesMap.isEmpty() && 
						!droitsAccesMap.containsKey(this.centre.getIdCentreGestion())){
					droitsAccesMap.put(this.centre.getIdCentreGestion(), this.personnel.getDroitAdmin());
					getSessionController().setDroitsAccesMap(droitsAccesMap);
				}
				// Nouveaux droits d'acces aux fiches d'evaluation
				Map<Integer, Boolean> droitsEvaluationEtudiantMap = getSessionController().getDroitsEvaluationEtudiantMap();
				if(this.personnel.isDroitEvaluationEtudiant()){
					// Si l'on ajoute le meme personnel que l'user connecté, ajout dans sa map du droit d'evaluation
					droitsEvaluationEtudiantMap.put(this.centre.getIdCentreGestion(), true);
				} else {
					// Si le droit evaluation est mis a false, retrait de la clef
					if (droitsEvaluationEtudiantMap.containsKey(this.personnel.getIdCentreGestion())) droitsEvaluationEtudiantMap.remove(this.personnel.getIdCentreGestion());
				}
				getSessionController().setDroitsEvaluationEtudiantMap(droitsEvaluationEtudiantMap);

				Map<Integer, Boolean> droitsEvaluationEnseignantMap = getSessionController().getDroitsEvaluationEnseignantMap();
				if(this.personnel.isDroitEvaluationEnseignant()){
					// Si l'on ajoute le meme personnel que l'user connecté, ajout dans sa map du droit d'evaluation
					droitsEvaluationEnseignantMap.put(this.centre.getIdCentreGestion(), true);
				} else {
					// Si le droit evaluation est mis a false, retrait de la clef
					if (droitsEvaluationEnseignantMap.containsKey(this.personnel.getIdCentreGestion())) droitsEvaluationEnseignantMap.remove(this.personnel.getIdCentreGestion());
				}
				getSessionController().setDroitsEvaluationEnseignantMap(droitsEvaluationEnseignantMap);
				

				Map<Integer, Boolean> droitsEvaluationEntrepriseMap = getSessionController().getDroitsEvaluationEntrepriseMap();
				if(this.personnel.isDroitEvaluationEntreprise()){
					// Si l'on ajoute le meme personnel que l'user connecté, ajout dans sa map du droit d'evaluation
					droitsEvaluationEntrepriseMap.put(this.centre.getIdCentreGestion(), true);
				} else {
					// Si le droit evaluation est mis a false, retrait de la clef
					if (droitsEvaluationEntrepriseMap.containsKey(this.personnel.getIdCentreGestion())) droitsEvaluationEntrepriseMap.remove(this.personnel.getIdCentreGestion());
				}
				getSessionController().setDroitsEvaluationEntrepriseMap(droitsEvaluationEntrepriseMap);
			}
			if(logger.isDebugEnabled()){
				logger.debug("idPersonnelCentreGestion : " + idPersonnelCentreGestion);
			}
		}  catch (PersonalAlreadyExistingForCentreException pe){
			logger.error("DataAddException",pe.fillInStackTrace());
			addErrorMessage("formAjoutPersonnel:erreurAjout","CENTRE.PERSONNEL.ALREADYEXISTING",this.personnel.getUidPersonnel());
			return null;
		} catch (DataAddException d){
			logger.error("DataAddException",d.fillInStackTrace());
			addErrorMessage("formAjoutPersonnel:erreurAjout","CENTRE.PERSONNEL.ERREURAJOUT");
			return null;
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formAjoutPersonnel:erreurAjout", "CENTRE.WS.ERREUR");
			return null;
		}catch (Exception e){
			logger.error("Exception",e.fillInStackTrace());
			addErrorMessage("formAjoutPersonnel:erreurAjout","CENTRE.PERSONNEL.ERREUR");
			return null;
		}

		this.personnel = new PersonnelCentreGestionDTO();

		return "listePersonnels";
	}

	/* ****************************************************************************
	 * Consulter un personnel rattaché
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToVoirPersonnel(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToVoirPersonnel() ");
		}
		return "voirPersonnel";
	}

	/* ****************************************************************************
	 * Modifier un personnel rattaché
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String goToModifPersonnel(){
		if(logger.isDebugEnabled()){
			logger.debug("public String goToModifPersonnel() ");
		}
		return "modifPersonnel";
	}

	/**
	 * @return a String
	 */
	public String modifierPersonnel(){
		if(logger.isDebugEnabled()){
			logger.debug("public String modifierPersonnel() ");
		}

		personnel.setLoginModif(getSessionController().getCurrentLogin());

		// On défini l'idDroitAdministration à partir de l'objet DroitAdministration attaché au personnel
		personnel.setIdDroitAdmin(personnel.getDroitAdmin().getId());

		try{
			// Modification du personnel
			getPersonnelCentreGestionDomainService().updatePersonnelCentreGestion(personnel);

			//Maj droit
			Map<Integer, DroitAdministrationDTO> droitsAccesMap = getSessionController().getDroitsAccesMap();
			if (droitsAccesMap!=null 
					&& !droitsAccesMap.isEmpty() 
					&& droitsAccesMap.containsKey(this.personnel.getIdCentreGestion())){
				droitsAccesMap.remove(this.personnel.getIdCentreGestion());
				droitsAccesMap.put(this.personnel.getIdCentreGestion(), this.personnel.getDroitAdmin());
				getSessionController().setDroitsAccesMap(droitsAccesMap);
			}

			// Nouveaux droits d'acces aux fiches d'evaluation
			Map<Integer, Boolean> droitsEvaluationEtudiantMap = getSessionController().getDroitsEvaluationEtudiantMap();
			if(this.personnel.isDroitEvaluationEtudiant()){
				// Si l'on ajoute le meme personnel que l'user connecté, ajout dans sa map du droit d'evaluation
				droitsEvaluationEtudiantMap.put(this.centre.getIdCentreGestion(), true);
			} else {
				// Si le droit evaluation est mis a false, retrait de la clef
				if (droitsEvaluationEtudiantMap.containsKey(this.personnel.getIdCentreGestion())) droitsEvaluationEtudiantMap.remove(this.personnel.getIdCentreGestion());
			}
			getSessionController().setDroitsEvaluationEtudiantMap(droitsEvaluationEtudiantMap);

			Map<Integer, Boolean> droitsEvaluationEnseignantMap = getSessionController().getDroitsEvaluationEnseignantMap();
			if(this.personnel.isDroitEvaluationEnseignant()){
				// Si l'on ajoute le meme personnel que l'user connecté, ajout dans sa map du droit d'evaluation
				droitsEvaluationEnseignantMap.put(this.centre.getIdCentreGestion(), true);
			} else {
				// Si le droit evaluation est mis a false, retrait de la clef
				if (droitsEvaluationEnseignantMap.containsKey(this.personnel.getIdCentreGestion())) droitsEvaluationEnseignantMap.remove(this.personnel.getIdCentreGestion());
			}
			getSessionController().setDroitsEvaluationEnseignantMap(droitsEvaluationEnseignantMap);
			

			Map<Integer, Boolean> droitsEvaluationEntrepriseMap = getSessionController().getDroitsEvaluationEntrepriseMap();
			if(this.personnel.isDroitEvaluationEntreprise()){
				// Si l'on ajoute le meme personnel que l'user connecté, ajout dans sa map du droit d'evaluation
				droitsEvaluationEntrepriseMap.put(this.centre.getIdCentreGestion(), true);
			} else {
				// Si le droit evaluation est mis a false, retrait de la clef
				if (droitsEvaluationEntrepriseMap.containsKey(this.personnel.getIdCentreGestion())) droitsEvaluationEntrepriseMap.remove(this.personnel.getIdCentreGestion());
			}
			getSessionController().setDroitsEvaluationEntrepriseMap(droitsEvaluationEntrepriseMap);
		} catch (DataUpdateException d){
			logger.error("DataUpdateException",d.fillInStackTrace());
			addErrorMessage("formModifPersonnel:erreurModifPersonnel","CENTRE.PERSONNEL.MODIF.ERREUR");
			return null;
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formModifPersonnel:erreurModifPersonnel", "CENTRE.PERSONNEL.MODIF.ERREUR");
			return null;
		}

		this.personnel = new PersonnelCentreGestionDTO();

		return "listePersonnels";
	}

	/* ****************************************************************************
	 * Supprimer un personnel rattaché
	 *****************************************************************************/
	/**
	 * @return a String
	 */
	public String supprimerPersonnel(){
		if(logger.isDebugEnabled()){
			logger.debug("public String supprimerPersonnel()");
		}
		if(this.personnel!=null){
			if(logger.isInfoEnabled()){
				logger.info("Suppression du Personnel de Centre de gestion : "+this.personnel);
			}
			try {
				// Suppression du personnel en base
				getPersonnelCentreGestionDomainService().deletePersonnelCentreGestion(this.personnel.getIdCentreGestion(), this.personnel.getId());
				// Suppression du personnel dans la liste du controleur
				this.personnels.remove(this.personnel);
				//Méj liste des centres pour la personne connectée
				if(this.personnel.getUidPersonnel().equals(getSessionController().getCurrentLogin())){
					if(!getSessionController().getCurrentCentresGestion().contains(this.centre.getIdCentreGestion()) && getSessionController().getCurrentAuthPersonnel()!=null){
						getSessionController().getCurrentCentresGestion().remove(getCentreGestionDomainService().getCentreGestion(this.centre.getIdCentreGestion()));
						if(getSessionController().getCurrentCentresGestion()!=null && !getSessionController().getCurrentCentresGestion().isEmpty()){
							Collections.sort(getSessionController().getCurrentCentresGestion(), new Comparator<CentreGestionDTO>(){
								/**
								 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
								 */
								@Override
								public int compare(CentreGestionDTO c1, CentreGestionDTO c2) {
									return c1.getNomCentre().compareTo(c2.getNomCentre());
								}
							});
						}
					}
					//Maj droits
					Map<Integer, DroitAdministrationDTO> droitsAccesMap = getSessionController().getDroitsAccesMap();
					if(droitsAccesMap!=null &&
							!droitsAccesMap.isEmpty() && 
							droitsAccesMap.containsKey(this.personnel.getIdCentreGestion())){
						droitsAccesMap.remove(this.personnel.getIdCentreGestion());
						getSessionController().setDroitsAccesMap(droitsAccesMap);
					}
					
					if (this.personnel.isDroitEvaluationEtudiant()){
						Map<Integer, Boolean> droitsEvaluationEtudiantMap = getSessionController().getDroitsEvaluationEtudiantMap();
						if(droitsEvaluationEtudiantMap!=null &&
								!droitsEvaluationEtudiantMap.isEmpty() && 
								droitsEvaluationEtudiantMap.containsKey(this.centre.getIdCentreGestion())){
							droitsEvaluationEtudiantMap.remove(this.personnel.getIdCentreGestion());
							getSessionController().setDroitsEvaluationEtudiantMap(droitsEvaluationEtudiantMap);
						}
					}
					if (this.personnel.isDroitEvaluationEnseignant()){
						Map<Integer, Boolean> droitsEvaluationEnseignantMap = getSessionController().getDroitsEvaluationEnseignantMap();
						if(droitsEvaluationEnseignantMap!=null &&
								!droitsEvaluationEnseignantMap.isEmpty() && 
								droitsEvaluationEnseignantMap.containsKey(this.centre.getIdCentreGestion())){
							droitsEvaluationEnseignantMap.remove(this.personnel.getIdCentreGestion());
							getSessionController().setDroitsEvaluationEnseignantMap(droitsEvaluationEnseignantMap);
						}
					}
					if (this.personnel.isDroitEvaluationEntreprise()){
						Map<Integer, Boolean> droitsEvaluationEntrepriseMap = getSessionController().getDroitsEvaluationEntrepriseMap();
						if(droitsEvaluationEntrepriseMap!=null &&
								!droitsEvaluationEntrepriseMap.isEmpty() && 
								droitsEvaluationEntrepriseMap.containsKey(this.centre.getIdCentreGestion())){
							droitsEvaluationEntrepriseMap.remove(this.personnel.getIdCentreGestion());
							getSessionController().setDroitsEvaluationEtudiantMap(droitsEvaluationEntrepriseMap);
						}
					}
				}
			} catch (DataDeleteException e) {
				logger.error("DataDeleteException", e.fillInStackTrace());
				addErrorMessage("formSupprPersonnel:erreurSupprPersonnel", "CENTRE.PERSONNEL.SUPPRESSION.ERREUR",this.personnel.getUidPersonnel());
				return null;
			} catch (WebServiceDataBaseException e) {
				logger.error("WebServiceDataBaseException", e.fillInStackTrace());
				addErrorMessage("formSupprPersonnel:erreurSupprPersonnel", "CENTRE.PERSONNEL.SUPPRESSION.ERREUR",this.personnel.getUidPersonnel());
				return null;
			}

			this.personnel = new PersonnelCentreGestionDTO();
		}
		return "listePersonnels";
	}

	/* ***************************************************************
	 * Gestion des menus deroulants de confidentialite
	 ****************************************************************/
	/**
	 * @return boolean
	 */
	public boolean isConfidentialiteAffichable(){
		CentreGestionDTO etab = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite());

		if(etab != null){
			// Si l'etablissement a deja ete cree

			if(this.centre.getIdCentreGestion() == etab.getIdCentreGestion()){
				// Si le centre actuellement stocké dans le centreController est l'etablissement,
				// on peut afficher le menu déroulant des confidentialités
				return true;
			}

			// On récupére son code de confidentialite
			String codeConfEtablissement = etab.getCodeConfidentialite();

			if (codeConfEtablissement.equals(DonneesStatic.CODE_CONFIDENTIALITE_LIBRE)){
				// Si le code de l'etablissement est à Libre, 
				// on peut afficher le menu déroulant des confidentialités
				return true;
			}
		} else {
			// Sinon, le centre etablissement n'a pas encore été créé
			// c'est donc forcément lui qui est en cours d'ajout et le menu déroulant est donc affiché
			return true;
		}

		return false;
	}	

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getConfidentialites(){
		List<SelectItem> ls = new ArrayList<SelectItem>();

		// On crée les selectItem pour chaque critere et on les ajoute à la liste
		SelectItem itmConfNulle = new SelectItem(getBeanUtils().getConfidentialiteNulle(),(getBeanUtils().getConfidentialiteNulle().getLibelle()));
		ls.add(itmConfNulle);
		SelectItem itmConfTotale = new SelectItem(getBeanUtils().getConfidentialiteTotale(),(getBeanUtils().getConfidentialiteTotale().getLibelle()));
		ls.add(itmConfTotale);
		SelectItem itmConfLibre = new SelectItem(getBeanUtils().getConfidentialiteLibre(),(getBeanUtils().getConfidentialiteLibre().getLibelle()));
		ls.add(itmConfLibre);

		CentreGestionDTO etab = new CentreGestionDTO();
		etab = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite());

		if (this.centre.getIdCentreGestion() != 0){
			// Si un centre est stocké dans la variable centre du CentreController(donc en cours de modification)
			if (etab != null 
					&& this.centre.getIdCentreGestion() != etab.getIdCentreGestion()){
				// Si l'Etablissement existe déjé et que ce n'est pas le centre actuellement modifié
				// On retire la confidentialite libre (qui n'est dispo que pour l'etablissement)
				ls.remove(itmConfLibre);
			}
		} else {
			// Sinon, aucun centre n'est stocké dans la variable centre du CentreController (donc en cours d'ajout)
			if (etab != null){
				// Si l'Etablissement existe déjà
				// On retire la confidentialite libre (qui n'est dispo que pour l'etablissement)
				ls.remove(itmConfLibre);
			}
		}
		return ls;
	}

	/**
	 * @return the confidentialiteEtablissement
	 */
	public ConfidentialiteDTO getConfidentialiteEtablissement() {
		this.confidentialiteEtablissement = new ConfidentialiteDTO();

		CentreGestionDTO etab = new CentreGestionDTO();
		etab = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite());

		if(etab != null) {
			String codeConfEtablissement = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite()).getCodeConfidentialite();
			this.confidentialiteEtablissement = getNomenclatureDomainService().getConfidentialiteFromCode(codeConfEtablissement);
		}

		return confidentialiteEtablissement;
	}

	/* ***************************************************************
	 * Gestion des menus deroulants de niveaux de centers
	 ****************************************************************/
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getNiveauxCentre(){
		List<SelectItem> ls = new ArrayList<SelectItem>();

		// On crée les selectItem pour chaque critere et on les ajoute à la liste
		SelectItem itmEtablissement = new SelectItem(getBeanUtils().getEtablissement(),(getBeanUtils().getEtablissement()).getLibelle());
		ls.add(itmEtablissement);
		SelectItem itmEtape = new SelectItem(getBeanUtils().getEtape(),(getBeanUtils().getEtape()).getLibelle());
		ls.add(itmEtape);
		SelectItem itmUfr = new SelectItem(getBeanUtils().getUfr(),(getBeanUtils().getUfr()).getLibelle());
		ls.add(itmUfr);

		if (this.centre.getIdCentreGestion() != 0){
			// Si un centre est stocké dans la variable centre du centreController (donc en cours de modification)
			if ((this.centre.getIdCentreGestion() != (getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite())).getIdCentreGestion())
					&& getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite())!=null){
				// Si l'Etablissement existe et que ce n'est pas l'etablissement en cours de modification, on le retire de la liste
				ls.remove(itmEtablissement);

				if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_ETAPE)){
					// Si le critere de gestion defini dans le fichier de config est 'ETAPE', on retire 'UFR' de la liste
					ls.remove(itmUfr);
				} else if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_UFR)){
					// Si le critere de gestion defini dans le fichier de config est 'UFR', on retire 'ETAPE' de la liste
					ls.remove(itmEtape);
				} else if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_MIXTE)){

					// Si le critere de gestion defini dans le fichier de config est 'MIXTE', on ne retire rien de la liste

				} else {
					// Si le critere de gestion defini dans le fichier de config est vide, on retire 'ETAPE' et 'UFR' de la liste
					ls.remove(itmEtape);
					ls.remove(itmUfr);
				}
			} else {
				// Si le centre etablissement n'existe pas encore ou qu'il est en cours de modification, on retire les possibilité 'ETAPE' et 'UFR'
				ls.remove(itmEtape);
				ls.remove(itmUfr);
			}
		} else {

			// Sinon, aucun centre n'est stocké dans la variable centre du CentreController (donc en cours d'ajout)
			if (getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite())!=null){
				// Si l'Etablissement existe, on le retire de la liste
				ls.remove(itmEtablissement);

				if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_ETAPE)){
					// Si le critere de gestion defini dans le fichier de config est 'ETAPE', on retire 'UFR' de la liste
					ls.remove(itmUfr);
				} else if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_UFR)){
					// Si le critere de gestion defini dans le fichier de config est 'UFR', on retire 'ETAPE' de la liste
					ls.remove(itmEtape);
				} else if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_MIXTE)){

					// Si le critere de gestion defini dans le fichier de config est 'MIXTE', on ne retire rien de la liste

				} else {
					// Si le critere de gestion defini dans le fichier de config est vide, on retire 'ETAPE' et 'UFR' de la liste
					ls.remove(itmEtape);
					ls.remove(itmUfr);
				}
			} else {
				// Si le centre etablissement n'existe pas encore ou qu'il est en cours de modification, on retire les possibilités 'ETAPE' et 'UFR'
				ls.remove(itmEtape);
				ls.remove(itmUfr);
			}
		}

		return ls;
	}

	/* ****************************************************************************
	 * DEPOT ANONYME
	 *****************************************************************************/

	/**
	 * @return the depotEncode
	 */
	public String getDepotEncode() {
		depotEncode="";
		if(this.centre!=null){
			depotEncode=Utils.encodageIdCgMd5(this.centre.getIdCentreGestion());
		}
		return depotEncode;
	}

	/* ****************************************************************************
	 * Fiche d'evaluation
	 *****************************************************************************/
	
	/**
	 * @return String
	 */
	public String goToFicheEvaluation(){
		this.ficheEvaluation = new FicheEvaluationDTO();
		this.questionSupplementaire = new QuestionSupplementaireDTO();
		FicheEvaluationDTO tmp = getFicheEvaluationDomainService().getFicheEvaluationFromIdCentre(this.centre.getIdCentreGestion());
		if (tmp != null){
			this.ficheEvaluation = tmp;
		} else {
			this.ficheEvaluation.setIdCentreGestion(this.centre.getIdCentreGestion());
			try{
				int idFicheEvaluation = getFicheEvaluationDomainService().addFicheEvaluation(this.ficheEvaluation);
				if (idFicheEvaluation > 0){
					// On recupere apres insertion afin que tous les champs soient mis a default true
					this.ficheEvaluation = getFicheEvaluationDomainService().getFicheEvaluationFromIdCentre(this.centre.getIdCentreGestion());
				}
			} catch (DataAddException d){
				logger.error("DataAddException",d.fillInStackTrace());
				addErrorMessage("formFicheEtudiant","CENTRE.AJOUT_CENTRE.ERREUR");
				return null;
			} catch (WebServiceDataBaseException w){
				logger.error("WebServiceDataBaseException", w.fillInStackTrace());
				addErrorMessage("formFicheEtudiant", "CENTRE.AJOUT_CENTRE.ERREUR");
				return null;
			}
		}
		return "goToFicheEvaluation";
	}

	/**
	 * @return String
	 */
	public String goToFicheEtudiant(){
		this.listeQuestionsSupplementairesEtudiant1 = getFicheEvaluationDomainService().getQuestionsSupplementairesFromIdPlacement(this.ficheEvaluation.getIdFicheEvaluation(), 1);
		if(this.listeQuestionsSupplementairesEtudiant1 == null){
			this.listeQuestionsSupplementairesEtudiant1 = new ArrayList<QuestionSupplementaireDTO>();
		}
		this.listeQuestionsSupplementairesEtudiant2 = getFicheEvaluationDomainService().getQuestionsSupplementairesFromIdPlacement(this.ficheEvaluation.getIdFicheEvaluation(), 2);
		if(this.listeQuestionsSupplementairesEtudiant2 == null){
			this.listeQuestionsSupplementairesEtudiant2 = new ArrayList<QuestionSupplementaireDTO>();
		}
		this.listeQuestionsSupplementairesEtudiant3 = getFicheEvaluationDomainService().getQuestionsSupplementairesFromIdPlacement(this.ficheEvaluation.getIdFicheEvaluation(), 3);
		if(this.listeQuestionsSupplementairesEtudiant3 == null){
			this.listeQuestionsSupplementairesEtudiant3 = new ArrayList<QuestionSupplementaireDTO>();
		}
		return "goToFicheEtudiant";
	}

	/**
	 * 
	 */
	public void updateFicheEtudiant(){
		if (this.ficheEvaluation != null){
			try {
				this.ficheEvaluation.setValidationEtudiant(true);
				getFicheEvaluationDomainService().updateFicheEvaluationEtudiant(this.ficheEvaluation);
				addInfoMessage("formFicheEtudiant", "CENTRE.FICHE_EVALUATION.CONFIRMATION_MODIF");
			} catch (DataUpdateException d){
				logger.error("DataUpdateException",d.fillInStackTrace());
				addErrorMessage("formFicheEtudiant","CENTRE.FICHE_EVALUATION.ERREUR");
			} catch (WebServiceDataBaseException w){
				logger.error("WebServiceDataBaseException", w.fillInStackTrace());
				addErrorMessage("formFicheEtudiant", "CENTRE.FICHE_EVALUATION.ERREUR");
			}
		}
	}

	/**
	 * @return String
	 */
	public String goToFicheEnseignant(){
		this.listeQuestionsSupplementairesEnseignant1 = getFicheEvaluationDomainService().getQuestionsSupplementairesFromIdPlacement(this.ficheEvaluation.getIdFicheEvaluation(),4);
		if(this.listeQuestionsSupplementairesEnseignant1 == null){
			this.listeQuestionsSupplementairesEnseignant1 = new ArrayList<QuestionSupplementaireDTO>();
		}
		this.listeQuestionsSupplementairesEnseignant2 = getFicheEvaluationDomainService().getQuestionsSupplementairesFromIdPlacement(this.ficheEvaluation.getIdFicheEvaluation(),5);
		if(this.listeQuestionsSupplementairesEnseignant2 == null){
			this.listeQuestionsSupplementairesEnseignant2 = new ArrayList<QuestionSupplementaireDTO>();
		}
		return "goToFicheEnseignant";
	}

	/**
	 * 
	 */
	public void updateFicheEntreprise(){
		if (this.ficheEvaluation != null){
			try {
				this.ficheEvaluation.setValidationEntreprise(true);
				getFicheEvaluationDomainService().updateFicheEvaluationEntreprise(this.ficheEvaluation);
				addInfoMessage("formFicheEntreprise", "CENTRE.FICHE_EVALUATION.CONFIRMATION_MODIF");
			} catch (DataUpdateException d){
				logger.error("DataUpdateException",d.fillInStackTrace());
				addErrorMessage("formFicheEntreprise","CENTRE.FICHE_EVALUATION.ERREUR");
			} catch (WebServiceDataBaseException w){
				logger.error("WebServiceDataBaseException", w.fillInStackTrace());
				addErrorMessage("formFicheEntreprise", "CENTRE.FICHE_EVALUATION.ERREUR");
			}
		}
	}

	/**
	 * @return String
	 */
	public String goToFicheEntreprise(){

		this.listeQuestionsSupplementairesEntreprise1 = getFicheEvaluationDomainService().getQuestionsSupplementairesFromIdPlacement(this.ficheEvaluation.getIdFicheEvaluation(),6);
		if(this.listeQuestionsSupplementairesEntreprise1 == null){
			this.listeQuestionsSupplementairesEntreprise1 = new ArrayList<QuestionSupplementaireDTO>();
		}
		this.listeQuestionsSupplementairesEntreprise2 = getFicheEvaluationDomainService().getQuestionsSupplementairesFromIdPlacement(this.ficheEvaluation.getIdFicheEvaluation(),7);
		if(this.listeQuestionsSupplementairesEntreprise2 == null){
			this.listeQuestionsSupplementairesEntreprise2 = new ArrayList<QuestionSupplementaireDTO>();
		}
		this.listeQuestionsSupplementairesEntreprise3 = getFicheEvaluationDomainService().getQuestionsSupplementairesFromIdPlacement(this.ficheEvaluation.getIdFicheEvaluation(),8);
		if(this.listeQuestionsSupplementairesEntreprise3 == null){
			this.listeQuestionsSupplementairesEntreprise3 = new ArrayList<QuestionSupplementaireDTO>();
		}
		
		return "goToFicheEntreprise";
	}

	/**
	 * 
	 */
	public void updateFicheEnseignant(){
		if (this.ficheEvaluation != null){
			try {
				this.ficheEvaluation.setValidationEnseignant(true);
				getFicheEvaluationDomainService().updateFicheEvaluationEnseignant(this.ficheEvaluation);
				addInfoMessage("formFicheEnseignant", "CENTRE.FICHE_EVALUATION.CONFIRMATION_MODIF");
			} catch (DataUpdateException d){
				logger.error("DataUpdateException",d.fillInStackTrace());
				addErrorMessage("formFicheEnseignant","CENTRE.FICHE_EVALUATION.ERREUR");
			} catch (WebServiceDataBaseException w){
				logger.error("WebServiceDataBaseException", w.fillInStackTrace());
				addErrorMessage("formFicheEnseignant", "CENTRE.FICHE_EVALUATION.ERREUR");
			}
		}
	}

	/**
	 * initialisation question supplementaire etudiant I
	 */
	public void avantAjoutQuestionEtudiant1(){
		this.questionSupplementaire = new QuestionSupplementaireDTO();
		this.questionSupplementaire.setIdPlacement(1);
	}
	/**
	 * initialisation question supplementaire etudiant II
	 */
	public void avantAjoutQuestionEtudiant2(){
		this.questionSupplementaire = new QuestionSupplementaireDTO();
		this.questionSupplementaire.setIdPlacement(2);
	}
	/**
	 * initialisation question supplementaire etudiant III
	 */
	public void avantAjoutQuestionEtudiant3(){
		this.questionSupplementaire = new QuestionSupplementaireDTO();
		this.questionSupplementaire.setIdPlacement(3);
	}
	/**
	 * initialisation question supplementaire enseignant I
	 */
	public void avantAjoutQuestionEnseignant1(){
		this.questionSupplementaire = new QuestionSupplementaireDTO();
		this.questionSupplementaire.setIdPlacement(4);
	}
	/**
	 * initialisation question supplementaire enseignant II
	 */
	public void avantAjoutQuestionEnseignant2(){
		this.questionSupplementaire = new QuestionSupplementaireDTO();
		this.questionSupplementaire.setIdPlacement(5);
	}
	/**
	 * initialisation question supplementaire entreprise I
	 */
	public void avantAjoutQuestionEntreprise1(){
		this.questionSupplementaire = new QuestionSupplementaireDTO();
		this.questionSupplementaire.setIdPlacement(6);
	}
	/**
	 * initialisation question supplementaire entreprise II
	 */
	public void avantAjoutQuestionEntreprise2(){
		this.questionSupplementaire = new QuestionSupplementaireDTO();
		this.questionSupplementaire.setIdPlacement(7);
	}
	/**
	 * initialisation question supplementaire entreprise III
	 */
	public void avantAjoutQuestionEntreprise3(){
		this.questionSupplementaire = new QuestionSupplementaireDTO();
		this.questionSupplementaire.setIdPlacement(8);
	}

	/**
	 * 
	 */
	public void ajouterQuestionSupplementaire(){
		try{
			getSessionController().setEditQuestionEvalCurrentPage("_questionEval_editEtape2");
			this.questionSupplementaire.setIdFicheEvaluation(this.ficheEvaluation.getIdFicheEvaluation());

			int idQuestionSupplementaire = getFicheEvaluationDomainService().addQuestionSupplementaire(this.questionSupplementaire);
			
			if (idQuestionSupplementaire > 0) {
				this.questionSupplementaire.setIdQuestionSupplementaire(idQuestionSupplementaire);

				int idPlacement = this.questionSupplementaire.getIdPlacement();
				switch (idPlacement) {
				case 1 :
					this.listeQuestionsSupplementairesEtudiant1.add(this.questionSupplementaire);
					break;
				case 2 :
					this.listeQuestionsSupplementairesEtudiant2.add(this.questionSupplementaire);
					break;
				case 3 :
					this.listeQuestionsSupplementairesEtudiant3.add(this.questionSupplementaire);
					break;
				case 4 :
					this.listeQuestionsSupplementairesEnseignant1.add(this.questionSupplementaire);
					break;
				case 5 :
					this.listeQuestionsSupplementairesEnseignant2.add(this.questionSupplementaire);
					break;
				case 6 :
					this.listeQuestionsSupplementairesEntreprise1.add(this.questionSupplementaire);
					break;
				case 7 :
					this.listeQuestionsSupplementairesEntreprise2.add(this.questionSupplementaire);
					break;
				case 8 :
					this.listeQuestionsSupplementairesEntreprise3.add(this.questionSupplementaire);
					break;
				default:
					break;
				}

				addInfoMessage(null, "CENTRE.FICHE_EVALUATION.QUESTION_SUPPLEMENTAIRE.CONFIRMATION_AJOUT");
				logger.info("Ajout de la question supplementaire n°"+idQuestionSupplementaire+" pour la fiche n°" +this.ficheEvaluation.getIdFicheEvaluation());
			} else {
				logger.error(getString("CENTRE.FICHE_EVALUATION.ERREUR"));
				addErrorMessage("formEditQuestionEval", "CENTRE.FICHE_EVALUATION.ERREUR");
			}
		} catch (DataAddException d){
			logger.error("DataAddException",d.fillInStackTrace());
			addErrorMessage("formEditQuestionEval","CENTRE.FICHE_EVALUATION.CONFIRMATION_MODIF");
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formEditQuestionEval", "CENTRE.FICHE_EVALUATION.ERREUR");
		}
	}

	/**
	 * 
	 */
	public void modifierQuestionSupplementaire(){
		try {
			getSessionController().setEditQuestionEvalCurrentPage("_questionEval_editEtape2");

			if (getFicheEvaluationDomainService().updateQuestionSupplementaire(this.questionSupplementaire)){
				addInfoMessage(null, "CENTRE.FICHE_EVALUATION.QUESTION_SUPPLEMENTAIRE.CONFIRMATION_MODIF");
				logger.info("Modification de la question supplementaire n°"+this.questionSupplementaire.getIdQuestionSupplementaire()+" pour la fiche n°" +this.ficheEvaluation.getIdFicheEvaluation());
			} else {
				logger.error(getString("CENTRE.FICHE_EVALUATION.ERREUR"));
				addErrorMessage("formEditQuestionEval", "CENTRE.FICHE_EVALUATION.ERREUR");
			}

		} catch (DataUpdateException d){
			logger.error("DataUpdateException",d.fillInStackTrace());
			addErrorMessage("formEditQuestionEval","CENTRE.FICHE_EVALUATION.ERREUR");
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formEditQuestionEval", "CENTRE.FICHE_EVALUATION.ERREUR");
		}
	}
	/**
	 * @return a String
	 */
	public void supprimerQuestionSupplementaire(){
		try{
			getSessionController().setSuppressionQuestionEvalCurrentPage("_questionEval_deleteEtape2");

			if (getFicheEvaluationDomainService().deleteQuestionSupplementaire(this.questionSupplementaire.getIdQuestionSupplementaire())){
				int idPlacement = this.questionSupplementaire.getIdPlacement();
				switch (idPlacement) {
				case 1 :
					this.listeQuestionsSupplementairesEtudiant1.remove(this.questionSupplementaire);
					break;
				case 2 :
					this.listeQuestionsSupplementairesEtudiant2.remove(this.questionSupplementaire);
					break;
				case 3 :
					this.listeQuestionsSupplementairesEtudiant3.remove(this.questionSupplementaire);
					break;
				case 4 :
					this.listeQuestionsSupplementairesEnseignant1.remove(this.questionSupplementaire);
					break;
				case 5 :
					this.listeQuestionsSupplementairesEnseignant2.remove(this.questionSupplementaire);
					break;
				case 6 :
					this.listeQuestionsSupplementairesEntreprise1.remove(this.questionSupplementaire);
					break;
				case 7 :
					this.listeQuestionsSupplementairesEntreprise2.remove(this.questionSupplementaire);
					break;
				case 8 :
					this.listeQuestionsSupplementairesEntreprise3.remove(this.questionSupplementaire);
					break;
				default:
					break;
				}

				logger.info(getSessionController().getCurrentLogin()+" supprime la question : "
						+this.questionSupplementaire.getIdQuestionSupplementaire()+" - " +this.questionSupplementaire.getQuestion());
				addInfoMessage(null, "CENTRE.FICHE_EVALUATION.QUESTION_SUPPLEMENTAIRE.CONFIRMATION_SUPPR");
			} else {
				logger.error(getString("CENTRE.FICHE_EVALUATION.ERREUR"));
				addErrorMessage("formSupprCentre:erreurListeCentre", "CENTRE.SUPPRESSION.ERREUR");
			}

		}catch (DataDeleteException de) {
			logger.error("DataDeleteException ",de.fillInStackTrace());
			addErrorMessage("formSupprCentre:erreurListeCentre", "CENTRE.SUPPRESSION.ERREUR");
		}catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ",we.fillInStackTrace());
			addErrorMessage("formSupprCentre:erreurListeCentre", "CENTRE.SUPPRESSION.ERREUR");
		}
	}

	/* ***************************************************************
	 * Getters / Setters
	 *****************************************************************/
	/**
	 * @param centre the centre to set
	 */
	public void setCentre(CentreGestionDTO centre) {
		this.centre = centre;
	}
	/**
	 * @return the centre
	 */
	public CentreGestionDTO getCentre() {
		return centre;
	}
	/**
	 * @param nbCriteres the nbCriteres to set
	 */
	public void setNbCriteres(int nbCriteres) {
		this.nbCriteres = nbCriteres;
	}
	/**
	 * @return the nbCriteres
	 */
	public int getNbCriteres() {
		return nbCriteres;
	}
	/**
	 * @param nbPersonnels the nbPersonnels to set
	 */
	public void setNbPersonnels(int nbPersonnels) {
		this.nbPersonnels = nbPersonnels;
	}
	/**
	 * @return the nbPersonnels
	 */
	public int getNbPersonnels() {
		return nbPersonnels;
	}
	/**
	 * @param listeCentreVide the listeCentreVide to set
	 */
	public void setListeCentreVide(boolean listeCentreVide) {
		this.listeCentreVide = listeCentreVide;
	}
	/**
	 * @return the listeCentreVide
	 */
	public boolean isListeCentreVide() {
		listeCentreVide = this.listeCentreVide();
		return listeCentreVide;
	}
	/**
	 * @param ajoutPossible the ajoutPossible to set
	 */
	public void setAjoutPossible(boolean ajoutPossible) {
		this.ajoutPossible = ajoutPossible;
	}
	/**
	 * @param critere the critere to set
	 */
	public void setCritere(CritereGestionDTO critere) {
		this.critere = critere;
	}
	/**
	 * @return the critere
	 */
	public CritereGestionDTO getCritere() {
		return critere;
	}
	/**
	 * @param listeCritereVide the listeCritereVide to set
	 */
	public void setListeCritereVide(boolean listeCritereVide) {
		this.listeCritereVide = listeCritereVide;
	}
	/**
	 * @return the listeCritereVide
	 */
	public boolean isListeCritereVide() {
		listeCritereVide = this.listeCritereVide();
		return listeCritereVide;
	}
	/**
	 * @return the uploadedLogo
	 */
	public UploadedFile getUploadedLogo() {
		return uploadedLogo;
	}
	/**
	 * @param uploadedLogo the uploadedLogo to set
	 */
	public void setUploadedLogo(UploadedFile uploadedLogo) {
		this.uploadedLogo = uploadedLogo;
	}
	/**
	 * @param logosDir the logosDir to set
	 */
	public void setlogosDir(String logosDir) {
		this.logosDir = logosDir;
	}
	/**
	 * @return the logosDir
	 */
	public String getlogosDir() {
		return logosDir;
	}
	/**
	 * @param appliDir the appliDir to set
	 */
	public void setAppliDir(String appliDir) {
		this.appliDir = appliDir;
	}
	/**
	 * @return appliDir
	 */
	public String getAppliDir() {
		return appliDir;
	}
	/**
	 * @param personnel the personnel to set
	 */
	public void setPersonnel(PersonnelCentreGestionDTO personnel) {
		this.personnel = personnel;
	}
	/**
	 * @return the personnel
	 */
	public PersonnelCentreGestionDTO getPersonnel() {
		return personnel;
	}
	/**
	 * @param recherchePersonnels the recherchePersonnels to set
	 */
	public void setRecherchePersonnels(List<PersonnelCentreGestionDTO> recherchePersonnels) {
		this.recherchePersonnels = recherchePersonnels;
	}
	/**
	 * @return the recherchePersonnels
	 */
	public List<PersonnelCentreGestionDTO> getRecherchePersonnels() {
		return recherchePersonnels;
	}
	/**
	 * @param listePersonnelVide the listePersonnelVide to set
	 */
	public void setListePersonnelVide(boolean listePersonnelVide) {
		this.listePersonnelVide = listePersonnelVide;
	}
	/**
	 * @return the listePersonnelVide
	 */
	public boolean isListePersonnelVide() {
		listePersonnelVide = this.listePersonnelVide();
		return listePersonnelVide;
	}

	/**
	 * @param listeAffectationVide the listeAffectationVide to set
	 */
	public void setListeAffectationVide(boolean listeAffectationVide) {
		this.listeAffectationVide = listeAffectationVide;
	}
	/**
	 * @return the listeAffectationVide
	 */
	public boolean isListeAffectationVide() {
		listeAffectationVide = this.listeAffectationVide();
		return listeAffectationVide;
	}

	/**
	 * @return the centreEntreprise
	 */
	public CentreGestionDTO getCentreEntreprise() {
		if(centreEntreprise==null){
			this.centreEntreprise=getCentreGestionDomainService().getCentreEntreprise();
		}
		return centreEntreprise;
	}

	/**
	 * @param centreEntreprise the centreEntreprise to set
	 */
	public void setCentreEntreprise(CentreGestionDTO centreEntreprise) {
		this.centreEntreprise = centreEntreprise;
	}

	/**
	 * @return the formCentreEntreprise
	 */
	public CentreGestionDTO getFormCentreEntreprise() {
		return formCentreEntreprise;
	}

	/**
	 * @param formCentreEntreprise the formCentreEntreprise to set
	 */
	public void setFormCentreEntreprise(CentreGestionDTO formCentreEntreprise) {
		this.formCentreEntreprise = formCentreEntreprise;
	}
	/**
	 * @param listeCriteresChoisis the listeCriteresChoisis to set
	 */
	public void setListeCriteresChoisis(List<Object> listeCriteresChoisis) {
		this.listeCriteresChoisis = listeCriteresChoisis;
	}
	/**
	 * @return the listeCriteresChoisis
	 */
	public List<Object> getListeCriteresChoisis() {
		return listeCriteresChoisis;
	}
	/**
	 * @return the codeAffectationPersonnel
	 */
	public Object getCodeAffectationPersonnel() {
		return codeAffectationPersonnel;
	}
	/**
	 * @param codeAffectationPersonnel the codeAffectationPersonnel to set
	 */
	public void setCodeAffectationPersonnel(Object codeAffectationPersonnel) {
		this.codeAffectationPersonnel = codeAffectationPersonnel;
	}
	/**
	 * @return the toutLesCriteres
	 */
	public Map<String, String> getToutLesCriteres() {
		return toutLesCriteres;
	}
	/**
	 * @param toutLesCriteres the toutLesCriteres to set
	 */
	public void setToutLesCriteres(Map<String, String> toutLesCriteres) {
		this.toutLesCriteres = toutLesCriteres;
	}
	/**
	 * @param nbContacts the nbContacts to set
	 */
	public void setNbContacts(int nbContacts) {
		this.nbContacts = nbContacts;
	}
	/**
	 * @return the nbContacts
	 */
	public int getNbContacts() {
		return nbContacts;
	}
	/**
	 * @param nbConventions the nbConventions to set
	 */
	public void setNbConventions(int nbConventions) {
		this.nbConventions = nbConventions;
	}
	/**
	 * @return the nbConventions
	 */
	public int getNbConventions() {
		return nbConventions;
	}
	/**
	 * @param nbOffres the nbOffres to set
	 */
	public void setNbOffres(int nbOffres) {
		this.nbOffres = nbOffres;
	}
	/**
	 * @return the nbOffres
	 */
	public int getNbOffres() {
		return nbOffres;
	}
	/**
	 * @return the ficheEvaluation
	 */
	public FicheEvaluationDTO getFicheEvaluation() {
		return ficheEvaluation;
	}
	/**
	 * @param ficheEvaluation the ficheEvaluation to set
	 */
	public void setFicheEvaluation(FicheEvaluationDTO ficheEvaluation) {
		this.ficheEvaluation = ficheEvaluation;
	}
	/**
	 * @return the questionSupplementaire
	 */
	public QuestionSupplementaireDTO getQuestionSupplementaire() {
		return questionSupplementaire;
	}
	/**
	 * @param questionSupplementaire the questionSupplementaire to set
	 */
	public void setQuestionSupplementaire(QuestionSupplementaireDTO questionSupplementaire) {
		this.questionSupplementaire = questionSupplementaire;
	}
	/**
	 * @return the listeQuestionsSupplementairesEtudiant1
	 */
	public List<QuestionSupplementaireDTO> getListeQuestionsSupplementairesEtudiant1() {
		return listeQuestionsSupplementairesEtudiant1;
	}
	/**
	 * @param listeQuestionsSupplementairesEtudiant1 the listeQuestionsSupplementairesEtudiant1 to set
	 */
	public void setListeQuestionsSupplementairesEtudiant1(
			List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEtudiant1) {
		this.listeQuestionsSupplementairesEtudiant1 = listeQuestionsSupplementairesEtudiant1;
	}
	/**
	 * @return the listeQuestionsSupplementairesEtudiant2
	 */
	public List<QuestionSupplementaireDTO> getListeQuestionsSupplementairesEtudiant2() {
		return listeQuestionsSupplementairesEtudiant2;
	}
	/**
	 * @param listeQuestionsSupplementairesEtudiant2 the listeQuestionsSupplementairesEtudiant2 to set
	 */
	public void setListeQuestionsSupplementairesEtudiant2(
			List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEtudiant2) {
		this.listeQuestionsSupplementairesEtudiant2 = listeQuestionsSupplementairesEtudiant2;
	}
	/**
	 * @return the listeQuestionsSupplementairesEtudiant3
	 */
	public List<QuestionSupplementaireDTO> getListeQuestionsSupplementairesEtudiant3() {
		return listeQuestionsSupplementairesEtudiant3;
	}
	/**
	 * @param listeQuestionsSupplementairesEtudiant3 the listeQuestionsSupplementairesEtudiant3 to set
	 */
	public void setListeQuestionsSupplementairesEtudiant3(
			List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEtudiant3) {
		this.listeQuestionsSupplementairesEtudiant3 = listeQuestionsSupplementairesEtudiant3;
	}
	/**
	 * @return the listeQuestionsSupplementairesEnseignant1
	 */
	public List<QuestionSupplementaireDTO> getListeQuestionsSupplementairesEnseignant1() {
		return listeQuestionsSupplementairesEnseignant1;
	}
	/**
	 * @param listeQuestionsSupplementairesEnseignant1 the listeQuestionsSupplementairesEnseignant1 to set
	 */
	public void setListeQuestionsSupplementairesEnseignant1(
			List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEnseignant1) {
		this.listeQuestionsSupplementairesEnseignant1 = listeQuestionsSupplementairesEnseignant1;
	}
	/**
	 * @return the listeQuestionsSupplementairesEnseignant2
	 */
	public List<QuestionSupplementaireDTO> getListeQuestionsSupplementairesEnseignant2() {
		return listeQuestionsSupplementairesEnseignant2;
	}
	/**
	 * @param listeQuestionsSupplementairesEnseignant2 the listeQuestionsSupplementairesEnseignant2 to set
	 */
	public void setListeQuestionsSupplementairesEnseignant2(
			List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEnseignant2) {
		this.listeQuestionsSupplementairesEnseignant2 = listeQuestionsSupplementairesEnseignant2;
	}
	/**
	 * @return the listeQuestionsSupplementairesEntreprise1
	 */
	public List<QuestionSupplementaireDTO> getListeQuestionsSupplementairesEntreprise1() {
		return listeQuestionsSupplementairesEntreprise1;
	}
	/**
	 * @param listeQuestionsSupplementairesEntreprise1 the listeQuestionsSupplementairesEntreprise1 to set
	 */
	public void setListeQuestionsSupplementairesEntreprise1(
			List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEntreprise1) {
		this.listeQuestionsSupplementairesEntreprise1 = listeQuestionsSupplementairesEntreprise1;
	}
	/**
	 * @return the listeQuestionsSupplementairesEntreprise2
	 */
	public List<QuestionSupplementaireDTO> getListeQuestionsSupplementairesEntreprise2() {
		return listeQuestionsSupplementairesEntreprise2;
	}
	/**
	 * @param listeQuestionsSupplementairesEntreprise2 the listeQuestionsSupplementairesEntreprise2 to set
	 */
	public void setListeQuestionsSupplementairesEntreprise2(
			List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEntreprise2) {
		this.listeQuestionsSupplementairesEntreprise2 = listeQuestionsSupplementairesEntreprise2;
	}
	/**
	 * @return the listeQuestionsSupplementairesEntreprise3
	 */
	public List<QuestionSupplementaireDTO> getListeQuestionsSupplementairesEntreprise3() {
		return listeQuestionsSupplementairesEntreprise3;
	}
	/**
	 * @param listeQuestionsSupplementairesEntreprise3 the listeQuestionsSupplementairesEntreprise3 to set
	 */
	public void setListeQuestionsSupplementairesEntreprise3(
			List<QuestionSupplementaireDTO> listeQuestionsSupplementairesEntreprise3) {
		this.listeQuestionsSupplementairesEntreprise3 = listeQuestionsSupplementairesEntreprise3;
	}
}
