package co.com.edalac.plugin.userservice.model.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse<T extends AbstractDTO> {

	private T data;
	private List<T> list;
	private Integer statusCode;
	private String message;

	
}
