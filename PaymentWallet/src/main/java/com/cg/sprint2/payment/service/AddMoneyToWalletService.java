package com.cg.sprint2.payment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.sprint2.payment.dao.AddMoneyToWalletDAO;
import com.cg.sprint2.payment.dto.CardDetails;

@Service
public class AddMoneyToWalletService {
	@Autowired
	
	 AddMoneyToWalletDAO amdao;

	public void setAmdao(AddMoneyToWalletDAO amdao) {
		this.amdao = amdao;
	}
	
	
	  // Adding Card
	public CardDetails addcard(CardDetails card)
	{
		return amdao.save(card);
	}
	 @Transactional(readOnly=true)
	public List<CardDetails> getCarddetailsByMobileno(List<String> mobileno)
	{
		return amdao.findAllById(mobileno);
	}
	 //Add Money To Wallet
	 public double addMoney(int add,String mobileno)
	 {
		 
		 return amdao.addToWallet(add,mobileno);
	 }
	 // verify card number
	 public CardDetails checkCard(long cdno)
	 {
		 return amdao.verifyCardNo(cdno);
	 }
	 // Deducting Amount From Card
	 public double dedcutBalance(double deduct,long cdno)
	 {
		 return amdao.deductBalance(deduct,cdno);
	 }
}

