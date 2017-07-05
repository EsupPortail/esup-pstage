package org.esupportail.pstage.dao.referentiel.ldap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import net.sf.ehcache.CacheManager;

import org.esupportail.commons.exceptions.GroupNotFoundException;
import org.esupportail.commons.exceptions.ObjectNotFoundException;
import org.esupportail.commons.services.i18n.I18nService;
import org.esupportail.commons.services.ldap.LdapException;
import org.esupportail.commons.services.ldap.LdapGroup;
import org.esupportail.commons.services.ldap.LdapGroupImpl;
import org.esupportail.commons.services.ldap.LdapGroupService;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.utils.Assert;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.Filter;
import org.springframework.ldap.filter.WhitespaceWildcardsFilter;
import org.springframework.util.StringUtils;

@SuppressWarnings("serial")
public class ComposanteSearchableLdapServiceImpl  implements LdapGroupService, InitializingBean, Serializable{
	/**
	 * The default unique attribute.
	 */
	private static final String DEFAULT_ID_ATTRIBUTE = "gid";

	/**
	 * The default object class.
	 */
	private static final String DEFAULT_OBJECT_CLASS = "Group";

	/**
	 * A logger.
	 */
	private final transient Logger logger = new LoggerImpl(getClass());

	/**
	 * The real LDAP entity service to delegate.
	 */
	private ComposanteCachingLdapEntityServiceImpl service;

	/**
	 * The attribute used by method getLdapGroupsFromToken().
	 */
	private String searchAttribute;

	/**
	 * The attributes that will be shown when searching for a group.
	 */
	private List<String> searchDisplayedAttributes;
	
	/**
	 * Bean constructor.
	 */
	public ComposanteSearchableLdapServiceImpl() {
		super();
		service = new ComposanteCachingLdapEntityServiceImpl();
		service.setIdAttribute(DEFAULT_ID_ATTRIBUTE);
		service.setObjectClass(DEFAULT_OBJECT_CLASS);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (searchAttribute == null) {
			logger.info("property searchAttribute is not set, method getLdapGroupsFromToken() will fail");
		} else {
			Assert.notEmpty(searchDisplayedAttributes, "property searchDisplayedAttribute is not set");
		}
		service.afterPropertiesSet();
	}

	
	
	@Override
	public LdapGroup getLdapGroup(String id) throws LdapException,
			GroupNotFoundException {
		try {
			return LdapGroupImpl.createLdapGroup(service.getLdapEntity(id));
			
		} catch (ObjectNotFoundException e) {
			throw new GroupNotFoundException(e);
		}
	}

	@Override
	public List<LdapGroup> getLdapGroupsFromFilter(String filterExpr)
			throws LdapException {
		return LdapGroupImpl.createLdapGroups(service.getLdapEntitiesFromFilter(filterExpr));
	}

	@Override
	public List<LdapGroup> getLdapGroupsFromToken(String token)
			throws LdapException {
		Filter filter = new WhitespaceWildcardsFilter(searchAttribute, token);
		return getLdapGroupsFromFilter(filter.encode());
	}
	

	@Override
	public boolean groupMatchesFilter(String id, String filter)
			throws LdapException {
		return service.entityMatchesFilter(id, filter);
	}
	
	@Override
	public List<String> getStatistics(Locale locale) {
		return service.getStatistics(locale);
	}
	
	@Override
	public void resetStatistics() {
		service.resetStatistics();
		
	}
	
	/**
	 * Set the cache manager.
	 * @param cacheManager
	 */
	public void setCacheManager(final CacheManager cacheManager) {
		service.setCacheManager(cacheManager);
	}

	/**
	 * Set the cache name.
	 * @param cacheName
	 */
	public void setCacheName(final String cacheName) {
		service.setCacheName(cacheName);
	}

	
	/** Set the dnSubPath.
	 * @param dnSubPath
	 */
	public void setDnSubPath(final String dnSubPath) {
		service.setDnSubPath(dnSubPath);
	}

	/**
	 * Set the i18nService.
	 * @param i18nService
	 */
	public void setI18nService(final I18nService i18nService) {
		service.setI18nService(i18nService);
	}

	/**
	 * Set the idAttribute.
	 * @param idAttribute
	 */
	public void setIdAttribute(final String idAttribute) {
		service.setIdAttribute(idAttribute);
	}
	
	/**
	 * Set the attributes.
	 * @param attributes
	 */
	public void setAttributes(final List<String> attributes) {
		service.setAttributes(attributes);
	}

	/**
	 * Set the ldapTemplate.
	 * @param ldapTemplate
	 */
	public void setLdapTemplate(final LdapTemplate ldapTemplate) {
		service.setLdapTemplate(ldapTemplate);
	}
	
	/**
	 * Set the objectClass.
	 * @param objectClass
	 */
	public void setObjectClass(final String objectClass) {
		service.setObjectClass(objectClass);
	}

	/**
	 * Set the testFilter.
	 * @param testFilter
	 */
	public void setTestFilter(final String testFilter) {
		service.setTestFilter(testFilter);
	}
	

	/**
	 * @see org.esupportail.commons.services.ldap.BasicLdapService#supportStatistics()
	 */
	public boolean supportStatistics() {
		return service.supportStatistics();
	}

	/**
	 * @see org.esupportail.commons.services.ldap.BasicLdapService#supportsTest()
	 */
	public boolean supportsTest() {
		return service.supportsTest();
	}
	
	/**
	 * @see org.esupportail.commons.services.ldap.BasicLdapService#test()
	 */
	public void test() {
		service.test();
	}

	/**
	 * @see org.esupportail.commons.services.ldap.BasicLdapService#testLdapFilter(java.lang.String)
	 */
	public String testLdapFilter(final String filterExpr) throws LdapException {
		return service.testLdapFilter(filterExpr);
	}
	
	
	
	/**
	 * @see org.esupportail.commons.services.ldap.LdapGroupService#getSearchDisplayedAttributes()
	 */
	public List<String> getSearchDisplayedAttributes() {
		return searchDisplayedAttributes;
	}
	
	/**
	 * @param searchDisplayedAttributes the searchDisplayedAttributes to set
	 */
	public void setSearchDisplayedAttributes(final List<String> searchDisplayedAttributes) {
		this.searchDisplayedAttributes = searchDisplayedAttributes;
	}

	/**
	 * @param searchAttribute the searchAttribute to set
	 */
	public void setSearchAttribute(final String searchAttribute) {
		this.searchAttribute = searchAttribute;
	}

	/**
	 * Set the attributes.
	 * @param attributes
	 */
	public void setAttributesAsString(final String attributes) {
		List<String> list = new ArrayList<String>();
		for (String attribute : attributes.split(",")) {
			if (StringUtils.hasText(attribute)) {
				if (!list.contains(attribute)) {
					list.add(attribute);
				}
			}
		}
		setAttributes(list);
	}

	/**
	 * @param searchDisplayedAttributes the searchDisplayedAttributes to set
	 */
	public void setSearchDisplayedAttributesAsString(final String searchDisplayedAttributes) {
		List<String> list = new ArrayList<String>();
		for (String attribute : searchDisplayedAttributes.split(",")) {
			if (StringUtils.hasText(attribute)) {
				if (!list.contains(attribute)) {
					list.add(attribute);
				}
			}
		}
		setSearchDisplayedAttributes(list);
	}

	
}
