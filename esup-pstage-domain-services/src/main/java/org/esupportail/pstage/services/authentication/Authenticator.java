package org.esupportail.pstage.services.authentication;

import org.esupportail.pstage.domain.beans.User;

/**
 * The interface of authenticators.
 */
public interface Authenticator {

	/**
	 * @return the authenticated user.
	 */
	User getUser();

}