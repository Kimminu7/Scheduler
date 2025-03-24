package org.example.schedulerproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.schedulerproject.entity.Scheduler;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SchedulerResponseDto {

    private Long id;
    private String name;
    private String contents;
    private String password;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public SchedulerResponseDto(Scheduler scheduler) {
        this.id = scheduler.getId();
        this.name = scheduler.getName();
        this.contents = scheduler.getContents();
        this.password = scheduler.getPassword();
        this.created_at = scheduler.getCreated_at();
        this.updated_at = scheduler.getUpdated_at();
    }
}
