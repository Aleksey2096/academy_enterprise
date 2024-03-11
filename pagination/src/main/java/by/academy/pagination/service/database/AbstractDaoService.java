package by.academy.pagination.service.database;

import by.academy.pagination.dao.AbstractDAO;
import by.academy.pagination.entity.PaginationObject;
import by.academy.pagination.service.mapping.Converter;

import java.util.List;

public abstract class AbstractDaoService<E, D, K>
        implements DaoService<E, D, K> {
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

    /**
     * @param dto object from servlet layer.
     * @return dto object, which entity was saved in database.
     */
    @Override
    public D create(final D dto) {
        E entity = converter.convertToEntity(dto);
        E createdEntity = dao.insert(entity);
        return converter.convertToDto(createdEntity);
    }

    /**
     * @param id unique value of entity object.
     * @return dto object, which entity was found in database.
     */
    @Override
    public D readById(final K id) {
        E entity = dao.selectById(id);
        return converter.convertToDto(entity);
    }

    /**
     * @param dto object from servlet layer to be updated.
     */
    @Override
    public void update(final D dto) {
        E entity = converter.convertToEntity(dto);
        dao.update(entity);
    }

    /**
     * @param id unique value of entity object.
     */
    @Override
    public void deleteById(final K id) {
        dao.deleteById(id);
    }

    /**
     * @return dto collection of all objects from concrete
     * entity class, which were saved in database.
     */
    @Override
    public List<D> readAll() {
        return converter.convertToDtoCollection(dao.selectAll());
    }

    /**
     * @param pagination contains query attributes.
     * @return PaginationResult with collection of entities converted to DTO.
     */
    @Override
    public PaginationObject<D> readAllWithPagination(
            final PaginationObject<E> pagination) {
        return converter.convertToDtoPaginationResult(
                dao.selectAllWithPagination(pagination));
    }
}
