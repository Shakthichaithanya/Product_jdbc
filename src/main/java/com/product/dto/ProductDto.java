package com.product.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.product.exceptions.ProductException;
import com.product.model.Product;
import com.product.queries.Queries;
import com.product.utility.JdbcUtility;

public class ProductDto {

	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	static Logger logger = Logger.getLogger(ProductDto.class);
	public int insertProductList(List<Product> list) throws ProductException {
		connection=JdbcUtility.getConnection();
		int count[];
		try {
			preparedStatement = connection.prepareStatement(Queries.INSERT_QUERY);
			
			for(Product product : list) {
				preparedStatement.setInt(1, product.getProductId());
				preparedStatement.setString(2, product.getProductName());
				preparedStatement.setInt(3, product.getProductPrice());
				preparedStatement.setInt(4, product.getUnits());
				preparedStatement.setString(5, product.getCompanyName());
				preparedStatement.addBatch();
			}
			
			count = preparedStatement.executeBatch();
			
		} catch (SQLException e) {
			logger.error("problem in creating prepared statement object");
			throw new ProductException("problem in creating prepared statement object");
		}
		return count.length;
}
	public void productUpdate() throws ProductException{
		logger.info("Update method loaded");
		connection=JdbcUtility.getConnection();
		try {
			Statement statement= connection.createStatement();
			statement.executeUpdate(Queries.UPDATE);
			}catch(SQLException e) {
				logger.error("problem in creating statement object update method");
				throw new ProductException("problem in creatingstatement object update method");
			}
	}

	public int insertProduct(Product product) throws ProductException {

		logger.info("in insert product");
		connection = JdbcUtility.getConnection();
		int count = 0;
		try {

			preparedStatement = connection.prepareStatement(Queries.INSERT_QUERY);
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setInt(3, product.getProductPrice());
			preparedStatement.setInt(4, product.getUnits());
			preparedStatement.setString(5, product.getCompanyName());

			count = preparedStatement.executeUpdate();

			logger.info(count + " records inserted..");

		} catch (SQLException e) {
			logger.error("problem in creating prepared statement object in insert method");
			throw new ProductException("problem in creating prepared statement object in insert method");
		}
		return count;
	}

	public List<Product> getAllProducts() throws ProductException {
		connection = JdbcUtility.getConnection();
		List<Product> list = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(Queries.SELECT_WHERE_QUERY);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int price = resultSet.getInt(3);
				int units = resultSet.getInt(4);
				String companyName = resultSet.getString(5);

				Product product1 = new Product(id, name, price, units, companyName);
				list.add(product1);
			}

		} catch (SQLException e) {
			logger.error("problem in creating prepared statement object get method");
			throw new ProductException("problem in creating prepared statement object get method");
		}
		return list;
	}

}
