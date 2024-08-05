package com.mykart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mykart.constants.Constants;
import com.mykart.dto.Product;
import com.mykart.service.ProductService;
import com.mykart.wrapper.ResponseWrapper;

@RestController
public class Productcontroller {
	

	
	@Autowired
	ProductService productService;	
	
	
	//adding new Product
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value="/product/addProduct")
	public ResponseEntity<Object> addProduct(@RequestBody Product product){
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			String response=productService.addProduct(product);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		}catch(Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.GENERIC_ERROR);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());		
	}
	
	//EndPoint for Getting Product Data
	@SuppressWarnings({"unchecked","rawtypes"})
	@PostMapping(value="/product/getProduct/{productId}")
	public ResponseEntity<Object> getProduct(@PathVariable String productId){
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			Product response=productService.getProduct(productId);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		}catch(Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.GENERIC_ERROR);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());	
	}
	
 	
}
