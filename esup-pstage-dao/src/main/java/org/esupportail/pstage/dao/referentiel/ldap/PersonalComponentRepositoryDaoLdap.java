package org.esupportail.pstage.dao.referentiel.ldap;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.esupportail.commons.services.ldap.LdapException;
import org.esupportail.commons.services.ldap.LdapGroup;
import org.esupportail.commons.services.ldap.LdapGroupService;
import org.esupportail.pstage.dao.referentiel.PersonalComponentRepositoryDao;
import org.esupportail.pstage.domain.beans.LdapGroupeAttributs;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.WhitespaceWildcardsFilter;

/**
 *  Acces des composantes pour du personnel avec Ldap

 *
 */
public class PersonalComponentRepositoryDaoLdap implements PersonalComponentRepositoryDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private static Logger logger = Logger.getLogger(PersonalComponentRepositoryDaoLdap.class);

	/**
	 * Service ldap 
	 */
	private LdapGroupService ldapGroupService;
	/**
	 * Attributs utilises dans les recherches, que soit pour composer  des filtres  ou
	 * pour recuperer dans identifiants ldap depuis le fichier de config
	 */
	private LdapGroupeAttributs ldapGroupeAttributs;

	/**
	 *  Retourne les codes de toutes les composantes de l'universite et leurs libelles
	 */
	@Override
	public Map<String, String> getComposantesRef(String universityCode) {

		Map<String, String> composantes=null ;
		List<LdapGroup> ldapGroups  = null;

		//ldapComposanteCode
		AndFilter filter = new AndFilter();
		WhitespaceWildcardsFilter espaceFiltre = new WhitespaceWildcardsFilter(ldapGroupeAttributs.getLdapComposanteCode(), " ");
		filter.and(espaceFiltre);
		String encode = filter.encode();   
		encode=encode.substring(1, encode.length()-1);
		if(logger.isInfoEnabled()){
			logger.info(" le filtre ldap " + encode);
		}

		try {
			ldapGroups = ldapGroupService.getLdapGroupsFromFilter(encode);

			if(!ldapGroups.isEmpty()){
				String compCode=null;
				String compLibelle =null;
				composantes = new LinkedHashMap<String, String>(ldapGroups.size());
				//on formate pour le map
				for(LdapGroup group : ldapGroups){
					compCode = group.getAttribute(ldapGroupeAttributs.getLdapComposanteCode());
					compLibelle = group.getAttribute(ldapGroupeAttributs.getLdapComposanteLibelle());
					composantes.put(compCode, compLibelle);
				}
			}
		} catch (LdapException ldae) {

			errorldap(ldae,"getLdapGroupsFromFilter");
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

//	@Override
//	public void afterPropertiesSet() throws Exception {
//		Assert.notNull(ldapGroupService,"La propriété ldapGroupService ne peut être null.");
//	}

}
