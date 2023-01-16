package by.academy.task05daoAnnotation.service;

import java.io.Serializable;

import by.academy.task05daoAnnotation.dao.AbstractDao;
import by.academy.task05daoAnnotation.dao.DaoException;
import by.academy.task05daoAnnotation.dao.Transaction;
import by.academy.task05daoAnnotation.dao.impl.ObjectDao;

public final class DaoService {
	public Object create(final Object object) throws ServiceException {
		Transaction transaction = new Transaction();
		try {
			AbstractDao<Object> objectDao = new ObjectDao();
			transaction.init(objectDao);
			Object createdObject = objectDao.insert(object);
			transaction.commit();
			return createdObject;
		} catch (DaoException e1) {
			try {
				transaction.rollBack();
				throw new ServiceException(e1);
			} catch (DaoException e2) {
				throw new ServiceException(e2);
			}
		}
	}

	public Object read(final Class<?> cls, final Serializable id) throws ServiceException {
		Transaction transaction = new Transaction();
		try {
			AbstractDao<Object> objectDao = new ObjectDao();
			transaction.init(objectDao);
			Object object = objectDao.select(cls, id);
			transaction.commit();
			return object;
		} catch (DaoException e1) {
			try {
				transaction.rollBack();
				throw new ServiceException(e1);
			} catch (DaoException e2) {
				throw new ServiceException(e2);
			}
		}
	}

	public void update(final Object object) throws ServiceException {
		Transaction transaction = new Transaction();
		try {
			AbstractDao<Object> objectDao = new ObjectDao();
			transaction.init(objectDao);
			objectDao.update(object);
			transaction.commit();
		} catch (DaoException e1) {
			try {
				transaction.rollBack();
				throw new ServiceException(e1);
			} catch (DaoException e2) {
				throw new ServiceException(e2);
			}
		}
	}

	public int delete(final Class<?> cls, final Serializable id) throws ServiceException {
		Transaction transaction = new Transaction();
		try {
			AbstractDao<Object> objectDao = new ObjectDao();
			transaction.init(objectDao);
			int changedRowsNum = objectDao.delete(cls, id);
			transaction.commit();
			return changedRowsNum;
		} catch (DaoException e1) {
			try {
				transaction.rollBack();
				throw new ServiceException(e1);
			} catch (DaoException e2) {
				throw new ServiceException(e2);
			}
		}
	}
}
