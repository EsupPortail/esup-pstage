/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import org.esupportail.commons.services.smtp.SmtpService;
import org.esupportail.commons.utils.Assert;
import org.esupportail.pstage.domain.AdminDomainService;
import org.esupportail.pstage.domain.AvenantDomainService;
import org.esupportail.pstage.domain.CentreGestionDomainService;
import org.esupportail.pstage.domain.ConventionDomainService;
import org.esupportail.pstage.domain.CritereGestionDomainService;
import org.esupportail.pstage.domain.EnseignantDomainService;
import org.esupportail.pstage.domain.EtudiantDomainService;
import org.esupportail.pstage.domain.NomenclatureDomainService;
import org.esupportail.pstage.domain.OffreDomainService;
import org.esupportail.pstage.domain.PersonnelCentreGestionDomainService;
import org.esupportail.pstage.domain.StructureDomainService;
import org.esupportail.pstage.domain.beans.ManagedRoadMap;
import org.esupportail.pstage.domain.beans.RoadMap;
import org.esupportail.pstage.domain.beans.User;
import org.esupportail.pstage.domain.referentiel.GeographieRepositoryDomain;
import org.esupportail.pstage.domain.referentiel.PersonalComponentRepositoryDomain;
import org.esupportail.pstage.domain.referentiel.PersonalDataRepositoryDomain;
import org.esupportail.pstage.domain.referentiel.PersonalDataRepositoryDomainLdap;
import org.esupportail.pstage.domain.referentiel.StudentComponentRepositoryDomain;
import org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain;
import org.esupportail.pstage.utils.BlowfishUtils;

/**
 * An abstract class inherited by all the beans for them to get:
 * - the context of the application (sessionController).
 * - the domain service (domainService).
 * - the application service (applicationService).
 * - the i18n service (i18nService).
 */
public abstract class AbstractContextAwareController extends AbstractDomainAwareBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The SessionController.
	 */
	private SessionController sessionController;
	/**
	 * The SessionController.
	 */
	private CentreController centreController;
	/**
	 * AdminDomainService.
	 */
	private AdminDomainService adminDomainService;
	/**
	 * CentreGestionDomainService.
	 */
	private CentreGestionDomainService centreGestionDomainService;
	/**
	 * EtudiantDomainService.
	 */
	private EtudiantDomainService etudiantDomainService;
	/**
	 * NomenclatureDomainService.
	 */
	private NomenclatureDomainService nomenclatureDomainService;
	/**
	 * PersonnelCentreGestionDomainService.
	 */
	private PersonnelCentreGestionDomainService personnelCentreGestionDomainService;
	/**
	 * EnseignantDomainService.
	 */
	private EnseignantDomainService enseignantDomainService;
	/**
	 * StructureDomainService.
	 */
	private StructureDomainService structureDomainService;	
	/**
	 * OffreDomainService.
	 */
	private OffreDomainService offreDomainService;
	/**
	 * PersonalDataRepositoryLdap.
	 */
	private PersonalDataRepositoryDomainLdap personalDataRepositoryLdap;
	/**
	 * GeographieRepositoryDomain.
	 */
	private GeographieRepositoryDomain geographieRepositoryDomain;
	/**
	 * CritereGestionDomainService.
	 */
	private CritereGestionDomainService critereGestionDomainService;
	/**
	 * AvenantDomainService.
	 */
	private AvenantDomainService avenantDomainService;
	/**
	 * BeanUtils .
	 */
	private BeanUtils beanUtils;
	/**
	 * BlowfishUtils.
	 */
	private BlowfishUtils blowfishUtils;
	/**
	 * SmtpService.
	 */
	private SmtpService smtpService;
	/**
	 * ConventionDomainService.
	 */
	private ConventionDomainService conventionDomainService;
	/**
	 * StudentDataRepositoryDomain.
	 */
	private StudentDataRepositoryDomain studentDataRepositoryDomain;
	/**
	 * StudentComponentRepositoryDomain.
	 */
	private StudentComponentRepositoryDomain studentComponentRepositoryDomain;
	/**
	 * PersonalDataRepositoryDomain.
	 */
	private PersonalDataRepositoryDomain personalDataRepositoryDomain;
	/**
	 * PersonalComponentRepositoryDomain.
	 */
	private PersonalComponentRepositoryDomain personalComponentRepositoryDomain;
	
	/**
	 * Managed the road of user.
	 */
	private ManagedRoadMap managedRoadMap;

	
	/**
	 * Constructor.
	 */
	protected AbstractContextAwareController() {
		super();
	}

	/**
	 * @see org.esupportail.pstage.web.controllers.AbstractDomainAwareBean#afterPropertiesSetInternal()
	 */
	@Override
	public void afterPropertiesSetInternal() {
		Assert.notNull(this.sessionController, "property sessionController of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.adminDomainService, "property adminDomainService of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.centreGestionDomainService, "property centreGestionDomainService of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.nomenclatureDomainService, "property nomenclatureDomainService of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.personnelCentreGestionDomainService, "property personnelCentreGestionDomainService of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.structureDomainService, "property structureDomainService of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.offreDomainService, "property offreDomainService of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.beanUtils, "property beanUtils of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.smtpService, "property smtpService of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.conventionDomainService, "property conventionDomainService of class "
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.studentDataRepositoryDomain, "property studentDataRepositoryDomain of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.studentComponentRepositoryDomain, "property studentComponentRepositoryDomain of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.personalDataRepositoryDomain, "property personalDataRepositoryDomain of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.personalComponentRepositoryDomain, "property personalComponentRepositoryDomain of class "
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.enseignantDomainService, "property enseignantDomainService of class "
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.avenantDomainService, "property avenantDomainService of class "
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.etudiantDomainService, "property enseignantDomainService of class "
				+ this.getClass().getName() + " can not be null");
	}

	
	
	/*
	 ******************* METHODS ********************** */

	/**
	 * Add the current Road in the RoadMap.
	 * @param action
	 * @param label
	 * @param title
	 * @param rang
	 */

	public void addTheCurrentRoad(final String action, final String label, final String title, final Integer rang) {
//		Integer rang = managedRoadMap.getRoads().size() + 1;
		managedRoadMap.addRoad(new RoadMap(action, true, label, rang, title));
	}
	
	/**
	 * Reinit the managedRoadMap.
	 */
	public void resetRoadMap() {
		managedRoadMap.reset();
	}
	
	/**
	 * @param sessionController the sessionController to set
	 */
	public void setSessionController(final SessionController sessionController) {
		this.sessionController = sessionController;
	}

	/**
	 * @return the sessionController
	 */
	public SessionController getSessionController() {
		return sessionController;
	}

	/**
	 * @see org.esupportail.pstage.web.controllers.AbstractDomainAwareBean#getCurrentUser()
	 */
	@Override
	protected User getCurrentUser() {
		return sessionController.getCurrentUser();
	}

	/**
	 * @return the adminDomainService
	 */
	public AdminDomainService getAdminDomainService() {
		return adminDomainService;
	}

	/**
	 * @param adminDomainService the adminDomainService to set
	 */
	public void setAdminDomainService(AdminDomainService adminDomainService) {
		this.adminDomainService = adminDomainService;
	}

	/**
	 * @return the centreGestionDomainService
	 */
	public CentreGestionDomainService getCentreGestionDomainService() {
		return centreGestionDomainService;
	}

	/**
	 * @param centreGestionDomainService the centreGestionDomainService to set
	 */
	public void setCentreGestionDomainService(
			CentreGestionDomainService centreGestionDomainService) {
		this.centreGestionDomainService = centreGestionDomainService;
	}

	/**
	 * @return the nomenclatureDomainService
	 */
	public NomenclatureDomainService getNomenclatureDomainService() {
		return nomenclatureDomainService;
	}

	/**
	 * @param nomenclatureDomainService the nomenclatureDomainService to set
	 */
	public void setNomenclatureDomainService(
			NomenclatureDomainService nomenclatureDomainService) {
		this.nomenclatureDomainService = nomenclatureDomainService;
	}

	/**
	 * @return the personnelCentreGestionDomainService
	 */
	public PersonnelCentreGestionDomainService getPersonnelCentreGestionDomainService() {
		return personnelCentreGestionDomainService;
	}

	/**
	 * @param personnelCentreGestionDomainService the personnelCentreGestionDomainService to set
	 */
	public void setPersonnelCentreGestionDomainService(
			PersonnelCentreGestionDomainService personnelCentreGestionDomainService) {
		this.personnelCentreGestionDomainService = personnelCentreGestionDomainService;
	}
	
	/**
	 * @return the structureDomainService
	 */
	public StructureDomainService getStructureDomainService() {
		return structureDomainService;
	}

	/**
	 * @param structureDomainService the structureDomainService to set
	 */
	public void setStructureDomainService(
			StructureDomainService structureDomainService) {
		this.structureDomainService = structureDomainService;
	}

	/**
	 * @return the offreDomainService
	 */
	public OffreDomainService getOffreDomainService() {
		return offreDomainService;
	}

	/**
	 * @param offreDomainService the offreDomainService to set
	 */
	public void setOffreDomainService(OffreDomainService offreDomainService) {
		this.offreDomainService = offreDomainService;
	}

	/**
	 * @return the beanUtils
	 */
	public BeanUtils getBeanUtils() {
		return beanUtils;
	}

	/**
	 * @param beanUtils the beanUtils to set
	 */
	public void setBeanUtils(BeanUtils beanUtils) {
		this.beanUtils = beanUtils;
	}

	/**
	 * @return the blowfishUtils
	 */
	public BlowfishUtils getBlowfishUtils() {
		return blowfishUtils;
	}

	/**
	 * @param blowfishUtils the blowfishUtils to set
	 */
	public void setBlowfishUtils(BlowfishUtils blowfishUtils) {
		this.blowfishUtils = blowfishUtils;
	}

	/**
	 * @return the smtpService
	 */
	public SmtpService getSmtpService() {
		return smtpService;
	}

	/**
	 * @param smtpService the smtpService to set
	 */
	public void setSmtpService(SmtpService smtpService) {
		this.smtpService = smtpService;
	}
	/**
	 * @param etudiantDomainService the etudiantDomainService to set
	 */
	public void setEtudiantDomainService(EtudiantDomainService etudiantDomainService) {
		this.etudiantDomainService = etudiantDomainService;
	}
	/**
	 * @return the EtudiantDomainService
	 */
	public EtudiantDomainService getEtudiantDomainService() {
		return etudiantDomainService;
	}
	/**
	 * @return the studentDataRepositoryDomain
	 */
	public StudentDataRepositoryDomain getStudentDataRepositoryDomain() {
		return studentDataRepositoryDomain;
	}

	/**
	 * @param studentDataRepositoryDomain the studentDataRepositoryDomain to set
	 */
	public void setStudentDataRepositoryDomain(
			StudentDataRepositoryDomain studentDataRepositoryDomain) {
		this.studentDataRepositoryDomain = studentDataRepositoryDomain;
	}

	/**
	 * @param enseignantDomainService the enseignantDomainService to set
	 */
	public void setEnseignantDomainService(EnseignantDomainService enseignantDomainService) {
		this.enseignantDomainService = enseignantDomainService;
	}

	/**
	 * @return the enseignantDomainService
	 */
	public EnseignantDomainService getEnseignantDomainService() {
		return enseignantDomainService;
	}

	/**
	 * @return the conventionDomainService
	 */
	public ConventionDomainService getConventionDomainService() {
		return conventionDomainService;
	}

	/**
	 * @return the critereGestionDomainService
	 */
	public CritereGestionDomainService getCritereGestionDomainService() {
		return critereGestionDomainService;
	}

	/**
	 * @param critereGestionDomainService the critereGestionDomainService to set
	 */
	public void setCritereGestionDomainService(
			CritereGestionDomainService critereGestionDomainService) {
		this.critereGestionDomainService = critereGestionDomainService;
	}

	/**
	 * @param conventionDomainService the conventionDomainService to set
	 */
	public void setConventionDomainService(
			ConventionDomainService conventionDomainService) {
		this.conventionDomainService = conventionDomainService;
	}
	/**
	 * @return the personalComponentRepositoryDomain
	 */
	public PersonalComponentRepositoryDomain getPersonalComponentRepositoryDomain() {
		return personalComponentRepositoryDomain;
	}

	/**
	 * @param personalComponentRepositoryDomain the personalComponentRepositoryDomain to set
	 */
	public void setPersonalComponentRepositoryDomain(
			PersonalComponentRepositoryDomain personalComponentRepositoryDomain) {
		this.personalComponentRepositoryDomain = personalComponentRepositoryDomain;
	}
	/**
	 * @return the studentComponentRepositoryDomain
	 */
	public StudentComponentRepositoryDomain getStudentComponentRepositoryDomain() {
		return studentComponentRepositoryDomain;
	}

	/**
	 * @param studentComponentRepositoryDomain the studentComponentRepositoryDomain to set
	 */
	public void setStudentComponentRepositoryDomain(
			StudentComponentRepositoryDomain studentComponentRepositoryDomain) {
		this.studentComponentRepositoryDomain = studentComponentRepositoryDomain;
	}

	/**
	 * @return the personalDataRepositoryLdap
	 */
	public PersonalDataRepositoryDomainLdap getPersonalDataRepositoryLdap() {
		return personalDataRepositoryLdap;
	}

	/**
	 * @param personalDataRepositoryLdap the personalDataRepositoryLdap to set
	 */
	public void setPersonalDataRepositoryLdap(
			PersonalDataRepositoryDomainLdap personalDataRepositoryLdap) {
		this.personalDataRepositoryLdap = personalDataRepositoryLdap;
	}

	/**
	 * @return the geographieRepositoryDomain
	 */
	public GeographieRepositoryDomain getGeographieRepositoryDomain() {
		return geographieRepositoryDomain;
	}

	/**
	 * @param geographieRepositoryDomain the geographieRepositoryDomain to set
	 */
	public void setGeographieRepositoryDomain(
			GeographieRepositoryDomain geographieRepositoryDomain) {
		this.geographieRepositoryDomain = geographieRepositoryDomain;
	}
	
	/**
	 * @return PersonalDataRepositoryDomain
	 */
	public PersonalDataRepositoryDomain getPersonalDataRepositoryDomain() {
		return personalDataRepositoryDomain;
	}

	/**
	 * @param personalDataRepositoryDomain the personalDataRepositoryDomain to set
	 */
	public void setPersonalDataRepositoryDomain(
			PersonalDataRepositoryDomain personalDataRepositoryDomain) {
		this.personalDataRepositoryDomain = personalDataRepositoryDomain;
	}

	/**
	 * @return the managedRoadMap
	 */
	public ManagedRoadMap getManagedRoadMap() {
		return managedRoadMap;
	}

	/**
	 * @param managedRoadMap the managedRoadMap to set
	 */
	public void setManagedRoadMap(ManagedRoadMap managedRoadMap) {
		this.managedRoadMap = managedRoadMap;
	}
	

	/**
	 * @return the avenantDomainService
	 */
	public AvenantDomainService getAvenantDomainService() {
		return avenantDomainService;
	}

	/**
	 * @param avenantDomainService the avenantDomainService to set
	 */
	public void setAvenantDomainService(AvenantDomainService avenantDomainService) {
		this.avenantDomainService = avenantDomainService;
	}

	/**
	 * @param centreController the centreController to set
	 */
	public void setCentreController(CentreController centreController) {
		this.centreController = centreController;
	}

	/**
	 * @return the centreController
	 */
	public CentreController getCentreController() {
		return centreController;
	}

	
}
