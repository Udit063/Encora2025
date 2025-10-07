package com.example.orderService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// This client will call the product-service
@FeignClient(name="product-service", url="http://localhost:8082")
public interface ProductServiceClient {
	@GetMapping("/api/products/{id}")
	Object getProductById(@PathVariable("id") Long id);

}
