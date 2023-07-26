package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="worker")
public class Worker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String name;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="no_of_hours")
	private int hours;
	
	@Column(name="rating")
	private double rating;
	
	@Column(name="no_of_rating")
	private double ratingsCount;
	
	@Column(name="car_cleaning")
	private int carCleaning;
	
	@Column(name="air_filling")
	private int airFilling;
	
	@Column(name="car_servicing")
	private int carServicing;
	
	

	public Worker(String name, String username, String password, int hours, double rating, double ratingsCount,
			int carCleaning, int airFilling, int carServicing) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.hours = hours;
		this.rating = rating;
		this.ratingsCount = ratingsCount;
		this.carCleaning = carCleaning;
		this.airFilling = airFilling;
		this.carServicing = carServicing;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(double ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	public int isCarCleaning() {
		return carCleaning;
	}

	public void setCarCleaning(int carCleaning) {
		this.carCleaning = carCleaning;
	}

	public int isAirFilling() {
		return airFilling;
	}

	public void setAirFilling(int airFilling) {
		this.airFilling = airFilling;
	}

	public int isCarServicing() {
		return carServicing;
	}

	public void setCarServicing(int carServicing) {
		this.carServicing = carServicing;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Worker() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}
