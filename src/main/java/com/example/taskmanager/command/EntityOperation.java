package com.example.taskmanager.command;


import com.example.taskmanager.entity.Task;

import java.util.List;

public interface EntityOperation {
    Task execute(Task task);
    List<Task> execute();
}