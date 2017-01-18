/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.util.List;

import org.esupportail.pstagedata.domain.dto.AffectationDTO;
import org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO;
import org.esupportail.pstagedata.exceptions.AffectationAlreadyExistingForCodeException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.PersonalAlreadyExistingForCentreException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.esupportail.pstagedata.remote.RemoteServices;
import org.springframework.dao.DataAccessException;


/**
 * PersonnelCentreGestion Domain service impl.
 */
/**
 * @author Florian Garot : florian.garot@univ-artois.fr
 *
 */
public class PersonnelCentreGestionDomainServiceImpl implements PersonnelCentreGestionDomainService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Code Universite
	 */
	String codeUniversite;
	
	/**
	 * ListeDomainService
	 */
	private NomenclatureDomainService nomenclatureDomainService;
	
	/**
	 * @return the nomenclatureDomainService
	 */
	public NomenclatureDomainService getNomenclatureDomainService() {
		return nomenclatureDomainService;
	}
	
	/**
	 * @param nomenclatureDomainService the nomenclatureDomainService to set
	 */
	public void setNomenclatureDomainService(
			NomenclatureDomainService nomenclatureDomainService) {
		this.nomenclatureDomainService = nomenclatureDomainService;
	}
	
	/**
	 * CentreGestionDomainService
	 */
	private CentreGestionDomainService centreGestionDomainService;
	
	/**
	 * @return the centreGestionDomainService
	 */
	public CentreGestionDomainService getCentreGestionDomainService() {
		return centreGestionDomainService;
	}
	/**
	 * @param CentreGestionDomainService the CentreGestionDomainService to set
	 */
	public void setCentreGestionDomainService(CentreGestionDomainService centreGestionDomainService) {
		this.centreGestionDomainService = centreGestionDomainService;
	}
	/**
	 * RemoteServices
	 */
	private RemoteServices remoteServices;
	
	/**
	 * @return the remoteServices
	 */
	public RemoteServices getRemoteServices(){
		return remoteServices;
	}

	/**
	 * @param remoteServices the remoteServices to set
	 */
	public void setRemoteServices(RemoteServices remoteServices) {
		this.remoteServices = remoteServices;
	}

	/**
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#getPersonnelCentreGestionList(int)
	 */
	public List<PersonnelCentreGestionDTO> getPersonnelCentreGestionList(int idCentreGestion){
		List<PersonnelCentreGestionDTO> l = this.remoteServices.getPersonnelCentreGestionList(idCentreGestion);
		setObjectsForPersonnel(l);
		return l;
	}
	/**
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#getNombrePersonnelCentreGestion(int)
	 */
	public int getNombrePersonnelCentreGestion(int idCentreGestion){
		return this.remoteServices.getNombrePersonnelCentreGestion(idCentreGestion);
	}
	/**
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#getPersonnelCentreGestion(int)
	 */
	public PersonnelCentreGestionDTO getPersonnelCentreGestion(int idPersonnelCentreGestion){
		PersonnelCentreGestionDTO p = this.remoteServices.getPersonnelCentreGestion(idPersonnelCentreGestion);
		setObjectsForPersonnel(p);
		return p;
	}

	/**
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#getInterlocuteur(int)
	 */
	public List<PersonnelCentreGestionDTO> getInterlocuteur(int idCentreGestion){
		List <PersonnelCentreGestionDTO> l = this.remoteServices.getInterlocuteur(idCentreGestion);
		setObjectsForPersonnel(l);
		return l;
	}

	/**
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#getPersonnelCentreGestionFromUidAndCentre(String,int)
	 */
	public PersonnelCentreGestionDTO getPersonnelCentreGestionFromUidAndCentre(String uidPersonnelCentreGestion, int idCentreGestion){
		PersonnelCentreGestionDTO p = this.remoteServices.getPersonnelCentreGestionFromUidAndCentre(uidPersonnelCentreGestion, idCentreGestion);
		setObjectsForPersonnel(p);
		return p;
	}

	/**
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#getPersonnelCentreGestionFromUid(String,String)
	 */
	public List<PersonnelCentreGestionDTO> getPersonnelCentreGestionFromUid(String uidPersonnel,String codeUniversite){
		List<PersonnelCentreGestionDTO> l = this.remoteServices.getPersonnelCentreGestionFromUid(uidPersonnel, codeUniversite);
		setObjectsForPersonnel(l);
		return l;
	}

	/**
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#getPersonnelCentreGestionFromNom(String,String)
	 */
	public PersonnelCentreGestionDTO getPersonnelCentreGestionFromNom(String nom, String codeUniversite){
		PersonnelCentreGestionDTO p = this.remoteServices.getPersonnelCentreGestionFromNom(nom, codeUniversite);
		setObjectsForPersonnel(p);
		return p;
	}
	  
	/**
	 * @throws PersonalAlreadyExistingForCentreException 
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#addPersonnelCentreGestion(org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO)
	 */
	public int addPersonnelCentreGestion(PersonnelCentreGestionDTO pg) throws DataAccessException, WebServiceDataBaseException, DataAddException, PersonalAlreadyExistingForCentreException{
		return this.remoteServices.addPersonnelCentreGestion(pg);
	}

	/**
	 * @throws WebServiceDataBaseException 
	 * @throws DataUpdateException 
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#updatePersonnelCentreGestion(org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO)
	 */
	public boolean updatePersonnelCentreGestion(PersonnelCentreGestionDTO pg) throws DataAccessException, DataUpdateException, WebServiceDataBaseException{
		return this.remoteServices.updatePersonnelCentreGestion(pg);
	}

	/**
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException 
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#deletePersonnelCentreGestion(int)
	 */
	public boolean deletePersonnelCentreGestion(int idCentreGestion, int idPersonnelCentreGestion) throws DataAccessException, WebServiceDataBaseException, DataDeleteException{
		return this.remoteServices.deletePersonnelCentreGestion(idCentreGestion, idPersonnelCentreGestion);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#getNombreAffectation()
	 */
	public int getNombreAffectation(){
		return this.remoteServices.getNombreAffectation();
	}
	
	/**
	 * @throws AffectationAlreadyExistingForCodeException 
	 * @see org.esupportail.pstage.domain.PersonnelCentreGestionDomainService#addAffectation(org.esupportail.pstagedata.domain.dto.AffectationDTO)
	 */ 
	public int addAffectation(AffectationDTO a) throws DataAddException,WebServiceDataBaseException, AffectationAlreadyExistingForCodeException{
		return this.remoteServices.addAffectation(a);
	}
	
	/**
	 * Rempli les divers objets (Pays, TypeStructure, ...) depuis les listes en caches
	 * @param ls
	 */
	public void setObjectsForPersonnel(List<PersonnelCentreGestionDTO> lp){
		if(lp!=null){
			for(PersonnelCentreGestionDTO p : lp){
				setObjectsForPersonnel(p);
			}
		}
	}
	
	/**
	 * Rempli les divers objets depuis les listes en caches
	 * @param s
	 */
	public void setObjectsForPersonnel(PersonnelCentreGestionDTO p){
		if(p!=null){
			if (p.getCodeAffectation() != null)
				p.setAffectation(this.nomenclatureDomainService.getAffectationFromCode(p.getCodeAffectation(), codeUniversite));
			if (p.getIdDroitAdmin() > 0)
				p.setDroitAdmin(this.nomenclatureDomainService.getDroitAdministrationFromId(p.getIdDroitAdmin()));
			if (p.getIdCentreGestion() > 0)
				p.setCentreGestion(this.centreGestionDomainService.getCentreGestion(p.getIdCentreGestion()));
			if (p.getIdCivilite() > 0)
				p.setCivilite(this.nomenclatureDomainService.getCiviliteFromId(p.getIdCivilite()));
		}
	}

	/**
	 * @return the codeUniversite
	 */
	public String getCodeUniversite() {
		return codeUniversite;
	}

	/**
	 * @param codeUniversite the codeUniversite to set
	 */
	public void setCodeUniversite(String codeUniversite) {
		this.codeUniversite = codeUniversite;
	}
	
	
}
