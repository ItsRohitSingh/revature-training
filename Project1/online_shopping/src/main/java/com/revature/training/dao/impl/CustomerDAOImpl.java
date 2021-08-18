package com.revature.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.training.dao.CustomerDAO;
import com.revature.training.exception.BusinessException;
import com.revature.training.model.Customer;
import com.revature.training.util.DBConnection;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public int registerCustomer(Customer customer) throws BusinessException {
		int add = 0;
		try (Connection connection = DBConnection.getConnection()) {
			String sql = "insert into customer (firstname, lastname, email, password) values (?,?,?,?);";

			PreparedStatement addCustomerStatement = connection.prepareStatement(sql);
			addCustomerStatement.setString(1, customer.getFirstName());
			addCustomerStatement.setString(2, customer.getLastName());
			addCustomerStatement.setString(3, customer.getEmailId());
			addCustomerStatement.setString(4, customer.getPassword());

			add = addCustomerStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return add;
	}

	@Override
	public int getCustomerId(String emailId) throws BusinessException {
		List<Integer> customerList = new ArrayList<>();
		int customerId = 0;
		try (Connection connection = DBConnection.getConnection()) {
			String sql = "select customerid from customer where email=?";

			PreparedStatement checkCustomerIdStatement = connection.prepareStatement(sql);
			checkCustomerIdStatement.setString(1, emailId);

			ResultSet resultSet = checkCustomerIdStatement.executeQuery();

			while (resultSet.next()) {
				customerId = resultSet.getInt("customerid");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerId;
	}

	@Override
	public boolean checkLogin(String emailId, String password) throws BusinessException {
		List<String> customerList = new ArrayList<>();
		try (Connection connection = DBConnection.getConnection()) {
			String sql = "select password from customer where email=?";

			PreparedStatement checkCustomerIdStatement = connection.prepareStatement(sql);
			checkCustomerIdStatement.setString(1, emailId);

			ResultSet resultSet = checkCustomerIdStatement.executeQuery();

			while (resultSet.next()) {
				customerList.add(resultSet.getString("password"));
			}
			if (customerList.size() != 1) {
				throw new BusinessException("Email-Id does not exist. Please enter correct Email-Id or register for a new account.");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (customerList.get(0).equals(password)) {
			return true;
		} else {
			throw new BusinessException("Incorrect Password! Please input correct Password.");
		}
	}

	@Override
	public String fetchCustomerFirstName(int customerId) throws BusinessException {
		String name = null;
		try (Connection connection = DBConnection.getConnection()) {
			
			String sql = "select firstname from customer where customerid=?";

			PreparedStatement checkCustomerIdStatement = connection.prepareStatement(sql);
			checkCustomerIdStatement.setInt(1, customerId);

			ResultSet resultSet = checkCustomerIdStatement.executeQuery();

			while (resultSet.next()) {
				name = resultSet.getString("firstname");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;
	}
}
