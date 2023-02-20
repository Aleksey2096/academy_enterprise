package by.academy.task07webAnimal.service.mapping;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Converter<T, R> {
    /**
     * converts dto into entity.
     */
    private final Function<T, R> toEntity;
    /**
     * converts entity into dto.
     */
    private final Function<R, T> toDTO;

    /**
     * @param newToEntity function that converts given dto
     *                    entity into the domain entity.
     * @param newToDTO    function that converts given domain
     *                    entity into the dto entity.
     */
    public Converter(final Function<T, R> newToEntity,
                     final Function<R, T> newToDTO) {
        toEntity = newToEntity;
        toDTO = newToDTO;
    }

    /**
     * @param dto DTO entity.
     * @return domain representation.
     */
    public final R convertToEntity(final T dto) {
        return toEntity.apply(dto);
    }

    /**
     * @param entity domain representation.
     * @return DTO entity.
     */
    public final T convertToDTO(final R entity) {
        return toDTO.apply(entity);
    }

    /**
     * @param dtoCollection collection of DTO entities.
     * @return list of domain representations.
     */
    public final List<R> convertToEntityCollection(
            final Collection<T> dtoCollection) {
        return dtoCollection.stream().map(this::convertToEntity).collect(
                Collectors.toList());
    }

    /**
     * @param entityCollection collection of domain representations.
     * @return list of DTO entities.
     */
    public final List<T> convertToDTOCollection(
            final Collection<R> entityCollection) {
        return entityCollection.stream().map(this::convertToDTO).collect(
                Collectors.toList());
    }
}
