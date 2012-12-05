package org.esupportail.pstage.domain.referentiel;

import java.util.Map;

import org.esupportail.pstage.dao.referentiel.PersonalComponentRepositoryDao;


/**
 * 
 * Acces au composantes du personnel personnalise
 *
 */

public class PersonalComponentRepositoryDomainLdap implements
		PersonalComponentRepositoryDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PersonalComponentRepositoryDao personalComponentRepositoryDao;


	

	public Map<String, String> getComposantesRef(String universityCode) {
		return personalComponentRepositoryDao.getComposantesRef(universityCode);
	}

	/**
	 * @param personalComponentRepositoryDao the personalComponentRepositoryDao to set
	 */
	public void setPersonalComponentRepositoryDao(
			PersonalComponentRepositoryDao personalComponentRepositoryDao) {
		this.personalComponentRepositoryDao = personalComponentRepositoryDao;
	}

	
}
