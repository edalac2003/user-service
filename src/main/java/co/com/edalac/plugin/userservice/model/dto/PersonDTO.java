package co.com.edalac.plugin.userservice.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.com.edalac.plugin.userservice.model.dto.response.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO extends AbstractDTO{

	private static final long serialVersionUID = -2673000135781248471L;

	private Long id;
	private String firstName;
	private String lastName;
	private String genre;
	private LocalDate birthdate;
	private Boolean status;
	
	private CityDTO city = new CityDTO();
	
	private List<IdentificationPersonDTO> identifications = new ArrayList<IdentificationPersonDTO>();
	
	private List<ContactPersonDTO> contacts = new ArrayList<ContactPersonDTO>();
	
	private List<AddressPersonDTO> addresses = new ArrayList<AddressPersonDTO>();
}
