package com.jsp.warehouse.responsedto;

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
public class StorageTypeResponse {

	private int storageTypeId;
	private double lengthsInMeters;
	private double breadthInMeters;
	private double heightInMeters;
	private double capacityinWeight;
	private int unitsAvailable;
}




