package com.chandana.tasksync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chandana.tasksync.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {}
