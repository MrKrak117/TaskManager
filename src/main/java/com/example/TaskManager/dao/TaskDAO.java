package com.example.TaskManager.dao;

import com.example.TaskManager.entity.Task;
import com.example.TaskManager.util.TaskFactory;

import java.sql.Date;

public class TaskDAO  implements TaskFactory {

    //TODO: Document Factory Pattern
    private int id;
    private String taskName;
    private String taskDescription;
    private Date creationDate;
    private Date dueDate;

    public TaskDAO() {
    }

    public TaskDAO(final Task task) {
        this.id = task.getId();
        this.taskName = task.getTaskName();
        this.taskDescription = task.getTaskDescription();
        this.creationDate = task.getCreationDate();
        this.dueDate = task.getDueDate();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(final int id) {
        this.id = id;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public void setTaskName(final String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public void setTaskDescription(final String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public void setDueDate(final Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "TaskDAO{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
