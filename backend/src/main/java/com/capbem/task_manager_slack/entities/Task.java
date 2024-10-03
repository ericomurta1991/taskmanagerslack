package com.capbem.task_manager_slack.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


@Entity
public class Task implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Instant startDate;
	private LocalDate dueDate;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	@Enumerated(EnumType.STRING)
	private TaskPriority priority;

	
	public enum TaskStatus {
		PENDING, COMPLETED, IN_PROGRESS
	}
	public enum TaskPriority {
		LOW, MEDIUM, HIGH
	}
	
	public Task() {
		super();
	}

	public Task(Long id, String title, String description, Instant startdate, LocalDate dueDate, Instant createdAt, Instant updatedAt,
			User user, TaskStatus status, TaskPriority priority) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startdate;
		this.dueDate = dueDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.status = status;
		this.priority = priority;
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


	public Instant getStartDate() {
		return startDate;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
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
	
	public Instant getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
	public void prePersist() {
		this.createdAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdated() {
		this.updatedAt = Instant.now();
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
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
