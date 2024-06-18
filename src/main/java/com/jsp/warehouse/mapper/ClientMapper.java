package com.jsp.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Client;
import com.jsp.warehouse.requestdto.ClientRequest;
import com.jsp.warehouse.responsedto.ClientResponse;

@Component
public class ClientMapper {

	public Client mapToClientRequest(ClientRequest clientRequest, Client client) {
		client.setBusinessName(clientRequest.getBusinessName());
		client.setEmail(clientRequest.getEmail());
		client.setContactNumber(clientRequest.getContactNumber());
		
		return client;
	}
	
	
	public ClientResponse mapToClientResponse(Client client) {
		 
		return ClientResponse.builder()
				.apiKey(client.getApiKey())
				.build();

	}	
	
}
