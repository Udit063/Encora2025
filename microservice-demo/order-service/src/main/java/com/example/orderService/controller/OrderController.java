package com.example.orderService.controller;

import com.example.orderService.client.ProductServiceClient;
import com.example.orderService.model.Order;
import com.example.orderService.repository.OrderRepository;
import com.thoughtworks.xstream.converters.time.LocalDateTimeConverter;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductServiceClient productServiceClient;
    
    @GetMapping
    @Operation(summary="Get all orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    @PostMapping
    @Operation(summary="create an order")
    public Order createOrder(@RequestBody Order order) {
       orderRepository.save(order);
       return order;
    }
    
    @GetMapping("/createorder")
    @Operation(summary="create a sample order")
    public Order createSampleOrder() {
    	Order order = new Order();
    	return order;
    }
    
    @GetMapping("/{id}")
    @Operation(summary="get order by ID")
    public Order getOrderById(@PathVariable Long id) {
       Order order = orderRepository.findById(id).get();
       return order;
    }
    
    @GetMapping("/product/{productId}")
    @Operation(summary="Get product info by product id")
    public Object getProductInfo(@PathVariable Long productId) {
    	return productServiceClient.getProductById(productId);
    }
  
}

