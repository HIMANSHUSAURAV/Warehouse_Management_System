package com.jsp.warehouse.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseRequest {

  @NotNull (message = "admin name should not null")
  @NotBlank(message = "dmin name could not blank")
	private String name;                                    
}
