package co.com.edalac.plugin.userservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.CityDTO;
import co.com.edalac.plugin.userservice.model.entity.CityEntity;
import co.com.edalac.plugin.userservice.repository.CityRepository;
import co.com.edalac.plugin.userservice.service.GenericService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class CityServiceImpl implements GenericService<CityDTO, Long> {

	@Autowired
	private CityRepository repository;
	
	@Override
	public void create(CityDTO dto) throws UserException {
		ModelMapper mapper = new ModelMapper();
		CityEntity entity = mapper.map(dto, CityEntity.class);
		repository.save(entity);
		
	}

	@Override
	public CityDTO findById(Long id) throws UserException {
		CityEntity entity = repository.findById(id).orElse(new CityEntity());
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, CityDTO.class);
	}

	@Override
	public List<CityDTO> findAll() throws UserException {
		List<CityEntity> states = repository.findAll();

		return states.stream().map(s -> {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(s, CityDTO.class);
		}).toList();
	}

}
