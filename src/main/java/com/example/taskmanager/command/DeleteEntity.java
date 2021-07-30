package com.example.taskmanager.command;

import com.example.taskmanager.entity.Task;

import java.util.List;

public class DeleteEntity implements  EntityOperation{

    private final EntityReceiverService entityReceiver = new EntityReceiverService();

    @Override
    public Task execute(Task task) {
        return entityReceiver.deleteEntity(task);
    }

    @Override
    public List<Task> execute() {
        return null;
    }

}
