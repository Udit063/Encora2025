package com.encora.exceptions.bank;

public class InsufficientBalanceException extends Throwable {
	String message;
	 public InsufficientBalanceException(String msg) {
		 this.message = msg;
	 }
	 
	 @Override
	public String toString() {
		return "Exception: " + message;
	}

}
