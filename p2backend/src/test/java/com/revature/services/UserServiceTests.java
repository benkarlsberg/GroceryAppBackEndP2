package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(classes = com.revature.driver.P2backendApplication.class)
public class UserServiceTests {

    @Autowired
    UserService us;
    @MockBean
    UserRepo ur;

    @Test
    void addUser() {
        User user = new User(1, "ryanhaque", "abc123");

        Mockito.when(ur.save(user)).thenReturn(
                new User(100, user.getUsername(), user.getPassword()) );

        user = us.addUser(user);

        Assertions.assertEquals(100, user.getId());
        Assertions.assertEquals("ryanhaque", user.getUsername());
        Assertions.assertEquals("abc123", user.getPassword());
    }

    @Test
    void updateUser() {
        User user = new User(1, "ryanhaque", "a123");

        Mockito.when(ur.save(user)).thenReturn(
                new User(10, user.getUsername(), user.getPassword()) );

        user = us.updateUser(user);

        Assertions.assertEquals(10, user.getId());
        Assertions.assertEquals("ryanhaque", user.getUsername());
        Assertions.assertEquals("a123", user.getPassword());
    }

    @Test
    void getUserByUserName() {
        User user = new User(100, "thomas","password");
        Optional<User> userOptional = Optional.of(user);

        Mockito.when(ur.findByUsername(user.getUsername())).thenReturn(userOptional.get());

        User actual = us.getUserByUsername(user.getUsername());

        Assertions.assertEquals(actual.getUsername(), user.getUsername());
    }






}
