package com.example.taskmanager.service;

import com.example.taskmanager.command.DeleteEntity;
import com.example.taskmanager.command.EntityOperationExecutor;
import com.example.taskmanager.command.GetEntity;
import com.example.taskmanager.command.SaveEntity;
import com.example.taskmanager.dao.TaskDAO;
import com.example.taskmanager.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private  EntityOperationExecutor entityOperationExecutor;

    public List<TaskDAO> getAllTask(){


        final List<Task> result = entityOperationExecutor.executeOperation(new GetEntity());


        final List<TaskDAO> taskDAOS = new ArrayList<>();

        result.forEach(task -> taskDAOS.add(new TaskDAO(task)));

        return taskDAOS;
    }

    public TaskDAO createTask(final TaskDAO taskDAO){
        final Task task = new Task(taskDAO.getTaskName(), taskDAO.getTaskDescription(),new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                taskDAO.getDueDate());

        /*task.setTaskName(taskDAO.getTaskName());
        task.setTaskDescription(taskDAO.getTaskDescription());
        task.setCreationDate());
        task.setDueDate(taskDAO.getDueDate());*/

        final Task result = entityOperationExecutor.executeOperation(new SaveEntity(), task);

        return new TaskDAO(result);
    }

    public TaskDAO getTaskById(final int id){
        final Task task = new Task();
        task.setId(id);

        final Task result = entityOperationExecutor.executeOperation(new GetEntity(), task);

        return new TaskDAO(result);
    }

    public void deleteTask(final int id){
        final Task task = new Task();
        task.setId(id);

        entityOperationExecutor.executeOperation(new DeleteEntity(), task);
    }

    public TaskDAO updateTask(final int id, final TaskDAO taskDao){
        Task task = new Task();
        task.setId(id);

        task = entityOperationExecutor.executeOperation(new GetEntity(), task);

        task.setTaskName(taskDao.getTaskName());
        task.setTaskDescription(taskDao.getTaskDescription());
        task.setDueDate(taskDao.getDueDate());

        final Task result = entityOperationExecutor.executeOperation(new SaveEntity(), task);

        return new TaskDAO(result);
    }

}
