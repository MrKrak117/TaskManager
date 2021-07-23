package com.example.TaskManager.repository;

import com.example.TaskManager.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
