package com.jsp.warehouse.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.InventoryRequest;
import com.jsp.warehouse.responsedto.InventoryResponse;
import com.jsp.warehouse.utility.ResponseStructure;

public interface InventoryService  {

	ResponseEntity<ResponseStructure<InventoryResponse>> createInventory(int storageId, int clientId,
			InventoryRequest inventoryRequest);

	ResponseEntity<ResponseStructure<InventoryResponse>> findInventory(int productId);

	ResponseEntity<ResponseStructure<List<InventoryResponse>>> findAllInventories();

	ResponseEntity<ResponseStructure<InventoryResponse>> updateInventory(int productId,
			InventoryRequest inventoryRequest);




}
