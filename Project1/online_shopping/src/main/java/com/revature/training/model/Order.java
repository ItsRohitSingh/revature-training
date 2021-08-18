package com.revature.training.model;

public class Order {
	private int orderId;
	private int orderCustomerId;
	private int orderProductId;
	private String orderProductName;
	private int orderQuantity;
	private int orderPrice;
	private String orderStatus;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, int orderCustomerId, int orderProductId, String orderProductName, int orderQuantity,
			int orderPrice, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderCustomerId = orderCustomerId;
		this.orderProductId = orderProductId;
		this.orderProductName = orderProductName;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderCustomerId() {
		return orderCustomerId;
	}

	public void setOrderCustomerId(int orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}

	public int getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	public String getOrderProductName() {
		return orderProductName;
	}

	public void setOrderProductName(String orderProductName) {
		this.orderProductName = orderProductName;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCustomerId=" + orderCustomerId + ", orderProductId="
				+ orderProductId + ", orderProductName=" + orderProductName + ", orderQuantity=" + orderQuantity
				+ ", orderPrice=" + orderPrice + ", orderStatus=" + orderStatus + "]";
	}

}
