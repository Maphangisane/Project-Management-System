package com.algoExpert.demo.Service;

import com.algoExpert.demo.Entity.*;
import com.algoExpert.demo.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    create user
    public User create(User user){
        return userRepository.save(user);
    }

// get all users
    public List<User> getUsers(){
        return userRepository.findAll();
    }

//    update user by id
//    TODO

//    delete user by id
    public List<User> deleteUser(int userId){
        userRepository.deleteById(userId);
        return userRepository.findAll();
    }

}
