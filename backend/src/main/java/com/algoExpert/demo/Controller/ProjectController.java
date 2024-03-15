package com.algoExpert.demo.Controller;

import com.algoExpert.demo.Entity.Project;
import com.algoExpert.demo.Entity.User;
import com.algoExpert.demo.Repository.UserRepository;
import com.algoExpert.demo.Service.ProjectService;
import com.algoExpert.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

//  create project using user id
    @PostMapping("/createProject/{user_id}")
    public Project create(@RequestBody Project project, @PathVariable int user_id){
        return projectService.createProject(project,user_id);
    }

//    get all projects
    @GetMapping("/findAllProject")
    public List<Project> getAllProject(){
        return projectService.getAllProjects();
    }

}
