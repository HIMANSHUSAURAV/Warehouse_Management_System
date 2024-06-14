package com.jsp.warehouse.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Storage;
import com.jsp.warehouse.requestdto.StorageRequest;
import com.jsp.warehouse.responsedto.StorageResponse;

import jakarta.validation.Valid;

@Component
public class StorageMapper {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Storage mapToStorage(StorageRequest storageRequest , Storage storage) {
		storage.setBlockName(storageRequest.getBlockName());
		storage.setSection(storageRequest.getSection());
		storage.setCapacityInWeight(storageRequest.getCapacityInKg());
		storage.setCapacityInArea(storageRequest.getLengthInMeter() * 
				storageRequest.getBreadthInMeter() * storageRequest.getHeightInMeter());
		storage.setMaterialTypes(storageRequest.getMaterialTypes());		
		return storage;
	}

	public StorageResponse mapToStorageResponse(Storage storage) {
		return StorageResponse.builder()
				.storageId(storage.getStorageId())
				.blockName(storage.getBlockName())
				.section(storage.getSection())

				.availableArea(storage.getAvailableArea())
				.maxAdditionalWeight(storage.getMaxAdditionalWeight())
				.build();
	}

}




