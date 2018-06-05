package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dto.PositionDto;
import ua.mapper.impl.PositionReversibleDtoMapper;
import ua.repository.PositionRepository;
import ua.service.PositionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    private PositionRepository positionRepository;

    private PositionReversibleDtoMapper dtoMapper;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository, PositionReversibleDtoMapper dtoMapper) {
        this.positionRepository = positionRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public Optional<PositionDto> findPositionById(Integer id) {
        return Optional.of(
                dtoMapper.mapToDto(
                        positionRepository.findPositionById(id)));
    }

    @Override
    public Optional<List<PositionDto>> getAllPositions() {
        return Optional.of(
                positionRepository.getAllPositions().stream()
                        .map(position -> dtoMapper.mapToDto(position)).collect(Collectors.toList()));
    }

    @Override
    public boolean deletePosition(PositionDto positionDto) {
        return positionRepository.deletePosition(dtoMapper.mapToEntity(positionDto));
    }

    @Override
    public boolean updatePosition(PositionDto positionDto) {
        return positionRepository.updatePosition(dtoMapper.mapToEntity(positionDto));
    }

    @Override
    public boolean createPosition(PositionDto positionDto) {
        return positionRepository.createPosition(dtoMapper.mapToEntity(positionDto));
    }
}
