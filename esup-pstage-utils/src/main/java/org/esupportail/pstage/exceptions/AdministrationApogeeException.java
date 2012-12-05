
package org.esupportail.pstage.exceptions; 

import org.esupportail.pstage.utils.Configuration;




/**
 * A class for configuration exceptions.
 */
public class AdministrationApogeeException extends RuntimeException {

	/**
	 * The id for serialization.
	 */
	private static final long serialVersionUID = -6697943874257515161L;

	/**
	 * @param message
	 */
	public AdministrationApogeeException(final String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AdministrationApogeeException(final Throwable cause) {
		super(Configuration.getString("CommunicationApogeeException.MESS_DEFAULT"), cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AdministrationApogeeException(final String message, final Throwable cause) {
		super(message, cause);
	}
	

}
