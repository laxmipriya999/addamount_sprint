package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Bank;
import com.capg.model.Transaction;
import com.capg.service.BankService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BankController {

	@Autowired
	private BankService service;
	
	
	@PostMapping(path="/create")
	public Bank createAccount(@RequestBody Bank bank)
	{
		return service.createAccount(bank);
	}

	@GetMapping(path="/show/{id}")
	public Bank showBalance(@PathVariable Long id)
	{
		return service.showBalance(id);
	}
	@GetMapping(path="/deposite/{accNo}&{depositeAmount}")
	public Bank deposite(@PathVariable Long accNo,@PathVariable Double depositeAmount)
	{
		return service.deposite(accNo,depositeAmount);
	}
	@GetMapping(path="/get/{accNo}")
	public Bank getAccount(@PathVariable Long accNo) {
		return service.getAccount(accNo);
	}
	@GetMapping(path="/withdraw/{accNo}&{withdrawAmount}")
	public Bank withdraw(@PathVariable Long accNo,@PathVariable Double withdrawAmount)
	{
		return service.withdraw(accNo,withdrawAmount);
	}
	@GetMapping(path="/print/{accNo}")
	public List<Transaction> printTransactions(@PathVariable Long accNo)
	{
		return service.printTransactions(accNo);
	}
	@GetMapping(path="/fund/{saccNo}&{raccNo}&{transferAmount}")
	public Bank fundTranfer(@PathVariable Long saccNo,@PathVariable Long raccNo,@PathVariable Double transferAmount) {
		return service.fundTransfer(saccNo,raccNo,transferAmount);
	}
}