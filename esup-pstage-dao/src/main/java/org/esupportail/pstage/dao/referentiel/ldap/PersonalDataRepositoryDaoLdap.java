package org.esupportail.pstage.dao.referentiel.ldap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.esupportail.commons.services.ldap.LdapException;
import org.esupportail.commons.services.ldap.LdapUser;
import org.esupportail.commons.services.ldap.LdapUserService;
import org.esupportail.pstage.dao.referentiel.PersonalDataRepositoryDao;
import org.esupportail.pstage.services.ldap.LdapAttributes;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstage.utils.Utils;
import org.esupportail.pstagedata.domain.beans.Affectation;
import org.esupportail.pstagedata.domain.beans.Enseignant;
import org.esupportail.pstagedata.domain.beans.PersonnelCentreGestion;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.ldap.filter.NotFilter;
import org.springframework.ldap.filter.OrFilter;
import org.springframework.ldap.filter.WhitespaceWildcardsFilter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@SuppressWarnings("serial")
public class PersonalDataRepositoryDaoLdap  implements PersonalDataRepositoryDao{
	private static Logger logger = Logger.getLogger(PersonalDataRepositoryDaoLdap.class);
	
	private LdapUserService ldapUserService;

	private  LdapAttributes ldapAttributes;
	private static String separateur = ",";

	/**
	 * @param ldapAttributes the ldapAttributes to set
	 */
	public void setLdapAttributes(LdapAttributes ldapAttributes) {
		this.ldapAttributes = ldapAttributes;
	}

	/**
	 * @param ldapUserService the ldapUserService to set
	 */
	public void setLdapUserService(LdapUserService ldapUserService) {
		this.ldapUserService = ldapUserService;
	}

	@Override
	public Enseignant getEnseignantRef(String universityCode, String id) {
		Enseignant enseignant = retrieveEnseignant(id,new  EqualsFilter(ldapAttributes.getLdapUid(), id) );
		enseignant.setCodeUniversite(universityCode);	
		return enseignant;
	}

	private Enseignant retrieveEnseignant(String id,Filter filtre) {
		AndFilter filter = new AndFilter();

		filter.and(filtre);
		String encode = filter.encode();   
		encode=encode.substring(1, encode.length()-1);
		List<LdapUser> ldapUsersFromFilter=null;
		if(logger.isInfoEnabled()){
			logger.info(" le filtre ldap " + encode);
		}
		try {
			ldapUsersFromFilter = ldapUserService.getLdapUsersFromFilter(encode);
		}
		catch (LdapException ldae) {
			errorldap(ldae,"getLdapUsersFromFilter");
		}
		Enseignant enseignant = new Enseignant();
		if(!ldapUsersFromFilter.isEmpty()){
			LdapUser ldapUser = ldapUsersFromFilter.get(0);
			if(logger.isInfoEnabled()){
				logger.info("attributsNames= " +ldapUser.getAttributeNames());
				logger.info("attributs = " + ldapUser.getAttributes());
			}

			enseignantFormate(enseignant, ldapUser);

		}

		return enseignant;
	}



	/**
	 * Met en forme l'etudiant avec les parametres qui vont bien 
	 * @param etudiantRef
	 * @param ldapUser
	 */
	private Enseignant enseignantFormate(Enseignant enseignant, LdapUser ldapUser) {
		enseignant.setUidEnseignant(ldapUser.getAttribute(ldapAttributes.getLdapUid()));
		enseignant.setNom(ldapUser.getAttribute(ldapAttributes.getLdapName()));
		enseignant.setPrenom(ldapUser.getAttribute(ldapAttributes.getLdapFirstName()));

		if(StringUtils.hasText(ldapUser.getAttribute(ldapAttributes.getLdapMail()))){
			enseignant.setMail(ldapUser.getAttribute(ldapAttributes.getLdapMail()));
		}
		enseignant.setBatiment(ldapUser.getAttribute(ldapAttributes.getLdapMemberBuilding()));
		enseignant.setBureau(ldapUser.getAttribute(ldapAttributes.getLdapMemberRoom()));
		enseignant.setCampus(ldapUser.getAttribute(ldapAttributes.getLdapMemberCampus()));
		
		// Creation de l'objet affectation pour l'affichage dans le resultat de la recherche
		Affectation a = new Affectation();
		if (ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()) != null 
			&& !(ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()).isEmpty())){
			a.setLibelle(ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()));
		}
		if (ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()) != null
			&& !(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()).isEmpty())){
			a.setCode(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()));
			enseignant.setCodeAffectation(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()));
		}
		enseignant.setAffectation(a);
		
		String civilite = ldapUser.getAttribute(ldapAttributes.getLdapMemberCivility());
		if (civilite != null){
			if (civilite.equalsIgnoreCase(DonneesStatic.CIVILITE_MR_LDAP)){
				enseignant.setIdCivilite(DonneesStatic.ID_CIVILITE_MR);
			} else if (civilite.equalsIgnoreCase(DonneesStatic.CIVILITE_MME_LDAP)){
				enseignant.setIdCivilite(DonneesStatic.ID_CIVILITE_MME);
			} else if (civilite.equalsIgnoreCase(DonneesStatic.CIVILITE_MLLE_LDAP)){
				enseignant.setIdCivilite(DonneesStatic.ID_CIVILITE_MLLE);
			} else {
				enseignant.setIdCivilite(DonneesStatic.ID_CIVILITE_VIDE);
			}
		} else {
			enseignant.setIdCivilite(DonneesStatic.ID_CIVILITE_VIDE);
		}
		
		String tel = ldapUser.getAttribute(ldapAttributes.getLdapMemberPhone());
		if(StringUtils.hasText(tel)){
			enseignant.setTel(tel);
		}

		String type = ldapUser.getAttribute(ldapAttributes.getLdapMemberType());
		enseignant.setTypePersonne(type);


		return enseignant;
	}



	private void errorldap(LdapException ldae, String methodeAppelee) {
		StringBuilder builder = new StringBuilder();
		builder.append(" Probleme pendant appel de ");
		builder.append(methodeAppelee);
		builder.append(" dans ");
		builder.append(this.getClass().getSimpleName());
		builder.append(" : ");
		logger.error(builder.toString() ,ldae.getCause());

		if(logger.isDebugEnabled()){
			logger.debug(builder.toString(), ldae);
		};
	}
	
	@Override
	public List<Enseignant> getEnseignantsByName(String universityCode, String name) {
		AndFilter filter = new AndFilter();
		filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapName(), name));
		String affiliationFacultyValues=ldapAttributes.getLdapFacultytAffiliation();

		if (affiliationFacultyValues.contains(separateur)){
			//il y a plusieurs valeurs possibles pour primaryAffiliation -> on fait un filtre ou
			String[] affiliationValues = affiliationFacultyValues.split(",");
			OrFilter filtreOu = new OrFilter();
			for(String affiliationValue : affiliationValues){
				filtreOu.or(new EqualsFilter(ldapAttributes.getLdapAffiliation(),affiliationValue));
			}
			filter.and(filtreOu);
		}
		else{

			filter.and(new EqualsFilter(ldapAttributes.getLdapAffiliation(), ldapAttributes.getLdapFacultytAffiliation()));
		}

		//Il y des enseignants #type de personnel appartenant Ã  ldap.faculty.affiliation mais ne pouvant Ãªtre tuteur de stage 
		//#(ex. : lecteur, moniteur) : les valeurs sont sÃ©parÃ©es par une virgule ",", on les traites avant

		String ldapFacultyNonTuteur = ldapAttributes.getLdapFacultyNonTuteur();
		if(StringUtils.hasText(ldapFacultyNonTuteur)){	
			if(ldapFacultyNonTuteur.contains(separateur)){
				//On a plusieurs attributs d'enseingants  qui bien que etant faculty, ne peuvent etre tuteurs de stage
				//dans ce cas on construit le filtre sur chaqu'un des attributs
				String[] valeursNonTuteurs = ldapFacultyNonTuteur.split(",");        		
				for(String unTypeNonTuteur : valeursNonTuteurs) {
					//TODO cas ou la chaine contient un accent , filtre encode mal 
					filter.and(new NotFilter(new EqualsFilter(ldapAttributes.getLdapMemberType(), unTypeNonTuteur)));
				}	
			}
			else {	        		
				filter.and(new NotFilter(new EqualsFilter(ldapAttributes.getLdapMemberType(), ldapFacultyNonTuteur)));
			}
		}


		String encode = filter.encode();       
		encode = encode.substring(1, encode.length()-1);
		if(logger.isInfoEnabled()){
			logger.info(" le filtre ldap " + encode);
		}

		List<LdapUser> enseignantsDansLdap=null;

		try {
			enseignantsDansLdap = ldapUserService.getLdapUsersFromFilter(encode);
		}
		catch (LdapException ldae) {
			errorldap(ldae,"getLdapUsersFromFilter");
		}

		return ldapUsersToTeachers(universityCode, enseignantsDansLdap);
	}

	@Override
	public List<Enseignant> getEnseignantsByName(String universityCode, String name, String firstName, String codeAffectation) {	
		AndFilter filter = new AndFilter();		 
		filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapName(), name));
		filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapFirstName(), firstName));
		if(codeAffectation != null && !codeAffectation.equals("")){
			filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapMemberAffectation(), codeAffectation));
		}

		String affiliationFacultyValues=ldapAttributes.getLdapFacultytAffiliation();

		if (affiliationFacultyValues.contains(separateur)){
			//il y a plusieurs valeurs possibles pour primaryAffiliation -> on fait un filtre ou
			String[] affiliationValues = affiliationFacultyValues.split(",");
			OrFilter filtreOu = new OrFilter();
			for(String affiliationValue : affiliationValues){
				filtreOu.or(new EqualsFilter(ldapAttributes.getLdapAffiliation(),affiliationValue));
			}
			filter.and(filtreOu);
		}
		else{
			filter.and(new EqualsFilter(ldapAttributes.getLdapAffiliation(), ldapAttributes.getLdapFacultytAffiliation()));
		}

		String ldapFacultyNonTuteur = ldapAttributes.getLdapFacultyNonTuteur();
		if(StringUtils.hasText(ldapFacultyNonTuteur)){	
			if(ldapFacultyNonTuteur.contains(separateur)){
				//On a plusieurs attributs d'enseingants  qui bien que etant faculty, ne peuvent etre tuteurs de stage
				//dans ce cas on construit le filtre sur chaqu'un des attributs
				String[] valeursNonTuteurs = ldapFacultyNonTuteur.split(",");        		
				for(String unTypeNonTuteur : valeursNonTuteurs) {
					//FIXME cas ou la chaine contient un accent , filtre encode mal ==> a faire
					filter.and(new NotFilter(new EqualsFilter(ldapAttributes.getLdapMemberType(), unTypeNonTuteur)));
				}	
			}
			else {	        		
				filter.and(new NotFilter(new EqualsFilter(ldapAttributes.getLdapMemberType(), ldapFacultyNonTuteur)));
			}
		}

		String encode = filter.encode();       
		encode = encode.substring(1, encode.length()-1);
		if(logger.isInfoEnabled()){
			logger.info(" le filtre ldap " + encode);
		} 
		List<LdapUser> enseignantsDansLdap=null;

		try {
			enseignantsDansLdap = ldapUserService.getLdapUsersFromFilter(encode);
		}
		catch (LdapException ldae) {
			errorldap(ldae,"getLdapUsersFromFilter");
		}


		return ldapUsersToTeachers(universityCode, enseignantsDansLdap);
	}
	/**
	 * Transforme un ensemble d'utilisateurs Ldap en un ensemble d'enseignants
	 * @param universityCode
	 * @param enseignantsDansLdap
	 * @return
	 */
	private List<Enseignant> ldapUsersToTeachers(String universityCode,
			List<LdapUser> enseignantsDansLdap) {
		List<Enseignant> enseignants = null;
		Enseignant enseignant =null;
		if(!enseignantsDansLdap.isEmpty()){


			enseignants = new ArrayList<Enseignant>(enseignantsDansLdap.size());

			for(LdapUser user : enseignantsDansLdap){	  
				enseignant = new Enseignant();
				enseignant.setCodeUniversite(universityCode);
				enseignants.add(enseignantFormate(enseignant, user));
			}
		}

		return enseignants;
	}



	/** 
	 * Retourne le membre de uid=uid present pour l'universite choisie
	 * @param universityCode
	 * @param id personnel centre de gestion
	 * @return a CenterStaffMember
	 */

	@Override
	public PersonnelCentreGestion getPersonnelCentreGestionRef(
			String universityCode, String id) {

		PersonnelCentreGestion personnelCentreGestion = retrievePersonnelCentreGestion(id,new EqualsFilter(ldapAttributes.getLdapUid(), id) );
		personnelCentreGestion.setCodeUniversite(universityCode);
		return personnelCentreGestion;
	}

	private PersonnelCentreGestion retrievePersonnelCentreGestion(String id,
			Filter filtre) {
		AndFilter filter = new AndFilter();

		filter.and(filtre);
		String encode = filter.encode();   
		encode=encode.substring(1, encode.length()-1);
		List<LdapUser> ldapUsersFromFilter=null;

		if(logger.isInfoEnabled()){
			logger.info(" le filtre ldap " + encode);
		}
		try {
			ldapUsersFromFilter = ldapUserService.getLdapUsersFromFilter(encode);
		}
		catch (LdapException ldae) {
			errorldap(ldae,"getLdapUsersFromFilter");
		}
		PersonnelCentreGestion personnelCentreGestion = new PersonnelCentreGestion();
		if(!ldapUsersFromFilter.isEmpty()){
			LdapUser ldapUser = ldapUsersFromFilter.get(0);
			if(logger.isInfoEnabled()){
				logger.info("attributsNames= " +ldapUser.getAttributeNames());
				logger.info("attributs = " + ldapUser.getAttributes());
			}

			personnelCGFormate(personnelCentreGestion, ldapUser);

		}

		return personnelCentreGestion;
	}
	/**
	 * Format le personnel en mappant les attributs ceux du personnel
	 * @param personnelCentreGestion
	 * @param ldapUser
	 */
	private PersonnelCentreGestion  personnelCGFormate( PersonnelCentreGestion personnelCentreGestion, LdapUser ldapUser) {
		personnelCentreGestion.setUidPersonnel((ldapUser.getAttribute(ldapAttributes.getLdapUid())));
		personnelCentreGestion.setNom(ldapUser.getAttribute(ldapAttributes.getLdapName()));
		personnelCentreGestion.setPrenom(ldapUser.getAttribute(ldapAttributes.getLdapFirstName()));

		if(StringUtils.hasText(ldapUser.getAttribute(ldapAttributes.getLdapMail()))){
			personnelCentreGestion.setMail(ldapUser.getAttribute(ldapAttributes.getLdapMail()));
		}
		personnelCentreGestion.setBatiment(ldapUser.getAttribute(ldapAttributes.getLdapMemberBuilding()));
		personnelCentreGestion.setBureau(ldapUser.getAttribute(ldapAttributes.getLdapMemberRoom()));
		personnelCentreGestion.setCampus(ldapUser.getAttribute(ldapAttributes.getLdapMemberCampus()));
		
		// Creation de l'objet affectation pour l'affichage dans le resultat de la recherche
		Affectation a = new Affectation();
		if (ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()) != null 
			&& !(ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()).isEmpty())){
			a.setLibelle(ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()));
		}
		if (ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()) != null
			&& !(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()).isEmpty())){
			a.setCode(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()));
			personnelCentreGestion.setCodeAffectation(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()));
		}
		personnelCentreGestion.setAffectation(a);
		
		String civilite = ldapUser.getAttribute(ldapAttributes.getLdapMemberCivility());
		if (civilite != null){
			if (civilite.equalsIgnoreCase(DonneesStatic.CIVILITE_MR_LDAP)){
				personnelCentreGestion.setIdCivilite(DonneesStatic.ID_CIVILITE_MR);
			} else if (civilite.equalsIgnoreCase(DonneesStatic.CIVILITE_MME_LDAP)){
				personnelCentreGestion.setIdCivilite(DonneesStatic.ID_CIVILITE_MME);
			} else if (civilite.equalsIgnoreCase(DonneesStatic.CIVILITE_MLLE_LDAP)){
				personnelCentreGestion.setIdCivilite(DonneesStatic.ID_CIVILITE_MLLE);
			} else {
				personnelCentreGestion.setIdCivilite(DonneesStatic.ID_CIVILITE_VIDE);
			}
		} else {
			personnelCentreGestion.setIdCivilite(DonneesStatic.ID_CIVILITE_VIDE);
		}
		
		String tel = ldapUser.getAttribute(ldapAttributes.getLdapMemberPhone());
		if(StringUtils.hasText(tel)){
			personnelCentreGestion.setTel(tel);
		}
		
		String type = ldapUser.getAttribute(ldapAttributes.getLdapMemberType());
		personnelCentreGestion.setTypePersonne(type);

		return personnelCentreGestion;

	}

	@Override
	public List<PersonnelCentreGestion> getPersonnelCentreGestionRefByName( String universityCode, String name, String firstName, String codeAffectation) {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de getPersonnelCentreGestionRefByName()");
		}


		//FIXME pour le moment pas de prise en compte de universityCode
		AndFilter filter = new AndFilter();
		
		filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapName(), name));
		filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapFirstName(), firstName));
		if(codeAffectation != null && !codeAffectation.equals("")){
			filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapMemberAffectation(), codeAffectation));
		}
		//creation d'un filtre ou  utilisant la valeur de eduPersonPrimaryAffiliation = employee et  eduPersonPrimaryAffiliation = faculty
		String employeeAffiliationValues = ldapAttributes.getLdapEmployeeAffiliation();
		String facultyAffiliationValues= ldapAttributes.getLdapFacultytAffiliation();
		//On veut eviter les doublons
		Set<String> lesAffiliations = new HashSet<String>();
		//cas affiliation employee

		if (employeeAffiliationValues.contains(separateur)){
			String[] emplAffiliationValues = employeeAffiliationValues.split(separateur);
			for(String emplAffiliationValue : emplAffiliationValues){
				lesAffiliations.add(emplAffiliationValue);
			}
		}else {
			lesAffiliations.add(employeeAffiliationValues);
		}
		//cas affiliaton  faculty
		if(facultyAffiliationValues.contains(separateur)){
			String[] facAffiliationValues = facultyAffiliationValues.split(separateur);

			for(String facAffiliationValue: facAffiliationValues){
				lesAffiliations.add(facAffiliationValue);
			}
		}
		else{
			lesAffiliations.add(facultyAffiliationValues);
		}

		OrFilter filtreOu = new OrFilter();
		for(String affiliationValue: lesAffiliations){
			filtreOu.or(new EqualsFilter(ldapAttributes.getLdapAffiliation(),affiliationValue));
		}
		filter.and(filtreOu);

		String encode = filter.encode();       
		encode = encode.substring(1, encode.length()-1);


		if(logger.isInfoEnabled()){
			logger.info(" le filtre ldap " + encode);
		} 
		List<LdapUser> enseignantsDansLdap=null;

		try {
			enseignantsDansLdap = ldapUserService.getLdapUsersFromFilter(encode);
		}
		catch (LdapException ldae) {
			errorldap(ldae,"getLdapUsersFromFilter");
		}

		return ldapUsersToPersonnelCDG(universityCode, enseignantsDansLdap);
	}



	private List<PersonnelCentreGestion> ldapUsersToPersonnelCDG(
			String universityCode, List<LdapUser> personnelsCdgLdap) {
		List<PersonnelCentreGestion> personnelsCDG = null;
		PersonnelCentreGestion personnelCDG =null;
		if(!personnelsCdgLdap.isEmpty()){
			personnelsCDG = new ArrayList<PersonnelCentreGestion>(personnelsCdgLdap.size());
			for(LdapUser user : personnelsCdgLdap){
				personnelCDG = new PersonnelCentreGestion();
				personnelCDG.setCodeUniversite(universityCode);
				personnelsCDG.add(personnelCGFormate(personnelCDG, user));
			}
		}

		return personnelsCDG;
	}



	public void initPersonalDataRepositoryLdap(){
		Assert.notNull(ldapUserService, Utils.verifierPropriete(ldapUserService, this.getClass().getName()));
		Assert.notNull(ldapAttributes, Utils.verifierPropriete(ldapAttributes, this.getClass().getName()));


	}
}
