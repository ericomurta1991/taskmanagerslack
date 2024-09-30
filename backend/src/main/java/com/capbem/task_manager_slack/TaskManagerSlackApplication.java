package com.capbem.task_manager_slack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class TaskManagerSlackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerSlackApplication.class, args);
	}

}
