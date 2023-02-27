package by.academy.pagination.dao;

import by.academy.pagination.entity.OrderType;
import by.academy.pagination.entity.PaginationObject;
import by.academy.pagination.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static by.academy.pagination.entity.Constant.FROM_HIBERNATE_CLASS;
import static by.academy.pagination.entity.Constant.UNCHECKED;

public abstract class AbstractDAO<E, K> implements DAO<E, K> {
    /**
     * entity class value.
     */
    private final Class<E> entityClass;

    /**
     * @param newEntityClass entity class value.
     */
    public AbstractDAO(final Class<E> newEntityClass) {
        entityClass = newEntityClass;
    }

    /**
     * @param entity to be saved in database.
     * @return entity with generated id value.
     */
    @Override
    public E insert(final E entity) {
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
    @Override
    public E selectById(final K id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        E entity = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    /**
     * @param entity to be updated in database.
     */
    @Override
    public void update(final E entity) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * @param id of entity which must be deleted from database.
     */
    @Override
    public void deleteById(final K id) {
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
    @Override
    public List<E> selectAll() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        List<E> entities = entityManager.createQuery(
                String.format(FROM_HIBERNATE_CLASS,
                        entityClass.getSimpleName())).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return entities;
    }

    /**
     * @param pagination contains query attributes.
     * @return found collection of entities with additional parameters.
     */
    @Override
    public PaginationObject<E> selectAllWithPagination(
            final PaginationObject<E> pagination) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(
                Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(entityClass)));
        Long count = entityManager.createQuery(countQuery).getSingleResult();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(
                entityClass);
        Root<E> from = criteriaQuery.from(entityClass);
        CriteriaQuery<E> select = criteriaQuery.select(from);
        if (OrderType.ASC.equals(pagination.getOrderType())) {
            criteriaQuery.orderBy(
                    criteriaBuilder.asc(from.get(pagination.getOrderField())));
        } else {
            criteriaQuery.orderBy(
                    criteriaBuilder.desc(from.get(pagination.getOrderField())));
        }
        TypedQuery<E> typedQuery = entityManager.createQuery(select);
        typedQuery.setFirstResult((pagination.getCurrentPage() - 1)
                * pagination.getRecordsPerPage());
        typedQuery.setMaxResults(pagination.getRecordsPerPage());
        pagination.setPagesNum(
                countNumberOfPages(pagination.getRecordsPerPage(), count));
        pagination.setRecords(typedQuery.getResultList());
        entityManager.getTransaction().commit();
        entityManager.close();
        return pagination;
    }
}
