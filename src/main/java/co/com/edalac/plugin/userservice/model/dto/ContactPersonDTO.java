package co.com.edalac.plugin.userservice.model.dto;

import co.com.edalac.plugin.userservice.model.dto.response.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class ContactPersonDTO extends AbstractDTO {

	private static final long serialVersionUID = 3848567181260115121L;
	
	private Long id;
	private PersonDTO person;
	private ContactTypeDTO contactType;
	private Boolean master;
	
}
