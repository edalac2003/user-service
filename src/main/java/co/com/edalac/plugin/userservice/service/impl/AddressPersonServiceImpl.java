package co.com.edalac.plugin.userservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.AddressPersonDTO;
import co.com.edalac.plugin.userservice.model.entity.AddressPersonEntity;
import co.com.edalac.plugin.userservice.repository.AddressPersonRepository;
import co.com.edalac.plugin.userservice.service.AddressPersonService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class AddressPersonServiceImpl implements AddressPersonService {

	@Autowired
	private AddressPersonRepository repository;
	
	@Override
	public void create(AddressPersonDTO dto) throws UserException {
		ModelMapper mapper = new ModelMapper();
		AddressPersonEntity entity = mapper.map(dto, AddressPersonEntity.class);
		repository.save(entity);
		
	}

	@Override
	public AddressPersonDTO findById(Long id) throws UserException {
		AddressPersonEntity entity = repository.findById(id).orElse(new AddressPersonEntity());
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, AddressPersonDTO.class);
	}

	@Override
	public List<AddressPersonDTO> findAll() throws UserException {
		List<AddressPersonEntity> entities = repository.findAll();
		
		return entities.stream().map(c -> {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(c, AddressPersonDTO.class);
		}).toList();
	}

	
}
