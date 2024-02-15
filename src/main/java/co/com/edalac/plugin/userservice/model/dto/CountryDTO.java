package co.com.edalac.plugin.userservice.model.dto;

import java.util.List;

import co.com.edalac.plugin.userservice.model.dto.response.AbstractResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CountryDTO extends AbstractResponseDTO {

	private static final long serialVersionUID = -384597677299172552L;
	
	private Long idCountry;
	private String name;
	private String code;

	private List<StateDTO> states;
}
