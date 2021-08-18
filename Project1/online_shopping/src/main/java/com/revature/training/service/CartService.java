package com.revature.training.service;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;

public interface CartService {
	public int addToCart(Cart cart) throws BusinessException;

	public int removeFromCart(int customerId, int productId) throws BusinessException;

	public int changeQuantity(int customerId, int productId, int quantity) throws BusinessException;
}
