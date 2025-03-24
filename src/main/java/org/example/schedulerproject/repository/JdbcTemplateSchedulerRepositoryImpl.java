package org.example.schedulerproject.repository;

import org.example.schedulerproject.dto.ScResponseDto;
import org.example.schedulerproject.entity.Scheduler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcTemplateSchedulerRepositoryImpl implements SchedulerRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateSchedulerRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 생성 INSERT
    @Override
    public ScResponseDto addSchedule(Scheduler scheduler) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        jdbcInsert.withTableName("scheduler").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", scheduler.getName());
        parameters.put("contents", scheduler.getContents());
        parameters.put("password", scheduler.getPassword());
        parameters.put("createdAt", scheduler.getCreatedAt());
        parameters.put("updatedAt", scheduler.getUpdatedAt());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScResponseDto(key.longValue(), scheduler.getName(), scheduler.getContents(), LocalDateTime.now(), LocalDateTime.now());

        // TODO 리턴 해줄것
        //return null;
    }



    // 전체 조회
    // "SELECT * FROM scheduler"


    // 단건 조회
    // "SELECT * FROM WHERE id = ?"

    // 수정
    // "UPDATE scheduler SET title = ?, contents = ?, password = ?, CreatedAt = ? WHERE id = ?"

    // 삭제
    // "DELETE FROM scheduler WHERE id = ?"


//    @Override
//    public ResponseDto findOneTodo(Long id){
//        String sql = "SELECT * FROM todo WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
//                new ResponseDto(
//                        rs.getString("userName"),
//                        rs.getString("todo"),
//                        rs.getDate("doDate"),
//                        rs.getTimestamp("createDate").toLocalDateTime(),
//                        rs.getTimestamp("updateDate").toLocalDateTime()
//                ), id
//        );
//    }

    // 단건 조회
   // public ScResponseDto findById(Long id) {
        String sql = "SELECT id, title, contents, created_at, updated_at FROM Scheduler WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, schedulerRowMapper(), id);

        /**
         * 다건조회
         * jdbcTemplate.query(sql, schedulerRowMapper());
         *
         * 생성, 수정, 삭제의 경우
         * DELETE FROM scheduler WHERE id = ?
         * jdbcTemplate.update(sql, ...);
         */
    //}

//    public RowMapper<ScResponseDto> schedulerRowMapper() {
//        return (rs, rowNum) -> {
//            ScResponseDto scheduler = new ScResponseDto(
//                    rs.getLong("id"),
//                    rs.getString("title"),
//                    rs.getString("contents"),
//                    rs.getTimestamp("created_at").toLocalDateTime(),
//                    rs.getTimestamp("updated_at").toLocalDateTime()
//            );
//        };
//    }
//

}
