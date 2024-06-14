package com.jsp.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.service.WarehouseService;
import com.jsp.warehouse.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;
	
	 @PreAuthorize("hasAuthority('CREATE_WAREHOUSE')")
	@PostMapping("/warehouses")
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(@RequestBody WarehouseRequest warehouseRequest) {
		return warehouseService.createWarehouse(warehouseRequest);
	}
	 
	    @PreAuthorize("hasAuthority('UPDATE_WAREHOUSE')")
		@PutMapping("/warehouses/{warehouseId}")
		public ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse(@RequestBody WarehouseRequest warehouseRequest, @PathVariable int warehouseId) {
			return warehouseService.updateWarehouse(warehouseRequest, warehouseId);
		}
	    
	    @GetMapping("/warehouses/{warehouseId}")
		public ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(@PathVariable int warehouseId){
			
			 return warehouseService.findWarehouse(warehouseId);
		}
	    
	    @PreAuthorize("hasAuthority('UPDATE_WAREHOUSE')")
	    @GetMapping("/warehouses")
	  		public ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehouses(){
	  			
	  			 return warehouseService.findWarehouses();
	  		}
	   
	    @GetMapping("/cities/{city}/warehouses")
	    public ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehousesByCity(@PathVariable String city){
	    	return warehouseService.findWarehousesByCity(city);
	    }
	    
}













