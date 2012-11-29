package org.esupportail.pstage.web.deepLinking;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author cleprous
 *
 */
public class ActionBinding implements Serializable {

	
	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 3079783230222975978L;

	/*
	 ******************* PROPERTIES ******************* */
	
	
	/**
	 * The EL expression.
	 */
	private String action;
	
	/**
	 * arguments to action method.
	 */
	private Class< ? >[] args;
	
	/**
	 * The class return to this action method. 
	 */
	private Class< ? > returns;
	
	/*
	 ******************* INIT ************************* */
	
	/**
	 * Constructor.
	 */
	public ActionBinding() {
		super();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + Arrays.hashCode(args);
		result = prime * result + ((returns == null) ? 0 : returns.hashCode());
		return result;
	}




	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		ActionBinding other = (ActionBinding) obj;
		if (action == null) {
			if (other.action != null) {	return false; }
		} else if (!action.equals(other.action)) { return false; }
		if (!Arrays.equals(args, other.args)) { return false; }
		if (returns == null) {
			if (other.returns != null) { return false; }
		} else if (!returns.equals(other.returns)) { return false; }
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActionBinding#" + hashCode() + "[action=[" + action + "], returns=[" + returns + "]]";
	}
	/*
	 ******************* METHODS ********************** */

	/*
	 ******************* ACCESSORS ******************** */
	
	
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(final String action) {
		this.action = action;
	}

	/**
	 * @return the args
	 */
	public Class<?>[] getArgs() {
		return args;
	}

	/**
	 * @param args the args to set
	 */
	public void setArgs(final Class< ? >[] args) {
		this.args = args;
	}

	/**
	 * @return the returns
	 */
	public Class<?> getReturns() {
		return returns;
	}

	/**
	 * @param returns the returns to set
	 */
	public void setReturns(final Class< ? > returns) {
		this.returns = returns;
	}




	
	
}
