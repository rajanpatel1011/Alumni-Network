package com.alumni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {

	private ConnectionDAO(){

	}

	/**
	 * @param args
	 */
	public static Connection getConnection() throws SQLException 
	{
			Connection connection=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				throw new SQLException();
			}
			
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aumninw?user=root&password=rads1443");
			
			//connection = DriverManager.getConnection("jdbc:mysql://182.50.133.170:3306/aumninw","aumninw","Admin@123");
			
			connection = DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_9915491d71b4e71","b48e9c36f019f2","66000fbb");
			
			
			 //System.out.println("Connection Successfully");
			return connection;
	}
	/**This method will close the connection
	 * @param connection : Connection to be closed.	 
	 */
	
	public static void closeConnection(Connection connection)
	{
		try
		{
			if(connection!= null && !connection.isClosed())
			{
				connection.close();
				 System.out.println(" Connection Close");
			}
		}
		catch(Exception e)
		{
			System.out.println("CLOSE CON : " + e);
		}
	}

}
