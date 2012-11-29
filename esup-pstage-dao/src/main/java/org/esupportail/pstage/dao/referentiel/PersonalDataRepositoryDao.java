package org.esupportail.pstage.dao.referentiel;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.remote.EnseignantDTO;
import org.esupportail.pstagedata.remote.PersonnelCentreGestionDTO;
/**
 * 
 *acces aux donnees du personnel
 *
 */
public interface PersonalDataRepositoryDao extends Serializable {
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
		 * @return Enseignant
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
		 * @return List<Enseignant>
		 */
		public List<EnseignantDTO> getEnseignantsByName(String universityCode, String name, String firstName, String codeAffectation);



}
