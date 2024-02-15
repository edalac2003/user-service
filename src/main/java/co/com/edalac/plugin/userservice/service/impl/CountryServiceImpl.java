package co.com.edalac.plugin.userservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.edalac.plugin.userservice.model.dto.CountryDTO;
import co.com.edalac.plugin.userservice.model.entity.CountryEntity;
import co.com.edalac.plugin.userservice.repository.CountryRepository;
import co.com.edalac.plugin.userservice.service.GenericService;
import co.com.edalac.plugin.userservice.service.CountryService;
import co.com.edalac.plugin.userservice.util.exception.UserException;

@Service
public class CountryServiceImpl implements CountryService,  GenericService<CountryDTO, Long> {

	@Autowired
	private CountryRepository repository;
	
	@Override
	public void create(CountryDTO country) throws UserException {
		ModelMapper mapper = new ModelMapper();
		CountryEntity entity = mapper.map(country, CountryEntity.class);
		repository.save(entity);
	}

	@Override
	public CountryDTO findById(Long id) throws UserException {
		CountryEntity country = repository.findById(id).orElse(new CountryEntity());
		ModelMapper mapper = new ModelMapper();
		return mapper.map(country, CountryDTO.class);
	}

	@Override
	public List<CountryDTO> findAll() throws UserException {
		List<CountryEntity> countries = repository.findAll();
		
		return countries.stream().map(c -> {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(c, CountryDTO.class);
		}).toList();
	}

	
}
