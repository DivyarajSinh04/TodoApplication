package com.app.todo.services;
import com.app.todo.models.Task;
import com.app.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TaskService {
    // How to fetch tasks from the database?
    // we have Repository that provides methods to interact with the database
    private final TaskRepository taskRepository;

    // constructor injection, here only one constructor is used, so no need for @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll(); // this will return all tasks from the database
    }

    public void createTask(String title, String description){
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false); // default value for completed is false
        taskRepository.save(task); // this will save the task to the database
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("False Id"));
        task.setCompleted(!task.isCompleted()); // task.isCompleted() returns true or false depending on the curr val of complete
        taskRepository.save(task);
    }
}
