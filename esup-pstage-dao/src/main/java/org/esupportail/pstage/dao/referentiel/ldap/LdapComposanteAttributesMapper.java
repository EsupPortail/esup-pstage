package org.esupportail.pstage.dao.referentiel.ldap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.esupportail.commons.services.ldap.LdapGroupImpl;
import org.springframework.ldap.core.AttributesMapper;

public class LdapComposanteAttributesMapper  implements AttributesMapper, Serializable {

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 9222929097200132160L;

	/**
	 * The attributes.
	 */
	private List<String> attributes;

	/**
	 * The name of the attirbute that contains the uid.
	 */
	@SuppressWarnings("unused")
	private String uidAttribute;


	/**
	 * Bean constructor.
	 * @param uidAttribute
	 * @param attributes
	 */
	public LdapComposanteAttributesMapper(
			final String uidAttribute,
			final List<String> attributes) {
		this.uidAttribute = uidAttribute;
		this.attributes = attributes;
	}
	public LdapComposanteAttributesMapper(List<String> attributes) {
		super();
		this.attributes = attributes;
	}
	/**
	 * @return the attributes names
	 */
	public List<String> getAttributes() {
		return attributes;
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object mapFromAttributes(final Attributes attrs) throws NamingException {

		LdapGroupImpl ldapGroup = new LdapGroupImpl();

		for (String ldapAttributeName : attributes) {
			Attribute attribute = attrs.get(ldapAttributeName);
			List<String> listAttr = new ArrayList<String>();
			// The attribute exists
			if (attribute != null) {
				NamingEnumeration<Object> attrValueEnum = (NamingEnumeration<Object>) attribute.getAll();
				while (attrValueEnum.hasMore()) {
					Object attributeValue = attrValueEnum.next();
					// Convert everything except byte[] to String
					if (!(attributeValue instanceof byte[])) {
						attributeValue = attributeValue.toString();
						listAttr.add(attributeValue.toString());
					}
				}
				Set attributeNames = Collections.singleton(ldapAttributeName);
				// Run through the mapped attribute names
				for (Iterator attrNameItr = attributeNames .iterator(); attrNameItr.hasNext();) {
					String attributeName = (String) attrNameItr .next();
					ldapGroup.getAttributes().put(attributeName.toString(), listAttr);
				}
			}
		}
		return ldapGroup;
	}



}
