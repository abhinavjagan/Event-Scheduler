package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.details;

@Repository
public interface detailsrepo extends JpaRepository<details,Long> {
	//@Query(value = "SELECT * from slot_details where location= :location", nativeQuery = true)
	public List<details> findByLocation(@Param("location") String loc);
	
	@Query(value = " SELECT * from test.slot_details where `id`= :slotId", nativeQuery = true)
	public List<details> findBySlotId(@Param("slotId") int slotId);
	
	@Modifying@Transactional
	@Query(value = "UPDATE slot_details SET `computed cost`= :a , `check-in time`= :b, `check-out time`=:c",nativeQuery = true)
	public void updatecompCost(@Param("a") int a, @Param("b") int b, @Param("c") int c);
	
	@Modifying@Transactional
	@Query(value = "UPDATE slot_details SET `computed cost`= :a, `check-in time`= :b, `check-out time`=:c where `id`= :d ",nativeQuery = true)
	public void tc(@Param("a") int a, @Param("b") int b, @Param("c") int c, @Param("d") int d);
	
	@Query(value = " SELECT * from test.slot_details where `id`= :slotId", nativeQuery = true)
	public details findBySId(@Param("slotId") long slotId);
    
}