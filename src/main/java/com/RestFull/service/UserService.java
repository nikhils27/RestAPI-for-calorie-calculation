package com.RestFull.service;

import java.util.List;

import com.RestFull.entity.User;

public interface UserService {
 
	public void saveUser(User user); 
	
	public User findUser(String username);
	
	public void delUser(User user);
	
	public List<User> getAllUser();
	
	
}
