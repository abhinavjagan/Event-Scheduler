package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public Event createEvent(Event event) {
		Event savedEvent = this.eventRepository.save(event);
		return savedEvent;
	}

	@Override
	public List<Event> updateEvent(Event event, Integer eid) {
		List<Event> lstEvents = this.eventRepository.findAll();
		List<Event> updatedEvents = new ArrayList<>();
		for(Event e: lstEvents) {
			if(e.getEventId() == eid) {
				e.setEventName(event.getEventName());
				e.setColor(event.getColor());
				e.setStart(event.getStart());
				e.setEnd(event.getEnd());
				Event updatedEvent = this.eventRepository.save(e);
				updatedEvents.add(updatedEvent);
			}
		}
		return updatedEvents;
	}
	
	@Override
	public List<Event> getAllEvents() {
		List<Event> events = this.eventRepository.findAll();
		return events;
	}
	
	@Override
	public void deleteEvent(Integer eid) {
		Event e = this.eventRepository.findById(eid).orElseThrow(() -> new ResourceNotFoundException("Event not exist with this ID"));
		this.eventRepository.delete(e);
	}
	
	

}
