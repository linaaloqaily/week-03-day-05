package com.example.bankmanagement.Service;

import com.example.bankmanagement.Model.CustomerDetails;
import com.example.bankmanagement.Repository.CustomerDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {

    private final CustomerDetailsRepository customerDetailsRepository;

    public List<CustomerDetails> getDetails() {
        return customerDetailsRepository.findAll();
    }

    public void addDetails(CustomerDetails customerDetails) throws IllegalAccessException{
        customerDetailsRepository.save(customerDetails);
    }

    public CustomerDetails getCustomer(Integer id){
       return customerDetailsRepository.findById(id).get();
    }
}
