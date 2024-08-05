package com.mykart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mykart.dto.Product;


public interface ProductRepository extends MongoRepository<Product, String> {
	Product findByProductId(String productId);
}
