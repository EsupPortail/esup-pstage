/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.esupportail.pstage.exceptions.ExportException;
import org.esupportail.pstage.services.export.CastorService;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstage.web.paginators.RechercheConventionPaginator;
import org.esupportail.pstage.web.servlet.ExportConventionsServlet;
import org.esupportail.pstage.web.utils.PDFUtils;
import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.ConventionDTO;
import org.esupportail.pstagedata.domain.dto.CritereGestionDTO;
import org.esupportail.pstagedata.domain.dto.CritereRechercheConventionDTO;
import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.esupportail.pstagedata.domain.dto.EtudiantDTO;
import org.esupportail.pstagedata.domain.dto.FicheEvaluationDTO;
import org.esupportail.pstagedata.domain.dto.OrigineStageDTO;
import org.esupportail.pstagedata.domain.dto.QuestionSupplementaireDTO;
import org.esupportail.pstagedata.domain.dto.ReponseEvaluationDTO;
import org.esupportail.pstagedata.domain.dto.ReponseSupplementaireDTO;
import org.esupportail.pstagedata.domain.dto.StructureDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;

/**
 * A visual bean for the welcome page.
 */
/**
 * @author Garot
 * 
 */
public class EvaluationController extends AbstractContextAwareController {

	/* ***************************************************************
	 * PROPRIETES
	 * **************************************************************/
	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -239570715531002003L;
	/**
	 * Logger.
	 */
	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * ConventionController
	 */
	private ConventionController conventionController;

	/**
	 * Service to generate Xml.
	 */
	private CastorService castorService;

	/**
	 * return String
	 */
	private String togglePanelActiveItem;

	/**
	 * Listes contenant les questions supplementaires pour chaque fiche
	 * d'evaluation
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
	 * code permettant au tuteur pro d'acceder a sa fiche depuis le lien envoye
	 * en mail
	 */
	private String codeAccesFiche;

	/**
	 * liste des centres gestion dans lesquels le gestionnaire connecte a les
	 * droits d'evaluation
	 */
	private List<SelectItem> listeItemsCurrentCentresGestionEval;

	/**
	 * id du centre de gestion choisi pour la recherche de fiche d'evaluation
	 */
	private Integer rechEvalIdCentre;

	/**
	 * Etat de l'affichage de la recherche d'evaluation
	 */
	private int etatAffichageRechEval = 1;

	/**
	 * Liste des criteres presentees au gestionnaires lors de la recherche de
	 * fiche d'evaluation ufr ou etape
	 */
	private List<SelectItem> rechEvalListeCodes;

	/**
	 * true lorsque l'on consulte une convention via la recherche d'evaluation
	 */
	private boolean retourEvaluation = false;

	/**
	 * return true si la personne connectee est tuteur de la convention en cours
	 * de consultation
	 */
	@SuppressWarnings("unused")
	private boolean tuteurCurrentConvention;

	/**
	 * id du type de destinataire pour l'envoi de mail en masse 1:etudiant
	 * 2:tuteur pedago 3:tuteur pro
	 */
	private int typeDestMailEval;

	/**
	 * id du type de mail pour l'envoi de masse 1:1er envoi 2:Rappel
	 */
	private int typeMailEval;

	/**
	 * Contenu du mail pour l'envoi de masse en fonction des types choisis
	 */
	private String contenuMailEval;


	/* ************************
	 * METHODES FICHE ETUDIANT
	 * ***********************/

	/**
	 * Acces la fiche d'evaluation partie Etudiant
	 */
	public String goToFicheEtudiant() {
		this.togglePanelActiveItem = "etudiantTogglePanel1";
		ReponseEvaluationDTO reponseEvalTmp = this.conventionController.getConvention().getReponseEvaluation();
		// Si la reponse n'a pas ete initialise a la creation de la convention,
		// il n'y en a pas encore, on l'initialise donc vide en base
		if (reponseEvalTmp == null) {
			reponseEvalTmp = new ReponseEvaluationDTO();
			reponseEvalTmp.setIdFicheEvaluation(this.conventionController.getConvention()
					.getFicheEvaluation().getIdFicheEvaluation());
			reponseEvalTmp.setIdConvention(this.conventionController.getConvention().getIdConvention());
			try {
				getFicheEvaluationDomainService().addReponseEvaluation(
						reponseEvalTmp);
			} catch (DataAddException ae) {
				logger.error("DataAddException", ae.getCause());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ",
						we.getCause());
				addErrorMessage(null,
						"CONVENTION.CREERCONVENTION.CONVENTION.ERREUR",
						we.getMessage());
			}
			this.conventionController.getConvention().setReponseEvaluation(reponseEvalTmp);
		}

		this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

		// Assignation des questions supplementaires de la partie 1 Etudiant
		this.setQuestionsSupplementairesEtudiant1(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(
						this.conventionController.getConvention().getFicheEvaluation()
						.getIdFicheEvaluation(), 1));
		// S'il y en a, recuperation/initialisation des reponses correspondantes
		if (this.questionsSupplementairesEtudiant1 != null
				&& !this.questionsSupplementairesEtudiant1.isEmpty()) {
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant1) {
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}
		// Assignation des questions supplementaires de la partie 2 Etudiant
		this.setQuestionsSupplementairesEtudiant2(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(
						this.conventionController.getConvention().getFicheEvaluation()
						.getIdFicheEvaluation(), 2));
		if (this.questionsSupplementairesEtudiant2 != null
				&& !this.questionsSupplementairesEtudiant2.isEmpty()) {
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant2) {
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}
		// Assignation des questions supplementaires de la partie 3 Etudiant
		this.setQuestionsSupplementairesEtudiant3(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(
						this.conventionController.getConvention().getFicheEvaluation()
						.getIdFicheEvaluation(), 3));
		if (this.questionsSupplementairesEtudiant3 != null
				&& !this.questionsSupplementairesEtudiant3.isEmpty()) {
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant3) {
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}

		try {
			if (this.reponsesSupplementaires != null
					&& !this.reponsesSupplementaires.isEmpty()) {
				// On l'ajoute vide pour update par la suite
				getFicheEvaluationDomainService().addReponsesSupplementaires(
						reponsesSupplementaires);
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.getCause());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.getCause());
			addErrorMessage(null,
					"CONVENTION.CREERCONVENTION.CONVENTION.ERREUR",
					we.getMessage());
		}

		return "conventionEtape13FicheEvaluationEtudiant";
	}

	/**
	 * Remplissage de la reponse par l'etudiant
	 */
	public void updateReponseEtudiant() {

		ReponseEvaluationDTO reponseEvalTmp = this.conventionController.getConvention().getReponseEvaluation();

		if (reponseEvalTmp != null) {
			try {
				if (this.conventionController.getSelOrigineStage() != null) {
					reponseEvalTmp.setReponseEtuI5(this.conventionController.getSelOrigineStage().getId());
				}

				getFicheEvaluationDomainService()
				.updateReponseEvaluationEtudiant(reponseEvalTmp);

				this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

				if (this.questionsSupplementairesEtudiant1 != null) {
					for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant1) {
						ReponseSupplementaireDTO reponse = question
								.getReponseSupplementaire();
						if (reponse != null
								&& reponse.getIdQuestionSupplementaire() != null) {
							this.reponsesSupplementaires.add(reponse);
						}
					}
				}
				if (this.questionsSupplementairesEtudiant2 != null) {
					for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant2) {
						ReponseSupplementaireDTO reponse = question
								.getReponseSupplementaire();
						if (reponse != null
								&& reponse.getIdQuestionSupplementaire() != null) {
							this.reponsesSupplementaires.add(reponse);
						}
					}
				}
				if (this.questionsSupplementairesEtudiant3 != null) {
					for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant3) {
						ReponseSupplementaireDTO reponse = question
								.getReponseSupplementaire();
						if (reponse != null
								&& reponse.getIdQuestionSupplementaire() != null) {
							this.reponsesSupplementaires.add(reponse);
						}
					}
				}

				if (reponsesSupplementaires != null
						&& !reponsesSupplementaires.isEmpty()) {
					getFicheEvaluationDomainService()
					.updateReponsesSupplementaires(
							reponsesSupplementaires);
				}

				addInfoMessage("formFicheEtudiant",
						"CONVENTION.ETAPE13.CREATION");
				if (logger.isInfoEnabled()) {
					logger.info(getSessionController().getCurrentLogin()
							+ " met a jour sa reponse a la fiche n°"
							+ reponseEvalTmp.getIdFicheEvaluation()
							+ " pour la convention n°"
							+ reponseEvalTmp.getIdConvention());
				}
			} catch (DataUpdateException d) {
				logger.error("DataUpdateException", d.getCause());
				addErrorMessage("formFicheEtudiant",
						"CONVENTION.ETAPE13.ERREUR_AJOUT");
			} catch (WebServiceDataBaseException w) {
				logger.error("WebServiceDataBaseException",
						w.getCause());
				addErrorMessage("formFicheEtudiant",
						"CONVENTION.ETAPE13.ERREUR_WS");
			}
		}
	}

	/**
	 * @return String
	 */
	public String validateFicheEtudiant() {
		this.conventionController.getConvention().getReponseEvaluation().setValidationEtudiant(true);
		this.updateReponseEtudiant();
		return "conventionEtape13FicheEvaluation";
	}

	/**
	 * Generation du pdf pour l'impression de la fiche d'evaluation de
	 * l'etudiant
	 */
	public void editPdfFicheEtudiant() {
		try {
			if (this.conventionController.getConvention().getReponseEvaluation() == null) {
				this.conventionController.setConvention(getConventionDomainService()
						.getConventionFromId(this.conventionController.getConvention().getIdConvention()));
			}
			if (this.conventionController.getConvention().getSujetStage() == null) {
				String sujetDeStage = getConventionDomainService()
						.getConventionFromId(this.conventionController.getConvention().getIdConvention())
						.getSujetStage();
				this.conventionController.getConvention().setSujetStage(sujetDeStage);
			}
			if (this.conventionController.getConvention().getOrigineStage() == null) {
				OrigineStageDTO origine = getConventionDomainService()
						.getConventionFromId(this.conventionController.getConvention().getIdConvention())
						.getOrigineStage();
				this.conventionController.getConvention().setOrigineStage(origine);
			}

			// Recuperation des questions/reponses supplementaires
			List<QuestionSupplementaireDTO> list = getFicheEvaluationDomainService()
					.getQuestionsSupplementaires(
							this.conventionController.getConvention().getFicheEvaluation()
							.getIdFicheEvaluation());
			if (list != null) {
				for (QuestionSupplementaireDTO question : list) {
					question.setReponseSupplementaire(getFicheEvaluationDomainService()
							.getReponseSupplementaire(
									question.getIdQuestionSupplementaire(),
									this.conventionController.getConvention().getIdConvention()));
				}
				this.conventionController.getConvention().setQuestionsSupplementaires(list);
			}
			String nomDocxsl = "";
			String fileNameXml = "";
			String fileNameXmlfin = ".xml";
			String idReponse = this.conventionController.getConvention().getIdConvention().toString();
			nomDocxsl = "ficheEtudiant" + ".xsl";
			fileNameXml = "ficheEtudiant_" + idReponse;
			// appel castor pour fichier xml a partir de objet java convention
			castorService.objectToFileXml(this.conventionController.getConvention(), fileNameXml
					+ fileNameXmlfin);
			// fusion du xsl et xml en pdf
			String fileNamePdf = fileNameXml + ".pdf";
			PDFUtils.exportPDF(fileNameXml + fileNameXmlfin,
					FacesContext.getCurrentInstance(),
					castorService.getXslXmlPath(), fileNamePdf, nomDocxsl);
			// Si c'est un superAdmin ou un gestionnaire qui imprime, on indique
			// en base que la fiche a ete imprimee
			if (getSessionController().isSuperAdminPageAuthorized()
					|| (getSessionController().getDroitsEvaluationEtudiantMap() != null && !getSessionController()
					.getDroitsEvaluationEtudiantMap().isEmpty())) {
				this.conventionController.getConvention().getReponseEvaluation().setImpressionEtudiant(
						true);
				getFicheEvaluationDomainService().setImpressionEtudiant(
						this.conventionController.getConvention().getFicheEvaluation()
						.getIdFicheEvaluation(),
						this.conventionController.getConvention().getIdConvention());
			}
		} catch (ExportException e) {
			logger.error("editPdfFicheEtudiant ", e.getCause());
		}
	}

	/**
	 * Envoi d'un mail avertissant l'etudiant qu'il peut aller remplir sa fiche
	 */
	public void envoiMailEtudiant() {
		String adresseEtudiant = "";
		String nomEtu = "";
		if (this.conventionController.getConvention().getEtudiant() != null) {
			nomEtu = this.conventionController.getConvention().getEtudiant().getPrenom() + " "
					+ this.conventionController.getConvention().getEtudiant().getNom();
			if (this.conventionController.getConvention().getCourrielPersoEtudiant() != null
					&& !this.conventionController.getConvention().getCourrielPersoEtudiant().isEmpty()) {
				adresseEtudiant = this.conventionController.getConvention().getCourrielPersoEtudiant();
			} else if (this.conventionController.getConvention().getEtudiant().getMail() != null
					&& !this.conventionController.getConvention().getEtudiant().getMail().isEmpty()) {
				adresseEtudiant = this.conventionController.getConvention().getEtudiant().getMail();
			}
		} else {
			addErrorMessage("formAccueilFiche:panelMailEtudiant",
					"CONVENTION.ETAPE13.MAIL.INEXISTANT_ETUDIANT",
					this.conventionController.getConvention().getIdConvention());
			return;
		}
		try {
			String contenu = "";
			String sujet = "";
			if (this.typeMailEval == 1) {
				sujet = getSessionController().getApplicationNamePStage()
						+ " - Evaluation de votre stage pour la convention n°"
						+ this.conventionController.getConvention().getIdConvention();
				contenu = getString("CONVENTION.ETAPE13.MAIL.CONTENU_ETUDIANT",
						this.conventionController.getConvention().getStructure().getRaisonSociale(),
						getSessionController().getApplicationNamePStage());
			} else if (this.typeMailEval == 2) {
				sujet = getSessionController().getApplicationNamePStage()
						+ " - Rappel concernant l'évaluation de votre stage pour la convention n°"
						+ this.conventionController.getConvention().getIdConvention();
				contenu = getString(
						"CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ETUDIANT",
						this.conventionController.getConvention().getStructure().getRaisonSociale(),
						getSessionController().getApplicationNamePStage());
			}

			getSmtpService().send(new InternetAddress(adresseEtudiant), sujet,
					contenu, "");
			// On indique en base et pour l'affichage que le mail a ete envoye
			this.conventionController.getConvention().setEnvoiMailEtudiant(true);
			this.conventionController.getConvention().setDateEnvoiMailEtudiant(new Date());
			getFicheEvaluationDomainService().setEnvoiMailEtudiant(
					this.conventionController.getConvention().getIdConvention());
			this.conventionController.getResultatsRechercheConvention().get(
					this.conventionController.getResultatsRechercheConvention().indexOf(this.conventionController.getConvention()))
					.setEnvoiMailEtudiant(true);
			this.conventionController.getResultatsRechercheConvention().get(
					this.conventionController.getResultatsRechercheConvention().indexOf(this.conventionController.getConvention()))
					.setDateEnvoiMailEtudiant(new Date());
			addInfoMessage("formAccueilFiche:panelMailEtudiant",
					"CONVENTION.ETAPE13.MAIL.ENVOI_REUSSI", adresseEtudiant,
					this.conventionController.getConvention().getIdConvention());
			this.conventionController.reloadRechercheConventionPaginator();
		} catch (AddressException e) {
			if (logger.isDebugEnabled()) {
				e.printStackTrace();
			}
			addErrorMessage("formAccueilFiche:panelMailEtudiant",
					"CONVENTION.ETAPE13.MAIL.ERREUR_ETUDIANT", adresseEtudiant,
					nomEtu, this.conventionController.getConvention().getIdConvention());
		}
	}


	/* ************************
	 * METHODES FICHE ENSEIGNANT
	 * ***********************/

	/**
	 * Acces a la partie Enseignant de la fiche d'evaluation
	 */
	public String goToFicheEnseignant() {
		this.togglePanelActiveItem = "enseignantTogglePanel1";
		ReponseEvaluationDTO reponseEvalTmp = this.conventionController.getConvention()
				.getReponseEvaluation();
		if (reponseEvalTmp == null) {
			reponseEvalTmp = new ReponseEvaluationDTO();
			reponseEvalTmp.setIdConvention(this.conventionController.getConvention().getIdConvention());
			reponseEvalTmp.setIdFicheEvaluation(this.conventionController.getConvention()
					.getFicheEvaluation().getIdFicheEvaluation());
			try {
				getFicheEvaluationDomainService().addReponseEvaluation(
						reponseEvalTmp);
			} catch (DataAddException ae) {
				logger.error("DataAddException", ae.getCause());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ",
						we.getCause());
				addErrorMessage(null,
						"CONVENTION.CREERCONVENTION.CONVENTION.ERREUR",
						we.getMessage());
			}
			this.conventionController.getConvention().setReponseEvaluation(reponseEvalTmp);
		}

		this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

		// Assignation des questions supplementaires de la partie 1 Enseignant
		this.setQuestionsSupplementairesEnseignant1(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(
						this.conventionController.getConvention().getFicheEvaluation()
						.getIdFicheEvaluation(), 4));
		// S'il y en a, recuperation/initialisation des reponses correspondantes
		if (this.questionsSupplementairesEnseignant1 != null
				&& !this.questionsSupplementairesEnseignant1.isEmpty()) {
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEnseignant1) {
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}
		// Assignation des questions supplementaires de la partie 2 Enseignant
		this.setQuestionsSupplementairesEnseignant2(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(
						this.conventionController.getConvention().getFicheEvaluation()
						.getIdFicheEvaluation(), 5));
		if (this.questionsSupplementairesEnseignant2 != null
				&& !this.questionsSupplementairesEnseignant2.isEmpty()) {
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEnseignant2) {
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}

		try {
			if (this.reponsesSupplementaires != null
					&& !this.reponsesSupplementaires.isEmpty()) {
				getFicheEvaluationDomainService().addReponsesSupplementaires(
						reponsesSupplementaires);
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.getCause());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.getCause());
			addErrorMessage(null,
					"CONVENTION.CREERCONVENTION.CONVENTION.ERREUR",
					we.getMessage());
		}

		return "conventionEtape13FicheEvaluationEnseignant";
	}

	/**
	 * Remplissage de sa reponse par l'enseignant
	 */
	public void updateReponseEnseignant() {
		ReponseEvaluationDTO reponseEvalTmp = this.conventionController.getConvention()
				.getReponseEvaluation();
		if (reponseEvalTmp != null) {
			try {
				getFicheEvaluationDomainService()
				.updateReponseEvaluationEnseignant(reponseEvalTmp);

				this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

				if (this.questionsSupplementairesEnseignant1 != null) {
					for (QuestionSupplementaireDTO question : this.questionsSupplementairesEnseignant1) {
						ReponseSupplementaireDTO reponse = question
								.getReponseSupplementaire();
						if (reponse != null
								&& reponse.getIdQuestionSupplementaire() != null) {
							this.reponsesSupplementaires.add(reponse);
						}
					}
				}
				if (this.questionsSupplementairesEnseignant2 != null) {
					for (QuestionSupplementaireDTO question : this.questionsSupplementairesEnseignant2) {
						ReponseSupplementaireDTO reponse = question
								.getReponseSupplementaire();
						if (reponse != null
								&& reponse.getIdQuestionSupplementaire() != null) {
							this.reponsesSupplementaires.add(reponse);
						}
					}
				}

				if (reponsesSupplementaires != null
						&& !reponsesSupplementaires.isEmpty()) {
					getFicheEvaluationDomainService()
					.updateReponsesSupplementaires(
							reponsesSupplementaires);
				}

				addInfoMessage("formFicheEnseignant",
						"CONVENTION.ETAPE13.CREATION");
				if (logger.isInfoEnabled()) {
					logger.info(getSessionController().getCurrentLogin()
							+ " met a jour sa reponse a la fiche n°"
							+ reponseEvalTmp.getIdFicheEvaluation()
							+ " pour la convention n°"
							+ reponseEvalTmp.getIdConvention());
				}
			} catch (DataUpdateException d) {
				logger.error("DataUpdateException", d.getCause());
				addErrorMessage("formFicheEnseignant",
						"CONVENTION.ETAPE13.ERREUR_AJOUT");
			} catch (WebServiceDataBaseException w) {
				logger.error("WebServiceDataBaseException",
						w.getCause());
				addErrorMessage("formFicheEnseignant",
						"CONVENTION.ETAPE13.ERREUR_WS");
			}
		}
	}

	/**
	 * @return String
	 */
	public String validateFicheEnseignant() {
		this.conventionController.getConvention().getReponseEvaluation().setValidationEnseignant(true);
		this.updateReponseEnseignant();
		return "conventionEtape13FicheEvaluation";
	}

	/**
	 * Generation du pdf pour l'impression de la fiche Enseignant
	 */
	public void editPdfFicheEnseignant() {
		try {
			// Si la reponseEvaluation n'est pas initialisee, on appelle getConventionFromId pour bien recup toutes les infos
			if (this.conventionController.getConvention().getReponseEvaluation() == null) {
				this.conventionController.setConvention(getConventionDomainService()
						.getConventionFromId(this.conventionController.getConvention().getIdConvention()));
			}
			// Recuperation des questions/reponses supplementaires
			List<QuestionSupplementaireDTO> list = getFicheEvaluationDomainService()
					.getQuestionsSupplementaires(
							this.conventionController.getConvention().getFicheEvaluation()
							.getIdFicheEvaluation());
			if (list != null) {
				for (QuestionSupplementaireDTO question : list) {
					question.setReponseSupplementaire(getFicheEvaluationDomainService()
							.getReponseSupplementaire(
									question.getIdQuestionSupplementaire(),
									this.conventionController.getConvention().getIdConvention()));
				}
				this.conventionController.getConvention().setQuestionsSupplementaires(list);
			}
			String nomDocxsl = "";
			String fileNameXml = "";
			String fileNameXmlfin = ".xml";
			String idReponse = this.conventionController.getConvention().getIdConvention().toString();
			nomDocxsl = "ficheEnseignant" + ".xsl";
			fileNameXml = "ficheEnseignant_" + idReponse;
			// appel castor pour fichier xml a partir de objet java convention
			castorService.objectToFileXml(this.conventionController.getConvention(), fileNameXml
					+ fileNameXmlfin);
			// fusion du xsl et xml en pdf
			String fileNamePdf = fileNameXml + ".pdf";
			PDFUtils.exportPDF(fileNameXml + fileNameXmlfin,
					FacesContext.getCurrentInstance(),
					castorService.getXslXmlPath(), fileNamePdf, nomDocxsl);

			// Si c'est un superAdmin ou un gestionnaire qui imprime, on indique
			// en base que la fiche a ete imprimee
			if (getSessionController().isSuperAdminPageAuthorized()
					|| (getSessionController()
							.getDroitsEvaluationEnseignantMap() != null && !getSessionController()
							.getDroitsEvaluationEnseignantMap().isEmpty())) {
				this.conventionController.getConvention().getReponseEvaluation().setImpressionEnseignant(
						true);
				getFicheEvaluationDomainService().setImpressionEnseignant(
						this.conventionController.getConvention().getFicheEvaluation()
						.getIdFicheEvaluation(),
						this.conventionController.getConvention().getIdConvention());
			}
		} catch (ExportException e) {
			logger.error("editPdfFicheEnseignant ", e.getCause());
		}
	}

	/**
	 * Generation et envoie du lien vers sa fiche au tuteur pédagogique de
	 * l'etudiant
	 */
	public void envoiMailEnseignant() {
		String adresseTuteurPedago = "";
		String nomTuteur = "";
		String libelleEtu = "";
		if (this.conventionController.getConvention().getEnseignant() != null
				&& this.conventionController.getConvention().getEnseignant().getMail() != null
				&& !this.conventionController.getConvention().getEnseignant().getMail().isEmpty()) {
			nomTuteur = this.conventionController.getConvention().getEnseignant().getPrenom() + " "
					+ this.conventionController.getConvention().getEnseignant().getNom();
			adresseTuteurPedago = this.conventionController.getConvention().getEnseignant().getMail();
		} else {
			addErrorMessage("formAccueilFiche:panelMailEnseignant",
					"CONVENTION.ETAPE13.MAIL.INEXISTANT_ENSEIGNANT",
					this.conventionController.getConvention().getIdConvention());
			return;
		}

		if (this.conventionController.getConvention().getEtudiant() != null) {
			libelleEtu = this.conventionController.getConvention().getEtudiant().getPrenom() + " "
					+ this.conventionController.getConvention().getEtudiant().getNom();
		}

		try {
			String contenu = "";
			String sujet = "";
			if (this.typeMailEval == 1) {
				sujet = getSessionController().getApplicationNamePStage()
						+ " - Evaluation du stage de " + libelleEtu;
				contenu = getString(
						"CONVENTION.ETAPE13.MAIL.CONTENU_ENSEIGNANT",
						libelleEtu, this.conventionController.getConvention().getIdConvention(),
						getSessionController().getApplicationNamePStage());
			} else if (this.typeMailEval == 2) {
				sujet = getSessionController().getApplicationNamePStage()
						+ " - Rappel concernant l'évaluation du stage de "
						+ libelleEtu;
				contenu = getString(
						"CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ENSEIGNANT",
						libelleEtu, this.conventionController.getConvention().getIdConvention(),
						getSessionController().getApplicationNamePStage());
			}

			getSmtpService().send(new InternetAddress(adresseTuteurPedago),
					sujet, contenu, "");
			// On indique en base que le mail a ete envoye
			this.conventionController.getConvention().setEnvoiMailTuteurPedago(true);
			this.conventionController.getConvention().setDateEnvoiMailTuteurPedago(new Date());
			getFicheEvaluationDomainService().setEnvoiMailEnseignant(
					this.conventionController.getConvention().getIdConvention());
			this.conventionController.getResultatsRechercheConvention().get(
					this.conventionController.getResultatsRechercheConvention().indexOf(this.conventionController.getConvention()))
					.setEnvoiMailTuteurPedago(true);
			this.conventionController.getResultatsRechercheConvention().get(
					this.conventionController.getResultatsRechercheConvention().indexOf(this.conventionController.getConvention()))
					.setDateEnvoiMailTuteurPedago(new Date());
			addInfoMessage("formAccueilFiche:panelMailEnseignant",
					"CONVENTION.ETAPE13.MAIL.ENVOI_REUSSI",
					adresseTuteurPedago, this.conventionController.getConvention().getIdConvention());
			this.conventionController.reloadRechercheConventionPaginator();
		} catch (AddressException e) {
			if (logger.isDebugEnabled()) {
				e.printStackTrace();
			}
			addErrorMessage("formAccueilFiche:panelMailEnseignant",
					"CONVENTION.ETAPE13.MAIL.ERREUR_ENSEIGNANT",
					adresseTuteurPedago, nomTuteur,
					this.conventionController.getConvention().getIdConvention());
		}
	}


	/* ************************
	 * METHODES FICHE ENTREPRISE
	 * ***********************/

	/**
	 * Acces la fiche d'evaluation partie Entreprise par le super admin
	 */
	public String goToFicheEntreprise() {

		this.accesPartieEntreprise();

		return "conventionEtape13FicheEvaluationEntreprise";
	}

	/**
	 * Acces la fiche d'evaluation partie Entreprise par le tuteur pro
	 * (acces via lien)
	 */
	public String goToFicheEntrepriseTuteurPro() {

		int idDecode = Utils.convertStringToInt(getBlowfishUtils().decode(
				this.codeAccesFiche));
		// recuperation de la convention via l'id
		this.conventionController.setConvention(getConventionDomainService().getConventionFromId(
				idDecode));

		this.accesPartieEntreprise();

		return "goToFicheEntrepriseTuteurPro";
	}

	/**
	 * Code global d'acces a la fiche entreprise
	 */
	private void accesPartieEntreprise() {
		this.togglePanelActiveItem = "entrepriseTogglePanel1";
		ReponseEvaluationDTO reponseEvalTmp = this.conventionController.getConvention()
				.getReponseEvaluation();
		if (reponseEvalTmp == null) {
			reponseEvalTmp = new ReponseEvaluationDTO();
			reponseEvalTmp.setIdConvention(this.conventionController.getConvention().getIdConvention());
			reponseEvalTmp.setIdFicheEvaluation(this.conventionController.getConvention()
					.getFicheEvaluation().getIdFicheEvaluation());
			try {
				getFicheEvaluationDomainService().addReponseEvaluation(
						reponseEvalTmp);
			} catch (DataAddException ae) {
				logger.error("DataAddException", ae.getCause());
				addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
			} catch (WebServiceDataBaseException we) {
				logger.error("WebServiceDataBaseException ",
						we.getCause());
				addErrorMessage(null,
						"CONVENTION.CREERCONVENTION.CONVENTION.ERREUR",
						we.getMessage());
			}
			this.conventionController.getConvention().setReponseEvaluation(reponseEvalTmp);
		}

		this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

		// Assignation des questions supplementaires de la partie 1 Entreprise
		this.setQuestionsSupplementairesEntreprise1(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(
						this.conventionController.getConvention().getFicheEvaluation()
						.getIdFicheEvaluation(), 6));
		// S'il y en a, recuperation/initialisation des reponses correspondantes
		if (this.questionsSupplementairesEntreprise1 != null
				&& !this.questionsSupplementairesEntreprise1.isEmpty()) {
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise1) {
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}
		// Assignation des questions supplementaires de la partie 2 Entreprise
		this.setQuestionsSupplementairesEntreprise2(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(
						this.conventionController.getConvention().getFicheEvaluation()
						.getIdFicheEvaluation(), 7));
		// S'il y en a, recuperation/initialisation des reponses correspondantes
		if (this.questionsSupplementairesEntreprise2 != null
				&& !this.questionsSupplementairesEntreprise2.isEmpty()) {
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise2) {
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}
		// Assignation des questions supplementaires de la partie 3 Entreprise
		this.setQuestionsSupplementairesEntreprise3(getFicheEvaluationDomainService()
				.getQuestionsSupplementairesFromIdPlacement(
						this.conventionController.getConvention().getFicheEvaluation()
						.getIdFicheEvaluation(), 8));
		// S'il y en a, recuperation/initialisation des reponses correspondantes
		if (this.questionsSupplementairesEntreprise3 != null
				&& !this.questionsSupplementairesEntreprise3.isEmpty()) {
			for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise3) {
				ReponseSupplementaireDTO reponse = recupReponseSup(question);
				question.setReponseSupplementaire(reponse);
			}
		}

		try {
			if (this.reponsesSupplementaires != null
					&& !this.reponsesSupplementaires.isEmpty()) {
				getFicheEvaluationDomainService().addReponsesSupplementaires(
						reponsesSupplementaires);
			}
		} catch (DataAddException ae) {
			logger.error("DataAddException", ae.getCause());
			addErrorMessage(null, "CONVENTION.CREERCONVENTION.ERREURAJOUT");
		} catch (WebServiceDataBaseException we) {
			logger.error("WebServiceDataBaseException ", we.getCause());
			addErrorMessage(null,
					"CONVENTION.CREERCONVENTION.CONVENTION.ERREUR",
					we.getMessage());
		}
	}

	/**
	 * Remplissage de la fiche entreprise par le superadmin
	 */
	public void updateReponseEntreprise() {
		ReponseEvaluationDTO reponseEvalTmp = this.conventionController.getConvention()
				.getReponseEvaluation();

		if (reponseEvalTmp != null) {
			this.commonUpdateReponseEntreprise(reponseEvalTmp);

			addInfoMessage("formFicheEntreprise", "CONVENTION.ETAPE13.CREATION");
			if (logger.isInfoEnabled()) {
				logger.info(getSessionController().getCurrentLogin()
						+ " met a jour sa reponse a la fiche n°"
						+ reponseEvalTmp.getIdFicheEvaluation()
						+ " pour la convention n°"
						+ reponseEvalTmp.getIdConvention());
			}
		}
	}

	/**
	 * Remplissage de la fiche entreprise par le tuteur pro via le lien
	 */
	public void updateReponseEntrepriseTuteurPro() {
		ReponseEvaluationDTO reponseEvalTmp = this.conventionController.getConvention()
				.getReponseEvaluation();

		if (reponseEvalTmp != null) {
			this.commonUpdateReponseEntreprise(reponseEvalTmp);

			addInfoMessage("formFicheEntreprise", "CONVENTION.ETAPE13.CREATION");
			if (logger.isInfoEnabled()) {
				logger.info("Le tuteur professionnel a mis a jour sa reponse a la fiche n°"
						+ reponseEvalTmp.getIdFicheEvaluation()
						+ " pour la convention n°"
						+ reponseEvalTmp.getIdConvention());
			}
		}
	}

	/**
	 * update de la reponse entreprise via l'appli (sans accès via lien)
	 * 
	 * @param reponseEvalTmp
	 */
	private void commonUpdateReponseEntreprise(
			ReponseEvaluationDTO reponseEvalTmp) {
		try {
			getFicheEvaluationDomainService()
			.updateReponseEvaluationEntreprise(reponseEvalTmp);

			this.reponsesSupplementaires = new ArrayList<ReponseSupplementaireDTO>();

			if (this.questionsSupplementairesEntreprise1 != null) {
				for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise1) {
					ReponseSupplementaireDTO reponse = question
							.getReponseSupplementaire();
					if (reponse != null
							&& reponse.getIdQuestionSupplementaire() != null) {
						this.reponsesSupplementaires.add(reponse);
					}
				}
			}
			if (this.questionsSupplementairesEntreprise2 != null) {
				for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise2) {
					ReponseSupplementaireDTO reponse = question
							.getReponseSupplementaire();
					if (reponse != null
							&& reponse.getIdQuestionSupplementaire() != null) {
						this.reponsesSupplementaires.add(reponse);
					}
				}
			}
			if (this.questionsSupplementairesEntreprise3 != null) {
				for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise3) {
					ReponseSupplementaireDTO reponse = question
							.getReponseSupplementaire();
					if (reponse != null
							&& reponse.getIdQuestionSupplementaire() != null) {
						this.reponsesSupplementaires.add(reponse);
					}
				}
			}

			if (reponsesSupplementaires != null
					&& !reponsesSupplementaires.isEmpty()) {
				getFicheEvaluationDomainService()
				.updateReponsesSupplementaires(reponsesSupplementaires);
			}

		} catch (DataUpdateException d) {
			logger.error("DataUpdateException", d.getCause());
			addErrorMessage("formFicheEntreprise",
					"CONVENTION.ETAPE13.ERREUR_AJOUT");
		} catch (WebServiceDataBaseException w) {
			logger.error("WebServiceDataBaseException", w.getCause());
			addErrorMessage("formFicheEntreprise",
					"CONVENTION.ETAPE13.ERREUR_WS");
		}
	}

	/**
	 * @return String
	 */
	public String validateFicheEntreprise() {
		this.conventionController.getConvention().getReponseEvaluation().setValidationEntreprise(true);
		this.updateReponseEntreprise();
		return "conventionEtape13FicheEvaluation";
	}

	/**
	 * @return String
	 */
	public String validateFicheEntrepriseTuteurPro() {
		this.conventionController.getConvention().getReponseEvaluation().setValidationEntreprise(true);
		this.updateReponseEntrepriseTuteurPro();
		return "goToFicheEntrepriseTuteurPro";
	}

	/**
	 * Generation du pdf pour l'impression de la fiche entreprise
	 */
	public void editPdfFicheEntreprise() {
		try {
			ConventionDTO conventionTmp;
			if (this.conventionController.getConvention().getReponseEvaluation() == null) {
				conventionTmp = getConventionDomainService()
						.getConventionFromId(this.conventionController.getConvention().getIdConvention());
			} else {
				conventionTmp = this.conventionController.getConvention();
			}
			// Recuperation des questions/reponses supplementaires
			List<QuestionSupplementaireDTO> list = getFicheEvaluationDomainService()
					.getQuestionsSupplementaires(
							conventionTmp.getFicheEvaluation()
							.getIdFicheEvaluation());
			if (list != null) {
				for (QuestionSupplementaireDTO question : list) {
					question.setReponseSupplementaire(getFicheEvaluationDomainService()
							.getReponseSupplementaire(
									question.getIdQuestionSupplementaire(),
									conventionTmp.getIdConvention()));
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
			castorService.objectToFileXml(conventionTmp, fileNameXml
					+ fileNameXmlfin);
			// fusion du xsl et xml en pdf
			String fileNamePdf = fileNameXml + ".pdf";
			PDFUtils.exportPDF(fileNameXml + fileNameXmlfin,
					FacesContext.getCurrentInstance(),
					castorService.getXslXmlPath(), fileNamePdf, nomDocxsl);
			// Si c'est un superAdmin ou un gestionnaire qui imprime, on indique
			// en base que la fiche a ete imprimee
			if (getSessionController().isSuperAdminPageAuthorized()
					|| (getSessionController()
							.getDroitsEvaluationEnseignantMap() != null && !getSessionController()
							.getDroitsEvaluationEnseignantMap().isEmpty())) {
				conventionTmp.getReponseEvaluation().setImpressionEntreprise(
						true);
				getFicheEvaluationDomainService().setImpressionEntreprise(
						conventionTmp.getFicheEvaluation()
						.getIdFicheEvaluation(),
						conventionTmp.getIdConvention());
			}
		} catch (ExportException e) {
			logger.error("editPdfFicheEntreprise ", e.getCause());
		}
	}

	/**
	 * Generation et envoi du lien vers sa fiche non casifiee au tuteur pro de l'etudiant
	 */
	public void envoiMailEntreprise() {

		// chiffrage de l'id de la convention via blowfish
		String idEncode = getBlowfishUtils().encode(
				"" + this.conventionController.getConvention().getIdConvention());

		String url = getSessionController().getBaseUrl()
				+ "/stylesheets/evaluationStage/index.xhtml" + "?id="
				+ idEncode;

		String adresseTuteurPro = "";
		String nomTuteurPro = "";
		if (this.conventionController.getConvention().getContact() != null
				&& this.conventionController.getConvention().getContact().getMail() != null
				&& !this.conventionController.getConvention().getContact().getMail().isEmpty()) {
			nomTuteurPro = this.conventionController.getConvention().getContact().getPrenom() + " "
					+ this.conventionController.getConvention().getContact().getNom();
			adresseTuteurPro = this.conventionController.getConvention().getContact().getMail();
		} else {
			addErrorMessage("formAccueilFiche:panelMailEntreprise",
					"CONVENTION.ETAPE13.MAIL.INEXISTANT_ENTREPRISE",
					this.conventionController.getConvention().getIdConvention());
			return;
		}

		String libelleEtu = "";
		if (this.conventionController.getConvention().getEtudiant() != null) {
			libelleEtu = this.conventionController.getConvention().getEtudiant().getPrenom() + " "
					+ this.conventionController.getConvention().getEtudiant().getNom();
		}

		try {
			String contenu = "";
			String sujet = "";
			if (this.typeMailEval == 1) {
				sujet = getSessionController().getApplicationNamePStage()
						+ " - Evaluation du stage de " + libelleEtu;
				contenu = getString(
						"CONVENTION.ETAPE13.MAIL.CONTENU_ENTREPRISE",
						libelleEtu, url, getSessionController()
						.getApplicationNamePStage());
			} else if (this.typeMailEval == 2) {
				sujet = getSessionController().getApplicationNamePStage()
						+ " - Rappel concernant l'évaluation du stage de "
						+ libelleEtu;
				contenu = getString(
						"CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ENTREPRISE",
						libelleEtu, url, getSessionController()
						.getApplicationNamePStage());
			}
			getSmtpService().send(new InternetAddress(adresseTuteurPro), sujet,
					contenu, "");
			// On indique en base que le mail a ete envoye
			this.conventionController.getConvention().setEnvoiMailTuteurPro(true);
			this.conventionController.getConvention().setDateEnvoiMailTuteurPro(new Date());
			getFicheEvaluationDomainService().setEnvoiMailEntreprise(this.conventionController.getConvention().getIdConvention());
			// Renseignement de l'envoi/date pour rafraichir la liste
			this.conventionController.getResultatsRechercheConvention().get(
					this.conventionController.getResultatsRechercheConvention().indexOf(this.conventionController.getConvention()))
					.setEnvoiMailTuteurPro(true);
			this.conventionController.getResultatsRechercheConvention().get(
					this.conventionController.getResultatsRechercheConvention().indexOf(this.conventionController.getConvention()))
					.setDateEnvoiMailTuteurPro(new Date());

			addInfoMessage("formAccueilFiche:panelMailTuteurPro",
					"CONVENTION.ETAPE13.MAIL.ENVOI_REUSSI", adresseTuteurPro,
					this.conventionController.getConvention().getIdConvention());

			this.conventionController.reloadRechercheConventionPaginator();
			// Si l'entreprise avait validé sa fiche et a fait la demande de
			// pouvoir la remodifier, l'envoi du rappel l'invalide
			// automatiquement
			if (this.conventionController.getConvention().getReponseEvaluation() != null
					&& this.conventionController.getConvention().getReponseEvaluation()
					.isValidationEntreprise()) {
				this.conventionController.getConvention().getReponseEvaluation().setValidationEntreprise(
						false);
				getFicheEvaluationDomainService()
				.updateReponseEvaluationEntreprise(
						this.conventionController.getConvention().getReponseEvaluation());
			}
		} catch (AddressException e) {
			if (logger.isDebugEnabled()) {
				e.printStackTrace();
			}
			addErrorMessage("formAccueilFiche:panelMailEntreprise",
					"CONVENTION.ETAPE13.MAIL.ERREUR_ENTREPRISE",
					adresseTuteurPro, nomTuteurPro,
					this.conventionController.getConvention().getIdConvention());
		}
	}


	/* ************************
	 * METHODES RECHERCHE/CONSULTATION
	 * ***********************/

	/**
	 * @return String
	 */
	public String goToRechercheEval() {

		this.conventionController.setCritereRechercheConvention(this.conventionController.initCritereRechercheConvention());
		this.conventionController.getCritereRechercheConvention().setNbExportMaxi("");

		this.listeItemsCurrentCentresGestionEval = new ArrayList<SelectItem>();

		if (getSessionController().isSuperAdminPageAuthorized()) {
			List<CentreGestionDTO> centres = getCentreGestionDomainService().getCentreGestionList(getSessionController().getCodeUniversite());
			if (centres != null && !centres.isEmpty()) {
				for (CentreGestionDTO centre : centres) {
					this.listeItemsCurrentCentresGestionEval.add(new SelectItem(centre.getIdCentreGestion(),centre.getNomCentre()));
				}
			}
		} else {
			Map<Integer, Boolean> mapEtu = getSessionController()
					.getDroitsEvaluationEtudiantMap();
			Map<Integer, Boolean> mapEns = getSessionController()
					.getDroitsEvaluationEnseignantMap();
			Map<Integer, Boolean> mapEnt = getSessionController()
					.getDroitsEvaluationEntrepriseMap();

			Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
			if (mapEtu != null && !mapEtu.isEmpty()) {
				map.putAll(mapEtu);
			}
			if (mapEns != null && !mapEns.isEmpty()) {
				map.putAll(mapEns);
			}
			if (mapEnt != null && !mapEnt.isEmpty()) {
				map.putAll(mapEnt);
			}
			if (map != null && !map.isEmpty()) {
				for (Iterator<Integer> iter = map.keySet().iterator(); iter
						.hasNext();) {
					CentreGestionDTO cg = getCentreGestionDomainService().getCentreGestion(iter.next());
					this.listeItemsCurrentCentresGestionEval
					.add(new SelectItem(cg.getIdCentreGestion(), cg
							.getNomCentre()));
				}
			}
		}

		if (this.rechEvalIdCentre == null
				&& this.listeItemsCurrentCentresGestionEval != null
				&& !this.listeItemsCurrentCentresGestionEval.isEmpty()) {
			this.rechEvalIdCentre = (Integer) this.listeItemsCurrentCentresGestionEval
					.get(0).getValue();
		}

		this.updateAffichageListeCodes();

		return "rechercheEvaluation";
	}

	/**
	 * Recherche de fiches d'evaluation de l'etudiant connecte.
	 * 
	 * @return String
	 */
	public String goToRechercheEvalEtu() {
		String ret = "resultatsRechercheEvaluation";
		this.rechEvalIdCentre = null;
		this.conventionController.setConventionCree(false);
		this.conventionController.setConvention(new ConventionDTO());
		this.conventionController.setResultatsRechercheConvention(new ArrayList<ConventionDTO>());
		if (this.getSessionController().getCurrentAuthEtudiant() != null) {
			this.conventionController.setResultatsRechercheConvention(getConventionDomainService()
					.getConventionsEtudiant(
							this.getSessionController()
							.getCurrentAuthEtudiant()
							.getIdentEtudiant(),
							getSessionController().getCodeUniversite()));
			if (this.conventionController.getResultatsRechercheConvention() != null
					&& !this.conventionController.getResultatsRechercheConvention().isEmpty()) {
				for (ConventionDTO convention : this.conventionController.getResultatsRechercheConvention()) {
					FicheEvaluationDTO fiche = getFicheEvaluationDomainService()
							.getFicheEvaluationFromIdCentre(
									convention.getIdCentreGestion());
					if (fiche != null) {
						convention.setFicheEvaluation(fiche);
						int idFicheEvaluation = fiche.getIdFicheEvaluation();
						convention
						.setReponseEvaluation(getFicheEvaluationDomainService()
								.getReponseEvaluation(
										idFicheEvaluation,
										convention.getIdConvention()));
					}
				}
				this.conventionController.reloadRechercheConventionPaginator();
			} else {
				this.conventionController.setResultatsRechercheConvention(null);
				addInfoMessage("formRechEval",
						"RECHERCHEEVALUATION.AUCUNRESULTAT");
				this.conventionController.getRechercheConventionPaginator().reset();
			}
		}

		return ret;
	}

	/**
	 * Recherche de fiches d'evaluation du tuteur pedago connecte.
	 * 
	 * @return String
	 */
	public String goToRechercheEvalEns() {
		String ret = "resultatsRechercheEvaluation";

		this.rechEvalIdCentre = null;
		this.conventionController.setConventionCree(false);
		this.conventionController.setConvention(new ConventionDTO());
		this.conventionController.setRechercheConventionPaginator(new RechercheConventionPaginator());
		this.conventionController.setResultatsRechercheConvention(new ArrayList<ConventionDTO>());
		if (this.getSessionController().getCurrentAuthEnseignant() != null) {
			if (this.getSessionController().getCurrentAuthEnseignant()
					.getUidEnseignant() != null) {
				EnseignantDTO tmpEns = getEnseignantDomainService()
						.getEnseignantFromUid(
								this.getSessionController()
								.getCurrentAuthEnseignant()
								.getUidEnseignant(),
								getSessionController().getCodeUniversite());
				if (tmpEns != null) {
					this.conventionController.setResultatsRechercheConvention(getConventionDomainService()
							.getConventionsByEnseignant(
									tmpEns.getId(),
									getBeanUtils()
									.getAnneeUniversitaireCourante(
											new Date())));

					if (this.conventionController.getResultatsRechercheConvention() != null
							&& !this.conventionController.getResultatsRechercheConvention().isEmpty()) {
						for (ConventionDTO conventionTmp : this.conventionController.getResultatsRechercheConvention()) {
							FicheEvaluationDTO fiche = getFicheEvaluationDomainService()
									.getFicheEvaluationFromIdCentre(
											conventionTmp.getIdCentreGestion());
							if (fiche != null) {
								conventionTmp.setFicheEvaluation(fiche);
								int idFicheEvaluation = fiche
										.getIdFicheEvaluation();
								conventionTmp
								.setReponseEvaluation(getFicheEvaluationDomainService()
										.getReponseEvaluation(
												idFicheEvaluation,
												conventionTmp
												.getIdConvention()));
							}
						}
						this.conventionController.reloadRechercheConventionPaginator();
					} else {
						this.conventionController.setResultatsRechercheConvention(null);
						addInfoMessage("formRechEval",
								"RECHERCHEEVALUATION.AUCUNRESULTAT");
						this.conventionController.getRechercheConventionPaginator().reset();
					}
				}

			}
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String rechercherEvaluation() {
		String ret = "resultatsRechercheEvaluation";
		this.conventionController.setConventionCree(false);
		// Mise a null de tous les criteres inutiles pour la recherche de fiche
		CritereRechercheConventionDTO critereRechercheEvaluation = this.conventionController.getCritereRechercheConvention();
		critereRechercheEvaluation.setNomEnseignant(null);
		critereRechercheEvaluation.setPrenomEnseignant(null);
		critereRechercheEvaluation.setTypeStructure(null);
		critereRechercheEvaluation.setStatutJuridique(null);
		critereRechercheEvaluation.setEstValidee(true);
		critereRechercheEvaluation.setEstVerifiee(null);

		// On ne recherche que pour le centre selectionne dans le menu deroulant
		List<Integer> list = new ArrayList<Integer>();
		list.add(this.rechEvalIdCentre);
		critereRechercheEvaluation.setIdsCentreGestion(list);

		this.conventionController.setResultatsRechercheConvention(getConventionDomainService().getConventionsFromCriteres(critereRechercheEvaluation));
		FicheEvaluationDTO fiche = getFicheEvaluationDomainService().getFicheEvaluationFromIdCentre(this.rechEvalIdCentre);

		// instanciation de l'objet convention juste pour y stocker la fiche
		// d'evaluation afin de l'utiliser dans la page de resultats
		this.conventionController.setConvention(new ConventionDTO());
		this.conventionController.getConvention().setFicheEvaluation(fiche);

		if (this.conventionController.getResultatsRechercheConvention() != null
				&& !this.conventionController.getResultatsRechercheConvention().isEmpty()) {
			if (fiche != null) {
				for (ConventionDTO convention : this.conventionController.getResultatsRechercheConvention()) {
					convention.setFicheEvaluation(fiche);
					int idFicheEvaluation = fiche.getIdFicheEvaluation();
					convention.setReponseEvaluation(getFicheEvaluationDomainService().getReponseEvaluation(idFicheEvaluation,convention.getIdConvention()));
				}
			}
			this.conventionController.reloadRechercheConventionPaginator();
		} else {
			ret = null;
			this.conventionController.setResultatsRechercheConvention(null);
			addInfoMessage("formRechEval", "RECHERCHEEVALUATION.AUCUNRESULTAT");
			this.conventionController.getRechercheConventionPaginator().reset();
		}

		return ret;
	}

	/**
	 * @return String
	 */
	public String goToEvalConvention() {
		String retour = this.conventionController.goToRecapConvention();
		if (retour != null) {
			retour = "conventionEtape13FicheEvaluation";
		}
		return retour;
	}


	/* ************************
	 * METHODES ENVOI MAIL
	 * ***********************/

	/**
	 * @return the contenuMailEval
	 */
	public String getContenuMailEval() {
		if (this.typeMailEval == 1) {
			// 1er envoi
			switch (this.typeDestMailEval) {
			case 1:
				this.contenuMailEval = getString(
						"CONVENTION.ETAPE13.MAIL.CONTENU_ETUDIANT",
						"<i>raison sociale de l'organisme d'accueil</i>",
						getSessionController().getApplicationNamePStage());
				break;
			case 2:
				this.contenuMailEval = getString(
						"CONVENTION.ETAPE13.MAIL.CONTENU_ENSEIGNANT",
						"<i>Nom prenom</i>", "<i>idConvention</i>",
						getSessionController().getApplicationNamePStage());
				break;
			case 3:
				this.contenuMailEval = getString(
						"CONVENTION.ETAPE13.MAIL.CONTENU_ENTREPRISE",
						"<i>Nom prenom</i>", "***", getSessionController()
						.getApplicationNamePStage());
				break;
			default:
				break;
			}
		} else if (this.typeMailEval == 2) {
			// Rappel
			switch (this.typeDestMailEval) {
			case 1:
				this.contenuMailEval = getString(
						"CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ETUDIANT",
						"<i>raison sociale de l'organisme d'accueil</i>",
						getSessionController().getApplicationNamePStage());
				break;
			case 2:
				this.contenuMailEval = getString(
						"CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ENSEIGNANT",
						"<i>Nom prenom</i>", "<i>idConvention</i>",
						getSessionController().getApplicationNamePStage());
				break;
			case 3:
				this.contenuMailEval = getString(
						"CONVENTION.ETAPE13.MAIL.RAPPEL.CONTENU_ENTREPRISE",
						"<i>Nom prenom</i>", "***", getSessionController()
						.getApplicationNamePStage());
				break;
			default:
				break;
			}
		}
		return contenuMailEval;
	}

	/**
	 * Action prealable a l'affichage de la popup d'envoi de mail
	 */
	public void avantEnvoiMailEval() {
		this.typeMailEval = 1;
		this.typeDestMailEval = 1;
	}

	/**
	 * Methode d'envoi des mail en masse pour les fiches d'evaluation
	 */
	public void envoiMailEvalEnMasse() {

		switch (this.typeDestMailEval) {
		case 1:
			for (ConventionDTO conventionTmp : this.conventionController.getRechercheConventionPaginator().getListe()) {
				if (conventionTmp.isValidationConvention()
						&& conventionTmp.getFicheEvaluation()
						.isValidationEtudiant()) {
					this.conventionController.setConvention(getConventionDomainService().getConventionFromId(conventionTmp.getIdConvention()));
					if ((this.conventionController.getConvention().getReponseEvaluation() == null || !this.conventionController.getConvention()
							.getReponseEvaluation().isValidationEtudiant())
							&& ((!this.conventionController.getConvention().isEnvoiMailEtudiant() && this.typeMailEval == 1) || (this.conventionController.getConvention()
									.isEnvoiMailEtudiant() && this.typeMailEval == 2))) {
						if (this.conventionController.getConvention().getIdEtudiant() > 0) {
							EtudiantDTO etudiantTmp = this
									.getEtudiantDomainService()
									.getEtudiantFromId(
											this.conventionController.getConvention().getIdEtudiant());
							if (etudiantTmp != null) {
								this.conventionController.getConvention().setEtudiant(etudiantTmp);
							}
						}
						if (this.conventionController.getConvention().getIdStructure() > 0) {
							StructureDTO structureTmp = this
									.getStructureDomainService()
									.getStructureFromId(
											this.conventionController.getConvention().getIdStructure());
							if (structureTmp != null) {
								this.conventionController.getConvention().setStructure(structureTmp);
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
			for (ConventionDTO conventionTmp : this.conventionController.getRechercheConventionPaginator()
					.getListe()) {
				if (conventionTmp.isValidationConvention()
						&& conventionTmp.getFicheEvaluation()
						.isValidationEnseignant()) {
					this.conventionController.setConvention(getConventionDomainService().getConventionFromId(conventionTmp.getIdConvention()));
					if ((this.conventionController.getConvention().getReponseEvaluation() == null || !this.conventionController.getConvention()
							.getReponseEvaluation().isValidationEnseignant())
							&& ((!this.conventionController.getConvention().isEnvoiMailTuteurPedago() && this.typeMailEval == 1) || (this.conventionController.getConvention()
									.isEnvoiMailTuteurPedago() && this.typeMailEval == 2))) {
						if (this.conventionController.getConvention().getIdEnseignant() > 0) {
							EnseignantDTO enseignantTmp = this
									.getEnseignantDomainService()
									.getEnseignantFromId(
											this.conventionController.getConvention().getIdEnseignant());
							if (enseignantTmp != null) {
								this.conventionController.getConvention().setEnseignant(enseignantTmp);
							}
						}
						if (this.conventionController.getConvention().getIdEtudiant() > 0) {
							EtudiantDTO etudiantTmp = this
									.getEtudiantDomainService()
									.getEtudiantFromId(
											this.conventionController.getConvention().getIdEtudiant());
							if (etudiantTmp != null) {
								this.conventionController.getConvention().setEtudiant(etudiantTmp);
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
			for (ConventionDTO conventionTmp : this.conventionController.getRechercheConventionPaginator().getListe()) {
				if (conventionTmp.isValidationConvention()
						&& conventionTmp.getFicheEvaluation()
						.isValidationEntreprise()) {
					this.conventionController.setConvention(getConventionDomainService().getConventionFromId(conventionTmp.getIdConvention()));
					// On verifie que la fiche n'est pas deja saisie et qu'on
					// envoie un 1er mail ou un mail de rappel
					if ((this.conventionController.getConvention().getReponseEvaluation() == null || !this.conventionController.getConvention()
							.getReponseEvaluation().isValidationEntreprise())
							&& ((!this.conventionController.getConvention().isEnvoiMailTuteurPro() && this.typeMailEval == 1) || (this.conventionController.getConvention()
									.isEnvoiMailTuteurPro() && this.typeMailEval == 2))) {
						if (this.conventionController.getConvention().getIdContact() > 0) {
							ContactDTO contactTmp = this
									.getStructureDomainService()
									.getContactFromId(
											this.conventionController.getConvention().getIdContact());
							if (contactTmp != null) {
								this.conventionController.getConvention().setContact(contactTmp);
							}
						}
						if (this.conventionController.getConvention().getIdEtudiant() > 0) {
							EtudiantDTO etudiantTmp = this
									.getEtudiantDomainService()
									.getEtudiantFromId(
											this.conventionController.getConvention().getIdEtudiant());
							if (etudiantTmp != null) {
								this.conventionController.getConvention().setEtudiant(etudiantTmp);
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
		addInfoMessage("formEnvoiMailEval",
				"CONVENTION.ETAPE13.MAIL.ENVOIMASSE_REUSSI");

		getSessionController().setEnvoiMailEvalCurrentPage(
				"_envoiMailEval_etape2");
	}

	/**
	 * Envoi d'un mail de demande de debloquage de la saisie pour le tuteur pro
	 */
	public void envoiDemandeInvalidation() {
		String nomContact = "";
		String nomEtu = "";

		if (this.conventionController.getConvention().getIdEtudiant() > 0) {
			EtudiantDTO etudiantTmp = this.getEtudiantDomainService()
					.getEtudiantFromId(this.conventionController.getConvention().getIdEtudiant());
			if (etudiantTmp != null) {
				nomEtu = etudiantTmp.getPrenom() + " " + etudiantTmp.getNom();
			} else {
				addErrorMessage(null,
						"CONVENTION.ETAPE13.MAIL.INEXISTANT_ETUDIANT",
						this.conventionController.getConvention().getIdConvention());
				return;
			}
		}

		if (this.conventionController.getConvention().getIdContact() > 0) {
			ContactDTO contactTmp = this.getStructureDomainService()
					.getContactFromId(this.conventionController.getConvention().getIdContact());
			if (contactTmp != null) {
				nomContact = contactTmp.getPrenom() + " " + contactTmp.getNom();
			} else {
				addErrorMessage(null,
						"CONVENTION.ETAPE13.MAIL.INEXISTANT_ENTREPRISE",
						this.conventionController.getConvention().getIdConvention());
				return;
			}
		}

		String sujet = getSessionController().getApplicationNamePStage()
				+ " - Evaluation de votre stage pour la convention n°"
				+ this.conventionController.getConvention().getIdConvention();
		String contenu = getString(
				"CONVENTION.ETAPE13.MAIL.CONTENU_DEMANDE_INVALIDATION",
				nomContact, nomEtu, this.conventionController.getConvention().getIdConvention(),
				getSessionController().getApplicationNamePStage());

		getSmtpService().send(getSessionController().getMailingListPStageIA(),
				sujet, contenu, "");

		addInfoMessage(null, "CONVENTION.ETAPE13.MAIL.ENVOI_REUSSI",
				getSessionController().getMailingListPStageIA(),
				this.conventionController.getConvention().getIdConvention());

	}


	/* ************************
	 * METHODES EXPORT
	 * ***********************/

	/**
	 * Export excel des fiches etudiant
	 */
	public void exportFichesEtudiantColumn() {

		List<ConventionDTO> listeExportEval = new ArrayList<ConventionDTO>();
		if (this.conventionController.getRechercheConventionPaginator().getListe() != null) {
			listeExportEval = this.conventionController.getRechercheConventionPaginator().getListe();
		}

		if (listeExportEval != null && !listeExportEval.isEmpty()) {

			HSSFWorkbook classeur = new HSSFWorkbook();
			HSSFSheet sheet = classeur.createSheet("exportFichesEtudiant");

			List<String> header = new ArrayList<String>();
			FicheEvaluationDTO ficheEvaluation = getFicheEvaluationDomainService()
					.getFicheEvaluationFromIdCentre(this.rechEvalIdCentre);

			header.add(getString("RECHERCHEEVALUATION.NUMCONVENTION"));

			// ajout colonne nom et prenom
			header.add(getString("CONVENTION.NOM"));
			header.add(getString("CONVENTION.PRENOM"));

			/*******************************
			 * HEADER ETUDIANT PART I
			 ******************************/
			// On ajoute les questions en fonction de leur utilisation par le centre ou non
			if (ficheEvaluation.isQuestionEtuI1())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.1"));
			if (ficheEvaluation.isQuestionEtuI2())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.2"));
			if (ficheEvaluation.isQuestionEtuI3())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.3"));
			if (ficheEvaluation.isQuestionEtuI4())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.4"));
			if (ficheEvaluation.isQuestionEtuI5())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.5"));
			if (ficheEvaluation.isQuestionEtuI6())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.6"));
			if (ficheEvaluation.isQuestionEtuI7())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.7"));
			if (ficheEvaluation.isQuestionEtuI8())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.I.8"));
			// Ajout des questions supplémentaires etudiant partie 1
			this.setQuestionsSupplementairesEtudiant1(getFicheEvaluationDomainService()
					.getQuestionsSupplementairesFromIdPlacement(
							ficheEvaluation.getIdFicheEvaluation(), 1));
			if (this.questionsSupplementairesEtudiant1 != null) {
				for (int i = 0; i < this.questionsSupplementairesEtudiant1.size(); i++) {
					header.add(this.questionsSupplementairesEtudiant1.get(i).getQuestion());
				}
			}

			/*******************************
			 * HEADER ETUDIANT PART II
			 ******************************/
			if (ficheEvaluation.isQuestionEtuII1())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.1"));
			if (ficheEvaluation.isQuestionEtuII2())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.2"));
			if (ficheEvaluation.isQuestionEtuII3())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.3"));
			if (ficheEvaluation.isQuestionEtuII4())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.4"));
			if (ficheEvaluation.isQuestionEtuII5())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.5"));
			if (ficheEvaluation.isQuestionEtuII6())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.II.6"));
			// Ajout des questions supplémentaires etudiant partie 2
			this.setQuestionsSupplementairesEtudiant2(getFicheEvaluationDomainService()
					.getQuestionsSupplementairesFromIdPlacement(
							ficheEvaluation.getIdFicheEvaluation(), 2));
			if (this.questionsSupplementairesEtudiant2 != null) {
				for (int i = 0; i < this.questionsSupplementairesEtudiant2.size(); i++) {
					header.add(this.questionsSupplementairesEtudiant2.get(i).getQuestion());
				}
			}

			/*******************************
			 * HEADER ETUDIANT PART III
			 ******************************/
			if (ficheEvaluation.isQuestionEtuIII1()) {
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.1_1"));
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.1bis"));
			}
			if (ficheEvaluation.isQuestionEtuIII2())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.2"));
			// if (ficheEvaluation.isQuestionEtuIII3())
			// header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.3"));
			if (ficheEvaluation.isQuestionEtuIII4())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.4"));
			if (ficheEvaluation.isQuestionEtuIII5())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.5"));
			if (ficheEvaluation.isQuestionEtuIII6())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.6"));
			if (ficheEvaluation.isQuestionEtuIII7())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.7"));
			if (ficheEvaluation.isQuestionEtuIII8())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.8"));
			if (ficheEvaluation.isQuestionEtuIII9())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.9"));
			if (ficheEvaluation.isQuestionEtuIII10())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.10"));
			if (ficheEvaluation.isQuestionEtuIII11())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.11"));
			if (ficheEvaluation.isQuestionEtuIII12())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.12"));
			// if (ficheEvaluation.isQuestionEtuIII13())
			// header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.13"));
			if (ficheEvaluation.isQuestionEtuIII14())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.14"));
			if (ficheEvaluation.isQuestionEtuIII15())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.15"));
			if (ficheEvaluation.isQuestionEtuIII16())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.QUESTIONS.III.16"));
			// Ajout des questions supplémentaires etudiant partie 3
			this.setQuestionsSupplementairesEtudiant3(getFicheEvaluationDomainService()
					.getQuestionsSupplementairesFromIdPlacement(
							ficheEvaluation.getIdFicheEvaluation(), 3));
			if (this.questionsSupplementairesEtudiant3 != null) {
				for (int i = 0; i < this.questionsSupplementairesEtudiant3.size(); i++) {
					header.add(this.questionsSupplementairesEtudiant3.get(i).getQuestion());
				}
			}

			/** Ecriture du header dans la feuille excel **/
			HSSFRow row_i;
			for (int i = 0; i < header.size(); i++) {
				row_i = sheet.createRow(i);
				row_i.createCell(0).setCellValue(header.get(i));
			}

			// assignation d'une largeur fixe aux columns
			sheet.setColumnWidth(0, 256 * 95);

			// gele de la premiere colonne/en-tete
			sheet.createFreezePane(1, 0);

			// initialisation des variables
			ReponseEvaluationDTO reponseTmp;
			ConventionDTO convention = new ConventionDTO();
			int j = 0;
			HSSFRow row;
			HSSFCell cell;
			// Style general
			HSSFCellStyle cellStyle = classeur.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// Style entete column (gras)
			HSSFCellStyle cellStyle2 = classeur.createCellStyle();
			HSSFFont fonte = classeur.createFont();
			fonte.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cellStyle2.setFont(fonte);
			cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);


			/***************************************************************
			 * REMPLISSAGE AVEC LES REPONSES POUR CHAQUE CONVENTION TROUVEE
			 ***************************************************************/
			for (int i = 0; i < listeExportEval.size(); i++) {

				// Initilisation de la convention dans conventionController pour
				// recuperer ses reponses supplementaires via recupReponseSup
				this.conventionController.setConvention(listeExportEval.get(i));

				// Reglage taille colonne
				sheet.setColumnWidth(i + 1, 256 * 40);

				// Recuperation de la reponse
				reponseTmp = listeExportEval.get(i).getReponseEvaluation();

				if (reponseTmp != null && reponseTmp.isValidationEtudiant()) {

					int cpt = 0;
					String reponse = "";
					row = sheet.getRow(cpt);
					cell = row.createCell(j + 1); // j = colonne (0 = header, 1 = 1ere colonne de donnees)

					// num convention
					cell.setCellValue(listeExportEval.get(i).getIdConvention());
					cell.setCellStyle(cellStyle2);
					cpt++;

					// Remplissage complet de la convention
					convention = listeExportEval.get(i);
					convention = getConventionDomainService().getConventionFromId(convention.getIdConvention());

					// Renseignement etudiant
					convention.setEtudiant(getEtudiantDomainService().getEtudiantFromId(convention.getIdEtudiant()));
					// nom etu
					row = sheet.getRow(cpt);
					cell = row.createCell(j + 1);
					cell.setCellValue(convention.getEtudiant().getNom());
					cell.setCellStyle(cellStyle);
					cpt++;
					// prenom etu
					row = sheet.getRow(cpt);
					cell = row.createCell(j + 1);
					cell.setCellValue(convention.getEtudiant().getPrenom());
					cell.setCellStyle(cellStyle);
					cpt++;

					/*******************************
					 * REPONSES PART I
					 ******************************/
					/** Question I-1 **/
					if (ficheEvaluation.isQuestionEtuI1()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						switch (reponseTmp.getReponseEtuI1()) {
						case 1:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.1.1");
							break;
						case 2:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.1.2");
							break;
						case 3:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.1.3");
							break;
						default:
							break;
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question I-2 **/
					if (ficheEvaluation.isQuestionEtuI2()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						switch (reponseTmp.getReponseEtuI2()) {
						case 1:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.2.1");
							break;
						case 2:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.2.2");
							break;
						case 3:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.2.3");
							break;
						case 4:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.2.4");
							break;
						case 5:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.2.5");
							break;
						default:
							break;
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question I-3 **/
					if (ficheEvaluation.isQuestionEtuI3()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						switch (reponseTmp.getReponseEtuI3()) {
						case 1:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.3.1");
							break;
						case 2:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.3.2");
							break;
						case 3:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.3.3");
							break;
						case 4:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.3.4");
							break;
						default:
							break;
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question I-4 **/
					if (ficheEvaluation.isQuestionEtuI4()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						if (reponseTmp.isReponseEtuI4a())
							reponse += getString("CENTRE.FICHE_EVALUATION.LIBELLES.MAIL");
						if (reponseTmp.isReponseEtuI4b())
							reponse += (" " + getString("CENTRE.FICHE_EVALUATION.LIBELLES.TELEPHONE"));
						if (reponseTmp.isReponseEtuI4c())
							reponse += (" " + getString("CENTRE.FICHE_EVALUATION.LIBELLES.COURRIER"));
						if (reponseTmp.isReponseEtuI4d())
							reponse += (" " + getString("CENTRE.FICHE_EVALUATION.LIBELLES.PROSPECTION"));
						if (reponse == "") {
							reponse = "NÉANT";
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question I-5 **/
					if (ficheEvaluation.isQuestionEtuI5()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						if (reponseTmp.getReponseEtuI5() > 0)
							reponse = getNomenclatureDomainService()
							.getOrigineStageDTOFromId(
									reponseTmp.getReponseEtuI5())
									.getLibelle();
						if (reponse == null) {
							reponse = "";
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question I-6 **/
					if (ficheEvaluation.isQuestionEtuI6()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						switch (reponseTmp.getReponseEtuI6()) {
						case 1:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.6.1");
							break;
						case 2:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.6.2");
							break;
						case 3:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.6.3");
							break;
						case 4:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.6.4");
							break;
						default:
							break;
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question I-7 **/
					if (ficheEvaluation.isQuestionEtuI7()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						// Cas NON
						if (!reponseTmp.isReponseEtuI7()) {
							switch (reponseTmp.getReponseEtuI7bis2()) {
							case 1:
								reponse = (" Non - " + getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.NON.1"));
								break;
							case 2:
								reponse = (" Non - " + getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.NON.2"));
								break;
							}
						}
						// Cas OUI
						if (reponseTmp.isReponseEtuI7()) {
							switch (reponseTmp.getReponseEtuI7bis1()) {
							case 1:
								reponse = (" Oui - " + getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.OUI.1"));
								break;
							case 2:
								reponse = (" Oui - " + getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.OUI.2"));
								break;
							case 3:
								reponse = (" Oui - "
										+ getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.OUI.3")
										+ " - Utilisation des ressources : " + reponseTmp
										.isReponseEtuI7bis1a());
								break;
							case 4:
								reponse = (" Oui - " + getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.OUI.4"));
								break;
							case 5:
								reponse = (" Oui - "
										+ getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.I.7.OUI.5")
										+ " : " + reponseTmp
										.getReponseEtuI7bis1b());
								break;
							default:
								break;
							}
						}
						if (reponse == "") {
							reponse = "NÉANT";
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question I-8 **/
					if (ficheEvaluation.isQuestionEtuI8()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(transformBooleanRep(reponseTmp.isReponseEtuI8()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Questions sup I **/
					if (this.questionsSupplementairesEtudiant1 != null
							&& !this.questionsSupplementairesEtudiant1.isEmpty()) {
						for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant1) {
							// On recupere la reponse a partir de la question
							ReponseSupplementaireDTO reponseSup = recupReponseSup(question);
							reponse = "";
							row = sheet.getRow(cpt);
							cell = row.createCell(j + 1);
							if (question.getTypeQuestion() != null ){
								// On evalue le type de la question pour savoir ce qu'il faut récupérer dans l'objet reponse (int, txt ou bool).
								if (question.getTypeQuestion().equalsIgnoreCase("TXT")){
									reponse = reponseSup.getReponseTxt();
								} else if (question.getTypeQuestion().equalsIgnoreCase("INT")){
									if (reponseSup.getReponseInt() != null) reponse = recupLibelleNotation(reponseSup.getReponseInt());
								} else if (question.getTypeQuestion().equalsIgnoreCase("BOOL")){
									if (reponseSup.isReponseBool()) {
										reponse = "Oui";
									} else {
										reponse = "Non";
									}
								}
							}
							cell.setCellValue(reponse);
							cell.setCellStyle(cellStyle);
							cpt++;
						}
					}

					/*******************************
					 * REPONSES PART II
					 ******************************/
					/** Question II-1 **/
					if (ficheEvaluation.isQuestionEtuII1()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (reponseTmp.getReponseEtuII1() == 4
								|| reponseTmp.getReponseEtuII1() == 5)
							cell.setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEtuII1())+ " : " + reponseTmp.getReponseEtuII1bis());
						else
							cell.setCellValue(this.recupLibelleNotation(reponseTmp.getReponseEtuII1()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-2 **/
					if (ficheEvaluation.isQuestionEtuII2()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (reponseTmp.getReponseEtuII2() == 4
								|| reponseTmp.getReponseEtuII2() == 5)
							cell.setCellValue(this
									.recupLibelleNotation(reponseTmp
											.getReponseEtuII2())
											+ " : " + reponseTmp.getReponseEtuII2bis());
						else
							cell.setCellValue(this
									.recupLibelleNotation(reponseTmp
											.getReponseEtuII2()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-3 **/
					if (ficheEvaluation.isQuestionEtuII3()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (reponseTmp.getReponseEtuII3() == 4
								|| reponseTmp.getReponseEtuII3() == 5)
							cell.setCellValue(this
									.recupLibelleNotation(reponseTmp
											.getReponseEtuII3())
											+ " : " + reponseTmp.getReponseEtuII3bis());
						else
							cell.setCellValue(this
									.recupLibelleNotation(reponseTmp
											.getReponseEtuII3()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-4 **/
					if (ficheEvaluation.isQuestionEtuII4()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleAvis(reponseTmp.getReponseEtuII4()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					// if (ficheEvaluation.isQuestionEtuII5())
					// row=sheet.getRow(cpt); cell=row.createCell(j+1);
					// cell.setCellValue(reponseTmp.isReponseEtuII5());
					// cell.setCellStyle(cellStyle); cpt++;

					/** Question II-5 **/
					if (ficheEvaluation.isQuestionEtuII5()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						// cas NON
						if (!reponseTmp.isReponseEtuII5()) {
							cell.setCellValue("Non");
							cell.setCellStyle(cellStyle);
							cpt++;
						}
						// cas OUI
						if (reponseTmp.isReponseEtuII5()) {
							switch (reponseTmp.getReponseEtuII5a()) {
							case 1:
								if (reponseTmp.isReponseEtuII5b()) {
									reponse = (" Oui - "
											+ getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.1") + " - Avec autonomie : Oui");
								} else {
									reponse = (" Oui - "
											+ getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.1") + " - Avec autonomie : Non");
								}
								break;
							case 2:
								if (reponseTmp.isReponseEtuII5b()) {
									reponse = (" Oui - "
											+ getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.2") + " - Avec autonomie : Oui");
								} else {
									reponse = (" Oui - "
											+ getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.2") + " - Avec autonomie : Non");
								}
								break;
							case 3:
								if (reponseTmp.isReponseEtuII5b()) {
									reponse = (" Oui - "
											+ getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.3") + " - Avec autonomie : Oui");
								} else {
									reponse = (" Oui - "
											+ getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.II.5.OUI.3") + " - Avec autonomie : Non");
								}
								break;
							}
							cell.setCellValue(reponse);
							cell.setCellStyle(cellStyle);
							cpt++;
						}
					}

					/** Question II-6 **/
					if (ficheEvaluation.isQuestionEtuII6()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(transformBooleanRep(reponseTmp.isReponseEtuII6()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Questions sup II **/
					if (this.questionsSupplementairesEtudiant2 != null
							&& !this.questionsSupplementairesEtudiant2.isEmpty()) {
						for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant2) {
							// On recupere la reponse a partir de la question
							ReponseSupplementaireDTO reponseSup = recupReponseSup(question);
							reponse = "";
							row = sheet.getRow(cpt);
							cell = row.createCell(j + 1);
							if (question.getTypeQuestion() != null && reponseSup != null){
								// On evalue le type de la question pour savoir ce qu'il faut récupérer dans l'objet reponse (int, txt ou bool).
								if (question.getTypeQuestion().equalsIgnoreCase("TXT")){
									reponse = reponseSup.getReponseTxt();
								} else if (question.getTypeQuestion().equalsIgnoreCase("INT")){
									if (reponseSup.getReponseInt() != null) reponse = recupLibelleNotation(reponseSup.getReponseInt());
								} else if (question.getTypeQuestion().equalsIgnoreCase("BOOL")){
									if (reponseSup.isReponseBool()) {
										reponse = "Oui";
									} else {
										reponse = "Non";
									}
								}
							}
							cell.setCellValue(reponse);
							cell.setCellStyle(cellStyle);
							cpt++;
						}
					}

					/*******************************
					 * REPONSES PART III
					 ******************************/
					/** Question III-1 **/
					if (ficheEvaluation.isQuestionEtuIII1()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(convention.getSujetStage());
						cell.setCellStyle(cellStyle);
						cpt++;

						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (reponseTmp.isReponseEtuIII1())
							cell.setCellValue("Oui, pour le sujet suivant : "
									+ reponseTmp.getReponseEtuIII1bis());
						else
							cell.setCellValue("Non");
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-2 **/
					if (ficheEvaluation.isQuestionEtuIII2()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (!reponseTmp.isReponseEtuIII2())
							cell.setCellValue("Non : "
									+ reponseTmp.getReponseEtuIII2bis());
						else
							cell.setCellValue("Oui");
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-3 **/
					// if (ficheEvaluation.isQuestionEtuIII3())
					// row.createCell(cpt).setCellValue(reponseTmp.isReponseEtuIII3());
					// cpt++;

					/** Question III-4 **/
					if (ficheEvaluation.isQuestionEtuIII4()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						switch (reponseTmp.getReponseEtuIII4()) {
						case 1:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.1");
							break;
						case 2:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.2");
							break;
						case 3:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.3");
							break;
						case 4:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.4");
							break;
						case 5:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.5");
							break;
						case 6:
							reponse = getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.4.6");
							break;
						default:
							break;
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-5 **/
					if (ficheEvaluation.isQuestionEtuIII5()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						if (reponseTmp.isReponseEtuIII5a())
							reponse += getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.5.1");
						if (reponseTmp.isReponseEtuIII5b())
							reponse += (" "
									+ getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.5.2")
									+ " : " + reponseTmp.getReponseEtuIII5bis());
						if (reponseTmp.isReponseEtuIII5c())
							reponse += (" " + getString("CENTRE.FICHE_EVALUATION.FICHE_ETUDIANT.REPONSES.III.5.3"));
						if (reponse == "") {
							reponse = "NÉANT";
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-6 **/
					if (ficheEvaluation.isQuestionEtuIII6()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (reponseTmp.getReponseEtuIII6() == 4
								|| reponseTmp.getReponseEtuIII6() == 5)
							cell.setCellValue(this.recupLibelleAvis(reponseTmp
									.getReponseEtuIII6())
									+ " : "
									+ reponseTmp.getReponseEtuIII6bis());
						else
							cell.setCellValue(this.recupLibelleAvis(reponseTmp
									.getReponseEtuIII6()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-7 **/
					if (ficheEvaluation.isQuestionEtuIII7()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (reponseTmp.getReponseEtuIII7() == 4
								|| reponseTmp.getReponseEtuIII7() == 5)
							cell.setCellValue(this.recupLibelleAvis(reponseTmp
									.getReponseEtuIII7())
									+ " : "
									+ reponseTmp.getReponseEtuIII7bis());
						else
							cell.setCellValue(this.recupLibelleAvis(reponseTmp
									.getReponseEtuIII7()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-8 **/
					if (ficheEvaluation.isQuestionEtuIII8()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (reponseTmp.isReponseEtuIII8())
							cell.setCellValue("Oui : "
									+ reponseTmp.getReponseEtuIII8bis());
						else
							cell.setCellValue("Non");
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-9 **/
					if (ficheEvaluation.isQuestionEtuIII9()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (!reponseTmp.isReponseEtuIII9())
							cell.setCellValue("Non : "
									+ reponseTmp.getReponseEtuIII9bis());
						else
							cell.setCellValue("Oui");
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-10 **/
					if (ficheEvaluation.isQuestionEtuIII10()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(transformBooleanRep(reponseTmp.isReponseEtuIII10()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-11 **/
					if (ficheEvaluation.isQuestionEtuIII11()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(transformBooleanRep(reponseTmp.isReponseEtuIII11()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-12 **/
					if (ficheEvaluation.isQuestionEtuIII12()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(transformBooleanRep(reponseTmp.isReponseEtuIII12()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-13 **/
					// if (ficheEvaluation.isQuestionEtuIII13())
					// row=sheet.getRow(cpt); cell=row.createCell(j+1);
					// cell.setCellValue(reponseTmp.isReponseEtuIII13());
					// cell.setCellStyle(cellStyle); cpt++;

					/** Question III-14 **/
					if (ficheEvaluation.isQuestionEtuIII14()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(transformBooleanRep(reponseTmp.isReponseEtuIII14()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-15 **/
					if (ficheEvaluation.isQuestionEtuIII15()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (reponseTmp.getReponseEtuIII15() == 4
								|| reponseTmp.getReponseEtuIII15() == 5)
							cell.setCellValue(this.recupLibelleAvis(reponseTmp
									.getReponseEtuIII15())
									+ " : "
									+ reponseTmp.getReponseEtuIII15bis());
						else
							cell.setCellValue(this.recupLibelleAvis(reponseTmp
									.getReponseEtuIII15()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-16 **/
					if (ficheEvaluation.isQuestionEtuIII16()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (reponseTmp.getReponseEtuIII16() == 4
								|| reponseTmp.getReponseEtuIII16() == 5)
							cell.setCellValue(this
									.recupLibelleNotation(reponseTmp
											.getReponseEtuIII16())
											+ " : "
											+ reponseTmp.getReponseEtuIII16bis());
						else
							cell.setCellValue(this
									.recupLibelleNotation(reponseTmp
											.getReponseEtuIII16()));
						cell.setCellStyle(cellStyle);
					}

					/** Questions sup III **/
					if (this.questionsSupplementairesEtudiant3 != null
							&& !this.questionsSupplementairesEtudiant3.isEmpty()) {
						for (QuestionSupplementaireDTO question : this.questionsSupplementairesEtudiant3) {
							// On recupere la reponse a partir de la question
							ReponseSupplementaireDTO reponseSup = recupReponseSup(question);
							reponse = "";
							row = sheet.getRow(cpt);
							cell = row.createCell(j + 1);
							if (question.getTypeQuestion() != null ){
								// On evalue le type de la question pour savoir ce qu'il faut récupérer dans l'objet reponse (int, txt ou bool).
								if (question.getTypeQuestion().equalsIgnoreCase("TXT")){
									reponse = reponseSup.getReponseTxt();
								} else if (question.getTypeQuestion().equalsIgnoreCase("INT")){
									if (reponseSup.getReponseInt() != null) reponse = recupLibelleNotation(reponseSup.getReponseInt());
								} else if (question.getTypeQuestion().equalsIgnoreCase("BOOL")){
									if (reponseSup.isReponseBool()) {
										reponse = "Oui";
									} else {
										reponse = "Non";
									}
								}
							}
							cell.setCellValue(reponse);
							cell.setCellStyle(cellStyle);
							cpt++;
						}
					}

					// Incrementation = passage a la colonne suivante
					j++;
				}
			}
			/**************************************
			 * GENERATION DU FICHIER EXCEL ETUDIANT
			 **************************************/
			try {
				ByteArrayOutputStream baosXLS = new ByteArrayOutputStream();

				classeur.write(baosXLS);

				ExportConventionsServlet edit = new ExportConventionsServlet();

				List<Integer> idCentre = this.conventionController.getCritereRechercheConvention().getIdsCentreGestion();

				String XlsFileName = "extraction_pstage_etudiant_IdCentre_"
						+ idCentre.get(0)
						+ "_AnneeUniv_"
						+ this.conventionController.getCritereRechercheConvention().getAnneeUniversitaire() + ".xls";

				edit.doGet(baosXLS, XlsFileName);

			} catch (Exception e) {
				logger.error("exportFichesEtudiant() - Exception lors de la tentative d'ecriture du baosXLS : "
						+ e.getMessage());
			}
		}
	}

	/**
	 * Export excel des fiches enseignant
	 */
	public void exportFichesEnseignantColumn() {

		List<ConventionDTO> listeExportEval = new ArrayList<ConventionDTO>();
		if (this.conventionController.getRechercheConventionPaginator().getListe() != null) {
			listeExportEval = this.conventionController.getRechercheConventionPaginator().getListe();
		}

		if (listeExportEval != null && !listeExportEval.isEmpty()) {

			HSSFWorkbook classeur = new HSSFWorkbook();
			HSSFSheet sheet = classeur.createSheet("exportFichesEnseignant");

			List<String> header = new ArrayList<String>();

			FicheEvaluationDTO ficheEvaluation = getFicheEvaluationDomainService()
					.getFicheEvaluationFromIdCentre(this.rechEvalIdCentre);

			header.add(getString("RECHERCHEEVALUATION.NUMCONVENTION"));

			// ajout des noms prenoms
			header.add(getString("CONVENTION.NOM"));
			header.add(getString("CONVENTION.PRENOM"));

			/*******************************
			 * HEADER ENSEIGNANT PART I
			 ******************************/
			// On ajoute les questions en fonction de leur utilisation par le centre ou non
			if (ficheEvaluation.isQuestionEnsI1())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.I.1"));
			if (ficheEvaluation.isQuestionEnsI2())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.I.2"));
			if (ficheEvaluation.isQuestionEnsI3())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.I.3"));
			// Ajout des questions supplémentaires enseignant partie 1
			this.setQuestionsSupplementairesEnseignant1(getFicheEvaluationDomainService()
					.getQuestionsSupplementairesFromIdPlacement(
							ficheEvaluation.getIdFicheEvaluation(), 4));
			if (this.questionsSupplementairesEnseignant1 != null) {
				for (int i = 0; i < this.questionsSupplementairesEnseignant1.size(); i++) {
					header.add(this.questionsSupplementairesEnseignant1.get(i).getQuestion());
				}
			}

			/*******************************
			 * HEADER ENSEIGNANT PART II
			 ******************************/
			// On ajoute les questions en fonction de leur utilisation par le centre ou non
			if (ficheEvaluation.isQuestionEnsII1())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.1"));
			if (ficheEvaluation.isQuestionEnsII2())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.2"));
			if (ficheEvaluation.isQuestionEnsII3())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.3"));
			if (ficheEvaluation.isQuestionEnsII4())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.4"));
			if (ficheEvaluation.isQuestionEnsII5())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.5"));
			if (ficheEvaluation.isQuestionEnsII6())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.6"));
			if (ficheEvaluation.isQuestionEnsII7())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.7"));
			if (ficheEvaluation.isQuestionEnsII8())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.8"));
			if (ficheEvaluation.isQuestionEnsII9())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.9"));
			if (ficheEvaluation.isQuestionEnsII10())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.10"));
			if (ficheEvaluation.isQuestionEnsII11())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENSEIGNANT.QUESTIONS.II.11"));
			// Ajout des questions supplémentaires enseignant partie 2
			this.setQuestionsSupplementairesEnseignant1(getFicheEvaluationDomainService()
					.getQuestionsSupplementairesFromIdPlacement(
							ficheEvaluation.getIdFicheEvaluation(), 5));
			if (this.questionsSupplementairesEnseignant1 != null) {
				for (int i = 0; i < this.questionsSupplementairesEnseignant1.size(); i++) {
					header.add(this.questionsSupplementairesEnseignant1.get(i).getQuestion());
				}
			}

			/** Ecriture du header dans la feuille excel **/
			HSSFRow row_i;
			for (int i = 0; i < header.size(); i++) {
				row_i = sheet.createRow(i);
				row_i.createCell(0).setCellValue(header.get(i));
			}

			// assignation d'une largeur fixe aux columns
			sheet.setColumnWidth(0, 256 * 46);

			// geler de la premiere colonne/en-tete
			sheet.createFreezePane(1, 0);

			// initialisation des variables
			ReponseEvaluationDTO reponseTmp;
			ConventionDTO convention = new ConventionDTO();
			HSSFRow row;
			HSSFCell cell;
			// Style general
			HSSFCellStyle cellStyle = classeur.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// Style entete column (gras)
			HSSFCellStyle cellStyle2 = classeur.createCellStyle();
			HSSFFont fonte = classeur.createFont();
			fonte.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cellStyle2.setFont(fonte);
			cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			int j = 0;

			/***************************************************************
			 * REMPLISSAGE AVEC LES REPONSES POUR CHAQUE CONVENTION TROUVEE
			 ***************************************************************/
			for (int i = 0; i < listeExportEval.size(); i++) {

				// Initilisation de la convention dans conventionController pour
				// recuperer ses reponses supplementaires via recupReponseSup
				this.conventionController.setConvention(listeExportEval.get(i));

				// Reglage taille colonne
				sheet.setColumnWidth(i + 1, 256 * 22);

				// Recuperation de la reponse
				reponseTmp = listeExportEval.get(i).getReponseEvaluation();

				if (reponseTmp != null && reponseTmp.isValidationEnseignant()) {

					int cpt = 0;
					String reponse = "";
					row = sheet.getRow(cpt);
					cell = row.createCell(j + 1); // j = colonne (0 = header, 1 = 1ere colonne de donnees)

					// num convention
					cell.setCellValue(listeExportEval.get(i).getIdConvention());
					cell.setCellStyle(cellStyle2);
					cpt++;
					
					// Remplissage complet de la convention
					convention = listeExportEval.get(i);
					convention = getConventionDomainService().getConventionFromId(convention.getIdConvention());

					// Renseignement etudiant
					convention.setEtudiant(getEtudiantDomainService().getEtudiantFromId(convention.getIdEtudiant()));
					// nom etu
					row = sheet.getRow(cpt);
					cell = row.createCell(j + 1);
					cell.setCellValue(convention.getEtudiant().getNom());
					cell.setCellStyle(cellStyle);
					cpt++;
					// prenom etu
					row = sheet.getRow(cpt);
					cell = row.createCell(j + 1);
					cell.setCellValue(convention.getEtudiant().getPrenom());
					cell.setCellStyle(cellStyle);
					cpt++;

					/*******************************
					 * REPONSES PART I
					 ******************************/
					/** Question I-1 **/
					if (ficheEvaluation.isQuestionEnsI1()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						if (reponseTmp.isReponseEnsI1a())
							reponse += getString("CENTRE.FICHE_EVALUATION.LIBELLES.MAIL");
						if (reponseTmp.isReponseEnsI1b())
							reponse += (" " + getString("CENTRE.FICHE_EVALUATION.LIBELLES.TELEPHONE"));
						if (reponseTmp.isReponseEnsI1c())
							reponse += (" " + getString("CENTRE.FICHE_EVALUATION.LIBELLES.RENCONTRE"));

						if (reponse == "") {
							reponse = "NÉANT";
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question I-2 **/
					if (ficheEvaluation.isQuestionEnsI2()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						reponse = "";
						if (reponseTmp.isReponseEnsI2a())
							reponse += getString("CENTRE.FICHE_EVALUATION.LIBELLES.MAIL");
						if (reponseTmp.isReponseEnsI2b())
							reponse += (" " + getString("CENTRE.FICHE_EVALUATION.LIBELLES.TELEPHONE"));
						if (reponseTmp.isReponseEnsI2c())
							reponse += (" " + getString("CENTRE.FICHE_EVALUATION.LIBELLES.RENCONTRE"));

						if (reponse == "") {
							reponse = "NÉANT";
						}
						cell.setCellValue(reponse);
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question I-3 **/
					if (ficheEvaluation.isQuestionEnsI3()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(reponseTmp.getReponseEnsI3());
						cell.setCellStyle(cellStyle);
						cpt++;
					}


					/** Questions sup I **/
					if (this.questionsSupplementairesEnseignant1 != null
							&& !this.questionsSupplementairesEnseignant1.isEmpty()) {
						for (QuestionSupplementaireDTO question : this.questionsSupplementairesEnseignant1) {
							// On recupere la reponse a partir de la question
							ReponseSupplementaireDTO reponseSup = recupReponseSup(question);
							reponse = "";
							row = sheet.getRow(cpt);
							cell = row.createCell(j + 1);
							if (question.getTypeQuestion() != null ){
								// On evalue le type de la question pour savoir ce qu'il faut récupérer dans l'objet reponse (int, txt ou bool).
								if (question.getTypeQuestion().equalsIgnoreCase("TXT")){
									reponse = reponseSup.getReponseTxt();
								} else if (question.getTypeQuestion().equalsIgnoreCase("INT")){
									if (reponseSup.getReponseInt() != null) reponse = recupLibelleNotation(reponseSup.getReponseInt());
								} else if (question.getTypeQuestion().equalsIgnoreCase("BOOL")){
									if (reponseSup.isReponseBool()) {
										reponse = "Oui";
									} else {
										reponse = "Non";
									}
								}
							}
							cell.setCellValue(reponse);
							cell.setCellStyle(cellStyle);
							cpt++;
						}
					}

					/*******************************
					 * REPONSES PART II
					 ******************************/
					/** Question II-1 **/
					if (ficheEvaluation.isQuestionEnsII1()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnsII1()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-2 **/
					if (ficheEvaluation.isQuestionEnsII2()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnsII2()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-3 **/
					if (ficheEvaluation.isQuestionEnsII3()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnsII3()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-4 **/
					if (ficheEvaluation.isQuestionEnsII4()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnsII4()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-5 **/
					if (ficheEvaluation.isQuestionEnsII5()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnsII5()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-6 **/
					if (ficheEvaluation.isQuestionEnsII6()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnsII6()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-7 **/
					if (ficheEvaluation.isQuestionEnsII7()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnsII7()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-8 **/
					if (ficheEvaluation.isQuestionEnsII8()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnsII8()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-9 **/
					if (ficheEvaluation.isQuestionEnsII9()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnsII9()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-10 **/
					if (ficheEvaluation.isQuestionEnsII10()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnsII10()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question II-11 **/
					if (ficheEvaluation.isQuestionEnsII11()){
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(reponseTmp.getReponseEnsII11());
						cell.setCellStyle(cellStyle);
					}

					/** Questions sup II **/
					if (this.questionsSupplementairesEnseignant2 != null
							&& !this.questionsSupplementairesEnseignant2.isEmpty()) {
						for (QuestionSupplementaireDTO question : this.questionsSupplementairesEnseignant2) {
							// On recupere la reponse a partir de la question
							ReponseSupplementaireDTO reponseSup = recupReponseSup(question);
							reponse = "";
							row = sheet.getRow(cpt);
							cell = row.createCell(j + 1);
							if (question.getTypeQuestion() != null && reponseSup != null){
								// On evalue le type de la question pour savoir ce qu'il faut récupérer dans l'objet reponse (int, txt ou bool).
								if (question.getTypeQuestion().equalsIgnoreCase("TXT")){
									reponse = reponseSup.getReponseTxt();
								} else if (question.getTypeQuestion().equalsIgnoreCase("INT")){
									if (reponseSup.getReponseInt() != null) reponse = recupLibelleNotation(reponseSup.getReponseInt());
								} else if (question.getTypeQuestion().equalsIgnoreCase("BOOL")){
									if (reponseSup.isReponseBool()) {
										reponse = "Oui";
									} else {
										reponse = "Non";
									}
								}
							}
							cell.setCellValue(reponse);
							cell.setCellStyle(cellStyle);
							cpt++;
						}
					}

					// Incrementation = passage a la colonne suivante
					j++;
				}

			}
			/****************************************
			 * GENERATION DU FICHIER EXCEL ENSEIGNANT
			 ****************************************/
			try {
				ByteArrayOutputStream baosXLS = new ByteArrayOutputStream();

				classeur.write(baosXLS);

				ExportConventionsServlet edit = new ExportConventionsServlet();

				List<Integer> idCentre = this.conventionController.getCritereRechercheConvention().getIdsCentreGestion();

				String XlsFileName = "extraction_pstage_enseignant_IdCentre_"
						+ idCentre.get(0)
						+ "_AnneeUniv_"
						+ this.conventionController.getCritereRechercheConvention().getAnneeUniversitaire() + ".xls";

				edit.doGet(baosXLS, XlsFileName);
			} catch (Exception e) {
				logger.error("exportConvention() - Exception lors de la tentative d'ecriture du baosXLS : "
						+ e.getMessage());
			}
		}
	}

	/**
	 * Export excel des fiches entreprise
	 */
	public void exportFichesEntrepriseColumn() {

		List<ConventionDTO> listeExportEval = new ArrayList<ConventionDTO>();
		if (this.conventionController.getRechercheConventionPaginator().getListe() != null) {
			listeExportEval = this.conventionController.getRechercheConventionPaginator().getListe();
		}

		if (listeExportEval != null && !listeExportEval.isEmpty()) {
			HSSFWorkbook classeur = new HSSFWorkbook();
			HSSFSheet sheet = classeur.createSheet("exportFichesEntreprise");

			HSSFRow row = sheet.createRow(0);
			sheet.setColumnWidth(0, 256 * 52);

			List<String> header = new ArrayList<String>();
			FicheEvaluationDTO ficheEvaluation = getFicheEvaluationDomainService()
					.getFicheEvaluationFromIdCentre(this.rechEvalIdCentre);

			header.add(getString("RECHERCHEEVALUATION.NUMCONVENTION"));

			// ajout des noms prenoms
			header.add(getString("CONVENTION.NOM"));
			header.add(getString("CONVENTION.PRENOM"));

			/*******************************
			 * HEADER ENTREPRISE PART I
			 ******************************/
			// On ajoute les questions en fonction de leur utilisation par le centre ou non
			if (ficheEvaluation.isQuestionEnt1())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.1"));
			if (ficheEvaluation.isQuestionEnt2())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.2"));
			if (ficheEvaluation.isQuestionEnt3())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.3"));
			if (ficheEvaluation.isQuestionEnt5())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.5"));
			if (ficheEvaluation.isQuestionEnt9())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.9"));
			if (ficheEvaluation.isQuestionEnt11())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.11"));
			if (ficheEvaluation.isQuestionEnt12())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.12"));
			if (ficheEvaluation.isQuestionEnt13())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.13"));
			if (ficheEvaluation.isQuestionEnt14())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.14"));
			// Ajout des questions supplémentaires entreprise partie 1
			this.setQuestionsSupplementairesEntreprise1(getFicheEvaluationDomainService()
					.getQuestionsSupplementairesFromIdPlacement(
							ficheEvaluation.getIdFicheEvaluation(), 6));
			if (this.questionsSupplementairesEntreprise1 != null) {
				for (int i = 0; i < this.questionsSupplementairesEntreprise1.size(); i++) {
					header.add(this.questionsSupplementairesEntreprise1.get(i).getQuestion());
				}
			}

			/*******************************
			 * HEADER ENTREPRISE PART II
			 ******************************/
			if (ficheEvaluation.isQuestionEnt4())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.4"));
			if (ficheEvaluation.isQuestionEnt6())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.6"));
			if (ficheEvaluation.isQuestionEnt7())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.7"));
			if (ficheEvaluation.isQuestionEnt8())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.8"));
			if (ficheEvaluation.isQuestionEnt15())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.15"));
			// Ajout des questions supplémentaires entreprise partie 2
			this.setQuestionsSupplementairesEntreprise2(getFicheEvaluationDomainService()
					.getQuestionsSupplementairesFromIdPlacement(
							ficheEvaluation.getIdFicheEvaluation(), 7));
			if (this.questionsSupplementairesEntreprise2 != null) {
				for (int i = 0; i < this.questionsSupplementairesEntreprise2.size(); i++) {
					header.add(this.questionsSupplementairesEntreprise2.get(i).getQuestion());
				}
			}

			/*******************************
			 * HEADER ENTREPRISE PART III
			 ******************************/
			if (ficheEvaluation.isQuestionEnt16())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.16"));
			if (ficheEvaluation.isQuestionEnt17())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.17"));
			if (ficheEvaluation.isQuestionEnt19())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.19"));
			if (ficheEvaluation.isQuestionEnt10())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.10"));
			if (ficheEvaluation.isQuestionEnt18())
				header.add(getString("CENTRE.FICHE_EVALUATION.FICHE_ENTREPRISE.QUESTIONS.18"));
			// Ajout des questions supplémentaires entreprise partie 3
			this.setQuestionsSupplementairesEntreprise3(getFicheEvaluationDomainService()
					.getQuestionsSupplementairesFromIdPlacement(
							ficheEvaluation.getIdFicheEvaluation(), 8));
			if (this.questionsSupplementairesEntreprise3 != null) {
				for (int i = 0; i < this.questionsSupplementairesEntreprise3.size(); i++) {
					header.add(this.questionsSupplementairesEntreprise3.get(i).getQuestion());
				}
			}

			/** Ecriture du header dans la feuille excel **/
			HSSFRow row_i;
			for (int i = 0; i < header.size(); i++) {
				row_i = sheet.createRow(i);
				row_i.createCell(0).setCellValue(header.get(i));
			}

			// geler de la premiere colonne/en-tête
			sheet.createFreezePane(1, 0);

			// initialisation des variables
			ReponseEvaluationDTO reponseTmp;
			ConventionDTO convention = new ConventionDTO();
			int j = 0;
			HSSFCell cell;
			// Style general
			HSSFCellStyle cellStyle = classeur.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// Style entete column (gras)
			HSSFCellStyle cellStyle2 = classeur.createCellStyle();
			HSSFFont fonte = classeur.createFont();
			fonte.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cellStyle2.setFont(fonte);
			cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			/***************************************************************
			 * REMPLISSAGE AVEC LES REPONSES POUR CHAQUE CONVENTION TROUVEE
			 * 
			 * /!\ Un bouleversement de la structure du questionnaire ayant ete
			 * decide apres sa modelisation en base, les reponses 
			 * ne sont pas présentées dans l'ordre !!!
			 * 
			 ***************************************************************/
			for (int i = 0; i < listeExportEval.size(); i++) {

				// Initilisation de la convention dans conventionController pour
				// recuperer ses reponses supplementaires via recupReponseSup
				this.conventionController.setConvention(listeExportEval.get(i));

				// Reglage taille colonne
				sheet.setColumnWidth(i + 1, 256 * 15);

				// Recuperation de la reponse
				reponseTmp = listeExportEval.get(i).getReponseEvaluation();

				if (reponseTmp != null && reponseTmp.isValidationEntreprise()) {
					int cpt = 0;
					String reponse = "";
					row = sheet.getRow(cpt);
					cell = row.createCell(j + 1); // j = colonne (0 = header, 1 = 1ere colonne de donnees)

					// num convention
					cell.setCellValue(listeExportEval.get(i).getIdConvention());
					cell.setCellStyle(cellStyle2);
					cpt++;

					// Remplissage complet de la convention
					convention = listeExportEval.get(i);
					convention = getConventionDomainService().getConventionFromId(convention.getIdConvention());

					// Renseignement etudiant
					convention.setEtudiant(getEtudiantDomainService().getEtudiantFromId(convention.getIdEtudiant()));
					// nom etu
					row = sheet.getRow(cpt);
					cell = row.createCell(j + 1);
					cell.setCellValue(convention.getEtudiant().getNom());
					cell.setCellStyle(cellStyle);
					cpt++;
					// prenom etu
					row = sheet.getRow(cpt);
					cell = row.createCell(j + 1);
					cell.setCellValue(convention.getEtudiant().getPrenom());
					cell.setCellStyle(cellStyle);
					cpt++;

					/*******************************
					 * REPONSES PART I
					 ******************************/
					/** Question I-1 **/
					if (ficheEvaluation.isQuestionEnt1()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt1())
								+ " : "
								+ reponseTmp.getReponseEnt1bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question I-2 **/
					if (ficheEvaluation.isQuestionEnt2()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt2())
								+ " : "
								+ reponseTmp.getReponseEnt2bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question I-3 **/
					if (ficheEvaluation.isQuestionEnt3()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt3()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question I-4 **/
					if (ficheEvaluation.isQuestionEnt5()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt5())
								+ " : "
								+ reponseTmp.getReponseEnt5bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question I-5 **/
					if (ficheEvaluation.isQuestionEnt9()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt9())
								+ " : "
								+ reponseTmp.getReponseEnt9bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question I-6 **/
					if (ficheEvaluation.isQuestionEnt11()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt11())
								+ " : "
								+ reponseTmp.getReponseEnt11bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question I-7 **/
					if (ficheEvaluation.isQuestionEnt12()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt12())
								+ " : "
								+ reponseTmp.getReponseEnt12bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question I-8 **/
					if (ficheEvaluation.isQuestionEnt13()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt13())
								+ " : "
								+ reponseTmp.getReponseEnt13bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question I-9 **/
					if (ficheEvaluation.isQuestionEnt14()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt14())
								+ " : "
								+ reponseTmp.getReponseEnt14bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Questions sup I **/
					if (this.questionsSupplementairesEntreprise1 != null
							&& !this.questionsSupplementairesEntreprise1.isEmpty()) {
						for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise1) {
							// On recupere la reponse a partir de la question
							ReponseSupplementaireDTO reponseSup = recupReponseSup(question);
							reponse = "";
							row = sheet.getRow(cpt);
							cell = row.createCell(j + 1);
							if (question.getTypeQuestion() != null ){
								// On evalue le type de la question pour savoir ce qu'il faut récupérer dans l'objet reponse (int, txt ou bool).
								if (question.getTypeQuestion().equalsIgnoreCase("TXT")){
									reponse = reponseSup.getReponseTxt();
								} else if (question.getTypeQuestion().equalsIgnoreCase("INT")){
									if (reponseSup.getReponseInt() != null) reponse = recupLibelleNotation(reponseSup.getReponseInt());
								} else if (question.getTypeQuestion().equalsIgnoreCase("BOOL")){
									if (reponseSup.isReponseBool()) {
										reponse = "Oui";
									} else {
										reponse = "Non";
									}
								}
							}
							cell.setCellValue(reponse);
							cell.setCellStyle(cellStyle);
							cpt++;
						}
					}

					/*******************************
					 * REPONSES PART II
					 ******************************/
					/** Question II-1 **/
					if (ficheEvaluation.isQuestionEnt4()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt4())
								+ " : "
								+ reponseTmp.getReponseEnt4bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question II-2 **/
					if (ficheEvaluation.isQuestionEnt6()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt6())
								+ " : "
								+ reponseTmp.getReponseEnt6bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question II-3 **/
					if (ficheEvaluation.isQuestionEnt7()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt7())
								+ " : "
								+ reponseTmp.getReponseEnt7bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question II-4 **/
					if (ficheEvaluation.isQuestionEnt8()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt8())
								+ " : "
								+ reponseTmp.getReponseEnt8bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question II-5 **/
					if (ficheEvaluation.isQuestionEnt15()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleNotation(reponseTmp
								.getReponseEnt15())
								+ " : "
								+ reponseTmp.getReponseEnt15bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Questions sup II **/
					if (this.questionsSupplementairesEntreprise2 != null
							&& !this.questionsSupplementairesEntreprise2.isEmpty()) {
						for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise2) {
							// On recupere la reponse a partir de la question
							ReponseSupplementaireDTO reponseSup = recupReponseSup(question);
							reponse = "";
							row = sheet.getRow(cpt);
							cell = row.createCell(j + 1);
							if (question.getTypeQuestion() != null ){
								// On evalue le type de la question pour savoir ce qu'il faut récupérer dans l'objet reponse (int, txt ou bool).
								if (question.getTypeQuestion().equalsIgnoreCase("TXT")){
									reponse = reponseSup.getReponseTxt();
								} else if (question.getTypeQuestion().equalsIgnoreCase("INT")){
									if (reponseSup.getReponseInt() != null) reponse = recupLibelleNotation(reponseSup.getReponseInt());
								} else if (question.getTypeQuestion().equalsIgnoreCase("BOOL")){
									if (reponseSup.isReponseBool()) {
										reponse = "Oui";
									} else {
										reponse = "Non";
									}
								}
							}
							cell.setCellValue(reponse);
							cell.setCellStyle(cellStyle);
							cpt++;
						}
					}

					/*******************************
					 * REPONSES PART III
					 ******************************/
					/** Question III-1 **/
					if (ficheEvaluation.isQuestionEnt16()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(this.recupLibelleAvis(reponseTmp
								.getReponseEnt16())
								+ " : "
								+ reponseTmp.getReponseEnt16bis());
						cell.setCellStyle(cellStyle);
						cpt++;
					}

					/** Question III-2 **/
					if (ficheEvaluation.isQuestionEnt17()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (reponseTmp.getReponseEnt17() == 4
								|| reponseTmp.getReponseEnt17() == 5)
							cell.setCellValue(this
									.recupLibelleNotation(reponseTmp
											.getReponseEnt17())
											+ " : " + reponseTmp.getReponseEnt17bis());
						else
							cell.setCellValue(this
									.recupLibelleNotation(reponseTmp
											.getReponseEnt17()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question III-3 **/
					if (ficheEvaluation.isQuestionEnt19()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(reponseTmp.getReponseEnt19());
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question III-4 **/
					if (ficheEvaluation.isQuestionEnt10()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						cell.setCellValue(transformBooleanRep(reponseTmp.isReponseEnt10()));
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Question III-5 **/
					if (ficheEvaluation.isQuestionEnt18()) {
						row = sheet.getRow(cpt);
						cell = row.createCell(j + 1);
						if (!reponseTmp.isReponseEnt18())
							cell.setCellValue(" Non : "
									+ reponseTmp.getReponseEnt18bis());
						else
							cell.setCellValue("Oui");
						cell.setCellStyle(cellStyle);
						cpt++;
					}
					/** Questions sup III **/
					if (this.questionsSupplementairesEntreprise3 != null
							&& !this.questionsSupplementairesEntreprise3.isEmpty()) {
						for (QuestionSupplementaireDTO question : this.questionsSupplementairesEntreprise3) {
							// On recupere la reponse a partir de la question
							ReponseSupplementaireDTO reponseSup = recupReponseSup(question);
							reponse = "";
							row = sheet.getRow(cpt);
							cell = row.createCell(j + 1);
							if (question.getTypeQuestion() != null ){
								// On evalue le type de la question pour savoir ce qu'il faut récupérer dans l'objet reponse (int, txt ou bool).
								if (question.getTypeQuestion().equalsIgnoreCase("TXT")){
									reponse = reponseSup.getReponseTxt();
								} else if (question.getTypeQuestion().equalsIgnoreCase("INT")){
									if (reponseSup.getReponseInt() != null) reponse = recupLibelleNotation(reponseSup.getReponseInt());
								} else if (question.getTypeQuestion().equalsIgnoreCase("BOOL")){
									if (reponseSup.isReponseBool()) {
										reponse = "Oui";
									} else {
										reponse = "Non";
									}
								}
							}
							cell.setCellValue(reponse);
							cell.setCellStyle(cellStyle);
							cpt++;
						}
					}
					
					j++;
				}
			}
			/****************************************
			 * GENERATION DU FICHIER EXCEL ENTREPRISE
			 ****************************************/
			try {
				ByteArrayOutputStream baosXLS = new ByteArrayOutputStream();

				classeur.write(baosXLS);

				ExportConventionsServlet edit = new ExportConventionsServlet();

				List<Integer> idCentre = this.conventionController.getCritereRechercheConvention()
						.getIdsCentreGestion();

				String XlsFileName = "extraction_pstage_entreprise_IdCentre_"
						+ idCentre.get(0)
						+ "_AnneeUniv_"
						+ this.conventionController.getCritereRechercheConvention()
						.getAnneeUniversitaire() + ".xls";

				edit.doGet(baosXLS, XlsFileName);
			} catch (Exception e) {
				logger.error("exportConvention() - Exception lors de la tentative d'ecriture du baosXLS : "
						+ e.getMessage());
			}
		}
	}


	/* ************************
	 * METHODES GLOBALES
	 * ***********************/

	/**
	 * Recupere la reponse d'une question sup a partir de son objet
	 * @param question
	 * @return ReponseSupplementaireDTO
	 */
	private ReponseSupplementaireDTO recupReponseSup(
			QuestionSupplementaireDTO question) {
		ReponseSupplementaireDTO reponse = getFicheEvaluationDomainService()
				.getReponseSupplementaire(
						question.getIdQuestionSupplementaire(),
						this.conventionController.getConvention().getIdConvention());
		// Si on ne trouve rien existant en base, on l'initialise avec les ids
		// disponibles
		if (reponse.getIdQuestionSupplementaire() == null) {
			reponse.setIdQuestionSupplementaire(question
					.getIdQuestionSupplementaire());
			reponse.setIdConvention(this.conventionController.getConvention().getIdConvention());
			this.reponsesSupplementaires.add(reponse);
		}
		return reponse;
	}

	/**
	 * Remplace l'affichage "VRAI/FAUX" en "OUI/NON"
	 * @param bool
	 * @return String
	 */
	private String transformBooleanRep(boolean bool) {
		if (bool){
			return "Oui";
		} else {
			return "Non";
		}
	}

	/**
	 * Recupere le libelle notation (Excellent/Tres bien/...) a partir de son id
	 * @param idNotation
	 * @return
	 */
	private String recupLibelleNotation(int idNotation) {
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
	 * Recupere le libelle avis (Tout a fait d'accord/Pas du tout d'accord/...) a partir de son id
	 * @param idAvis
	 * @return
	 */
	private String recupLibelleAvis(int idAvis) {
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

	/**
	 * Recharge la liste des codes de la recherche d'evaluation en fonction de l'annee et du centre choisis
	 */
	public void updateAffichageListeCodes() {

		this.rechEvalListeCodes = new ArrayList<SelectItem>();

		if (rechEvalIdCentre != null && rechEvalIdCentre > 0) {

			CentreGestionDTO centre = getCentreGestionDomainService().getCentreGestion(this.rechEvalIdCentre);

			// On recupere le critere de recherche de convention
			CritereRechercheConventionDTO critereRechercheEvaluation = this.conventionController.getCritereRechercheConvention();

			if (centre != null){

				if (centre.getNiveauCentre().getLibelle()
						.equalsIgnoreCase(DonneesStatic.CG_ETAB)) {
					// Si le centre chosi est de type etablissement, on affiche le message d'info (affichage 1)
					this.etatAffichageRechEval = 1;


					if (critereRechercheEvaluation != null) {
						// Remise à zero de la liste d'idsEtapes et d'idsUfr
						// du critere de recherche de convention pour y mettre l'id du centre etab
						// afin de recup les conventions orphelines
						List<Integer> list = new ArrayList<Integer>();
						list.add(this.rechEvalIdCentre);
						critereRechercheEvaluation.setIdsEtapes(new ArrayList<String>());
						critereRechercheEvaluation.setIdsUfrs(new ArrayList<String>());
						critereRechercheEvaluation.setIdsCentreGestion(list);
					}
				}

				if (centre.getNiveauCentre().getLibelle()
						.equalsIgnoreCase(DonneesStatic.CG_ETAPE)) {
					// Si le centre chosi est de type etape, on affiche la liste de codeEtapes (affichage 2)
					this.etatAffichageRechEval = 2;

					if (critereRechercheEvaluation != null) {
						critereRechercheEvaluation.setIdsUfrs(new ArrayList<String>());
					}
				}

				if (centre.getNiveauCentre().getLibelle()
						.equalsIgnoreCase(DonneesStatic.CG_UFR)) {
					// Si le centre chosi est de type ufr, on affiche la liste de codeUfrs (affichage 3)
					this.etatAffichageRechEval = 3;

					if (critereRechercheEvaluation != null) {
						critereRechercheEvaluation.setIdsEtapes(new ArrayList<String>());
					}
				}
			}

			if (this.etatAffichageRechEval == 2 || this.etatAffichageRechEval == 3){
				List<CritereGestionDTO> listeCodes = getCritereGestionDomainService()
						.getCritereGestionFromIdCentreAndAnnee(
								this.rechEvalIdCentre,
								critereRechercheEvaluation.getAnneeUniversitaire());

				if (listeCodes != null && !listeCodes.isEmpty()) {
					for (CritereGestionDTO critere : listeCodes) {
						if (critere.getCodeVersionEtape() != null
								&& !critere.getCodeVersionEtape().isEmpty()) {
							this.rechEvalListeCodes.add(new SelectItem(critere
									.getCode(), critere.getCode() + ";"
											+ critere.getCodeVersionEtape() + " - "
											+ critere.getLibelle()));
						} else {
							this.rechEvalListeCodes.add(new SelectItem(critere
									.getCode(), critere.getCode() + " - "
											+ critere.getLibelle()));
						}
					}
				} else {
					// Si au final il s'avere que la liste des codes est vide, on affiche un message l'indiquant (affichage 4)
					this.etatAffichageRechEval = 4;
					// Puis on vide les criteres de recherche
					critereRechercheEvaluation.setIdsEtapes(new ArrayList<String>());
					critereRechercheEvaluation.setIdsUfrs(new ArrayList<String>());
				}
			}
			// On reporte les modifs specifiques à l'eval dans le critere de recherche de convention
			this.conventionController.setCritereRechercheConvention(critereRechercheEvaluation);
		}
	}


	/* ***************************************************************
	 * GETTERS/SETTERS
	 * **************************************************************/

	/**
	 * @return the tuteurCurrentConvention
	 */
	public boolean isTuteurCurrentConvention() {
		boolean b = false;
		if (getSessionController().getCurrentAuthEnseignant() != null
				&& this.conventionController.getConvention().getEnseignant() != null
				&& getSessionController()
				.getCurrentAuthEnseignant()
				.getUidEnseignant()
				.equalsIgnoreCase(
						this.conventionController.getConvention().getEnseignant()
						.getUidEnseignant())) {
			b = true;
		}
		return b;
	}

	public ConventionController getConventionController() {
		return conventionController;
	}

	public void setConventionController(ConventionController conventionController) {
		this.conventionController = conventionController;
	}

	public CastorService getCastorService() {
		return castorService;
	}

	public void setCastorService(CastorService castorService) {
		this.castorService = castorService;
	}

	public String getTogglePanelActiveItem() {
		return togglePanelActiveItem;
	}

	public void setTogglePanelActiveItem(String togglePanelActiveItem) {
		this.togglePanelActiveItem = togglePanelActiveItem;
	}

	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEtudiant1() {
		return questionsSupplementairesEtudiant1;
	}

	public void setQuestionsSupplementairesEtudiant1(
			List<QuestionSupplementaireDTO> questionsSupplementairesEtudiant1) {
		this.questionsSupplementairesEtudiant1 = questionsSupplementairesEtudiant1;
	}

	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEtudiant2() {
		return questionsSupplementairesEtudiant2;
	}

	public void setQuestionsSupplementairesEtudiant2(
			List<QuestionSupplementaireDTO> questionsSupplementairesEtudiant2) {
		this.questionsSupplementairesEtudiant2 = questionsSupplementairesEtudiant2;
	}

	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEtudiant3() {
		return questionsSupplementairesEtudiant3;
	}

	public void setQuestionsSupplementairesEtudiant3(
			List<QuestionSupplementaireDTO> questionsSupplementairesEtudiant3) {
		this.questionsSupplementairesEtudiant3 = questionsSupplementairesEtudiant3;
	}

	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEnseignant1() {
		return questionsSupplementairesEnseignant1;
	}

	public void setQuestionsSupplementairesEnseignant1(
			List<QuestionSupplementaireDTO> questionsSupplementairesEnseignant1) {
		this.questionsSupplementairesEnseignant1 = questionsSupplementairesEnseignant1;
	}

	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEnseignant2() {
		return questionsSupplementairesEnseignant2;
	}

	public void setQuestionsSupplementairesEnseignant2(
			List<QuestionSupplementaireDTO> questionsSupplementairesEnseignant2) {
		this.questionsSupplementairesEnseignant2 = questionsSupplementairesEnseignant2;
	}

	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEntreprise1() {
		return questionsSupplementairesEntreprise1;
	}

	public void setQuestionsSupplementairesEntreprise1(
			List<QuestionSupplementaireDTO> questionsSupplementairesEntreprise1) {
		this.questionsSupplementairesEntreprise1 = questionsSupplementairesEntreprise1;
	}

	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEntreprise2() {
		return questionsSupplementairesEntreprise2;
	}

	public void setQuestionsSupplementairesEntreprise2(
			List<QuestionSupplementaireDTO> questionsSupplementairesEntreprise2) {
		this.questionsSupplementairesEntreprise2 = questionsSupplementairesEntreprise2;
	}

	public List<QuestionSupplementaireDTO> getQuestionsSupplementairesEntreprise3() {
		return questionsSupplementairesEntreprise3;
	}

	public void setQuestionsSupplementairesEntreprise3(
			List<QuestionSupplementaireDTO> questionsSupplementairesEntreprise3) {
		this.questionsSupplementairesEntreprise3 = questionsSupplementairesEntreprise3;
	}

	public List<ReponseSupplementaireDTO> getReponsesSupplementaires() {
		return reponsesSupplementaires;
	}

	public void setReponsesSupplementaires(
			List<ReponseSupplementaireDTO> reponsesSupplementaires) {
		this.reponsesSupplementaires = reponsesSupplementaires;
	}

	public String getCodeAccesFiche() {
		return codeAccesFiche;
	}

	public void setCodeAccesFiche(String codeAccesFiche) {
		this.codeAccesFiche = codeAccesFiche;
	}

	public List<SelectItem> getListeItemsCurrentCentresGestionEval() {
		return listeItemsCurrentCentresGestionEval;
	}

	public void setListeItemsCurrentCentresGestionEval(
			List<SelectItem> listeItemsCurrentCentresGestionEval) {
		this.listeItemsCurrentCentresGestionEval = listeItemsCurrentCentresGestionEval;
	}

	public Integer getRechEvalIdCentre() {
		return rechEvalIdCentre;
	}

	public void setRechEvalIdCentre(Integer rechEvalIdCentre) {
		this.rechEvalIdCentre = rechEvalIdCentre;
	}

	public int getEtatAffichageRechEval() {
		return etatAffichageRechEval;
	}

	public void setEtatAffichageRechEval(int etatAffichageRechEval) {
		this.etatAffichageRechEval = etatAffichageRechEval;
	}

	public List<SelectItem> getRechEvalListeCodes() {
		return rechEvalListeCodes;
	}

	public void setRechEvalListeCodes(List<SelectItem> rechEvalListeCodes) {
		this.rechEvalListeCodes = rechEvalListeCodes;
	}

	public int getTypeDestMailEval() {
		return typeDestMailEval;
	}

	public void setTypeDestMailEval(int typeDestMailEval) {
		this.typeDestMailEval = typeDestMailEval;
	}

	public int getTypeMailEval() {
		return typeMailEval;
	}

	public void setTypeMailEval(int typeMailEval) {
		this.typeMailEval = typeMailEval;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setContenuMailEval(String contenuMailEval) {
		this.contenuMailEval = contenuMailEval;
	}

	public boolean isRetourEvaluation() {
		return retourEvaluation;
	}

	public void setRetourEvaluation(boolean retourEvaluation) {
		this.retourEvaluation = retourEvaluation;
	}

}
