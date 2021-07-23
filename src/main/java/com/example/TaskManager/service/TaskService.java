package com.example.TaskManager.service;

import com.example.TaskManager.dao.TaskDAO;
import com.example.TaskManager.entity.Task;
import com.example.TaskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDAO> getAllTask(){
        final List<TaskDAO> taskDAOS = new ArrayList<>();

        taskRepository.findAll().forEach(task -> taskDAOS.add(new TaskDAO(task)));

        return taskDAOS;
    }

    public TaskDAO getTaskById(final int id){
        final Optional<Task> result = taskRepository.findById(id);
        return result.map(TaskDAO::new).orElse(null);
    }

    public void deleteTask(final int id){
        final Task task = new Task();
        task.setId(id);

        taskRepository.delete(task);
    }

    public TaskDAO updateTask(final TaskDAO taskDao){
        Task task;
        final Optional<Task> result = taskRepository.findById(taskDao.getId());

        if(!result.isPresent()){
            return null;
        }

        task = result.get();
        task.setTaskName(taskDao.getTaskName());
        task.setTaskDescription(taskDao.getTaskDescription());
        task.setCreationDate(task.getCreationDate());
        task.setDueDate(task.getDueDate());

        return new TaskDAO(taskRepository.save(task));
    }

}
