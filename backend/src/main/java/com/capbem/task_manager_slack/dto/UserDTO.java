package com.capbem.task_manager_slack.dto;

import java.io.Serializable;

import com.capbem.task_manager_slack.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	
	
	public UserDTO() {
		super();
	}


	public UserDTO(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.nome = entity.getName();
		this.email = entity.getEmail();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
}
