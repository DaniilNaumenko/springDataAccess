package by.naumenka.service;

import  by.naumenka.model.Category;
import  by.naumenka.model.Event;
import  by.naumenka.model.Ticket;
import  by.naumenka.model.User;

import java.util.List;

public interface TicketService {

    Ticket bookTicket(long userId, long eventId, int place, Category category);

    List<Ticket> getBookedTickets(User user);

    List<Ticket> getBookedTickets(Event event);

    void cancelTicket(long ticketId);

    List<Ticket> getAllTickets();
}