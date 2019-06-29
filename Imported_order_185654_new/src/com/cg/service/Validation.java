package com.cg.service;

public interface Validation {
	//basic validation using regex notations
	String pricepattern="[1-9][0-9]*+[.]+[0-9]*";
	String pricepattern1="[1-9][0-9]*";
	String quantitypattern="[0-9]*";
	public static boolean validatePrice(String data)
	{
		return (data.matches(pricepattern)||data.matches(pricepattern1));
	}
	public static boolean validatedata(String data,String pattern)
	{
		return data.matches(pattern);
	}

}
