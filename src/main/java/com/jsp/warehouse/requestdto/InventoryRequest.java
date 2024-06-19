package com.jsp.warehouse.requestdto;

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
public class InventoryRequest {

	private String productTitle;
	private double lengthInMeters;
	private double breadthInMeters;
	private double heightInMeters;
	private double weightInKg;
	private double quantity;
	private int sellerId;
	
	List<MaterialTypes> materialTypes;

}
