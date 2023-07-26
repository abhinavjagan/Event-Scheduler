package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "slot_details")
public class AdditionalCosts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "check_in")
	private int checkIn;
	
	@Column(name = "check_out")
	private int checkOut;
	
	@Column(name = "slot_id")
	private int slotId;

	@Column(name="car_washing")
	private int carWashing;
	
	@Column(name="air_filling")
	private int airFilling;
	
	@Column(name="car_servicing")
	private int carServicing;

	public int getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(int checkIn) {
		this.checkIn = checkIn;
	}

	public int getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(int checkOut) {
		this.checkOut = checkOut;
	}
	
	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	        

	public AdditionalCosts(long id, int checkIn, int checkOut, int slotId, int carWashing, int airFilling,
			int carServicing) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.slotId = slotId;
		this.airFilling = airFilling;
		this.carWashing = carWashing;
		this.carServicing = carServicing;

	}
	
	public int getCarWashing() {
		return carWashing;
	}

	public void setCarWashing(int carWashing) {
		this.carWashing = carWashing;
	}

	public int getAirFilling() {
		return airFilling;
	}

	public void setAirFilling(int airFilling) {
		this.airFilling = airFilling;
	}

	public int getCarServicing() {
		return carServicing;
	}

	public void setCarServicing(int carServicing) {
		this.carServicing = carServicing;
	}

	public AdditionalCosts() {
		
	}
	
	
}
