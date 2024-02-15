package co.com.edalac.plugin.userservice.service;

import java.util.List;

import co.com.edalac.plugin.userservice.util.exception.UserException;

/**
 * 
 * @param <T> Clase DTO de entrada
 * @param <D> Tipo de dato númerico para el ID de la Clase Entity
 */
public interface GenericService<T, D> {

	void create(T dto) throws UserException;
	
	T findById(D id)  throws UserException;
	
	List<T> findAll()  throws UserException;
}
