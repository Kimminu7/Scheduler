package org.example.schedulerproject.service;

import org.example.schedulerproject.dto.ScRequestDto;
import org.example.schedulerproject.dto.ScResponseDto;
import org.example.schedulerproject.entity.Scheduler;
import org.example.schedulerproject.repository.SchedulerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class SchedulerServiceImpl implements SchedulerService {

    // 레포지토리
    private final SchedulerRepository schedulerRepository;

    // 레포지토리 생성
    public SchedulerServiceImpl(SchedulerRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }

    // 생성
    @Override
    public ScResponseDto addSchedule(ScRequestDto dto) {
        // 요청 받은 데이터를 Entity로 변환.
        Scheduler scheduler = new Scheduler(dto.getName(), dto.getContents(), dto.getPassword());

        return schedulerRepository.addSchedule(scheduler);
    }

    // 전체 조회
    @Override
    public List<ScResponseDto> findAll() {
        return schedulerRepository.findAll();
    }

    // 단건 조회
    @Override
    public ScResponseDto findById(Long id) {
        return schedulerRepository.findById(id);
    }

    // 수정
    @Override
    public String editSchedule(Long id, String name, String contents, String password) {

        // 수정해야 할 DB에 이미 저장되어있는 id값을 가져옴.
        ScResponseDto findScheduler = schedulerRepository.findById(id);
        Scheduler updatedSchedule = new Scheduler(findScheduler.getId(), name, contents, password);

        return schedulerRepository.editSchedule(updatedSchedule);
    }

    // 삭제
    @Override
    public void deleteSchedule(Long id) {

        int deletedRow = schedulerRepository.deleteSchedule(id);

        if (deletedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



}
