package com.product.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.product.exceptions.ProductException;

public class JdbcUtility {

	private static Connection connection = null;
	static Logger logger = Logger.getLogger(JdbcUtility.class);

	public static Connection getConnection() throws ProductException {

		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
				logger.debug("class loaded");
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GCP_DB", "postgres",
						"*TULASIram71#");
				logger.debug("connected");
			} catch (ClassNotFoundException e) {
				logger.error("problem in loading Driver");
				throw new ProductException("problem in loading Driver");
			} catch (SQLException e) {
				logger.error("Database Error !!");
				throw new ProductException("Database Error !!");
			}
		}
		logger.info("conenction object created");
		return connection;
	}

	public static void closeConnection() throws ProductException {
		try {
			connection.close();
			logger.info("conenction object closed");
		} catch (SQLException e) {
			logger.error("Problem while closing connection");
			throw new ProductException("Problem while closing connection");
		}
	}
}
