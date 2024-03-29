package com.example.Spring.boot.annotation.service;

import com.example.Spring.boot.annotation.dto.CustomerDto;
import com.example.Spring.boot.annotation.entity.Customer;
import com.example.Spring.boot.annotation.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return customer.stream().map((todo) -> this.modelMapper.map(todo, CustomerDto.class)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto CustomerFindById(long id) {
        Optional<Customer> customer = this.customerRepository.findById(id);
        CustomerDto customerDto = this.modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = this.modelMapper.map(customerDto, Customer.class);
        Customer customerSave = this.customerRepository.save(customer);
        CustomerDto saveCustomerDto = this.modelMapper.map(customerSave, CustomerDto.class);
        return saveCustomerDto;
    }
}
