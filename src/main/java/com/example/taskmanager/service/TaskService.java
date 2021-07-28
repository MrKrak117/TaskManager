package com.example.taskmanager.service;

import com.example.taskmanager.dao.TaskDAO;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDAO> getAllTask(){
        final List<TaskDAO> taskDAOS = new ArrayList<>();

        taskRepository.findAll().forEach(task -> taskDAOS.add(new TaskDAO(task)));

        return taskDAOS;
    }

    public TaskDAO createTask(final TaskDAO taskDAO){
        final Task task = new Task();

        task.setTaskName(taskDAO.getTaskName());
        task.setTaskDescription(taskDAO.getTaskDescription());
        task.setCreationDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        task.setDueDate(taskDAO.getDueDate());
        taskRepository.save(task);

        return new TaskDAO(task);
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

    public TaskDAO updateTask(final int id, final TaskDAO taskDao){
        Task task;
        final Optional<Task> result = taskRepository.findById(id);

        if(!result.isPresent()){
            return null;
        }

        task = result.get();
        task.setTaskName(taskDao.getTaskName());
        task.setTaskDescription(taskDao.getTaskDescription());
        task.setCreationDate(taskDao.getCreationDate());
        task.setDueDate(taskDao.getDueDate());

        return new TaskDAO(taskRepository.save(task));
    }

}
