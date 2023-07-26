package com.example.demo.model;

import javax.persistence.Column;

public class BookingIds {
	@Column(name= "slot_id")
	private long slotId;
	
	@Column(name= "user_id")
	private long userId;
	
	@Column(name="discount")
	private long discount;

	public long getDiscount() {
		return discount;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public long getSlotId() {
		return slotId;
	}

	public void setSlotId(long slotId) {
		this.slotId = slotId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public BookingIds(long slotId, long userId, int discount) {
		super();
		this.slotId = slotId;
		this.userId = userId;
		this.discount = discount;
	}
	
	public BookingIds() {
		
	}
}
