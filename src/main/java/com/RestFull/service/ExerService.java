package com.RestFull.service;

import java.time.LocalDate;
import java.util.List;

import com.RestFull.entity.ExerInstance;

public interface ExerService {
         
	public void saveExer(ExerInstance exer);
	
	//public List<ExerInstance> getExer(String Username);
	
	public int GetTotalCal(String username,LocalDate Sdate, LocalDate Edate);
	
	public int GetCalorie(String username,int miles ,int min);
	
	public void delExerInstance(String username);
	
	public void delExerInstance(long id);
	
	public List<ExerInstance> getExer(String username);
	
	
}
