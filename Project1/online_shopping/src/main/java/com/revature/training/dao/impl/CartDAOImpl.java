package com.revature.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.training.dao.CartDAO;
import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;
import com.revature.training.util.DBConnection;

public class CartDAOImpl implements CartDAO {

	@Override
	public int addToCart(Cart cart) throws BusinessException {
		int add = 0;
		try (Connection connection = DBConnection.getConnection()) {
			String sql = "insert into cart (ca_cu_id, ca_pr_id, ca_pr_name, ca_quantity, ca_price) values (?,?,?,?,?);";
			
			PreparedStatement addCartStatement = connection.prepareStatement(sql);
			addCartStatement.setInt(1, cart.getCartCustomerId());
			addCartStatement.setInt(2, cart.getCartProductId());
			addCartStatement.setString(3, cart.getCartProductName());
			addCartStatement.setInt(4, cart.getQuantity());
			addCartStatement.setInt(5, cart.getPrice());
			
			add = addCartStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return add;
	}

	@Override
	public int removeFromCart(int customerId, int productId) throws BusinessException {
		int delete=0;
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "delete from cart where ca_cu_id = ? and ca_pr_id = ? ;";
			
			PreparedStatement deleteCartStatement = connection.prepareStatement(sql);
			deleteCartStatement.setInt(1, customerId);
			deleteCartStatement.setInt(2, productId);
			
			delete = deleteCartStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return delete;
	}

	@Override
	public int changeQuantity(int customerId, int productId, int quantity) throws BusinessException {
		int change=0;
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "update cart set ca_quantity = ? where ca_cu_id = ? and ca_pr_id = ?";
			
			PreparedStatement changeQuantityStatement = connection.prepareStatement(sql);
			changeQuantityStatement.setInt(1, quantity);
			changeQuantityStatement.setInt(2, customerId);
			changeQuantityStatement.setInt(3, productId);
			
			change = changeQuantityStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return change;
	}

}
