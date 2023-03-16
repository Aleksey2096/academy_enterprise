package by.academy.pharmacy.dao.impl;

import by.academy.pharmacy.dao.PrescriptionDAO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.OrderType;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static by.academy.pharmacy.entity.Constant.AMOUNT;
import static by.academy.pharmacy.entity.Constant.DATE;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.PERCENTAGE_SYMBOL;
import static by.academy.pharmacy.entity.Constant.USER_ENTITY;

public class PrescriptionDaoImpl implements PrescriptionDAO {
    private final EntityManager entityManager
            = HibernateUtil.getEntityManager();

    @Override
    public Class<PrescriptionEntity> getEntityClass() {
        return PrescriptionEntity.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Predicate createCommonPredicate(final Root<PrescriptionEntity> root,
                                           final String searchValue) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        Predicate predicateForId = cb.like(root.get(ID).as(String.class),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        Predicate predicateForAmount = cb.like(
                root.get(AMOUNT).as(String.class),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        Predicate predicateForDate = cb.like(root.get(DATE).as(String.class),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        return cb.or(predicateForId, predicateForAmount, predicateForDate);
    }

    @Override
    public PaginationObject<PrescriptionEntity> selectAllWithParametersByUser(
            final PaginationObject<PrescriptionEntity> pagination,
            final OrderObject orderObject,
            final String searchValue, final UserEntity userEntity) {
        entityManager.getTransaction().begin();
        entityManager.clear();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PrescriptionEntity> cq = cb.createQuery(
                PrescriptionEntity.class);
        Root<PrescriptionEntity> root = cq.from(PrescriptionEntity.class);
        Predicate mainPredicate;
        Predicate userPredicate = cb.equal(root.get(USER_ENTITY), userEntity);
        if (searchValue != null && !searchValue.isBlank()) {
            mainPredicate = cb.and(createCommonPredicate(root, searchValue),
                    userPredicate);
        } else {
            mainPredicate = userPredicate;
        }
        cq.select(root).where(mainPredicate);
        if (orderObject.getOrderField() == null) {
            orderObject.setOrderField(ID);
        }
        if (OrderType.ASC.equals(orderObject.getOrderType())) {
            cq.orderBy(cb.asc(root.get(orderObject.getOrderField())));
        } else {
            cq.orderBy(cb.desc(root.get(orderObject.getOrderField())));
        }
        TypedQuery<PrescriptionEntity> typedQuery = entityManager.createQuery(
                cq);
        typedQuery
                .setFirstResult((pagination.getCurrentPage() - 1)
                        * pagination.getRecordsPerPage());
        typedQuery.setMaxResults(pagination.getRecordsPerPage());
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(countQuery.from(PrescriptionEntity.class)));
        countQuery.where(mainPredicate);
        pagination.setPagesNum(
                countNumberOfPages(pagination.getRecordsPerPage(),
                        entityManager.createQuery(countQuery)
                                .getSingleResult()));
        pagination.setRecords(typedQuery.getResultList());
        entityManager.getTransaction().commit();
        return pagination;
    }
}
