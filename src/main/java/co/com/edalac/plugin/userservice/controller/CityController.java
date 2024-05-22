package co.com.edalac.plugin.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.edalac.plugin.userservice.model.dto.CityDTO;
import co.com.edalac.plugin.userservice.model.dto.response.UserResponse;
import co.com.edalac.plugin.userservice.service.impl.CityServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController(value = "/city")
@RequestMapping
@ApiResponse
public class CityController extends AbstractController {

	@Autowired
	private CityServiceImpl cityService;
	
	@PostMapping
	public void create(CityDTO cityDTO) {
		cityService.create(cityDTO);
	}
	
	@GetMapping("/findById")
	public UserResponse<CityDTO> findById(Long id) {
		UserResponse<CityDTO> response = new UserResponse<CityDTO>();
		try {
			response.setData(cityService.findById(id));
			return response;
		}catch (Exception e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	@GetMapping("/findAll")
	public UserResponse<CityDTO> findAll(){
		UserResponse<CityDTO> response = new UserResponse<CityDTO>();
		try {
			response.setList(cityService.findAll());
			return response;
		}catch (Exception e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage(e.getMessage());
			return response;
		}
	}
}
