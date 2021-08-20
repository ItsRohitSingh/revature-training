package com.revature.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.training.dao.OrderDAO;
import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;
import com.revature.training.model.Order;
import com.revature.training.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public int addOrder(Order order) throws BusinessException {
		int checkAdd = 0;
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "insert into project1_onlineshopping.order (ordercustomerid, orderproductid, orderproductname, orderquantity, orderprice, orderstatus) values (?,?,?,?,?,?)" ;
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, order.getOrderCustomerId());
			preparedStatement.setInt(2, order.getOrderProductId());
			preparedStatement.setString(3, order.getOrderProductName());
			preparedStatement.setInt(4, order.getOrderQuantity());
			preparedStatement.setInt(5, order.getOrderPrice());
			preparedStatement.setString(6, order.getOrderStatus());
			
			checkAdd = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkAdd;
	}

	@Override
	public int updateOrderStatus(int orderId, String orderStatus) throws BusinessException {
		int updateStatus = 0;
		
		try(Connection connection = DBConnection.getConnection()) {
			
			String sql = "update project1_onlineshopping.order set orderstatus = ? where orderid = ?";
			
			PreparedStatement updateStatement = connection.prepareStatement(sql);
			
			updateStatement.setString(1, orderStatus);
			updateStatement.setInt(2, orderId);
			
			updateStatus = updateStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updateStatus;
	}

	@Override
	public List<Order> viewOrderByCustomer(int customerId) throws BusinessException {
		List<Order> orderList = new ArrayList<>();
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "select orderid, orderproductid, orderproductname, orderquantity, orderprice, orderstatus from project1_onlineshopping.order where ordercustomerid = ?";
			
			PreparedStatement fetchCart = connection.prepareStatement(sql);
			fetchCart.setInt(1, customerId);
			
			ResultSet resultSet = fetchCart.executeQuery();
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrderId(resultSet.getInt("orderid"));
				order.setOrderProductId(resultSet.getInt("orderproductid"));
				order.setOrderProductName(resultSet.getString("orderproductname"));
				order.setOrderQuantity(resultSet.getInt("orderquantity"));
				order.setOrderPrice(resultSet.getInt("orderprice"));
				order.setOrderStatus(resultSet.getString("orderstatus"));
				
				orderList.add(order);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public List<Integer> fetchProductIdFromCart(int customerId) throws BusinessException {
		List<Integer> cartList = new ArrayList<>();
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "select cartproductid from cart where cartcustomerid = ?";
			
			PreparedStatement fetchCart = connection.prepareStatement(sql);
			fetchCart.setInt(1, customerId);
			
			ResultSet resultSet = fetchCart.executeQuery();
			while(resultSet.next()) {
							
				cartList.add(resultSet.getInt("cartproductid"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public List<String> fetchProductNameFromCart(int customerId) throws BusinessException {
		List<String> cartList = new ArrayList<>();
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "select cartproductname from cart where cartcustomerid = ?";
			
			PreparedStatement fetchCart = connection.prepareStatement(sql);
			fetchCart.setInt(1, customerId);
			
			ResultSet resultSet = fetchCart.executeQuery();
			while(resultSet.next()) {
							
				cartList.add(resultSet.getString("cartproductname"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public List<Integer> fetchQuantityFromCart(int customerId) throws BusinessException {
		List<Integer> cartList = new ArrayList<>();
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "select cartquantity from cart where cartcustomerid = ?";
			
			PreparedStatement fetchCart = connection.prepareStatement(sql);
			fetchCart.setInt(1, customerId);
			
			ResultSet resultSet = fetchCart.executeQuery();
			while(resultSet.next()) {
							
				cartList.add(resultSet.getInt("cartquantity"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public List<Integer> fetchPriceFromCart(int customerId) throws BusinessException {
		List<Integer> cartList = new ArrayList<>();
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "select cartprice from cart where cartcustomerid = ?";
			
			PreparedStatement fetchCart = connection.prepareStatement(sql);
			fetchCart.setInt(1, customerId);
			
			ResultSet resultSet = fetchCart.executeQuery();
			while(resultSet.next()) {
							
				cartList.add(resultSet.getInt("cartprice"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public int deleteAllFromCart(int customerId) throws BusinessException {
		int checkDelete = 0;
		
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "delete from cart where cartcustomerid = ?";
			
			PreparedStatement deleteStatement = connection.prepareStatement(sql);
			deleteStatement.setInt(1, customerId);
			
			checkDelete = deleteStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return checkDelete;
	}

	@Override
	public List<Order> viewAllOrders() throws BusinessException {
		List<Order> orderList = new ArrayList<>();
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "select orderid, orderproductid, orderproductname, orderquantity, orderprice, orderstatus from project1_onlineshopping.order";
			
			PreparedStatement fetchCart = connection.prepareStatement(sql);
			
			ResultSet resultSet = fetchCart.executeQuery();
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrderId(resultSet.getInt("orderid"));
				order.setOrderProductId(resultSet.getInt("orderproductid"));
				order.setOrderProductName(resultSet.getString("orderproductname"));
				order.setOrderQuantity(resultSet.getInt("orderquantity"));
				order.setOrderPrice(resultSet.getInt("orderprice"));
				order.setOrderStatus(resultSet.getString("orderstatus"));
				
				orderList.add(order);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public int updateQuantityProduct(int productId, int quantityPurchased) throws BusinessException {
		int updateProduct = 0;
		
		try(Connection connection = DBConnection.getConnection()) {
			
			String sql = "update products set productquantity = productquantity - ? where productid = ?";
			
			PreparedStatement updateStatement = connection.prepareStatement(sql);
			updateStatement.setInt(1, quantityPurchased);
			updateStatement.setInt(2, productId);
			
			updateProduct = updateStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updateProduct;
	}

}
