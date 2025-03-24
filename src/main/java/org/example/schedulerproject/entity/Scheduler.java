package org.example.schedulerproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Scheduler {

    private Long id;
    private String name;
    private String contents;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Scheduler(String name, String contents, String password) {
        this.name = name;
        this.contents = contents;
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }

}
