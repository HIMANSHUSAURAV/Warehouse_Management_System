package com.jsp.warehouse.requestdto;

import java.util.List;

import com.jsp.warehouse.enums.MaterialTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StorageRequest {

	private String blockName;
	private String section;
	private double capacityInWeight;
	private double lengthInMeters;
	private double breadthInMeters;
	private double heightInMeters;
	
	List<MaterialTypes> materialTypes;
}





