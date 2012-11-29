/**
 * ESUP-Portail Example Application - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-example
 */
package org.esupportail.pstage.web.deepLinking;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.esupportail.commons.utils.Assert;
import org.esupportail.commons.web.deepLinking.AbstractDeepLinkingRedirector;
import org.esupportail.pstage.web.controllers.RechercheController;
import org.esupportail.pstage.web.controllers.SessionController;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class DeepLinkingRedirectorImpl extends AbstractDeepLinkingRedirector {
	
	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -4484064189163071618L;
	
	/**
	 * The session controller.
	 */
	private SessionController sessionController;
	/**
	 * Recherche controller
	 */
	private RechercheController rechercheController;
	
	/**
	 * Bean constructor.
	 */
	public DeepLinkingRedirectorImpl() {
		super();
	}

	/**
	 * @see org.esupportail.commons.beans.AbstractI18nAwareBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		Assert.notNull(this.sessionController, "property sessionController of class " 
				+ this.getClass().getName() + " can not be null");
		Assert.notNull(this.rechercheController, "property rechercheController of class " 
				+ this.getClass().getName() + " can not be null");
	}
	
	/**
	 * @see org.esupportail.commons.web.deepLinking.DeepLinkingRedirector#redirect(java.util.Map)
	 */
	public String redirect(
			final Map<String, String> params) {
		sessionController.resetSessionLocale();
		String retour="";
		// Premier accès, redirection vers le bon dossier
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		StringBuffer url = req.getRequestURL();
		if(url.toString().contains("/depot/")){
			retour=url.substring(url.indexOf("/stylesheets"));
		}
		if(url.toString().contains("/depotAnonyme/")){
			retour=url.substring(url.indexOf("/stylesheets"));
		}
		if(url.toString().contains("/stage/")){
			retour=url.substring(url.indexOf("/stylesheets"));
		}
		if(url.toString().contains("/recherche/")){
			retour=url.substring(url.indexOf("/stylesheets"));
		}
		
		/* ******************************************************
		 * Gestion des paramètres
		 *******************************************************/
		
		//Moteur de recherche établissement
		if(params!=null){
//			if(params.containsKey("ongletRecherche")){
//				int ongletRecherche=0;
//				String ongletRechercheParam = params.get("ongletRecherche");
//				if(Utils.isNumber(ongletRechercheParam)){
//					ongletRecherche=Integer.parseInt(ongletRechercheParam);
//					if(ongletRecherche>0){
//						switch (ongletRecherche) {
//						case 1:
//							this.rechercheController.goToOngletSiret();
//							break;
//						case 2:
//							this.rechercheController.goToOngletRaisonSociale();
//							break;
//						case 3:
//							this.rechercheController.goToOngletActivite();
//							break;
//						case 4:
//							this.rechercheController.goToOngletTelFax();
//							break;
//						case 5:
//							this.rechercheController.goToOngletService();
//							break;
//						case 6:
//							this.rechercheController.goToOngletAccord();
//							break;
//						default:
//							this.rechercheController.goToOngletRaisonSociale();
//							break;
//						}
//					}
//				}
//			}
		}
		return retour;
	}

	/**
	 * @param sessionController the sessionController to set
	 */
	public void setSessionController(final SessionController sessionController) {
		this.sessionController = sessionController;
	}

	/**
	 * @param rechercheController the rechercheController to set
	 */
	public void setRechercheController(RechercheController rechercheController) {
		this.rechercheController = rechercheController;
	}

}
