package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Transaction_master")
public class Transaction {
	
	@Id
	private Long transactionId;
	private Double creditedAmount;
	private Double debitedAmount;
	private Double balance;
	private Long accNo;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Double getCreditedAmount() {
		return creditedAmount;
	}
	public void setCreditedAmount(Double creditedAmount) {
		this.creditedAmount = creditedAmount;
	}
	public Double getDebitedAmount() {
		return debitedAmount;
	}
	public void setDebitedAmount(Double debitedAmount) {
		this.debitedAmount = debitedAmount;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Long getAccNo() {
		return accNo;
	}
	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", creditedAmount=" + creditedAmount + ", debitedAmount="
				+ debitedAmount + ", balance=" + balance + ", accNo=" + accNo + "]";
	}
		
}
