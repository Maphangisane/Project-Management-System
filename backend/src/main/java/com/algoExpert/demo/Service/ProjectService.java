package com.algoExpert.demo.Service;

import com.algoExpert.demo.Entity.*;
import com.algoExpert.demo.Repository.ProjectRepository;
import com.algoExpert.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TableService tableService;

//  create project
    public Project createProject(Project project,Integer user_id)
    {
//      find user by id
        User user=userRepository.findById(user_id).get();
        project.setUser(user);
        Project savedProjects =projectRepository.save(project);

//      add owner to the project as a member
        List<Member> members =  savedProjects.getMembersList();
        Member newMember = new Member(0,user.getUser_id(), savedProjects.getProject_id(),null);
        members.add(newMember);
        project.setMembersList(members);

//      create a default table
        tableService.createTable(project.getProject_id(), user_id);

        return projectRepository.save(savedProjects);
    }

//  get all projects
    public List<Project> getAllProjects(){return projectRepository.findAll(); }

}
