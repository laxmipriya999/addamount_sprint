package com.capg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.model.Bank;
import com.capg.model.Transaction;
@Repository
public class BankDaoImp implements BankDao {

	@Autowired
	BankRepo brepo;
	@Autowired
	TransactionRepo trepo;

	@Override
	public Bank createAccount(Bank bank) {

		  Transaction tran = new Transaction(); tran.setBalance(bank.getBalance());
		  tran.setCreditedAmount(bank.getBalance());
		  tran.setTransactionId((long)(Math.random()*1000));
		  tran.setDebitedAmount((double) 0); tran.setAccNo(bank.getAccNo()); trepo.save(tran);
		 
		 
		return brepo.save(bank);
	}

	@Override
	public Bank showBalance(Long accNo) {
		// TODO Auto-generated method stub
		return brepo.findByAccNo(accNo);
		
	}

	@Override
	public Bank deposite(Long accNo, Double depositeAmount) {
		// TODO Auto-generated method stub
		
		
		Bank bank= brepo.findByAccNo(accNo);
		Double currentBal= bank.getBalance();
		Transaction tran=new Transaction();
		tran.setTransactionId((long)(Math.random()*1000));
		tran.setCreditedAmount(depositeAmount);
		tran.setDebitedAmount((double)0);
		tran.setBalance(currentBal+depositeAmount);
		tran.setAccNo(accNo);
		trepo.save(tran);
		bank.setBalance(currentBal+depositeAmount);
		return brepo.save(bank);
	}

	@Override
	public Bank getAccount(Long accNo) {
		// TODO Auto-generated method stub
		return brepo.findByAccNo(accNo);
	}

	@Override
	public Bank withdraw(Long accNo, Double withdrawAmount) {

		Bank bank = brepo.findByAccNo(accNo);
		Transaction tran = new Transaction();
		tran.setTransactionId((long)(Math.random()*1000));
		tran.setAccNo(accNo);
		tran.setDebitedAmount(withdrawAmount);
		tran.setCreditedAmount((double)0);
		Double currentBal = bank.getBalance();
		tran.setBalance(currentBal-withdrawAmount);
		bank.setBalance(currentBal-withdrawAmount);
		trepo.save(tran);
		return brepo.save(bank);
	}

	@Override
	public List<Transaction> printTransactions(Long accNo) {
		// TODO Auto-generated method stub
		return trepo.findAllByAccNo(accNo);
	}

	@Override
	public Bank fundTransfer(Long saccNo, Long raccNo, Double transferAmount) {
		
		Bank sBank=withdraw(saccNo, transferAmount);
		deposite(raccNo, transferAmount);
		
		return sBank;
	}

	
}
