package com.chandana.tasksync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.chandana.tasksync.entity.TaskList;
import com.chandana.tasksync.service.TaskListService;

@RestController
@RequestMapping("/api/lists")
@CrossOrigin("*")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @GetMapping
    public List<TaskList> getLists() {
        return taskListService.getAllLists();
    }

    @PostMapping
    public TaskList createList(@RequestBody TaskList list) {
        return taskListService.saveList(list);
    }

    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable Long id) {
        taskListService.deleteList(id);
    }
}
