package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Event;
import com.example.demo.service.EventService;

@Controller
@RequestMapping("/events")
public class EventsController {

	@Autowired
	private EventService eventService;

//	int eventId = 1;

	@PostMapping("/create")
	public ResponseEntity<List<Event>> createEvent(@RequestBody Event event) {
		List<Integer> users = event.getUsers();
		Event createdEvent = new Event();
		createdEvent.setEventName(event.getEventName());
		createdEvent.setStart(event.getStart());
		createdEvent.setEnd(event.getEnd());
		createdEvent.setColor(event.getColor());

		List<Event> createdEvents = new ArrayList<>();
		if(users.isEmpty()) {
			return new ResponseEntity<List<Event>>(createdEvents, HttpStatus.CREATED);
		}
		else {
			for(int i=0; i<users.size(); i++) {
				createdEvent.setUserId(users.get(i));
//				createdEvent.setEventId(eventId);
				this.eventService.createEvent(createdEvent);
				createdEvents.add(createdEvent);
			}
//			eventId++;
		}
		return new ResponseEntity<List<Event>>(createdEvents, HttpStatus.CREATED);
	}

	public List<Event> getEvents() {
		System.out.println("Calling");
		return this.eventService.getAllEvents();
	}

	@GetMapping("/getEvents")
	public ResponseEntity<List<Event>> getEventsApi() {
		System.out.println("Calling");
		return new ResponseEntity<List<Event>>(this.eventService.getAllEvents(), HttpStatus.OK);
	}
	
	@GetMapping("/getEvents/{userId}")
	public ResponseEntity<Map<String, List<Event>>> getEventsByUser(@PathVariable Integer userId) {
		List<Event> events = getEvents();
		List<Event> searchedEvents = new ArrayList<>();
		for(Event event: events) {
			if(userId == event.getUserId()) {
				searchedEvents.add(event);
			}
		}
		Map<String, List<Event>> hm = new HashMap<>();
		hm.put("val", searchedEvents);
		return ResponseEntity.ok(hm);
	}

	@PutMapping("/{eventId}")
	public ResponseEntity<List<Event>> updateEvent(@RequestBody Event event, @PathVariable Integer eventId) {
		List<Event> updatedEvents = this.eventService.updateEvent(event, eventId);
		return new ResponseEntity<List<Event>>(updatedEvents, HttpStatus.OK);
	}

	@DeleteMapping("/{eventId}")
	public ResponseEntity<?> updateEvent(@PathVariable Integer eventId) {
		this.eventService.deleteEvent(eventId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}