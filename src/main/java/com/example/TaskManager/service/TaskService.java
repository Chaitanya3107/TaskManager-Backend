package com.example.TaskManager.service;
import com.example.TaskManager.model.Tasks;
import com.example.TaskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;

    public List<Tasks> getAllTasks() {
        return repo.findAll();

    }
    public void addTask(Tasks task) {
        repo.save(task);
    }

    public Tasks getTask(int id) {
        return repo.findById(id).orElse(new Tasks());
    }

    public void updateTask(int id,Tasks newTask) {
        Tasks existingTask = repo.findById(id).orElseThrow(()->new RuntimeException("Task not found with id: "+ id));
        existingTask.setTask(newTask.getTask());
        existingTask.setCompletion(newTask.isCompletion());
        repo.save(existingTask);
    }

    public void deleteTaskById(int id) {
        repo.deleteById(id);
    }
}







