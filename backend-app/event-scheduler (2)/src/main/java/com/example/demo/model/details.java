package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slot_details")
public class details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "location")
	private String location;

	@Column(name = "slot number")
	private long slotno;
	
	@Column(name = "Cost")
	private long cost;
	
	@Column(name = "Workers")
	private String worker;
	
	@Column(name = "Workers Rating")
	private String rating;
	
	@Column(name = "Car registration number")
	private String carreg;
	
	@Column(name = "Availability Status")
	private String avail;
	
	@Column(name = "Computed Cost")
	private long compCost;
	
	@Column(name = "Date")
	private String date;
	
	@Column(name = "Check-in time")
	private int checkInTime;
	
	@Column(name = "Check-out time")
	private int checkOutTime;
	
	@Column(name = "Car Washing")
	private boolean carWashing;
	
	@Column(name = "Air Filling")
	private boolean airFilling;
	
	@Column(name = "Car Servicing")
	private boolean carServicing;

public details(long id, String location, long slotno, long cost, String worker, String rating, String carreg,
			String avail, String date, int checkInTime, int checkOutTime, boolean carWashing, boolean airFilling,
			boolean carServicing) {
		super();
		this.id = id;
		this.location = location;
		this.slotno = slotno;
		this.cost = cost;
		this.worker = worker;
		this.rating = rating;
		this.carreg = carreg;
		this.avail = avail;
		this.date = date;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.carWashing = carWashing;
		this.airFilling = airFilling;
		this.carServicing = carServicing;
	}

public details() {
		
	}
	
	public boolean isCarWashing() {
	return carWashing;
}

public void setCarWashing(boolean carWashing) {
	this.carWashing = carWashing;
}

public boolean isAirFilling() {
	return airFilling;
}

public void setAirFilling(boolean airFilling) {
	this.airFilling = airFilling;
}

public boolean isCarServicing() {
	return carServicing;
}

public void setCarServicing(boolean carServicing) {
	this.carServicing = carServicing;
}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getSlotno() {
		return slotno;
	}
	public void setSlotno(long slotno) {
		this.slotno = slotno;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCarreg() {
		return carreg;
	}
	public void setCarreg(String carreg) {
		this.carreg = carreg;
	}
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
	}
	public long getCompCost() {
		return compCost;
	}
	public void setCompCost(int checkIn, int checkOut) {
		this.compCost = (checkOut - checkIn) * 25;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(int checkInTime) {
		this.checkInTime = checkInTime;
	}

	public int getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(int checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	

	
}