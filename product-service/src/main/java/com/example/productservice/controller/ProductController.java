package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/allProduct")
    public List<Product> getProducts(){
        return  productService.getAllProduct();
    }

    @PostMapping("/createProduct")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/productId/{id}")
    public Optional<Product> getProductById(@PathVariable("id") int pid){
        return productService.getProductById(pid);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") int pid, @RequestBody Product product){
        return productService.updateProduct(pid,product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") int pid){
        return productService.deleteProduct(pid);
    }

}
