package co.com.edalac.plugin.userservice.service;

import java.util.List;

import co.com.edalac.plugin.userservice.model.dto.ContactPersonDTO;

public interface ContactPersonService extends GenericService<ContactPersonDTO, Long> {

	List<ContactPersonDTO> getAllByIdPerson(Long idPerson);
}
