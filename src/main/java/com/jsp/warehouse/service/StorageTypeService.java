package com.jsp.warehouse.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.StorageTypeRequest;
import com.jsp.warehouse.responsedto.StorageTypeResponse;
import com.jsp.warehouse.utility.ResponseStructure;

public interface StorageTypeService {

	ResponseEntity<ResponseStructure<StorageTypeResponse>> addStorageType(StorageTypeRequest storageTypeRequest);

	ResponseEntity<ResponseStructure<StorageTypeResponse>> updateStorageType(int storageTypeId,
			StorageTypeRequest storageTypeRequest);

	ResponseEntity<ResponseStructure<List<StorageTypeResponse>>> findStorageTypes();



	
}
