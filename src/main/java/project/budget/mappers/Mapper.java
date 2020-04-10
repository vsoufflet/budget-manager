package project.budget.mappers;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<I, E, O> {

    E toEntity(I inputDto);

    default List<E> toEntities(List<I> inputDtos) {
        return inputDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    O toDto(E entity);

    default List<O> toDtos(List<E> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
