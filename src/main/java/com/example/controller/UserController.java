package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	public static  Long suserid;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
//    @PostMapping("/login")
//    @ResponseBody // This annotation is needed to directly return a boolean value
//    public boolean login(@RequestParam String emailId, @RequestParam String password, HttpSession session) {
//        User user = userService.login(emailId, password);
//        if (user != null) {
//            session.setAttribute("userId", user.getUserId()); // Assuming getUserId() returns the user_id attribute
//            return true;
//        } else {
//            return false;
//        }
//    
//    }
    @PostMapping("/login")
    @ResponseBody // This annotation is needed to directly return a boolean value
    public boolean login(@RequestParam String emailId, @RequestParam String password,HttpSession session) {
        User user = userService.login(emailId, password);
        if (user != null) {
           session.setAttribute("userId", user.getUserId()); // Assuming getUserId() returns the user_id attribute
           suserid=user.getUserId();
            return true;
        } 
        return false;
    }
}
