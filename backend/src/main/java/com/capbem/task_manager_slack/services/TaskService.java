package com.capbem.task_manager_slack.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capbem.task_manager_slack.dto.TaskDTO;
import com.capbem.task_manager_slack.entities.Task;
import com.capbem.task_manager_slack.repositories.TaskRepository;
import com.capbem.task_manager_slack.services.exceptions.DatabaseException;
import com.capbem.task_manager_slack.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository repository;
	
	@Transactional(readOnly = true)
	public Page<TaskDTO> findAllPaged(PageRequest pageRequest) {
		Page<Task> list = repository.findAll(pageRequest); 
		return list.map(x -> new TaskDTO(x));
	}
	
	@Transactional(readOnly = true)
	public TaskDTO findById(Long id) {
		Optional<Task> obj = repository.findById(id);
		Task entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		
		return new TaskDTO(entity);
	}
	
	@Transactional
	public TaskDTO insert(TaskDTO taskDto) {
		Task entity = new Task();
		entity.setTitle(taskDto.getTitle());
		entity.setDescription(taskDto.getDescription());
		entity.setDueDate(taskDto.getDueDate());
		
		entity = repository.save(entity);
		
		
		return new TaskDTO(entity);
		
	}
	
	@Transactional
	public TaskDTO update(Long id, TaskDTO taskDto) {
		try {
		Task entity = repository.getReferenceById(id);
		entity.setTitle(taskDto.getTitle());
		entity.setDescription(taskDto.getDescription());
		entity.setDueDate(taskDto.getDueDate());
	
		entity = repository.save(entity);
		
		return new TaskDTO (entity);
		
		}catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Id not found!" + id);
		}
		
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found!" + id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}

}
