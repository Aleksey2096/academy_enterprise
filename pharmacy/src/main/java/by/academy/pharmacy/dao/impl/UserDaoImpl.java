package by.academy.pharmacy.dao.impl;

import by.academy.pharmacy.dao.UserDAO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.DATE_JOINED;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER;
import static by.academy.pharmacy.entity.Constant.LOGIN;
import static by.academy.pharmacy.entity.Constant.PERCENTAGE_SYMBOL;
import static by.academy.pharmacy.entity.Constant.ROLE;

public class UserDaoImpl implements UserDAO {
    private final EntityManager entityManager
            = HibernateUtil.getEntityManager();

    @Override
    public Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public UserEntity selectByLogin(final String login) {
        entityManager.getTransaction().begin();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);
        cq.select(root).where(cb.equal(root.get("login"), login));
        List<UserEntity> userEntities = entityManager.createQuery(cq)
                .getResultList();
        UserEntity userEntity = null;
        if (userEntities.size() > 0) {
            userEntity = userEntities.get(0);
        }
        entityManager.getTransaction().commit();
        return userEntity;
    }

    @Override
    public Predicate createCommonPredicate(final Root<UserEntity> root,
                                           final String searchValue) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        Predicate predicateForHealthCareCardNumber = cb.like(
                root.get(HEALTH_CARE_CARD_NUMBER).as(String.class),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        Predicate predicateForLogin = cb.like(root.get(LOGIN),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
//		Predicate predicateForPassword = cb.like(userRoot.get(PASSWORD),
//				PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        Predicate predicateForRole = cb.like(root.get(ROLE).as(String.class),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        Predicate predicateForJoinedDate = cb.like(
                root.get(DATE_JOINED).as(String.class),
                PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
//		Predicate predicateForPersonalInfoEntity = cb.like(
//				userRoot.get(PERSONAL_INFO_ENTITY).as(String.class),
//				PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
//		Predicate predicateForAvatarImagePath = cb.like(userRoot.get(AVATAR_IMAGE_PATH),
//				PERCENTAGE_SYMBOL + searchValue + PERCENTAGE_SYMBOL);
        return cb.or(predicateForHealthCareCardNumber, predicateForLogin,
                predicateForRole,
                predicateForJoinedDate);
    }

    @Override
    public PaginationObject<UserEntity> selectAllWithParameters(
            final PaginationObject<UserEntity> pagination,
            final OrderObject orderObject,
            final String searchValue) {
        return selectAllWithParameters(pagination, orderObject,
                HEALTH_CARE_CARD_NUMBER,
                searchValue);
    }

    @Override
    public Set<MedicineProductEntity> selectCart(
            final Long healthCareCardnumber) {
        entityManager.getTransaction().begin();
        UserEntity userEntity = entityManager.find(UserEntity.class,
                healthCareCardnumber);
        Set<MedicineProductEntity> cart = userEntity.getCart();
        entityManager.getTransaction().commit();
        return cart;
    }
}
