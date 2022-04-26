package com.example.customerservice.controller;

import com.example.customerservice.ValueObject.ResponseTemplate;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/addCustomer")
    public Customer saveUser(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Integer customerId){
        return customerService.getUserWithDepartment(customerId);
    }

}
