package com.jsp.warehouse.service;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.utility.ResponseStructure;

public interface WarehouseService {

    ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(WarehouseRequest warehouseRequest);

}
