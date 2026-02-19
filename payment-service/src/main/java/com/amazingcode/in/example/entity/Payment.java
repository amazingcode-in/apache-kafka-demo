package com.amazingcode.in.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private String txnId;
    private float amount;
    private String txnType;
    private Customer customer;
}
