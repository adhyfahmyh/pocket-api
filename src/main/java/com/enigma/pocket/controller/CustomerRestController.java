package com.enigma.pocket.controller;

import com.enigma.pocket.dto.CustomerSearchDto;
import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") Integer id){
        return customerService.findCustomerId(id);
    }
    @GetMapping("/customers")
    public Page<Customer> getAllCustomers(@RequestBody CustomerSearchDto customer,
                                          @RequestParam(name = "page", defaultValue = "0") Integer page,
                                          @RequestParam(name = "size", defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return customerService.findCustomers(customer, pageable);
    }
    @PostMapping("/customer/create")
    public void createNewCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }
    @PutMapping("/customer")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }
    @PostMapping("/customer/{id}/delete")
    public void deleteCustomer(@PathVariable(name = "id") Integer id){
        customerService.removeCustomer(id);
    }


}
