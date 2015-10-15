/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.AccordPartenariatDTO;
import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.CritereRechercheStructureAdresseDTO;
import org.esupportail.pstagedata.domain.dto.ServiceDTO;
import org.esupportail.pstagedata.domain.dto.StructureDTO;
import org.esupportail.pstagedata.domain.dto.TicketStructureDTO;
import org.esupportail.pstagedata.exceptions.AccordAlreadyExistingForContactException;
import org.esupportail.pstagedata.exceptions.AccordAlreadyExistingForStructureException;
import org.esupportail.pstagedata.exceptions.AccountAlreadyExistingForCoupleMailStructureException;
import org.esupportail.pstagedata.exceptions.ContactDeleteException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.MailAlreadyUsedForStructureException;
import org.esupportail.pstagedata.exceptions.ServiceDeleteException;
import org.esupportail.pstagedata.exceptions.StructureDeleteException;
import org.esupportail.pstagedata.exceptions.StructureNumSiretException;
import org.esupportail.pstagedata.exceptions.UnvalidNumSiretException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;

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
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 * @throws AccordAlreadyExistingForContactException 
	 * @throws AccordAlreadyExistingForStructureException 
	 */
	public int addAccord(AccordPartenariatDTO accord) throws DataAddException, WebServiceDataBaseException, AccordAlreadyExistingForContactException, AccordAlreadyExistingForStructureException;
	/**
	 * @param accord
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 * @throws AccordAlreadyExistingForContactException 
	 * @throws AccordAlreadyExistingForStructureException 
	 */
	public boolean updateAccord(AccordPartenariatDTO accord) throws DataUpdateException, WebServiceDataBaseException, AccordAlreadyExistingForContactException, AccordAlreadyExistingForStructureException;
	/**
	 * @param idAccord
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean deleteAccord(int idAccord) throws DataDeleteException, WebServiceDataBaseException;
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
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 * @throws MailAlreadyUsedForStructureException 
	 */
	public int addContact(ContactDTO c) throws DataAddException, WebServiceDataBaseException, MailAlreadyUsedForStructureException;

	/**
	 * @param c
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 * @throws MailAlreadyUsedForStructureException 
	 */
	public boolean updateContact(ContactDTO c) throws DataUpdateException, WebServiceDataBaseException, MailAlreadyUsedForStructureException;
	/**
	 * @param c
	 * @return boolean
	 * @throws DataUpdateException
	 * @throws WebServiceDataBaseException
	 * @throws AccountAlreadyExistingForCoupleMailStructureException 
	 */
	public boolean updateCompteContact(ContactDTO c) throws DataUpdateException, WebServiceDataBaseException, AccountAlreadyExistingForCoupleMailStructureException;
	/**
	 * @param idContact 
	 * @param loginInfosAJour 
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateContactInfosAJour(int idContact, String loginInfosAJour) throws DataUpdateException, WebServiceDataBaseException;

	/**
	 * @param idContact 
	 * @param Date
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateContactDerniereConnexion(int idContact, Date avantDerniereConnexion) throws DataUpdateException, WebServiceDataBaseException;

	/**
	 * @param idContact 
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException 
	 * @throws ContactDeleteException 
	 */
	public boolean deleteContact(int idContact) throws DataDeleteException, WebServiceDataBaseException, ContactDeleteException;
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
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addService(ServiceDTO s) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @param s
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateService(ServiceDTO s) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idService
	 * @param loginInfosAJour
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateServiceInfosAJour(int idService, String loginInfosAJour) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idService
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException 
	 * @throws ServiceDeleteException 
	 */
	public boolean deleteService(int idService) throws DataDeleteException, WebServiceDataBaseException, ServiceDeleteException;
	/* ****************************************************************************
	 * STRUCTURE
	 *****************************************************************************/
	// Ajout moderation Entreprise
	/**
	 * @param estValidee
	 * @return List<StructureDTO>
	 */
	public List<StructureDTO> getStructuresFromVerification(int estValidee);

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
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 * @throws UnvalidNumSiretException 
	 * @throws StructureNumSiretException 
	 */
	public int addStructure(StructureDTO s) throws DataAddException, WebServiceDataBaseException, UnvalidNumSiretException, StructureNumSiretException;
	/**
	 * @param s
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 * @throws UnvalidNumSiretException 
	 * @throws StructureNumSiretException 
	 */
	public boolean updateStructure(StructureDTO s) throws DataUpdateException, WebServiceDataBaseException, UnvalidNumSiretException, StructureNumSiretException;
	/**
	 * @param idStructure
	 * @param loginInfosAJour
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateStructureInfosAJour(int idStructure, String loginInfosAJour) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idStructure 
	 * @param loginValidation
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateStructureValidation(int idStructure, String loginValidation) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idStructure 
	 * @param loginStopValidation
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateStructureStopValidation(int idStructure, String loginStopValidation) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idStructure
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException 
	 * @throws StructureDeleteException 
	 */
	public boolean deleteStructureBase(int idStructure) throws DataDeleteException, WebServiceDataBaseException, StructureDeleteException;
	/**
	 * @param idStructure
	 * @return boolean
	 * @throws DataDeleteException
	 * @throws WebServiceDataBaseException
	 * @throws StructureDeleteException
	 */
	public boolean deleteStructure(int idStructure, String loginCurrentUser) throws DataUpdateException, WebServiceDataBaseException;

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
	 * @throws DataAddException
	 * @throws WebServiceDataBaseException
	 */
	public int addTicketStructure(TicketStructureDTO ticketStructure) throws DataAddException, WebServiceDataBaseException;

	/**
	 * @param ticket
	 * @return boolean
	 * @throws DataDeleteException
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteTicketStructure(String ticket) throws DataDeleteException, WebServiceDataBaseException;

	/**
	 * 
	 * @return List<String>
	 */
	public List<String> getRaisonsSociales(String raisonSociale);
	
	/**
	 * @return StructureDTO
	 */
	public List<StructureDTO> getStructuresTemEnServFalse();

}