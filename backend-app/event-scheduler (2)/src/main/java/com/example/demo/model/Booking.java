package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="bookings")
	public class Booking {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long booking_id;

		@Column(name = "user_id")
		private Long user_id;
		
		@Column(name = "slot_id")
		private Long slot_id;
		
		@Column(name = "Check_in")
		private int check_in;
		
		@Column(name = "Check_out")
		private int check_out;
		
		public Booking(Long user_id, Long slot_id, int check_in, int check_out) {
			super();
			this.user_id = user_id;
			this.slot_id = slot_id;
			this.check_in = check_in;
			this.check_out = check_out;
		}

		public Booking () {}
		public Long getBooking_id() {
			return booking_id;
		}

		public void setBooking_id(Long booking_id) {
			this.booking_id = booking_id;
		}

		public Long getUser_id() {
			return user_id;
		}

		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}

		public Long getSlot_id() {
			return slot_id;
		}

		public void setSlot_id(Long slot_id) {
			this.slot_id = slot_id;
		}

		public int getCheck_in() {
			return check_in;
		}

		public void setCheck_in(int check_in) {
			this.check_in = check_in;
		}

		public int getCheck_out() {
			return check_out;
		}

		public void setCheck_out(int check_out) {
			this.check_out = check_out;
		}

		
		
	}

