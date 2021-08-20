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
import com.revature.training.model.Products;
import com.revature.training.service.ProductService;

class ProductServiceImplTest {

	private ProductService productService;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		productService = new ProductServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		productService = null;
	}

	@Test
	void testAddProduct() {
		String productName = "Test Product";
		String productManufacturer = "Demo";
		int quantity = 1;
		int price = 10;
		int checkAdd = 0;
		int checkRemove = 0;
		Products product = new Products(productName, productManufacturer, quantity, price);
		
		try {
			checkAdd = productService.addProduct(product);
			checkRemove = productService.removeProduct(productName);
		} catch (BusinessException e) {
		}
		assertEquals(1, checkAdd);
	}

	@Test
	void testRemoveProduct() {
		String productName = "Test Product";
		String productManufacturer = "Demo";
		int quantity = 1;
		int price = 10;
		int checkAdd = 0;
		int checkRemove = 0;
		Products product = new Products(productName, productManufacturer, quantity, price);
		
		try {
			checkAdd = productService.addProduct(product);
			checkRemove = productService.removeProduct(productName);
		} catch (BusinessException e) {
		}
		assertEquals(1, checkRemove);
	}

	@Test
	void testShowProductByName() {
		String productName = "Test";
		String productManufacturer = "Demo";
		int quantity = 1;
		int price = 10;
		int checkAdd = 0;
		int checkRemove = 0;
		List<Products> productList = new ArrayList<>();
		Products product = new Products(productName, productManufacturer, quantity, price);
		
		try {
			checkAdd = productService.addProduct(product);
			productList = productService.showProductByName(productName);
			checkRemove = productService.removeProduct(productName);
		} catch (BusinessException e) {
		}
		assertEquals(1, productList.size());
	}

	@Test
	void testShowProductByManufacturer() {
		String productName = "Test Product";
		String productManufacturer = "Demo";
		int quantity = 1;
		int price = 10;
		int checkAdd = 0;
		int checkRemove = 0;
		List<Products> productList = new ArrayList<>();
		Products product = new Products(productName, productManufacturer, quantity, price);
		
		try {
			checkAdd = productService.addProduct(product);
			productList = productService.showProductByManufacturer(productManufacturer);
			checkRemove = productService.removeProduct(productName);
		} catch (BusinessException e) {
		}
		assertEquals(1, productList.size());
	}

}
