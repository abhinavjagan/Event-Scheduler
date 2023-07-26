package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
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
import com.example.demo.model.Booking;
import com.example.demo.model.BookingIds;
import com.example.demo.model.Users;
import com.example.demo.model.Worker;
import com.example.demo.model.details;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WorkerRepository;
import com.example.demo.repository.detailsrepo;
import com.example.demo.service.UserServices;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/v1/")
public class UsersController {
	
	private String otp="000000";

	@Autowired
	private UserRepository UserRepository ;
	
	@Autowired
	private AdminRepository AdminRepository;
	
	@Autowired
	private WorkerRepository WorkerRepository;
	
	@Autowired
	private BookingRepository BookingRepository;
	
	@Autowired
	private detailsrepo detailsrepo;

	@GetMapping("/search/{query}")
	public ResponseEntity<List<Users>> searchUserByName(@PathVariable String query) {
		List<Users> usersList = getAlldetails();
		List<Users> searchedList = new ArrayList<>();
		for(Users user: usersList) {
			if(user.getUsername().contains(query)) {
				searchedList.add(user);
			}
		}
		return ResponseEntity.ok(searchedList);
	}

	@PutMapping("/users/changePassword/{id}")
	public ResponseEntity<Users> changePassword(@PathVariable Integer id, @RequestBody Users userDetails) {
		Users user = UserRepository.findById(id);

		user.setPassword(userDetails.getPassword());
		Users updatedEmployee = UserRepository.save(user);
		return ResponseEntity.ok(updatedEmployee);
	}

	@GetMapping("/facilities")
	public ResponseEntity<List<Users>> getFacilities(){
		List<Users> users = UserRepository.findAll();
		List<Users> facilities = new ArrayList<>();
		for (Users user: users) {
			if(user.getUsername() == "court" || user.getFirstName() == "Swimming Pool" ||user.getFirstName() == "Gym" ||user.getFirstName() == "Room") {
				facilities.add(user);
			}
		}
		return ResponseEntity.ok(facilities);
	}


	// get all employees
	@GetMapping("/users")
	public List<Users> getAlldetails(){
		return UserRepository.findAll();
	}		
	
 //create employee rest api
	@PostMapping("/users")
	public Users createEmployee(@RequestBody Users employee) {
		return UserRepository.save(employee);
	}
	
// get employee by id rest api
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getEmployeeById(@PathVariable Long id) {
	Users user = UserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	
	// update employee rest api
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateEmployee(@PathVariable Long id, @RequestBody Users employeeDetails){
		Users user = UserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		user.setUsername(employeeDetails.getUsername());
		user.setPassword(employeeDetails.getPassword());
		user.setFirstName(employeeDetails.getFirstName());
		user.setLastName(employeeDetails.getLastName());
		user.setAddress(employeeDetails.getAddress());
		user.setCity(employeeDetails.getCity());
		user.setState(employeeDetails.getState());
		user.setPincode(employeeDetails.getPincode());
		user.setCarreg(employeeDetails.getCarreg());
		user.setMobileNum(employeeDetails.getMobileNum());
		user.setEmailId(employeeDetails.getEmailId());

		Users updatedEmployee = UserRepository.save(user);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Users user = UserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		UserRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/email") // takes email, checks for uniqueness
	public int EmailCheckandVerify(@RequestBody String email) throws UnsupportedEncodingException {
		email = email.replaceAll("[<>=_]", "");
		email = URLDecoder.decode(email, "UTF-8");
		System.out.print(email + "11111");
		System.out.println(UserRepository.checkEmail(email));
		if(UserRepository.checkEmail(email) == 0) {
			System.out.println(UserRepository.checkEmail(email));
			System.out.println(email);
			otp=UserServices.EmailVerification(email);
			return 1;
		}
		else
			otp="000000";
			return 0;
	}
	
	@GetMapping("/otp")//sends otp to user and the frontend
	public String OTPtoReact() {
		return otp;
	}
	
	@PostMapping("/userDetails")// receive user details if otp verification is successful, else null
	public Users newUser(@RequestBody Users u) {
		return UserRepository.save(u);
	}
	
	@GetMapping("/login/admin")
	public Long AdminLogin(@RequestParam("username") String userName, @RequestParam("password") String passWord) {
		if((AdminRepository.checkAdmin(userName,passWord)==0)){
			return (long) 0;
		}
		else
			return AdminRepository.checkAdmin(userName, passWord);
		
	}
	
	@GetMapping("/login/worker")
	public Long WorkerLogin(@RequestParam("username") String userName, @RequestParam("password") String passWord) {
		long w;
		if((WorkerRepository.checkWorker(userName,passWord)==0)){
			return (long) 0;
		}
		else
			w = WorkerRepository.getId(userName, passWord);
			return w;
		
	}
	
	@GetMapping("/login/user")
	public Long UserLogin(@RequestParam("username") String userName, @RequestParam("password") String passWord) {
		if((UserRepository.checkUser(userName,passWord)==0)){
			return (long) 0;
		}
		else {
			long u=UserRepository.getId(userName,passWord);
			return u;
		}
	
	}
	
	@PostMapping("/bookslots/new")
	public Booking addBooking(@RequestBody Booking b) {
		return BookingRepository.save(b);
	}
	
	@GetMapping("/bookings/byUser")
	public List<Booking> getAllBookingsOfUser(@RequestParam Long user_id ) {
	
		return BookingRepository.getUserBooking(user_id);
	}
	
	@PostMapping("/wallet")
	public Users updatewallet(@RequestBody BookingIds ids) {
		details d = detailsrepo.findBySId(ids.getSlotId());
		double fp=(d.getCompCost())*0.9;
		UserRepository.updateWallet(fp, ids.getUserId());
		UserRepository.updateVisits(ids.getUserId());
		System.out.println(ids.getUserId());
		return UserRepository.findById(ids.getUserId());
	}
	
	private UserServices us = new UserServices();
	
	@GetMapping("/bookings/sendEmail")
	public void paymentEmail(@RequestParam("amt") long amt, @RequestParam("wallet") double wallet, @RequestParam("email") String email)  {
		String msg="Hello user, Your booking has been confirmed.\n\n"+"Rs. "+amt +"/- have been deducted from your wallet.\nYour current wallet balance is Rs. "+wallet +"/- .\n\n The Car Parking Solutions Team";
		String sub="Booking Confirmed";
		UserServices.sendEmail(msg,sub,email,"theCh0sen0ne.oo111@gmail.com");
	}
	
	@GetMapping("/worker/data")
	public List<Worker> getWorkerDetails(@RequestParam("id") Long id){
		return WorkerRepository.findbyId(id);
	}

	
}