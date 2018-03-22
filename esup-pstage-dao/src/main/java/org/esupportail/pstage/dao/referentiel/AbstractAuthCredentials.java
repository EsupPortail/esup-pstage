package org.esupportail.pstage.dao.referentiel;

/**
 * Classe abstraite pour n'injecter les logs d'authentification du ws apogee qu'à un seul endroit
 */
public class AbstractAuthCredentials {

	/**
	 * User ayant acces au web service Apogee
	 */
	private String user;
	/**
	 * Password pour l'acces au web service Apogee
	 */
	private String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
