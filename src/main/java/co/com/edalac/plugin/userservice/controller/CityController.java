package co.com.edalac.plugin.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.edalac.plugin.userservice.model.dto.CityDTO;
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
	public CityDTO findById(Long id) {
		return cityService.findById(id);
	}
	
	@GetMapping("/findAll")
	public List<CityDTO> findAll(){
		return cityService.findAll();
	}
}
