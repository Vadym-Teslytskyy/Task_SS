package ua.repository;

import ua.entity.Position;

import java.util.List;

public interface PositionRepository {

    Position findPositionById(Integer id);

    List<Position> getAllPositions();

    boolean deletePosition(Position position);

    boolean updatePosition(Position position);

    boolean createPosition(Position position);
}
