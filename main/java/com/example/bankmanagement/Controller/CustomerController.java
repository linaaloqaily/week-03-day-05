package com.example.bankmanagement.Controller;

import com.example.bankmanagement.DTO.API;
import com.example.bankmanagement.DTO.CustomerDetailsDTO;
import com.example.bankmanagement.Model.Customer;
import com.example.bankmanagement.Service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomersService customersService;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @GetMapping("/getCustomer")
    public ResponseEntity<List<Customer>> getCustomers(){
        logger.info("Get Customer");
        return ResponseEntity.status(200).body(customersService.getCustomers());
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<API> addCustomer(@RequestBody @Valid Customer customer) throws IllegalAccessException {
        customersService.addCustomer(customer);
        logger.info("Add Customer");
        return ResponseEntity.status(201).body(new API("Customer added !",201));
    }

    @PostMapping("details")
    public ResponseEntity addCustomerDetails(@RequestBody CustomerDetailsDTO customerDetailsDTO){
        customersService.addCustomerDetails(customerDetailsDTO);
        logger.info("Add Customer Details");
        return ResponseEntity.status(201).body(new API("Customer added !",201));
    }


    @PostMapping("/withdraw/{custID}/{amount}")
    public ResponseEntity<API> withdraws(@RequestParam @Valid Integer custID ,@RequestParam @Valid Integer amount){
        customersService.withdraws(custID,amount);
        logger.info("Get withdraw");
        return ResponseEntity.status(201).body(new API("The process done",201));

    }

    @PostMapping("/deposit/{custID}/{amount}")
    public ResponseEntity<API> deposits(@RequestParam @Valid Integer custID ,@RequestParam @Valid Integer amount){
        customersService.deposit(custID,amount);
        logger.info("Get deposit");
        return ResponseEntity.status(201).body(new API("The deposit process done",201));
    }


}
