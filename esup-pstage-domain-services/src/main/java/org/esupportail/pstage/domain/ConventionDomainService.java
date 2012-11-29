/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.remote.ConventionDTO;
import org.esupportail.pstagedata.remote.CritereRechercheConventionDTO;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.EtapeAlreadyExistingForCodeException_Exception;
import org.esupportail.pstagedata.remote.EtapeDTO;
import org.esupportail.pstagedata.remote.UfrAlreadyExistingForCodeException_Exception;
import org.esupportail.pstagedata.remote.UfrDTO;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;

/**
 * @author Danielle Martineau : danielle.martineau@univ-rennes1.fr
 *
 */

/**
 * ConventionDomainService interface.
 */
public interface ConventionDomainService extends Serializable {
	
	/**
	 * @param codeUniversite 
	 * @return List<ConventionDTO>
	 */
	public List<ConventionDTO> getConventions(String codeUniversite);
	
	/**
	 * @param id
	 * @return ConventionDTO
	 */
	public ConventionDTO getConventionFromId(int id);
	/**
	 * @param codeUniversite 
	 * @return List<String>
	 */
	public List<String> getAnneesConvention(String codeUniversite);
	
	/**
	 * @param critereRechercheConvention
	 * @return List<ConventionDTO>
	 */
	public List<ConventionDTO> getConventionsFromCriteres(CritereRechercheConventionDTO critereRechercheConvention);
	
	/**
	 * @param idEnseignant 
	 * @param critereRechercheConvention
	 * @return List<ConventionDTO>
	 */
	public List<ConventionDTO> getConventionsFromCriteresByEnseignantTuteur(int idEnseignant, CritereRechercheConventionDTO critereRechercheConvention);
	

	/**
	 * @param critereRechercheConvention
	 * @return List<ConventionDTO>
	 */
	public List<ConventionDTO> getConventionsFromCriteresExport(CritereRechercheConventionDTO critereRechercheConvention);
	
	/**
	 * @param id
	 * @return ConventionDTO pour export
	 */
	public ConventionDTO getConventionFromExport(int id);


	/**
	 * @param identEtudiant
	 * @param codeUniversite 
	 * @return List<ConventionDTO>
	 */
	public List<ConventionDTO> getConventionsEtudiant(String identEtudiant, String codeUniversite);
	
	/**
	 * @param idCentreGestion
	 * @param codeUniversite 
	 * @return int
	 */
	public int getNombreConventionByCentreGestion(int idCentreGestion, String codeUniversite);
	
	/**
	 * @param idEnseignant
	 * @param annee
	 * @return List<ConventionDTO>
	 */
	public List<ConventionDTO> getConventionsByEnseignant(int idEnseignant, String annee);
	/**
	 * @param convention
	 * @return int
	 * @throws DataAddException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public int addConvention(ConventionDTO convention) throws DataAddException_Exception, WebServiceDataBaseException_Exception;

	/**
	 * @param convention
	 * @return boolean
	 * @throws DataUpdateException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean updateConvention(ConventionDTO convention) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;

	/**
	 * @param code 
	 * @param idCentreGestion 
	 * @param codeUniversite 
	 * @return boolean
	 * @throws DataUpdateException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean updateCentreConventionByUfr(String code, int idCentreGestion, String codeUniversite) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param code 
	 * @param idCentreGestion 
	 * @param codeUniversite 
	 * @return boolean
	 * @throws DataUpdateException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean updateCentreConventionByEtape(String code, int idCentreGestion, String codeUniversite) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @param idConvention
	 * @return boolean
	 * @throws DataDeleteException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean deleteConvention(int idConvention) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @param idsCentreGestion
	 * @param codeUniversite 
	 * @return List<EtapeDTO>
	 */
	public List<EtapeDTO> getEtapesFromIdsCentreGestion(List<Integer> idsCentreGestion, String codeUniversite);

	/**
	 * @param idsCentreGestion
	 * @param codeUniversite 
	 * @return List<UfrDTO>
	 */
	public List<UfrDTO> getUfrsFromIdsCentreGestion(List<Integer> idsCentreGestion, String codeUniversite);
	
	
	/**
	 * @param etape
	 * @return int
	 * @throws DataAddException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 * @throws EtapeAlreadyExistingForCodeException_Exception 
	 */
	public int addEtape(EtapeDTO etape) throws DataAddException_Exception, WebServiceDataBaseException_Exception, EtapeAlreadyExistingForCodeException_Exception;
	
	/**
	 * @param code
	 * @param codeUniversite 
	 * @return EtapeDTO
	 */
	public EtapeDTO getEtapeFromId(String code, String codeUniversite);

	/**
	 * @param code
	 * @param codeUniversite 
	 * @return UfrDTO
	 */
	public UfrDTO getUfrFromId(String code, String codeUniversite);
	
	/**
	 * @param ufr
	 * @return int
	 * @throws DataAddException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 * @throws UfrAlreadyExistingForCodeException_Exception 
	 */
	public int addUfr(UfrDTO ufr) throws DataAddException_Exception, WebServiceDataBaseException_Exception, UfrAlreadyExistingForCodeException_Exception;
	
	/**
	 * @param codeEtape 
	 * @param codeUniversite 
	 * @return String
	 */
	public String getCodeUFRFromCodeEtape(String codeEtape, String codeUniversite);
}
