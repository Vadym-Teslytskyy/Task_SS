package ua.repository;

import ua.entity.Position;

import java.util.List;

public interface PositionRepository {

    Position findEmployeeById(Integer id);

    List<Position> getAllEmployees();

    boolean deleteEmployee(Position employee);

    boolean updateEmployee(Position employee);

    boolean createEmployee(Position employee);
}
