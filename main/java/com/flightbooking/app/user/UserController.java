package com.flightbooking.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController (UserService userService){
        this.userService=userService;
    }
    @PostMapping("/create")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }


    @GetMapping("/login")
    public User logUser(@RequestParam String userName,@RequestParam String password){


        return userService.authenticateUser(userName,password);
    }



}
