package com.jsp.warehouse.responsedto;

import java.time.LocalDate;
import java.util.List;

import com.jsp.warehouse.enums.MaterialTypes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrderResponse {

	private int orderId;
	private long orderQuantity;
	private String invoiceLink;
	private int customerId;
}
