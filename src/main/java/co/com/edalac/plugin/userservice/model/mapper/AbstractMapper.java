package co.com.edalac.plugin.userservice.model.mapper;

public interface AbstractMapper<T, R> {

	T mapperDtoToEntity(R dto);
	
	R mapperEntityToDTO(T entity);
}
