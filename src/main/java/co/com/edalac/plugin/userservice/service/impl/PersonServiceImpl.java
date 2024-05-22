package co.com.edalac.plugin.userservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.PersonDTO;
import co.com.edalac.plugin.userservice.model.entity.PersonEntity;
import co.com.edalac.plugin.userservice.repository.PersonRepository;
import co.com.edalac.plugin.userservice.service.PersonService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Override
	public void create(PersonDTO dto) throws UserException {
		ModelMapper mapper = new ModelMapper();
		PersonEntity entity = mapper.map(dto, PersonEntity.class);
		repository.save(entity);
	}

	@Override
	public PersonDTO findById(Long id) throws UserException {
		PersonEntity entity = repository.findById(id).orElse(new PersonEntity());
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, PersonDTO.class);
	}

	@Override
	public List<PersonDTO> findAll() throws UserException {
		List<PersonEntity> entities = repository.findAll();
		
		return entities.stream().map(c -> {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(c, PersonDTO.class);
		}).toList();
	}

}
