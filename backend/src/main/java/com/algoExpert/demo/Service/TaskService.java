package com.algoExpert.demo.Service;

import com.algoExpert.demo.Entity.*;
import com.algoExpert.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TaskService {
     @Autowired
     private TaskRepository taskRepository;
     @Autowired
     private ProjectRepository projectRepository;

     @Autowired
     private AssigneesRepository assigneesRepository;

     @Autowired
     private TableRepository tableRepository;

    @Autowired
    private MemberRepository memberRepository;

//    create new task
    public Table createTask(int member_id, int table_id){

        Table table = tableRepository.findById(table_id).get();

        List<Task> taskList =table.getTasks();
        Task task=new Task(0,"",""
                ,member_id,"","","","",null);

        taskList.add(task);
        table.setTasks(taskList);

        return tableRepository.save(table);
    }

//    get all tasks
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

}

