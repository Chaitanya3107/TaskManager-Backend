package com.example.TaskManager.controller;
import com.example.TaskManager.model.Tasks;
import com.example.TaskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService service;
    // getting all tasks
    @GetMapping("tasks")
    public List<Tasks> getAllTask(){
        return service.getAllTasks();
    }
    // getting single task
    @GetMapping("task/{id}")
    public Tasks getTask(@PathVariable("id") int id){
        return service.getTask(id);
    }
    // adding a task
    @PostMapping("tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Tasks addTask(@RequestBody Tasks task){
        service.addTask(task);
        return service.getTask(task.getId());
    }
    // updating a task
    @PutMapping("tasks/{id}")
    public Tasks updateTask(@PathVariable("id")int id, @RequestBody Tasks task){
        service.updateTask(id,task);
        return service.getTask(id);
    }
    // deleting a task
    @DeleteMapping("tasks/{id}")
    public String deleteTaskById(@PathVariable("id") int id){
        service.deleteTaskById(id);
        return "Deleted";
    }


}
