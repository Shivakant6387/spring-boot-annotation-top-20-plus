package com.example.Spring.boot.annotation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_id",length = 1)
    private long CustomerID;
    @Column(name = "customer_name",length = 30)
    private String CustomerName;
    @Column(name = "customer_email",length = 150)
    private String CustomerEmail;
    @Column(name = "contact_name",length = 50)
    private String ContactName;
    @Column(name = "contact_number",length = 15)
    private String ContactNumber;
    @Column(name = "address",length = 50)
    private String Address;
    @Column(name = "city",length = 50)
    private String City;
    @Column(name = "postal_code",length = 20)
    private String PostalCode;
    @Column(name = "country",length = 30)
    private String Country;
}
