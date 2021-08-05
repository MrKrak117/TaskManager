package com.example.taskmanager.service;

import com.example.taskmanager.command.EntityOperationExecutor;
import com.example.taskmanager.dao.TaskDAO;
import com.example.taskmanager.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class TaskServiceTest {

    @Mock
    EntityOperationExecutor entityOperationExecutor;

    private TaskService taskService;
    final List<Task> tasks = new ArrayList<>();

    @BeforeEach
    void init () throws ParseException {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

        tasks.add(new Task(1,"OOP Basics", "OOP Basic concepts training",
                new Date(df.parse("07-15-2020").getTime()), new Date(df.parse("07-16-2020").getTime())));
        tasks.add(new Task(2,"OOP Intermediate", "OOP intermediate concepts training",
                new Date(df.parse("07-16-2020").getTime()), new Date(df.parse("07-18-2020").getTime())));
        tasks.add(new Task(3,"OOP Expert", "OOP Expert concepts training",
                new Date(df.parse("07-18-2020").getTime()), new Date(df.parse("07-22-2020").getTime())));
        tasks.add(new Task(4,"JPA Training", "JPA Integration with Spring",
                new Date(df.parse("07-22-2020").getTime()), new Date(df.parse("07-24-2020").getTime())));

        taskService = new TaskService(entityOperationExecutor);

        Mockito.lenient().when(entityOperationExecutor.executeOperation()).thenReturn(tasks).thenReturn(new ArrayList<>());
        Mockito.lenient().when(entityOperationExecutor.executeOperation(any(), any())).thenReturn(tasks.get(1));
    }

    @Test
    void testGetAllTaskReturnsListWithDaos(){
        final List<TaskDAO> result = taskService.getAllTask();
        Assertions.assertEquals(4,result.size());
    }

    @Test
    void testCreateTaskIsCreatedReturningDao(){
        final TaskDAO taskDAO = new TaskDAO(tasks.get(1));
        final TaskDAO result = taskService.createTask(taskDAO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(taskDAO.getTaskName(), result.getTaskName());
    }

    @Test
    void testGetTaskByIdReturnsTaskDao(){
        final TaskDAO result = taskService.getTaskById(2);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteTaskIsDeleted(){
        taskService.deleteTask(2);
        verify(entityOperationExecutor,times(1)).executeOperation(any(), any());
    }

    @Test
    void testUpdateTaskIsUpdated(){
        final TaskDAO result = taskService.updateTask(2, new TaskDAO(tasks.get(1)));
        verify(entityOperationExecutor,times(2)).executeOperation(any(), any());

        Assertions.assertNotNull(result);
    }
}
