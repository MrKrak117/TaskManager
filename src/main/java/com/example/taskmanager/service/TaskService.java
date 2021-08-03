package com.example.taskmanager.service;

import com.example.taskmanager.command.EntityOperationExecutor;
import com.example.taskmanager.dao.TaskDAO;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.util.TaskType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class TaskService {

    private final EntityOperationExecutor entityOperationExecutor;

    public TaskService(EntityOperationExecutor entityOperationExecutor) {
        this.entityOperationExecutor = entityOperationExecutor;
    }

    public List<TaskDAO> getAllTask(){
        final List<Task> result = entityOperationExecutor.executeOperation();
        final List<TaskDAO> taskDAOS = new ArrayList<>();

        result.forEach(task -> taskDAOS.add(new TaskDAO(task)));

        return taskDAOS;
    }

    public TaskDAO createTask(final TaskDAO taskDAO){
        final Task task = new Task(taskDAO.getTaskName(), taskDAO.getTaskDescription(),new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                taskDAO.getDueDate());
        final Task result = entityOperationExecutor.executeOperation(task, TaskType.SAVE);

        return new TaskDAO(result);
    }

    public TaskDAO getTaskById(final int id){
        final Task task = new Task();
        task.setId(id);

        final Task result = entityOperationExecutor.executeOperation(task, TaskType.GET);

        return new TaskDAO(result);
    }

    public void deleteTask(final int id){
        final Task task = new Task();
        task.setId(id);

        entityOperationExecutor.executeOperation(task, TaskType.DELETE);
    }

    public TaskDAO updateTask(final int id, final TaskDAO taskDao){
        Task task = new Task();
        task.setId(id);

        task = entityOperationExecutor.executeOperation(task, TaskType.SAVE);

        task.setTaskName(taskDao.getTaskName());
        task.setTaskDescription(taskDao.getTaskDescription());
        task.setDueDate(taskDao.getDueDate());

        final Task result = entityOperationExecutor.executeOperation(task, TaskType.SAVE);

        return new TaskDAO(result);
    }

}
