package by.naumenka.repository;

import by.naumenka.model.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    Optional<UserAccount> findByUserId(long userId);
}