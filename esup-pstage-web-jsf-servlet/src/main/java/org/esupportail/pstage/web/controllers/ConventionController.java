/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.esupportail.commons.annotations.cache.SessionCache;
import org.esupportail.pstage.domain.beans.AdministrationApogee;
import org.esupportail.pstage.domain.beans.ApogeeMap;
import org.esupportail.pstage.domain.beans.ElementPedagogique;
import org.esupportail.pstage.domain.beans.EtabRef;
import org.esupportail.pstage.domain.beans.EtapeInscription;
import org.esupportail.pstage.domain.beans.EtudiantRef;
import org.esupportail.pstage.domain.beans.JoursHebdo;
import org.esupportail.pstage.domain.beans.SignataireRef;
import org.esupportail.pstage.exceptions.CommunicationApogeeException;
import org.esupportail.pstage.exceptions.ExportException;
import org.esupportail.pstage.services.export.CastorService;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstage.web.beans.SequenceEtapeEnum;
import org.esupportail.pstage.web.beans.SequenceEtapeEnumSel;
import org.esupportail.pstage.web.comparator.ComparatorSelectItem;
import org.esupportail.pstage.web.paginators.RechercheConventionPaginator;
import org.esupportail.pstage.web.servlet.ExportConventionsServlet;
import org.esupportail.pstage.web.utils.PDFUtils;
import org.esupportail.pstagedata.domain.dto.AffectationDTO;
import org.esupportail.pstagedata.domain.dto.AssuranceDTO;
import org.esupportail.pstagedata.domain.dto.AvenantDTO;
import org.esupportail.pstagedata.domain.dto.CaisseRegimeDTO;
import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.ConventionDTO;
import org.esupportail.pstagedata.domain.dto.CritereGestionDTO;
import org.esupportail.pstagedata.domain.dto.CritereRechercheConventionDTO;
import org.esupportail.pstagedata.domain.dto.CritereRechercheOffreDTO;
import org.esupportail.pstagedata.domain.dto.DroitAdministrationDTO;
import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.esupportail.pstagedata.domain.dto.EtapeDTO;
import org.esupportail.pstagedata.domain.dto.EtudiantDTO;
import org.esupportail.pstagedata.domain.dto.FicheEvaluationDTO;
import org.esupportail.pstagedata.domain.dto.IndemnisationDTO;
import org.esupportail.pstagedata.domain.dto.LangueConventionDTO;
import org.esupportail.pstagedata.domain.dto.ModeValidationStageDTO;
import org.esupportail.pstagedata.domain.dto.ModeVersGratificationDTO;
import org.esupportail.pstagedata.domain.dto.NatureTravailDTO;
import org.esupportail.pstagedata.domain.dto.OffreDTO;
import org.esupportail.pstagedata.domain.dto.OrigineStageDTO;
import org.esupportail.pstagedata.domain.dto.PaysDTO;
import org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.QuestionSupplementaireDTO;
import org.esupportail.pstagedata.domain.dto.ReponseEvaluationDTO;
import org.esupportail.pstagedata.domain.dto.ReponseSupplementaireDTO;
import org.esupportail.pstagedata.domain.dto.ServiceDTO;
import org.esupportail.pstagedata.domain.dto.StatutJuridiqueDTO;
import org.esupportail.pstagedata.domain.dto.StructureDTO;
import org.esupportail.pstagedata.domain.dto.TempsTravailDTO;
import org.esupportail.pstagedata.domain.dto.ThemeDTO;
import org.esupportail.pstagedata.domain.dto.TypeConventionDTO;
import org.esupportail.pstagedata.domain.dto.TypeStructureDTO;
import org.esupportail.pstagedata.domain.dto.UfrDTO;
import org.esupportail.pstagedata.domain.dto.UniteDureeDTO;
import org.esupportail.pstagedata.domain.dto.UniteGratificationDTO;
import org.esupportail.pstagedata.exceptions.AffectationAlreadyExistingForCodeException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.EtapeAlreadyExistingForCodeException;
import org.esupportail.pstagedata.exceptions.UfrAlreadyExistingForCodeException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.springframework.util.StringUtils;

/**
 * A visual bean for the welcome page.
 */
/**
 * @author Garot
 *
 */
public class ConventionController extends AbstractContextAwareController {

	/* ***************************************************************
	 * Proprietes
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
	 * convention.
	 */
	private ConventionDTO convention;
	/**
	 * rechIdentEtudiant.
	 */
	private String rechIdentEtudiant;
	/**
	 * rechNomEtudiant.
	 */
	private String rechNomEtudiant;
	/**
	 * rechPrenomEtudiant.
	 */
	private String rechPrenomEtudiant;
	/**
	 * listeResultatsRechercheEtudiant.
	 */
	private List<EtudiantRef> listeResultatsRechercheEtudiant = null;
	/**
	 * resultat recherche etudiant.
	 */
	private EtudiantRef resultatEtudiantRef;
	/**
	 *  etudiant.
	 */
	private EtudiantRef etudiantRef;
	/**
	 * listeEtapesEtudiant.
	 */
	private List<SelectItem> listeEtapesEtudiant;
	/**
	 * listeUfrsEtudiant.
	 */
	private List<SelectItem> listeUfrsEtudiant;
	/**
	 * Ufr selectionnee .
	 */
	private Object selectedUfr;

	/**
	 * EtapeEtude selectionnee .
	 */
	private String selectedCodeEtape;

	/**
	 * Elp selectionne .
	 */
	private String selectedCodeElp = "";

	/**
	 * choixEtape.
	 */
	private boolean choixEtape = false;
	/**
	 * listeELPEtapes.
	 */
	private List<ElementPedagogique> listeELPEtapes; 
	/**
	 * assurance selectionnee.
	 */
	private AssuranceDTO selAssurance;
	/**
	 * CaisseRegime selectionnee.
	 */
	private CaisseRegimeDTO selCaisseRegime;
	/**
	 * TypeConvention selectionne.
	 */
	private TypeConventionDTO selTypeConvention;
	/**
	 * Theme selectionne.
	 */
	private ThemeDTO selTheme;
	/**
	 * 
	 */
	private boolean ctrlInfosEtuOK = false;
	/**
	 * ctrl des infos Stage.
	 */
	private boolean ctrlInfosStageOK = false;
	/**
	 * Date pattern.
	 */
	private static String datePattern = Utils.DATE_PATTERN;
	/**
	 * unite selectionne.
	 */
	private UniteDureeDTO selUniteDureeExceptionnelle;
	/**
	 * temps de travail choisi.
	 */
	private TempsTravailDTO selTempsTravail;
	/**
	 * indemnisation choisi.
	 */
	private IndemnisationDTO selIndemnisation;
	/**
	 * UniteGratification choisi.
	 */
	private UniteGratificationDTO selUniteGratification;
	/**
	 * UniteGratification choisi.
	 */
	private UniteDureeDTO selUniteDureeGratification;
	/**
	 * ModeVersGratification selectionne.
	 */
	private ModeVersGratificationDTO selModeVersGratification;
	/**
	 * NatureTravail selectionne.
	 */
	private NatureTravailDTO selNatureTravail;
	/**
	 * ModeValidationStage selectionne.
	 */
	private ModeValidationStageDTO selModeValidationStage;
	/**
	 * OrigineStageDTO selectionne.
	 */
	private OrigineStageDTO selOrigineStage;

	/**
	 * rechNomEnseignant.
	 */
	private String rechNomEnseignant;
	/**
	 * rechPrenomEnseignant.
	 */
	private String rechPrenomEnseignant;

	/**
	 * CodeAffectationEnseignant.
	 */
	private String selCodeAffectationEnseignant;

	/**
	 * listeAffectation.
	 */
	private List<SelectItem> listeAffectation;

	/**
	 * listeResultatsRechercheEnseignant.
	 */
	private List<EnseignantDTO> listeResultatsRechercheEnseignant = null;

	/**
	 * liste des Enseignants.
	 */
	private List<EnseignantDTO> listeEnseignant;
	/**
	 * resultat de recherche enseigant.
	 */
	private EnseignantDTO resultatEnseignant;

	/**
	 * EtablissementController.
	 */
	private EtablissementController etablissementController;

	/**
	 * The CentreController.
	 */
	private CentreController centreController;

	/**
	 * booltemConfSujetTeme.
	 */
	private boolean booltemConfSujetTeme;
	/**
	 * Id du contact selectionne - convention Signataire.
	 */
	private int idSignataireSel;
	/**
	 * Contact selectionne - convention signatraire.
	 */
	private ContactDTO signataireSel;
	/**
	 * LangueConvention selectionnee.
	 */
	private LangueConventionDTO selLangueConvention;
	/**
	 * Service to generate Xml.
	 */
	private CastorService castorService;
	/**
	 * nomEdition.
	 */
	private String nomEdition;

	/**
	 * annee universitaire au titre de laquelle sera effectuee la convention
	 */
	private String selectedAnneeUniv;

	//Recherche
	/**
	 * critereRechercheConvention.
	 */
	//	private CritereRechercheConventionDTO critereRechercheConvention = new CritereRechercheConventionDTO();
	private CritereRechercheConventionDTO critereRechercheConvention = initCritereRechercheConvention();

	/**
	 * Liste des types structure et statuts pour la recherche.
	 */
	private List<SelectItem> rechTypesStatutsStructure;
	/**
	 * Type ou statut structure selectionne pour la recherche.
	 */
	private String rechTypeOuStatut;
	/**
	 * 1 = Oui.
	 * 2 = Non
	 * null = Les 2
	 */
	private String estValidee = null;
	/**
	 * 1 = Oui.
	 * 2 = Non
	 * null = Les 2
	 */
	private String estVerifiee = null;
	/**
	 * Liste des etapes dispo pour la recherche.
	 */
	private List<SelectItem> rechEtapes = null;
	/**
	 * Liste des ufrs dispo pour la recherche.
	 */
	private List<SelectItem> rechUfrs = null;
	/**
	 * Resultats de la recherche convention.
	 */
	private List<ConventionDTO> resultatsRechercheConvention;
	/**
	 * Vrai si recherche avancée, faux si recherche simple.
	 */
	private boolean rechercheAvancee = false;
	/**
	 * RechercheConventionPaginator.
	 */
	private RechercheConventionPaginator rechercheConventionPaginator;
	/**
	 * Saisie partielle de l'intitule d'une offre pour en recuperer l'id pour la convention.
	 */
	private String intituleOffreConvention = "";
	/**
	 * sequence des Etapes en creation.
	 */
	private SequenceEtapeEnum sequenceEtapeEnum;
	/**
	 * startYearDay.
	 */
	private String startYearDay;
	/**
	 * startYearMonth.
	 */
	private String startYearMonth;
	/**
	 * convention selectionnee.
	 */
	private ConventionDTO currentConvention;
	/**
	 * sequence des Etapes en consultation, modif.
	 */
	private SequenceEtapeEnumSel sequenceEtapeEnumSel;
	/**
	 * numOffreConvention.
	 */
	private String numOffreConvention;
	/**
	 * RechercheController.
	 */
	private RechercheController rechercheController;
	/**
	 * retourAction Offre - Recherche etab.
	 */
	private String retourAction;

	/**
	 * The ExportController.
	 */
	private ExportController exportController;

	/**
	 * conventionCree.
	 */
	private boolean conventionCree = false;

	/**
	 * edition convention en fr.
	 */
	private boolean editConvFR = false;

	/**
	 * liste AnneeUniversitaire convention. 
	 */
	private List<SelectItem> listeAnneeUnivConvention;

	/**
	 * Annee universitaire selectionnee.
	 */
	private Object selAnneeUniversitaire;

	/**
	 * Onglet courant dans la validation en masse
	 */
	private int ongletCourant = 1;

	/**
	 * Liste selectItem des elements pedagogiques
	 */
	private List<SelectItem> listeELPEtapesSelectItems;

	/**
	 * Affichage ou non de l'alerte de surcharge du tuteur
	 */
	private boolean surchargeTuteur;

	/**
	 * 1 = Oui.
	 * 2 = Non
	 * null = Les 2
	 */
	private boolean estEtrangere = false;

	/**
	 * Blocage dès la premiere etape de creation de convention lorsque toutes les etapes sont orphelines
	 */
	private boolean blocageCreationEtpOrpheline = false;

	/**
	 * Liste des conventions selectionnees pour la validation en masse
	 */
	private List<ConventionDTO> listeConventionsSelectionnees=new ArrayList<ConventionDTO>();

	/* ***************************************************************
	 * Ajouts 2.2.1 Fiche Evaluation
	 ****************************************************************/
	/**
	 * Listes contenant les questions supplementaires pour chaque fiche d'evaluation
	 */
	private List<QuestionSupplementaireDTO> questionsSupplementairesEtudiant1;
	private List<QuestionSupplementaireDTO> questionsSupplementairesEtudiant2;
	private List<QuestionSupplementaireDTO> questionsSupplementairesEtudiant3;
	private List<QuestionSupplementaireDTO> questionsSupplementairesEnseignant1;
	private List<QuestionSupplementaireDTO> questionsSupplementairesEnseignant2;
	private List<QuestionSupplementaireDTO> questionsSupplementairesEntreprise1;
	private List<QuestionSupplementaireDTO> questionsSupplementairesEntreprise2;
	private List<QuestionSupplementaireDTO> questionsSupplementairesEntreprise3;

	/**
	 * Listes contenant les reponses supplementaires a add/update
	 */
	private List<ReponseSupplementaireDTO> reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

	/**
	 * return String
	 */
	private String togglePanelActiveItem;

	/**
	 * return true si la personne connectee est tuteur de la convention en cours de consultation
	 */
	@SuppressWarnings("unused")
	private boolean tuteurCurrentConvention;

	/**
	 * code permettant au tuteur pro d'acceder a sa fiche depuis le lien envoye en mail
	 */
	private String codeAccesFiche;

	/**
	 * id du centre de gestion choisi pour la recherche de fiche d'evaluation
	 */
	private Integer rechEvalIdCentre;

	/**
	 * liste des centres gestion dans lesquels le gestionnaire connecte a les droits d'evaluation
	 */
	private List<SelectItem> listeItemsCurrentCentresGestionEval;
	/**
	 * Liste des criteres presentees au gestionnaires lors de la recherche de fiche d'evaluation (ufr ou etape, en fait...)
	 */
	private List<SelectItem> rechEvalListeEtapes;

	/**
	 * true lorsque l'on consulte une convention via la recherche d'evaluation
	 */
	private boolean retourEvaluation = false;

	/**
	 * Bean constructor.
	 */
	public ConventionController() {
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

		selectedCodeEtape = null;
		selectedCodeElp = null;
		selAssurance = null;
		selCaisseRegime = null;
		ctrlInfosEtuOK = false;
		ctrlInfosStageOK = false;
		sequenceEtapeEnum = null;
		selTypeConvention = null;
		selTheme = null;
		selUniteDureeExceptionnelle = null;
		selTempsTravail = null;
		selIndemnisation = null;
		selUniteGratification = null;
		selUniteDureeGratification = null;
		selModeVersGratification = null;
		selNatureTravail = null;
		selModeValidationStage = null;
		selOrigineStage = null;
		selLangueConvention = null;
		signataireSel = null;
		this.conventionCree = false;
		selAnneeUniversitaire = null;
		//		getSessionController().setCreationConventionCurrentPage("creerConventionConsignes");

		enter();
	}
	/**
	 * @return true if the current user is allowed to view the page.
	 */
	public boolean isPageAuthorized() {
		return true;
	}

	/**
	 * JSF callback.
	 * @return a String.
	 */
	public String enter() {
		if (!isPageAuthorized()) {
			addUnauthorizedActionMessage();
			return null;
		}
		return "navigationWelcome";
	}

	/**
	 * @return A String
	 */
	public String goToCreerConventionConsignes() {
		reset();
		this.convention = new ConventionDTO();
		this.convention.setEtudiant(new EtudiantDTO());
		this.convention.setCentreGestion(new CentreGestionDTO());
		this.convention.setStructure(new StructureDTO());
		this.convention.setService(new ServiceDTO());
		this.convention.setContact(new ContactDTO());
		this.convention.setSignataire(new ContactDTO());
		this.convention.setEnseignant(new EnseignantDTO());
		sequenceEtapeEnum = null;

		return "creerConvention";
	}

	/**
	 * @return A String
	 */
	public String goToCreerConvention() {
		reset();
		String retour = "creerConvention";
		this.convention = new ConventionDTO();
		this.convention.setEtudiant(new EtudiantDTO());
		this.convention.setCentreGestion(new CentreGestionDTO());
		this.convention.setStructure(new StructureDTO());
		this.convention.setService(new ServiceDTO());
		this.convention.setContact(new ContactDTO());
		this.convention.setSignataire(new ContactDTO());
		this.convention.setEnseignant(new EnseignantDTO());
		sequenceEtapeEnum = null;

		if (getSessionController().getCurrentStageCasUser() != null) {
			if (logger.isInfoEnabled()) {
				logger.info("goToCreerConvention : user connecte : " 
						+ getSessionController().getCurrentStageCasUser().getId());
			}
		}
		if (this.getSessionController().getCurrentAuthEtudiant() != null) {
			retour = "creerConventionEtu";
		}
		this.numOffreConvention = null;

		return retour;
	}

	public void goToCreerConventionEtape2(){
		if (this.numOffreConvention != null && !this.numOffreConvention.isEmpty()){
			this.goToCreerConventionEtape2Etab();
		} else {
			getSessionController().setCreationConventionEtape1CurrentPage("_creerConventionEtape1DemandeLienOffre");	
		}
	}

	/**
	 * @return A String
	 */
	public String goToCreerConventionEtu() {
		if (this.getSessionController().getCurrentAuthEtudiant() != null) {
			rechercheInfosEtudiant(this.getSessionController().getCurrentAuthEtudiant().getIdentEtudiant());
		}
		getSessionController().setCreationConventionEtape1CurrentPage("_creerConventionEtape1ChoixEtapeEtudiant");

		//TODO
		if (this.numOffreConvention != null && !this.numOffreConvention.isEmpty()){
			// Ajout pour l'interaction Pstage/plateforme IP
			this.rechercheNumOffre(); // recuperation des infos de l'offre et transfert dans celles de la convention
			return "formulaireCompletion";
		}

		return "creerConventionEtape1Etudiant";
	}

	/**
	 * @return A String
	 */
	public String goToCreerConventionRechEtu() {
		reset();
		this.convention = new ConventionDTO();
		this.convention.setEtudiant(new EtudiantDTO());
		this.convention.setCentreGestion(new CentreGestionDTO());
		this.convention.setStructure(new StructureDTO());
		this.convention.setService(new ServiceDTO());
		this.convention.setContact(new ContactDTO());
		this.convention.setSignataire(new ContactDTO());
		this.convention.setEnseignant(new EnseignantDTO());
		sequenceEtapeEnum = null;

		this.rechIdentEtudiant = "";
		this.rechNomEtudiant = "";
		this.rechPrenomEtudiant = "";

		getSessionController().setCreationConventionEtape1CurrentPage("_creerConventionEtape1RechercheEtudiant");

		//TODO
		if (this.numOffreConvention != null && !this.numOffreConvention.isEmpty()){
			// Ajout pour l'interaction Pstage/plateforme IP
			this.rechercheNumOffre(); // recuperation des infos de l'offre et transfert dans celles de la convention
			etablissementController.setFormStructure(new StructureDTO());
			etablissementController.setFormServiceTmpPays(getBeanUtils().getFrance());
			// + assignations d'objets a partir d'ids si besoin ?
			return "formulaireCompletion";
		}

		return "creerConventionEtape1Etudiant";
	}

	/**
	 * Etape intermediaire suite au formulaire de completion pour appli d'offres Tierce
	 */
	public String goToCreerConventionRechEtuFromFormCompletion(){

		// recuperation des objets insérés pour les updater
		OffreDTO offreTmp = getOffreDomainService().getOffreFromId(Utils.convertStringToInt(this.numOffreConvention));
		ContactDTO contactTmp = getStructureDomainService().getContactFromId(offreTmp.getIdContactCand());
		ServiceDTO serviceTmp = getStructureDomainService().getServiceFromId(contactTmp.getIdService());
		StructureDTO structureTmp = getStructureDomainService().getStructureFromId(offreTmp.getIdStructure());

		// update de la structure avec les infos saisies dans le formulaire
		structureTmp.setIdPays(etablissementController.getFormServiceTmpPays().getId());
		structureTmp.setIdEffectif(etablissementController.getFormStructure().getEffectif().getId());
		structureTmp.setTypeStructure(etablissementController.getFormStructureTmpTypeStructure());
		this.getStructureDomainService().updateStructure(structureTmp);

		// update du service avec l'idPays de sa structure
		serviceTmp.setIdPays(structureTmp.getIdPays());
		this.getStructureDomainService().updateService(serviceTmp);

		// update du contact avec l'idCg récupérée
		contactTmp.setIdCentreGestion(getCentreGestionDomainService().getCentreEntreprise().getIdCentreGestion());
		this.getStructureDomainService().updateContact(contactTmp);

		// update de l'offre avec l'année univ'
		offreTmp.setAnneeUniversitaire(getBeanUtils().getAnneeUniversitaireCourante(new Date()));
		this.getOffreDomainService().updateOffre(offreTmp);


		return "creerConventionEtape1Etudiant";
	}

	/**
	 * 
	 */
	public void goToChoixEtapeEtudiant() {
		this.ctrlInfosEtuOK = false;
		this.ctrlInfosStageOK = false;
		this.selectedCodeElp = null;
		this.selectedCodeEtape = null;
		this.selectedUfr = null;
		this.listeELPEtapes = new ArrayList<ElementPedagogique>();
		this.selCaisseRegime = null;
		this.selAssurance = null;
		this.etudiantRef = new EtudiantRef();
		this.selectedAnneeUniv = "";
		this.choixEtape = false;
		this.blocageCreationEtpOrpheline = false;

		if (logger.isDebugEnabled()) {
			logger.debug("goToChoixEtapeEtudiant()");
		}
		sequenceEtapeEnum = SequenceEtapeEnum.etape1;

		this.setEtudiantRef(this.resultatEtudiantRef);

		this.checkConventionExistante();

		getSessionController().setCreationConventionEtape1CurrentPage("_creerConventionEtape1ChoixEtapeEtudiant");

	}

	/**
	 * Charge les etapes, elp, etc.. de l'etudiant une fois l'annee scolaire choisie
	 */
	public void loadInfosEtu(){
		this.choixEtape = false;
		if (this.selectedAnneeUniv != null && ! this.selectedAnneeUniv.isEmpty()){
			ApogeeMap apogeeMap = getStudentDataRepositoryDomain().getEtapesByEtudiantAndAnnee(this.etudiantRef.getNumEtudiant(),this.selectedAnneeUniv);

			// recuperation de la liste des composantes
			this.etudiantRef.setStudys(apogeeMap.getStudentStudys());
			// recuperation de la liste des etapes
			this.etudiantRef.setSteps(apogeeMap.getStudentSteps());
			// recuperation Map des elements pedagogiques
			this.etudiantRef.setElementPedagogiques(apogeeMap.getElementPedagogiques());
			// recuperation liste des ElPs
			this.etudiantRef.setListeELPs(apogeeMap.getListeELPs());
			// recuperation liste des etapes inscriptions
			this.etudiantRef.setListeEtapeInscriptions(apogeeMap.getListeEtapeInscriptions());

			if (!getSessionController().isAutoriserConventionsOrphelines()){
				this.retirerEtapesOrphelines();
			}

			// Cas ou l'on n'a qu'une seule composante
			if (this.etudiantRef.getStudys().size() == 1) {
				String clef = null;
				String valeur = null;
				Iterator<String> i = this.etudiantRef.getStudys().keySet().iterator();
				while (i.hasNext())	{
					clef = i.next();
					valeur = this.etudiantRef.getStudys().get(clef);
					this.etudiantRef.setThecodeUFR(clef);
					if (!StringUtils.hasText(valeur)) {
						AffectationDTO affecEtudiant = rechAffec(clef);
						if (affecEtudiant != null) {
							this.etudiantRef.setTheUfr(affecEtudiant.getLibelle());
						}
					} else {
						this.etudiantRef.setTheUfr(valeur);
					}

				}
			}
			if (this.etudiantRef.getListeEtapeInscriptions() != null && !this.etudiantRef.getListeEtapeInscriptions().isEmpty()) {
				// Cas ou l'on n'a qu'une seule etape
				if (this.etudiantRef.getListeEtapeInscriptions().size() == 1) {
					//String valeur = null;
					for (EtapeInscription etp : this.etudiantRef.getListeEtapeInscriptions()){
						this.etudiantRef.setTheCodeEtape(etp.getCodeEtp());
						this.etudiantRef.setTheCodeVersionEtape(etp.getCodVrsVet());
						this.etudiantRef.setTheEtape(etp.getLibWebVet());
						// recherche des elements pedagogiques
						this.listeELPEtapes = rechElpEtape(etp.getCodeEtp());
						if (this.listeELPEtapes != null) {
							if (this.listeELPEtapes.size() == 1) {
								this.etudiantRef.setTheCodeElp(this.listeELPEtapes.get(0).getCodElp());
								this.etudiantRef.setTheLibElp(this.listeELPEtapes.get(0).getLibElp());
								this.etudiantRef.setTheCreditECTS(this.listeELPEtapes.get(0).getNbrCrdElp());
								this.selectedCodeElp = this.listeELPEtapes.get(0).getCodElp();
							}
						}
					}
				} else {
					// Remplissage de la liste des select items
					this.listeEtapesEtudiant = new ArrayList<SelectItem>();
					for (EtapeInscription etp : this.etudiantRef.getListeEtapeInscriptions()){
						this.listeEtapesEtudiant.add(new SelectItem(etp.getCodeEtp()+";"+etp.getCodVrsVet(), etp.getLibWebVet()));
					}
				}
			}
		} else {
			addErrorMessage("formConvention:choixAnneeUniv", "FORM.CHAMP_OBLIGATOIRE");
		}
	}

	/**
	 * 
	 */
	public void goToCreerConventionCtrlInfosEtu() {
		boolean ctrlInfosOK = true;
		this.ctrlInfosEtuOK = false;
		this.ctrlInfosStageOK = false;
		//		String retour = null;

		// ctrl blocage si toutes les etapes sont orphelines
		if (blocageCreationEtpOrpheline){
			ctrlInfosOK = false;
		}

		// ctrl assurance maladie obligatoire
		if (selAssurance == null) {
			addErrorMessage("formConvention:affilss", "CONVENTION.CREERCONVENTION.AFFILSS.OBLIGATOIRE");
			ctrlInfosOK = false;
		}
		// ctrl assurance maladie obligatoire, sauf pour les etudiants etrangers
		if (selCaisseRegime == null) {
			if (selAssurance != null) {
				if (!selAssurance.getCodeCtrl().equals(DonneesStatic.ASS_CODE_CTRL_ETRANGER)) {
					addErrorMessage("formConvention:caisses", "CONVENTION.CREERCONVENTION.CAISSEREGIME.OBLIGATOIRE");
					ctrlInfosOK = false;
				}
			}
		}
		if (isEtudiantSupUneEtape()) {
			if (selectedCodeEtape == null || this.selectedCodeEtape.isEmpty()) {
				addErrorMessage("formConvention:choixEtape", "CONVENTION.CREERCONVENTION.ETAPE.OBLIGATOIRE");
				ctrlInfosOK = false;
			}

			if (isEtudiantSupUnElp()) {
				if (selectedCodeElp == null || this.selectedCodeElp.isEmpty()) {
					addErrorMessage("formConvention:choixElp2", "CONVENTION.CREERCONVENTION.ELP.OBLIGATOIRE");
					ctrlInfosOK = false;
				}
			}
		} else {
			if (isEtudiantSupUnElp()) {
				if (selectedCodeElp == null || this.selectedCodeElp.isEmpty()) {
					addErrorMessage("formConvention:choixElp1", "CONVENTION.CREERCONVENTION.ELP.OBLIGATOIRE");
					ctrlInfosOK = false;
				}
			}
		}

		if (!StringUtils.hasText(etudiantRef.getPostalCode())) {
			if (StringUtils.hasText(etudiantRef.getCountry())) {
				if (etudiantRef.getCountry().equalsIgnoreCase(DonneesStatic.PAYS_FR)) {
					addErrorMessage("formConvention:codePostal", "CONVENTION.CREERCONVENTION.CODEPOSTAL.OBLIGATOIRE");
					ctrlInfosOK = false;
				}
			}
		}
		if (ctrlInfosOK) {
			// recuperation du centre gérant l'etape/ufr selectionnée
			CentreGestionDTO centreGestionRattachement = new CentreGestionDTO();
			String codeEtapeTmp;
			if (getSessionController().getCritereGestion() != null) {
				// centre gestion UFR
				if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_UFR)) {
					centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(this.etudiantRef.getThecodeUFR(), getSessionController().getCodeUniversite());
				}
				// centre gestion Etape
				if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_ETAPE)) {
					if (this.etudiantRef.getTheCodeVersionEtape() != null && !this.etudiantRef.getTheCodeVersionEtape().isEmpty()){
						codeEtapeTmp = this.etudiantRef.getTheCodeEtape()+";"+this.etudiantRef.getTheCodeVersionEtape();
					} else {
						codeEtapeTmp = this.etudiantRef.getTheCodeEtape();
					}
					centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(codeEtapeTmp, getSessionController().getCodeUniversite());
				}
				// centre gestion Mixte
				if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_MIXTE)) {
					if (this.etudiantRef.getTheCodeVersionEtape() != null && !this.etudiantRef.getTheCodeVersionEtape().isEmpty()){
						codeEtapeTmp = this.etudiantRef.getTheCodeEtape()+";"+this.etudiantRef.getTheCodeVersionEtape();
					} else {
						codeEtapeTmp = this.etudiantRef.getTheCodeEtape();
					}
					// recherche cg gérant l'etape
					centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(codeEtapeTmp, getSessionController().getCodeUniversite());
					// si non trouvé, recherche centre gérant l'Ufr
					if (centreGestionRattachement == null) {
						centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(this.etudiantRef.getThecodeUFR(), getSessionController().getCodeUniversite());
					}
				}
			}
			// recherche centre etablissement, si centre ou critere vide
			if (centreGestionRattachement == null || getSessionController().getCritereGestion() == null || getSessionController().getCritereGestion().equals("")) {
				centreGestionRattachement = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite());
			}

			if (centreGestionRattachement != null) {
				getSessionController().setCentreGestionRattachement(centreGestionRattachement);
				this.convention.setIdCentreGestion(centreGestionRattachement.getIdCentreGestion());
				this.convention.setCentreGestion(centreGestionRattachement);

				if (!getSessionController().isSuperAdminPageAuthorized()){
					if (this.getSessionController().getCurrentAuthEtudiant() != null){
						// Si la personne connectée est un étudiant, on vérifie que le centre de gestion leur autorise la création de convention
						if (!centreGestionRattachement.isAutorisationEtudiantCreationConvention()){
							if (this.isEtudiantSupUneEtape()){
								addErrorMessage("formConvention:choixEtape", "CONVENTION.CREERCONVENTION.ETUDIANT_UNAUTHORIZED");
							} else {
								addErrorMessage("formConvention:etape", "CONVENTION.CREERCONVENTION.ETUDIANT_UNAUTHORIZED");
							}
							logger.info("CONVENTION.CREERCONVENTION.ETUDIANT_UNAUTHORIZED");
							return ;
						}
					} else {
						// Sinon, on verifie que le personnel connecté a bien les droits requis sur le centre gérant l'étape séléctionnée

						boolean creationAutorisee = false;
						if (getSessionController().getCurrentIdsCentresGestion() != null 
								&& getSessionController().getCurrentIdsCentresGestion().contains(centreGestionRattachement.getIdCentreGestion())){
							// On recupere les droits grace à la droitsAccesMap
							DroitAdministrationDTO droits = getSessionController().getDroitsAccesMap().get(centreGestionRattachement.getIdCentreGestion());
							if (droits != null && (droits.getLibelle().equalsIgnoreCase(DonneesStatic.LIBELLE_DROIT_ECRITURE)
									|| droits.getLibelle().equalsIgnoreCase(DonneesStatic.LIBELLE_DROIT_ADMIN))){
								// Si le personnel a bien les droits Ecriture ou Admin sur le centre, on autorise la création
								creationAutorisee = true;
							}
						}
						if (!creationAutorisee){
							if (this.isEtudiantSupUneEtape()){
								addErrorMessage("formConvention:choixEtape", "CONVENTION.CREERCONVENTION.UNAUTHORIZED");
							} else {
								addErrorMessage("formConvention:etape", "CONVENTION.CREERCONVENTION.UNAUTHORIZED");
							}
							logger.info("CONVENTION.CREERCONVENTION.UNAUTHORIZED");
							return ;
						}
					}
				}
			}
			if (selAssurance != null) {
				this.etudiantRef.setTheAssurance(selAssurance);
			}
			if (selCaisseRegime != null) {
				this.etudiantRef.setTheCaisseRegime(selCaisseRegime);
			}

			this.ctrlInfosEtuOK = true;
			//			retour = "_creerConventionEtape1Etudiant";
			getSessionController().setCreationConventionEtape1CurrentPage("_creerConventionEtape1ConfirmInfosEtu");
		}
		//		return retour;
	}

	public String retourConfirmInfosEtu(){
		getSessionController().setCreationConventionEtape1CurrentPage("_creerConventionEtape1ConfirmInfosEtu");
		return "creerConventionEtape1Etudiant";
	}

	/**
	 * @return String
	 */
	public String modifierEtudiantDetail() {
		String retour = null;
		boolean ctrlInfosOK = true;
		// ctrl donnees stage
		String nomForm = "formSelConvention";
		// ctrl assurance maladie obligatoire
		if (selAssurance == null) {
			addErrorMessage(nomForm + ":affilss", "CONVENTION.CREERCONVENTION.AFFILSS.OBLIGATOIRE");
			ctrlInfosOK = false;
		}

		// ctrl assurance maladie obligatoire
		if (selCaisseRegime == null) {
			if (selAssurance != null) {
				if (!selAssurance.getCodeCtrl().equals(DonneesStatic.ASS_CODE_CTRL_ETRANGER)) {
					addErrorMessage(nomForm + ":caisses", "CONVENTION.CREERCONVENTION.CAISSEREGIME.OBLIGATOIRE");
					ctrlInfosOK = false;
				}

			}
		}
		if (!StringUtils.hasText(this.convention.getCodePostalEtudiant())) {
			if (StringUtils.hasText(this.convention.getPaysEtudiant())) {
				if (this.convention.getPaysEtudiant().equalsIgnoreCase(DonneesStatic.PAYS_FR)) {
					addErrorMessage(nomForm + ":codePostal", "CONVENTION.CREERCONVENTION.CODEPOSTAL.OBLIGATOIRE");
					ctrlInfosOK = false;
				}
			}
		}
		if (ctrlInfosOK) {
			// renseignements des zones de selection
			if (selAssurance != null) {
				this.convention.setAssurance(selAssurance);
				this.convention.setIdAssurance(selAssurance.getId());

			}
			if (selCaisseRegime != null) {
				this.convention.setCaisseRegime(selCaisseRegime);
				this.convention.setCodeCaisse(selCaisseRegime.getCode());
			}
			EtudiantDTO etudiantTmp = this.convention.getEtudiant();
			etudiantTmp.setLoginModif(getSessionController().getCurrentLogin());
			try {
				if (this.getEtudiantDomainService().updateEtudiant(etudiantTmp)) {
					addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
				} 
			} catch (DataUpdateException ae) {
				logger.error("DataUpdateException", ae.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ETU.ERREUR");
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ETU.ERREUR", we.getMessage());
			}

			ConventionDTO conventionTmp = this.convention;
			conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
			try {
				if (this.getConventionDomainService().updateConvention(conventionTmp)) {
					retour = SequenceEtapeEnumSel.etape1.actionEtape();
					addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
					this.alerteMailModifConvention(" les infos étudiant ");
				} 
			} catch (DataUpdateException ae) {
				logger.error("DataUpdateException", ae.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
			}
		}
		return retour;
	}
	/**
	 * Etape 02 : Recherche établissement.
	 * @return a String
	 */
	public String goToCreerConventionEtape2Etab() {
		ajoutInfosEtudiant();
		sequenceEtapeEnum = SequenceEtapeEnum.etape2;

		getSessionController().setCreationConventionEtape2CurrentPage("_creerConventionEtape2Etab");
		return "creerConventionEtape2Etab";
	}

	/**
	 * @return a String
	 */
	public String goToRetourAction() {
		return this.retourAction;
	}
	/**
	 * Etape 01 : Recherche Lien Offre.
	 * @return a String
	 */
	public String goToCreerConventionEtape1Offre() {
		ajoutInfosEtudiant();
		this.intituleOffreConvention="";
		this.numOffreConvention="";
		sequenceEtapeEnum = SequenceEtapeEnum.etape2;
		getSessionController().setCreationConventionEtape1CurrentPage("_creerConventionEtape1Offre");
		return "creerConventionEtape1Etudiant";
	}

	/**
	 * Etape 02 : Retour Recherche ou Offre.
	 * @return a String
	 */
	public String goToCreerConventionEtape2EtabR() {
		if (this.retourAction != null){
			if (this.retourAction.equals("_creerConventionEtape2Etab")){
				getSessionController().setCreationConventionEtape2CurrentPage(this.retourAction);
				return "creerConventionEtape2Etab";
			} else if (this.retourAction.equals("_creerConventionEtape1Offre")){
				getSessionController().setCreationConventionEtape1CurrentPage(this.retourAction);
				return "creerConventionEtape1Etudiant";
			} else {
				return this.retourAction;
			}
		}
		return null;
	}

	/**
	 * @return A String
	 */
	public String rechercheNumOffre() {

		//if (this.offreMotCle)

		boolean ctrlOK = true;
		String retour = null;
		String description = "";
		int numOffre = 0;
		if (!StringUtils.hasText(this.numOffreConvention)) {
			addErrorMessage("formConvention:idOffre", "CONVENTION.ETAPE1.RECHERCHENUMOFFRE.OBLIGATOIRE");
			ctrlOK = false;
		}
		try {
			numOffre = Integer.parseInt(this.numOffreConvention);
		} catch (NumberFormatException e) {
			addErrorMessage("formConvention:idOffre", "CONVENTION.ETAPE1.RECHERCHENUMOFFRE.NUMERIQUE");
			ctrlOK = false;
		}

		if (ctrlOK) {
			OffreDTO offre = getOffreDomainService().getOffreFromId(numOffre);
			if (offre != null) {
				if (offre.getDescription() !=null) {
					if (StringUtils.hasText(offre.getDescription())) {
						description = Utils.replaceHTML(offre.getDescription());
						this.convention.setFonctionsEtTaches(description);
					}
				}
				if (offre.isRemuneration()) {
					List<IndemnisationDTO> l = getNomenclatureDomainService().getIndemnisations();
					if(l!=null){
						for(IndemnisationDTO o : l){
							if (o.getLibelle().equalsIgnoreCase(DonneesStatic.OUI)) {
								this.selIndemnisation = o;
							}
						}
					}
				}
				if (offre.getIdStructure() > 0) {
					if (logger.isDebugEnabled()) {
						logger.debug("ConventionController:: rechercheNumOffre ");
						logger.debug("offre.getIdStructure() " + offre.getIdStructure());
					}
					StructureDTO structureTmp = getStructureDomainService().getStructureFromId(offre.getIdStructure());
					if (structureTmp != null) {
						this.rechercheController.setResultatRechercheStructure(structureTmp);

						getSessionController().setCreationConventionEtape2CurrentPage("_creerConventionEtape2DetailsEtab");
						retour = "creerConventionEtape2Etab";
					}
				}

			} else {
				addErrorMessage("formConvention:idOffre", "CONVENTION.ETAPE1.RECHERCHENUMOFFRE.AUCUNE");
			}
		}
		return retour;
	}

	/**
	 * 
	 */
	public void ajoutInfosEtudiant() {

		if (this.etudiantRef.getTheCodeEtape() != null) {
			EtapeDTO etapeTmp = new EtapeDTO(); 
			etapeTmp.setCode(this.etudiantRef.getTheCodeEtape());
			etapeTmp.setCodeVersionEtape(this.etudiantRef.getTheCodeVersionEtape());
			etapeTmp.setLibelle(this.etudiantRef.getTheEtape());
			this.convention.setEtape(etapeTmp);
			this.convention.setCodeEtape(etapeTmp.getCode());
			this.convention.setCodeVersionEtape(etapeTmp.getCodeVersionEtape());
			this.convention.setCodeUniversiteEtape(getSessionController().getCodeUniversite());
		}
		if (this.etudiantRef.getThecodeUFR() != null) {
			UfrDTO ufrTmp = new UfrDTO(); 
			ufrTmp.setCode(this.etudiantRef.getThecodeUFR());
			ufrTmp.setLibelle(this.etudiantRef.getTheUfr());
			ufrTmp.setCodeUniversite(getSessionController().getCodeUniversite());
			this.convention.setUfr(ufrTmp);
			this.convention.setCodeUFR(ufrTmp.getCode());
			this.convention.setCodeUniversiteUFR(getSessionController().getCodeUniversite());
			this.convention.setCodeDepartement(ufrTmp.getCode());
		}
		this.convention.setEtudiant(this.etudiantRef);
		this.convention.setAdresseEtudiant(this.etudiantRef.getMainAddress());
		this.convention.setCodePostalEtudiant(this.etudiantRef.getPostalCode());
		this.convention.setVilleEtudiant(this.etudiantRef.getTown());
		this.convention.setPaysEtudiant(this.etudiantRef.getCountry());
		this.convention.setCourrielPersoEtudiant(this.etudiantRef.getMailPerso());
		this.convention.setTelEtudiant(this.etudiantRef.getTel());
		this.convention.setTelPortableEtudiant(this.etudiantRef.getPortablePhone());
		if (this.etudiantRef.getTheAssurance() != null) {
			this.convention.setAssurance(this.etudiantRef.getTheAssurance());
			this.convention.setIdAssurance(this.etudiantRef.getTheAssurance().getId());
		}
		if (this.etudiantRef.getTheCaisseRegime() != null) {
			this.convention.setCaisseRegime(this.etudiantRef.getTheCaisseRegime());
			this.convention.setCodeCaisse(this.etudiantRef.getTheCaisseRegime().getCode());
		}
		if (this.etudiantRef.getTheCodeElp() != null) {
			this.convention.setCodeElp(this.etudiantRef.getTheCodeElp());
		}
		if (this.etudiantRef.getTheLibElp() != null) {
			this.convention.setLibelleELP(this.etudiantRef.getTheLibElp());
		}
		if (this.etudiantRef.getTheCreditECTS() != null) {
			this.convention.setCreditECTS(this.etudiantRef.getTheCreditECTS());
		}
		if (this.etudiantRef.getLibelleCPAM() != null) {
			this.convention.setLibelleCPAM(this.etudiantRef.getLibelleCPAM());
		}
		if (this.etudiantRef.getListeEtapeInscriptions() != null && !this.etudiantRef.getListeEtapeInscriptions().isEmpty()) {
			for (Iterator<EtapeInscription> iter = this.etudiantRef.getListeEtapeInscriptions().iterator(); iter.hasNext();) {
				EtapeInscription etpins = iter.next();
				if (this.etudiantRef.getTheCodeEtape().equals(etpins.getCodeEtp())) {
					this.convention.setCodeCursusLMD(etpins.getCodCursusLmd());
					this.convention.setCodeFinalite(etpins.getCodFinalite());
					this.convention.setLibelleFinalite(etpins.getLibFinalite());
				}
			}
		}
	}
	/**
	 * Etape 02 : Création établissement.
	 * @return a String
	 */
	public String goToCreerConventionEtape2CreaEtab() {
		this.etablissementController.goToCreationEtablissement();
		getSessionController().setCreationConventionEtape2CurrentPage("_creerConventionEtape2CreaEtab");
		return "creerConventionEtape2Etab";
	}

	/**
	 * Etape 02 : Création établissement.
	 * @return a String
	 */
	public String goToConventionEtape2CreaEtab() {
		this.etablissementController.goToCreationEtablissement();
		return "conventionEtape2CreaEtab";
	}
	/**
	 * @return String
	 */
	public String goToCreerConventionEtape2DetailsEtab() {
		//		String ret = "_creerConventionEtape2DetailsEtab";

		getSessionController().setCreationConventionEtape2CurrentPage("_creerConventionEtape2DetailsEtab");
		return "creerConventionEtape2Etab";
		//		return ret;
	}

	/**
	 * @return String
	 */
	public String goToConventionEtape2DetailsEtab() {
		String retour = "conventionEtape2ModifEtabServiceContact";
		getSessionController().setCurrentManageStructure(this.convention.getStructure());
		getSessionController().setMenuGestionEtab(false);
		this.etablissementController.loadContactsServices();
		if (this.convention.getStructure() != null) {
			this.convention.setIdStructure(this.convention.getStructure().getIdStructure());
		}
		return retour;
	}
	/**
	 * @return String
	 */
	public String goToConventionModifEtabServiceContact() {
		String retour = null;
		if (this.convention.getStructure() != null) {
			this.convention.setIdStructure(this.convention.getStructure().getIdStructure());
		}
		if (this.convention.getService() != null) {
			this.convention.setIdService(this.convention.getService().getIdService());
		}
		if (this.convention.getContact() != null) {
			this.convention.setIdContact(this.convention.getContact().getId());
		}
		//remise à zéro du signataire
		this.convention.setSignataire(new ContactDTO());
		this.convention.setIdSignataire(0);
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				this.alerteMailModifConvention(" l'établissement d'accueil ");

				//retour=sequenceEtapeEnumSel.etape2.actionEtape();
				retour = "conventionEtape2ModifEtabServiceSignataire";
				addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
			} 
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}
		return retour;
	}

	/**
	 * @return String
	 */
	public String goToConventionModifEtabServiceSignataire() {
		String retour = null;
		if (this.convention.getSignataire() != null) {
			this.convention.setIdSignataire(this.convention.getSignataire().getId());
		}
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				retour = SequenceEtapeEnumSel.etape2.actionEtape();
				addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
			}
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}

		return retour;
	}
	/**
	 * @return String
	 */
	public String goToConventionModifServiceContact() {
		String retour = null;
		if (this.convention.getService() != null) {
			this.convention.setIdService(this.convention.getService().getIdService());
		}
		if (this.convention.getContact() != null) {
			this.convention.setIdContact(this.convention.getContact().getId());
		}
		this.etablissementController.setServiceSel(this.convention.getService());
		this.etablissementController.setIdServiceSel(this.convention.getService().getIdService());
		getSessionController().setCurrentManageStructure(this.convention.getStructure());
		getSessionController().setMenuGestionEtab(false);
		//remise a zero du signataire
		this.convention.setSignataire(new ContactDTO());
		this.convention.setIdSignataire(0);
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				this.alerteMailModifConvention(" le service d'accueil ");
				retour = "conventionEtape3ModifServiceSignataire";
				addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
			} 
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}
		return retour;
	}



	/**
	 * @return String
	 */
	public String goToConventionModifContact() {
		String retour = null;
		if (this.convention.getService() != null) {
			this.convention.setIdService(this.convention.getService().getIdService());
		}
		if (this.convention.getContact() != null) {
			this.convention.setIdContact(this.convention.getContact().getId());
		}
		this.etablissementController.setServiceSel(this.convention.getService());
		this.etablissementController.setIdServiceSel(this.convention.getService().getIdService());
		getSessionController().setCurrentManageStructure(this.convention.getStructure());
		getSessionController().setMenuGestionEtab(false);
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				this.alerteMailModifConvention(" le tuteur professionnel ");
				retour = SequenceEtapeEnumSel.etape4.actionEtape();
				addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
			} 
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}
		return retour;
	}
	/**
	 * @return String
	 */
	public String goToConventionModifServiceSignataire() {
		String retour = null;
		if (this.convention.getSignataire() != null) {
			this.convention.setIdSignataire(this.convention.getSignataire().getId());
		}
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				this.alerteMailModifConvention(" le signataire ");
				retour = SequenceEtapeEnumSel.etape3.actionEtape();
				addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
			}
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}

		return retour;
	}
	/**
	 * @return String
	 */
	public String goToConventionModifSignataire() {
		String retour = null;
		if (this.convention.getSignataire() != null) {
			this.convention.setIdSignataire(this.convention.getSignataire().getId());
		}
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				this.alerteMailModifConvention(" le signataire ");
				retour = SequenceEtapeEnumSel.etape7.actionEtape();
				addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
			} 

		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}
		return retour;
	}
	/**
	 * @return String
	 */
	public String goToConventionRechEtab() {
		String ret = "conventionEtape2RechEtab";
		return ret;

	}

	/**
	 * Bouton d'ajout d'un etablissement. 
	 * @return String
	 */
	public void ajouterEtablissement() {
		String ret = null;
		ret = this.etablissementController.ajouterEtablissement();
		if (ret != null && this.etablissementController.getFormStructure() != null) {
			if (this.convention != null) {
				this.convention.setStructure(this.etablissementController.getFormStructure());
				getSessionController().setCurrentManageStructure(this.etablissementController.getFormStructure());
				getSessionController().setMenuGestionEtab(false);
				this.etablissementController.loadContactsServices();
				this.etablissementController.setFormStructure(null);
				this.convention.setIdStructure(this.convention.getStructure().getIdStructure());
				//				ret = "creerConventionEtape2Etab";
				getSessionController().setCreationConventionEtape2CurrentPage("_creerConventionEtape2DetailsEtab");
			}			
		}

		//		return ret;
	}
	/**
	 * Bouton d'ajout etablissement Modif. 
	 * @return String
	 */
	public String ajouterEtablissementModif() {
		String ret = null;
		ret = this.etablissementController.ajouterEtablissement();
		if (ret != null && this.etablissementController.getFormStructure() != null) {
			this.convention.setStructure(this.etablissementController.getFormStructure());
			getSessionController().setCurrentManageStructure(this.etablissementController.getFormStructure());
			getSessionController().setMenuGestionEtab(false);
			this.etablissementController.loadContactsServices();
			this.etablissementController.setFormStructure(null);
			this.convention.setIdStructure(this.convention.getStructure().getIdStructure());

			ConventionDTO conventionTmp = this.convention;
			conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
			try {
				if (this.getConventionDomainService().updateConvention(conventionTmp)) {
					this.alerteMailModifConvention(" l'établissement d'accueil ");
					ret = SequenceEtapeEnumSel.etape2.actionEtape();
					addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
				} 
			} catch (DataUpdateException ae) {
				logger.error("DataUpdateException", ae.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
				ret = null;		
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
				ret = null;
			}
			ret = SequenceEtapeEnumSel.etape2.actionEtape();
		}
		return ret;
	}
	/**
	 * @return String
	 */
	public void goToCreerConventionModifEtab() {
		//		String ret = null;
		//		ret = this.etablissementController.goToModificationEtablissement();
		this.etablissementController.goToModificationEtablissement();
		getSessionController().setCreationConventionEtape2CurrentPage("_creerConventionEtape2ModifEtab");
		//		ret = "_creerConventionEtape2ModifEtab";
		//		return ret;
	}
	/**
	 * @return String
	 */
	public String goToConventionModifEtab()  {
		String ret = null;
		ret = this.etablissementController.goToModificationEtablissement();
		ret = "conventionEtape2ModifEtab";
		return ret;
	}
	/**
	 * @return String
	 */
	public void modifierEtablissement() {
		String ret = null;
		ret = this.etablissementController.modifierEtablissement();
		FacesContext fc = FacesContext.getCurrentInstance();
		Iterator<FacesMessage> ifm = fc.getMessages("formModifEtab");
		while (ifm.hasNext()) {
			FacesMessage fm = ifm.next();
			fc.addMessage("formConvention:formModifEtab",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, fm.getSummary() , fm.getDetail()));
			ifm.remove();
		}
		ifm = fc.getMessages("formAffEtab");
		while (ifm.hasNext()) {
			FacesMessage fm = ifm.next();
			fc.addMessage("formConvention:formAffEtab",
					new FacesMessage(fm.getSummary() , fm.getDetail()));
			ifm.remove();
		}
		if (StringUtils.hasText(ret)) {
			//			ret = "_creerConventionEtape2DetailsEtab";
			getSessionController().setCreationConventionEtape2CurrentPage("_creerConventionEtape2DetailsEtab");
		}
		//		return ret;
	}

	/**
	 * @return String
	 */
	public String modifierEtablissementDetail() {
		String ret = null;
		ret = this.etablissementController.modifierEtablissement();
		FacesContext fc = FacesContext.getCurrentInstance();
		Iterator<FacesMessage> ifm = fc.getMessages("formModifEtab");
		while (ifm.hasNext()) {
			FacesMessage fm = ifm.next();
			fc.addMessage("formConvention:formModifEtab",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, fm.getSummary(), fm.getDetail()));
			ifm.remove();
		}
		ifm = fc.getMessages("formAffEtab");
		while (ifm.hasNext()) {
			FacesMessage fm = ifm.next();
			fc.addMessage("formConvention:formAffEtab",
					new FacesMessage(fm.getSummary(), fm.getDetail()));
			ifm.remove();
		}
		if (StringUtils.hasText(ret)) {
			ret = SequenceEtapeEnumSel.etape2.actionEtape();
		}
		return ret;
	}

	/**
	 * Etape 03 : Service.
	 * @return a String
	 */
	public String goToCreerConventionEtape3Service() {
		getSessionController().setCurrentManageStructure(this.convention.getStructure());
		getSessionController().setMenuGestionEtab(false);
		this.etablissementController.loadContactsServices();
		sequenceEtapeEnum = SequenceEtapeEnum.etape3;
		if (this.convention.getStructure() != null) {
			this.convention.setIdStructure(this.convention.getStructure().getIdStructure());
		}
		return "creerConventionEtape3Service";
	}



	/**
	 * @return  String
	 */
	public String goToConventionEtape3ServiceModif() {
		String ret = null;
		this.convention.setIdService(this.convention.getService().getIdService());
		this.etablissementController.setServiceSel(this.convention.getService());
		this.etablissementController.setIdServiceSel(this.convention.getService().getIdService());
		getSessionController().setCurrentManageStructure(this.convention.getStructure());
		getSessionController().setMenuGestionEtab(false);
		//this.etablissementController.loadContactsServices();
		this.etablissementController.reloadContacts();
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				this.alerteMailModifConvention(" le service d'accueil ");
				//ret=sequenceEtapeEnumSel.etape3.actionEtape();
				ret = "conventionEtape3ModifServiceContact";
				addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
			} 
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}

		return ret;
	}

	/**
	 * Etape 04 : Contact.
	 * @return a String
	 */
	public String goToCreerConventionEtape4Contact() {
		String retour = "creerConventionEtape4Contact";
		//this.etablissementController.loadContactsServices();
		this.etablissementController.reloadContacts();
		sequenceEtapeEnum = SequenceEtapeEnum.etape4;
		//si etudiant et cg centreGestion.saisieTuteurProParEtudiant est false
		if (this.getSessionController().getCurrentAuthEtudiant() != null) {
			if (!this.convention.getCentreGestion().getSaisieTuteurProParEtudiant()) {
				this.convention.setContact(null);
				retour = goToCreerConventionEtape5Stage();
			}
		}
		return retour;
	}

	/**
	 * 
	 */
	public void goToCreerConventionCtrlStage() { 
		boolean ctrlInfosOK = true;
		//		String retour = null;
		// ctrl donnees stage
		String nomForm = "formConvention";
		ctrlInfosOK = conventionCtrlStage(nomForm);

		if (ctrlInfosOK) {
			this.ctrlInfosStageOK = true;
			// renseignements des zones de selection
			rensInfosSelecStage();
			//			retour = "_creerConventionEtape5ConfirmInfosStage";
			getSessionController().setCreationConventionEtape5CurrentPage("_creerConventionEtape5ConfirmInfosStage");
		}
		//		return retour;
	}

	/**
	 * @param nomForm 
	 * @return boolean
	 */
	public boolean conventionCtrlStage(String nomForm){ 
		boolean ctrlInfosOK = true;
		if (this.convention.isInterruptionStage()) {
			// date debut interruption obligatoire , si interruption
			if (this.convention.getDateDebutInterruption() == null) {
				addErrorMessage(nomForm+":dateDebutInterruption", "CONVENTION.CREERCONVENTION.DATEDEBINTERRUP.OBLIGATOIRE");
				ctrlInfosOK = false;
			}
			// date fin interruption obligatoire , si interruption
			if (this.convention.getDateFinInterruption() == null) {
				addErrorMessage(nomForm+":dateFinInterruption", "CONVENTION.CREERCONVENTION.DATEFININTERRUP.OBLIGATOIRE");
				ctrlInfosOK = false;
			}
		}
		// date de fin de stage doit etre <= date de debut
		if (this.convention.getDateDebutStage() != null && this.convention.getDateFinStage() != null) {
			if (this.convention.getDateFinStage().before(this.convention.getDateDebutStage())) {
				addErrorMessage(nomForm+":dateFinStage", "CONVENTION.CREERCONVENTION.DATEFIN.FINAVANTDEBUT");
				ctrlInfosOK = false;
			} else {
				// controle pour les stage conseilles - codectrl=CONS
				if (selTypeConvention.getCodeCtrl().equals(DonneesStatic.TYPE_CONVENTION_CODE_CTRL_CONS)) {
					Calendar finMax = Calendar.getInstance();
					finMax.clear();
					finMax.setTime(this.convention.getDateDebutStage());
					finMax.add(Calendar.MONTH,6);

					if (this.convention.getDateFinStage().after(finMax.getTime())) {
						addErrorMessage(nomForm+":dateFinStage", "CONVENTION.CREERCONVENTION.DUREECONSEILLE.MAX");
						ctrlInfosOK = false;
					}
				}
			}
		}
		// pourcentage de quotite obligatoire , si travail en temps partiel - codectrl=TPART
		if (selTempsTravail != null) {
			if (selTempsTravail.getCodeCtrl().equals(DonneesStatic.TEMPS_TRAVAIL_CODE_CTRL_PARTIEL)) {
				if (this.convention.getQuotiteTravail() == null || this.convention.getQuotiteTravail() == 0) {
					addErrorMessage(nomForm+":quotiteTravail", "CONVENTION.CREERCONVENTION.QUOTITE.OBLIGATOIRE");
					ctrlInfosOK = false;
				}
			}
		}
		// unite de la duree exceptionnelle obligatoire, si saisie duree exceptionnelle 
		//		if (StringUtils.hasText(this.convention.getDureeExceptionnelle())) {
		//			if (selUniteDureeExceptionnelle ==  null) {
		//				addErrorMessage(nomForm+":uniteDureeExceptionnelle", "CONVENTION.CREERCONVENTION.UNITEDUREEEXCEPTIONNELLE.OBLIGATOIRE");
		//				ctrlInfosOK = false;
		//			}
		//		}
		// Montant de la gratification obligatoire, si indemnisation
		if (selIndemnisation != null) {
			if (selIndemnisation.getLibelle().equalsIgnoreCase(DonneesStatic.OUI)) {
				// unite du montant obligatoire, si montant 
				if (StringUtils.hasText(this.convention.getMontantGratification())) {
					if (selUniteDureeGratification == null) {
						addErrorMessage(nomForm + ":montantGratification", "CONVENTION.CREERCONVENTION.UNITEDUREEGRATIFICATION.OBLIGATOIRE");
						ctrlInfosOK = false;
					} else if (selUniteGratification == null) {
						// unite duree gratif obligatoire
						addErrorMessage(nomForm + ":montantGratification", "CONVENTION.CREERCONVENTION.UNITEGRATIFICATION.OBLIGATOIRE");
						ctrlInfosOK = false;
					}
				}
				if (selModeVersGratification == null) {
					addErrorMessage(nomForm+":modeVersGratification", "CONVENTION.CREERCONVENTION.MODEVERSGRATIFICATION.OBLIGATOIRE");
					ctrlInfosOK = false;
				}
				if (selModeVersGratification != null && selModeVersGratification.getLibelle().equals("")) {
					addErrorMessage(nomForm+":modeVersGratification", "CONVENTION.CREERCONVENTION.MODEVERSGRATIFICATION.OBLIGATOIRE");
					ctrlInfosOK = false;
				}
			} else {
				this.convention.setMontantGratification("");
				this.convention.setModeVersGratification(null);
				this.convention.setIdModeVersGratification(0);
				this.selModeVersGratification = null;
			}
		}
		return ctrlInfosOK;
	}

	/**
	 * renseignement des zones de selections.
	 */
	public void rensInfosSelecStage() {
		convention.setTypeConvention(selTypeConvention);
		convention.setIdTypeConvention(selTypeConvention.getId());
		if (selTheme != null) {
			convention.setTheme(selTheme);
			convention.setIdTheme(selTheme.getId());
		}
		convention.setTempsTravail(selTempsTravail);
		convention.setIdTempsTravail(selTempsTravail.getId());
		convention.setIndemnisation(selIndemnisation);
		convention.setIdIndemnisation(selIndemnisation.getId());
		convention.setUniteGratification(selUniteGratification);
		if (selUniteGratification != null) {
			convention.setIdUniteGratification(selUniteGratification.getId());
		}
		if (selUniteDureeGratification != null) {
			convention.setUniteDureeGratification(selUniteDureeGratification);
			convention.setIdUniteDureeGratification(selUniteDureeGratification.getId());
		}
		convention.setModeVersGratification(selModeVersGratification);
		if (selModeVersGratification != null) {
			convention.setIdModeVersGratification(selModeVersGratification.getId());
		}
		convention.setOrigineStage(selOrigineStage);
		if (selOrigineStage != null) {
			convention.setIdOrigineStage(selOrigineStage.getId());
		}
		if (selUniteDureeExceptionnelle != null) {
			convention.setUniteDuree(selUniteDureeExceptionnelle);
			convention.setIdUniteDureeExceptionnelle(selUniteDureeExceptionnelle.getId());
		}
		convention.setNatureTravail(selNatureTravail);
		convention.setIdNatureTravail(selNatureTravail.getId());
		// Passage du mode de validation par le centre de gestion
		if (this.convention.getCentreGestion().getModeValidationStage()!=null){
			this.selModeValidationStage=this.convention.getCentreGestion().getModeValidationStage();
		}
		convention.setModeValidationStage(this.selModeValidationStage);
		convention.setIdModeValidationStage(this.selModeValidationStage.getId());
		convention.setLangueConvention(selLangueConvention);
		convention.setCodeLangueConvention(selLangueConvention.getCode());
	}
	/**
	 * @return A String
	 */
	public String goToCreerConventionValidElpEtu() {
		return "creerConventionValidElpEtu";
	}

	/**
	 * @return A String
	 */
	public String goToCreerConventionConfirmInfosEtu() {
		return "creerConventionEtabAccueil";
	}
	/**
	 * @return A String
	 */
	public String goToCreerConventionModifInfosEtu() {
		return "creerConventionValidElpEtu";
	}
	/**
	 * @return A String
	 */
	public String goToCreerConventionEnregInfosEtu() {
		return "creerConventionValidInfosEtu";
	}
	/**
	 * @return A String
	 */
	public String goToCreerConventionEtape5Stage() {
		//		this.convention.setNbHeuresHebdo("35.00");
		this.convention.setQuotiteTravail(100);
		this.ctrlInfosStageOK = false;
		getSessionController().setCreationConventionEtape5CurrentPage("_creerConventionEtape5Stage");
		if (logger.isDebugEnabled()) {
			logger.debug("goToCreerConventionEtape5Stage ");
			if (this.convention.getContact() != null) {
				logger.debug("this.convention.getContact() " + this.convention.getContact().getId());
			}
			if (this.convention.getService() != null) {
				logger.debug("this.convention.getService() " + this.convention.getService().getIdService());
			}
		}
		sequenceEtapeEnum = SequenceEtapeEnum.etape5;
		if (this.convention.getContact() != null) {
			this.convention.setIdContact(this.convention.getContact().getId());
		}
		if (this.convention.getService() != null) {
			this.convention.setIdService(this.convention.getService().getIdService());
		}
		this.selLangueConvention = new LangueConventionDTO();
		this.selLangueConvention.setCode("fr");
		selAnneeUniversitaire = null;
		return "creerConventionEtape5Stage";
	}

	/**
	 * 
	 */
	public void goToCreerConventionEtape5StageR() {
		this.ctrlInfosStageOK = false;
		getSessionController().setCreationConventionEtape5CurrentPage("_creerConventionEtape5Stage");
		//		return "_creerConventionEtape5Stage";
	}


	/**
	 * @return A String
	 */
	public String goToCreerConventionEtape6RespPedago() {
		sequenceEtapeEnum = SequenceEtapeEnum.etape6;
		getSessionController().setCreationConventionEtape6CurrentPage("_creerConventionEtape6RechEnseignant");
		return "creerConventionEtape6Enseignant";
	}
	/**
	 * 
	 */
	public void goToCreerConventionEtape6Enseignant() {
		sequenceEtapeEnum = SequenceEtapeEnum.etape6;
		this.convention.setEnseignant(this.resultatEnseignant);
		checkSurchargeTuteur();
		//		return "_creerConventionEtape6Enseignant";
		getSessionController().setCreationConventionEtape6CurrentPage("_creerConventionEtape6Enseignant");
	}
	/**
	 * @return A String
	 */
	public String goToConventionEtape6ValidEnseignant() {
		this.convention.setEnseignant(this.resultatEnseignant);

		return "conventionEtape6ValidEnseignant";
	}

	/**
	 * @return A String
	 */
	public String goToConventionEtape6listeEnseignant() {
		return "conventionEtape6ListeEnseignant";
	}

	/**
	 * @return A String
	 */
	public String goToCreerConventionEtape7Signataire() {
		String retour = "creerConventionEtape7Signataire";
		sequenceEtapeEnum = SequenceEtapeEnum.etape7;
		//si etudiant et cg centreGestion.saisieTuteurProParEtudiant est false
		if (this.getSessionController().getCurrentAuthEtudiant() != null) {
			if (!this.convention.getCentreGestion().getSaisieTuteurProParEtudiant()) {
				this.convention.setSignataire(null);
				this.setSignataireSel(null);
				retour = goToCreerConventionEtape8Recap();
			}
		}
		return retour;
	}
	/**
	 * @return A String
	 */
	public String goToCreerConventionEtape8Recap() {
		sequenceEtapeEnum = SequenceEtapeEnum.etape8;
		if (logger.isDebugEnabled()) {
			logger.debug("goToCreerConventionEtape8Recap "); 
			if (this.signataireSel != null) { 
				logger.debug("this.signataireSel " + this.signataireSel.toString());
			}
		}
		if (this.signataireSel != null) {
			if (this.convention != null) {
				this.convention.setSignataire(this.signataireSel);
				this.convention.setIdSignataire(this.signataireSel.getId());
			}
		}
		return "creerConventionEtape8Recap";
	}
	/**
	 * @return String
	 */
	public String goToAjouterConvention() {
		String retour = null;
		this.conventionCree = false;
		ConventionDTO conventionTmp = this.convention;

		if (this.convention.getIdModeVersGratification() == null)
			this.convention.setIdModeVersGratification(0);

		// creation etape
		try {
			this.convention.getEtape().setCodeUniversite(getSessionController().getCodeUniversite());
			int idEtape = this.getConventionDomainService().addEtape(this.convention.getEtape());
			if (logger.isInfoEnabled()){
				logger.info("Ajout etape : " + this.convention.getEtape()+", id etape ajout : " + idEtape);
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			return retour;
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ETAPE.ERREUR", we.getMessage());
			return retour;
		} catch (EtapeAlreadyExistingForCodeException ee) {
			if (logger.isInfoEnabled()) {
				logger.info("Etape deja existante code " + this.convention.getEtape());
			}
		}
		// creation Ufr
		try {
			this.convention.getUfr().setCodeUniversite(getSessionController().getCodeUniversite());
			int idUfr = this.getConventionDomainService().addUfr(this.convention.getUfr());
			if (logger.isInfoEnabled()) {
				logger.info("Ajout Ufr : " 
						+ this.convention.getUfr() + ", id ufr ajout : " + idUfr);
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			return retour;
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.UFR.ERREUR", we.getMessage());
			return retour;
		} catch (UfrAlreadyExistingForCodeException ue) {
			if (logger.isInfoEnabled()) {
				logger.info("Ufr deja existante code " + this.convention.getUfr());
			}
		}
		// creation etudiant
		EtudiantDTO etudiantTmp = this.convention.getEtudiant();
		etudiantTmp.setLoginCreation(getSessionController().getCurrentLogin());
		if (logger.isDebugEnabled()) {
			logger.debug("goToAjouterConvention "); 
			if (this.convention.getEtudiant() != null) { 
				logger.debug("this.convention.getEtudiant() " 
						+ this.convention.getEtudiant().getIdentEtudiant());
			}
		}
		try {
			int idEtudiant = this.getEtudiantDomainService().addEtudiant(etudiantTmp);
			if (logger.isInfoEnabled()) {
				logger.info("Ajout etudiant : " 
						+ this.convention.getEtudiant().getIdentEtudiant());
			}
			if (idEtudiant > 0) {
				conventionTmp.setIdEtudiant(idEtudiant);
			}

		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			return retour;
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ETU.ERREUR", we.getMessage());
			return retour;
		}

		// creation Affectation
		try {
			if (this.convention.getEnseignant() != null) {
				if (this.convention.getEnseignant().getAffectation() == null) {
					AffectationDTO affect = new AffectationDTO();
					affect.setCodeUniversite(getSessionController().getCodeUniversite());
					affect.setCode("");
					affect.setLibelle("");
					this.convention.getEnseignant().setAffectation(affect);

				}
				if (this.convention.getEnseignant().getAffectation().getCode() == null) {
					AffectationDTO affect = new AffectationDTO();
					affect.setCodeUniversite(getSessionController().getCodeUniversite());
					affect.setCode("");
					affect.setLibelle("");
					this.convention.getEnseignant().setAffectation(affect);

				} 
				int idAffectationEnseignant = getPersonnelCentreGestionDomainService().addAffectation(this.convention.getEnseignant().getAffectation());
				if (logger.isInfoEnabled()) {
					logger.info("Ajout Affectation : " 
							+ this.convention.getEnseignant().getAffectation() 
							+ ", id affectation ajout : " + idAffectationEnseignant);
				}
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			return retour;
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.UFR.ERREUR", we.getMessage());
			return retour;
		} catch (AffectationAlreadyExistingForCodeException ue) {
			if (logger.isInfoEnabled()) {
				logger.info("Affectation deja existante code " 
						+ this.convention.getEnseignant().getAffectation().getCode());
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Affectation deja existante code " 
						+ this.convention.getEnseignant().getAffectation().getCode());
			}
		}
		// creation enseignant
		EnseignantDTO enseignantTmp = this.convention.getEnseignant();
		if (logger.isDebugEnabled()) {
			logger.debug("goToAjouterConvention "); 
			if (this.convention.getEnseignant() != null) { 
				logger.debug("this.convention.getEnseignant() " + this.convention.getEnseignant().getUidEnseignant());
			}
		}
		try {
			if (enseignantTmp != null && enseignantTmp.getUidEnseignant() != null) {
				EnseignantDTO enseignantExist = getEnseignantDomainService().getEnseignantFromUid(this.convention.getEnseignant().getUidEnseignant(), getSessionController().getCodeUniversite());
				if (enseignantExist == null ){
					if(!StringUtils.hasText(enseignantTmp.getCodeAffectation())){
						enseignantTmp.setCodeAffectation("");
					}
					enseignantTmp.setCodeUniversiteAffectation(getSessionController().getCodeUniversite());
					enseignantTmp.setLoginCreation(getSessionController().getCurrentLogin());
					int idEnseignant = this.getEnseignantDomainService().addEnseignant(enseignantTmp);
					if (logger.isInfoEnabled()) {
						logger.info("Ajout enseignant : " 
								+ this.convention.getEnseignant().getUidEnseignant());
					}
					if (idEnseignant > 0) {
						conventionTmp.setIdEnseignant(idEnseignant);
					}
				} else {
					if(!StringUtils.hasText(enseignantTmp.getCodeAffectation())){
						enseignantTmp.setCodeAffectation("");
					}
					enseignantTmp.setCodeUniversiteAffectation(getSessionController().getCodeUniversite());
					enseignantTmp.setId(enseignantExist.getId());
					enseignantTmp.setLoginModif(getSessionController().getCurrentLogin());
					getEnseignantDomainService().updateEnseignant(enseignantTmp);
					conventionTmp.setIdEnseignant(enseignantExist.getId());
				}
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			return retour;
		} catch (DataUpdateException ue) {
			logger.error("DataAddException", ue.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			return retour;
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ENSEIGNANT.ERREUR", we.getMessage());
			return retour;
		}

		// Creation convention

		// calcul de la duree du stage en semaine
		int semCalStage = 0;
		// calcul avec interruption
		if (logger.isDebugEnabled()) {
			logger.debug("Utils.CalculDureeSemaine conventionTmp.getDateDebutStage()= "
					+ conventionTmp.getDateDebutStage());
			logger.debug("Utils.CalculDureeSemaine conventionTmp.getDateFinStage()= " 
					+ conventionTmp.getDateFinStage());
		}
		if (conventionTmp.isInterruptionStage()) {
			if (logger.isDebugEnabled()) {
				logger.debug("Utils.CalculDureeSemaine conventionTmp.getDateDebutInterruption()= " 
						+ conventionTmp.getDateDebutInterruption());
				logger.debug("Utils.CalculDureeSemaine conventionTmp.getDateFinInterruption()= "
						+ conventionTmp.getDateFinInterruption());
			}
			semCalStage = Utils.CalculDureeSemaine(conventionTmp.getDateDebutStage(),
					conventionTmp.getDateFinStage(), conventionTmp.getDateDebutInterruption(),
					conventionTmp.getDateFinInterruption());
		} else {
			semCalStage = Utils.CalculDureeSemaine(conventionTmp.getDateDebutStage(),
					conventionTmp.getDateFinStage(), null, null);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("ConventionController :: Utils.CalculDureeSemaine semCalStage= " + semCalStage);
		}

		convention.setDureeStage(semCalStage);
		if (logger.isDebugEnabled()) {
			logger.debug("conventionTmp " + conventionTmp.toString()); 

		}
		if (selAnneeUniversitaire != null) {
			String selAnneeUniv = selAnneeUniversitaire.toString();
			conventionTmp.setAnnee(selAnneeUniv);
		} else {
			String anneeUniversitaire = anneeUniv(conventionTmp.getDateDebutStage(),conventionTmp.getDateFinStage());
			if (anneeUniversitaire != null) {
				conventionTmp.setAnnee(anneeUniversitaire);
			}
		}

		conventionTmp.setLoginCreation(getSessionController().getCurrentLogin());
		EtabRef etabRef = getStudentComponentRepositoryDomain().getEtabRef(getSessionController().getCodeUniversite());
		if (etabRef != null) {
			if (etabRef.getAdresseEtabRef() != null) {
				conventionTmp.setAdresseEtabRef(etabRef.getAdresseEtabRef());
				if (logger.isDebugEnabled()) {
					logger.debug("ConventionController :: etabRef.getAdresseEtabRef() = "
							+ etabRef.getAdresseEtabRef());
				}
			}
			if (etabRef.getNomEtabRef() != null) {
				conventionTmp.setNomEtabRef(etabRef.getNomEtabRef());
				if (logger.isDebugEnabled()) {
					logger.debug("ConventionController :: etabRef.getNomEtabRef() = "
							+ etabRef.getNomEtabRef());
				}
			}
		}
		// recherche du signataire de la composante

		if (conventionTmp.getUfr() != null) {
			SignataireRef sigRef = getStudentComponentRepositoryDomain().getSigCompoRef(getSessionController().getCodeUniversite(), conventionTmp.getUfr().getCode());
			if (sigRef != null) {
				if (sigRef.getNomSignataireComposante() != null) {
					conventionTmp.setNomSignataireComposante(sigRef.getNomSignataireComposante());
					if (logger.isDebugEnabled()) {
						logger.debug("ConventionController :: sigRef.getNomSignataireComposante() = "
								+ sigRef.getNomSignataireComposante());
					}
				}
				if (sigRef.getQualiteSignataire() != null) {
					conventionTmp.setQualiteSignataire(sigRef.getQualiteSignataire());
				}

			}

		}
		conventionTmp.setCodeUniversiteEtape(getSessionController().getCodeUniversite());
		conventionTmp.setCodeUniversiteUFR(getSessionController().getCodeUniversite());
		try {
			int idConvention = this.getConventionDomainService().addConvention(conventionTmp);
			if (logger.isInfoEnabled()) {
				logger.info("Ajout Convention : " 
						+ this.convention.getEtudiant().getIdentEtudiant());
			}
			if (idConvention > 0) {
				if (logger.isInfoEnabled()) {
					logger.info("Creation Convention OK : " + idConvention);
				}
				this.convention.setIdConvention(idConvention);
				addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
				this.conventionCree = true;

				// Si c'est un étudiant qui crée la convention et qu'on est configurés en alertes mail pour les tuteurs et gestionnaires
				if (getSessionController().getCurrentAuthEtudiant() != null && getSessionController().isAvertissementPersonnelCreaConvention()){
					String text=getString("ALERTES_MAIL.AVERTISSEMENT_PERSONNEL_CREA_CONVENTION",
							idConvention,
							getSessionController().getCurrentUser().getDisplayName(),
							this.convention.getIdCentreGestion());

					String libelleEtape = "";
					if (conventionTmp.getEtape() != null
							&& !conventionTmp.getEtape().getLibelle().isEmpty()){
						libelleEtape = conventionTmp.getEtape().getLibelle();
					}
					String sujet=getString("ALERTES_MAIL.AVERTISSEMENT_PERSONNEL_CREA_CONVENTION.SUJET",
							libelleEtape,
							idConvention);

					// Envoi d'une alerte à l'enseignant référent
					//					if (this.convention.getEnseignant().getMail() != null && !this.convention.getEnseignant().getMail().isEmpty())
					//						getSmtpService().send(new InternetAddress(this.convention.getEnseignant().getMail()),sujet,text,text);

					// Envoi d'une alerte aux personnels du centre gestion configurés pour les recevoir
					List<PersonnelCentreGestionDTO> listePersonnels = getPersonnelCentreGestionDomainService().getPersonnelCentreGestionList(this.convention.getIdCentreGestion());

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
				//sequenceEtapeEnum = SequenceEtapeEnum.etape9;
				sequenceEtapeEnum = SequenceEtapeEnum.etape10;
				//retour vers detail convention (validation, avenant ), idem recherche 
				sequenceEtapeEnumSel = SequenceEtapeEnumSel.etape13;
				retour = "conventionEtape8Recap";
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}catch (AddressException ade){
			logger.error("AddressException", ade.fillInStackTrace());
			addErrorMessage(null, "GENERAL.ERREUR_MAIL");
		}
		return retour;
	}

	/**
	 * @return String
	 */
	public String modifierStageDetail() {
		String retour = null;
		boolean ctrlInfosOK = true;
		// ctrl donnees stage
		String nomForm = "formSelConvention";
		ctrlInfosOK = conventionCtrlStage(nomForm);
		if (ctrlInfosOK) {
			// renseignements des zones de selection
			rensInfosSelecStage();
			ConventionDTO conventionTmp = this.convention;

			// calcul de la duree du stage en semaine
			int semCalStage = 0;
			// calcul avec interruption
			if (logger.isDebugEnabled()) {
				logger.debug("Utils.CalculDureeSemaine conventionTmp.getDateDebutStage()= " 
						+ conventionTmp.getDateDebutStage());
				logger.debug("Utils.CalculDureeSemaine conventionTmp.getDateFinStage()= " 
						+ conventionTmp.getDateFinStage());
			}
			if (conventionTmp.isInterruptionStage()) {
				if (logger.isDebugEnabled()) {
					logger.debug("Utils.CalculDureeSemaine conventionTmp.getDateDebutInterruption()= " 
							+ conventionTmp.getDateDebutInterruption());
					logger.debug("Utils.CalculDureeSemaine conventionTmp.getDateFinInterruption()= " 
							+ conventionTmp.getDateFinInterruption());
				}
				semCalStage = Utils.CalculDureeSemaine(conventionTmp.getDateDebutStage(), conventionTmp.getDateFinStage(), conventionTmp.getDateDebutInterruption(), conventionTmp.getDateFinInterruption());
			} else {
				semCalStage = Utils.CalculDureeSemaine(conventionTmp.getDateDebutStage(), conventionTmp.getDateFinStage(), null, null);
			}
			if (logger.isDebugEnabled()) {
				logger.debug("Utils.CalculDureeSemaine semCalStage= " 
						+ semCalStage);
			}

			convention.setDureeStage(semCalStage);
			if (logger.isDebugEnabled()) {
				logger.debug("conventionTmp " + conventionTmp.toString()); 

			}

			if (selAnneeUniversitaire != null) {
				String selAnneeUniv = selAnneeUniversitaire.toString();
				conventionTmp.setAnnee(selAnneeUniv);
			} else {
				String anneeUniversitaire = anneeUniv(conventionTmp.getDateDebutStage(),conventionTmp.getDateFinStage());
				if (anneeUniversitaire != null) {
					conventionTmp.setAnnee(anneeUniversitaire);
				}
			}
			conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
			try {
				if (this.getConventionDomainService().updateConvention(conventionTmp)) {
					this.alerteMailModifConvention(" le détail du stage ");
					retour = SequenceEtapeEnumSel.etape5.actionEtape();
					addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
				} 
			} catch (DataUpdateException ae) {
				logger.error("DataUpdateException", ae.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
			}

		}
		return retour;

	}

	/**
	 * @return String
	 */
	public String editPdfConventionFr() {
		String retour = null;
		this.editConvFR = true;
		retour = editPdfConvention();
		return retour;
	}
	/**
	 * @return String
	 */
	public String editPdfConvention() {
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
			String idConvention = this.convention.getIdConvention().toString();
			EtudiantDTO etudiant = this.convention.getEtudiant();
			fileNameXml = "convention_" + idConvention;
			if (this.convention.getCodeLangueConvention() != null) {
				language = this.convention.getCodeLangueConvention();
			}
			if (this.editConvFR) {
				language = "fr";
			}
			nomDocxsl = "convention" + "_" + language + ".xsl";
			if (etudiant != null) {
				fileNameXml = fileNameXml + ("_" + etudiant.getPrenom() + "_" + etudiant.getNom());
			}

			// Retrait des eventuels caracteres de controle empechant la generation XML
			if (this.convention.getSujetStage() != null && !this.convention.getSujetStage().isEmpty())
				this.convention.setSujetStage(this.convention.getSujetStage().replaceAll("[\\x00-\\x1F]",""));
			if (this.convention.getCommentaireDureeTravail() != null && !this.convention.getCommentaireDureeTravail().isEmpty())
				this.convention.setCommentaireDureeTravail(this.convention.getCommentaireDureeTravail().replaceAll("[\\x00-\\x1F]",""));
			if (this.convention.getCommentaireStage() != null && !this.convention.getCommentaireStage().isEmpty())
				this.convention.setCommentaireStage(this.convention.getCommentaireStage().replaceAll("[\\x00-\\x1F]",""));
			if (this.convention.getFonctionsEtTaches() != null && !this.convention.getFonctionsEtTaches().isEmpty())
				this.convention.setFonctionsEtTaches(this.convention.getFonctionsEtTaches().replaceAll("[\\x00-\\x1F]",""));
			if (this.convention.getDetails() != null && !this.convention.getDetails().isEmpty())
				this.convention.setDetails(this.convention.getDetails().replaceAll("[\\x00-\\x1F]",""));
			if (this.convention.getModeEncadreSuivi() != null && !this.convention.getModeEncadreSuivi().isEmpty())
				this.convention.setModeEncadreSuivi(this.convention.getModeEncadreSuivi().replaceAll("[\\x00-\\x1F]",""));
			if (this.convention.getAvantagesNature() != null && !this.convention.getAvantagesNature().isEmpty())
				this.convention.setAvantagesNature(this.convention.getAvantagesNature().replaceAll("[\\x00-\\x1F]",""));
			if (this.convention.getTravailNuitFerie() != null && !this.convention.getTravailNuitFerie().isEmpty())
				this.convention.setTravailNuitFerie(this.convention.getTravailNuitFerie().replaceAll("[\\x00-\\x1F]",""));

			// appel castor pour fichier xml a partir de Convention
			castorService.objectToFileXml(this.convention, fileNameXml + fileNameXmlfin);
			//fusion du xsl et xml en pdf
			String fileNamePdf = fileNameXml + ".pdf";
			PDFUtils.exportPDF(fileNameXml + fileNameXmlfin, FacesContext.getCurrentInstance(), 
					castorService.getXslXmlPath(),
					fileNamePdf, nomDocxsl);
			addInfoMessage(null, "CONVENTION.IMPRESSION.CONFIRMATION");
			this.editConvFR = false;
		} catch (ExportException e) {
			logger.error("ExportException ", e.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.EDIT.CONVENTION.ERREUR", e.getMessage());
		}
		return retour;
	}

	/**
	 * Create generate PDF files in a simple directory
	 * @return string
	 */
	public String editPdfConventionsEnMasse() {		
		String retour = null;

		/**
		 **  Methodes de creation des documents PDF selon l'edition demandee
		 **/
		//StringBuffer sbFilename = new StringBuffer();
		String nomDocxsl = "";
		String fileNameXml = "";
		String fileNameXmlfin = ".xml";
		//String xslXmlPath = castorService.getXslXmlPath();
		String language = "fr";			
		String idConvention;
		EtudiantDTO etudiant;

		try	{
			List<ConventionDTO> liste=getResultatsRechercheConvention();
			int i=0;

			for (ConventionDTO c : liste){

				if (i<2){
					i++;					
					idConvention=c.getIdConvention().toString();
					etudiant = c.getEtudiant();
					fileNameXml = "convention_" + idConvention;

					if (c.getCodeLangueConvention() != null) {
						language = c.getCodeLangueConvention();
					}
					if (this.editConvFR) {
						language = "fr";
					}
					nomDocxsl = "convention" + "_" + language + ".xsl";
					if (etudiant != null) {
						fileNameXml = fileNameXml + ("_" + etudiant.getPrenom() + "_" + etudiant.getNom());
					}

					// Retrait des eventuels caracteres de controle empechant la generation XML
					if (c.getSujetStage() != null && !c.getSujetStage().isEmpty())
						c.setSujetStage(c.getSujetStage().replaceAll("[\\x00-\\x1F]",""));
					if (c.getCommentaireDureeTravail() != null && !c.getCommentaireDureeTravail().isEmpty())
						c.setCommentaireDureeTravail(c.getCommentaireDureeTravail().replaceAll("[\\x00-\\x1F]",""));
					if (c.getCommentaireStage() != null && !c.getCommentaireStage().isEmpty())
						c.setCommentaireStage(c.getCommentaireStage().replaceAll("[\\x00-\\x1F]",""));
					if (c.getFonctionsEtTaches() != null && !c.getFonctionsEtTaches().isEmpty())
						c.setFonctionsEtTaches(c.getFonctionsEtTaches().replaceAll("[\\x00-\\x1F]",""));
					if (c.getDetails() != null && !c.getDetails().isEmpty())
						c.setDetails(c.getDetails().replaceAll("[\\x00-\\x1F]",""));
					if (c.getModeEncadreSuivi() != null && !c.getModeEncadreSuivi().isEmpty())
						c.setModeEncadreSuivi(c.getModeEncadreSuivi().replaceAll("[\\x00-\\x1F]",""));
					if (c.getAvantagesNature() != null && !c.getAvantagesNature().isEmpty())
						c.setAvantagesNature(c.getAvantagesNature().replaceAll("[\\x00-\\x1F]",""));
					if (c.getTravailNuitFerie() != null && !c.getTravailNuitFerie().isEmpty())
						c.setTravailNuitFerie(c.getTravailNuitFerie().replaceAll("[\\x00-\\x1F]",""));

					// appel castor pour fichier xml a partir de Convention
					castorService.objectToFileXml(c, fileNameXml + fileNameXmlfin);
					//fusion du xsl et xml en pdf
					String fileNamePdf = fileNameXml + ".pdf";


					//					Affichage console
					//					System.out.println(i + " : " + c);
					//					System.out.println("   ==> idConvention : "+idConvention);
					//					System.out.println("   ==> etudiant : "+etudiant);	
					//					System.out.println("   ==> nomDocxsl : "+nomDocxsl);
					//					System.out.println("   ==> fileNameXml : "+fileNameXml);
					//					System.out.println("   ==> castorService.getXslXmlPath() = "+castorService.getXslXmlPath());
					//					System.out.println("   ==> fileNamePdf : "+fileNamePdf);

					/*
					 * Enregistrement des pdf dans un dossier simple 
					 */
					PDFUtils.exportPDFinDirectory(fileNameXml + fileNameXmlfin,  
							castorService.getXslXmlPath(),
							fileNamePdf, nomDocxsl);  

					addInfoMessage(null, "CONVENTION.IMPRESSION.CONFIRMATION");
					this.editConvFR = false;				
				}
				else{
					break;
				}
			}
		}
		catch(ExportException e) {
			logger.error("ExportException ", e.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.EDIT.CONVENTION.ERREUR", e.getMessage());
		}
		return retour;
	}

	/**
	 * Create generate PDF files in a zip directory
	 * @return string
	 */
	public String editPdfConventionsEnMasseZip() {		
		String retour = null;
		/**
		 **  Methodes de creation des documents PDF selon l'edition demandee
		 **/
		//StringBuffer sbFilename = new StringBuffer();
		List<ConventionDTO> liste=getResultatsRechercheConvention();

		String nomDocxsl = "";
		String fileNameXml = "";
		String fileNameXmlfin = ".xml";
		String fileNameXMLfinal;
		//String xslXmlPath = castorService.getXslXmlPath();
		String language = "fr";			
		String idConvention;
		EtudiantDTO etudiant;
		String currentLogin = getSessionController().getCurrentLogin();
		String[] parts=currentLogin.split(Pattern.quote("."));  
		String id_user=parts[0]+"_"+parts[1];


		Date date=new Date();
		String ZipFolderName ="Impression_En_Masse/";
		String ZipName="Impression_En_Masse_"+id_user+"_"+date.getTime()+".zip";

		List<String> fileNameXMLfinalList = new ArrayList<String>();
		List<String> fileNamePdfList = new ArrayList<String>();
		List<String> nomDocxslList = new ArrayList<String>();

		try	{

			/*
			 * Etape 1 : Ménage dans le dossier regroupant tous les fichiers zip
			 */
			this.deleteZipFolder(date,castorService.getXslXmlPath(), ZipFolderName);

			/*
			 *  Etape 2 : Parcours des conventions trouvees et recuperation des attributs string dans des listes
			 */
			for (ConventionDTO c:liste){				
				idConvention=c.getIdConvention().toString();
				etudiant = c.getEtudiant();
				fileNameXml = "convention_" + idConvention;			

				if (c.getCodeLangueConvention() != null) {
					language = c.getCodeLangueConvention();
				}
				if (this.editConvFR) {
					language = "fr";
				}
				nomDocxsl = "convention" + "_" + language + ".xsl";
				if (etudiant != null) {
					fileNameXml = fileNameXml + ("_" + etudiant.getPrenom() + "_" + etudiant.getNom());
				}
				// Retrait des eventuels caracteres de controle empechant la generation XML
				if (c.getSujetStage() != null && !c.getSujetStage().isEmpty())
					c.setSujetStage(c.getSujetStage().replaceAll("[\\x00-\\x1F]",""));
				if (c.getCommentaireDureeTravail() != null && !c.getCommentaireDureeTravail().isEmpty())
					c.setCommentaireDureeTravail(c.getCommentaireDureeTravail().replaceAll("[\\x00-\\x1F]",""));
				if (c.getCommentaireStage() != null && !c.getCommentaireStage().isEmpty())
					c.setCommentaireStage(c.getCommentaireStage().replaceAll("[\\x00-\\x1F]",""));
				if (c.getFonctionsEtTaches() != null && !c.getFonctionsEtTaches().isEmpty())
					c.setFonctionsEtTaches(c.getFonctionsEtTaches().replaceAll("[\\x00-\\x1F]",""));
				if (c.getDetails() != null && !c.getDetails().isEmpty())
					c.setDetails(c.getDetails().replaceAll("[\\x00-\\x1F]",""));
				if (c.getModeEncadreSuivi() != null && !c.getModeEncadreSuivi().isEmpty())
					c.setModeEncadreSuivi(c.getModeEncadreSuivi().replaceAll("[\\x00-\\x1F]",""));
				if (c.getAvantagesNature() != null && !c.getAvantagesNature().isEmpty())
					c.setAvantagesNature(c.getAvantagesNature().replaceAll("[\\x00-\\x1F]",""));
				if (c.getTravailNuitFerie() != null && !c.getTravailNuitFerie().isEmpty())
					c.setTravailNuitFerie(c.getTravailNuitFerie().replaceAll("[\\x00-\\x1F]",""));

				// appel castor pour fichier xml a partir de Convention
				castorService.objectToFileXml(c, fileNameXml + fileNameXmlfin);
				//fusion du xsl et xml en pdf
				String fileNamePdf = fileNameXml + ".pdf";
				fileNameXMLfinal=fileNameXml + fileNameXmlfin;

				/**
				 * Remplissage listes des attributs
				 */
				fileNameXMLfinalList.add(fileNameXMLfinal);
				fileNamePdfList.add(fileNamePdf);
				nomDocxslList.add(nomDocxsl);

				addInfoMessage(null, "CONVENTION.IMPRESSION.CONFIRMATION");
				this.editConvFR = false;				
			}//end for

			/*
			 *  Etape 3 : Appel de la fonction de transformation des fichier en Pdf, stockage dans le dossier zip puis telechargement 
			 */
			PDFUtils.setPDFfilesInZip(fileNameXMLfinalList, ZipName, ZipFolderName, castorService.getXslXmlPath(), fileNamePdfList, nomDocxslList, FacesContext.getCurrentInstance());


		}catch(ExportException e) {
			logger.error("ExportException ", e.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.EDIT.CONVENTION.ERREUR", e.getMessage());
		} 
		catch(IOException e){
			logger.error(e.getMessage(), e);
		}
		return retour;
	}


	public void deleteZipFolder(Date date,String currentPath, String zipFolder){
		logger.info("Preparation du dossier "+ currentPath+zipFolder);
		Long Date_de_connexion=date.getTime();
		File dir=new File(currentPath+zipFolder);

		if (dir.exists()){
			if (!EmptyDirectory(dir)){
				logger.info("Directory exists and isn't empty ! ");


				File []liste=dir.listFiles();
				String name;
				String nombre_date;
				Long nombre_date_a_comparer;
				int nbr_heure=1; // nombre d'heure délais de sauvegarde des fichiers zip
				Long difference;
				Long diff_dates;

				String[] parts1;
				String[] parts2;
				List<File> fichier_a_supp= new ArrayList<File>();

				logger.info("Le dossier "+dir + " contient "+liste.length+ " fichiers. ");
				for (File l: liste){

					try{
						name=l.getName();					
						parts1 = name.split("_");

						// exemple : Impression_En_Masse_14326425434
						//// String part1 = parts1[0]  --> Impression
						//// String part2 = parts1[1]  --> En
						//// String part3 = parts1[2]  --> Masse
						//// String part4 = parts1[3]  --> par
						//// String part5 = parts1[4]  --> prenom
						//// String part6 = parts1[5]  --> nom
						//// String part7 = parts1[6]  --> 14326425434.zip

						nombre_date=parts1[6]; // 14326425434.zip

						parts2=nombre_date.split(Pattern.quote("."));  
						//// String part1 = parts2[0]  --> 14326425434
						//// String part2 = parts2[1]  --> zip

						// On recupere la partie '14326425434' c'est a dire le string nombre que l'on convertira en long			
						nombre_date=parts2[0];
						nombre_date_a_comparer=Long.parseLong(nombre_date);

						// reprendre ici, faire un test si la durée entre 'nombre_date_recente' et 'nombre_date_a_comparer' est supérieur à 1h (e.g.)
						//si oui, deleter les fichiers correspondant
						diff_dates=Date_de_connexion - nombre_date_a_comparer;	

						//rq : 1h=3600s  et 1000ms=1s  donc 1h = 3 600 000 ms 						
						difference=diff_dates-nbr_heure*3600000;						

						if (difference>=0){
							fichier_a_supp.add(l);							
						}				

					}catch(Exception e){
						logger.error(" impossible de spliter le string par '_' et puis par '.' ! ");
					}					
				}			

				if (fichier_a_supp.isEmpty()){
					logger.info("Pas de vieux fichiers à supprimer. ");
				}else{					

					// Nous avons donc une liste de nom de fichier à supprimer				
					for (File f:fichier_a_supp){
						logger.info("    Suppression du fichier  '"+f.getName()  + "' ");
						try{
							f.delete();
						}catch(Exception e){
							logger.error("impossible d'effacer le fichier "+f.getName() + " !");
						}					
					}
				}				
			}else {
				logger.info("Directory exists but is empty !");
			}
		}
		else{
			logger.info("Directory doesn't exist ! ");
		}

	}

	public boolean EmptyDirectory(File folder){
		File []liste ;
		boolean resultat=false;
		if(folder.isDirectory())
		{
			liste=folder.listFiles();
			if(liste!=null && liste.length==0)
			{
				resultat= true; 
			}

		}
		return resultat; 
	}


	/**
	 * @return String
	 */
	public String editPdfRecap() {
		String retour = null;
		try	{
			/**
			 **  Methodes de creation des documents PDF selon l'edition demandee
			 **/
			String nomDocxsl = "";
			String fileNameXml = "";
			String fileNameXmlfin = ".xml";
			String idConvention = this.convention.getIdConvention().toString();
			nomDocxsl = "recap" + ".xsl";
			fileNameXml = "recap_" + idConvention;
			// appel castor pour fichier xml a partir de objet java convention
			castorService.objectToFileXml(this.convention, fileNameXml + fileNameXmlfin);
			//fusion du xsl et xml en pdf
			String fileNamePdf = fileNameXml + ".pdf";
			PDFUtils.exportPDF(fileNameXml + fileNameXmlfin, FacesContext.getCurrentInstance(), 
					castorService.getXslXmlPath(),
					fileNamePdf, nomDocxsl);
			addInfoMessage(null, "CONVENTION.IMPRESSION.RECAP.CONFIRMATION");
		} catch (ExportException e) {
			logger.error("editPdfRecap ", e.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.EDIT.RECAP.ERREUR", e.getMessage());
		}
		return retour;
	}

	/**
	 * @return String
	 */
	public String editPdfRemerciement() {
		String retour = null;
		try	{
			/**
			 *  Methodes de creation des documents PDF selon l'edition demandee
			 */
			String nomDocxsl = "";
			String fileNameXml = "";
			String fileNameXmlfin = ".xml";
			String idConvention = this.convention.getIdConvention().toString();
			nomDocxsl = "remerciement" + ".xsl";
			fileNameXml = "remerciement_" + idConvention;
			// appel castor pour fichier xml a partir de objet java convention
			castorService.objectToFileXml(this.convention, fileNameXml + fileNameXmlfin);
			//fusion du xsl et xml en pdf
			String fileNamePdf = fileNameXml + ".pdf";
			PDFUtils.exportPDF(fileNameXml + fileNameXmlfin, FacesContext.getCurrentInstance(),
					castorService.getXslXmlPath(),
					fileNamePdf, nomDocxsl);
			addInfoMessage(null, "CONVENTION.IMPRESSION.REMERCIEMENT.CONFIRMATION");
		} catch (ExportException e) {
			logger.error("editPdfRemerciement ", e.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.EDIT.RECAP.ERREUR", e.getMessage());
		}
		return retour;
	}


	/**
	 * @return String
	 */
	public String goToRecapConvention() {
		String retour = null;
		if (this.currentConvention != null) {
			if (logger.isDebugEnabled()) {
				logger.info("Selection Convention: " + this.currentConvention.toString());
			}
			ConventionDTO conventionTmp = this.getConventionDomainService().getConventionFromId(this.currentConvention.getIdConvention());
			if (conventionTmp != null) {
				this.convention = conventionTmp;
				// renseignement des zones de selections a partir de la convention
				setSelTypeConvention(conventionTmp.getTypeConvention());
				setSelTheme(conventionTmp.getTheme());
				setSelTempsTravail(conventionTmp.getTempsTravail());
				setSelIndemnisation(conventionTmp.getIndemnisation());
				if (conventionTmp.getAnnee() != null) {
					setSelAnneeUniversitaire(conventionTmp.getAnnee());
				}
				if (conventionTmp.getUniteGratification() != null) {
					setSelUniteGratification(conventionTmp.getUniteGratification());
				}
				if (conventionTmp.getModeVersGratification() != null) {
					setSelModeVersGratification(conventionTmp.getModeVersGratification());
				}
				if (conventionTmp.getOrigineStage() != null) {
					setSelOrigineStage(conventionTmp.getOrigineStage());
				}
				if (conventionTmp.getUniteDuree() != null) {
					setSelUniteDureeExceptionnelle(conventionTmp.getUniteDuree());
				}
				if (conventionTmp.getUniteDureeGratification() != null) {
					setSelUniteDureeGratification(conventionTmp.getUniteDureeGratification());
				}

				setSelNatureTravail(conventionTmp.getNatureTravail());			
				setSelModeValidationStage(conventionTmp.getModeValidationStage());
				setSelLangueConvention(conventionTmp.getLangueConvention());

				if (conventionTmp.getAssurance() != null) {
					setSelAssurance(conventionTmp.getAssurance());
				}

				if (conventionTmp.getCaisseRegime() != null) {
					setSelCaisseRegime(conventionTmp.getCaisseRegime());
				}

				if (this.currentConvention.getEtape() != null) {
					this.convention.setEtape(this.currentConvention.getEtape());
				}
				if (this.currentConvention.getUfr() != null) {
					this.convention.setUfr(this.currentConvention.getUfr());
				}
				if (conventionTmp.getIdEtudiant() > 0) {
					EtudiantDTO etudiantTmp  = this.getEtudiantDomainService().getEtudiantFromId(conventionTmp.getIdEtudiant());
					if (etudiantTmp != null) {
						this.convention.setEtudiant(etudiantTmp);
					}
				}
				if (conventionTmp.getIdCentreGestion() > 0) {
					CentreGestionDTO centreGestionTmp = this.getCentreGestionDomainService().getCentreGestion(conventionTmp.getIdCentreGestion());
					if (centreGestionTmp != null) {
						this.convention.setCentreGestion(centreGestionTmp);
						getSessionController().setCentreGestionRattachement(centreGestionTmp);
					}
				}
				if (conventionTmp.getIdEnseignant() > 0 ) {
					EnseignantDTO enseignantTmp = this.getEnseignantDomainService().getEnseignantFromId(conventionTmp.getIdEnseignant());
					if (enseignantTmp != null) {
						if (StringUtils.hasText(enseignantTmp.getCodeAffectation())) {
							AffectationDTO affecDTO = rechAffec(enseignantTmp.getCodeAffectation());
							if (affecDTO != null) {
								enseignantTmp.setAffectation(affecDTO);
							}

						}
						enseignantTmp.setCivilite(getNomenclatureDomainService().getCiviliteFromId(enseignantTmp.getIdCivilite()));
						this.convention.setEnseignant(enseignantTmp);
					}
				}
				if (conventionTmp.getIdStructure() > 0) {
					StructureDTO structureTmp = this.getStructureDomainService().getStructureFromId(conventionTmp.getIdStructure());
					if (structureTmp != null) {
						this.convention.setStructure(structureTmp);
					}
				}
				if (conventionTmp.getIdService() > 0) {
					ServiceDTO serviceTmp = this.getStructureDomainService().getServiceFromId(conventionTmp.getIdService());
					if (serviceTmp != null) {
						this.convention.setService(serviceTmp);
						this.etablissementController.setServiceSel(serviceTmp);
						this.etablissementController.setIdServiceSel(serviceTmp.getIdService());
						getSessionController().setCurrentManageStructure(this.convention.getStructure());
						getSessionController().setMenuGestionEtab(false);
						//this.etablissementController.loadContactsServices();
						this.etablissementController.reloadServices();

					}
				}
				if (conventionTmp.getIdContact() > 0) {
					ContactDTO contactTmp = this.getStructureDomainService().getContactFromId(conventionTmp.getIdContact());
					if (contactTmp != null) {
						this.convention.setContact(contactTmp);
						this.etablissementController.reloadContacts();
						this.etablissementController.setIdContactSel(contactTmp.getId());
					}
				}
				if (conventionTmp.getIdSignataire() > 0) {
					ContactDTO signataireTmp = this.getStructureDomainService().getContactFromId(conventionTmp.getIdSignataire());
					if (signataireTmp != null) {
						this.convention.setSignataire(signataireTmp);
					}
				}


				// Ajout de la vérification de modification de tuteur pro ou pedago via avenant et remplacement le cas échéant
				//				if (this.currentConvention.getNbAvenant()>0){
				//					List<AvenantDTO> listeAvenants = getAvenantDomainService().getAvenant(conventionTmp.getIdConvention());
				//					for (AvenantDTO avenant : listeAvenants){
				//						if (avenant.isModificationEnseignant()){
				//							EnseignantDTO enseignantTmp = this.getEnseignantDomainService().getEnseignantFromId(avenant.getIdEnseignant());
				//							if (enseignantTmp != null) {
				//								if (StringUtils.hasText(enseignantTmp.getCodeAffectation())) {
				//									AffectationDTO affecDTO = rechAffec(enseignantTmp.getCodeAffectation());
				//									if (affecDTO != null) {
				//										enseignantTmp.setAffectation(affecDTO);
				//									}
				//								}
				//								enseignantTmp.setCivilite(getNomenclatureDomainService().getCiviliteFromId(enseignantTmp.getIdCivilite()));
				//								this.convention.setEnseignant(enseignantTmp);
				//							}
				//						}
				//						if (avenant.isModificationSalarie()){
				//							ContactDTO contactTmp = this.getStructureDomainService().getContactFromId(avenant.getIdContact());
				//							if (contactTmp != null) {
				//								this.convention.setContact(contactTmp);
				//								this.etablissementController.reloadContacts();
				//								this.etablissementController.setIdContactSel(contactTmp.getId());
				//							}
				//						}
				//					}
				//				}
			}
			sequenceEtapeEnumSel = SequenceEtapeEnumSel.etape13;
			retour = "conventionEtape8Recap";
		}
		return retour;
	}

	/**
	 * @return String
	 */
	public String goToValidConvention() {
		String retour = null;
		if (this.currentConvention != null) {
			if (logger.isDebugEnabled()) {
				logger.info("Validation Convention: " + this.currentConvention.toString());
			}

			ConventionDTO conventionTmp = this.getConventionDomainService().getConventionFromId(this.currentConvention.getIdConvention());
			if (conventionTmp != null) {
				this.convention = conventionTmp;
				// renseignement des zones de selections a partir de la convention
				setSelTypeConvention(conventionTmp.getTypeConvention());
				setSelTheme(conventionTmp.getTheme());
				setSelTempsTravail(conventionTmp.getTempsTravail());
				setSelIndemnisation(conventionTmp.getIndemnisation());
				if (conventionTmp.getAnnee() != null) {
					setSelAnneeUniversitaire(conventionTmp.getAnnee());
				}
				if (conventionTmp.getUniteGratification() != null) {
					setSelUniteGratification(conventionTmp.getUniteGratification());
				}
				if (conventionTmp.getModeVersGratification() != null) {
					setSelModeVersGratification(conventionTmp.getModeVersGratification());
				}
				if (conventionTmp.getOrigineStage() != null) {
					setSelOrigineStage(conventionTmp.getOrigineStage());
				}
				if (conventionTmp.getUniteDuree() != null) {
					setSelUniteDureeExceptionnelle(conventionTmp.getUniteDuree());
				}
				if (conventionTmp.getUniteDureeGratification() != null) {
					setSelUniteDureeGratification(conventionTmp.getUniteDureeGratification());
				}

				setSelNatureTravail(conventionTmp.getNatureTravail());			
				setSelModeValidationStage(conventionTmp.getModeValidationStage());
				setSelLangueConvention(conventionTmp.getLangueConvention());

				if (conventionTmp.getAssurance() != null) {
					setSelAssurance(conventionTmp.getAssurance());
				}

				if (conventionTmp.getCaisseRegime() != null) {
					setSelCaisseRegime(conventionTmp.getCaisseRegime());
				}

				if (this.currentConvention.getEtape() != null) {
					this.convention.setEtape(this.currentConvention.getEtape());
				}
				if (this.currentConvention.getUfr() != null) {
					this.convention.setUfr(this.currentConvention.getUfr());
				}
				if (conventionTmp.getIdEtudiant() > 0) {
					EtudiantDTO etudiantTmp  = this.getEtudiantDomainService().getEtudiantFromId(conventionTmp.getIdEtudiant());
					if (etudiantTmp != null) {
						this.convention.setEtudiant(etudiantTmp);
					}
				}
				if (conventionTmp.getIdCentreGestion() > 0) {
					CentreGestionDTO centreGestionTmp = this.getCentreGestionDomainService().getCentreGestion(conventionTmp.getIdCentreGestion());
					if (centreGestionTmp != null) {
						this.convention.setCentreGestion(centreGestionTmp);
						getSessionController().setCentreGestionRattachement(centreGestionTmp);
					}
				}

				if (conventionTmp.getIdEnseignant() > 0 ) {
					EnseignantDTO enseignantTmp = this.getEnseignantDomainService().getEnseignantFromId(conventionTmp.getIdEnseignant());
					if (enseignantTmp != null) {
						if (StringUtils.hasText(enseignantTmp.getCodeAffectation())) {
							AffectationDTO affecDTO = rechAffec(enseignantTmp.getCodeAffectation());
							if (affecDTO != null) {
								enseignantTmp.setAffectation(affecDTO);
							}

						}
						enseignantTmp.setCivilite(getNomenclatureDomainService().getCiviliteFromId(enseignantTmp.getIdCivilite()));
						this.convention.setEnseignant(enseignantTmp);
					}
				}
				if (conventionTmp.getIdStructure() > 0) {
					StructureDTO structureTmp = this.getStructureDomainService().getStructureFromId(conventionTmp.getIdStructure());
					if (structureTmp != null) {
						this.convention.setStructure(structureTmp);
					}
				}
				if (conventionTmp.getIdService() > 0) {
					ServiceDTO serviceTmp = this.getStructureDomainService().getServiceFromId(conventionTmp.getIdService());
					if (serviceTmp != null) {
						this.convention.setService(serviceTmp);
						this.etablissementController.setServiceSel(serviceTmp);
						this.etablissementController.setIdServiceSel(serviceTmp.getIdService());
						getSessionController().setCurrentManageStructure(this.convention.getStructure());
						getSessionController().setMenuGestionEtab(false);
						//this.etablissementController.loadContactsServices();
						this.etablissementController.reloadServices();

					}
				}
				if (conventionTmp.getIdContact() > 0) {
					ContactDTO contactTmp = this.getStructureDomainService().getContactFromId(conventionTmp.getIdContact());
					if (contactTmp != null) {
						this.convention.setContact(contactTmp);
						this.etablissementController.reloadContacts();
						this.etablissementController.setIdContactSel(contactTmp.getId());
					}
				}
				if (conventionTmp.getIdSignataire() > 0) {
					ContactDTO signataireTmp = this.getStructureDomainService().getContactFromId(conventionTmp.getIdSignataire());
					if (signataireTmp != null) {
						this.convention.setSignataire(signataireTmp);
					}
				}

				// Ajout de la vérification de modification de tuteur pro ou pedago via avenant et remplacement le cas échéant
				if (this.currentConvention.getNbAvenant()>0){
					List<AvenantDTO> listeAvenants = getAvenantDomainService().getAvenant(conventionTmp.getIdConvention());
					for (AvenantDTO avenant : listeAvenants){
						if (avenant.isModificationEnseignant()){
							EnseignantDTO enseignantTmp = this.getEnseignantDomainService().getEnseignantFromId(avenant.getIdEnseignant());
							if (enseignantTmp != null) {
								if (StringUtils.hasText(enseignantTmp.getCodeAffectation())) {
									AffectationDTO affecDTO = rechAffec(enseignantTmp.getCodeAffectation());
									if (affecDTO != null) {
										enseignantTmp.setAffectation(affecDTO);
									}
								}
								enseignantTmp.setCivilite(getNomenclatureDomainService().getCiviliteFromId(enseignantTmp.getIdCivilite()));
								this.convention.setEnseignant(enseignantTmp);
							}
						}
						if (avenant.isModificationSalarie()){
							ContactDTO contactTmp = this.getStructureDomainService().getContactFromId(avenant.getIdContact());
							if (contactTmp != null) {
								this.convention.setContact(contactTmp);
								this.etablissementController.reloadContacts();
								this.etablissementController.setIdContactSel(contactTmp.getId());
							}
						}
					}
				}
			}
			sequenceEtapeEnumSel = SequenceEtapeEnumSel.etape10;
			retour = "conventionEtape10Validation";
		}
		return retour;
	}



	/**
	 * @return String
	 */
	public String goToConventionModifStage() {
		String ret = null;
		ret = "conventionEtape5ModifStage";
		return ret;
	}
	/**
	 * @return String
	 */
	public String goToConventionModifEtudiant() {
		String ret = null;
		ret = "conventionEtape1ModifEtudiant";
		return ret;
	}
	/**
	 * @param idEtudiant 
	 * @return A String
	 */
	public void rechercheInfosEtudiant(final String idEtudiant) {
		this.ctrlInfosEtuOK = false;
		this.ctrlInfosStageOK = false;

		this.listeResultatsRechercheEtudiant = null;
		this.resultatEtudiantRef=getStudentDataRepositoryDomain().getEtudiantRef(getSessionController().getCodeUniversite(), idEtudiant);
		if (resultatEtudiantRef != null) {
			if (!resultatEtudiantRef.getAdministrationApogee().isStatusApogee() && !resultatEtudiantRef.getAdministrationApogee().getRaison().isEmpty()) {
				if (logger.isDebugEnabled()) {
					logger.debug("etudiant en erreur administrative " 
							+ resultatEtudiantRef.getAdministrationApogee().getRaison());
					addErrorMessage("formConvention:identEtudiant", "RECHERCHEETU.PAS.IA");
					resultatEtudiantRef = null;
					listeResultatsRechercheEtudiant = null;
				}
			}
		}
		if (resultatEtudiantRef == null) {
			addErrorMessage("formConvention:identEtudiant", "RECHERCHEETU.INVALIDE");
		}
		recupInfosEtudiantRef();
	}

	/**
	 * 
	 */
	public void retirerEtapesOrphelines(){
		this.blocageCreationEtpOrpheline = false;
		List<EtapeInscription> listEtapes = this.etudiantRef.getListeEtapeInscriptions();

		List<String> list = new ArrayList<String>();
		String code;
		CentreGestionDTO centreTmp;
		// On parcours l'ensemble des etapes avec inscription admin de l'etudiant
		for (EtapeInscription etp : listEtapes){
			// On regarde s'il existe un centre associe au code etape
			if (etp.getCodVrsVet()!= null && !etp.getCodVrsVet().isEmpty()){
				code = etp.getCodeEtp()+";"+etp.getCodVrsVet();
			} else {
				code = etp.getCodeEtp();
			}
			centreTmp = getCentreGestionDomainService().getCentreFromCritere(code, getSessionController().getCodeUniversite());
			if (centreTmp == null){
				// S'il n'y en a pas, on vérifie une derniere fois a partir du code ufr
				EtapeInscription ufrEtape = rechUfrEtape(code);
				if (ufrEtape != null){
					centreTmp = getCentreGestionDomainService().getCentreFromCritere(ufrEtape.getCodeComposante(), getSessionController().getCodeUniversite());
					if (centreTmp == null){
						list.add(code);
					}
				}
			}
		}
		String codEtpAComparer;
		// On recree une liste qui ne contiendra pas les codes a retirer
		List<EtapeInscription> listEtpFiltree = new ArrayList<EtapeInscription>();
		boolean codeFound;
		for (EtapeInscription etp : listEtapes){
			codeFound = false;
			if (etp.getCodVrsVet()!= null && !etp.getCodVrsVet().isEmpty()){
				codEtpAComparer = etp.getCodeEtp()+";"+etp.getCodVrsVet();
			} else {
				codEtpAComparer = etp.getCodeEtp();
			}
			for (String codEtpARetirer : list){
				if (codEtpAComparer.equalsIgnoreCase(codEtpARetirer)){
					codeFound = true;
					break;
				}
			}

			if (!codeFound){
				listEtpFiltree.add(etp);
			}
		}

		listEtapes = listEtpFiltree;

		if (listEtapes.size() == 1){
			this.etudiantRef.setListeEtapeInscriptions(listEtapes);
			Map<String,String> mapTmp = new HashMap<String,String>();
			mapTmp.put(listEtapes.get(0).getCodeComposante(), listEtapes.get(0).getLibComposante());
			this.etudiantRef.setStudys(mapTmp);
		} else if (listEtapes.isEmpty()){
			this.blocageCreationEtpOrpheline = true;
		} else {
			this.etudiantRef.setListeEtapeInscriptions(listEtapes);
		}
	}

	/**
	 * @return String
	 */
	public void recupInfosEtudiantRef() {
		if (this.resultatEtudiantRef != null) {
			this.etudiantRef = new EtudiantRef();

			this.setEtudiantRef(this.resultatEtudiantRef);

			goToChoixEtapeEtudiant();
		}
	}

	/**
	 * 
	 */
	public String rechercheEtudiant() {

		boolean numEtuNomPrenomOK = true;
		this.ctrlInfosEtuOK = false;
		this.ctrlInfosStageOK = false;

		//		String retour = null;
		//		getSessionController().setCreationConventionCurrentPage("creerConventionRechercheEtudiant");
		if ((!StringUtils.hasText(this.rechIdentEtudiant)) && (! StringUtils.hasText(this.rechNomEtudiant)) && (! StringUtils.hasText(this.rechPrenomEtudiant))) {
			addErrorMessage("formConvention:oblig", "RECHERCHEETU.OBLIGATOIRE.RESPECTER");
			numEtuNomPrenomOK = false;
		}
		if (StringUtils.hasText(this.rechIdentEtudiant) && StringUtils.hasText(this.rechNomEtudiant)) {
			addErrorMessage("formConvention:nom", "RECHERCHEETU.OPTION");
			numEtuNomPrenomOK = false;
		}
		if (StringUtils.hasText(this.rechIdentEtudiant) && StringUtils.hasText(this.rechPrenomEtudiant)) {
			addErrorMessage("formConvention:nom", "RECHERCHEETU.OPTION");
			numEtuNomPrenomOK = false;
		}
		if (!StringUtils.hasText(this.rechNomEtudiant) && StringUtils.hasText(this.rechPrenomEtudiant)) {
			addErrorMessage("formConvention:nom", "RECHERCHEETU.OPTION.PRENOM");
			numEtuNomPrenomOK = false;
		}
		if (StringUtils.hasText(this.rechPrenomEtudiant)) {
			if (this.rechPrenomEtudiant.length() < 3 ) {
				addErrorMessage("formConvention:prenom", "RECHERCHEETU.PRENOM2");
				numEtuNomPrenomOK = false;
			}
		}

		if (numEtuNomPrenomOK) {
			// recherche par numero etudiant
			if (StringUtils.hasText(this.rechIdentEtudiant)) {
				this.listeResultatsRechercheEtudiant = null;
				this.resultatEtudiantRef=getStudentDataRepositoryDomain().getEtudiantRefByNum(getSessionController().getCodeUniversite(), this.rechIdentEtudiant);
				if (resultatEtudiantRef != null) {
					if (resultatEtudiantRef.getAdministrationApogee() != null){
						if (!resultatEtudiantRef.getAdministrationApogee().isStatusApogee() && !resultatEtudiantRef.getAdministrationApogee().getRaison().isEmpty()) {
							if (logger.isDebugEnabled()) {
								logger.debug("etudiant en erreur administrative " + resultatEtudiantRef.getAdministrationApogee().getRaison());
							}
							addErrorMessage("formConvention:identEtudiant", "RECHERCHEETU.PAS.IA");
							resultatEtudiantRef = null;
							listeResultatsRechercheEtudiant = null;
						}
					}
				}
				if (resultatEtudiantRef == null) {
					addErrorMessage("formConvention:identEtudiant", "RECHERCHEETU.INVALIDE");
				}
			} else {
				// recherche par nom ou prenom
				if (StringUtils.hasText(this.rechNomEtudiant) || StringUtils.hasText(this.rechPrenomEtudiant) ) {
					this.listeResultatsRechercheEtudiant=getStudentDataRepositoryDomain().getEtudiantsRefByName(getSessionController().getCodeUniversite(), this.rechNomEtudiant, this.rechPrenomEtudiant);

					if (this.listeResultatsRechercheEtudiant.isEmpty()) {
						addErrorMessage("formConvention:nom", "RECHERCHEETU.INVALIDE");
					}
					if (this.listeResultatsRechercheEtudiant.size() == 1) {
						EtudiantRef etudiantRefTmp = this.listeResultatsRechercheEtudiant.get(0);
						if (etudiantRefTmp.getAdministrationApogee() != null ){
							if (!etudiantRefTmp.getAdministrationApogee().isStatusApogee() && !etudiantRefTmp.getAdministrationApogee().getRaison().isEmpty()) {
								if (logger.isDebugEnabled()) {
									logger.debug("etudiant en erreur  " + etudiantRefTmp.getAdministrationApogee().getRaison());
								}
								addErrorMessage("formConvention:nom", "RECHERCHEETU.PAS.IA");
								resultatEtudiantRef = null;
								listeResultatsRechercheEtudiant = null;
							}
						} else {
							if (logger.isDebugEnabled()) {
								logger.debug("etudiantRefTmp.getAdministrationApogee() = null -> configuration tout Ldap");
							}
							AdministrationApogee adminApogee = new AdministrationApogee();
							adminApogee.setStatusApogee(true);
							adminApogee.setRaison("");
							etudiantRefTmp.setAdministrationApogee(adminApogee);
						}
					}
					checkListeResultatsEtudiant();
				} else {
					this.listeResultatsRechercheEtudiant = null;
					this.resultatEtudiantRef = null;
				}
			}
			if (this.resultatEtudiantRef != null) {
				goToChoixEtapeEtudiant();
			}
			if (this.listeResultatsRechercheEtudiant != null) {
				getSessionController().setCreationConventionEtape1CurrentPage("_creerConventionEtape1ListeEtudiant");
				return "creerConventionEtape1Etudiant";
			}
		}
		return null;
	}
	/**
	 * @return String
	 */
	public String goToConventionModifEnseignant() {
		String ret = null;
		ret = "conventionEtape6ModifEnseignant";
		return ret;
	}
	/**
	 * @return String
	 */
	public String rechercheEnseignantCrea() {
		this.listeResultatsRechercheEnseignant = null;
		this.resultatEnseignant = null;
		String nomForm = "formConvention";
		rechercheEnseignant(nomForm);
		if (this.resultatEnseignant != null) {
			goToCreerConventionEtape6Enseignant();
		}
		if (this.listeResultatsRechercheEnseignant != null) {
			getSessionController().setCreationConventionEtape6CurrentPage("_creerConventionEtape6ListeEnseignant");
		}
		if (getSessionController().getCreationConventionEtape6CurrentPage().equals("_creerConventionEtape6RechEnseignant")){
			return null;
		} else {
			return "creerConventionEtape6Enseignant";
		}
	}
	/**
	 * @return A String
	 */
	public String rechercheEnseignantModif() {
		this.listeResultatsRechercheEnseignant = null;
		this.resultatEnseignant = null;
		String retour = null;
		String nomForm = "formSelConvention";
		rechercheEnseignant(nomForm);
		if (this.resultatEnseignant != null) {
			retour = goToConventionEtape6ValidEnseignant();
		}
		if (this.listeResultatsRechercheEnseignant != null) {
			retour = goToConventionEtape6listeEnseignant();
		}
		return retour;
	}

	/**
	 * 
	 */
	public void rechercheEnseignantAvenant() {
		String nomForm = "formRechEnseignant";

		this.resultatEnseignant = new EnseignantDTO();
		this.listeEnseignant = new ArrayList<EnseignantDTO>();
		this.listeResultatsRechercheEnseignant = new ArrayList<EnseignantDTO>();
		rechercheEnseignant(nomForm);
	}
	/**
	 * @return A String
	 */
	public String goToEnseignantValid() {
		String retour = null;
		ConventionDTO conventionTmp =  this.convention;
		// creation enseignant
		EnseignantDTO enseignantTmp = this.convention.getEnseignant();
		if (logger.isDebugEnabled()) {
			logger.debug("goToEnseignantValid "); 
			if (this.convention.getEnseignant() != null) { 
				logger.debug("this.convention.getEnseignant() " + this.convention.getEnseignant().getUidEnseignant());
			}
		}
		try {
			// verification enseignant
			EnseignantDTO enseignantExist = this.getEnseignantDomainService().getEnseignantFromUid(enseignantTmp.getUidEnseignant(), enseignantTmp.getCodeUniversite());
			if (enseignantExist == null) {
				enseignantTmp.setLoginCreation(getSessionController().getCurrentLogin());
				// verification affectation
				AffectationDTO affectationEnseignant = null;
				// pour traiter le cas ou l'enseignant n'a pas l'affectation
				if (this.convention.getEnseignant().getAffectation() != null)
					affectationEnseignant = getNomenclatureDomainService().getAffectationFromCode(this.convention.getEnseignant().getAffectation().getCode(),getSessionController().getCodeUniversite());
				// on ne crée pas l'affectation null ou l'affectation avec le code null
				if (affectationEnseignant == null && this.convention.getEnseignant().getAffectation() != null && this.convention.getEnseignant().getAffectation().getCode() != null) {
					this.convention.getEnseignant().getAffectation().setCodeUniversite(getSessionController().getCodeUniversite());
					int idAffectationEnseignant = getPersonnelCentreGestionDomainService().addAffectation(this.convention.getEnseignant().getAffectation());
					if (logger.isInfoEnabled()) logger.info("Ajout affectation : " + idAffectationEnseignant);
				}

				enseignantTmp.setCodeUniversiteAffectation(getSessionController().getCodeUniversite());

				int idEnseignant = this.getEnseignantDomainService().addEnseignant(enseignantTmp); 
				if (idEnseignant > 0) {
					if (logger.isInfoEnabled())logger.info("Ajout enseignant : "+ this.convention.getEnseignant().getUidEnseignant());
					conventionTmp.setIdEnseignant(idEnseignant);
				}
			} else {

				if (enseignantTmp.getCodeAffectation() == null || enseignantTmp.getCodeAffectation().isEmpty())
					enseignantTmp.setCodeAffectation("");

				enseignantTmp.setCodeUniversiteAffectation(getSessionController().getCodeUniversite());
				enseignantTmp.setId(enseignantExist.getId());
				enseignantTmp.setLoginModif(getSessionController().getCurrentLogin());
				getEnseignantDomainService().updateEnseignant(enseignantTmp);
				conventionTmp.setIdEnseignant(enseignantExist.getId());
			}

		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ENSEIGNANT.ERREUR", we.getMessage());
		}
		// update convention
		conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				this.alerteMailModifConvention(" l'enseignant référent ");
				retour = SequenceEtapeEnumSel.etape6.actionEtape();
				addInfoMessage(null, "CONVENTION.CREERCONVENTION.CONFIRMATION");
			} 
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}
		return retour;
	}

	/**
	 * rechercheEnseignant.
	 * @param nomForm 
	 */
	public void rechercheEnseignant(final String nomForm) {
		boolean NomPrenomEnseigOK=true;
		if ((!StringUtils.hasText(this.rechNomEnseignant)) && (!StringUtils.hasText(this.rechPrenomEnseignant))) {
			addErrorMessage(nomForm + ":nom", "RECHERCHEENSEIGNANT.OBLIGATOIRE");
			NomPrenomEnseigOK = false;
		}
		if (NomPrenomEnseigOK) {
			if (logger.isDebugEnabled()) {
				logger.debug("rechercheEnseignant ");
				if (StringUtils.hasText(selCodeAffectationEnseignant)) {
					logger.debug("selCodeAffectationEnseignant " + selCodeAffectationEnseignant);
				}
			}
			String codeAffec = null;
			if (StringUtils.hasText(selCodeAffectationEnseignant)) { 
				codeAffec = selCodeAffectationEnseignant;
			}
			this.listeResultatsRechercheEnseignant = getPersonalDataRepositoryDomain().getEnseignantsByName(getSessionController().getCodeUniversite(), this.rechNomEnseignant, this.rechPrenomEnseignant, codeAffec );

			if (this.listeResultatsRechercheEnseignant==null || this.listeResultatsRechercheEnseignant.isEmpty()) {
				addErrorMessage(nomForm + ":information", "RECHERCHEENSEIGNANT.INVALIDE");
			}
			checkListeResultatsEnseigant();
		}
	}

	/**
	 * @return String
	 */
	public String goToConventionVerification() {
		String retour = null;
		this.convention.setValidationPedagogique(true);
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
		conventionTmp.setDateModif(new Date());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				// Envoi de mail - Verification de la propriete et de l'activation ou non de la validation pedagogique (pas d'envoi si ce n'est pas le cas)
				if (getSessionController().isAvertissementEtudiantConvention() && (getSessionController().isValidationPedagogique()
						&& this.convention.getCentreGestion().isValidationPedagogique())){
					String text=getString("ALERTES_MAIL.AVERTISSEMENT_ETUDIANTS_CONVENTION",
							this.convention.getIdConvention(),
							getSessionController().getCurrentUser().getDisplayName());
					String sujet=getString("ALERTES_MAIL.AVERTISSEMENT_ETUDIANTS_CONVENTION.SUJET",
							this.convention.getIdConvention());
					String mail = this.convention.getEtudiant().getMail();
					if (this.convention.getCourrielPersoEtudiant() != null && !this.convention.getCourrielPersoEtudiant().isEmpty()){
						mail = this.convention.getCourrielPersoEtudiant();
					}
					getSmtpService().send(new InternetAddress(mail),
							sujet,text,text);
				}
				retour = SequenceEtapeEnumSel.etape10.actionEtape();
				addInfoMessage("formSelConvention:erreurConventionVerification", "CONVENTION.VALIDER.CONFIRMATION", this.convention.getIdConvention());
			}
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage("formSelConvention:erreurConventionVerification", "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage("formSelConvention:erreurConventionVerification", "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		} catch (AddressException ade){
			logger.error("AddressException ", ade.fillInStackTrace());
			addErrorMessage("formSelConvention:erreurConventionValidation", "GENERAL.ERREUR_MAIL", ade.getMessage());
		}
		return retour;
	}
	/**
	 * @return String
	 */
	public String goToConventionUnVerification() {
		String retour = null;
		this.convention.setValidationPedagogique(false);
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
		conventionTmp.setDateModif(new Date());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				retour = SequenceEtapeEnumSel.etape10.actionEtape();
				addInfoMessage("formSelConvention:erreurConventionVerification", "CONVENTION.VALIDATION_PEDAGOGIQUE.CONFIRMATION_UNVERIF", this.convention.getIdConvention());
			} 
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage("formSelConvention:erreurConventionVerification", "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage("formSelConvention:erreurConventionVerification", "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}
		return retour;
	}


	/**
	 * @return String
	 */
	public String goToConventionValidation() {
		String retour = null;
		this.convention.setValidationConvention(true);
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginValidation(getSessionController().getCurrentLogin());
		conventionTmp.setDateValidation(new Date());
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				// Envoi de mail - Verification de la propriete et de l'activation ou non de la validation pedagogique (pas d'envoi si c'est le cas)
				if (getSessionController().isAvertissementEtudiantConvention() && (!getSessionController().isValidationPedagogique() 
						|| (getSessionController().isValidationPedagogique() && !this.convention.getCentreGestion().isValidationPedagogique()))){
					String text=getString("ALERTES_MAIL.AVERTISSEMENT_ETUDIANTS_CONVENTION",
							this.convention.getIdConvention(),
							getSessionController().getCurrentUser().getDisplayName());
					String sujet=getString("ALERTES_MAIL.AVERTISSEMENT_ETUDIANTS_CONVENTION.SUJET",
							this.convention.getIdConvention());
					String mail = this.convention.getEtudiant().getMail();
					if (this.convention.getCourrielPersoEtudiant() != null && !this.convention.getCourrielPersoEtudiant().isEmpty()){
						mail = this.convention.getCourrielPersoEtudiant();
					}
					getSmtpService().send(new InternetAddress(mail),
							sujet,text,text);
				}
				retour = SequenceEtapeEnumSel.etape10.actionEtape();
				addInfoMessage(null, "CONVENTION.VALIDER.CONFIRMATION", this.convention.getIdConvention());
			}
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage("formSelConvention:erreurConventionValidation", "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage("formSelConvention:erreurConventionValidation", "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		} catch (AddressException ade){
			logger.error("AddressException ", ade.fillInStackTrace());
			addErrorMessage("formSelConvention:erreurConventionValidation", "GENERAL.ERREUR_MAIL", ade.getMessage());
		}
		return retour;
	}

	/**
	 * @return String
	 */
	public String goToConventionInValidation() {
		String retour = null;
		int nbAvenant = getAvenantDomainService().getNombreAvenant(this.convention.getIdConvention());
		if (nbAvenant > 0) {
			boolean presenceAvenantValide = false;
			for (AvenantDTO avenant : getAvenantDomainService().getAvenant(this.convention.getIdConvention())){
				if (avenant.isValidationAvenant()){
					presenceAvenantValide = true;
					break;
				}
			}
			if (presenceAvenantValide){
				addErrorMessage("formSelConvention:erreurConventionValidation", "CONVENTION.INVALIDER.IMPOSSIBLE");
				return null;
			}
		}
		this.convention.setValidationConvention(false);
		ConventionDTO conventionTmp = this.convention;
		conventionTmp.setLoginValidation(null);
		try {
			if (this.getConventionDomainService().updateConvention(conventionTmp)) {
				retour = SequenceEtapeEnumSel.etape10.actionEtape();
				addInfoMessage(null, "CONVENTION.INVALIDER.CONFIRMATION", this.convention.getIdConvention());
			} 
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage("formSelConvention:erreurConventionValidation", "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage("formSelConvention:erreurConventionValidation", "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}
		return retour;
	}
	/**
	 * @return String
	 */
	public String goToSuppConvention() {
		String retour = null;
		try {
			if (this.convention != null) {
				if (this.getConventionDomainService().deleteConvention(this.convention.getIdConvention())) {
					addInfoMessage(null, "CONVENTION.SUPPRESSION.CONFIRMATION", this.convention.getIdConvention());
					if(logger.isInfoEnabled()){
						logger.info(getSessionController().getCurrentLogin()+" supprime la convention "+this.convention);
					}
					if(this.resultatsRechercheConvention!=null && ((ArrayList<ConventionDTO>)this.resultatsRechercheConvention).contains(this.convention)){
						this.resultatsRechercheConvention.remove(this.convention);
					}
					this.convention = null;
					retour = "resultatsRechercheConvention";
					if (!checkListeResultats()) {
						retour = null;
					}
				} else {
					addErrorMessage(null, "CONVENTION.SUPPRESSION.ERREUR", this.convention.getIdConvention());
				}
			}

		} catch (DataDeleteException ae) {
			logger.error("DataDeleteException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.SUPPRESSION.ERREUR", this.convention.getIdConvention());
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.SUPPRESSION.ERREUR", this.convention.getIdConvention());
		}
		return retour;
	}
	/**
	 * Re-chargement du paginator. 
	 */
	private void reloadRechercheEtudiantPaginator() {
		//
	}
	/**
	 * Re-chargement du paginator. 
	 */
	private void reloadRechercheEnseignantPaginator() {
		//
	}

	/**
	 * recharge Ufr à partir de la selection etape etude.
	 * @param e 
	 */
	public void rechargeUfr() {
		if (selectedCodeEtape != null) {
			String[] tabCodes = selectedCodeEtape.split(";");
			EtapeInscription ufrEtape = rechUfrEtape(selectedCodeEtape);
			if (ufrEtape != null) {
				this.etudiantRef.setThecodeUFR(ufrEtape.getCodeComposante());
				this.etudiantRef.setTheUfr(ufrEtape.getLibComposante());
				this.etudiantRef.setTheCodeEtape(ufrEtape.getCodeEtp());
				this.etudiantRef.setTheCodeVersionEtape(ufrEtape.getCodVrsVet());
				this.etudiantRef.setTheEtape(ufrEtape.getLibWebVet());
			}
			this.choixEtape = true;
			this.listeELPEtapes = rechElpEtape(tabCodes[0]);
			if (this.listeELPEtapes != null) {
				if (this.listeELPEtapes.size() == 1) {
					this.etudiantRef.setTheCodeElp(this.listeELPEtapes.get(0).getCodElp());
					this.etudiantRef.setTheLibElp(this.listeELPEtapes.get(0).getLibElp());
					this.etudiantRef.setTheCreditECTS(this.listeELPEtapes.get(0).getNbrCrdElp());
					this.selectedCodeElp = this.listeELPEtapes.get(0).getCodElp();
				}
			}
		} else {
			this.choixEtape = false;
			addErrorMessage("formConvention:choixEtape", "FORM.CHAMP_OBLIGATOIRE");
		}
	}
	/**
	 * 
	 */
	public void rechargeElp() {
		if (this.selectedCodeElp != null) {
			if (this.etudiantRef.getListeELPs() != null && !this.etudiantRef.getListeELPs().isEmpty()) {

				List<ElementPedagogique> listeELPs = this.etudiantRef.getListeELPs();

				for (Iterator<ElementPedagogique> itelp = listeELPs.iterator(); itelp.hasNext();) {
					ElementPedagogique elpedago = itelp.next();
					if (elpedago.getCodElp().equals(selectedCodeElp)) {
						this.etudiantRef.setTheCodeElp(elpedago.getCodElp());
						this.etudiantRef.setTheLibElp(elpedago.getLibElp());
						this.etudiantRef.setTheCreditECTS(elpedago.getNbrCrdElp());
					}
				}

			}
		}
	}	

	/**
	 * @param codeEtape
	 * @return EtapeInscription
	 */
	public EtapeInscription rechUfrEtape(final String codeEtape) {
		EtapeInscription ufrEtape = null;
		String code = "";
		if (this.etudiantRef.getListeEtapeInscriptions() != null && !this.etudiantRef.getListeEtapeInscriptions().isEmpty()) {
			for (Iterator<EtapeInscription> iter = this.etudiantRef.getListeEtapeInscriptions().iterator(); iter.hasNext();) {
				EtapeInscription etpins = iter.next();

				if (etpins.getCodVrsVet()!= null && !etpins.getCodVrsVet().isEmpty()){
					code = etpins.getCodeEtp()+";"+etpins.getCodVrsVet();
				} else {
					code = etpins.getCodeEtp();
				}

				if (codeEtape.equals(code)) {
					if (etpins.getCodeComposante()!=null && !etpins.getCodeComposante().isEmpty()) {
						ufrEtape = etpins;
					}
				}

			}
		}
		return ufrEtape;
	}
	/**
	 * @param codeEtape
	 * @return List<ElementPedagogique>
	 */
	public List<ElementPedagogique> rechElpEtape(String codeEtape) {
		List<ElementPedagogique> lELPEtapes = new ArrayList<ElementPedagogique>();
		boolean trouveElp = false;
		// test si ELP existante pour cette etape
		if (this.etudiantRef.getListeELPs() != null && !this.etudiantRef.getListeELPs().isEmpty()) {
			List<ElementPedagogique> listeELPs = new ArrayList<ElementPedagogique>();
			listeELPs = this.etudiantRef.getListeELPs();
			for (Iterator<ElementPedagogique> itelp = listeELPs.iterator(); itelp.hasNext();) {
				ElementPedagogique elpedago = itelp.next();
				if (elpedago.getCodEtp().equals(codeEtape)) {
					lELPEtapes.add(elpedago);
					trouveElp = true;
				}
			}
		}
		if (!trouveElp) {
			lELPEtapes = null;
		}
		return lELPEtapes;
	}
	/**
	 *
	 * @return List <SequenceEtapeEnum>
	 */
	public List<SequenceEtapeEnum> getSequences() {
		List<SequenceEtapeEnum> result = new ArrayList<SequenceEtapeEnum>();
		for (SequenceEtapeEnum s : SequenceEtapeEnum.values()) {
			if (sequenceEtapeEnum != null 
					&& sequenceEtapeEnum.getNumEtape() > s.getNumEtape()) {
				s.setDisabled(false);
			} else {
				s.setDisabled(true);
			}
			result.add(s);
		}
		return result;
	}
	/**
	 *
	 * @return List <SequenceEtapeEnumSel>
	 */
	public List<SequenceEtapeEnumSel> getSequencesSel() {
		List<SequenceEtapeEnumSel> result = new ArrayList<SequenceEtapeEnumSel>();
		for (SequenceEtapeEnumSel s : SequenceEtapeEnumSel.values()) {
			if (sequenceEtapeEnumSel != null 
					&& sequenceEtapeEnumSel.getNumEtape() >= s.getNumEtape()) {
				s.setDisabled(false);
			} else {
				s.setDisabled(true);
			}
			result.add(s);
		}
		return result;
	}
	/**
	 * Contrôle la liste des résultats.
	 * Si un seul résultat, transfert du résultat vers "this.resultatRechercheEtudiant" 
	 * pour un affichage du détail etudiant
	 */
	private void checkListeResultatsEtudiant() {
		if ((this.listeResultatsRechercheEtudiant != null) && (!this.listeResultatsRechercheEtudiant.isEmpty())) {
			if (this.listeResultatsRechercheEtudiant.size() == 1) {
				this.resultatEtudiantRef = this.listeResultatsRechercheEtudiant.get(0);
				this.listeResultatsRechercheEtudiant = null;
				reloadRechercheEtudiantPaginator();
			} else {
				reloadRechercheEtudiantPaginator();
				this.resultatEtudiantRef = null;
			}
		} else {
			this.resultatEtudiantRef = null;
			this.listeResultatsRechercheEtudiant = null;
		}

	}
	/**
	 * Contrôle la liste des résultats.
	 * Si un seul résultat, transfert du résultat vers "this.resultatEnseigant" 
	 * pour un affichage du détail enseigant
	 */
	private void checkListeResultatsEnseigant() {
		if ((this.listeResultatsRechercheEnseignant != null) && (!this.listeResultatsRechercheEnseignant.isEmpty())) {
			if (this.listeResultatsRechercheEnseignant.size() == 1) {
				this.resultatEnseignant=this.listeResultatsRechercheEnseignant.get(0);
				if (StringUtils.hasText(resultatEnseignant.getCodeAffectation())) {
					AffectationDTO affecDTO = rechAffec(resultatEnseignant.getCodeAffectation());
					if (affecDTO != null) {
						this.resultatEnseignant.setAffectation(affecDTO);
					}
				}
				this.resultatEnseignant.setCivilite(getNomenclatureDomainService().getCiviliteFromId(this.resultatEnseignant.getIdCivilite()));
				this.listeResultatsRechercheEnseignant = null;
				reloadRechercheEnseignantPaginator();
			} else {
				// transform liste enseignant en enseignantDTO
				this.listeEnseignant = new ArrayList<EnseignantDTO>();
				for (Iterator <EnseignantDTO> iter = this.listeResultatsRechercheEnseignant.iterator(); iter.hasNext();) {
					EnseignantDTO enseignantDTO = iter.next();
					if (StringUtils.hasText(enseignantDTO.getCodeAffectation())) {
						AffectationDTO affecDTO = rechAffec(enseignantDTO.getCodeAffectation());
						if (affecDTO != null) {
							enseignantDTO.setAffectation(affecDTO);
						}
					}
					enseignantDTO.setCivilite(getNomenclatureDomainService().getCiviliteFromId(enseignantDTO.getIdCivilite()));
					this.listeEnseignant.add(enseignantDTO);
				}
				reloadRechercheEnseignantPaginator();
				this.resultatEnseignant = null;
			}
		} else {
			this.resultatEnseignant = null;
			this.listeResultatsRechercheEnseignant = null;
		}
	}

	/**
	 * @param codeAffec
	 * @return affecDTO
	 */
	public AffectationDTO rechAffec(final String codeAffec) {
		AffectationDTO affecDTO = new AffectationDTO();
		affecDTO.setCodeUniversite(getSessionController().getCodeUniversite());
		List<SelectItem> listeAffec = getListeAffectation();
		if (listeAffec != null ) {
			if (!listeAffec.isEmpty()) {
				for (Iterator<SelectItem> iter = listeAffec.iterator(); iter.hasNext();) {
					SelectItem affec = iter.next();
					if (codeAffec.equals(affec.getValue().toString())) {
						affecDTO.setCode(affec.getValue().toString());
						affecDTO.setLibelle(affec.getLabel());
					}
				}
			}
		}
		if ((codeAffec != null) && (affecDTO.getCode() == null)) {
			affecDTO.setCode(codeAffec);
			affecDTO.setLibelle(""); 
		}
		return affecDTO;
	}
	/**
	 * @return boolean isSupUneUfr
	 */
	public boolean isEtudiantSupUneUfr() {
		boolean isSupUneUfr = false;
		if (this.resultatEtudiantRef != null) {
			if (this.resultatEtudiantRef.getStudys().size() > 1) {
				isSupUneUfr = true;
			}
		}

		return isSupUneUfr;
	}
	/**
	 * @return boolean isSupUneEtape
	 */
	public boolean isEtudiantSupUneEtape() {
		boolean isSupUneEtape = false;
		if (this.resultatEtudiantRef != null) {
			List<EtapeInscription> listFiltree = new ArrayList<EtapeInscription>();
			if (this.resultatEtudiantRef.getListeEtapeInscriptions() != null && !this.resultatEtudiantRef.getListeEtapeInscriptions().isEmpty()){
				for (EtapeInscription etapeAcontroler : this.resultatEtudiantRef.getListeEtapeInscriptions()){
					listFiltree.add(etapeAcontroler);
				}
			}
			if (listFiltree != null) {
				if (listFiltree.size() > 1) {
					isSupUneEtape = true;
				}
			}
		}

		return isSupUneEtape;
	}
	/**
	 * @return boolean isEtudiantUneEtape
	 */
	public boolean isEtudiantUneEtape() {
		boolean isUneEtape = false;
		if (this.resultatEtudiantRef != null) {
			List<EtapeInscription> listFiltree = new ArrayList<EtapeInscription>();
			for (EtapeInscription etapeAcontroler : this.resultatEtudiantRef.getListeEtapeInscriptions()){
				listFiltree.add(etapeAcontroler);
			}
			if (listFiltree != null) {
				if (listFiltree.size() == 1) {
					isUneEtape = true;
				}
			}
		}

		return isUneEtape;
	}
	/**
	 * @return isEtudiantTrouves
	 */
	public boolean isEtudiantTrouves() {
		boolean isEtudiantTrouves = false;
		if (this.listeResultatsRechercheEtudiant != null) {
			if (!this.listeResultatsRechercheEtudiant.isEmpty()) {
				isEtudiantTrouves = true;
			}
		}
		return isEtudiantTrouves;
	}
	/**
	 * @return isEnseignantTrouves
	 */
	public boolean isEnseignantTrouves() {
		boolean isEnseignantTrouves = false;
		if (this.listeResultatsRechercheEnseignant != null) {
			if (!this.listeResultatsRechercheEnseignant.isEmpty()) {
				isEnseignantTrouves = true;
			}
		}
		return isEnseignantTrouves;
	}
	/**
	 * @return boolean isEtudiantSupUnElp
	 */
	public boolean isEtudiantSupUnElp() {
		boolean isSupUnElp = false;
		if (this.listeELPEtapes != null) {
			if (this.listeELPEtapes.size() > 1) {
				isSupUnElp = true;
			}
		}
		return isSupUnElp;
	}
	/**
		lELPEtapes.add(new ElementPedagogique());
	 * @return boolean isEtudiantUnElp
	 */
	public boolean isEtudiantUnElp() {
		boolean isUnElp = false;
		if (this.listeELPEtapes != null) {
			if (this.listeELPEtapes.size() == 1) {
				isUnElp = true;
			}
		}
		return isUnElp;
	}
	/**
	 * @return boolean isRetourListe
	 */
	public boolean isRetourListe() {
		boolean isRetourListe = false;
		if (this.retourAction != null) {
			if (this.retourAction.equals("resultatsRechercheConvention")) {
				isRetourListe = true;
			}
		}
		return isRetourListe;
	}
	/**
	 * @return boolean isConventionValide
	 */
	public boolean isConventionValide() {
		boolean isConventionValide = false;
		if (this.convention != null) {
			if (this.convention.isValidationConvention()) {
				isConventionValide = true;
			} else if (getSessionController().isValidationPedagogique()
					&& this.convention.getCentreGestion().isValidationPedagogique()
					&& this.convention.isValidationPedagogique()
					&& getSessionController().getCurrentAuthEtudiant() != null){
				isConventionValide = true;
			}
		}
		return isConventionValide;
	}

	/**
	 * @return boolean isCGUrlInstruction
	 */
	public boolean isCgUrlInstruction() {
		boolean isCgUrlInstruction = false;
		if (this.convention != null) {
			if (this.convention.getCentreGestion() != null) {
				if (this.convention.getCentreGestion().getUrlPageInstruction() != null) {
					if (!this.convention.getCentreGestion().getUrlPageInstruction().isEmpty()) {
						isCgUrlInstruction = true;
					}
				}
			}
		}

		return isCgUrlInstruction;
	}

	/**
	 * @return isSaisieTuteurProParEtudiant
	 */
	public boolean isSaisieTuteurProParEtudiant() {
		boolean isSaisieTuteurProParEtudiant = true;
		if (this.getSessionController().getCurrentAuthEtudiant() != null) {
			if (this.convention != null) {
				if (!this.convention.getCentreGestion().getSaisieTuteurProParEtudiant()) {
					isSaisieTuteurProParEtudiant = false;
				}
			}
		}
		return isSaisieTuteurProParEtudiant;
	}
	/**
	 * @return List <SelectItem>
	 */
	public List<SelectItem> getNbJoursHebdoItems() {
		List<SelectItem> l = new ArrayList<SelectItem>();
		l.add(new SelectItem(JoursHebdo.jours6.getValeur(), JoursHebdo.jours6.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours5_5.getValeur(), JoursHebdo.jours5_5.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours5.getValeur(), JoursHebdo.jours5.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours4_5.getValeur(), JoursHebdo.jours4_5.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours4.getValeur(), JoursHebdo.jours4.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours3_5.getValeur(), JoursHebdo.jours3_5.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours3.getValeur(), JoursHebdo.jours3.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours2_5.getValeur(), JoursHebdo.jours2_5.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours2.getValeur(), JoursHebdo.jours2.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours1_5.getValeur(), JoursHebdo.jours1_5.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours1.getValeur(), JoursHebdo.jours1.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours0_5.getValeur(), JoursHebdo.jours0_5.getLibelle()));
		return l;
	}
	/**
	 * Mini recherche du numéro d'offre.
	 * @param suggest
	 * @return List<OffreDTO>
	 */
	public List<OffreDTO> suggestOffre(String suggest) {
		String intitule = suggest;
		List<OffreDTO> result = new ArrayList<OffreDTO>();
		if (intitule.length() >= 5) {
			CritereRechercheOffreDTO cro = new CritereRechercheOffreDTO();
			cro.setIdsCentreGestion(getSessionController().getCurrentIdsCentresGestion());
			cro.setEstDiffusee(true);
			cro.setEstSupprimee(false);
			cro.setDiffusionTerminee(false);
			cro.setEstAccessERQTH(false);
			cro.setEstPrioERQTH(false);
			cro.setIntitule(intitule);
			result = getOffreDomainService().getOffresFromCriteres(cro);
			if (result == null) result = new ArrayList<OffreDTO>();
		}
		return result;
	}

	/**
	 * Vers moteur de recherche Conventions
	 * @return String
	 */
	public String goToRechercheConvention() {
		String ret = "rechercheConvention";
		this.conventionCree = false;
		//		this.critereRechercheConvention=new CritereRechercheConventionDTO();
		this.critereRechercheConvention= initCritereRechercheConvention();
		return ret;
	}
	/**
	 * Vers moteur de recherche Conventions.
	 * @return String
	 */
	public String goToRechercheConventionEtu() {
		String ret = "resultatsRechercheConvention";
		this.conventionCree = false;
		this.resultatsRechercheConvention = new ArrayList<ConventionDTO>();
		if (this.getSessionController().getCurrentAuthEtudiant() != null) {
			this.resultatsRechercheConvention = getConventionDomainService().getConventionsEtudiant(this.getSessionController().getCurrentAuthEtudiant().getIdentEtudiant(),getSessionController().getCodeUniversite());
		}
		if (!checkListeResultats()) {
			this.rechercheConventionPaginator.reset();
		}
		return ret;
	}

	/**
	 * Vers moteur de recherche Conventions.
	 * @return String
	 */
	public String goToRechercheConventionEnseignantTuteur() {
		String ret = "resultatsRechercheConvention";
		this.conventionCree = false;
		this.rechercheConventionPaginator = new RechercheConventionPaginator();
		this.resultatsRechercheConvention = new ArrayList<ConventionDTO>();
		if (this.getSessionController().getCurrentAuthEnseignant() != null) {
			if (this.getSessionController().getCurrentAuthEnseignant().getUidEnseignant() != null) {
				EnseignantDTO tmpEns = getEnseignantDomainService().getEnseignantFromUid(this.getSessionController().getCurrentAuthEnseignant().getUidEnseignant(),
						getSessionController().getCodeUniversite());
				if (tmpEns != null) {
					this.resultatsRechercheConvention = getConventionDomainService().getConventionsByEnseignant(tmpEns.getId(),getBeanUtils().getAnneeUniversitaireCourante(new Date()));
					if (this.resultatsRechercheConvention != null && !this.resultatsRechercheConvention.isEmpty()) {
						for (ConventionDTO convention : resultatsRechercheConvention){
							convention.setCentreGestion(getCentreGestionDomainService().getCentreGestion(convention.getIdCentreGestion()));
						}
						//renseignement de la liste de resultats en vue d'export
						this.exportController.setResultatsRechercheConvention(resultatsRechercheConvention);
					}
				}

			}
		}
		if (!checkListeResultats()) {
			this.rechercheConventionPaginator.reset();
		}
		return ret;
	}
	/**
	 * Recherche des Conventions.
	 * @return String
	 */
	public String rechercherConvention() {
		String ret = "resultatsRechercheConvention";
		this.conventionCree = false;

		if (this.critereRechercheConvention.getNomEnseignant() == "")
			this.critereRechercheConvention.setNomEnseignant(null);
		if(this.critereRechercheConvention.getPrenomEnseignant() == "")
			this.critereRechercheConvention.setPrenomEnseignant(null);

		this.critereRechercheConvention.setIdsCentreGestion(getSessionController().getCurrentIdsCentresGestion());
		if (StringUtils.hasText(this.rechTypeOuStatut)) {
			if (this.rechTypeOuStatut.contains("t")) {
				if (Utils.isNumber(this.rechTypeOuStatut.substring(1))) {
					this.critereRechercheConvention.setTypeStructure(getNomenclatureDomainService().getTypeStructureFromId(
							Utils.convertStringToInt(this.rechTypeOuStatut.substring(1))));
					this.critereRechercheConvention.setStatutJuridique(null);
				}
			}
			if (this.rechTypeOuStatut.contains("s")) {
				if (Utils.isNumber(this.rechTypeOuStatut.substring(1))) {
					this.critereRechercheConvention.setStatutJuridique(getNomenclatureDomainService().getStatutJuridiqueFromId(
							Utils.convertStringToInt(this.rechTypeOuStatut.substring(1))));
					if (this.critereRechercheConvention.getStatutJuridique() != null 
							&& this.critereRechercheConvention.getStatutJuridique().getIdParent() > 0) {
						this.critereRechercheConvention.setTypeStructure(getNomenclatureDomainService().getTypeStructureFromId(
								this.critereRechercheConvention.getStatutJuridique().getIdParent()));
					}
				}
			}
		} else {
			this.critereRechercheConvention.setTypeStructure(null);
			this.critereRechercheConvention.setStatutJuridique(null);
		}
		if (!StringUtils.hasText(this.estValidee)) this.critereRechercheConvention.setEstValidee(null);
		else if(this.estValidee.equals("1")) this.critereRechercheConvention.setEstValidee(true);
		else if(this.estValidee.equals("2")) this.critereRechercheConvention.setEstValidee(false);

		if (!StringUtils.hasText(this.estVerifiee))	this.critereRechercheConvention.setEstVerifiee(null);
		else if(this.estVerifiee.equals("1")) this.critereRechercheConvention.setEstVerifiee(true);
		else if(this.estVerifiee.equals("2")) this.critereRechercheConvention.setEstVerifiee(false);

		if (this.estEtrangere) this.critereRechercheConvention.setEstEtrangere(true);
		else this.critereRechercheConvention.setEstEtrangere(false);

		//this.critereRechercheConvention.setLimit(true);
		//		this.critereRechercheConvention.setNbRechercheMaxi(Integer.toString(DonneesStatic.nb_recherche_maxi));
		this.critereRechercheConvention.setNbRechercheMaxi(this.critereRechercheConvention.getNbRechercheMaxi());
		// si enseignant référent, recherche des conventions pour les enseignants tuteur
		if (getSessionController().isEnseignantTuteur()) {
			if (this.getSessionController().getCurrentAuthEnseignant().getUidEnseignant() != null) {
				EnseignantDTO tmpEns = getEnseignantDomainService().getEnseignantFromUid(this.getSessionController().getCurrentAuthEnseignant().getUidEnseignant(),
						getSessionController().getCodeUniversite());
				if (tmpEns != null) {
					this.resultatsRechercheConvention = getConventionDomainService().getConventionsFromCriteresByEnseignantTuteur(tmpEns.getId(),this.critereRechercheConvention);
				}
			}
			if (this.resultatsRechercheConvention == null)
				this.resultatsRechercheConvention = new ArrayList<ConventionDTO>();

			// recherche aussi avec critere CG
			if (this.critereRechercheConvention.getIdsCentreGestion() != null) {
				List<ConventionDTO> resultatsRechercheConventionCG = getConventionDomainService().getConventionsFromCriteres(this.critereRechercheConvention);
				if (resultatsRechercheConventionCG != null && !resultatsRechercheConventionCG.isEmpty()) {
					for (Iterator<ConventionDTO> itercg = resultatsRechercheConventionCG.iterator(); itercg.hasNext();) {
						ConventionDTO conventionDTO = itercg.next();
						if (!this.resultatsRechercheConvention.contains(conventionDTO)) {
							this.resultatsRechercheConvention.add(conventionDTO);
						}
					}
					Collections.sort(this.resultatsRechercheConvention, new Comparator<ConventionDTO>(){
						/**
						 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
						 */
						@Override
						public int compare(ConventionDTO l1, ConventionDTO l2) {
							return l1.getIdConvention().compareTo(l2.getIdConvention());
						}
					});
				}
			}
		}else {
			this.resultatsRechercheConvention = getConventionDomainService().getConventionsFromCriteres(this.critereRechercheConvention);
		}

		if (!checkListeResultats()) {
			ret = null;
		}
		return ret;
	}
	/**
	 * Passage du moteur simple a avance et vice-versa.
	 */
	public void rechercheSimpleAvancee() {
		if (this.rechercheAvancee)this.rechercheAvancee = false;
		else this.rechercheAvancee = true;
		this.conventionCree = false;
		resetRechercheConvention();
	}
	/**
	 * Reset des criteres de recherche d'offres.
	 */
	public void resetRechercheConvention() {
		//		critereRechercheConvention = new CritereRechercheConventionDTO();
		critereRechercheConvention = initCritereRechercheConvention();

		this.critereRechercheConvention.setIdsCentreGestion(getSessionController().getCurrentIdsCentresGestion());
		this.rechTypeOuStatut = null;
	}
	/**
	 * Re-chargement du paginator. 
	 */
	public void reloadRechercheConventionPaginator() {
		this.rechercheConventionPaginator.reset();
		this.rechercheConventionPaginator.setListe(this.resultatsRechercheConvention);
		this.rechercheConventionPaginator.forceReload();
	}
	/**
	 * Contrôle la liste des résultats.
	 * @return boolean : vrai si resultats
	 */
	private boolean checkListeResultats() {
		boolean ret = true;
		if(this.resultatsRechercheConvention == null || this.resultatsRechercheConvention.isEmpty()) {
			this.resultatsRechercheConvention = null;
			ret = false;
			addInfoMessage("formRechConvention", "RECHERCHECONVENTION.AUCUNRESULTAT");
		} else if (this.resultatsRechercheConvention != null && !this.resultatsRechercheConvention.isEmpty()) {
			reloadRechercheConventionPaginator();
		}
		return ret;
	}
	/**
	 * @param dateDebutStage
	 * @param dateFinStage
	 * @return anneeUniversitaire
	 */
	public String anneeUniv(Date dateDebutStage, Date dateFinStage){
		// annee universitaire
		String anneeUniversitaire = null;
		Calendar debutStage = Calendar.getInstance();
		debutStage.setTime(dateDebutStage);
		int year = debutStage.get(Calendar.YEAR);
		Calendar debutAnnee = Calendar.getInstance();
		debutAnnee.set(year, Integer.parseInt(startYearMonth) - 1, Integer
				.parseInt(startYearDay), 0, 0, 0);
		// pas de millisecond (sinon c sera toujours avant debut annee, meme
		// s'il s'agit du meme jour)
		debutAnnee.clear(Calendar.MILLISECOND);
		//si debut stage dans le mois precedent la date de dubut d'annee et si choice.year=true dans le fichier de config
		Calendar debutAnneeMinusAMonth = (Calendar) debutAnnee.clone();
		debutAnneeMinusAMonth.add(Calendar.MONTH, -1);
		// mois suivant la date de debut d'annee 
		Calendar debutAnneePlusAMonth = (Calendar) debutAnnee.clone();
		debutAnneePlusAMonth.add(Calendar.MONTH, 1);
		//la date de debut de stage peut etre calculee automatiquement
		if (debutStage.before(debutAnnee)) {
			if (logger.isDebugEnabled()) {
				logger.debug("AnneeUniversitaire  debut stage avant debut annee universitaire");
			}
			// si le debut du stage a lieu avant date debut d'une nouvelle annee
			// universitaire
			// annee universitaire = annee debut -1/ annee debut
			anneeUniversitaire = ((year - 1) + "/" + year);
		} else {
			if (debutStage.after(debutAnnee)) { // si le debut du stage a lieu
				// apres ou meme jour
				// annee universitaire = annee debut/ annee debut+1
				if (logger.isDebugEnabled()){
					logger.debug("AnneeUniversitaire  debut stage apres fin annee universitaire");
				}
				anneeUniversitaire = (year + "/" + (year + 1));
			} 
			else { // meme date
				anneeUniversitaire =(year + "/" + (year + 1));
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("AnneeUniversitaire : " + anneeUniversitaire);
		}
		return anneeUniversitaire;
	}

	/**
	 * @return isChoixAnneeUniv
	 */
	public boolean isChoixAnneeUniv() {
		boolean isChoixAnneeUniv = false;
		// annee universitaire
		Calendar debutStage = Calendar.getInstance();
		if (this.convention != null) {
			if (this.convention.getDateDebutStage() != null) {
				debutStage.setTime(this.convention.getDateDebutStage());
				int year = debutStage.get(Calendar.YEAR);
				Calendar debutAnnee = Calendar.getInstance();
				debutAnnee.set(year, Integer.parseInt(startYearMonth) - 1, Integer.parseInt(startYearDay), 0, 0, 0);
				// pas de millisecond (sinon c sera toujours avant debut annee, meme
				// s'il s'agit du meme jour)
				debutAnnee.clear(Calendar.MILLISECOND);
				if (logger.isDebugEnabled()){
					logger.debug("debut annee universitaire = " + debutAnnee.getTime());
					logger.debug("debut debut stage = " + debutStage.getTime());
					logger.debug("getChoixAnneeAvantDebutAnnee() = " + this.convention.getCentreGestion().getChoixAnneeAvantDebutAnnee());
					logger.debug("getChoixAnneeApresDebutAnnee() = " + this.convention.getCentreGestion().getChoixAnneeApresDebutAnnee());
				}
				//si debut stage dans le mois precedent la date de dubut d'annee et si choice.year=true dans le fichier de config
				Calendar debutAnneeMinusAMonth = (Calendar) debutAnnee.clone();
				debutAnneeMinusAMonth.add(Calendar.MONTH, -1);
				// mois suivant la date de debut d'annee 
				Calendar debutAnneePlusAMonth = (Calendar) debutAnnee.clone();
				debutAnneePlusAMonth.add(Calendar.MONTH, 1);
				if (logger.isDebugEnabled()){
					logger.debug("debutAnneeMinusAMonth = " + debutAnneeMinusAMonth.getTime());
					logger.debug("debutAnneePlusAMonth = " + debutAnneePlusAMonth.getTime());
				}
				//si debut stage dans le mois precedent la date de debut d'annee 
				//et si ChoixAnneeAvantDebutAnnee=true dans le centre de gestion
				//on doit pouvoir choisir l'annee universitaire
				if (debutStage.before(debutAnnee) && debutStage.after(debutAnneeMinusAMonth) 
						&& this.convention.getCentreGestion().getChoixAnneeAvantDebutAnnee() ){
					if (logger.isDebugEnabled()){
						logger.debug("on doit choisir l'annee universitaire ChoixAnneeAvantDebutAnnee");
					}
					isChoixAnneeUniv = true;
				}
				else{
					//si debut stage dans le mois suivant la date de debut d'annee 
					//et si ChoixAnneeApresDebutAnnee=true dans le  centre de gestion
					//on doit pouvoir choisir l'annee universitaire
					if (debutStage.after(debutAnnee) && debutStage.before(debutAnneePlusAMonth) 
							&& this.convention.getCentreGestion().getChoixAnneeApresDebutAnnee() ){
						if (logger.isDebugEnabled()){
							logger.debug("on doit choisir l'annee universitaire ChoixAnneeApresDebutAnnee");
						}
						isChoixAnneeUniv = true;	
					}
				}
				//si debut stage = a la date de debut d'annee 
				//et si ChoixAnneeAvantDebutAnnee=true ou ChoixAnneeApresDebutAnnee=true dans le centre de gestion
				//on doit pouvoir choisir l'annee universitaire
				if (debutStage.equals(debutAnnee) && (this.convention.getCentreGestion().getChoixAnneeAvantDebutAnnee()
						|| this.convention.getCentreGestion().getChoixAnneeApresDebutAnnee())){
					isChoixAnneeUniv = true;
				}

				// Inserer verif date debut -> date fin < 6 mois
				if (this.convention.getDateFinStage() != null){
					long dateDebStageLong = this.convention.getDateDebutStage().getTime();
					long dateFinStageLong = this.convention.getDateFinStage().getTime();

					if (dateFinStageLong >= dateDebStageLong) {

						long dureeLong = dateFinStageLong - dateDebStageLong;

						long sixMois = 15721200000L;

						if (dureeLong >= sixMois){
							addWarnMessage("formConvention:choixAnneeUniv", "CONVENTION.CREERCONVENTION.DUREEMAX");
						}
					}
				}
			}
		}
		return isChoixAnneeUniv;
	}

	/**
	 * @return nbAvenant
	 */
	public int getNbAvenant(){
		int nbAvenant = 0;
		if (this.convention != null && this.convention.getIdConvention() != null) {
			nbAvenant = getAvenantDomainService().getNombreAvenant(this.convention.getIdConvention());
		}
		return nbAvenant;
	}

	/**
	 * @return String
	 */
	public String goToValiderEnMasse() {
		if(logger.isDebugEnabled()){
			logger.debug("public String goToValiderEnMasse()");
		}
		//		this.critereRechercheConvention=new CritereRechercheConventionDTO();
		//		this.critereRechercheConvention = initCritereRechercheConvention();
		this.ongletTuteur();
		this.critereRechercheConvention.setNbExportMaxi("");
		return "rechercheMasseConvention";
	}

	/**
	 * @return String
	 */
	public String validerEnMasse() {
		if(logger.isDebugEnabled()){
			logger.debug("public String validerEnMasse()");
		}
		try {

			ConventionDTO conventionTmp = new ConventionDTO();

			for (int i=0;i<this.rechercheConventionPaginator.getListe().size();i++){

				conventionTmp=this.rechercheConventionPaginator.getListe().get(i);

				if (conventionTmp.isSelected()){

					conventionTmp = getConventionDomainService().getConventionFromId(conventionTmp.getIdConvention());						
					conventionTmp.setValidationConvention(true);
					conventionTmp.setLoginValidation(getSessionController().getCurrentLogin());
					conventionTmp.setDateValidation(new Date());
					if (!this.getConventionDomainService().updateConvention(conventionTmp)){
						addErrorMessage(null,"CONVENTION.VALIDATION_EN_MASSE.ERREUR", conventionTmp.getIdConvention());
						return null;
					} else {
						if (getSessionController().isAvertissementEtudiantConvention()){
							String text=getString("ALERTES_MAIL.AVERTISSEMENT_ETUDIANTS_CONVENTION",
									conventionTmp.getIdConvention(),
									getSessionController().getCurrentUser().getDisplayName());
							String sujet=getString("ALERTES_MAIL.AVERTISSEMENT_ETUDIANTS_CONVENTION.SUJET",
									conventionTmp.getIdConvention());
							getSmtpService().send(new InternetAddress(getEtudiantDomainService().getEtudiantFromId(conventionTmp.getIdEtudiant()).getMail()),
									sujet,text,text);
						}
					}
					this.rechercheConventionPaginator.getListe().remove(i);
					i--;
				}

			}
		} 
		catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage("formResultConventions:messageResultat", "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} 
		catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage("formResultConventions:messageResultat", "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		} 
		catch (AddressException ade){
			logger.error("AddressException", ade.fillInStackTrace());
			addErrorMessage(null, "GENERAL.ERREUR_MAIL");
		}
		catch (Exception e) {
			logger.error("Exception ", e.fillInStackTrace());
			addErrorMessage("formResultConventions:messageResultat", "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", e.getMessage());
		}
		addInfoMessage("formResultConventions:messageResultat", "CONVENTION.VALIDATION_EN_MASSE.CONFIRMATION");
		this.reloadRechercheConventionPaginator();
		return null;

	}

	/**
	 * Recherche de conventions en masse par tuteur pedagogique
	 */
	public void ongletTuteur(){
		//		this.critereRechercheConvention = new CritereRechercheConventionDTO();
		this.critereRechercheConvention = initCritereRechercheConvention();
		this.ongletCourant = 1;
	}
	/**
	 * Recherche de conventions en masse par Ufr
	 */
	public void ongletUfr(){
		//		this.critereRechercheConvention = new CritereRechercheConventionDTO();
		this.critereRechercheConvention = initCritereRechercheConvention();
		this.ongletCourant = 2;
	}
	/**
	 * Recherche de conventions en masse par Etape
	 */
	public void ongletEtape(){
		//		this.critereRechercheConvention = new CritereRechercheConventionDTO();
		this.critereRechercheConvention = initCritereRechercheConvention();
		this.ongletCourant = 3;
	}

	/**
	 * @return String
	 */
	public String rechercherMasseConvention() {
		String ret = "resultatMasseConvention";
		this.conventionCree = false;
		this.critereRechercheConvention.setEstValidee(false);

		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		this.critereRechercheConvention.setAnneeUniversitaire(year);
		this.critereRechercheConvention.setTypeStructure(null);
		this.critereRechercheConvention.setStatutJuridique(null);
		//this.critereRechercheConvention.setLimit(true);
		this.critereRechercheConvention.setNbRechercheMaxi(Integer.toString(DonneesStatic.nb_recherche_maxi));

		if (this.estEtrangere) this.critereRechercheConvention.setEstEtrangere(true);
		else this.critereRechercheConvention.setEstEtrangere(false);

		if (getSessionController().isValidationPedagogique()){
			// Listes des ids des centres de gestion avec ou sans validation pédagogique
			List<Integer> idsCentresSansVP = new ArrayList<Integer>();
			List<Integer> idsCentresAvecVP = new ArrayList<Integer>();
			for (int idCg : getSessionController().getCurrentIdsCentresGestion()){
				if (getCentreGestionDomainService().getCentreGestion(idCg).isValidationPedagogique()){
					idsCentresAvecVP.add(idCg);
				} else {
					idsCentresSansVP.add(idCg);
				}
			}
			// Premiere recherche pour les centres avec Validation pedago, et donc avec le critere de recherche Correspondant
			this.critereRechercheConvention.setEstVerifiee(true);
			this.critereRechercheConvention.setIdsCentreGestion(idsCentresAvecVP);

			this.resultatsRechercheConvention = getConventionDomainService().getConventionsFromCriteres(this.critereRechercheConvention);
			if (this.resultatsRechercheConvention == null){
				this.resultatsRechercheConvention = new ArrayList<ConventionDTO>();
			}

			// Deuxieme recherche pour les autres centre
			this.critereRechercheConvention.setEstVerifiee(null);
			this.critereRechercheConvention.setIdsCentreGestion(idsCentresSansVP);

			List<ConventionDTO> listeSansVP = getConventionDomainService().getConventionsFromCriteres(this.critereRechercheConvention);
			if (listeSansVP!= null){
				this.resultatsRechercheConvention.addAll(getConventionDomainService().getConventionsFromCriteres(this.critereRechercheConvention));
			}
		} else {
			this.critereRechercheConvention.setIdsCentreGestion(getSessionController().getCurrentIdsCentresGestion());

			this.resultatsRechercheConvention = getConventionDomainService().getConventionsFromCriteres(this.critereRechercheConvention);
		}
		if (!checkListeResultats()) {
			ret = null;
		}
		return ret;
	}

	public void ajouterCommentaireStage(){
		if(logger.isDebugEnabled()){
			logger.debug("public String ajouterCommentaireStage()");
		}
		try {
			ConventionDTO conventionTmp = new ConventionDTO();

			conventionTmp = getConventionDomainService().getConventionFromId(this.convention.getIdConvention());
			conventionTmp.setLoginModif(getSessionController().getCurrentLogin());
			conventionTmp.setDateValidation(new Date());
			conventionTmp.setCommentaireStage(this.convention.getCommentaireStage());
			if (!this.getConventionDomainService().updateConvention(conventionTmp)){
				addErrorMessage("formCommentaire","CONVENTION.CREERCONVENTION.ERREURAJOUT", conventionTmp.getIdConvention());
			} else {
				addInfoMessage("formCommentaire", "CONVENTION.VALIDATION_COMMENTAIRE");
			}
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage("formCommentaire", "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage("formCommentaire", "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		} catch (Exception e) {
			logger.error("Exception ", e.fillInStackTrace());
			addErrorMessage("formCommentaire", "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", e.getMessage());
		}
	}

	public void alerteMailModifConvention(String modif){
		try {
			// Si c'est un étudiant qui modifie la convention et qu'on est configurés en alertes mail pour les tuteurs et gestionnaires
			if (getSessionController().getCurrentAuthEtudiant() != null && getSessionController().isAvertissementPersonnelModifConvention()){
				String text=getString("ALERTES_MAIL.AVERTISSEMENT_PERSONNEL_MODIF_CONVENTION",
						getSessionController().getCurrentUser().getDisplayName(),
						modif,
						this.convention.getIdConvention());

				String libelleEtape = "";
				if (this.convention.getEtape() != null
						&& !this.convention.getEtape().getLibelle().isEmpty()){
					libelleEtape = this.convention.getEtape().getLibelle();
				}
				String sujet=getString("ALERTES_MAIL.AVERTISSEMENT_PERSONNEL_MODIF_CONVENTION.SUJET",
						libelleEtape,
						this.convention.getIdConvention());

				// Envoi d'une alerte à l'enseignant référent s'il est renseigné dans la convention
				//				EnseignantDTO tmp = getEnseignantDomainService().getEnseignantFromId(this.convention.getIdEnseignant());
				//				if (tmp !=null && tmp.getId() != 0 && tmp.getMail() != null && !tmp.getMail().isEmpty())
				//					getSmtpService().send(new InternetAddress(tmp.getMail()),sujet,text,text);

				// Envoi d'une alerte aux personnels du centre gestion configurés pour les recevoir
				List<PersonnelCentreGestionDTO> listePersonnels = getPersonnelCentreGestionDomainService().getPersonnelCentreGestionList(this.convention.getIdCentreGestion());

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
		} catch (AddressException ade){
			logger.error("AddressException", ade.fillInStackTrace());
			addErrorMessage(null, "GENERAL.ERREUR_MAIL");
		}
	}

	private boolean conventionExistante;
	/**
	 * @return boolean
	 */
	public boolean isConventionExistante(){
		return this.conventionExistante;
	}
	public void checkConventionExistante(){
		this.conventionExistante = false;
		List<ConventionDTO> list = getConventionDomainService().getConventionsEtudiant(this.etudiantRef.getIdentEtudiant(), getSessionController().getCodeUniversite());
		if (list != null && !list.isEmpty()){
			for(ConventionDTO convention : list){
				if(convention.getAnnee().equalsIgnoreCase(Utils.getCurrentYear(true))){
					// L'étudiant dispose d'une convention sur l'année courante
					this.conventionExistante = true;
					break;
				}
			}
		}

	}
	/**
	 * Verification du nombre de conventions assignees au tuteur
	 */
	public void checkSurchargeTuteur(){
		this.surchargeTuteur = false;
		Integer limiteSurcharge = getSessionController().getSurchargeTuteur();
		if (limiteSurcharge != null){
			Integer nbConventions= getEnseignantDomainService().getNombreConventionByEnseignantByAnnee(this.convention.getEnseignant().getUidEnseignant(), getSessionController().getCodeUniversite(), getBeanUtils().getAnneeUniversitaireCourante(new Date()));
			if(nbConventions > limiteSurcharge){
				this.surchargeTuteur = true;
			}
		}
	}

	/* ***************************************************************
	 * Ajouts 2.2.1 Fiche Evaluation
	 ****************************************************************/
	/**
	 * Acces a la partie Etudiant de la fiche d'evaluation
	 */
	public String goToFicheEtudiant(){
		this.togglePanelActiveItem = "etudiantTogglePanel1";
		ReponseEvaluationDTO reponseEvalTmp = this.convention.getReponseEvaluation();
		// Si la reponse n'a pas ete initialise a la creation de la convention, il n'y en a pas encore, on l'initialise donc vide en base
		if (reponseEvalTmp == null){
			reponseEvalTmp = new ReponseEvaluationDTO();
			reponseEvalTmp.setIdFicheEvaluation(this.convention.getFicheEvaluation().getIdFicheEvaluation());
			reponseEvalTmp.setIdConvention(this.convention.getIdConvention());
			try{
				getFicheEvaluationDomainService().addReponseEvaluation(reponseEvalTmp);
			} catch (DataAddException ae) {
				logger.error("DataAddException", ae.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
			}
			this.convention.setReponseEvaluation(reponseEvalTmp);
		}

		this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

		// Assignation des questions supplementaires de la partie 1 Etudiant
		this.setQuestionsSupplementairesEtudiant1(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(this.convention.getFicheEvaluation().getIdFicheEvaluation(), 1));
		// S'il y en a, recuperation/initialisation des reponses correspondantes
		if(this.questionsSupplementairesEtudiant1 != null && !this.questionsSupplementairesEtudiant1.isEmpty()){
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant1){
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}
		// Assignation des questions supplementaires de la partie 2 Etudiant
		this.setQuestionsSupplementairesEtudiant2(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(this.convention.getFicheEvaluation().getIdFicheEvaluation(), 2));
		if(this.questionsSupplementairesEtudiant2 != null && !this.questionsSupplementairesEtudiant2.isEmpty()){
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant2){
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}
		// Assignation des questions supplementaires de la partie 3 Etudiant
		this.setQuestionsSupplementairesEtudiant3(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(this.convention.getFicheEvaluation().getIdFicheEvaluation(), 3));
		if(this.questionsSupplementairesEtudiant3 != null && !this.questionsSupplementairesEtudiant3.isEmpty()){
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant3){
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}

		try{
			if (this.reponsesSupplementaires != null && !this.reponsesSupplementaires.isEmpty()){
				getFicheEvaluationDomainService().addReponsesSupplementaires(reponsesSupplementaires);
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}

		return "conventionEtape13FicheEvaluationEtudiant";
	}	

	/**
	 * Remplissage de la reponse par l'etudiant
	 */
	public void updateReponseEtudiant(){
		ReponseEvaluationDTO reponseEvalTmp = this.convention.getReponseEvaluation();
		if(reponseEvalTmp != null){
			try{
				if (selOrigineStage != null) {
					reponseEvalTmp.setReponseEtuI5(selOrigineStage.getId());
				}

				getFicheEvaluationDomainService().updateReponseEvaluationEtudiant(reponseEvalTmp);

				this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

				if(this.questionsSupplementairesEtudiant1 != null){
					for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant1){
						ReponseSupplementaireDTO reponse = question.getReponseSupplementaire();
						if (reponse != null && reponse.getIdQuestionSupplementaire() != null){
							this.reponsesSupplementaires.add(reponse);
						}
					}
				}
				if(this.questionsSupplementairesEtudiant2 != null){
					for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant2){
						ReponseSupplementaireDTO reponse = question.getReponseSupplementaire();
						if (reponse != null && reponse.getIdQuestionSupplementaire() != null){
							this.reponsesSupplementaires.add(reponse);
						}
					}
				}
				if(this.questionsSupplementairesEtudiant3 != null){
					for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant3){
						ReponseSupplementaireDTO reponse = question.getReponseSupplementaire();
						if (reponse != null && reponse.getIdQuestionSupplementaire() != null){
							this.reponsesSupplementaires.add(reponse);
						}
					}
				}

				if (reponsesSupplementaires != null && !reponsesSupplementaires.isEmpty()){
					getFicheEvaluationDomainService().updateReponsesSupplementaires(reponsesSupplementaires);
				}

				addInfoMessage("formFicheEtudiant", "CONVENTION.ETAPE13.CREATION");
				if(logger.isInfoEnabled()){
					logger.info(getSessionController().getCurrentLogin()+" met a jour sa reponse a la fiche n°"+reponseEvalTmp.getIdFicheEvaluation()
							+" pour la convention n°"+reponseEvalTmp.getIdConvention());
				}
			} catch (DataUpdateException d){
				logger.error("DataUpdateException",d.fillInStackTrace());
				addErrorMessage("formFicheEtudiant","CONVENTION.ETAPE13.ERREUR_AJOUT");
			} catch (WebServiceDataBaseException w){
				logger.error("WebServiceDataBaseException", w.fillInStackTrace());
				addErrorMessage("formFicheEtudiant", "CONVENTION.ETAPE13.ERREUR_WS");
			}
		}
	}
	/**
	 * @return String
	 */
	public String validateFicheEtudiant(){
		this.convention.getReponseEvaluation().setValidationEtudiant(true);
		this.updateReponseEtudiant();
		return "conventionEtape13FicheEvaluation";
	}

	/**
	 * Generation du pdf pour l'impression de la fiche d'evaluation de l'etudiant
	 */
	public void editPdfFicheEtudiant(){
		try	{
			if (this.convention.getReponseEvaluation() == null){
				this.convention = getConventionDomainService().getConventionFromId(this.convention.getIdConvention());
			}
			
			if (this.convention.getSujetStage() == null){
				String sujetDeStage=getConventionDomainService().getConventionFromId(this.convention.getIdConvention()).getSujetStage();
				this.convention.setSujetStage(sujetDeStage);
			}
			
			if (this.convention.getOrigineStage()==null){
				OrigineStageDTO origine=getConventionDomainService().getConventionFromId(this.convention.getIdConvention()).getOrigineStage();
				this.convention.setOrigineStage(origine);
			}
			
			
			
			// Recuperation des questions/reponses supplementaires
			List<QuestionSupplementaireDTO> list = getFicheEvaluationDomainService()
					.getQuestionsSupplementaires(this.convention.getFicheEvaluation().getIdFicheEvaluation());
			if (list != null){
				for (QuestionSupplementaireDTO question : list){
					question.setReponseSupplementaire(getFicheEvaluationDomainService().getReponseSupplementaire(
							question.getIdQuestionSupplementaire(), this.convention.getIdConvention()));
				}
				this.convention.setQuestionsSupplementaires(list);
			}
			String nomDocxsl = "";
			String fileNameXml = "";
			String fileNameXmlfin = ".xml";
			String idReponse = this.convention.getIdConvention().toString();
			nomDocxsl = "ficheEtudiant" + ".xsl";
			fileNameXml = "ficheEtudiant_" + idReponse;
			// appel castor pour fichier xml a partir de objet java convention
			castorService.objectToFileXml(this.convention, fileNameXml + fileNameXmlfin);
			//fusion du xsl et xml en pdf
			String fileNamePdf = fileNameXml + ".pdf";
			PDFUtils.exportPDF(fileNameXml + fileNameXmlfin, FacesContext.getCurrentInstance(),
					castorService.getXslXmlPath(),
					fileNamePdf, nomDocxsl);
			// Si c'est un superAdmin ou un gestionnaire qui imprime, on indique en base que la fiche a ete imprimee
			if (getSessionController().isSuperAdminPageAuthorized()
					|| (getSessionController().getDroitsEvaluationEtudiantMap() != null
					&& !getSessionController().getDroitsEvaluationEtudiantMap().isEmpty())){
				this.convention.getReponseEvaluation().setImpressionEtudiant(true);
				getFicheEvaluationDomainService().setImpressionEtudiant(this.convention.getFicheEvaluation().getIdFicheEvaluation(), this.convention.getIdConvention());
			}
		} catch (ExportException e) {
			logger.error("editPdfFicheEtudiant ", e.fillInStackTrace());
		}
	}

	/**
	 * Envoi d'un mail avertissant l'etudiant qu'il peut aller remplir sa fiche
	 */
	public void envoiMailEtudiant(){
		String adresseEtudiant = "";
		String nomEtu = "";
		if (this.convention.getEtudiant() != null){
			nomEtu = this.convention.getEtudiant().getPrenom()+" "+this.convention.getEtudiant().getNom();
			if (this.convention.getCourrielPersoEtudiant() != null 
					&& !this.convention.getCourrielPersoEtudiant().isEmpty()){
				adresseEtudiant = this.convention.getCourrielPersoEtudiant();
			} else if (this.convention.getEtudiant().getMail() != null 
					&& !this.convention.getEtudiant().getMail().isEmpty()) {
				adresseEtudiant = this.convention.getEtudiant().getMail();
			}
		} else {
			addErrorMessage("formAccueilFiche:panelMailEtudiant", "CONVENTION.ETAPE13.MAIL.INEXISTANT_ETUDIANT",this.convention.getIdConvention());
			return;
		}
		try{
			String contenu = "";
			String sujet = "";
			if (this.typeMailEval == 1){
				sujet = getSessionController().getApplicationNamePStage()+" - Evaluation de votre stage pour la convention n°"+this.convention.getIdConvention();
				contenu = getString("CONVENTION.ETAPE13.MAIL.CONTENU_ETUDIANT",this.convention.getStructure().getRaisonSociale(),
						getSessionController().getApplicationNamePStage());
			} else if (this.typeMailEval == 2){
				sujet = getSessionController().getApplicationNamePStage()+" - Rappel concernant l'évaluation de votre stage pour la convention n°"+this.convention.getIdConvention();
				contenu = getString("CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ETUDIANT",this.convention.getStructure().getRaisonSociale(),
						getSessionController().getApplicationNamePStage());
			}

			getSmtpService().send(new InternetAddress(adresseEtudiant),
					sujet,
					contenu,
					"");
			// On indique en base et pour l'affichage que le mail a ete envoye
			this.convention.setEnvoiMailEtudiant(true);
			this.convention.setDateEnvoiMailEtudiant(new Date());
			getFicheEvaluationDomainService().setEnvoiMailEtudiant(this.convention.getIdConvention());
			resultatsRechercheConvention.get(resultatsRechercheConvention.indexOf(this.convention)).setEnvoiMailEtudiant(true);
			resultatsRechercheConvention.get(resultatsRechercheConvention.indexOf(this.convention)).setDateEnvoiMailEtudiant(new Date());
			addInfoMessage("formAccueilFiche:panelMailEtudiant","CONVENTION.ETAPE13.MAIL.ENVOI_REUSSI",adresseEtudiant,this.convention.getIdConvention());
			this.reloadRechercheConventionPaginator();
		} catch (AddressException e) {
			if (logger.isDebugEnabled()){
				e.printStackTrace();
			}
			addErrorMessage("formAccueilFiche:panelMailEtudiant", "CONVENTION.ETAPE13.MAIL.ERREUR_ETUDIANT",adresseEtudiant,nomEtu,this.convention.getIdConvention());
		}
	}

	/**
	 * @return the tuteurCurrentConvention
	 */
	public boolean isTuteurCurrentConvention(){
		boolean b = false;
		if (getSessionController().getCurrentAuthEnseignant() != null 
				&& this.convention.getEnseignant() != null
				&& getSessionController().getCurrentAuthEnseignant().getUidEnseignant()
				.equalsIgnoreCase(this.convention.getEnseignant().getUidEnseignant())){
			b=true;
		}
		return b;
	}

	/**
	 * Acces a la partie Enseignant de la fiche d'evaluation
	 */
	public String goToFicheEnseignant(){
		this.togglePanelActiveItem = "enseignantTogglePanel1";
		ReponseEvaluationDTO reponseEvalTmp = this.convention.getReponseEvaluation();
		if (reponseEvalTmp == null){
			reponseEvalTmp = new ReponseEvaluationDTO();
			reponseEvalTmp.setIdConvention(this.convention.getIdConvention());
			reponseEvalTmp.setIdFicheEvaluation(this.convention.getFicheEvaluation().getIdFicheEvaluation());
			try{
				getFicheEvaluationDomainService().addReponseEvaluation(reponseEvalTmp);
			} catch (DataAddException ae) {
				logger.error("DataAddException", ae.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
			}
			this.convention.setReponseEvaluation(reponseEvalTmp);
		}

		this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

		// Assignation des questions supplementaires de la partie 1 Enseignant
		this.setQuestionsSupplementairesEnseignant1(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(this.convention.getFicheEvaluation().getIdFicheEvaluation(), 4));
		// S'il y en a, recuperation/initialisation des reponses correspondantes
		if(this.questionsSupplementairesEnseignant1 != null && !this.questionsSupplementairesEnseignant1.isEmpty()){
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEnseignant1){
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}
		// Assignation des questions supplementaires de la partie 2 Enseignant
		this.setQuestionsSupplementairesEnseignant2(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(this.convention.getFicheEvaluation().getIdFicheEvaluation(), 5));
		if(this.questionsSupplementairesEnseignant2 != null && !this.questionsSupplementairesEnseignant2.isEmpty()){
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEnseignant2){
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}

		try{
			if (this.reponsesSupplementaires != null && !this.reponsesSupplementaires.isEmpty()){
				getFicheEvaluationDomainService().addReponsesSupplementaires(reponsesSupplementaires);
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}

		getSessionController().setFicheEvaluationCurrentPage("_conventionEtape13FicheEvaluationEnseignant");
		return "conventionEtape13FicheEvaluationEnseignant";
	}
	/**
	 * Remplissage de sa reponse par l'enseignant
	 */
	public void updateReponseEnseignant(){
		ReponseEvaluationDTO reponseEvalTmp = this.convention.getReponseEvaluation();
		if(reponseEvalTmp != null){
			try{
				getFicheEvaluationDomainService().updateReponseEvaluationEnseignant(reponseEvalTmp);

				this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

				if(this.questionsSupplementairesEnseignant1 != null){
					for (QuestionSupplementaireDTO question : this.questionsSupplementairesEnseignant1){
						ReponseSupplementaireDTO reponse = question.getReponseSupplementaire();
						if (reponse != null && reponse.getIdQuestionSupplementaire() != null){
							this.reponsesSupplementaires.add(reponse);
						}
					}
				}
				if(this.questionsSupplementairesEnseignant2 != null){
					for (QuestionSupplementaireDTO question : this.questionsSupplementairesEnseignant2){
						ReponseSupplementaireDTO reponse = question.getReponseSupplementaire();
						if (reponse != null && reponse.getIdQuestionSupplementaire() != null){
							this.reponsesSupplementaires.add(reponse);
						}
					}
				}

				if (reponsesSupplementaires != null && !reponsesSupplementaires.isEmpty()){
					getFicheEvaluationDomainService().updateReponsesSupplementaires(reponsesSupplementaires);
				}

				addInfoMessage("formFicheEnseignant", "CONVENTION.ETAPE13.CREATION");
				if(logger.isInfoEnabled()){
					logger.info(getSessionController().getCurrentLogin()+" met a jour sa reponse a la fiche n°"+reponseEvalTmp.getIdFicheEvaluation()
							+" pour la convention n°"+reponseEvalTmp.getIdConvention());
				}
			} catch (DataUpdateException d){
				logger.error("DataUpdateException",d.fillInStackTrace());
				addErrorMessage("formFicheEnseignant","CONVENTION.ETAPE13.ERREUR_AJOUT");
			} catch (WebServiceDataBaseException w){
				logger.error("WebServiceDataBaseException", w.fillInStackTrace());
				addErrorMessage("formFicheEnseignant", "CONVENTION.ETAPE13.ERREUR_WS");
			}
		}
	}
	/**
	 * @return String
	 */
	public String validateFicheEnseignant(){
		this.convention.getReponseEvaluation().setValidationEnseignant(true);
		this.updateReponseEnseignant();
		return "conventionEtape13FicheEvaluation";
	}
	/**
	 * Generation du pdf pour l'impression de la fiche Enseignant
	 */
	public void editPdfFicheEnseignant(){
		try	{
			if (this.convention.getReponseEvaluation() == null){
				this.convention = getConventionDomainService().getConventionFromId(this.convention.getIdConvention());
			}
			// Recuperation des questions/reponses supplementaires
			List<QuestionSupplementaireDTO> list = getFicheEvaluationDomainService()
					.getQuestionsSupplementaires(this.convention.getFicheEvaluation().getIdFicheEvaluation());
			if (list != null){
				for (QuestionSupplementaireDTO question : list){
					question.setReponseSupplementaire(getFicheEvaluationDomainService().getReponseSupplementaire(
							question.getIdQuestionSupplementaire(), this.convention.getIdConvention()));
				}
				this.convention.setQuestionsSupplementaires(list);
			}
			String nomDocxsl = "";
			String fileNameXml = "";
			String fileNameXmlfin = ".xml";
			String idReponse = this.convention.getIdConvention().toString();
			nomDocxsl = "ficheEnseignant" + ".xsl";
			fileNameXml = "ficheEnseignant_" + idReponse;
			// appel castor pour fichier xml a partir de objet java convention
			castorService.objectToFileXml(this.convention, fileNameXml + fileNameXmlfin);
			//fusion du xsl et xml en pdf
			String fileNamePdf = fileNameXml + ".pdf";
			PDFUtils.exportPDF(fileNameXml + fileNameXmlfin, FacesContext.getCurrentInstance(),
					castorService.getXslXmlPath(),
					fileNamePdf, nomDocxsl);

			// Si c'est un superAdmin ou un gestionnaire qui imprime, on indique en base que la fiche a ete imprimee
			if (getSessionController().isSuperAdminPageAuthorized()
					|| (getSessionController().getDroitsEvaluationEnseignantMap() != null
					&& !getSessionController().getDroitsEvaluationEnseignantMap().isEmpty())){
				this.convention.getReponseEvaluation().setImpressionEnseignant(true);
				getFicheEvaluationDomainService().setImpressionEnseignant(this.convention.getFicheEvaluation().getIdFicheEvaluation(), this.convention.getIdConvention());
			}
		} catch (ExportException e) {
			logger.error("editPdfFicheEnseignant ", e.fillInStackTrace());
		}
	}

	/**
	 * Generation et envoie du lien vers sa fiche au tuteur pédagogique de l'etudiant
	 */
	public void envoiMailEnseignant(){
		String adresseTuteurPedago = "";
		String nomTuteur = "";
		String libelleEtu = "";
		if (this.convention.getEnseignant() != null && this.convention.getEnseignant().getMail()!=null
				&& !this.convention.getEnseignant().getMail().isEmpty()){
			nomTuteur = this.convention.getEnseignant().getPrenom() + " " + this.convention.getEnseignant().getNom();
			adresseTuteurPedago = this.convention.getEnseignant().getMail();
		} else {
			addErrorMessage("formAccueilFiche:panelMailEnseignant", "CONVENTION.ETAPE13.MAIL.INEXISTANT_ENSEIGNANT",this.convention.getIdConvention());
			return;
		}

		if (this.convention.getEtudiant() != null){
			libelleEtu = this.convention.getEtudiant().getPrenom()+" "+this.convention.getEtudiant().getNom();
		}

		try {
			String contenu = "";
			String sujet = "";
			if (this.typeMailEval == 1){
				sujet=getSessionController().getApplicationNamePStage()+" - Evaluation du stage de "+libelleEtu;
				contenu = getString("CONVENTION.ETAPE13.MAIL.CONTENU_ENSEIGNANT",libelleEtu,
						this.convention.getIdConvention(),
						getSessionController().getApplicationNamePStage());
			} else if (this.typeMailEval == 2){
				sujet=getSessionController().getApplicationNamePStage()+" - Rappel concernant l'évaluation du stage de "+libelleEtu;
				contenu = getString("CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ENSEIGNANT",libelleEtu,
						this.convention.getIdConvention(),
						getSessionController().getApplicationNamePStage());
			}

			getSmtpService().send(new InternetAddress(adresseTuteurPedago),
					sujet,
					contenu,
					"");
			// On indique en base que le mail a ete envoye
			this.convention.setEnvoiMailTuteurPedago(true);
			this.convention.setDateEnvoiMailTuteurPedago(new Date());
			getFicheEvaluationDomainService().setEnvoiMailEnseignant(this.convention.getIdConvention());
			this.resultatsRechercheConvention.get(resultatsRechercheConvention.indexOf(this.convention)).setEnvoiMailTuteurPedago(true);
			this.resultatsRechercheConvention.get(resultatsRechercheConvention.indexOf(this.convention)).setDateEnvoiMailTuteurPedago(new Date());
			addInfoMessage("formAccueilFiche:panelMailEnseignant","CONVENTION.ETAPE13.MAIL.ENVOI_REUSSI",adresseTuteurPedago,this.convention.getIdConvention());
			this.reloadRechercheConventionPaginator();
		} catch (AddressException e) {
			if (logger.isDebugEnabled()){
				e.printStackTrace();
			}
			addErrorMessage("formAccueilFiche:panelMailEnseignant", "CONVENTION.ETAPE13.MAIL.ERREUR_ENSEIGNANT",adresseTuteurPedago,nomTuteur,this.convention.getIdConvention());
		}
	}	

	/**
	 * Acces a la partie Entreprise de la fiche d'evaluation par le super admin
	 */
	public String goToFicheEntreprise(){

		this.accesPartieEntreprise();

		return "conventionEtape13FicheEvaluationEntreprise";
	}

	/**
	 * Acces a la partie Entreprise de la fiche d'evaluation par le tuteur pro (acces via lien)
	 */
	public String goToFicheEntrepriseTuteurPro(){

		int idDecode = Utils.convertStringToInt(getBlowfishUtils().decode(this.codeAccesFiche));
		// recuperation de la convention via l'id
		this.convention = getConventionDomainService().getConventionFromId(idDecode);

		this.accesPartieEntreprise();

		return "goToFicheEntrepriseTuteurPro";
	}

	private void accesPartieEntreprise(){
		this.togglePanelActiveItem = "entrepriseTogglePanel1";
		ReponseEvaluationDTO reponseEvalTmp = this.convention.getReponseEvaluation();
		if (reponseEvalTmp == null){
			reponseEvalTmp = new ReponseEvaluationDTO();
			reponseEvalTmp.setIdConvention(this.convention.getIdConvention());
			reponseEvalTmp.setIdFicheEvaluation(this.convention.getFicheEvaluation().getIdFicheEvaluation());
			try{
				getFicheEvaluationDomainService().addReponseEvaluation(reponseEvalTmp);
			} catch (DataAddException ae) {
				logger.error("DataAddException", ae.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
			}
			this.convention.setReponseEvaluation(reponseEvalTmp);
		}

		this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

		// Assignation des questions supplementaires de la partie 1 Entreprise
		this.setQuestionsSupplementairesEntreprise1(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(this.convention.getFicheEvaluation().getIdFicheEvaluation(), 6));
		// S'il y en a, recuperation/initialisation des reponses correspondantes
		if(this.questionsSupplementairesEntreprise1!= null && !this.questionsSupplementairesEntreprise1.isEmpty()){
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise1){
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}
		// Assignation des questions supplementaires de la partie 2 Entreprise
		this.setQuestionsSupplementairesEntreprise2(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(this.convention.getFicheEvaluation().getIdFicheEvaluation(), 7));
		// S'il y en a, recuperation/initialisation des reponses correspondantes
		if(this.questionsSupplementairesEntreprise2!= null && !this.questionsSupplementairesEntreprise2.isEmpty()){
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise2){
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}
		// Assignation des questions supplementaires de la partie 3 Entreprise
		this.setQuestionsSupplementairesEntreprise3(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(this.convention.getFicheEvaluation().getIdFicheEvaluation(), 8));
		// S'il y en a, recuperation/initialisation des reponses correspondantes
		if(this.questionsSupplementairesEntreprise3!= null && !this.questionsSupplementairesEntreprise3.isEmpty()){
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise3){
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}

		try{
			if (this.reponsesSupplementaires != null && !this.reponsesSupplementaires.isEmpty()){
				getFicheEvaluationDomainService().addReponsesSupplementaires(reponsesSupplementaires);
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		}

		getSessionController().setFicheEvaluationCurrentPage("_conventionEtape13FicheEvaluationEntreprise");
	}

	/**
	 * Remplissage de la fiche entreprise par le superadmin
	 */
	public void updateReponseEntreprise(){
		ReponseEvaluationDTO reponseEvalTmp = this.convention.getReponseEvaluation();

		if(reponseEvalTmp != null){
			this.commonUpdateReponseEntreprise(reponseEvalTmp);

			addInfoMessage("formFicheEntreprise", "CONVENTION.ETAPE13.CREATION");
			if(logger.isInfoEnabled()){
				logger.info(getSessionController().getCurrentLogin()+" met a jour sa reponse a la fiche n°"+reponseEvalTmp.getIdFicheEvaluation()
						+" pour la convention n°"+reponseEvalTmp.getIdConvention());
			}
		}
	}
	/**
	 * Remplissage de la fiche entreprise par le tuteur pro via le lien
	 */
	public void updateReponseEntrepriseTuteurPro(){
		ReponseEvaluationDTO reponseEvalTmp = this.convention.getReponseEvaluation();

		if(reponseEvalTmp != null){
			this.commonUpdateReponseEntreprise(reponseEvalTmp);

			addInfoMessage("formFicheEntreprise", "CONVENTION.ETAPE13.CREATION");
			if(logger.isInfoEnabled()){
				logger.info("Le tuteur professionnel a mis a jour sa reponse a la fiche n°"+reponseEvalTmp.getIdFicheEvaluation()
						+" pour la convention n°"+reponseEvalTmp.getIdConvention());
			}
		}
	}

	/**
	 * update de la reponse entreprise via l'appli (sans accès via lien)
	 * @param reponseEvalTmp
	 */
	private void commonUpdateReponseEntreprise(ReponseEvaluationDTO reponseEvalTmp){
		try{
			getFicheEvaluationDomainService().updateReponseEvaluationEntreprise(reponseEvalTmp);

			this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

			if(this.questionsSupplementairesEntreprise1 != null){
				for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise1){
					ReponseSupplementaireDTO reponse = question.getReponseSupplementaire();
					if (reponse != null && reponse.getIdQuestionSupplementaire() != null){
						this.reponsesSupplementaires.add(reponse);
					}
				}
			}
			if(this.questionsSupplementairesEntreprise2 != null){
				for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise2){
					ReponseSupplementaireDTO reponse = question.getReponseSupplementaire();
					if (reponse != null && reponse.getIdQuestionSupplementaire() != null){
						this.reponsesSupplementaires.add(reponse);
					}
				}
			}
			if(this.questionsSupplementairesEntreprise3 != null){
				for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise3){
					ReponseSupplementaireDTO reponse = question.getReponseSupplementaire();
					if (reponse != null && reponse.getIdQuestionSupplementaire() != null){
						this.reponsesSupplementaires.add(reponse);
					}
				}
			}

			if (reponsesSupplementaires != null && !reponsesSupplementaires.isEmpty()){
				getFicheEvaluationDomainService().updateReponsesSupplementaires(reponsesSupplementaires);
			}

		} catch (DataUpdateException d){
			logger.error("DataUpdateException",d.fillInStackTrace());
			addErrorMessage("formFicheEntreprise","CONVENTION.ETAPE13.ERREUR_AJOUT");
		} catch (WebServiceDataBaseException w){
			logger.error("WebServiceDataBaseException", w.fillInStackTrace());
			addErrorMessage("formFicheEntreprise", "CONVENTION.ETAPE13.ERREUR_WS");
		}
	}

	/**
	 * @return String
	 */
	public String validateFicheEntreprise(){
		this.convention.getReponseEvaluation().setValidationEntreprise(true);
		this.updateReponseEntreprise();
		return "conventionEtape13FicheEvaluation";
	}
	/**
	 * @return String
	 */
	public String validateFicheEntrepriseTuteurPro(){
		this.convention.getReponseEvaluation().setValidationEntreprise(true);
		this.updateReponseEntrepriseTuteurPro();
		return "goToFicheEntrepriseTuteurPro";
	}

	/**
	 * Generation du pdf pour l'impression de la fiche entreprise
	 */
	public void editPdfFicheEntreprise(){
		try	{
			ConventionDTO conventionTmp;
			if (this.convention.getReponseEvaluation() == null){
				conventionTmp = getConventionDomainService().getConventionFromId(this.convention.getIdConvention());
			} else {
				conventionTmp = this.convention;
			}
			// Recuperation des questions/reponses supplementaires
			List<QuestionSupplementaireDTO> list = getFicheEvaluationDomainService()
					.getQuestionsSupplementaires(conventionTmp.getFicheEvaluation().getIdFicheEvaluation());
			if (list != null){
				for (QuestionSupplementaireDTO question : list){
					question.setReponseSupplementaire(getFicheEvaluationDomainService().getReponseSupplementaire(
							question.getIdQuestionSupplementaire(), conventionTmp.getIdConvention()));
				}
				conventionTmp.setQuestionsSupplementaires(list);
			}
			String nomDocxsl = "";
			String fileNameXml = "";
			String fileNameXmlfin = ".xml";
			String idReponse = conventionTmp.getIdConvention().toString();
			nomDocxsl = "ficheEntreprise" + ".xsl";
			fileNameXml = "ficheEntreprise_" + idReponse;
			// appel castor pour fichier xml a partir de objet java convention
			castorService.objectToFileXml(conventionTmp, fileNameXml + fileNameXmlfin);
			//fusion du xsl et xml en pdf
			String fileNamePdf = fileNameXml + ".pdf";
			PDFUtils.exportPDF(fileNameXml + fileNameXmlfin, FacesContext.getCurrentInstance(),
					castorService.getXslXmlPath(),
					fileNamePdf, nomDocxsl);
			// Si c'est un superAdmin ou un gestionnaire qui imprime, on indique en base que la fiche a ete imprimee
			if (getSessionController().isSuperAdminPageAuthorized()
					|| (getSessionController().getDroitsEvaluationEnseignantMap() != null
					&& !getSessionController().getDroitsEvaluationEnseignantMap().isEmpty())){
				conventionTmp.getReponseEvaluation().setImpressionEntreprise(true);
				getFicheEvaluationDomainService().setImpressionEntreprise(conventionTmp.getFicheEvaluation().getIdFicheEvaluation(), conventionTmp.getIdConvention());
			}
		} catch (ExportException e) {
			logger.error("editPdfFicheEntreprise ", e.fillInStackTrace());
		}
	}

	/**
	 * Generation et envoie du lien vers sa fiche non casifiee au tuteur professionnel de l'etudiant
	 */
	public void envoiMailEntreprise(){

		// chiffrage de l'id de la convention via blowfish
		String idEncode = getBlowfishUtils().encode(""+this.convention.getIdConvention());

		String url = getSessionController().getBaseUrl()+"/stylesheets/evaluationStage/index.xhtml"+"?id="+idEncode;

		String adresseTuteurPro = "";
		String nomTuteurPro ="";
		if (this.convention.getContact() != null && this.convention.getContact().getMail() != null
				&& !this.convention.getContact().getMail().isEmpty()){
			nomTuteurPro = this.convention.getContact().getPrenom() + " " + this.convention.getContact().getNom();
			adresseTuteurPro = this.convention.getContact().getMail();
		} else {
			addErrorMessage("formAccueilFiche:panelMailEntreprise", "CONVENTION.ETAPE13.MAIL.INEXISTANT_ENTREPRISE",this.convention.getIdConvention());
			return;
		}

		String libelleEtu = "";
		if (this.convention.getEtudiant() != null){
			libelleEtu = this.convention.getEtudiant().getPrenom()+" "+this.convention.getEtudiant().getNom();
		}

		try{
			String contenu = "";
			String sujet = "";
			if (this.typeMailEval == 1){
				sujet = getSessionController().getApplicationNamePStage()+" - Evaluation du stage de "+libelleEtu;
				contenu = getString("CONVENTION.ETAPE13.MAIL.CONTENU_ENTREPRISE",libelleEtu,
						url,
						getSessionController().getApplicationNamePStage());
			} else if (this.typeMailEval == 2){
				sujet = getSessionController().getApplicationNamePStage()+" - Rappel concernant l'évaluation du stage de "+libelleEtu;
				contenu = getString("CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ENTREPRISE",libelleEtu,
						url,
						getSessionController().getApplicationNamePStage());
			}
			getSmtpService().send(new InternetAddress(adresseTuteurPro),
					sujet,
					contenu,
					"");
			// On indique en base que le mail a ete envoye
			this.convention.setEnvoiMailTuteurPro(true);
			this.convention.setDateEnvoiMailTuteurPro(new Date());
			getFicheEvaluationDomainService().setEnvoiMailEntreprise(this.convention.getIdConvention());
			this.resultatsRechercheConvention.get(resultatsRechercheConvention.indexOf(this.convention)).setEnvoiMailTuteurPro(true);
			this.resultatsRechercheConvention.get(resultatsRechercheConvention.indexOf(this.convention)).setDateEnvoiMailTuteurPro(new Date());
			addInfoMessage("formAccueilFiche:panelMailTuteurPro","CONVENTION.ETAPE13.MAIL.ENVOI_REUSSI",adresseTuteurPro,this.convention.getIdConvention());
			this.reloadRechercheConventionPaginator();
			// Si l'entreprise avait validé sa fiche et a fait la demande de pouvoir la remodifier, l'envoi du rappel l'invalide automatiquement
			if (this.convention.getReponseEvaluation() != null && this.convention.getReponseEvaluation().isValidationEntreprise()){
				this.convention.getReponseEvaluation().setValidationEntreprise(false);
				getFicheEvaluationDomainService().updateReponseEvaluationEntreprise(this.convention.getReponseEvaluation());
			}
		} catch (AddressException e) {
			if (logger.isDebugEnabled()){
				e.printStackTrace();
			}
			addErrorMessage("formAccueilFiche:panelMailEntreprise", "CONVENTION.ETAPE13.MAIL.ERREUR_ENTREPRISE",adresseTuteurPro,nomTuteurPro,this.convention.getIdConvention());
		}
	}

	/**
	 * @param question
	 * @return ReponseSupplementaireDTO
	 */
	private ReponseSupplementaireDTO recupReponseSup(QuestionSupplementaireDTO question){
		ReponseSupplementaireDTO reponse = getFicheEvaluationDomainService()
				.getReponseSupplementaire(question.getIdQuestionSupplementaire(), this.convention.getIdConvention());
		// Si on ne trouve rien existant en base, on l'initialise avec les ids disponibles
		if (reponse.getIdQuestionSupplementaire() == null){
			reponse.setIdQuestionSupplementaire(question.getIdQuestionSupplementaire());
			reponse.setIdConvention(this.convention.getIdConvention());
			this.reponsesSupplementaires.add(reponse);
		}
		return reponse;
	}

	/**
	 * @return String
	 */
	public String goToRechercheEval() {

		//		this.critereRechercheConvention=new CritereRechercheConventionDTO();
		this.critereRechercheConvention = initCritereRechercheConvention();
		this.critereRechercheConvention.setNbExportMaxi("");

		this.listeItemsCurrentCentresGestionEval = new ArrayList<SelectItem>();
		if (getSessionController().isSuperAdminPageAuthorized()){
			List <CentreGestionDTO> centres = getCentreGestionDomainService().getCentreGestionList(getSessionController().getCodeUniversite());
			if (centres != null && !centres.isEmpty()){
				for (CentreGestionDTO centre : centres){
					this.listeItemsCurrentCentresGestionEval.add(new SelectItem(centre.getIdCentreGestion(), centre.getNomCentre()));
				}
			}
		} else {
			Map<Integer,Boolean> mapEtu = getSessionController().getDroitsEvaluationEtudiantMap();
			Map<Integer,Boolean> mapEns = getSessionController().getDroitsEvaluationEnseignantMap();
			Map<Integer,Boolean> mapEnt = getSessionController().getDroitsEvaluationEntrepriseMap();

			Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
			if (mapEtu != null && !mapEtu.isEmpty()){
				map.putAll(mapEtu);
			}
			if (mapEns != null && !mapEns.isEmpty()){
				map.putAll(mapEns);
			}
			if (mapEnt != null && !mapEnt.isEmpty()){
				map.putAll(mapEnt);
			}
			if (map != null && !map.isEmpty()){
				for(Iterator<Integer> iter = map.keySet().iterator(); iter.hasNext(); ){
					CentreGestionDTO cg = getCentreGestionDomainService().getCentreGestion(iter.next());
					this.listeItemsCurrentCentresGestionEval.add(new SelectItem(cg.getIdCentreGestion(), cg.getNomCentre()));
				}
			}
		}

		if (this.rechEvalIdCentre == null && this.listeItemsCurrentCentresGestionEval != null
				&& !this.listeItemsCurrentCentresGestionEval.isEmpty()){
			this.rechEvalIdCentre = (Integer)this.listeItemsCurrentCentresGestionEval.get(0).getValue();
		}

		return "rechercheEvaluation";
	}

	/**
	 * Renvoie true si le centre sur lequel la recherche d'evaluation est faite est de type ETAPE
	 * et remet à zero la liste d'idsUfrs du critere de recherche de convention
	 */
	public boolean isEtape(){
		if (this.rechEvalIdCentre != null && this.rechEvalIdCentre != 0){
			CentreGestionDTO centre = getCentreGestionDomainService().getCentreGestion(this.rechEvalIdCentre);
			if (centre !=null && centre.getNiveauCentre().getLibelle().equalsIgnoreCase(DonneesStatic.CG_ETAPE)){
				if (this.critereRechercheConvention != null){
					this.critereRechercheConvention.setIdsUfrs(new ArrayList<String>());
				}
				return true;
			}
		}
		return false;
	}
	/**
	 * Renvoie true si le centre sur lequel la recherche d'evaluation est faite est de type UFR
	 * et remet à zero la liste d'idsEtapes du critere de recherche de convention
	 */
	public boolean isUfr(){
		if (this.rechEvalIdCentre != null && this.rechEvalIdCentre != 0){
			CentreGestionDTO centre = getCentreGestionDomainService().getCentreGestion(this.rechEvalIdCentre);
			if (centre !=null && centre.getNiveauCentre().getLibelle().equalsIgnoreCase(DonneesStatic.CG_UFR)){
				if (this.critereRechercheConvention != null){
					this.critereRechercheConvention.setIdsEtapes(new ArrayList<String>());
				}
				return true;
			}
		}
		return false;
	}
	/**
	 * Renvoie true si le centre sur lequel la recherche d'evaluation est faite est de type Etablissement
	 * et remet à zero la liste d'idsEtapes et idsUfr du critere de recherche de convention pour y mettre 
	 * son id de centre de gestion afin de recup les conventions orphelines
	 */
	public boolean isEtablissement(){
		if (this.rechEvalIdCentre != null && this.rechEvalIdCentre != 0){
			CentreGestionDTO centre = getCentreGestionDomainService().getCentreGestion(this.rechEvalIdCentre);
			if (centre !=null && centre.getNiveauCentre().getLibelle().equalsIgnoreCase(DonneesStatic.CG_ETAB)){
				if (this.critereRechercheConvention != null){
					List<Integer> list = new ArrayList<Integer>();
					list.add(this.rechEvalIdCentre);
					this.critereRechercheConvention.setIdsEtapes(new ArrayList<String>());
					this.critereRechercheConvention.setIdsUfrs(new ArrayList<String>());
					this.critereRechercheConvention.setIdsCentreGestion(list);
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * @return String
	 */
	public String rechercherEvaluation(){
		String ret = "resultatsRechercheEvaluation";
		this.conventionCree = false;
		// Mise a null de tous les criteres inutiles pour la recherche de fiche
		this.critereRechercheConvention.setNomEnseignant(null);
		this.critereRechercheConvention.setPrenomEnseignant(null);
		this.critereRechercheConvention.setTypeStructure(null);
		this.critereRechercheConvention.setStatutJuridique(null);
		this.critereRechercheConvention.setEstValidee(true);
		this.critereRechercheConvention.setEstVerifiee(null);

		// On ne recherche que pour le centre selectionne dans le menu deroulant
		List<Integer> list = new ArrayList<Integer>();
		list.add(this.rechEvalIdCentre);
		this.critereRechercheConvention.setIdsCentreGestion(list);

		//		this.critereRechercheConvention.setNbRechercheMaxi(Integer.toString(DonneesStatic.nb_recherche_maxi));
		this.critereRechercheConvention.setNbRechercheMaxi(this.critereRechercheConvention.getNbRechercheMaxi());

		this.resultatsRechercheConvention = getConventionDomainService().getConventionsFromCriteres(this.critereRechercheConvention);

		FicheEvaluationDTO fiche = getFicheEvaluationDomainService().getFicheEvaluationFromIdCentre(this.rechEvalIdCentre);

		// instanciation de l'objet convention juste pour y stocker la fiche d'evaluation afin de l'utiliser dans la page de resultats
		this.convention = new ConventionDTO();
		this.convention.setFicheEvaluation(fiche);

		if (this.resultatsRechercheConvention != null 
				&& !this.resultatsRechercheConvention.isEmpty()){
			if (fiche != null){
				for (ConventionDTO convention : this.resultatsRechercheConvention){
					convention.setFicheEvaluation(fiche);
					int idFicheEvaluation = fiche.getIdFicheEvaluation();
					convention.setReponseEvaluation(getFicheEvaluationDomainService().getReponseEvaluation(idFicheEvaluation, convention.getIdConvention()));
				}
			}
			reloadRechercheConventionPaginator();
		} else {
			ret=null;
			this.resultatsRechercheConvention = null;
			addInfoMessage("formRechEval", "RECHERCHEEVALUATION.AUCUNRESULTAT");
			this.rechercheConventionPaginator.reset();
		}

		return ret;
	}

	/**
	 * Recherche de fiches d'evaluation de l'etudiant connecte.
	 * @return String
	 */
	public String goToRechercheEvalEtu() {
		String ret = "resultatsRechercheEvaluation";
		this.rechEvalIdCentre = null;
		this.conventionCree = false;
		this.convention = new ConventionDTO();
		this.resultatsRechercheConvention = new ArrayList<ConventionDTO>();
		if (this.getSessionController().getCurrentAuthEtudiant() != null) {
			this.resultatsRechercheConvention = getConventionDomainService().getConventionsEtudiant(this.getSessionController().getCurrentAuthEtudiant().getIdentEtudiant(),getSessionController().getCodeUniversite());
			if (this.resultatsRechercheConvention != null && !this.resultatsRechercheConvention.isEmpty()){
				for (ConventionDTO convention : this.resultatsRechercheConvention){
					FicheEvaluationDTO fiche = getFicheEvaluationDomainService().getFicheEvaluationFromIdCentre(convention.getIdCentreGestion());
					if (fiche != null){
						convention.setFicheEvaluation(fiche);
						int idFicheEvaluation = fiche.getIdFicheEvaluation();
						convention.setReponseEvaluation(getFicheEvaluationDomainService().getReponseEvaluation(idFicheEvaluation, convention.getIdConvention()));
					}
				}
				reloadRechercheConventionPaginator();
			} else {
				this.resultatsRechercheConvention = null;
				addInfoMessage("formRechEval", "RECHERCHEEVALUATION.AUCUNRESULTAT");
				this.rechercheConventionPaginator.reset();
			}
		}

		return ret;
	}

	/**
	 * Recherche de fiches d'evaluation du tuteur pedago connecte.
	 * @return String
	 */
	public String goToRechercheEvalEns() {
		String ret = "resultatsRechercheEvaluation";

		this.rechEvalIdCentre = null;
		this.conventionCree = false;
		this.convention = new ConventionDTO();
		this.rechercheConventionPaginator = new RechercheConventionPaginator();
		this.resultatsRechercheConvention = new ArrayList<ConventionDTO>();
		if (this.getSessionController().getCurrentAuthEnseignant() != null) {
			if (this.getSessionController().getCurrentAuthEnseignant().getUidEnseignant() != null) {
				EnseignantDTO tmpEns = getEnseignantDomainService().getEnseignantFromUid(this.getSessionController().getCurrentAuthEnseignant().getUidEnseignant(),
						getSessionController().getCodeUniversite());
				if (tmpEns != null){
					this.resultatsRechercheConvention = getConventionDomainService().getConventionsByEnseignant(tmpEns.getId(),getBeanUtils().getAnneeUniversitaireCourante(new Date()));

					if (this.resultatsRechercheConvention != null && !this.resultatsRechercheConvention.isEmpty()) {
						for (ConventionDTO conventionTmp : this.resultatsRechercheConvention){
							FicheEvaluationDTO fiche = getFicheEvaluationDomainService().getFicheEvaluationFromIdCentre(conventionTmp.getIdCentreGestion());
							if (fiche != null){
								conventionTmp.setFicheEvaluation(fiche);
								int idFicheEvaluation = fiche.getIdFicheEvaluation();
								conventionTmp.setReponseEvaluation(getFicheEvaluationDomainService().getReponseEvaluation(idFicheEvaluation, conventionTmp.getIdConvention()));
							}
						}
						reloadRechercheConventionPaginator();
					} else {
						this.resultatsRechercheConvention = null;
						addInfoMessage("formRechEval", "RECHERCHEEVALUATION.AUCUNRESULTAT");
						this.rechercheConventionPaginator.reset();
					}
				}

			}
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToEvalConvention(){
		String retour = this.goToRecapConvention();
		if (retour != null){
			retour = "conventionEtape13FicheEvaluation";
		}
		return retour;
	}

	/**
	 * id du type de destinataire pour l'envoi de mail en masse
	 * 1:etudiant 2:tuteur pedago 3:tuteur pro
	 */
	private int typeDestMailEval;

	/**
	 * id du type de mail pour l'envoi de masse
	 * 1:1er envoi 2:Rappel
	 */
	private int typeMailEval;

	/**
	 * Contenu du mail pour l'envoi de masse en fonction des types choisis
	 */
	private String contenuMailEval;

	/**
	 * @return the contenuMailEval
	 */
	public String getContenuMailEval() {
		if (this.typeMailEval == 1){
			// 1er envoi
			switch (this.typeDestMailEval) {
			case 1:
				this.contenuMailEval = getString("CONVENTION.ETAPE13.MAIL.CONTENU_ETUDIANT",
						"<i>raison sociale de l'organisme d'accueil</i>",getSessionController().getApplicationNamePStage());
				break;
			case 2:
				this.contenuMailEval = getString("CONVENTION.ETAPE13.MAIL.CONTENU_ENSEIGNANT",
						"<i>Nom prenom</i>","<i>idConvention</i>",getSessionController().getApplicationNamePStage());
				break;
			case 3:
				this.contenuMailEval = getString("CONVENTION.ETAPE13.MAIL.CONTENU_ENTREPRISE",
						"<i>Nom prenom</i>","***",getSessionController().getApplicationNamePStage());
				break;
			default:
				break;
			}
		} else if (this.typeMailEval == 2){
			// Rappel
			switch (this.typeDestMailEval) {
			case 1:
				this.contenuMailEval = getString("CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ETUDIANT","<i>raison sociale de l'organisme d'accueil</i>",getSessionController().getApplicationNamePStage());
				break;
			case 2:
				this.contenuMailEval = getString("CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ENSEIGNANT",
						"<i>Nom prenom</i>","<i>idConvention</i>",getSessionController().getApplicationNamePStage());
				break;
			case 3:
				this.contenuMailEval = getString("CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ENTREPRISE",
						"<i>Nom prenom</i>","***",getSessionController().getApplicationNamePStage());
				break;
			default:
				break;
			}
		}
		return contenuMailEval;
	}

	/**
	 * Methode d'envoi des mail en masse pour les fiches d'evaluation
	 */
	public void envoiMailEvalEnMasse(){

		switch (this.typeDestMailEval) {
		case 1:
			for (ConventionDTO conventionTmp : this.rechercheConventionPaginator.getListe()){
				if (conventionTmp.isValidationConvention() && conventionTmp.getFicheEvaluation().isValidationEtudiant()){
					this.convention = getConventionDomainService().getConventionFromId(conventionTmp.getIdConvention());
					if ((this.convention.getReponseEvaluation() == null || !this.convention.getReponseEvaluation().isValidationEtudiant())
							&& ((!this.convention.isEnvoiMailEtudiant() && this.typeMailEval == 1)
									|| (this.convention.isEnvoiMailEtudiant() && this.typeMailEval == 2))){
						if (this.convention.getIdEtudiant() > 0) {
							EtudiantDTO etudiantTmp  = this.getEtudiantDomainService().getEtudiantFromId(this.convention.getIdEtudiant());
							if (etudiantTmp != null) {
								this.convention.setEtudiant(etudiantTmp);
							}
						}
						if (this.convention.getIdStructure() > 0) {
							StructureDTO structureTmp  = this.getStructureDomainService().getStructureFromId(this.convention.getIdStructure());
							if (structureTmp != null) {
								this.convention.setStructure(structureTmp);
							}
						}
						this.envoiMailEtudiant();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			break;
		case 2:
			for (ConventionDTO conventionTmp : this.rechercheConventionPaginator.getListe()){
				if (conventionTmp.isValidationConvention() && conventionTmp.getFicheEvaluation().isValidationEnseignant()){
					this.convention = getConventionDomainService().getConventionFromId(conventionTmp.getIdConvention());
					if ((this.convention.getReponseEvaluation() == null || !this.convention.getReponseEvaluation().isValidationEnseignant())
							&& ((!this.convention.isEnvoiMailTuteurPedago()&& this.typeMailEval == 1)
									|| (this.convention.isEnvoiMailTuteurPedago() && this.typeMailEval == 2))){
						if (this.convention.getIdEnseignant() > 0 ) {
							EnseignantDTO enseignantTmp = this.getEnseignantDomainService().getEnseignantFromId(this.convention.getIdEnseignant());
							if (enseignantTmp != null) {
								this.convention.setEnseignant(enseignantTmp);
							}
						}
						if (this.convention.getIdEtudiant() > 0) {
							EtudiantDTO etudiantTmp  = this.getEtudiantDomainService().getEtudiantFromId(this.convention.getIdEtudiant());
							if (etudiantTmp != null) {
								this.convention.setEtudiant(etudiantTmp);
							}
						}
						this.envoiMailEnseignant();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			break;
		case 3:
			for (ConventionDTO conventionTmp : this.rechercheConventionPaginator.getListe()){
				if (conventionTmp.isValidationConvention() && conventionTmp.getFicheEvaluation().isValidationEntreprise()){
					this.convention = getConventionDomainService().getConventionFromId(conventionTmp.getIdConvention());
					// On verifie que la fiche n'est pas deja saisie et qu'on envoie un 1er mail ou un mail de rappel
					if ((this.convention.getReponseEvaluation() == null || !this.convention.getReponseEvaluation().isValidationEntreprise())
							&& ((!this.convention.isEnvoiMailTuteurPro() && this.typeMailEval == 1)
									|| (this.convention.isEnvoiMailTuteurPro() && this.typeMailEval == 2))){
						if (this.convention.getIdContact() > 0) {
							ContactDTO contactTmp = this.getStructureDomainService().getContactFromId(this.convention.getIdContact());
							if (contactTmp != null) {
								this.convention.setContact(contactTmp);
							}
						}
						if (this.convention.getIdEtudiant() > 0) {
							EtudiantDTO etudiantTmp  = this.getEtudiantDomainService().getEtudiantFromId(this.convention.getIdEtudiant());
							if (etudiantTmp != null) {
								this.convention.setEtudiant(etudiantTmp);
							}
						}
						this.envoiMailEntreprise();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			break;
		default:
			break;
		}
		addInfoMessage("formEnvoiMailEval","CONVENTION.ETAPE13.MAIL.ENVOIMASSE_REUSSI");

		getSessionController().setEnvoiMailEvalCurrentPage("_envoiMailEval_etape2");
	}

	/**
	 * 
	 */
	public void avantEnvoiMailEval(){
		this.typeMailEval = 1;
		this.typeDestMailEval = 1;
	}

	/**
	 * Envoi d'un mail de demande de debloquage de la saisie pour le tuteur pro
	 */
	public void envoiDemandeInvalidation(){
		String nomContact = "";
		String nomEtu = "";

		if (this.convention.getIdEtudiant() > 0) {
			EtudiantDTO etudiantTmp  = this.getEtudiantDomainService().getEtudiantFromId(this.convention.getIdEtudiant());
			if (etudiantTmp != null) {
				nomEtu = etudiantTmp.getPrenom()+" "+etudiantTmp.getNom();
			} else {
				addErrorMessage(null, "CONVENTION.ETAPE13.MAIL.INEXISTANT_ETUDIANT",this.convention.getIdConvention());
				return;
			}
		}

		if (this.convention.getIdContact() > 0) {
			ContactDTO contactTmp = this.getStructureDomainService().getContactFromId(this.convention.getIdContact());
			if (contactTmp != null) {
				nomContact = contactTmp.getPrenom()+" "+contactTmp.getNom();
			} else {
				addErrorMessage(null, "CONVENTION.ETAPE13.MAIL.INEXISTANT_ENTREPRISE",this.convention.getIdConvention());
				return;
			}
		}

		String sujet = getSessionController().getApplicationNamePStage()+" - Evaluation de votre stage pour la convention n°"+this.convention.getIdConvention();
		String contenu = getString("CONVENTION.ETAPE13.MAIL.CONTENU_DEMANDE_INVALIDATION",
				nomContact,
				nomEtu,
				this.convention.getIdConvention(),
				getSessionController().getApplicationNamePStage());

		getSmtpService().send(getSessionController().getMailingListPStageIA(),
				sujet,
				contenu,
				"");

		addInfoMessage(null,"CONVENTION.ETAPE13.MAIL.ENVOI_REUSSI",getSessionController().getMailingListPStageIA(),this.convention.getIdConvention());

	}

	/**
	 * return
	 */
	public void exportFichesEtudiant() {

		List<ConventionDTO> listeExportEval = new ArrayList<ConventionDTO>();
		if (this.rechercheConventionPaginator.getListe()!= null){
			listeExportEval = this.rechercheConventionPaginator.getListe();
		}
		if (listeExportEval != null && !listeExportEval.isEmpty()){
			HSSFWorkbook classeur = new HSSFWorkbook();
			HSSFSheet sheet = classeur.createSheet("exportFichesEtudiant");

			HSSFRow row = sheet.createRow(0);

			List<String> header = new ArrayList<String>();
			FicheEvaluationDTO ficheEvaluation = getFicheEvaluationDomainService().getFicheEvaluationFromIdCentre(this.rechEvalIdCentre);

			header.add(getString("RECHERCHEEVALUATION.NUMCONVENTION"));

			//ajout colonne nom et prénom
			header.add(getString("CONVENTION.NOM"));
			header.add(getString("CONVENTION.PRENOM"));

			// Ajout des questions en fonction de leur utilisation ou non par le centre
			if (ficheEvaluation.isQuestionEtuI1()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.1"));
			if (ficheEvaluation.isQuestionEtuI2()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.2"));
			if (ficheEvaluation.isQuestionEtuI3()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.3"));
			if (ficheEvaluation.isQuestionEtuI4()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.4"));
			if (ficheEvaluation.isQuestionEtuI5()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.5"));
			if (ficheEvaluation.isQuestionEtuI6()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.6"));
			if (ficheEvaluation.isQuestionEtuI7()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.7"));
			if (ficheEvaluation.isQuestionEtuI8()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.8"));

			if (ficheEvaluation.isQuestionEtuII1()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.1"));
			if (ficheEvaluation.isQuestionEtuII2()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.2"));
			if (ficheEvaluation.isQuestionEtuII3()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.3"));
			if (ficheEvaluation.isQuestionEtuII4()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.4"));
			if (ficheEvaluation.isQuestionEtuII5()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.5"));
			if (ficheEvaluation.isQuestionEtuII6()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.6"));

			if (ficheEvaluation.isQuestionEtuIII1()) {
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.1_1"));			
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.1bis"));
			}
			if (ficheEvaluation.isQuestionEtuIII2()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.2"));
			//if (ficheEvaluation.isQuestionEtuIII3()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.3"));
			if (ficheEvaluation.isQuestionEtuIII4()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.4"));
			if (ficheEvaluation.isQuestionEtuIII5()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.5"));
			if (ficheEvaluation.isQuestionEtuIII6()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.6"));
			if (ficheEvaluation.isQuestionEtuIII7()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.7"));
			if (ficheEvaluation.isQuestionEtuIII8()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.8"));
			if (ficheEvaluation.isQuestionEtuIII9()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.9"));
			if (ficheEvaluation.isQuestionEtuIII10()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.10"));
			if (ficheEvaluation.isQuestionEtuIII11()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.11"));
			if (ficheEvaluation.isQuestionEtuIII12()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.12"));
			//if (ficheEvaluation.isQuestionEtuIII13()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.13"));
			if (ficheEvaluation.isQuestionEtuIII14()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.14"));
			if (ficheEvaluation.isQuestionEtuIII15()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.15"));
			if (ficheEvaluation.isQuestionEtuIII16()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.16"));

			// Creation des cellules Header
			for(int i=0;i<header.size();i++){
				row.createCell(i).setCellValue(header.get(i));
			}

			ReponseEvaluationDTO reponseTmp;
			ConventionDTO convention=new ConventionDTO();
			// Remplissage avec les reponses
			for (int i=0;i<listeExportEval.size();i++) {
				reponseTmp = listeExportEval.get(i).getReponseEvaluation();

				if (reponseTmp != null &&  reponseTmp.isValidationEtudiant()){
					row = sheet.createRow(i+1);
					int cpt=0;
					String reponse = "";

					// num convention
					row.createCell(cpt).setCellValue(listeExportEval.get(i).getIdConvention());
					cpt++;

					convention=listeExportEval.get(i);					
					convention=getConventionDomainService().getConventionFromId(convention.getIdConvention());

					// renseignement etudiant
					convention.setEtudiant(getEtudiantDomainService().getEtudiantFromId(convention.getIdEtudiant()));

					//nom
					row.createCell(cpt).setCellValue(convention.getEtudiant().getNom());
					cpt++;

					//prenom
					row.createCell(cpt).setCellValue(convention.getEtudiant().getPrenom());
					cpt++;

					if (ficheEvaluation.isQuestionEtuI1()){
						reponse = "";
						switch (reponseTmp.getReponseEtuI1()) {
						case 1 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.1.1");
							break;
						case 2 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.1.2");
							break;
						case 3 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.1.3");
							break;
						default:
							break;
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuI2()){
						reponse = "";
						switch (reponseTmp.getReponseEtuI2()) {
						case 1 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.2.1");
							break;
						case 2 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.2.2");
							break;
						case 3 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.2.3");
							break;
						case 4 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.2.4");
							break;
						case 5 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.2.5");
							break;
						default:
							break;
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuI3()){
						reponse = "";
						switch (reponseTmp.getReponseEtuI3()) {
						case 1 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.3.1");
							break;
						case 2 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.3.2");
							break;
						case 3 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.3.3");
							break;
						case 4 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.3.4");
							break;
						default:
							break;
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuI4()){
						reponse = "";
						if (reponseTmp.isReponseEtuI4a()) reponse+=getString("CENTRE.FICHE_EVALUATION.LIBELLES.MAIL");
						if (reponseTmp.isReponseEtuI4b()) reponse+=(" "+getString("CENTRE.FICHE_EVALUATION.LIBELLES.TELEPHONE"));
						if (reponseTmp.isReponseEtuI4c()) reponse+=(" "+getString("CENTRE.FICHE_EVALUATION.LIBELLES.COURRIER"));
						if (reponseTmp.isReponseEtuI4d()) reponse+=(" "+getString("CENTRE.FICHE_EVALUATION.LIBELLES.PROSPECTION"));
						if (reponse == ""){
							reponse = "NÉANT";
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuI5()){
						reponse = "";
						if (reponseTmp.getReponseEtuI5() > 0)
							reponse = getNomenclatureDomainService().getOrigineStageDTOFromId(reponseTmp.getReponseEtuI5()).getLibelle();
						if (reponse == null){
							reponse = "";
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuI6()){
						reponse = "";
						switch (reponseTmp.getReponseEtuI6()) {
						case 1 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.6.1");
							break;
						case 2 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.6.2");
							break;
						case 3 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.6.3");
							break;
						case 4 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.6.4");
							break;
						default:
							break;
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuI7()){
						reponse = "";						
						// Cas NON
						if (!reponseTmp.isReponseEtuI7()) {							
							switch (reponseTmp.getReponseEtuI7bis2()) {
							case 1 :
								reponse = (" FAUX - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.NON.1"));
								break;
							case 2 :
								reponse = (" FAUX - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.NON.2"));
								break;
							}
						}
						// Cas OUI
						if (reponseTmp.isReponseEtuI7()) {
							switch (reponseTmp.getReponseEtuI7bis1()) {
							case 1 :
								reponse =(" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.OUI.1"));
								break;
							case 2 :
								reponse = (" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.OUI.2"));
								break;
							case 3 :
								reponse = (" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.OUI.3")+" - Utilisation des ressources : "+ reponseTmp.isReponseEtuI7bis1a());
								break;
							case 4 :
								reponse = (" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.OUI.4"));
								break;
							case 5 :
								reponse = (" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.OUI.5") + " : "+reponseTmp.getReponseEtuI7bis1b());
								break;
							default:
								break;
							}
						}
						if (reponse == ""){
							reponse = "NÉANT";
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}


					if (ficheEvaluation.isQuestionEtuI8()) row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuI8()); cpt++;
					if (ficheEvaluation.isQuestionEtuII1()){
						if (reponseTmp.getReponseEtuII1()==4 || reponseTmp.getReponseEtuII1()==5)
							row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEtuII1())+" : "+reponseTmp.getReponseEtuII1bis());
						else
							row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEtuII1())); 
						cpt++;
					}										
					if (ficheEvaluation.isQuestionEtuII2()){
						if (reponseTmp.getReponseEtuII2()==4 || reponseTmp.getReponseEtuII2()==5)
							row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEtuII2())+" : "+reponseTmp.getReponseEtuII2bis());
						else
							row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEtuII2())); 
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuII3()){
						if (reponseTmp.getReponseEtuII3()==4 || reponseTmp.getReponseEtuII3()==5)
							row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEtuII3())+" : "+reponseTmp.getReponseEtuII3bis());
						else
							row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEtuII3())); 
						cpt++;							
					}
					if (ficheEvaluation.isQuestionEtuII4()) row.createCell(cpt).setCellValue(this.recupLibelleAvis(reponseTmp.getReponseEtuII4())); cpt++;
					//if (ficheEvaluation.isQuestionEtuII5()) row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuII5()); cpt++;

					if (ficheEvaluation.isQuestionEtuII5()){
						reponse = "";		
						//cas NON
						if (!reponseTmp.isReponseEtuII5()){
							row.createCell(cpt).setCellValue("Non");
							cpt++;
						}
						//cas OUI
						if (reponseTmp.isReponseEtuII5()){
							switch (reponseTmp.getReponseEtuII5a()){
							case 1 :
								if (reponseTmp.isReponseEtuII5b()){
									reponse = (" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.1")+" - Avec autonomie : VRAI");
								}else{
									reponse = (" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.1")+" - Avec autonomie : FAUX");
								}
								break;
							case 2 :
								if (reponseTmp.isReponseEtuII5b()){
									reponse = (" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.2")+" - Avec autonomie : VRAI");
								}else{
									reponse = (" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.2")+" - Avec autonomie : FAUX");
								}
								break;
							case 3 :
								if (reponseTmp.isReponseEtuII5b()){
									reponse = (" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.3")+" - Avec autonomie : VRAI");
								}else{
									reponse = (" VRAI - "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.3")+" - Avec autonomie : FAUX");
								}
								break;
							}
							row.createCell(cpt).setCellValue(reponse);
							cpt++;
						}
					}
					if (ficheEvaluation.isQuestionEtuII6()) row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuII6()); cpt++;

					if (ficheEvaluation.isQuestionEtuIII1()){
						row.createCell(cpt).setCellValue(convention.getSujetStage()); cpt++;
						if (reponseTmp.isReponseEtuIII1())
							row.createCell(cpt).setCellValue("VRAI, pour le sujet suivant : "+reponseTmp.getReponseEtuIII1bis()); 
						else
							row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII1());
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuIII2()){
						if (!reponseTmp.isReponseEtuIII2())
							row.createCell(cpt).setCellValue("FAUX : "+reponseTmp.getReponseEtuIII2bis()); 
						else
							row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII2()); 
						cpt++;
					}
					//if (ficheEvaluation.isQuestionEtuIII3()) row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII3()); cpt++;


					///// reprendre ici, reste la partie III ou les coms ne sont pas mis 


					if (ficheEvaluation.isQuestionEtuIII4()){
						reponse = "";
						switch (reponseTmp.getReponseEtuIII4()) {
						case 1 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.1");
							break;
						case 2 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.2");
							break;
						case 3 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.3");
							break;
						case 4 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.4");
							break;
						case 5 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.5");
							break;
						case 6 :
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.6");
							break;
						default:
							break;
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuIII5()){
						reponse="";
						if (reponseTmp.isReponseEtuIII5a()) reponse+=getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.5.1");
						if (reponseTmp.isReponseEtuIII5b()) reponse+=(" "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.5.2")+" : "+reponseTmp.getReponseEtuIII5bis());
						if (reponseTmp.isReponseEtuIII5c()) reponse+=(" "+getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.5.3"));
						if (reponse == ""){
							reponse = "NÉANT";
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuIII6()){
						if(reponseTmp.getReponseEtuIII6()==4 || reponseTmp.getReponseEtuIII6()==5)
							row.createCell(cpt).setCellValue(this.recupLibelleAvis(reponseTmp.getReponseEtuIII6())+" : "+reponseTmp.getReponseEtuIII6bis()); 
						else
							row.createCell(cpt).setCellValue(this.recupLibelleAvis(reponseTmp.getReponseEtuIII6())); 
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuIII7()){
						if(reponseTmp.getReponseEtuIII7()==4 || reponseTmp.getReponseEtuIII7()==5)
							row.createCell(cpt).setCellValue(this.recupLibelleAvis(reponseTmp.getReponseEtuIII7())+" : "+reponseTmp.getReponseEtuIII7bis()); 
						else
							row.createCell(cpt).setCellValue(this.recupLibelleAvis(reponseTmp.getReponseEtuIII7())); 
						cpt++;					
					}
					if (ficheEvaluation.isQuestionEtuIII8()){
						if (reponseTmp.isReponseEtuIII8())
							row.createCell(cpt).setCellValue("VRAI : "+reponseTmp.getReponseEtuIII8bis());
						else
							row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII8());
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuIII9()){
						if (!reponseTmp.isReponseEtuIII9())
							row.createCell(cpt).setCellValue("FAUX : "+reponseTmp.getReponseEtuIII9bis()); 
						else
							row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII9()); 
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuIII10()) row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII10()); cpt++;
					if (ficheEvaluation.isQuestionEtuIII11()) row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII11()); cpt++;
					if (ficheEvaluation.isQuestionEtuIII12()) row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII12()); cpt++;
					//if (ficheEvaluation.isQuestionEtuIII13()) row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII13()); cpt++;
					if (ficheEvaluation.isQuestionEtuIII14()) row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII14()); cpt++;
					if (ficheEvaluation.isQuestionEtuIII15()){
						if(reponseTmp.getReponseEtuIII15()==4 || reponseTmp.getReponseEtuIII15()==5)
							row.createCell(cpt).setCellValue(this.recupLibelleAvis(reponseTmp.getReponseEtuIII15())+" : "+reponseTmp.getReponseEtuIII15bis());
						else
							row.createCell(cpt).setCellValue(this.recupLibelleAvis(reponseTmp.getReponseEtuIII15())); 
						cpt++;
					}
					if (ficheEvaluation.isQuestionEtuIII16()){
						if(reponseTmp.getReponseEtuIII16()==4 || reponseTmp.getReponseEtuIII16()==5)
							row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEtuIII16())+" : "+reponseTmp.getReponseEtuIII16bis());
						else
							row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEtuIII16()));
					}

				}
			}

			try {
				ByteArrayOutputStream baosXLS = new ByteArrayOutputStream();

				classeur.write(baosXLS);

				ExportConventionsServlet edit = new ExportConventionsServlet();
				edit.doGet(baosXLS);
			} catch (Exception e){
				logger.error("exportFichesEtudiant() - Exception lors de la tentative d'ecriture du baosXLS : " + e.getMessage());
			}
		}
	}

	/**
	 * return
	 */
	public void exportFichesEnseignant() {
		List<ConventionDTO> listeExportEval = new ArrayList<ConventionDTO>();
		if (this.rechercheConventionPaginator.getListe()!= null){
			listeExportEval = this.rechercheConventionPaginator.getListe();
		}
		if (listeExportEval != null && !listeExportEval.isEmpty()){
			HSSFWorkbook classeur = new HSSFWorkbook();
			HSSFSheet sheet = classeur.createSheet("exportFichesEtudiant");

			HSSFRow row = sheet.createRow(0);

			List<String> header = new ArrayList<String>();

			FicheEvaluationDTO ficheEvaluation = getFicheEvaluationDomainService().getFicheEvaluationFromIdCentre(this.rechEvalIdCentre);

			header.add(getString("RECHERCHEEVALUATION.NUMCONVENTION"));

			//ajout des noms prenoms
			header.add(getString("CONVENTION.NOM"));
			header.add(getString("CONVENTION.PRENOM"));

			// Ajout des questions en fonction de leur utilisation ou non par le centre
			if (ficheEvaluation.isQuestionEnsI1()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.I.1"));
			if (ficheEvaluation.isQuestionEnsI2()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.I.2"));
			if (ficheEvaluation.isQuestionEnsI3()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.I.3"));

			if (ficheEvaluation.isQuestionEnsII1()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.1"));
			if (ficheEvaluation.isQuestionEnsII2()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.2"));
			if (ficheEvaluation.isQuestionEnsII3()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.3"));
			if (ficheEvaluation.isQuestionEnsII4()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.4"));
			if (ficheEvaluation.isQuestionEnsII5()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.5"));
			if (ficheEvaluation.isQuestionEnsII6()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.6"));
			if (ficheEvaluation.isQuestionEnsII7()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.7"));
			if (ficheEvaluation.isQuestionEnsII8()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.8"));
			if (ficheEvaluation.isQuestionEnsII9()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.9"));
			if (ficheEvaluation.isQuestionEnsII10()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.10"));
			if (ficheEvaluation.isQuestionEnsII11()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.11"));

			// Creation des cellules Header
			for(int i=0;i<header.size();i++){
				row.createCell(i).setCellValue(header.get(i));
			}

			ReponseEvaluationDTO reponseTmp;
			ConventionDTO convention=new ConventionDTO();
			// Remplissage avec les reponses
			for (int i=0;i<listeExportEval.size();i++) {
				reponseTmp = listeExportEval.get(i).getReponseEvaluation();

				if (reponseTmp != null && reponseTmp.isValidationEnseignant()){
					row = sheet.createRow(i+1);
					int cpt=0;
					String reponse = "";

					// num convention
					row.createCell(cpt).setCellValue(listeExportEval.get(i).getIdConvention());
					cpt++;

					convention=listeExportEval.get(i);

					convention=getConventionDomainService().getConventionFromId(convention.getIdConvention());

					// renseignement etudiant
					convention.setEtudiant(getEtudiantDomainService().getEtudiantFromId(convention.getIdEtudiant()));

					//nom
					row.createCell(cpt).setCellValue(convention.getEtudiant().getNom());
					cpt++;

					//prenom
					row.createCell(cpt).setCellValue(convention.getEtudiant().getPrenom());
					cpt++;

					if (ficheEvaluation.isQuestionEnsI1()){
						reponse = "";
						if (reponseTmp.isReponseEnsI1a()) reponse+=getString("CENTRE.FICHE_EVALUATION.LIBELLES.MAIL");
						if (reponseTmp.isReponseEnsI1b()) reponse+=(" "+getString("CENTRE.FICHE_EVALUATION.LIBELLES.TELEPHONE"));
						if (reponseTmp.isReponseEnsI1c()) reponse+=(" "+getString("CENTRE.FICHE_EVALUATION.LIBELLES.RENCONTRE"));

						if (reponse == ""){
							reponse = "NÉANT";
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}
					if (ficheEvaluation.isQuestionEnsI2()){
						reponse = "";
						if (reponseTmp.isReponseEnsI2a()) reponse+=getString("CENTRE.FICHE_EVALUATION.LIBELLES.MAIL");
						if (reponseTmp.isReponseEnsI2b()) reponse+=(" "+getString("CENTRE.FICHE_EVALUATION.LIBELLES.TELEPHONE"));
						if (reponseTmp.isReponseEnsI2c()) reponse+=(" "+getString("CENTRE.FICHE_EVALUATION.LIBELLES.RENCONTRE"));

						if (reponse == ""){
							reponse = "NÉANT";
						}
						row.createCell(cpt).setCellValue(reponse);
						cpt++;
					}
					if (ficheEvaluation.isQuestionEnsI3()) row.createCell(cpt).setCellValue(reponseTmp.getReponseEnsI3()); cpt++;

					if (ficheEvaluation.isQuestionEnsII1()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnsII1())); cpt++;
					if (ficheEvaluation.isQuestionEnsII2()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnsII2())); cpt++;
					if (ficheEvaluation.isQuestionEnsII3()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnsII3())); cpt++;
					if (ficheEvaluation.isQuestionEnsII4()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnsII4())); cpt++;
					if (ficheEvaluation.isQuestionEnsII5()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnsII5())); cpt++;
					if (ficheEvaluation.isQuestionEnsII6()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnsII6())); cpt++;
					if (ficheEvaluation.isQuestionEnsII7()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnsII7())); cpt++;
					if (ficheEvaluation.isQuestionEnsII8()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnsII8())); cpt++;
					if (ficheEvaluation.isQuestionEnsII9()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnsII9())); cpt++;
					if (ficheEvaluation.isQuestionEnsII10()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnsII10())); cpt++;
					if (ficheEvaluation.isQuestionEnsII11()) row.createCell(cpt).setCellValue(reponseTmp.getReponseEnsII11());
				}
			}
			try {
				ByteArrayOutputStream baosXLS = new ByteArrayOutputStream();

				classeur.write(baosXLS);

				ExportConventionsServlet edit = new ExportConventionsServlet();
				edit.doGet(baosXLS);
			} catch (Exception e){
				logger.error("exportConvention() - Exception lors de la tentative d'ecriture du baosXLS : " + e.getMessage());
			}
		}
	}

	/**
	 * return
	 */
	public void exportFichesEntreprise() {
		List<ConventionDTO> listeExportEval = new ArrayList<ConventionDTO>();
		if (this.rechercheConventionPaginator.getListe()!= null){
			listeExportEval = this.rechercheConventionPaginator.getListe();
		}
		if (listeExportEval != null && !listeExportEval.isEmpty()){
			HSSFWorkbook classeur = new HSSFWorkbook();
			HSSFSheet sheet = classeur.createSheet("exportFichesEtudiant");

			HSSFRow row = sheet.createRow(0);

			List<String> header = new ArrayList<String>();
			FicheEvaluationDTO ficheEvaluation = getFicheEvaluationDomainService().getFicheEvaluationFromIdCentre(this.rechEvalIdCentre);

			header.add(getString("RECHERCHEEVALUATION.NUMCONVENTION"));

			//ajout des noms prenoms
			header.add(getString("CONVENTION.NOM"));
			header.add(getString("CONVENTION.PRENOM"));

			// Ajout des questions en fonction de leur utilisation ou non par le centre
			if (ficheEvaluation.isQuestionEnt1()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.1"));
			if (ficheEvaluation.isQuestionEnt2()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.2"));
			if (ficheEvaluation.isQuestionEnt3()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.3"));			
			if (ficheEvaluation.isQuestionEnt5()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.5"));
			if (ficheEvaluation.isQuestionEnt9()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.9"));
			if (ficheEvaluation.isQuestionEnt11()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.11"));
			if (ficheEvaluation.isQuestionEnt12()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.12"));
			if (ficheEvaluation.isQuestionEnt13()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.13"));			
			if (ficheEvaluation.isQuestionEnt14()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.14"));

			if (ficheEvaluation.isQuestionEnt4()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.4"));			
			if (ficheEvaluation.isQuestionEnt6()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.6"));
			if (ficheEvaluation.isQuestionEnt7()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.7"));
			if (ficheEvaluation.isQuestionEnt8()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.8"));
			if (ficheEvaluation.isQuestionEnt15()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.15"));

			if (ficheEvaluation.isQuestionEnt16()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.16"));
			if (ficheEvaluation.isQuestionEnt17()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.17"));
			if (ficheEvaluation.isQuestionEnt19()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.19"));
			if (ficheEvaluation.isQuestionEnt10()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.10"));
			if (ficheEvaluation.isQuestionEnt18()) header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.18"));

			// Creation des cellules Header
			for(int i=0;i<header.size();i++){
				row.createCell(i).setCellValue(header.get(i));
			}

			ReponseEvaluationDTO reponseTmp;
			ConventionDTO convention=new ConventionDTO();
			// Remplissage avec les reponses
			for (int i=0;i<listeExportEval.size();i++) {
				reponseTmp = listeExportEval.get(i).getReponseEvaluation();

				if (reponseTmp != null && reponseTmp.isValidationEntreprise()){
					row = sheet.createRow(i+1);
					int cpt=0;

					// num convention
					row.createCell(cpt).setCellValue(listeExportEval.get(i).getIdConvention());
					cpt++;

					convention=listeExportEval.get(i);					
					convention=getConventionDomainService().getConventionFromId(convention.getIdConvention());

					// renseignement etudiant
					convention.setEtudiant(getEtudiantDomainService().getEtudiantFromId(convention.getIdEtudiant()));

					//nom
					row.createCell(cpt).setCellValue(convention.getEtudiant().getNom());
					cpt++;

					//prenom
					row.createCell(cpt).setCellValue(convention.getEtudiant().getPrenom());
					cpt++;


					if (ficheEvaluation.isQuestionEnt1()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt1())+" : "+reponseTmp.getReponseEnt1bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt2()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt2())+" : "+reponseTmp.getReponseEnt2bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt3()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt3())); cpt++;
					if (ficheEvaluation.isQuestionEnt5()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt5())+" : "+reponseTmp.getReponseEnt5bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt9()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt9())+" : "+reponseTmp.getReponseEnt9bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt11()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt11())+" : "+reponseTmp.getReponseEnt11bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt12()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt12())+" : "+reponseTmp.getReponseEnt12bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt13()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt13())+" : "+reponseTmp.getReponseEnt13bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt14()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt14())+" : "+reponseTmp.getReponseEnt14bis()); cpt++;

					if (ficheEvaluation.isQuestionEnt4()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt4())+" : "+reponseTmp.getReponseEnt4bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt6()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt6())+" : "+reponseTmp.getReponseEnt6bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt7()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt7())+" : "+reponseTmp.getReponseEnt7bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt8()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt8())+" : "+reponseTmp.getReponseEnt8bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt15()) row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt15())+" : "+reponseTmp.getReponseEnt15bis()); cpt++;

					if (ficheEvaluation.isQuestionEnt16()) row.createCell(cpt).setCellValue(this.recupLibelleAvis(reponseTmp.getReponseEnt16())+" : "+reponseTmp.getReponseEnt16bis()); cpt++;
					if (ficheEvaluation.isQuestionEnt17()) {
						if (reponseTmp.getReponseEnt17()==4 || reponseTmp.getReponseEnt17()==5)
							row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt17())+" : "+reponseTmp.getReponseEnt17bis());
						else
							row.createCell(cpt).setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEnt17()));
						cpt++;
					}
					if (ficheEvaluation.isQuestionEnt19()) row.createCell(cpt).setCellValue(reponseTmp.getReponseEnt19());cpt++;
					if (ficheEvaluation.isQuestionEnt10()) row.createCell(cpt).setCellValue(reponseTmp.isReponseEnt10()); cpt++;
					if (ficheEvaluation.isQuestionEnt18()) {
						if (!reponseTmp.isReponseEnt18())
							row.createCell(cpt).setCellValue(" FAUX : "+reponseTmp.getReponseEnt18bis()); 
						else
							row.createCell(cpt).setCellValue(reponseTmp.isReponseEnt18()); 
						cpt++;
					}
				}
			}
			try {
				ByteArrayOutputStream baosXLS = new ByteArrayOutputStream();

				classeur.write(baosXLS);

				ExportConventionsServlet edit = new ExportConventionsServlet();
				edit.doGet(baosXLS);
			} catch (Exception e){
				logger.error("exportConvention() - Exception lors de la tentative d'ecriture du baosXLS : " + e.getMessage());
			}
		}
	}

	/**
	 * @param idNotation
	 * @return
	 */
	private String recupLibelleNotation(int idNotation){
		switch (idNotation) {
		case 1:
			return getString("CENTRE.FICHE_EVALUATION.NOTATION.1");
		case 2:
			return getString("CENTRE.FICHE_EVALUATION.NOTATION.2");
		case 3:
			return getString("CENTRE.FICHE_EVALUATION.NOTATION.3");
		case 4:
			return getString("CENTRE.FICHE_EVALUATION.NOTATION.4");
		case 5:
			return getString("CENTRE.FICHE_EVALUATION.NOTATION.5");
		default:
			return null;
		}
	}
	/**
	 * @param idAvis
	 * @return
	 */
	private String recupLibelleAvis(int idAvis){
		switch (idAvis) {
		case 1:
			return getString("CENTRE.FICHE_EVALUATION.AVIS.1");
		case 2:
			return getString("CENTRE.FICHE_EVALUATION.AVIS.2");
		case 3:
			return getString("CENTRE.FICHE_EVALUATION.AVIS.3");
		case 4:
			return getString("CENTRE.FICHE_EVALUATION.AVIS.4");
		case 5:
			return getString("CENTRE.FICHE_EVALUATION.AVIS.5");
		default:
			return null;
		}
	}


	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/
	/**
	 * @return the choixEtape
	 */
	public boolean isChoixEtape() {
		return choixEtape;
	}
	/**
	 * @return the convention
	 */
	public ConventionDTO getConvention() {
		return convention;
	}
	/**
	 * @param convention the convention to set
	 */
	public void setConvention(final ConventionDTO convention) {
		this.convention = convention;
	}
	/**
	 * @return the rechIdentEtudiant
	 */
	public String getRechIdentEtudiant() {
		return rechIdentEtudiant;
	}
	/**
	 * @param rechIdentEtudiant the rechIdentEtudiant to set
	 */
	public void setRechIdentEtudiant(final String rechIdentEtudiant) {
		this.rechIdentEtudiant = rechIdentEtudiant;
	}
	/**
	 * @return the rechNomEtudiant
	 */
	public String getRechNomEtudiant() {
		return rechNomEtudiant;
	}
	/**
	 * @param rechNomEtudiant the rechNomEtudiant to set
	 */
	public void setRechNomEtudiant(final String rechNomEtudiant) {
		this.rechNomEtudiant = rechNomEtudiant;
	}
	/**
	 * @return the rechPrenomEtudiant
	 */
	public String getRechPrenomEtudiant() {
		return rechPrenomEtudiant;
	}
	/**
	 * @param rechPrenomEtudiant the rechPrenomEtudiant to set
	 */
	public void setRechPrenomEtudiant(final String rechPrenomEtudiant) {
		this.rechPrenomEtudiant = rechPrenomEtudiant;
	}
	/**
	 * @return the listeResultatsRechercheEtudiant
	 */
	public List<EtudiantRef> getListeResultatsRechercheEtudiant() {
		return listeResultatsRechercheEtudiant;
	}
	/**
	 * @param listeResultatsRechercheEtudiant the listeResultatsRechercheEtudiant to set
	 */
	public void setListeResultatsRechercheEtudiant(
			final List<EtudiantRef> listeResultatsRechercheEtudiant) {
		this.listeResultatsRechercheEtudiant = listeResultatsRechercheEtudiant;
	}
	/**
	 * @return the resultatEtudiantRef
	 */
	public EtudiantRef getResultatEtudiantRef() {
		return resultatEtudiantRef;
	}
	/**
	 * @param resultatEtudiantRef the resultatEtudiantRef to set
	 */
	public void setResultatEtudiantRef(final EtudiantRef resultatEtudiantRef) {
		this.resultatEtudiantRef = resultatEtudiantRef;
	}
	/**
	 * @return the etudiantRef
	 */
	public EtudiantRef getEtudiantRef() {
		return etudiantRef;
	}
	/**
	 * @param etudiantRef the etudiantRef to set
	 */
	public void setEtudiantRef(final EtudiantRef etudiantRef) {
		this.etudiantRef = etudiantRef;
	}
	/**
	 * @return the listeEtapesEtudiant
	 */
	public List<SelectItem> getListeEtapesEtudiant() {
		return listeEtapesEtudiant;
	}
	/**
	 * @param listeEtapesEtudiant the listeEtapesEtudiant to set
	 */
	public void setListeEtapesEtudiant(final List<SelectItem> listeEtapesEtudiant) {
		this.listeEtapesEtudiant = listeEtapesEtudiant;
	}
	/**
	 * @return the listeUfrsEtudiant
	 */
	public List<SelectItem> getListeUfrsEtudiant() {
		listeUfrsEtudiant = new ArrayList<SelectItem>();
		if (this.resultatEtudiantRef != null) {
			if (this.resultatEtudiantRef.getStudys() != null) {
				LinkedHashMap<String,String> ufrs = (LinkedHashMap<String, String>) this.resultatEtudiantRef.getStudys();
				if (ufrs != null) {
					String clef = null;
					String valeur = null;
					Iterator<String> i = this.resultatEtudiantRef.getStudys().keySet().iterator();
					while (i.hasNext())	{
						clef = i.next();
						valeur = this.resultatEtudiantRef.getStudys().get(clef);
						listeUfrsEtudiant.add(new SelectItem(clef, valeur));
					}
				}
			}

		}

		return listeUfrsEtudiant;
	}
	/**
	 * @param listeUfrsEtudiant the listeUfrsEtudiant to set
	 */
	public void setListeUfrsEtudiant(final List<SelectItem> listeUfrsEtudiant) {
		this.listeUfrsEtudiant = listeUfrsEtudiant;
	}
	/**
	 * @return the selectedUfr
	 */
	public Object getSelectedUfr() {
		return selectedUfr;
	}
	/**
	 * @param selectedUfr the selectedUfr to set
	 */
	public void setSelectedUfr(final Object selectedUfr) {
		this.selectedUfr = selectedUfr;
	}
	/**
	 * @param choixEtape the choixEtape to set
	 */
	public void setChoixEtape(final boolean choixEtape) {
		this.choixEtape = choixEtape;
	}
	/**
	 * @return the listeELPEtapes
	 */
	public List<ElementPedagogique> getListeELPEtapes() {
		return listeELPEtapes;
	}
	/**
	 * @param listeELPEtapes the listeELPEtapes to set
	 */
	public void setListeELPEtapes(final List<ElementPedagogique> listeELPEtapes) {
		this.listeELPEtapes = listeELPEtapes;
	}
	/**
	 * @return the selTypeConvention
	 */
	public TypeConventionDTO getSelTypeConvention() {
		return selTypeConvention;
	}
	/**
	 * @param selTypeConvention the selTypeConvention to set
	 */
	public void setSelTypeConvention(final TypeConventionDTO selTypeConvention) {
		this.selTypeConvention = selTypeConvention;
	}
	/**
	 * @return the selTheme
	 */
	public ThemeDTO getSelTheme() {
		return selTheme;
	}
	/**
	 * @param selTheme the selTheme to set
	 */
	public void setSelTheme(final ThemeDTO selTheme) {
		this.selTheme = selTheme;
	}
	/**
	 * @return the ctrlInfosEtuOK
	 */
	public boolean isCtrlInfosEtuOK() {
		return ctrlInfosEtuOK;
	}
	/**
	 * @param ctrlInfosEtuOK the ctrlInfosEtuOK to set
	 */
	public void setCtrlInfosEtuOK(final boolean ctrlInfosEtuOK) {
		this.ctrlInfosEtuOK = ctrlInfosEtuOK;
	}
	/**
	 * @return the datePattern
	 */
	public static String getDatePattern() {
		return datePattern;
	}
	/**
	 * @return the selUniteDureeExceptionnelle
	 */
	public UniteDureeDTO getSelUniteDureeExceptionnelle() {
		return selUniteDureeExceptionnelle;
	}
	/**
	 * @param selUniteDureeExceptionnelle the selUniteDureeExceptionnelle to set
	 */
	public void setSelUniteDureeExceptionnelle(
			final UniteDureeDTO selUniteDureeExceptionnelle) {
		this.selUniteDureeExceptionnelle = selUniteDureeExceptionnelle;
	}
	/**
	 * @return the selTempsTravail
	 */
	public TempsTravailDTO getSelTempsTravail() {
		return selTempsTravail;
	}
	/**
	 * @param selTempsTravail the selTempsTravail to set
	 */
	public void setSelTempsTravail(final TempsTravailDTO selTempsTravail) {
		this.selTempsTravail = selTempsTravail;
	}
	/**
	 * @return the selIndemnisation
	 */
	public IndemnisationDTO getSelIndemnisation() {
		return selIndemnisation;
	}
	/**
	 * @param selIndemnisation the selIndemnisation to set
	 */
	public void setSelIndemnisation(final IndemnisationDTO selIndemnisation) {
		this.selIndemnisation = selIndemnisation;
	}
	/**
	 * @return the selUniteGratification
	 */
	public UniteGratificationDTO getSelUniteGratification() {
		return selUniteGratification;
	}
	/**
	 * @param selUniteGratification the selUniteGratification to set
	 */
	public void setSelUniteGratification(final UniteGratificationDTO selUniteGratification) {
		this.selUniteGratification = selUniteGratification;
	}
	/**
	 * @return the selModeVersGratification
	 */
	public ModeVersGratificationDTO getSelModeVersGratification() {
		return selModeVersGratification;
	}
	/**
	 * @param selModeVersGratification the selModeVersGratification to set
	 */
	public void setSelModeVersGratification(
			final ModeVersGratificationDTO selModeVersGratification) {
		this.selModeVersGratification = selModeVersGratification;
	}
	/**
	 * @return the selModeValidationStage
	 */
	public ModeValidationStageDTO getSelModeValidationStage() {
		return selModeValidationStage;
	}
	/**
	 * @param selModeValidationStage the selModeValidationStage to set
	 */
	public void setSelModeValidationStage(
			final ModeValidationStageDTO selModeValidationStage) {
		this.selModeValidationStage = selModeValidationStage;
	}
	/**
	 * @return the selNatureTravail
	 */
	public NatureTravailDTO getSelNatureTravail() {
		return selNatureTravail;
	}
	/**
	 * @param selNatureTravail the selNatureTravail to set
	 */
	public void setSelNatureTravail(final NatureTravailDTO selNatureTravail) {
		this.selNatureTravail = selNatureTravail;
	}
	/**
	 * @return the ctrlInfosStageOK
	 */
	public boolean isCtrlInfosStageOK() {
		return ctrlInfosStageOK;
	}
	/**
	 * @param ctrlInfosStageOK the ctrlInfosStageOK to set
	 */
	public void setCtrlInfosStageOK(final boolean ctrlInfosStageOK) {
		this.ctrlInfosStageOK = ctrlInfosStageOK;
	}
	/**
	 * @return the selOrigineStage
	 */
	public OrigineStageDTO getSelOrigineStage() {
		return selOrigineStage;
	}
	/**
	 * @param selOrigineStage the selOrigineStage to set
	 */
	public void setSelOrigineStage(final OrigineStageDTO selOrigineStage) {
		this.selOrigineStage = selOrigineStage;
	}
	/**
	 * @return the rechNomEnseignant
	 */
	public String getRechNomEnseignant() {
		return rechNomEnseignant;
	}
	/**
	 * @param rechNomEnseignant the rechNomEnseignant to set
	 */
	public void setRechNomEnseignant(final String rechNomEnseignant) {
		this.rechNomEnseignant = rechNomEnseignant;
	}
	/**
	 * @return the rechPrenomEnseignant
	 */
	public String getRechPrenomEnseignant() {
		return rechPrenomEnseignant;
	}

	/**
	 * @param rechPrenomEnseignant the rechPrenomEnseignant to set
	 */
	public void setRechPrenomEnseignant(final String rechPrenomEnseignant) {
		this.rechPrenomEnseignant = rechPrenomEnseignant;
	}
	/**
	 * @return the selCodeAffectationEnseignant
	 */
	public String getSelCodeAffectationEnseignant() {
		return selCodeAffectationEnseignant;
	}
	/**
	 * @param selCodeAffectationEnseignant the selCodeAffectationEnseignant to set
	 */
	public void setSelCodeAffectationEnseignant(final String selCodeAffectationEnseignant) {
		this.selCodeAffectationEnseignant = selCodeAffectationEnseignant;
	}
	/**
	 * @return the listeAffectation
	 */
	@SessionCache
	public List<SelectItem> getListeAffectation() {
		listeAffectation = new ArrayList<SelectItem>();
		try {
			LinkedHashMap<String,String> compo =
					(LinkedHashMap<String, String>) getPersonalComponentRepositoryDomain().getComposantesRef(getSessionController().getCodeUniversite());
			if (compo != null) {
				String clef = null;
				String valeur = null;
				Iterator<String> i = compo.keySet().iterator();
				while (i.hasNext()) {
					clef = i.next();
					valeur = compo.get(clef);
					listeAffectation.add(new SelectItem(clef, valeur));
				}
			}
		} catch (CommunicationApogeeException e) {
			addErrorMessage(null, "APOGEE.ERREUR");

			return listeAffectation;
		}

		Collections.sort(listeAffectation, new ComparatorSelectItem());
		setListeAffectation(listeAffectation);
		return listeAffectation;
	}
	/**
	 * @param listeAffectation the listeAffectation to set
	 */
	public void setListeAffectation(final List<SelectItem> listeAffectation) {
		this.listeAffectation = listeAffectation;
	}
	/**
	 * @return the listeResultatsRechercheEnseignant
	 */
	public List<EnseignantDTO> getListeResultatsRechercheEnseignant() {
		return listeResultatsRechercheEnseignant;
	}
	/**
	 * @param listeResultatsRechercheEnseignant the listeResultatsRechercheEnseignant to set
	 */
	public void setListeResultatsRechercheEnseignant(
			final List<EnseignantDTO> listeResultatsRechercheEnseignant) {
		this.listeResultatsRechercheEnseignant = listeResultatsRechercheEnseignant;
	}
	/**
	 * @return the listeEnseignant
	 */
	public List<EnseignantDTO> getListeEnseignant() {
		return listeEnseignant;
	}
	/**
	 * @param listeEnseignant the listeEnseignant to set
	 */
	public void setListeEnseignant(final List<EnseignantDTO> listeEnseignant) {
		this.listeEnseignant = listeEnseignant;
	}
	/**
	 * @return the resultatEnseignant
	 */
	public EnseignantDTO getResultatEnseignant() {
		return resultatEnseignant;
	}
	/**
	 * @param resultatEnseignant the resultatEnseignant to set
	 */
	public void setResultatEnseignant(final EnseignantDTO resultatEnseignant) {
		this.resultatEnseignant = resultatEnseignant;
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
			final EtablissementController etablissementController) {
		this.etablissementController = etablissementController;
	}
	/**
	 * @return the centreController
	 */
	public CentreController getCentreController() {
		return centreController;
	}
	/**
	 * @param centreController the centreController to set
	 */
	public void setCentreController(final CentreController centreController) {
		this.centreController = centreController;
	}
	/**
	 * @param booltemConfSujetTeme the booltemConfSujetTeme to set
	 */
	public void setBooltemConfSujetTeme(final boolean booltemConfSujetTeme) {

		this.booltemConfSujetTeme = booltemConfSujetTeme;
		if (booltemConfSujetTeme) {
			this.convention.setTemConfSujetTeme("O");
		} else {
			this.convention.setTemConfSujetTeme("N");
		}
	}
	/**
	 * @return the booltemConfSujetTeme
	 */
	public boolean isBooltemConfSujetTeme() {
		booltemConfSujetTeme = false;
		if (this.convention != null) {
			if (StringUtils.hasText(this.convention.getTemConfSujetTeme())) {
				if (this.convention.getTemConfSujetTeme().equals("O")) {
					booltemConfSujetTeme = true;
				}
			}
		}

		return booltemConfSujetTeme;
	}
	/**
	 * @return the idSignataireSel
	 */
	public int getIdSignataireSel() {
		return idSignataireSel;
	}
	/**
	 * @param idSignataireSel the idSignataireSel to set
	 */
	public void setIdSignataireSel(final int idSignataireSel) {
		this.idSignataireSel = idSignataireSel;
	}
	/**
	 * @return the signataireSel
	 */
	public ContactDTO getSignataireSel() {
		return signataireSel;
	}
	/**
	 * @param signataireSel the signataireSel to set
	 */
	public void setSignataireSel(final ContactDTO signataireSel) {
		this.signataireSel = signataireSel;
	}
	/**
	 * @return the critereRechercheConvention
	 */
	public CritereRechercheConventionDTO getCritereRechercheConvention() {
		return critereRechercheConvention;
	}
	/**
	 * @param critereRechercheConvention the critereRechercheConvention to set
	 */
	public void setCritereRechercheConvention(
			final CritereRechercheConventionDTO critereRechercheConvention) {
		this.critereRechercheConvention = critereRechercheConvention;
	}
	/**
	 * @return the rechTypesStatutsStructure
	 */
	public List<SelectItem> getRechTypesStatutsStructure() {
		rechTypesStatutsStructure = new ArrayList<SelectItem>();
		List<TypeStructureDTO> lt = getNomenclatureDomainService().getTypesStructure();
		for (TypeStructureDTO t : lt) {
			rechTypesStatutsStructure.add(new SelectItem("t" + t.getId(), t.getLibelle()));
			List<StatutJuridiqueDTO> lc = getNomenclatureDomainService().getStatutsJuridiquesFromIdTypeStructure(t.getId());
			if (lc!=null && !lc.isEmpty()){
				for (StatutJuridiqueDTO s: lc) {
					rechTypesStatutsStructure.add(new SelectItem("s"+s.getId(), "--- "+s.getLibelle()));
				}
			}
		}
		return rechTypesStatutsStructure;
	}
	/**
	 * @param rechTypesStatutsStructure the rechTypesStatutsStructure to set
	 */
	public void setRechTypesStatutsStructure(
			final List<SelectItem> rechTypesStatutsStructure) {
		this.rechTypesStatutsStructure = rechTypesStatutsStructure;
	}
	/**
	 * @return the rechTypeOuStatut
	 */
	public String getRechTypeOuStatut() {
		return rechTypeOuStatut;
	}
	/**
	 * @param rechTypeOuStatut the rechTypeOuStatut to set
	 */
	public void setRechTypeOuStatut(final String rechTypeOuStatut) {
		this.rechTypeOuStatut = rechTypeOuStatut;
	}
	/**
	 * @return the estValidee
	 */
	public String getEstValidee() {
		return estValidee;
	}
	/**
	 * @param estValidee the estValidee to set
	 */
	public void setEstValidee(final String estValidee) {
		this.estValidee = estValidee;
	}
	/**
	 * @return the rechEtapes
	 */
	public List<SelectItem> getRechEtapes() {
		rechEtapes=null;
		List<EtapeDTO> l=getConventionDomainService().getEtapesFromIdsCentreGestion(getSessionController().getCurrentIdsCentresGestion(), getSessionController().getCodeUniversite());
		if(l!=null &&!l.isEmpty()){
			rechEtapes=new ArrayList<SelectItem>();
			for(EtapeDTO e : l){
				rechEtapes.add(new SelectItem(e.getCode(),e.getCode() + " - " + e.getLibelle()));
			}
		}
		if (rechEtapes != null) {
			Collections.sort(rechEtapes, new ComparatorSelectItem());
		}
		return rechEtapes;
	}
	/**
	 * @param rechEtapes the rechEtapes to set
	 */
	public void setRechEtapes(final List<SelectItem> rechEtapes) {
		this.rechEtapes = rechEtapes;
	}
	/**
	 * @return the rechUfrs
	 */
	public List<SelectItem> getRechUfrs() {
		rechUfrs=null;
		List<UfrDTO> l=getConventionDomainService().getUfrsFromIdsCentreGestion(getSessionController().getCurrentIdsCentresGestion(), getSessionController().getCodeUniversite());
		if(l!=null &&!l.isEmpty()){
			rechUfrs=new ArrayList<SelectItem>();
			for(UfrDTO u : l){
				rechUfrs.add(new SelectItem(u.getCode(),u.getLibelle()));
			}
		}
		return rechUfrs;
	}
	/**
	 * @param rechUfrs the rechUfrs to set
	 */
	public void setRechUfrs(final List<SelectItem> rechUfrs) {
		this.rechUfrs = rechUfrs;
	}
	/**
	 * @return the resultatsRechercheConvention
	 */
	public List<ConventionDTO> getResultatsRechercheConvention() {
		return resultatsRechercheConvention;
	}
	/**
	 * @param resultatsRechercheConvention the resultatsRechercheConvention to set
	 */
	public void setResultatsRechercheConvention(
			final List<ConventionDTO> resultatsRechercheConvention) {
		this.resultatsRechercheConvention = resultatsRechercheConvention;
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
	public void setRechercheAvancee(final boolean rechercheAvancee) {
		this.rechercheAvancee = rechercheAvancee;
	}
	/**
	 * @return the rechercheConventionPaginator
	 */
	public RechercheConventionPaginator getRechercheConventionPaginator() {
		return rechercheConventionPaginator;
	}
	/**
	 * @param rechercheConventionPaginator the rechercheConventionPaginator to set
	 */
	public void setRechercheConventionPaginator(
			final RechercheConventionPaginator rechercheConventionPaginator) {
		this.rechercheConventionPaginator = rechercheConventionPaginator;
	}
	/**
	 * @return the selLangueConvention
	 */
	public LangueConventionDTO getSelLangueConvention() {
		return selLangueConvention;
	}
	/**
	 * @param selLangueConvention the selLangueConvention to set
	 */
	public void setSelLangueConvention(final LangueConventionDTO selLangueConvention) {
		this.selLangueConvention = selLangueConvention;
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
	public void setCastorService(final CastorService castorService) {
		this.castorService = castorService;
	}
	/**
	 * @return the nomEdition
	 */
	public String getNomEdition() {
		return nomEdition;
	}
	/**
	 * @param nomEdition the nomEdition to set
	 */
	public void setNomEdition(final String nomEdition) {
		this.nomEdition = nomEdition;
	}
	/**
	 * @return the startYearDay
	 */
	public String getStartYearDay() {
		return startYearDay;
	}
	/**
	 * @param startYearDay the startYearDay to set
	 */
	public void setStartYearDay(final String startYearDay) {
		this.startYearDay = startYearDay;
	}
	/**
	 * @return the startYearMonth
	 */
	public String getStartYearMonth() {
		return startYearMonth;
	}
	/**
	 * @param startYearMonth the startYearMonth to set
	 */
	public void setStartYearMonth(final String startYearMonth) {
		this.startYearMonth = startYearMonth;
	}
	/**
	 * @return the currentConvention
	 */
	public ConventionDTO getCurrentConvention() {
		return currentConvention;
	}
	/**
	 * @param currentConvention the currentConvention to set
	 */
	public void setCurrentConvention(final ConventionDTO currentConvention) {
		this.currentConvention = currentConvention;
	}
	/**
	 * @return the sequenceEtapeEnumSel
	 */
	public SequenceEtapeEnumSel getSequenceEtapeEnumSel() {
		return sequenceEtapeEnumSel;
	}
	/**
	 * @param sequenceEtapeEnumSel the sequenceEtapeEnumSel to set
	 */
	public void setSequenceEtapeEnumSel(final SequenceEtapeEnumSel sequenceEtapeEnumSel) {
		this.sequenceEtapeEnumSel = sequenceEtapeEnumSel;
	}
	/**
	 * @return the selAssurance
	 */
	public AssuranceDTO getSelAssurance() {
		return selAssurance;
	}
	/**
	 * @param selAssurance the selAssurance to set
	 */
	public void setSelAssurance(final AssuranceDTO selAssurance) {
		this.selAssurance = selAssurance;
	}

	/**
	 * @return the selCaisseRegime
	 */
	public CaisseRegimeDTO getSelCaisseRegime() {
		return selCaisseRegime;
	}
	/**
	 * @param selCaisseRegime the selCaisseRegime to set
	 */
	public void setSelCaisseRegime(final CaisseRegimeDTO selCaisseRegime) {
		this.selCaisseRegime = selCaisseRegime;
	}
	/**
	 * @return the numOffreConvention
	 */
	public String getNumOffreConvention() {
		return numOffreConvention;
	}
	/**
	 * @param numOffreConvention the numOffreConvention to set
	 */
	public void setNumOffreConvention(final String numOffreConvention) {
		this.numOffreConvention = numOffreConvention;
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
	public void setRechercheController(final RechercheController rechercheController) {
		this.rechercheController = rechercheController;
	}
	/**
	 * @return the retourAction
	 */
	public String getRetourAction() {
		return retourAction;
	}

	/**
	 * @param retourAction the retourAction to set
	 */
	public void setRetourAction(final String retourAction) {
		this.retourAction = retourAction;
	}

	/**
	 * @return the intituleOffreConvention
	 */
	public String getIntituleOffreConvention() {
		return intituleOffreConvention;
	}

	/**
	 * @param intituleOffreConvention the intituleOffreConvention to set
	 */
	public void setIntituleOffreConvention(String intituleOffreConvention) {
		this.intituleOffreConvention = intituleOffreConvention;
	}

	/**
	 * @return the exportController
	 */
	public ExportController getExportController() {
		return exportController;
	}

	/**
	 * @param exportController the exportController to set
	 */
	public void setExportController(ExportController exportController) {
		this.exportController = exportController;
	}

	/**
	 * @return the conventionCree
	 */
	public boolean isConventionCree() {
		return conventionCree;
	}

	/**
	 * @param conventionCree the conventionCree to set
	 */
	public void setConventionCree(boolean conventionCree) {
		this.conventionCree = conventionCree;
	}

	/**
	 * @return the editConvFR
	 */
	public boolean isEditConvFR() {
		return editConvFR;
	}

	/**
	 * @param editConvFR the editConvFR to set
	 */
	public void setEditConvFR(boolean editConvFR) {
		this.editConvFR = editConvFR;
	}

	/**
	 * @return the listeAnneeUnivConvention
	 */
	public List<SelectItem> getListeAnneeUnivConvention() {
		this.listeAnneeUnivConvention = new ArrayList<SelectItem>();
		List<String> an = new ArrayList<String>(); 
		Calendar debutStage = Calendar.getInstance();
		debutStage.setTime(this.convention.getDateDebutStage());
		int year = debutStage.get(Calendar.YEAR);
		an.add((year - 1) + "/" + year);
		an.add(year + "/" + (year + 1));
		if (!an.isEmpty()){
			for(String s : an){
				listeAnneeUnivConvention.add(new SelectItem(s,s));
			}
		}
		return listeAnneeUnivConvention;

	}

	/**
	 * @param listeAnneeUnivConvention the listeAnneeUnivConvention to set
	 */
	public void setListeAnneeUnivConvention(
			List<SelectItem> listeAnneeUnivConvention) {
		this.listeAnneeUnivConvention = listeAnneeUnivConvention;
	}

	/**
	 * @return the selAnneeUniversitaire
	 */
	public Object getSelAnneeUniversitaire() {
		return selAnneeUniversitaire;
	}

	/**
	 * @param selAnneeUniversitaire the selAnneeUniversitaire to set
	 */
	public void setSelAnneeUniversitaire(Object selAnneeUniversitaire) {
		this.selAnneeUniversitaire = selAnneeUniversitaire;
	}

	/**
	 * @param ongletCourant the ongletCourant to set
	 */
	public void setOngletCourant(int ongletCourant) {
		this.ongletCourant = ongletCourant;
	}
	/**
	 * @return the ongletCourant
	 */
	public int getOngletCourant() {
		return ongletCourant;
	}

	/**
	 * @return the selectedCodeElp
	 */
	public String getSelectedCodeElp() {
		return selectedCodeElp;
	}

	/**
	 * @param selectedCodeElp the selectedCodeElp to set
	 */
	public void setSelectedCodeElp(String selectedCodeElp) {
		this.selectedCodeElp = selectedCodeElp;
	}

	/**
	 * @return the selectedCodeEtape
	 */
	public String getSelectedCodeEtape() {
		return selectedCodeEtape;
	}

	/**
	 * @param selectedCodeEtape the selectedCodeEtape to set
	 */
	public void setSelectedCodeEtape(String selectedCodeEtape) {
		this.selectedCodeEtape = selectedCodeEtape;
	}

	/**
	 * @return the listeELPEtapesSelectItems
	 */
	public List<SelectItem> getListeELPEtapesSelectItems() {
		listeELPEtapesSelectItems = new ArrayList<SelectItem>();
		if (this.listeELPEtapes != null && !this.listeELPEtapes.isEmpty()) {
			String clef = null;
			String valeur = null;
			for (ElementPedagogique e : listeELPEtapes){
				clef = e.getCodElp();
				valeur = e.getLibElp();
				listeELPEtapesSelectItems.add(new SelectItem(clef, valeur));
			}
		}

		return listeELPEtapesSelectItems;
	}

	/**
	 * @param listeELPEtapesSelectItems the listeELPEtapesSelectItems to set
	 */
	public void setListeELPEtapesSelectItems(
			List<SelectItem> listeELPEtapesSelectItems) {
		this.listeELPEtapesSelectItems = listeELPEtapesSelectItems;
	}

	/**
	 * @return the estVerifiee
	 */
	public String getEstVerifiee() {
		return estVerifiee;
	}
	/**
	 * @param estVerifiee the estVerifiee to set
	 */
	public void setEstVerifiee(String estVerifiee) {
		this.estVerifiee = estVerifiee;
	}

	/**
	 * @return boolean
	 */
	public boolean isSurchargeTuteur(){
		return this.surchargeTuteur;
	}

	/**
	 * @return the questionsSupplementairesEtudiant1
	 */
	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEtudiant1() {
		return questionsSupplementairesEtudiant1;
	}

	/**
	 * @param questionsSupplementairesEtudiant1 the questionsSupplementairesEtudiant1 to set
	 */
	public void setQuestionsSupplementairesEtudiant1(
			List<QuestionSupplementaireDTO> questionsSupplementairesEtudiant1) {
		this.questionsSupplementairesEtudiant1 = questionsSupplementairesEtudiant1;
	}

	/**
	 * @return the questionsSupplementairesEtudiant2
	 */
	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEtudiant2() {
		return questionsSupplementairesEtudiant2;
	}

	/**
	 * @param questionsSupplementairesEtudiant2 the questionsSupplementairesEtudiant2 to set
	 */
	public void setQuestionsSupplementairesEtudiant2(
			List<QuestionSupplementaireDTO> questionsSupplementairesEtudiant2) {
		this.questionsSupplementairesEtudiant2 = questionsSupplementairesEtudiant2;
	}

	/**
	 * @return the questionsSupplementairesEtudiant3
	 */
	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEtudiant3() {
		return questionsSupplementairesEtudiant3;
	}

	/**
	 * @param questionsSupplementairesEtudiant3 the questionsSupplementairesEtudiant3 to set
	 */
	public void setQuestionsSupplementairesEtudiant3(
			List<QuestionSupplementaireDTO> questionsSupplementairesEtudiant3) {
		this.questionsSupplementairesEtudiant3 = questionsSupplementairesEtudiant3;
	}

	/**
	 * @return the questionsSupplementairesEnseignant1
	 */
	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEnseignant1() {
		return questionsSupplementairesEnseignant1;
	}

	/**
	 * @param questionsSupplementairesEnseignant1 the questionsSupplementairesEnseignant1 to set
	 */
	public void setQuestionsSupplementairesEnseignant1(
			List<QuestionSupplementaireDTO> questionsSupplementairesEnseignant1) {
		this.questionsSupplementairesEnseignant1 = questionsSupplementairesEnseignant1;
	}

	/**
	 * @return the questionsSupplementairesEnseignant2
	 */
	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEnseignant2() {
		return questionsSupplementairesEnseignant2;
	}

	/**
	 * @param questionsSupplementairesEnseignant2 the questionsSupplementairesEnseignant2 to set
	 */
	public void setQuestionsSupplementairesEnseignant2(
			List<QuestionSupplementaireDTO> questionsSupplementairesEnseignant2) {
		this.questionsSupplementairesEnseignant2 = questionsSupplementairesEnseignant2;
	}


	/**
	 * @return the reponsesSupplementaires
	 */
	public List<ReponseSupplementaireDTO> getReponsesSupplementaires() {
		return reponsesSupplementaires;
	}

	/**
	 * @param reponsesSupplementaires the reponsesSupplementaires to set
	 */
	public void setReponsesSupplementaires(List<ReponseSupplementaireDTO> reponsesSupplementaires) {
		this.reponsesSupplementaires = reponsesSupplementaires;
	}

	/**
	 * @return the togglePanelActiveItem
	 */
	public String getTogglePanelActiveItem() {
		return togglePanelActiveItem;
	}

	/**
	 * @param togglePanelActiveItem the togglePanelActiveItem to set
	 */
	public void setTogglePanelActiveItem(String togglePanelActiveItem) {
		this.togglePanelActiveItem = togglePanelActiveItem;
	}

	/**
	 * @return the codeAccesFiche
	 */
	public String getCodeAccesFiche() {
		return codeAccesFiche;
	}

	/**
	 * @param codeAccesFiche the codeAccesFiche to set
	 */
	public void setCodeAccesFiche(String codeAccesFiche) {
		this.codeAccesFiche = codeAccesFiche;
	}

	/**
	 * @return the questionsSupplementairesEntreprise1
	 */
	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEntreprise1() {
		return questionsSupplementairesEntreprise1;
	}

	/**
	 * @param questionsSupplementairesEntreprise1 the questionsSupplementairesEntreprise1 to set
	 */
	public void setQuestionsSupplementairesEntreprise1(
			List<QuestionSupplementaireDTO> questionsSupplementairesEntreprise1) {
		this.questionsSupplementairesEntreprise1 = questionsSupplementairesEntreprise1;
	}

	/**
	 * @return the questionsSupplementairesEntreprise2
	 */
	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEntreprise2() {
		return questionsSupplementairesEntreprise2;
	}

	/**
	 * @param questionsSupplementairesEntreprise2 the questionsSupplementairesEntreprise2 to set
	 */
	public void setQuestionsSupplementairesEntreprise2(
			List<QuestionSupplementaireDTO> questionsSupplementairesEntreprise2) {
		this.questionsSupplementairesEntreprise2 = questionsSupplementairesEntreprise2;
	}

	/**
	 * @return the questionsSupplementairesEntreprise3
	 */
	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEntreprise3() {
		return questionsSupplementairesEntreprise3;
	}

	/**
	 * @param questionsSupplementairesEntreprise3 the questionsSupplementairesEntreprise3 to set
	 */
	public void setQuestionsSupplementairesEntreprise3(
			List<QuestionSupplementaireDTO> questionsSupplementairesEntreprise3) {
		this.questionsSupplementairesEntreprise3 = questionsSupplementairesEntreprise3;
	}

	/**
	 * @return the listeItemsCurrentCentresGestionEval
	 */
	public List<SelectItem> getListeItemsCurrentCentresGestionEval() {
		return listeItemsCurrentCentresGestionEval;
	}

	/**
	 * @param listeItemsCurrentCentresGestionEval the listeItemsCurrentCentresGestionEval to set
	 */
	public void setListeItemsCurrentCentresGestionEval(
			List<SelectItem> listeItemsCurrentCentresGestionEval) {
		this.listeItemsCurrentCentresGestionEval = listeItemsCurrentCentresGestionEval;
	}

	/**
	 * @return the rechEvalIdCentre
	 */
	public Integer getRechEvalIdCentre() {
		return rechEvalIdCentre;
	}

	/**
	 * @param rechEvalIdCentre the rechEvalIdCentre to set
	 */
	public void setRechEvalIdCentre(Integer rechEvalIdCentre) {
		this.rechEvalIdCentre = rechEvalIdCentre;
	}
	/**
	 * @return the rechEvalListeEtapes
	 */
	public List<SelectItem> getRechEvalListeEtapes() {
		this.rechEvalListeEtapes = new ArrayList<SelectItem>();
		if(rechEvalIdCentre != null && rechEvalIdCentre > 0){
			List<CritereGestionDTO> listeEtapes = getCritereGestionDomainService().getCritereGestionFromIdCentre(this.rechEvalIdCentre);
			if (listeEtapes != null && !listeEtapes.isEmpty()){
				for (CritereGestionDTO critere : listeEtapes){
					if (critere.getCodeVersionEtape() != null && !critere.getCodeVersionEtape().isEmpty()){
						this.rechEvalListeEtapes.add(new SelectItem(critere.getCode(),
								critere.getCode()+";"+critere.getCodeVersionEtape()+" - " +critere.getLibelle()));
					} else {
						this.rechEvalListeEtapes.add(new SelectItem(critere.getCode(),
								critere.getCode()+" - "+critere.getLibelle()));
					}
				}
			}
		}
		return rechEvalListeEtapes;
	}

	/**
	 * @param rechEvalListeEtapes the rechEvalListeEtapes to set
	 */
	public void setRechEvalListeEtapes(List<SelectItem> rechEvalListeEtapes) {
		this.rechEvalListeEtapes = rechEvalListeEtapes;
	}

	/**
	 * @return the retourEvaluation
	 */
	public boolean isRetourEvaluation() {
		return retourEvaluation;
	}

	/**
	 * @param retourEvaluation the retourEvaluation to set
	 */
	public void setRetourEvaluation(boolean retourEvaluation) {
		this.retourEvaluation = retourEvaluation;
	}

	/**
	 * @return the typeDestMailEval
	 */
	public int getTypeDestMailEval() {
		return typeDestMailEval;
	}

	/**
	 * @param typeDestMailEval the typeDestMailEval to set
	 */
	public void setTypeDestMailEval(int typeDestMailEval) {
		this.typeDestMailEval = typeDestMailEval;
	}

	/**
	 * @return the typeMailEval
	 */
	public int getTypeMailEval() {
		return typeMailEval;
	}

	/**
	 * @param typeMailEval the typeMailEval to set
	 */
	public void setTypeMailEval(int typeMailEval) {
		this.typeMailEval = typeMailEval;
	}

	/**
	 * @param contenuMailEval the contenuMailEval to set
	 */
	public void setContenuMailEval(String contenuMailEval) {
		this.contenuMailEval = contenuMailEval;
	}

	public UniteDureeDTO getSelUniteDureeGratification() {
		return selUniteDureeGratification;
	}

	public void setSelUniteDureeGratification(UniteDureeDTO selUniteDureeGratification) {
		this.selUniteDureeGratification = selUniteDureeGratification;
	}

	public boolean isBlocageCreationEtpOrpheline() {
		return blocageCreationEtpOrpheline;
	}

	public void setBlocageCreationEtpOrpheline(boolean blocageCreationEtpOrpheline) {
		this.blocageCreationEtpOrpheline = blocageCreationEtpOrpheline;
	}
	/**
	 * 
	 * @return estEtrangere
	 */
	public Boolean getEstEtrangere() {
		return estEtrangere;
	}

	/**
	 * 
	 * @param choixPays the choixPays to set
	 */
	public void setEstEtrangere(Boolean estEtrangere) {
		this.estEtrangere=estEtrangere;
	}

	/**
	 * initCritereRechercheConvention
	 * @return CritereRechercheConventionDTO
	 */
	public CritereRechercheConventionDTO initCritereRechercheConvention(){
		CritereRechercheConventionDTO c = null;
		if(getBeanUtils()!=null){
			c=new CritereRechercheConventionDTO();
			c.setPays(getBeanUtils().getFrance());
		}else{
			c=new CritereRechercheConventionDTO();
			PaysDTO p = new PaysDTO();
			p.setLibelle("FRANCE");
			p.setCog(DonneesStatic.FRANCE_COG);
			p.setCrpay(DonneesStatic.FRANCE_TERRITOIRE_CRPAY);
			c.setPays(p);
		}
		c.setNbRechercheMaxi(Integer.toString(DonneesStatic.nb_recherche_maxi));
		c.setNbExportMaxi(Integer.toString(DonneesStatic.nb_response_export_maxi));
		return c;
	}

	public String getSelectedAnneeUniv() {
		return selectedAnneeUniv;
	}

	public void setSelectedAnneeUniv(String selectedAnneeUniv) {
		this.selectedAnneeUniv = selectedAnneeUniv;
	}

	/**
	 * @return the listeAnneesUniv
	 */
	public List<SelectItem> getListeAnneesUniv() {
		List<SelectItem> listeAnneesUniv = new ArrayList<SelectItem>();
		if(this.resultatEtudiantRef.getListeAnneesUniv() != null && !this.resultatEtudiantRef.getListeAnneesUniv().isEmpty()){
			for (String annee : this.resultatEtudiantRef.getListeAnneesUniv()){
				int anneeInt = Integer.parseInt(annee);
				listeAnneesUniv.add(new SelectItem(anneeInt,anneeInt+"/"+(anneeInt+1)));
			}
		}
		return listeAnneesUniv;
	}
	public List<ConventionDTO> getListeConventionsSelectionnees() {
		return listeConventionsSelectionnees;
	}

	public void setListeConventionsSelectionnees(
			List<ConventionDTO> listeConventionsSelectionneesf) {
		listeConventionsSelectionnees = listeConventionsSelectionneesf;
	}

	public void remplirListeConventionsSelectionnees(){
		if ( (!listeConventionsSelectionnees.isEmpty()) || (listeConventionsSelectionnees!=null)){
			listeConventionsSelectionnees=new ArrayList<ConventionDTO>();
		}
		for (ConventionDTO c: this.rechercheConventionPaginator.getListe()){
			if (c.isSelected()){
				c = getConventionDomainService().getConventionFromId(c.getIdConvention());
				c.setEtudiant(getEtudiantDomainService().getEtudiantFromId(c.getIdEtudiant()));
				listeConventionsSelectionnees.add(c);
			}
		}

	}

	public int getSizeListeConventionsSelectionnes(){
		int nbr=0;
		if (this.listeConventionsSelectionnees!=null && !this.listeConventionsSelectionnees.isEmpty()){
			nbr=this.getListeConventionsSelectionnees().size();	
		}
		return nbr;
	}
}
