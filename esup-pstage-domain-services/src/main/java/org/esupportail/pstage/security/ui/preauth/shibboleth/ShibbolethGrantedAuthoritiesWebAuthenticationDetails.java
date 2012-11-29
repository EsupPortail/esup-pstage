package org.esupportail.pstage.security.ui.preauth.shibboleth;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * PreAuthenticated authentication details with Shibboleth attributes.
 * 
 * @author Adrien Colson
 */
public class ShibbolethGrantedAuthoritiesWebAuthenticationDetails extends
		PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails {

	/**
	 * Serialization id.
	 */
	private static final long serialVersionUID = -6151476110577717306L;

	/**
	 * Shibboleth attributes.
	 */
	private Map<String, String> shibAttributes;

	/**
	 * @param request
	 */
	public ShibbolethGrantedAuthoritiesWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
	}

	/**
	 * @return the shibAttributes
	 */
	public Map<String, String> getShibAttributes() {
		return shibAttributes;
	}

	/**
	 * @see org.springframework.security.ui.WebAuthenticationDetails#doPopulateAdditionalInformation(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected void doPopulateAdditionalInformation(HttpServletRequest request) {
		this.shibAttributes = mapShibAttributes(request);
	}

	/**
	 * @param request
	 * @return mapped Shibboleth attributes
	 */
	private Map<String, String> mapShibAttributes(HttpServletRequest request) {
		Map<String, String> shibAttributes = new HashMap<String, String>();

		@SuppressWarnings("unchecked")
		Enumeration requestHeaders = request.getHeaderNames();
		while (requestHeaders.hasMoreElements()) {
			String name = (String) requestHeaders.nextElement();
			if ((name.matches(".*Shib.*") || name.matches(".*shib.*")) && !name.equals("HTTP_SHIB_ATTRIBUTES")
					&& !name.equals("Shib-Attributes")) {
				shibAttributes.put(name, request.getHeader(name));
			}
		}

		return shibAttributes;
	}

}
