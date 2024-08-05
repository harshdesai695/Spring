package com.mykart.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykart.dto.User;
import com.mykart.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	Date date = new Date();

	// Add New User
	public String addUser(User newUser) throws Exception {
		User user=new User();
		try {
			newUser.setCreatedAt(date.toString());
			user=userRepository.save(newUser);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return user.getUserId();
	}
	
	//Get User Details
	public User getUser(String userName,String password ) throws Exception{
		User user;
		try {
			user=userRepository.findByUserNameAndPassword(userName, password);
			System.out.println("USer->"+user);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return user;
	}

	// Delete User
	public String deleteUser(User user) throws Exception {
		try {
			userRepository.deleteUserByUserId(user.getUserId());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "User Deleted";
	}
	
	

	// Update User phoneNo
	@Transactional
	public String updateUserPhoneNo(User user) throws Exception {
		try {
			Query query = new Query(Criteria.where("_id").is(user.getUserId()));
			Update update = new Update().set("phoneNo", user.getPhoneNo());
			mongoTemplate.updateFirst(query, update, User.class);
		} catch (Exception e) {
			System.out.println("[Exception" + e.fillInStackTrace() + "]");
			throw new Exception(e.getMessage());
		}
		return "Phone No Updated";
	}

	// Update User Email
	@Transactional
	public String updateUserEmail(User user) throws Exception {
		try {
			Query query = new Query(Criteria.where("_id").is(user.getUserId()));
			Update update = new Update().set("email", user.getEmail());
			mongoTemplate.updateFirst(query, update, User.class);
		} catch (Exception e) {
			System.out.println("[Exception" + e.fillInStackTrace() + "]");
			throw new Exception(e.getMessage());
		}
		return "Email Updated";
	}
	
	//Update User Password
	@Transactional
	public String updateUserPassword(User user) throws Exception{
		try {
			Query query = new Query(Criteria.where("_id").is(user.getUserId()));
			Update update = new Update().set("password", user.getPassword());
			mongoTemplate.updateFirst(query, update, User.class);
		} catch (Exception e) {
			System.out.println("[Exception" + e.fillInStackTrace() + "]");
			throw new Exception(e.getMessage());
		}
		return "Password Updated";
	}

}
