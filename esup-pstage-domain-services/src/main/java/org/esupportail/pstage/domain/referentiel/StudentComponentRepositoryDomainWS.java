package org.esupportail.pstage.domain.referentiel;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.esupportail.commons.annotations.cache.SessionCache;
import org.esupportail.pstage.dao.referentiel.StudentComponentRepositoryDaoWS;
import org.esupportail.pstage.domain.beans.EtabRef;
import org.esupportail.pstage.domain.beans.SignataireRef;


/**
 * 
 * Acces au composantes du personnel personnalise
 *
 */

public class StudentComponentRepositoryDomainWS implements
	StudentComponentRepositoryDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static Logger  logger = Logger.getLogger(StudentComponentRepositoryDomainWS.class);
	/**
	 * 
	 */
	private StudentComponentRepositoryDaoWS studentComponentRepositoryDaoWS; 

	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentComponentRepositoryDomain#getEtabRef(java.lang.String)
	 */
	public EtabRef getEtabRef(String universityCode) {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de StudentComponentRepositoryWS.getEtabRef( universityCode) : " + universityCode);
		}
		EtabRef etabRef = studentComponentRepositoryDaoWS.getEtabRef(universityCode);
		if(logger.isDebugEnabled()){
			logger.debug(" StudentComponentRepositoryWS etabRef.getNomEtabRef ==> " + etabRef.getNomEtabRef());
		}
		return etabRef;
	}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentComponentRepositoryDomain#getEtapesRef(java.lang.String)
	 */
	@SessionCache
	public Map<String, String> getEtapesRef(String universityCode) {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de StudentComponentRepositoryWS.getEtapesRef(String universityCode) : " + universityCode);
		}
		
		LinkedHashMap<String, String> etapes = studentComponentRepositoryDaoWS.getEtapesRef(universityCode);
		
		if(logger.isDebugEnabled()){
			logger.debug(" StudentComponentRepositoryWS liste des etapes  ==> " + etapes.size());
		}
		return etapes;
	}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentComponentRepositoryDomain#getSigCompoRef(java.lang.String, java.lang.String)
	 */
	public SignataireRef getSigCompoRef(String universityCode, String composante) {
		SignataireRef sigRef = studentComponentRepositoryDaoWS.getSigCompoRef(universityCode, composante);
		return sigRef;
	}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentComponentRepositoryDomain#getComposantesPrincipalesRef(java.lang.String, java.util.Map)
	 */
	public Map<String, String> getComposantesPrincipalesRef(String universityCode,
			Map<String, String> lesComposantes) {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de StudentComponentRepositoryDomainWS.getUfrs( universityCode,lesComposantes) : " + universityCode);
		}
		
		Map<String, String> ufrs = studentComponentRepositoryDaoWS.getComposantesPrincipalesRef(universityCode, lesComposantes);
		
		if(logger.isDebugEnabled()){
			logger.debug(" StudentComponentRepositoryDomainWS liste des Ufrs ==> " + ufrs.size());
		}
		return ufrs;
	}

	/**
	 * @return the studentComponentRepositoryDaoWS
	 */
	public StudentComponentRepositoryDaoWS getStudentComponentRepositoryDaoWS() {
		return studentComponentRepositoryDaoWS;
	}

	/**
	 * @param studentComponentRepositoryDaoWS the studentComponentRepositoryDaoWS to set
	 */
	public void setStudentComponentRepositoryDaoWS(
			StudentComponentRepositoryDaoWS studentComponentRepositoryDaoWS) {
		this.studentComponentRepositoryDaoWS = studentComponentRepositoryDaoWS;
	}





}
