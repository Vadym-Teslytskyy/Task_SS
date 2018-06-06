package ua.service;

import ua.model.dto.PositionDto;

import java.util.List;
import java.util.Optional;

public interface PositionService {

    Optional<PositionDto> findPositionById(Integer id);

    Optional<List<PositionDto>> getAllPositions();

    boolean deletePosition(PositionDto positionDto);

    boolean updatePosition(PositionDto positionDto);

    boolean createPosition(PositionDto positionDto);
}
