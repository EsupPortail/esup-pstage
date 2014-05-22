/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.pstage.domain.beans.User;

/**
 * A bean to manage user preferences.
 */
public class PreferencesController extends AbstractContextAwareController {

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 2503649603430502319L;

	/**
	 * A logger.
	 */
	private final Logger logger = new LoggerImpl(this.getClass());
	
	/**
	 * A list of JSF components for the locales.
	 */
	private List<SelectItem> localeItems;

	/**
	 * Bean constructor.
	 */
	public PreferencesController() {
		super();
	}
	
	/**
	 * JSF callback.
	 * @return A String.
	 */
	public String enter() {
		if (!isPageAuthorized()) {
			addUnauthorizedActionMessage();
			return null;
		}
		return "navigationPreferences";
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + hashCode();
	}

	/**
	 * @return true if the current user is allowed to view the page.
	 */
	public boolean isPageAuthorized() {
		return getCurrentUser() != null;
	}

	/**
	 * @return the localeItems
	 */
	public List<SelectItem> getLocaleItems() {
		if (localeItems == null) {
			localeItems = new ArrayList<SelectItem>();
			Iterator<Locale> iter = 
				FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
			while (iter.hasNext()) {
				Locale locale = iter.next();
				StringBuffer buf = new StringBuffer(locale.getLanguage());
				buf.append(" - ").append(locale.getDisplayLanguage(locale));
				localeItems.add(new SelectItem(locale, buf.toString()));
			}
		}
		return localeItems;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(final Locale locale) {
		User currentUser = getCurrentUser();
		if (currentUser == null) {
			// store in the session
			setSessionLocale(locale);
		} else {
			// update the current user
			if (logger.isDebugEnabled()) {
				logger.debug("set language [" + locale + "] for user '" + currentUser.getId() + "'");
			}
			currentUser.setLanguage(locale.toString());
			getSessionController().resetSessionLocale();
			addInfoMessage(null, "PREFERENCES.MESSAGE.UPDATED");
		}
	}
	
}
