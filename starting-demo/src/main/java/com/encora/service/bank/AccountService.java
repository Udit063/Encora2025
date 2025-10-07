package com.encora.service.bank;

public interface AccountService {
	public void doTransaction(int crid, int drid, int amt) throws Throwable;
}
