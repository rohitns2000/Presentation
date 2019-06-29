package com.cg.bean;

public class Order {
	//basic bean structure as per given data
	private int id;
	private double price;
	private int quantity;
	private double amount;
	private double charges;
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", price=" + price + ", quantity=" + quantity + ", amount=" + amount + ", charges="
				+ charges + "]";
	}
	public Order(int id, double price, int quantity, double amount, double charges) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.charges = charges;
	}
	public Order() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getCharges() {
		return charges;
	}
	public void setCharges(double charges) {
		this.charges = charges;
	}
	
	

}
