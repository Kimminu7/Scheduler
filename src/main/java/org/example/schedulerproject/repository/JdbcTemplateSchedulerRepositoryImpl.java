package org.example.schedulerproject.repository;

import org.example.schedulerproject.dto.ScResponseDto;
import org.example.schedulerproject.entity.Scheduler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;


@Repository
public class JdbcTemplateSchedulerRepositoryImpl implements SchedulerRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateSchedulerRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 생성 INSERT
    @Override
    public ScResponseDto addSchedule(Scheduler scheduler) {
        String sql = "INSERT INTO scheduler (name, contents, password) VALUES(?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, scheduler.getName());
            ps.setString(2, scheduler.getContents());
            ps.setString(3, scheduler.getPassword());
            return ps;
        }, keyHolder);
        long key = keyHolder.getKey().longValue();
        scheduler.setId(key);

        // TODO 리턴 해줄것
        return new ScResponseDto(key, scheduler.getName(), scheduler.getContents());
        //"INSERT INTO schedulers (name, contents, password)   VALUES (?, ? ,?)"
    }


    // 전체 조회
    @Override
    public ScResponseDto findAll() {
        String sql = "SELECT * FROM scheduler";

        return null;
    }
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

    private RowMapper<Scheduler> schedulerRowMapper() {
        return (rs, rowNum) -> {
            Scheduler scheduler = new Scheduler();
            scheduler.setId(rs.getLong("id"));
            scheduler.setName(rs.getString("name"));
            scheduler.setPassword(rs.getString("password"));
            scheduler.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
            scheduler.setUpdatedAt(rs.getTimestamp("updatedAt").toLocalDateTime());
            return scheduler;
        };
    }
}
