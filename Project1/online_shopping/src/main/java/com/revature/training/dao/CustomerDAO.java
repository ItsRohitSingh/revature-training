package com.revature.training.dao;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Customer;

public interface CustomerDAO {
	public int registerCustomer(Customer customer) throws BusinessException;

	public int getCustomerId(String emailId) throws BusinessException;

	public boolean checkLogin(String emailId, String password) throws BusinessException;

	public String fetchCustomerFirstName(int customerId) throws BusinessException;
}
