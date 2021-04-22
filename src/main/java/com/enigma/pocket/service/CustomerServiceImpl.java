package com.enigma.pocket.service;

import com.enigma.pocket.dto.CustomerSearchDto;
import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.exception.CustomerNotFoundException;
import com.enigma.pocket.repository.CustomerRepository;
import com.enigma.pocket.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final String notFoundMessage = "Customer with id: %s Not Found";
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findCustomerId(Integer id) {
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

    @Override
    public Page<Customer> findCustomers(CustomerSearchDto customer, Pageable pageable) {
//        List<Customer> customers = customerRepository.findAllByFirstNameStartingWithAndEmailContainingAndBirthDateBetween(firstName, email, fromDate, toDate, pageable);
        Page<Customer> customers = customerRepository.findAll(CustomerSpecification.findCustomer(customer), pageable);
        return customers;
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {

            validatePresent(customer.getCustomerId());
            customerRepository.save(customer);
    }

    private void validatePresent(Integer id){
        if (!customerRepository.findById(id).isPresent()){
            throw new CustomerNotFoundException(String.format(notFoundMessage, id));
        }
    }

    @Override
    public void removeCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
