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
public class AddressPersonDTO extends AbstractDTO {

	private static final long serialVersionUID = -3112151983151833206L;

	private Integer id;
	private PersonDTO person;
	private AddressTypeDTO addressType;
	private Boolean master;
	private Boolean active;
	private CityDTO city;
	private String address;
	private String addressComplement;
}
