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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class JdbcTemplateSchedulerRepositoryImpl implements SchedulerRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateSchedulerRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 생성 INSERT ( 구글링 )
    //"INSERT INTO schedulers (name, contents, password)   VALUES (?, ? ,?)"
    @Override
    public ScResponseDto addSchedule(Scheduler scheduler) {
        String sql = "INSERT INTO scheduler (name, contents, password) VALUES(?, ?, ?)";
        // 구글링 해서 찾은 방식.
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
    }

    // 전체 조회
    // "SELECT * FROM scheduler"
    @Override
    public List<ScResponseDto> findAll() {
        // 배열 형태로 반환 ( 전체 ) .query문은 조회할때만 사용
        return jdbcTemplate.query("SELECT * FROM scheduler", schedulerRowMapper());
    }


    // 단건 조회
    // "SELECT * FROM scheduler WHERE id = ?"
    @Override
    public ScResponseDto findById(Long id) {
        // 한건만 조회 하고 싶은경우 똑같이 .queryForObject 형식으로 사용.
        return jdbcTemplate.queryForObject("SELECT * FROM scheduler WHERE id = ?", schedulerRowMapper(), id);
    }

    // 수정
    // "UPDATE scheduler SET name = ?, contents = ?, password = ? WHERE id = ?"
    @Override
    public String editSchedule(Scheduler updatedSchedule) {
        String sql = "UPDATE scheduler SET name = ?, contents = ?, password = ? WHERE id = ?";
        int result = jdbcTemplate.update(sql,
                ps -> { // 숫자는 위 SQL문의 ?와 매칭됨
                    ps.setString(1, updatedSchedule.getName());
                    ps.setString(2, updatedSchedule.getContents());
                    ps.setString(3, updatedSchedule.getPassword());
                    ps.setLong(4, updatedSchedule.getId());
                }
        );

        return "수정 완료";
    }

    // 삭제
    // "DELETE FROM scheduler WHERE id = ?"
    @Override
    public int deleteSchedule(Long id) {
        return jdbcTemplate.update("DELETE FROM scheduler WHERE id = ?", id);
    }

        /**
         * 다건조회
         * jdbcTemplate.query(sql, schedulerRowMapper());
         *
         * 생성, 수정, 삭제의 경우
         * DELETE FROM scheduler WHERE id = ?
         * jdbcTemplate.update(sql, ...);
         */

    // JDBC 에서 활용하는 RowMapper 클래스
    private RowMapper<ScResponseDto> schedulerRowMapper() {

        return new RowMapper<ScResponseDto>() {
            @Override
            public ScResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScResponseDto(
                        rs.getLong("id"),  // 이때 해당 DB 컬럼명에 맞게 작성해야함.
                        rs.getString("name"),
                        rs.getString("contents"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
            }
        };
    }

}
