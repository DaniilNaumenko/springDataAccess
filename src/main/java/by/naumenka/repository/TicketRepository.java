package by.naumenka.repository;

import by.naumenka.model.Ticket;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List<Ticket> findAllByUserId(long userId);

    List<Ticket> findAllByEventId(long eventId);

    @NonNull
    List<Ticket> findAll();
}