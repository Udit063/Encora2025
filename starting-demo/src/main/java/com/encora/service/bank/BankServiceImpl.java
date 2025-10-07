package com.encora.service.bank;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.encora.exceptions.UserNotFoundException;
import com.encora.exceptions.bank.InsufficientBalanceException;
import com.encora.model.bank.Accounts;
import com.encora.repository.bank.AccountsRepo;

@Transactional
@Service
public class BankServiceImpl implements BankService{
	@Autowired
	private AccountsRepo accRepo;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void credit(int accNo, int amt) throws Throwable {
		System.out.println("acc no - "+ accNo);
		Accounts accounts = accRepo.findById(accNo).orElseThrow(()-> new UserNotFoundException());
		int old_amt = accounts.getAmount();
		int new_amt = old_amt + amt;
		accounts.setAmount(new_amt);
		accRepo.save(accounts);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = InsufficientBalanceException.class)
	@Override
	public void debit(int accNo, int amt) throws Throwable {
		Accounts accounts = accRepo.findById(accNo).orElseThrow(()-> new UserNotFoundException());
		int old_amt = accounts.getAmount();
		
		int new_amt = Optional.ofNullable(old_amt).filter(o -> o - amt > 0).map(a -> a - amt).orElseThrow(()-> new InsufficientBalanceException("Insufficient Balance!! "));
		accounts.setAmount(new_amt);
		accRepo.save(accounts);
	}
}
