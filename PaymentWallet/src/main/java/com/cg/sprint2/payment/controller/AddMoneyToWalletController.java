package com.cg.sprint2.payment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint2.payment.dto.CardDetails;
import com.cg.sprint2.payment.service.AddMoneyToWalletService;

@RestController
public class AddMoneyToWalletController{
	
	@Autowired
	AddMoneyToWalletService amservice;
	
	public void setAmservice(AddMoneyToWalletService amservice) {
		this.amservice = amservice;
	}
	
	//Add Card to the User
	@PostMapping(value="/addcard/{mobileno}",consumes="application/json")
	public ResponseEntity<String> addNewCard(@RequestBody CardDetails cdetails,@PathVariable String mobileno)
	{
		cdetails.setMobileno(mobileno);
		String smsg="Card Added";
	    String umsg="Card Addition Failed";	
	    
	    if(amservice.addcard(cdetails)!=null)
	    {
	   	 return new ResponseEntity<String>(smsg,HttpStatus.ACCEPTED);
		 }
		 else
		 {
			 return new ResponseEntity<String>(umsg,HttpStatus.BAD_REQUEST);
		 }
	}
	// Get All Added Cards
	@GetMapping(value="/showAllCards/{mobileno}",produces="application/json")
	public List<CardDetails> showAllCards(@PathVariable List<String> mobileno)
	{
		return amservice.getCarddetailsByMobileno(mobileno);
	}
	// Add Money To Wallet
	@PutMapping(value="/addMoney/{mobileno}/{cdno}/{add}",consumes="application/json")
	public String addMoneyToWallet(@PathVariable int add,@PathVariable long cdno,@PathVariable String mobileno)
	{
		CardDetails cd = amservice.checkCard(cdno);
		if(cd!=null)
		{
		   if(add<cd.getCardbalance())
		   {
			   amservice.addMoney(add,mobileno);
			   amservice.dedcutBalance(add,cdno);
			   return "Money Added Sucessfully";
		   }
		   else
			     return  "Insufficient Balance";
	    }
		else
			return "Add Card First";
	}
}
