package org.esupportail.pstage.domain.referentiel;

import java.util.List;


/**
 * 
 * acces aux donnees du personnel
 *
 */

public class PersonalDataRepositoryDomainCustom implements
		PersonalDataRepositoryDomain {

	@Override
	public Enseignant getEnseignantRef(String universityCode, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> getEnseignantsByName(String universityCode,
			String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> getEnseignantsByName(String universityCode,
			String name, String firstName, String codeAffectation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnelCentreGestion getPersonnelCentreGestionRef(
			String universityCode, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonnelCentreGestion> getPersonnelCentreGestionRefByName(
			String universityCode, String name, String firstName,
			String codeAffectation) {
		// TODO Auto-generated method stub
		return null;
	}



	


}
