package com.capbem.task_manager_slack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capbem.task_manager_slack.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
