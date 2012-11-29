package org.esupportail.pstage.web.deepLinking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.el.MethodExpression;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

import org.esupportail.commons.exceptions.ConfigException;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.services.urlGeneration.AbstractUrlGenerator;
import org.esupportail.commons.services.urlGeneration.ServletUrlGeneratorImpl;
import org.esupportail.commons.utils.BeanUtils;
import org.esupportail.commons.web.tags.TagUtils;
import org.springframework.util.StringUtils;

/**
 * @author cleprous
 * TODO gere les exception.
 */
public class DeepLinkingPhaseListener implements PhaseListener {

	
	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -7429514681508723093L;


	/**
	 * A logger.
	 */
	private final Logger logger = new LoggerImpl(getClass());
	
	
	/**
	 * Constructor.
	 */
	public DeepLinkingPhaseListener() {
		super();
	}

	
	
	/**
	 * @see javax.faces.event.PhaseListener#afterPhase(javax.faces.event.PhaseEvent)
	 */
	public void afterPhase(@SuppressWarnings("unused") final PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 */
	public void beforePhase(final PhaseEvent event) {
		if (logger.isDebugEnabled()) {
			logger.debug("enterig  DeepLinkingPhaseListener::beforePhase = " + event);
		}
		FacesContext context = event.getFacesContext();
		HttpServletRequest httpRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			
			Map<String, String> params = getParams(httpRequest);
			if (logger.isDebugEnabled()) {
				logger.debug("params params  = " + params);
			}
			if (params != null) {
				UrlPatternDescriptor u = getUrlPatternDescriptor(params.keySet());
				if (logger.isDebugEnabled()) {
					logger.debug("UrlPatternDescriptor u  = " + u);
				}
				if (u != null) {
					//renvoie les paremetres de la methode execute
					Object[] param = getArgsMethod(params, u);
					MethodExpression method = context.getApplication()
						.getExpressionFactory().createMethodExpression(
								context.getELContext(),
								TagUtils.makeELExpression(
									u.getActionBinding().getAction()),
									u.getActionBinding().getReturns(),
									u.getActionBinding().getArgs());
					
					Object navRules = method.invoke(context.getELContext(), param);
					NavigationHandler navigation = context.getApplication().getNavigationHandler();
					// Redirection vers la page des erreurs
					if (StringUtils.hasText(u.getViewId())) {
						//si dans le bean un chaine est defini on l'utilise.
						//Elle est prioritaire
						navigation.handleNavigation(context, "", u.getViewId());
					} else if (navRules != null && navRules instanceof String) {
						navigation.handleNavigation(context, "", (String) navRules);
					} else {
						throw new ConfigException("une chaine de caractere pour la redirection "
								+ "doit Ãªtre dÃ©finis"
								+ " dans la propiÃ©tÃ© viewId ou "
								+ "dans le retour de la mÃ©thode appelÃ©e");
					}
					context.renderResponse();
					
				}
			}	
			
			
		} catch (Throwable t) {
			//TODO catch DeepLinkingPhaseListener::beforePhase
			logger.error(t);
		}
	}
	
	

	/**
	 * 
	 * @param params
	 * @return UrlPatternDescriptor
	 */
	private UrlPatternDescriptor getUrlPatternDescriptor(final Set<String> params) {
		List<UrlPatternDescriptor> list = getUrlDescriptor();
		if (list != null && !list.isEmpty()) {
			for (UrlPatternDescriptor u : list) {
				if (u.isParamsContains(params)) {
					return u;
				}
			}
		}
		return null;
	}
	
	
	/**
	 * renvoie les arguments de la mÃ©thode qui va Ãªtre execute.
	 * Les valeurs de ces arguments sont dans les parametres de l'url. 
	 * TODO a revoir reflechir Ã  une meilleur solution.
	 * @param params
	 * @param u
	 * @return Object[]
	 */
	private Object[] getArgsMethod(final Map<String, String> params, final UrlPatternDescriptor u) {
		Object[] argsMethod = null;
		if (u.getActionBinding().getArgs() != null) {
			argsMethod = new Object[u.getActionBinding().getArgs().length];
			for (int i = 0; i < u.getActionBinding().getArgs().length; ++i) {
				//the param http is always String class.
				String param = params.get(u.getParams().get(i));
				Class< ? > currentClazz = u.getActionBinding().getArgs()[i];
				if (currentClazz.equals(String.class)) {
					//on a rien Ã  faire
					argsMethod[i] = param;
				} else if (currentClazz.equals(Boolean.class)) {
					argsMethod[i] = Boolean.valueOf(param);
				} else if (currentClazz.equals(Integer.class)) {
					argsMethod[i] = Integer.valueOf(param);
				}
				//TODO faire les autres classes primaire.
				//TODO voir utilisation de converter pour objet complexe
				
			}
		}
		return argsMethod;
	}
 	
	/**
	 * return all list UrlPatternDescriptor.
	 * @return List<UrlPatternDescriptor>
	 */
	private List<UrlPatternDescriptor> getUrlDescriptor() {
		//ADD Action
		Map<String, Object> treatments = BeanUtils.getBeansOfClass(UrlPatternDescriptor.class);
		List<UrlPatternDescriptor> urlP = new ArrayList<UrlPatternDescriptor>();
		for (String name : treatments.keySet()) {
			if (logger.isDebugEnabled()) {
				logger.debug("get to roles bean [" + name + "]...");
			}
			Object bean = treatments.get(name);
			if (bean == null) {
				throw new ConfigException("bean [" + name 
						+ "] is null, " 
						+ "application doesn't init action.");
			}
			if (!(bean instanceof UrlPatternDescriptor)) {
				throw new ConfigException("bean [" + name 
						+ "] does not roles.");
			}
			urlP.add((UrlPatternDescriptor) bean);

		}
		return urlP;
	}

	/**
	 * @param request
	 * @return the parameters of the current request.
	 */
	private Map<String, String> getParams(
			final HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		Map<String, String>  params = AbstractUrlGenerator.decodeArgToParams(
				request.getParameter(ServletUrlGeneratorImpl.ARGS_PARAM));
		return params;
	}







	
	
	/**
	 * @see javax.faces.event.PhaseListener#getPhaseId()
	 */
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
	
	
	

}
