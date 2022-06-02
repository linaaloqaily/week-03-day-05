package com.example.bankmanagement.Controller;

import com.example.bankmanagement.DTO.API;
import com.example.bankmanagement.Model.Bank;
import com.example.bankmanagement.Service.BankService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/bank")
public class BankController {

    private final BankService bankService;
    Logger logger = LoggerFactory.getLogger(BankController.class);


    @GetMapping
    public ResponseEntity<List<Bank>> getBanks(){
        logger.info("Get Bank");
        return ResponseEntity.status(200).body(bankService.getBanks());
    }

    @PostMapping
    public ResponseEntity<API> addBank(@RequestBody @Valid Bank bank)  throws IllegalAccessException{
        bankService.getBank(bank);
        logger.info("Add Bank");
        return ResponseEntity.status(201).body(new API("Bank added !", 201));
    }

    @PostMapping("/addcustmerToBank/{custID}/{bankID}")
    public ResponseEntity<API> addCustomerToBank(@PathVariable Integer custID,@PathVariable Integer bankID){
        bankService.addCustomerToBank(custID,bankID);
        logger.info("Add Customer to Bank");
        return ResponseEntity.status(201).body(new API("User added",201));
    }
}
