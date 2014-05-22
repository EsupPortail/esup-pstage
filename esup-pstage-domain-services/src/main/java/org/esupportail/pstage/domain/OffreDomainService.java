/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.CritereRechercheOffreDTO;
import org.esupportail.pstagedata.domain.dto.DureeDiffusionDTO;
import org.esupportail.pstagedata.domain.dto.FichierDTO;
import org.esupportail.pstagedata.domain.dto.OffreDTO;
import org.esupportail.pstagedata.domain.dto.OffreDiffusionDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;

/**
 * The OffreDomainService service interface.
 */
public interface OffreDomainService extends Serializable {
	/* ****************************************************************************
	 * OFFRE
	 *****************************************************************************/
	/**
	 * @return List<String>
	 */
	public List<String> getAnneesUnivOffres();

	/**
	 * @param idCentreGestion
	 * @return int
	 */
	public int getNombreOffreByCentreGestion(int idCentreGestion);
	
	/**
	 * @param idStructure
	 * @param idsCentreGestion 
	 * @param isEtudiant 
	 * @return List<OffreDTO>
	 */
	public List<OffreDTO> getOffresFromIdStructureAndIdsCentreGestion(int idStructure, List<Integer> idsCentreGestion, boolean isEtudiant);
	/**
	 * @param id
	 * @return OffreDTO
	 */
	public OffreDTO getOffreFromId(int id);
	
	/**
	 * @param critereRechercheOffre
	 * @return List<OffreDTO>
	 */
	public List<OffreDTO> getOffresFromCriteres(CritereRechercheOffreDTO critereRechercheOffre);
	/**
	 * @param o
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addOffre(OffreDTO o) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @param o
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateOffre(OffreDTO o) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idOffre
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean deleteOffreLogique(int idOffre) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idOffre
	 * @param loginValidation
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateValidationOffre(int idOffre, String loginValidation) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idOffre
	 * @param loginStopValidation
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateStopValidationOffre(int idOffre, String loginStopValidation) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idOffre
	 * @param loginDffusion
	 * @param dateFinDiffusion 
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateDiffusionOffre(int idOffre, String loginDffusion, Date dateFinDiffusion) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idOffre
	 * @param loginStopDiffusion
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateStopDiffusionOffre(int idOffre, String loginStopDiffusion) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idOffre
	 * @param loginRejetValidation
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateRejetOffre(int idOffre, String loginRejetValidation) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @param idOffre
	 * @param estPourvue
	 * @return boolean
	 * @throws DataUpdateException
	 * @throws WebServiceDataBaseException
	 */
	public boolean updateOffrePourvue(int idOffre, boolean estPourvue) throws DataUpdateException, WebServiceDataBaseException;
	/* ****************************************************************************
	 * OFFRE MODE CANDIDATURE
	 *****************************************************************************/
	/**
	 * @param idOffre
	 * @param idsModeCandidature 
	 * @return int
	 * @throws DataAddException 
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addOffreModeCandidature(int idOffre, List<Integer> idsModeCandidature) throws DataAddException, DataDeleteException, WebServiceDataBaseException;
	
	/**
	 * @param idOffre
	 * @return boolean
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean deleteOffreModeCandidatureFromId(int idOffre) throws DataAddException, WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @param idsCentreGestion
	 */
	public int countOffreADiffuser(List<Integer> idsCentreGestion);
	/* ****************************************************************************
	 * FICHIERS
	 *****************************************************************************/
	
	/**
	 * @param idFichier
	 * @return OffreFichier
	 */
	public FichierDTO getFichierFromIdFichier(int idFichier);
	
	/**
	 * @param o
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addFichier(FichierDTO o) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @param o
	 * @return boolean
	 * @throws DataUpdateException
	 * @throws WebServiceDataBaseException
	 */
	public boolean updateFichier(FichierDTO o) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idFichier
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean deleteFichier(int idFichier) throws DataDeleteException, WebServiceDataBaseException;
	
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean cleanFichiers() throws DataDeleteException, WebServiceDataBaseException;
	
	/* ****************************************************************************
	 * OFFRE DIFFUSION
	 *****************************************************************************/
	/**
	 * @return List<OffreDiffusionDTO>
	 * @param idOffre
	 */
	public List<OffreDiffusionDTO> getOffreDiffusionFromIdOffre(int idOffre);
	/**
	 * @param lod
	 * @return int
	 * @throws DataAddException
	 * @throws DataDeleteException
	 * @throws WebServiceDataBaseException
	 */
	public int addOffreDiffusion(List<OffreDiffusionDTO> lod) throws DataAddException, DataDeleteException, WebServiceDataBaseException;
	
	/**
	 * @param idOffre
	 * @return boolean
	 * @throws DataDeleteException
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteOffreDiffusionFromId(int idOffre) throws DataDeleteException, WebServiceDataBaseException;
	
	/**
	 * @return List<DureeDiffusionDTO>
	 */
	public List<DureeDiffusionDTO> getDureeDiffusion();
}
