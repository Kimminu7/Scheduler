package org.example.schedulerproject.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.schedulerproject.entity.Scheduler;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScResponseDto {

    private Long id;
    private String name;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ScResponseDto(Long id, String name, String contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
    }

    public ScResponseDto(Scheduler scheduler) {
        this.id = scheduler.getId();
        this.name = scheduler.getName();
        this.contents = scheduler.getContents();
        this.createdAt = scheduler.getCreatedAt();
        this.updatedAt = scheduler.getUpdatedAt();
    }
}
