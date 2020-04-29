package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.BankDao;
import com.capg.model.Bank;
import com.capg.model.Transaction;

@Service
public class BankServiceImp implements BankService{

	@Autowired
	private BankDao dao;
	
	@Override
	public Bank createAccount(Bank bank) {
		
		return dao.createAccount(bank);
	}

	@Override
	public Bank showBalance(Long accNo) {
		// TODO Auto-generated method stub
		return dao.showBalance(accNo);
	}

	@Override
	public Bank deposite(Long accNo, Double depositeAmount) {
		// TODO Auto-generated method stub
		return dao.deposite(accNo,depositeAmount);
	}

	@Override
	public Bank getAccount(Long accNo) {
		// TODO Auto-generated method stub
		return dao.getAccount(accNo);
	}

	@Override
	public Bank withdraw(Long accNo, Double withdrawAmount) {
		// TODO Auto-generated method stub
		return dao.withdraw(accNo,withdrawAmount);
	}

	@Override
	public List<Transaction> printTransactions(Long accNo) {
		// TODO Auto-generated method stub
		return dao.printTransactions(accNo);
	}

	@Override
	public Bank fundTransfer(Long saccNo, Long raccNo, Double transferAmount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(saccNo,raccNo,transferAmount);
	}

	
}
