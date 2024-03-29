package com.example.Spring.boot.annotation.controller;

import com.example.Spring.boot.annotation.dto.CustomerDto;
import com.example.Spring.boot.annotation.exception.ResourceNotFoundException;
import com.example.Spring.boot.annotation.service.CustomerService;
import com.example.Spring.boot.annotation.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/customer/{id}")
    public CustomerDto CustomerFindById(@PathVariable long id) throws ResourceNotFoundException {
        return this.customerService.CustomerFindById(id);
    }

    @PostMapping("/createCustomer")
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return this.customerService.createCustomer(customerDto);
    }

    @PutMapping("/customer/update/{id}")
    public CustomerDto updateCustomer(@PathVariable long id, @RequestBody CustomerDto customerDto) throws ResourceNotFoundException {
        return this.customerService.updateCustomer(id, customerDto);
    }

    @DeleteMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable long id) throws ResourceNotFoundException {
        this.customerService.deleteCustomer(id);
        return Constant.DELETE;
    }
}
