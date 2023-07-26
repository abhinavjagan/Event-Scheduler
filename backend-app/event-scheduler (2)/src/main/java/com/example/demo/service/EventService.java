package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Event;

public interface EventService {

	Event createEvent(Event event);
	List<Event> updateEvent(Event event, Integer eid);
	List<Event> getAllEvents();
	void deleteEvent(Integer eid);
}
