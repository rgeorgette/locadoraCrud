package br.com.rodrigo.locadora.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.rodrigo.locadora.util.JPAUtil;

public abstract class GenericDao<T, I> {

	private Class<T> persistedClass;

	protected GenericDao() {
	}

	protected GenericDao(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	public void merge(T t) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void delete(T t) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(t));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		List<T> lista = entityManager.createQuery("from " + persistedClass.getSimpleName()).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return lista;
	}

	public T findById(I id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		T t = entityManager.find(persistedClass, id);
		entityManager.close();
		return t;
	}

}
