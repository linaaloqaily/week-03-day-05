package com.example.bankmanagement.Service;

import com.example.bankmanagement.Exception.InvalidIdException;
import com.example.bankmanagement.Model.Bank;
import com.example.bankmanagement.Model.Customer;
import com.example.bankmanagement.Repository.BankRepository;
import com.example.bankmanagement.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;
    private final CustomerRepository customerRepository;

    public List<Bank> getBanks() {
        return bankRepository.findAll();
    }

    public void getBank(Bank bank)  throws IllegalAccessException {
        bankRepository.save(bank);
    }

    public void addCustomerToBank(Integer costomerId,Integer bankId){
        Customer customer=customerRepository.findById(costomerId).
                orElseThrow(() -> new InvalidIdException("Invaild id"));
        Bank bank=bankRepository.findById(bankId).
                orElseThrow(() -> new InvalidIdException("vaild id"));
        customer.setBank((Set<Bank>) bank);
        customerRepository.save(customer);



    }
}
