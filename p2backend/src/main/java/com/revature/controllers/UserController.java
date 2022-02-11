package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService us;

    @GetMapping ("/users")
    public List<User> getAllUsers() {
        return us.getAllUsers();
    }

    @GetMapping("/users/search")
    public List<User> searchUser(@RequestParam String user) {
        return us.getUserByUsername(user);
    }

    @PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
    public User addMovie(@RequestBody User user) {
        return us.addUser(user);
    }

    @PutMapping(value="/users/{id}", consumes = "application/json", produces = "application/json")
    public User updateMovie(@PathVariable("id") String id, @RequestBody User user) {

        user.setId(Integer.parseInt(id));
        return us.updateUser(user);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<User> deleteMovie(@PathVariable("id") String id) {
        boolean success = us.deleteUser(Integer.parseInt(id));
        return new ResponseEntity<>((success) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }

}