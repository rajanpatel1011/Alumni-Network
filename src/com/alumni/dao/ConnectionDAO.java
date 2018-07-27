package com.alumni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {

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
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aumninw?user=root&password=password");
			
			//connection = DriverManager.getConnection("jdbc:mysql://182.50.133.170:3306/aumninw","aumninw","Admin@123");
			
	//		connection = DriverManager.getConnection("jdbc:mysql://us-cdbr-cb-east-01.cleardb.net:3306/cb_aumninw","b48e9c36f019f2","4c7cbb94");
			
			
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
				// System.out.println(" Connection Close");
			}
		}
		catch(Exception e)
		{
			System.out.println("CLOSE CON : " + e);
		}
	}

}
