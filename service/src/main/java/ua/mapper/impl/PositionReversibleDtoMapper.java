package ua.mapper.impl;

import org.springframework.stereotype.Component;
import ua.entity.Position;
import ua.mapper.ReversibleDtoMapper;
import ua.model.dto.PositionDto;

@Component
public class PositionReversibleDtoMapper implements ReversibleDtoMapper<Position, PositionDto> {

    public PositionDto mapToDto(Position entity) {
        PositionDto positionDto = new PositionDto();
        positionDto.setId(entity.getId());
        positionDto.setCompanyName(entity.getCompanyName());
        positionDto.setPositionName(entity.getPositionName());
        positionDto.setSalary(entity.getSalary());
        return positionDto;
    }

    public Position mapToEntity(PositionDto dto) {
        Position position = new Position();
        position.setId(dto.getId());
        position.setCompanyName(dto.getCompanyName());
        position.setPositionName(dto.getPositionName());
        position.setSalary(dto.getSalary());
        return position;
    }
}
