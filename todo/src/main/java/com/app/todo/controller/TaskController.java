package com.app.todo.controller;
import com.app.todo.models.Task;
import com.app.todo.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Model is used to pass data from the controller to the view
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
//@RequestMapping("/tasks") // this will map all requests to /tasks to this controller
public class TaskController {

    private final TaskService taskService;

    //constructor injection, here only one constructor is used, so no need for @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks); // add tasks to the model to be used in the view
        return "tasks.html"; // this will return the tasks view, from resources/templates/tasks.html
    }

    @PostMapping
    public String createTasks(@RequestParam String title,@RequestParam String description) {
        taskService.createTask(title, description); // call the service to create a task
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
