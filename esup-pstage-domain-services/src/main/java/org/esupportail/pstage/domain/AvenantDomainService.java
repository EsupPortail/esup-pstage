/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.remote.AvenantDTO;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;


/**
 * Avenant Domain service interface.
 */
/**
 * @author Florian Garot : florian.garot@univ-artois.fr
 *
 */
public interface AvenantDomainService extends Serializable {
	
	/**
	 * @return List<AvenantDTO>
	 */
	public List<AvenantDTO> getAvenant(int idConvention);

	/**
	 * @return int
	 */
	public int getNombreAvenant(int idConvention);
	
	/**
	 * @param a
	 * @return int
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public int addAvenant(AvenantDTO a) throws DataAddException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param a
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateAvenant(AvenantDTO a) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idAvenant
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean deleteAvenant(int idAvenant) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception;

}
