package com.cg.dao;

import java.util.Map;

import com.cg.bean.Order;

public interface OrderRepo {
	//classes implemented in Impl
	int saveOrder(Order bean);
	Map<Integer,Order> getAllOrder();

}
