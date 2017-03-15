package com.pesit.eVoting.sql.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * This class is base class for all the data access object classes
 * 
 * @author 
 *
 * @param <T>
 *            is class which extends the base class functionality
 */
public class BaseDao<T> {

	
	@PersistenceContext
	EntityManager entityManager;


	private Class<T> type;

	/**
	 * This constructor sets the child class type
	 */
	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	/**
	 * @return session needed for transaction
	 */
	public Session getCurrentSession() {
		return entityManager.unwrap(Session.class);
	}

	/**
	 * @return the type of child class
	 */
	public Class<T> getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            is type of child class
	 */
	public void setType(Class<T> type) {
		this.type = type;
	}

	/**
	 * 
	 * @param id
	 *            is primary key for object
	 * @return object(row of table) of which matched identity
	 */
	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		return (T) getCurrentSession().get(type, id);
	}

	/**
	 * 
	 * @return all the (rows of table) object (list)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Criteria criteria = getCurrentSession().createCriteria(type);
		return (List<T>) criteria.list();
	}

	/**
	 * 
	 * @param entity
	 *            is object of class for saving
	 */
	public void save(T entity) {
		getCurrentSession().save(entity);
	}

	/**
	 * 
	 * @param entity
	 *            is object of class to persist
	 */
	public void persist(T entity) {
		getCurrentSession().persist(entity);
	}

	/**
	 * 
	 * @param entity
	 *            is object of class for saving or updation
	 */
	public void saveOrUpdate(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	/**
	 * 
	 * @param entity
	 *            is object of class for saving or updation
	 */
	public void update(T entity) {
		getCurrentSession().update(entity);
	}

	/**
	 * 
	 * @param entity
	 *            is object of class to delete
	 */
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

}
