package org.example.schedulerproject.dto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
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
}
