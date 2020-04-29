package com.capg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

	List<Transaction> findAllByAccNo(Long accNo);
	
}
