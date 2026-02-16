package com.chandana.tasksync.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;

    public Task() {}

    public Task(String title) {
        this.title = title;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public TaskList getTaskList() { return taskList; }

    public void setTaskList(TaskList taskList) { this.taskList = taskList; }
}
