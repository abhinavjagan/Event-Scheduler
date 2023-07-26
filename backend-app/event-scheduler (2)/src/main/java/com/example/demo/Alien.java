package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //writing @Component("lap1") will change the name of the objs created to lap1
//@Scope(value = "prototype") //can create multiple objects with this or else only singleton obj will exist. can get 0 objs too
public class Alien {
	
	private int aid;
	private String aname;
	private String tech;
	@Autowired //searches by obj type
	//@Qualifier("laptop") //this searches for obj by name laptop
	private Laptop laptop;
	
	public Alien() {
		super();
		System.out.println("object created...");
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public void show() {
		System.out.println("In show...");
		laptop.compile();
	}
}
