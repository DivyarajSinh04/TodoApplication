package com.app.todo.repository;
import com.app.todo.models.Task; // import Task.java to use it in the repository

import org.springframework.data.jpa.repository.JpaRepository;

// repository is a class/inter that connects your app to db
// JpaRepository is a Spring Data interface that provides JPA related methods such as CRUD operations.

public interface TaskRepository extends JpaRepository<Task, Long> {
    // No need to write any methods here, JpaRepository provides all the necessary methods
    // You can add custom query methods if needed, for example:
    // List<Task> findByCompleted(boolean completed);
}
