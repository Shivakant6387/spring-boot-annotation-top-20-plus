package com.example.Spring.boot.annotation.repository;

import com.example.Spring.boot.annotation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
