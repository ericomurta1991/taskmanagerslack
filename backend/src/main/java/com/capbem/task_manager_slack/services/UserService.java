package com.capbem.task_manager_slack.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capbem.task_manager_slack.dto.UserDTO;
import com.capbem.task_manager_slack.entities.User;
import com.capbem.task_manager_slack.repositories.UserRepository;
import com.capbem.task_manager_slack.services.exceptions.DatabaseException;
import com.capbem.task_manager_slack.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(PageRequest pageRequest) {
		Page<User> list = repository.findAll(pageRequest);
		
		return list.map(x -> new UserDTO(x));
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.get();
		
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insert(UserDTO userDto) {
		User entity = new User();
		entity.setName(userDto.getName());
		entity.setEmail(userDto.getEmail());
		entity.setBirthday(userDto.getBirthday());
		entity = repository.save(entity);
	
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO update(Long id, UserDTO userDto) {
		try {
			User entity = repository.getReferenceById(id);
			entity.setName(userDto.getName());
			entity.setEmail(userDto.getEmail());
			entity.setBirthday(userDto.getBirthday());
			
			return new UserDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not Found " + id);
		}
		
	}
	

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not Found " + id);
		}catch (DataIntegrityViolationException e){
			throw new DatabaseException("Integrity violation");
		}
		
	}

	
}
