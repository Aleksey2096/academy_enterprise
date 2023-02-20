package by.academy.task07webAnimal.dao;

import by.academy.task07webAnimal.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

import static by.academy.task07webAnimal.entity.Constant.FROM_HIBERNATE_CLASS;
import static by.academy.task07webAnimal.entity.Constant.UNCHECKED;

public abstract class AbstractDAO<T, R> {
    /**
     * entity class value.
     */
    private final Class<T> entityClass;

    /**
     * @param newEntityClass entity class value.
     */
    public AbstractDAO(final Class<T> newEntityClass) {
        entityClass = newEntityClass;
    }

    /**
     * @param entity to be saved in database.
     * @return entity with generated id value.
     */
    public T insert(final T entity) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    /**
     * @param id unique identification value.
     * @return found entity.
     */
    public T selectById(final R id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        T entity = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    /**
     * @param entity to be updated in database.
     * @return updated entity.
     */
    public T update(final T entity) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        T updatedEntity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return updatedEntity;
    }

    /**
     * @param entity to be deleted from database.
     */
    public void delete(final T entity) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(entity) ? entity
                : entityManager.merge(entity));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * @param id of entity which must be deleted from database.
     */
    public void deleteById(final R id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(entityClass, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * @return list of all entityClass objects saved in database.
     */
    @SuppressWarnings(UNCHECKED)
    public List<T> selectAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        List<T> entities = entityManager.createQuery(
                String.format(FROM_HIBERNATE_CLASS,
                        entityClass.getSimpleName())).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return entities;
    }
}
