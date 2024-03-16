package com.algoExpert.demo.Service;

import com.algoExpert.demo.Entity.*;
import com.algoExpert.demo.Repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
@Service
public class TaskService {
     @Autowired
     private TaskRepository taskRepository;
     @Autowired
     private ProjectRepository projectRepository;

     @PersistenceContext
     private EntityManager entityManager;

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
    public Table deleteTaskById(Integer taskId, Integer table_id) {
        Task storedTask = taskRepository.findById(taskId).orElse(null);
        Table table = tableRepository.findById(table_id).orElse(null);

            List<Comment> comments = storedTask.getComments();
            if (!comments.isEmpty()) {
                for (Comment comment : comments) {
                    commentRepository.delete(comment);
                }
            }
           List<Task> taskList = table.getTasks();
           taskList.remove(storedTask);
           table.setTasks(taskList);
           tableRepository.save(table);
        return table;
    }
//    get all tasks
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }
}

