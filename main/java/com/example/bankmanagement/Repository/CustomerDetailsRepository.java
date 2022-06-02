package com.example.bankmanagement.Repository;

import com.example.bankmanagement.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,Integer> {
}
