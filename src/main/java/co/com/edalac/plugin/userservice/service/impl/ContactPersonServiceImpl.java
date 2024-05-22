package co.com.edalac.plugin.userservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.ContactPersonDTO;
import co.com.edalac.plugin.userservice.model.entity.ContactPersonEntity;
import co.com.edalac.plugin.userservice.repository.ContactPersonRepository;
import co.com.edalac.plugin.userservice.service.ContactPersonService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class ContactPersonServiceImpl implements ContactPersonService {

	@Autowired
	private ContactPersonRepository repository;
	
	@Override
	public void create(ContactPersonDTO dto) throws UserException {
		ModelMapper mapper = new ModelMapper();
		ContactPersonEntity entity = mapper.map(dto, ContactPersonEntity.class);
		repository.save(entity);
	}

	@Override
	public ContactPersonDTO findById(Long id) throws UserException {
		ContactPersonEntity entity = repository.findById(id).orElse(new ContactPersonEntity());
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, ContactPersonDTO.class);
	}

	@Override
	public List<ContactPersonDTO> findAll() throws UserException {
		List<ContactPersonEntity> entities = repository.findAll();
		
		return entities.stream().map(c -> {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(c, ContactPersonDTO.class);
		}).toList();
	}


}
