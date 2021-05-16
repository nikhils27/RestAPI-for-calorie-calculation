package com.RestFull.control;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestFull.entity.ExerInstance;
import com.RestFull.entity.User;
import com.RestFull.service.ExerService;
import com.RestFull.service.GetCalorie;
import com.RestFull.service.UserService;

import java.util.List;
import java.util.Optional;


@RestController
public class MainControl {
 
	@Autowired
	private UserService userservice; 
	
	@Autowired
	private ExerService exerservice; 
	
	
	
	// ..... CREATING USER......//
	
	@PostMapping("/user")
	public String saveUser(@RequestBody User user) {
       	User user1=this.userservice.findUser(user.getUsername());
       	if(user1==null) {
       		this.userservice.saveUser(user);
       		return "user saved";
       	}
       	else {
       		return "username alerdy taken";
       	}
		
	}
	
	
	
	//.....CREATING EXERCISE INSTANCE.....//
	
	@PostMapping("/user/exercise/{username}")
	public String saveExer(@PathVariable("username") String username, @RequestParam("miles") int speed,@RequestParam("time") int time)
	{
		
		User user=this.userservice.findUser(username);
		
		if(user==null) {
			return "user not found";
		}
		
		else {
		long cal= this.exerservice.GetCalorie(username, speed, time);	    
		ExerInstance exer=new ExerInstance();
		exer.setCal(cal);
		LocalDate date = LocalDate.now();
		exer.setDate(date);
		exer.setUsername(username);
		
		this.exerservice.saveExer(exer);
		
		return "data saved";
		}
		
	}
	
	
	
	
	
	///..... GET CALORIES BURNED FOR MY PROFILE.....//
	@GetMapping("/user/exercise/{username}")
	public List<ExerInstance> getAllcalorie(@PathVariable("username") String username){
		List<ExerInstance> list=this.exerservice.getExer(username);
		
		return list;
		
	}

	
		
	
	//....GET TOTAL CALORIE BETWEEN TWO DATES X AND Y....//
	
	
	@GetMapping("/user/getCalorie/{username}")
	public String getCal(@PathVariable("username") String username, @RequestParam("Sdate") String Sdate,@RequestParam("Edate") String Edate) {
		
		User user=this.userservice.findUser(username);
		if(user==null) {
			return "user not found";
		}
		else {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	 	int i=this.exerservice.GetTotalCal(username,LocalDate.parse(Sdate,df),LocalDate.parse(Edate,df).plusDays(1));
	   
	    return "total calories burned between "+Sdate+" and "+Edate+" is "+i;
		}
   	}
	
	
	///....DELETING EXERCISE INSTANCE.....//
	
	@DeleteMapping("/user/exercise/{username}/{id}")
	public String delExerInstance(@PathVariable("username") String username,@PathVariable("id") long id ) {
	   
		List<ExerInstance> list=this.exerservice.getExer(username);
		if(list==null) {
			return "exercise instance not found ";
		}
		
		this.exerservice.delExerInstance(id);
		return "exercise instance deleted";
		
	}
	 
	
		
	//....DELETING USER WITH ITS EXERISE INSTANCES.....///
	
	@DeleteMapping("/user/{username}")
    public String delUser(@PathVariable("username") String username){
		User user=this.userservice.findUser(username);
		
		if(user==null) {
			return "user not found";
		}
		
		else {
			
			this.userservice.delUser(user);
            this.exerservice.delExerInstance(username);	        
			return "user deleted";	
       
		}	
		
	}
	
	
			//.... UPADATING USER PROFILE....//	
	
	@PutMapping("/user")
	public String updateUser(@RequestBody User user) {
		User user1=this.userservice.findUser(user.getUsername());
		if(user1==null) {
			return "user not found";
		}
		
		else {
			this.userservice.saveUser(user1);
			return "user updated";
		}
		
		}

	
	
	//....HANDLING EXCEPTION...
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> catchException(Exception ex){
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	
	}

	
	
	///OTHERS...
	
	//......GETTING SPECIFIC USER INFORMATON......//
	@GetMapping("/user/{username}")
	public User getUser(@PathVariable("username") String username){
		User user=this.userservice.findUser(username);
		return user;
	}
	
	////.....LIST OF ALL USERS....////
	@GetMapping("/user")
	public List<User> getAllUser(){
		List<User> user=this.userservice.getAllUser();
		return user;
	}
	
	



	
	
	
	
	
	
	
	
}
