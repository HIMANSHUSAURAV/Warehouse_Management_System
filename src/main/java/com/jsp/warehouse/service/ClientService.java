package com.jsp.warehouse.service;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.ClientRequest;
import com.jsp.warehouse.responsedto.ClientResponse;
import com.jsp.warehouse.utility.ResponseStructure;


public interface ClientService {

	ResponseEntity<ResponseStructure<ClientResponse>> addClient(ClientRequest clientRequest);

	ResponseEntity<ResponseStructure<ClientResponse>> updateClient(int clientId, ClientRequest clientRequest);

}
