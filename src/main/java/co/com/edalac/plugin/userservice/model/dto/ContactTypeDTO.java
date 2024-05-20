package co.com.edalac.plugin.userservice.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactTypeDTO implements Serializable {
	private static final long serialVersionUID = 5581525076798162142L;
	
	private Integer idContactType;
	private String name;
	private Boolean active;
}
