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
import org.esupportail.pstage.domain.beans.EtudiantRef;
import org.esupportail.pstage.services.ldap.LdapAttributes;
import org.esupportail.pstage.services.ldap.LdapGroupeAttributs;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.ldap.filter.OrFilter;
import org.springframework.ldap.filter.WhitespaceWildcardsFilter;
import org.springframework.util.StringUtils;


public class StudentDataRepositoryDaoLdap implements StudentDataRepositoryDao {

	private static Logger logger = Logger.getLogger(StudentDataRepositoryDaoLdap.class);
	private LdapUserService ldapUserService;
	private LdapAttributes ldapAttributes;

    private LdapGroupService ldapGroupService;
    private LdapGroupeAttributs ldapGroupeAttributs;

    private LdapGroupService ldapGroupServiceSpecial;

    /**

     * @param ldapGroupServiceSpecial the ldapGroupServiceSpecial to set
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
	 * 
	 */

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


	private static final long serialVersionUID = 1L;

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
		//     filter.and(new EqualsFilter("objectClass", "Person"));
		//filter.and(new EqualsFilter(ldapAttributes.getLdapUid(), id));
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
		EtudiantRef etudiantRef = new EtudiantRef();
		if(!ldapUsersFromFilter.isEmpty()){
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
		//num ettudiant=supannEtuid=uidNumber
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
              //logger.info("dateNaissance : "  etudiantRef.getDateNais());
            } catch (ParseException e) {
              e.printStackTrace();
            }
          }

    	if (ldapUser.getAttribute("supannCivilite")!=null){
	  if (ldapUser.getAttribute("supannCivilite").equals("M.")) etudiantRef.setCodeSexe("M");
	  else etudiantRef.setCodeSexe("F");
            // etudiantRef.setCodeSexe(ldapUser.getAttribute("supannCivilite"));
    	}


		//on ajoute chaque etape d'inscription dans la map, mais sans libelle pour le moment
		Map<String, String>  mapSteps =null;
		Map<String, String> etapesRef = getEtapesRef(null);
		String studentStep =ldapAttributes.getLdapStudentStep();
		if(StringUtils.hasText(ldapUser.getAttribute(studentStep))){
			mapSteps = new LinkedHashMap<String, String>();
			List<String> list = ldapUser.getAttributes().get(studentStep);
			for(String uneEtape : list ){
				//mapSteps.put(uneEtape, "");
				etudiantRef.setTheCodeEtape(uneEtape);
				etudiantRef.setTheEtape(etapesRef.get(uneEtape));
				System.out.println( " Code Etape etudiant = " + uneEtape);
				System.out.println( " Libelle Etape etudiant = " + etapesRef.get(uneEtape));
			}
			etudiantRef.setSteps(mapSteps);
		}



		//les affectations ou ufr
		//  //on ajoute chaque ufr d'inscription dans la map, mais sans libelle pour le moment
		Map<String, String>  mapEtudes =null;
		String affectationEtd =ldapAttributes.getLdapStudentAffectation();
		Map<String, String> ufrRef = getComposantesPrincipalesRef(null);
		if(StringUtils.hasText(ldapUser.getAttribute(affectationEtd))){
			mapEtudes = new LinkedHashMap<String, String>();
			List<String> list = ldapUser.getAttributes().get(affectationEtd);
			for(String uneAffectation : list ){
				mapEtudes.put(uneAffectation, ufrRef.get(uneAffectation));
				etudiantRef.setThecodeUFR(uneAffectation);
				System.out.println( " UFR etudiant code = " + uneAffectation);
				etudiantRef.setTheUfr(ufrRef.get(uneAffectation));
				System.out.println( " UFR etudiant libelle = " + ufrRef.get(uneAffectation));
			}
			etudiantRef.setSteps(mapEtudes);
		}
		
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
	public EtudiantRef getEtudiantRefByNum(String universityCode, String id) {

		EtudiantRef etudiantRefByNum = retrieveStudent(id,new EqualsFilter(ldapAttributes.getLdapStudentId(), id ));
		etudiantRefByNum.setCodeUniversite(universityCode);

		return etudiantRefByNum;
	}

	@Override
	public List<EtudiantRef> getEtudiantsRefByName(String universityCode,
			String name, String firstName) {
		//TODO  si le prenom est vide 
		AndFilter filter = new AndFilter();
		filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapName(), name));
		filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapFirstName(), firstName));
		filter.and(new EqualsFilter(ldapAttributes.getLdapAffiliation(), ldapAttributes.getLdapStudentAffiliation()));
		String encode = filter.encode();   
		if(logger.isInfoEnabled()){
			logger.info(" le filtre ldap " + encode);
		}

		encode=encode.substring(1, encode.length()-1);
		List<LdapUser> etudiantsDansLdap=null;
		try {
			etudiantsDansLdap = ldapUserService.getLdapUsersFromFilter(encode);
		}
		catch (LdapException ldae) {
			errorldap(ldae,"getLdapUsersFromFilter");
		}
		List<EtudiantRef> etudiants = null;
		//EtudiantRef etudiantRef =null;
		if(!etudiantsDansLdap.isEmpty()){
			etudiants = new ArrayList<EtudiantRef>(etudiantsDansLdap.size());
			//etudiantRef = new EtudiantRef();
			for(LdapUser user : etudiantsDansLdap){
				/*
				
				etudiantRef.setNumEtudiant(user.getAttribute(ldapAttributes.getLdapStudentId()));
				etudiantRef.setNom(user.getAttribute(ldapAttributes.getLdapName()));
				etudiantRef.setPrenom(user.getAttribute(ldapAttributes.getLdapFirstName()));
				if(StringUtils.hasText(user.getAttribute(ldapAttributes.getLdapMail()))){
					etudiantRef.setMail(user.getAttribute(ldapAttributes.getLdapMail()));

					etudiantRef.setCodeUniversite(universityCode);
					etudiants.add(etudiantRef);
				} */
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
         //System.out.println("ldapGroupeAttributs="+ldapGroupeAttributs);
     //WhitespaceWildcardsFilter espaceFiltre = new WhitespaceWildcardsFilter(ldapGroupeAttributs.getLdapCodePrincipalesFormations(), " ");
      WhitespaceWildcardsFilter espaceFiltre = new WhitespaceWildcardsFilter(ldapGroupeAttributs.getLdapComposanteCode(), " ");
     filter.and(espaceFiltre);
    String encode = filter.encode();
   encode=encode.substring(1, encode.length()-1);
   if(logger.isInfoEnabled()){
        logger.info(" le filtre ldap getEtapesRef " + encode);
    }
        try {

         ldapGroups= ldapGroupServiceSpecial.getLdapGroupsFromFilter(encode);
         //System.out.println("ldapGroups="+ldapGroups);

        }
        catch (LdapException ldae) {

           StringBuilder builder = new StringBuilder();
                builder.append(" Probleme pendant appel de ");
                builder.append(" getLdapGroupsFromFilter  dans la classe ");
                builder.append(this.getClass().getSimpleName());
                logger.error(builder.toString(),ldae.getCause());
        if(logger.isDebugEnabled()){
                logger.debug(builder.toString(), ldae);
                }
        }
         if(!ldapGroups.isEmpty()){

           String etapeCode=null;
           String etapeLibelle =null;
           etapes = new LinkedHashMap<String, String>(ldapGroups.size());
       //on formate pour le map
           for(LdapGroup group : ldapGroups){
       // etapeCode = group.getAttribute(ldapGroupeAttributs.getLdapCodePrincipalesFormations());
        etapeCode = group.getAttribute(ldapGroupeAttributs.getLdapComposanteCode());
        //System.out.println("etapeCode="+etapeCode);
        etapeLibelle = group.getAttribute(ldapGroupeAttributs.getLdapComposanteLibelle());
        //System.out.println("etapeLibelle="+etapeLibelle);
        etapes.put(etapeCode, etapeLibelle);
         }     
        }
        logger.info(" resultat etape 1 : " + etapes);
        return etapes;
}

public Map<String, String> getComposantesPrincipalesRef(String universityCode) {
	Map<String, String> composantes=null;
     List<LdapGroup> ldapGroups =null;
	System.out.println("Composantes");
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
	 System.out.println("ldapGroups="+ldapGroups);
	 if(!ldapGroups.isEmpty()){
			
    	   String compCode=null;
    	   String compLibelle =null;
    	   composantes = new LinkedHashMap<String, String>(ldapGroups.size());
       //on formate pour le map
    	   for(LdapGroup group : ldapGroups){
    	compCode = group.getAttribute(ldapGroupeAttributs.getLdapComposanteCode());
    	//System.out.println("compCode="+compCode);
    	compLibelle = group.getAttribute(ldapGroupeAttributs.getLdapComposanteLibelle());
    	//System.out.println("compLibelle="+compLibelle);
    	composantes.put(compCode, compLibelle);
	 }	
	}
	
	}
	catch (LdapException ldae) {

    	   StringBuilder builder = new StringBuilder();
		builder.append(" Probleme pendant appel de ");
		builder.append(" getLdapGroupsFromFilter  dans la classe ");
		builder.append(this.getClass().getSimpleName());
		logger.error(builder.toString(),ldae.getCause());
        if(logger.isDebugEnabled()){
        	logger.debug(builder.toString(), ldae);
		}
	}
	
	
	return composantes;
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

	/*
	private List<EtudiantRef> getStudentsByName( String universityCode, 	String name) {
		 AndFilter filter = new AndFilter();
	     filter.and(new WhitespaceWildcardsFilter(ldapAttributes.getLdapName(), name));
	     filter.and(new EqualsFilter(ldapAttributes.getLdapAffiliation(), ldapAttributes.getLdapStudentAffiliation()));
	    String encode = filter.encode();   
	    if(logger.isInfoEnabled()){
	    	logger.info(" le filtre ldap " + encode);
	    }

	   encode=encode.substring(1, encode.length()-1);
	   List<LdapUser> etudiantsDansLdap=null;
		try {
	   etudiantsDansLdap = ldapUserService.getLdapUsersFromFilter(encode);
		}
		catch (LdapException ldae) {
	    	   errorldap(ldae,"getLdapUsersFromFilter");
		}
		List<EtudiantRef> etudiants = null;
		EtudiantRef etudiantRef =null;
		if(!etudiantsDansLdap.isEmpty()){
			etudiants = new ArrayList<EtudiantRef>(etudiantsDansLdap.size());
			etudiantRef = new EtudiantRef();
			for(LdapUser user : etudiantsDansLdap){	  
		           etudiantRef.setCodeUniversite(universityCode);
				   etudiants.add(etudiantFormate(etudiantRef, user));
				   }


		}




	   return etudiants;
	}
	 */
}
