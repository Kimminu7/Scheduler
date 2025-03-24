package org.example.schedulerproject.repository;

import org.example.schedulerproject.dto.SchedulerResponseDto;
import org.example.schedulerproject.entity.Scheduler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcSchedulerRepositoryImpl implements SchedulerRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcSchedulerRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public SchedulerResponseDto addSchedule(Scheduler scheduler) {
        // INSERT Query 직접 작성하지 않아도 된다.
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("user").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", scheduler.getName());
        parameters.put("contents", scheduler.getContents());
        parameters.put("created_at", scheduler.getCreated_at());
        parameters.put("password", scheduler.getPassword());

        // 저장 후 생성된 key값 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new SchedulerResponseDto(key.longValue(),scheduler.getName(), scheduler.getContents(), scheduler.getPassword(), scheduler.getCreated_at(), scheduler.getUpdated_at());
    }
}
