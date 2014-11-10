/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.CritereGestionDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;

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
	 * @param codeEtape
	 * @return CritereGestionDTO
	 */
	public CritereGestionDTO getCritereGestionSansVetFromCodeEtape(String codeEtape);
	/**
	 * @param idCentreGestion
	 * @return int
	 */
	public int getNombreCritereGestion(int idCentreGestion);
	/**
	 * @param critere
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException
	 */
	public int addCritere(CritereGestionDTO critere) throws DataAddException,WebServiceDataBaseException;
	/**
	 * @param codeCritere
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteCritere(String codeCritere) throws DataDeleteException,WebServiceDataBaseException;
	
}
