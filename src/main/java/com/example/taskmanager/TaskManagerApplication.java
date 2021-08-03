package com.example.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TaskManagerApplication {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(TaskManagerApplication.class, args);
		checkBeansPresence("entityOperationExecutor","entityReceiver","taskRepository","getEntity","saveEntity","deleteEntity");

	}

	private static void checkBeansPresence(String... beans) {
		for (String beanName : beans) {
			System.out.println("Is " + beanName + " in ApplicationContext: " +
					applicationContext.containsBean(beanName));
		}
	}
}
