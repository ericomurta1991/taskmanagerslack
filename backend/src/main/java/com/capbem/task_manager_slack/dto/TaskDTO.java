package com.capbem.task_manager_slack.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import com.capbem.task_manager_slack.entities.Task;
import com.capbem.task_manager_slack.entities.User;

public class TaskDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private Instant createdAt;
	
	private User user;

	public TaskDTO() {
		super();
	}

	public TaskDTO(Long id, String title, String description, LocalDate dueDate, Instant createdAt, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.createdAt = createdAt;
		this.user = user;
	}
	
	public TaskDTO(Task entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.description = entity.getDescription();
		this.dueDate = entity.getDueDate();
		this.createdAt = entity.getCreatedAt();
		this.user = entity.getUser();
		
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

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}	
	
	
}
