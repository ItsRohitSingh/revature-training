package com.revature.training.dao;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;

public interface CartDAO {
	public int addToCart(Cart cart) throws BusinessException;

	public int removeFromCart(int customerId, int productId) throws BusinessException;

	public int changeQuantity(int customerId, int productId, int quantity) throws BusinessException;
}
