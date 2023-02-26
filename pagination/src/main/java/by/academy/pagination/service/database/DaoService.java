package by.academy.pagination.service.database;

import by.academy.pagination.entity.PaginationResult;

import java.util.List;

public interface DaoService<D, K> {
    /**
     * @param dto object from servlet layer.
     * @return dto object, which entity was saved in database.
     */
    D create(D dto);

    /**
     * @param key unique value of entity object.
     * @return dto object, which entity was found in database.
     */
    D readById(K key);

    /**
     * @param dto object from servlet layer to be updated.
     */
    void update(D dto);

    /**
     * @param key unique value of entity object.
     */
    void deleteById(K key);

    /**
     * @return dto collection of all objects from concrete
     * entity class, which were saved in database.
     */
    List<D> readAll();

    /**
     * @param recordsPerPage number of records displayed on single page.
     * @param currentPage    number of current page.
     * @return PaginationResult with collection of entities converted to DTO.
     */
    PaginationResult<D> readAllWithPagination(Integer recordsPerPage,
                                              Integer currentPage);
}
