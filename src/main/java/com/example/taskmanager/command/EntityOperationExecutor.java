package com.example.taskmanager.command;

import com.example.taskmanager.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityOperationExecutor {

    private final List<EntityOperation> operations = new ArrayList<>();

    public List<Task> executeOperation(EntityOperation entityOperation) {
        operations.add(entityOperation);
        return entityOperation.execute();
    }


    public Task executeOperation(EntityOperation entityOperation, Task task) {
        operations.add(entityOperation);
        return entityOperation.execute(task);
    }
}
