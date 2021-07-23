DROP TABLE IF EXISTS TASK; 
 
CREATE TABLE TASK (  
	taskId INT AUTO_INCREMENT PRIMARY KEY,  
	taskName VARCHAR(30),  
	taskDescription VARCHAR(80),
	creationDate DATE,
	dueDate DATE
);  
