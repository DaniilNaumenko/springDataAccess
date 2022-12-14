package by.naumenka.service.impl;

import by.naumenka.exception.GlobalApplicationException;
import by.naumenka.model.Category;
import by.naumenka.model.Event;
import by.naumenka.model.Ticket;
import by.naumenka.model.User;
import by.naumenka.repository.EventRepository;
import by.naumenka.repository.TicketRepository;
import by.naumenka.repository.UserRepository;
import by.naumenka.service.TicketService;
import by.naumenka.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final UserAccountService userAccountService;

    public TicketServiceImpl(TicketRepository ticketRepository, UserRepository userRepository, EventRepository eventRepository, UserAccountService userAccountService) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.userAccountService = userAccountService;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        log.info("booking ticket");

        Optional<Event> eventById = eventRepository.findById(eventId);

        if (!userRepository.findById(userId).isPresent() || !eventById.isPresent()) {
            throw new GlobalApplicationException("such user id " + userId + " or event id " + eventId + " doesn't exists");
        }

        log.info("withdrawing money from account for event " + eventById.get());
        userAccountService.withdrawMoneyFromAccount(userId, eventById.get().getTicketPrice());
        Ticket ticket = new Ticket(eventId, userId, category, place);

        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        log.info("getBookedTickets by user " + user);
        return ticketRepository.findAllByUserId(user.getId());
    }

    @Override
    public List<Ticket> getBookedTickets(Event event) {
        log.info("getBookedTickets by event " + event);
        return ticketRepository.findAllByEventId(event.getId());
    }

    @Override
    public void cancelTicket(long ticketId) {
        log.info("deleting ticket by id " + ticketId);
        ticketRepository.deleteById(ticketId);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

}