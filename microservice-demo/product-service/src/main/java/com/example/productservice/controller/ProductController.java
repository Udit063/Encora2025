package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping
    @Operation(summary="get all products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @GetMapping("/{id}")
    @Operation(summary="get product by ID")
    public Product getProductById(@PathVariable Long id) {
    	return (Product)productRepository.findById(id).get();        
    }
    
    @PostMapping
    @Operation(summary="create a new product")
    public Product createProduct(@RequestBody Product product) {
       productRepository.save(product);
       return product;
    }
    
    @PostMapping("/createsampleproduct")
    @Operation(summary="create sample product")
    public Product createSampleProduct() {
    	Product product = new Product();
    	product.setName("Laptop");
    	product.setPrice(1000);
    	productRepository.save(product);
    	return product;
    }

    @PutMapping("/{id}")
    @Operation(summary="update product by id")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id).get();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        productRepository.save(product);
        return product;
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary="delete an existing product")
    public void deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
}

