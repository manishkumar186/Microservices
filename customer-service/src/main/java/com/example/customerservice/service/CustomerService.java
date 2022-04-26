package com.example.customerservice.service;

import com.example.customerservice.ValueObject.Product;
import com.example.customerservice.ValueObject.ResponseTemplate;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    private RestTemplate restTemplate;

    public Customer createCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public ResponseTemplate getUserWithDepartment(Integer customerId){
        ResponseTemplate object = new ResponseTemplate();
        Customer customer = customerRepo.findByCustomerId(customerId);

        Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/product/productId/" + customer.getProductId(),Product.class);

        object.setCustomer(customer);
        object.setProduct(product);

        return object;
    }
}
