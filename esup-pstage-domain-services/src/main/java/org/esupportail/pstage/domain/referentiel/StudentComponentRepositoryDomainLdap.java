package org.esupportail.pstage.domain.referentiel;

import java.util.Map;

import org.esupportail.pstage.dao.referentiel.StudentComponentRepositoryDao;
import org.esupportail.pstage.domain.beans.EtabRef;
import org.esupportail.pstage.domain.beans.SignataireRef;


/**
 * 
 * Acces au composantes du personnel personnalise
 *
 */

public class StudentComponentRepositoryDomainLdap implements
	StudentComponentRepositoryDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StudentComponentRepositoryDao studentComponentRepositoryDao;
	
	/**
	 * @param studentComponentRepositoryDao the studentComponentRepositoryDao to set
	 */
	public void setStudentComponentRepositoryDao(
			StudentComponentRepositoryDao studentComponentRepositoryDao) {
		this.studentComponentRepositoryDao = studentComponentRepositoryDao;
	}

	public EtabRef getEtabRef(String universityCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String> getEtapesRef(String universityCode) {
		return studentComponentRepositoryDao.getEtapesRef(universityCode);
	}

	public SignataireRef getSigCompoRef(String universityCode, String Composante) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String> getComposantesPrincipalesRef(String universityCode,
			Map<String, String> lesComposantes) {
		return studentComponentRepositoryDao.getComposantesPrincipalesRef(universityCode, lesComposantes);
	}
}
