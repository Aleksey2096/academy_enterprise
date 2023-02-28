package by.academy.pagination.entity;

public final class Constant {
    /**
     * table title.
     */
    public static final String PERSON = "person";
    /**
     * jsp page attribute.
     */
    public static final String PEOPLE = "people";
    /**
     * database property.
     */
    public static final String ID = "id";
    /**
     * database property.
     */
    public static final String NAME = "name";
    /**
     * database property.
     */
    public static final String SURNAME = "surname";
    /**
     * gets all objects of concrete hibernate entity.
     */
    public static final String FROM_HIBERNATE_CLASS = "FROM %s";
    /**
     * SuppressWarnings type.
     */
    public static final String UNCHECKED = "unchecked";
    /**
     * encoding variable title.
     */
    public static final String ENCODING = "encoding";
    /**
     * page with form for creating new person.
     */
    public static final String JSP_PEOPLE_NEW_JSP = "/jsp/people/new.jsp";
    /**
     * page with collection of all people.
     */
    public static final String JSP_PEOPLE_INDEX_JSP = "/jsp/people/index.jsp";
    /**
     * page with form for updating person.
     */
    public static final String JSP_PEOPLE_EDIT_JSP = "/jsp/people/edit.jsp";
    /**
     * request parameter name.
     */
    public static final String COMMAND = "command";
    /**
     * name of mysql driver.
     */
    public static final String COM_MYSQL_CJ_JDBC_DRIVER
            = "com.mysql.cj.jdbc.Driver";
    /**
     * name of persistence unit, depending on profile.
     */
    public static final String PERSISTENCE_UNIT_NAME = "persistenceUnitName";
    /**
     * properties, containing name of persistence unit.
     */
    public static final String PERSISTENCE_UNIT_PROPERTIES
            = "persistenceUnit.properties";
    /**
     * request parameter title.
     */
    public static final String CURRENT_PAGE = "currentPage";
    /**
     * request parameter title.
     */
    public static final String RECORDS_PER_PAGE = "recordsPerPage";
    /**
     * initial number of page.
     */
    public static final Integer DEFAULT_PAGE_NUMBER = 1;
    /**
     * initial number of records displayed on single page.
     */
    public static final Integer DEFAULT_RECORDS_PER_PAGE = 5;
    /**
     * previous request link, which allows to return to the same paginated page.
     */
    public static final String PREVIOUS_REQUEST_LINK = "previousRequestLink";
    /**
     * request parameter title.
     */
    public static final String ORDER_TYPE = "orderType";
    /**
     * request parameter title.
     */
    public static final String ORDER_FIELD = "orderField";
    /**
     * sql special symbol.
     */
    public static final String PERCENTAGE_SYMBOL = "%";
    /**
     * request parameter title.
     */
    public static final String SEARCH_FIELD = "searchField";
    /**
     * request parameter title.
     */
    public static final String SEARCH_VALUE = "searchValue";

    private Constant() {
    }
}
