package com.alumni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {

	private static final String JDBC_DRIVER_CLASS ="";
	private static final String JDBC_USERNAME = "";
	private static final String JDBC_PWD = "";
	private ConnectionDAO() {

	}

	/**
	 * @param args
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*
			 * connection = DriverManager.getConnection(
			 * "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_9915491d71b4e71",
			 * "b644aae84597ea", "66000fbb");
			 */
			
			/*
			 * connection = DriverManager.getConnection(
			 * "jdbc:mysql://localhost:3306/aumninw", "root", "Rads$1443");
			 */
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://	mkorvuw3sl6cu9ms.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/qtgw3fawiicu6ueb",
					"fivvwerod3jmhr3h",
					"zzbuda79xnj5uwuc");

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
