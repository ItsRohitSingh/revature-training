package com.revature.training.service;

import java.util.List;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Customer;

public interface CustomerService {
	public int registerCustomer(Customer customer) throws BusinessException;
	
	public int deleteCustomer(String emailId) throws BusinessException;

	public int getCustomerId(String emailId) throws BusinessException;

	public boolean checkLogin(String emailId, String password) throws BusinessException;

	public String fetchCustomerFirstName(int customerId) throws BusinessException;

	public List<Customer> showCustomerByFirstName(String firstName) throws BusinessException;

	public List<Customer> showCustomerByLastName(String lastName) throws BusinessException;

	public List<Customer> showCustomerByEmail(String emailId) throws BusinessException;

	public List<Customer> showCustomerByOrder(int orderId) throws BusinessException;
}
