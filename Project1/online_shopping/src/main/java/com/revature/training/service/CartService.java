package com.revature.training.service;

import java.util.List;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;

public interface CartService {
	public int addToCart(int customerId, int productId, int quantity) throws BusinessException;

	public int removeFromCart(int customerId, int productId) throws BusinessException;

	public int changeQuantity(int customerId, int productId, int newQuantity) throws BusinessException;
	
	public String fetchProductName(int productId) throws BusinessException;
	
	public List<Cart> viewCartByCustomer(int customerId) throws BusinessException;

	public boolean checkProductInCart(int customerId, int productId) throws BusinessException;
	
	public int checkQuantityInCart(int customerId, int productId) throws BusinessException;
}
