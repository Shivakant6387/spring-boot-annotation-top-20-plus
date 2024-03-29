package com.example.Spring.boot.annotation.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {
    private long CustomerID;
    private String CustomerName;
    private String CustomerEmail;
    private String ContactName;
    private String ContactNumber;
    private String Address;
    private String City;
    private String PostalCode;
    private String Country;
}
