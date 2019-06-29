package com.cg.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.cg.bean.Order;
import com.cg.dao.OrderRepo;
import com.cg.dao.OrderRepoImpl;

public class OrderServiceImpl implements OrderService{
	OrderRepo ord = new OrderRepoImpl();

	@Override
	public double calculateOrder(Order o) {
		double amount = o.getPrice()*o.getQuantity()*75;
		return amount;
	}

	@Override
	public double calculateCharges(Order o) {
		double charges = o.getAmount()*0.0125;
		return charges;
	}

	@Override
	public int saveOrderDetails(Order o) {
		
		return ord.saveOrder(o);
	}

	@Override
	public void printAllOrder() {
		Iterator<Map.Entry<Integer, Order>> itr = ord.getAllOrder().entrySet().iterator(); 
        //getting all order details
        while(itr.hasNext()) 
        { 
             Entry<Integer, Order> entry = itr.next(); 
         	System.out.println("======================================");
             System.out.println("Product Id: "+ entry.getValue().getId());
             System.out.println("Product Price: "+ entry.getValue().getPrice()+"$");
             System.out.println("Product Quantity: "+ entry.getValue().getQuantity()+" pcs");
             System.out.println("Product Amount: "+ entry.getValue().getAmount()+" Rupees");
             System.out.println("Product Charges: "+ entry.getValue().getCharges()+" Rupees");
             System.out.println("Product Line Total: "+ (entry.getValue().getAmount()+entry.getValue().getCharges())+" Rupees");
         	System.out.println("======================================");
        } 
	}

	public void setDao(OrderRepoImpl dao) {
		
	}

	@Override
	public Map<Integer,Order> getAllOrder() {
		return ord.getAllOrder();
		// TODO Auto-generated method stub
		
	}


}
