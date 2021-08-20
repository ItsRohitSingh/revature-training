package com.revature.training.service.impl;

import java.util.List;

import com.revature.training.dao.CustomerDAO;
import com.revature.training.dao.impl.CustomerDAOImpl;
import com.revature.training.exception.BusinessException;
import com.revature.training.model.Customer;
import com.revature.training.model.Products;
import com.revature.training.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public int registerCustomer(Customer customer) throws BusinessException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		int checkRegister = 0;
		if (customer.getFirstName().matches("[a-zA-Z]{2,25}")) {
			if (customer.getLastName().matches("[a-zA-Z]{2,25}")) {
				if (customer.getEmailId().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
					if((customer.getPassword().length() >= 8) && (customer.getPassword().length() <= 16)) {
						checkRegister = customerDAO.registerCustomer(customer);
					}
					else {
						throw new BusinessException("Password length should be between 8 to 16 characters.");
					}
				}
				else {
					throw new BusinessException("Invalid Email! Please enter a valid Email-Id.");
				}
			}
			else {
				throw new BusinessException("Last Name should be of minimum 2 characters and maximum 25 characters.");
			}
		}
		else {
			throw new BusinessException("First Name should be of minimum 2 characters and maximum 25 characters.");
		}
		
		return checkRegister;
	}
	
	@Override
	public int deleteCustomer(String emailId) throws BusinessException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		if(emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			int delete = customerDAO.deleteCustomer(emailId);
			return delete;
		}
		else {
			throw new BusinessException("Please enter valid Email-Id.");
		}
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
		if (emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			if (password.length() >= 8 && password.length() <= 16) {
				boolean result = customerDAO.checkLogin(emailId, password);
				return result;
			} else {
				throw new BusinessException("Password Length should be between 8-16 characters.");
			}
		} else {
			throw new BusinessException("Please enter valid Email-Id.");
		}
	}

	@Override
	public String fetchCustomerFirstName(int customerId) throws BusinessException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		String customerFirstName = customerDAO.fetchCustomerFirstName(customerId);
		return customerFirstName;
	}

	@Override
	public List<Customer> showCustomerByFirstName(String firstName) throws BusinessException {
		List<Customer> customerList = null;
		CustomerDAO customerDAO = new CustomerDAOImpl();
		if (firstName.matches("[a-zA-Z]{2,10}")) {
			customerList = customerDAO.showCustomerByFirstName(firstName);
		} else {
			throw new BusinessException("Invalid Customer First Name : " + firstName);
		}
		return customerList;
	}

	@Override
	public List<Customer> showCustomerByLastName(String lastName) throws BusinessException {
		List<Customer> customerList = null;
		CustomerDAO customerDAO = new CustomerDAOImpl();
		if (lastName.matches("[a-zA-Z]{2,10}")) {
			customerList = customerDAO.showCustomerByLastName(lastName);
		} else {
			throw new BusinessException("Invalid Customer Last Name : " + lastName);
		}
		return customerList;
	}

	@Override
	public List<Customer> showCustomerByEmail(String emailId) throws BusinessException {
		List<Customer> customerList = null;
		CustomerDAO customerDAO = new CustomerDAOImpl();
		if (emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			customerList = customerDAO.showCustomerByEmail(emailId);
		} else {
			throw new BusinessException("Invalid Customer Email-Id : " + emailId);
		}
		return customerList;
	}

	@Override
	public List<Customer> showCustomerByOrder(int orderId) throws BusinessException {
		List<Customer> customerList = null;
		CustomerDAO customerDAO = new CustomerDAOImpl();
		customerList = customerDAO.showCustomerByOrder(orderId);
		return customerList;
	}

}
