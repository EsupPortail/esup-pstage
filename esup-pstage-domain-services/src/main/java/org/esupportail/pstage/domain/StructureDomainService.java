/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.esupportail.pstagedata.remote.AccordAlreadyExistingForContactException;
import org.esupportail.pstagedata.remote.AccordAlreadyExistingForContactException_Exception;
import org.esupportail.pstagedata.remote.AccordAlreadyExistingForStructureException;
import org.esupportail.pstagedata.remote.AccordAlreadyExistingForStructureException_Exception;
import org.esupportail.pstagedata.remote.AccordPartenariatDTO;
import org.esupportail.pstagedata.remote.AccountAlreadyExistingForCoupleMailStructureException;
import org.esupportail.pstagedata.remote.AccountAlreadyExistingForCoupleMailStructureException_Exception;
import org.esupportail.pstagedata.remote.ContactDTO;
import org.esupportail.pstagedata.remote.ContactDeleteException;
import org.esupportail.pstagedata.remote.ContactDeleteException_Exception;
import org.esupportail.pstagedata.remote.CritereRechercheStructureAdresseDTO;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.MailAlreadyUsedForStructureException;
import org.esupportail.pstagedata.remote.MailAlreadyUsedForStructureException_Exception;
import org.esupportail.pstagedata.remote.ServiceDTO;
import org.esupportail.pstagedata.remote.ServiceDeleteException_Exception;
import org.esupportail.pstagedata.remote.StructureDTO;
import org.esupportail.pstagedata.remote.StructureDeleteException;
import org.esupportail.pstagedata.remote.StructureDeleteException_Exception;
import org.esupportail.pstagedata.remote.StructureNumSiretException;
import org.esupportail.pstagedata.remote.StructureNumSiretException_Exception;
import org.esupportail.pstagedata.remote.TicketStructureDTO;
import org.esupportail.pstagedata.remote.UnvalidNumSiretException;
import org.esupportail.pstagedata.remote.UnvalidNumSiretException_Exception;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;

/**
 * The StructureDaoService service interface.
 */
public interface StructureDomainService extends Serializable {
	/* ****************************************************************************
	 * ACCORD PARTENARIAT
	 *****************************************************************************/
	/**
	 * @return List<AccordPartenariatDTO>
	 */
	public List<AccordPartenariatDTO> getAccordsNonValides();
	/**
	 * @param id 
	 * @return AccordPartenariatDTO
	 */
	public AccordPartenariatDTO getAccordFromId(int id);
	/**
	 * @param idStructure 
	 * @return AccordPartenariatDTO
	 */
	public AccordPartenariatDTO getAccordFromIdStructure(int idStructure);
	/**
	 * @param idContact 
	 * @return AccordPartenariatDTO
	 */
	public AccordPartenariatDTO getAccordFromIdContact(int idContact);
	/**
	 * @return int
	 */
	public int countAccordAValider();
	/**
	 * @param accord
	 * @return int
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws AccordAlreadyExistingForContactException 
	 * @throws AccordAlreadyExistingForStructureException 
	 */
	public int addAccord(AccordPartenariatDTO accord) throws DataAddException_Exception, WebServiceDataBaseException_Exception, AccordAlreadyExistingForContactException_Exception, AccordAlreadyExistingForStructureException_Exception;
	/**
	 * @param accord
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws AccordAlreadyExistingForContactException 
	 * @throws AccordAlreadyExistingForStructureException 
	 */
	public boolean updateAccord(AccordPartenariatDTO accord) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception, AccordAlreadyExistingForContactException_Exception, AccordAlreadyExistingForStructureException_Exception;
	/**
	 * @param idAccord
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean deleteAccord(int idAccord) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception;
	/* ****************************************************************************
	 * CONTACT
	 *****************************************************************************/
	/**
	 * @param id
	 * @return ContactDTO
	 */
	public ContactDTO getContactFromId(int id);
	
	/**
	 * @param idService
	 * @param idsCentresGestion
	 * @param codeUniversite
	 * @return List<ContactDTO>
	 */
	public List<ContactDTO> getContactsFromIdService(int idService, List<Integer> idsCentresGestion, String codeUniversite);
	
	/**
	 * @param login
	 * @return ContactDTO
	 */
	public ContactDTO getContactFromLogin(String login);

	/**
	 * @param mail
	 * @param idStructure
	 * @return ContactDTO
	 */
	public ContactDTO getContactEntrepriseAvecCompteFromMailAndIdStructure(String mail, int idStructure);

	/**
	 * @param idCentreGestion
	 * @return int
	 */
	public int getNombreContactByCentreGestion(int idCentreGestion);
	
	/**
	 * @param c
	 * @return int
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws MailAlreadyUsedForStructureException 
	 */
	public int addContact(ContactDTO c) throws DataAddException_Exception, WebServiceDataBaseException_Exception, MailAlreadyUsedForStructureException_Exception;
	
	/**
	 * @param c
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws MailAlreadyUsedForStructureException 
	 */
	public boolean updateContact(ContactDTO c) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception, MailAlreadyUsedForStructureException_Exception;
	/**
	 * @param c
	 * @return boolean
	 * @throws DataUpdateException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 * @throws AccountAlreadyExistingForCoupleMailStructureException 
	 */
	public boolean updateCompteContact(ContactDTO c) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception, AccountAlreadyExistingForCoupleMailStructureException_Exception;
	/**
	 * @param idContact 
	 * @param loginInfosAJour 
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateContactInfosAJour(int idContact, String loginInfosAJour) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @param idContact 
	 * @param xmlGregorianCalendar 
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateContactDerniereConnexion(int idContact, XMLGregorianCalendar xmlGregorianCalendar) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @param idContact 
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws ContactDeleteException 
	 */
	public boolean deleteContact(int idContact) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception, ContactDeleteException_Exception;
	/* ****************************************************************************
	 * SERVICE
	 *****************************************************************************/
	/**
	 * @param id
	 * @return ServiceDTO
	 */
	public ServiceDTO getServiceFromId(int id);
	/**
	 * @param id
	 * @return ServiceDTO
	 */ 
	public ServiceDTO getServiceFromIdContact(int id);
	/**
	 * @param id
	 * @return List<ServiceDTO>
	 */
	public List<ServiceDTO> getServicesFromIdStructure(int id);
	/**
	 * @param s
	 * @return int
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public int addService(ServiceDTO s) throws DataAddException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param s
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateService(ServiceDTO s) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idService
	 * @param loginInfosAJour
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateServiceInfosAJour(int idService, String loginInfosAJour) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idService
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws ServiceDeleteException 
	 */
	public boolean deleteService(int idService) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception, ServiceDeleteException_Exception;
	/* ****************************************************************************
	 * STRUCTURE
	 *****************************************************************************/
	/**
	 * @param id
	 * @return StructureDTO
	 */
	public StructureDTO getStructureFromId(int id);
	/**
	 * @param id
	 * @return StructureDTO
	 */
	public StructureDTO getStructureFromIdService(int id);
	/**
	 * @param raisonSociale
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresFromRaisonSociale(String raisonSociale);
	/**
	 * @param raisonSociale
	 * @param cog
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresFromRaisonSocialeEtPays(String raisonSociale, int cog);
	/**
	 * @param raisonSociale
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresPaysEtrangerFromRaisonSociale(String raisonSociale);
	/**
	 * @param numeroSiret
	 * @return StructureDTO
	 */
	public StructureDTO getStructureFromNumSiret(String numeroSiret);
	/**
	 * Retourne les structures dont les contacts associï¿½s au centre ENTREPRISE
	 * ont l'adresse mail ï¿½gale ï¿½ "mail" 
	 * @param mail
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructureFromContactMailEntrepriseAvecCompte(String mail);
	/**
	 * @param id
	 * @return StructureDTO
	 */
	public StructureDTO getStructureAvecAccordFromId(int id);
	/**
	 * @param raisonSociale
	 * @param departement
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresFromRaisonSocialeEtDepartement(String raisonSociale, String departement);
	/**
	 * @param numSiren
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresFromNumSiren(String numSiren);
	/**
	 * @param telephone
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresFromTelephone(String telephone);
	/**
	 * @param fax
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresFromFax(String fax);
	/**
	 * @param c
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresFromAdresse(CritereRechercheStructureAdresseDTO c);
	/**
	 * @param nomService
	 * @param departement
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresFromNomServiceEtDepartement(String nomService, String departement);
	/**
	 * @param typeStructure
	 * @param nafN1
	 * @param departement 
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresFromTypeStructureNafN1EtDepartement(int typeStructure, String nafN1, String departement);
	/**
	 * @param raisonSociale
	 * @param dateDebut 
	 * @param dateFin 
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresAvecAccordAValiderFromRaisonSociale(String raisonSociale, Date dateDebut, Date dateFin);
	/**
	 * @param raisonSociale
	 * @param dateDebut 
	 * @param dateFin 
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresAvecAccordValidesFromRaisonSociale(String raisonSociale, Date dateDebut, Date dateFin);
	/**
	 * @param raisonSociale
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresSansAccordFromRaisonSociale(String raisonSociale);
	/**
	 * @param s
	 * @return int
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws UnvalidNumSiretException 
	 * @throws StructureNumSiretException 
	 */
	public int addStructure(StructureDTO s) throws DataAddException_Exception, WebServiceDataBaseException_Exception, UnvalidNumSiretException_Exception, StructureNumSiretException_Exception;
	/**
	 * @param s
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws UnvalidNumSiretException 
	 * @throws StructureNumSiretException 
	 */
	public boolean updateStructure(StructureDTO s) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception, UnvalidNumSiretException_Exception, StructureNumSiretException_Exception;
	/**
	 * @param idStructure
	 * @param loginInfosAJour
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateStructureInfosAJour(int idStructure, String loginInfosAJour) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idStructure 
	 * @param loginValidation
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateStructureValidation(int idStructure, String loginValidation) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idStructure 
	 * @param loginStopValidation
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateStructureStopValidation(int idStructure, String loginStopValidation) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idStructure
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws StructureDeleteException 
	 */
	public boolean deleteStructure(int idStructure) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception, StructureDeleteException_Exception;
	
	/* ****************************************************************************
	 * TICKET STRUCTURE
	 *****************************************************************************/
	/**
	 * @param ticketStructure 
	 * @return boolean
	 */
	public boolean getTicketStructureValide(TicketStructureDTO ticketStructure);

	
	/**
	 * @param ticketStructure
	 * @return int
	 * @throws DataAddException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public int addTicketStructure(TicketStructureDTO ticketStructure) throws DataAddException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @param ticket
	 * @return boolean
	 * @throws DataDeleteException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean deleteTicketStructure(String ticket) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception;
}
