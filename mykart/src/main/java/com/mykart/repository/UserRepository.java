package com.mykart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mykart.dto.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByUserId(String userId);
	User findByUserNameAndPassword(String userName,String password);
	void deleteUserByUserId(String userId);
	

}
