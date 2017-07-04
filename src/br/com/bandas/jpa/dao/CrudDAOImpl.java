package br.com.bandas.jpa.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CrudDAOImpl<T, ID> implements CrudDAO<T, ID> {

	private EntityManager entityManager;

	public CrudDAOImpl() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mainPU");
		entityManager = factory.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getGenericType() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<T>) type.getActualTypeArguments()[0];
	}//????

	@Override
	public T save(T entity) {
		entityManager.getTransaction().begin();
		if (!entityManager.contains(entity)) {
			entity = entityManager.merge(entity);
		}
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		return entity;
	}

	@Override
	public T get(ID id) {
		return entityManager.find(this.getGenericType(), id);
	}

	
	@Override
	public void update(T entity) {
		entityManager.getTransaction().begin();
//		entityManager.refresh(entityManager.merge(entity));
		entityManager.merge(entity);//apagar
		entityManager.getTransaction().commit();
		entityManager.close();//apagar
	}

	@Override
	public void delete(T entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(entity));
		entityManager.getTransaction().commit();
	}

	

}
