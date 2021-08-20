package com.revature.training.dao;

import java.util.List;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;
import com.revature.training.model.Products;

public interface CartDAO {
	public int addToCart(Cart cart) throws BusinessException;

	public int removeFromCart(int customerId, int productId) throws BusinessException;

	public int changeQuantity(int customerId, int productId, int newQuantity, int price) throws BusinessException;
	
	public String fetchProductName(int productId) throws BusinessException;
	
	public int fetchProductQuantity(int productId) throws BusinessException;

	public int fetchProductPrice(int productId) throws BusinessException;
	
	public List<Cart> viewCartByCustomer(int customerId) throws BusinessException;
	
	public boolean checkProductInCart(int customerId, int productId) throws BusinessException;
	
	public int checkQuantityInCart(int customerId, int productId) throws BusinessException;
}
