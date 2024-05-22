package co.com.edalac.plugin.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.edalac.plugin.userservice.model.dto.ContactTypeDTO;
import co.com.edalac.plugin.userservice.service.ContactTypeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/user/contact-type")
@ApiResponse
public class ContactTypeController {
	
	@Autowired
	private ContactTypeService contactTypeService;
	
	@GetMapping("findById/{id}")
	public ContactTypeDTO findById(@PathVariable Integer id) {
		return contactTypeService.findById(id);
	}
	
	@GetMapping("findAll")
	public List<ContactTypeDTO> findAll(){
		return contactTypeService.findAll();
	}
}
