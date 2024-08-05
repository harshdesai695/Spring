package com.mykart.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mykart.dto.Product;
import com.mykart.dto.User;
import com.mykart.repository.ProductRepository;

@Service
public class ProductService {
	
	Date date = new Date();
	
	@Autowired
	ProductRepository productRepository;
	
	
	public String addProduct(Product newProduct) throws Exception{
		try {
			productRepository.save(newProduct);
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		return "Added";
	}


	public Product getProduct(String productId) throws Exception{
		Product product;
		try {
			product=productRepository.findByProductId(productId);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return product;
	
	
	}
	
}
