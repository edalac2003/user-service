package co.com.edalac.plugin.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.edalac.plugin.userservice.model.dto.PersonDTO;
import co.com.edalac.plugin.userservice.model.dto.response.UserResponse;
import co.com.edalac.plugin.userservice.service.PersonService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/user/person")
@ApiResponse
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/findby/{id}")
	public UserResponse<PersonDTO> findById(@PathVariable Long id){
		UserResponse<PersonDTO> response = new UserResponse<PersonDTO>();
		PersonDTO person = personService.findById(id);
		response.setData(person);
		return response;
	}
}
