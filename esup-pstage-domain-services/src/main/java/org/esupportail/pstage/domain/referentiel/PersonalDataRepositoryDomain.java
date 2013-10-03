package org.esupportail.pstage.domain.referentiel;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO;

/**
 * acces aux donnees du personnel
 */
public interface PersonalDataRepositoryDomain extends Serializable{
	/**
		 * @param universityCode
		 * @param id
		 * @return PersonnelCentreGestion
		 */
		
		public PersonnelCentreGestionDTO getPersonnelCentreGestionRef(String universityCode, String id);

		/**
		 * @param universityCode
		 * @param name
		 * @param firstName
		 * @param codeAffectation
		 * @return List<PersonnelCentreGestion>
		 */
		public List<PersonnelCentreGestionDTO> getPersonnelCentreGestionRefByName(String universityCode, String name, String firstName, String codeAffectation);

		/**
		 * @param universityCode
		 * @param id
		 * @return EnseignantDTO
		 */
		public EnseignantDTO getEnseignantRef(String universityCode, String id);

		/**
		 * Retourne les enseignants suivant un nom
		 * @param universityCode
		 * @param name
		 * @return a List of Teacher
		 */
		public List<EnseignantDTO> getEnseignantsByName(String universityCode, String name);

		/**
		 * @param universityCode
		 * @param name
		 * @param firstName
		 * @param codeAffectation
		 * @return List<EnseignantDTO>
		 */
		public List<EnseignantDTO> getEnseignantsByName(String universityCode, String name, String firstName, String codeAffectation);



}
