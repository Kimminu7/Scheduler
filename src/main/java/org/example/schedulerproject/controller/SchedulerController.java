package org.example.schedulerproject.controller;

import org.example.schedulerproject.dto.SchedulerRequestDto;
import org.example.schedulerproject.dto.SchedulerResponseDto;
import org.example.schedulerproject.service.SchedulerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/schedules")
public class SchedulerController {

    private final SchedulerService schedulerService;

    public SchedulerController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostMapping
    public ResponseEntity<SchedulerResponseDto> addSchedule(@RequestBody SchedulerRequestDto dto) {

        return new ResponseEntity<>(schedulerService.addSchedule(dto),HttpStatus.CREATED);
    }


}
