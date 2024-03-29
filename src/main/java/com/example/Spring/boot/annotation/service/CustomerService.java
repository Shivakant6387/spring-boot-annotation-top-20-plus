package com.example.Spring.boot.annotation.service;

import com.example.Spring.boot.annotation.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    public List<CustomerDto> getAllCustomerDetails();
}
