package com.jsp.warehouse.service;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.PurchaseOrderRequest;
import com.jsp.warehouse.responsedto.PurchaseOrderResponse;
import com.jsp.warehouse.utility.ResponseStructure;

public interface PurchaseOrderService {

	ResponseEntity<ResponseStructure<PurchaseOrderResponse>> createPurchaseOrder(
			PurchaseOrderRequest purchaseOrderRequest, int productId);

}
