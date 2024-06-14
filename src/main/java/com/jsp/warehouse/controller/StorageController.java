package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.StorageRequest;
import com.jsp.warehouse.responsedto.StorageResponse;
import com.jsp.warehouse.service.StorageService;
import com.jsp.warehouse.utility.ResponseStructure;
import com.jsp.warehouse.utility.SimpleStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class StorageController {

	@Autowired
	private StorageService storageService;
	
	

	@PreAuthorize("hasAuthority('CREATE_STORAGE')")
	@PostMapping("warehouses/{wareHouseId}/storages")
	public ResponseEntity<SimpleStructure<String>> createStorage(@RequestBody  StorageRequest storageRequest ,
			@PathVariable int wareHouseId, @RequestParam("no_of_storage_units") int noOfStorageUnits ){
		return storageService.createStorage(storageRequest , wareHouseId , noOfStorageUnits);
	}
	
	 @PutMapping("/storages/{storageId}")
	 @PreAuthorize("hasAuthority('UPDATE_STORAGE')")
	    public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(
	             @RequestBody StorageRequest storageRequest, @PathVariable int storageId) {
	        return storageService.updateStorage(storageRequest, storageId);
	    }
}


