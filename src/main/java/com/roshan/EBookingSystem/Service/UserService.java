package com.roshan.EBookingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshan.EBookingSystem.Entity.User;
import com.roshan.EBookingSystem.Repository.UserRepo;
import com.roshan.EBookingSystem.Security.PasswordUtil;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User getUserById(Integer userId) {
        return userRepo.findById(userId).orElse(null);
    }

    // Authenticate User (Check Password)
    public boolean authenticateUser(User user) {
        User storedUser = userRepo.findByUserName(user.getUserName());
        return storedUser != null && PasswordUtil.checkPassword(user.getPassword(), storedUser.getPassword());
    }
    

    public Iterable<User> getAllUser() {
        return userRepo.findAll();
    }

     // Add user with hashed password
    public void addUser(User user) {
        user.setPassword(PasswordUtil.hashPassword(user.getPassword())); // Hash password before saving
        userRepo.save(user);
    }

    // Delete user (ensure authentication first)
    public void deleteUser(User user) {
        User storedUser = userRepo.findByUserName(user.getUserName());
        if (storedUser != null && PasswordUtil.checkPassword(user.getPassword(), storedUser.getPassword())) {
            userRepo.delete(storedUser);
        }
    }

}
