/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.remote.CentreEntrepriseDejaExistantException_Exception;
import org.esupportail.pstagedata.remote.CentreEtablissementDejaExistantException_Exception;
import org.esupportail.pstagedata.remote.CentreGestionDTO;
import org.esupportail.pstagedata.remote.CentreGestionSuperviseurDTO;
import org.esupportail.pstagedata.remote.CentreReferenceException_Exception;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public interface CentreGestionDomainService extends Serializable {
	/* ****************************************************************************
	 * CENTRE GESTION
	 *****************************************************************************/
	/**
	 * @param codeUniversite
	 * @return List<CentreGestion>
	 */
	public List<CentreGestionDTO> getCentreGestionList(String codeUniversite);
	/**
	 * @param idCentreGestion
	 * @return CentreGestionDTO
	 */
	public CentreGestionDTO getCentreGestion(int idCentreGestion);
	/**
	 * @param nomCentre 
	 * @param codeUniversite
	 * @return CentreGestionDTO
	 */
	public CentreGestionDTO getCentreGestionFromNomCentre(String nomCentre, String codeUniversite);
	
	/**
	 * @param codeUniversite
	 * @return int
	 */
	public int getNombreCentreGestion(String codeUniversite);
	
	/**
	 * Rï¿½cupï¿½re les centres de gestion correspondant ï¿½ l'uid ldap d'un personnel
	 * ayant les droits en ecriture ou en admin pour ces centres
	 * 
	 * @param uidPersonnel
	 * @param codeUniversite 
	 * @return List<CentreGestionDTO>
	 */
	public List<CentreGestionDTO> getCentreDroitEcriture(String uidPersonnel, String codeUniversite);
	/**
	 * Rï¿½cupï¿½re les centres de gestion correspondant ï¿½ l'uid ldap d'un personnel
	 * ayant des droits pour ces centres
	 * 
	 * @param uidPersonnel
	 * @param codeUniversite 
	 * @return List<CentreGestionDTO>
	 */
	public List<CentreGestionDTO> getCentreFromUid(String uidPersonnel, String codeUniversite);
	
	/**
	 * @param codeCritere
	 * @param codeUniversite
	 * @return CentreGestionDTO
	 */
	public CentreGestionDTO getCentreFromCritere(String codeCritere, String codeUniversite);
	
	/**
	 * @return CentreGestionDTO
	 */
	public CentreGestionDTO getCentreEntreprise();
	
	/**
	 * @param codeUniversite 
	 * @return CentreGestionDTO
	 */
	public CentreGestionDTO getCentreEtablissement(String codeUniversite);
	
	/**
	 * @param codeUniversite 
	 * @return List<CentreGestionDTO>
	 */
	public List<CentreGestionDTO> getCentresEtablissement(String codeUniversite);
	
	/**
	 * @param cg
	 * @return int : l'id du centre ajoutï¿½
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws CentreEtablissementDejaExistantException_Exception 
	 * @throws CentreEntrepriseDejaExistantException_Exception 
	 */
	public int addCentreGestion(CentreGestionDTO cg) throws DataAddException_Exception, WebServiceDataBaseException_Exception,CentreEtablissementDejaExistantException_Exception,CentreEntrepriseDejaExistantException_Exception;
	/**
	 * @param cg
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws CentreEtablissementDejaExistantException_Exception 
	 * @throws CentreEntrepriseDejaExistantException_Exception 
	 */
	public boolean updateCentreGestion(CentreGestionDTO cg) throws DataUpdateException_Exception,WebServiceDataBaseException_Exception,CentreEtablissementDejaExistantException_Exception,CentreEntrepriseDejaExistantException_Exception;
	/**
	 * @param idCentreGestion
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception
	 * @throws CentreReferenceException_Exception
	 */
	public boolean deleteCentreGestion(int idCentreGestion) throws DataDeleteException_Exception,WebServiceDataBaseException_Exception,CentreReferenceException_Exception;
	
	/**
	 * @return List<CentreGestionSuperviseurDTO>
	 */
	public List<CentreGestionSuperviseurDTO> getCentreGestionSuperviseur();
	
	/**
	 * @param cg
	 * @return int
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public int addCentreGestionSuperviseur(CentreGestionSuperviseurDTO cg) throws DataAddException_Exception,WebServiceDataBaseException_Exception;
	
	/**
	 * @param idCentreGestion 
	 * @param idFichier 
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean updateIdFichier(int idCentreGestion, int idFichier) throws DataUpdateException_Exception,WebServiceDataBaseException_Exception;
	/**
	 * @param idCentreGestion
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean setIdFichierNull(int idCentreGestion) throws DataUpdateException_Exception,WebServiceDataBaseException_Exception;

}
