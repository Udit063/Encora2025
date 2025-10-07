package com.encora.service.bank;

public interface BankService {
	public void credit(int accNo, int amt) throws Throwable;
	public void debit(int accNo, int amt) throws Throwable;
}
