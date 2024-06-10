package com.jsp.warehouse.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.exception.IllegalOperationException;
import com.jsp.warehouse.mapper.WarehouseMapper;
import com.jsp.warehouse.repo.WarehouseRepo;
import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.service.WarehouseService;
import com.jsp.warehouse.utility.ResponseStructure;

@Service
public class WarehouseServiceImpl implements WarehouseService{

	 @Autowired
	    private WarehouseRepo warehouseRepo;

	    @Autowired
	    private WarehouseMapper warehouseMapper;

		@PostMapping("/warehouses")
		public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(WarehouseRequest warehouseRequest) {
			
			Warehouse warehouse= warehouseMapper.mapToWarehouse(warehouseRequest,  new Warehouse()); 
	         Warehouse saveW = warehouseRepo.save(warehouse); 
	          
	         return ResponseEntity.status(HttpStatus.CREATED) 
	             .body(new ResponseStructure<WarehouseResponse>() 
	                 .setStatus(HttpStatus.CREATED.value()) 
	                 .setMessage("Warehouse created") 
	                 .setData(warehouseMapper.mapToWarehouseResponse(saveW)));
			
}
}