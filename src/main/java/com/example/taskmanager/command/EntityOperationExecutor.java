package com.example.taskmanager.command;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.util.TaskType;
import com.example.taskmanager.util.Utility;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class EntityOperationExecutor {

    private final EntityOperation[] entityOperations;

    public EntityOperationExecutor(EntityOperation[] entityOperations) {
        this.entityOperations = entityOperations;
    }

    public List<Task> executeOperation() {
        EntityOperation entityOperation = Utility.findOperation(TaskType.GET, entityOperations);
        return entityOperation.execute();
    }

    public Task executeOperation(Task task, TaskType taskType) {
        EntityOperation entityOperation = Utility.findOperation(taskType, entityOperations);
        return entityOperation.execute(task);
    }
}
