package com.capbem.task_manager_slack.resources;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capbem.task_manager_slack.dto.TaskDTO;
import com.capbem.task_manager_slack.services.TaskService;

@RestController
@RequestMapping
public class TaskResource {
	
	private TaskService service;
	
	@GetMapping
	public ResponseEntity<Page<TaskDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "title") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<TaskDTO> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TaskDTO> findById(@PathVariable Long id){
		
		TaskDTO taskDto = service.findById(id);
		return ResponseEntity.ok().body(taskDto);
	}
	
	@PostMapping
	public ResponseEntity<TaskDTO> insert(@RequestBody TaskDTO taskDto){
		taskDto = service.insert(taskDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskDto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(taskDto);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDto){
		taskDto = service.update(id, taskDto );
		return ResponseEntity.ok().body(taskDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
