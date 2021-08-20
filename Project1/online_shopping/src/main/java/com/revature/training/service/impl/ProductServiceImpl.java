package com.revature.training.service.impl;

import java.util.List;

import com.revature.training.dao.ProductDAO;
import com.revature.training.dao.impl.ProductDAOImpl;
import com.revature.training.exception.BusinessException;
import com.revature.training.model.Products;
import com.revature.training.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO = new ProductDAOImpl();
	@Override
	public int addProduct(Products product) throws BusinessException {
		int checkAddProduct = productDAO.addProduct(product);
		return checkAddProduct;
	}

	@Override
	public int removeProduct(String productName) throws BusinessException {
		int checkRemoveProduct = productDAO.removeProduct(productName);
		return checkRemoveProduct;
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
		List<Products> productList=null;
		if(name.matches("[a-zA-Z]{2,10}")) {
			productList=productDAO.showProductByName(name);
		}else {
			throw new BusinessException("Invalid Product name : "+name);
		}
		return productList;
	}

	@Override
	public List<Products> showProductByManufacturer(String manufacturer) throws BusinessException {
		List<Products> productList=null;
		if(manufacturer.matches("[a-zA-Z]{2,10}")) {
			productList=productDAO.showProductByManufacturer(manufacturer);
		}else {
			throw new BusinessException("Invalid Product Manufacturer name : "+manufacturer);
		}
		return productList;
	}

}
