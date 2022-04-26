package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.exception.ResourceNotFoundException;
import com.example.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(int pid){
        return productRepo.findById(pid);
    }

    public Product saveProduct(Product product){
        return  productRepo.save(product);
    }

    public ResponseEntity<Product> updateProduct(int pid, Product product){
         Product products = productRepo.findById(pid)
                 .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + pid));

        products.setProductName(product.getProductName());
        products.setProductPrice(product.getProductPrice());

        Product updatedProduct = productRepo.save(products);
        return ResponseEntity.ok(updatedProduct);

    }


    public ResponseEntity<Product> deleteProduct(int pid){
        Product products = productRepo.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + pid));

        productRepo.delete(products);
        return ResponseEntity.ok(products);

    }
}
