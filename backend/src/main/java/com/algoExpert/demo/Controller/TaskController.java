package com.algoExpert.demo.Controller;

import com.algoExpert.demo.Entity.Project;
import com.algoExpert.demo.Entity.Table;
import com.algoExpert.demo.Entity.Task;
import com.algoExpert.demo.Entity.User;

import com.algoExpert.demo.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

//  create task using table and member id
    @PostMapping("/createTask/{member_id}/{table_id}")
    public Table createTask(@PathVariable int member_id,@PathVariable int table_id){
        return taskService.createTask(member_id,table_id);
    }

//    get all tasks
    @GetMapping("/getAllTask")
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }

    //delete task
    @DeleteMapping("/deleteTaskById/{task_id}/{table_id}")
    public Table deleteTaskById(@PathVariable Integer task_id, @PathVariable Integer table_id){
       return  taskService.deleteTaskById(task_id,table_id);
    }

}
