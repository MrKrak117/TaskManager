package com.example.taskmanager.command;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.util.TaskType;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GetEntity implements EntityOperation{

    private final EntityReceiverService entityReceiver;

    public GetEntity(EntityReceiverService entityReceiver) {
        this.entityReceiver = entityReceiver;
    }

    @Override
    public Task execute(Task task) {
        return entityReceiver.getEntity(task);
    }

    @Override
    public List<Task> execute() {
        return entityReceiver.getAllEntities();
    }

    @Override
    public boolean canHandle(TaskType taskType) {
        return taskType.equals(TaskType.GET);
    }
}
