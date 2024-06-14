package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.ClientRequest;
import com.jsp.warehouse.responsedto.ClientResponse;
import com.jsp.warehouse.service.ClientService;
import com.jsp.warehouse.utility.ResponseStructure;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

	
	@Autowired
	private ClientService clientService;

		@PostMapping("/clients")
		public ResponseEntity<ResponseStructure<ClientResponse>> addClient(@RequestBody ClientRequest clientRequest) {
			return clientService.addClient(clientRequest);
		}
	
		@PutMapping("clients/{clientId}")
		public ResponseEntity<ResponseStructure<ClientResponse>> updateClient(@PathVariable int clientId, 
				@RequestBody ClientRequest clientRequest) {
		    
		    return clientService.updateClient(clientId,clientRequest);
		}
}
