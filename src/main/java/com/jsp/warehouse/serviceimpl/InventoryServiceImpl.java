package com.jsp.warehouse.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Client;
import com.jsp.warehouse.entity.Inventory;
import com.jsp.warehouse.entity.Storage;
import com.jsp.warehouse.exception.ClientNotFoundByIdException;
import com.jsp.warehouse.exception.InventoryNotFoundByIdException;
import com.jsp.warehouse.exception.StorageNotFoundByIdException;
import com.jsp.warehouse.mapper.InventoryMapper;
import com.jsp.warehouse.repo.ClientRepo;
import com.jsp.warehouse.repo.InventoryRepo;
import com.jsp.warehouse.repo.StorageRepo;
import com.jsp.warehouse.requestdto.InventoryRequest;
import com.jsp.warehouse.responsedto.InventoryResponse;
import com.jsp.warehouse.service.InventoryService;
import com.jsp.warehouse.utility.ResponseStructure;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepo inventoryRepo;

	@Autowired
	private InventoryMapper inventoryMapper;

	@Autowired
	private StorageRepo storageRepo;

	@Autowired
	private ClientRepo clientRepo;


	@Override
	public ResponseEntity<ResponseStructure<InventoryResponse>> createInventory(int storageId, int clientId,
			InventoryRequest inventoryRequest) {

		Storage storage = storageRepo.findById(storageId).orElseThrow(()-> new StorageNotFoundByIdException("storage Not Found"));

		Inventory inventory = inventoryRepo.save(inventoryMapper.mapToInventory(inventoryRequest, new Inventory()));

		Client client = clientRepo.findById(clientId).orElseThrow(()-> new ClientNotFoundByIdException("Client Not Found"));

		storage.getInventories().add(inventory);
		inventory.setRestockedAt(LocalDate.now());


		storage.setMaxAdditionalWeight(storage.getMaxAdditionalWeight() * inventoryRequest.getQuantity() - inventoryRequest.getWeightInKg());
		storage.setAvailableArea(inventory.getLengthInMeters() * inventory.getBreadthInMeters() * inventory.getHeightInMeters());
		storage.setSellerId(inventoryRequest.getSellerId());

		inventory = inventoryRepo.save(inventory);
		storageRepo.save(storage);
		clientRepo.save(client);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<InventoryResponse>()
						.setStatus(HttpStatus.CREATED.value())
						.setMessage("Inventory created")
						.setData(inventoryMapper.mapToInventoryResponse(inventory)));
	}


	@Override
	public ResponseEntity<ResponseStructure<InventoryResponse>> findInventory(int productId) {
		return inventoryRepo.findById(productId).map(inventory ->{
			return ResponseEntity.status(HttpStatus.FOUND)
					.body(new ResponseStructure<InventoryResponse>()
							.setStatus(HttpStatus.FOUND.value())
							.setMessage("Inventory created")
							.setData(inventoryMapper.mapToInventoryResponse(inventory)));
		}).orElseThrow(()->new InventoryNotFoundByIdException("Inventory not found "));

	}

	@Override
	public ResponseEntity<ResponseStructure<List<InventoryResponse>>> findAllInventories() {
		List<InventoryResponse> inventoryResponses	=inventoryRepo.findAll().stream()
				.map(inventories -> inventoryMapper.mapToInventoryResponse(inventories))
				.toList();
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<InventoryResponse>>()
						.setStatus(HttpStatus.FOUND.value())
						.setMessage("Inventories found")
						.setData(inventoryResponses));
	}


	@Override
	public ResponseEntity<ResponseStructure<InventoryResponse>> updateInventory(int productId,
			InventoryRequest inventoryRequest) {
		return  inventoryRepo.findById(productId)
				.map(existingInventory -> { 

					existingInventory = inventoryRepo.save(inventoryMapper.mapToInventory(inventoryRequest, existingInventory));


					return ResponseEntity.status(HttpStatus.OK)
							.body(new ResponseStructure<InventoryResponse>()
									.setStatus(HttpStatus.OK.value())
									.setMessage("Inventory created")
									.setData(inventoryMapper.mapToInventoryResponse(existingInventory)));

				}).orElseThrow(()-> new InventoryNotFoundByIdException("Inventory Not found"));

	}
}





