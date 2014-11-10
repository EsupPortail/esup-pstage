/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.ConventionDTO;
import org.esupportail.pstagedata.domain.dto.CritereRechercheConventionDTO;
import org.esupportail.pstagedata.domain.dto.EtapeDTO;
import org.esupportail.pstagedata.domain.dto.UfrDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.EtapeAlreadyExistingForCodeException;
import org.esupportail.pstagedata.exceptions.UfrAlreadyExistingForCodeException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;

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
	 * @param idsConventionsExport
	 * @return List<ConventionDTO> pour export
	 */
	public List<ConventionDTO> getConventionsFromExport(List<Integer> idsConventionsExport);


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
	 * @throws DataAddException
	 * @throws WebServiceDataBaseException
	 */
	public int addConvention(ConventionDTO convention) throws DataAddException, WebServiceDataBaseException;

	/**
	 * @param convention
	 * @return boolean
	 * @throws DataUpdateException
	 * @throws WebServiceDataBaseException
	 */
	public boolean updateConvention(ConventionDTO convention) throws DataUpdateException, WebServiceDataBaseException;

	/**
	 * @param code 
	 * @param idCentreGestion 
	 * @param codeUniversite 
	 * @return boolean
	 * @throws DataUpdateException
	 * @throws WebServiceDataBaseException
	 */
	public boolean updateCentreConventionByUfr(String code, int idCentreGestion, String codeUniversite) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param code 
	 * @param idCentreGestion 
	 * @param codeUniversite 
	 * @return boolean
	 * @throws DataUpdateException
	 * @throws WebServiceDataBaseException
	 */
	public boolean updateCentreConventionByEtape(String code, int idCentreGestion, String codeUniversite) throws DataUpdateException, WebServiceDataBaseException;
	
	/**
	 * @param idConvention
	 * @return boolean
	 * @throws DataDeleteException
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteConvention(int idConvention) throws DataDeleteException, WebServiceDataBaseException;
	
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
	 * @throws DataAddException
	 * @throws WebServiceDataBaseException
	 * @throws EtapeAlreadyExistingForCodeException 
	 */
	public int addEtape(EtapeDTO etape) throws DataAddException, WebServiceDataBaseException, EtapeAlreadyExistingForCodeException;
	
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
	 * @throws DataAddException
	 * @throws WebServiceDataBaseException
	 * @throws UfrAlreadyExistingForCodeException 
	 */
	public int addUfr(UfrDTO ufr) throws DataAddException, WebServiceDataBaseException, UfrAlreadyExistingForCodeException;
	
	/**
	 * @param codeEtape 
	 * @param codeUniversite 
	 * @return String
	 */
	public String getCodeUFRFromCodeEtape(String codeEtape, String codeUniversite);
	
	/**
	 * @param codeEtape 
	 * @param codeVersionEtape
	 * @return broolean
	 */
	public boolean updateConventionSetCodeVersionEtape(String codeEtape, String codeVersionEtape);
}
