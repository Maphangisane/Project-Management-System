package com.algoExpert.demo.Service;

import com.algoExpert.demo.Entity.*;
import com.algoExpert.demo.Repository.MemberRepository;
import com.algoExpert.demo.Repository.ProjectRepository;
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

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProjectRepository projectRepository;

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
    public List<Project> getUserProjectIds(int userId) {
        // Find all members
        List<Member> memberList = memberRepository.findAll();

        // Filter members by user_id and map them to project ids
        List<Integer> userProjectIds = memberList.stream()
                .filter(member -> member.getUser_id() == userId)
                .map(Member::getProject_id) // Assuming you have a method getProject_id() in Member class
                .collect(Collectors.toList());

        return projectRepository.findAllById(userProjectIds);
    }

}
