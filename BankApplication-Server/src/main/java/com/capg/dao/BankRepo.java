package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer> {

	Bank findByAccNo(Long accNo);
}
