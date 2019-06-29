package com.cg.pl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cg.bean.Order;
import com.cg.exception.QuantityException;
import com.cg.service.OrderServiceImpl;
import com.cg.service.Validation;



public class ImportedOrder {
	public static void main(String[] args) {
		//Taking price and quantity from the user as an input in Dollars
		//calculated amount as price*quantity*75
		//calculated service charges on top of amount
		//line total is nothing but the charges and amount

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		OrderServiceImpl service=new OrderServiceImpl();
		while(true) {
			System.out.println("==============MENU====================");
	        System.out.println("1. Enter price(Dollars) and Quantity");
	        System.out.println("2. Display All the orders");
	        System.out.println("3. Exit");
	        System.out.println("Enter your choice\n");
	        String choice;
			try {
				choice = br.readLine();
				switch (choice) {
				
			case "1"://input taken.. 
					int qty; double price;
					System.out.println("Enter Product Details ");
					System.out.println("Enter the product price(in dollars): ");
					while(true)
					{
					String pri=br.readLine();
					//validating price
					boolean b1 = Validation.validatePrice(pri);
					if(b1 == true)
					{
						try 
						{
							price = Double.parseDouble(pri);
							break;
						}
						catch(Exception e)
						{
							System.out.println("Enter Again!!!");
						}
					}
					else
					{
						System.out.println("Wrong details Enter Again!!!");
					}
					}
					
					System.out.println("Enter the quantity: ");
					while(true)
					{
						//validating quantity entered
					String quantity=br.readLine();
					boolean b1 = Validation.validatedata(quantity, Validation.quantitypattern);
					if(b1 == true)
					{
						try 
						{	
							qty = Integer.parseInt(quantity);
							break;
						}
						catch(Exception e)
						{
							System.out.println("Enter Again!!!");
						}
					}
					else
					{
						System.out.println("Wrong input.Enter Valid Numbers:");
					}

					}
					//if Quantity Entered is 0 raises an exception but adds in database
					try {
					if(qty==0)
					{
						throw new QuantityException("0 entered");
					}
					}
					catch(QuantityException e1)
					{
						System.err.println("Quantity Entered is 0!!!");
					}
					//generating a default constructor so as to pass values and get the details
					Order o = new Order();
					o.setPrice(price);
					o.setQuantity(qty);
					//getting amount from service
					double amount = service.calculateOrder(o);
					o.setAmount(amount);
					//getting charges from service
					double charges = service.calculateCharges(o);
					int id = (int)(Math.random()*1000);
					//final order preparation
					Order fin = new Order(id, price, qty, amount, charges);
					//System.out.println(fin);
					//saving the order into the hash map
					service.saveOrderDetails(fin);
					break;
					
			case "2": //printing all the order
					service.printAllOrder();
	                   break;
			case "3"://exiting the interface
					System.out.println("Thank You have a nice day!");
					   System.exit(0);
	                   break;
	                   
	            default://all other values other than 3 are invalid
	            	  System.out.println("Invalid choice");
		        }
			} catch (IOException e) {
				e.printStackTrace();
			}

	    }
    }
}



