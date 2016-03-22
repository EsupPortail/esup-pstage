package org.esupportail.pstage.web.controllers;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstage.web.beans.ConventionColonneEnum;
import org.esupportail.pstage.web.beans.ConventionEntrepriseColonneEnum;
import org.esupportail.pstage.web.servlet.ExportConventionsServlet;
import org.esupportail.pstagedata.domain.dto.AvenantDTO;
import org.esupportail.pstagedata.domain.dto.ConventionDTO;
import org.esupportail.pstagedata.domain.dto.CritereRechercheConventionDTO;
import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.springframework.util.StringUtils;

/**
 * @author dhouillo
 * 
 */
public class ExportController extends AbstractContextAwareController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7120547238012215550L;
	/**
	 * Logger.
	 */
	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Resultats de la recherche convention.
	 */
	private List<ConventionDTO> resultatsRechercheConvention;

	// Recherche
	/**
	 * critereRechercheConvention.
	 */
	private CritereRechercheConventionDTO critereRechercheConvention = new CritereRechercheConventionDTO();

	/**
	 * Liste des types structure et statuts pour la recherche.
	 */
	private List<SelectItem> rechTypesStatutsStructure;
	/**
	 * Type ou statut structure sélectionné pour la recherche.
	 */
	private String rechTypeOuStatut;

	/**
	 * 1 = Oui. 2 = Non null = Les 2
	 */
	private String estValidee = null;
	/**
	 * 1 = Oui. 2 = Non null = Les 2
	 */
	private String estVerifiee = null;
	/**
	 * toutes les conventions etrangeres ou pays en particulier
	 */
	private boolean estEtrangere = false;

	/**
	 * Liste des colonnes convention choisies.
	 */
	private List<String> conventionColonnesChoisies;

	/**
	 * Liste des colonnes convention choisies.
	 */
	private List<SelectItem> conventionColonnesChoisiesItem;

	/**
	 * Liste des colonnes convention/entreprise choisies.
	 */
	private List<String> conventionEntrepriseColonnesChoisies;

	/**
	 * Liste des colonnes convention/entreprise choisies.
	 */
	private List<SelectItem> conventionEntrepriseColonnesChoisiesItem;

	/**
	 * Bean constructor.
	 */
	public ExportController() {
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
		this.conventionColonnesChoisies = new ArrayList<String>();
		this.conventionEntrepriseColonnesChoisies = new ArrayList<String>();

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
	 * 
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
	 * Recherche des Conventions.
	 * 
	 * @return String
	 */
	public String rechercherConvention() {
		String ret = null;

		if (this.critereRechercheConvention.getNomEnseignant() == "")
			this.critereRechercheConvention.setNomEnseignant(null);
		if (this.critereRechercheConvention.getPrenomEnseignant() == "")
			this.critereRechercheConvention.setPrenomEnseignant(null);

		this.critereRechercheConvention
		.setIdsCentreGestion(getSessionController()
				.getCurrentIdsCentresGestion());
		if (logger.isDebugEnabled()) {
			logger.debug("ExportController:: limit : "
					+ this.critereRechercheConvention.isLimit());
		}
		if (!StringUtils.hasText(this.critereRechercheConvention
				.getNomEtudiant())) {
			if (StringUtils.hasText(this.critereRechercheConvention
					.getPrenomEtudiant())) {
				addErrorMessage("formRechConvention",
						"RECHERCHECONVENTION.NOM.OBLIGATOIRE");
				return ret;
			}
		}
		// au moins le critère annee doit etre saisi
		if (!StringUtils.hasText(this.critereRechercheConvention
				.getIdConvention())
				&& !StringUtils.hasText(this.critereRechercheConvention
						.getNumeroEtudiant())
						&& !StringUtils.hasText(this.critereRechercheConvention
								.getNomEtudiant())
								&& !StringUtils.hasText(this.critereRechercheConvention
										.getPrenomEtudiant())) {
			if (!StringUtils.hasText(this.critereRechercheConvention
					.getAnneeUniversitaire())) {
				addErrorMessage("formRechConvention",
						"RECHERCHECONVENTION.ANNEEU.OBLIGATOIRE");
				return ret;
			}
		}
		if (StringUtils.hasText(this.rechTypeOuStatut)) {
			if (this.rechTypeOuStatut.contains("t")) {
				if (Utils.isNumber(this.rechTypeOuStatut.substring(1))) {
					this.critereRechercheConvention
					.setTypeStructure(getNomenclatureDomainService()
							.getTypeStructureFromId(
									Utils.convertStringToInt(this.rechTypeOuStatut
											.substring(1))));
					this.critereRechercheConvention.setStatutJuridique(null);
				}
			}
			if (this.rechTypeOuStatut.contains("s")) {
				if (Utils.isNumber(this.rechTypeOuStatut.substring(1))) {
					this.critereRechercheConvention
					.setStatutJuridique(getNomenclatureDomainService()
							.getStatutJuridiqueFromId(
									Utils.convertStringToInt(this.rechTypeOuStatut
											.substring(1))));
					if (this.critereRechercheConvention.getStatutJuridique() != null
							&& this.critereRechercheConvention
							.getStatutJuridique().getIdParent() > 0) {
						this.critereRechercheConvention
						.setTypeStructure(getNomenclatureDomainService()
								.getTypeStructureFromId(
										this.critereRechercheConvention
										.getStatutJuridique()
										.getIdParent()));
					}
				}
			}
		} else {
			this.critereRechercheConvention.setTypeStructure(null);
			this.critereRechercheConvention.setStatutJuridique(null);
		}
		if (!StringUtils.hasText(this.estValidee))
			this.critereRechercheConvention.setEstValidee(null);
		else if (this.estValidee.equals("1"))
			this.critereRechercheConvention.setEstValidee(true);
		else if (this.estValidee.equals("2"))
			this.critereRechercheConvention.setEstValidee(false);

		if (!StringUtils.hasText(this.estVerifiee))
			this.critereRechercheConvention.setEstVerifiee(null);
		else if (this.estVerifiee.equals("1"))
			this.critereRechercheConvention.setEstVerifiee(true);
		else if (this.estVerifiee.equals("2"))
			this.critereRechercheConvention.setEstVerifiee(false);

		if (this.estEtrangere)
			this.critereRechercheConvention.setEstEtrangere(true);
		else
			this.critereRechercheConvention.setEstEtrangere(false);

		if (logger.isInfoEnabled()) {
			logger.info("ExportController:: Appel getConventionsFromCriteresExport debut ");
		}
		// si enseignant référent, recherche des conventions pour les
		// enseignants tuteur
		if (getSessionController().isEnseignantTuteur()) {
			if (this.getSessionController().getCurrentAuthEnseignant()
					.getUidEnseignant() != null) {
				EnseignantDTO tmpEns = getEnseignantDomainService()
						.getEnseignantFromUid(
								this.getSessionController()
								.getCurrentAuthEnseignant()
								.getUidEnseignant(),
								getSessionController().getCodeUniversite());
				if (tmpEns != null) {
					this.resultatsRechercheConvention = getConventionDomainService()
							.getConventionsFromCriteresByEnseignantTuteur(
									tmpEns.getId(),
									this.critereRechercheConvention);
				}
			}
			if (this.resultatsRechercheConvention == null)
				this.resultatsRechercheConvention = new ArrayList<ConventionDTO>();
			// recherche aussi avec critere CG
			if (this.critereRechercheConvention.getIdsCentreGestion() != null) {
				List<ConventionDTO> resultatsRechercheConventionCG = getConventionDomainService()
						.getConventionsFromCriteresExport(
								this.critereRechercheConvention);
				if (resultatsRechercheConventionCG != null
						&& !resultatsRechercheConventionCG.isEmpty()) {
					for (Iterator<ConventionDTO> itercg = resultatsRechercheConventionCG
							.iterator(); itercg.hasNext();) {
						ConventionDTO conventionDTO = itercg.next();
						if (!this.resultatsRechercheConvention
								.contains(conventionDTO)) {
							this.resultatsRechercheConvention
							.add(conventionDTO);
						}
					}
					Collections.sort(this.resultatsRechercheConvention,
							new Comparator<ConventionDTO>() {
						/**
						 * @see java.util.Comparator#compare(java.lang.Object,
						 *      java.lang.Object)
						 */
						@Override
						public int compare(ConventionDTO l1,
								ConventionDTO l2) {
							return l1.getIdConvention().compareTo(
									l2.getIdConvention());
						}
					});
				}
			}
		} else {
			this.resultatsRechercheConvention = getConventionDomainService()
					.getConventionsFromCriteresExport(
							this.critereRechercheConvention);
		}

		if (logger.isInfoEnabled()) {
			logger.info("ExportController:: Appel getConventionsFromCriteresExport fin ");
		}
		if (this.resultatsRechercheConvention == null
				|| this.resultatsRechercheConvention.isEmpty()) {
			this.resultatsRechercheConvention = null;
			addInfoMessage("formRechConvention",
					"RECHERCHECONVENTION.AUCUNRESULTAT");
		} else if (this.resultatsRechercheConvention != null
				&& !this.resultatsRechercheConvention.isEmpty()) {
			if (logger.isDebugEnabled()) {
				logger.debug("ExportController:: nombre convention : "
						+ this.resultatsRechercheConvention.size());
			}
			if (logger.isInfoEnabled()) {
				logger.info("ExportController:: Appel getConventionFromExport debut ");
			}
			if (this.resultatsRechercheConvention != null
					&& !this.resultatsRechercheConvention.isEmpty()) {
				List<ConventionDTO> lConventionExport = new ArrayList<ConventionDTO>();
				List<Integer> idsConventionsExport = new ArrayList<Integer>();
				for (ConventionDTO c : resultatsRechercheConvention) {
					idsConventionsExport.add(c.getIdConvention());
				}
				lConventionExport = getConventionDomainService()
						.getConventionsFromExport(idsConventionsExport);
				this.resultatsRechercheConvention = lConventionExport;
				ret = "exportConvention";
			}

			if (logger.isInfoEnabled()) {
				logger.info("ExportController:: Appel getConventionFromExport fin ");
			}
		}
		this.conventionColonnesChoisies = new ArrayList<String>();
		this.conventionEntrepriseColonnesChoisies = new ArrayList<String>();
		return ret;
	}

	/**
	 * choix export des conventions tuteur
	 * 
	 * @return String
	 */
	public String goToChoixExportConventionTuteur() {
		String ret = null;
		if (this.resultatsRechercheConvention != null
				&& !this.resultatsRechercheConvention.isEmpty()) {
			List<ConventionDTO> lConventionExport = new ArrayList<ConventionDTO>();
			List<Integer> idsConventionsExport = new ArrayList<Integer>();
			for (ConventionDTO c : resultatsRechercheConvention) {
				idsConventionsExport.add(c.getIdConvention());
			}
			lConventionExport = getConventionDomainService()
					.getConventionsFromExport(idsConventionsExport);
			this.resultatsRechercheConvention = lConventionExport;
			ret = "exportConvention";
		}
		this.conventionColonnesChoisies = new ArrayList<String>();
		this.conventionEntrepriseColonnesChoisies = new ArrayList<String>();
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToExportConvention() {
		String ret = null;
		if (this.resultatsRechercheConvention != null
				&& !this.resultatsRechercheConvention.isEmpty()) {
			exportConvention();
		}
		return ret;
	}

	/**
	 * 
	 */
	public void exportConvention() {

		List<ConventionDTO> conventions = this.resultatsRechercheConvention;

		if (conventions != null && !conventions.isEmpty()) {

			HSSFWorkbook classeur = new HSSFWorkbook();
			HSSFSheet sheet = classeur.createSheet("exportConvention");

			HSSFRow row = sheet.createRow(0);

			int cpt = 0;
			for (String colonne : this.conventionColonnesChoisies) {
				row.createCell(cpt).setCellValue(getString(colonne));
				// Si on choisi d'avoir les avenants, on ajoute une case pour
				// leurs contenus
				if (colonne.equalsIgnoreCase("EXPORTCONVENTION.AVENANT")) {
					cpt++;
					row.createCell(cpt).setCellValue("Détails Avenant(s)");
				}
				cpt++;
			}
			for (String colonne : this.conventionEntrepriseColonnesChoisies) {
				row.createCell(cpt).setCellValue(getString(colonne));
				cpt++;
			}

			String ligneAvenant = "";
			String cellAvenant = "";
			boolean isAvenantExistant = false;

			ConventionDTO conventionTmp;
			for (int i = 0; i < conventions.size(); i++) {
				conventionTmp = conventions.get(i);
				// Prise en compte des gratification 'Non' et 'Ne sait pas'
				if (conventionTmp.getIdIndemnisation() != null) {
					if (conventionTmp.getIdIndemnisation() == 3) {
						conventionTmp.setMontantGratification("Ne sait pas");
					} else if (conventionTmp.getIdIndemnisation() == 2) {
						conventionTmp
						.setMontantGratification("Pas d'indemnisation");
					}
				}

				row = sheet.createRow(i + 1);

				cpt = 0;
				for (String colonne : this.conventionColonnesChoisies) {

					if (colonne.equalsIgnoreCase("EXPORTCONVENTION.AVENANT")) {
						if (conventionTmp.getNbAvenant() > 0) {

							List<AvenantDTO> listAvenants = getAvenantDomainService()
									.getAvenant(conventionTmp.getIdConvention());

							cellAvenant = "";
							isAvenantExistant = false;

							for (AvenantDTO avenant : listAvenants) {
								ligneAvenant = "";

								if (avenant.isValidationAvenant()) {
									isAvenantExistant = true;

									if (avenant.getDateCreation() != null){
										ligneAvenant = "["
												+ avenant.getTitreAvenant()
												+ "] Créé le "
												+ new SimpleDateFormat(
														"dd/MM/yyyy à HH:mm:ss")
										.format(avenant
												.getDateCreation())
												+ "\n";
									} else {
										ligneAvenant = "["
												+ avenant.getTitreAvenant()
												+ "]\n";
									}

									// Rupture
									if (avenant.isRupture()) {
										if (avenant.getDateRupture() != null){
											ligneAvenant += "Rupture à compter du "
													+ new SimpleDateFormat(
															"dd/MM/yyyy")
											.format(avenant
													.getDateRupture());
										} else {
											ligneAvenant += "Rupture du stage";
										}
									} else {

										// Modif sujet
										if (avenant.isModificationSujet()) {
											ligneAvenant += "Remplacement du sujet par : "
													+ avenant.getSujetStage()
													+ "\n";
										}

										// Modif periode
										if (avenant.isModificationPeriode()) {
											if (avenant.getDateDebutStage() != null && avenant.getDateFinStage() != null){
												ligneAvenant += "Remplacement de la période par : Du "
														+ new SimpleDateFormat(
																"dd/MM/yyyy")
												.format(avenant
														.getDateDebutStage())
														+ " au "
														+ new SimpleDateFormat(
																"dd/MM/yyyy")
												.format(avenant
														.getDateFinStage());
											} else {
												ligneAvenant += "Remplacement de la période";
											}
											if (avenant.isInterruptionStage()) {
												if (avenant.getDateDebutInterruption() != null && avenant.getDateFinInterruption() != null){
													ligneAvenant += " avec interruption du "
															+ new SimpleDateFormat(
																	"dd/MM/yyyy")
													.format(avenant
															.getDateDebutInterruption())
															+ " au "
															+ new SimpleDateFormat(
																	"dd/MM/yyyy")
													.format(avenant
															.getDateFinInterruption());
												} else {
													ligneAvenant += " avec interruption";
												}
											} else {
												ligneAvenant += " sans interruption";
											}
											ligneAvenant += "\n";
										}

										// Modif Gratif
										if (avenant
												.isModificationMontantGratification()) {
											String uniteDureeGratif = "heures";
											if (avenant.getUniteDureeGratification() != null){
												uniteDureeGratif = avenant.getUniteDureeGratification().getLibelle();
											}
											ligneAvenant += "Remplacement de la gratification par : "
													+ avenant
													.getMontantGratification()
													+ " "
													+ avenant
													.getUniteGratification()
													.getLibelle()
													+ " par "
													+ uniteDureeGratif;
											ligneAvenant += "\n";
										}

										// Modif Lieu
										if (avenant.isModificationLieu()) {
											ligneAvenant += "Remplacement du lieu par : "
													+ avenant.getService()
													.getNom() + "";
											ligneAvenant += "\n";
										}

										// Modif Contact
										if (avenant.isModificationSalarie()) {
											ligneAvenant += "Remplacement du contact par : "
													+ avenant.getContact()
													.getPrenom()
													+ " "
													+ avenant.getContact()
													.getNom();
											ligneAvenant += "\n";
										}

										// Modif Enseignant
										if (avenant.isModificationEnseignant()) {
											ligneAvenant += "Remplacement de l'enseignant référent par : "
													+ avenant.getEnseignant()
													.getUidEnseignant();
											ligneAvenant += "\n";
										}
									}
									cellAvenant += (ligneAvenant + "\n");
								}
							}
						} else {
							isAvenantExistant = false;
						}
						if (isAvenantExistant) {
							row.createCell(cpt).setCellValue("Oui");
							cpt++;
							row.createCell(cpt).setCellValue(cellAvenant);
						} else {
							row.createCell(cpt).setCellValue("Non");
							cpt++;
							row.createCell(cpt).setCellValue(
									"Aucun avenant validé");
						}
					} else {
						// Cas général
						row.createCell(cpt).setCellValue(
								this.recupValueStage(colonne, conventionTmp));
					}
					cpt++;
				}
				for (String colonne : this.conventionEntrepriseColonnesChoisies) {
					row.createCell(cpt).setCellValue(
							this.recupValueEntreprise(colonne, conventionTmp));
					cpt++;
				}
			}

			try {
				ByteArrayOutputStream baosXLS = new ByteArrayOutputStream();

				classeur.write(baosXLS);

				ExportConventionsServlet edit = new ExportConventionsServlet();

				String XlsFileName ="extraction_pstage.xls";

				edit.doGet(baosXLS,XlsFileName);

			} catch (Exception e) {
				logger.error("exportConvention() - Exception lors de la tentative d'ecriture du baosXLS : "
						+ e.getMessage());
			}
		}
	}

	/**
	 * @return Object
	 */
	private String recupValueStage(String nameProperty, ConventionDTO convention) {
		try {
			if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.NUMEROCONVENTION")) {
				return convention.getIdConvention().toString();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.NUMEROETUDIANT")) {
				return convention.getEtudiant().getNumEtudiant();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.NOMETUDIANT")) {
				return convention.getEtudiant().getNom();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.PRENOMETUDIANT")) {
				return convention.getEtudiant().getPrenom();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.TELPERSOETUDIANT")) {
				return convention.getTelEtudiant();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.TELPORTABLEETUDIANT")) {
				return convention.getTelPortableEtudiant();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.MAILPERSOETUDIANT")) {
				return convention.getCourrielPersoEtudiant();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.CODESEXEETUDIANT")) {
				return convention.getEtudiant().getCodeSexe();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.ADRESSETU")) {
				return convention.getAdresseEtudiant();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.CODEPOSTALETU")) {
				return convention.getCodePostalEtudiant();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.PAYSETU")) {
				return convention.getPaysEtudiant();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.VILLEETU")) {
				return convention.getVilleEtudiant();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.CODEUFR")) {
				return convention.getUfr().getCode();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.LIBELLEUFR")) {
				return convention.getUfr().getLibelle();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.CODEDEPT")) {
				return convention.getCodeDepartement();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.CODEETAPE")) {
				return convention.getEtape().getCode();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.LIBELLEETAPE")) {
				return convention.getEtape().getLibelle();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.DATEDEB")) {
				if (convention.getDateDebutStage() != null){
					return new SimpleDateFormat("dd/MM/yyyy").format(convention
							.getDateDebutStage());
				} else {
					return "";
				}
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.DATEFIN")) {
				if (convention.getDateFinStage() != null){
					return new SimpleDateFormat("dd/MM/yyyy").format(convention
							.getDateFinStage());
				} else {
					return "";
				}
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.INTERRUPTION")) {
				if (convention.getInterruptionStageExport()) {
					return "Oui";
				} else {
					return "Non";
				}
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.DATEDEB.INTERRUPT")) {
				if (convention.getDateDebutInterruption() != null){
					return new SimpleDateFormat("dd/MM/yyyy").format(convention
							.getDateDebutInterruption());
				} else {
					return "";
				}
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.DATEFIN.INTERRUPT")) {
				if (convention.getDateFinInterruption() != null){
					return new SimpleDateFormat("dd/MM/yyyy").format(convention
							.getDateFinInterruption());
				} else {
					return "";
				}
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.THEMATIQUE")) {
				return convention.getTheme().getLibelle();
			} else if (nameProperty.equalsIgnoreCase("EXPORTCONVENTION.SUJET")) {
				return convention.getSujetStage();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.FONCTION")) {
				return convention.getFonctionsEtTaches();
			} else if (nameProperty.equalsIgnoreCase("EXPORTCONVENTION.DETAIL")) {
				return convention.getDetails();
			} else if (nameProperty.equalsIgnoreCase("EXPORTCONVENTION.DUREE")) {
				String duree = "0";
				if (convention.getDureeExceptionnelle() != null
						&& !convention.getDureeExceptionnelle().isEmpty()) {
					duree = convention.getDureeExceptionnelle();
					if (convention.getIdUniteDureeExceptionnelle() != null
							&& convention.getIdUniteDureeExceptionnelle() != 0) {
						switch (convention.getIdUniteDureeExceptionnelle()) {
						case 1:
							duree += " heure(s)";
						case 2:
							duree += " jour(s)";
						case 3:
							duree += " semaine(s)";
						case 4:
							duree += " mois";
						case 5:
							duree += " annee(s)";
						default:
							duree += " heure(s)";
						}
					} else {
						duree += " heure(s)";
					}
				} else {
					duree = convention.getDureeStage().toString() + " semaines";
				}

				return duree;
				// } else if
				// (nameProperty.equalsIgnoreCase("EXPORTCONVENTION.DUREEEXCEPTION")){
				// return convention.getDureeExceptionnelle();
				// } else if
				// (nameProperty.equalsIgnoreCase("EXPORTCONVENTION.UNITEDUREEEXCEP")){
				// if (convention.getDureeExceptionnelle() != null &&
				// !convention.getDureeExceptionnelle().isEmpty()){
				// if (convention.getIdUniteDureeExceptionnelle() != 0){
				// switch (convention.getIdUniteDureeExceptionnelle()) {
				// case 1:
				// return "heure(s)";
				// case 2:
				// return "jour(s)";
				// case 3:
				// return "semaine(s)";
				// case 4:
				// return "mois";
				// case 5:
				// return "annee(s)";
				// default:
				// return "";
				// }
				// } else {
				// return "heures";
				// }
				// } else {
				// return "";
				// }

			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.UNITEDUREEGRATIF")) {
				return convention.getUniteDureeGratification().getLibelle();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.NBJOURS")) {
				return convention.getNbJoursHebdo();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.GRATIFICATION")) {
				return convention.getMontantGratification();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.UNITEGRATIFICATION")) {
				return convention.getUniteGratification().getLibelle();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.VALIDEE")) {
				if (convention.getValidationConventionExport()) {
					return "Oui";
				} else {
					return "Non";
				}
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.VALIDEE.PEDAGOGIQUEMENT")) {
				if (convention.getValidationPedagogiqueExport()) {
					return "Oui";
				} else {
					return "Non";
				}
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.NOM.ENSEIGNANT")) {
				return convention.getEnseignant().getNom();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.PRENOM.ENSEIGNANT")) {
				return convention.getEnseignant().getPrenom();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.MAIL.ENSEIGNANT")) {
				return convention.getEnseignant().getMail();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.NOM.SIGNATAIRE")) {
				return convention.getSignataire().getNom();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.PRENOM.SIGNATAIRE")) {
				return convention.getSignataire().getPrenom();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.MAIL.SIGNATAIRE")) {
				return convention.getSignataire().getMail();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.FONCTION.SIGNATAIRE")) {
				return convention.getSignataire().getFonction();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.ANNEEUNIV")) {
				return convention.getAnnee();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.TYPECONVENTION")) {
				return convention.getTypeConvention().getLibelle();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.COMMENTAIRESTAGE")) {
				return convention.getCommentaireStage();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.COMMENTAIREDUREETRAVAIL")) {
				return convention.getCommentaireDureeTravail();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.AVANTAGESNATURE")) {
				return convention.getAvantagesNature();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.MAILUNIVETU")) {
				return convention.getEtudiant().getMail();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.DATECREATION")) {
				if (convention.getDateCreation() != null){
					return new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss").format(convention
							.getDateCreation());
				} else {
					return "";
				}
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.DATEMODIF")) {
				if (convention.getDateModif() != null){
					return new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss").format(convention
							.getDateModif());
				} else {
					return "";
				}
			} else {
				if (logger.isDebugEnabled())
					logger.debug("methode recupValueStage(...) : NameProperty "
							+ nameProperty + " inconnue.");
				return "";
			}
		} catch (NullPointerException e) {
			if (logger.isDebugEnabled())
				logger.debug("methode recupValueStage(...) : NullPointerException pour "
						+ nameProperty + ".");
			return "";
		}
	}

	/**
	 * @return Object
	 */
	private String recupValueEntreprise(String nameProperty,
			ConventionDTO convention) {
		try {
			if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.RAISONSOC")) {
				return convention.getStructure().getRaisonSociale();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.SIRET")) {
				return convention.getStructure().getNumeroSiret();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.RESIDENCE")) {
				return convention.getStructure().getBatimentResidence();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.VOIE")) {
				return convention.getStructure().getVoie();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.LIBCEDEX")) {
				return convention.getStructure().getLibCedex();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.CODEPOSTAL")) {
				return convention.getStructure().getCodePostal();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.COMMUNE")) {
				return convention.getStructure().getCommune();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.PAYS")) {
				return convention.getStructure().getPays().getLibelle();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.STATUTJURIDIQUE")) {
				return convention.getStructure().getStatutJuridique()
						.getLibelle();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.TYPESTRUCTURE")) {
				return convention.getStructure().getTypeStructure()
						.getLibelle();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.EFFECTIF")) {
				return convention.getStructure().getEffectif().getLibelle();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.CODENAF")) {
				return convention.getStructure().getCodeNAF_N5();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.TELEPHONE")) {
				return convention.getStructure().getTelephone();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.FAX")) {
				return convention.getStructure().getFax();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.MAIL")) {
				return convention.getStructure().getMail();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.STRUCTURE.SITEWEB")) {
				return convention.getStructure().getSiteWeb();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.SERVICE.NOM")) {
				return convention.getService().getNom();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.SERVICE.RESIDENCE")) {
				return convention.getService().getBatimentResidence();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.SERVICE.VOIE")) {
				return convention.getService().getVoie();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.SERVICE.LIBCEDEX")) {
				return convention.getService().getLibCedex();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.SERVICE.CODEPOSTAL")) {
				return convention.getService().getCodePostal();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.SERVICE.COMMUNE")) {
				return convention.getService().getCommune();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.SERVICE.PAYS")) {
				return convention.getService().getPays().getLibelle();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.NOM.CONTACT")) {
				return convention.getContact().getNom();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.PRENOM.CONTACT")) {
				return convention.getContact().getPrenom();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.MAIL.CONTACT")) {
				return convention.getContact().getMail();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.TEL.CONTACT")) {
				return convention.getContact().getTel();
			} else if (nameProperty
					.equalsIgnoreCase("EXPORTCONVENTION.FONCTION.CONTACT")) {
				return convention.getContact().getFonction();
			} else {
				if (logger.isDebugEnabled())
					logger.debug("methode recupValueEntreprise(...) : NameProperty "
							+ nameProperty + " inconnue.");
				return "";
			}
		} catch (NullPointerException e) {
			if (logger.isDebugEnabled())
				logger.debug("methode recupValueEntreprise(...) : NullPointerException pour "
						+ nameProperty + ".");
			return "";
		}
	}

	/**
	 * @return List <SelectItem>
	 */

	public List<SelectItem> getConventionColonnes() {
		List<SelectItem> ls = new ArrayList<SelectItem>();

		for (ConventionColonneEnum s : ConventionColonneEnum.values()) {

			ls.add(new SelectItem(s.getKeyLabel(), getString(s.getKeyLabel())));
		}

		return ls;
	}

	/**
	 * @return List <SelectItem>
	 */

	public List<SelectItem> getConventionEntrepriseColonnes() {
		List<SelectItem> ls = new ArrayList<SelectItem>();

		for (ConventionEntrepriseColonneEnum s : ConventionEntrepriseColonneEnum
				.values()) {

			ls.add(new SelectItem(s.getKeyLabel(), getString(s.getKeyLabel())));
		}
		return ls;
	}

	/* ***************************************************************
	 * Getters / Setters
	 * **************************************************************
	 */
	/**
	 * @return the resultatsRechercheConvention
	 */
	public List<ConventionDTO> getResultatsRechercheConvention() {
		return resultatsRechercheConvention;
	}

	/**
	 * @param resultatsRechercheConvention
	 *            the resultatsRechercheConvention to set
	 */
	public void setResultatsRechercheConvention(
			final List<ConventionDTO> resultatsRechercheConvention) {
		this.resultatsRechercheConvention = resultatsRechercheConvention;
	}

	/**
	 * @return the critereRechercheConvention
	 */
	public CritereRechercheConventionDTO getCritereRechercheConvention() {
		return critereRechercheConvention;
	}

	/**
	 * @param critereRechercheConvention
	 *            the critereRechercheConvention to set
	 */
	public void setCritereRechercheConvention(
			CritereRechercheConventionDTO critereRechercheConvention) {
		this.critereRechercheConvention = critereRechercheConvention;
	}

	/**
	 * @return the rechTypesStatutsStructure
	 */
	public List<SelectItem> getRechTypesStatutsStructure() {
		return rechTypesStatutsStructure;
	}

	/**
	 * @param rechTypesStatutsStructure
	 *            the rechTypesStatutsStructure to set
	 */
	public void setRechTypesStatutsStructure(
			List<SelectItem> rechTypesStatutsStructure) {
		this.rechTypesStatutsStructure = rechTypesStatutsStructure;
	}

	/**
	 * @return the rechTypeOuStatut
	 */
	public String getRechTypeOuStatut() {
		return rechTypeOuStatut;
	}

	/**
	 * @param rechTypeOuStatut
	 *            the rechTypeOuStatut to set
	 */
	public void setRechTypeOuStatut(String rechTypeOuStatut) {
		this.rechTypeOuStatut = rechTypeOuStatut;
	}

	/**
	 * @return the estValidee
	 */
	public String getEstValidee() {
		return estValidee;
	}

	/**
	 * @param estValidee
	 *            the estValidee to set
	 */
	public void setEstValidee(String estValidee) {
		this.estValidee = estValidee;
	}

	/**
	 * @return the conventionColonnesChoisies
	 */
	public List<String> getConventionColonnesChoisies() {
		return conventionColonnesChoisies;
	}

	/**
	 * @param conventionColonnesChoisies
	 *            the conventionColonnesChoisies to set
	 */
	public void setConventionColonnesChoisies(
			List<String> conventionColonnesChoisies) {
		this.conventionColonnesChoisies = conventionColonnesChoisies;
	}

	/**
	 * @return the conventionEntrepriseColonnesChoisies
	 */
	public List<String> getConventionEntrepriseColonnesChoisies() {
		return conventionEntrepriseColonnesChoisies;
	}

	/**
	 * @param conventionEntrepriseColonnesChoisies
	 *            the conventionEntrepriseColonnesChoisies to set
	 */
	public void setConventionEntrepriseColonnesChoisies(
			List<String> conventionEntrepriseColonnesChoisies) {
		this.conventionEntrepriseColonnesChoisies = conventionEntrepriseColonnesChoisies;
	}

	/**
	 * @return the conventionColonnesChoisiesItem
	 */
	public List<SelectItem> getConventionColonnesChoisiesItem() {
		return conventionColonnesChoisiesItem;
	}

	/**
	 * @param conventionColonnesChoisiesItem
	 *            the conventionColonnesChoisiesItem to set
	 */
	public void setConventionColonnesChoisiesItem(
			List<SelectItem> conventionColonnesChoisiesItem) {
		this.conventionColonnesChoisiesItem = conventionColonnesChoisiesItem;
	}

	/**
	 * @return the conventionEntrepriseColonnesChoisiesItem
	 */
	public List<SelectItem> getConventionEntrepriseColonnesChoisiesItem() {
		return conventionEntrepriseColonnesChoisiesItem;
	}

	/**
	 * @param conventionEntrepriseColonnesChoisiesItem
	 *            the conventionEntrepriseColonnesChoisiesItem to set
	 */
	public void setConventionEntrepriseColonnesChoisiesItem(
			List<SelectItem> conventionEntrepriseColonnesChoisiesItem) {
		this.conventionEntrepriseColonnesChoisiesItem = conventionEntrepriseColonnesChoisiesItem;
	}

	public String getEstVerifiee() {
		return estVerifiee;
	}

	public void setEstVerifiee(String estVerifiee) {
		this.estVerifiee = estVerifiee;
	}

	public boolean isEstEtrangere() {
		return estEtrangere;
	}

	public void setEstEtrangere(boolean estEtrangere) {
		this.estEtrangere = estEtrangere;
	}

}
