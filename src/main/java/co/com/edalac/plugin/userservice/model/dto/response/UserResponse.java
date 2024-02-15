package co.com.edalac.plugin.userservice.model.dto.response;

import lombok.Data;

@Data
public class UserResponse<T> {

	private T data;
	private Integer statusCode;
	private String message;

	
}
