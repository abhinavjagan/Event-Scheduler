package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "slot_details")
public class BookingTimings{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "check_in time")
	private int checkInTime;
	
	@Column(name = "check_out time")
	private int checkOutTime;
	
	
	public BookingTimings(long id, int checkInTime, int checkOutTime) {
		super();
		this.id = id;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BookingTimings() {
		
	}
	
}