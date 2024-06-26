package com.jsp.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.InventoryRequest;
import com.jsp.warehouse.responsedto.InventoryResponse;
import com.jsp.warehouse.service.InventoryService;
import com.jsp.warehouse.utility.ResponseStructure;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("client/{clientId}/storages/{storageId}/inventories")
	public ResponseEntity<ResponseStructure<InventoryResponse>> createInventory(@PathVariable int storageId, 
			@PathVariable int clientId,@RequestBody InventoryRequest inventoryRequest) {
		
		return  inventoryService.createInventory(storageId,clientId, inventoryRequest);
	}
	
	
	@GetMapping("client/{productId}/inventories")
	public ResponseEntity<ResponseStructure<InventoryResponse>> findInventory(@PathVariable int productId) {
		return inventoryService.findInventory(productId);
	}
	@GetMapping("client/inventories")
	public ResponseEntity<ResponseStructure<List<InventoryResponse>>> findAllInventories() {
		return inventoryService.findAllInventories();
	}
	
	@PutMapping("client/{productId}/inventories")
	public ResponseEntity<ResponseStructure<InventoryResponse>> updateInventory
							(@PathVariable int productId, @RequestBody InventoryRequest inventoryRequest) {
		
		return inventoryService.updateInventory(productId, inventoryRequest);
	}
}
