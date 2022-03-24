package com.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.product.dto.ProductDto;
import com.product.exceptions.ProductException;
import com.product.model.Product;



public class Main {

		static Logger logger = Logger.getLogger(Main.class);

		public static void main(String[] args) {

			Scanner scanner = new Scanner(System.in);
			PropertyConfigurator.configure("src/main/resources/log4j.properties");
			logger.info("log file loaded");
			ProductDto dto = new ProductDto();
			int productCount = scanner.nextInt();
			
			List<Product> list = new ArrayList<>();
			
			for (int i = 0; i < productCount; i++) {
				System.out.println("id");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.println("name");
				String name = scanner.nextLine();
				System.out.println("price");
				int price = scanner.nextInt();
				System.out.println("units");
				int units = scanner.nextInt();
				System.out.println("Company_name");
				scanner.nextLine();
				String companyName=scanner.nextLine();
				
				Product product = new Product(id, name, price,units,companyName);
				list.add(product);
			}
			
			try {
				dto.productUpdate();
				//int result = dto.insertProductList(list);
				//System.out.println(result + " records inserted");
			} catch (ProductException e) {
				logger.error(e.getMessage());
			}
			
			try {
				List<Product> list1 = dto.getAllProducts();
				list1.forEach(product1 -> System.out.println(product1));
			} catch (ProductException e) {
				logger.error(e.getMessage());
			}
			finally{
				scanner.close();
			}
	}

}
