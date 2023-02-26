package by.academy.pagination.service.database;

import by.academy.pagination.dao.AbstractDAO;
import by.academy.pagination.entity.PaginationResult;
import by.academy.pagination.service.mapping.Converter;

import java.util.List;

public abstract class AbstractDaoService<E, D, K> implements DaoService<D, K> {
    /**
     * works with database.
     */
    private final AbstractDAO<E, K> dao;
    /**
     * converts objects between entity and dto.
     */
    private final Converter<E, D> converter;

    /**
     * @param newDao       works with database.
     * @param newConverter converts objects between entity and dto.
     */
    public AbstractDaoService(final AbstractDAO<E, K> newDao,
                              final Converter<E, D> newConverter) {
        dao = newDao;
        converter = newConverter;
    }

    /**
     * @return AbstractDAO implementation.
     */
    public AbstractDAO<E, K> getDao() {
        return dao;
    }

    /**
     * @return Converter implementation.
     */
    public Converter<E, D> getConverter() {
        return converter;
    }

    @Override
    public D create(final D dto) {
        E entity = converter.convertToEntity(dto);
        E createdEntity = dao.insert(entity);
        return converter.convertToDto(createdEntity);
    }

    @Override
    public D readById(final K id) {
        E entity = dao.selectById(id);
        return converter.convertToDto(entity);
    }

    @Override
    public void update(final D dto) {
        E entity = converter.convertToEntity(dto);
        dao.update(entity);
    }

    @Override
    public void deleteById(final K id) {
        dao.deleteById(id);
    }

    @Override
    public List<D> readAll() {
        return converter.convertToDtoCollection(dao.selectAll());
    }

    @Override
    public PaginationResult<D> readAllWithPagination(Integer recordsPerPage,
                                                     Integer currentPage) {
        return converter.convertToDtoPaginationResult(
                dao.selectAllWithPagination(recordsPerPage, currentPage));
    }
}
