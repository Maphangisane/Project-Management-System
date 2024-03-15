package com.algoExpert.demo;

import com.algoExpert.demo.Entity.Task;
import com.algoExpert.demo.Repository.TaskRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private TaskRepository taskRepository;

	// This tests the creation of a new task
//	@Test
//	void createTask(){
//		Task task = new Task();
//
//		task.setTitle("Task");
//		task.setDescription("Description");
//		task.setOwner("Thabang");
//		task.setStart_date("Start_date");
//		task.setEnd_date("End_date");
//		task.setStatus("Done");
//		task.setPriority("Critical");
//		task.setComment("code review done");
//
//		Task savedTask = taskRepository.save(task);
//
//		Assertions.assertThat(savedTask).isNotNull();
//	}

	// This tests checks if Tasks list from db is not empty
//	@Test
//	void readAllTasks(){
//		Iterable<Task> tasks = taskRepository.findAll();
//		Assertions.assertThat(tasks).hasSizeGreaterThan(0);
//	}
}
