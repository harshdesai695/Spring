package com.mykart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mykart.constants.Constants;
import com.mykart.dto.UserActivity;
import com.mykart.service.UserActivityService;
import com.mykart.wrapper.ResponseWrapper;

@RestController
public class UserActivityController {

	
	@Autowired
	UserActivityService userActivityService;
	
	//Endpoint To Add UserActivity (Orders,WishList,CartList)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "activity/addUserActivity")
	public ResponseEntity<Object> addUserActivity(@RequestBody UserActivity userActivity){
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			String response = userActivityService.addUserActivity(userActivity);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		} catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.GENERIC_ERROR);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}
	
	//EndPoint to get UserActivity
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value="activity/getUserActivity/{userId}")
	public ResponseEntity<Object> getUserActivity(@PathVariable String userId){
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			UserActivity response = userActivityService.getUserActivity(userId);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		}catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.GENERIC_ERROR);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}
	
	//EndPoint To get WishList
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value="activity/getWishList/{userId}")
	public ResponseEntity<Object> getWishList(@PathVariable String userId){
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			List<String> response = userActivityService.getWishList(userId);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		}catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.GENERIC_ERROR);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}
	
	//EndPoint To get CartList
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value="activity/getCartList/{userId}")
	public ResponseEntity<Object> getCartList(@PathVariable String userId){
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			List<String> response = userActivityService.getCardList(userId);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		}catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.GENERIC_ERROR);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}
	
	//EndPoint To get OrderList
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value="activity/getOrderList/{userId}")
	public ResponseEntity<Object> getOrderList(@PathVariable String userId){
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			List<String> response = userActivityService.getOrderList(userId);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		}catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.GENERIC_ERROR);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}
	
}
