package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.exception.CustomerNotFoundException;
import com.enigma.pocket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Customer> findCustomers(String firstName, String email, Pageable pageable) {
        List<Customer> customers = customerRepository.findAllByFirstNameStartingWithAndEmailContaining(firstName, email, pageable);
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
