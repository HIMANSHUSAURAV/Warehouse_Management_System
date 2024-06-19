package com.jsp.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.PurchaseOrder;
import com.jsp.warehouse.requestdto.PurchaseOrderRequest;
import com.jsp.warehouse.responsedto.PurchaseOrderResponse;

@Component
public class PurchaseOrderMapper {

	public  PurchaseOrder mapToPurchaseOrder(PurchaseOrderRequest purchaseOrderRequest, PurchaseOrder purchaseOrder ) {
		
		purchaseOrder.setOrderQuantity(purchaseOrder.getOrderQuantity());
		purchaseOrder.setInvoiceLink(purchaseOrder.getInvoiceLink());
		purchaseOrder.setCustomerId(purchaseOrder.getCustomerId());
		return purchaseOrder;
	}
	
	public PurchaseOrderResponse mapToPurchaseOrderResponse(PurchaseOrder purchaseOrder) {
		return PurchaseOrderResponse.builder()
				.orderId(purchaseOrder.getOrderId())
				.orderQuantity(purchaseOrder.getOrderQuantity())
				.invoiceLink(purchaseOrder.getInvoiceLink())
				.customerId(purchaseOrder.getCustomerId())
				.build();
	}
}


