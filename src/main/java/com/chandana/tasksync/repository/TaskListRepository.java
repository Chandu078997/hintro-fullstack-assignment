package com.chandana.tasksync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chandana.tasksync.entity.TaskList;

import java.util.List;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
	
	List<TaskList> findByBoardId(Long boardId);
}
