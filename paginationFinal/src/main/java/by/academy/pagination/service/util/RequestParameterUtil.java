package by.academy.pagination.service.util;

import by.academy.pagination.entity.OrderType;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static by.academy.pagination.entity.Constant.CURRENT_PAGE;
import static by.academy.pagination.entity.Constant.DEFAULT_PAGE_NUMBER;
import static by.academy.pagination.entity.Constant.DEFAULT_RECORDS_PER_PAGE;
import static by.academy.pagination.entity.Constant.ID;
import static by.academy.pagination.entity.Constant.ORDER_FIELD;
import static by.academy.pagination.entity.Constant.ORDER_TYPE;
import static by.academy.pagination.entity.Constant.RECORDS_PER_PAGE;
import static by.academy.pagination.entity.Constant.SEARCH_FIELD;
import static by.academy.pagination.entity.Constant.SEARCH_VALUE;

public final class RequestParameterUtil {

    /**
     * private default constructor.
     */
    private RequestParameterUtil() {
    }

    /**
     * @param name    parameter title.
     * @param request HttpServletRequest.
     * @return parsed integer value.
     */
    public static Integer getInteger(final String name,
                                     final HttpServletRequest request) {
        try {
            return Integer.parseInt(request.getParameter(name));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * @param request HttpServletRequest.
     * @return current page parameter from request.
     */
    public static Integer getCurrentPage(final HttpServletRequest request) {
        return Optional.ofNullable(request.getParameter(CURRENT_PAGE))
                .map(Integer::parseInt).orElse(DEFAULT_PAGE_NUMBER);
    }

    /**
     * @param request HttpServletRequest.
     * @return records per page parameter from request.
     */
    public static Integer getRecordsPerPage(final HttpServletRequest request) {
        return Optional.ofNullable(request.getParameter(RECORDS_PER_PAGE))
                .map(Integer::parseInt).orElse(DEFAULT_RECORDS_PER_PAGE);
    }

    /**
     * @param request HttpServletRequest.
     * @return descending or ascending type of ordering.
     */
    public static OrderType getOrderType(final HttpServletRequest request) {
        return Optional.ofNullable(request.getParameter(ORDER_TYPE))
                .map(x -> OrderType.valueOf(x.toUpperCase()))
                .orElse(OrderType.ASC);
    }

    /**
     * @param request HttpServletRequest.
     * @return field which needs to sort records.
     */
    public static String getPersonOrderField(final HttpServletRequest request) {
        return Optional.ofNullable(request.getParameter(ORDER_FIELD))
                .orElse(ID);
    }

    /**
     * @param request HttpServletRequest.
     * @return title of search field.
     */
    public static String getSearchField(final HttpServletRequest request) {
        String searchField = request.getParameter(SEARCH_FIELD);
        if (searchField != null && !searchField.isEmpty()) {
            return searchField;
        } else {
            return null;
        }
    }

    /**
     * @param request HttpServletRequest.
     * @return value of search field.
     */
    public static String getSearchValue(final HttpServletRequest request) {
        String searchValue = request.getParameter(SEARCH_VALUE);
        if (searchValue != null && !searchValue.isEmpty()) {
            return searchValue;
        } else {
            return null;
        }
    }
}
