package by.academy.pharmacy.dao.impl;

import by.academy.pharmacy.dao.MedicineDAO;
import by.academy.pharmacy.entity.MedicineEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static by.academy.pharmacy.entity.Constant.APPROVAL_DATE;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.IS_NONPRESCRIPTION;
import static by.academy.pharmacy.entity.Constant.PERCENTAGE_SYMBOL;
import static by.academy.pharmacy.entity.Constant.TITLE;

public class MedicineDaoImpl implements MedicineDAO {
	private final EntityManager entityManager
			= HibernateUtil.getEntityManager();

	@Override
	public Class<MedicineEntity> getEntityClass() {
		return MedicineEntity.class;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Predicate createCommonPredicate(final Root<MedicineEntity> root,
										   final String searchValue) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate predicateForId = cb.like(root.get(ID).as(String.class),
				PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
		Predicate predicateForTitle = cb.like(root.get(TITLE),
				PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
		Predicate predicateForIsNonprescription = cb.like(
				root.get(IS_NONPRESCRIPTION).as(String.class),
				PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
		Predicate predicateForApprovalDate = cb.like(
				root.get(APPROVAL_DATE).as(String.class),
				PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
		return cb.or(predicateForId, predicateForTitle,
				predicateForIsNonprescription,
				predicateForApprovalDate);
	}

	@Override
	public PaginationObject<MedicineEntity> selectAllWithParameters(
			final PaginationObject<MedicineEntity> pagination,
			final OrderObject orderObject,
			final String searchValue) {
		return selectAllWithParameters(pagination, orderObject, ID,
				searchValue);
	}
}
