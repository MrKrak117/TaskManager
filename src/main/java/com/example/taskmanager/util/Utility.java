package com.example.taskmanager.util;

import com.example.taskmanager.command.EntityOperation;

import java.util.Arrays;
import java.util.Optional;

public class Utility {

    public static EntityOperation findOperation(TaskType taskType, EntityOperation[] entityOperations){
        Optional<EntityOperation> entityOperation = Arrays.stream(entityOperations).
                filter(operation -> operation.canHandle(taskType)).findAny();
        return entityOperation.orElse(null);

    }

}
