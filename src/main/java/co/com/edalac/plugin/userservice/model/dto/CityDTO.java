package co.com.edalac.plugin.userservice.model.dto;

import co.com.edalac.plugin.userservice.model.dto.response.AbstractResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
//@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO extends AbstractResponseDTO {

	private static final long serialVersionUID = 9009994347449747019L;
	
	private Long idCity;
	private String name;
	private String code;
	
}
