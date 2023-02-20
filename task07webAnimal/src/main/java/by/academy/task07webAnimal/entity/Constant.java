package by.academy.task07webAnimal.entity;

public final class Constant {
    /**
     * table title.
     */
    public static final String ANIMAL = "animal";
    /**
     * jsp page attribute.
     */
    public static final String ANIMALS = "animals";
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
    public static final String WEIGHT = "weight";
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
     * page with form for creating new animal.
     */
    public static final String JSP_ANIMALS_NEW_JSP = "/jsp/animals/new.jsp";
    /**
     * default page of web application.
     */
    public static final String INDEX_JSP = "/index.jsp";
    /**
     * page with collection of all animals.
     */
    public static final String JSP_ANIMALS_INDEX_JSP = "/jsp/animals/index.jsp";
    /**
     * page with form for updating animal.
     */
    public static final String JSP_ANIMALS_EDIT_JSP = "/jsp/animals/edit.jsp";
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

    private Constant() {
    }
}
