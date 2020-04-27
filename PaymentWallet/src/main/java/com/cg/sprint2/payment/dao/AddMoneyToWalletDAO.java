package com.cg.sprint2.payment.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.sprint2.payment.dto.CardDetails;

@Repository
public interface AddMoneyToWalletDAO extends JpaRepository<CardDetails, String> 
{

	@Query("update walletuser set  walletbalance=walletbalance+add where mobileno=:mobileno")
	public int addToWallet(@Param("add")int add ,@Param("mobileno") String mobileno);
	
	@Query("update carddetails set  cbalance=cbalance-deduct where cardno=:cardno")
	public double deductBalance(@Param("deduct") double deduct,@Param("cardno") long cardno);
	
	@Query("select * from carddetails where cardno=:cardno")
	public CardDetails verifyCardNo(long cardno);
}
