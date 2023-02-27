package by.academy.pagination;

import by.academy.pagination.entity.PaginationObject;
import by.academy.pagination.entity.Person;
import by.academy.pagination.service.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Test {
    public static void main(String[] args) {
        int currentPage=1;
        int recordsPerPage=200;


        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(
                Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(Person.class)));
        Long count = entityManager.createQuery(countQuery).getSingleResult();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> from = criteriaQuery.from(Person.class);



        CriteriaQuery<Person> select = criteriaQuery.select(from).where(criteriaBuilder.like(from.get("id").as(String.class),"%11%"));





        criteriaQuery.orderBy(criteriaBuilder.asc(from.get("name")));

        TypedQuery<Person> typedQuery = entityManager.createQuery(select);
        typedQuery.setFirstResult((currentPage - 1) * recordsPerPage);
        typedQuery.setMaxResults(recordsPerPage);
        PaginationObject<Person> paginationResult = PaginationObject.<Person>builder()
                .currentPage(currentPage).recordsPerPage(recordsPerPage)
                .pagesNum(countNumberOfPages(recordsPerPage, count))
                .records(typedQuery.getResultList()).build();
        entityManager.getTransaction().commit();
        entityManager.close();




        paginationResult.getRecords().forEach(System.out::println);





        HibernateUtil.close();
    }


   private static Integer countNumberOfPages(Integer recordsPerPage, Long rowsNum) {
        if (rowsNum % recordsPerPage == 0) {
            return (int) (rowsNum / recordsPerPage);
        } else {
            return (int) (rowsNum / recordsPerPage) + 1;
        }
    }
}
