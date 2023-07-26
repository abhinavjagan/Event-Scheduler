package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	@Query(value="Select * from test.bookings where user_id = :id",nativeQuery=true)
	public List<Booking> getUserBooking(@Param("id") Long id);
	
}
