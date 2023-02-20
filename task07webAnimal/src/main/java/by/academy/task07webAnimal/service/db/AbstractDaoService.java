package by.academy.task07webAnimal.service.db;

import by.academy.task07webAnimal.dao.AbstractDAO;
import by.academy.task07webAnimal.service.mapping.Converter;

import java.util.List;

public abstract class AbstractDaoService<T, V, R> {
    /**
     * works with database.
     */
    private final AbstractDAO<T, R> dao;
    /**
     * converts objects between entity and dto.
     */
    private final Converter<V, T> converter;

    /**
     * @param newDao       works with database.
     * @param newConverter converts objects between entity and dto.
     */
    public AbstractDaoService(final AbstractDAO<T, R> newDao,
                              final Converter<V, T> newConverter) {
        dao = newDao;
        converter = newConverter;
    }

    /**
     * @return AbstractDAO implementation.
     */
    public AbstractDAO<T, R> getDao() {
        return dao;
    }

    /**
     * @return Converter implementation.
     */
    public Converter<V, T> getConverter() {
        return converter;
    }

    /**
     * @param dto object from servlet layer.
     * @return dto object, which entity was saved in database.
     */
    public V create(final V dto) {
        T entity = converter.convertToEntity(dto);
        T createdEntity = dao.insert(entity);
        return converter.convertToDTO(createdEntity);
    }

    /**
     * @param id unique value of entity object.
     * @return dto object, which entity was found in database.
     */
    public V readById(final R id) {
        T entity = dao.selectById(id);
        return converter.convertToDTO(entity);
    }

    /**
     * @param dto object from servlet layer to be updated.
     * @return dto object, which entity was updated in database.
     */
    public V update(final V dto) {
        T entity = converter.convertToEntity(dto);
        T updatedEntity = dao.update(entity);
        return converter.convertToDTO(updatedEntity);
    }

    /**
     * @param dto which corresponding entity needs to be removed from database.
     */
    public void delete(final V dto) {
        dao.delete(converter.convertToEntity(dto));
    }

    /**
     * @param id unique value of entity object.
     */
    public void deleteById(final R id) {
        dao.deleteById(id);
    }

    /**
     * @return dto collection of all objects from concrete
     * entity class, which were saved in database.
     */
    public List<V> readAll() {
        return converter.convertToDTOCollection(dao.selectAll());
    }
}
