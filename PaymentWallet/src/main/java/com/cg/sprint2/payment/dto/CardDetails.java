package com.cg.sprint2.payment.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carddetails")
public class CardDetails {
	@Id
	String mobileno;
	long cardno;
	String cardtype;
	int cvv;
	LocalDate expirydate;
	@Column(name="cbalance")
	double cardbalance=50000;
	
	public CardDetails() {}

	public CardDetails(String mobileno, long cardno, String cardtype, int cvv, LocalDate expirydate, double cardbalance) {
		super();
		this.mobileno = mobileno;
		this.cardno = cardno;
		this.cardtype = cardtype;
		this.cvv = cvv;
		this.expirydate = expirydate;
		this.cardbalance = cardbalance;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public long getCardno() {
		return cardno;
	}

	public void setCardno(long cardno) {
		this.cardno = cardno;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}

	public double getCardbalance() {
		return cardbalance;
	}

	public void setCardbalance(double cardbalance) {
		this.cardbalance = cardbalance;
	}
	
	

}
