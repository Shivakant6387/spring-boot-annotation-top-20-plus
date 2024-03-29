package com.example.Spring.boot.annotation.service;

import com.example.Spring.boot.annotation.dto.CustomerDto;
import com.example.Spring.boot.annotation.entity.Customer;
import com.example.Spring.boot.annotation.exception.ResourceNotFoundException;
import com.example.Spring.boot.annotation.repository.CustomerRepository;
import com.example.Spring.boot.annotation.util.Constant;
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
    public CustomerDto CustomerFindById(long id) throws ResourceNotFoundException {
        Optional<Customer> customer = Optional.ofNullable(this.customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constant.RESOURCE_NOT_FOUND)));
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

    @Override
    public CustomerDto updateCustomer(long id, CustomerDto customerDto) throws ResourceNotFoundException {
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constant.NOT_FOUND));
        customer.setCity(customerDto.getCity());
        customer.setCustomerEmail(customerDto.getCustomerEmail());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setAddress(customerDto.getAddress());
        customer.setContactName(customerDto.getContactName());
        customer.setContactNumber(customerDto.getContactNumber());
        customer.setCountry(customerDto.getCountry());
        customer.setPostalCode(customerDto.getPostalCode());
        Customer customerUpdate = this.customerRepository.save(customer);
        return this.modelMapper.map(customerUpdate, CustomerDto.class);
    }

    @Override
    public void deleteCustomer(long id) throws ResourceNotFoundException {
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constant.RESOURCE_NOT_FOUND));
        this.customerRepository.delete(customer);
    }
}
