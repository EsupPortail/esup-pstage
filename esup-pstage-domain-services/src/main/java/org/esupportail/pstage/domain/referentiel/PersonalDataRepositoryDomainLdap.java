package org.esupportail.pstage.domain.referentiel;

import java.util.List;


/**
 * 
 * acces aux donnees du personnel
 *
 */

public class PersonalDataRepositoryDomainLdap implements
		PersonalDataRepositoryDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonalDataRepositoryDao personalDataRepositoryDao;

	/**
	 * @param personalDataRepositoryDao the personalDataRepositoryDao to set
	 */
	public void setPersonalDataRepositoryDao(
			PersonalDataRepositoryDao personalDataRepositoryDao) {
		this.personalDataRepositoryDao = personalDataRepositoryDao;
	}

	@Override
	public Enseignant getEnseignantRef(String universityCode, String id) {
		return personalDataRepositoryDao.getEnseignantRef(universityCode, id);
	}

	@Override
	public List<Enseignant> getEnseignantsByName(String universityCode,
			String name) {
		return personalDataRepositoryDao.getEnseignantsByName(universityCode, name);
	}

	@Override
	public List<Enseignant> getEnseignantsByName(String universityCode,
			String name, String firstName, String codeAffectation) {
		return personalDataRepositoryDao.getEnseignantsByName(universityCode, name, firstName, codeAffectation);
	}

	@Override
	public PersonnelCentreGestion getPersonnelCentreGestionRef(
			String universityCode, String id) {
		return personalDataRepositoryDao.getPersonnelCentreGestionRef(universityCode, id) ;
	}

	@Override
	public List<PersonnelCentreGestion> getPersonnelCentreGestionRefByName(
			String universityCode, String name, String firstName,
			String codeAffectation) {
		return personalDataRepositoryDao.getPersonnelCentreGestionRefByName(universityCode, name, firstName, codeAffectation);
	}



	


}
