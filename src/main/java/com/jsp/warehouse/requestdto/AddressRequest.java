package com.jsp.warehouse.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

	@NotBlank(message = "The Address Line must not be Blank")
	@NotNull(message = "The Address Line must not be null")
	private String addressLine;
	
	@NotBlank(message = "The Address city must not be Blank")
	@NotNull(message = "The Address city must not be null")
	private String city;
	
	@NotBlank(message = "The Address state must not be Blank")
	@NotNull(message = "The Address state must not be null")
	private String state;
	
	@NotBlank(message = "The Address country must not be Blank")
	@NotNull(message = "The Address country must not be null")
	private String country;
	
	@NotNull(message = "The Address pincode must not be null")
	private int pincode;
	
	 @NotNull(message = "The Address latitude must not be null")
	    @NotBlank(message = "The Address latitude must not be blank")
	    private String latitude;

	    @NotNull(message = "The Address longitude must not be null")
	    @NotBlank(message = "The Address longitude must not be blank")
	    private String longitude;
}



