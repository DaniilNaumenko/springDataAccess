package by.naumenka.service;

import by.naumenka.model.Event;

import java.util.Date;
import java.util.List;

public interface EventService {

    Event getById(long id);

    List<Event> getEventsByTitle(String title);

    List<Event> getEventsForDay(Date day);

    Event createEvent(Event event);

    Event updateEvent(Event event);

    void deleteEvent(long eventId);

    List<Event> getAllEvents();
}