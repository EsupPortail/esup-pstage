package org.esupportail.pstage.web.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstage.web.beans.ConventionColonneEnum;
import org.esupportail.pstage.web.beans.ConventionEntrepriseColonneEnum;
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
	 * Type ou statut structure sélectionné pour la recherche.
	 */
	private String rechTypeOuStatut;
	
	/**
	 * 1 = Oui.
	 * 2 = Non
	 * null = Les 2
	 */
	private String estValidee = null;
	
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
	 * @return String
	 */
	public String rechercherConvention() {
		String ret = null;
		this.critereRechercheConvention.setIdsCentreGestion(getSessionController().getCurrentIdsCentresGestion());
		if (logger.isDebugEnabled()) {
			logger.debug("ExportController:: limit : " + this.critereRechercheConvention.isLimit());
		}
		if (!StringUtils.hasText(this.critereRechercheConvention.getNomEtudiant())) {
			if (StringUtils.hasText(this.critereRechercheConvention.getPrenomEtudiant())) {
				addErrorMessage("formRechConvention", "RECHERCHECONVENTION.NOM.OBLIGATOIRE");
				return ret;
			}
		}
		//au moins le critère annee doit etre saisi
		if (!StringUtils.hasText(this.critereRechercheConvention.getIdConvention()) 
			&& !StringUtils.hasText(this.critereRechercheConvention.getNumeroEtudiant()) 
			&& !StringUtils.hasText(this.critereRechercheConvention.getNomEtudiant())
			&& !StringUtils.hasText(this.critereRechercheConvention.getPrenomEtudiant())) {
			if (!StringUtils.hasText(this.critereRechercheConvention.getAnneeUniversitaire())) {
				addErrorMessage("formRechConvention", "RECHERCHECONVENTION.ANNEEU.OBLIGATOIRE");
				return ret;
			}
		}
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
		else if (this.estValidee.equals("1"))	this.critereRechercheConvention.setEstValidee(true);
		else if (this.estValidee.equals("2"))	this.critereRechercheConvention.setEstValidee(false);
		//this.critereRechercheConvention.setLimit(true);
		
		this.critereRechercheConvention.setNbExportMaxi(Integer.toString(DonneesStatic.NB_RESPONSE_EXPORT_MAXI));
		if (logger.isInfoEnabled()) {
			logger.info("ExportController:: Appel getConventionsFromCriteresExport debut ");
		}
		// si enseignant tuteur, recherche des conventions pour les enseignants tuteur
		if (getSessionController().isEnseignantTuteur()) {
			if (this.getSessionController().getCurrentAuthEnseignant().getUidEnseignant() != null) {
				EnseignantDTO tmpEns = getEnseignantDomainService().getEnseignantFromUid(this.getSessionController().getCurrentAuthEnseignant().getUidEnseignant(),
						getSessionController().getCodeUniversite());
				if (tmpEns != null) {
					this.resultatsRechercheConvention = getConventionDomainService().getConventionsFromCriteresByEnseignantTuteur(tmpEns.getId(),this.critereRechercheConvention);
				}			
			}
			// recherche aussi avec critere CG
			if (this.critereRechercheConvention.getIdsCentreGestion() != null) {
				List<ConventionDTO> resultatsRechercheConventionCG = getConventionDomainService().getConventionsFromCriteresExport(this.critereRechercheConvention);
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
			this.resultatsRechercheConvention = getConventionDomainService().getConventionsFromCriteresExport(this.critereRechercheConvention);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("ExportController:: Appel getConventionsFromCriteresExport fin ");
		}
		if (this.resultatsRechercheConvention == null || this.resultatsRechercheConvention.isEmpty()) {
			this.resultatsRechercheConvention = null;
			addInfoMessage("formRechConvention", "RECHERCHECONVENTION.AUCUNRESULTAT");
		} else if (this.resultatsRechercheConvention != null && !this.resultatsRechercheConvention.isEmpty()) {
			if (logger.isDebugEnabled()) {
				logger.debug("ExportController:: nombre convention : " + this.resultatsRechercheConvention.size());
			}
			if (this.resultatsRechercheConvention.size() > DonneesStatic.NB_RESPONSE_EXPORT_MAXI) {
				addInfoMessage("formRechConvention", "RECHERCHECONVENTION.MAXRESULTATS",this.resultatsRechercheConvention.size());
				return ret;
			}
			if (logger.isInfoEnabled()) {
				logger.info("ExportController:: Appel getConventionFromExport debut ");
			}
			if (this.resultatsRechercheConvention != null && !this.resultatsRechercheConvention.isEmpty()) {
				List<ConventionDTO> lConventionExport = new ArrayList<ConventionDTO>();
				for (ConventionDTO c : resultatsRechercheConvention) {
					c = getConventionDomainService().getConventionFromExport(c.getIdConvention());
					lConventionExport.add(c);
				}
				this.resultatsRechercheConvention = lConventionExport;
				//exportConvention();
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
	 * @return String
	 */
	public String goToChoixExportConventionTuteur() {
		String ret = null;
		List<ConventionDTO> lConventionExport = new ArrayList<ConventionDTO>();
		if (this.resultatsRechercheConvention != null && !this.resultatsRechercheConvention.isEmpty()) {
			for (ConventionDTO c : resultatsRechercheConvention) {
				c = getConventionDomainService().getConventionFromExport(c.getIdConvention());
				lConventionExport.add(c);
			}
			this.resultatsRechercheConvention = lConventionExport;
			//exportConvention();
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
		if (this.resultatsRechercheConvention != null && !this.resultatsRechercheConvention.isEmpty()) {
			exportConvention();
		}
		return ret;
	}
	
	/**
	 * 
	 */
	public void exportConvention() {

		//to get xls 
		String typeExport = "xls";
		String fileName = "conventions" + "." + typeExport;
		List<ConventionDTO> conventions = new ArrayList<ConventionDTO>();
		List<String> colonnesChoisies = new ArrayList<String>();
		conventions = this.resultatsRechercheConvention;
		if (this.conventionColonnesChoisies != null && !this.conventionColonnesChoisies.isEmpty()) {
			for (String c : this.conventionColonnesChoisies) {
				colonnesChoisies.add(getString(c));
			}
		} 
		if (this.conventionEntrepriseColonnesChoisies != null 
				&& !this.conventionEntrepriseColonnesChoisies.isEmpty()) {
			for (String c : this.conventionEntrepriseColonnesChoisies) {
				colonnesChoisies.add(getString(c));
			}
		} 
		
		
		getFileGeneratorService().conventionFile(conventions, typeExport, fileName, colonnesChoisies);
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
		
		for (ConventionEntrepriseColonneEnum s : ConventionEntrepriseColonneEnum.values()) {
			
			ls.add(new SelectItem(s.getKeyLabel(), getString(s.getKeyLabel())));
		}
		return ls;
	}
	
	
	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/
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
	 * @return the critereRechercheConvention
	 */
	public CritereRechercheConventionDTO getCritereRechercheConvention() {
		return critereRechercheConvention;
	}


	/**
	 * @param critereRechercheConvention the critereRechercheConvention to set
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
	 * @param rechTypesStatutsStructure the rechTypesStatutsStructure to set
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
	 * @param rechTypeOuStatut the rechTypeOuStatut to set
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
	 * @param estValidee the estValidee to set
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
	 * @param conventionColonnesChoisies the conventionColonnesChoisies to set
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
	 * @param conventionEntrepriseColonnesChoisies the conventionEntrepriseColonnesChoisies to set
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
	 * @param conventionColonnesChoisiesItem the conventionColonnesChoisiesItem to set
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
	 * @param conventionEntrepriseColonnesChoisiesItem the conventionEntrepriseColonnesChoisiesItem to set
	 */
	public void setConventionEntrepriseColonnesChoisiesItem(
			List<SelectItem> conventionEntrepriseColonnesChoisiesItem) {
		this.conventionEntrepriseColonnesChoisiesItem = conventionEntrepriseColonnesChoisiesItem;
	}


	
}
