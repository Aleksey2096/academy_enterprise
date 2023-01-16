package by.academy.task05daoAnnotation.dao.impl;

import static by.academy.task05daoAnnotation.entity.Constant.CLASS_ANNOTATION_EXCEPTION_MESSAGE;
import static by.academy.task05daoAnnotation.entity.Constant.COLUMN_NAME;
import static by.academy.task05daoAnnotation.entity.Constant.COMMA;
import static by.academy.task05daoAnnotation.entity.Constant.EQUALS_MARK;
import static by.academy.task05daoAnnotation.entity.Constant.FIELD_ANNOTATION_EXCEPTION_MESSAGE;
import static by.academy.task05daoAnnotation.entity.Constant.NULL_EXCEPTION_MESSAGE;
import static by.academy.task05daoAnnotation.entity.Constant.QUESTION_MARK;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.academy.task05daoAnnotation.dao.AbstractDao;
import by.academy.task05daoAnnotation.dao.DaoException;
import by.academy.task05daoAnnotation.dao.DatabaseQuery;
import by.academy.task05daoAnnotation.entity.MyColumn;
import by.academy.task05daoAnnotation.entity.MyTable;

public final class ObjectDao extends AbstractDao<Object> {

	@Override
	public Object insert(final Object object) throws DaoException {
		PreparedStatement statement = null;
		try {
			checkIfNull(object);
			Class<?> cls = object.getClass();
			checkIfAnnotated(cls);
			String tableName = cls.getAnnotation(MyTable.class).name();
			Connection connection = getConnection();
			String idColumnName = getPrimaryKeyColumnName(connection, tableName);
			List<Field> annotatedFields = getAnnotatedFields(cls.getDeclaredFields());
			Field idField = getIdField(cls.getDeclaredFields(), idColumnName);
			annotatedFields.remove(idField);
			List<Object> fieldValues = getFieldValues(annotatedFields, object);
			statement = connection.prepareStatement(
					String.format(DatabaseQuery.INSERT, tableName,
							getColumnNamesString(annotatedFields),
							getQuestionMarksString(annotatedFields.size())),
					Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < annotatedFields.size(); ++i) {
				statement.setObject(i + 1, fieldValues.get(i));
			}
			statement.executeUpdate();
			setIdField(statement, idField, object);
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			throw new DaoException(e);
		} finally {
			close(statement);
		}
		return object;
	}

	@Override
	public Object select(final Class<?> cls, final Serializable id) throws DaoException {
		PreparedStatement statement = null;
		try {
			checkIfAnnotated(cls);
			String tableName = cls.getAnnotation(MyTable.class).name();
			Connection connection = getConnection();
			String idColumnName = getPrimaryKeyColumnName(connection, tableName);
			List<Field> annotatedFields = getAnnotatedFields(cls.getDeclaredFields());
			statement = connection.prepareStatement(String.format(DatabaseQuery.SELECT,
					getColumnNamesString(annotatedFields), tableName, idColumnName));
			statement.setObject(1, id);
			ResultSet resultSet = statement.executeQuery();
			Object object = null;
			while (resultSet.next()) {
				object = cls.getDeclaredConstructor().newInstance();
				for (int i = 0; i < annotatedFields.size(); ++i) {
					annotatedFields.get(i).set(object, resultSet.getObject(i + 1));
				}
			}
			return object;
		} catch (SQLException | IllegalArgumentException | InstantiationException
				| IllegalAccessException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new DaoException(e);
		} finally {
			close(statement);
		}
	}

	@Override
	public void update(final Object object) throws DaoException {
		PreparedStatement statement = null;
		try {
			checkIfNull(object);
			Class<?> cls = object.getClass();
			checkIfAnnotated(cls);
			String tableName = cls.getAnnotation(MyTable.class).name();
			Connection connection = getConnection();
			String idColumnName = getPrimaryKeyColumnName(connection, tableName);
			List<Field> annotatedFields = getAnnotatedFields(cls.getDeclaredFields());
			Field idField = getIdField(cls.getDeclaredFields(), idColumnName);
			annotatedFields.remove(idField);
			List<Object> fieldValues = getFieldValues(annotatedFields, object);
			statement = connection.prepareStatement(String.format(DatabaseQuery.UPDATE, tableName,
					getSetExpressionsString(annotatedFields), idColumnName));
			for (int i = 0; i < annotatedFields.size(); ++i) {
				statement.setObject(i + 1, fieldValues.get(i));
			}
			statement.setObject(annotatedFields.size() + 1, idField.get(object));
			statement.executeUpdate();
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			throw new DaoException(e);
		} finally {
			close(statement);
		}
	}

	@Override
	public int delete(final Class<?> cls, final Serializable id) throws DaoException {
		PreparedStatement statement = null;
		try {
			checkIfAnnotated(cls);
			String tableName = cls.getAnnotation(MyTable.class).name();
			Connection connection = getConnection();
			String idColumnName = getPrimaryKeyColumnName(connection, tableName);
			statement = connection
					.prepareStatement(String.format(DatabaseQuery.DELETE, tableName, idColumnName));
			statement.setObject(1, id);
			return statement.executeUpdate();
		} catch (SQLException | IllegalArgumentException | SecurityException e) {
			throw new DaoException(e);
		} finally {
			close(statement);
		}
	}

	private void checkIfNull(final Object object) throws DaoException {
		if (object == null) {
			throw new DaoException(NULL_EXCEPTION_MESSAGE);
		}
	}

	private void checkIfAnnotated(final Class<?> cls) throws DaoException {
		if (!cls.isAnnotationPresent(MyTable.class)) {
			throw new DaoException(CLASS_ANNOTATION_EXCEPTION_MESSAGE);
		}
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; ++i) {
			if (fields[i].isAnnotationPresent(MyColumn.class)) {
				return;
			}
		}
		throw new DaoException(FIELD_ANNOTATION_EXCEPTION_MESSAGE);
	}

	private String getPrimaryKeyColumnName(final Connection connection, final String tableName)
			throws SQLException {
		DatabaseMetaData metaData = connection.getMetaData();
		ResultSet resultSet = metaData.getPrimaryKeys(null, null, tableName);
		String idColumnName = null;
		while (resultSet.next()) {
			idColumnName = resultSet.getString(COLUMN_NAME);
		}
		return idColumnName;
	}

	private List<Field> getAnnotatedFields(final Field[] fields) {
		List<Field> annotatedFields = new ArrayList<>();
		for (int i = 0; i < fields.length; ++i) {
			if (fields[i].isAnnotationPresent(MyColumn.class)) {
				fields[i].setAccessible(true);
				annotatedFields.add(fields[i]);
			}
		}
		return annotatedFields;
	}

	private Field getIdField(final Field[] fields, final String idColumnName) {
		Field idField = null;
		for (int i = 0; i < fields.length; ++i) {
			if (fields[i].isAnnotationPresent(MyColumn.class)
					&& fields[i].getAnnotation(MyColumn.class).name().equals(idColumnName)) {
				fields[i].setAccessible(true);
				idField = fields[i];
			}
		}
		return idField;
	}

	private List<Object> getFieldValues(final Collection<Field> fields,
			final Object daoEntityObject) throws IllegalArgumentException, IllegalAccessException {
		List<Object> fieldValues = new ArrayList<>();
		for (Field field : fields) {
			fieldValues.add(field.get(daoEntityObject));
		}
		return fieldValues;
	}

	private String getColumnNamesString(final Collection<Field> fields) {
		StringBuilder columnNames = new StringBuilder();
		fields.forEach(field -> columnNames.append(field.getAnnotation(MyColumn.class).name())
				.append(COMMA));
		columnNames.deleteCharAt(columnNames.length() - 1);
		return columnNames.toString();
	}

	private String getQuestionMarksString(final int quantity) {
		StringBuilder questionMarks = new StringBuilder();
		for (int i = 0; i < quantity; ++i) {
			questionMarks.append(QUESTION_MARK).append(COMMA);
		}
		questionMarks.deleteCharAt(questionMarks.length() - 1);
		return questionMarks.toString();
	}

	private String getSetExpressionsString(final Collection<Field> fields) {
		StringBuilder setExpressions = new StringBuilder();
		fields.forEach(field -> setExpressions.append(field.getAnnotation(MyColumn.class).name())
				.append(EQUALS_MARK).append(QUESTION_MARK).append(COMMA));
		setExpressions.deleteCharAt(setExpressions.length() - 1);
		return setExpressions.toString();
	}

	private void setIdField(final Statement statement, final Field idField,
			final Object daoEntityObject)
			throws IllegalArgumentException, IllegalAccessException, SQLException {
		ResultSet keys = statement.getGeneratedKeys();
		Serializable idColumnValue = null;
		while (keys.next()) {
			idColumnValue = (Serializable) keys.getObject(1, idField.getType());
		}
		idField.set(daoEntityObject, idColumnValue);
	}
}
