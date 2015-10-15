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
import org.esupportail.pstagedata.remote.RemoteServices;

/**
 * The StructureDomainService service impl.
 */
public class StructureDomainServiceImpl implements Serializable, StructureDomainService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * RemoteServices
	 */
	private RemoteServices remoteServices;

	/**
	 * @return the remoteServices
	 */
	public RemoteServices getRemoteServices() {
		return remoteServices;
	}

	/**
	 * @param remoteServices the remoteServices to set
	 */
	public void setRemoteServices(RemoteServices remoteServices) {
		this.remoteServices = remoteServices;
	}

	/* ****************************************************************************
	 * ACCORD PARTENARIAT
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getAccordsNonValides()
	 */
	public List<AccordPartenariatDTO> getAccordsNonValides(){
		return this.remoteServices.getAccordsNonValides();
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getAccordFromId(int)
	 */
	public AccordPartenariatDTO getAccordFromId(int id){
		return this.remoteServices.getAccordFromId(id);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getAccordFromIdStructure(int)
	 */
	public AccordPartenariatDTO getAccordFromIdStructure(int idStructure){
		return this.remoteServices.getAccordFromIdStructure(idStructure);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getAccordFromIdContact(int)
	 */
	public AccordPartenariatDTO getAccordFromIdContact(int idContact){
		return this.remoteServices.getAccordFromIdContact(idContact);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#countAccordAValider()
	 */
	public int countAccordAValider(){
		return this.remoteServices.countAccordAValider();
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#addAccord(org.esupportail.pstagedata.domain.dto.AccordPartenariatDTO)
	 */
	public int addAccord(AccordPartenariatDTO accord) throws DataAddException,WebServiceDataBaseException, AccordAlreadyExistingForContactException, AccordAlreadyExistingForStructureException{
		return this.remoteServices.addAccord(accord);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateAccord(org.esupportail.pstagedata.domain.dto.AccordPartenariatDTO)
	 */
	public boolean updateAccord(AccordPartenariatDTO accord) throws DataUpdateException,WebServiceDataBaseException, AccordAlreadyExistingForContactException, AccordAlreadyExistingForStructureException{
		return this.remoteServices.updateAccord(accord);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#deleteAccord(int)
	 */
	public boolean deleteAccord(int idAccord) throws DataDeleteException,WebServiceDataBaseException{
		return this.remoteServices.deleteAccord(idAccord);
	}
	/* ****************************************************************************
	 * CONTACT
	 *****************************************************************************/

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getContactFromId(int)
	 */
	public ContactDTO getContactFromId(int id){
		ContactDTO c = this.remoteServices.getContactFromId(id);
		setObjectsForContact(c);
		return c;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getContactsFromIdService(int, java.util.List, java.lang.String)
	 */
	public List<ContactDTO> getContactsFromIdService(int idService, List<Integer> idsCentresGestion, String codeUniversite){
		List<ContactDTO> l = this.remoteServices.getContactsFromIdService(idService, idsCentresGestion, codeUniversite);
		setObjectsForContact(l);
		return l;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getContactFromLogin(java.lang.String)
	 */
	public ContactDTO getContactFromLogin(String login){
		ContactDTO c = this.remoteServices.getContactFromLogin(login);
		setObjectsForContact(c);
		return c;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getContactEntrepriseAvecCompteFromMailAndIdStructure(java.lang.String, int)
	 */
	public ContactDTO getContactEntrepriseAvecCompteFromMailAndIdStructure(String mail, int idStructure){
		return this.remoteServices.getContactEntrepriseAvecCompteFromMailAndIdStructure(mail, idStructure);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getNombreContactByCentreGestion(int)
	 */
	public int getNombreContactByCentreGestion(int idCentreGestion){
		return this.remoteServices.getNombreContactByCentreGestion(idCentreGestion);
	}

	/**
	 * @param lc
	 */
	public void setObjectsForContact(List<ContactDTO> lc){
		if(lc!=null){
			for(ContactDTO c : lc){
				setObjectsForContact(c);
			}
		}
	}

	/**
	 * @param c
	 */
	public void setObjectsForContact(ContactDTO c){
		if(c!=null){
			if (c.getIdCivilite() > 0)
				c.setCivilite(nomenclatureDomainService.getCiviliteFromId(c.getIdCivilite()));
		}
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#addContact(org.esupportail.pstagedata.domain.dto.ContactDTO)
	 */
	public int addContact(ContactDTO c) throws DataAddException,WebServiceDataBaseException, MailAlreadyUsedForStructureException{
		return this.remoteServices.addContact(c);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateContact(org.esupportail.pstagedata.domain.dto.ContactDTO)
	 */
	public boolean updateContact(ContactDTO c) throws DataUpdateException,WebServiceDataBaseException, MailAlreadyUsedForStructureException{
		return this.remoteServices.updateContact(c);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateCompteContact(org.esupportail.pstagedata.domain.dto.ContactDTO)
	 */
	public boolean updateCompteContact(ContactDTO c) throws DataUpdateException, WebServiceDataBaseException, AccountAlreadyExistingForCoupleMailStructureException{
		return this.remoteServices.updateCompteContact(c);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateContactInfosAJour(int, java.lang.String)
	 */
	public boolean updateContactInfosAJour(int idContact, String loginInfosAJour) throws DataUpdateException,WebServiceDataBaseException{
		return this.remoteServices.updateContactInfosAJour(idContact, loginInfosAJour);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateContactDerniereConnexion(int, java.util.Date)
	 */
	public boolean updateContactDerniereConnexion(int idContact, Date avantDerniereConnexion) throws DataUpdateException,WebServiceDataBaseException{
		return this.remoteServices.updateContactDerniereConnexion(idContact, avantDerniereConnexion);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#deleteContact(int)
	 */
	public boolean deleteContact(int idContact) throws DataDeleteException,WebServiceDataBaseException, ContactDeleteException{
		return this.remoteServices.deleteContact(idContact);
	}
	/* ****************************************************************************
	 * SERVICE
	 *****************************************************************************/

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getServiceFromId(int)
	 */
	public ServiceDTO getServiceFromId(int id){
		ServiceDTO s = this.remoteServices.getServiceFromId(id);
		setObjectsForService(s);
		return s;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getServiceFromIdContact(int)
	 */
	public ServiceDTO getServiceFromIdContact(int id){
		ServiceDTO s = this.remoteServices.getServiceFromIdContact(id);
		setObjectsForService(s);
		return s;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getServicesFromIdStructure(int)
	 */
	public List<ServiceDTO> getServicesFromIdStructure(int id){
		List<ServiceDTO> ls = this.remoteServices.getServicesFromIdStructure(id);
		setObjectsForService(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#addService(org.esupportail.pstagedata.domain.dto.ServiceDTO)
	 */
	public int addService(ServiceDTO s) throws DataAddException,WebServiceDataBaseException{
		return this.remoteServices.addService(s);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateService(org.esupportail.pstagedata.domain.dto.ServiceDTO)
	 */
	public boolean updateService(ServiceDTO s) throws DataUpdateException,WebServiceDataBaseException{
		return this.remoteServices.updateService(s);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateServiceInfosAJour(int, java.lang.String)
	 */
	public boolean updateServiceInfosAJour(int idService, String loginInfosAJour) throws DataUpdateException,WebServiceDataBaseException{
		return this.remoteServices.updateServiceInfosAJour(idService, loginInfosAJour);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#deleteService(int)
	 */
	public boolean deleteService(int idService) throws DataDeleteException,WebServiceDataBaseException, ServiceDeleteException{
		return this.remoteServices.deleteService(idService);
	}

	/**
	 * @param ls
	 */
	public void setObjectsForService(List<ServiceDTO> ls){
		if(ls!=null){
			for(ServiceDTO s : ls){
				setObjectsForService(s);
			}
		}
	}

	/**
	 * @param s
	 */
	public void setObjectsForService(ServiceDTO s){
		if(s!=null){
			if (s.getIdPays() > 0)
				s.setPays(this.nomenclatureDomainService.getPaysFromId(s.getIdPays()));
		}
	}

	/* ****************************************************************************
	 * STRUCTURE
	 *****************************************************************************/

	// Ajout moderation Entreprise
	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresFromVerification(boolean)
	 */
	public List<StructureDTO> getStructuresFromVerification(int estValidee){
		List<StructureDTO> ls = this.remoteServices.getStructuresFromVerification(estValidee);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructureFromId(int)
	 */
	public StructureDTO getStructureFromId(int id){
		StructureDTO s = this.remoteServices.getStructureFromId(id);
		setObjects(s);
		return s;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructureFromIdService(int)
	 */
	public StructureDTO getStructureFromIdService(int id){
		StructureDTO s = this.remoteServices.getStructureFromIdService(id);
		setObjects(s);
		return s;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresFromRaisonSociale(java.lang.String)
	 */
	public List<StructureDTO> getStructuresFromRaisonSociale(String raisonSociale){
		List<StructureDTO> ls = this.remoteServices.getStructuresFromRaisonSociale(raisonSociale);
		setObjects(ls);
		return ls;
	}
	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresFromRaisonSocialeEtPays(java.lang.String, int)
	 */
	public List<StructureDTO> getStructuresFromRaisonSocialeEtPays(String raisonSociale, int cog){
		List<StructureDTO> ls = this.remoteServices.getStructuresFromRaisonSocialeEtPays(raisonSociale, cog);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresPaysEtrangerFromRaisonSociale(java.lang.String)
	 */
	public List<StructureDTO> getStructuresPaysEtrangerFromRaisonSociale(String raisonSociale){
		List<StructureDTO> ls = this.remoteServices.getStructuresPaysEtrangerFromRaisonSociale(raisonSociale);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructureFromNumSiret(java.lang.String)
	 */
	public StructureDTO getStructureFromNumSiret(String numeroSiret){
		StructureDTO s = this.remoteServices.getStructureFromNumSiret(numeroSiret);
		setObjects(s);
		return s;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructureFromContactMailEntrepriseAvecCompte(java.lang.String)
	 */
	public List<StructureDTO> getStructureFromContactMailEntrepriseAvecCompte(String mail){
		List<StructureDTO> ls = this.remoteServices.getStructureFromContactMailEntrepriseAvecCompte(mail);
		if(ls!=null){
			for(StructureDTO s : ls){
				if (s.getIdPays() > 0)
					s.setPays(this.nomenclatureDomainService.getPaysFromId(s.getIdPays()));
			}
		}
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructureAvecAccordFromId(int)
	 */
	public StructureDTO getStructureAvecAccordFromId(int id){
		StructureDTO s = this.remoteServices.getStructureAvecAccordFromId(id);
		setObjects(s);
		return s;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresFromRaisonSocialeEtDepartement(java.lang.String, java.lang.String)
	 */
	public List<StructureDTO> getStructuresFromRaisonSocialeEtDepartement(String raisonSociale, String departement){
		List<StructureDTO> ls = this.remoteServices.getStructuresFromRaisonSocialeEtDepartement(raisonSociale,departement);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresFromNumSiren(java.lang.String)
	 */
	public List<StructureDTO> getStructuresFromNumSiren(String numSiren){
		List<StructureDTO> ls = this.remoteServices.getStructuresFromNumSiren(numSiren);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresFromTelephone(java.lang.String)
	 */
	public List<StructureDTO> getStructuresFromTelephone(String telephone){
		List<StructureDTO> ls = this.remoteServices.getStructuresFromTelephone(telephone);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresFromFax(java.lang.String)
	 */
	public List<StructureDTO> getStructuresFromFax(String fax){
		List<StructureDTO> ls = this.remoteServices.getStructuresFromFax(fax);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresFromAdresse(org.esupportail.pstagedata.domain.dto.CritereRechercheStructureAdresseDTO)
	 */
	public List<StructureDTO> getStructuresFromAdresse(CritereRechercheStructureAdresseDTO c){
		List<StructureDTO> ls = null;
		if(c!=null){
			ls=this.remoteServices.getStructuresFromAdresse(c);
			setObjects(ls);
		}
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresFromNomServiceEtDepartement(java.lang.String, java.lang.String)
	 */
	public List<StructureDTO> getStructuresFromNomServiceEtDepartement(String nomService, String departement){
		List<StructureDTO> ls = this.remoteServices.getStructuresFromNomServiceEtDepartement(nomService,departement);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresFromTypeStructureNafN1EtDepartement(int, java.lang.String, java.lang.String)
	 */
	public List<StructureDTO> getStructuresFromTypeStructureNafN1EtDepartement(int typeStructure, String nafN1, String departement){
		List<StructureDTO> ls = this.remoteServices.getStructuresFromTypeStructureNafN1EtDepartement(typeStructure,nafN1,departement);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresAvecAccordAValiderFromRaisonSociale(java.lang.String, java.util.Date, java.util.Date)
	 */
	public List<StructureDTO> getStructuresAvecAccordAValiderFromRaisonSociale(String raisonSociale, Date dateDebut, Date dateFin){
		List<StructureDTO> ls = this.remoteServices.getStructuresAvecAccordAValiderFromRaisonSociale(raisonSociale, dateDebut, dateFin);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresAvecAccordValidesFromRaisonSociale(java.lang.String, java.util.Date, java.util.Date)
	 */
	public List<StructureDTO> getStructuresAvecAccordValidesFromRaisonSociale(String raisonSociale, Date dateDebut, Date dateFin){
		List<StructureDTO> ls = this.remoteServices.getStructuresAvecAccordValidesFromRaisonSociale(raisonSociale, dateDebut, dateFin);
		setObjects(ls);
		return ls;
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresSansAccordFromRaisonSociale(java.lang.String)
	 */
	public List<StructureDTO> getStructuresSansAccordFromRaisonSociale(String raisonSociale){
		List<StructureDTO> ls = this.remoteServices.getStructuresSansAccordFromRaisonSociale(raisonSociale);
		setObjects(ls);
		return ls;
	}

	/**
	 * Rempli les divers objets (Pays, TypeStructure, ...) depuis les listes en caches
	 * @param ls
	 */
	public void setObjects(List<StructureDTO> ls){
		if(ls!=null){
			for(StructureDTO s : ls){
				setObjects(s);
			}
		}
	}

	/**
	 * Rempli les divers objets (Pays, TypeStructure, ...) depuis les listes en caches
	 * @param s
	 */
	public void setObjects(StructureDTO s){
		if(s!=null){
			if(s.getIdTypeStructure() > 0)
				s.setTypeStructure(this.nomenclatureDomainService.getTypeStructureFromId(s.getIdTypeStructure()));
			if (s.getIdStatutJuridique() > 0)
				s.setStatutJuridique(this.nomenclatureDomainService.getStatutJuridiqueFromId(s.getIdStatutJuridique()));
			if (s.getIdEffectif() > 0)
				s.setEffectif(this.nomenclatureDomainService.getEffectifFromId(s.getIdEffectif()));
			if (s.getCodeNAF_N5() != null && !s.getCodeNAF_N5().isEmpty())
				s.setNafN5(this.nomenclatureDomainService.getNafN5FromCode(s.getCodeNAF_N5()));
			if (s.getIdPays() > 0)
				s.setPays(this.nomenclatureDomainService.getPaysFromId(s.getIdPays()));
		}
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#addStructure(org.esupportail.pstagedata.domain.dto.StructureDTO)
	 */
	public int addStructure(StructureDTO s) throws DataAddException,WebServiceDataBaseException, UnvalidNumSiretException, StructureNumSiretException{
		return this.remoteServices.addStructure(s);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateStructure(org.esupportail.pstagedata.domain.dto.StructureDTO)
	 */
	public boolean updateStructure(StructureDTO s) throws DataUpdateException,WebServiceDataBaseException, UnvalidNumSiretException, StructureNumSiretException{
		return this.remoteServices.updateStructure(s);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateStructureInfosAJour(int, java.lang.String)
	 */
	public boolean updateStructureInfosAJour(int idStructure, String loginInfosAJour) throws DataUpdateException,WebServiceDataBaseException{
		return this.remoteServices.updateStructureInfosAJour(idStructure, loginInfosAJour);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateStructureValidation(int, java.lang.String)
	 */
	public boolean updateStructureValidation(int idStructure, String loginValidation) throws DataUpdateException,WebServiceDataBaseException{
		return this.remoteServices.updateStructureValidation(idStructure, loginValidation);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#updateStructureStopValidation(int, java.lang.String)
	 */
	public boolean updateStructureStopValidation(int idStructure, String loginStopValidation) throws DataUpdateException,WebServiceDataBaseException{
		return this.remoteServices.updateStructureStopValidation(idStructure, loginStopValidation);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#deleteStructureBase(int)
	 */
	public boolean deleteStructureBase(int idStructure) throws DataDeleteException,WebServiceDataBaseException, StructureDeleteException{
		return this.remoteServices.deleteStructureBase(idStructure);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#deleteStructureBase(int)
	 */
	public boolean deleteStructure(int idStructure, String loginCurrentUser) throws DataUpdateException,WebServiceDataBaseException{
		return this.remoteServices.deleteStructure(idStructure, loginCurrentUser);
	}

	public List<String> getRaisonsSociales(String raisonSociale){		
		return (List<String>) this.remoteServices.getRaisonsSociales(raisonSociale);
	}

	/* ****************************************************************************
	 * TICKET STRUCTURE
	 *****************************************************************************/

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#addTicketStructure(org.esupportail.pstagedata.domain.dto.TicketStructureDTO)
	 */
	public int addTicketStructure(TicketStructureDTO ticketStructure)
			throws DataAddException, WebServiceDataBaseException {

		return this.remoteServices.addTicketStructure(ticketStructure);
	}
	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#deleteTicketStructure(java.lang.String)
	 */
	public boolean deleteTicketStructure(String ticket)
			throws DataDeleteException, WebServiceDataBaseException {
		return this.remoteServices.deleteTicketStructure(ticket);
	}
	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getTicketStructureValide(org.esupportail.pstagedata.domain.dto.TicketStructureDTO)
	 */
	public boolean getTicketStructureValide(TicketStructureDTO ticketStructure) {
		return this.remoteServices.getTicketStructureValide(ticketStructure);
	}

	/**
	 * @see org.esupportail.pstage.domain.StructureDomainService#getStructuresTemEnServFalse()
	 */
	public List<StructureDTO> getStructuresTemEnServFalse() {
		return this.remoteServices.getStructuresTemEnServFalse();
	}

}
