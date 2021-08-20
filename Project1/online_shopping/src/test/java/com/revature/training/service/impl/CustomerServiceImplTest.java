package com.revature.training.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Customer;
import com.revature.training.service.CustomerService;

class CustomerServiceImplTest {

	private CustomerService customerService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		customerService = new CustomerServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		customerService = null;
	}

	@Test
	void testRegisterCustomer() {
		String firstName = "Test";
		String lastName = "Demo";
		String emailId = "test@demo.com";
		String password = "testdemo123";

		int checkRegister = 0;
		int checkDelete = 0;
		Customer customer = new Customer(firstName, lastName, emailId, password);
		try {
			checkRegister = customerService.registerCustomer(customer);

			checkDelete = customerService.deleteCustomer(emailId);

		} catch (BusinessException e) {

		}

		assertEquals(1, checkRegister);
	}

	@Test
	void testDeleteCustomer() {
		String firstName = "Test";
		String lastName = "Demo";
		String emailId = "test@demo.com";
		String password = "testdemo123";

		int checkRegister = 0;
		int checkDelete = 0;
		Customer customer = new Customer(firstName, lastName, emailId, password);
		try {
			checkRegister = customerService.registerCustomer(customer);

			checkDelete = customerService.deleteCustomer(emailId);

		} catch (BusinessException e) {

		}

		assertEquals(1, checkDelete);
	}

	@Test
	void testGetCustomerId() {
		String emailId = "rohit@gmail.com";

		int getCustomerId = 0;
		try {

			getCustomerId = customerService.getCustomerId(emailId);

		} catch (BusinessException e) {

		}

		assertEquals(2, getCustomerId);
	}

	@Test
	void testCheckLogin() {
		String emailId = "rohit@gmail.com";
		String password = "rohit123";

		boolean checkLogin = false;

		try {
			checkLogin = customerService.checkLogin(emailId, password);
		} catch (BusinessException e) {
		}

		assertEquals(true, checkLogin);
	}

	@Test
	void testFetchCustomerFirstName() {
		int customerId = 2;
		String firstName = "Rohit";
		String getCustomerFirstName = null;
		try {

			getCustomerFirstName = customerService.fetchCustomerFirstName(customerId);

		} catch (BusinessException e) {
		}

		assertEquals(firstName, getCustomerFirstName);
	}

	@Test
	void testShowCustomerByFirstName() {
		String firstName = "Rohit";
		List<Customer> showCustomerByFirstName = null;

		try {
			showCustomerByFirstName = customerService.showCustomerByFirstName(firstName);
		} catch (BusinessException e) {
		}
		assertEquals(1, showCustomerByFirstName.size());
	}

	@Test
	void testShowCustomerByLastName() {
		String lastName = "Mishra";
		List<Customer> showCustomerByLastName = null;

		try {
			showCustomerByLastName = customerService.showCustomerByLastName(lastName);
		} catch (BusinessException e) {
		}
		assertEquals(1, showCustomerByLastName.size());
	}

	@Test
	void testShowCustomerByEmail() {
		String emailId = "rohit@gmail.com";
		List<Customer> showCustomerByEmail = null;

		try {
			showCustomerByEmail = customerService.showCustomerByEmail(emailId);
		} catch (BusinessException e) {
		}
		assertEquals(1, showCustomerByEmail.size());
	}

	@Test
	void testShowCustomerByOrder() {
		int orderId = 1;
		List<Customer> showCustomerByOrder = null;

		try {
			showCustomerByOrder = customerService.showCustomerByOrder(orderId);
		} catch (BusinessException e) {
		}
		assertEquals(1, showCustomerByOrder.size());
	}

}
