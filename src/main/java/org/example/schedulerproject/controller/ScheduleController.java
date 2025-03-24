package org.example.schedulerproject.controller;

import org.example.schedulerproject.dto.ScRequestDto;
import org.example.schedulerproject.dto.ScResponseDto;
import org.example.schedulerproject.service.SchedulerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final SchedulerService schedulerService;

    public ScheduleController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostMapping
    public ResponseEntity<ScResponseDto> addSchedule(@RequestBody ScRequestDto dto) {

        return new ResponseEntity<>(schedulerService.addSchedule(dto), HttpStatus.CREATED);
    }
}
