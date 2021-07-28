package com.example.taskmanager.service;

import com.example.taskmanager.dao.TaskDAO;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TaskServiceTest {
/*
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private final TaskService taskService = new TaskService(taskRepository);

    private static final List<Task> tasks = new ArrayList<>();

    @BeforeAll
    public static void init() throws ParseException {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

        tasks.add(new Task(1,"OOP Basics", "OOP Basic concepts training",
                new Date(df.parse("07-15-2020").getTime()), new Date(df.parse("07-16-2020").getTime())));
        tasks.add(new Task(2,"OOP Intermediate", "OOP intermediate concepts training",
                new Date(df.parse("07-16-2020").getTime()), new Date(df.parse("07-18-2020").getTime())));
        tasks.add(new Task(3,"OOP Expert", "OOP Expert concepts training",
                new Date(df.parse("07-18-2020").getTime()), new Date(df.parse("07-22-2020").getTime())));
        tasks.add(new Task(4,"JPA Training", "JPA Integration with Spring",
                new Date(df.parse("07-22-2020").getTime()), new Date(df.parse("07-24-2020").getTime())));
    }

    @Test
    void testGetAllTaskReturnsListWithDaos(){
        when(taskRepository.findAll()).thenReturn(tasks);

        final List<TaskDAO> result = taskService.getAllTask();

        Assertions.assertEquals(4,result.size());
    }

    @Test
    void testGetAllTaskNoRecordsReturnsEmptyList(){
        when(taskRepository.findAll()).thenReturn(new ArrayList<>());

        final List<TaskDAO> result = taskService.getAllTask();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(0,result.size());
    }

    @Test
    void testGetTaskByIdReturnsDao(){
        when(taskRepository.findById(2)).thenReturn(tasks.stream().filter( task -> task.getId() == 2).findFirst());

        final TaskDAO result = taskService.getTaskById(2);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(tasks.get(1).getTaskName(), result.getTaskName());
    }

    @Test
    void testCreateTaskTaskIsCreatedAndReturnDAO(){
        final TaskDAO taskDAO;
        final Task task = new Task();

        task.setTaskName("SomeName");
        task.setId(14);
        task.setTaskDescription("SomeDesc");

        taskDAO = new TaskDAO(task);

        final TaskDAO result = taskService.createTask(taskDAO);

        Assertions.assertNotNull(result);
    }

    @Test
    void testGetTaskByIdNotFoundReturnsNull(){
        when(taskRepository.findById(2)).thenReturn(Optional.empty());

        final TaskDAO result = taskService.getTaskById(2);

        Assertions.assertNull(result);
    }

    @Test
    void testDeleteTaskByIdDeletedMethodIsExecuted(){

        taskService.deleteTask(17);

        verify(taskRepository, times(1)).delete(any());
    }

    @Test
    void testUpdateTaskByIdTaskIsUpdated(){
        final TaskDAO taskDAO;
        final Task task = new Task();

        task.setTaskName("SomeName");
        task.setId(14);
        task.setTaskDescription("SomeDesc");

        taskDAO = new TaskDAO(task);

        when(taskRepository.save(any())).thenReturn(task);
        when(taskRepository.findById(14)).thenReturn(Optional.of(task));

        final TaskDAO result = taskService.updateTask(14, taskDAO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(taskDAO.getTaskName(), result.getTaskName());

    }

    @Test
    void testUpdateTaskByIdTaskNotFoundReturnsNull(){
        final TaskDAO result = taskService.updateTask(0, new TaskDAO());

        Assertions.assertNull(result);
    }*/
}
