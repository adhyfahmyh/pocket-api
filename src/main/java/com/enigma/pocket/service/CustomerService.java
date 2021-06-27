package com.enigma.pocket.service;

import com.enigma.pocket.dto.CustomerLoginDto;
import com.enigma.pocket.dto.CustomerSearchDto;
import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    public Customer findCustomerId(String id);
    public Page<Customer> findCustomers(CustomerSearchDto customerSearchForm, Pageable pageable);
    public void createCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void removeCustomer(String id);
    public Customer customerLogin(CustomerLoginDto customerLoginDto);
}
