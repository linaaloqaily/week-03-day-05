package com.example.bankmanagement.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Bank {
    @Id
    @NotNull(message = "id is required")
    private Integer id;

    @NotEmpty(message = "name is required")
    private String name;


    @ManyToOne()
    @JsonIgnore
    private Customer customers;
}
