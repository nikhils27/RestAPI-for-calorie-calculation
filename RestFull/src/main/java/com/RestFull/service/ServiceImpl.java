package com.RestFull.service;

import com.RestFull.Dao.UserDao;
import com.RestFull.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements UserService{
   
	@Autowired
   private UserDao userdao;
	
	@Override
	public void saveUser(User user) {
       this.userdao.save(user);            
	}

	@Override
	public User findUser(String username) {
		User user=this.userdao.findByUsername(username);
		return user;
	}

	@Override
	
	public void delUser(User user) {
		// TODO Auto-generated method stub
	
		this.userdao.delete(user);
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userdao.findAll();
	}

	
}
