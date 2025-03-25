package org.example.schedulerproject.service;

import org.example.schedulerproject.dto.ScRequestDto;
import org.example.schedulerproject.dto.ScResponseDto;
import org.example.schedulerproject.entity.Scheduler;
import org.example.schedulerproject.repository.SchedulerRepository;
import org.springframework.stereotype.Service;

import javax.swing.tree.RowMapper;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private final SchedulerRepository SchedulerRepository;

    public SchedulerServiceImpl(SchedulerRepository schedulerRepository) {
        this.SchedulerRepository = schedulerRepository;
    }

    // 생성
    @Override
    public ScResponseDto addSchedule(ScRequestDto dto) {
        // 요청 받은 데이터를 Entity로 변환.
        Scheduler scheduler = new Scheduler(dto.getName(), dto.getContents(), dto.getPassword());

        return SchedulerRepository.addSchedule(scheduler);
    }

    // 전체조회
    @Override
    public ScResponseDto findAll() {

        return SchedulerRepository.findAll();
    }

}
