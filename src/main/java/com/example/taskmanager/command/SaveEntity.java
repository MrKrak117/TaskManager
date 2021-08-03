package com.example.taskmanager.command;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.util.TaskType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveEntity implements EntityOperation{

    private final EntityReceiverService entityReceiver;

    public SaveEntity(EntityReceiverService entityReceiver) {
        this.entityReceiver = entityReceiver;
    }

    @Override
    public Task execute(Task task) {
        return entityReceiver.saveEntity(task);
    }

    @Override
    public List<Task> execute() {
        return null;
    }

    @Override
    public boolean canHandle(TaskType taskType) {
        return taskType.equals(TaskType.SAVE);
    }
}
