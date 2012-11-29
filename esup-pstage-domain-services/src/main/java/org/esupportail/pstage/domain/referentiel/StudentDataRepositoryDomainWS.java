package org.esupportail.pstage.domain.referentiel;

import java.util.List;

import org.apache.log4j.Logger;
import org.esupportail.pstage.domain.beans.EtudiantRef;

/**
 * 
 * Acces au composantes du personnel personnalise
 *
 */

public class StudentDataRepositoryDomainWS implements
	StudentDataRepositoryDomain {

	/**
	 * 
	 */
	private static Logger  logger = Logger.getLogger(StudentDataRepositoryDomainWS.class);
	/**
	 * 
	 */
	private StudentDataRepositoryDaoWS studentDataRepositoryDaoWS; 

	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtudiantRef(java.lang.String, java.lang.String)
	 */
	public EtudiantRef getEtudiantRef(String universityCode, String id) {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de StudentDataRepositoryWS.getStudent(String universityCode, String id) : " + universityCode +  "id : " + id);
		}
		
		EtudiantRef etudiantRef = studentDataRepositoryDaoWS.getEtudiantRef(universityCode, id);
		
		if(logger.isDebugEnabled()){
			logger.debug(" StudentDataRepositoryWS etudiantRef  ==> " + etudiantRef.toString());
		}
		return etudiantRef;
	}

	
	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtudiantRefByNum(java.lang.String, java.lang.String)
	 */
	public EtudiantRef getEtudiantRefByNum(String universityCode, String id) {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de StudentDataRepositoryWS.getStudentByNum(String universityCode, String id) : " + universityCode +  "id : " + id);
		}
		
		EtudiantRef etudiantRef = studentDataRepositoryDaoWS.getEtudiantRefByNum(universityCode, id);
		
		if(logger.isDebugEnabled()){
			if (etudiantRef !=null) {
				logger.debug(" StudentDataRepositoryWS etudiantRef  ==> " + etudiantRef.toString());
			}
			
		}
		return etudiantRef;
	}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtudiantsRefByName(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<EtudiantRef> getEtudiantsRefByName(String universityCode,String name, String firstName) {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de StudentDataRepositoryWS.getStudentsByName(universityCode, name,firstName) : " + universityCode +  "name : " + name + " firstName : " + firstName);
		}
		
		List<EtudiantRef> lEtudiantRef = studentDataRepositoryDaoWS.getEtudiantsRefByName(universityCode, name, firstName);
		if(logger.isDebugEnabled()){
			
			logger.debug(" StudentDataRepositoryWS lEtudiantRef  ==> " + lEtudiantRef.size());
		}
		return lEtudiantRef;
	}


	/**
	 * @return the studentDataRepositoryDaoWS
	 */
	public StudentDataRepositoryDaoWS getStudentDataRepositoryDaoWS() {
		return studentDataRepositoryDaoWS;
	}


	/**
	 * @param studentDataRepositoryDaoWS the studentDataRepositoryDaoWS to set
	 */
	public void setStudentDataRepositoryDaoWS(
			StudentDataRepositoryDaoWS studentDataRepositoryDaoWS) {
		this.studentDataRepositoryDaoWS = studentDataRepositoryDaoWS;
	}



	



}
