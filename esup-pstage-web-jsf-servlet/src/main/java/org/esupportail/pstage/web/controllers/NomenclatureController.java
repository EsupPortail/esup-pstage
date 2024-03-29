/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import gouv.education.apogee.commun.client.ws.GeographieMetier.CommuneDTO;
import org.apache.log4j.Logger;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.domain.dto.AssuranceDTO;
import org.esupportail.pstagedata.domain.dto.CaisseRegimeDTO;
import org.esupportail.pstagedata.domain.dto.CiviliteDTO;
import org.esupportail.pstagedata.domain.dto.ConfidentialiteDTO;
import org.esupportail.pstagedata.domain.dto.ContratOffreDTO;
import org.esupportail.pstagedata.domain.dto.DroitAdministrationDTO;
import org.esupportail.pstagedata.domain.dto.EffectifDTO;
import org.esupportail.pstagedata.domain.dto.FapN1DTO;
import org.esupportail.pstagedata.domain.dto.FapN2DTO;
import org.esupportail.pstagedata.domain.dto.FapN3DTO;
import org.esupportail.pstagedata.domain.dto.FapQualificationDTO;
import org.esupportail.pstagedata.domain.dto.FapQualificationSimplifieeDTO;
import org.esupportail.pstagedata.domain.dto.IndemnisationDTO;
import org.esupportail.pstagedata.domain.dto.LangueConventionDTO;
import org.esupportail.pstagedata.domain.dto.ModeCandidatureDTO;
import org.esupportail.pstagedata.domain.dto.ModeValidationStageDTO;
import org.esupportail.pstagedata.domain.dto.ModeVersGratificationDTO;
import org.esupportail.pstagedata.domain.dto.NafN1DTO;
import org.esupportail.pstagedata.domain.dto.NafN5DTO;
import org.esupportail.pstagedata.domain.dto.NatureTravailDTO;
import org.esupportail.pstagedata.domain.dto.NiveauCentreDTO;
import org.esupportail.pstagedata.domain.dto.NiveauFormationDTO;
import org.esupportail.pstagedata.domain.dto.OrigineStageDTO;
import org.esupportail.pstagedata.domain.dto.PaysDTO;
import org.esupportail.pstagedata.domain.dto.StatutJuridiqueDTO;
import org.esupportail.pstagedata.domain.dto.TempsTravailDTO;
import org.esupportail.pstagedata.domain.dto.ThemeDTO;
import org.esupportail.pstagedata.domain.dto.TypeConventionDTO;
import org.esupportail.pstagedata.domain.dto.TypeOffreDTO;
import org.esupportail.pstagedata.domain.dto.TypeStructureDTO;
import org.esupportail.pstagedata.domain.dto.UniteDureeDTO;
import org.esupportail.pstagedata.domain.dto.UniteGratificationDTO;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;


/**
 * AccordController
 */
/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
/**
 * @author Garot
 *
 */
public class NomenclatureController extends AbstractContextAwareController {

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
	/* ****************************
	 * Proprietes des Nomenclatures pour appel en jsp
	 */
	/**
	 * Liste de toutes les années universitaire
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> anneesConvention;
	/**
	 * Nomenclature des civilités
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> civilites;
	/**
	 * Nomenclature des confidentialités
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> confidentialites;
	/**
	 * Nomenclature des contrats
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> contrats;
	/**
	 * Date stage : stage en cours, terminé, ...
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> datesStage;
	/**
	 * Nomenclature des droitsAdmin
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> droitsAdmin;
	/**
	 * Nomenclature des effectifs
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> effectifs;
	/**
	 * Nomenclature de la FapN1
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> fapN1;
	/**
	 * Nomenclature de la FapN2
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> fapN2;
	/**
	 * Nomenclature de la FapN3
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> fapN3;
	/**
	 * Nomenclature des qualifications FAP
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> fapQualifications;
	/**
	 * Nomenclature des qualifications FAP simplifiées
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> fapQualificationsSimplifiees;
	/**
	 * Nomenclature des modes de candidature
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> modesCandidature;
	/**
	 * Nomenclature de la NafN1
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> nafN1;
	/**
	 * Nomenclature de la NafN5
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> nafN5;
	/**
	 * Nomenclature des niveaux de formation
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> niveauxFormation;
	/**
	 * Nomenclature des niveaux de centre (critères de gestion)
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> niveauxCentre;
	/**
	 * Nomenclature des pays
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> pays;
	/**
	 * Nomenclature des statuts juridiques
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> statutsJuridiques;
	/**
	 * Nomenclature dynamique mise à jour en fonction du type de structure
	 */
	private List<SelectItem> statutsJuridiquesListening;
	/**
	 * Nomenclature des temps de travail
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> tempsTravail;
	/**
	 * Nomenclature des types d'offre
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> typesOffre;
	/**
	 * Nomenclature des types de structures
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> typesStructure;

	/**
	 * Nomenclature des unités de durée
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> unitesDurees;

	/**
	 * Nomenclature assurances
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> assurances;

	/**
	 * Nomenclature typeConventions
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> typeConventions;

	/**
	 * Nomenclature themes
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> themes;

	/**
	 * Nomenclature indemnisation
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> indemnisations;

	/**
	 * Nomenclature uniteGratifications
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> uniteGratifications;

	/**
	 * Nomenclature modeVersGratifications
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> modeVersGratifications;

	/**
	 * Nomenclature natureTravails
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> natureTravails;

	/**
	 * Nomenclature modeValidationStages
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> modeValidationStages;

	/**
	 * Nomenclature  origineStages
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> origineStages;

	/**
	 * Liste d'années (année courant à année courante + 4)
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> annees;
	/**
	 * Liste des mois
	 */
	@SuppressWarnings("unused")
	private List<SelectItem> mois;

	/**
	 * Index du menu_centre
	 */
	private int indexMenu;



	/**
	 * Bean constructor.
	 */
	public NomenclatureController() {
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
	 * @return java.lang.String
	 */
	public String goToGestionNomenclatures(){
		this.resetObjects();
		this.typeConventionCurrentPage = "table";
		this.typeStructureCurrentPage = "table";
		this.statutJuridiqueCurrentPage = "table";
		this.typeOffreCurrentPage = "table";
		this.contratOffreCurrentPage = "table";
		this.effectifCurrentPage = "table";
		this.modeValidationStageCurrentPage = "table";

		return "gestionNomenclatures";
	}

	/**
	 * @return java.lang.String
	 */
	public void resetObjects(){
		this.caisseRegime = new CaisseRegimeDTO();
		this.niveauFormation = new NiveauFormationDTO();
		this.tpsTravail = new TempsTravailDTO();
		this.origineStage = new OrigineStageDTO();
		this.typeConvention = new TypeConventionDTO();
		this.typeStructure = new TypeStructureDTO();
		this.statutJuridique = new StatutJuridiqueDTO();
		this.typeOffre = new TypeOffreDTO();
		this.contratOffre = new ContratOffreDTO();
		this.effectif = new EffectifDTO();
		this.modeValidationStage = new ModeValidationStageDTO();
	}

	/**
	 * Navigation
	 */
	private String caisseRegimeCurrentPage = "table";
	private String niveauFormationCurrentPage = "table";
	private String tempsTravailCurrentPage = "table";
	private String origineStageCurrentPage = "table";
	private String typeConventionCurrentPage = "table";
	private String typeStructureCurrentPage = "table";
	private String statutJuridiqueCurrentPage = "table";
	private String typeOffreCurrentPage = "table";
	private String contratOffreCurrentPage = "table";
	private String effectifCurrentPage = "table";
	private String modeValidationStageCurrentPage = "table";

	/**
	 * Objets
	 */
	private CaisseRegimeDTO caisseRegime;
	private NiveauFormationDTO niveauFormation;
	private TempsTravailDTO tpsTravail;
	private OrigineStageDTO origineStage;
	private TypeConventionDTO typeConvention;
	private TypeStructureDTO typeStructure;
	private StatutJuridiqueDTO statutJuridique;
	private TypeOffreDTO typeOffre;
	private ContratOffreDTO contratOffre;
	private EffectifDTO effectif;
	private ModeValidationStageDTO modeValidationStage;

	/**
	 * Code de l'objet CaisseRegime en cours de modification
	 */
	private String codeCaisseRegime;

	////////////////////////////////
	// AJOUTS/UPDATES/SUPPRESSIONS/
	//////////////////////////////
	/**
	 * @return
	 */
	public void addCaisseRegime() {
		try{
			getNomenclatureDomainService().addCaisseRegime(this.caisseRegime);
			addInfoMessage(null,"NOMENCLATURES.AJOUT.CONFIRMATION");
			this.caisseRegimeCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			if (we.getMessage().contains("Duplicate")){
				addErrorMessage(null,"NOMENCLATURES.ERREUR_DUPLICAT");
			} else {
				logger.error("WebServiceDataBaseException", we);
				addErrorMessage(null,"NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage(null,"NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void updateCaisseRegime(){
		try{
			// Si le code de CaisseRegime a été modifié dans le formulaire
			if (!this.codeCaisseRegime.equalsIgnoreCase(this.caisseRegime.getCode())){
//				// On verifie que le code saisi n'est pas deja existant dans la liste
				List<SelectItem> listTmp = this.getCaisseRegimes();
				if (listTmp != null) {
					for (SelectItem tmp : listTmp){
						CaisseRegimeDTO caisseRegime = (CaisseRegimeDTO)tmp.getValue();
						logger.info(this.caisseRegime.getCode() + " " + caisseRegime.getCode());
						if (this.caisseRegime.getCode().equalsIgnoreCase(caisseRegime.getCode())){
							addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR_DUPLICAT");
							return;
						}
					}
				}
			}
			getNomenclatureDomainService().updateCaisseRegime(this.caisseRegime,this.codeCaisseRegime);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.caisseRegimeCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteCaisseRegime(){
		try{
			if (getNomenclatureDomainService().deleteCaisseRegime(this.caisseRegime.getCode())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void reactivateCaisseRegime() {
		try {
			if(getNomenclatureDomainService().reactivateCaisseRegime(this.caisseRegime.getCode())) {
				addInfoMessage("formNomenclature","NOMENCLATURES.REACTIVATION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch (Exception e) {
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void addNiveauFormation(){
		try{
			getNomenclatureDomainService().addNiveauFormation(this.niveauFormation);
			addInfoMessage("formNomenclature","NOMENCLATURES.AJOUT.CONFIRMATION");
			this.niveauFormationCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");

		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void updateNiveauFormation(){
		try{
			getNomenclatureDomainService().updateNiveauFormation(this.niveauFormation);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.niveauFormationCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteNiveauFormation(){
		try{
			if (getNomenclatureDomainService().deleteNiveauFormation(this.niveauFormation.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void reactivateNiveauFormation() {
		try {
			if(getNomenclatureDomainService().reactivateNiveauFormation(this.niveauFormation.getId())) {
				addInfoMessage("formNomenclature","NOMENCLATURES.REACTIVATION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch (Exception e) {
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void addTempsTravail(){
		try{
			getNomenclatureDomainService().addTempsTravail(this.tpsTravail);
			addInfoMessage("formNomenclature","NOMENCLATURES.AJOUT.CONFIRMATION");
			this.tempsTravailCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void updateTempsTravail(){
		try{
			getNomenclatureDomainService().updateTempsTravail(this.tpsTravail);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.tempsTravailCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteTempsTravail(){
		try{
			if (getNomenclatureDomainService().deleteTempsTravail(this.tpsTravail.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void reactivateTempsTravail() {
		try{
			if (getNomenclatureDomainService().reactivateTempsTravail(this.tpsTravail.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.REACTIVATION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void addOrigineStage(){
		try{
			getNomenclatureDomainService().addOrigineStage(this.origineStage);
			addInfoMessage("formNomenclature","NOMENCLATURES.AJOUT.CONFIRMATION");
			this.origineStageCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void updateOrigineStage(){
		try{
			getNomenclatureDomainService().updateOrigineStage(this.origineStage);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.origineStageCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteOrigineStage(){
		try{
			if (getNomenclatureDomainService().deleteOrigineStage(this.origineStage.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void reactivateOrigineStage() {
		try{
			if (getNomenclatureDomainService().reactivateOrigineStage(this.origineStage.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.REACTIVATION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void addTypeConvention(){
		try{
			getNomenclatureDomainService().addTypeConvention(this.typeConvention);
			addInfoMessage("formNomenclature","NOMENCLATURES.AJOUT.CONFIRMATION");
			this.typeConventionCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void updateTypeConvention(){
		try{
			getNomenclatureDomainService().updateTypeConvention(this.typeConvention);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.typeConventionCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteTypeConvention(){
		try{
			if (getNomenclatureDomainService().deleteTypeConvention(this.typeConvention.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}


	/**
	 * @return
	 */
	public void addTypeStructure(){
		try{
			getNomenclatureDomainService().addTypeStructure(this.typeStructure);
			addInfoMessage("formNomenclature","NOMENCLATURES.AJOUT.CONFIRMATION");
			this.typeStructureCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void updateTypeStructure(){
		try{
			getNomenclatureDomainService().updateTypeStructure(this.typeStructure);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.typeStructureCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteTypeStructure(){
		try{
			if (getNomenclatureDomainService().deleteTypeStructure(this.typeStructure.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			if (e.getMessage().contains("Constraint")){
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR_CONTRAINTE_TYPESTRUCT");
			} else {
				logger.error("Exception", e);
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		}
	}

	/**
	 * @return
	 */
	public void reactivateTypeStructure() {
		try {
			if(getNomenclatureDomainService().reactivateTypeStructure(this.typeStructure.getId())) {
				addInfoMessage("formNomenclature","NOMENCLATURES.REACTIVATION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch (Exception e) {
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void addStatutJuridique(){
		try{
			if(this.statutJuridique.getTypeStructure() != null){
				this.statutJuridique.setIdParent(this.statutJuridique.getTypeStructure().getId());
			} else {
				this.statutJuridique.setIdParent(0);
			}
			getNomenclatureDomainService().addStatutJuridique(this.statutJuridique);
			addInfoMessage("formNomenclature","NOMENCLATURES.AJOUT.CONFIRMATION");
			this.statutJuridiqueCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void updateStatutJuridique(){
		try{
			if(this.statutJuridique.getTypeStructure() != null){
				this.statutJuridique.setIdParent(this.statutJuridique.getTypeStructure().getId());
			} else {
				this.statutJuridique.setIdParent(0);
			}
			getNomenclatureDomainService().updateStatutJuridique(this.statutJuridique);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.statutJuridiqueCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteStatutJuridique(){
		try{
			if (getNomenclatureDomainService().deleteStatutJuridique(this.statutJuridique.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void reactivateStatutJuridique() {
		try {
			if(getNomenclatureDomainService().reactivateStatutJuridique(this.statutJuridique.getId())) {
				addInfoMessage("formNomenclature", "NOMENCLATURES.REACTIVATION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature", "NOMENCLATURES.ERREUR");
			}
		} catch(Exception e) {
			logger.error("Exception", e);
			addErrorMessage("formNomenclature", "NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void addTypeOffre(){
		try{
			getNomenclatureDomainService().addTypeOffre(this.typeOffre);
			addInfoMessage("formNomenclature","NOMENCLATURES.AJOUT.CONFIRMATION");
			this.typeOffreCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void updateTypeOffre(){
		try{
			getNomenclatureDomainService().updateTypeOffre(this.typeOffre);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.typeOffreCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteTypeOffre(){
		try{
			if (getNomenclatureDomainService().deleteTypeOffre(this.typeOffre.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			if (e.getMessage().contains("Constraint")){
				logger.error("Exception", e);
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR_CONTRAINTE_TYPEOFFRE");
			} else {
				logger.error("Exception", e);
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		}
	}

	/**
	 * @return
	 */
	public void reactivateTypeOffre() {
		try {
			if(getNomenclatureDomainService().reactivateTypeOffre(this.typeOffre.getId())) {
				addInfoMessage("formNomenclature", "NOMENCLATURES.REACTIVATION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature", "NOMENCLATURES.ERREUR");
			}
		} catch(Exception e) {
			logger.error("Exception", e);
			addErrorMessage("formNomenclature", "NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void addContratOffre(){
		try{
			if(this.contratOffre.getTypeOffre() != null){
				this.contratOffre.setIdParent(this.contratOffre.getTypeOffre().getId());
			} else {
				this.contratOffre.setIdParent(0);
			}
			getNomenclatureDomainService().addContratOffre(this.contratOffre);
			addInfoMessage("formNomenclature","NOMENCLATURES.AJOUT.CONFIRMATION");
			this.contratOffreCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void updateContratOffre(){
		try{
			if(this.contratOffre.getTypeOffre() != null){
				this.contratOffre.setIdParent(this.contratOffre.getTypeOffre().getId());
			} else {
				this.contratOffre.setIdParent(0);
			}
			getNomenclatureDomainService().updateContratOffre(this.contratOffre);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.contratOffreCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteContratOffre(){
		try{
			if (getNomenclatureDomainService().deleteContratOffre(this.contratOffre.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void reactivateContratOffre() {
		try {
			if(getNomenclatureDomainService().reactivateContratOffre(this.contratOffre.getId())) {
				addInfoMessage("formNomenclature", "NOMENCLATURES.REACTIVATION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature", "NOMENCLATURES.ERREUR");
			}
		} catch(Exception e) {
			logger.error("Exception", e);
			addErrorMessage("formNomenclature", "NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void addEffectif(){
		try{
			getNomenclatureDomainService().addEffectif(this.effectif);
			addInfoMessage("formNomenclature","NOMENCLATURES.AJOUT.CONFIRMATION");
			this.effectifCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void updateEffectif(){
		try{
			getNomenclatureDomainService().updateEffectif(this.effectif);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.effectifCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteEffectif(){
		try{
			if (getNomenclatureDomainService().deleteEffectif(this.effectif.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void reactivateEffectif() {
		try {
			if(getNomenclatureDomainService().reactivateEffectif(this.effectif.getId())) {
				addInfoMessage("formNomenclature", "NOMENCLATURES.REACTIVATION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature", "NOMENCLATURES.ERREUR");
			}
		} catch(Exception e) {
			logger.error("Exception", e);
			addErrorMessage("formNomenclature", "NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void addModeValidationStage(){
		try{
			getNomenclatureDomainService().addModeValidationStage(this.modeValidationStage);
			addInfoMessage("formNomenclature","NOMENCLATURES.AJOUT.CONFIRMATION");
			this.modeValidationStageCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");

		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void updateModeValidationStage(){
		try{
			getNomenclatureDomainService().updateModeValidationStage(this.modeValidationStage);
			addInfoMessage("formNomenclature","NOMENCLATURES.MODIFICATION.CONFIRMATION");
			this.modeValidationStageCurrentPage="table";
		} catch(WebServiceDataBaseException we){
			logger.error("WebServiceDataBaseException", we);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}
	/**
	 * @return
	 */
	public void deleteModeValidationStage(){
		try{
			if (getNomenclatureDomainService().deleteModeValidationStage(this.modeValidationStage.getId())){
				addInfoMessage("formNomenclature","NOMENCLATURES.SUPPRESSION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
			}
		} catch(Exception e){
			logger.error("Exception", e);
			addErrorMessage("formNomenclature","NOMENCLATURES.ERREUR");
		}
	}

	/**
	 * @return
	 */
	public void reactivateModeValidationStage() {
		try {
			if(getNomenclatureDomainService().reactivateModeValidationStage(this.modeValidationStage.getId())) {
				addInfoMessage("formNomenclature", "NOMENCLATURES.REACTIVATION.CONFIRMATION");
			} else {
				addErrorMessage("formNomenclature", "NOMENCLATURES.ERREUR");
			}
		} catch(Exception e) {
			logger.error("Exception", e);
			addErrorMessage("formNomenclature", "NOMENCLATURES.ERREUR");
		}
	}

	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getAnneesConvention(){
		List<SelectItem> ls = new ArrayList<>();
		List<String> an = getConventionDomainService().getAnneesConvention(getSessionController().getCodeUniversite());
		if(an!=null && !an.isEmpty()){
			ls = new ArrayList<>();
			for(String s : an){
				ls.add(new SelectItem(s,s));
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getAnneesUnivOffres() {
		List<SelectItem> ls = new ArrayList<>();
		List<String> an = getOffreDomainService().getAnneesUnivOffres();
		if(an!=null && !an.isEmpty()){
			ls = new ArrayList<>();
			for(String s : an){
				ls.add(new SelectItem(s,s));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getAnnees() {
		List<SelectItem> ls;
		List<String> l = new ArrayList<>();
		String cY = Utils.getYear(Utils.getToday());
		int cYi = Utils.convertStringToInt(cY);
		l.add(cY);
		l.add(Integer.toString(cYi + 1));
		l.add(Integer.toString(cYi + 2));
		l.add(Integer.toString(cYi + 3));
		l.add(Integer.toString(cYi + 4 ));
		ls = new ArrayList<>();
		for(String s : l){
			ls.add(new SelectItem(s,s));
		}
		return ls;
	}


	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getAssurances() {
		List<SelectItem> ls = null;
		List<AssuranceDTO> l = getNomenclatureDomainService().getAssurances();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(AssuranceDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getCaisseRegimes() {
		List<SelectItem> ls = null;
		List<CaisseRegimeDTO> l = getNomenclatureDomainService().getCaisseRegimes();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(CaisseRegimeDTO o : l){
				String lib="";
				lib+=o.getCode() + " - " + o.getLibelle();
				lib+=(o.getInfoCaisse()!=null && !o.getInfoCaisse().isEmpty())?" (" + o.getInfoCaisse() + ")":"";
				ls.add(new SelectItem(o,lib));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getCivilites(){
		List<SelectItem> ls = null;
		List<CiviliteDTO> l = getNomenclatureDomainService().getCivilites();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(CiviliteDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getConfidentialites(){
		List<SelectItem> ls = null;
		List<ConfidentialiteDTO> l = getNomenclatureDomainService().getConfidentialites();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(ConfidentialiteDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getConfidentialitesSansConfEtab(){
		List<SelectItem> ls = null;
		List<ConfidentialiteDTO> l = getNomenclatureDomainService().getConfidentialites();
		if(l!=null){
			l.remove(getBeanUtils().getConfidentialiteLibre());
			ls = new ArrayList<>();
			for(ConfidentialiteDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getContrats(){
		List<SelectItem> ls = new ArrayList<>();
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContrats();
		if(l!=null){
			for(ContratOffreDTO o : l){
				String lib = o.getLibelle() + " (TypeOffre: " + o.getTypeOffre().getLibelle() + ")";
				ls.add(new SelectItem(o,lib));
			}
		}
		return ls;
	}

	/**
	 * @param id
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getContratOffreFromIdTypeOffre(int id){
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContratsOffreFromIdTypeOffre(id);
		List<SelectItem> ls = new ArrayList<>();
		for(ContratOffreDTO o : l){
			ls.add(new SelectItem(o,o.getLibelle()));
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getDatesStage(){
		List<SelectItem> ls = new ArrayList<>();
		ls.add(new SelectItem("1",getString("RECHERCHECONVENTION.DATESTAGE.ENCOURS")));
		ls.add(new SelectItem("2",getString("RECHERCHECONVENTION.DATESTAGE.TERMINE")));
		ls.add(new SelectItem("3",getString("RECHERCHECONVENTION.DATESTAGE.MOINS1SEM")));
		ls.add(new SelectItem("4",getString("RECHERCHECONVENTION.DATESTAGE.MOINS2SEM")));
		ls.add(new SelectItem("5",getString("RECHERCHECONVENTION.DATESTAGE.MOINS1MOIS")));
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getDroitsAdmin(){
		List<SelectItem> ls = new ArrayList<>();
		List<DroitAdministrationDTO> l = getNomenclatureDomainService().getDroitsAdmin();
		if(l!=null){
			for(DroitAdministrationDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getEffectifs(){
		List<SelectItem> ls = new ArrayList<>();
		List<EffectifDTO> l = getNomenclatureDomainService().getEffectifs();
		if(l!=null){
			for(EffectifDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getEffectifsEnServ(){
		List<SelectItem> ls = new ArrayList<>();
		List<EffectifDTO> l = getNomenclatureDomainService().getEffectifs();
		if(l!=null){
			for(EffectifDTO o : l){
				if ("O".equalsIgnoreCase(o.getTemEnServ())) {
					ls.add(new SelectItem(o, o.getLibelle()));
				}
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapN1(){
		List<SelectItem> ls = new ArrayList<>();
		List<FapN1DTO> l = getNomenclatureDomainService().getFapN1();
		if(l!=null){
			for(FapN1DTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapN2(){
		List<SelectItem> ls = new ArrayList<>();
		List<FapN2DTO> l = getNomenclatureDomainService().getFapN2();
		if(l!=null){
			for(FapN2DTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @param code
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapN2FromCodeFapN1(String code){
		List<SelectItem> ls = new ArrayList<>();
		List<FapN2DTO> l = getNomenclatureDomainService().getFapN2FromCodeFapN1(code);
		for(FapN2DTO o : l){
			ls.add(new SelectItem(o,o.getLibelle()));
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapN3(){
		List<SelectItem> ls = new ArrayList<>();
		List<FapN3DTO> l = getNomenclatureDomainService().getFapN3();
		if(l!=null){
			for(FapN3DTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @param code
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapN3FromCodeFapN2(String code){
		List<SelectItem> ls = new ArrayList<>();
		List<FapN3DTO> l = getNomenclatureDomainService().getFapN3FromCodeFapN2(code);
		for(FapN3DTO o : l){
			ls.add(new SelectItem(o,o.getLibelle()));
		}
		return ls;
	}
	/**
	 * @param num
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapN3FromNumQualif(int num){
		List<SelectItem> ls = new ArrayList<>();
		List<FapN3DTO> l = getNomenclatureDomainService().getFapN3FromNumQualif(num);

		for(FapN3DTO o : l){
			if(o.getNumQualification()==num){
				ls.add(new SelectItem(o.getNumQualification(),o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapQualifications(){
		List<SelectItem> ls = new ArrayList<>();
		List<FapQualificationDTO> l = getNomenclatureDomainService().getFapQualifications();
		if(l!=null){
			for(FapQualificationDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @param id
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapQualificationFromNumQualifSimplifiee(int id){
		List<SelectItem> ls = new ArrayList<>();
		List<FapQualificationDTO> l = getNomenclatureDomainService().getFapQualificationFromNumQualifSimplifiee(id);
		for(FapQualificationDTO o : l){
			ls.add(new SelectItem(o,o.getLibelle()));
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapQualificationsSimplifiees(){
		List<SelectItem> ls = new ArrayList<>();
		List<FapQualificationSimplifieeDTO> l = getNomenclatureDomainService().getFapQualificationsSimplifiees();
		if(l!=null){
			for(FapQualificationSimplifieeDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}


	/**
	 * @return the Indemnisations
	 */
	public List<SelectItem> getIndemnisations() {
		List<SelectItem> ls = new ArrayList<>();
		List<IndemnisationDTO> l = getNomenclatureDomainService().getIndemnisations();
		if(l!=null){
			for(IndemnisationDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}


	/**
	 * @return List<SelectItem> getLangueConventions()
	 */
	public List<SelectItem> getLangueConventions(){
		List<SelectItem> ls = new ArrayList<>();
		List<LangueConventionDTO> l = getNomenclatureDomainService().getLangueConventions();
		if(l!=null){
			for(LangueConventionDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getModesCandidature(){
		List<SelectItem> ls = new ArrayList<>();
		List<ModeCandidatureDTO> l = getNomenclatureDomainService().getModesCandidature();
		if(l!=null){
			for(ModeCandidatureDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}


	/**
	 * @return the ModeValidationStages
	 */
	public List<SelectItem> getModeValidationStages() {
		List<SelectItem> ls = new ArrayList<>();
		List<ModeValidationStageDTO> l = getNomenclatureDomainService().getModeValidationStages();
		if(l!=null){
			for(ModeValidationStageDTO o : l){
				ls.add(new SelectItem(o, o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return the ModeValidationStages
	 */
	public List<SelectItem> getModeValidationStagesEnServ() {
		List<SelectItem> ls = new ArrayList<>();
		List<ModeValidationStageDTO> l = getNomenclatureDomainService().getModeValidationStages();
		if(l!=null){
			for(ModeValidationStageDTO o : l){
				if ("O".equalsIgnoreCase(o.getTemEnServ())) {
					ls.add(new SelectItem(o, o.getLibelle()));
				}
			}
		}
		return ls;
	}



	/**
	 * @return the ModeVersGratifications
	 */
	public List<SelectItem> getModeVersGratifications() {
		List<SelectItem> ls = new ArrayList<>();
		List<ModeVersGratificationDTO> l = getNomenclatureDomainService().getModeVersGratifications();
		if(l!=null){
			for(ModeVersGratificationDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getMois(){
		List<SelectItem> ls = new ArrayList<>();
		List<String> l = new ArrayList<>();
		l.add(getString("MOIS.JANVIER"));
		l.add(getString("MOIS.FEVRIER"));
		l.add(getString("MOIS.MARS"));
		l.add(getString("MOIS.AVRIL"));
		l.add(getString("MOIS.MAI"));
		l.add(getString("MOIS.JUIN"));
		l.add(getString("MOIS.JUILLET"));
		l.add(getString("MOIS.AOUT"));
		l.add(getString("MOIS.SEPTEMBRE"));
		l.add(getString("MOIS.OCTOBRE"));
		l.add(getString("MOIS.NOVEMBRE"));
		l.add(getString("MOIS.DECEMBRE"));
		for(String s : l){
			ls.add(new SelectItem(s,s));
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getNafN1(){
		List<SelectItem> ls = new ArrayList<>();
		List<NafN1DTO> l = getNomenclatureDomainService().getNafN1();
		if(l!=null){
			for(NafN1DTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getNafN5(){
		List<SelectItem> ls = new ArrayList<>();
		List<NafN5DTO> l = getNomenclatureDomainService().getNafN5();
		if(l!=null){
			for(NafN5DTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @param code
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getNafN5FromCodeNafN1(String code){
		List<SelectItem> ls = new ArrayList<>();
		List<NafN5DTO> l = getNomenclatureDomainService().getNafN5FromCodeNafN1(code);
		for(NafN5DTO o : l){
			ls.add(new SelectItem(o,o.getLibelle()));
		}
		return ls;
	}

	/**
	 * @return the NatureTravails
	 */
	public List<SelectItem> getNatureTravails() {
		List<SelectItem> ls = new ArrayList<>();
		List<NatureTravailDTO> l = getNomenclatureDomainService().getNatureTravails();
		if(l!=null){
			for(NatureTravailDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getNiveauxCentre(){
		List<SelectItem> ls = new ArrayList<>();
		List<NiveauCentreDTO> l = getNomenclatureDomainService().getNiveauxCentre();
		if(l!=null){
			for(NiveauCentreDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getNiveauxFormation(){
		List<SelectItem> ls = new ArrayList<>();
		List<NiveauFormationDTO> l = getNomenclatureDomainService().getNiveauxFormation();
		if(l!=null){
			for(NiveauFormationDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getNiveauxFormationEnServ(){
		List<SelectItem> ls = new ArrayList<>();
		List<NiveauFormationDTO> l = getNomenclatureDomainService().getNiveauxFormation();
		if(l!=null){
			for(NiveauFormationDTO o : l){
				if ("O".equalsIgnoreCase(o.getTemEnServ())) {
					ls.add(new SelectItem(o, o.getLibelle()));
				}
			}
		}
		return ls;
	}

	/**
	 * @return the origineStages
	 */
	public List<SelectItem> getOrigineStages() {
		List<SelectItem> ls = new ArrayList<>();
		List<OrigineStageDTO> l = getNomenclatureDomainService().getOrigineStages();
		if(l!=null){
			for(OrigineStageDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return the origineStages en service
	 */
	public List<SelectItem> getOrigineStagesEnServ() {
		List<SelectItem> ls = new ArrayList<>();
		List<OrigineStageDTO> l = getNomenclatureDomainService().getOrigineStages();
		if(l!=null){
			for(OrigineStageDTO o : l){
				if ("O".equalsIgnoreCase(o.getTemEnServ())) {
					ls.add(new SelectItem(o, o.getLibelle()));
				}
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getPays(){
		List<SelectItem> ls = new ArrayList<>();
		List<PaysDTO> l = getNomenclatureDomainService().getPays();
		if(l!=null){
			ls.add(new SelectItem("",""));
			for(PaysDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}



	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getStatutsJuridiques(){
		List<SelectItem> ls = new ArrayList<>();
		List<StatutJuridiqueDTO> l = getNomenclatureDomainService().getStatutsJuridiques();
		if(l!=null){
			for(StatutJuridiqueDTO o : l){
				String lib = o.getLibelle() + " (TypeStructure: " + o.getTypeStructure().getLibelle() + ")";
				ls.add(new SelectItem(o,lib));
			}
		}
		return ls;
	}
	/**
	 * @param id
	 * @param ajouterChampVide
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getStatutsJuridiquesFromIdTypeStructure(int id, boolean ajouterChampVide){
		List<SelectItem> ls = new ArrayList<>();
		List<StatutJuridiqueDTO> l = getNomenclatureDomainService().getStatutsJuridiquesFromIdTypeStructure(id);
		for(StatutJuridiqueDTO o : l){
			ls.add(new SelectItem(o,o.getLibelle()));
		}
		return ls;
	}
	/**
	 * Nomenclature dynamique mise à jour en fonction du type de structure
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getStatutsJuridiquesListening(){
		return this.statutsJuridiquesListening;
	}
	/**
	 * Mise à jour de la Nomenclature Statut juridique en fonction de la Nomenclature Type de Structure
	 * @param event
	 */
	public void valueTypeStructureChanged(ValueChangeEvent event){
		if(event.getNewValue() instanceof TypeStructureDTO){
			TypeStructureDTO t = (TypeStructureDTO)event.getNewValue();
			this.statutsJuridiquesListening=getStatutsJuridiquesFromIdTypeStructure(t.getId(), true);
		}else{
			this.statutsJuridiquesListening=null;
		}
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getTempsTravail(){
		List<SelectItem> ls = new ArrayList<>();
		List<TempsTravailDTO> l = getNomenclatureDomainService().getTempsTravail();
		if(l!=null){
			for(TempsTravailDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getTempsTravailEnServ(){
		List<SelectItem> ls = new ArrayList<>();
		List<TempsTravailDTO> l = getNomenclatureDomainService().getTempsTravail();
		if(l!=null){
			for(TempsTravailDTO o : l){
				if ("O".equalsIgnoreCase(o.getTemEnServ())) {
					ls.add(new SelectItem(o, o.getLibelle()));
				}
			}
		}
		return ls;
	}

	/**
	 * @return the themes
	 */
	public List<SelectItem> getThemes() {
		List<SelectItem> ls = new ArrayList<>();
		List<ThemeDTO> l = getNomenclatureDomainService().getThemes();
		if(l!=null){
			for(ThemeDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
			// AJOUT D'UN TRI PAR ORDRE ALPHABETIQUE
			Collections.sort(ls, new Comparator<SelectItem>(){
				@Override
				public int compare(SelectItem e1, SelectItem e2) {
					return ((String)e1.getLabel()).compareTo((String)e2.getLabel());
				}
			});
		}
		return ls;
	}


	/**
	 * @return the typeConventions
	 */
	public List<SelectItem> getTypeConventions() {
		List<SelectItem> ls = new ArrayList<>();
		List<TypeConventionDTO> l = getNomenclatureDomainService().getTypeConventions();
		if(l!=null){
			for(TypeConventionDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return the typeConventions
	 */
	public List<SelectItem> getTypeConventionsFC() {
		List<SelectItem> ls = new ArrayList<>();
		List<TypeConventionDTO> l = getNomenclatureDomainService().getTypeConventions();
		if(l!=null){
			for(TypeConventionDTO t : l){
				if (DonneesStatic.TYPE_CONVENTION_CODE_CTRL_FC.equalsIgnoreCase(t.getCodeCtrl())) {
					ls.add(new SelectItem(t, t.getLibelle()));
				}
			}
		}
		return ls;
	}

	/**
	 * @return the typeConventions
	 */
	public List<SelectItem> getTypeConventionsFI() {
		List<SelectItem> ls = new ArrayList<>();
		List<TypeConventionDTO> l = getNomenclatureDomainService().getTypeConventions();
		if(l!=null){
			for(TypeConventionDTO t : l){
				if (DonneesStatic.TYPE_CONVENTION_CODE_CTRL_FI.equalsIgnoreCase(t.getCodeCtrl()) || DonneesStatic.TYPE_CONVENTION_CODE_CTRL_CESURE.equalsIgnoreCase(t.getCodeCtrl())) {
					ls.add(new SelectItem(t, t.getLibelle()));
				}
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getTypesOffre(){
		List<SelectItem> ls = new ArrayList<>();
		List<TypeOffreDTO> l = getNomenclatureDomainService().getTypesOffre();
		if(l!=null){
			for(TypeOffreDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getTypesOffreEnServ(){
		List<SelectItem> ls = new ArrayList<>();
		List<TypeOffreDTO> l = getNomenclatureDomainService().getTypesOffre();
		if(l!=null){
			for(TypeOffreDTO o : l){
				if ("O".equalsIgnoreCase(o.getTemEnServ())) {
					ls.add(new SelectItem(o, o.getLibelle()));
				}
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getTypesStructureItalic(){
		List<SelectItem> ls = new ArrayList<>();
		List<TypeStructureDTO> l = getNomenclatureDomainService().getTypesStructure();
		if(l!=null){
			for(TypeStructureDTO o : l){
				String lib="";
				lib+=o.getLibelle() + " <i>(SIRET " + (o.isSiretObligatoire() ? "Obligatoire" : "Non obligatoire") + ")</i>";
				ls.add(new SelectItem(o,lib));
			}
		}

		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getTypesStructure(){
		List<SelectItem> ls = new ArrayList<>();
		List<TypeStructureDTO> l = getNomenclatureDomainService().getTypesStructure();
		if(l!=null){
			for(TypeStructureDTO o : l){
				String lib="";
				lib+=o.getLibelle() + " (SIRET " + (o.isSiretObligatoire() ? "Obligatoire" : "Non obligatoire") + ")";
				ls.add(new SelectItem(o,lib));
			}
		}

		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getTypesStructureEnServ(){
		List<SelectItem> ls = new ArrayList<>();
		List<TypeStructureDTO> l = getNomenclatureDomainService().getTypesStructure();
		if(l!=null){
			for(TypeStructureDTO o : l){
				if ("O".equalsIgnoreCase(o.getTemEnServ())) {
					String lib = "";
					lib += o.getLibelle() + " (SIRET " + (o.isSiretObligatoire() ? "Obligatoire" : "Non obligatoire") + ")";
					ls.add(new SelectItem(o, lib));
				}
			}
		}

		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getTypesStructureSansSiret(){
		List<SelectItem> ls = new ArrayList<>();
		List<TypeStructureDTO> l = getNomenclatureDomainService().getTypesStructure();
		if(l!=null){
			for(TypeStructureDTO o : l){
				if ("O".equalsIgnoreCase(o.getTemEnServ())) {
					ls.add(new SelectItem(o, o.getLibelle()));
				}
			}
		}

		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getUnitesDurees(){
		List<SelectItem> ls = new ArrayList<>();
		List<UniteDureeDTO> l = getNomenclatureDomainService().getUnitesDurees();
		if(l!=null){
			for(UniteDureeDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return the UniteGratifications
	 */
	public List<SelectItem> getUniteGratifications() {
		List<SelectItem> ls = new ArrayList<>();
		List<UniteGratificationDTO> l = getNomenclatureDomainService().getUniteGratifications();
		if(l!=null){
			for(UniteGratificationDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return the caisseRegime
	 */
	public CaisseRegimeDTO getCaisseRegime() {
		return caisseRegime;
	}

	/**
	 * @param caisseRegime the caisseRegime to set
	 */
	public void setCaisseRegime(CaisseRegimeDTO caisseRegime) {
		this.caisseRegime = caisseRegime;
		this.codeCaisseRegime = this.caisseRegime.getCode();
	}

	/**
	 * @return the codeCaisseRegime
	 */
	public String getCodeCaisseRegime() {
		return codeCaisseRegime;
	}

	/**
	 * @param codeCaisseRegime the codeCaisseRegime to set
	 */
	public void setCodeCaisseRegime(String codeCaisseRegime) {
		this.codeCaisseRegime = codeCaisseRegime;
	}

	/**
	 * @return the caisseRegimeCurrentPage
	 */
	public String getCaisseRegimeCurrentPage() {
		return caisseRegimeCurrentPage;
	}

	/**
	 * @param caisseRegimeCurrentPage the caisseRegimeCurrentPage to set
	 */
	public void setCaisseRegimeCurrentPage(String caisseRegimeCurrentPage) {
		this.caisseRegimeCurrentPage = caisseRegimeCurrentPage;
	}

	/**
	 * @return the niveauFormationCurrentPage
	 */
	public String getNiveauFormationCurrentPage() {
		return niveauFormationCurrentPage;
	}

	/**
	 * @param niveauFormationCurrentPage the niveauFormationCurrentPage to set
	 */
	public void setNiveauFormationCurrentPage(String niveauFormationCurrentPage) {
		this.niveauFormationCurrentPage = niveauFormationCurrentPage;
	}

	/**
	 * @return the niveauFormation
	 */
	public NiveauFormationDTO getNiveauFormation() {
		return niveauFormation;
	}

	/**
	 * @param niveauFormation the niveauFormation to set
	 */
	public void setNiveauFormation(NiveauFormationDTO niveauFormation) {
		this.niveauFormation = niveauFormation;
	}

	/**
	 * @return the tpsTravail
	 */
	public TempsTravailDTO getTpsTravail() {
		return tpsTravail;
	}

	/**
	 * @param tpsTravail the tpsTravail to set
	 */
	public void setTpsTravail(TempsTravailDTO tpsTravail) {
		this.tpsTravail = tpsTravail;
	}

	/**
	 * @return the origineStage
	 */
	public OrigineStageDTO getOrigineStage() {
		return origineStage;
	}

	/**
	 * @param origineStage the origineStage to set
	 */
	public void setOrigineStage(OrigineStageDTO origineStage) {
		this.origineStage = origineStage;
	}

	/**
	 * @return the typeConvention
	 */
	public TypeConventionDTO getTypeConvention() {
		return typeConvention;
	}

	/**
	 * @param typeConvention the typeConvention to set
	 */
	public void setTypeConvention(TypeConventionDTO typeConvention) {
		this.typeConvention = typeConvention;
	}

	/**
	 * @return the typeStructure
	 */
	public TypeStructureDTO getTypeStructure() {
		return typeStructure;
	}

	/**
	 * @param typeStructure the typeStructure to set
	 */
	public void setTypeStructure(TypeStructureDTO typeStructure) {
		this.typeStructure = typeStructure;
	}

	/**
	 * @return the statutJuridique
	 */
	public StatutJuridiqueDTO getStatutJuridique() {
		return statutJuridique;
	}

	/**
	 * @param statutJuridique the statutJuridique to set
	 */
	public void setStatutJuridique(StatutJuridiqueDTO statutJuridique) {
		this.statutJuridique = statutJuridique;
	}

	/**
	 * @return the typeOffre
	 */
	public TypeOffreDTO getTypeOffre() {
		return typeOffre;
	}

	/**
	 * @param typeOffre the typeOffre to set
	 */
	public void setTypeOffre(TypeOffreDTO typeOffre) {
		this.typeOffre = typeOffre;
	}

	/**
	 * @return the contratOffre
	 */
	public ContratOffreDTO getContratOffre() {
		return contratOffre;
	}

	/**
	 * @param contratOffre the contratOffre to set
	 */
	public void setContratOffre(ContratOffreDTO contratOffre) {
		this.contratOffre = contratOffre;
	}

	/**
	 * @return the effectif
	 */
	public EffectifDTO getEffectif() {
		return effectif;
	}

	/**
	 * @param effectif the effectif to set
	 */
	public void setEffectif(EffectifDTO effectif) {
		this.effectif = effectif;
	}

	/**
	 * @return the tempsTravailCurrentPage
	 */
	public String getTempsTravailCurrentPage() {
		return tempsTravailCurrentPage;
	}

	/**
	 * @param tempsTravailCurrentPage the tempsTravailCurrentPage to set
	 */
	public void setTempsTravailCurrentPage(String tempsTravailCurrentPage) {
		this.tempsTravailCurrentPage = tempsTravailCurrentPage;
	}

	/**
	 * @return the origineStageCurrentPage
	 */
	public String getOrigineStageCurrentPage() {
		return origineStageCurrentPage;
	}

	/**
	 * @param origineStageCurrentPage the origineStageCurrentPage to set
	 */
	public void setOrigineStageCurrentPage(String origineStageCurrentPage) {
		this.origineStageCurrentPage = origineStageCurrentPage;
	}

	/**
	 * @return the typeConventionCurrentPage
	 */
	public String getTypeConventionCurrentPage() {
		return typeConventionCurrentPage;
	}

	/**
	 * @param typeConventionCurrentPage the typeConventionCurrentPage to set
	 */
	public void setTypeConventionCurrentPage(String typeConventionCurrentPage) {
		this.typeConventionCurrentPage = typeConventionCurrentPage;
	}

	/**
	 * @return the typeStructureCurrentPage
	 */
	public String getTypeStructureCurrentPage() {
		return typeStructureCurrentPage;
	}

	/**
	 * @param typeStructureCurrentPage the typeStructureCurrentPage to set
	 */
	public void setTypeStructureCurrentPage(String typeStructureCurrentPage) {
		this.typeStructureCurrentPage = typeStructureCurrentPage;
	}

	/**
	 * @return the statutJuridiqueCurrentPage
	 */
	public String getStatutJuridiqueCurrentPage() {
		return statutJuridiqueCurrentPage;
	}

	/**
	 * @param statutJuridiqueCurrentPage the statutJuridiqueCurrentPage to set
	 */
	public void setStatutJuridiqueCurrentPage(String statutJuridiqueCurrentPage) {
		this.statutJuridiqueCurrentPage = statutJuridiqueCurrentPage;
	}

	/**
	 * @return the typeOffreCurrentPage
	 */
	public String getTypeOffreCurrentPage() {
		return typeOffreCurrentPage;
	}

	/**
	 * @param typeOffreCurrentPage the typeOffreCurrentPage to set
	 */
	public void setTypeOffreCurrentPage(String typeOffreCurrentPage) {
		this.typeOffreCurrentPage = typeOffreCurrentPage;
	}

	/**
	 * @return the contratOffreCurrentPage
	 */
	public String getContratOffreCurrentPage() {
		return contratOffreCurrentPage;
	}

	/**
	 * @param contratOffreCurrentPage the contratOffreCurrentPage to set
	 */
	public void setContratOffreCurrentPage(String contratOffreCurrentPage) {
		this.contratOffreCurrentPage = contratOffreCurrentPage;
	}

	/**
	 * @return the effectifCurrentPage
	 */
	public String getEffectifCurrentPage() {
		return effectifCurrentPage;
	}

	/**
	 * @param effectifCurrentPage the effectifCurrentPage to set
	 */
	public void setEffectifCurrentPage(String effectifCurrentPage) {
		this.effectifCurrentPage = effectifCurrentPage;
	}

	/**
	 * @return the modeValidationStageCurrentPage
	 */
	public String getModeValidationStageCurrentPage() {
		return modeValidationStageCurrentPage;
	}

	/**
	 * @param modeValidationStageCurrentPage the modeValidationStageCurrentPage to set
	 */
	public void setModeValidationStageCurrentPage(
			String modeValidationStageCurrentPage) {
		this.modeValidationStageCurrentPage = modeValidationStageCurrentPage;
	}

	/**
	 * @return the modeValidationStage
	 */
	public ModeValidationStageDTO getModeValidationStage() {
		return modeValidationStage;
	}

	/**
	 * @param modeValidationStage the modeValidationStage to set
	 */
	public void setModeValidationStage(ModeValidationStageDTO modeValidationStage) {
		this.modeValidationStage = modeValidationStage;
	}

	public int getIndexMenu() {
		return indexMenu;
	}

	public void setIndexMenu(int indexMenu) {
		this.indexMenu = indexMenu;
	}



}
