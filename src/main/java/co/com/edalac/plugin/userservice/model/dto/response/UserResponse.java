package co.com.edalac.plugin.userservice.model.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class UserResponse<T extends AbstractDTO> {

	private T data;
	private List<T> list;
	private Integer statusCode;
	private String message;

	
}
