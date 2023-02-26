package by.academy.pagination.service.mapping;

import by.academy.pagination.entity.PaginationResult;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Converter<E, D> {
    /**
     * @param entity domain representation.
     * @return DTO entity.
     */
    D convertToDto(final E entity);

    /**
     * @param dto DTO entity.
     * @return domain representation.
     */
    E convertToEntity(final D dto);

    /**
     * @param paginationResult result of dao pagination
     *                         method with the list of entities.
     * @return PaginationResult with records list converted to DTO entities.
     */
    default PaginationResult<D> convertToDtoPaginationResult(
            final PaginationResult<E> paginationResult) {
        return PaginationResult.<D>builder().currentPage(
                        paginationResult.getCurrentPage()).pagesNum(
                        paginationResult.getPagesNum()).recordsPerPage(
                        paginationResult.getRecordsPerPage())
                .records(convertToDtoCollection(paginationResult.getRecords()))
                .build();
    }

    /**
     * @param entities collection of domain representations.
     * @return list of DTO entities.
     */
    default List<D> convertToDtoCollection(final Collection<E> entities) {
        return entities.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * @param dtoCollection collection of DTO entities.
     * @return list of domain representations.
     */
    default List<E> convertToEntities(final Collection<D> dtoCollection) {
        return dtoCollection.stream().map(this::convertToEntity)
                .collect(Collectors.toList());
    }
}
