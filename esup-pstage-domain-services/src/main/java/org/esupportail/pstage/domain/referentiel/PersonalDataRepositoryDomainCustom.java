package org.esupportail.pstage.domain.referentiel;

import java.util.List;

import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO;



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
	private static final long serialVersionUID = 1L;

	@Override
	public EnseignantDTO getEnseignantRef(String universityCode, String id) {
		return null;
	}

	@Override
	public List<EnseignantDTO> getEnseignantsByName(String universityCode,
			String name) {
		return null;
	}

	@Override
	public List<EnseignantDTO> getEnseignantsByName(String universityCode,
			String name, String firstName, String codeAffectation) {
		return null;
	}

	@Override
	public PersonnelCentreGestionDTO getPersonnelCentreGestionRef(
			String universityCode, String id) {
		return null;
	}

	@Override
	public List<PersonnelCentreGestionDTO> getPersonnelCentreGestionRefByName(
			String universityCode, String name, String firstName,
			String codeAffectation) {
		return null;
	}	


}
