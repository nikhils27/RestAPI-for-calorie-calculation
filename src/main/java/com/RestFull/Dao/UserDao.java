package com.RestFull.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.RestFull.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
