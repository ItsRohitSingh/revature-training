package com.revature.training.model;

public class Cart {
	private int cartCustomerId;
	private int cartProductId;
	private String cartProductName;
	private int quantity;
	private int price;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartCustomerId, int cartProductId, String cartProductName, int quantity, int price) {
		super();
		this.cartCustomerId = cartCustomerId;
		this.cartProductId = cartProductId;
		this.cartProductName = cartProductName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getCartCustomerId() {
		return cartCustomerId;
	}

	public void setCartCustomerId(int cartCustomerId) {
		this.cartCustomerId = cartCustomerId;
	}

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public String getCartProductName() {
		return cartProductName;
	}

	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
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

	@Override
	public String toString() {
		return "Cart [cartCustomerId=" + cartCustomerId + ", cartProductId=" + cartProductId + ", cartProductName="
				+ cartProductName + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
