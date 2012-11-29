package org.esupportail.pstage.security.userdetails.shibboleth;

import java.util.Map;
import java.util.Map.Entry;

import org.esupportail.pstage.domain.beans.User;

/**
 * User with Shibboleth attributes.
 * 
 * @author Adrien Colson
 */
public class ShibbolethUser extends User {

	/**
	 * Serialization id.
	 */
	private static final long serialVersionUID = 6850079157036241519L;

	/**
	 * Shibboleth Attributes.
	 */
	private Map<String, String> shibAttributes;

	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 * @param shibAttributes
	 * @throws IllegalArgumentException
	 */
	public ShibbolethUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, GrantedAuthority[] authorities,
			Map<String, String> shibAttributes) throws IllegalArgumentException {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.shibAttributes = shibAttributes;
	}

	/**
	 * @return the shibAttributes
	 */
	public Map<String, String> getShibAttributes() {
		return shibAttributes;
	}

	/**
	 * @param shibAttributes
	 *            the shibAttributes to set
	 */
	public void setShibAttributes(Map<String, String> shibAttributes) {
		this.shibAttributes = shibAttributes;
	}

	/**
	 * @see org.springframework.security.userdetails.User#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(super.toString());
		sb.append("; ");

		if ((shibAttributes != null) && !shibAttributes.isEmpty()) {
			sb.append("Shibboleth Attributes: ");

			boolean firstAttribute = true;
			for (Entry<String, String> entry : shibAttributes.entrySet()) {
				if (firstAttribute) {
					firstAttribute = false;
				} else {
					sb.append(", ");
				}
				sb.append(entry.getKey()).append("=").append(entry.getValue());
			}
		} else {
			sb.append("Not any attribute");
		}

		return sb.toString();
	}

}
