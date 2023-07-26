package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private long pincode;
	
	@Column(name = "Car registration number")
	private String carreg;
	
	@Column(name = "mobile_num")
	private long mobileNum;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name="number_of_visits")
	private int visits=0;
	
	@Column(name = "wallet")
	private double wallet=1000;
	
	public Users(Long id, String username, String password, String firstName, String lastName, String address,
			String city, String state, long pincode, String carreg, long mobileNum, String emailId, int visits,
			double wallet) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.carreg = carreg;
		this.mobileNum = mobileNum;
		this.emailId = emailId;
		this.visits = 0;
		this.wallet = 1000;
	}


public Users() {
		
	}

	
public double getWallet() {
	return wallet;
}


public void setWallet(double wallet) {
	this.wallet = wallet;
}


public int getVisits() {
	return visits;
}


public void setVisits(int visits) {
	this.visits = visits;
}


public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public long getPincode() {
		return pincode;
	}


	public void setPincode(long pincode) {
		this.pincode = pincode;
	}


	public String getCarreg() {
		return carreg;
	}


	public void setCarreg(String carreg) {
		this.carreg = carreg;
	}


	public long getMobileNum() {
		return mobileNum;
	}


	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}