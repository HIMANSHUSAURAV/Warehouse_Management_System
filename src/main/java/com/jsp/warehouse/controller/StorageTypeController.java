package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.StorageTypeRequest;
import com.jsp.warehouse.responsedto.StorageTypeResponse;
import com.jsp.warehouse.service.StorageTypeService;
import com.jsp.warehouse.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping
public class StorageTypeController {

	
	@Autowired
	private StorageTypeService storageTypeService;
	
	@PostMapping("/storageTypes")
	public ResponseEntity<ResponseStructure<StorageTypeResponse>> addStorageType(@RequestBody StorageTypeRequest storageTypeRequest ,
			@PathVariable int storageTypeId){
		
		return storageTypeService.addStorageType(storageTypeRequest,storageTypeId);
	}
}






