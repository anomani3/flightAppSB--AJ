package com.flightbooking.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
