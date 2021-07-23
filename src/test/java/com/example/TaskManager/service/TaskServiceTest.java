package com.example.TaskManager.service;

import com.example.TaskManager.dao.TaskDAO;
import com.example.TaskManager.entity.Task;
import com.example.TaskManager.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private final TaskService taskService = new TaskService();

    private final List<Task> tasks = new ArrayList<>();

    @Before
    public void init() throws ParseException {
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
    public void testGetAllTaskReturnsListWithDaos(){
        when(taskRepository.findAll()).thenReturn(tasks);

        final List<TaskDAO> result = taskService.getAllTask();

        Assert.assertEquals(4,result.size());
    }

    @Test
    public void testGetAllTaskNoRecordsReturnsEmptyList(){
        when(taskRepository.findAll()).thenReturn(new ArrayList<>());

        final List<TaskDAO> result = taskService.getAllTask();

        Assert.assertNotNull(result);
        Assert.assertEquals(0,result.size());
    }

    @Test
    public void testGetTaskByIdReturnsDao(){
        when(taskRepository.findById(2)).thenReturn(tasks.stream().filter( task -> task.getId() == 2).findFirst());

        final TaskDAO result = taskService.getTaskById(2);

        Assert.assertNotNull(result);
        Assert.assertEquals(tasks.get(1).getTaskName(), result.getTaskName());
    }

    @Test
    public void testGetTaskByIdNotFoundReturnsNull(){
        when(taskRepository.findById(2)).thenReturn(Optional.empty());

        final TaskDAO result = taskService.getTaskById(2);

        Assert.assertNull(result);
    }

    @Test
    public void testDeleteTaskByIdDeletedMethodIsExecuted(){

        taskService.deleteTask(17);

        verify(taskRepository, times(1)).delete(any());
    }

    @Test
    public void testUpdateTaskByIdTaskIsUpdated(){
        final TaskDAO taskDAO;
        final Task task = new Task();

        task.setTaskName("SomeName");
        task.setId(14);
        task.setTaskDescription("SomeDesc");

        taskDAO = new TaskDAO(task);

        when(taskRepository.save(any())).thenReturn(task);
        when(taskRepository.findById(14)).thenReturn(Optional.of(task));

        final TaskDAO result = taskService.updateTask(taskDAO);

        Assert.assertNotNull(result);
        Assert.assertEquals(taskDAO.getTaskName(), result.getTaskName());

    }

    @Test
    public void testUpdateTaskByIdTaskNotFoundReturnsNull(){
        final TaskDAO result = taskService.updateTask(new TaskDAO());

        Assert.assertNull(result);
    }
}
