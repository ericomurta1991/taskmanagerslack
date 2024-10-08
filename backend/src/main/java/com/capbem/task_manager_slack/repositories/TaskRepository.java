package com.capbem.task_manager_slack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capbem.task_manager_slack.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
