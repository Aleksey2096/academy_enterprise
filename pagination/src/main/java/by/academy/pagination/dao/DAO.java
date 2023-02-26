package by.academy.pagination.dao;

import by.academy.pagination.entity.PaginationResult;

import java.util.List;

public interface DAO<E, K> {
    /**
     * @param entity to be saved in database.
     * @return entity with generated id value.
     */
    E insert(final E entity);

    /**
     * @param id unique identification value.
     * @return found entity.
     */
    E selectById(final K id);

    /**
     * @param entity to be updated in database.
     */
    void update(final E entity);

    /**
     * @param id of entity which must be deleted from database.
     */
    void deleteById(final K id);

    /**
     * @return list of all entityClass objects saved in database.
     */
    List<E> selectAll();

    /**
     * @param recordsPerPage number of records displayed on single page.
     * @param currentPage    number of current page.
     * @return found collection of entities with additional parameters.
     */
    PaginationResult<E> selectAllWithPagination(Integer recordsPerPage,
                                                Integer currentPage);

    default Integer countNumberOfPages(Integer recordsPerPage, Long rowsNum) {
        if (rowsNum % recordsPerPage == 0) {
            return (int) (rowsNum / recordsPerPage);
        } else {
            return (int) (rowsNum / recordsPerPage) + 1;
        }
    }
}
