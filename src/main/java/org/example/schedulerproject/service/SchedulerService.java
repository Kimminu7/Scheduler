package org.example.schedulerproject.service;

import org.example.schedulerproject.dto.ScRequestDto;
import org.example.schedulerproject.dto.ScResponseDto;
import org.example.schedulerproject.entity.Scheduler;

import java.util.List;
import java.util.Optional;

public interface SchedulerService {

    //  생성
    ScResponseDto addSchedule(ScRequestDto dto);

    //  전체 조회
    List<ScResponseDto> findAll();



    //  단건 조회
    ScResponseDto findById(Long id);

    //  수정


    //  삭제
    void deleteSchedule(Long id);



}
