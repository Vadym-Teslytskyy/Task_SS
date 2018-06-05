package ua.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.entity.Position;
import ua.mapper.PositionMapper;
import ua.repository.PositionRepository;

import javax.sql.DataSource;
import java.util.List;

public class PositionRepositoryImpl implements PositionRepository {

    JdbcTemplate jdbcTemplate;

    PositionMapper positionMapper;

    private final String SQL_FIND_POSITION_BY_ID = "select * from position where id = ?";
    private final String SQL_DELETE_POSITION_BY_ID = "delete from position where id = ?";
    private final String SQL_UPDATE_POSITION_BY_ID = "update position set company_name = ?, position_name = ?,"
            + " salary  = ? where id = ?";
    private final String SQL_FIND_ALL = "select * from position";
    private final String SQL_INSERT_POSITION = "insert into position(id, company_name, position_name, salary)"
            + " values(?,?,?,?)";

    @Autowired
    public PositionRepositoryImpl(DataSource dataSource, PositionMapper positionMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.positionMapper = positionMapper;
    }

    @Override
    public Position findEmployeeById(Integer id) {
        return jdbcTemplate.queryForObject(SQL_FIND_POSITION_BY_ID, new Object[]{id}, positionMapper);
    }

    @Override
    public List<Position> getAllEmployees() {
        return jdbcTemplate.query(SQL_FIND_ALL, positionMapper);
    }

    @Override
    public boolean deleteEmployee(Position position) {
        return jdbcTemplate.update(SQL_DELETE_POSITION_BY_ID, position.getId()) > 0;
    }

    @Override
    public boolean updateEmployee(Position position) {
        return jdbcTemplate.update(SQL_UPDATE_POSITION_BY_ID, position.getCompanyName(), position.getPositionName(),
                position.getSalary(), position.getId()) > 0;
    }

    @Override
    public boolean createEmployee(Position position) {
        return jdbcTemplate.update(SQL_INSERT_POSITION, position.getId(), position.getCompanyName(),
                position.getPositionName(), position.getSalary()) > 0;
    }
}