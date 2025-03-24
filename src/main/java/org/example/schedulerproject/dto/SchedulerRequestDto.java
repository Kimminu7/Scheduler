package org.example.schedulerproject.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulerRequestDto {

    private String name;
    private String contents;
    private String password;
    private LocalDateTime created_at;
}
