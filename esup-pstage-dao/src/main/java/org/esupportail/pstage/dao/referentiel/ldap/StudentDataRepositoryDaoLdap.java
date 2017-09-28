package org.esupportail.pstage.dao.referentiel.ldap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.esupportail.commons.services.ldap.LdapException;
import org.esupportail.commons.services.ldap.LdapGroup;
import org.esupportail.commons.services.ldap.LdapGroupService;
import org.esupportail.commons.services.ldap.LdapUser;
import org.esupportail.commons.services.ldap.LdapUserService;
import org.esupportail.pstage.dao.referentiel.StudentDataRepositoryDao;
import org.esupportail.pstage.domain.beans.AdministrationApogee;
import org.esupportail.pstage.domain.beans.EtapeInscription;
import org.esupportail.pstage.domain.beans.EtudiantRef;
import org.esupportail.pstage.domain.beans.LdapAttributes;
import org.esupportail.pstage.domain.beans.LdapGroupeAttributs;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstage.utils.Utils;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.ldap.filter.OrFilter;
import org.springframework.ldap.filter.WhitespaceWildcardsFilter;
import org.springframework.util.StringUtils;


public class StudentDataRepositoryDaoLdap implements StudentDataRepositoryDao {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(StudentDataRepositoryDaoLdap.class);

	private LdapUserService ldapUserService;
	private LdapAttributes ldapAttributes;
	private LdapGroupService ldapGroupService;
	private LdapGroupeAttributs ldapGroupeAttributs;
	private LdapGroupService ldapGroupServiceSpecial;


	//	@Override
	//	public void afterPropertiesSet() throws Exception {
	//		Assert.notNull(this.ldapUserService, "La propriété ldapUserService de la classe " +this.getClass().getSimpleName()+ " ne doit pas être null.");
	//	}

	/**
	 * Etudiant par son identifiant ldap
	 */
	@Override
	public EtudiantRef getEtudiantRef(String universityCode, String id) {

		EtudiantRef etudiantRef = retrieveStudent(id,new  EqualsFilter(ldapAttributes.getLdapUid(), id) );
		etudiantRef.setCodeUniversite(universityCode);

		return etudiantRef;
	}
	/**
	 * Recupere et format un etudiant 
	 * @param id
	 * @param filtre, filtre sur l'etudiant
	 * @return
	 */
	private EtudiantRef retrieveStudent(String id, Filter filtre ) {
		AndFilter filter = new AndFilter();
		filter.and(filtre);
		String encode = filter.encode();   
		encode=encode.substring(1, encode.length()-1);
		List<LdapUser> ldapUsersFromFilter=null;
		if(logger.isInfoEnabled()){
			logger.info("Filtre ldap " + encode);
		}
		try {
			ldapUsersFromFilter = ldapUserService.getLdapUsersFromFilter(encode);
		}
		catch (LdapException ldae) {
			errorldap(ldae,"getLdapUsersFromFilter");
		}
		EtudiantRef etudiantRef = new EtudiantRef();
		if(ldapUsersFromFilter != null && !ldapUsersFromFilter.isEmpty()){
			LdapUser ldapUser = ldapUsersFromFilter.get(0);
			if(logger.isInfoEnabled()){
				logger.info("attributsNames= " +ldapUser.getAttributeNames());
				logger.info("attributs = " + ldapUser.getAttributes());
			}

			etudiantFormate(etudiantRef, ldapUser);

		}

		return etudiantRef;
	}

	/**
	 * Met en forme l'etudiant avec les parametres qui vont bien 
	 * @param etudiantRef
	 * @param ldapUser
	 */
	private EtudiantRef etudiantFormate(EtudiantRef etudiantRef, LdapUser ldapUser) {
		etudiantRef.setIdentEtudiant(ldapUser.getAttribute(ldapAttributes.getLdapUid()));
		etudiantRef.setNumEtudiant(ldapUser.getAttribute(ldapAttributes.getLdapStudentId()));
		etudiantRef.setNom(ldapUser.getAttribute(ldapAttributes.getLdapName()));
		etudiantRef.setPrenom(ldapUser.getAttribute(ldapAttributes.getLdapFirstName()));
		if(StringUtils.hasText(ldapUser.getAttribute(ldapAttributes.getLdapMail()))){
			etudiantRef.setMail(ldapUser.getAttribute(ldapAttributes.getLdapMail()));
		}
		if (ldapUser.getAttribute("dateNaissance")!=null){
			try {
				etudiantRef.setDateNais(new SimpleDateFormat("dd/MM/yyyy").parse(ldapUser.getAttribute("dateNaissance")));
			} catch (ParseException e) {
				logger.error(e);
			}
		}

		String civilite = ldapUser.getAttribute(ldapAttributes.getLdapMemberCivility());
		if (civilite != null){
			if (civilite.equalsIgnoreCase(DonneesStatic.CIVILITE_MR_LDAP)){
				etudiantRef.setCodeSexe("M");
			} else {
				etudiantRef.setCodeSexe("F");
			}
		} else {
			etudiantRef.setCodeSexe("");
		}

		//on ajoute chaque etape d'inscription dans la map, mais sans libelle pour le moment
		Map<String, String> mapSteps =null;
		Map<String, String> etapesRef = getEtapesRef(null);
		String studentStep =ldapAttributes.getLdapStudentStep();
		List<EtapeInscription> listEtapes = new ArrayList<EtapeInscription>();
		if(StringUtils.hasText(ldapUser.getAttribute(studentStep))){
			mapSteps = new LinkedHashMap<String, String>();
			for(String uneEtape : ldapUser.getAttributes().get(studentStep) ){
				mapSteps.put(uneEtape, etapesRef.get(uneEtape));
				etudiantRef.setTheCodeEtape(uneEtape);
				etudiantRef.setTheEtape(etapesRef.get(uneEtape));

				EtapeInscription etpins = new EtapeInscription();
				etpins.setCodeEtp(uneEtape);
				etpins.setLibWebVet(etapesRef.get(uneEtape));
				etpins.setTypeIns(DonneesStatic.TYPE_INS_ADMIN);
				listEtapes.add(etpins);
				if (logger.isDebugEnabled()){
					logger.debug("Code Etape etudiant = " + uneEtape);
					logger.debug("Libelle Etape etudiant = " + etapesRef.get(uneEtape));
				}
			}
			etudiantRef.setSteps(mapSteps);
			etudiantRef.setListeEtapeInscriptions(listEtapes);
		}

		// on ajoute chaque ufr d'inscription dans la map, mais sans libelle pour le moment
		Map<String, String>  mapEtudes =null;
		String affectationEtd =ldapAttributes.getLdapStudentAffectation();
		Map<String, String> ufrRef = getComposantesPrincipalesRef(null);

		if(StringUtils.hasText(ldapUser.getAttribute(affectationEtd))){
			mapEtudes = new LinkedHashMap<String, String>();
			List<String> list = ldapUser.getAttributes().get(affectationEtd);
			for(String uneAffectation : list ){
				etudiantRef.setThecodeUFR(uneAffectation);
				if (ufrRef != null) {
					mapEtudes.put(uneAffectation, ufrRef.get(uneAffectation));
					etudiantRef.setTheUfr(ufrRef.get(uneAffectation));
				} else {
					mapEtudes.put(uneAffectation, "");
					etudiantRef.setTheUfr("");
				}
				if (logger.isDebugEnabled()){
					logger.debug("Code UFR etudiant = " + etudiantRef.getThecodeUFR());
					logger.debug("Libelle UFR etudiant = " + etudiantRef.getTheUfr());
				}
			}
			etudiantRef.setStudys(mapEtudes);
		}

		List<String> listeAnneesUniv = new ArrayList<>();
		listeAnneesUniv.add(Utils.getCurrentYear(false));
		etudiantRef.setListeAnneesUniv(listeAnneesUniv);

		AdministrationApogee adminApogee = new AdministrationApogee();
		adminApogee.setStatusApogee(false);
		adminApogee.setRaison("");
		etudiantRef.setAdministrationApogee(adminApogee);

		return etudiantRef;
	}
	/**
	 * Etudiant par son numero etudiant
	 */
	@Override
	public EtudiantRef getEtudiantRefByNum(String universityCode, String id, String annee) {
		EtudiantRef etudiantRefByNum = retrieveStudent(id,new EqualsFilter(ldapAttributes.getLdapStudentId(), id));
		etudiantRefByNum.setCodeUniversite(universityCode);

		return etudiantRefByNum;
	}

	@Override
	public List<EtudiantRef> getEtudiantsRefByName(String universityCode,
			String name, String firstName) {
		AndFilter filter = new AndFilter();
		filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapName(), name));
		filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapFirstName(), firstName));
		filter.and(new EqualsFilter(ldapAttributes.getLdapAffiliation(), ldapAttributes.getLdapStudentAffiliation()));
		String encode = filter.encode();   
		if(logger.isInfoEnabled()){
			logger.info("Filtre ldap : " + encode);
		}

		encode=encode.substring(1, encode.length()-1);
		List<LdapUser> etudiantsDansLdap=null;
		try {
			etudiantsDansLdap = ldapUserService.getLdapUsersFromFilter(encode);
		} catch (LdapException ldae) {
			errorldap(ldae,"getLdapUsersFromFilter");
		}
		List<EtudiantRef> etudiants = null;
		if(etudiantsDansLdap != null && !etudiantsDansLdap.isEmpty()){
			etudiants = new ArrayList<EtudiantRef>(etudiantsDansLdap.size());
			for(LdapUser user : etudiantsDansLdap){
				String id = user.getAttribute(ldapAttributes.getLdapStudentId());
				EtudiantRef etudiantRef = retrieveStudent(id,new EqualsFilter(ldapAttributes.getLdapStudentId(), id));
				etudiantRef.setCodeUniversite(universityCode);
				etudiants.add(etudiantRef);
			}

		}

		return etudiants;
	}

	public HashMap<String, String> getEtapesRef(String universityCode) {
		List<LdapGroup> ldapGroups =null;

		HashMap<String, String> etapes=null ;
		AndFilter filter = new AndFilter();
		WhitespaceWildcardsFilter espaceFiltre = new WhitespaceWildcardsFilter(ldapGroupeAttributs.getLdapComposanteCode(), " ");
		filter.and(espaceFiltre);
		String encode = filter.encode();
		encode=encode.substring(1, encode.length()-1);
		if(logger.isInfoEnabled()){
			logger.info(" le filtre ldap getEtapesRef " + encode);
		}
		try {
			ldapGroups= ldapGroupServiceSpecial.getLdapGroupsFromFilter(encode);
		} catch (LdapException ldae) {
			logger.error("Probleme lors de l'appel de getLdapGroupsFromFilter dans "+this.getClass().getSimpleName()+" : ",ldae.getCause());
		}
		if(ldapGroups != null && !ldapGroups.isEmpty()){
			String etapeCode=null;
			String etapeLibelle =null;
			etapes = new LinkedHashMap<>(ldapGroups.size());

			//on formate pour la map
			for(LdapGroup group : ldapGroups){
				etapeCode = group.getAttribute(ldapGroupeAttributs.getLdapComposanteCode());
				etapeLibelle = group.getAttribute(ldapGroupeAttributs.getLdapComposanteLibelle());
				etapes.put(etapeCode, etapeLibelle);
			}
		}
		return etapes;
	}

	public Map<String, String> getComposantesPrincipalesRef(String universityCode) {
		Map<String, String> composantes=null;
		List<LdapGroup> ldapGroups =null;
		AndFilter filter = new AndFilter();       
		String valFormationsPrincipales= ldapGroupeAttributs.getLdapValCodeFormationsPrincipales();
		String  codeFormationsPrincipales = ldapGroupeAttributs.getLdapCodePrincipalesFormations();
		if(valFormationsPrincipales.contains(LdapGroupeAttributs.sperateurValeurLdap)){
			String[]  valsFormaPrinc = valFormationsPrincipales.split(LdapGroupeAttributs.sperateurValeurLdap);
			OrFilter filtreOu = new OrFilter();
			for(String valFormaPrinc : valsFormaPrinc){
				filtreOu.or(new EqualsFilter(codeFormationsPrincipales, valFormaPrinc));
			}
			filter.and(filtreOu);
		}else {
			//un seul attribut
			filter.and(new EqualsFilter(codeFormationsPrincipales, valFormationsPrincipales));
		}
		String encode = filter.encode();   
		encode=encode.substring(1, encode.length()-1);
		if(logger.isInfoEnabled())
			logger.info(" le filtre ldap " + encode);

		try {
			ldapGroups= ldapGroupService.getLdapGroupsFromFilter(encode);
			logger.info("ldapGroups="+ldapGroups);
			if(ldapGroups != null && !ldapGroups.isEmpty()){
				String compCode=null;
				String compLibelle =null;
				composantes = new LinkedHashMap<String, String>(ldapGroups.size());
				//on formate pour la map
				for(LdapGroup group : ldapGroups){
					compCode = group.getAttribute(ldapGroupeAttributs.getLdapComposanteCode());
					compLibelle = group.getAttribute(ldapGroupeAttributs.getLdapComposanteLibelle());
					composantes.put(compCode, compLibelle);
				}	
			}
		} catch (LdapException ldae) {
			logger.error("Probleme pendant l'appel de getLdapsGroupsFromFilter dans "+this.getClass().getSimpleName()+" : ",ldae.getCause());
		}
		return composantes;
	}

	private void errorldap(LdapException ldae, String methodeAppelee) {
		logger.error("Probleme pendant l'appel de "+methodeAppelee+" dans "+this.getClass().getSimpleName()+" :",ldae.getCause());
	}

	/**
	 * @param ldapGroupService the ldapGroupService to set
	 */
	public void setLdapGroupServiceSpecial(LdapGroupService ldapGroupService) {
		this.ldapGroupServiceSpecial = ldapGroupService;
	}


	/**
	 * @param ldapGroupService the ldapGroupService to set
	 */
	public void setLdapGroupService(LdapGroupService ldapGroupService) {
		this.ldapGroupService = ldapGroupService;
	}

	/**
	 * @param ldapGroupeAttributs the ldapGroupeAttributs to set
	 */
	public void setLdapGroupeAttributs(LdapGroupeAttributs ldapGroupeAttributs) {
		this.ldapGroupeAttributs = ldapGroupeAttributs;
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
}
