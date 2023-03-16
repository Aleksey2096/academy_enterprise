package by.academy.pharmacy.entity;

import java.util.List;
import java.util.Objects;

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

    public PaginationObject() {
    }

    public PaginationObject(final Integer currentPage,
                            final Integer recordsPerPage,
                            final Integer pagesNum, final List<E> records) {
        this.currentPage = currentPage;
        this.recordsPerPage = recordsPerPage;
        this.pagesNum = pagesNum;
        this.records = records;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(final Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(final Integer recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public Integer getPagesNum() {
        return pagesNum;
    }

    public void setPagesNum(final Integer pagesNum) {
        this.pagesNum = pagesNum;
    }

    public List<E> getRecords() {
        return records;
    }

    public void setRecords(final List<E> records) {
        this.records = records;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPage, pagesNum, records, recordsPerPage);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PaginationObject<?> other = (PaginationObject<?>) obj;
        return Objects.equals(currentPage, other.currentPage)
                && Objects.equals(pagesNum, other.pagesNum)
                && Objects.equals(records, other.records)
                && Objects.equals(recordsPerPage, other.recordsPerPage);
    }

    @Override
    public String toString() {
        return "PaginationObject [currentPage=" + currentPage
                + ", recordsPerPage=" + recordsPerPage
                + ", pagesNum=" + pagesNum + ", records=" + records + "]";
    }
}
