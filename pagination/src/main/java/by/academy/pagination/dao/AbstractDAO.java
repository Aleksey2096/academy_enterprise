package by.academy.pagination.dao;

import by.academy.pagination.entity.PaginationResult;
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

    @Override
    public E insert(final E entity) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    @Override
    public E selectById(final K id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        E entity = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    @Override
    public void update(final E entity) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteById(final K id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(entityClass, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

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

    @Override
    public PaginationResult<E> selectAllWithPagination(Integer recordsPerPage,
                                                       Integer currentPage) {
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
        TypedQuery<E> typedQuery = entityManager.createQuery(select);
        typedQuery.setFirstResult((currentPage - 1) * recordsPerPage);
        typedQuery.setMaxResults(recordsPerPage);
        PaginationResult<E> paginationResult = PaginationResult.<E>builder()
                .currentPage(currentPage).recordsPerPage(recordsPerPage)
                .pagesNum(countNumberOfPages(recordsPerPage, count))
                .records(typedQuery.getResultList()).build();
        entityManager.getTransaction().commit();
        entityManager.close();
        return paginationResult;
    }
}
