package org.esupportail.pstage.dao.referentiel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
import org.esupportail.pstage.utils.Utils;
import org.springframework.util.StringUtils;

import gouv.education.apogee.commun.client.ws.administratifmetier.AdministratifMetierServiceInterfaceProxy;
import gouv.education.apogee.commun.client.ws.etudiantmetier.EtudiantMetierServiceInterfaceProxy;
import gouv.education.apogee.commun.client.ws.offreformationmetier.OffreFormationMetierServiceInterfaceProxy;
import gouv.education.apogee.commun.client.ws.pedagogiquemetier.PedagogiqueMetierServiceInterfaceProxy;
import gouv.education.apogee.commun.client.ws.referentielmetier.ReferentielMetierServiceInterfaceProxy;
import gouv.education.apogee.commun.transverse.dto.administratif.InsAdmAnuDTO2;
import gouv.education.apogee.commun.transverse.dto.administratif.InsAdmEtpDTO2;
import gouv.education.apogee.commun.transverse.dto.etudiant.CoordonneesDTO2;
import gouv.education.apogee.commun.transverse.dto.etudiant.IdentifiantsEtudiantDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.InfoAdmEtuDTO;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.DiplomeDTO3;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.ElementPedagogiDTO2;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.ListeElementPedagogiDTO2;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.OffreFormationDTO3;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.SECritereDTO2;
import gouv.education.apogee.commun.transverse.dto.offreformation.recupererse.VersionDiplomeDTO3;
import gouv.education.apogee.commun.transverse.dto.pedagogique.ComposanteDTO3;
import gouv.education.apogee.commun.transverse.dto.pedagogique.ContratPedagogiqueResultatVdiVetDTO2;
import gouv.education.apogee.commun.transverse.dto.pedagogique.EtapeResVdiVetDTO2;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;

/**
 * Acces donnees etudiant
 */

@SuppressWarnings("serial")
public class StudentDataRepositoryDaoWS implements StudentDataRepositoryDao {

	/**
	 *
	 */
	final transient Logger logger = Logger.getLogger(StudentDataRepositoryDaoWS.class);

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
	 * Codes correspondants aux regimes d'inscription de la Formation Continue
	 */
	private String codesRegimeInscriptionFC;

	/**
	 * @see org.esupportail.pstage.dao.referentiel.StudentDataRepositoryDao#getEtudiantRef(java.lang.String, java.lang.String)
	 */
	public EtudiantRef getEtudiantRef(String universityCode, String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("#getEtudiantRef# - [id : " + id + ", universityCode  : " + universityCode+"]");
		}

		String filter = "(" + ldapAttributes.getLdapUid() + "=" + id + ")";

		List<LdapUser> listeLdapUser = ldapUserService.getLdapUsersFromFilter(filter);

		if (listeLdapUser==null || listeLdapUser.isEmpty()) {
			return null;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("#getEtudiantRef# - listeLdapUser.size() : " + listeLdapUser.size());
		}

		// parcours de la liste de LdapUser
		List <EtudiantRef> liste = new ArrayList<EtudiantRef>();
		for (Iterator<LdapUser> iter = listeLdapUser.iterator(); iter.hasNext();) {
			LdapUser ldapuser = iter.next();

			// creation d'un user et alimentation des donnees 
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
			logger.debug("#getEtudiantRef# - studentLdap.getNom() = "+studentLdap.getNom());
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
		// annee a null puisqu'on n'est pas en modification donc il s'agit forcement de l'annee courante.
		studentApogee = getStudentApogee(universityCode, codEtu, null, false);
		if (studentApogee != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Apres getStudentApogee - statusApogee = "+studentApogee.getAdministrationApogee().isStatusApogee());
				logger.debug("Apres getStudentApogee - raison = "+studentApogee.getAdministrationApogee().getRaison());
			}
			if (studentApogee.getAdministrationApogee() != null) {
				adminApogee = studentApogee.getAdministrationApogee();
			}

			// renseignement des informations etudiant a partir infos ldap, apogee		
			s = rensInfosEtudiant(studentLdap, studentApogee);
			s.setCodeUniversite(universityCode);

			if (logger.isDebugEnabled()) {
				logger.debug("Apres rensInfosEtudiant - adminApogee.isStatusApogee() = "+adminApogee.isStatusApogee());
				logger.debug("Apres rensInfosEtudiant - adminApogee.getRaison() = "+adminApogee.getRaison());
			}
			s.setAdministrationApogee(adminApogee);
		} else {
			s = studentApogee;
		}

		return s;
	}

	/**
	 * @see org.esupportail.pstage.dao.referentiel.StudentDataRepositoryDao#getEtudiantRefByNum(java.lang.String, java.lang.String, java.lang.String)
	 */
	public EtudiantRef getEtudiantRefByNum(final String universityCode, final String id, String annee) {
		// id = numero etudiant
		if (logger.isDebugEnabled()) {
			logger.debug("#getEtudiantRefByNum# - [id : " + id + ", universityCode  : " + universityCode+"]");
		}
		String codEtu = id;
		//recherche codEtu par le codInd
		if (!this.ldapStudentIdIsCODETU) {
			codEtu = getStudentCodInd(id);
		}
		String filter = "(" + ldapAttributes.getLdapStudentId() + "=" + codEtu + ")";
		List<LdapUser> listeLdapUser = ldapUserService.getLdapUsersFromFilter(filter);

		EtudiantRef studentLdap = new EtudiantRef();

		if (listeLdapUser.isEmpty()) {
			// return null;
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("Nombre d'etudiants trouves dans le ldap : " + listeLdapUser.size());
			}
			// parcours de la liste de LdapUser
			List <EtudiantRef> liste = new ArrayList<EtudiantRef>();
			for (Iterator<LdapUser> iter = listeLdapUser.iterator(); iter.hasNext();) {
				LdapUser ldapuser = iter.next();

				// creation d'un user et alimentation des donnees 
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
			if (liste != null && !liste.isEmpty()) {
				studentLdap = liste.get(0);
			}
			if (logger.isDebugEnabled()) {
				logger.debug("studentLdap.getNom() = "+studentLdap.getNom());
				logger.debug("studentLdap.getMail() = "+studentLdap.getMail());
			}
		}

		EtudiantRef studentApogee = new EtudiantRef();
		EtudiantRef s = new EtudiantRef();
		AdministrationApogee adminApogee = new AdministrationApogee();
		adminApogee.setStatusApogee(true);
		adminApogee.setRaison("");

		// recherche des informations etudiant dans Apogee
		studentApogee = getStudentApogee(universityCode, id, annee, true);
		if (studentApogee != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Apres getStudentApogee - studentApogee.getAdministrationApogee().isStatusApogee() = "+studentApogee.getAdministrationApogee().isStatusApogee());
				logger.debug("Apres getStudentApogee - studentApogee.getAdministrationApogee().getRaison() = "+studentApogee.getAdministrationApogee().getRaison());
			}
			if (studentApogee.getAdministrationApogee() != null) {
				adminApogee = studentApogee.getAdministrationApogee();
			}

			// renseignement des informations etudiant a partir infos ldap, apogee		
			s = rensInfosEtudiant(studentLdap, studentApogee);
			s.setCodeUniversite(universityCode);

			if (logger.isDebugEnabled()) {
				logger.debug("Apres rensInfosEtudiant - adminApogee.isStatusApogee() = "+adminApogee.isStatusApogee());
				logger.debug("Apres rensInfosEtudiant - adminApogee.getRaison() = "+adminApogee.getRaison());
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
	public List<EtudiantRef> getEtudiantsRefByName(String universityCode, String name, String firstName) {
		if (logger.isDebugEnabled()) {
			logger.debug("#getEtudiantsRefByName# [universityCode  :"+universityCode+"]");
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
			logger.debug("Filtre LDAP = " + filter);
		}

		List<LdapUser> listeLdapUser = ldapUserService.getLdapUsersFromFilter(filter);

		if (listeLdapUser.isEmpty()) {
			return students;
		}
		logger.debug("Nombre d'etudiants trouves : " + listeLdapUser.size());

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

			// creation d'un user et alimentation des donn�es 
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

			try {
				// annee a null puisqu'on n'est pas en modification donc il s'agit forcement de l'annee courante.
				studentApogee = getStudentApogee(universityCode, codEtu, null, true);
			} catch (Exception e){
				logger.error("Exception sur getStudentApogee(?,?) dans getEtudiantsRefByName() : " + e);
			}

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
	public EtudiantRef getStudentApogee(String universityCode, String id, String annee, boolean temRecupAnneeAntecedente) {
		if (logger.isDebugEnabled()){
			logger.debug("#getStudentApogee# - [id : "+id+", universityCode  : "+universityCode +", annee  : "+ annee +"]");
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
		Date dateNais = new Date();
		// libelle CPAM etudiant
		String libelleCPAM = "";

		// Ajout des variables d'annee (pour permettre la modif d'anciennes conventions)
		String anneeCourante = "";
		String anneePrecedente = "";
		String anneeSuivante = "";

		if (annee != null && !annee.isEmpty()){
			anneeCourante = annee;
			anneePrecedente = String.valueOf((Utils.convertStringToInt(annee)-1));
			anneeSuivante = String.valueOf((Utils.convertStringToInt(annee)+1));
		} else {
			anneeCourante = getYear();
			anneePrecedente = String.valueOf((Utils.convertStringToInt(getYear())-1));
			anneeSuivante = String.valueOf((Utils.convertStringToInt(getYear())+1));
		}

		EtudiantRef studentApogee = new EtudiantRef();
		AdministrationApogee adminApogee = new AdministrationApogee();
		adminApogee.setStatusApogee(true);
		adminApogee.setRaison("");
		try {
			// appel au WS AMUE
			EtudiantMetierServiceInterfaceProxy etudiantMetierService = new EtudiantMetierServiceInterfaceProxy();

			AdministratifMetierServiceInterfaceProxy serviceAdministratif = new AdministratifMetierServiceInterfaceProxy();

			// Recherche l'etudiant dans Apogee
			IdentifiantsEtudiantDTO etudiant = etudiantMetierService.recupererIdentifiantsEtudiant(
					id, null, null, null, null, null, null, null, null, this.temoinRecupAnnu);

			// Recuperation des infos de l'etudiant dans Apogee
			InfoAdmEtuDTO infosAdmEtu = etudiantMetierService.recupererInfosAdmEtu(etudiant.getCodEtu().toString());

			// Recuperation des coordonnees de l'etudiant
			CoordonneesDTO2 coordonnees = new CoordonneesDTO2();
			try{
				coordonnees = etudiantMetierService.recupererAdressesEtudiant_v2(
						etudiant.getCodEtu().toString(), null, this.temoinRecupAnnu);
			} catch (WebBaseException wb) {
				coordonnees = etudiantMetierService.recupererAdressesEtudiant_v2(
						etudiant.getCodEtu().toString(), anneeCourante, this.temoinRecupAnnu);
			}
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

			/* ********************************************************
			 * Verification des inscriptions annuelles de l'étudiant
			 *********************************************************/
			if (logger.isDebugEnabled()) {
				logger.debug("Verification des inscriptions annuelles de l'étudiant");
			}

			List<String> listeAnneesUniv = new ArrayList<String>();
			// Recuperation des codes renseignées en parametre pour detecter la FC
			String [] codesFC = this.codesRegimeInscriptionFC.split(";");
			String [] annees = serviceAdministratif.recupererAnneesIa(etudiant.getCodEtu().toString(), "E");
			List<String> anneesInscriptionFC = new ArrayList<>();

			// INSCRIPTION SUR L'ANNEE PRECEDENTE ?
			if (temRecupAnneeAntecedente) {
				if (Arrays.asList(annees).contains(anneePrecedente)) {
					logger.debug("Inscription trouvee sur l'annee precedente (" + anneePrecedente + ")");
					listeAnneesUniv.add(anneePrecedente);

					// Recuperation du regime d'inscription pour l'etudiant a partir de l'annee
					for (InsAdmAnuDTO2 insAdmAnu : serviceAdministratif.recupererIAAnnuelles_v2(etudiant.getCodEtu().toString(), anneePrecedente, "E")) {
						// Libelle CPAM
						if (insAdmAnu.getCpam() != null && insAdmAnu.getCpam().getLibCpam() != null) {
							logger.debug("Libelle CPAM : " + insAdmAnu.getCpam().getLibCpam());
							libelleCPAM = insAdmAnu.getCpam().getLibCpam();
						}
						// Regime d'inscription
						if (insAdmAnu.getRegimeIns() != null
								&& Arrays.asList(codesFC).contains(insAdmAnu.getRegimeIns().getCodRgi())){
							anneesInscriptionFC.add(anneePrecedente);
						}
					}

				} else {
					logger.debug("Pas d'inscription pour l'etudiant " + etudiant.getCodEtu().toString() + " sur l'annee " + anneePrecedente);
				}
			}

			// INSCRIPTION SUR L'ANNEE COURANTE ?
			if (Arrays.asList(annees).contains(anneeCourante)){
				logger.debug("Inscription trouvee sur l'annee courante ("+anneeCourante+")");
				listeAnneesUniv.add(anneeCourante);

				// Recuperation du libelle CPAM et du regime d'inscription pour l'etudiant a partir de l'annee
				for (InsAdmAnuDTO2 insAdmAnu : serviceAdministratif.recupererIAAnnuelles_v2(etudiant.getCodEtu().toString(), anneeCourante, "E")) {
					// Libelle CPAM
					if (insAdmAnu.getCpam() != null && insAdmAnu.getCpam().getLibCpam() != null) {
						logger.debug("Libelle CPAM : " + insAdmAnu.getCpam().getLibCpam());
						libelleCPAM = insAdmAnu.getCpam().getLibCpam();
					}
					// Regime d'inscription
					if (insAdmAnu.getRegimeIns() != null && Arrays.asList(codesFC).contains(insAdmAnu.getRegimeIns().getCodRgi())){
						anneesInscriptionFC.add(anneeCourante);
					}
				}
			} else {
				logger.debug("Pas d'inscription pour l'etudiant "+ etudiant.getCodEtu().toString()+" sur l'annee "+anneeCourante);
			}

			// INSCRIPTION SUR L'ANNEE SUIVANTE ?
			if (Arrays.asList(annees).contains(anneeSuivante)){
				logger.debug("Inscription trouvee sur l'annee suivante ("+anneeSuivante+")");
				listeAnneesUniv.add(anneeSuivante);

				// Recuperation du regime d'inscription pour l'etudiant a partir de l'annee
				for (InsAdmAnuDTO2 insAdmAnu : serviceAdministratif.recupererIAAnnuelles_v2(etudiant.getCodEtu().toString(), anneeSuivante, "E")) {
					// Libelle CPAM
					if (libelleCPAM == "" && insAdmAnu.getCpam() != null && insAdmAnu.getCpam().getLibCpam() != null) {
						logger.debug("Libelle CPAM : " + insAdmAnu.getCpam().getLibCpam());
						libelleCPAM = insAdmAnu.getCpam().getLibCpam();
					}
					// Regime d'inscription
					if (insAdmAnu.getRegimeIns() != null && Arrays.asList(codesFC).contains(insAdmAnu.getRegimeIns().getCodRgi())){
						anneesInscriptionFC.add(anneeSuivante);
					}
				}
			} else {
				logger.debug("Pas d'inscription pour l'etudiant "+ etudiant.getCodEtu().toString()+" sur l'annee "+anneeSuivante);
			}

			studentApogee.setIdentEtudiant(id);
			studentApogee.setNumEtudiant(etudiant.getCodEtu().toString());
			studentApogee.setNom(nompatro);
			studentApogee.setNomMarital(nommarital);
			studentApogee.setPrenom(prenom);
			studentApogee.setMail(mail);
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

			// ajout du libelle CPAM
			studentApogee.setLibelleCPAM(libelleCPAM);

			// ajout de l'eventuelle liste des inscriptions FC
			if (anneesInscriptionFC != null && !anneesInscriptionFC.isEmpty()){
				studentApogee.setAnneesInscriptionFC(anneesInscriptionFC);
			} else {
				studentApogee.setAnneesInscriptionFC(null);
			}

			studentApogee.setAdministrationApogee(adminApogee);

			studentApogee.setListeAnneesUniv(listeAnneesUniv);

			return studentApogee;

		} catch (WebBaseException e) {
			logger.warn("WebBaseException globale : " + e );
			if (e.toString().equals("technical.data.nullretrieve.etudiant")) {
				logger.error("Etudiant non trouvé : " + id);
			}
			return null;
		} catch (AdministrationApogeeException e) {
			logger.warn("AdministrationApogeeException globale : " + e);
			logger.warn("e.getCause() : " + e.getCause());
			if (e.toString().equals("technical.data.nullretrieve.etudiant")) {
				logger.error("Etudiant non trouvé : " + id);
				return null;
			}
			if (e.getCause().toString().equals("technical.data.nullretrieve.findIAE")) {
				adminApogee.setStatusApogee(false);
				adminApogee.setRaison("Pas d'inscription administrative pour cet etudiant");
				studentApogee.setAdministrationApogee(adminApogee);
			}
			return studentApogee;
		} catch (Exception e) {
			logger.error("Exception globale : " + e);
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
			logger.debug("#rensInfosEtudiant#");
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
		Date dateNais = new Date();
		// libelle CPAM etudiant
		String libelleCPAM = "";
		// liste des annes d'inscription
		List<String> listeAnneesUniv = new ArrayList<String>();
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
				logger.debug("studentApogee.getNom() = "+studentApogee.getNom());
				logger.debug("studentApogee.getMail() = "+studentApogee.getMail());
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
			s.setLibelleCPAM(studentApogee.getLibelleCPAM());
			//Code Etu
			s.setNumEtudiant(studentApogee.getNumEtudiant());
			// Volume horaire
			s.setVolumeHoraireFormation(studentApogee.getVolumeHoraireFormation());
			//anneesInscriptionFC
			s.setAnneesInscriptionFC(studentApogee.getAnneesInscriptionFC());

			if (studentApogee.getListeAnneesUniv() != null && !studentApogee.getListeAnneesUniv().isEmpty()){
				s.setListeAnneesUniv(studentApogee.getListeAnneesUniv());
			}
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

			// Ajout de l'annee univ courante
			listeAnneesUniv.add(getYear());
			s.setListeAnneesUniv(listeAnneesUniv);
		}
		return s;
	}


	/**
	 * @param cod
	 * @return ApogeeMap
	 */
	@SuppressWarnings("unused")
	public ApogeeMap getEtapesByEtudiantAndAnnee(String cod, String anneeScolaire, String codeUniversite) {
		if (logger.isDebugEnabled()) {
			logger.debug("#getEtapesByEtudiantAndAnnee# - cod : " + cod);
		}

		// recherche des Inscriptions Administratives et Inscription Pedagogiques
		ApogeeMap apogeeMap = getStudentIAIP(cod, anneeScolaire);

		return apogeeMap;
	}

	/**
	 * recherche des Inscriptions Administratives et Inscriptions Pedagogiques.
	 * @param cod
	 * @return  ApogeeMap
	 */
	public ApogeeMap getStudentIAIP(String cod, String annee) {
		if (logger.isDebugEnabled()) {
			logger.debug("#getStudentIAIP# - [cod : " + cod +", annee : "+annee+"]");
		}
		ApogeeMap apogeeMap = new ApogeeMap();

		AdministratifMetierServiceInterfaceProxy serviceAdministratif = new AdministratifMetierServiceInterfaceProxy();

		PedagogiqueMetierServiceInterfaceProxy servicePedagogique =  new PedagogiqueMetierServiceInterfaceProxy();

		ReferentielMetierServiceInterfaceProxy referentielMetierService = new ReferentielMetierServiceInterfaceProxy();

		// Recuperation des etapes auxquelles l'etudiant est inscrit administrativement
		// (inscription admin etape en cours (E)) en fonction de l'annee en param
		InsAdmEtpDTO2[] tabInsAdmEtp;
		try {
			tabInsAdmEtp = serviceAdministratif.recupererIAEtapes_v2(cod, annee, "E", "E");
		} catch (WebBaseException e) {
			tabInsAdmEtp = new InsAdmEtpDTO2[0];
			if (logger.isDebugEnabled()){
				if (e.toString().equals("technical.parameter.noncoherentinput.invalidUser")) {
					logger.debug("Aucun resultat pour l'etudiant "+ cod +" sur l'annee "+annee);
				} else if (e.toString().equals("technical.data.nullretrieve.DossierEtudiantIP")
						|| e.toString().equals("technical.data.nullretrieve.findIAA")
						|| e.toString().equals("technical.data.nullretrieve.findIAE")) {
					logger.debug("Pas d'inscription pour l'etudiant "+ cod +" sur l'annee "+annee);
				} else {
					logger.debug("WebBaseException dans getStudentIAIP pour l'etudiant "+ cod +" sur l'annee "+annee);
				}
			}
		} catch (Exception e) {
			logger.error("Exception pour "+ cod +" sur l'annee "+ annee +" : " + e);
			throw new CommunicationApogeeException(e);
		}

		LinkedHashMap<String,String> lEtape = new LinkedHashMap<String, String>();
		LinkedHashMap<String,String> lEtapeVet = new LinkedHashMap<String, String>();
		LinkedHashMap<String,String> lEtapeVetPedago = new LinkedHashMap<String, String>();
		LinkedHashMap<String,String> lComposante = new LinkedHashMap<String, String>();
		// Liste des etapes a l'inscription administrative
		List<EtapeInscription> listeEtapeInscriptions = new  ArrayList<EtapeInscription>();
		// Pour les Elps
		LinkedHashMap<String,ElementPedagogique> elementPedagogiques = new LinkedHashMap<String,ElementPedagogique>();
		List<ElementPedagogique> listeELPs = new  ArrayList<ElementPedagogique>();

		// recherche des Inscriptions Administratives payees de l'etudiant
		for (InsAdmEtpDTO2 insAdmEtp : tabInsAdmEtp) {
			if (logger.isDebugEnabled()){
				logger.debug("- Inscription Administrative -");
				logger.debug("[codeEtape : "+insAdmEtp.getEtape().getCodeEtp() +
						", codeVersionEtape : " + insAdmEtp.getEtape().getVersionEtp()+
						", libEtape : "+insAdmEtp.getEtape().getLibWebVet() +
						", codeComposante : " + insAdmEtp.getComposante().getCodComposante() +
						", libComposante : " + insAdmEtp.getComposante().getLibComposante() +
						", codeInscriptionPayee : " + insAdmEtp.getCodeInscriptionPayee()+"]");
			}

			if (insAdmEtp.getCodeInscriptionPayee().equals("P")) {

				//**********************
				// POUR LES COMPOSANTES
				//**********************
				Object idlComp = insAdmEtp.getComposante().getCodComposante();
				String libComp = insAdmEtp.getComposante().getLibComposante();
				if(libComp == null){
					ComposanteDTO3[] composante;
					try {
						composante = referentielMetierService.recupererComposante_v2((String)idlComp, null);
						if(composante != null && composante[0]!=null && composante[0].getLibCmp()!=null){
							libComp=composante[0].getLibCmp();
						}
					} catch (WebBaseException e) {
						composante = new ComposanteDTO3[0];
						logger.warn("WebBaseException recupererComposante_v2 : " + e );
						continue;
					}
				}
				lComposante.put(idlComp + "" , libComp);

				//**********************
				// POUR LES ETAPES
				//**********************
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
					// renseignement des infos du diplome
					String codeDiplome = insAdmEtp.getDiplome().getCodeDiplome();
					etpins.setCodeDiplome(codeDiplome);
					etpins.setLibDiplome(insAdmEtp.getDiplome().getLibLongDiplome());
					String versDiplome = insAdmEtp.getDiplome().getVersionDiplome();
					etpins.setVersionDiplome(versDiplome);
					try {
						OffreFormationMetierServiceInterfaceProxy offreFormationMetierService = new OffreFormationMetierServiceInterfaceProxy();

						// recherche du cursus LMD, codFinalite
						SECritereDTO2 seCritereDTO = new SECritereDTO2();
//						seCritereDTO.setCodAnu(annee);
						seCritereDTO.setCodDip("aucun");
						seCritereDTO.setCodVrsVdi("aucun");
//						seCritereDTO.setCodEtp("aucun");
						seCritereDTO.setCodEtp(insAdmEtp.getEtape().getCodeEtp());
//						seCritereDTO.setCodVrsVet("aucun");
						seCritereDTO.setCodVrsVet(insAdmEtp.getEtape().getVersionEtp());
						seCritereDTO.setCodElp("tous");
//						seCritereDTO.setCodNatureElp("stag");

						DiplomeDTO3[] diplomeDTO = offreFormationMetierService.recupererSE_v3(seCritereDTO);
						if (diplomeDTO != null) {
							for (int i = 0; i < diplomeDTO.length; i++) {
								VersionDiplomeDTO3[] versionDiplome = diplomeDTO[i].getListVersionDiplome();
								for (int j = 0; j < versionDiplome.length; j++) {
									if (versionDiplome[j].getCodCursusLmd() != null) {
										etpins.setCodCursusLmd(versionDiplome[j].getCodCursusLmd());
									}
									OffreFormationDTO3 offreFormation = versionDiplome[j].getOffreFormation();
									if (offreFormation != null) {

										if (offreFormation.getCodFinalite() != null) {
											etpins.setCodFinalite(offreFormation.getCodFinalite());
										}
										if (offreFormation.getLibFinalite() != null) {
											etpins.setLibFinalite(offreFormation.getLibFinalite());
										}

										// Recup volume horaire si saisi
										Integer volumeHoraire = offreFormation.getListEtape()[0].getListVersionEtape()[0].getVolume();
										if (volumeHoraire != null) {
											etpins.setVolumeHoraire(Integer.toString(volumeHoraire));
										} else {
											etpins.setVolumeHoraire("0");
										}

										// Recup éléments pédagogiques
										ListeElementPedagogiDTO2[] listeelementPedagogiDTO = offreFormation.getListEtape()[0].getListVersionEtape()[0].getListListeElementPedagogi();

										if(listeelementPedagogiDTO != null) {
											for (int k = 0; k < listeelementPedagogiDTO.length; k++) {
												ElementPedagogiDTO2[] elementPedagogique = listeelementPedagogiDTO[k].getListElementPedagogi();
												for (int l = 0; l < elementPedagogique.length; l++) {
													// Remplissage de la table des elements pedagogiques si elp de nature stage (ou avec temoin stage actif) et non suspendu
													if ((elementPedagogique[l].getLibNatureElp().equalsIgnoreCase("stage")
															|| elementPedagogique[l].getTemStage().equals("O"))
															&& !elementPedagogique[l].getTemSusp().equals("O")) {
														ElementPedagogique elpedago = new ElementPedagogique();
														elpedago.setCodEtp(etpins.getCodeEtp());
														elpedago.setCodVrsVet(etpins.getCodVrsVet());

														elpedago.setCodElp(elementPedagogique[l].getCodElp());
														elpedago.setLibElp(elementPedagogique[l].getLibElp());
														elpedago.setTemElpTypeStage(elementPedagogique[l].getTemStage());
														if (elementPedagogique[l].getCredits() != null) {
															elpedago.setNbrCrdElp(elementPedagogique[l].getCredits());
														}
														//renseignement de la map element pedagogique
														elementPedagogiques.put(etpins.getCodeEtp() + "", elpedago);
														// renseignement de la liste des elements pedagogiques
														if (!listeELPs.contains(elpedago)) {
															listeELPs.add(elpedago);
														}

													}
												}
											}
										}
									}
								}
							}
						}
					} catch (WebBaseException e) {
						logger.warn("WebBaseException recupererSE_v3 : " + e );
						if (e.toString().equals("technical.data.nullretrieve.recupererse")) {
							logger.warn("Aucune donnee en sortie pour " + cod + " - diplome/vers : " + codeDiplome + versDiplome);
							continue;
						}
						continue;
					}

				}
				listeEtapeInscriptions.add(etpins);
			}
		}


		apogeeMap.setStudentSteps(lEtape);
		apogeeMap.setStudentsEtapesVets(lEtapeVet);
		apogeeMap.setStudentsEtapesVetsPedago(lEtapeVetPedago);
		apogeeMap.setListeEtapeInscriptions(listeEtapeInscriptions);
		apogeeMap.setStudentStudys(lComposante);
		apogeeMap.setElementPedagogiques(elementPedagogiques);
		apogeeMap.setListeELPs(listeELPs);

		if (logger.isDebugEnabled()){
			logger.debug("- ApogeeMap -");
			logger.debug("[StudentSteps : "+ lEtape +
					", StudentsEtapesVets : " + lEtapeVet +
					", StudentsEtapesVetsPedago : "+ lEtapeVetPedago +
					", ListeEtapeInscriptions : "+ listeEtapeInscriptions +
					", StudentStudys : " + lComposante +"]");
		}

		return apogeeMap;
	}

	/**
	 * @param codInd
	 * @return le codEtu pour le codInd pass� en param�tre
	 */
	public String getStudentCodEtu(final String codInd) {
		if (logger.isDebugEnabled()) {
			logger.debug("#getStudentCodEtu# - this.temoinRecupAnnu : " + this.temoinRecupAnnu);
		}
		String codEtu = codInd;
		try {
			EtudiantMetierServiceInterfaceProxy etudiantMetierService = new EtudiantMetierServiceInterfaceProxy();

			// Recherche l'etudiant par le codind dans Apogee
			IdentifiantsEtudiantDTO etudiant = etudiantMetierService.recupererIdentifiantsEtudiant(
					null, codInd, null, null, null, null, null, null, null, this.temoinRecupAnnu);
			codEtu = etudiant.getCodEtu().toString();
		} catch (WebBaseException e) {
			logger.warn("WebBaseException in getStudentByNum = " + e );
			if (e.toString().equals("technical.parameter.noncoherentinput.invalidUser")) {
				logger.warn("Aucun resultat pour l'etudiant "+ codInd);
			}
			if (e.toString().equals("technical.data.nullretrieve.findIAA")) {
				logger.warn("Pas d'inscription pedagogique pour l'etudiant "+ codInd);

			}
		}
		return codEtu;
	}

	/**
	 * @param codEtu
	 * @return le codInd pour le codEtu passé en paramètre
	 */
	public String getStudentCodInd(final String codEtu) {
		if (logger.isDebugEnabled()) {
			logger.debug("#getStudentCodInd# - this.temoinRecupAnnu : " + this.temoinRecupAnnu);
		}
		String codInd = codEtu;
		try {
			EtudiantMetierServiceInterfaceProxy etudiantMetierService = new EtudiantMetierServiceInterfaceProxy();

			// Recherche du codInd de l'etudiant dans Apogee
			IdentifiantsEtudiantDTO etudiant = etudiantMetierService.recupererIdentifiantsEtudiant(
					codEtu, null, null, null, null, null, null, null, null, this.temoinRecupAnnu);
			codInd = etudiant.getCodInd().toString();
		} catch (WebBaseException e) {
			logger.warn("WebBaseException in getStudentByNum = " + e );
			if (e.toString().equals("technical.security.invaliduser.user")) {
				logger.warn("Aucun resultat pour l'etudiant "+ codEtu);
			}
			if (e.toString().equals("technical.data.nullretrieve.findIAA")) {
				logger.warn("Pas d'inscription pedagogique pour l'etudiant "+ codEtu);
			}
		}
		return codInd;
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
			if(sYM < month || (sYM == month && sYD <= day)){
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


	public String getCodesRegimeInscriptionFC() {
		return codesRegimeInscriptionFC;
	}

	public void setCodesRegimeInscriptionFC(String codesRegimeInscriptionFC) {
		this.codesRegimeInscriptionFC = codesRegimeInscriptionFC;
	}
}
