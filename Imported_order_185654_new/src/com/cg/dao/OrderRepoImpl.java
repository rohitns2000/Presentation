package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.bean.Order;

public class OrderRepoImpl implements OrderRepo {
	//saving the order into the hash map and retrieving the same
	Map<Integer,Order> hsmp = new HashMap<Integer,Order>();

	@Override
	public int saveOrder(Order bean) {
	 hsmp.put(bean.getId(), bean);
	 return 1;
	}

	@Override
	public Map<Integer, Order> getAllOrder() {
		return hsmp;
	}


}
