package com.revature.training.service.impl;

import java.util.List;

import com.revature.training.dao.CartDAO;
import com.revature.training.dao.impl.CartDAOImpl;
import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;
import com.revature.training.service.CartService;

public class CartServiceImpl implements CartService {

	CartDAO cartDAO = new CartDAOImpl();

	@Override
	public int addToCart(int customerId, int productId, int quantity) throws BusinessException {

		if (quantity > 0) {
			String productName = cartDAO.fetchProductName(productId);
			int quantityLeft = cartDAO.fetchProductQuantity(productId);
			int productPrice = cartDAO.fetchProductPrice(productId);
			int checkAdd = 0;
			if (quantityLeft > 0) {
				if (quantity <= quantityLeft) {
					productPrice *= quantity;
					Cart cart = new Cart();
					cart.setCartCustomerId(customerId);
					cart.setCartProductId(productId);
					cart.setCartProductName(productName);
					cart.setQuantity(quantity);
					cart.setPrice(productPrice);

					checkAdd = cartDAO.addToCart(cart);
				} else {
					throw new BusinessException(
							"Only " + quantityLeft + " stocks of " + productName + " are available.");
				}
			} else {
				throw new BusinessException(productName + " is Out Of Stock!");
			}
			return checkAdd;
		} else {
			throw new BusinessException("Please enter valid quantity.");
		}
	}

	@Override
	public int removeFromCart(int customerId, int productId) throws BusinessException {
		int checkRemove = 0;
		checkRemove = cartDAO.removeFromCart(customerId, productId);
		return checkRemove;
	}

	@Override
	public int changeQuantity(int customerId, int productId, int newQuantity) throws BusinessException {
		int quantityLeft = cartDAO.fetchProductQuantity(productId);
		String productName = cartDAO.fetchProductName(productId);
		int productPrice = cartDAO.fetchProductPrice(productId);
		
		if (newQuantity > 0) {
			if (quantityLeft > 0) {
				if (newQuantity <= quantityLeft) {
					int checkChange = cartDAO.changeQuantity(customerId, productId, newQuantity, productPrice);
					return checkChange;
				} 
				else {
					throw new BusinessException(
							"Only " + quantityLeft + " stocks of " + productName + " are available.");
				}
			}
			else {
				throw new BusinessException(productName + " is Out Of Stock!");
			}
		} 
		else {
			throw new BusinessException("Please enter valid quantity.");
		}
	}

	@Override
	public String fetchProductName(int productId) throws BusinessException {
		String productName = cartDAO.fetchProductName(productId);
		return productName;
	}

	@Override
	public List<Cart> viewCartByCustomer(int customerId) throws BusinessException {
		List<Cart> cartList = cartDAO.viewCartByCustomer(customerId);
		return cartList;
	}

	@Override
	public boolean checkProductInCart(int customerId, int productId) throws BusinessException {
		boolean isProductInCart = cartDAO.checkProductInCart(customerId, productId);
		return isProductInCart;
	}

	@Override
	public int checkQuantityInCart(int customerId, int productId) throws BusinessException {
		int quantityInCart = cartDAO.checkQuantityInCart(customerId, productId);
		return quantityInCart;
	}

}
