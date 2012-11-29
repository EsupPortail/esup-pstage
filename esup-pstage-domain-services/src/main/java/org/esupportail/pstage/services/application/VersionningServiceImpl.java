/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.services.application; 

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.esupportail.commons.exceptions.ConfigException;
import org.esupportail.commons.services.application.Version;
import org.esupportail.commons.services.application.VersionException;
import org.esupportail.commons.services.application.VersionningService;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.utils.Assert;
import org.esupportail.pstage.domain.beans.User;

/**
 * A bean for versionning management.
 */
public class VersionningServiceImpl extends AbstractDomainAwareBean implements VersionningService {

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -8260436813100182531L;

	/**
	 * A logger.
	 */
	private final Logger logger = new LoggerImpl(getClass());
	
	/**
	 * The id of the first administrator.
	 */
	private String firstAdministratorId;
	
	/**
	 * Bean constructor.
	 */
	public VersionningServiceImpl() {
		super();
	}

	/**
	 * @see org.esupportail.pstage.web.controllers.AbstractDomainAwareBean#afterPropertiesSetInternal()
	 */
	@Override
	public void afterPropertiesSetInternal() {
		Assert.notNull(this.firstAdministratorId, 
				"property firstAdministratorId of class " + this.getClass().getName() 
				+ " can not be null");
	}

	/**
	 * print the last version available.
	 */
	private void printLastVersion() {
		Version latestVersion = getApplicationService().getLatestVersion();
		if (latestVersion != null) {
			logger.info("Latest version available: " + latestVersion);
		}
	}
	
	/**
	 * Set the database version.
	 * @param version 
	 * @param silent true to omit info messages
	 */
	public void setDatabaseVersion(
			final String version, 
			final boolean silent) {
		getDomainService().setDatabaseVersion(version);
		if (!silent) {
			logger.info("database version set to " + version + ".");
		}
	}

	/**
	 * @return the database version.
	 */
	public Version getDatabaseVersion() {
		return getDomainService().getDatabaseVersion();
	}

	/**
	 * @see org.esupportail.commons.services.application.VersionningService#initDatabase()
	 */
	public void initDatabase() {
		DatabaseUtils.create();
		logger.info("creating the first user of the application thanks to " 
				+ getClass().getName() + ".firstAdministratorId...");
		User firstAdministrator = getDomainService().getUser(firstAdministratorId);
		getDomainService().addAdmin(firstAdministrator);
		logger.info("the database has been created.");
		setDatabaseVersion("0.0.0", true);
	}

	/**
	 * @see org.esupportail.commons.services.application.VersionningService#checkVersion(boolean, boolean)
	 */
	public void checkVersion(
			final boolean throwException,
			final boolean printLatestVersion) throws VersionException {
		Version databaseVersion = getDomainService().getDatabaseVersion();
		Version applicationVersion = getApplicationService().getVersion();
		if (databaseVersion == null) {
			String msg = "Your database is not initialized, please run 'ant init-data'.";
			if (throwException) {
				throw new VersionException(msg);
			}
			logger.error(msg);
			if (printLatestVersion) {
				printLastVersion();
			}
			return;
		}
		if (applicationVersion.equals(databaseVersion)) {
			String msg = "The database is up to date.";
			if (throwException) {
				if (logger.isDebugEnabled()) {
					logger.debug(msg);
				}
			} else {
				logger.info(msg);
			}
			if (printLatestVersion) {
				printLastVersion();
			}
			return;
		}
		if (applicationVersion.isSameMajorAndMinor(databaseVersion)) {
			logger.info("Database version is " + databaseVersion + ", upgrading...");
			upgradeDatabase();
			if (printLatestVersion) {
				printLastVersion();
			}
			return;
		}
		if (databaseVersion.isOlderThan(applicationVersion)) {
			String msg = "The database is too old (" + databaseVersion + "), please run 'ant upgrade'.";
			if (throwException) {
				throw new VersionException(msg);
			}
			logger.error(msg);
			if (printLatestVersion) {
				printLastVersion();
			}
			return;
		}
		String msg = "The application is too old (" + databaseVersion + "), please upgrade.";
		if (throwException) {
			throw new VersionException(msg);
		}
		if (printLatestVersion) {
			printLastVersion();
		}
		logger.error(msg);
	}
	
	/**
	 * Print a message saying that the database version is older than ...
	 * @param version the new version
	 */	
	protected void printOlderThanMessage(final String version) {
		logger.info(new StringBuffer("database version (")
				.append(getDomainService().getDatabaseVersion())
				.append(") is older than ")
				.append(version)
				.append(", upgrading..."));
	}
	
	/**
	 * Upgrade the database to version 0.1.0.
	 */
	public void upgrade0d1d0() {
		// nothing to do yet
	}

	/**
	 * Upgrade the database to a given version, if needed.
	 * @param version 
	 */
	private void upgradeDatabaseIfNeeded(final String version) {
		if (!getDatabaseVersion().isOlderThan(version)) {
			return;
		}
		printOlderThanMessage(version);
		String methodName = "upgrade" + version.replace('.', 'd');
		Class [] methodArgs = new Class [] {};
		Method method;
		try {
			method = getClass().getMethod(methodName, methodArgs);
		} catch (SecurityException e) {
			throw new ConfigException(
					"access to the information of class " + getClass() + " was denied", e);
		} catch (NoSuchMethodException e) {
			throw new ConfigException(
					"could no find method " + getClass() + "." + methodName + "()", e);
		}
		Exception invocationException = null;
		try {
			method.invoke(this, new Object[] {});
			setDatabaseVersion(version, false);
			return;
		} catch (IllegalArgumentException e) {
			invocationException = e;
		} catch (IllegalAccessException e) {
			invocationException = e;
		} catch (InvocationTargetException e) {
			if (e.getCause() == null) {
				invocationException = e;
			} else if (e.getCause() instanceof Exception) {
				invocationException = (Exception) e.getCause();
			} else {
				invocationException = e;
			}
		}
		throw new ConfigException(
				"could no invoke method " + getClass() + "." + methodName + "()", 
				invocationException);
	}

	/**
	 * @see org.esupportail.commons.services.application.VersionningService#upgradeDatabase()
	 */
	public boolean upgradeDatabase() {
		if (getDatabaseVersion().equals(getApplicationService().getVersion())) {
			logger.info("The database is up to date, no need to upgrade.");
			return false;
		}
		DatabaseUtils.update();
		upgradeDatabaseIfNeeded("0.1.0");
		if (!getDatabaseVersion().equals(getApplicationService().getVersion())) {
			setDatabaseVersion(getApplicationService().getVersion().toString(), false);
		}
		return false;
	}

	/**
	 * @return the firstAdministratorId
	 */
	public String getFirstAdministratorId() {
		return firstAdministratorId;
	}

	/**
	 * @param firstAdministratorId the firstAdministratorId to set
	 */
	public void setFirstAdministratorId(final String firstAdministratorId) {
		this.firstAdministratorId = firstAdministratorId;
	}

}
