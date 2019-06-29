package com.cg.service;

import java.util.Map;

import com.cg.bean.Order;

public interface OrderService {
	//classes implemented in impl
	double calculateOrder(Order o);
	double calculateCharges(Order o);
	int saveOrderDetails(Order o);
	void printAllOrder();
	public Map<Integer,Order> getAllOrder();

}
