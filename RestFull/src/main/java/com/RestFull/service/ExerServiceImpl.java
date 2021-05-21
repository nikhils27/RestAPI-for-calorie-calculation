package com.RestFull.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestFull.Dao.ExerInstanceDao;
import com.RestFull.Dao.UserDao;
import com.RestFull.entity.ExerInstance;
import com.RestFull.entity.User;

@Service
public class ExerServiceImpl implements ExerService {

	@Autowired
	private ExerInstanceDao exerDao;
	

	@Autowired
	private UserDao userdao;
	
	
	@Override
	public void saveExer(ExerInstance exer) {

		this.exerDao.save(exer);

	}

	@Override
	public int GetTotalCal(String username, LocalDate Sdate, LocalDate Edate) {
		int cal=0;
		for (LocalDate date = Sdate; date.isBefore(Edate); date = date.plusDays(1))
		{
		    List<ExerInstance> list=this.exerDao.findByUsername(username);
		    for(ExerInstance exer : list) {
		    	if(exer.getDate().equals(date)) {		
		    		cal=cal+(int)exer.getCal();
		    	}		    	
		    }
	    
		}
		return cal;
	}

	@Override
	public int GetCalorie(String username, int miles, int min) {
		
		User user=this.userdao.findByUsername(username);
		
        double speed= min/miles;
	    
		
		double mnt=0;
		
		switch((int)speed) {
		 
		case 13:
			mnt=6;
			break;
		case 12:
			mnt=8.3;
			break;
		case 11:
			mnt=9;
			break;
		case 10:
			mnt=9.8;
			break;
		case 9:
			mnt=10.5;
			break;
		case 8:
			mnt=11.5;
			break;
		case 7:
			mnt=12.3;
			break;
		case 6:
			mnt=14.5;
			break;
		case 5:
			mnt=19;
			break;
		case 4:
			mnt=23;
			break;
		
		default:
			mnt=7;
			break;
		}

		int cal=(int)(mnt*3.5*user.getWeight())/200;
		cal=cal*60;
		
		return cal;
	}

	@Override
	public void delExerInstance(String username) {
		
		
		List<ExerInstance> list=this.exerDao.findByUsername(username);
		this.exerDao.deleteAll(list);
		}

	@Override
	public List<ExerInstance> getExer(String username) {
		
		return this.exerDao.findByUsername(username);
		
	}

	@Override
	public void delExerInstance(long id) {
		this.exerDao.deleteById(id);
		
		
	}

}
