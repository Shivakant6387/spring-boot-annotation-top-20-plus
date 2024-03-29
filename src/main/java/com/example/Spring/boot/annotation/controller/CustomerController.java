package com.example.Spring.boot.annotation.controller;

import com.example.Spring.boot.annotation.dto.CustomerDto;
import com.example.Spring.boot.annotation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAllCustomerDetails")
    public List<CustomerDto> getAllCustomerDetails() {
        return this.customerService.getAllCustomerDetails();
    }
}
