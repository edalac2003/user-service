package co.com.edalac.plugin.userservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.StateDTO;
import co.com.edalac.plugin.userservice.model.entity.StateEntity;
import co.com.edalac.plugin.userservice.repository.StateRepository;
import co.com.edalac.plugin.userservice.service.GenericService;
import co.com.edalac.plugin.userservice.service.StateService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class StateServiceImpl implements GenericService<StateDTO, Long>, StateService {

	@Autowired
	private StateRepository repository;

	@Override
	public void create(StateDTO dto) throws UserException {
		ModelMapper mapper = new ModelMapper();
		StateEntity entity = mapper.map(dto, StateEntity.class);
		repository.save(entity);
	}

	@Override
	public StateDTO findById(Long id) throws UserException {
		StateEntity entity = repository.findById(id).orElse(StateEntity.builder().build());
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, StateDTO.class);
	}

	@Override
	public List<StateDTO> findAll() throws UserException {
		List<StateEntity> states = repository.findAll();

		return states.stream().map(s -> {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(s, StateDTO.class);
		}).toList();
	}

}
