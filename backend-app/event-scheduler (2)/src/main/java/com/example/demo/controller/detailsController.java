package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AdditionalCosts;
import com.example.demo.model.BookingTimings;
import com.example.demo.model.details;
import com.example.demo.repository.detailsrepo;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class detailsController {

	@Autowired
	private detailsrepo detailsrepo ;
	
	// get all employees
	@GetMapping("/details")
	public List<details> getAlldetails(){
		return detailsrepo.findAll();
	}		
	
	//get all slots by location
	@GetMapping("/customslots")
	public List<details> getSlotsByLocation(@RequestParam("location") String location){
		return detailsrepo.findByLocation(location);
	}
	
	
 //create employee rest api
	@PostMapping("/details")
	public details createEmployee(@RequestBody details employee) {
		detailsrepo.save(employee);
		employee.setCompCost(employee.getCheckInTime(), employee.getCheckOutTime());
		return detailsrepo.save(employee);
	}
	
// get employee by id rest api
	@GetMapping("/details/{id}")
	public ResponseEntity<details> getEmployeeById(@PathVariable Long id) {
	details employee = detailsrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest api
	@PutMapping("/details/{id}")
	public ResponseEntity<details> updateEmployee(@PathVariable Long id, @RequestBody details employeeDetails){
		details employee = detailsrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setLocation(employeeDetails.getLocation());
		employee.setSlotno(employeeDetails.getSlotno());
		employee.setCost(employeeDetails.getCost());
		employee.setWorker(employeeDetails.getWorker());
		employee.setRating(employeeDetails.getRating());
		employee.setCarreg(employeeDetails.getCarreg());
		employee.setAvail(employee.getAvail());
		employee.setCheckInTime(employee.getCheckInTime());
		employee.setCheckOutTime(employee.getCheckOutTime());
		employee.setCompCost(employeeDetails.getCheckInTime(), employeeDetails.getCheckOutTime());
		
		details updatedEmployee = detailsrepo.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/details/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		details employee = detailsrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		detailsrepo.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/details/compcost")
	public List<details> updateCompCost(@RequestBody BookingTimings timings) {
		detailsrepo.updatecompCost((timings.getCheckOutTime() - timings.getCheckInTime()) * 25, timings.getCheckInTime(), timings.getCheckOutTime());
		return detailsrepo.findAll();
	}
		
	@PostMapping("/details/totcost")
	public List<details> totalCost(@RequestBody AdditionalCosts services) {
		detailsrepo.updatecompCost((services.getCheckOut() - services.getCheckIn()) * 25, services.getCheckIn(), services.getCheckOut());
		detailsrepo.tc((services.getCheckOut() - services.getCheckIn()) * 25 + services.getCarWashing() * 10 + services.getAirFilling() * 5 + services.getCarServicing() * 50, services.getCheckIn(), services.getCheckOut(), services.getSlotId());
		return detailsrepo.findBySlotId(services.getSlotId());
	}
	
	
}