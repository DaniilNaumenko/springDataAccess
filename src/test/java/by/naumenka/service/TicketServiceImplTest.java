package by.naumenka.service;

import by.naumenka.model.Category;
import by.naumenka.model.Event;
import by.naumenka.model.Ticket;
import by.naumenka.model.User;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@NoArgsConstructor
public class TicketServiceImplTest {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private EventService eventService;

    @Test
    public void bookTicketTest() {
        Ticket ticket = new Ticket(1, 2, Category.BAR, 1);
        Assertions.assertEquals(ticket, ticketService.bookTicket(1, 2, 1, Category.BAR));
    }

    @Test
    public void getTicketsByUserTest() {
        User user = new User("user1", "email@test.com");
        Assertions.assertEquals(0, ticketService.getBookedTickets(user).size());
    }

    @Test
    public void getTicketsByEventTest() {
        Event event = eventService.getById(1L);
        Assertions.assertEquals(1, ticketService.getBookedTickets(event).size());
    }

    @Test
    public void deleteUserTest() {
        int size = ticketService.getAllTickets().size();
        ticketService.cancelTicket(1);
        Assertions.assertEquals(0, size - 1);
    }
}