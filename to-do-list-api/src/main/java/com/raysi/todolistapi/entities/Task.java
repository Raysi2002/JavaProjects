package com.raysi.todolistapi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    @Column(length = 10000)
    //@Lob used for large strings
    private String description;
    private boolean status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
}
