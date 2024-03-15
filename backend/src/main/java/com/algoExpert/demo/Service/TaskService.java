package com.algoExpert.demo.Service;

import com.algoExpert.demo.Entity.*;
import com.algoExpert.demo.Repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
     private CommentRepository commentRepository;

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

    //delete task
    @Transactional
    public List<Task> deleteTaskById(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task != null) {
            List<Comment> comments = task.getComments();
            if (comments != null) {
                for (Comment comment : comments) {
                    commentRepository.delete(comment);
                }
            }
            taskRepository.delete(task);
        }
        return taskRepository.findAll();
    }
//    get all tasks
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

}

