package com.revature.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.training.dao.ProductDAO;
import com.revature.training.exception.BusinessException;
import com.revature.training.model.Products;
import com.revature.training.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public int addProduct(Products product) throws BusinessException {
		int add = 0;

		try (Connection connection = DBConnection.getConnection()) {
			String sql = "insert into products (productid, productname, productmanufacturer, productquantity, productprice) values (?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getProductManufacturer());
			preparedStatement.setInt(4, product.getQuantity());
			preparedStatement.setInt(5, product.getPrice());
			
			add = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Internal error occured contact sysadmin");
		}

		return add;
	}

	@Override
	public int removeProduct(int productId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int changeQuantity(int productId, int quantity) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkQuantity(int productId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Products> showProductByName(String name) throws BusinessException {
		List<Products> productList=new ArrayList<>();
		try(Connection connection=DBConnection.getConnection()){
			String sql="select productid, productname, productmanufacturer, productquantity, productprice from products where productname=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Products products=new Products();
				products.setProductId(resultSet.getInt("productid"));
				products.setProductName(resultSet.getString("productname"));
				products.setProductManufacturer(resultSet.getString("productmanufacturer"));
				products.setQuantity(resultSet.getInt("productquantity"));
				products.setPrice(resultSet.getInt("productprice"));
				
				productList.add(products);
			}
			
			if(productList.size()==0) {
				throw new BusinessException("No Product with name : "+name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return productList;
	}

	@Override
	public List<Products> showProductByManufacturer(String manufacturer) throws BusinessException {
		List<Products> productList=new ArrayList<>();
		try(Connection connection=DBConnection.getConnection()){
			String sql="select productid, productname, productmanufacturer, productquantity, productprice from products where productmanufacturer=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, manufacturer);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Products products=new Products();
				products.setProductId(resultSet.getInt("productid"));
				products.setProductName(resultSet.getString("productname"));
				products.setProductManufacturer(resultSet.getString("productmanufacturer"));
				products.setQuantity(resultSet.getInt("productquantity"));
				products.setPrice(resultSet.getInt("productprice"));
				
				productList.add(products);
			}
			
			if(productList.size()==0) {
				throw new BusinessException("No Product with manufacturer : "+manufacturer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return productList;
	}

}
