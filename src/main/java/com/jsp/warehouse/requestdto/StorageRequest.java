package com.jsp.warehouse.requestdto;

import java.util.List;

import com.jsp.warehouse.enums.MaterialTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StorageRequest {

	private String blockName;
	private double capacityInArea;
	private String section;
	private double capacityInKg;
	private double lengthInMeter;
	private double breadthInMeter;
	private double heightInMeter;
	
	private List<MaterialTypes> materialTypes;
}





