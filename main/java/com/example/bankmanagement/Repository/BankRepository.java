package com.example.bankmanagement.Repository;

import com.example.bankmanagement.Model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Integer> {
}
