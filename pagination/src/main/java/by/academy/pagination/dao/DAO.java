package by.academy.pagination.dao;

import by.academy.pagination.entity.OrderType;
import by.academy.pagination.entity.PaginationObject;

import java.util.List;

public interface DAO<E, K> {
    /**
     * @param entity to be saved in database.
     * @return entity with generated id value.
     */
    E insert(E entity);

    /**
     * @param id unique identification value.
     * @return found entity.
     */
    E selectById(K id);

    /**
     * @param entity to be updated in database.
     */
    void update(E entity);

    /**
     * @param id of entity which must be deleted from database.
     */
    void deleteById(K id);

    /**
     * @return list of all entityClass objects saved in database.
     */
    List<E> selectAll();

    /**
     * @param paginationObject contains query attributes.
     * @return found collection of entities with additional parameters.
     */
    PaginationObject<E> selectAllWithPagination(
            PaginationObject<E> paginationObject);

    /**
     * @param recordsPerPage number of records displayed on single page.
     * @param rowsNum        common quantity of rows found in database.
     * @return number of pages.
     */
    default Integer countNumberOfPages(Integer recordsPerPage, Long rowsNum) {
        if (rowsNum % recordsPerPage == 0) {
            return (int) (rowsNum / recordsPerPage);
        } else {
            return (int) (rowsNum / recordsPerPage) + 1;
        }
    }
}
