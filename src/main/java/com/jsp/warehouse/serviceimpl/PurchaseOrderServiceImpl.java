package com.jsp.warehouse.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.mapper.PurchaseOrderMapper;
import com.jsp.warehouse.repo.InventoryRepo;
import com.jsp.warehouse.repo.PurchaseOrderRepo;
import com.jsp.warehouse.requestdto.PurchaseOrderRequest;
import com.jsp.warehouse.responsedto.PurchaseOrderResponse;
import com.jsp.warehouse.service.PurchaseOrderService;
import com.jsp.warehouse.utility.ResponseStructure;

public class PurchaseOrderServiceImpl implements PurchaseOrderService{
	
	@Autowired
	private InventoryRepo inventoryRepo;
	
	@Autowired
	private PurchaseOrderMapper purchaseOrderMapper;
	
	@Autowired
	private PurchaseOrderRepo purchaseorderRepo;

	
	
	@Override
	public ResponseEntity<ResponseStructure<PurchaseOrderResponse>> createPurchaseOrder(
			PurchaseOrderRequest purchaseOrderRequest, int productId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
