package org.example.schedulerproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Scheduler {

    private Long id;
    private String name;
    private String contents;
    private String password;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Scheduler(String name, String contents, LocalDateTime createdAt, String password) {
        this.name = name;
        this.contents = contents;
        this.created_at = createdAt;
        this.password = password;
    }
}
