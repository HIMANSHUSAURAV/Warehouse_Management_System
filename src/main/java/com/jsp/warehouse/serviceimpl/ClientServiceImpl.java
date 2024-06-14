package com.jsp.warehouse.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Client;
import com.jsp.warehouse.exception.ClientNotFoundByIdException;
import com.jsp.warehouse.mapper.ClientMapper;
import com.jsp.warehouse.repo.ClientRepo;
import com.jsp.warehouse.requestdto.ClientRequest;
import com.jsp.warehouse.responsedto.ClientResponse;
import com.jsp.warehouse.service.ClientService;
import com.jsp.warehouse.utility.ResponseStructure;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepo clientRepository;

	@Autowired
	private ClientMapper clientMapper;


	@Override
	public ResponseEntity<ResponseStructure<ClientResponse>> addClient(ClientRequest clientRequest) {

		String apiKey = UUID.randomUUID().toString();

		Client client = clientRepository.save(clientMapper.mapToClientRequest(clientRequest, new Client()));
          client.setApiKey(apiKey);
          clientRepository.save(client);
          
          return ResponseEntity.status(HttpStatus.CREATED)
        		  .body(new ResponseStructure<ClientResponse>()
        				  .setStatus(HttpStatus.CREATED.value())
        				  .setMessage("ApiKey  created")
        				  .setData(clientMapper.mapToClientResponse(client)));
	}


	@Override
	public ResponseEntity<ResponseStructure<ClientResponse>> updateClient(int clientId, ClientRequest clientRequest) {
		
		return clientRepository.findById(clientId).map(exClient -> {
			exClient = clientRepository.save(clientMapper.mapToClientRequest(clientRequest, exClient));
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<ClientResponse>()
							.setStatus(HttpStatus.OK.value())
							.setMessage("client updated")
							.setData(clientMapper.mapToClientResponse(exClient)));
		}).orElseThrow(() -> new  ClientNotFoundByIdException ("Client not found"));
	}

}
