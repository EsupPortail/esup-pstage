package org.esupportail.pstage.exceptions;

/**
 * 
 */


import org.esupportail.commons.exceptions.EsupException;

/**
 * @author cleprous
 *
 */
public class ExportException extends EsupException {

	
	/*
	 ******************* PROPERTIES ******************* */
	
	/**
	 * the serialization id.
	 */
	private static final long serialVersionUID = 8265870925705066188L;


	/*
	 ******************* INIT ************************* */

	
	/**
	 * Constructors.
	 */
	public ExportException() {
		super();
	}

	/**
	 * Constructors.
	 * @param message
	 */
	public ExportException(final String message) {
		super(message);
	}

	/**
	 * Constructors.
	 * @param cause
	 */
	public ExportException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Constructors.
	 * @param message
	 * @param cause
	 */
	public ExportException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/*
	 ******************* METHODS ********************** */

	/*
	 ******************* ACCESSORS ******************** */

}
