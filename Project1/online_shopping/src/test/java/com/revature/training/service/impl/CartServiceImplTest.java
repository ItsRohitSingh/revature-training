package com.revature.training.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.training.exception.BusinessException;
import com.revature.training.service.CartService;
import com.revature.training.model.Cart;

class CartServiceImplTest {

	private CartService cartService;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cartService = new CartServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		cartService = null;
	}

	@Test
	void testAddToCart() {
		int productId = 1;
		int customerId = 1;
		int quantity = 1;
		int checkAdd = 0;
		int checkRemove = 0;
		try {
			checkAdd = cartService.addToCart(customerId, productId, quantity);
			
		} catch (BusinessException e) {
			
		}
		assertEquals(checkAdd, 1);
		
		try {
			checkRemove = cartService.removeFromCart(customerId, productId);
		} catch (BusinessException e) {

		}
		
		
	}

	@Test
	void testRemoveFromCart() {
		int productId = 1;
		int customerId = 1;
		int quantity = 1;
		int checkAdd = 0;
		int checkRemove = 0;
		try {
			checkAdd = cartService.addToCart(customerId, productId, quantity);
			
		} catch (BusinessException e) {
			
		}
		
		try {
			checkRemove = cartService.removeFromCart(customerId, productId);
		} catch (BusinessException e) {

		}
		assertEquals(1,checkRemove);
		
	}

	@Test
	void testChangeQuantity() {
		int productId = 1;
		int customerId = 1;
		int quantity = 1;
		int checkAdd = 0;
		int checkChange = 0;
		int checkRemove = 0;
		int newQuantity = 2;
		try {
			checkAdd = cartService.addToCart(customerId, productId, quantity);
			
		} catch (BusinessException e) {
			
		}
		
		try {
			checkChange = cartService.changeQuantity(customerId, productId, newQuantity);
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			checkRemove = cartService.removeFromCart(customerId, productId);
		} catch (BusinessException e) {

		}
		assertEquals(2,checkChange);
	}

	@Test
	void testFetchProductName() {
		int productId = 1;
		String fetchProductName = null;
		
		try {
			fetchProductName = cartService.fetchProductName(productId);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("TV",fetchProductName);
	}

	@Test
	void testViewCartByCustomer() {
		int productId = 1;
		int customerId = 1;
		int quantity = 1;
		int checkAdd = 0;
		int checkRemove = 0;
		List<Cart> cartList = new ArrayList<>();
		try {
			checkAdd = cartService.addToCart(customerId, productId, quantity);
			
		} catch (BusinessException e) {
			
		}
		
		try {
			cartList = cartService.viewCartByCustomer(customerId);
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			checkRemove = cartService.removeFromCart(customerId, productId);
		} catch (BusinessException e) {

		}
		assertEquals(1,cartList.size());
	}

	@Test
	void testCheckProductInCart() {
		int productId = 1;
		int customerId = 1;
		int quantity = 1;
		int checkAdd = 0;
		int checkRemove = 0;
		boolean checkProduct = false;
		try {
			checkAdd = cartService.addToCart(customerId, productId, quantity);
			
			checkProduct = cartService.checkProductInCart(customerId, productId);
			
			checkRemove = cartService.removeFromCart(customerId, productId);
		} catch (BusinessException e) {

		}
		assertEquals(true,checkProduct);
	}

	@Test
	void testCheckQuantityInCart() {
		int productId = 1;
		int customerId = 1;
		int quantity = 1;
		int checkAdd = 0;
		int checkRemove = 0;
		int checkQuantity = 0;
		try {
			checkAdd = cartService.addToCart(customerId, productId, quantity);
			
			checkQuantity = cartService.checkQuantityInCart(customerId, productId);
			
			checkRemove = cartService.removeFromCart(customerId, productId);
		} catch (BusinessException e) {

		}
		assertEquals(quantity,checkQuantity);
	}

}
