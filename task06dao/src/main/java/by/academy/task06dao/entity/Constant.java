package by.academy.task06dao.entity;

public final class Constant {
    /**
     * message for deleted person object.
     */
    public static final String DELETE_MESSAGE_2 = "Deleted person = ";
    /**
     * message for number of changed rows after deleting person object.
     */
    public static final String DELETE_MESSAGE_1
            = "Deleted person (changed rows) = ";
    /**
     * message for updated person object.
     */
    public static final String UPDATE_MESSAGE = "Updated person = ";
    /**
     * contains test value of surname updated.
     */
    public static final String TEST_SURNAME_UPDATED = "TestSurnameUpdated";
    /**
     * contains test value of name updated.
     */
    public static final String TEST_NAME_UPDATED = "TestNameUpdated";
    /**
     * message for selected person object.
     */
    public static final String SELECT_MESSAGE = "Selected person = ";
    /**
     * message for inserted person object.
     */
    public static final String INSERT_MESSAGE = "Inserted person = ";
    /**
     * contains test value of surname.
     */
    public static final String TEST_SURNAME = "TestSurname";
    /**
     * contains test value of name.
     */
    public static final String TEST_NAME = "TestName";
    /**
     * contains test value of name to find in person table.
     */
    public static final String TEST_FIND_NAME = "Kelly";
    /**
     * contains test value of surname to find in person table.
     */
    public static final String TEST_FIND_SURNAME = "Webb";
    /**
     * exception message for null object.
     */
    public static final String NULL_EXCEPTION_MESSAGE = "Object is null!";
    /**
     * exception message for object without MyTable annotation.
     */
    public static final String CLASS_ANNOTATION_EXCEPTION_MESSAGE
            = "Object class has no annotation \"MyTable\"!";
    /**
     * exception message for object without MyColumn annotation.
     */
    public static final String FIELD_ANNOTATION_EXCEPTION_MESSAGE
            = "Object has no field annotated as \"MyColumn\"!";
    /**
     * value to find name of id column in database table.
     */
    public static final String COLUMN_NAME = "COLUMN_NAME";
    /**
     * comma sign.
     */
    public static final String COMMA = ",";
    /**
     * question mark sign.
     */
    public static final String QUESTION_MARK = "?";
    /**
     * equals sign.
     */
    public static final String EQUALS_MARK = "=";
    /**
     * name of person table.
     */
    public static final String PERSON_TABLE_TITLE = "person";
    /**
     * title of id column.
     */
    public static final String ID_COLUMN_TITLE = "id";
    /**
     * title of name column.
     */
    public static final String NAME_COLUMN_TITLE = "name";
    /**
     * title of surname column.
     */
    public static final String SURNAME_COLUMN_TITLE = "surname";

    private Constant() {
    }
}
