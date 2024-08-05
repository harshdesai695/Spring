package com.mykart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mykart.dto.UserActivity;
import com.mykart.repository.UserActivityRepository;

@Service
public class UserActivityService {

	
	@Autowired
	UserActivityRepository userActivityRepository;
	
	
	public String addUserActivity(UserActivity userActivity) throws Exception{
		try {
			userActivityRepository.save(userActivity);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "Added";
	}
	
	public UserActivity getUserActivity(String userId) throws Exception{
		UserActivity userActivity;
		try {
			userActivity=userActivityRepository.findByUserId(userId);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return userActivity;
	}
	
	public List<String> getWishList(String userId) throws Exception{
		List<String> wishList;
		try {
			wishList=userActivityRepository.findWishListByUserId(userId);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return wishList;
	}
	
	public List<String> getCardList(String userId) throws Exception{
		List<String> cardList;
		try {
			cardList=userActivityRepository.findCartListByUserId(userId);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return cardList;
	}
	
	public List<String> getOrderList(String userId) throws Exception{
		List<String> orderList;
		try {
			orderList=userActivityRepository.findOrderListByUserId(userId);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return orderList;
	}
	
	
	
}
