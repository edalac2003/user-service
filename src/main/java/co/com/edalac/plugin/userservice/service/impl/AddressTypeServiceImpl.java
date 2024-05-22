package co.com.edalac.plugin.userservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.AddressTypeDTO;
import co.com.edalac.plugin.userservice.model.entity.AddressTypeEntity;
import co.com.edalac.plugin.userservice.repository.AddressTypeRepository;
import co.com.edalac.plugin.userservice.service.AddressTypeService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class AddressTypeServiceImpl implements AddressTypeService {

	@Autowired
	private AddressTypeRepository repository;
	
	@Override
	public void create(AddressTypeDTO dto) throws UserException {
		ModelMapper mapper = new ModelMapper();
		AddressTypeEntity entity = mapper.map(dto, AddressTypeEntity.class);
		repository.save(entity);
	}

	@Override
	public AddressTypeDTO findById(Integer id) throws UserException {
		AddressTypeEntity entity = repository.findById(id).orElse(new AddressTypeEntity());
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, AddressTypeDTO.class);
	}

	@Override
	public List<AddressTypeDTO> findAll() throws UserException {
		List<AddressTypeEntity> entities = repository.findAll();
		
		return entities.stream().map(c -> {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(c, AddressTypeDTO.class);
		}).toList();
	}

}
