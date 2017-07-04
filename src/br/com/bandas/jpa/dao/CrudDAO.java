package br.com.bandas.jpa.dao;


public interface CrudDAO<T, ID> {
//	Object update = null;

	public T save(T entity);
	public void update(T entity);
	public T get(ID id);
	public void delete(T entity);


}
