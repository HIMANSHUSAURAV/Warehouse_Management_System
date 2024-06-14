package com.jsp.warehouse.service;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.StorageRequest;
import com.jsp.warehouse.responsedto.StorageResponse;
import com.jsp.warehouse.utility.ResponseStructure;
import com.jsp.warehouse.utility.SimpleStructure;

import jakarta.validation.Valid;

public interface StorageService  {

	ResponseEntity<SimpleStructure<String>> addStorage(@Valid StorageRequest storageRequest, int warehouseId,
			int noOfStorageUnits);

	ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(StorageRequest storageRequest, int storageId);


	
}
