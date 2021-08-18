package com.revature.training.dao;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Order;

public interface OrderDAO {
	public int addOrder(Order order) throws BusinessException;

	public int updateOrderStatus(int orderId, String orderStatus) throws BusinessException;
}
