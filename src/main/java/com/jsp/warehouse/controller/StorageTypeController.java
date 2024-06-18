package com.jsp.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	    public ResponseEntity<ResponseStructure<StorageTypeResponse>> addStorageType(
	            @RequestBody StorageTypeRequest storageTypeRequest){

	      return storageTypeService.addStorageType(storageTypeRequest);
	    }
	  
	  @PutMapping("storagetypes/{storageId}")
	  public ResponseEntity<ResponseStructure<StorageTypeResponse>> updateStorageType(@PathVariable int storageTypeId, @RequestBody StorageTypeRequest storageTypeRequest) {
	     
	      
	      return storageTypeService.updateStorageType(storageTypeId,storageTypeRequest);
	  }
	  
	  @GetMapping("/storagetypes")
	  public ResponseEntity<ResponseStructure <List<StorageTypeResponse>>> findAllStorageTypes() {
	      return storageTypeService.findStorageTypes();
	  }
	  
	 
}








