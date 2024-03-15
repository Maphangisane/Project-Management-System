package com.algoExpert.demo.Service;

import com.algoExpert.demo.Entity.*;
import com.algoExpert.demo.Repository.MemberRepository;
import com.algoExpert.demo.Repository.ProjectRepository;
import com.algoExpert.demo.Repository.TableRepository;
import com.algoExpert.demo.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    private TableRepository tableRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TableService tableService;

//  create project
    public Integer createProject(Project project,int user_id)
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

        Project savedProject = projectRepository.save(savedProjects);
        return savedProject.getProject_id();
    }

//  get all projects
    public List<Project> getAllProjects(){return projectRepository.findAll(); }

    //get one project
    public Project findProject(int project_id){
        return projectRepository.findById(project_id).get();
    }

    @Transactional
    public List<Project> deleteProjectById(Integer projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project with ID " + projectId + " not found"));

        // Delete associated tables
        for (Table table : project.getTables()) {
            tableRepository.delete(table);
        }

        // Delete associated members
        for (Member member : project.getMembersList()) {
            memberRepository.delete(member);
        }
        // Now delete the project
        projectRepository.delete(project);

        return  projectRepository.findAll();
    }

}
