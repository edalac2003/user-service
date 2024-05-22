package co.com.edalac.plugin.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.edalac.plugin.userservice.model.dto.IdentificationTypeDTO;
import co.com.edalac.plugin.userservice.model.dto.response.UserResponse;
import co.com.edalac.plugin.userservice.service.IdentificationTypeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/user/identification-type")
@ApiResponse
public class IdentificationTypeController {

	@Autowired
	private IdentificationTypeService service;
	
	@GetMapping("findById/{id}")
	public UserResponse<IdentificationTypeDTO> findById(Integer id){
		UserResponse<IdentificationTypeDTO> response = new UserResponse<IdentificationTypeDTO>();
		try {
			response.setData(service.findById(id));
			return response;
		}catch (Exception e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	@GetMapping("findAll")
	public UserResponse<IdentificationTypeDTO> findAll(){
		UserResponse<IdentificationTypeDTO> response = new UserResponse<IdentificationTypeDTO>();
		try {
			response.setList(service.findAll());
			return response;
		}catch (Exception e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage(e.getMessage());
			return response;
		}
	}
}
