package com.flightbooking.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User saveUser(User user) {

        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User deleteUserById(Integer uid) {
        User existingUser = userRepo.findById(uid).orElse(null);
        if (existingUser != null) {
            userRepo.deleteById(uid);
        }
        return existingUser;
    }

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();

    }

    @Override
    public User findUserById(Integer uid) {
        User existingUser = userRepo.findById(uid).orElse(null);
        return existingUser;

    }

    @Override
    public User updateUser(User user, Integer uid) {
        User existingUser = userRepo.findById(uid).orElse(null);
        if (existingUser != null) {
            existingUser.setUserId(user.getUserId());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmailId(user.getEmailId());
            existingUser.setPassportNumber(user.getPassportNumber());
            return userRepo.save(existingUser);

        }
        return existingUser;
    }

    @Override
    public User authenticateUser(String userName, String password) {
        User user = userRepo.findUserByUserNAme(userName);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}


