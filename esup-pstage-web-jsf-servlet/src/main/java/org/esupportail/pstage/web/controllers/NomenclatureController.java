/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.remote.AssuranceDTO;
import org.esupportail.pstagedata.remote.CaisseRegimeDTO;
import org.esupportail.pstagedata.remote.CiviliteDTO;
import org.esupportail.pstagedata.remote.ConfidentialiteDTO;
import org.esupportail.pstagedata.remote.ContratOffreDTO;
import org.esupportail.pstagedata.remote.DroitAdministrationDTO;
import org.esupportail.pstagedata.remote.EffectifDTO;
import org.esupportail.pstagedata.remote.FapN1DTO;
import org.esupportail.pstagedata.remote.FapN2DTO;
import org.esupportail.pstagedata.remote.FapN3DTO;
import org.esupportail.pstagedata.remote.FapQualificationDTO;
import org.esupportail.pstagedata.remote.FapQualificationSimplifieeDTO;
import org.esupportail.pstagedata.remote.IndemnisationDTO;
import org.esupportail.pstagedata.remote.LangueConventionDTO;
import org.esupportail.pstagedata.remote.ModeCandidatureDTO;
import org.esupportail.pstagedata.remote.ModeValidationStageDTO;
import org.esupportail.pstagedata.remote.ModeVersGratificationDTO;
import org.esupportail.pstagedata.remote.NafN1DTO;
import org.esupportail.pstagedata.remote.NafN5DTO;
import org.esupportail.pstagedata.remote.NatureTravailDTO;
import org.esupportail.pstagedata.remote.NiveauCentreDTO;
import org.esupportail.pstagedata.remote.NiveauFormationDTO;
import org.esupportail.pstagedata.remote.OrigineStageDTO;
import org.esupportail.pstagedata.remote.PaysDTO;
import org.esupportail.pstagedata.remote.StatutJuridiqueDTO;
import org.esupportail.pstagedata.remote.TempsTravailDTO;
import org.esupportail.pstagedata.remote.ThemeDTO;
import org.esupportail.pstagedata.remote.TypeConventionDTO;
import org.esupportail.pstagedata.remote.TypeOffreDTO;
import org.esupportail.pstagedata.remote.TypeStructureDTO;
import org.esupportail.pstagedata.remote.UniteDureeDTO;
import org.esupportail.pstagedata.remote.UniteGratificationDTO;


/**
 * AccordController
 */
/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
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
	 * Nomenclature des effectifs
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
	private List<SelectItem> statutsJuridiquesListening=null;
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
	
	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getAnneesConvention(){
		List<SelectItem> ls = new ArrayList<SelectItem>();
		List<String> an = getConventionDomainService().getAnneesConvention(getSessionController().getCodeUniversite());
		if(an!=null && !an.isEmpty()){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = new ArrayList<SelectItem>();
		List<String> an = getOffreDomainService().getAnneesUnivOffres();
		if(an!=null && !an.isEmpty()){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<String> l = new ArrayList<String>();
		String cY = Utils.getYear(Utils.getToday());
		int cYi = Utils.convertStringToInt(cY);
		l.add(cY);
		l.add(cYi + 1 +"");
		l.add(cYi + 2 +"");
		l.add(cYi + 3 +"");
		l.add(cYi + 4 +"");
		ls = new ArrayList<SelectItem>();
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
				lib+=o.getLibelle();
				lib+=(o.getInfoCaisse()!=null && !o.getInfoCaisse().isEmpty())?" (" + o.getInfoCaisse() + " )":"";
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
	public List<SelectItem> getContrats(){
		List<SelectItem> ls = null;
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContrats();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(ContratOffreDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @param id 
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getContratOffreFromIdTypeOffre(int id){
		List<SelectItem> ls = null;
		List<ContratOffreDTO> l = getNomenclatureDomainService().getContratsOffreFromIdTypeOffre(id);
		ls = new ArrayList<SelectItem>();
		for(ContratOffreDTO o : l){
			ls.add(new SelectItem(o,o.getLibelle()));
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getDatesStage(){
		List<SelectItem> ls = null;
		ls=new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<DroitAdministrationDTO> l = getNomenclatureDomainService().getDroitsAdmin();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<EffectifDTO> l = getNomenclatureDomainService().getEffectifs();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(EffectifDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapN1(){
		List<SelectItem> ls = null;
		List<FapN1DTO> l = getNomenclatureDomainService().getFapN1();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<FapN2DTO> l = getNomenclatureDomainService().getFapN2();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<FapN2DTO> l = getNomenclatureDomainService().getFapN2FromCodeFapN1(code);
		ls = new ArrayList<SelectItem>();
		for(FapN2DTO o : l){
			ls.add(new SelectItem(o,o.getLibelle()));
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapN3(){
		List<SelectItem> ls = null;
		List<FapN3DTO> l = getNomenclatureDomainService().getFapN3();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<FapN3DTO> l = getNomenclatureDomainService().getFapN3FromCodeFapN2(code);
		ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<FapN3DTO> l = getNomenclatureDomainService().getFapN3FromNumQualif(num);
		ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<FapQualificationDTO> l = getNomenclatureDomainService().getFapQualifications();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<FapQualificationDTO> l = getNomenclatureDomainService().getFapQualificationFromNumQualifSimplifiee(id);
		ls = new ArrayList<SelectItem>();
		for(FapQualificationDTO o : l){
			ls.add(new SelectItem(o,o.getLibelle()));
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getFapQualificationsSimplifiees(){
		List<SelectItem> ls = null;
		List<FapQualificationSimplifieeDTO> l = getNomenclatureDomainService().getFapQualificationsSimplifiees();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<IndemnisationDTO> l = getNomenclatureDomainService().getIndemnisations();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
			List<SelectItem> ls = null;
			List<LangueConventionDTO> l = getNomenclatureDomainService().getLangueConventions();
			if(l!=null){
				ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<ModeCandidatureDTO> l = getNomenclatureDomainService().getModesCandidature();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<ModeValidationStageDTO> l = getNomenclatureDomainService().getModeValidationStages();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(ModeValidationStageDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}


	
	/**
	 * @return the ModeVersGratifications
	 */
	public List<SelectItem> getModeVersGratifications() {
		List<SelectItem> ls = null;
		List<ModeVersGratificationDTO> l = getNomenclatureDomainService().getModeVersGratifications();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<String> l = new ArrayList<String>();
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
		ls = new ArrayList<SelectItem>();
		for(String s : l){
			ls.add(new SelectItem(s,s));
		}
		return ls;
	}
	
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getNafN1(){
		List<SelectItem> ls = null;
		List<NafN1DTO> l = getNomenclatureDomainService().getNafN1();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<NafN5DTO> l = getNomenclatureDomainService().getNafN5();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<NafN5DTO> l = getNomenclatureDomainService().getNafN5FromCodeNafN1(code);
		ls = new ArrayList<SelectItem>();
		for(NafN5DTO o : l){
			ls.add(new SelectItem(o,o.getLibelle()));
		}
		return ls;
	}
	
	/**
	 * @return the NatureTravails
	 */
	public List<SelectItem> getNatureTravails() {
		List<SelectItem> ls = null;
		List<NatureTravailDTO> l = getNomenclatureDomainService().getNatureTravails();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<NiveauCentreDTO> l = getNomenclatureDomainService().getNiveauxCentre();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<NiveauFormationDTO> l = getNomenclatureDomainService().getNiveauxFormation();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(NiveauFormationDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	
	/**
	 * @return the origineStages
	 */
	public List<SelectItem> getOrigineStages() {
		List<SelectItem> ls = null;
		List<OrigineStageDTO> l = getNomenclatureDomainService().getOrigineStages();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(OrigineStageDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getPays(){
		List<SelectItem> ls = null;
		List<PaysDTO> l = getNomenclatureDomainService().getPays();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<StatutJuridiqueDTO> l = getNomenclatureDomainService().getStatutsJuridiques();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(StatutJuridiqueDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
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
		List<SelectItem> ls = null;
		List<StatutJuridiqueDTO> l = getNomenclatureDomainService().getStatutsJuridiquesFromIdTypeStructure(id);
		ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<TempsTravailDTO> l = getNomenclatureDomainService().getTempsTravail();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(TempsTravailDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	

	/**
	 * @return the themes
	 */
	public List<SelectItem> getThemes() {
		List<SelectItem> ls = null;
		List<ThemeDTO> l = getNomenclatureDomainService().getThemes();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(ThemeDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	

	/**
	 * @return the typeConventions
	 */
	public List<SelectItem> getTypeConventions() {
		List<SelectItem> ls = null;
		List<TypeConventionDTO> l = getNomenclatureDomainService().getTypeConventions();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(TypeConventionDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}

	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getTypesOffre(){
		List<SelectItem> ls = null;
		List<TypeOffreDTO> l = getNomenclatureDomainService().getTypesOffre();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(TypeOffreDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getTypesStructure(){
		List<SelectItem> ls = null;
		List<TypeStructureDTO> l = getNomenclatureDomainService().getTypesStructure();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(TypeStructureDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	/**
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getUnitesDurees(){
		List<SelectItem> ls = null;
		List<UniteDureeDTO> l = getNomenclatureDomainService().getUnitesDurees();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
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
		List<SelectItem> ls = null;
		List<UniteGratificationDTO> l = getNomenclatureDomainService().getUniteGratifications();
		if(l!=null){
			ls = new ArrayList<SelectItem>();
			for(UniteGratificationDTO o : l){
				ls.add(new SelectItem(o,o.getLibelle()));
			}
		}
		return ls;
	}
	
}
