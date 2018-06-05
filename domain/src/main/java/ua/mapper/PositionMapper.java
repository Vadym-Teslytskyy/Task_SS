package ua.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.entity.Position;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PositionMapper implements RowMapper<Position> {
    @Override
    public Position mapRow(ResultSet resultSet, int i) throws SQLException {
        Position position = new Position();
        position.setId(resultSet.getInt("id"));
        position.setCompanyName(resultSet.getString("company_name"));
        position.setPositionName(resultSet.getString("position_name"));
        position.setSalary(resultSet.getBigDecimal("salary"));
        return position;
    }
}
