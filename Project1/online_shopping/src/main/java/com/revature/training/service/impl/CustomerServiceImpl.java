package com.revature.training.service.impl;

import com.revature.training.dao.CustomerDAO;
import com.revature.training.dao.impl.CustomerDAOImpl;
import com.revature.training.exception.BusinessException;
import com.revature.training.model.Customer;
import com.revature.training.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	
	@Override
	public int registerCustomer(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCustomerId(String emailId) throws BusinessException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		int customerId = customerDAO.getCustomerId(emailId);
		return customerId;
	}

	@Override
	public boolean checkLogin(String emailId, String password) throws BusinessException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		if(emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			if(password.length()>=8 && password.length()<=16) {
				boolean result = customerDAO.checkLogin(emailId, password);
				return result;
			}
			else {
				throw new BusinessException("Password Length should be between 8-16 characters.");
			}
		}
		else {
			throw new BusinessException("Please enter valid Email-Id.");
		}
	}

	@Override
	public String fetchCustomerFirstName(int customerId) throws BusinessException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		String customerFirstName = customerDAO.fetchCustomerFirstName(customerId);
		return customerFirstName;
	}

}
