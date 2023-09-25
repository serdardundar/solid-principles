package com.github.serdardundar.solidprinciples.ifsegreg.service.end;

import com.github.serdardundar.solidprinciples.ifsegreg.entity.Entity;

//common interface to be implemented by all persistence services.
public interface PersistenceService<T extends Entity> {

	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(Long id);
	
}
