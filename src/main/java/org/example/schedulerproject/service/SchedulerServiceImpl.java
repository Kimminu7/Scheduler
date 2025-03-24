package org.example.schedulerproject.service;

import org.example.schedulerproject.dto.SchedulerRequestDto;
import org.example.schedulerproject.dto.SchedulerResponseDto;
import org.example.schedulerproject.entity.Scheduler;
import org.example.schedulerproject.repository.SchedulerRepository;
import org.springframework.stereotype.Service;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private final SchedulerRepository schedulerRepository;

    public SchedulerServiceImpl(SchedulerRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }

    @Override
    public SchedulerResponseDto addSchedule(SchedulerRequestDto dto) {
        Scheduler scheduler = new Scheduler(dto.getName(), dto.getContents(), dto.getCreated_at(), dto.getPassword());
        return schedulerRepository.addSchedule(scheduler);
    }
}
