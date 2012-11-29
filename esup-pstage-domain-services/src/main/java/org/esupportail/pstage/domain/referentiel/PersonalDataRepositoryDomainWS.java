package org.esupportail.pstage.domain.referentiel;

import java.util.List;

import org.apache.log4j.Logger;


/**
 * 
 * acces aux donnees du personnel
 *
 */

public class PersonalDataRepositoryDomainWS implements
		PersonalDataRepositoryDomain {
	
	/**
	 * 
	 */
	final Logger logger = Logger.getLogger(PersonalDataRepositoryDomainWS.class);

	/**
	 * 
	 */
	private PersonalDataRepositoryDaoWS personalDataRepositoryDaoWS; 

	
	/**
	 * @see org.esupportail.pstage.domain.referentiel.PersonalDataRepositoryDomain#getEnseignantRef(java.lang.String, java.lang.String)
	 */
	public Enseignant getEnseignantRef(String universityCode, String id) {
		return personalDataRepositoryDaoWS.getEnseignantRef(universityCode, id);
	}

	@Override
	public List<Enseignant> getEnseignantsByName(String universityCode,
			String name) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.PersonalDataRepositoryDomain#getEnseignantsByName(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<Enseignant> getEnseignantsByName(String universityCode,
			String name, String firstName, String codeAffectation) {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de PersonalDataRepositoryWS.getEnseignantsByName(universityCode, name,firstName,codeAffectation) : " + universityCode +  " name : " + name 
					+ " firstName : " + firstName + "codeAffectation : " + codeAffectation);
		}
		
		List<Enseignant>  lEnseignant = personalDataRepositoryDaoWS.getEnseignantsByName(universityCode, name, firstName, codeAffectation);
		if(logger.isDebugEnabled()){
			
			logger.debug(" PersonalDataRepositoryDomainWS lEnseignant  ==> " + lEnseignant.size());
		}
		return lEnseignant;
	}

	
	/**
	 * @see org.esupportail.pstage.domain.referentiel.PersonalDataRepositoryDomain#getPersonnelCentreGestionRef(java.lang.String, java.lang.String)
	 */
	public PersonnelCentreGestion getPersonnelCentreGestionRef(
			String universityCode, String id) {
		PersonnelCentreGestion personnelCentreGestion = personalDataRepositoryDaoWS.getPersonnelCentreGestionRef(universityCode, id);
		return personnelCentreGestion;
	}


	/**
	 * @see org.esupportail.pstage.domain.referentiel.PersonalDataRepositoryDomain#getPersonnelCentreGestionRefByName(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<PersonnelCentreGestion> getPersonnelCentreGestionRefByName(
			String universityCode, String name, String firstName,
			String codeAffectation) {
		List<PersonnelCentreGestion> lPersonnelCentreGestion = personalDataRepositoryDaoWS.getPersonnelCentreGestionRefByName(universityCode, name, firstName, codeAffectation);

		return lPersonnelCentreGestion;
	}

	/**
	 * @return the personalDataRepositoryDaoWS
	 */
	public PersonalDataRepositoryDaoWS getPersonalDataRepositoryDaoWS() {
		return personalDataRepositoryDaoWS;
	}

	/**
	 * @param personalDataRepositoryDaoWS the personalDataRepositoryDaoWS to set
	 */
	public void setPersonalDataRepositoryDaoWS(
			PersonalDataRepositoryDaoWS personalDataRepositoryDaoWS) {
		this.personalDataRepositoryDaoWS = personalDataRepositoryDaoWS;
	}



	


}
