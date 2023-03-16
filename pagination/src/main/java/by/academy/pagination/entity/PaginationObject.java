package by.academy.pagination.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class PaginationObject<E> {
    /**
     * page showed to user at current moment.
     */
    private Integer currentPage;
    /**
     * quantity of records displayed on single page.
     */
    private Integer recordsPerPage;
    /**
     * common quantity of pages.
     */
    private Integer pagesNum;
    /**
     * list of objects to be showed on single page.
     */
    private List<E> records;
    /**
     * field which needs to sort objects.
     */
    private String orderField;
    /**
     * descending or ascending type of ordering.
     */
    private OrderType orderType;
    /**
     * title of field.
     */
    private String searchField;
    /**
     * value of search field.
     */
    private String searchValue;
}
