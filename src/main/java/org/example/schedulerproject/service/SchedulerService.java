package org.example.schedulerproject.service;

import org.example.schedulerproject.dto.SchedulerRequestDto;
import org.example.schedulerproject.dto.SchedulerResponseDto;

public interface SchedulerService {

    SchedulerResponseDto addSchedule(SchedulerRequestDto dto);
}
