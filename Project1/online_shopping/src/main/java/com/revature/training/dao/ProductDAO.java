package com.revature.training.dao;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Products;

public interface ProductDAO {
	public int addProduct(Products product) throws BusinessException;

	public int removeProduct(int productId) throws BusinessException;

	public int changeQuantity(int productId, int quantity) throws BusinessException;

	public int checkQuantity(int productId) throws BusinessException;
}
