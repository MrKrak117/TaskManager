package com.example.taskmanager.command;

import com.example.taskmanager.entity.Task;

import java.util.List;

public class SaveEntity implements EntityOperation{

    private final EntityReceiverService entityReceiver = new EntityReceiverService();

    @Override
    public Task execute(Task task) {
        return entityReceiver.saveEntity(task);
    }

    @Override
    public List<Task> execute() {
        return null;
    }
}
