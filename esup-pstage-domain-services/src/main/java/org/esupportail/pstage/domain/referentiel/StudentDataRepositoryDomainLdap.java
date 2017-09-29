package org.esupportail.pstage.domain.referentiel;

import java.util.LinkedHashMap;
import java.util.List;

import org.esupportail.pstage.dao.referentiel.StudentDataRepositoryDao;
import org.esupportail.pstage.domain.beans.ApogeeMap;
import org.esupportail.pstage.domain.beans.EtudiantRef;
import org.esupportail.pstage.utils.Configuration;

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
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtudiantRefByNum(java.lang.String, java.lang.String, java.lang.String)
	 */
	public EtudiantRef getEtudiantRefByNum(String universityCode, String id,String annee) {
		return studentDataRepositoryDao.getEtudiantRefByNum(universityCode,id,annee);
	}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtudiantsRefByName(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<EtudiantRef> getEtudiantsRefByName(String universityCode,
			String name, String firstName) {
		return studentDataRepositoryDao.getEtudiantsRefByName(universityCode, name, firstName);
	}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.StudentDataRepositoryDomain#getEtapesByEtudiantAndAnnee(String, String, String)
	 */
	public ApogeeMap getEtapesByEtudiantAndAnnee(String cod, String anneeScolaire, String codeUniversite){
		// "Pont" pour la nouvelle methode utilisee avec Apogee, adaptee pour le fonctionnement Full Ldap
		ApogeeMap apogeeMap = new ApogeeMap();
		EtudiantRef stud = this.getEtudiantRefByNum(codeUniversite, cod, anneeScolaire);

		apogeeMap.setStudentStudys(new LinkedHashMap(stud.getStudys()));
		// recuperation de la liste des etapes
		apogeeMap.setStudentSteps(new LinkedHashMap(stud.getSteps()));
		// recuperation Map des elements pedagogiques
		apogeeMap.setElementPedagogiques(new LinkedHashMap(stud.getElementPedagogiques()));
		// recuperation liste des ElPs
		apogeeMap.setListeELPs(stud.getListeELPs());
		// recuperation liste des etapes inscriptions
		apogeeMap.setListeEtapeInscriptions(stud.getListeEtapeInscriptions());


		return apogeeMap;
	}


}
