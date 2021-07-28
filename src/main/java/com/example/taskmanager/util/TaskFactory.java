package com.example.taskmanager.util;

import java.sql.Date;

public interface TaskFactory {

    public int getId();
    public void setId(final int id);
    public String getTaskName();
    public void setTaskName(final String taskName);
    public String getTaskDescription();
    public void setTaskDescription(final String taskDescription);
    public Date getCreationDate();
    public void setCreationDate(final Date creationDate);
    public Date getDueDate();
    public void setDueDate(final Date dueDate);

}