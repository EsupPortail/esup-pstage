package org.esupportail.pstage.domain;

import java.util.List;

import org.apache.log4j.Logger;
import org.esupportail.pstage.exceptions.StatistiquesException;
import org.esupportail.pstage.utils.Configuration;
import org.esupportail.pstage.utils.TypeCritere;
import org.esupportail.pstagedata.domain.dto.CritereDTO;
import org.esupportail.pstagedata.exceptions.RemoteException;
import org.esupportail.pstagedata.remote.RemoteServices;
import org.esupportail.pstagedata.domain.dto.StatisticItemDTO;

@SuppressWarnings("serial")
public class StatistiquesDomainServiceImpl implements StatistiquesDomainService{

	private final static Logger logger= Logger.getLogger(StatistiquesDomainServiceImpl.class);

	private RemoteServices remoteServices;

	public void setRemoteServices(RemoteServices remoteServices) {
		this.remoteServices = remoteServices;
	}

	@Override
	public List<CritereDTO> getCriteresPremierNiveauPrConvention()throws StatistiquesException{
		List<CritereDTO> criteresParCategorieEtParNiveau = remoteServices.getCriteresParCategorieEtParNiveau(TypeCritere.CONVENTION.get(), TypeCritere.PREMIER_NIVEAU.get());
		if(criteresParCategorieEtParNiveau == null ){
			logger.error(Configuration.getString("critere.cvt.niveau1.ko"));
			throw new StatistiquesException(Configuration.getString("critere.cvt.niveau1.ko"));
		}
		return criteresParCategorieEtParNiveau;
	}

	@Override
	public List<CritereDTO> getCriteresSecondNiveauPrConvention() {
		List<CritereDTO> criteresParCategorieEtParNiveau = remoteServices.getCriteresParCategorieEtParNiveau(TypeCritere.CONVENTION.get(), TypeCritere.SECOND_NIVEAU.get());
		return criteresParCategorieEtParNiveau;
	}

	@Override
	public List<CritereDTO> getCriteresPremierNiveauPrOffres() throws StatistiquesException {
		List<CritereDTO> criteresOffreEtNiveau1 = remoteServices.getCriteresParCategorieEtParNiveau(TypeCritere.OFFRE.get(),  TypeCritere.PREMIER_NIVEAU.get());
		if(criteresOffreEtNiveau1 == null ){
			logger.error(Configuration.getString("critere.offre.niveau1.ko"));
			throw new StatistiquesException(Configuration.getString("critere.offre.niveau1.ko"));
		}
		return criteresOffreEtNiveau1;
	}

	@Override
	public List<CritereDTO> getCriteresSecondNiveauPrOffres()
	throws StatistiquesException {
		List<CritereDTO> criteresOffreEtNiveau2 = remoteServices.getCriteresParCategorieEtParNiveau(TypeCritere.OFFRE.get(),TypeCritere.SECOND_NIVEAU.get());
		if(criteresOffreEtNiveau2 == null ){
			logger.error(Configuration.getString("critere.offre.niveau2.ko"));
			throw new StatistiquesException(Configuration.getString("critere.offre.niveau2.ko"));
		}
		return criteresOffreEtNiveau2;
	}

	/****************************/
	
	@Override
	public List<String> getAnneesConventions(Integer idCentreGestion,
			String etab) throws StatistiquesException {
		List<String> anneesConventions= null;
		try {
			anneesConventions	 =  remoteServices.getAnneesConventions(idCentreGestion, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("annees.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("annees.cvt.ko"));
		}
		return anneesConventions;
	}

	public List<StatisticItemDTO> getNumberOfConventions(Integer idCenter, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventions(idCenter, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}	
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByType(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParType(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByTheme(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParTheme(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByIndemnity(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParIndemnite(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByWorkDuration(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParTpsDeTravail(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}	
		return nbCvt;
	}

	public List<StatisticItemDTO> getNumberOfConventionsByNbDaysPerWeek(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParJourSemaine(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByWayToFind(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParOrigineStage(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByTeacherGuide(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParEnseignantTuteur(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStructure(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParStructure(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStructureActivity(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParStructureActivite(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStructureType(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParStructureType(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStructureSize(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParTailleStructure(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByServiceDep(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParDepLieuStage(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByServiceCountry(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getTotalConventionsParPaysDuService(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	/******************* UFR ************************/
	
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudy(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudy(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}	
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndType(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndType(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndTheme(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndTheme(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndIndemnity(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndIndemnity(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndWorkDuration(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndWorkDuration(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}	
		return nbCvt;
	}

	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndNbDaysPerWeek(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndNbDaysPerWeek(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndWayToFind(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndWayToFind(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndTeacherGuide(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndTeacherGuide(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndStructure(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndStructure(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndActivity(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndActivity(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndStructureType(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndStructureType(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndStructureSize(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndStructureSize(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndServiceDep(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndServiceDep(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndServiceCountry(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndServiceCountry(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	/******************* DEP ************************/
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartment(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartment(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}	
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndType(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndType(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndActivity(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndActivity(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndIndemnity(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndIndemnity(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndWorkDuration(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndWorkDuration(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}	
		return nbCvt;
	}

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndNbDaysPerWeek(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndNbDaysPerWeek(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndWayToFind(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndWayToFind(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndTeacherGuide(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndTeacherGuide(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndStructure(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndStructure(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndStructureType(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndStructureType(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndStructureSize(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndStructureSize(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndServiceDep(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndServiceDep(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndServiceCountry(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndServiceCountry(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndTheme(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndTheme(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	
	/******************* ETAPE ************************/
	
	public List<StatisticItemDTO> getNumberOfConventionsByStep(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStep(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}	
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndType(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndType(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndActivity(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndActivity(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndIndemnity(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndIndemnity(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndWorkDuration(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndWorkDuration(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}	
		return nbCvt;
	}

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndNbDaysPerWeek(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndNbDaysPerWeek(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndWayToFind(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndWayToFind(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndTeacherGuide(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndTeacherGuide(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndStructure(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndStructure(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndStructureType(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndStructureType(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndStructureSize(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndStructureSize(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndServiceDep(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndServiceDep(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndServiceCountry(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndServiceCountry(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndTheme(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndTheme(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
	/******************* OFFRE ************************/
	
	@Override
	public List<String> getAnneesOffres(Integer idCentreGestion,
			String etat) throws StatistiquesException {
		List<String> anneesOffres= null;
		try {
			anneesOffres	 =  remoteServices.getAnneesOffres(idCentreGestion, etat);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("annees.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("annees.offre.ko"));
		}
		return anneesOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffers(Integer idCenter, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffers(idCenter, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}	
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByActivity(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByActivity(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByStructure(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByStructure(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByStructureType(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByStructureType(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByStructureSize(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByStructureSize(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}	
		return nbOffres;
	}

	public List<StatisticItemDTO> getNumberOfOffersByStructureDep(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByStructureDep(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByStructureCountry(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByStructureCountry(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByFunction(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByFunction(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByFormation(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByFormation(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByLevel(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByLevel(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByType(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByType(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByValidation(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByValidation(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByPublication(Integer idCenter, String year, String etab) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByPublication(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByCandidateFound(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByCandidateFound(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}
	
	public List<StatisticItemDTO> getNumberOfOffersByLocalStudent(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException {
		List<StatisticItemDTO> nbOffres;
		try {
			nbOffres = remoteServices.getNumberOfOffersByLocalStudent(idCenter,year, etab, validation, publication);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.offre.ko"));
			throw new StatistiquesException(Configuration.getString("nb.offre.ko"));
		}
		return nbOffres;
	}

	@Override
	public List<StatisticItemDTO> getNumberOfConventionsByNbWeeks(
			Integer idCenter, String year, String etab)
			throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByNbWeeks(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}

	@Override
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndNbWeeks(
			Integer idCenter, String year, String etab)
			throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStudyAndNbWeeks(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}

	@Override
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndNbWeeks(
			Integer idCenter, String year, String etab)
			throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByDepartmentAndNbWeeks(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}

	@Override
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndNbWeeks(
			Integer idCenter, String year, String etab)
			throws StatistiquesException {
		List<StatisticItemDTO> nbCvt;
		try {
			nbCvt = remoteServices.getNumberOfConventionsByStepAndNbWeeks(idCenter,year, etab);
		} catch (RemoteException e) {
			logger.error(Configuration.getString("nb.cvt.ko"));
			throw new StatistiquesException(Configuration.getString("nb.cvt.ko"));
		}
		return nbCvt;
	}
	
}
