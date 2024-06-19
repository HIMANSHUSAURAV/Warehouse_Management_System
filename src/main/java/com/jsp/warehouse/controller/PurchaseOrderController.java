package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.PurchaseOrderRequest;
import com.jsp.warehouse.responsedto.PurchaseOrderResponse;
import com.jsp.warehouse.service.PurchaseOrderService;
import com.jsp.warehouse.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1")
public class PurchaseOrderController {

	
	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	@PostMapping("/inventories/{inventoryId}/purchaseOrders")
	public ResponseEntity<ResponseStructure<PurchaseOrderResponse>> createPurchaseOrder(
			@RequestBody PurchaseOrderRequest purchaseOrderRequest, @PathVariable int productId  ){
		return purchaseOrderService.createPurchaseOrder(purchaseOrderRequest, productId);
	}
}




