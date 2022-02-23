package com.revature.repositories;

import com.revature.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = com.revature.driver.P2backendApplication.class)
@Transactional
public class UserRepoTest {
    @Autowired
    public UserRepo ur;

    @Test
    void getAllUsers() {
        List<User> users = (List<User>) ur.findAll();
        System.out.println(users);
        Assertions.assertFalse(users.isEmpty());
    }

    @Test
    @Rollback
    void addUser() {
        User ryan = new User(1, "ryanhaque", "abc123");
        ryan = ur.save(ryan);
        Assertions.assertNotEquals(0, ryan.getId());
        User getRyan = ur.findById(ryan.getId()).orElse(null);
        Assertions.assertEquals(getRyan, ryan);
    }

}
