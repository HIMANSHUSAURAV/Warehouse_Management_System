package com.jsp.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.StorageType;
import com.jsp.warehouse.requestdto.StorageTypeRequest;
import com.jsp.warehouse.responsedto.StorageTypeResponse;

@Component
public class StorageTypeMapper {

	public StorageType mapToStorageType(StorageTypeRequest storageTypeRequest , StorageType storageType) {
		
		storageType.setLengthsInMeters(storageTypeRequest.getLengthsInMeters());
		storageType.setBreadthInMeters(storageTypeRequest.getBreadthInMeters());
		storageType.setHeightInMeters(storageTypeRequest.getHeightInMeters());
		storageType.setCapacityinWeight(storageTypeRequest.getCapacityinWeight());
		
		return storageType;
	}
	public StorageTypeResponse mapToStorageTypeResponse(StorageType storageType) {
		
		return StorageTypeResponse.builder()
				.storageTypeId(storageType.getStorageTypeId())
				.lengthsInMeters(storageType.getLengthsInMeters())
				.breadthInMeters(storageType.getBreadthInMeters())
				.heightInMeters(storageType.getHeightInMeters())
				.capacityinWeight(storageType.getCapacityinWeight())
				.unitsAvailable(storageType.getUnitsAvailable())
				.build();
	}
	
}


