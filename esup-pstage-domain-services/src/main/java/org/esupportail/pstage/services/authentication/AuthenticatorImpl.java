/**
 * ESUP-Portail Helpdesk - Copyright (c) 2004-2008 ESUP-Portail consortium.
 */
package org.esupportail.pstage.services.authentication; 

import java.io.Serializable;

import org.esupportail.commons.services.authentication.AuthUtils;
import org.esupportail.commons.services.authentication.AuthenticationService;
import org.esupportail.commons.services.authentication.info.AuthInfo;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.utils.Assert;
import org.esupportail.commons.utils.ContextUtils;
import org.esupportail.pstage.domain.DomainService;
import org.esupportail.pstage.domain.beans.User;
import org.springframework.beans.factory.InitializingBean;

/**
 * A basic authenticator implementation.
 */
public class AuthenticatorImpl implements Serializable, InitializingBean, Authenticator {

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 6382142726147456592L;

	/**
	 * The session attribute to store the auth info.
	 */
	private static final String AUTH_INFO_ATTRIBUTE = AuthenticatorImpl.class.getName() + ".authInfo";
	
	/**
	 * The session attribute to store the user.
	 */
	private static final String USER_ATTRIBUTE = AuthenticatorImpl.class.getName() + ".user";
	
	/**
	 * A logger.
	 */
	private final Logger logger = new LoggerImpl(getClass());
	
	/**
	 * The external authenticator.
	 */
	private AuthenticationService authenticationService;
	
	/**
	 * The domain authenticator.
	 */
	private DomainService domainService;
	
	/**
	 * Bean constructor.
	 */
	public AuthenticatorImpl() {
		super();
	}

	/**
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() {
		Assert.notNull(authenticationService, 
				"property authenticationService of class " + this.getClass().getName() 
				+ " can not be null");
	}

	/**
	 * @see org.esupportail.pstage.services.authentication.Authenticator#getUser()
	 */
	public User getUser() {
		AuthInfo authInfo = (AuthInfo) ContextUtils.getSessionAttribute(AUTH_INFO_ATTRIBUTE);
		if (authInfo != null) {
			User user = (User) ContextUtils.getSessionAttribute(USER_ATTRIBUTE);
			if (logger.isDebugEnabled()) {
				logger.debug("found auth info in session: " + user);
			}
			return user;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("no auth info found in session");
		}
		authInfo = authenticationService.getAuthInfo();
		if (authInfo == null) {
			return null;
		}
		if (AuthUtils.CAS.equals(authInfo.getType())) {
			User user = getDomainService().getUser(authInfo.getId());
			storeToSession(authInfo, user);
			return user;
		} 
		return null;
	}

	/**
	 * Store the authentication information to the session.
	 * @param authInfo
	 * @param user
	 */
	protected void storeToSession(
			final AuthInfo authInfo,
			final User user) {
		if (logger.isDebugEnabled()) {
			logger.debug("storing to session: " + authInfo);
		}
		ContextUtils.setSessionAttribute(AUTH_INFO_ATTRIBUTE, authInfo);
		ContextUtils.setSessionAttribute(USER_ATTRIBUTE, user);
	}

	/**
	 * @param authenticationService the authenticationService to set
	 */
	public void setAuthenticationService(
			final AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	/**
	 * @return the authenticationService
	 */
	protected AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	/**
	 * @return the domainService
	 */
	protected DomainService getDomainService() {
		return domainService;
	}

	/**
	 * @param domainService the domainService to set
	 */
	public void setDomainService(final DomainService domainService) {
		this.domainService = domainService;
	}

}
