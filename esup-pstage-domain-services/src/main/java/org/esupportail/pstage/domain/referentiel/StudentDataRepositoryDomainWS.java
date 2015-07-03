package org.esupportail.pstage.domain.referentiel;

import java.util.List;

import org.apache.log4j.Logger;
import org.esupportail.pstage.dao.referentiel.StudentDataRepositoryDaoWS;
import org.esupportail.pstage.domain.beans.ApogeeMap;
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
	private static final long serialVersionUID = 1L;
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
		if(logger.isDebugEnabled()){
			logger.debug("getStudent("+universityCode+", "+id+");");
		}
		
		return studentDataRepositoryDaoWS.getEtudiantRef(universityCode, id);
		
	}

	
	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtudiantRefByNum(java.lang.String, java.lang.String)
	 */
	public EtudiantRef getEtudiantRefByNum(String universityCode, String id) {
		if(logger.isDebugEnabled()){
			logger.debug("getStudentByNum("+universityCode+","+id+");");
		}

		return studentDataRepositoryDaoWS.getEtudiantRefByNum(universityCode, id);
		
	}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtudiantsRefByName(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<EtudiantRef> getEtudiantsRefByName(String universityCode,String name, String firstName) {
		if(logger.isDebugEnabled()){
			logger.debug("getStudentsByName("+universityCode+", "+name+", "+firstName+");");
		}
		
		return studentDataRepositoryDaoWS.getEtudiantsRefByName(universityCode, name, firstName);

	}
	
	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtapesByEtudiantAndAnnee(java.lang.String, java.lang.String)
	 */
	public ApogeeMap getEtapesByEtudiantAndAnnee(String cod, String anneeScolaire){
		if(logger.isDebugEnabled()){
			logger.debug("getEtapesByEtudiantAndAnnee(" + cod +  ", " + anneeScolaire+")");
		}
		
		return studentDataRepositoryDaoWS.getEtapesByEtudiantAndAnnee(cod, anneeScolaire);

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