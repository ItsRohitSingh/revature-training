package com.revature.training.service;

import java.util.List;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Products;

public interface ProductService {
	public int addProduct(Products product) throws BusinessException;

	public int removeProduct(String productName) throws BusinessException;

	public int changeQuantity(int productId, int quantity) throws BusinessException;

	public int checkQuantity(int productId) throws BusinessException;

	public List<Products> showProductByName(String name) throws BusinessException;

	public List<Products> showProductByManufacturer(String manufacturer) throws BusinessException;
}
