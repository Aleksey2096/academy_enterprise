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
public final class PaginationResult<E> {
    private Integer currentPage;
    private Integer recordsPerPage;
    private Integer pagesNum;
    private List<E> records;
}
