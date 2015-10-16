/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.EtudiantDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;

/**
 * Etudiant Domain service interface.
 */
/**
 * @author Danielle Martineau : danielle.martineau@univ-rennes1.fr
 *
 */
public interface EtudiantDomainService extends Serializable {
	
	/**
	 * @return List<EtudiantDTO>
	 */
	public List<EtudiantDTO> getEtudiants();
	
	/**
	 * @param id
	 * @return EtudiantDTO
	 */
	public EtudiantDTO getEtudiantFromId(int id);
	
	/**
	 * @param etudiant
	 * @return int
	 * @throws DataAddException
	 * @throws WebServiceDataBaseException
	 */
	public int addEtudiant(EtudiantDTO etudiant) throws DataAddException, WebServiceDataBaseException;
	
	/**
	 * @param etudiant
	 * @return boolean
	 * @throws DataUpdateException
	 * @throws WebServiceDataBaseException
	 */
	public boolean updateEtudiant(EtudiantDTO etudiant) throws DataUpdateException, WebServiceDataBaseException;
	
	/**
	 * @param idEtudiant
	 * @return boolean
	 * @throws DataDeleteException
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteEtudiant(int idEtudiant) throws DataDeleteException, WebServiceDataBaseException;
	
	
	//////// Modification grenoble
	/**
	 * 
	 * @param UID
	 * @return EtudiantDTO
	 */
	public EtudiantDTO getEtudiantFromUID(String UID);
	
	/**
	 * @param uidEtudiant
	 * @param codeUniversite
	 * @return
	 */
	public EtudiantDTO getEtudiantFromUid(String uidEtudiant, String codeUniversite);
	
}
