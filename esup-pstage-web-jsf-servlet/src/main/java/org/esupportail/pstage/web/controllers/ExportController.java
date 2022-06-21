package org.esupportail.pstage.web.controllers;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstage.web.beans.ConventionColonneEnum;
import org.esupportail.pstage.web.beans.ConventionEntrepriseColonneEnum;
import org.esupportail.pstage.web.servlet.ExportConventionsServlet;
import org.esupportail.pstagedata.domain.dto.*;
import org.primefaces.model.DualListModel;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.faces.model.SelectItem;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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
	private final transient Logger logger = Logger.getLogger(this.getClass());

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
	private DualListModel<String> conventionColonnesChoisies;

	/**
	 * Liste des colonnes convention choisies.
	 */
	private List<SelectItem> conventionColonnesChoisiesItem;

	/**
	 * Liste des colonnes convention/entreprise choisies.
	 */
	private DualListModel<String> conventionEntrepriseColonnesChoisies;

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
		this.conventionColonnesChoisies = new DualListModel<String>();
		this.conventionEntrepriseColonnesChoisies = new DualListModel<String>();

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

		if ("".equals(this.critereRechercheConvention.getNomEnseignant()))
			this.critereRechercheConvention.setNomEnseignant(null);
		if ("".equals(this.critereRechercheConvention.getPrenomEnseignant()))
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

		if (!StringUtils.hasText(this.estValidee)) {
			this.critereRechercheConvention.setEstValidee(null);
		} else if ("1".equals(this.estValidee)) {
			this.critereRechercheConvention.setEstValidee(true);
		} else if ("2".equals(this.estValidee)) {
			this.critereRechercheConvention.setEstValidee(false);
		}

		if (!StringUtils.hasText(this.estVerifiee)) {
			this.critereRechercheConvention.setEstVerifiee(null);
		} else if ("1".equals(this.estVerifiee)) {
			this.critereRechercheConvention.setEstVerifiee(true);
		} else if ("2".equals(this.estVerifiee)) {
			this.critereRechercheConvention.setEstVerifiee(false);
		}

		if (this.estEtrangere) {
			this.critereRechercheConvention.setEstEtrangere(true);
		} else {
			this.critereRechercheConvention.setEstEtrangere(false);
		}

		logger.info("Appel getConventionsFromCriteresExport debut ");

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
					for (Iterator<ConventionDTO> itercg = resultatsRechercheConventionCG.iterator(); itercg.hasNext();) {
						ConventionDTO conventionDTO = itercg.next();
						if (!this.resultatsRechercheConvention.contains(conventionDTO)) {
							this.resultatsRechercheConvention.add(conventionDTO);
						}
					}
//					Collections.sort(this.resultatsRechercheConvention,
//							new Comparator<ConventionDTO>() {
//								/**
//								 * @see java.util.Comparator#compare(java.lang.Object,
//								 *      java.lang.Object)
//								 */
//								@Override
//								public int compare(ConventionDTO l1,
//												   ConventionDTO l2) {
//									return l1.getIdConvention().compareTo(
//											l2.getIdConvention());
//								}
//							});
				}
			}
		} else {
			this.resultatsRechercheConvention = getConventionDomainService().getConventionsFromCriteresExport(this.critereRechercheConvention);
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
				List<ConventionDTO> lConventionExport;
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
		List<String> sourceCCC = new ArrayList<String>();
		for(ConventionColonneEnum cce : ConventionColonneEnum.values()) {
			sourceCCC.add(cce.getKeyLabel());
		}
//		Collections.sort(sourceCCC, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				return getString(s1).compareToIgnoreCase(getString(s2));
//			}
//		});
		List<String> targetCCC = new ArrayList<String>();
		this.conventionColonnesChoisies = new DualListModel<>(sourceCCC, targetCCC);

		List<String> sourceCECC = new ArrayList<String>();
		for(ConventionEntrepriseColonneEnum cecc : ConventionEntrepriseColonneEnum.values()) {
			sourceCECC.add(cecc.getKeyLabel());
		}
//		Collections.sort(sourceCECC, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				return getString(s1).compareTo(getString(s2));
//			}
//		});
		List<String> targetCECC = new ArrayList<>();
		this.conventionEntrepriseColonnesChoisies = new DualListModel<>(sourceCECC, targetCECC);
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
			List<ConventionDTO> lConventionExport;
			List<Integer> idsConventionsExport = new ArrayList<Integer>();
			for (ConventionDTO c : resultatsRechercheConvention) {
				idsConventionsExport.add(c.getIdConvention());
			}
			lConventionExport = getConventionDomainService()
					.getConventionsFromExport(idsConventionsExport);
			this.resultatsRechercheConvention = lConventionExport;
			ret = "exportConvention";
		}

		List<String> sourceCCC = new ArrayList<String>();
		for(ConventionColonneEnum cce : ConventionColonneEnum.values()) {
			sourceCCC.add(cce.getKeyLabel());
		}
//		Collections.sort(sourceCCC, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				return getString(s1).compareToIgnoreCase(getString(s2));
//			}
//		});
		List<String> targetCCC = new ArrayList<String>();
		this.conventionColonnesChoisies = new DualListModel<String>(sourceCCC, targetCCC);

		List<String> sourceCECC = new ArrayList<String>();
		for(ConventionEntrepriseColonneEnum cecc : ConventionEntrepriseColonneEnum.values()) {
			sourceCECC.add(cecc.getKeyLabel());
		}
//		Collections.sort(sourceCECC, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				return getString(s1).compareTo(getString(s2));
//			}
//		});
		List<String> targetCECC = new ArrayList<String>();
		this.conventionEntrepriseColonnesChoisies = new DualListModel<String>(sourceCECC, targetCECC);
		return ret;
	}

	/**
	 * @return String
	 */
	public String goToExportConvention() {
		String ret = null;
		if (this.resultatsRechercheConvention != null && !this.resultatsRechercheConvention.isEmpty()) {
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
			for (String colonne : this.conventionColonnesChoisies.getTarget()) {
				row.createCell(cpt).setCellValue(getString(colonne));
				// Si on choisi d'avoir les avenants, on ajoute une case pour
				// leurs contenus
				if ("EXPORTCONVENTION.AVENANT".equalsIgnoreCase(colonne)) {
					cpt++;
					row.createCell(cpt).setCellValue("Détails Avenant(s)");
				}
				cpt++;
			}
			for (String colonne : this.conventionEntrepriseColonnesChoisies.getTarget()) {
				row.createCell(cpt).setCellValue(getString(colonne));
				cpt++;
			}

			StringBuilder ligneAvenant;
			StringBuilder cellAvenant = new StringBuilder("");
			boolean isAvenantExistant;

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
				for (String colonne : this.conventionColonnesChoisies.getTarget()) {

					if ("EXPORTCONVENTION.AVENANT".equalsIgnoreCase(colonne)) {
						if (conventionTmp.getNbAvenant() > 0) {

							List<AvenantDTO> listAvenants = getAvenantDomainService()
									.getAvenant(conventionTmp.getIdConvention());

							cellAvenant = new StringBuilder("");
							isAvenantExistant = false;

							for (AvenantDTO avenant : listAvenants) {
								ligneAvenant = new StringBuilder("");

								if (avenant.isValidationAvenant()) {
									isAvenantExistant = true;

									if (avenant.getDateCreation() != null){
										ligneAvenant.append("["
												+ avenant.getTitreAvenant()
												+ "] Créé le "
												+ new SimpleDateFormat(
												"dd/MM/yyyy à HH:mm:ss")
												.format(avenant
														.getDateCreation())
												+ "\n");
									} else {
										ligneAvenant.append("["
												+ avenant.getTitreAvenant()
												+ "]\n");
									}

									// Rupture
									if (avenant.isRupture()) {
										if (avenant.getDateRupture() != null){
											ligneAvenant.append("Rupture à compter du "
													+ new SimpleDateFormat(
													"dd/MM/yyyy")
													.format(avenant
															.getDateRupture()));
										} else {
											ligneAvenant.append("Rupture du stage");
										}
									} else {

										// Modif sujet
										if (avenant.isModificationSujet()) {
											ligneAvenant.append("Remplacement du sujet par : "
													+ avenant.getSujetStage()
													+ "\n");
										}

										// Modif periode
										if (avenant.isModificationPeriode()) {
											if (avenant.getDateDebutStage() != null && avenant.getDateFinStage() != null){
												ligneAvenant.append("Remplacement de la période par : Du "
														+ new SimpleDateFormat(
														"dd/MM/yyyy")
														.format(avenant
																.getDateDebutStage())
														+ " au "
														+ new SimpleDateFormat(
														"dd/MM/yyyy")
														.format(avenant
																.getDateFinStage()));
											} else {
												ligneAvenant.append("Remplacement de la période");
											}
											if (avenant.isInterruptionStage()) {
												if (avenant.getDateDebutInterruption() != null && avenant.getDateFinInterruption() != null){
													ligneAvenant.append(" avec interruption du "
															+ new SimpleDateFormat(
															"dd/MM/yyyy")
															.format(avenant
																	.getDateDebutInterruption())
															+ " au "
															+ new SimpleDateFormat(
															"dd/MM/yyyy")
															.format(avenant
																	.getDateFinInterruption()));
												} else {
													ligneAvenant.append(" avec interruption");
												}
											} else {
												ligneAvenant.append(" sans interruption");
											}
											ligneAvenant.append("\n");
										}

										// Modif Gratif
										if (avenant.isModificationMontantGratification()) {
											String uniteDureeGratif = "heures";
											if (avenant.getUniteDureeGratification() != null){
												uniteDureeGratif = avenant.getUniteDureeGratification().getLibelle();
											}
											String uniteGratification = "Brut";
											if (avenant.getUniteGratification() != null) {
												uniteGratification = avenant.getUniteGratification().getLibelle();
											}											
											ligneAvenant.append("Remplacement de la gratification par : "
													+ avenant
													.getMontantGratification()
													+ " "
													+ uniteGratification
													+ " par "
													+ uniteDureeGratif);
											ligneAvenant.append("\n");
										}

										// Modif Lieu
										if (avenant.isModificationLieu()) {
											ligneAvenant.append("Remplacement du lieu par : "
													+ avenant.getService()
													.getNom() + "");
											ligneAvenant.append("\n");
										}

										// Modif Contact
										if (avenant.isModificationSalarie()) {
											ligneAvenant.append("Remplacement du contact par : "
													+ avenant.getContact()
													.getPrenom()
													+ " "
													+ avenant.getContact()
													.getNom());
											ligneAvenant.append("\n");
										}

										// Modif Enseignant
										if (avenant.isModificationEnseignant()) {
											ligneAvenant.append("Remplacement de l'enseignant référent par : "
													+ avenant.getEnseignant()
													.getUidEnseignant());
											ligneAvenant.append("\n");
										}
									}
									cellAvenant.append(ligneAvenant.toString() + "\n");
								}
							}
						} else {
							isAvenantExistant = false;
						}
						if (isAvenantExistant) {
							row.createCell(cpt).setCellValue("Oui");
							cpt++;
							row.createCell(cpt).setCellValue(cellAvenant.toString());
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
				for (String colonne : this.conventionEntrepriseColonnesChoisies.getTarget()) {
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
				logger.error("exportConvention() - Exception lors de la tentative d'ecriture du baosXLS : " + e);
			}
		}
	}

	/**
	 * @return Object
	 */
	private String recupValueStage(String nameProperty, ConventionDTO convention) {
		try {
			if ("EXPORTCONVENTION.NUMEROCONVENTION".equalsIgnoreCase(nameProperty)) {
				return convention.getIdConvention().toString();
			} else if ("EXPORTCONVENTION.NUMEROETUDIANT".equalsIgnoreCase(nameProperty)) {
				return convention.getEtudiant().getNumEtudiant();
			} else if ("EXPORTCONVENTION.NOMETUDIANT".equalsIgnoreCase(nameProperty)) {
				return convention.getEtudiant().getNom();
			} else if ("EXPORTCONVENTION.PRENOMETUDIANT".equalsIgnoreCase(nameProperty)) {
				return convention.getEtudiant().getPrenom();
			} else if ("EXPORTCONVENTION.TELPERSOETUDIANT".equalsIgnoreCase(nameProperty)) {
				return convention.getTelEtudiant();
			} else if ("EXPORTCONVENTION.TELPORTABLEETUDIANT".equalsIgnoreCase(nameProperty)) {
				return convention.getTelPortableEtudiant();
			} else if ("EXPORTCONVENTION.MAILPERSOETUDIANT".equalsIgnoreCase(nameProperty)) {
				return convention.getCourrielPersoEtudiant();
			} else if ("EXPORTCONVENTION.CODESEXEETUDIANT".equalsIgnoreCase(nameProperty)) {
				return convention.getEtudiant().getCodeSexe();
			} else if ("EXPORTCONVENTION.ADRESSETU".equalsIgnoreCase(nameProperty)) {
				return convention.getAdresseEtudiant();
			} else if ("EXPORTCONVENTION.CODEPOSTALETU".equalsIgnoreCase(nameProperty)) {
				return convention.getCodePostalEtudiant();
			} else if ("EXPORTCONVENTION.PAYSETU".equalsIgnoreCase(nameProperty)) {
				return convention.getPaysEtudiant();
			} else if ("EXPORTCONVENTION.VILLEETU".equalsIgnoreCase(nameProperty)) {
				return convention.getVilleEtudiant();
			} else if ("EXPORTCONVENTION.CODEUFR".equalsIgnoreCase(nameProperty)) {
				return convention.getUfr().getCode();
			} else if ("EXPORTCONVENTION.LIBELLEUFR".equalsIgnoreCase(nameProperty)) {
				return convention.getUfr().getLibelle();
			} else if ("EXPORTCONVENTION.CODEDEPT".equalsIgnoreCase(nameProperty)) {
				return convention.getCodeDepartement();
			} else if ("EXPORTCONVENTION.CODEETAPE".equalsIgnoreCase(nameProperty)) {
				return convention.getEtape().getCode();
			} else if ("EXPORTCONVENTION.LIBELLEETAPE".equalsIgnoreCase(nameProperty)) {
				return convention.getEtape().getLibelle();
			} else if ("EXPORTCONVENTION.DATEDEB".equalsIgnoreCase(nameProperty)) {
				if (convention.getDateDebutStage() != null){
					return new SimpleDateFormat("dd/MM/yyyy").format(convention
							.getDateDebutStage());
				} else {
					return "";
				}
			} else if ("EXPORTCONVENTION.DATEFIN".equalsIgnoreCase(nameProperty)) {
				if (convention.getDateFinStage() != null){
					return new SimpleDateFormat("dd/MM/yyyy").format(convention
							.getDateFinStage());
				} else {
					return "";
				}
			} else if ("EXPORTCONVENTION.INTERRUPTION".equalsIgnoreCase(nameProperty)) {
				if (convention.getInterruptionStageExport()) {
					return "Oui";
				} else {
					return "Non";
				}
			} else if ("EXPORTCONVENTION.DATEDEB.INTERRUPT".equalsIgnoreCase(nameProperty)) {
				if (convention.getInterruptionStageExport() && convention.getDateDebutInterruption() != null){
					return new SimpleDateFormat("dd/MM/yyyy").format(convention.getDateDebutInterruption());
				} else {
					return "";
				}
			} else if ("EXPORTCONVENTION.DATEFIN.INTERRUPT".equalsIgnoreCase(nameProperty)) {
				if (convention.getInterruptionStageExport() && convention.getDateFinInterruption() != null){
					return new SimpleDateFormat("dd/MM/yyyy").format(convention.getDateFinInterruption());
				} else {
					return "";
				}
			} else if ("EXPORTCONVENTION.THEMATIQUE".equalsIgnoreCase(nameProperty)) {
				return convention.getTheme().getLibelle();
			} else if ("EXPORTCONVENTION.SUJET".equalsIgnoreCase(nameProperty)) {
				return convention.getSujetStage();
			} else if ("EXPORTCONVENTION.FONCTION".equalsIgnoreCase(nameProperty)) {
				return convention.getFonctionsEtTaches();
			} else if ("EXPORTCONVENTION.DETAIL".equalsIgnoreCase(nameProperty)) {
				return convention.getDetails();
			} else if ("EXPORTCONVENTION.DUREE".equalsIgnoreCase(nameProperty)) {
				String duree;
				if (convention.getDureeExceptionnelle() != null
						&& !convention.getDureeExceptionnelle().isEmpty()) {
					duree = convention.getDureeExceptionnelle();
					if (convention.getIdUniteDureeExceptionnelle() != null
							&& convention.getIdUniteDureeExceptionnelle() != 0) {
						switch (convention.getIdUniteDureeExceptionnelle()) {
							case 1:
								duree += " heure(s)";
								break;
							case 2:
								duree += " jour(s)";
								break;
							case 3:
								duree += " semaine(s)";
								break;
							case 4:
								duree += " mois";
								break;
							case 5:
								duree += " annee(s)";
								break;
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
			} else if ("EXPORTCONVENTION.NBHEURESHEBDO".equalsIgnoreCase(nameProperty)) {
				return convention.getNbHeuresHebdo();
			} else if ("EXPORTCONVENTION.NBJOURS".equalsIgnoreCase(nameProperty)) {
				return convention.getNbJoursHebdo();
			} else if ("EXPORTCONVENTION.GRATIFICATION".equalsIgnoreCase(nameProperty)) {
				return convention.getMontantGratification();
			} else if ("EXPORTCONVENTION.UNITEGRATIFICATION".equalsIgnoreCase(nameProperty)) {
				return convention.getUniteGratification().getLibelle();
			} else if ("EXPORTCONVENTION.UNITEDUREEGRATIF".equalsIgnoreCase(nameProperty)) {
				return convention.getUniteDureeGratification().getLibelle();
			} else if ("EXPORTCONVENTION.ORIGINESTAGE".equalsIgnoreCase(nameProperty)) {
				return convention.getOrigineStage().getLibelle();					
			} else if ("EXPORTCONVENTION.VALIDEE".equalsIgnoreCase(nameProperty)) {
				if (convention.getValidationConventionExport()) {
					return "Oui";
				} else {
					return "Non";
				}
			} else if ("EXPORTCONVENTION.VALIDEE.PEDAGOGIQUEMENT".equalsIgnoreCase(nameProperty)) {
				if (convention.getValidationPedagogiqueExport()) {
					return "Oui";
				} else {
					return "Non";
				}
			} else if ("EXPORTCONVENTION.NOM.ENSEIGNANT".equalsIgnoreCase(nameProperty)) {
				return convention.getEnseignant().getNom();
			} else if ("EXPORTCONVENTION.PRENOM.ENSEIGNANT".equalsIgnoreCase(nameProperty)) {
				return convention.getEnseignant().getPrenom();
			} else if ("EXPORTCONVENTION.MAIL.ENSEIGNANT".equalsIgnoreCase(nameProperty)) {
				return convention.getEnseignant().getMail();
			} else if ("EXPORTCONVENTION.NOM.SIGNATAIRE".equalsIgnoreCase(nameProperty)) {
				return convention.getSignataire().getNom();
			} else if ("EXPORTCONVENTION.PRENOM.SIGNATAIRE".equalsIgnoreCase(nameProperty)) {
				return convention.getSignataire().getPrenom();
			} else if ("EXPORTCONVENTION.MAIL.SIGNATAIRE".equalsIgnoreCase(nameProperty)) {
				return convention.getSignataire().getMail();
			} else if ("EXPORTCONVENTION.FONCTION.SIGNATAIRE".equalsIgnoreCase(nameProperty)) {
				return convention.getSignataire().getFonction();
			} else if ("EXPORTCONVENTION.ANNEEUNIV".equalsIgnoreCase(nameProperty)) {
				return convention.getAnnee();
			} else if ("EXPORTCONVENTION.TYPECONVENTION".equalsIgnoreCase(nameProperty)) {
				return convention.getTypeConvention().getLibelle();
			} else if ("EXPORTCONVENTION.COMMENTAIRESTAGE".equalsIgnoreCase(nameProperty)) {
				return convention.getCommentaireStage();
			} else if ("EXPORTCONVENTION.COMMENTAIREDUREETRAVAIL".equalsIgnoreCase(nameProperty)) {
				return convention.getCommentaireDureeTravail();
			} else if ("EXPORTCONVENTION.AVANTAGESNATURE".equalsIgnoreCase(nameProperty)) {
				return convention.getAvantagesNature();
			} else if ("EXPORTCONVENTION.MAILUNIVETU".equalsIgnoreCase(nameProperty)) {
				return convention.getEtudiant().getMail();
			} else if ("EXPORTCONVENTION.DATECREATION".equalsIgnoreCase(nameProperty)) {
				if (convention.getDateCreation() != null){
					return new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss").format(convention
							.getDateCreation());
				} else {
					return "";
				}
			} else if ("EXPORTCONVENTION.DATEMODIF".equalsIgnoreCase(nameProperty)) {
				if (convention.getDateModif() != null){
					return new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss").format(convention
							.getDateModif());
				} else {
					return "";
				}
			} else if ("EXPORTCONVENTION.CODEELP".equalsIgnoreCase(nameProperty)) {
				return convention.getCodeElp();
			} else if ("EXPORTCONVENTION.LIBELLEELP".equalsIgnoreCase(nameProperty)) {
				return convention.getLibelleELP();
			}
			else {
				if (logger.isDebugEnabled())
					logger.debug("methode recupValueStage(...) : NameProperty "
							+ nameProperty + " inconnue.");
				return "";
			}
		} catch (NullPointerException e) {
			if (logger.isDebugEnabled())
				logger.debug("methode recupValueStage(...) : NullPointerException pour "
						+ nameProperty + ".",e);
			return "";
		}
	}

	/**
	 * @return Object
	 */
	private String recupValueEntreprise(String nameProperty,
										ConventionDTO convention) {
		try {
			if ("EXPORTCONVENTION.STRUCTURE.RAISONSOC".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getRaisonSociale();
			} else if ("EXPORTCONVENTION.STRUCTURE.SIRET".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getNumeroSiret();
			} else if ("EXPORTCONVENTION.STRUCTURE.RESIDENCE".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getBatimentResidence();
			} else if ("EXPORTCONVENTION.STRUCTURE.VOIE".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getVoie();
			} else if ("EXPORTCONVENTION.STRUCTURE.LIBCEDEX".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getLibCedex();
			} else if ("EXPORTCONVENTION.STRUCTURE.CODEPOSTAL".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getCodePostal();
			} else if ("EXPORTCONVENTION.STRUCTURE.COMMUNE".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getCommune();
			} else if ("EXPORTCONVENTION.STRUCTURE.PAYS".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getPays().getLibelle();
			} else if ("EXPORTCONVENTION.STRUCTURE.STATUTJURIDIQUE".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getStatutJuridique()
						.getLibelle();
			} else if ("EXPORTCONVENTION.STRUCTURE.TYPESTRUCTURE".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getTypeStructure()
						.getLibelle();
			} else if ("EXPORTCONVENTION.STRUCTURE.EFFECTIF".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getEffectif().getLibelle();
			} else if ("EXPORTCONVENTION.STRUCTURE.CODENAF".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getCodeNAF_N5();
			} else if ("EXPORTCONVENTION.STRUCTURE.TELEPHONE".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getTelephone();
			} else if ("EXPORTCONVENTION.STRUCTURE.FAX".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getFax();
			} else if ("EXPORTCONVENTION.STRUCTURE.MAIL".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getMail();
			} else if ("EXPORTCONVENTION.STRUCTURE.SITEWEB".equalsIgnoreCase(nameProperty)) {
				return convention.getStructure().getSiteWeb();
			} else if ("EXPORTCONVENTION.SERVICE.NOM".equalsIgnoreCase(nameProperty)) {
				return convention.getService().getNom();
			} else if ("EXPORTCONVENTION.SERVICE.RESIDENCE".equalsIgnoreCase(nameProperty)) {
				return convention.getService().getBatimentResidence();
			} else if ("EXPORTCONVENTION.SERVICE.VOIE".equalsIgnoreCase(nameProperty)) {
				return convention.getService().getVoie();
			} else if ("EXPORTCONVENTION.SERVICE.LIBCEDEX".equalsIgnoreCase(nameProperty)) {
				return convention.getService().getLibCedex();
			} else if ("EXPORTCONVENTION.SERVICE.CODEPOSTAL".equalsIgnoreCase(nameProperty)) {
				return convention.getService().getCodePostal();
			} else if ("EXPORTCONVENTION.SERVICE.COMMUNE".equalsIgnoreCase(nameProperty)) {
				return convention.getService().getCommune();
			} else if ("EXPORTCONVENTION.SERVICE.PAYS".equalsIgnoreCase(nameProperty)) {
				return convention.getService().getPays().getLibelle();
			} else if ("EXPORTCONVENTION.NOM.CONTACT".equalsIgnoreCase(nameProperty)) {
				return convention.getContact().getNom();
			} else if ("EXPORTCONVENTION.PRENOM.CONTACT".equalsIgnoreCase(nameProperty)) {
				return convention.getContact().getPrenom();
			} else if ("EXPORTCONVENTION.MAIL.CONTACT".equalsIgnoreCase(nameProperty)) {
				return convention.getContact().getMail();
			} else if ("EXPORTCONVENTION.TEL.CONTACT".equalsIgnoreCase(nameProperty)) {
				return convention.getContact().getTel();
			} else if ("EXPORTCONVENTION.FONCTION.CONTACT".equalsIgnoreCase(nameProperty)) {
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
						+ nameProperty + ".",e);
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
	public DualListModel<String> getConventionColonnesChoisies() {
		return conventionColonnesChoisies;
	}

	/**
	 * @param conventionColonnesChoisies
	 *            the conventionColonnesChoisies to set
	 */
	public void setConventionColonnesChoisies(
			DualListModel<String> conventionColonnesChoisies) {
		this.conventionColonnesChoisies = conventionColonnesChoisies;
	}

	/**
	 * @return the conventionEntrepriseColonnesChoisies
	 */
	public DualListModel<String> getConventionEntrepriseColonnesChoisies() {
		return conventionEntrepriseColonnesChoisies;
	}

	/**
	 * @param conventionEntrepriseColonnesChoisies
	 *            the conventionEntrepriseColonnesChoisies to set
	 */
	public void setConventionEntrepriseColonnesChoisies(
			DualListModel<String> conventionEntrepriseColonnesChoisies) {
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
