/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.esupportail.commons.annotations.cache.SessionCache;
import org.esupportail.pstagedata.domain.dto.AffectationDTO;
import org.esupportail.pstagedata.domain.dto.AssuranceDTO;
import org.esupportail.pstagedata.domain.dto.CaisseRegimeDTO;
import org.esupportail.pstagedata.domain.dto.CiviliteDTO;
import org.esupportail.pstagedata.domain.dto.ConfidentialiteDTO;
import org.esupportail.pstagedata.domain.dto.ContratOffreDTO;
import org.esupportail.pstagedata.domain.dto.CritereGestionDTO;
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
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.esupportail.pstagedata.remote.RemoteServices;

/**
 * The NomenclatureDomainService service impl.
 */
public class NomenclatureDomainServiceImpl implements Serializable, NomenclatureDomainService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * RemoteServices
	 */
	private RemoteServices remoteServices;
	
	/**
	 * @return the remoteServices
	 */
	public RemoteServices getRemoteServices() {
		return remoteServices;
	}

	/**
	 * @param remoteServices the remoteServices to set
	 */
	public void setRemoteServices(RemoteServices remoteServices) {
		this.remoteServices = remoteServices;
	}

	/* ****************************************************************************
	 * AJOUTS/UPDATES/SUPPRESSIONS
	 *****************************************************************************/
	@Override
	public int addCaisseRegime(CaisseRegimeDTO cr) throws DataAddException, WebServiceDataBaseException{
		return this.remoteServices.addCaisseRegime(cr);
	}
	
	@Override
	public boolean updateCaisseRegime(CaisseRegimeDTO cr,String codeCaisse) throws DataUpdateException, WebServiceDataBaseException{
		return this.remoteServices.updateCaisseRegime(cr, codeCaisse);
	}

	@Override
	public boolean deleteCaisseRegime(String codeCaisse) throws DataDeleteException, WebServiceDataBaseException{
		return this.remoteServices.deleteCaisseRegime(codeCaisse);	
	}
	@Override
	public int addNiveauFormation(NiveauFormationDTO nf)
			throws DataAddException, WebServiceDataBaseException {
		return this.remoteServices.addNiveauFormation(nf);
	}

	@Override
	public boolean updateNiveauFormation(NiveauFormationDTO nf)
			throws DataUpdateException, WebServiceDataBaseException {
		return this.remoteServices.updateNiveauFormation(nf);
	}

	@Override
	public boolean deleteNiveauFormation(int id) throws DataDeleteException,
			WebServiceDataBaseException {
		return this.remoteServices.deleteNiveauFormation(id);
	}

	@Override
	public int addEffectif(EffectifDTO ef) throws DataAddException,
			WebServiceDataBaseException {
		return this.remoteServices.addEffectif(ef);
	}

	@Override
	public boolean updateEffectif(EffectifDTO ef) throws DataUpdateException,
			WebServiceDataBaseException {
		return this.remoteServices.updateEffectif(ef);
	}

	@Override
	public boolean deleteEffectif(int id) throws DataDeleteException,
			WebServiceDataBaseException {
		return this.remoteServices.deleteEffectif(id);
	}

	@Override
	public int addTempsTravail(TempsTravailDTO tt) throws DataAddException,
			WebServiceDataBaseException {
		return this.remoteServices.addTempsTravail(tt);
	}

	@Override
	public boolean updateTempsTravail(TempsTravailDTO tt)
			throws DataUpdateException, WebServiceDataBaseException {
		return this.remoteServices.updateTempsTravail(tt);
	}

	@Override
	public boolean deleteTempsTravail(int id) throws DataDeleteException,
			WebServiceDataBaseException {
		return this.remoteServices.deleteTempsTravail(id);
	}

	@Override
	public int addOrigineStage(OrigineStageDTO os) throws DataAddException,
			WebServiceDataBaseException {
		return this.remoteServices.addOrigineStage(os);
	}

	@Override
	public boolean updateOrigineStage(OrigineStageDTO os)
			throws DataUpdateException, WebServiceDataBaseException {
		return this.remoteServices.updateOrigineStage(os);
	}

	@Override
	public boolean deleteOrigineStage(int id) throws DataDeleteException,
			WebServiceDataBaseException {
		return this.remoteServices.deleteOrigineStage(id);
	}

	@Override
	public int addTypeConvention(TypeConventionDTO tc) throws DataAddException,
			WebServiceDataBaseException {
		return this.remoteServices.addTypeConvention(tc);
	}

	@Override
	public boolean updateTypeConvention(TypeConventionDTO tc)
			throws DataUpdateException, WebServiceDataBaseException {
		return this.remoteServices.updateTypeConvention(tc);
	}

	@Override
	public boolean deleteTypeConvention(int id) throws DataDeleteException,
			WebServiceDataBaseException {
		return this.remoteServices.deleteTypeConvention(id);
	}

	@Override
	public int addTypeStructure(TypeStructureDTO ts) throws DataAddException,
			WebServiceDataBaseException {
		return this.remoteServices.addTypeStructure(ts);
	}

	@Override
	public boolean updateTypeStructure(TypeStructureDTO ts)
			throws DataUpdateException, WebServiceDataBaseException {
		return this.remoteServices.updateTypeStructure(ts);
	}

	@Override
	public boolean deleteTypeStructure(int id) throws DataDeleteException,
			WebServiceDataBaseException {
		return this.remoteServices.deleteTypeStructure(id);
	}

	@Override
	public int addStatutJuridique(StatutJuridiqueDTO sj)
			throws DataAddException, WebServiceDataBaseException {
		return this.remoteServices.addStatutJuridique(sj);
	}

	@Override
	public boolean updateStatutJuridique(StatutJuridiqueDTO sj)
			throws DataUpdateException, WebServiceDataBaseException {
		return this.remoteServices.updateStatutJuridique(sj);
	}

	@Override
	public boolean deleteStatutJuridique(int id) throws DataDeleteException,
			WebServiceDataBaseException {
		return this.remoteServices.deleteStatutJuridique(id);
	}

	@Override
	public int addTypeOffre(TypeOffreDTO to) throws DataAddException,
			WebServiceDataBaseException {
		return this.remoteServices.addTypeOffre(to);
	}

	@Override
	public boolean updateTypeOffre(TypeOffreDTO to) throws DataUpdateException,
			WebServiceDataBaseException {
		return this.remoteServices.updateTypeOffre(to);
	}

	@Override
	public boolean deleteTypeOffre(int id) throws DataDeleteException,
			WebServiceDataBaseException {
		return this.remoteServices.deleteTypeOffre(id);
	}

	@Override
	public int addContratOffre(ContratOffreDTO co) throws DataAddException,
			WebServiceDataBaseException {
		return this.remoteServices.addContratOffre(co);
	}

	@Override
	public boolean updateContratOffre(ContratOffreDTO co)
			throws DataUpdateException, WebServiceDataBaseException {
		return this.remoteServices.updateContratOffre(co);
	}

	@Override
	public boolean deleteContratOffre(int id) throws DataDeleteException,
			WebServiceDataBaseException {
		return this.remoteServices.deleteContratOffre(id);
	}
	@Override
	public int addModeValidationStage(ModeValidationStageDTO mv)
			throws DataAddException, WebServiceDataBaseException {
		return this.remoteServices.addModeValidationStage(mv);
	}

	@Override
	public boolean updateModeValidationStage(ModeValidationStageDTO mv)
			throws DataUpdateException, WebServiceDataBaseException {
		return this.remoteServices.updateModeValidationStage(mv);
	}

	@Override
	public boolean deleteModeValidationStage(int id) throws DataDeleteException,
			WebServiceDataBaseException {
		return this.remoteServices.deleteModeValidationStage(id);
	}
	/* ****************************************************************************
	 * AFFECTATION
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getAffectations(java.lang.String)
	 */
	public List<AffectationDTO> getAffectations(String codeUniversite){
		return this.remoteServices.getAffectationFromCodUniv(codeUniversite);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getAffectationFromCode(java.lang.String, java.lang.String)
	 */
	public AffectationDTO getAffectationFromCode(String code, String codeUniversite){
		AffectationDTO a = null;
		for(AffectationDTO af : getAffectations(codeUniversite)){
			if(af.getCode().equalsIgnoreCase(code)){
				a=af;
				break;
			}
		}
		return a;
	}
	
	
	/* ****************************************************************************
	 * Assurance
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getAssurances()
	 */
	@SessionCache
	public List<AssuranceDTO> getAssurances() {
		return this.remoteServices.getAssurances();
	}

	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getAssuranceDTOFromId(int)
	 */

	public AssuranceDTO getAssuranceDTOFromId(int id) {
		AssuranceDTO o = null;
		for(AssuranceDTO oo : getAssurances()){
			if(oo.getId()==(id)){
				o=oo;
				break;
			}
		}
		return o;
	}
	
	
	/* ****************************************************************************
	 * CaisseRegime
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getCaisseRegimes()
	 */
	public List<CaisseRegimeDTO> getCaisseRegimes() {
		return this.remoteServices.getCaisseRegimes();
	}
	

	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getCaisseRegimeDTOFromId(java.lang.String)
	 */
	public CaisseRegimeDTO getCaisseRegimeDTOFromId(String code) {
		CaisseRegimeDTO o = null;
		for(CaisseRegimeDTO oo : getCaisseRegimes()){
			if(oo.getCode().equalsIgnoreCase(code)){
				o=oo;
				break;
			}
		}
		return o;
	}
	
	/* ****************************************************************************
	 * CIVILITE
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getCivilites()
	 */
	@SessionCache
	public List<CiviliteDTO> getCivilites(){
		return this.remoteServices.getCivilites();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getCiviliteFromId(int)
	 */
	public CiviliteDTO getCiviliteFromId(int id){
		CiviliteDTO c = null;
		for(CiviliteDTO cf : getCivilites()){
			if(cf.getId()==id){
				c=cf;
				break;
			}
		}
		return c;
	}
	
	/* ****************************************************************************
	 * CONFIDENTIALITE
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getConfidentialites()
	 */
	@SessionCache
	public List<ConfidentialiteDTO> getConfidentialites(){
		return this.remoteServices.getConfidentialite();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getConfidentialiteFromCode(String)
	 */
	public ConfidentialiteDTO getConfidentialiteFromCode(String code){
		ConfidentialiteDTO c = null;
		for(ConfidentialiteDTO cf : getConfidentialites()){
			if(cf.getCode().equalsIgnoreCase(code)){
				c=cf;
				break;
			}
		}
		return c;
	}
	
	/* ****************************************************************************
	 * CONTRAT
	 *****************************************************************************/
	
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getContrats()
	 */
	public List<ContratOffreDTO> getContrats(){
		List<ContratOffreDTO> list = this.remoteServices.getContrats();
		for (ContratOffreDTO contrat : list){
			contrat.setTypeOffre(getTypeOffreFromId(contrat.getIdParent()));
		}
		return list;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getContratOffreFromId(int)
	 */
	public ContratOffreDTO getContratOffreFromId(int id){
		ContratOffreDTO c = null;
		for(ContratOffreDTO cf : getContrats()){
			if(cf.getId()==id){
				c=cf;
				break;
			}
		}
		return c;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getContratsOffreFromIdTypeOffre(int)
	 */
	public List<ContratOffreDTO> getContratsOffreFromIdTypeOffre(int id){
		List<ContratOffreDTO> l = null;
		if(id>0){
			l = new ArrayList<ContratOffreDTO>();
			for(ContratOffreDTO ff : getContrats()){
				if(ff.getIdParent()==id){
					l.add(ff);
				}
			}
			if(l.isEmpty()){
				l=null;
			}
		}
		return l;
	}
	
	/* ****************************************************************************
	 * CRITERE GESTION
	 *****************************************************************************/
	
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getCriteresGestion()
	 */
	public List<CritereGestionDTO> getCriteresGestion(){
		return this.remoteServices.getCritereGestion();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getCritereGestionFromIdCentre(int)
	 */
	public List<CritereGestionDTO> getCritereGestionFromIdCentre(int idCentreGestion){
		List<CritereGestionDTO> l = null;
		if(idCentreGestion>0){
			l = new ArrayList<CritereGestionDTO>();
			for(CritereGestionDTO cd : getCriteresGestion()){
				if(cd.getIdCentreGestion()==idCentreGestion){
					l.add(cd);
				}
			}
			if(l.isEmpty()){
				l=null;
			}
		}
		return l;
	}
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getCritereGestionFromCode(String)
	 */
	public CritereGestionDTO getCritereGestionFromCode(String code){
		CritereGestionDTO c = null;
		for(CritereGestionDTO cd : getCriteresGestion()){
			if(cd.getCode().equals(code)){
				c = cd;
				break;
			}
		}
		return c;
	}
	/* ****************************************************************************
	 * DROITS ADMINISTRATION
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getDroitsAdmin()
	 */
	@SessionCache
	public List<DroitAdministrationDTO> getDroitsAdmin(){
		return this.remoteServices.getDroitAdministration();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getDroitAdministrationFromId(int)
	 */
	public DroitAdministrationDTO getDroitAdministrationFromId(int idDroitAdmin){
		DroitAdministrationDTO d = null;
		for(DroitAdministrationDTO df : getDroitsAdmin()){
			if(df.getId()==idDroitAdmin){
				d=df;
				break;
			}
		}
		return d;
	}
	
	/* ****************************************************************************
	 * EFFECTIF
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getEffectifs()
	 */
	public List<EffectifDTO> getEffectifs(){
		return this.remoteServices.getEffectifs();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getEffectifFromId(int)
	 */
	public EffectifDTO getEffectifFromId(int id){
		EffectifDTO e = null;
		for(EffectifDTO ef : getEffectifs()){
			if(ef.getId()==id){
				e=ef;
				break;
			}
		}
		return e;
	}
	
	/* ****************************************************************************
	 * FAPN1
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapN1()
	 */
	@SessionCache
	public List<FapN1DTO> getFapN1(){
		List<FapN1DTO> l = this.remoteServices.getFapN1();
		if(l!=null && !l.isEmpty()){
			Collections.sort(l, new Comparator<FapN1DTO>(){
				/**
				 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
				 */
				@Override
				public int compare(FapN1DTO l1, FapN1DTO l2) {
					return l1.getLibelle().compareToIgnoreCase(l2.getLibelle());
				}
			});
		}
		return l;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapN1FromCode(java.lang.String)
	 */
	public FapN1DTO getFapN1FromCode(String code){
		FapN1DTO f = null;
		for(FapN1DTO ff : getFapN1()){
			if(ff.getCode().equalsIgnoreCase(code)){
				f=ff;
				break;
			}
		}
		return f;
	}
	/* ****************************************************************************
	 * FAPN2
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapN2()
	 */
	@SessionCache
	public List<FapN2DTO> getFapN2(){
		List<FapN2DTO> l = this.remoteServices.getFapN2();
		if(l!=null && !l.isEmpty()){
			Collections.sort(l, new Comparator<FapN2DTO>(){
				/**
				 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
				 */
				@Override
				public int compare(FapN2DTO l1, FapN2DTO l2) {
					return l1.getLibelle().compareToIgnoreCase(l2.getLibelle());
				}
			});
		}
		return l;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapN2FromCode(java.lang.String)
	 */
	public FapN2DTO getFapN2FromCode(String code){
		FapN2DTO f = null;
		for(FapN2DTO ff : getFapN2()){
			if(ff.getCode().equalsIgnoreCase(code)){
				f=ff;
				break;
			}
		}
		return f;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapN2FromCodeFapN1(java.lang.String)
	 */
	public List<FapN2DTO> getFapN2FromCodeFapN1(String code){
		List<FapN2DTO> l = null;
		if(code!=null){
			l = new ArrayList<FapN2DTO>();
			for(FapN2DTO ff : getFapN2()){
				if(ff.getCodeParent().equalsIgnoreCase(code)){
					l.add(ff);
				}
			}
			if(l.isEmpty()){
				l=null;
			}else{
				Collections.sort(l, new Comparator<FapN2DTO>(){
					/**
					 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
					 */
					@Override
					public int compare(FapN2DTO l1, FapN2DTO l2) {
						return l1.getLibelle().compareToIgnoreCase(l2.getLibelle());
					}
				});
			}
		}
		return l;
	}
	/* ****************************************************************************
	 * FAPN3
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapN3()
	 */
	@SessionCache
	public List<FapN3DTO> getFapN3(){
		List<FapN3DTO> l = this.remoteServices.getFapN3();
		if(l!=null && !l.isEmpty()){
			Collections.sort(l, new Comparator<FapN3DTO>(){
				/**
				 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
				 */
				@Override
				public int compare(FapN3DTO l1, FapN3DTO l2) {
					return l1.getLibelle().compareToIgnoreCase(l2.getLibelle());
				}
			});
		}
		return l;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapN3FromCode(java.lang.String)
	 */
	public FapN3DTO getFapN3FromCode(String code){
		FapN3DTO f = null;
		for(FapN3DTO ff : getFapN3()){
			if(ff.getCode().equalsIgnoreCase(code)){
				f=ff;
				break;
			}
		}
		return f;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapN3FromCodeFapN2(java.lang.String)
	 */
	public List<FapN3DTO> getFapN3FromCodeFapN2(String code){
		List<FapN3DTO> l = null;
		if(code!=null){
			l = new ArrayList<FapN3DTO>();
			for(FapN3DTO ff : getFapN3()){
				if(ff.getCodeParent().equalsIgnoreCase(code)){
					l.add(ff);
				}
			}
			if(l.isEmpty()){
				l=null;
			}else{
				Collections.sort(l, new Comparator<FapN3DTO>(){
					/**
					 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
					 */
					@Override
					public int compare(FapN3DTO l1, FapN3DTO l2) {
						return l1.getLibelle().compareToIgnoreCase(l2.getLibelle());
					}
				});
			}
		}
		return l;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapN3FromNumQualif(int)
	 */
	public List<FapN3DTO> getFapN3FromNumQualif(int num){
		List<FapN3DTO> l = null;
		if(num>0){
			l = new ArrayList<FapN3DTO>();
			for(FapN3DTO ff : getFapN3()){
				if(ff.getNumQualification()==num){
					l.add(ff);
				}
			}
			if(l.isEmpty()){
				l=null;
			}else{
				Collections.sort(l, new Comparator<FapN3DTO>(){
					/**
					 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
					 */
					@Override
					public int compare(FapN3DTO l1, FapN3DTO l2) {
						return l1.getLibelle().compareToIgnoreCase(l2.getLibelle());
					}
				});
			}
		}
		return l;
	}
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapN3FromNumQualifSimplifiee(int)
	 */
	public List<FapN3DTO> getFapN3FromNumQualifSimplifiee(int num){
		List<FapN3DTO> l = null;
		if(num>0){
			List<FapQualificationDTO> lf = getFapQualificationFromNumQualifSimplifiee(num);
			l = new ArrayList<FapN3DTO>();
			for(FapQualificationDTO fq : lf){
				List<FapN3DTO> lTmp = getFapN3FromNumQualif(fq.getId());
				if(lTmp!=null &&!lTmp.isEmpty())l.addAll(lTmp);
			}
			if(l.isEmpty()){
				l=null;
			}else{
				Collections.sort(l, new Comparator<FapN3DTO>(){
					/**
					 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
					 */
					@Override
					public int compare(FapN3DTO o1, FapN3DTO o2) {
						return o1.getLibelle().compareTo(o2.getLibelle());
					}				
				});
			}
		}
		return l;
	}	
	/* ****************************************************************************
	 * FAP QUALIFICATION
	 *****************************************************************************/	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapQualifications()
	 */
	@SessionCache
	public List<FapQualificationDTO> getFapQualifications(){
		return this.remoteServices.getFapQualifications();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapQualificationFromId(int)
	 */
	public FapQualificationDTO getFapQualificationFromId(int id){
		FapQualificationDTO f = null;
		for(FapQualificationDTO ff : getFapQualifications()){
			if(ff.getId()==id){
				f=ff;
				break;
			}
		}
		return f;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapQualificationFromNumQualifSimplifiee(int)
	 */
	public List<FapQualificationDTO> getFapQualificationFromNumQualifSimplifiee(int id){
		List<FapQualificationDTO> l = null;
		if(id>0){
			l = new ArrayList<FapQualificationDTO>();
			for(FapQualificationDTO ff : getFapQualifications()){
				if(ff.getIdParent()==id){
					l.add(ff);
				}
			}
			if(l.isEmpty()){
				l=null;
			}
		}
		return l;
	}
	/* ****************************************************************************
	 * FAP QUALIFICATION SIMPLIFIEE
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapQualificationsSimplifiees()
	 */
	@SessionCache
	public List<FapQualificationSimplifieeDTO> getFapQualificationsSimplifiees(){
		return this.remoteServices.getFapQualificationsSimplifiees();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getFapQualificationSimplifieeFromId(int)
	 */
	public FapQualificationSimplifieeDTO getFapQualificationSimplifieeFromId(int id){
		FapQualificationSimplifieeDTO f = null;
		for(FapQualificationSimplifieeDTO ff : getFapQualificationsSimplifiees()){
			if(ff.getId()==id){
				f=ff;
				break;
			}
		}
		return f;
	}
	
	/* ****************************************************************************
	 * Indemnisation
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getIndemnisations()
	 */
	@SessionCache
	public List<IndemnisationDTO> getIndemnisations() {
		return this.remoteServices.getIndemnisations();
	}

	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getIndemnisationDTOFromId(int)
	 */
	public IndemnisationDTO getIndemnisationDTOFromId(int id) {
		IndemnisationDTO o = null;
		for(IndemnisationDTO oo : getIndemnisations()){
			if(oo.getId()==(id)){
				o=oo;
				break;
			}
		}
		return o;
	}
	

	
	/* ****************************************************************************
	 * LangueConvention
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getLangueConventions()
	 */
	@SessionCache
	public List<LangueConventionDTO> getLangueConventions() {
		return this.remoteServices.getLangueConventions();
	}

	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getLangueConventionDTOFromId(java.lang.String)
	 */
	public LangueConventionDTO getLangueConventionDTOFromId(String code) {
		LangueConventionDTO o = null;
		for(LangueConventionDTO oo : getLangueConventions()){
			if(oo.getCode().equalsIgnoreCase(code)){
				o=oo;
				break;
			}
		}
		return o;
	}
	
	/* ****************************************************************************
	 * MODE CANDIDATURE
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getModesCandidature()
	 */
	@SessionCache
	public List<ModeCandidatureDTO> getModesCandidature(){
		return this.remoteServices.getModesCandidature();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getModeCandidatureFromId(int)
	 */
	public ModeCandidatureDTO getModeCandidatureFromId(int id){
		ModeCandidatureDTO m = null;
		for(ModeCandidatureDTO mm : getModesCandidature()){
			if(mm.getId()==id){
				m=mm;
				break;
			}
		}
		return m;
	}
	

	/* ****************************************************************************
	 * ModeValidationStage
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getModeValidationStages()
	 */
	public List<ModeValidationStageDTO> getModeValidationStages() {
		return this.remoteServices.getModeValidationStages();
	}

	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getModeValidationStageDTOFromId(int)
	 */
	public ModeValidationStageDTO getModeValidationStageDTOFromId(int id) {
		ModeValidationStageDTO o = null;
		for(ModeValidationStageDTO oo : getModeValidationStages()){
			if(oo.getId()==(id)){
				o=oo;
				break;
			}
		}
		return o;
	}

	/* ****************************************************************************
	 * ModeVersGratification
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getModeVersGratifications()
	 */
	@SessionCache
	public List<ModeVersGratificationDTO> getModeVersGratifications() {
		return this.remoteServices.getModeVersGratifications();
	}
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getModeVersGratificationDTOFromId(int)
	 */
	public ModeVersGratificationDTO getModeVersGratificationDTOFromId(int id) {
		ModeVersGratificationDTO o = null;
		for(ModeVersGratificationDTO oo : getModeVersGratifications()){
			if(oo.getId()==(id)){
				o=oo;
				break;
			}
		}
		return o;
	}

	
	/* ****************************************************************************
	 * NAFN1
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNafN1()
	 */
	@SessionCache
	public List<NafN1DTO> getNafN1(){
		List<NafN1DTO> l = this.remoteServices.getNafN1();
		if(l!=null &&!l.isEmpty()){
			Collections.sort(l, new Comparator<NafN1DTO>(){
				/**
				 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
				 */
				@Override
				public int compare(NafN1DTO n1, NafN1DTO n2) {
					return n1.getLibelle().compareToIgnoreCase(n2.getLibelle());
				}
			});
		}
		return l;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNafN1FromCode(java.lang.String)
	 */
	public NafN1DTO getNafN1FromCode(String code){
		NafN1DTO n = null;
		for(NafN1DTO nn : getNafN1()){
			if(nn.getCode().equalsIgnoreCase(code)){
				n=nn;
				break;
			}
		}
		return n;
	}
	/* ****************************************************************************
	 * NAFN5
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNafN5()
	 */
	@SessionCache
	public List<NafN5DTO> getNafN5(){
		return this.remoteServices.getNafN5();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNafN5FromCode(java.lang.String)
	 */
	public NafN5DTO getNafN5FromCode(String code){
		NafN5DTO n = null;
		for(NafN5DTO nn : getNafN5()){
			if(nn.getCode().equalsIgnoreCase(code)){
				n=nn;
				break;
			}
		}
		return n;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNafN5FromCodeNafN1(java.lang.String)
	 */
	public List<NafN5DTO> getNafN5FromCodeNafN1(String code){
		List<NafN5DTO> l = null;
		if(code!=null){
			l = new ArrayList<NafN5DTO>();
			for(NafN5DTO ff : getNafN5()){
				if(ff.getCodeParent().equalsIgnoreCase(code)){
					l.add(ff);
				}
			}
			if(l.isEmpty()){
				l=null;
			}
		}
		return l;
	}
	

	/* ****************************************************************************
	 * NatureTravail
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNatureTravails()
	 */
	@SessionCache
	public List<NatureTravailDTO> getNatureTravails() {
		return this.remoteServices.getNatureTravails();
	}
	

	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNatureTravailDTOFromId(int)
	 */
	public NatureTravailDTO getNatureTravailDTOFromId(int id) {
		NatureTravailDTO o = null;
		for(NatureTravailDTO oo : getNatureTravails()){
			if(oo.getId()==(id)){
				o=oo;
				break;
			}
		}
		return o;
	}
	
	/* ****************************************************************************
	 * NIVEAU CENTRE
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNiveauxCentre()
	 */
	@SessionCache
	public List<NiveauCentreDTO> getNiveauxCentre(){
		return this.remoteServices.getNiveauCentre();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNiveauCentreFromId(int)
	 */
	public NiveauCentreDTO getNiveauCentreFromId(int id){
		NiveauCentreDTO n = null;
		for(NiveauCentreDTO nn : getNiveauxCentre()){
			if(nn.getId()==(id)){
				n=nn;
				break;
			}
		}
		return n;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNiveauCentreFromLibelle(java.lang.String)
	 */
	public NiveauCentreDTO getNiveauCentreFromLibelle(String lib){
		NiveauCentreDTO n = null;
		for(NiveauCentreDTO nn : getNiveauxCentre()){
			if(nn.getLibelle().equalsIgnoreCase(lib)){
				n=nn;
				break;
			}
		}
		return n;
	}
	/* ****************************************************************************
	 * NIVEAU FORMATION
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNiveauxFormation()
	 */
	public List<NiveauFormationDTO> getNiveauxFormation(){
		return this.remoteServices.getNiveauxFormation();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getNiveauFormationFromId(int)
	 */
	public NiveauFormationDTO getNiveauFormationFromId(int id){
		NiveauFormationDTO n = null;
		for(NiveauFormationDTO nn : getNiveauxFormation()){
			if(nn.getId()==(id)){
				n=nn;
				break;
			}
		}
		return n;
	}

	/* ****************************************************************************
	 *OrigineStage
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getOrigineStageDTOFromId(int)
	 */
	@SessionCache
	public OrigineStageDTO getOrigineStageDTOFromId(int id) {
	
		OrigineStageDTO o = null;
		for(OrigineStageDTO oo : getOrigineStages()){
			if(oo.getId()==(id)){
				o=oo;
				break;
			}
		}
		return o;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getOrigineStages()
	 */
	public List<OrigineStageDTO> getOrigineStages() {
		return this.remoteServices.getOrigineStages();
	}
	
	/* ****************************************************************************
	 * PAYS
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getPays()
	 */
	@SessionCache
	public List<PaysDTO> getPays(){
		return this.remoteServices.getPays();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getPaysFromId(int)
	 */
	public PaysDTO getPaysFromId(int id){
		PaysDTO p = null;
		for(PaysDTO pp : getPays()){
			if(pp.getId()==(id)){
				p=pp;
				break;
			}
		}
		return p;
	}
	
	/* ****************************************************************************
	 * STATUT JURIDIQUE
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getStatutsJuridiques()
	 */
	public List<StatutJuridiqueDTO> getStatutsJuridiques(){
		List<StatutJuridiqueDTO> list = this.remoteServices.getStatutsJuridiques();
		for (StatutJuridiqueDTO statut : list){
			statut.setTypeStructure(getTypeStructureFromId(statut.getIdParent()));
		}
		return list;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getStatutJuridiqueFromId(int)
	 */
	public StatutJuridiqueDTO getStatutJuridiqueFromId(int id){
		StatutJuridiqueDTO s = null;
		for(StatutJuridiqueDTO ss : getStatutsJuridiques()){
			if(ss.getId()==(id)){
				s=ss;
				break;
			}
		}
		return s;
	}
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getStatutsJuridiquesFromIdTypeStructure(int)
	 */
	public List<StatutJuridiqueDTO> getStatutsJuridiquesFromIdTypeStructure(int id){
		List<StatutJuridiqueDTO> l = null;
		if(id>0){
			l = new ArrayList<StatutJuridiqueDTO>();
			for(StatutJuridiqueDTO ff : getStatutsJuridiques()){
				if(ff.getIdParent()==id){
					l.add(ff);
				}
			}
			if(l.isEmpty()){
				l=null;
			}
		}
		return l;
	}
	
	/* ****************************************************************************
	 * TEMPS TRAVAIL
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getTempsTravail()
	 */
	public List<TempsTravailDTO> getTempsTravail(){
		return this.remoteServices.getTempsTravail();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getTempsTravailFromId(int)
	 */
	public TempsTravailDTO getTempsTravailFromId(int id){
		TempsTravailDTO t = null;
		for(TempsTravailDTO tt : getTempsTravail()){
			if(tt.getId()==(id)){
				t=tt;
				break;
			}
		}
		return t;
	}
	
	/* ****************************************************************************
	 * Theme
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getThemes()
	 */
	@SessionCache
	public List<ThemeDTO> getThemes() {
		return this.remoteServices.getThemes();
	}
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getThemeDTOFromId(int)
	 */
	public ThemeDTO getThemeDTOFromId(int id) {
		ThemeDTO o = null;
		for(ThemeDTO oo : getThemes()){
			if(oo.getId()==(id)){
				o=oo;
				break;
			}
		}
		return o;
	}

	
	/* ****************************************************************************
	 * TypeConvention
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getTypeConventions()
	 */
	public List<TypeConventionDTO> getTypeConventions() {
		return this.remoteServices.getTypeConventions();
	}

	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getTypeConventionDTOFromId(int)
	 */
	public TypeConventionDTO getTypeConventionDTOFromId(int id) {
		TypeConventionDTO o = null;
		for(TypeConventionDTO oo : getTypeConventions()){
			if(oo.getId()==(id)){
				o=oo;
				break;
			}
		}
		return o;
	}
	
	/* ****************************************************************************
	 * TYPE OFFRE
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getTypesOffre()
	 */
	public List<TypeOffreDTO> getTypesOffre(){
		return this.remoteServices.getTypesOffre();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getTypeOffreFromId(int)
	 */
	public TypeOffreDTO getTypeOffreFromId(int id){
		TypeOffreDTO t = null;
		for(TypeOffreDTO tt : getTypesOffre()){
			if(tt.getId()==(id)){
				t=tt;
				break;
			}
		}
		return t;
	}
	
	/* ****************************************************************************
	 * TYPE STRUCTURE
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getTypesStructure()
	 */
	public List<TypeStructureDTO> getTypesStructure(){
		return this.remoteServices.getTypesStructure();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getTypeStructureFromId(int)
	 */
	public TypeStructureDTO getTypeStructureFromId(int id){
		TypeStructureDTO t = null;
		for(TypeStructureDTO tt : getTypesStructure()){
			if(tt.getId()==(id)){
				t=tt;
				break;
			}
		}
		return t;
	}

	/* ****************************************************************************
	 * UNITE DUREE
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getUnitesDurees()
	 */
	@SessionCache
	public List<UniteDureeDTO> getUnitesDurees(){
		return this.remoteServices.getUnitesDurees();
	}
	
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getUniteDureeFromId(int)
	 */
	public UniteDureeDTO getUniteDureeFromId(int id){
		UniteDureeDTO u = null;
		for(UniteDureeDTO uu : getUnitesDurees()){
			if(uu.getId()==(id)){
				u=uu;
				break;
			}
		}
		return u;
	}



	
	/* ****************************************************************************
	 * UniteGratification
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getUniteGratifications()
	 */
	@SessionCache
	public List<UniteGratificationDTO> getUniteGratifications() {
		return this.remoteServices.getUniteGratifications();
	}


	/**
	 * @see org.esupportail.pstage.domain.NomenclatureDomainService#getUniteGratificationDTOFromId(int)
	 */
	public UniteGratificationDTO getUniteGratificationDTOFromId(int id) {
		UniteGratificationDTO o = null;
		for(UniteGratificationDTO oo : getUniteGratifications()){
			if(oo.getId()==(id)){
				o=oo;
				break;
			}
		}
		return o;
	}
}
