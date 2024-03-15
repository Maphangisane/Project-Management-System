package com.algoExpert.demo.Service;
import com.algoExpert.demo.Entity.Project;
import com.algoExpert.demo.Entity.Table;
import com.algoExpert.demo.Entity.Task;
import com.algoExpert.demo.Repository.ProjectRepository;
import com.algoExpert.demo.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private ProjectRepository projectRepository;

//  create a new table
    public Project createTable(int project_id, int member_id){
        Project project =  projectRepository.findById(project_id).get();

        List<Table> tables = project.getTables();
        Table table =new Table(0,"New Table",null);
        Task task=new Task(0,"",""
                ,member_id,"","","","",null);


        tables.add(table);
        project.setTables(tables);
        List<Task> taskList=new ArrayList<>();
        taskList.add(task);
        table.setTasks(taskList);

        return projectRepository.save(project);
    }

//  get all tables
    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

//  update table by id
//    public Table updateTable(int id, String table) {
//        Table table1 = tableRepository.findById(id).get();
//        table1.getTable_name();
//            return tableRepository.save(table);
//    }

//    delete table by id
    public void deleteTable(int id) {
        tableRepository.deleteById(id);
    }
}

