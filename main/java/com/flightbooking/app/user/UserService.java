package com.flightbooking.app.user;

import java.util.List;

public interface UserService {

    User saveUser(User user);
     List<User> getAllUser();
   User  deleteUserById(Integer uid);
   List<User>findAllUser();
   User findUserById(Integer uid);
   User updateUser(User user ,Integer uid);


}
