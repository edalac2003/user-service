package co.com.edalac.plugin.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.com.edalac.plugin.userservice.model.dto.ContactTypeDTO;
import co.com.edalac.plugin.userservice.service.ContactTypeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController("/contact-type")
@ApiResponse
public class ContactTypeController {
	
	@Autowired
	private ContactTypeService contactTypeService;
	
	@GetMapping(value = "findById/{id}")
	public ContactTypeDTO findById(@PathVariable Integer id) {
		return contactTypeService.findById(id);
	}
	
	@GetMapping(value = "/contacts")
	public List<ContactTypeDTO> findAll(){
		return contactTypeService.findAll();
	}
}
