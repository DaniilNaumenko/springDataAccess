package by.naumenka.service;

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
public class UserServiceImplTest {

    @Autowired
    private UserService userService;


    @Test
    public void getUserByIdTest() {
        Assertions.assertEquals(2L, userService.getUserById(2L).getId());
    }

    @Test
    public void getUserByEmailTest() {
        Assertions.assertEquals("email@test.com", userService.getUserByEmail("email@test.com").getEmail());
    }

    @Test
    public void createUserTest() {
        User user = new User("user1", "email@test.com");
        Assertions.assertEquals(user, userService.createUser(user));
    }

    @Test
    public void updateUserTest() {
        User userById = userService.getUserById(2L);
        userById.setEmail("update@test.com");

        Assertions.assertEquals(userById, userService.updateUser(userById));
    }

    @Test
    public void deleteUserTest() {
        int size = userService.getAllUsers().size();
        userService.deleteUser(2);
        Assertions.assertEquals(0, size - 1);
    }
}