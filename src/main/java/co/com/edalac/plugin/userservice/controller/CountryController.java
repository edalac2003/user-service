package co.com.edalac.plugin.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.edalac.plugin.userservice.model.dto.CountryDTO;
import co.com.edalac.plugin.userservice.model.dto.response.UserResponse;
import co.com.edalac.plugin.userservice.service.impl.CountryServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/country")
@RestController
@ApiResponse
public class CountryController {

	@Autowired
	private CountryServiceImpl countryServiceImpl;
	
	@PostMapping
	public void create(CountryDTO country) {
		countryServiceImpl.create(country);
	}
	
	@GetMapping("getById/{id}")
	public UserResponse<CountryDTO> getById(@PathVariable Long id) throws Exception{
		UserResponse<CountryDTO> response = new UserResponse<CountryDTO>();
		try {
			response.setData(countryServiceImpl.findById(id));
			return  response;
		}catch (Exception e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	@GetMapping("findAll")
	public UserResponse<List<CountryDTO>> findAll(){
		UserResponse<List<CountryDTO>> response = new UserResponse<List<CountryDTO>>();
		try {
			response.setData(countryServiceImpl.findAll());
			return  response;
		}catch (Exception e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage(e.getMessage());
			return response;
		}
	}
}
