package org.esupportail.pstage.domain.referentiel;

import java.util.List;

import org.esupportail.pstage.domain.beans.EtudiantRef;

/**
 * 
 * Recherches des etudiants  pour l'utilisation tout Ldap
 *
 */

public class StudentDataRepositoryDomainLdap implements
	StudentDataRepositoryDomain {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private StudentDataRepositoryDao studentDataRepositoryDao;
	/**
 * @param studentDataRepositoryDao the studentDataRepositoryDao to set
 */
public void setStudentDataRepositoryDao(
		StudentDataRepositoryDao studentDataRepositoryDao) {
	this.studentDataRepositoryDao = studentDataRepositoryDao;
}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtudiantRef(java.lang.String, java.lang.String)
	 */
	public EtudiantRef getEtudiantRef(String universityCode, String id) {
	
		return studentDataRepositoryDao.getEtudiantRef(universityCode, id);
	}

	
	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtudiantRefByNum(java.lang.String, java.lang.String)
	 */
	public EtudiantRef getEtudiantRefByNum(String universityCode, String id) {
		return studentDataRepositoryDao.getEtudiantRefByNum(universityCode,id);
	}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtudiantsRefByName(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<EtudiantRef> getEtudiantsRefByName(String universityCode,
			String name, String firstName) {
		return studentDataRepositoryDao.getEtudiantsRefByName(universityCode, name, firstName);
	}




}
