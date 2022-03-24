package com.product.queries;

public interface Queries {
	String INSERT_QUERY = "INSERT INTO product VALUES(?,?,?,?,?)";
	String SELECT_WHERE_QUERY="SELECT * FROM product WHERE company_name=\'LG\'";
	String UPDATE="UPDATE product SET product_price=product_price+10000 WHERE units<10";
}