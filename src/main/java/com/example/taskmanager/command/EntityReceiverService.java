package com.example.taskmanager.command;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntityReceiverService {

    private final TaskRepository taskRepository;

    public EntityReceiverService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveEntity(Task task) {
        return taskRepository.save(task);
    }

    public Task getEntity(Task task) {
        final Optional<Task> result = taskRepository.findById(task.getId());
        return result.orElse(null);

    }

    public Task deleteEntity(Task task) {
        taskRepository.delete(task);
        return task;
    }

    public List<Task> getAllEntities(){
        final List<Task> taskDAOS = new ArrayList<>();
        taskRepository.findAll().forEach(taskDAOS::add);
        return taskDAOS;
    }

}
