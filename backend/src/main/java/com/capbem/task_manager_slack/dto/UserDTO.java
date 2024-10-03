package com.capbem.task_manager_slack.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.capbem.task_manager_slack.entities.Task;
import com.capbem.task_manager_slack.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private LocalDate birthday;
	
	
	private List<TaskDTO> tasks = new ArrayList<>();
	
	
	public UserDTO() {
		super();
	}


	public UserDTO(Long id, String name, String email, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.birthday = entity.getBirthday();
		
	}
	
	public UserDTO(User entity, Set<Task> tasks ) {
		 this(entity);
		 tasks.forEach(task -> this.tasks.add(new TaskDTO(task)));
		 
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public List<TaskDTO> getTasks() {
		return tasks;
	}


	public void setTasks(List<TaskDTO> tasks) {
		this.tasks = tasks;
	}
	
	
	
	
	
	
	
}
