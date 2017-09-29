/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.AffectationDTO;
import org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO;
import org.esupportail.pstagedata.exceptions.AffectationAlreadyExistingForCodeException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.PersonalAlreadyExistingForCentreException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;


/**
 * PersonnelCentreGestion Domain service interface.
 */
/**
 * @author Florian Garot : florian.garot@univ-artois.fr
 *
 */
public interface PersonnelCentreGestionDomainService extends Serializable {

	/**
	 * @param idCentreGestion
	 * @return List<PersonnelCentreGestionDTO>
	 */
	public List<PersonnelCentreGestionDTO> getPersonnelCentreGestionList(int idCentreGestion);
	/**
	 * @param idCentreGestion
	 * @return int
	 */
	public int getNombrePersonnelCentreGestion(int idCentreGestion);
	/**
	 * @param idPersonnelCentreGestion
	 * @return PersonnelCentreGestionDTO
	 */
	public PersonnelCentreGestionDTO getPersonnelCentreGestion(int idPersonnelCentreGestion);

	/**
	 * @param idCentreGestion
	 * @return List<PersonnelCentreGestionDTO>
	 */
	public List<PersonnelCentreGestionDTO> getInterlocuteur(int idCentreGestion);

	/**
	 * @param uidPersonnelCentreGestion, idCentreGestion
	 * @return List<PersonnelCentreGestionDTO>
	 */
	public PersonnelCentreGestionDTO getPersonnelCentreGestionFromUidAndCentre(String uidPersonnelCentreGestion, int idCentreGestion);

	/**
	 * @param uidPersonnel, codeUniversite
	 * @return List<PersonnelCentreGestionDTO>
	 */
	public List<PersonnelCentreGestionDTO> getPersonnelCentreGestionFromUid(String uidPersonnel,String codeUniversite);

	/**
	 * @param nom, codeUniversite
	 * @return PersonnelCentreGestionDTO
	 */
	public PersonnelCentreGestionDTO getPersonnelCentreGestionFromNom(String nom, String codeUniversite);
	  
	/**
	 * @param pg
	 * @return int
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public int addPersonnelCentreGestion(PersonnelCentreGestionDTO pg) throws DataAddException,WebServiceDataBaseException,PersonalAlreadyExistingForCentreException;

	/**
	 * @param cp
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean updatePersonnelCentreGestion(PersonnelCentreGestionDTO pg) throws DataUpdateException,WebServiceDataBaseException;

	/**
	 * @param idCentreGestion
	 * @param idPersonnelCentreGestion
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deletePersonnelCentreGestion(int idCentreGestion, int idPersonnelCentreGestion) throws DataDeleteException,WebServiceDataBaseException;
	/**
	 * @return int
	 */
	public int getNombreAffectation();
	/**
	 * @param a
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException
	 */
	public int addAffectation(AffectationDTO a) throws DataAddException,WebServiceDataBaseException,AffectationAlreadyExistingForCodeException;

}
