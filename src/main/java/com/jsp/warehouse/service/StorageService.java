package com.jsp.warehouse.service;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.StorageRequest;
import com.jsp.warehouse.responsedto.StorageResponse;
import com.jsp.warehouse.utility.ResponseStructure;
import com.jsp.warehouse.utility.SimpleStructure;

import jakarta.validation.Valid;

public interface StorageService  {

	ResponseEntity<SimpleStructure<String>> createStorage(StorageRequest storageRequest, int wareHouseId,
			int noOfStorageUnits);
	
	ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(StorageRequest storageRequest, int storageId);

	


	
}
