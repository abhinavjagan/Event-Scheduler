package com.example.demo.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Users;
public interface UserRepository extends JpaRepository<Users, Long> {
	
	@Query(value="Select count(email_id) from test.users where email_id= :em", nativeQuery=true)
	public int checkEmail(@Param("em") String em);
	
	@Query(value="Select count(id) from test.users where username= :u and password= :p", nativeQuery=true)
	public int checkUser(@Param("u") String u, @Param("p") String p);
	
	@Query(value="Select id from test.users where username= :u and password= :p", nativeQuery = true)
	public long getId(@Param("u") String u, @Param("p") String p);
	
	@Modifying
	@Transactional
	@Query(value="Update test.users set number_of_visits=number_of_visits + 1 where id= :id", nativeQuery = true)
	public void updateVisits(@Param("id") Long id);

	@Modifying@Transactional	
	@Query(value = "UPDATE test.users SET wallet = wallet - :a where id= :b ",nativeQuery = true)
	public void updateWallet(@Param("a") double d, @Param("b") long b);
	
	@Query(value="select * from test.users where id= :id",nativeQuery=true)
	public Users findById(@Param("id") long id);
}
