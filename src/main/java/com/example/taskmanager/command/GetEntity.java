package com.example.taskmanager.command;

import com.example.taskmanager.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class GetEntity implements EntityOperation{

    @Autowired
    private ApplicationContext appContext;


    private final EntityReceiverService entityReceiver = new EntityReceiverService();

    @Override
    public Task execute(Task task) {
        return entityReceiver.getEntity(task);
    }

    @Override
    public List<Task> execute() {
        return entityReceiver.getAllEntities();
    }
}
