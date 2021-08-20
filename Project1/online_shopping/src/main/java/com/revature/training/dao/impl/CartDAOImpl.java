package com.revature.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.training.dao.CartDAO;
import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;
import com.revature.training.model.Products;
import com.revature.training.util.DBConnection;

public class CartDAOImpl implements CartDAO {

	@Override
	public String fetchProductName(int productId) throws BusinessException {
		String productName = null ;
		try (Connection connection = DBConnection.getConnection()) {
			String sql = "select productname from products where productid=?";

			PreparedStatement fetchProductDetails = connection.prepareStatement(sql);
			fetchProductDetails.setInt(1, productId);
			
			ResultSet resultSet = fetchProductDetails.executeQuery();
			while(resultSet.next()) {
				productName = resultSet.getString("productname");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return productName;
	}
	
	@Override
	public int fetchProductQuantity(int productId) throws BusinessException {
		int productQuantity = 0;
		try (Connection connection = DBConnection.getConnection()) {
			String sql = "select productquantity from products where productid=?";

			PreparedStatement fetchProductDetails = connection.prepareStatement(sql);
			fetchProductDetails.setInt(1, productId);
			
			ResultSet resultSet = fetchProductDetails.executeQuery();
			while(resultSet.next()) {
				productQuantity = resultSet.getInt("productquantity");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return productQuantity;
	}

	@Override
	public int fetchProductPrice(int productId) throws BusinessException {
		int productPrice = 0;
		try (Connection connection = DBConnection.getConnection()) {
			String sql = "select productprice from products where productid=?";

			PreparedStatement fetchProductDetails = connection.prepareStatement(sql);
			fetchProductDetails.setInt(1, productId);
			
			ResultSet resultSet = fetchProductDetails.executeQuery();
			while(resultSet.next()) {
				productPrice = resultSet.getInt("productprice");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return productPrice;
	}

	@Override
	public int addToCart(Cart cart) throws BusinessException {
		int add = 0;
		try (Connection connection = DBConnection.getConnection()) {
			
			
			String sql = "insert into cart (cartcustomerid, cartproductid, cartproductname, cartquantity, cartprice) values (?,?,?,?,?);";
			
			PreparedStatement addCartStatement = connection.prepareStatement(sql);
			addCartStatement.setInt(1, cart.getCartCustomerId());
			addCartStatement.setInt(2, cart.getCartProductId());
			addCartStatement.setString(3, cart.getCartProductName());
			addCartStatement.setInt(4, cart.getQuantity());
			addCartStatement.setInt(5, cart.getPrice());
			
			add = addCartStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return add;
	}

	@Override
	public int removeFromCart(int customerId, int productId) throws BusinessException {
		int delete = 0;
		try (Connection connection = DBConnection.getConnection()) {
			String sql = "delete from cart where cartcustomerid = ? and cartproductid = ? ;";

			PreparedStatement deleteCartStatement = connection.prepareStatement(sql);
			deleteCartStatement.setInt(1, customerId);
			deleteCartStatement.setInt(2, productId);

			delete = deleteCartStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return delete;
	}

	@Override
	public int changeQuantity(int customerId, int productId, int newQuantity, int price) throws BusinessException {
		int change = 0;
		int changePrice = 0;
		try (Connection connection = DBConnection.getConnection()) {
			String sql = "update cart set cartquantity = ? where cartcustomerid = ? and cartproductid = ?";
			
			String sql2 = "update cart set cartprice = ?*? where cartcustomerid = ? and cartproductid = ?";

			PreparedStatement changeQuantityStatement = connection.prepareStatement(sql);
			changeQuantityStatement.setInt(1, newQuantity);
			changeQuantityStatement.setInt(2, customerId);
			changeQuantityStatement.setInt(3, productId);
			
			PreparedStatement updatePrice = connection.prepareStatement(sql2);
			updatePrice.setInt(1, newQuantity);
			updatePrice.setInt(2, price);
			updatePrice.setInt(3, customerId);
			updatePrice.setInt(4, productId);
			
			changePrice = updatePrice.executeUpdate();

			change = changeQuantityStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return change+changePrice;
	}

	@Override
	public List<Cart> viewCartByCustomer(int customerId) throws BusinessException {
		List<Cart> cartList = new ArrayList<>();
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "select cartproductid, cartproductname, cartquantity, cartprice from cart where cartcustomerid = ?";
			
			PreparedStatement viewCart = connection.prepareStatement(sql);
			viewCart.setInt(1, customerId);
			
			ResultSet resultSet = viewCart.executeQuery();
			
			while(resultSet.next()) {
				Cart cart = new Cart();
				cart.setCartProductId(resultSet.getInt("cartproductid"));
				cart.setCartProductName(resultSet.getString("cartproductname"));
				cart.setQuantity(resultSet.getInt("cartquantity"));
				cart.setPrice(resultSet.getInt("cartprice"));
				
				cartList.add(cart);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public boolean checkProductInCart(int customerId, int productId) throws BusinessException {
		boolean isProductInCart = false;
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "select cartproductname from cart where cartcustomerid = ? and cartproductid = ?";
			
			PreparedStatement checkProduct = connection.prepareStatement(sql);
			checkProduct.setInt(1, customerId);
			checkProduct.setInt(2, productId);
			
			ResultSet resultSet = checkProduct.executeQuery();
			
			if(resultSet.next()) {
				isProductInCart = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return isProductInCart;
	}

	@Override
	public int checkQuantityInCart(int customerId, int productId) throws BusinessException {
		int quantityInCart = 0;
		try(Connection connection = DBConnection.getConnection()) {
			String sql = "select cartquantity from cart where cartcustomerid = ? and cartproductid = ?";
			
			PreparedStatement checkProduct = connection.prepareStatement(sql);
			checkProduct.setInt(1, customerId);
			checkProduct.setInt(2, productId);
			
			ResultSet resultSet = checkProduct.executeQuery();
			
			if(resultSet.next()) {
				quantityInCart = resultSet.getInt("cartquantity");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return quantityInCart;
	}
}
