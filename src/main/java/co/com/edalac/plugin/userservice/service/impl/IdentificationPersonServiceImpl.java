package co.com.edalac.plugin.userservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.IdentificationPersonDTO;
import co.com.edalac.plugin.userservice.model.entity.IdentificationPersonEntity;
import co.com.edalac.plugin.userservice.repository.IdentificationPersonRepository;
import co.com.edalac.plugin.userservice.service.IdentificationPersonService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class IdentificationPersonServiceImpl implements IdentificationPersonService {

	@Autowired
	private IdentificationPersonRepository repository;
	
	@Override
	public void create(IdentificationPersonDTO dto) throws UserException {
		ModelMapper mapper = new ModelMapper();
		IdentificationPersonEntity entity = mapper.map(dto, IdentificationPersonEntity.class);
		repository.save(entity);
	}

	@Override
	public IdentificationPersonDTO findById(Long id) throws UserException {
		IdentificationPersonEntity entity = repository.findById(id).orElse(new IdentificationPersonEntity());
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, IdentificationPersonDTO.class);
	}

	@Override
	public List<IdentificationPersonDTO> findAll() throws UserException {
		List<IdentificationPersonEntity> entities = repository.findAll();
		
		return entities.stream().map(c -> {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(c, IdentificationPersonDTO.class);
		}).toList();
	}

}
