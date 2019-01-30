package com.hr.repository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create a Database Connection Class Using a Singleton
 */

public class DbSingletonRepository {
	private static String db_url;
	private static String db_port;
	private static String db_name;
	private static String db_user;
	private static String db_password;
	private static Statement connection;

	private DbSingletonRepository() {
		// Default database parameters
		db_url = "jdbc:mysql://localhost";
		db_port = "3306";
		db_name = "mysql";
		db_user = "root";
		db_password = "admin";
		// Creation of an instance of the connection statement
		connection = setConnection();
	}

	/**
	 * Private method charge to set the connection statement
	 */
	private static Statement setConnection() {
		try {
			String url = "" + db_url + ":" + db_port + "/" + db_name + "";
			java.sql.Connection conn = DriverManager.getConnection(url, db_user, db_password);

			// Creation of the Statement object
			java.sql.Statement state = conn.createStatement();
			return (Statement) state;
		} catch (SQLException ex) {
			Logger.getLogger(DbSingletonRepository.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	/**
	 * Private inner class responsible for instantiating the single instance of the
	 * singleton
	 */
	private static class DbSingletonManagerHolder {
		private final static DbSingletonRepository instance = new DbSingletonRepository();
	}

	/**
	 * Public method, which is the only method allowed to return an instance of the
	 * singleton (the instance here is the database connection statement)
	 */
	public static DbSingletonRepository getInstance() {
		try {
			return DbSingletonManagerHolder.instance;
		} catch (ExceptionInInitializerError ex) {

		}
		return null;
	}

	public static Statement getStatement() {
		return connection;
	}
}