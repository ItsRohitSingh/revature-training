package com.revature.training.model;

public class Products {
	private int productId;
	private String productName;
	private String productManufacturer;
	private int quantity;
	private int price;

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(String productName, String productManufacturer, int quantity, int price) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.productManufacturer = productManufacturer;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + ", productManufacturer=" + productManufacturer + "]";
	}

	
}
