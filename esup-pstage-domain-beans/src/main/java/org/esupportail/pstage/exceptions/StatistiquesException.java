package org.esupportail.pstage.exceptions;

@SuppressWarnings("serial")
public class StatistiquesException extends Exception {
	/**
	 * Constructor.
	 */
	public StatistiquesException() {
		super();
	}

	/**
	 * Constructor.
	 * @param message 
	 */
	public StatistiquesException(final String message) {
		super(message);
	}

	

	/**
	 * Constructor.
	 * @param message 
	 * @param cause 
	 */
	public StatistiquesException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
