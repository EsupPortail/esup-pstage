/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

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

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.esupportail.commons.annotations.cache.SessionCache;
import org.esupportail.pstage.domain.beans.AdministrationApogee;
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
import org.esupportail.pstage.web.utils.PDFUtils;
import org.esupportail.pstagedata.domain.dto.AffectationDTO;
import org.esupportail.pstagedata.domain.dto.AssuranceDTO;
import org.esupportail.pstagedata.domain.dto.CaisseRegimeDTO;
import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.ConventionDTO;
import org.esupportail.pstagedata.domain.dto.CritereRechercheConventionDTO;
import org.esupportail.pstagedata.domain.dto.CritereRechercheOffreDTO;
import org.esupportail.pstagedata.domain.dto.DroitAdministrationDTO;
import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.esupportail.pstagedata.domain.dto.EtapeDTO;
import org.esupportail.pstagedata.domain.dto.EtudiantDTO;
import org.esupportail.pstagedata.domain.dto.IndemnisationDTO;
import org.esupportail.pstagedata.domain.dto.LangueConventionDTO;
import org.esupportail.pstagedata.domain.dto.ModeValidationStageDTO;
import org.esupportail.pstagedata.domain.dto.ModeVersGratificationDTO;
import org.esupportail.pstagedata.domain.dto.NatureTravailDTO;
import org.esupportail.pstagedata.domain.dto.OffreDTO;
import org.esupportail.pstagedata.domain.dto.OrigineStageDTO;
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
public class ConventionController extends AbstractContextAwareController {
	

//	public void recalcul(){
//		logger.info("DEBUT DU RECALCUL - RECUPERATION DE TOUTES LES CONVENTIONS EN COURS");
//		// recuperation vraiment tres tres longue de l'ensemble des conventions
//		List<ConventionDTO> conventions = getConventionDomainService().getConventions(getSessionController().getCodeUniversite());
//		
//		int duree = 0;
//		for (ConventionDTO convention : conventions){
//			duree = Utils.CalculDureeSemaine(convention.getDateDebutStage(), convention.getDateFinStage(), convention.getDateDebutInterruption(), convention.getDateFinInterruption());
//			convention.setDureeStage(duree);
//			try {
//				if (this.getConventionDomainService().updateConvention(convention)) {
//					logger.info("Convention "+convention.getIdConvention()+" updatée.");
//				}
//			} catch (DataUpdateException ae) {
//				logger.error("DataUpdateException", ae.fillInStackTrace());
//			} catch (WebServiceDataBaseException we) {
//				logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
//			}
//		}
//	}
	
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

	//Recherche
	/**
	 * critereRechercheConvention.
	 */
	private CritereRechercheConventionDTO critereRechercheConvention = new CritereRechercheConventionDTO();
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

	private List<SelectItem> listeELPEtapesSelectItems;
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

		//		getSessionController().setCreationConventionCurrentPage("creerConventionConsignes");
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

//		getSessionController().setCreationConventionCurrentPage("creerConventionConsignes");
		if (getSessionController().getCurrentStageCasUser() != null) {
			if (logger.isInfoEnabled()) {
				logger.debug("ConventionController:: goToCreerConvention : user connecte : " 
						+ getSessionController().getCurrentStageCasUser().getId());
			}
		}
		if (this.getSessionController().getCurrentAuthEtudiant() != null) {
			retour = "creerConventionEtu";
		}
		return retour;
	}

	/**
	 */
	public void goToCreerConventionEtu() {
//		String retour = null;
		if (this.getSessionController().getCurrentAuthEtudiant() != null) {
//			retour = rechercheInfosEtudiant(this.getSessionController().getCurrentAuthEtudiant().getIdentEtudiant());
			rechercheInfosEtudiant(this.getSessionController().getCurrentAuthEtudiant().getIdentEtudiant());
		}
//		return retour;
	}
	/**
	 * @return A String
	 */
	public String goToCreerConventionRechEtu() {
		this.rechIdentEtudiant = "";
		this.rechNomEtudiant = "";
		this.rechPrenomEtudiant = "";
		getSessionController().setCreationConventionEtape1CurrentPage("_creerConventionEtape1RechercheEtudiant");
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
		if (logger.isDebugEnabled()) {
			logger.debug("ConventionController:: goToChoixEtapeEtudiant ");
		}
		sequenceEtapeEnum = SequenceEtapeEnum.etape1;
		
		getSessionController().setCreationConventionEtape1CurrentPage("_creerConventionEtape1ChoixEtapeEtudiant");
		
//		return "creerConventionEtape1Etudiant";
	}
	
	/**
	 * 
	 */
	public void goToCreerConventionCtrlInfosEtu() {
		boolean ctrlInfosOK = true;
		this.ctrlInfosEtuOK = false;
		this.ctrlInfosStageOK = false;
//		String retour = null;

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
		}

		if (isEtudiantSupUnElp()) {
			if (selectedCodeElp == null || this.selectedCodeElp.isEmpty()) {
				addErrorMessage("formConvention:choixElp", "CONVENTION.CREERCONVENTION.ELP.OBLIGATOIRE");
				ctrlInfosOK = false;
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
			// On verifie que le personnel connecté n'est pas superadmin ou étudiant et a bien les droits requis sur le centre gérant l'étape séléctionnée
			if (!getSessionController().isSuperAdminPageAuthorized() && this.getSessionController().getCurrentAuthEtudiant() == null){
				// recuperation du centre gérant l'etape/ufr selectionnée
				CentreGestionDTO centreGestionRattachement = new CentreGestionDTO();
				if (getSessionController().getCritereGestion() != null) {
					// centre gestion UFR
					if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_UFR)) {
						centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(this.etudiantRef.getThecodeUFR(), getSessionController().getCodeUniversite());
					}
					// centre gestion Etape
					if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_ETAPE)) {
						centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(this.etudiantRef.getTheCodeEtape(), getSessionController().getCodeUniversite());
					}
					// centre gestion Mixte
					if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_MIXTE)) {
						// recherche cg gérant l'etape
						centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(this.etudiantRef.getTheCodeEtape(), getSessionController().getCodeUniversite());
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

		// recherche du centre de gestion qui gere Ufr ou Etape
		CentreGestionDTO centreGestionRattachement = new CentreGestionDTO();
		if (getSessionController().getCritereGestion() != null) {
			// centre gestion UFR
			if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_UFR)) {
				centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(this.etudiantRef.getThecodeUFR(), getSessionController().getCodeUniversite());
			}
			// centre gestion Etape
			if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_ETAPE)) {
				centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(this.etudiantRef.getTheCodeEtape(), getSessionController().getCodeUniversite());
			}
			// centre gestion Mixte, recherche centre qui gere etape
			if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_MIXTE)) {
				// recherche cg qui gere etape de etudiant
				centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(this.etudiantRef.getTheCodeEtape(), getSessionController().getCodeUniversite());
				// si non trouve, recherche centre qui gere Ufr
				if (centreGestionRattachement == null) {
					centreGestionRattachement = getCentreGestionDomainService().getCentreFromCritere(this.etudiantRef.getThecodeUFR(), getSessionController().getCodeUniversite());
				}
			}
		}
		// recherche centre etablissement, si critere = 
		if (getSessionController().getCritereGestion().equals("")|| getSessionController().getCritereGestion() == null) {
			centreGestionRattachement = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite());
		}
		// centre non trouve , rattachement au centre etablissement
		if (centreGestionRattachement == null) {
			centreGestionRattachement = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite());
		}
		if (centreGestionRattachement != null) {
			getSessionController().setCentreGestionRattachement(centreGestionRattachement);
			this.convention.setIdCentreGestion(centreGestionRattachement.getIdCentreGestion());
			this.convention.setCentreGestion(centreGestionRattachement);
		}
		if (this.etudiantRef.getTheCodeEtape() != null) {
			EtapeDTO etapeTmp = new EtapeDTO(); 
			etapeTmp.setCode(this.etudiantRef.getTheCodeEtape());
			etapeTmp.setLibelle(this.etudiantRef.getTheEtape());
			this.convention.setEtape(etapeTmp);
			this.convention.setCodeEtape(etapeTmp.getCode());
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
		if (this.etudiantRef.getListeEtapeInscriptions() != null) {
			if (!this.etudiantRef.getListeEtapeInscriptions().isEmpty()) {
				for (Iterator<EtapeInscription> iter = 
						this.etudiantRef.getListeEtapeInscriptions().iterator(); iter.hasNext();) {
					EtapeInscription etpins = iter.next();
					if (this.etudiantRef.getTheCodeEtape().equals(etpins.getCodeEtp())) {
						if (etpins.getTypeIns().equals(DonneesStatic.TYPE_INS_ADMIN)) {
							this.convention.setCodeCursusLMD(etpins.getCodCursusLmd());
							this.convention.setCodeFinalite(etpins.getCodFinalite());
							this.convention.setLibelleFinalite(etpins.getLibFinalite());
						}
					}
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
		if (StringUtils.hasText(this.convention.getDureeExceptionnelle())) {
			if (selUniteDureeExceptionnelle ==  null) {
				addErrorMessage(nomForm+":uniteDureeExceptionnelle", "CONVENTION.CREERCONVENTION.UNITEDUREEEXCEPTIONNELLE.OBLIGATOIRE");
				ctrlInfosOK = false;
			}
		}
		// unite du montant obligatoire, si montant 
		if (StringUtils.hasText(this.convention.getMontantGratification())) {
			if (selUniteGratification == null) {
				addErrorMessage(nomForm + ":UniteGratification", "CONVENTION.CREERCONVENTION.UNITEGRATIFICATION.OBLIGATOIRE");
				ctrlInfosOK = false;
			}
		}
		// Mode de versement de la gratification obligatoire, si indemnisation
		if (selIndemnisation != null) {
			if (selIndemnisation.getLibelle().equalsIgnoreCase(DonneesStatic.OUI)) {
				if (selModeVersGratification == null) {
					addErrorMessage(nomForm+":modeVersGratification", "CONVENTION.CREERCONVENTION.MODEVERSGRATIFICATION.OBLIGATOIRE");
					ctrlInfosOK = false;
				}
				if (selModeVersGratification != null && selModeVersGratification.getLibelle().equals("")) {
					addErrorMessage(nomForm+":modeVersGratification", "CONVENTION.CREERCONVENTION.MODEVERSGRATIFICATION.OBLIGATOIRE");
					ctrlInfosOK = false;
				}
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
		convention.setModeValidationStage(selModeValidationStage);
		convention.setIdModeValidationStage(selModeValidationStage.getId());
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
		this.convention.setNbHeuresHebdo("35.00");
		this.convention.setQuotiteTravail(100);
		this.ctrlInfosStageOK = false;
		getSessionController().setCreationConventionEtape5CurrentPage("_creerConventionEtape5Stage");
		if (logger.isDebugEnabled()) {
			logger.debug("ConventionController:: goToCreerConventionEtape5Stage ");
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
			logger.debug("ConventionController:: goToCreerConventionEtape8Recap "); 
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
			logger.debug("ConventionController:: goToAjouterConvention "); 
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
			logger.debug("ConventionController:: goToAjouterConvention "); 
			if (this.convention.getEnseignant() != null) { 
				logger.debug("this.convention.getEnseignant() "
						+ this.convention.getEnseignant().getUidEnseignant());
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
			logger.debug("ConventionController:: Utils.CalculDureeSemaine conventionTmp.getDateDebutStage()= "
					+ conventionTmp.getDateDebutStage());
			logger.debug("ConventionController:: Utils.CalculDureeSemaine conventionTmp.getDateFinStage()= " 
					+ conventionTmp.getDateFinStage());
		}
		if (conventionTmp.isInterruptionStage()) {
			if (logger.isDebugEnabled()) {
				logger.debug("ConventionController:: Utils.CalculDureeSemaine conventionTmp.getDateDebutInterruption()= " 
						+ conventionTmp.getDateDebutInterruption());
				logger.debug("ConventionController:: Utils.CalculDureeSemaine conventionTmp.getDateFinInterruption()= "
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
			logger.debug("ConventionController:: conventionTmp " + conventionTmp.toString()); 

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
				//sequenceEtapeEnum = SequenceEtapeEnum.etape9;
				sequenceEtapeEnum = SequenceEtapeEnum.etape10;
				//retour vers detail convention (validation, avenant ), idem recherche 
				sequenceEtapeEnumSel = SequenceEtapeEnumSel.etape12;
				retour = "conventionEtape8Recap";
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.fillInStackTrace());
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
				logger.debug("ConventionController:: conventionTmp " + conventionTmp.toString()); 

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
			}
			sequenceEtapeEnumSel = SequenceEtapeEnumSel.etape12;
			retour = "conventionEtape8Recap";
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
//		String retour = null;
		this.listeResultatsRechercheEtudiant = null;
		this.resultatEtudiantRef=getStudentDataRepositoryDomain().getEtudiantRef(getSessionController().getCodeUniversite(), idEtudiant);
		if (resultatEtudiantRef != null) {
			if (!resultatEtudiantRef.getAdministrationApogee().isStatusApogee()) {
				if (logger.isDebugEnabled()) {
					logger.debug("ConventionController:: etudiant en erreur Administratif " 
							+ resultatEtudiantRef.getAdministrationApogee().getRaison());
					addErrorMessage("formConvention:identEtudiant", "RECHERCHEETU.PAS.IA");
					resultatEtudiantRef = null;
					listeResultatsRechercheEtudiant = null;
//					return retour;
				}
			}
		}
		if (resultatEtudiantRef == null) {
			addErrorMessage("formConvention:identEtudiant", "RECHERCHEETU.INVALIDE");
		}
		recupInfosEtudiantRef();
//		return retour;
	}

	/**
	 * 
	 */
	public void retirerEtapesOrphelines(){
		Map<String,String> mapCodes = this.resultatEtudiantRef.getSteps();
		List<String> list = new ArrayList<String>();
		Iterator<String> iterator = mapCodes.keySet().iterator();
		String code;
		CentreGestionDTO centreTmp;
		// On parcours l'ensemble des etapes de l'etudiant
		while (iterator.hasNext()){
			code = iterator.next();
			// On regarde s'il existe un centre associe au code etape
			centreTmp = getCentreGestionDomainService().getCentreFromCritere(code, getSessionController().getCodeUniversite());
			if (centreTmp == null){
				// S'il n'y en a pas, on vérifie à nouveau mais à partir du code ufr
				this.etudiantRef = this.resultatEtudiantRef;
				EtapeInscription ufrEtape = rechUfrEtape(code);
				centreTmp = getCentreGestionDomainService().getCentreFromCritere(ufrEtape.getCodeComposante(), getSessionController().getCodeUniversite());
				if (centreTmp == null){
					list.add(code);
				}
			}
		}
		for (int i=0;i<list.size();i++){
			mapCodes.remove(list.get(i)); // retrait effectif des codes non utilisés dans la map
		}

		if (this.resultatEtudiantRef.getSteps().size() == 1){
			Iterator<String> i = this.resultatEtudiantRef.getSteps().keySet().iterator();
			this.etudiantRef = this.resultatEtudiantRef;
			Map<String,String> mapTmp = new HashMap<String,String>();
			while (i.hasNext())	{
				EtapeInscription ufrEtape = rechUfrEtape(i.next());
				mapTmp.put(ufrEtape.getCodeComposante(), ufrEtape.getLibComposante());
			}
			this.resultatEtudiantRef.setStudys(mapTmp);
		} else if (this.resultatEtudiantRef.getSteps().isEmpty()){
			if (this.isEtudiantSupUneEtape()){
				addErrorMessage("formConvention:choixEtape", "CONVENTION.CREERCONVENTION.ETAPES.NONRATTACHE");
			} else {
				addErrorMessage("formConvention:etape", "CONVENTION.CREERCONVENTION.ETAPE.NONRATTACHE");
			}
		}
	}

	/**
	 * @return String
	 */
	public void recupInfosEtudiantRef() {
//		String retour = null;
		if (this.resultatEtudiantRef != null) {
			this.etudiantRef = new EtudiantRef();

			if (!getSessionController().isAutoriserConventionsOrphelines()){
				this.retirerEtapesOrphelines();
			}

			this.setEtudiantRef(this.resultatEtudiantRef);

			if (this.resultatEtudiantRef.getStudys().size() == 1) {
				String clef = null;
				String valeur = null;
				Iterator<String> i = this.resultatEtudiantRef.getStudys().keySet().iterator();
				while (i.hasNext())	{
					clef = i.next();
					valeur = this.resultatEtudiantRef.getStudys().get(clef);
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
			if (this.resultatEtudiantRef.getSteps().size() == 1) {
				String clef = null;
				//String valeur = null;
				Iterator<String> i = this.resultatEtudiantRef.getSteps().keySet().iterator();
				while (i.hasNext())	{
					clef = i.next();
					//valeur = this.resultatEtudiantRef.getSteps().get(clef);
					this.etudiantRef.setTheCodeEtape(clef);
					// recherche libelle version etape
					rechLibVersEtape(clef);
					// recherche des elements pedagogiques
					this.listeELPEtapes = rechElpEtape(clef);
					if (this.listeELPEtapes != null) {
						if (this.listeELPEtapes.size() == 1) {
							this.etudiantRef.setTheCodeElp(this.listeELPEtapes.get(0).getCodElp());
							this.etudiantRef.setTheLibElp(this.listeELPEtapes.get(0).getLibElp());
							this.etudiantRef.setTheCreditECTS(this.listeELPEtapes.get(0).getNbrCrdElp());
						}
					}

				}
			}
			//			retour = goToChoixEtapeEtudiant();
			goToChoixEtapeEtudiant();
		}
//		return retour;
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
						if (!resultatEtudiantRef.getAdministrationApogee().isStatusApogee()) {
							if (logger.isDebugEnabled()) {
								logger.debug("ConventionController:: etudiant en erreur Administratif " + resultatEtudiantRef.getAdministrationApogee().getRaison());
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
							if (!etudiantRefTmp.getAdministrationApogee().isStatusApogee()) {
								if (logger.isDebugEnabled()) {
									logger.debug("ConventionController:: etudiant en erreur  " + etudiantRefTmp.getAdministrationApogee().getRaison());
								}
								addErrorMessage("formConvention:nom", etudiantRefTmp.getAdministrationApogee().getRaison());
								resultatEtudiantRef = null;
								listeResultatsRechercheEtudiant = null;
							}
						} else {
							if (logger.isDebugEnabled()) {
								logger.debug("ConventionController:: etudiantRefTmp.getAdministrationApogee() = null -> configuration tout Ldap");
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
				this.etudiantRef = new EtudiantRef();

				if (!getSessionController().isAutoriserConventionsOrphelines()){
					this.retirerEtapesOrphelines();
				}
				this.setEtudiantRef(this.resultatEtudiantRef);
				if (this.resultatEtudiantRef.getStudys().size() == 1) {
					String clef = null;
					String valeur = null;
					Iterator<String> i = this.resultatEtudiantRef.getStudys().keySet().iterator();
					while (i.hasNext())	{
						clef = i.next();
						valeur = this.resultatEtudiantRef.getStudys().get(clef);
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
				if (this.resultatEtudiantRef.getSteps().size() == 1) {
					String clef = null;
					//String valeur = null;
					Iterator<String> i = this.resultatEtudiantRef.getSteps().keySet().iterator();
					while (i.hasNext())	{
						clef = i.next();
						//valeur = this.resultatEtudiantRef.getSteps().get(clef);
						this.etudiantRef.setTheCodeEtape(clef);
						// recherche libelle version etape
						rechLibVersEtape(clef);
						// recherche des elements pedagogiques
						this.listeELPEtapes = rechElpEtape(clef);
						if (this.listeELPEtapes != null) {
							if (this.listeELPEtapes.size() == 1) {
								this.etudiantRef.setTheCodeElp(this.listeELPEtapes.get(0).getCodElp());
								this.etudiantRef.setTheLibElp(this.listeELPEtapes.get(0).getLibElp());
								this.etudiantRef.setTheCreditECTS(this.listeELPEtapes.get(0).getNbrCrdElp());
							}
						}
					}
				}
//				retour = goToChoixEtapeEtudiant();
				goToChoixEtapeEtudiant();
			}
			if (this.listeResultatsRechercheEtudiant != null) {
//				retour = "creerConventionEtape1ListeEtudiant";
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
			logger.debug("ConventionController:: goToEnseignantValid "); 
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
					if (logger.isInfoEnabled()) {
						logger.info("Ajout affectation : " + idAffectationEnseignant);
					}
				}
				enseignantTmp.setCodeUniversiteAffectation(getSessionController().getCodeUniversite());
				int idEnseignant = this.getEnseignantDomainService().addEnseignant(enseignantTmp); 
				if (logger.isInfoEnabled()) {
					logger.info("Ajout enseignant : " 
							+ this.convention.getEnseignant().getUidEnseignant());
				}
				if (idEnseignant > 0) {
					conventionTmp.setIdEnseignant(idEnseignant);
				}
			} else {
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
				logger.debug("ConventionController:: rechercheEnseignant ");
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
				retour = SequenceEtapeEnumSel.etape10.actionEtape();
				addInfoMessage("formSelConvention:erreurConventionVerification", "CONVENTION.VALIDER.CONFIRMATION", this.convention.getIdConvention());
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
				retour = SequenceEtapeEnumSel.etape10.actionEtape();
				addInfoMessage(null, "CONVENTION.VALIDER.CONFIRMATION", this.convention.getIdConvention());
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
	public String goToConventionInValidation() {
		String retour = null;
		int nbAvenant = getAvenantDomainService().getNombreAvenant(this.convention.getIdConvention());
		if (nbAvenant > 0) {
			addErrorMessage("formSelConvention:erreurConventionValidation", "CONVENTION.INVALIDER.IMPOSSIBLE");
		}else {
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
	 * @param codeEtape
	 */
	public void rechLibVersEtape(final String codeEtape) {
		if (this.etudiantRef.getListeEtapeInscriptions() != null) {
			if (!this.etudiantRef.getListeEtapeInscriptions().isEmpty()) {
				for (Iterator<EtapeInscription> iter = 
						this.etudiantRef.getListeEtapeInscriptions().iterator(); iter.hasNext();) {
					EtapeInscription etpins = iter.next();
					if (codeEtape.equals(etpins.getCodeEtp())) {
						this.etudiantRef.setTheEtape(etpins.getLibWebVet());
					}
				}
			}
		}
	}
	/**
	 * recharge Ufr à partir de la selection etape etude.
	 * @param e 
	 */
	public void rechargeUfr() {
		if (selectedCodeEtape != null) {
			EtapeInscription ufrEtape = rechUfrEtape(selectedCodeEtape);
			if (ufrEtape != null) {
				this.etudiantRef.setThecodeUFR(ufrEtape.getCodeComposante());
				this.etudiantRef.setTheUfr(ufrEtape.getLibComposante());
				this.etudiantRef.setTheCodeEtape(ufrEtape.getCodeEtp());
				// recherche libelle version etape
				rechLibVersEtape(ufrEtape.getCodeEtp());
			}
			this.choixEtape = true;
			this.listeELPEtapes = rechElpEtape(selectedCodeEtape);
			if (this.listeELPEtapes != null) {
				if (this.listeELPEtapes.size() == 1) {
					this.etudiantRef.setTheCodeElp(this.listeELPEtapes.get(0).getCodElp());
					this.etudiantRef.setTheLibElp(this.listeELPEtapes.get(0).getLibElp());
					this.etudiantRef.setTheCreditECTS(this.listeELPEtapes.get(0).getNbrCrdElp());
				}
			}
		}
	}
	/**
	 * @param e
	 */
	public void rechargeElp(ValueChangeEvent event) {
		if (selectedCodeElp != null) {
			if (this.etudiantRef.getListeELPs() != null ) {
				if (!this.etudiantRef.getListeELPs().isEmpty()) {
					List<ElementPedagogique> listeELPs = new ArrayList<ElementPedagogique>();
					listeELPs = this.etudiantRef.getListeELPs();

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
	}	

	/**
	 * @param codeEtape
	 * @return EtapeInscription
	 */
	public EtapeInscription rechUfrEtape(final String codeEtape) {
		EtapeInscription ufrEtape = null;
		if (this.etudiantRef.getListeEtapeInscriptions() != null ) {
			if (!this.etudiantRef.getListeEtapeInscriptions().isEmpty()) {
				for (Iterator<EtapeInscription> iter = this.etudiantRef.getListeEtapeInscriptions().iterator(); iter.hasNext();) {
					EtapeInscription etpins = iter.next();
					if (codeEtape.equals(etpins.getCodeEtp())) {
						if (etpins.getTypeIns().equals(DonneesStatic.TYPE_INS_ADMIN)) {
							if (etpins.getCodeComposante()!=null && !etpins.getCodeComposante().isEmpty()) {
								ufrEtape = etpins;
							}
						}
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
		if (this.etudiantRef.getListeELPs() != null ) {
			if (!this.etudiantRef.getListeELPs().isEmpty()) {
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
			if (this.resultatEtudiantRef.getSteps().size() > 1) {
				isSupUneEtape = true;
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
			if (this.resultatEtudiantRef.getSteps() != null) {
				if (this.resultatEtudiantRef.getSteps().size() == 1) {
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
		if (this.getSessionController() != null) {
			if (this.getSessionController().getCurrentAuthEtudiant() != null) {
				if (this.convention != null) {
					if (!this.convention.getCentreGestion().getSaisieTuteurProParEtudiant()) {
						isSaisieTuteurProParEtudiant = false;
					}
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
		l.add(new SelectItem(JoursHebdo.jours5.getValeur(), JoursHebdo.jours5.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours4.getValeur(), JoursHebdo.jours4.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours3.getValeur(), JoursHebdo.jours3.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours2.getValeur(), JoursHebdo.jours2.getLibelle()));
		l.add(new SelectItem(JoursHebdo.jours1.getValeur(), JoursHebdo.jours1.getLibelle()));
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
		this.critereRechercheConvention=new CritereRechercheConventionDTO();
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
		if (!StringUtils.hasText(this.estValidee))	this.critereRechercheConvention.setEstValidee(null);
		else if(this.estValidee.equals("1"))	this.critereRechercheConvention.setEstValidee(true);
		else if(this.estValidee.equals("2"))	this.critereRechercheConvention.setEstValidee(false);
		//this.critereRechercheConvention.setLimit(true);
		this.critereRechercheConvention.setNbRechercheMaxi(Integer.toString(DonneesStatic.NB_RECHERCHE_MAXI));
		// si enseignant tuteur, recherche des conventions pour les enseignants tuteur
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
		critereRechercheConvention = new CritereRechercheConventionDTO();
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
				logger.debug("ConventionController:: AnneeUniversitaire  debut stage avant debut annee universitaire");
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
					logger.debug("ConventionController:: AnneeUniversitaire  debut stage apres fin annee universitaire");
				}
				anneeUniversitaire = (year + "/" + (year + 1));
			} 
			else { // meme date
				anneeUniversitaire =(year + "/" + (year + 1));
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("ConventionController:: AnneeUniversitaire : " + anneeUniversitaire);
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
				debutAnnee.set(year, Integer.parseInt(startYearMonth) - 1, Integer
						.parseInt(startYearDay), 0, 0, 0);
				// pas de millisecond (sinon c sera toujours avant debut annee, meme
				// s'il s'agit du meme jour)
				debutAnnee.clear(Calendar.MILLISECOND);
				if (logger.isDebugEnabled()){
					logger.debug("ConventionController:: debut annee universitaire = " + debutAnnee.getTime());
					logger.debug("ConventionController:: debut debut stage = " + debutStage.getTime());
					logger.debug("ConventionController:: getChoixAnneeAvantDebutAnnee() = " + this.convention.getCentreGestion().getChoixAnneeAvantDebutAnnee());
					logger.debug("ConventionController:: getChoixAnneeApresDebutAnnee() = " + this.convention.getCentreGestion().getChoixAnneeApresDebutAnnee());
				}
				//si debut stage dans le mois precedent la date de dubut d'annee et si choice.year=true dans le fichier de config
				Calendar debutAnneeMinusAMonth = (Calendar) debutAnnee.clone();
				debutAnneeMinusAMonth.add(Calendar.MONTH, -1);
				// mois suivant la date de debut d'annee 
				Calendar debutAnneePlusAMonth = (Calendar) debutAnnee.clone();
				debutAnneePlusAMonth.add(Calendar.MONTH, 1);
				if (logger.isDebugEnabled()){
					logger.debug("ConventionController:: debutAnneeMinusAMonth = " + debutAnneeMinusAMonth.getTime());
					logger.debug("ConventionController:: debutAnneePlusAMonth = " + debutAnneePlusAMonth.getTime());
				}
				//si debut stage dans le mois precedent la date de debut d'annee 
				//et si ChoixAnneeAvantDebutAnnee=true dans le centre de gestion
				//on doit pouvoir choisir l'annee universitaire
				if (debutStage.before(debutAnnee) && debutStage.after(debutAnneeMinusAMonth) 
						&& this.convention.getCentreGestion().getChoixAnneeAvantDebutAnnee() ){
					if (logger.isDebugEnabled()){
						logger.debug("ConventionController:: on doit choisir l'annee universitaire ChoixAnneeAvantDebutAnnee");
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
							logger.debug("ConventionController:: on doit choisir l'annee universitaire ChoixAnneeApresDebutAnnee");
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
		this.critereRechercheConvention=new CritereRechercheConventionDTO();
		this.ongletTuteur();
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
			for (int i=0;i<this.rechercheConventionPaginator.getVisibleItems().size();i++){
				conventionTmp = this.rechercheConventionPaginator.getVisibleItems().get(i);
				if (conventionTmp.isSelected()){
					conventionTmp = getConventionDomainService().getConventionFromId(conventionTmp.getIdConvention());
					conventionTmp.setValidationConvention(true);
					conventionTmp.setLoginValidation(getSessionController().getCurrentLogin());
					conventionTmp.setDateValidation(new Date());
					if (!this.getConventionDomainService().updateConvention(conventionTmp)){
						addErrorMessage(null,"CONVENTION.VALIDATION_EN_MASSE.ERREUR", conventionTmp.getIdConvention());
						return null;
					}
					this.rechercheConventionPaginator.getVisibleItems().remove(i);
					i--;
				}
			}
		} catch (DataUpdateException ae) {
			logger.error("DataUpdateException", ae.fillInStackTrace());
			addErrorMessage("formResultConventions:messageResultat", "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.fillInStackTrace());
			addErrorMessage("formResultConventions:messageResultat", "CONVENTION.CREERCONVENTION.CONVENTION.ERREUR", we.getMessage());
		} catch (Exception e) {
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
		this.critereRechercheConvention = new CritereRechercheConventionDTO();
		this.ongletCourant = 1;
	}
	/**
	 * Recherche de conventions en masse par Ufr
	 */
	public void ongletUfr(){
		this.critereRechercheConvention = new CritereRechercheConventionDTO();
		this.ongletCourant = 2;
	}
	/**
	 * Recherche de conventions en masse par Etape
	 */
	public void ongletEtape(){
		this.critereRechercheConvention = new CritereRechercheConventionDTO();
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
		this.critereRechercheConvention.setIdsCentreGestion(getSessionController().getCurrentIdsCentresGestion());
		this.critereRechercheConvention.setTypeStructure(null);
		this.critereRechercheConvention.setStatutJuridique(null);

		//this.critereRechercheConvention.setLimit(true);
		this.critereRechercheConvention.setNbRechercheMaxi(Integer.toString(DonneesStatic.NB_RECHERCHE_MAXI));

		this.resultatsRechercheConvention = getConventionDomainService().getConventionsFromCriteres(this.critereRechercheConvention);
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
		listeEtapesEtudiant = new ArrayList<SelectItem>();
		if (this.resultatEtudiantRef != null) {
			if (this.resultatEtudiantRef.getSteps() != null && !this.resultatEtudiantRef.getSteps().isEmpty()) {
				LinkedHashMap<String,String> steps = (LinkedHashMap<String, String>) this.resultatEtudiantRef.getSteps();
				if( steps != null) {
					String clef = null;
					String valeur = null;
					Iterator<String> i = this.resultatEtudiantRef.getSteps().keySet().iterator();
					while (i.hasNext()) {
						clef = i.next();
						valeur = this.resultatEtudiantRef.getSteps().get(clef);
						listeEtapesEtudiant.add(new SelectItem(clef, valeur));
					}
				}
			}
		}

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
				clef = e.getLibElp();
				valeur = e.getCodElp();
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
}
