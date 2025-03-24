package org.example.schedulerproject.repository;

import org.example.schedulerproject.dto.SchedulerResponseDto;
import org.example.schedulerproject.entity.Scheduler;

public interface SchedulerRepository {

    SchedulerResponseDto addSchedule(Scheduler scheduler);

}
