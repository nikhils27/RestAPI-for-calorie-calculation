package com.RestFull.Dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestFull.entity.ExerInstance;

@Repository
public interface ExerInstanceDao extends JpaRepository<ExerInstance, Long> {

	public List<ExerInstance> findByUsername(String username);
	
	public void deleteByUsername(String username);
	
	public ExerInstance findByDate(LocalDate date);
}
