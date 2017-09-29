package org.esupportail.pstage.dao.referentiel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.apache.log4j.Logger;
import org.esupportail.commons.services.ldap.LdapException;
import org.esupportail.commons.services.ldap.LdapUser;
import org.esupportail.commons.services.ldap.LdapUserService;
import org.esupportail.pstage.domain.beans.LdapAttributes;
import org.esupportail.pstage.utils.DonneesStatic;
import org.esupportail.pstagedata.domain.dto.AffectationDTO;
import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.esupportail.pstagedata.domain.dto.PersonnelCentreGestionDTO;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.ldap.filter.OrFilter;
import org.springframework.ldap.filter.WhitespaceWildcardsFilter;
import org.springframework.ldap.filter.NotFilter;
import org.springframework.util.StringUtils;


/**
 * 
 * Acces au composantes du personnel personnalise
 *
 */

@SuppressWarnings("serial")
public class PersonalDataRepositoryDaoWS implements
PersonalDataRepositoryDao {

	/**
	 * 
	 */
	final transient Logger logger = Logger.getLogger(PersonalDataRepositoryDaoWS.class);

	/**
	 * see {@link LdapUserService}.
	 */
	private LdapUserService ldapUserService;
	/**
	 * 
	 */
	private LdapTemplate ldapTemplate;

	/**
	 * This class contains all LDAP attributes used to OPI. 
	 */
	private LdapAttributes ldapAttributes;

	private static String separateur = ",";

	/**
	 * sameCodeComposanteLdapApogee
	 */
	protected boolean sameCodeComposanteLdapApogee;

	/**
	 * @param codeLdapComposante
	 * @return le code composante Apogee en fonction du code Ldap en parametre
	 */
	@SuppressWarnings("unchecked")
	public String getCodeApogeeComposante(String codeLdapComposante) {

		List<String[]> listeComposantes = ldapTemplate.search(this.ldapAttributes.getLdapComposante(), this.ldapAttributes.getLdapComposanteFilter(), new CompDescriptionAttributesMapper());

		String codeApo = codeLdapComposante;
		
		for(String[] composante : listeComposantes){
			if(composante[0].equalsIgnoreCase(codeLdapComposante)){
				codeApo = composante[2];
			}
		}
		return codeApo;
	}

	/**
	 * @param codeApogeeComposante
	 * @return le code composante Ldap en fonction du code Apogee en parametre
	 */
	@SuppressWarnings("unchecked")
	public String getCodeLdapComposante(String codeApogeeComposante) {

		List<String[]> listeComposantes = ldapTemplate.list(this.ldapAttributes.getLdapComposante());

		String codeLdap=codeApogeeComposante;
		
		for(String[] composante : listeComposantes){
			if(composante[2]!=null && composante[2].equalsIgnoreCase(codeApogeeComposante)){
				codeLdap=composante[0];
			}
		}
		return codeLdap;
	}

	/**
	 *
	 */
	private class CompDescriptionAttributesMapper implements AttributesMapper {
		/**
		 * @see org.springframework.ldap.core.AttributesMapper#mapFromAttributes(javax.naming.directory.Attributes)
		 */
		public Object mapFromAttributes(Attributes attributs) throws NamingException {
			String[] compo = new String[3];
			compo[0]=(attributs.get(getLdapAttributes().getLdapComposanteCode())).get().toString();
			compo[1]=(attributs.get(getLdapAttributes().getLdapComposanteLibelle())).get().toString();
			compo[2]=((attributs.get(getLdapAttributes().getLdapCodeComposanteApogee())) != null ? (attributs.get(getLdapAttributes().getLdapCodeComposanteApogee())).get().toString() : null);
			return compo;
		}
	}

	public EnseignantDTO getEnseignantRef(String universityCode, String id) {
		if (logger.isDebugEnabled()){
			logger.debug("PersonalDataRepositoryDaoWS:: EnseignantRef  universityCode  = "+universityCode + " pour id = "+id);
		}
		EnseignantDTO enseignant = new EnseignantDTO();
		AndFilter filter = new AndFilter();
		//creation d'un filtre utilisant multivaleur ldapFacultytAffiliation
		if (ldapAttributes.getLdapFacultytAffiliation().contains(",")){
			//il y a plusieurs valeurs possibles pour primaryAffiliation -> on fait un ou
			StringTokenizer st = new StringTokenizer(ldapAttributes.getLdapFacultytAffiliation(),",");
			OrFilter filtreOu = new OrFilter();
			while (st.hasMoreTokens()){
				//on met chaque code dep dans la liste
				filtreOu.or(new EqualsFilter(ldapAttributes.getLdapAffiliation(),st.nextToken()));
			}
			filter.and(filtreOu);
		}
		else {
			filter.and(new EqualsFilter(ldapAttributes.getLdapAffiliation(),ldapAttributes.getLdapFacultytAffiliation()));
		}
		filter.and(new EqualsFilter(ldapAttributes.getLdapUid(),id));
		String encode = filter.encode();       
		encode = encode.substring(1, encode.length()-1);
		if (logger.isInfoEnabled()){
			logger.info(" le filtre ldap dans getEnseignantRef " + encode);
		}

		try {
			List<LdapUser> listeLdapUser = ldapUserService.getLdapUsersFromFilter(encode);

			if(!listeLdapUser.isEmpty()){
				LdapUser ldapUser = listeLdapUser.get(0);
				if (logger.isInfoEnabled()) {
					logger.info("attributsNames= " + ldapUser.getAttributeNames());
					logger.info("attributs = " + ldapUser.getAttributes());
				}
				enseignantFormate(enseignant, ldapUser);

			}
		}
		catch (LdapException ldae) {
			errorldap(ldae,"LdapUser");
		}

		return enseignant;
	}

	@Override
	public List<EnseignantDTO> getEnseignantsByName(String universityCode,
			String name) {
		return null;
	}



	/**
	 * @see org.esupportail.pstage.dao.referentiel.PersonalDataRepositoryDao#getEnseignantsByName(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<EnseignantDTO> getEnseignantsByName(String universityCode,
			String name, String firstName, String codeAffectation) {
		
		name = (name == null ? "" : name);
		firstName = (firstName == null ? "" : firstName);
		codeAffectation = (codeAffectation == null ? "" : codeAffectation);
		
		List<EnseignantDTO> teachers = new ArrayList<EnseignantDTO>();
		
		// Si la configuration indique que le code saisi dans le LDAP n'est pas celui d'apogee
		if (!sameCodeComposanteLdapApogee) {
			// On lance la methode de recuperation du code apogee a partir du code ldap
			codeAffectation=getCodeLdapComposante(codeAffectation);
		}

		AndFilter filter = new AndFilter();
		//creation d'un filtre utilisant multivaleur ldapFacultytAffiliation
		if (ldapAttributes.getLdapFacultytAffiliation().contains(",")){
			//il y a plusieurs valeurs possibles pour primaryAffiliation -> on fait un ou
			StringTokenizer st = new StringTokenizer(ldapAttributes.getLdapFacultytAffiliation(),",");
			OrFilter filtreOu = new OrFilter();
			while (st.hasMoreTokens()){
				//on met chaque code dep dans la liste
				filtreOu.or(new EqualsFilter(ldapAttributes.getLdapAffiliation(),st.nextToken()));
			}
			filter.and(filtreOu);
		}
		else{
			filter.and(new EqualsFilter(ldapAttributes.getLdapAffiliation(),ldapAttributes.getLdapFacultytAffiliation()));
		}
		if (name!=null && !name.equals("")){
			filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapName(),name));
		}

		if (firstName!=null && !firstName.equals("")){
			filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapFirstName(),firstName));
		}
		if (codeAffectation!=null && !codeAffectation.equals("")){
			filter.and(new EqualsFilter(ldapAttributes.getLdapMemberAffectation(),codeAffectation));
		} 
		//Il y des enseignants #type de personnel appartenant a ldap.faculty.affiliation mais ne pouvant etre tuteur de stage 
		//#(ex. : lecteur, moniteur) : les valeurs sont separes par une virgule ",", on les traites avant

		String ldapFacultyNonTuteur = ldapAttributes.getLdapFacultyNonTuteur();
		String memberTypes = ldapAttributes.getLdapMemberType();
		if(StringUtils.hasText(ldapFacultyNonTuteur)){
			//On a plusieurs attributs d'enseingants  qui bien que etant faculty, ne peuvent etre tuteurs de stage
			//dans ce cas on construit le filtre sur chaqu'un des attributs
			StringTokenizer valeursNonTuteurs = new StringTokenizer(ldapFacultyNonTuteur,",");
			while(valeursNonTuteurs.hasMoreTokens()) {
				String uneValeurNonTuteur = valeursNonTuteurs.nextToken();
				StringTokenizer stmt = new StringTokenizer(memberTypes,",");
				while (stmt.hasMoreTokens()){
					//on met chaque code dep dans la liste
					filter.and(new NotFilter(new EqualsFilter(stmt.nextToken(), uneValeurNonTuteur)));
				}
			}
		}
		String encode ;
		//Il y a des personnels non enseignants n'appartenant pas à ldap.faculty.affiliation mais pouvant être tuteur de stage 
		// uid dont les valeurs sont séparées par une virgule ",", on les traites avant
		String ldapEmployeeTuteur = ldapAttributes.getLdapEmployeeTuteur();
		if(logger.isInfoEnabled()){
			logger.info(" ldapEmployeeTuteur " + ldapEmployeeTuteur);
		}

		//on ne cree ce filtre que si une valeur est définie pour ldap.employee.tutor
		if(StringUtils.hasText(ldapEmployeeTuteur)){

			AndFilter filterEmployeeTutor = new AndFilter();
			if (name!=null && !name.equals("")){
				filterEmployeeTutor.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapName(),name));
			}

			if (firstName!=null && !firstName.equals("")){
				filterEmployeeTutor.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapFirstName(),firstName));
			}
			if (codeAffectation!=null && !codeAffectation.equals("")){
				filterEmployeeTutor.and(new EqualsFilter(ldapAttributes.getLdapMemberAffectation(),codeAffectation));
			}

			StringTokenizer affiliationEmployeeValues= new StringTokenizer(ldapAttributes.getLdapEmployeeAffiliation(),",");
			OrFilter filtreOuE = new OrFilter();
			while( affiliationEmployeeValues.hasMoreTokens()){
				filtreOuE.or(new EqualsFilter(ldapAttributes.getLdapAffiliation(),affiliationEmployeeValues.nextToken()));
			}
			filterEmployeeTutor.and(filtreOuE);
			StringTokenizer valeursTuteurs = new StringTokenizer(ldapEmployeeTuteur, ",");
			//On a plusieurs uid de personnels  qui ne sont pas recupérés dans faculty mais qui peuvent etre tuteurs de stage
			//dans ce cas on construit le filtre sur chaqu'un des uid
			OrFilter filtreOuT = new OrFilter();

			while(valeursTuteurs.hasMoreTokens()) {
				filtreOuT.or(new EqualsFilter(ldapAttributes.getLdapUid(),valeursTuteurs.nextToken()));
			}
			filterEmployeeTutor.and(filtreOuT);
			// on ajoute ce filtre
			AndFilter tempFilter= filter;
			OrFilter finalFilter = new OrFilter() ;
			finalFilter.or(tempFilter);
			finalFilter.or(filterEmployeeTutor);
			encode = finalFilter.encode();
		}
		else {
			encode = filter.encode();

		}
		encode = encode.substring(1, encode.length()-1);
		if(logger.isInfoEnabled()){
			logger.info(" le filtre ldap dans getEnseignantsByName" + encode);
		}

		try {

			List<LdapUser> listeLdapUser = ldapUserService.getLdapUsersFromFilter(encode);
			if (listeLdapUser.isEmpty()) {
				return teachers;
			}
			logger.debug("## taille de la liste trouvée : " + listeLdapUser.size());
			for (Iterator<LdapUser> iter = listeLdapUser.iterator(); iter.hasNext();) {
				LdapUser ldapuser = iter.next();
				// creation d'un user et alimentation des données 
				EnseignantDTO enseignantUser = new EnseignantDTO();
				enseignantUser.setUidEnseignant(ldapuser.getAttribute(ldapAttributes.getLdapUid()));
				enseignantUser.setNom(ldapuser.getAttribute(ldapAttributes.getLdapName()));
				if (ldapuser.getAttribute(ldapAttributes.getLdapFirstName())!=null){
					enseignantUser.setPrenom(ldapuser.getAttribute(ldapAttributes.getLdapFirstName()));
				}
				if (ldapuser.getAttribute(ldapAttributes.getLdapMail())!=null){
					enseignantUser.setMail(ldapuser.getAttribute(ldapAttributes.getLdapMail()));
				}
				if (ldapuser.getAttribute(ldapAttributes.getLdapMemberRoom())!=null){
					enseignantUser.setBureau(ldapuser.getAttribute(ldapAttributes.getLdapMemberRoom()));
				}
				if (ldapuser.getAttribute(ldapAttributes.getLdapMemberBuilding())!=null){
					enseignantUser.setBatiment(ldapuser.getAttribute(ldapAttributes.getLdapMemberBuilding()));
				}
				if (ldapuser.getAttribute(ldapAttributes.getLdapMemberAffectation())!=null){
					if(!sameCodeComposanteLdapApogee){
						enseignantUser.setCodeAffectation(getCodeApogeeComposante(ldapuser.getAttribute(ldapAttributes.getLdapMemberAffectation())));
					}else{
						enseignantUser.setCodeAffectation(ldapuser.getAttribute(ldapAttributes.getLdapMemberAffectation()));
					}
				}
				if (ldapuser.getAttribute(ldapAttributes.getLdapMemberCampus())!=null){
					enseignantUser.setCampus(ldapuser.getAttribute(ldapAttributes.getLdapMemberCampus()));
				}

				String civilite = ldapuser.getAttribute(ldapAttributes.getLdapMemberCivility());
				if (civilite != null){
					if (civilite.equalsIgnoreCase(DonneesStatic.CIVILITE_MR_LDAP)){
						enseignantUser.setIdCivilite(DonneesStatic.ID_CIVILITE_MR);
					} else if (civilite.equalsIgnoreCase(DonneesStatic.CIVILITE_MME_LDAP)){
						enseignantUser.setIdCivilite(DonneesStatic.ID_CIVILITE_MME);
					} else if (civilite.equalsIgnoreCase(DonneesStatic.CIVILITE_MLLE_LDAP)){
						enseignantUser.setIdCivilite(DonneesStatic.ID_CIVILITE_MLLE);
					} else {
						enseignantUser.setIdCivilite(DonneesStatic.ID_CIVILITE_VIDE);
					}
				} else {
					enseignantUser.setIdCivilite(DonneesStatic.ID_CIVILITE_VIDE);
				}

				if (ldapuser.getAttribute(ldapAttributes.getLdapAffiliation())!=null){
					enseignantUser.setTypePersonne(ldapuser.getAttribute(ldapAttributes.getLdapAffiliation()));
				}
				if (ldapuser.getAttribute(ldapAttributes.getLdapMemberPhone())!=null){
					enseignantUser.setTel(ldapuser.getAttribute(ldapAttributes.getLdapMemberPhone()));
				}
				enseignantUser.setCodeUniversite(universityCode);
				teachers.add(enseignantUser);

			} 
		}
		catch (LdapException ldae) {
			errorldap(ldae,"getLdapUsersFromFilter");
		}

		return teachers;
	}

	/**
	 * Met en forme l'enseignant
	 * @param enseignant
	 * @param ldapUser
	 */
	private EnseignantDTO enseignantFormate(EnseignantDTO enseignant, LdapUser ldapUser) {		
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
		AffectationDTO a = new AffectationDTO();
		if (ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()) != null 
				&& !(ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()).isEmpty())){
			a.setLibelle(ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()));
		}
		if (ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()) != null
				&& !(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()).isEmpty())){
			if(!sameCodeComposanteLdapApogee){
				enseignant.setCodeAffectation(getCodeApogeeComposante(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation())));
			}else{
				enseignant.setCodeAffectation(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()));
			}
			a.setCode(enseignant.getCodeAffectation());
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

	/**
	 * @see org.esupportail.pstage.dao.referentiel.PersonalDataRepositoryDao#getPersonnelCentreGestionRef(java.lang.String, java.lang.String)
	 */
	public PersonnelCentreGestionDTO getPersonnelCentreGestionRef(
			String universityCode, String id) {
		PersonnelCentreGestionDTO personnelCentreGestion = retrievePersonnelCentreGestion(id,new EqualsFilter(ldapAttributes.getLdapUid(), id) );
		personnelCentreGestion.setCodeUniversite(universityCode);
		return personnelCentreGestion;
	}

	/**
	 * @param id
	 * @param filtre
	 * @return PersonnelCentreGestion
	 */
	private PersonnelCentreGestionDTO retrievePersonnelCentreGestion(String id,
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
		PersonnelCentreGestionDTO personnelCentreGestion = new PersonnelCentreGestionDTO();
		if(ldapUsersFromFilter != null && !ldapUsersFromFilter.isEmpty()){
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
	 * Format le personnel
	 * @param personnelCentreGestion
	 * @param ldapUser
	 */
	private PersonnelCentreGestionDTO  personnelCGFormate( PersonnelCentreGestionDTO personnelCentreGestion, LdapUser ldapUser) {
		personnelCentreGestion.setUidPersonnel((ldapUser.getAttribute(ldapAttributes.getLdapUid())));
		personnelCentreGestion.setNom(ldapUser.getAttribute(ldapAttributes.getLdapName()));
		personnelCentreGestion.setPrenom(ldapUser.getAttribute(ldapAttributes.getLdapFirstName()));

		if(StringUtils.hasText(ldapUser.getAttribute(ldapAttributes.getLdapMail()))){
			personnelCentreGestion.setMail(ldapUser.getAttribute(ldapAttributes.getLdapMail()));
		}
		personnelCentreGestion.setBatiment(ldapUser.getAttribute(ldapAttributes.getLdapMemberBuilding()));
		personnelCentreGestion.setBureau(ldapUser.getAttribute(ldapAttributes.getLdapMemberRoom()));
		personnelCentreGestion.setCampus(ldapUser.getAttribute(ldapAttributes.getLdapMemberCampus()));

		//Creation de l'objet affectation pour l'affichage dans le resultat de la recherche
		AffectationDTO a = new AffectationDTO();
		if (ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()) != null 
				&& !(ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()).isEmpty())){
			a.setLibelle(ldapUser.getAttribute(ldapAttributes.getLdapMemberLibelleAffectation()));
		}
		if (ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()) != null
				&& !(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()).isEmpty())){
			if(!sameCodeComposanteLdapApogee){
				personnelCentreGestion.setCodeAffectation(getCodeApogeeComposante(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation())));
			}else{
				personnelCentreGestion.setCodeAffectation(ldapUser.getAttribute(ldapAttributes.getLdapMemberAffectation()));
			}
			a.setCode(personnelCentreGestion.getCodeAffectation());
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


	/**
	 * @see org.esupportail.pstage.dao.referentiel.PersonalDataRepositoryDao#getPersonnelCentreGestionRefByName(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<PersonnelCentreGestionDTO> getPersonnelCentreGestionRefByName(String universityCode, String name, String firstName, String codeAffectation) {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de getPersonnelCentreGestionRefByName()");
		}
		if(!sameCodeComposanteLdapApogee){
			codeAffectation=getCodeLdapComposante(codeAffectation);
		}

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
		//encode = encode.substring(1, encode.length()-1);


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

	private List<PersonnelCentreGestionDTO> ldapUsersToPersonnelCDG(
			String universityCode, List<LdapUser> personnelsCdgLdap) {
		List<PersonnelCentreGestionDTO> personnelsCDG = null;
		PersonnelCentreGestionDTO personnelCDG =null;
		if(!personnelsCdgLdap.isEmpty()){
			personnelsCDG = new ArrayList<PersonnelCentreGestionDTO>(personnelsCdgLdap.size());
			for(LdapUser user : personnelsCdgLdap){
				personnelCDG = new PersonnelCentreGestionDTO();
				personnelCDG.setCodeUniversite(universityCode);
				personnelsCDG.add(personnelCGFormate(personnelCDG, user));
			}
		}

		return personnelsCDG;
	}

	/**
	 * @param ldae
	 * @param methodeAppelee
	 */
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
	 * @return the ldapTemplate
	 */
	public LdapTemplate getLdapTemplate() {
		return ldapTemplate;
	}

	/**
	 * @param ldapTemplate the ldapTemplate to set
	 */
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
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


	/**
	 * @return the sameCodeComposanteLdapApogee
	 */
	public boolean isSameCodeComposanteLdapApogee() {
		return sameCodeComposanteLdapApogee;
	}


	/**
	 * @param sameCodeComposanteLdapApogee the sameCodeComposanteLdapApogee to set
	 */
	public void setSameCodeComposanteLdapApogee(boolean sameCodeComposanteLdapApogee) {
		this.sameCodeComposanteLdapApogee = sameCodeComposanteLdapApogee;
	}


}
