package com.example.bankmanagement.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "id is required")
    private Integer id;

    @NotNull(message = "age is required")
    private Integer age;

    @NotNull(message = "balance is required")
    private Integer balance;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customers;
}
