package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Worker;


@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
	
	@Query(value="Select count(id) from test.worker where user_name= :u and password= :p",nativeQuery=true)
	public Long checkWorker(@Param("u") String u, @Param("p") String p);
	
	@Query(value="Select id from test.worker where user_name= :u and password= :p", nativeQuery = true)
	public long getId(@Param("u") String u, @Param("p") String p);
	
	@Query(value="Select * from test.worker where id= :id",nativeQuery=true)
	public List<Worker> findbyId(@Param("id") long id);
}