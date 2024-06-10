package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.service.WarehouseService;
import com.jsp.warehouse.utility.ResponseStructure;

@RestController

public class WarehouseController {

	@GetMapping("/warehouses")
	public String saveWarehouse() {

		return " warehouse found";
	}
}