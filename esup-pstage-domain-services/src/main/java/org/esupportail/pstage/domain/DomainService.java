/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.commons.exceptions.ConfigException;
import org.esupportail.commons.exceptions.UserNotFoundException;
import org.esupportail.commons.services.application.Version;
import org.esupportail.commons.services.paginator.Paginator;
import org.esupportail.pstage.domain.beans.User;

/**
 * The domain service interface.
 */
public interface DomainService extends Serializable {

	//////////////////////////////////////////////////////////////
	// User
	//////////////////////////////////////////////////////////////

	/**
	 * @param id
	 * @return the User instance that corresponds to an id.
	 * @throws UserNotFoundException
	 */
	User getUser(String id) throws UserNotFoundException;

	/**
	 * @return the list of all the users.
	 */
	List<User> getUsers();

	/**
	 * Update a user.
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * Update a user's information (retrieved from the LDAP directory for instance).
	 * @param user
	 */
	void updateUserInfo(User user);
	
	/**
	 * Add an administrator.
	 * @param user
	 */
	void addAdmin(User user);

	/**
	 * Delete an administrator.
	 * @param user
	 */
	void deleteAdmin(User user);

	/**
	 * @return a paginator for administrators.
	 */
	Paginator<User> getAdminPaginator();

	//////////////////////////////////////////////////////////////
	// VersionManager
	//////////////////////////////////////////////////////////////
	
	/**
	 * @return the database version.
	 * @throws ConfigException when the database is not initialized
	 */
	Version getDatabaseVersion() throws ConfigException;
	
	/**
	 * Set the database version.
	 * @param version 
	 */
	void setDatabaseVersion(Version version);
	
	/**
	 * Set the database version.
	 * @param version 
	 */
	void setDatabaseVersion(String version);
	
	//////////////////////////////////////////////////////////////
	// Authorizations
	//////////////////////////////////////////////////////////////

	/**
	 * @param currentUser
	 * @return 'true' if the user can view administrators.
	 */
	boolean userCanViewAdmins(User currentUser);
	
	/**
	 * @param user 
	 * @return 'true' if the user can grant the privileges of administrator.
	 */
	boolean userCanAddAdmin(User user);

	/**
	 * @param user 
	 * @param admin
	 * @return 'true' if the user can revoke the privileges of an administrator.
	 */
	boolean userCanDeleteAdmin(User user, User admin);

}
