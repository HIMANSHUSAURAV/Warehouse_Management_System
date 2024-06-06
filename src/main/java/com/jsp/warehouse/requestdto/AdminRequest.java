package com.jsp.warehouse.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequest {
	@NotBlank(message = "The Admin name must not be Blank")
	@NotNull(message = "The Admin name must not be null")
	private String adminName;
	@NotBlank(message = "The Admin name must not be Blank")
	@NotNull(message = "The Admin name must not be null")
//	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",message = "The Email Id must end with @Gmail.com")
	private String adminEmail;
	@NotBlank(message = "The Admin name must not be Blank")
	@NotNull(message = "The Admin name must not be null")
//	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
//	message = "The Password cannot be accepted")
	private String password;
}