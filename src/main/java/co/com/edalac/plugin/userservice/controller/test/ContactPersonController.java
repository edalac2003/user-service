package co.com.edalac.plugin.userservice.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.edalac.plugin.userservice.model.dto.ContactPersonDTO;
import co.com.edalac.plugin.userservice.model.dto.response.UserResponse;
import co.com.edalac.plugin.userservice.service.ContactPersonService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/user/contact-person")
@ApiResponse
public class ContactPersonController {

	@Autowired
	private ContactPersonService service;
	
	@GetMapping("/getAllByIdPerson")
	public UserResponse<ContactPersonDTO> getAllByIdPerson(Long idPerson) {
		UserResponse<ContactPersonDTO> response = new UserResponse<ContactPersonDTO>();
		response.setList(service.getAllByIdPerson(idPerson));
		return response;
	}
}
