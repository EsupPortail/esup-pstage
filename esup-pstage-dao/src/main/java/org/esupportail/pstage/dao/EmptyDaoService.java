package org.esupportail.pstage.dao;

import java.util.List;

import org.esupportail.commons.services.paginator.Paginator;
import org.esupportail.pstage.domain.beans.User;
import org.esupportail.pstage.domain.beans.VersionManager;



/**

 * The DAO service interface.

 */

public class EmptyDaoService implements DaoService {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public void addUser(User user) {



	}



	public void addVersionManager(VersionManager versionManager) {



	}



	public void deleteUser(User user) {



	}



	public Paginator<User> getAdminPaginator() {

		return null;

	}



	public User getUser(String id) {

		return null;

	}



	public List<User> getUsers() {


		return null;

	}



	public List<VersionManager> getVersionManagers() {

		return null;

	}



	public void updateUser(User user) {



	}



	public void updateVersionManager(VersionManager versionManager) {


	}



	@Override

	public VersionManager getVersionManager() {

		return null;

	}



}
