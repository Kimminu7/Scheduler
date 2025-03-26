package org.example.schedulerproject.controller;

import org.example.schedulerproject.dto.ScRequestDto;
import org.example.schedulerproject.dto.ScResponseDto;
import org.example.schedulerproject.service.SchedulerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    // 서비스
    private final SchedulerService schedulerService;

    // 서비스 생성
    public ScheduleController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    // 생성
    @PostMapping
    public ResponseEntity<ScResponseDto> addSchedule(@RequestBody ScRequestDto dto) {

        return new ResponseEntity<>(schedulerService.addSchedule(dto), HttpStatus.CREATED);
    }

    // 전체 조회
    @GetMapping
    public List<ScResponseDto> findAll() {

        return schedulerService.findAll();
    }
    // 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScResponseDto> findById(@PathVariable Long id) {

        return new ResponseEntity<>(schedulerService.findById(id), HttpStatus.OK);
    }

    // 수정 ????
    @PutMapping("/{id}")
    public ResponseEntity<String> editSchedule(
            @PathVariable Long id,
            @RequestBody ScRequestDto dto
    ) {
        return new ResponseEntity<>(schedulerService.editSchedule(id, dto.getName(), dto.getContents(), dto.getPassword()), HttpStatus.OK);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        schedulerService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
