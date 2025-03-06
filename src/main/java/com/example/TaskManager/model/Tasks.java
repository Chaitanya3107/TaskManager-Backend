package com.example.TaskManager.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String task;
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean completion = false;

}
