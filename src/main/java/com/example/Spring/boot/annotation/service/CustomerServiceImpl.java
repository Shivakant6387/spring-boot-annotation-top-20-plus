package com.example.Spring.boot.annotation.service;

import com.example.Spring.boot.annotation.dto.CustomerDto;
import com.example.Spring.boot.annotation.entity.Customer;
import com.example.Spring.boot.annotation.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CustomerDto> getAllCustomerDetails() {
        List<Customer> customer = this.customerRepository.findAll();
        return customer.stream().map((todo) -> modelMapper.map(todo, CustomerDto.class)).collect(Collectors.toList());
    }
}
