package com.mykart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mykart.dto.UserActivity;



public interface UserActivityRepository extends MongoRepository<UserActivity, List<String>>{
	
	UserActivity findByUserId(String userId);
	List<String> findWishListByUserId(String userId);
	List<String> findCartListByUserId(String userId);
	List<String> findOrderListByUserId(String userId);
	

}
