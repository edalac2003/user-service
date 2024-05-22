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
public class AddressTypeDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
}
