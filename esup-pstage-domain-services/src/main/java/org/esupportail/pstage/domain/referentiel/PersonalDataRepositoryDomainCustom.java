package org.esupportail.pstage.domain.referentiel;

import java.util.List;

import org.esupportail.pstagedata.remote.EnseignantDTO;
import org.esupportail.pstagedata.remote.PersonnelCentreGestionDTO;


/**
 * 
 * acces aux donnees du personnel
 *
 */

public class PersonalDataRepositoryDomainCustom implements
		PersonalDataRepositoryDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6320390674434240470L;

	@Override
	public EnseignantDTO getEnseignantRef(String universityCode, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnseignantDTO> getEnseignantsByName(String universityCode,
			String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnseignantDTO> getEnseignantsByName(String universityCode,
			String name, String firstName, String codeAffectation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnelCentreGestionDTO getPersonnelCentreGestionRef(
			String universityCode, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonnelCentreGestionDTO> getPersonnelCentreGestionRefByName(
			String universityCode, String name, String firstName,
			String codeAffectation) {
		// TODO Auto-generated method stub
		return null;
	}



	


}
