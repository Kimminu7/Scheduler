package org.example.schedulerproject.dto;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ScRequestDto {

    private String name;
    private String contents;
    private String password;
}
