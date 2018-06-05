package ua.mapper;

public interface ReversibleDtoMapper<E, D> {

    D mapToDto(E entity);

    E mapToEntity(D dto);
}
