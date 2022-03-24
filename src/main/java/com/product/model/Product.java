package com.product.model;

public class Product {
	private int productId;
	private String productName;
	private int productPrice;
	private int units;
	private String companyName;

	public Product(int productId, String productName, int productPrice, int units, String companyName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.units = units;
		this.companyName = companyName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", units=" + units + ", companyName=" + companyName + "]";
	}

}
