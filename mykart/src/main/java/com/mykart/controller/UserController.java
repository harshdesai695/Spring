package com.mykart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mykart.constants.Constants;
import com.mykart.dto.User;
import com.mykart.service.UserService;
import com.mykart.wrapper.ResponseWrapper;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// EndPoint for Adding New User
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "user/addUser")
	public ResponseEntity<Object> addUser(@RequestBody User newUser) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			String response = userService.addUser(newUser);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		} catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.GENERIC_ERROR);
		}

		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}
	
	
	//EndPoint for Getting User Data
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "user/getUser")
	public ResponseEntity<Object> getUser(@RequestBody User user) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			user = userService.getUser(user.getUserName(),user.getPassword());
			responseWrapper.setResponseBody(user);
			responseWrapper.setResponseStatus(Constants.OK);
		} catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.GENERIC_ERROR);
		}

		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}
	
	// EndPoint for Deleting Existing User
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "user/deleteUser")
	public ResponseEntity<Object> deleteUser(@RequestBody User user) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			String response = userService.deleteUser(user);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		} catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.USER_NOT_FOUND);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}

	// EndPoint for Update User PhoneNo
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "user/update/phoneno")
	public ResponseEntity<Object> updatePhoneNo(@RequestBody User user) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			String response = userService.updateUserPhoneNo(user);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		} catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.USER_NOT_FOUND);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}

	// EndPoint for Update User Email
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "user/update/email")
	public ResponseEntity<Object> updateEmail(@RequestBody User user) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			String response = userService.updateUserEmail(user);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		} catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.USER_NOT_FOUND);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}

	// EndPoint for Update User Password
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "user/update/password")
	public ResponseEntity<Object> updatePassword(@RequestBody User user) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			String response = userService.updateUserPassword(user);
			responseWrapper.setResponseBody(response);
			responseWrapper.setResponseStatus(Constants.OK);
		} catch (Exception e) {
			responseWrapper.setResponseBody(e.getMessage());
			responseWrapper.setResponseStatus(Constants.USER_NOT_FOUND);
		}
		return new ResponseEntity(responseWrapper.getResponseBody(), responseWrapper.getHttpHeaders(),
				responseWrapper.getResponseStatus());
	}

}
