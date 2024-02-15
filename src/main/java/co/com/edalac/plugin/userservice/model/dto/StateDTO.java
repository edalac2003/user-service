package co.com.edalac.plugin.userservice.model.dto;

import java.util.List;

import co.com.edalac.plugin.userservice.model.dto.response.AbstractResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class StateDTO extends AbstractResponseDTO {

	private static final long serialVersionUID = -8096086907639532466L;
	
	private Long idState;
	private String name;
	private String code;
	private Long countryId;
	
	private List<CityDTO> cities;
}
