package com.revature.training.service;

import java.util.List;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;
import com.revature.training.model.Order;

public interface OrderService {
	public int addOrder(int customerId) throws BusinessException;

	public int updateOrderStatus(int orderId, String orderStatus) throws BusinessException;
	
	public List<Cart> fetchCartForCustomer(int customerId) throws BusinessException;

	public List<Order> viewOrderByCustomer(int customerId) throws BusinessException;
	
	public int deleteAllFromCart(int customerId) throws BusinessException;

	public List<Order> viewAllOrders() throws BusinessException;
	
	public int updateQuantityProduct(int productId, int quantityPurchased) throws BusinessException;
}
