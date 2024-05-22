package co.com.edalac.plugin.userservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.NotImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.ContactTypeDTO;
import co.com.edalac.plugin.userservice.model.entity.ContactTypeEntity;
import co.com.edalac.plugin.userservice.repository.ContactTypeRepository;
import co.com.edalac.plugin.userservice.service.ContactTypeService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class ContactTypeServiceImpl implements ContactTypeService {

	private ContactTypeRepository repository;
	
	public ContactTypeServiceImpl(ContactTypeRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void create(ContactTypeDTO dto) throws UserException {
		throw new NotImplementedException();
	}

	@Override
	public ContactTypeDTO findById(Integer id) throws UserException {
		Optional<ContactTypeEntity> entity = repository.findById(id);
		ModelMapper mapper = new ModelMapper();
		ContactTypeDTO dto =  mapper.map(entity, ContactTypeDTO.class);
		return dto;
	}

	@Override
	public List<ContactTypeDTO> findAll() throws UserException {
		List<ContactTypeEntity> contacts = repository.findAll();
		return contacts.stream()
			.map(c -> {
				ModelMapper mapper = new ModelMapper();
				return mapper.map(c, ContactTypeDTO.class);
			})
			.collect(Collectors.toList());
	}

}
