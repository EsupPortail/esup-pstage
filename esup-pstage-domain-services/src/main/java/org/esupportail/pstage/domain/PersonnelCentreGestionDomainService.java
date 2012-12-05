/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.remote.AffectationAlreadyExistingForCodeException_Exception;
import org.esupportail.pstagedata.remote.AffectationDTO;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.PersonalAlreadyExistingForCentreException_Exception;
import org.esupportail.pstagedata.remote.PersonnelCentreGestionDTO;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;


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
	 * @param idPersonnelCentreGestion, idCentreGestion
	 * @return List<PersonnelCentreGestionDTO>
	 */
	public PersonnelCentreGestionDTO getPersonnelCentreGestionFromIdAndCentre(int idPersonnelCentreGestion, int idCentreGestion);

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
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception
	 */
	public int addPersonnelCentreGestion(PersonnelCentreGestionDTO pg) throws DataAddException_Exception,WebServiceDataBaseException_Exception,PersonalAlreadyExistingForCentreException_Exception;

	/**
	 * @param cp
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean updatePersonnelCentreGestion(PersonnelCentreGestionDTO pg) throws DataUpdateException_Exception,WebServiceDataBaseException_Exception;

	/**
	 * @param idCentreGestion
	 * @param idPersonnelCentreGestion
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean deletePersonnelCentreGestion(int idCentreGestion, int idPersonnelCentreGestion) throws DataDeleteException_Exception,WebServiceDataBaseException_Exception;
	/**
	 * @return int
	 */
	public int getNombreAffectation();
	/**
	 * @param a
	 * @return int
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception
	 */
	public int addAffectation(AffectationDTO a) throws DataAddException_Exception,WebServiceDataBaseException_Exception,AffectationAlreadyExistingForCodeException_Exception;

}
