package com.chandana.tasksync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.chandana.tasksync.entity.TaskList;
import com.chandana.tasksync.repository.TaskListRepository;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository taskListRepository;

    public List<TaskList> getAllLists() {
        return taskListRepository.findAll();
    }

    public TaskList saveList(TaskList list) {
        return taskListRepository.save(list);
    }

    public void deleteList(Long id) {
        taskListRepository.deleteById(id);
    }
}
