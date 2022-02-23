package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    /*
    Automatically maps an Object to its instance found in the Spring Container.
    IF ONE EXISTS. If more than one instance exists, you need to add @Qualifier.
     */
    //This is Field Injection
    @Autowired
    UserRepo ur;

    @Override
    public User addUser(User user) {
        return ur.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) ur.findAll();
    }

    @Override
    public User updateUser(User change) {
        return ur.save(change);
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            ur.deleteById(id);
            return true;
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        return (User) ur.findByUsername(username);
    }
}
