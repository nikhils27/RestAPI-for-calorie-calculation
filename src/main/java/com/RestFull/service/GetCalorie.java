package com.RestFull.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCalorie {
	
	@Autowired
	UserService userservice;
	
	
	public long getcal(String username,int dist, int min) {
		
		double dist1=dist*0.621371;
		
		double speed= min/dist;
	    
		
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

		int cal=(int)(mnt*3.5*50)/200;
		cal=cal*60;
		
		return cal;
	}
}
