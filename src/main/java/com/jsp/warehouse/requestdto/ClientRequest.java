package com.jsp.warehouse.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

	private int clientId;
	private String businessName;
	private String email;
	private long contactNumber;
}
