package com.app.todo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// this class will be transformed to a table in the database using JPA
@Entity // without this it's just a normal java class, use entity to map it to a table
@Data // lombok annotation to generate getters, setters, toString, equals, and hashCode methods.
// There are @Getter, @Setter, @ToString, etc. annotations as well.
public class Task {
    @Id // it defines Long id as the primary key for the table
    @GeneratedValue(strategy = GenerationType.AUTO) // this will auto-generate the id for each task
    private Long id;
    private String title;
    private String description;
    private boolean completed;

    // Getters and Setters - You can either have a boiler code or generate them using lombok
//    public Long getId() {
//        return id;
//    }

}
