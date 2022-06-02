package com.example.bankmanagement.Controller;

import com.example.bankmanagement.DTO.API;
import com.example.bankmanagement.Model.CustomerDetails;
import com.example.bankmanagement.Service.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customerDetails")
public class CustomerDetailsController {

    Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);

    private final CustomerDetailsService customerDetailsService;

    @GetMapping("/getDetails")
    public ResponseEntity<List<CustomerDetails>> getDetails(){
        logger.info("Get Customer Details");
        return ResponseEntity.status(200).body(customerDetailsService.getDetails());
    }

    @PostMapping("/addDetails")
    public ResponseEntity<API> addDetails(@RequestBody @Valid CustomerDetails customerDetails) throws IllegalAccessException {
        customerDetailsService.addDetails(customerDetails);
        logger.info("Add Customer Details");
        return ResponseEntity.status(201).body(new API("Customer details added !",201));
    }

    
}
