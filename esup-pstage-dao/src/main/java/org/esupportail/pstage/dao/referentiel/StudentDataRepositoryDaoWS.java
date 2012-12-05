package org.esupportail.pstage.dao.referentiel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.esupportail.commons.services.ldap.LdapUser;
import org.esupportail.commons.services.ldap.LdapUserService;
import org.esupportail.pstage.domain.beans.AdministrationApogee;
import org.esupportail.pstage.domain.beans.ApogeeMap;
import org.esupportail.pstage.domain.beans.ElementPedagogique;
import org.esupportail.pstage.domain.beans.EtapeInscription;
import org.esupportail.pstage.domain.beans.EtudiantRef;
import org.esupportail.pstage.domain.beans.LdapAttributes;
import org.esupportail.pstage.exceptions.AdministrationApogeeException;
import org.esupportail.pstage.exceptions.CommunicationApogeeException;
import org.esupportail.pstage.utils.DonneesStatic;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import pedagogiquemetier_28022011_impl.servicesmetiers.commun.apogee.education.gouv.PedagogiqueMetierServiceInterface;
import referentielmetier_18062010_impl.servicesmetiers.commun.apogee.education.gouv.ReferentielMetierServiceInterface;
import administratifmetier_17062009_impl.servicesmetiers.commun.apogee.education.gouv.AdministratifMetierServiceInterface;
import offreformationmetier_19072010_impl.servicesmetiers.commun.apogee.education.gouv.OffreFormationMetierServiceInterface;
import administratifmetier_17062009_impl.servicesmetiers.commun.apogee.education.gouv.WebBaseException;
import etudiantwebserviceimpl.impl.webservices.commun.apogee.education.gouv.EtudiantMetierServiceInterface;
import gouv.education.apogee.commun.transverse.dto.administratif.insadmanudto2.InsAdmAnuDTO2;
import gouv.education.apogee.commun.transverse.dto.administratif.insadmetpdto2.InsAdmEtpDTO2;
import gouv.education.apogee.commun.transverse.dto.etudiant.coordonneesdto.CoordonneesDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.identifiantsetudiantdto.IdentifiantsEtudiantDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.infoadmetudto.InfoAdmEtuDTO;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.diplomedto2.DiplomeDTO2;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.elementpedagogidto2.ElementPedagogiDTO2;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.listeelementpedagogidto2.ListeElementPedagogiDTO2;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.offreformationdto2.OffreFormationDTO2;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.secriteredto2.SECritereDTO2;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.versiondiplomedto2.VersionDiplomeDTO2;
import gouv.education.apogee.commun.transverse.dto.pedagogique.composantedto3.ComposanteDTO3;
import gouv.education.apogee.commun.transverse.dto.pedagogique.contratpedagogiqueresultatvdivetdto.ContratPedagogiqueResultatVdiVetDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.etaperesvdivetdto.EtapeResVdiVetDTO;


/**
 * Acces donnees etudiant
 */

@SuppressWarnings("serial")
public class StudentDataRepositoryDaoWS implements StudentDataRepositoryDao {

	/**
	 * 
	 */
	final Logger logger = Logger.getLogger(StudentDataRepositoryDaoWS.class);

	/**
	 * startYearDay
	 */
	protected String startYearDay;
	/**
	 * startYearMonth
	 */
	protected String startYearMonth;

	/**
	 * temoinRecupAnnu;
	 */
	protected String temoinRecupAnnu;

	/**
	 * ldapStudentIdIsCODETU
	 */
	protected boolean ldapStudentIdIsCODETU;


	/**
	 * see {@link LdapUserService}.
	 */
	private LdapUserService ldapUserService;

	/**
	 * This class contains all LDAP attributes used to OPI. 
	 */
	private LdapAttributes ldapAttributes;

	/**
	 * 
	 */
	private EtudiantMetierServiceInterface etudiantMetierService;

	/**
	 * 
	 */
	private AdministratifMetierServiceInterface serviceAdministratif;

	/**
	 * 
	 */
	private PedagogiqueMetierServiceInterface servicePedagogique;

	/**
	 * 
	 */
	private OffreFormationMetierServiceInterface offreFormationMetierService;

	/**
	 * 
	 */
	private ReferentielMetierServiceInterface referentielMetierService;

	/**
	 * @see org.esupportail.pstage.dao.referentiel.StudentDataRepositoryDao#getEtudiantRef(java.lang.String, java.lang.String)
	 */
	public EtudiantRef getEtudiantRef(String universityCode, String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentDataRepositoryDaoWS:: getEtudiantRef . universityCode  = "+universityCode + " pour id = "+id);
		}

		String filter = "(" + ldapAttributes.getLdapUid() + "=" + id + ")"; 

		List<LdapUser> listeLdapUser = ldapUserService.getLdapUsersFromFilter(filter);

		if (listeLdapUser.isEmpty()) {
			return null;
		}
		logger.debug("## taille de la liste : " + listeLdapUser.size());

		// parcours de la liste de LdapUser
		List <EtudiantRef> liste = new ArrayList<EtudiantRef>();
		for (Iterator<LdapUser> iter = listeLdapUser.iterator(); iter.hasNext();) {
			LdapUser ldapuser = iter.next();

			// creation d'un user et alimentation des données 
			EtudiantRef etudiantUser = new EtudiantRef();
			etudiantUser.setIdentEtudiant(ldapuser.getAttribute(ldapAttributes.getLdapUid()));
			etudiantUser.setNumEtudiant(ldapuser.getAttribute(ldapAttributes.getLdapStudentId()));    
			etudiantUser.setNom(ldapuser.getAttribute(ldapAttributes.getLdapName()));
			etudiantUser.setPrenom(ldapuser.getAttribute(ldapAttributes.getLdapFirstName()));
			if (ldapuser.getAttribute(ldapAttributes.getLdapMail()) != null) {
				etudiantUser.setMail(ldapuser.getAttribute(ldapAttributes.getLdapMail()));
			}
			List <String> compo = ldapuser.getAttributes(ldapuser.getAttribute(ldapAttributes.getLdapStudentAffectation()));
			LinkedHashMap<String,String> comps = new LinkedHashMap<String, String>();
			for (Iterator <String> c = compo.iterator(); c.hasNext();) {
				String code = c.next();
				comps.put(code, "");
			}

			etudiantUser.setStudys(comps);
			liste.add(etudiantUser);
		} 
		EtudiantRef studentLdap = new EtudiantRef();
		if (liste != null && !liste.isEmpty()) {
			studentLdap = liste.get(0);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("StudentDataRepositoryDaoWS:: getStudentByNum.studentLdap.getNom() = "+studentLdap.getNom());
		}
		String codEtu = studentLdap.getNumEtudiant();
		//CodEtu ldap = codeInd
		if (!this.ldapStudentIdIsCODETU) { 
			codEtu = getStudentCodEtu(codEtu);
		}
		EtudiantRef studentApogee = new EtudiantRef();
		EtudiantRef s = new EtudiantRef();
		AdministrationApogee adminApogee = new AdministrationApogee();
		adminApogee.setStatusApogee(true);
		adminApogee.setRaison("");

		// recherche des informations etudiant dans Apogee
		studentApogee = getStudentApogee(universityCode, codEtu);
		if (studentApogee != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("StudentDataRepositoryDaoWS:: apres  studentApogee studentApogee.getAdministrationApogee().isStatusApogee() = "+studentApogee.getAdministrationApogee().isStatusApogee());
				logger.debug("StudentDataRepositoryDaoWS:: apres  studentApogee studentApogee.getAdministrationApogee().getRaison() = "+studentApogee.getAdministrationApogee().getRaison());
			}
			if (studentApogee.getAdministrationApogee() != null) {
				adminApogee = studentApogee.getAdministrationApogee();
			}

			// renseignement des informations etudiant a partir infos ldap, apogee		
			s = rensInfosEtudiant(studentLdap, studentApogee);
			s.setCodeUniversite(universityCode);

			if (logger.isDebugEnabled()) {
				logger.debug("StudentDataRepositoryDaoWS:: apres  rensInfosEtudiant adminApogee.isStatusApogee() = "+adminApogee.isStatusApogee());
				logger.debug("StudentDataRepositoryDaoWS:: apres  rensInfosEtudiant adminApogee.getRaison() = "+adminApogee.getRaison());
			}
			s.setAdministrationApogee(adminApogee);
		} else {
			s = studentApogee;
		}	

		return s;
	}

	/**
	 * @see org.esupportail.pstage.dao.referentiel.StudentDataRepositoryDao#getEtudiantRefByNum(java.lang.String, java.lang.String)
	 */
	public EtudiantRef getEtudiantRefByNum(final String universityCode, final String id) {
		// id = numero etudiant
		if (logger.isDebugEnabled()) {
			logger.debug("StudentDataRepositoryDaoWS:: " 
					+ "getStudentByNum. universityCode  = " + universityCode + " pour id = " + id);
		}
		String codEtu = id;
		//recherche codEtu par le codInd
		if (!this.ldapStudentIdIsCODETU) {
			codEtu = getStudentCodInd(id);
		}
		String filter = "(" + ldapAttributes.getLdapStudentId() + "=" + codEtu + ")"; 
		List<LdapUser> listeLdapUser = ldapUserService.getLdapUsersFromFilter(filter);
		if (listeLdapUser.isEmpty()) {
			return null;
		}
		logger.debug("## taille de la liste : " + listeLdapUser.size());

		// parcours de la liste de LdapUser
		List <EtudiantRef> liste = new ArrayList<EtudiantRef>();
		for (Iterator<LdapUser> iter = listeLdapUser.iterator(); iter.hasNext();) {
			LdapUser ldapuser = iter.next();

			// creation d'un user et alimentation des données 
			EtudiantRef etudiantUser = new EtudiantRef();
			etudiantUser.setIdentEtudiant(ldapuser.getAttribute(ldapAttributes.getLdapUid()));
			etudiantUser.setNumEtudiant(ldapuser.getAttribute(ldapAttributes.getLdapStudentId()));    
			etudiantUser.setNom(ldapuser.getAttribute(ldapAttributes.getLdapName()));
			etudiantUser.setPrenom(ldapuser.getAttribute(ldapAttributes.getLdapFirstName()));
			if (ldapuser.getAttribute(ldapAttributes.getLdapMail()) != null) {
				etudiantUser.setMail(ldapuser.getAttribute(ldapAttributes.getLdapMail()));
			}
			List <String> compo = ldapuser.getAttributes(ldapuser.getAttribute(ldapAttributes.getLdapStudentAffectation()));
			LinkedHashMap<String,String> comps = new LinkedHashMap<String, String>();
			for (Iterator <String> c = compo.iterator(); c.hasNext();) {
				String code =  c.next();
				comps.put(code, "");
			}
			etudiantUser.setStudys(comps);
			liste.add(etudiantUser);
		} 
		EtudiantRef studentLdap = new EtudiantRef();
		if (liste != null && !liste.isEmpty()) {
			studentLdap = liste.get(0);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("StudentDataRepositoryDaoWS:: getStudentByNum.studentLdap.getNom() = "+studentLdap.getNom());
			logger.debug("StudentDataRepositoryDaoWS:: getStudentByNum. studentLdap.getMail() = "+studentLdap.getMail());
		}

		EtudiantRef studentApogee = new EtudiantRef();
		EtudiantRef s = new EtudiantRef();
		AdministrationApogee adminApogee = new AdministrationApogee();
		adminApogee.setStatusApogee(true);
		adminApogee.setRaison("");

		// recherche des informations etudiant dans Apogee
		studentApogee = getStudentApogee(universityCode, id);
		if (studentApogee != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("StudentDataRepositoryDaoWS:: apres  studentApogee studentApogee.getAdministrationApogee().isStatusApogee() = "+studentApogee.getAdministrationApogee().isStatusApogee());
				logger.debug("StudentDataRepositoryDaoWS:: apres  studentApogee studentApogee.getAdministrationApogee().getRaison() = "+studentApogee.getAdministrationApogee().getRaison());
			}
			if (studentApogee.getAdministrationApogee() != null) {
				adminApogee = studentApogee.getAdministrationApogee();
			}


			// renseignement des informations etudiant a partir infos ldap, apogee		
			s = rensInfosEtudiant(studentLdap, studentApogee);
			s.setCodeUniversite(universityCode);

			if (logger.isDebugEnabled()) {
				logger.debug("StudentDataRepositoryDaoWS:: apres  rensInfosEtudiant adminApogee.isStatusApogee() = "+adminApogee.isStatusApogee());
				logger.debug("StudentDataRepositoryDaoWS:: apres  rensInfosEtudiant adminApogee.getRaison() = "+adminApogee.getRaison());
			}
			s.setAdministrationApogee(adminApogee);
		} else {
			s = studentApogee;
		}	
		return s;
	}


	/**
	 * @see org.esupportail.pstage.dao.referentiel.StudentDataRepositoryDao#getEtudiantsRefByName(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<EtudiantRef> getEtudiantsRefByName(String universityCode,
			String name, String firstName) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentDataRepositoryDaoWS:: getStudentsByName universityCode  = "+universityCode );
		}
		universityCode=universityCode==null?"":universityCode;
		name=name==null?"":name;
		List<EtudiantRef> students = new ArrayList<EtudiantRef>();

		String filter = "(&(" + ldapAttributes.getLdapAffiliation() + "=" + ldapAttributes.getLdapStudentAffiliation() + ")"; 
		if (StringUtils.hasText(name)) {
			filter += "(" + ldapAttributes.getLdapName() + "=*" + name + "*)";
		}
		if (StringUtils.hasText(firstName)) {
			filter += "(" + ldapAttributes.getLdapFirstName() + "=*" + firstName + "*)";
		}

		filter += ")";

		if (logger.isDebugEnabled()) {
			logger.debug("filter LDAP = " + filter);
		}

		List<LdapUser> listeLdapUser = ldapUserService.getLdapUsersFromFilter(filter);

		if (listeLdapUser.isEmpty()) {
			return students;
		}
		logger.debug("## taille de la liste trouvee : " + listeLdapUser.size());

		if (listeLdapUser.size() > DonneesStatic.NB_RESPONSE_ETU_LDAP_MAXI) {
			EtudiantRef studentApogee = new EtudiantRef();
			AdministrationApogee adminApogee = new AdministrationApogee();
			adminApogee.setStatusApogee(false);
			adminApogee.setRaison("La liste est trop importante , veuillez affiner votre recherche");
			studentApogee.setAdministrationApogee(adminApogee);
			students.add(studentApogee);
			return students;
		}

		for (Iterator<LdapUser> iter = listeLdapUser.iterator(); iter.hasNext();) {
			LdapUser ldapuser = iter.next();

			// creation d'un user et alimentation des données 
			EtudiantRef etudiantUser = new EtudiantRef();
			etudiantUser.setIdentEtudiant(ldapuser.getAttribute(ldapAttributes.getLdapUid()));
			etudiantUser.setNumEtudiant(ldapuser.getAttribute(ldapAttributes.getLdapStudentId()));    
			etudiantUser.setNom(ldapuser.getAttribute(ldapAttributes.getLdapName()));
			etudiantUser.setPrenom(ldapuser.getAttribute(ldapAttributes.getLdapFirstName()));
			if (ldapuser.getAttribute(ldapAttributes.getLdapMail()) != null) {
				etudiantUser.setMail(ldapuser.getAttribute(ldapAttributes.getLdapMail()));
			}
			// informations composantes
			List <String> compo = ldapuser.getAttributes(ldapAttributes.getLdapStudentAffectation());
			LinkedHashMap<String,String> composLdap = new LinkedHashMap<String, String>();
			for (Iterator <String> c = compo.iterator(); c.hasNext();) {
				String code = c.next();
				composLdap.put(code, "");
			}
			etudiantUser.setStudys(composLdap);
			EtudiantRef studentLdap = etudiantUser;
			String codEtu = etudiantUser.getNumEtudiant();
			//CodEtu ldap = codeInd
			if (!this.ldapStudentIdIsCODETU) {
				codEtu = getStudentCodEtu(codEtu);
			}
			// recherche des informations etudiant dans Apogee
			EtudiantRef studentApogee = new EtudiantRef();
			AdministrationApogee adminApogee = new AdministrationApogee();
			adminApogee.setStatusApogee(true);
			adminApogee.setRaison("");
			studentApogee = getStudentApogee(universityCode, codEtu);
			if (studentApogee != null) {
				if (studentApogee.getAdministrationApogee() != null) {
					adminApogee = studentApogee.getAdministrationApogee();
					// si pas erreur administratif, ajout dans la liste
					if (adminApogee.isStatusApogee()) {
						// renseignement des informations etudiant a partir infos ldap, apogee		
						etudiantUser = rensInfosEtudiant(studentLdap, studentApogee);
						etudiantUser.setCodeUniversite(universityCode);
						etudiantUser.setAdministrationApogee(adminApogee);
						students.add(etudiantUser);
					}
				}
			}


		} 


		return students;
	}


	/**
	 * @param universityCode
	 * @param id
	 * @return studentApogee
	 */
	public EtudiantRef getStudentApogee(String universityCode, String id) {
		if (logger.isDebugEnabled()){
			logger.debug("StudentDataRepositoryDaoWS:: getStudentApogee. universityCode  = "+universityCode + " pour id = "+id);
		}

		//BigDecimal cod_ind = null;
		Integer cod_ind = null;
		String nompatro = "";
		String nommarital = "";
		String prenom = "";
		String mail = "";

		// adresse permanente etudiant 
		String mainAddress = "";
		// code postal etudiant 
		String postalCode = "";
		// commune etudiant 
		String town = "";
		// pays etudiant 
		String country = "";
		// telephone etudiant 
		String phone = "";
		// telephone portable etudiant 
		String portablePhone = "";
		// courrier personnel etudiant 
		String mailPerso = "";
		//code pays
		String codePays = "";
		// libelle adresse france
		String libAd1 = "";
		String libAd2 = "";
		String libAd3 = "";
		// libelle adresse etrangere
		String libAde = "";
		// code sexe etudiant
		String codeSexe = "";
		// date Naissance etudiant
		XMLGregorianCalendar dateNais =null;
		// libelle CPAM etudiant
		String libelleCPAM = "";
		EtudiantRef studentApogee = new EtudiantRef();
		AdministrationApogee adminApogee = new AdministrationApogee();
		adminApogee.setStatusApogee(true);
		adminApogee.setRaison("");

		try {

			// Recherche l'etudiant dans Apogee
			IdentifiantsEtudiantDTO etudiant;

			etudiant = etudiantMetierService.recupererIdentifiantsEtudiant(
					id, null, null, null, null, null, null, null, null, this.temoinRecupAnnu);

			// Recuperation des infos de l'etudiant dans Apogee
			InfoAdmEtuDTO infosAdmEtu = etudiantMetierService.recupererInfosAdmEtu(etudiant.getCodEtu().toString());

			// Recuperation des infos de l'etudiant dans Apogee
			CoordonneesDTO coordonnees = etudiantMetierService.recupererAdressesEtudiant(
					etudiant.getCodEtu().toString(), null, this.temoinRecupAnnu);

			cod_ind = etudiant.getCodInd();

			// recuperation du nom, prenom
			if (infosAdmEtu.getNomPatronymique() != null) {
				nompatro = infosAdmEtu.getNomPatronymique();
			} 
			if (infosAdmEtu.getNomUsuel() != null) {
				nommarital = infosAdmEtu.getNomUsuel();
			} 


			if (infosAdmEtu.getPrenom1() != null) {
				prenom = infosAdmEtu.getPrenom1();
			}
			//recuperation du code sexe et date de naissance de l'etudiant
			if (infosAdmEtu.getSexe() != null) {
				codeSexe = infosAdmEtu.getSexe();
			}

			if (infosAdmEtu.getDateNaissance() != null) {
				dateNais = infosAdmEtu.getDateNaissance();
			}

			// recherche des informations etudiant dans APOGEE
			if (cod_ind != null) {

				if (coordonnees.getAdresseFixe().getPays().getCodPay() != null) {
					codePays = coordonnees.getAdresseFixe().getPays().getCodPay();
				}
				if (coordonnees.getAdresseFixe().getLibAd1() != null) {
					libAd1 = coordonnees.getAdresseFixe().getLibAd1();
				}
				if (coordonnees.getAdresseFixe().getLibAd2() != null) {
					libAd2 = coordonnees.getAdresseFixe().getLibAd2();
				}
				if (coordonnees.getAdresseFixe().getLibAd3() != null) {
					libAd3 = coordonnees.getAdresseFixe().getLibAd3();
				}
				if (coordonnees.getAdresseFixe().getLibAde() != null) {
					libAde = coordonnees.getAdresseFixe().getLibAde();
				}
				if (coordonnees.getAdresseFixe().getCommune() != null) {
					if (coordonnees.getAdresseFixe().getCommune().getCodePostal() != null) {
						postalCode = coordonnees.getAdresseFixe().getCommune().getCodePostal();
					}
				}
				if (coordonnees.getAdresseFixe().getCommune() != null) {
					if (coordonnees.getAdresseFixe().getCommune().getNomCommune() != null) {
						town = coordonnees.getAdresseFixe().getCommune().getNomCommune();
					}
				}
				if (coordonnees.getAdresseFixe().getPays().getLibPay() != null) {
					country = coordonnees.getAdresseFixe().getPays().getLibPay();
				}
				if (coordonnees.getAdresseFixe().getNumTel() != null) {
					phone = coordonnees.getAdresseFixe().getNumTel();
				}
				if (coordonnees.getNumTelPortable() != null) {
					portablePhone = coordonnees.getNumTelPortable();
				}
				if (coordonnees.getEmail() != null) {
					mailPerso = coordonnees.getEmail();
				}
				// recuperation du mail dans l'annuaire
				if (coordonnees.getEmailAnnuaire() != null) {
					mail = coordonnees.getEmailAnnuaire();
				}

				if (codePays != null) {
					if (codePays.equals("100")) {
						if (libAd1 != null) {
							mainAddress = libAd1 + " ";
						}
						if (libAd2 != null) {
							mainAddress = mainAddress + libAd2 + " ";
						}
						if (libAd3 != null) {
							mainAddress = mainAddress + libAd3;
						}
					} else {
						if (libAd1 != null) {
							mainAddress = libAd1 + " ";
						}
						if (libAd2 != null) {
							mainAddress = mainAddress + libAd2 + " ";
						}
						if (libAde != null) {
							mainAddress = mainAddress + libAde;
						}
					}
				}

			}
			// recherche de la liste des etapes, versions etape de l'etudiant
			LinkedHashMap<String,String> steps = new LinkedHashMap<String, String>();
			ApogeeMap apogeeMap = getStudentSteps(etudiant.getCodEtu().toString());
			steps = apogeeMap.getStudentSteps();
			// recuperation Map des elements pedagogiques
			LinkedHashMap <String,ElementPedagogique> elementPedagogiques = new LinkedHashMap<String, ElementPedagogique>();
			elementPedagogiques = apogeeMap.getElementPedagogiques();
			// recuperation liste des ElPs
			List<ElementPedagogique> listeELPs = new  ArrayList<ElementPedagogique>();
			listeELPs = apogeeMap.getListeELPs();
			// recuperation liste des etapes inscriptions
			List<EtapeInscription> listeEtapeInscriptions = new  ArrayList<EtapeInscription>();
			listeEtapeInscriptions = apogeeMap.getListeEtapeInscriptions();
			// recherche de la liste des composantes
			LinkedHashMap<String,String> comps = new LinkedHashMap<String, String>();
			comps = getStudentComposantes(etudiant.getCodEtu().toString());
			if (logger.isDebugEnabled()) {
				logger.debug("StudentDataRepositoryDaoWS:: getStudent .*** steps Apogee *** = " + steps);
				logger.debug("StudentDataRepositoryDaoWS:: getStudent .*** comps Apogee *** = " + comps);
			}	

			List<String> stepscods = new ArrayList<String>();
			if (steps != null) {
				Iterator<String> it2 = steps.keySet().iterator();
				while(it2.hasNext()){
					stepscods.add(it2.next());
				}
			}


			try {
				// recuperer les donnees CPAM
				if (logger.isDebugEnabled()) {
					logger.debug("StudentDataRepositoryDaoWS:: getStudentByNum.  serviceAdministratif.recupererIAAnnuelles_v2 = ");
				}
				List<InsAdmAnuDTO2> tabinsAdmAnu = serviceAdministratif.recupererIAAnnuellesV2(etudiant.getCodEtu().toString(), getYear(), "E");
				for (InsAdmAnuDTO2 insAdmAnu : tabinsAdmAnu) {
					if (logger.isDebugEnabled()) {
						logger.debug("StudentDataRepositoryDaoWS:: getStudentByNum.  insAdmAnu.getTemoinAffiliationSS()= "+insAdmAnu.getTemoinAffiliationSS());
					}
					if (insAdmAnu.getCpam() != null) {
						if (logger.isDebugEnabled()) {
							logger.debug("StudentDataRepositoryDaoWS:: getStudentByNum.  insAdmAnu.getCpam().getCodeCpam() = "+insAdmAnu.getCpam().getCodeCpam());
							logger.debug("StudentDataRepositoryDaoWS:: getStudentByNum.  insAdmAnu.getCpam().getLibCpam() = "+insAdmAnu.getCpam().getLibCpam());
						}
						if (insAdmAnu.getCpam().getLibCpam() != null) {
							libelleCPAM = insAdmAnu.getCpam().getLibCpam();
						}
					}

				}
			} catch (WebBaseException e) {
				logger.error("WebBaseException getStudentApogee = " + e );
				if (e.toString().equals("technical.security.invaliduser.user")) {
					logger.error("etudiant non trouve IAA = " + id );

				} 
				if (e.toString().equals("technical.data.nullretrieve.findIAA")) {
					logger.error("pas IAA pour etudiant= " + id );

				} 
			}



			studentApogee.setIdentEtudiant(id);
			studentApogee.setNumEtudiant(etudiant.getCodEtu().toString());
			studentApogee.setNom(nompatro);	
			studentApogee.setNomMarital(nommarital);	
			studentApogee.setPrenom(prenom);
			studentApogee.setMail(mail);

			studentApogee.setStudys(comps);
			studentApogee.setSteps(steps);
			studentApogee.setCodeUniversite(universityCode);

			// ajout des informations etudiants
			studentApogee.setMainAddress(mainAddress);
			studentApogee.setCountry(country);
			studentApogee.setMailPerso(mailPerso);
			studentApogee.setPortablePhone(portablePhone);
			studentApogee.setTel(phone);
			studentApogee.setPostalCode(postalCode);
			studentApogee.setTown(town);
			studentApogee.setCodeSexe(codeSexe);
			studentApogee.setDateNais(dateNais);
			// ajout des elements pedagogiques
			studentApogee.setElementPedagogiques(elementPedagogiques);
			studentApogee.setListeELPs(listeELPs);
			// ajout etapes- version etapes inscriptions
			studentApogee.setListeEtapeInscriptions(listeEtapeInscriptions);
			// ajout du libelle CPAM
			studentApogee.setLibelleCPAM(libelleCPAM);
			studentApogee.setAdministrationApogee(adminApogee);
			return studentApogee;

		} catch (AdministrationApogeeException e) {
			logger.error("AdministrationApogeeException getStudentApogee = " + e);
			logger.error("AdministrationApogeeException getStudentApogee = e.getCause()" + e.getCause());
			if (e.toString().equals("technical.data.nullretrieve.etudiant")) {
				logger.error("etudiant non trouve = " + id );
				return null;
			}
			// pas d'inscription Administrative pour IA
			if (e.getCause().toString().equals("technical.data.nullretrieve.findIAE")) {
				adminApogee.setStatusApogee(false);
				adminApogee.setRaison("pas d'inscriptionAdministrative pour cet etudiant");
				studentApogee.setAdministrationApogee(adminApogee);
			}
			return studentApogee;
		} catch (Exception e) {
			logger.error("Exception getStudentApogee = " + e);
			throw new CommunicationApogeeException(e);
		}

	}

	/**
	 * @param studentLdap
	 * @param studentApogee
	 * @return EtudiantRef
	 */
	public EtudiantRef rensInfosEtudiant(EtudiantRef studentLdap, EtudiantRef studentApogee){
		if (logger.isDebugEnabled()) {
			logger.debug("StudentDataRepositoryDaoWS:: rensInfosEtudiant. ");
		}

		String nompatro = "";
		String nommarital = "";
		String prenom = "";
		String mail = "";

		// adresse permanente etudiant 
		String mainAddress = "";
		// code postal etudiant 
		String postalCode = "";
		// commune etudiant 
		String town = "";
		// pays etudiant 
		String country = "";
		// telephone etudiant 
		String phone = "";
		// telephone portable etudiant 
		String portablePhone = "";
		// courrier personnel etudiant 
		String mailPerso = "";
		// code sexe etudiant
		String codeSexe = "";
		// date Naissance etudiant
		XMLGregorianCalendar dateNais = null;
		// libelle CPAM etudiant
		String libelleCPAM = "";
		//
		LinkedHashMap<String,String> steps = new LinkedHashMap<String, String>();

		EtudiantRef s = new EtudiantRef();
		s.setIdentEtudiant(studentLdap.getIdentEtudiant());
		s.setNumEtudiant(studentLdap.getNumEtudiant());
		if (studentApogee != null) {
			if (studentApogee.getStudys() != null && !studentApogee.getStudys().isEmpty()) {
				s.setStudys(studentApogee.getStudys());
			}			
		} else {
			s.setStudys(studentLdap.getStudys());
		}

		if (studentApogee != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("StudentDataRepositoryDaoWS:: getStudentByNum. studentApogee.getNom() = "+studentApogee.getNom());
				logger.debug("StudentDataRepositoryDaoWS:: getStudentByNum. studentApogee.getMail() = "+studentApogee.getMail());
			}
			s.setNom(studentApogee.getNom());	
			s.setPrenom(studentApogee.getPrenom());
			// recuperation du mail dans l'annuaire
			if (StringUtils.hasText(studentApogee.getMail())) {
				mail = studentApogee.getMail();
			} else {
				if (studentLdap.getMail() != null) {
					mail = studentLdap.getMail();
				}
			}


			s.setSteps(studentApogee.getSteps());
			// ajout des informations etudiants
			s.setMainAddress(studentApogee.getMainAddress());
			s.setCountry(studentApogee.getCountry());
			s.setMailPerso(studentApogee.getMailPerso());
			s.setMail(mail);
			s.setTel(studentApogee.getTel());
			s.setPortablePhone(studentApogee.getPortablePhone());
			s.setPostalCode(studentApogee.getPostalCode());
			s.setTown(studentApogee.getTown());
			s.setCodeSexe(studentApogee.getCodeSexe());
			s.setDateNais(studentApogee.getDateNais());
			// ajout des elements pedagogiques
			s.setElementPedagogiques(studentApogee.getElementPedagogiques());
			s.setListeELPs(studentApogee.getListeELPs());
			// ajout etapes- version etapes inscriptions
			s.setListeEtapeInscriptions(studentApogee.getListeEtapeInscriptions());
			s.setLibelleCPAM(studentApogee.getLibelleCPAM());
			//Code Etu
			s.setNumEtudiant(studentApogee.getNumEtudiant());
		} else {
			s.setNom(nompatro);	
			s.setNomMarital(nommarital);	
			s.setPrenom(prenom);
			if (studentLdap.getMail() != null) {
				mail = studentLdap.getMail();
			} 
			s.setSteps(steps);

			// ajout des informations etudiants
			s.setMainAddress(mainAddress);
			s.setCountry(country);
			s.setMailPerso(mailPerso);
			s.setMail(mail);
			s.setTel(phone);
			s.setPortablePhone(portablePhone);
			s.setPostalCode(postalCode);
			s.setTown(town);
			s.setCodeSexe(codeSexe);
			s.setDateNais(dateNais);
			s.setLibelleCPAM(libelleCPAM);
		}
		return s;
	}


	/**
	 * @param cod
	 * @return ApogeeMap
	 */
	public ApogeeMap getStudentSteps(String cod) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentDataRepositoryDaoWS:: getStudentSteps  cod = " + cod);
		}

		// recherche des Inscriptions Administratives et Inscription Pedagogiques
		ApogeeMap apogeeMap = getStudentIAIP(cod);
		if (apogeeMap != null) {
			apogeeMap.getStudentSteps();
			// recherche des elements pedagogiques
			getStudentELPV2(cod, apogeeMap);
		}

		return apogeeMap;
	}

	/**
	 * recherche des Inscriptions Administratives et Inscriptions Pedagogiques.
	 * @param cod 
	 * @return  ApogeeMap
	 */
	public ApogeeMap getStudentIAIP(String cod) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentDataRepositoryDaoWS:: getStudentIAIP  cod = " + cod);
		}
		ApogeeMap apogeeMap = new ApogeeMap();

		try {

			HashMap<String, Object> parameterMap2 = new HashMap<String, Object>();
			parameterMap2.put("val", Arrays.asList(cod,getYear()));

			// recuperer les Inscriptions Administratives de l'etudiant
			// dont inscription admin annuelle est en cours (E), inscription admin  etape est en cours (E), pour annee
			List<InsAdmEtpDTO2> tabInsAdmEtp = serviceAdministratif.recupererIAEtapesV2(cod, getYear(),"E", "E");
			LinkedHashMap<String,String> lEtape = new LinkedHashMap<String, String>();
			LinkedHashMap<String,String> lEtapeVet = new LinkedHashMap<String, String>();
			LinkedHashMap<String,String> lEtapeVetPedago = new LinkedHashMap<String, String>();
			List<EtapeInscription> listeEtapeInscriptions = new  ArrayList<EtapeInscription>();
			// recuperer les Inscriptions Administratives de l'etudiant, inscription payee, test sur le codeInscriptionPayee
			for (InsAdmEtpDTO2 insAdmEtp : tabInsAdmEtp) {
				if (logger.isDebugEnabled()){
					logger.debug("StudentDataRepositoryDaoWS:: lecture insAdmEtp, cod = "+insAdmEtp.getEtape().getCodeEtp() + " lib = "+insAdmEtp.getEtape().getLibWebVet() +
							" insAdmEtp.getEtape().getVersionEtp() : " + insAdmEtp.getEtape().getVersionEtp() +
							" insAdmEtp.getCodeInscriptionPayee() : " + insAdmEtp.getCodeInscriptionPayee() ); 
				}

				if (insAdmEtp.getCodeInscriptionPayee().equals("P")) {
					Object idl = insAdmEtp.getEtape().getCodeEtp();
					String lib = insAdmEtp.getEtape().getLibWebVet();
					// liste Etape
					lEtape.put(idl + "", lib);
					// liste etape-versionEtape
					String vet = insAdmEtp.getEtape().getVersionEtp();
					lEtapeVet.put(idl + "", vet);
					// renseignement de la liste des etapes- version etapes - inscriptions
					EtapeInscription etpins = new EtapeInscription();
					etpins.setCodeEtp(insAdmEtp.getEtape().getCodeEtp());
					etpins.setCodVrsVet(insAdmEtp.getEtape().getVersionEtp());
					etpins.setLibWebVet(insAdmEtp.getEtape().getLibWebVet());
					etpins.setCodeComposante(insAdmEtp.getComposante().getCodComposante());
					etpins.setLibComposante(insAdmEtp.getComposante().getLibComposante());
					etpins.setTypeIns(DonneesStatic.TYPE_INS_ADMIN);
					if (insAdmEtp.getDiplome() != null) {
						String codeDiplome = insAdmEtp.getDiplome().getCodeDiplome();
						etpins.setCodeDiplome(codeDiplome);
						etpins.setLibDiplome(insAdmEtp.getDiplome().getLibLongDiplome());
						String versDiplome = insAdmEtp.getDiplome().getVersionDiplome();
						etpins.setVersionDiplome(versDiplome);
						try {

							// recherche du cursus LMD, codFinalite
							SECritereDTO2 seCritereDTO = new SECritereDTO2();
							seCritereDTO.setCodAnu(getYear());
							seCritereDTO.setCodDip(codeDiplome);
							seCritereDTO.setCodElp("aucun");
							seCritereDTO.setCodEtp("aucun");
							seCritereDTO.setCodVrsVdi(versDiplome);
							seCritereDTO.setCodVrsVet("aucun");

							List<DiplomeDTO2> diplomeDTO = offreFormationMetierService.recupererSEV2(seCritereDTO);
							if (diplomeDTO != null) {
								if (logger.isDebugEnabled()) {
									logger.debug("StudentDataRepositoryDaoWS:: getStudentIAIP. diplomeDTO  = " + diplomeDTO.size());
								}
								for (int i = 0; i < diplomeDTO.size(); i++) {
									List<VersionDiplomeDTO2> versionDiplome = diplomeDTO.get(i).getListVersionDiplome().getItem();
									for (int j = 0; j < versionDiplome.size(); j++) {
										if (versionDiplome.get(j).getCodCursusLmd() != null) {
											etpins.setCodCursusLmd(versionDiplome.get(j).getCodCursusLmd());
										}
										OffreFormationDTO2 offreFormation = versionDiplome.get(j).getOffreFormation();
										if (offreFormation != null) {
											if (offreFormation.getCodFinalite() != null) {
												etpins.setCodFinalite(offreFormation.getCodFinalite());
											}
											if (offreFormation.getLibFinalite() != null) {
												etpins.setLibFinalite(offreFormation.getLibFinalite());
											}
										}
									}
								}
							}
						} catch (Exception e) {
							logger.error("Exception getStudentIAIP = " + e );
							if (e.toString().equals("technical.data.nullretrieve.recupererse")) {
								logger.error("aucune donnee en sortie = " + cod + "diplome/vers = " + codeDiplome + versDiplome);
								continue;
							}
							continue;
						}



					}

					listeEtapeInscriptions.add(etpins);
					if (logger.isDebugEnabled()){
						logger.debug("StudentDataRepositoryDaoWS:: cod = "+cod);
						logger.debug("StudentDataRepositoryDaoWS:: getYear() = "+getYear());
						logger.debug("StudentDataRepositoryDaoWS:: insAdmEtp.getEtape().getCodeEtp() = "+insAdmEtp.getEtape().getCodeEtp());
						logger.debug("StudentDataRepositoryDaoWS:: insAdmEtp.getEtape().getVersionEtp() = "+insAdmEtp.getEtape().getVersionEtp());
						logger.debug("StudentDataRepositoryDaoWS:: insAdmEtp.getComposante().getCodComposante() = "+insAdmEtp.getComposante().getCodComposante());
					}
				}
			}
			// recherche les Inscriptions pedagogiques 
			if (logger.isDebugEnabled()){
				logger.debug("servicePedagogique.recupererContratPedagogiqueResultatVdiVet");

			}
			List<ContratPedagogiqueResultatVdiVetDTO>  tabcontratPedagoResultatVdiVet = 
					servicePedagogique.recupererContratPedagogiqueResultatVdiVet(cod, getYear(), DonneesStatic.ws_sourceRes_Apogee, "", "", "");
			if(tabcontratPedagoResultatVdiVet!=null){
				for (ContratPedagogiqueResultatVdiVetDTO contratPedagoResVdiVet : tabcontratPedagoResultatVdiVet) {

					List<EtapeResVdiVetDTO> tabEtapeResVdiVet = contratPedagoResVdiVet.getEtapes().getItem();
					for (EtapeResVdiVetDTO etapeResVdiVet : tabEtapeResVdiVet) {
						if (etapeResVdiVet.getEtape() != null) {
							if (logger.isDebugEnabled()){
								logger.debug("StudentDataRepositoryDaoWS:: etapeResVdiVet.getEtape().getCodEtp() = "+etapeResVdiVet.getEtape().getCodEtp());
								logger.debug("StudentDataRepositoryDaoWS:: etapeResVdiVet.getEtape().getCodVrsVet() = "+etapeResVdiVet.getEtape().getCodVrsVet());
								logger.debug("StudentDataRepositoryDaoWS:: etapeResVdiVet.getEtape().etapeResVdiVet.getCodEtaIae() = "+etapeResVdiVet.getCodEtaIae());
							}
							// prendre les IP en cours "E"
							if (etapeResVdiVet.getCodEtaIae() != null) {
								if (etapeResVdiVet.getCodEtaIae().equals("E")) {
									// liste etape
									Object idl=etapeResVdiVet.getEtape().getCodEtp();
									String lib=etapeResVdiVet.getEtape().getLibWebVet();
									lEtape.put(idl+"",lib);
									// liste etape-versionEtape
									String vet=etapeResVdiVet.getEtape().getCodVrsVet().toString();
									lEtapeVet.put(idl+"",vet);
									// liste etape-versionEtape pedagogique
									lEtapeVetPedago.put(idl+"",vet);
									// renseignement de la liste des etapes- version etapes - inscriptions
									EtapeInscription etpins = new EtapeInscription();
									etpins.setCodeEtp(etapeResVdiVet.getEtape().getCodEtp());
									etpins.setCodVrsVet(etapeResVdiVet.getEtape().getCodVrsVet().toString());
									etpins.setLibWebVet(etapeResVdiVet.getEtape().getLibWebVet());
									etpins.setTypeIns(DonneesStatic.TYPE_INS_PEDAGO);
									listeEtapeInscriptions.add(etpins);
								}
							}
						}
					}
				}
			}
			apogeeMap.setStudentSteps(lEtape);
			apogeeMap.setStudentsEtapesVets(lEtapeVet);
			apogeeMap.setStudentsEtapesVetsPedago(lEtapeVetPedago);
			apogeeMap.setListeEtapeInscriptions(listeEtapeInscriptions);
			return apogeeMap;
		} catch (WebBaseException e) {
			logger.error("WebBaseException getStudentIAIP = " + e );

			if (e.toString().equals("technical.parameter.noncoherentinput.invalidUser")) {
				logger.error("etudiant non trouve = " + cod );
			}
			if (e.toString().equals("technical.data.nullretrieve.DossierEtudiantIP")) {
				logger.error("pas d'inscription pedagogique pour etudiant  = " + cod );

			}
			if (e.toString().equals("technical.data.nullretrieve.findIAE")) {
				logger.error(e + " : " + cod );
				logger.error(e.getMessage() + " : " + cod );
				// TODO
				throw new AdministrationApogeeException(e.getMessage(),e);
			}
			return apogeeMap;
		}
		catch (Exception e) {
			logger.error("Exception getStudentIAIP = " + e);
			throw new CommunicationApogeeException(e);
		}
	}


	/**
	 * recherche des ELPs etudiant.
	 * @param cod 
	 * @param apogeeMap 
	 * @return ApogeeMap
	 */

	public ApogeeMap getStudentELPV2(final String cod, final ApogeeMap apogeeMap) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentDataRepositoryDaoWS:: getStudentELPV2 cod = " + cod);
		}
		try {
			// recuperation des etapes pedagogiques
			LinkedHashMap<String,String> tabStudentsEtapesVets = apogeeMap.getStudentsEtapesVetsPedago();
			String etape = "";
			String vetEtape = "";
			LinkedHashMap<String,ElementPedagogique> elementPedagogiques = new LinkedHashMap<String,ElementPedagogique>();
			List<ElementPedagogique> listeELPs = new  ArrayList<ElementPedagogique>();
			if (tabStudentsEtapesVets != null &&  (!tabStudentsEtapesVets.isEmpty())) {
				Iterator<String> it2 = tabStudentsEtapesVets.keySet().iterator();
				while (it2.hasNext()) {
					etape = it2.next();
					vetEtape = tabStudentsEtapesVets.get(etape);
					if (logger.isDebugEnabled()) {
						logger.debug("getStudentELPV2:: Etape  = " + etape);
						logger.debug("getStudentELPV2:: VetEtape  = " + vetEtape);
					}
					try {
						// recherche des elements pedagogiques pour une etape/version etape
						SECritereDTO2 seCritereDTO = new SECritereDTO2();
						seCritereDTO.setCodAnu(getYear());
						seCritereDTO.setCodDip("aucun");
						seCritereDTO.setCodElp("tous");
						seCritereDTO.setCodEtp(etape);
						seCritereDTO.setCodVrsVdi("aucun");
						seCritereDTO.setCodVrsVet(vetEtape);

						// recherche des Elements Pedagogiques des etapes, versions etapes
						List<DiplomeDTO2> diplomeDTO = 
								offreFormationMetierService.recupererSEV2(seCritereDTO);
						if (diplomeDTO != null) {
							if (logger.isDebugEnabled()) {
								logger.debug("StudentDataRepositoryDaoWS:: getStudentELPV2. diplomeDTO  = " + diplomeDTO.size());
							}
							for (int i = 0; i < diplomeDTO.size(); i++) {
								List<VersionDiplomeDTO2> versionDiplome = diplomeDTO.get(i).getListVersionDiplome().getItem();
								for (int j = 0; j < versionDiplome.size(); j++) {
									OffreFormationDTO2 offreFormation = versionDiplome.get(j).getOffreFormation();
									List<ListeElementPedagogiDTO2> listeelementPedagogiDTO = 
											offreFormation.getListEtape().getItem().get(0).getListVersionEtape().getItem().get(0).getListListeElementPedagogi().getItem();
									for (int k = 0; k < listeelementPedagogiDTO.size(); k++) {
										List<ElementPedagogiDTO2> elementPedagogique = listeelementPedagogiDTO.get(k).getListElementPedagogi().getItem();
										for (int l = 0; l < elementPedagogique.size(); l++) {
											if (logger.isDebugEnabled()) {
												logger.debug("elementPedagogique.get(l).getCodElp() = " + elementPedagogique.get(l).getCodElp());
												logger.debug("elementPedagogique.get(l).getCredits() = " + elementPedagogique.get(l).getCredits());
											}
											//remplissage de la table des elements pedagogiques, si elp de type stage
											if (elementPedagogique.get(l).getTemStage().equals("O") ) {
												elementPedagogique.get(l).getCodElp();
												elementPedagogique.get(l).getCredits();
												elementPedagogique.get(l).getTemStage();
												ElementPedagogique elpedago = new ElementPedagogique();
												elpedago.setCodEtp(etape);
												elpedago.setCodVrsVet(vetEtape);
												elpedago.setCodElp(elementPedagogique.get(l).getCodElp());
												elpedago.setLibElp(elementPedagogique.get(l).getLibElp());
												elpedago.setTemElpTypeStage(elementPedagogique.get(l).getTemStage());
												if (elementPedagogique.get(l).getCredits() != null) {
													elpedago.setNbrCrdElp(elementPedagogique.get(l).getCredits());
												}
												//renseignement de la map element pedagogique
												Object idl=etape;
												elementPedagogiques.put(idl+"",elpedago);
												// renseignement de la liste des elements pedagogiques
												if (!listeELPs.contains(elpedago)) {
													listeELPs.add(elpedago) ;
												}


											}
										}
									}
								}
							}
						}
					} catch (Exception e) {
						logger.error("Exception getStudentELPV2 = " + e );
						if (e.toString().equals("technical.data.nullretrieve.recupererse")) {
							logger.error("aucune donnee en sortie = " + cod + "etape/vet = " + etape + vetEtape);
							continue;
						}
						continue;
					}
				}
			}
			apogeeMap.setElementPedagogiques(elementPedagogiques);
			apogeeMap.setListeELPs(listeELPs);
			return apogeeMap;
		} catch (Exception e) {
			logger.error("Exception in getStudentELPV2 = " + e);
			throw new CommunicationApogeeException(e);
		}
	}

	/**
	 * @param codInd
	 * @return le codEtu pour le codInd passé en paramètre
	 */
	public String getStudentCodEtu(final String codInd) {
		String codEtu = codInd;
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("StudentDataRepositoryDaoWS:: " 
						+ "getStudentCodEtu  this.temoinRecupAnnu = " + this.temoinRecupAnnu);
			}
			// Recherche l'etudiant par le codind dans Apogee
			IdentifiantsEtudiantDTO etudiant = etudiantMetierService.recupererIdentifiantsEtudiant(
					null, codInd, null, null, null, null, null, null, null, this.temoinRecupAnnu);
			codEtu = etudiant.getCodEtu().toString();
		} catch (etudiantwebserviceimpl.impl.webservices.commun.apogee.education.gouv.WebBaseException e) {
			logger.error("WebBaseException in getStudentByNum = " + e );
			if (e.toString().equals("technical.security.invaliduser.user")) {
				logger.error("etudiant non trouve IAA = " + codInd );

			} 
			if (e.toString().equals("technical.data.nullretrieve.findIAA")) {
				logger.error("pas IAA pour etudiant= " + codInd );

			} 
		}
		return codEtu;
	}


	/**
	 * @param codEtu
	 * @return le codInd pour le codEtu passé en paramètre
	 */
	public String getStudentCodInd(final String codEtu) {
		String codInd = codEtu;
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("StudentDataRepositoryDaoWS:: " 
						+ "getStudentCodInd  this.temoinRecupAnnu = " + this.temoinRecupAnnu);
			}
			// Recherche du codInd de l'etudiant dans Apogee
			IdentifiantsEtudiantDTO etudiant = etudiantMetierService.recupererIdentifiantsEtudiant(
					codEtu, null, null, null, null, null, null, null, null, this.temoinRecupAnnu);
			codInd = etudiant.getCodInd().toString();
		} catch (etudiantwebserviceimpl.impl.webservices.commun.apogee.education.gouv.WebBaseException e) {
			logger.error("WebBaseException in getStudentByNum = " + e );
			if (e.toString().equals("technical.security.invaliduser.user")) {
				logger.error("etudiant non trouve IAA = " + codEtu );

			} 
			if (e.toString().equals("technical.data.nullretrieve.findIAA")) {
				logger.error("pas IAA pour etudiant= " + codEtu );

			} 
		}
		return codInd;
	}

	/**
	 * @param cod
	 * @return LinkedHashMap<String,String>
	 */
	public LinkedHashMap<String,String> getStudentComposantes(final String cod) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentDataRepositoryDaoWS:: getStudentComposantes  cod = " + cod);
		}
		LinkedHashMap<String,String> lvide = new LinkedHashMap<String, String>();
		try {
			HashMap<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("val", Arrays.asList(cod,getYear()));
			// recuperer les Inscriptions Administratives de l'etudiant
			// dont inscription admin annuelle est en cours (E), inscription admin a etape est en cours (E), pour annee
			List<InsAdmEtpDTO2> tabInsAdmEtp = serviceAdministratif.recupererIAEtapesV2(cod, getYear(),"E", "E");

			LinkedHashMap<String,String> l = new LinkedHashMap<String, String>();

			// recuperer les Inscriptions Administratives de l'etudiant, inscription payee, test sur le codeInscriptionPayee
			for (InsAdmEtpDTO2 insAdmEtp : tabInsAdmEtp) {
				if (logger.isDebugEnabled()){
					logger.debug("StudentDataRepositoryDaoWS:: lecture insAdmEtp, cod = "+insAdmEtp.getEtape().getCodeEtp() + " lib = "+insAdmEtp.getEtape().getLibWebVet() +
							" insAdmEtp.getCodeInscriptionPayee() : " + insAdmEtp.getCodeInscriptionPayee() );
				}
				if (insAdmEtp.getCodeInscriptionPayee().equals("P")) {
					Object idl = insAdmEtp.getComposante().getCodComposante();
					String lib = insAdmEtp.getComposante().getLibComposante();
					if(lib == null){
						List<ComposanteDTO3> lcomposante = referentielMetierService.recupererComposanteV2((String)idl, null);
						if(lcomposante.get(0)!=null && lcomposante.get(0).getLibCmp()!=null){
							lib=lcomposante.get(0).getLibCmp();
						}
					}
					l.put(idl + "" , lib);
					if (logger.isDebugEnabled()) {
						logger.debug("StudentDataRepositoryDaoWS:: " 
								+ "insAdmEtp.getComposante().getCodComposante() = "
								+ insAdmEtp.getComposante().getCodComposante());
						logger.debug("StudentDataRepositoryDaoWS:: " 
								+ "insAdmEtp.getComposante().getLibComposante() = "
								+ insAdmEtp.getComposante().getLibComposante());
					}

				}

			}
			return l;
		} catch (WebBaseException e) {
			logger.error("WebBaseException in getStudentComposantes = " + e );

			if (e.toString().equals("technical.parameter.noncoherentinput.invalidUser")) {
				logger.error("etudiant non trouve = " + cod );
			}
			if (e.toString().equals("technical.data.nullretrieve.DossierEtudiantIP")) {
				logger.error("pas d'inscription pedagogique pour etudiant  = " + cod );

			}

			if (e.toString().equals("technical.data.nullretrieve.findIAE")) {
				logger.error("pas d'inscriptionAdministrative pour etudiant  = " + cod );
			}

			return lvide;

		} catch (Exception e) {
			logger.error("Exception in getStudentComposantes = " + e);
			throw new CommunicationApogeeException(e);
		}
	}

	/**
	 * @return String Year
	 */
	public String getYear(){
		String year="";
		Date d=new Date();
		DateFormat formatY = new SimpleDateFormat("yyyy");
		DateFormat formatM = new SimpleDateFormat("MM");
		DateFormat formatD = new SimpleDateFormat("dd");
		int month = Integer.parseInt(formatM.format(d));
		int day = Integer.parseInt(formatD.format(d));
		try{
			int sYM = Integer.parseInt(this.startYearMonth);
			int sYD = Integer.parseInt(this.startYearDay);
			if(sYM <= month && sYD <= day){
				year=formatY.format(d);
			}else{
				year=Integer.parseInt(formatY.format(d))-1+"";
			}
		}catch(NumberFormatException e){
			logger.error("Les valeurs de start.year.day et de start.year.month doivent etre des entiers",e);
			return null;
		}
		return year.trim();
	}


	/**
	 * Getters/Setters 
	 */


	/**
	 * @return the startYearDay
	 */
	public String getStartYearDay() {
		return startYearDay;
	}

	/**
	 * @param startYearDay the startYearDay to set
	 */
	public void setStartYearDay(String startYearDay) {
		this.startYearDay = startYearDay;
	}

	/**
	 * @return the startYearMonth
	 */
	public String getStartYearMonth() {
		return startYearMonth;
	}

	/**
	 * @param startYearMonth the startYearMonth to set
	 */
	public void setStartYearMonth(String startYearMonth) {
		this.startYearMonth = startYearMonth;
	}

	/**
	 * @return the temoinRecupAnnu
	 */
	public String getTemoinRecupAnnu() {
		return temoinRecupAnnu;
	}

	/**
	 * @param temoinRecupAnnu the temoinRecupAnnu to set
	 */
	public void setTemoinRecupAnnu(String temoinRecupAnnu) {
		this.temoinRecupAnnu = temoinRecupAnnu;
	}

	/**
	 * @return the ldapStudentIdIsCODETU
	 */
	public boolean isLdapStudentIdIsCODETU() {
		return ldapStudentIdIsCODETU;
	}

	/**
	 * @param ldapStudentIdIsCODETU the ldapStudentIdIsCODETU to set
	 */
	public void setLdapStudentIdIsCODETU(boolean ldapStudentIdIsCODETU) {
		this.ldapStudentIdIsCODETU = ldapStudentIdIsCODETU;
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
	 * @return the ldapAttributes
	 */
	public LdapAttributes getLdapAttributes() {
		return ldapAttributes;
	}


	/**
	 * @param ldapAttributes the ldapAttributes to set
	 */
	public void setLdapAttributes(LdapAttributes ldapAttributes) {
		this.ldapAttributes = ldapAttributes;
	}

	public void setEtudiantMetierService(
			EtudiantMetierServiceInterface etudiantMetierService) {
		this.etudiantMetierService = etudiantMetierService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(etudiantMetierService,"La propriété etudiantMetierService ne doit pas être null.");
		Assert.notNull(serviceAdministratif,"La propriété serviceAdministratif ne doit pas être null.");
		Assert.notNull(servicePedagogique,"La propriété servicePedagogique ne doit pas être null.");
		Assert.notNull(offreFormationMetierService,"La propriété offreFormationMetierService ne doit pas être null.");
		Assert.notNull(referentielMetierService,"La propriété referentielMetierService ne doit pas être null.");
	}

}
