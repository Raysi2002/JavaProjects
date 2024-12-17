package com.raysi.todolistapi.services;

import com.raysi.todolistapi.entities.Task;
import com.raysi.todolistapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TaskServices {
    @Autowired
    private TaskRepository taskRepository;

    //Get all the tasks
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public Task getTasksById(Long id){
        return taskRepository.getTaskById(id);
    }

    public void updateTaskById(Long id, boolean status){
        taskRepository.updateTask(id, status);
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteTaskById(id);
    }

    public void updateTitleById(Long id, String title) {
        taskRepository.updateTitleById(id, title);
    }
}
