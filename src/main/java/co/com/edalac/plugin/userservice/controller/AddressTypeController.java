package co.com.edalac.plugin.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.edalac.plugin.userservice.model.dto.AddressTypeDTO;
import co.com.edalac.plugin.userservice.model.dto.response.UserResponse;
import co.com.edalac.plugin.userservice.service.AddressTypeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/user/address-type")
@ApiResponse
public class AddressTypeController{

	@Autowired
	private AddressTypeService service;
	
	@GetMapping("findById/{id}")
	public UserResponse<AddressTypeDTO> findById(Integer id){
		UserResponse<AddressTypeDTO> response = new UserResponse<AddressTypeDTO>();
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
	public UserResponse<AddressTypeDTO> findAll(){
		UserResponse<AddressTypeDTO> response = new UserResponse<AddressTypeDTO>();
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
