/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.util.Locale;

import org.esupportail.commons.beans.AbstractApplicationAwareBean;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.utils.Assert;
import org.esupportail.commons.web.controllers.Resettable;
import org.esupportail.pstage.domain.DomainService;
import org.esupportail.pstage.domain.beans.User;

/**
 * An abstract class inherited by all the beans for them to get:
 * - the domain service (domainService).
 * - the application service (applicationService).
 * - the i18n service (i18nService).
 */
public abstract class AbstractDomainAwareBean extends AbstractApplicationAwareBean implements Resettable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A logger.
	 */
	private final Logger logger = new LoggerImpl(this.getClass());
	
	/**
	 * see {@link DomainService}.
	 */
	private DomainService domainService;
	
	/**
	 * Constructor.
	 */
	protected AbstractDomainAwareBean() {
		super();
	}

	/**
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public final void afterPropertiesSet() {
		super.afterPropertiesSet(); 
		Assert.notNull(this.domainService, 
				"property domainService of class " + this.getClass().getName() + " can not be null");
		afterPropertiesSetInternal();
		reset();
	}

	/**
	 * This method is run once the object has been initialized, just before reset().
	 */
	protected void afterPropertiesSetInternal() {
		// override this method
	}
	
	/**
	 * @see org.esupportail.commons.web.controllers.Resettable#reset()
	 */
	public void reset() {
		// nothing to reset
		
	}

	/**
	 * @param domainService the domainService to set
	 */
	public void setDomainService(final DomainService domainService) {
		this.domainService = domainService;
	}

	/**
	 * @return the domainService
	 */
	public DomainService getDomainService() {
		return domainService;
	}

	/**
	 * @return the current user.
	 */
	protected User getCurrentUser() {
		// this method should be overriden
		return null;
	}

	/**
	 * @return the current user's locale.
	 */
	@Override
	public Locale getCurrentUserLocale() {
		if (logger.isDebugEnabled()) {
			logger.debug(this.getClass().getName() + ".getCurrentUserLocale()");
		}
		User currentUser = getCurrentUser();
		if (currentUser == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("no current user, return null");
			}
			return null;
		}
		String lang = currentUser.getLanguage();
		if (lang == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("language not set for user '" + currentUser.getId() 
						+ "', return null");
			}
			return null;
		}
		Locale locale = new Locale(lang);
		if (logger.isDebugEnabled()) {
			logger.debug("language for user '" + currentUser.getId() + "' is '" + locale + "'");
		}
		return locale;
	}
}
