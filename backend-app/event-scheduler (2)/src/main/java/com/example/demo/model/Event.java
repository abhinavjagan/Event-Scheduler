package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="event")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int eventId;

//	int eventId;
	
	@Column(name = "userId")
	int userId;

	@Column(name = "eventName")
	String eventName;
	
	@Column(name = "start")
	int start;

	@Column(name = "end")
	int end;
 
	@Column(name = "color")
	String color;

	//Date

	@Transient
	List<Integer> users;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public List<Integer> getUsers() {
		return users;
	}

	public void setUsers(List<Integer> users) {
		this.users = users;
	}

	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
