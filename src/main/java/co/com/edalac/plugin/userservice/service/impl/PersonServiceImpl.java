package co.com.edalac.plugin.userservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.PersonDTO;
import co.com.edalac.plugin.userservice.model.entity.CityEntity;
import co.com.edalac.plugin.userservice.model.entity.ContactPersonEntity;
import co.com.edalac.plugin.userservice.model.entity.PersonEntity;
import co.com.edalac.plugin.userservice.repository.CityRepository;
import co.com.edalac.plugin.userservice.repository.ContactPersonRepository;
import co.com.edalac.plugin.userservice.repository.PersonRepository;
import co.com.edalac.plugin.userservice.service.PersonService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ContactPersonRepository contactPersonRepository;
	
	@Override
	public void create(PersonDTO dto) throws UserException {
		ModelMapper mapper = new ModelMapper();
		PersonEntity entity = mapper.map(dto, PersonEntity.class);
		repository.save(entity);
	}

	@Override
	public PersonDTO findById(Long id) throws UserException {
		PersonEntity personEntity = repository.findById(id).orElse(new PersonEntity());
		CityEntity cityEntity = cityRepository.findById(personEntity.getCityId()).orElse(new CityEntity());
		List<ContactPersonEntity> contacts = new ArrayList<ContactPersonEntity>();
//		List<ContactPersonEntity> contacts = contactPersonRepository.findByPersonId(personEntity.getId());
		
		personEntity.setCity(cityEntity);
		personEntity.setContacts(contacts);
		
		ModelMapper mapper = new ModelMapper();
		return mapper.map(personEntity, PersonDTO.class);
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
