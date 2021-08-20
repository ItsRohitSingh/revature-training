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
import com.revature.training.model.Order;
import com.revature.training.service.CartService;
import com.revature.training.service.OrderService;

class OrderServiceImplTest {

	private OrderService orderService = new OrderServiceImpl();
	private CartService cartService = new CartServiceImpl();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		orderService = new OrderServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		orderService = null;
	}

	@Test
	void testAddOrder() {
		int productId = 1;
		int customerId = 1;
		int quantity = 1;
		int checkAdd = 0;
		int checkRemove = 0;
		int checkAddOrder = 0;
		try {
			checkAdd = cartService.addToCart(customerId, productId, quantity);
			
			checkAddOrder = orderService.addOrder(customerId);
		
			checkRemove = cartService.removeFromCart(customerId, productId);
		} catch (BusinessException e) {

		}
		
		
	}

	@Test
	void testUpdateOrderStatus() {
		int orderId = 4;
		String orderStatus = "Testing";
		int checkUpdate = 0;
		
		try {
			checkUpdate = orderService.updateOrderStatus(orderId, orderStatus);
		} catch (BusinessException e) {
		}
		
		assertEquals(1, checkUpdate);
	}

}
