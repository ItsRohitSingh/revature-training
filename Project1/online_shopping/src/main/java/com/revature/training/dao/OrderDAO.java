package com.revature.training.dao;

import java.util.List;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;
import com.revature.training.model.Order;

public interface OrderDAO {
	
	public List<Integer> fetchProductIdFromCart(int customerId) throws BusinessException;
	
	public List<String> fetchProductNameFromCart(int customerId) throws BusinessException;
	
	public List<Integer> fetchQuantityFromCart(int customerId) throws BusinessException;
	
	public List<Integer> fetchPriceFromCart(int customerId) throws BusinessException;
	
	public int addOrder(Order order) throws BusinessException;

	public int updateOrderStatus(int orderId, String orderStatus) throws BusinessException;
	
	public List<Order> viewOrderByCustomer(int customerId) throws BusinessException;
	
	public int deleteAllFromCart(int customerId) throws BusinessException;
	
	public List<Order> viewAllOrders() throws BusinessException;
	
	public int updateQuantityProduct(int productId, int quantityPurchased) throws BusinessException;
}
