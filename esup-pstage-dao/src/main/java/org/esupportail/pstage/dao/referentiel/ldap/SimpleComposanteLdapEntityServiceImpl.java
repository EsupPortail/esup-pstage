package org.esupportail.pstage.dao.referentiel.ldap;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.naming.ServiceUnavailableException;
import javax.naming.directory.InvalidSearchFilterException;
import javax.naming.directory.SearchControls;

import org.esupportail.commons.exceptions.ObjectNotFoundException;
import org.esupportail.commons.services.exceptionHandling.ExceptionUtils;
import org.esupportail.commons.services.ldap.LdapBadFilterException;
import org.esupportail.commons.services.ldap.LdapConnectionException;
import org.esupportail.commons.services.ldap.LdapEntity;
import org.esupportail.commons.services.ldap.LdapEntityService;
import org.esupportail.commons.services.ldap.LdapException;
import org.esupportail.commons.services.ldap.LdapMiscException;
import org.esupportail.commons.services.ldap.StringFilter;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.utils.Assert;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.ldap.BadLdapGrammarException;
import org.springframework.ldap.UncategorizedLdapException;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.util.StringUtils;

public class SimpleComposanteLdapEntityServiceImpl  implements LdapEntityService, InitializingBean {
	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -441896567288193836L;

	/**
	 * The ObjectClass attribute.
	 */
	@SuppressWarnings("unused")
	private static final String OBJECT_CLASS_ATTRIBUTE = "objectClass";

	/**
	 * A logger.
	 */
	private final transient Logger logger = new LoggerImpl(getClass());

	/**
	 * A LdapTemplate instance, to perform LDAP operations.
	 */
	private LdapTemplate ldapTemplate;

	/**
	 * The value of the objectClass attribute when searching entities.
	 */
	private String objectClass;

	/**
	 * The name of the attribute that contains the unique id.
	 */
	private String idAttribute;

	/**
	 * The DN sub path.
	 */
	private String dnSubPath;

	/**
	 * The names of the attributes to retrieve.
	 */
	private List<String> attributes;

	/**
	 * The attributes mapper.
	 */
	private LdapComposanteAttributesMapper  attributesMapper;

	/**
	 * The test filter.
	 */
	private String testFilter;

	/**
	 * The exception thrown when the statistics methods are called.
	 */
	private final UnsupportedOperationException unsupportedExcepion = 
			new UnsupportedOperationException("class " + getClass() + " does not support statistics.");


	/**
	 * Bean constructor.
	 */
	public SimpleComposanteLdapEntityServiceImpl() {
		super();
	}

	/**
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() {
		Assert.notNull(ldapTemplate,
				"property ldapTemplate of class " + getClass().getName() + " can not be null");
		Assert.hasText(idAttribute,
				"property idAttribute of class " + getClass().getName() + " can not be null");
		Assert.notEmpty(attributes,
				"property attributes of class " + getClass().getName() + " can not be empty");
		Assert.hasText(objectClass,
				"property objectClass of class " + getClass().getName() + " can not be empty");
		if (!StringUtils.hasText(dnSubPath)) {
			dnSubPath = null;
			logger.info(getClass() + ": property dnSubPath is not set");
		}
		if (testFilter == null) {
			logger.info(getClass() + ": property testFilter is not set, target ldap-test will not work.");
		}
		//	Assert.notNull(attributesMapper, "should not be null");
		/*if (!attributes.contains(idAttribute)) {
			attributes.add(idAttribute);
		}
		 */

		attributesMapper = new LdapComposanteAttributesMapper(attributes);

	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + hashCode() + "["
				+ "objectClass=[" + objectClass + "], "
				+ "idAttribute=[" + idAttribute + "], "
				+ "dnSubPath=[" + dnSubPath + "], "
				+ "attributes=[" + attributes + "], "
				+ "testFilter=[" + testFilter + "]"
				+ "]";
	}

	/**
	 * Wrap an exception into a LdapException.
	 * @param message
	 * @param filterExpr
	 * @param e
	 * @return a LdapException
	 * @throws LdapException
	 */
	private LdapException wrapException(
			final String message,
			final String filterExpr,
			final Exception e) throws LdapException {
		if (e instanceof DataRetrievalFailureException) {
			return new LdapConnectionException(message, e);
		}
		if (e instanceof BadLdapGrammarException) {
			if (e.getCause() instanceof InvalidSearchFilterException) {
				return new LdapBadFilterException(
						message + ": bad filter [" + filterExpr + "]: "
								+ e.getCause().getMessage(), (Exception) e.getCause());
			}
		}
		if (e instanceof InvalidSearchFilterException) {
			return new LdapBadFilterException(message + ": " + e.getMessage(), e);
		}
		return new LdapMiscException(message + ": " + e.getMessage(), e);
	}

	/**
	 * @param filter
	 * @param retry
	 * @return the LDAP entities that correspond to a filter.
	 * @throws LdapException
	 */
	@SuppressWarnings({ "cast", "unchecked" })
	private List<LdapEntity> getLdapEntitiesFromFilter(
			final Filter filter,
			final boolean retry) throws LdapException {
		Exception ex = null;
		DistinguishedName dn;
		if (dnSubPath == null) {
			dn = new DistinguishedName();
		} else {
			dn = new DistinguishedName(dnSubPath);
		}
		AndFilter theFilter = new AndFilter();
		//theFilter.and(new EqualsFilter(OBJECT_CLASS_ATTRIBUTE, objectClass));
		theFilter.and(filter);
		try {
			List<String> attrsList = attributesMapper.getAttributes();
			String[] attrs = attrsList.toArray(new String[attrsList.size()]);

			List<LdapEntity> searchListe = (List<LdapEntity>)ldapTemplate.search(dn, theFilter.encode(), SearchControls.SUBTREE_SCOPE, attrs, attributesMapper);
			return searchListe;

		} catch (UncategorizedLdapException e) {
			if (e.getCause() != null && e.getCause() instanceof ServiceUnavailableException && retry) {
				ExceptionUtils.catchException(wrapException(
						"could not retrieve entities from the LDAP directory",
						filter.encode(), e));
				return getLdapEntitiesFromFilter(filter, false);
			}
			ex = e;
		} catch (DataAccessException e) {
			ex = e;
		}
		throw wrapException("could not retrieve entities from the LDAP directory", filter.encode(), ex);
	}


	/**
	 * @param filter
	 * @return the LDAP entities that correspond to a filter.
	 * @throws LdapException
	 */
	protected List<LdapEntity> getLdapEntitiesFromFilter(final Filter filter) throws LdapException {
		return getLdapEntitiesFromFilter(filter, true);
	}

	/**
	 * @see org.esupportail.commons.services.ldap.LdapEntityService#getLdapEntitiesFromFilter(java.lang.String)
	 */
	public List<LdapEntity> getLdapEntitiesFromFilter(final String filterExpr) throws LdapException {
		return getLdapEntitiesFromFilter(new StringFilter(filterExpr));
	}

	/**
	 * @see org.esupportail.commons.services.ldap.LdapEntityService#testLdapFilter(java.lang.String)
	 */
	public String testLdapFilter(final String filterExpr) throws LdapException {
		try {
			getLdapEntitiesFromFilter(new StringFilter(filterExpr));
			return null;
		} catch (LdapBadFilterException e) {
			return e.getMessage();
		}
	}

	/**
	 * @see org.esupportail.commons.services.ldap.LdapEntityService#getLdapEntity(java.lang.String)
	 */
	public LdapEntity getLdapEntity(final String id) throws LdapException, ObjectNotFoundException {
		List<LdapEntity> ldapEntities = getLdapEntitiesFromFilter(new EqualsFilter(idAttribute, id));
		if (ldapEntities.isEmpty()) {
			throw new ObjectNotFoundException("No LDAP entry found for entity [" + id + "]");
		} else if (ldapEntities.size() > 1) {
			throw new ObjectNotFoundException("Too many LDAP entries found for entity [" + id + "]");
		} else {
			return ldapEntities.get(0);
		}
	}

	/**
	 * @see org.esupportail.commons.services.ldap.LdapEntityService#entityMatchesFilter(
	 * java.lang.String, java.lang.String)
	 */
	public boolean entityMatchesFilter(final String id, final String filterExpr) throws LdapException {
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter(idAttribute, id));
		filter.and(new StringFilter(filterExpr));
		return !(getLdapEntitiesFromFilter(filter).isEmpty());
	}

	/**
	 * @see org.esupportail.commons.services.ldap.AbstractLdapService#supportsTest()
	 */
	@Override
	public boolean supportsTest() {
		return true;
	}

	/**
	 * @see org.esupportail.commons.services.ldap.AbstractLdapService#test()
	 */
	@Override
	public void test() {
		if (testFilter == null) {
			logger.error("can not test the LDAP connection when property testFilter is not set, "
					+ "edit configuration file ldap.xml.");
			return;
		}
		List<LdapEntity> ldapEntities;
		try {
			ldapEntities = getLdapEntitiesFromFilter(testFilter);
		} catch (LdapBadFilterException e) {
			logger.warn("bad LDAP filter [" + testFilter + "], edit configuration file ldap.xml: "
					+ e.getCause().getMessage());
			return;
		} catch (LdapConnectionException e) {
			logger.warn("could not connect to LDAP, edit configuration file ldap.xml: "
					+ e.getCause().getMessage());
			return;
		} catch (LdapException e) {
			logger.warn("LDAP error, edit configuration file ldap.xml: " + e.getCause().getMessage());
			return;
		}
		if (ldapEntities.isEmpty()) {
			logger.warn("no entity retrieved for filter [" + testFilter + "]");
		} else {
			logger.warn(ldapEntities.size() + " entity(ies) retrieved for filter [" + testFilter + "]:");
			for (LdapEntity ldapEntity : ldapEntities) {
				logger.warn(" - " + ldapEntity.getId() + ":");
				Map<String, List<String>> attrNames = ldapEntity.getAttributes();
				for (String attributeName : ldapEntity.getAttributeNames()) {
					String str = "   * " + attributeName + " = ";
					List<String> attrs = attrNames.get(attributeName);
					if (attrs.size() == 1) {
						str += attrs.get(0);
					} else {
						str += "{";
						String separator = "";
						for (String attr : attrs) {
							str += separator + attr;
							separator = ", ";
						}
						str += "}";
					}
					logger.warn(str);
				}
			}
		}
	}

	/**
	 * @param ldapTemplate the ldapTemplate to set
	 */
	public void setLdapTemplate(final LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	/**
	 * @param testFilter the testFilter to set
	 */
	public void setTestFilter(final String testFilter) {
		this.testFilter = testFilter;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(final List<String> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @param idAttribute the idAttribute to set
	 */
	public void setIdAttribute(final String idAttribute) {
		this.idAttribute = idAttribute;
	}

	/**
	 * @param objectClass the objectClass to set
	 */
	public void setObjectClass(final String objectClass) {
		this.objectClass = objectClass;
	}

	/**
	 * @param dnSubPath the dnSubPath to set
	 */
	public void setDnSubPath(final String dnSubPath) {
		this.dnSubPath = dnSubPath;
	}

	/**
	 * @return the idAttribute
	 */
	public String getIdAttribute() {
		return idAttribute;
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



	@Override
	public List<String> getStatistics(Locale locale) {
		throw unsupportedExcepion;
	}

	@Override
	public void resetStatistics() {
		throw unsupportedExcepion;
	}

	@Override
	public boolean supportStatistics() {
		throw unsupportedExcepion;
	}




}
