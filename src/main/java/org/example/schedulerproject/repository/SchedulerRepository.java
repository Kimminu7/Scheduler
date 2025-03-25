package org.example.schedulerproject.repository;

import org.example.schedulerproject.dto.ScResponseDto;
import org.example.schedulerproject.entity.Scheduler;

public interface SchedulerRepository {

    // 메모를 생성하는 Insert
    ScResponseDto addSchedule(Scheduler scheduler);

    // 메모를 조회하는 Select
    ScResponseDto findAll();

    // 메모를 조회하는 Select


    // 메모를 수정하는 Update


    // 메모를 삭제하는 Delete
}
