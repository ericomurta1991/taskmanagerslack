package com.capbem.task_manager_slack.dto;

import java.io.Serializable;
import java.time.LocalDate;


import com.capbem.task_manager_slack.entities.Task;
import com.capbem.task_manager_slack.entities.Task.TaskPriority;
import com.capbem.task_manager_slack.entities.Task.TaskStatus;
//import com.capbem.task_manager_slack.entities.User;
import com.capbem.task_manager_slack.entities.User;




public class TaskDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String description;
	
	private LocalDate startDate;
	private LocalDate dueDate;
	
	private User user;
	
	private TaskStatus status;
	private TaskPriority priority;
	
	/*
	public enum TaskStatus {
		PENDING, COMPLETED, IN_PROGRESS
	}
	public enum TaskPriority {
		LOW, MEDIUM, HIGH
	}
	*/
	

	public TaskDTO() {
		super();
	}

	public TaskDTO(Long id, String title, String description, LocalDate startDate, LocalDate dueDate, User user, TaskStatus status, TaskPriority priority) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.user = user;
		this.status = status;
		this.priority = priority;
	}
	
	public TaskDTO(Task entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.description = entity.getDescription();
		this.startDate = entity.getStartDate();
		this.dueDate = entity.getDueDate();
		this.status = entity.getStatus();
		this.priority = entity.getPriority();
		//this.user = entity.getUser();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	/*
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	*/
	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}


	
	
	
	
}
