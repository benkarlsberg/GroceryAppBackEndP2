package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService us;

    @GetMapping ("/users")
    public List<User> getAllUsers() {
        return us.getAllUsers();
    }

    @GetMapping("/users/{username}")
    public User searchUser(@PathVariable("username") String username) {
        return us.getUserByUsername(username);
    }

    @PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody User user) {
        return us.addUser(user);
    }

    @PutMapping(value="/users/{id}", consumes = "application/json", produces = "application/json")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user) {

        user.setId(Integer.parseInt(id));
        return us.updateUser(user);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
        boolean success = us.deleteUser(Integer.parseInt(id));
        return new ResponseEntity<>((success) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }

}
