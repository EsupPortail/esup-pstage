package org.esupportail.pstage.web.deepLinking;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author cleprous
 */
public class UrlPatternDescriptor implements Serializable {

	
	/**
	 * the serialization id.
	 */
	private static final long serialVersionUID = -6333138646368993220L;
	
	/*
	 ******************* PROPERTIES ******************* */
	
	

	/**
	 * The param list.
	 */
	private List<String> params;
	
	/**
	 * The EL expression. EX.: #{...}
	 */
	private ActionBinding actionBinding;
	
	/**
	 * The url return. Ex.: /stylesheets/../*.jsp
	 */
	private String viewId;
	
	/*
	 ******************* INIT ************************* */

	/**
	 * Constructor.
	 */
	public UrlPatternDescriptor() {
		super();
	}
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UrlPatternDescriptor#" + hashCode() + "[params=[" + params 
				+ "], actionBinding=[" + actionBinding + "], viewId=[" + viewId + "]]";
	}
	
	/*
	 ******************* METHODS ********************** */

	/**
	 * @param paramsHttp
	 * @return boolean
	 */
	public boolean isParamsContains(final Set<String> paramsHttp) {
		return params.containsAll(paramsHttp);
	}
	
	/*
	 ******************* ACCESSORS ******************** */
	
	/**
	 * @return List of String
	 */
	public List<String> getParams() {
		return params;
	}
	
	/**
	 * @return ActionBinding
	 */
	public ActionBinding getActionBinding() {
		return actionBinding;
	}

	/**
	 * @return String
	 */
	public String getViewId() {
		return viewId;
	}
	
	/**
	 * @param params
	 */
	public void setParams(final List<String> params) {
		this.params = params;
	}


	/**
	 * @param actionBinding
	 */
	public void setActionBinding(final ActionBinding actionBinding) {
		this.actionBinding = actionBinding;
	}

	

	/**
	 * @param viewId
	 */
	public void setViewId(final String viewId) {
		this.viewId = viewId;
	}


	

}
