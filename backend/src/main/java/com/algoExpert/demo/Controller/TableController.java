package com.algoExpert.demo.Controller;

import com.algoExpert.demo.Entity.Project;
import com.algoExpert.demo.Entity.Table;
import com.algoExpert.demo.Service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @CrossOrigin("http://localhost:3000")
@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableService tableService;

//    create table
    @PostMapping("/createTable/{project_id}/{member_id}")
    public Project createTable(@PathVariable Integer project_id, @PathVariable int member_id){
        return tableService.createTable(project_id,member_id);
    }

//    get all tables
    @GetMapping("/getAllTables")
    public List<Table> getAllTables() {
    return tableService.getAllTables();
}

//    update table
//    @PutMapping("/updateTable/{id}")
//    public Table updateTable(@PathVariable int id, @RequestBody Table table) {
//        return tableService.updateTable(id, table);
//    }
//
////    delete table
//    @DeleteMapping("/deleteTable/{id}")
//    public void deleteTable(@PathVariable int id) {
//        tableService.deleteTable(id);
//    }

//  get  table by id
    // @GetMapping("/getTable/{id}")
    // public Table getTableById(@PathVariable int id) {
    //     return tableService.getTableById(id);
    // }

}