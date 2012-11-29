package org.esupportail.pstage.security.ui.preauth.shibboleth;

import javax.servlet.http.HttpServletRequest;

/**
 * PreAuthenticated Processing Filter that accepts shibboleth users without
 * username.
 * 
 * @author Adrien Colson
 */
public class ShibbolethPreAuthenticatedProcessingFilter extends RequestHeaderPreAuthenticatedProcessingFilter {

	/**
	 * @see org.springframework.security.ui.preauth.header.RequestHeaderPreAuthenticatedProcessingFilter#getPreAuthenticatedPrincipal(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {

		/*String principal;

		try {
			principal = (String) super.getPreAuthenticatedPrincipal(request);
		} catch (PreAuthenticatedCredentialsNotFoundException e) {
			principal = "N/A";
		}*/

		return request.getRemoteUser();
	}

}
