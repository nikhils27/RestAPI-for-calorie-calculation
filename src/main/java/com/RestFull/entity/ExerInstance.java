package com.RestFull.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ExerInstance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private String username;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	
	private long cal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public long getCal() {
		return cal;
	}

	public void setCal(long cal) {
		this.cal = cal;
	}

	@Override
	public String toString() {
		return "ExerInstance [id=" + id + ", username=" + username + ", date=" + date + ", cal=" + cal + "]";
	}

	public ExerInstance(long id, String username, LocalDate date, long cal) {
		super();
		this.id = id;
		this.username = username;
		this.date = date;
		this.cal = cal;
	}

	public ExerInstance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
