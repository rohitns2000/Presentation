package com.cg.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bean.Order;
import com.cg.dao.OrderRepoImpl;
import com.cg.service.OrderServiceImpl;

class ImportedorderTesting {
	OrderRepoImpl dao;
	OrderServiceImpl service;
	double amt= 100.0;
	double charges = 20.0;
	int id = 123;
	double price = 1234;
	int qty = 5;

	@Before
	public void init()
	{
		dao = new OrderRepoImpl();
		service = new OrderServiceImpl();
		service.setDao(dao);
	}
	
	@Test
	public void testNotNullOrder() throws NullPointerException
	{
		Order o = new Order(id, price, qty, amt, charges);
		assertNotNull(o);
	}
	
//	@Test
//	public void testOrder() 
//	{
//		Order o = new Order(id, price, qty, amt, charges);
//		assertEquals(service.saveOrderDetails(o),1);
//	}

	@After
	public void destroy()
	{
		dao = null;
		service = null;
	}
}
