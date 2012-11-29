/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.remote.CritereGestionDTO;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;

/**
 * @author Florian Garot : florian.garot@univ-artois.fr
 *
 */
public interface CritereGestionDomainService extends Serializable {

	
	/**
	 * @return List<CritereGestionDTO>
	 */
	public List<CritereGestionDTO> getCritereGestion();
	/**
	 * @param idCentreGestion
	 * @return CritereGestionDTO
	 */
	public List<CritereGestionDTO> getCritereGestionFromIdCentre(int idCentreGestion);
	/**
	 * @param idCentreGestion
	 * @return int
	 */
	public int getNombreCritereGestion(int idCentreGestion);
	/**
	 * @param critere
	 * @return int
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception
	 */
	public int addCritere(CritereGestionDTO critere) throws DataAddException_Exception,WebServiceDataBaseException_Exception;
	/**
	 * @param codeCritere
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean deleteCritere(String codeCritere) throws DataDeleteException_Exception,WebServiceDataBaseException_Exception;
	
}
