/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.CentreGestionSuperviseurDTO;
import org.esupportail.pstagedata.exceptions.CentreEntrepriseDejaExistantException;
import org.esupportail.pstagedata.exceptions.CentreEtablissementDejaExistantException;
import org.esupportail.pstagedata.exceptions.CentreReferenceException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;

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
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 * @throws CentreEtablissementDejaExistantException 
	 * @throws CentreEntrepriseDejaExistantException 
	 */
	public int addCentreGestion(CentreGestionDTO cg) throws DataAddException, WebServiceDataBaseException,CentreEtablissementDejaExistantException,CentreEntrepriseDejaExistantException;
	/**
	 * @param cg
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 * @throws CentreEtablissementDejaExistantException 
	 * @throws CentreEntrepriseDejaExistantException 
	 */
	public boolean updateCentreGestion(CentreGestionDTO cg) throws DataUpdateException,WebServiceDataBaseException,CentreEtablissementDejaExistantException,CentreEntrepriseDejaExistantException;
	/**
	 * @param idCentreGestion
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 * @throws CentreReferenceException
	 */
	public boolean deleteCentreGestion(int idCentreGestion) throws DataDeleteException,WebServiceDataBaseException,CentreReferenceException;
	
	/**
	 * @return List<CentreGestionSuperviseurDTO>
	 */
	public List<CentreGestionSuperviseurDTO> getCentreGestionSuperviseur();
	
	/**
	 * @param cg
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addCentreGestionSuperviseur(CentreGestionSuperviseurDTO cg) throws DataAddException,WebServiceDataBaseException;
	
	/**
	 * @param idCentreGestion 
	 * @param idFichier 
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean updateIdFichier(int idCentreGestion, int idFichier) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @param idCentreGestion
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean setIdFichierNull(int idCentreGestion) throws DataUpdateException,WebServiceDataBaseException;

}
