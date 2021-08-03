package com.example.taskmanager.command;


import com.example.taskmanager.entity.Task;
import com.example.taskmanager.util.TaskType;

import java.util.List;

public interface EntityOperation {
    Task execute(Task task);
    List<Task> execute();
    boolean canHandle(TaskType taskType);
}