package com.revature.training.service.impl;

import java.util.List;

import com.revature.training.dao.OrderDAO;
import com.revature.training.dao.impl.OrderDAOImpl;
import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;
import com.revature.training.model.Order;
import com.revature.training.service.OrderService;

public class OrderServiceImpl implements OrderService {

	OrderDAO orderDAO = new OrderDAOImpl();
	
	@Override
	public int addOrder(int customerId) throws BusinessException {
		int checkAdd = 0;
		
		List<Integer> productIdList = orderDAO.fetchProductIdFromCart(customerId);
		List<String> productNameList = orderDAO.fetchProductNameFromCart(customerId);
		List<Integer> quantityList = orderDAO.fetchQuantityFromCart(customerId);
		List<Integer> priceList = orderDAO.fetchPriceFromCart(customerId);
		
		for(int i=0; i<productIdList.size(); i++) {
			Order order = new Order();
			order.setOrderCustomerId(customerId);
			order.setOrderProductId(productIdList.get(i));
			order.setOrderProductName(productNameList.get(i));
			order.setOrderQuantity(quantityList.get(i));
			order.setOrderPrice(priceList.get(i));
			order.setOrderStatus("Ordered");
			
			int checkOrder = orderDAO.addOrder(order);
			if(checkOrder == 1) {
				checkAdd += 1;
			}
		}
		
		return checkAdd;
	}

	@Override
	public int updateOrderStatus(int orderId, String orderStatus) throws BusinessException {
		int checkUpdate = orderDAO.updateOrderStatus(orderId, orderStatus);
		return checkUpdate;
	}

	@Override
	public List<Cart> fetchCartForCustomer(int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> viewOrderByCustomer(int customerId) throws BusinessException {
		List<Order> orderList = orderDAO.viewOrderByCustomer(customerId);
		return orderList;
	}

	@Override
	public int deleteAllFromCart(int customerId) throws BusinessException {
		int checkDelete = orderDAO.deleteAllFromCart(customerId);
		return checkDelete;
	}

	@Override
	public List<Order> viewAllOrders() throws BusinessException {
		List<Order> orderList = orderDAO.viewAllOrders();
		return orderList;
	}

	@Override
	public int updateQuantityProduct(int productId, int quantityPurchased) throws BusinessException {
		int updateProduct = 0;
		updateProduct = orderDAO.updateQuantityProduct(productId, quantityPurchased);
		
		return updateProduct;
	}

}
