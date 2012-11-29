package org.esupportail.pstage.domain.referentiel;

import java.io.Serializable;
import java.util.List;
/**
 * 
 *acces aux donnees du personnel
 *
 */
public interface PersonalDataRepositoryDomain extends Serializable{
	/**
		 * @param universityCode
		 * @param id
		 * @return PersonnelCentreGestion
		 */
		
		public PersonnelCentreGestion getPersonnelCentreGestionRef(String universityCode, String id);

		/**
		 * @param universityCode
		 * @param name
		 * @param firstName
		 * @param codeAffectation
		 * @return List<PersonnelCentreGestion>
		 */
		public List<PersonnelCentreGestion> getPersonnelCentreGestionRefByName(String universityCode, String name, String firstName, String codeAffectation);

		/**
		 * @param universityCode
		 * @param id
		 * @return Enseignant
		 */
		public Enseignant getEnseignantRef(String universityCode, String id);

		/**
		 * Retourne les enseignants suivant un nom
		 * @param universityCode
		 * @param name
		 * @return a List of Teacher
		 */
		public List<Enseignant> getEnseignantsByName(String universityCode, String name);

		/**
		 * @param universityCode
		 * @param name
		 * @param firstName
		 * @param codeAffectation
		 * @return List<Enseignant>
		 */
		public List<Enseignant> getEnseignantsByName(String universityCode, String name, String firstName, String codeAffectation);



}
