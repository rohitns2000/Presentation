package com.cg.exception;

public class QuantityException extends RuntimeException{
	//custom exception class for quantity 0
	String message;
	
	public QuantityException(String message){
		this.message = message;
	};
	
	@Override
	public String getMessage()
	{
		return this.message;
	}

}
