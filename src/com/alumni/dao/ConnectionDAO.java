package com.alumni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	private static final String DB_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String DB_DRIVER_CLASS ="jdbc:mysql://mkorvuw3sl6cu9ms.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/qtgw3fawiicu6ueb";
	private static final String DB_USERNAME = "fivvwerod3jmhr3h";
	private static final String DB_PWD = "zzbuda79xnj5uwuc";
	private ConnectionDAO() {

	}

	/**
	 * @param args
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName(DB_CLASS);
			/*
			 * Cleaer
			 * connection = DriverManager.getConnection(
			 * "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_9915491d71b4e71",
			 * "b644aae84597ea", "66000fbb");
			 */
			
			/*
			 * connection = DriverManager.getConnection(
			 * "jdbc:mysql://localhost:3306/aumninw", "root", "Rads$1443");
			 */
			
			connection = DriverManager.getConnection(DB_DRIVER_CLASS,
					DB_USERNAME,
					DB_PWD);

		} catch (ClassNotFoundException e) {
			throw new SQLException();
		} catch (Exception e1) {
			System.out.println(e1);
		}

		// connection =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/aumninw?user=root&password=rads1443");

		// connection =
		// DriverManager.getConnection("jdbc:mysql://182.50.133.170:3306/aumninw","aumninw","Admin@123");

		System.out.println("Connection Successfully");
		return connection;
	}

	/**
	 * This method will close the connection
	 * 
	 * @param connection : Connection to be closed.
	 */

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				System.out.println(" Connection Close");
			}
		} catch (Exception e) {
			System.out.println("CLOSE CON : " + e);
		}
	}

}
