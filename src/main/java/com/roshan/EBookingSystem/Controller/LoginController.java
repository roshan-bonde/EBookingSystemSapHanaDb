package com.roshan.EBookingSystem.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roshan.EBookingSystem.Service.UserService;
import com.roshan.EBookingSystem.Entity.User;;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public ArrayList<User> getAllUser() {
        ArrayList<User> userList = new ArrayList<>();
        userService.getAllUser().forEach( u -> userList.add(u));
        return userList;
    }
    
    @PostMapping("/login")  
    public String login(@RequestBody User user) {
        boolean authenticated = userService.authenticateUser(user);
        if (authenticated){
            return "Login Successful";
        }  else {
            return "Login failed";
        }
    }

    @PostMapping("/signup") 
    public HttpStatus signup(@RequestBody User user){
        userService.addUser(user);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/delete")
    public HttpStatus delete(@RequestBody User user) {
        userService.deleteUser(user);
        return HttpStatus.OK;
    }

    @PutMapping("/user/update/{userId}")
    public String updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        User u = userService.getUserById(userId);
        if (u != null) {
            u.setUserName(user.getUserName());
            u.setPassword(user.getPassword());
            u.setEmail(user.getEmail());
            u.setDateOfBirth(user.getDateOfBirth());
            u.setPhoneNumber(user.getPhoneNumber());
            userService.addUser(u);
            return "Update Successful";
        } else {
            return "Update failed";
        }
    }

}
