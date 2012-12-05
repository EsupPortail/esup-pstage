/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.esupportail.pstagedata.remote.CritereRechercheOffreDTO;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.DureeDiffusionDTO;
import org.esupportail.pstagedata.remote.FichierDTO;
import org.esupportail.pstagedata.remote.OffreDTO;
import org.esupportail.pstagedata.remote.OffreDiffusionDTO;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;

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
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public int addOffre(OffreDTO o) throws DataAddException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param o
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateOffre(OffreDTO o) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idOffre
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean deleteOffreLogique(int idOffre) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idOffre
	 * @param loginValidation
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateValidationOffre(int idOffre, String loginValidation) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idOffre
	 * @param loginStopValidation
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateStopValidationOffre(int idOffre, String loginStopValidation) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idOffre
	 * @param loginDffusion
	 * @param dateFinDiffusion 
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateDiffusionOffre(int idOffre, String loginDffusion, Date dateFinDiffusion) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idOffre
	 * @param loginStopDiffusion
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateStopDiffusionOffre(int idOffre, String loginStopDiffusion) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idOffre
	 * @param loginRejetValidation
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateRejetOffre(int idOffre, String loginRejetValidation) throws DataUpdateException_Exception,WebServiceDataBaseException_Exception;
	/**
	 * @param idOffre
	 * @param estPourvue
	 * @return boolean
	 * @throws DataUpdateException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean updateOffrePourvue(int idOffre, boolean estPourvue) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/* ****************************************************************************
	 * OFFRE MODE CANDIDATURE
	 *****************************************************************************/
	/**
	 * @param idOffre
	 * @param idsModeCandidature 
	 * @return int
	 * @throws DataAddException_Exception 
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public int addOffreModeCandidature(int idOffre, List<Integer> idsModeCandidature) throws DataAddException_Exception, DataDeleteException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @param idOffre
	 * @return boolean
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean deleteOffreModeCandidatureFromId(int idOffre) throws DataAddException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @return int
	 */
	public int countOffreADiffuser();
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
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public int addFichier(FichierDTO o) throws DataAddException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param o
	 * @return boolean
	 * @throws DataUpdateException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean updateFichier(FichierDTO o) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idFichier
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean deleteFichier(int idFichier) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean cleanFichiers() throws DataDeleteException_Exception, WebServiceDataBaseException_Exception;
	
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
	 * @throws DataAddException_Exception
	 * @throws DataDeleteException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public int addOffreDiffusion(List<OffreDiffusionDTO> lod) throws DataAddException_Exception, DataDeleteException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @param idOffre
	 * @return boolean
	 * @throws DataDeleteException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean deleteOffreDiffusionFromId(int idOffre) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @return List<DureeDiffusionDTO>
	 */
	public List<DureeDiffusionDTO> getDureeDiffusion();
}
