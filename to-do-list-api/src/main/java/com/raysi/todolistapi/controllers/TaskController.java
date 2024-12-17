package com.raysi.todolistapi.controllers;

import com.raysi.todolistapi.entities.Task;
import com.raysi.todolistapi.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class TaskController {

    @Autowired
    private TaskServices taskServices;

    @GetMapping("/api/tasks")
    public List<Task> getTasks(){
        return taskServices.getAllTasks();
    }

    @PostMapping("/api/tasks")
    public String saveTask(@RequestBody Task task){

        taskServices.saveTask(task);

        return "Task stored successfully";
    }

    @GetMapping("/api/tasks/{id}")
    public Task getAllTaskById(@PathVariable Long id){
        return taskServices.getTasksById(id);
    }

    @PutMapping("/api/tasks/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody boolean status){
        taskServices.updateTaskById(id, status);
        return "Status updated successfully!";
    }

    @DeleteMapping("/api/tasks/{id}")
    public String deleteTask(@PathVariable Long id){
        taskServices.deleteTaskById(id);
        return "Task deleted successfully";
    }

    @PutMapping("/api/tasks/title/{id}")
    public String updateTitle(@PathVariable Long id, @RequestBody String title){
        taskServices.updateTitleById(id, title);
        return "Title updated successfully!";
    }
}
