package org.esupportail.pstage.exceptions;


public class PstageXLSException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public PstageXLSException(final String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PstageXLSException(final Throwable cause) {
		super(" Probleme avec l'edition de fichier xls", cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PstageXLSException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
