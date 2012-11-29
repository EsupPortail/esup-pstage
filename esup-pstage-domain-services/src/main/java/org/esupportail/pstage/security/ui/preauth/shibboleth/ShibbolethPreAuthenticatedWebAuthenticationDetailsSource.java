package org.esupportail.pstage.security.ui.preauth.shibboleth;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;


/**
 * Implementation of AuthenticationDetailsSource which builds the details object
 * and its authorities from an HttpServletRequest object.
 * 
 * @author Adrien Colson
 */
public class ShibbolethPreAuthenticatedWebAuthenticationDetailsSource implements AuthenticationDetailsSource {

	/**
	 * Default multi-valued attributes splitter.
	 */
	private static final String ATTRIBUTES_SPLITTER = ";";

	/**
	 * Multi-valued attributes splitter.
	 */
	private String attributesSplitter = ATTRIBUTES_SPLITTER;

	/**
	 * Shibboleth authorities attribute name.
	 */
	private String authoritiesAttribute;

	/**
	 * @param attributesSplitter
	 *            the attributesSplitter to set
	 */
	public void setAttributesSplitter(String attributesSplitter) {
		this.attributesSplitter = attributesSplitter;
	}

	/**
	 * @param authoritiesAttribute
	 *            the authoritiesAttribute to set
	 */
	public void setAuthoritiesAttribute(String authoritiesAttribute) {
		this.authoritiesAttribute = authoritiesAttribute;
	}

	/**
	 * @see org.springframework.security.ui.AuthenticationDetailsSource#buildDetails(java.lang.Object)
	 */
	public Object buildDetails(Object context) {
		Assert.isInstanceOf(HttpServletRequest.class, context);
		HttpServletRequest request = (HttpServletRequest) context;

		ShibbolethGrantedAuthoritiesWebAuthenticationDetails details = new ShibbolethGrantedAuthoritiesWebAuthenticationDetails(
				request);
		details.setGrantedAuthorities(retrieveAuthorities(request));

		return details;
	}

	/**
	 * @param request
	 * @return authorities
	 */
	private GrantedAuthority[] retrieveAuthorities(HttpServletRequest request) {
		if (authoritiesAttribute != null) {
			List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>();
			String authoritiesString = request.getHeader(authoritiesAttribute);
			if (authoritiesString != null) {
				for (String authority : authoritiesString.split(attributesSplitter)) {
					if (authority.length()>0) {
						authoritiesList.add(new GrantedAuthorityImpl(authority));
					}
				}
			}

			if (!authoritiesList.isEmpty()) {
				return (GrantedAuthority[]) authoritiesList.toArray(new GrantedAuthority[] {});
			}
		}

		return new GrantedAuthority[] {};
	}
}
