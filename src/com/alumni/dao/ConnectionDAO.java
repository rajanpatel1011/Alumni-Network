package com.alumni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConnectionDAO {
	private static final String DB_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String DEFAULT_DB_URL = "jdbc:mysql://localhost:3306/aumninw";
	private static final String DEFAULT_DB_USERNAME = "root";
	private static final String DEFAULT_DB_PASSWORD = "";
	private static final String PROPERTIES_FILE = "config/database.properties";

	private ConnectionDAO() {
	}

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(DB_CLASS);
			Properties properties = loadProperties();
			String url = firstConfiguredValue("DB_URL", "JDBC_DATABASE_URL");
			String username = firstConfiguredValue("DB_USERNAME", "JDBC_DATABASE_USERNAME");
			String password = firstConfiguredValue("DB_PASSWORD", "JDBC_DATABASE_PASSWORD");

			if (url == null) {
				url = properties.getProperty("db.url", DEFAULT_DB_URL);
			}
			if (username == null) {
				username = properties.getProperty("db.username", DEFAULT_DB_USERNAME);
			}
			if (password == null) {
				password = properties.getProperty("db.password", DEFAULT_DB_PASSWORD);
			}

			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connection established");
			return connection;
		} catch (ClassNotFoundException e) {
			throw new SQLException("MySQL JDBC driver is not available", e);
		}
	}

	private static Properties loadProperties() {
		Properties properties = new Properties();
		Path propertiesPath = Paths.get(PROPERTIES_FILE);

		if (Files.isRegularFile(propertiesPath)) {
			try (InputStream input = Files.newInputStream(propertiesPath)) {
				properties.load(input);
			} catch (IOException e) {
				throw new IllegalStateException("Could not read " + PROPERTIES_FILE, e);
			}
		} else {
			try (InputStream input = ConnectionDAO.class.getClassLoader().getResourceAsStream("database.properties")) {
				if (input != null) {
					properties.load(input);
				}
			} catch (IOException e) {
				throw new IllegalStateException("Could not read database.properties", e);
			}
		}
		return properties;
	}

	private static String firstConfiguredValue(String... names) {
		for (String name : names) {
			String value = System.getenv(name);
			if (value != null && !value.trim().isEmpty()) {
				return value.trim();
			}
		}
		return null;
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				System.out.println("Database connection closed");
			}
		} catch (SQLException e) {
			System.err.println("Failed to close database connection: " + e.getMessage());
		}
	}
}
