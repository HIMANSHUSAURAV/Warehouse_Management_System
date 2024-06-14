package com.jsp.warehouse.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.WarehouseResponse;

@Component
public class WarehouseMapper {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Warehouse mapToWarehouse(WarehouseRequest warehouseRequest, Warehouse warehouse) {
		warehouse.setWarehousename(warehouseRequest.getWarehousename());
		
		return warehouse;
	}

	public WarehouseResponse mapToWarehouseResponse(Warehouse warehouse) {
		return WarehouseResponse.builder()
				.warehouseId(warehouse.getWarehouseId())
				.warehousename(warehouse.getWarehousename())
				.totalCapacity(warehouse.getTotalCapacity())
				.build();
	}
}
