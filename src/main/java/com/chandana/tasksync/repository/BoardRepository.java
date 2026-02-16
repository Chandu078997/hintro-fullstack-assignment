package com.chandana.tasksync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chandana.tasksync.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
