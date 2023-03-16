package by.academy.pharmacy.dao.impl;

import by.academy.pharmacy.dao.ProducerDAO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.ProducerEntity;
import by.academy.pharmacy.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static by.academy.pharmacy.entity.Constant.COMPANY_NAME;
import static by.academy.pharmacy.entity.Constant.COUNTRY;
import static by.academy.pharmacy.entity.Constant.CREATION_DATE;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.PERCENTAGE_SYMBOL;

public class ProducerDaoImpl implements ProducerDAO {

    private final EntityManager entityManager
            = HibernateUtil.getEntityManager();

    @Override
    public Class<ProducerEntity> getEntityClass() {
        return ProducerEntity.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Predicate createCommonPredicate(final Root<ProducerEntity> root,
                                           final String searchValue) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        Predicate predicateForId = cb.like(root.get(ID).as(String.class),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        Predicate predicateForCompanyName = cb.like(root.get(COMPANY_NAME),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        Predicate predicateForCountry = cb.like(
                root.get(COUNTRY).as(String.class),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        Predicate predicateForCreationDate = cb.like(
                root.get(CREATION_DATE).as(String.class),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        return cb.or(predicateForId, predicateForCompanyName,
                predicateForCountry,
                predicateForCreationDate);
    }

    @Override
    public PaginationObject<ProducerEntity> selectAllWithParameters(
            final PaginationObject<ProducerEntity> pagination,
            final OrderObject orderObject,
            final String searchValue) {
        return selectAllWithParameters(pagination, orderObject, ID,
                searchValue);
    }
}
