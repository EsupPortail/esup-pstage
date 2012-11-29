package org.esupportail.pstage.security.providers.preauth.shibboleth;

import org.esupportail.pstage.security.ui.preauth.shibboleth.ShibbolethGrantedAuthoritiesWebAuthenticationDetails;
import org.esupportail.pstage.security.userdetails.shibboleth.ShibbolethUser;
import org.springframework.util.Assert;


/**
 * Service that create ShibbolethUser.
 * 
 * @author Adrien Colson
 */
public class ShibbolethGrantedAuthoritiesUserDetailsService extends
		PreAuthenticatedGrantedAuthoritiesUserDetailsService {

	/**
	 * @see org.springframework.security.providers.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService#createuserDetails(org.springframework.security.Authentication,
	 *      org.springframework.security.GrantedAuthority[])
	 */
	@Override
	protected UserDetails createuserDetails(Authentication token, GrantedAuthority[] authorities) {
		Assert.isInstanceOf(ShibbolethGrantedAuthoritiesWebAuthenticationDetails.class, token.getDetails());
		ShibbolethGrantedAuthoritiesWebAuthenticationDetails details = (ShibbolethGrantedAuthoritiesWebAuthenticationDetails) token
				.getDetails();
		return new ShibbolethUser(token.getName(), "N/A", true, true, true, true, details.getGrantedAuthorities(),
				details.getShibAttributes());
	}

}
