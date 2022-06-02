package com.example.bankmanagement.Service;

import com.example.bankmanagement.DTO.CustomerDetailsDTO;
import com.example.bankmanagement.Model.Customer;
import com.example.bankmanagement.Model.CustomerDetails;
import com.example.bankmanagement.Repository.CustomerDetailsRepository;
import com.example.bankmanagement.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomersService {

    private final CustomerDetailsService customerDetailsService;
    private final CustomerRepository customerRepository;
    private final CustomerDetailsRepository customerDetailsRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) throws IllegalAccessException{
        customerRepository.save(customer);
    }

    public boolean withdraws(Integer id , Integer amount){
        CustomerDetails customerDetails = customerDetailsService.getCustomer(id);

        if(customerDetails == null || customerDetails.getBalance() < amount){
            return false;
        }
        customerDetails.setBalance(customerDetails.getBalance()- amount); ;
        return true;
    }

    public boolean deposit(Integer id , Integer amount){
        CustomerDetails customerDetails = customerDetailsService.getCustomer(id);

        if(customerDetails == null || customerDetails.getBalance() < amount){
            return false;
        }
        customerDetails.setBalance(customerDetails.getBalance()+ amount); ;
        return true;
    }

    public void addCustomerDetails(CustomerDetailsDTO cd) {
        Customer customer = customerRepository.findById(cd.getCustomerId()).get();
        CustomerDetails customerDetails = new CustomerDetails(null, cd.getAge(), cd.getBalance(),customer );
        customer.setCustomerDetails(customerDetails);
        customerDetailsRepository.save(customerDetails);

        customerDetailsRepository.save(customerDetails);
    }
}
