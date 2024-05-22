package co.com.edalac.plugin.userservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.IdentificationTypeDTO;
import co.com.edalac.plugin.userservice.model.entity.IdentificationTypeEntity;
import co.com.edalac.plugin.userservice.repository.IdentificationTypeRepository;
import co.com.edalac.plugin.userservice.service.IdentificationTypeService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class IdentificationTypeServiceImpl implements IdentificationTypeService {

	@Autowired
	private IdentificationTypeRepository repository;
	
	@Override
	public void create(IdentificationTypeDTO dto) throws UserException {
		ModelMapper mapper = new ModelMapper();
		IdentificationTypeEntity entity = mapper.map(dto, IdentificationTypeEntity.class);
		repository.save(entity);
	}

	@Override
	public IdentificationTypeDTO findById(Integer id) throws UserException {
		IdentificationTypeEntity entity = repository.findById(id).orElse(new IdentificationTypeEntity());
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, IdentificationTypeDTO.class);
	}

	@Override
	public List<IdentificationTypeDTO> findAll() throws UserException {
		List<IdentificationTypeEntity> entities = repository.findAll();
		
		return entities.stream().map(c -> {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(c, IdentificationTypeDTO.class);
		}).toList();
	}

}
