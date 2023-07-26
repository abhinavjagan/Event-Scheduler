package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	@Query(value="Select Count(id) from test.admin where user_name= :u and password= :p",nativeQuery=true)
	public Long checkAdmin(@Param("u") String u, @Param("p") String p);
	
	@Query(value="Select id from test.admin where user_name= :u and password= :p", nativeQuery = true)
	public long getId(@Param("u") String u, @Param("p") String p);

}