/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.AvenantDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;


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
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addAvenant(AvenantDTO a) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @param a
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateAvenant(AvenantDTO a) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idAvenant
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean deleteAvenant(int idAvenant) throws DataDeleteException, WebServiceDataBaseException;

}
