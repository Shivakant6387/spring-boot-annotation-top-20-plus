package com.example.Spring.boot.annotation.service;

import com.example.Spring.boot.annotation.dto.CustomerDto;
import com.example.Spring.boot.annotation.exception.ResourceNotFoundException;

import java.util.List;

public interface CustomerService {
    public List<CustomerDto> getAllCustomerDetails();
    public CustomerDto CustomerFindById(long id) throws ResourceNotFoundException;
    public CustomerDto createCustomer(CustomerDto customerDto);
    public CustomerDto updateCustomer(long id,CustomerDto customerDto) throws ResourceNotFoundException;
    public CustomerDto partiallyUpdateCustomer(long id,CustomerDto customerDto) throws ResourceNotFoundException;
    public void deleteCustomer(long id) throws ResourceNotFoundException;
}
