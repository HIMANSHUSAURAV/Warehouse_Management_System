package com.jsp.warehouse.responsedto;

import java.util.List;

import com.jsp.warehouse.enums.AdminType;
import com.jsp.warehouse.enums.MaterialTypes;
import com.jsp.warehouse.enums.Privilege;

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
public class StorageResponse {

	private int storageId;
	private String blockName;
	private String section;
	private double lengthInMeter;
	private double breadthInMeter;
	private double heightInMeter;
	private double capacityInKg;
	private double availableArea;
	private double maxAdditionalWeight;
	
	private List<MaterialTypes> materialTypes;
}



