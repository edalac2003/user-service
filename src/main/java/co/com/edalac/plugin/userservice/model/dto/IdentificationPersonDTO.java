package co.com.edalac.plugin.userservice.model.dto;

import co.com.edalac.plugin.userservice.model.dto.response.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class IdentificationPersonDTO extends AbstractDTO {

	private static final long serialVersionUID = 5273824819780396157L;

	private PersonDTO person;
	private IdentificationTypeDTO identificationType;
	private Boolean master;
	private Boolean active;
	private String value;
	
}
