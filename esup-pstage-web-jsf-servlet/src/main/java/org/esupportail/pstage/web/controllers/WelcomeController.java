/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;
import org.esupportail.commons.services.ldap.LdapUser;
import org.esupportail.commons.services.ldap.LdapUserService;
import org.esupportail.pstage.domain.beans.EtudiantRef;
import org.esupportail.pstage.domain.beans.NousContacter;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.domain.dto.AccordPartenariatDTO;
import org.esupportail.pstagedata.domain.dto.AdminStructureDTO;
import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.ContactDTO;
import org.esupportail.pstagedata.domain.dto.DroitAdministrationDTO;
import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.esupportail.pstagedata.domain.dto.EtudiantDTO;
import org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.StructureDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class WelcomeController extends AbstractContextAwareController {

	/* ***************************************************************
	 * Propri�t�s
	 ****************************************************************/
	/**
	 * Logger
	 */
	private final Logger logger = Logger.getLogger(this.getClass());
	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -239570715531002003L;
	/**
	 * Form connexion : Login
	 */
	private String login;
	/**
	 * Form connexion : Mot de passe
	 */
	private String mdp;
	/**
	 * Mail utilis� pour la r�cup�ration de mot de passe perdu
	 */
	private String mailMotDePassePerdu;
	/**
	 * Liste des structures pour s�lection (�tape 2 de r�cup�ration de mot de passe)
	 * dans le cas o� le contact poss�de un compte dans 2 �tablissements diff�rents.
	 */
	private List<StructureDTO> listeStructuresTrouveeMotDePassePerdu;
	/**
	 * �tablissement s�lectionn� pour la r�cup�ration de mot de passe
	 */
	private StructureDTO structureSelectionneeMotDePassePerdu;
	/**
	 * EtablissementController
	 */
	private EtablissementController etablissementController;
	/**
	 * OffreController
	 */
	private OffreController offreController;

	/**
	 * LdapUserService
	 */
	private LdapUserService ldapUserService;
	/**
	 * Nom de l'attribut sp�cifiant l'affiliation d'une personne dans ldap
	 */
	private String affiliation;
	/**
	 * Valeur de ldap.affiliation pour un etudiant
	 */
	private String student;
	/**
	 * Valeur(s) de l'attribut ldap.affiliation pour un administratif
	 */
	private String employee;
	/**
	 * Valeur de ldap.affiliation pour un enseignant
	 */
	private String faculty;
	/**
	 * Cr�ation d'une convention autoris�e
	 */
	private boolean creationConventionAutorisee=true;

	private String idLienDirect;
	
	/**
	 * Bean constructor.
	 */
	public WelcomeController() {
		super();
	}

	/* ***************************************************************
	 * Actions
	 ****************************************************************/

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + hashCode();
	}

	/**
	 * @see org.esupportail.pstage.web.controllers.AbstractDomainAwareBean#reset()
	 */
	@Override
	public void reset() {
		super.reset();		
	}

	/**
	 * @return A String
	 */
	public String goToAccueilEntr(){
		return "accueilEntr";
	}

	/**
	 * @return A String
	 */
	public String goToAccueilStage(){
		return "accueilStage";
	}

	/**
	 * @return A String
	 */
	public String enter() {
		return "navigationWelcome";
	}


	/**
	 * Envoi vers la 1�re �tape de r�cup�ration d'un mot de passe
	 * @return A String
	 */
	public String goToMotDePassePerdu(){
		this.mailMotDePassePerdu="";
		this.listeStructuresTrouveeMotDePassePerdu=null;
		return "motDePassePerdu";
	}

	/**
	 * Envoi vers la 2�me ou 3�me �tape de r�cup�ration d'un mot de passe
	 * @return String
	 */
	public String goToMotDePassePerduEtabTrouve(){
		String ret="_motDePassePerduEtape3Confirmation";
		if(StringUtils.hasText(this.mailMotDePassePerdu)){
			List<StructureDTO> ls = getStructureDomainService().getStructureFromContactMailEntrepriseAvecCompte(this.mailMotDePassePerdu);
			if(ls!=null){
				if(ls.size()>1){
					ret="_motDePassePerduEtape2SelectionEtab";
					this.listeStructuresTrouveeMotDePassePerdu=ls;
				}else{
					ret="_motDePassePerduEtape3Confirmation";
					ContactDTO c = getStructureDomainService().getContactEntrepriseAvecCompteFromMailAndIdStructure(this.mailMotDePassePerdu, 
							ls.get(0).getIdStructure());
					if(c!=null){
						InternetAddress cIA;
						try {
							cIA = new InternetAddress(c.getMail());
							cIA.validate();
							getSmtpService().send(
									cIA, 
									getString("MAIL.RECAPIDENTS.SUJET", getSessionController().getApplicationNameEntreprise()),
									getString("MAIL.RECAPIDENTS.MESSAGE", c.getLogin(), getBlowfishUtils().decode(c.getMdp()),getSessionController().getApplicationNameEntreprise()),
									""
							);
							if(logger.isInfoEnabled()){
								logger.info("Recuperation de mot de passe pour : "+c);
							}
							addInfoMessage(null, "MOTDEPASSEPERDU.CONFIRMATION", c.getMail());
							this.mailMotDePassePerdu="";
							this.listeStructuresTrouveeMotDePassePerdu=null;
						} catch (AddressException e) {
							logger.error(e.getMessage());
							e.printStackTrace();
							addErrorMessage(null, "MOTDEPASSEPERDU.ERREUR");
						}
					}else{
						addErrorMessage(null, "MOTDEPASSEPERDU.ERREUR");
					}
				}
			}else{
				ret="_motDePassePerduEtape3Confirmation";
				addErrorMessage(null, "MOTDEPASSEPERDU.INCONNUE");
			}
		}
		return ret;
	}

	/**
	 * Envoi vers l'�tape 3 de r�cup�ration de mot de passe depuis l'�tape 2
	 * @return String
	 */
	public String goToRecuperationMotDePasse(){
		String ret="_motDePassePerduEtape3Confirmation";
		if(this.structureSelectionneeMotDePassePerdu!=null){
			ContactDTO c = getStructureDomainService().getContactEntrepriseAvecCompteFromMailAndIdStructure(this.mailMotDePassePerdu, 
					this.structureSelectionneeMotDePassePerdu.getIdStructure());
			if(c!=null){
				InternetAddress cIA;
				try {
					cIA = new InternetAddress(c.getMail());
					cIA.validate();
					getSmtpService().send(
							cIA, 
							getString("MAIL.RECAPIDENTS.SUJET", getSessionController().getApplicationNameEntreprise()),
							getString("MAIL.RECAPIDENTS.MESSAGE", c.getLogin(), getBlowfishUtils().decode(c.getMdp()),getSessionController().getApplicationNameEntreprise()),
							""
					);
					if(logger.isInfoEnabled()){
						logger.info("Recuperation de mot de passe pour : "+c);
					}
					addInfoMessage(null, "MOTDEPASSEPERDU.CONFIRMATION", c.getMail());
					this.mailMotDePassePerdu="";
					this.listeStructuresTrouveeMotDePassePerdu=null;
				} catch (AddressException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
					addErrorMessage(null, "MOTDEPASSEPERDU.ERREUR");
				}
			}else{
				addErrorMessage(null, "MOTDEPASSEPERDU.ERREUR");
			}
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String nousContacter(){
		String retour="_nousContacterEtape2";
		if(!getSessionController().getNousContacter().isNull()){
			addInfoMessage(null, "GENERAL.NOUS_CONTACTER.CONFIRMATION");
			if(StringUtils.hasText(getSessionController().getMailingListEntr())){
				getSmtpService().send(
						getSessionController().getMailingListEntrIA(), 
						getString("MAIL.ADMIN.NOUSCONTACTER.SUJET", getSessionController().getApplicationNameEntreprise(), getSessionController().getNousContacter().getCodePostal()+" - "+getSessionController().getNousContacter().getPays().getLibelle())+" : "+getSessionController().getNousContacter().getSujet(),
						getString("MAIL.ADMIN.NOUSCONTACTER.MESSAGE", getSessionController().getApplicationNameEntreprise(), 
								getFacesInfoMessage("CONTACT.NOM").getSummary()+" : "+getSessionController().getNousContacter().getContact().getNom()+" - "+getFacesInfoMessage("CONTACT.PRENOM").getSummary()+" : "+getSessionController().getNousContacter().getContact().getPrenom()
								+" - "+getFacesInfoMessage("CONTACT.MAIL").getSummary()+" : "+getSessionController().getNousContacter().getContact().getMail(),
								getSessionController().getNousContacter().getSujet(),
								getSessionController().getNousContacter().getMessage()),
								""
				);
			}
			getSessionController().setNousContacter(new NousContacter());
		}
		return retour;
	}

	/**
	 * @return String
	 */
	public String nousContacterModifSiret(){
		initNousContacter();
		getSessionController().getNousContacter().setSujet(getString("STRUCTURE.DEMANDE_MODIFSIRET.SUJET")+
				getSessionController().getCurrentManageStructure().getRaisonSociale()+", "+
				getSessionController().getCurrentManageStructure().getNumeroSiret());
		getSessionController().getNousContacter().setMessage(getString("STRUCTURE.DEMANDE_MODIFSIRET.MESSAGE"));
		return null;
	}

	/**
	 * @return String
	 */
	public String initNousContacter(){
		getSessionController().setNousContacter(new NousContacter());
		if(getSessionController().getCurrentAuthContact()!=null){
			getSessionController().getNousContacter().getContact().setNom(getSessionController().getCurrentAuthContact().getNom());
			getSessionController().getNousContacter().getContact().setPrenom(getSessionController().getCurrentAuthContact().getPrenom());
			getSessionController().getNousContacter().getContact().setMail(getSessionController().getCurrentAuthContact().getMail());
			if(getSessionController().getCurrentManageStructure()!=null){
				getSessionController().getNousContacter().setCodePostal(getSessionController().getCurrentManageStructure().getCodePostal());
				getSessionController().getNousContacter().setPays(getSessionController().getCurrentManageStructure().getPays());
			}
		}
		getSessionController().getNousContacter().setSujet("");
		getSessionController().getNousContacter().setMessage("");
		return null;
	}

	//	public String retourLigneHTML(String s){
	//		String r="";
	//		StringTokenizer st = new StringTokenizer(s, "\n");
	//		r=st.nextToken();
	//		while(st.hasMoreTokens()){
	//			r=r+"</br>"+st.nextToken();
	//		}
	//		return r;
	//	}



	/**
	 * @return String
	 */
	public String goToGererStructure(){
		String ret=null;
		ret="gererStructure";
		if(getSessionController().getCurrentManageStructure()!=null && getSessionController().getCurrentManageStructure().getIdStructure()>0){
			if(getSessionController().getCurrentManageStructure().getIdAccordPartenariat()>0){
				AccordPartenariatDTO ap = getStructureDomainService().getAccordFromId(
						getSessionController().getCurrentManageStructure().getIdAccordPartenariat());
				getSessionController().getCurrentManageStructure().setAccordPartenariat(ap);

			}
			addInfoMessage(null, "STRUCTURE.GESTION",getSessionController().getCurrentManageStructure().getRaisonSociale());
			this.etablissementController.loadContactsServices();
			this.offreController.loadOffres();
			if(logger.isInfoEnabled()){
				logger.info(getSessionController().getCurrentLogin()+" g�re : "+getSessionController().getCurrentManageStructure());
			}
		}else{
			addErrorMessage(null, "STRUCTURE.GESTION.ERREUR");
		}
		return ret;
	}

	/**
	 * Connexion d'un contact ou d'un admin en compte local
	 * @return String
	 */
	public String connect(){
		String ret=null;
		if(StringUtils.hasText(login) && StringUtils.hasText(mdp)){
			ContactDTO tmp = getStructureDomainService().getContactFromLogin(this.login);
			if(tmp!=null && StringUtils.hasText(tmp.getMdp())){
				StructureDTO st = getStructureDomainService().getStructureFromIdService(tmp.getIdService());
				if(st!=null && st.getIdStructure()>0){
					AccordPartenariatDTO ap = getStructureDomainService().getAccordFromIdStructure(st.getIdStructure());
					if(ap!=null && ap.isEstValide() && tmp.getMdp().equalsIgnoreCase(this.mdp)){
						getSessionController().setCurrentAuthAdminStructure(null);
						if(logger.isInfoEnabled()){
							logger.info("Connection of contact : "+tmp);
						}
						ret="accueilEntr";
						getSessionController().setCurrentAuthContact(tmp);
						getSessionController().setCurrentManageStructure(getStructureDomainService().getStructureFromIdService(tmp.getIdService()));
						getSessionController().setMenuGestionEtab(true);
						
						List<CentreGestionDTO> l = new ArrayList<CentreGestionDTO>();
						l.add(getCentreGestionDomainService().getCentreEntreprise());
						getSessionController().setCurrentCentresGestion(l);
						this.etablissementController.loadContactsServices();
						this.offreController.loadOffres();
						getStructureDomainService().updateContactDerniereConnexion(tmp.getId(), tmp.getDerniereConnexion());
						
						getSessionController().setCurrentAuthAdminStructure(null);
						getSessionController().setCurrentAuthEtudiant(null);
						getSessionController().setCurrentAuthEnseignant(null);
						getSessionController().setCurrentAuthPersonnel(null);
					}else{
						addErrorMessage("connexion", "GENERAL.BADLOGINORPASS");
					}
				}else{
					addErrorMessage("connexion", "GENERAL.BADLOGINORPASS");
				}
			}else{
				getSessionController().setCurrentAuthContact(null);
				AdminStructureDTO tmpA = getAdminDomainService().getAdminStructureFromLogin(login);
				if(tmpA!=null && StringUtils.hasText(tmpA.getMdp())){
					if(tmpA.getMdp().equalsIgnoreCase(mdp)){
						if(logger.isInfoEnabled()){
							logger.info("Connection of local admin : "+tmpA);
						}
						ret="rechercheEtablissement";
						getSessionController().setCurrentAuthAdminStructure(tmpA);
						List<CentreGestionDTO> l = new ArrayList<CentreGestionDTO>();
						l.add(getCentreGestionDomainService().getCentreEntreprise());
						getSessionController().setCurrentCentresGestion(l);
					}else{
						addErrorMessage("connexion", "GENERAL.BADLOGINORPASS");
					}
				}else{
					addErrorMessage("connexion", "GENERAL.BADLOGINORPASS");
				}
			}
		}else{
			addErrorMessage("connexion", "GENERAL.LOGINANDPASS");
		}
		return ret;
	}
	/**
	 * Connexion via Shibboleth (auth/shibb/index.faces)
	 * @return boolean
	 */
	public String connectShibb(){
		String ret="accueilEntr";
		getSessionController().setCurrentAuthAdminStructure(null);
		getSessionController().setCurrentAuthContact(null);
		getSessionController().setNotAdminEntrepriseViaCasShibb(false);
		getSessionController().setCurrentAuthEtudiant(null);
		getSessionController().setCurrentAuthEnseignant(null);
		getSessionController().setCurrentAuthPersonnel(null);
		getSessionController().setCurrentCentresGestion(null);
		getSessionController().setCurrentStageCasUser(null);
		getSessionController().setNotAdminEntrepriseViaCasShibb(false);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			for(String admin : getSessionController().getSuperAdminTab()){
				if(admin.equals(auth.getName())){
					getSessionController().setCurrentAuthAdminStructure(new AdminStructureDTO());
					getSessionController().getCurrentAuthAdminStructure().setNom(auth.getName());
					getSessionController().getCurrentAuthAdminStructure().setPrenom("SuperAdmin");
					getSessionController().getCurrentAuthAdminStructure().setEppn(auth.getName());
					getSessionController().getCurrentAuthAdminStructure().setLogin(auth.getName());
					if(logger.isInfoEnabled()){
						logger.info("Connection of super admin via Shibb : "+getSessionController().getCurrentAuthAdminStructure());
					}
					List<CentreGestionDTO> l = new ArrayList<CentreGestionDTO>();
					l.add(getCentreGestionDomainService().getCentreEntreprise());
					getSessionController().setCurrentCentresGestion(l);
					ret="rechercheEtablissement";
				}
			}
			//Si aucun super admin ne correspond, recherche dans la base
			if(getSessionController().getCurrentAuthAdminStructure()==null){
				AdminStructureDTO tmp = getAdminDomainService().getAdminStructureFromEppn(auth.getName());
				if(tmp!=null){
					if(logger.isInfoEnabled()){
						logger.info("Connection of admin via Shibb : "+tmp);
					}
					getSessionController().setCurrentAuthAdminStructure(tmp);
					List<CentreGestionDTO> l = new ArrayList<CentreGestionDTO>();
					l.add(getCentreGestionDomainService().getCentreEntreprise());
					getSessionController().setCurrentCentresGestion(l);
					ret="rechercheEtablissement";
				}else{
					if(logger.isInfoEnabled()){
						logger.info("User not authorized via Shibb : "+auth.getName());
					}
					//addErrorMessage("connexion", "GENERAL.NOTAUTHORIZED");
					getSessionController().setNotAdminEntrepriseViaCasShibb(true);
				}
			}

			// methode redirigeant l'utilisateur vers la page des contacts s'il passe par le lien du mail de demande de compte
			ret = this.goToContactsLienDirect(ret);
			
		}
		return ret;
	}

	/**
	 * Connexion via Cas (auth/cas/index.faces)
	 * @return String
	 */
	public String connectCas(){
		String ret="accueilEntr";
		getSessionController().setCurrentAuthAdminStructure(null);
		getSessionController().setCurrentAuthContact(null);
		getSessionController().setNotAdminEntrepriseViaCasShibb(false);
		getSessionController().setCurrentAuthEtudiant(null);
		getSessionController().setCurrentAuthEnseignant(null);
		getSessionController().setCurrentAuthPersonnel(null);
		getSessionController().setCurrentCentresGestion(null);
		getSessionController().setCurrentStageCasUser(null);
		getSessionController().setCurrentManageStructure(null);
		getSessionController().setMenuGestionEtab(false);
		getSessionController().setCentreGestionRattachement(null);
		if(getCurrentUser()!=null){
			for(String admin : getSessionController().getSuperAdminTab()){
				if(admin.equals(getCurrentUser().getId())){
					getSessionController().setCurrentAuthAdminStructure(new AdminStructureDTO());
					getSessionController().getCurrentAuthAdminStructure().setNom(getCurrentUser().getId());
					getSessionController().getCurrentAuthAdminStructure().setPrenom("SuperAdmin");
					getSessionController().getCurrentAuthAdminStructure().setEppn(getCurrentUser().getId());
					getSessionController().getCurrentAuthAdminStructure().setLogin(getCurrentUser().getId());
					getSessionController().setNotAdminEntrepriseViaCasShibb(false);
					List<CentreGestionDTO> l = new ArrayList<CentreGestionDTO>();
					l.add(getCentreGestionDomainService().getCentreEntreprise());
					getSessionController().setCurrentCentresGestion(l);
					if(logger.isInfoEnabled()){
						logger.info("Connection of super admin via CAS : "+getSessionController().getCurrentAuthAdminStructure());
					}
					ret="rechercheEtablissement";
				}
			}
			//Si aucun super admin ne correspond, recherche dans la base
			if(getSessionController().getCurrentAuthAdminStructure()==null){
				AdminStructureDTO tmp = getAdminDomainService().getAdminStructureFromLogin(getCurrentUser().getId());
				if(tmp!=null){
					if(logger.isInfoEnabled()){
						logger.info("Connection of admin via CAS : "+tmp);
					}
					getSessionController().setCurrentAuthAdminStructure(tmp);
					getSessionController().setNotAdminEntrepriseViaCasShibb(false);
					List<CentreGestionDTO> l = new ArrayList<CentreGestionDTO>();
					l.add(getCentreGestionDomainService().getCentreEntreprise());
					getSessionController().setCurrentCentresGestion(l);
					ret="rechercheEtablissement";
				}else{
					if(logger.isInfoEnabled()){
						logger.info("User not authorized via CAS : "+getCurrentUser().getId());
					}
					//addErrorMessage("connexion", "GENERAL.NOTAUTHORIZED");
					getSessionController().setNotAdminEntrepriseViaCasShibb(true);
				}
			}
			// methode redirigeant l'utilisateur vers la page des contacts s'il passe par le lien du mail de demande de compte
			ret = this.goToContactsLienDirect(ret);
			
		}
		
		return ret;
	}

	public String goToContactsLienDirect(String ret){
		if (this.idLienDirect != null && !this.idLienDirect.isEmpty()){
			StructureDTO currentStruct = getStructureDomainService().getStructureFromId(Utils.convertStringToInt(this.idLienDirect));
			if (currentStruct != null){
				getSessionController().setCurrentManageStructure(currentStruct);
				getSessionController().setMenuGestionEtab(true);
				this.goToGererStructure();
				ret = "gestionContacts";
			}
		}
		return ret;
	}

	/**
	 * M�thode de connexion via CAS pour les utilisateurs 
	 */
	public void connectStage(){
		if(!getSessionController().isAdminPageAuthorized()){
			if(getCurrentUser()==null){
				//
			}else{
				if(getSessionController().getCurrentStageCasUser()==null){
					// Mise en session du currentUser pour indiquer qu'une personne est connect�e et
					// qu'il n'est pas n�cessaire par la suite de recharger le personnel connect� ainsi que ses droits
					getSessionController().setCurrentStageCasUser(getCurrentUser());
					//Connexion
					connectingStage();
				}else if(!getCurrentUser().getId().equals(getSessionController().getCurrentStageCasUser().getId())){
					//Connexion
					connectingStage();
				}
			}
		}
	}

	/**
	 * M�thode permettant d'identifier la personne connect�e : �tudiant, enseignant, personnel
	 * ainsi que les droits de chacun
	 */
	public void connectingStage(){
		if(getSessionController().getCurrentStageCasUser()!=null){
			getSessionController().setCurrentAuthAdminStructure(null);
			getSessionController().setCurrentAuthContact(null);
			getSessionController().setNotAdminEntrepriseViaCasShibb(false);
			getSessionController().setCurrentAuthEtudiant(null);
			getSessionController().setCurrentAuthEnseignant(null);
			getSessionController().setCurrentAuthPersonnel(null);
			getSessionController().setCurrentCentresGestion(new ArrayList<CentreGestionDTO>());
			getSessionController().setCurrentManageStructure(null);
			getSessionController().setMenuGestionEtab(false);
			getSessionController().setCentreGestionRattachement(null);

			LdapUser ldapUser = null;
			String userAffiliation = null;
			if(StringUtils.hasText(getSessionController().getCurrentStageCasUser().getId())){
				ldapUser = ldapUserService.getLdapUser(getSessionController().getCurrentStageCasUser().getId());
				userAffiliation = ldapUser.getAttribute(this.affiliation);
				if(StringUtils.hasText(userAffiliation) && (employee.contains(userAffiliation) || faculty.contains(userAffiliation))){
					// Gestion de ses droits pour chaque centre de l'universit� de l'individu connect�
					List<PersonnelCentreGestionDTO> liste = getPersonnelCentreGestionDomainService().getPersonnelCentreGestionFromUid(getSessionController().getCurrentStageCasUser().getId(),getSessionController().getCodeUniversite());
					if(logger.isDebugEnabled()){
						logger.info("ldapUser : " + ldapUser);
						logger.info("Employee : " + employee);
						logger.debug("Recherche des droits du personnel pour chaque centre de son universit� ==> " + liste);
					}

					if (liste != null && !liste.isEmpty()){
						Map<Integer,DroitAdministrationDTO> droitsAccesMap = new HashMap<Integer,DroitAdministrationDTO>();

						for(PersonnelCentreGestionDTO personnel : liste){

							DroitAdministrationDTO droitAcces = getNomenclatureDomainService().getDroitAdministrationFromId(personnel.getIdDroitAdmin());
							if(!droitsAccesMap.containsKey(personnel.getIdCentreGestion()))droitsAccesMap.put(personnel.getIdCentreGestion(),droitAcces);
						}

						getSessionController().setDroitsAccesMap(droitsAccesMap);

						if (logger.isDebugEnabled()){
							logger.debug("WelcomeController :: droitsAccesMap = "+ droitsAccesMap );
						}
					}

					getSessionController().setCurrentCentresGestion(getCentreGestionDomainService().getCentreFromUid(getSessionController().getCurrentStageCasUser().getId(),getSessionController().getCodeUniversite()));

					if(getSessionController().getCurrentCentresGestion()!=null && !getSessionController().getCurrentCentresGestion().isEmpty()){
						// Ajout des droits pour le centre entreprise (artois) si la personne est superadmin ou adminStructure
						if ((getSessionController().isSuperAdminPageAuthorized() 
						|| getAdminDomainService().getAdminStructureFromLogin(getSessionController().getCurrentLogin()) != null)
						&& getCentreGestionDomainService().getCentreEntreprise() != null){
							getSessionController().getCurrentCentresGestion().add(getCentreGestionDomainService().getCentreEntreprise());
						}
						Collections.sort(getSessionController().getCurrentCentresGestion(), new Comparator<CentreGestionDTO>(){
							@Override
							public int compare(CentreGestionDTO c1, CentreGestionDTO c2) {
								return c1.getNomCentre().compareTo(c2.getNomCentre());
							}
						});
					}

					if(employee.contains(userAffiliation)){
						//Si c'est un personnel
						PersonnelCentreGestionDTO p = getPersonalDataRepositoryDomain().getPersonnelCentreGestionRef(getSessionController().getCodeUniversite(),
								getSessionController().getCurrentStageCasUser().getId());

						if (p != null){
							if(!(p.getUidPersonnel().isEmpty())){
								getSessionController().setCurrentAuthPersonnel(p);

							}else{
								//Si aucun personnel trouv�, cr�ation de l'objet PersonnelDTO manuellement � partir des infos de getSessionController().getCurrentStageCasUser()
								p = new PersonnelCentreGestionDTO();
								p.setUidPersonnel(getSessionController().getCurrentStageCasUser().getId());

								getSessionController().setCurrentAuthPersonnel(p);
							}
						}	
					}

					if (faculty.contains(userAffiliation)){
						// /!\ Si le personnel est �galement enseignant, on rempli �galement sessionController -> currentAuthEnseignant
						//Si c'est un enseignant
						EnseignantDTO en = getPersonalDataRepositoryDomain().getEnseignantRef(getSessionController().getCodeUniversite(),
								getSessionController().getCurrentStageCasUser().getId());

						if(en!=null){
							if(!(en.getUidEnseignant().isEmpty())){
								getSessionController().setCurrentAuthEnseignant(en);

							}else{
								//Si aucun enseignant trouv�, cr�ation de l'objet EnseignantDTO manuellement � partir des infos de getSessionController().getCurrentStageCasUser()
								en = new EnseignantDTO();
								en.setUidEnseignant(getSessionController().getCurrentStageCasUser().getId());

								getSessionController().setCurrentAuthEnseignant(en);
							}
						}
					} 
				} else if (StringUtils.hasText(userAffiliation) && student.contains(userAffiliation)){
					//Sinon, si c'est un �tudiant
					EtudiantRef e = getStudentDataRepositoryDomain().getEtudiantRef(getSessionController().getCodeUniversite(),
							getSessionController().getCurrentStageCasUser().getId());
					CentreGestionDTO tmp = new CentreGestionDTO();
					CentreGestionDTO cgEtab = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite());
					if (e != null){
						if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_UFR)) {
							// On recupere la liste des ufr de l'etudiant et on v�rifie si elles sont gerees par un centre
							// Si c'est le cas et que ce centre n'est pas d�j� dans la liste CurrentCentresGestion, on l'y ajoute
							if(e.getStudysKey() != null) {
								if (!e.getStudysKey().isEmpty()) {
									for(String code : e.getStudysKey()){
										tmp = recupCentre(code);
										if (tmp != null
												&& !getSessionController().getCurrentCentresGestion().contains(tmp)){
											getSessionController().getCurrentCentresGestion().add(tmp);
										}
									}
								}else {
									// par default, on met le centre etablissement
									getSessionController().getCurrentCentresGestion().add(cgEtab);
								}
							}
						} else if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_ETAPE)) {
							// On recupere la liste des etapes de l'etudiant et on v�rifie si elles sont gerees par un centre
							// Si c'est le cas et que ce centre n'est pas d�j� dans la liste CurrentCentresGestion, on l'y ajoute
							if(e.getStepsKey() != null){
								if (!e.getStepsKey().isEmpty()) {
									for(String code : e.getStepsKey()){
										tmp = recupCentre(code);
										if (tmp != null
												&& !getSessionController().getCurrentCentresGestion().contains(tmp)){
											getSessionController().getCurrentCentresGestion().add(tmp);
										}
									}
								}else {
									// par default, on met le centre etablissement
									getSessionController().getCurrentCentresGestion().add(cgEtab);
								}
							}
							
						} else if (getSessionController().getCritereGestion().equals(DonneesStatic.CG_MIXTE)) {
							// On recupere les listes des etapes et des ufr de l'etudiant et on v�rifie si elles sont gerees par un centre
							// Si c'est le cas et que ce centre n'est pas d�j� dans la liste CurrentCentresGestion, on l'y ajoute
							if(e.getStepsKey() != null){
								for(String code : e.getStepsKey()){
									tmp = recupCentre(code);
									if (tmp != null
											&& !getSessionController().getCurrentCentresGestion().contains(tmp)){
										getSessionController().getCurrentCentresGestion().add(tmp);
									}
								}
							}
							if(e.getStudysKey() != null) {
								for(String code : e.getStudysKey()){
									tmp = recupCentre(code);
									if (tmp != null
											&& !getSessionController().getCurrentCentresGestion().contains(tmp)){
										getSessionController().getCurrentCentresGestion().add(tmp);
									}
								}
							}
							if (e.getStudysKey().isEmpty() && e.getStepsKey().isEmpty()) {
								// par default, on met le centre etablissement
								getSessionController().getCurrentCentresGestion().add(cgEtab);
							}
						} else {
							// par default, on met le centre etablissement
							getSessionController().getCurrentCentresGestion().add(cgEtab);
						}
						if(!getSessionController().isAutoriserConventionsOrphelines()){
							if(getSessionController().getCurrentCentresGestion()!=null
									&& getSessionController().getCurrentCentresGestion().size()==1
									&& getSessionController().getCurrentCentresGestion().contains(cgEtab)){
								this.creationConventionAutorisee=false;
							}else{
								this.creationConventionAutorisee=true;
							}
						}else{
							this.creationConventionAutorisee=true;
						}
					}

					if (e != null) {
						if(!(e.getIdentEtudiant().isEmpty())){
							getSessionController().setCurrentAuthEtudiant(e);
						}else{
							//Si aucun �tudiant trouv�, cr�ation de l'objet EtudiantDTO manuellement � partir des infos de getSessionController().getCurrentStageCasUser()
							EtudiantDTO tmpE = new EtudiantDTO();
							tmpE.setIdentEtudiant(getSessionController().getCurrentStageCasUser().getId());

							getSessionController().setCurrentAuthEtudiant(tmpE);
						}
					}
				}
			}
		}
		if (logger.isDebugEnabled())
			logger.debug("Resume des informations recuperees a la connexion : " + 
					"\nCurrentAuthAdminStructure : " + getSessionController().getCurrentAuthAdminStructure() +
					"\nCurrentAuthContact : " + getSessionController().getCurrentAuthContact() +
					"\nCurrentAuthEtudiant : " + getSessionController().getCurrentAuthEtudiant() +
					"\nCurrentAuthEnseignant : " + getSessionController().getCurrentAuthEnseignant() +
					"\nCurrentAuthPersonnel : " + getSessionController().getCurrentAuthPersonnel() +
					"\nCurrentManageStructure : " + getSessionController().getCurrentManageStructure() +
					"\nCurrentCentresGestions : " + getSessionController().getCurrentCentresGestion() +
					"\nDroitsAccesMap : " + getSessionController().getDroitsAccesMap() +
					"\nCentreGestionRattachement : " + getSessionController().getCentreGestionRattachement());
		
	}

	/**
	 * @param code
	 * @return CentreGestionDTO
	 */
	public CentreGestionDTO recupCentre(String code){
		// recherche du centre de gestion qui gere l'Ufr ou l'Etape liee au code
		CentreGestionDTO centre = getCentreGestionDomainService().getCentreFromCritere(code, getSessionController().getCodeUniversite());

		// S'il n'y en a pas, rattachement au centre etablissement
		if (centre == null) {
			centre = getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite());
		}

		return centre;
	}

	/**
	 * Espace stage seulement
	 * @return true if the current user is a SuperAdmin
	 */
	public boolean isSuperAdmin(){
		connectStage();
		return getSessionController().isSuperAdminPageAuthorized();
	}

	/**
	 * Espace stage seulement
	 * @return true if the current user is an Enseignant
	 */
	public boolean isEnseignant(){
		boolean isEnseignant=false;
		connectStage();
		if(this.getSessionController().getCurrentAuthEnseignant()!=null) isEnseignant=true;
		return isEnseignant;
	}

	/**
	 * Espace stage seulement
	 * @return true if the current user is an Enseignant Tuteur
	 */
	public boolean isEnseignantTuteur(){
		boolean isEnseignantTuteur=false;
		this.getSessionController().setEnseignantTuteur(false);
		connectStage();
		if(this.getSessionController().getCurrentAuthEnseignant()!= null){
			if (getEnseignantDomainService().getNombreConventionByEnseignant(getSessionController().getCurrentAuthEnseignant().getUidEnseignant(), getSessionController().getCodeUniversite()) > 0 ){
				isEnseignantTuteur=true;
				this.getSessionController().setEnseignantTuteur(true);
			}
		}
		return isEnseignantTuteur;
	}

	/**
	 * Espace stage seulement
	 * @return true if the current user is an Personnel
	 */
	public boolean isPersonnel(){
		boolean isPersonnel=false;
		connectStage();
		if(this.getSessionController().getCurrentAuthPersonnel()!=null){
			isPersonnel=true;
		} else {
			Map<Integer,DroitAdministrationDTO> map = getSessionController().getDroitsAccesMap();
			if (map != null && !(map.isEmpty())){
				isPersonnel=true;
			}
		}
		return isPersonnel;
	} 

	/**
	 * Espace stage seulement
	 * @return true if the current user is an Etudiant
	 */
	public boolean isEtudiant(){
		boolean isEtudiant=false;
		connectStage();
		if(this.getSessionController().getCurrentAuthEtudiant()!=null) isEtudiant=true;
		return isEtudiant;
	}

	/**
	 * Espace stage seulement
	 * @return true if the current user is a reader
	 */
	public boolean isReader(){
		boolean isReader=false;
		connectStage();
		Map<Integer,DroitAdministrationDTO> map = getSessionController().getDroitsAccesMap();
		if (map != null && !(map.isEmpty())){
			if(map.containsValue(getBeanUtils().getDroitLecture())){
				isReader = true;
			}
		}
		return isReader;
	}

	/**
	 * Espace stage seulement
	 * @return true if the current user is a writer
	 */
	public boolean isWriter(){
		boolean isWriter=false;
		connectStage();
		Map<Integer,DroitAdministrationDTO> map = getSessionController().getDroitsAccesMap();
		if (map != null && !(map.isEmpty())){
			if(map.containsValue(getBeanUtils().getDroitEcriture())){
				isWriter = true;
			}
		}
		return isWriter;
	}

	/**
	 * Espace stage seulement
	 * @return true if the current user is an admin
	 */
	public boolean isAdmin(){
		boolean isAdmin=false;
		connectStage();
		Map<Integer,DroitAdministrationDTO> map = getSessionController().getDroitsAccesMap();
		if (map != null && !(map.isEmpty())){
			if(map.containsValue(getBeanUtils().getDroitAdmin())){
				isAdmin = true;
			}
		}
		return isAdmin;
	}

	/**
	 * Espace stage seulement
	 * @return true if the current user is an adminEtablissement
	 */
	public boolean isAdminEtablissement(){
		boolean isAdminEtablissement=false;
		int idEtab = (getCentreGestionDomainService().getCentreEtablissement(getSessionController().getCodeUniversite())).getIdCentreGestion();
		connectStage();
		Map<Integer,DroitAdministrationDTO> map = getSessionController().getDroitsAccesMap();
		if (map != null && !(map.isEmpty())){
			if(map.containsKey(idEtab)){
				if(map.get(idEtab).equals(getBeanUtils().getDroitAdmin())){
					isAdminEtablissement = true;
				}
			}
		}
		return isAdminEtablissement;
	}

	/**
	 * M�thode de d�connexion depuis l'Espace Entreprise
	 * @return String
	 */
	public String disconnectEntreprise(){
		String ret="accueilEntr";
		disconnecting();
		return ret;
	}

	/**
	 * M�thode de d�connexion depuis Stage
	 * @return String
	 */
	public String disconnectStage(){
		String ret="accueilStage";
		disconnecting();
		return ret;
	}
	/**
	 * 
	 */
	public void disconnectLight(){
		getSessionController().setCurrentAuthAdminStructure(null);
		getSessionController().setCurrentAuthContact(null);
		getSessionController().setNotAdminEntrepriseViaCasShibb(false);
		getSessionController().setCurrentCentresGestion(null);
	}
	/**
	 * D�connexion
	 */
	public void disconnecting(){
		if(getSessionController().getCurrentAuthAdminStructure()!=null && logger.isInfoEnabled()){
			logger.info("Disconnection of : "+getSessionController().getCurrentAuthAdminStructure());
		}
		if(getSessionController().getCurrentAuthContact()!=null && logger.isInfoEnabled()){
			logger.info("Disconnection of : "+getSessionController().getCurrentAuthContact());
		}
		if(getSessionController().getCurrentAuthEtudiant()!=null && logger.isInfoEnabled()){
			logger.info("Disconnection of : "+getSessionController().getCurrentAuthEtudiant());
		}
		if(getSessionController().getCurrentAuthEnseignant()!=null && logger.isInfoEnabled()){
			logger.info("Disconnection of : "+getSessionController().getCurrentAuthEnseignant());
		}
		if(getSessionController().getCurrentAuthPersonnel()!=null && logger.isInfoEnabled()){
			logger.info("Disconnection of : "+getSessionController().getCurrentAuthPersonnel());
		}
		getSessionController().setCurrentAuthAdminStructure(null);
		getSessionController().setCurrentAuthContact(null);
		getSessionController().setNotAdminEntrepriseViaCasShibb(false);
		getSessionController().setCurrentAuthEtudiant(null);
		getSessionController().setCurrentAuthEnseignant(null);
		getSessionController().setCurrentAuthPersonnel(null);	
		getSessionController().setCurrentCentresGestion(null);
		getSessionController().setCurrentStageCasUser(null);
		getSessionController().setCentreGestionRattachement(null);
		try {
			getSessionController().logout();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the mailMotDePassePerdu
	 */
	public String getMailMotDePassePerdu() {
		return mailMotDePassePerdu;
	}

	/**
	 * @param mailMotDePassePerdu the mailMotDePassePerdu to set
	 */
	public void setMailMotDePassePerdu(String mailMotDePassePerdu) {
		this.mailMotDePassePerdu = mailMotDePassePerdu;
	}

	/**
	 * @return the listeStructuresTrouveeMotDePassePerdu
	 */
	public List<StructureDTO> getListeStructuresTrouveeMotDePassePerdu() {
		return listeStructuresTrouveeMotDePassePerdu;
	}

	/**
	 * @param listeStructuresTrouveeMotDePassePerdu the listeStructuresTrouveeMotDePassePerdu to set
	 */
	public void setListeStructuresTrouveeMotDePassePerdu(
			List<StructureDTO> listeStructuresTrouveeMotDePassePerdu) {
		this.listeStructuresTrouveeMotDePassePerdu = listeStructuresTrouveeMotDePassePerdu;
	}

	/**
	 * @return the structureSelectionneeMotDePassePerdu
	 */
	public StructureDTO getStructureSelectionneeMotDePassePerdu() {
		return structureSelectionneeMotDePassePerdu;
	}

	/**
	 * @param structureSelectionneeMotDePassePerdu the structureSelectionneeMotDePassePerdu to set
	 */
	public void setStructureSelectionneeMotDePassePerdu(
			StructureDTO structureSelectionneeMotDePassePerdu) {
		this.structureSelectionneeMotDePassePerdu = structureSelectionneeMotDePassePerdu;
	}
	/**
	 * @return the etablissementController
	 */
	public EtablissementController getEtablissementController() {
		return etablissementController;
	}

	/**
	 * @param etablissementController the etablissementController to set
	 */
	public void setEtablissementController(
			EtablissementController etablissementController) {
		this.etablissementController = etablissementController;
	}

	/**
	 * @return the offreController
	 */
	public OffreController getOffreController() {
		return offreController;
	}

	/**
	 * @param offreController the offreController to set
	 */
	public void setOffreController(OffreController offreController) {
		this.offreController = offreController;
	}

	/**
	 * @return the ldapUserService
	 */
	public LdapUserService getLdapUserService() {
		return ldapUserService;
	}
	/**
	 * @param ldapUserService the ldapUserService to set
	 */
	public void setLdapUserService(LdapUserService ldapUserService) {
		this.ldapUserService = ldapUserService;
	}
	/**
	 * @return the affiliation
	 */
	public String getAffiliation() {
		return affiliation;
	}
	/**
	 * @param affiliation the affiliation to set
	 */
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	/**
	 * @return the student
	 */
	public String getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(String student) {
		this.student = student;
	}
	/**
	 * @return the employee
	 */
	public String getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	/**
	 * @return the faculty
	 */
	public String getFaculty() {
		return faculty;
	}
	/**
	 * @param faculty the faculty to set
	 */
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	/**
	 * @return the creationConventionAutorisee
	 */
	public boolean isCreationConventionAutorisee() {
		return creationConventionAutorisee;
	}

	/**
	 * @param creationConventionAutorisee the creationConventionAutorisee to set
	 */
	public void setCreationConventionAutorisee(boolean creationConventionAutorisee) {
		this.creationConventionAutorisee = creationConventionAutorisee;
	}
	/**
	 * @param idLienDirect the idLienDirect to set
	 */
	public void setIdLienDirect(String idLienDirect) {
		this.idLienDirect = idLienDirect;
	}

	/**
	 * @return the idLienDirect
	 */
	public String getIdLienDirect() {
		return idLienDirect;
	}
}
