package com.revature.services;

import com.revature.models.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public List<User> getAllUsers();
    public User updateUser(User change);
    public boolean deleteUser(int id);
    User getUserByUsername(String username);
}
