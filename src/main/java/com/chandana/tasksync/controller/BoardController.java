package com.chandana.tasksync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

import com.chandana.tasksync.entity.Board;
import com.chandana.tasksync.entity.Task;
import com.chandana.tasksync.entity.TaskList;
import com.chandana.tasksync.repository.BoardRepository;
import com.chandana.tasksync.repository.TaskListRepository;
import com.chandana.tasksync.repository.TaskRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private TaskListRepository taskListRepository;

    @GetMapping("/{id}")
    public String viewBoard(@PathVariable Long id, Model model) {

        Optional<Board> board = boardRepository.findById(id);

        if (board.isPresent()) {

            List<TaskList> lists = taskListRepository.findByBoardId(id);

            model.addAttribute("board", board.get());
            model.addAttribute("lists", lists);

            return "board";
        }

        return "redirect:/dashboard";
    }
    @PostMapping("/create")
    public String createBoard(@RequestParam String name) {

        Board board = new Board();
        board.setName(name);

        boardRepository.save(board);

        return "redirect:/dashboard";
    }
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/{boardId}/task/create")
    public String createTask(@PathVariable Long boardId,
                             @RequestParam Long listId,
                             @RequestParam String title) {

        TaskList list = taskListRepository.findById(listId).orElse(null);

        if (list != null) {

            Task task = new Task();
            task.setTitle(title);
            task.setTaskList(list);

            taskRepository.save(task);
        }

        return "redirect:/board/" + boardId;
    }
    @PostMapping("/{boardId}/task/delete/{taskId}")
    public String deleteTask(@PathVariable Long boardId,
                             @PathVariable Long taskId) {

        taskRepository.deleteById(taskId);

        return "redirect:/board/" + boardId;
    }

    @PostMapping("/{boardId}/list/delete/{listId}")
    public String deleteList(@PathVariable Long boardId,
                             @PathVariable Long listId) {

        taskListRepository.deleteById(listId);

        return "redirect:/board/" + boardId;
    }
    @PostMapping("/delete/{boardId}")
    public String deleteBoard(@PathVariable Long boardId) {

        boardRepository.deleteById(boardId);

        return "redirect:/dashboard";
    }
    @PostMapping("/{boardId}/task/edit/{taskId}")
    public String editTask(@PathVariable Long boardId,
                           @PathVariable Long taskId,
                           @RequestParam String title) {

        Task task = taskRepository.findById(taskId).orElse(null);

        if (task != null) {
            task.setTitle(title);
            taskRepository.save(task);
        }

        return "redirect:/board/" + boardId;
    }

    @PostMapping("/{boardId}/list/create")
    public String createList(@PathVariable Long boardId,
                             @RequestParam String name) {

        Board board = boardRepository.findById(boardId).orElse(null);

        if (board != null) {
            TaskList list = new TaskList();
            list.setName(name);
            list.setBoard(board);

            taskListRepository.save(list);
        }

        return "redirect:/board/" + boardId;
    }


}
