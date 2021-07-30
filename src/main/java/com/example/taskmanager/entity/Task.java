package com.example.taskmanager.entity;

import com.example.taskmanager.util.TaskFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table
public class Task implements TaskFactory {

    //TODO: Document Factory Pattern
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private String taskName;

    @Column
    private String taskDescription;

    @Column
    private Date creationDate;

    @Column
    private Date dueDate;

    public Task() {
    }

    public Task(final int id, final String taskName, final String taskDescription, final Date creationDate,
                final Date dueDate) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    public Task(String taskName, String taskDescription, Date creationDate, Date dueDate) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
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

}
