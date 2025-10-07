package com.encora.service.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	BankServiceImpl bsi;
	@Override
	public void doTransaction(int crid, int drid, int amt) throws Throwable {
		bsi.debit(drid, amt);
		bsi.credit(crid, amt);
	}		
}
