package org.example.schedulerproject.service;

import org.example.schedulerproject.dto.ScRequestDto;
import org.example.schedulerproject.dto.ScResponseDto;

public interface SchedulerService {

    //  생성
    ScResponseDto addSchedule(ScRequestDto dto);

    //  전체 조회
    ScResponseDto findAll();

    //  단건 조회


    //  수정


    //  삭제

}
