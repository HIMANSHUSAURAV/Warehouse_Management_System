package com.jsp.warehouse.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.utility.ResponseStructure;

public interface WarehouseService {

    ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(WarehouseRequest warehouseRequest);

	ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse(WarehouseRequest warehouseRequest, int warehouseId);

	ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(int warehouseId);

	ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehouses();

	ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehousesByCity(String city);






}
