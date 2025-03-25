package org.example.schedulerproject.repository;

import org.example.schedulerproject.dto.ScResponseDto;
import org.example.schedulerproject.entity.Scheduler;

import java.util.List;
import java.util.Optional;

public interface SchedulerRepository {

    // 생성
    ScResponseDto addSchedule(Scheduler scheduler);

    // 전체 조회
    List<ScResponseDto> findAll();

    // 단건 조회
    ScResponseDto findByid(Long id);

    // 수정


    // 삭제
    int deleteSchedule(Long id);



}
