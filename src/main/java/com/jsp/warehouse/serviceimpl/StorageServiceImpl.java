package com.jsp.warehouse.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Storage;
import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.exception.AddressNotFoundByIdException;
import com.jsp.warehouse.exception.StorageNotFoundByIdException;
import com.jsp.warehouse.exception.WarehouseNotFoundByIdException;
import com.jsp.warehouse.mapper.StorageMapper;
import com.jsp.warehouse.repo.StorageRepo;
import com.jsp.warehouse.repo.WarehouseRepo;
import com.jsp.warehouse.requestdto.StorageRequest;
import com.jsp.warehouse.responsedto.AddressResponse;
import com.jsp.warehouse.responsedto.StorageResponse;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.service.StorageService;
import com.jsp.warehouse.utility.ResponseStructure;
import com.jsp.warehouse.utility.SimpleStructure;

import jakarta.validation.Valid;

@Service
public class StorageServiceImpl implements StorageService {

	@Autowired
	private StorageRepo storageRepo;

	@Autowired
	private StorageMapper storageMapper;

	@Autowired
	private WarehouseRepo warehouseRepo;


	@Override
	public ResponseEntity<SimpleStructure<String>> createStorage(StorageRequest storageRequest, int wareHouseId,
			int noOfStorageUnits) {
		Warehouse wareHouse =  warehouseRepo.findById(wareHouseId).orElseThrow(()-> new WarehouseNotFoundByIdException("warehouse not found"));

		List<Storage> storages = new ArrayList<Storage>();

		int count = 0;

		while(noOfStorageUnits > 0) {

			Storage storage  = storageMapper.mapToStorage(storageRequest, new Storage());

			storage.setMaxAdditionalWeight(storageRequest.getCapacityInWeight());
			storage.setAvailableArea(storageRequest.getLengthInMeters() * storageRequest.getBreadthInMeters() * storageRequest.getHeightInMeters());
			storage.setWareHouse(wareHouse);

			wareHouse.setTotalCapacity(storage.getCapacityInWeight() * noOfStorageUnits + wareHouse.getTotalCapacity());

			storages.add(storage);
			count++;
			noOfStorageUnits --;
		}

		storageRepo.saveAll(storages);
		warehouseRepo.save(wareHouse);

		return ResponseEntity.status(HttpStatus.CREATED).body(new SimpleStructure<String>()
				.setStatus(HttpStatus.CREATED.value())
				.setMessage(""+count + " Storages created"));
	}



	@Override
	public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(StorageRequest storageRequest,
			int storageId) {
		return storageRepo.findById(storageId).map(existingStorage -> {

			existingStorage = 	storageMapper.mapToStorage(storageRequest, existingStorage);
			existingStorage = storageRepo.save(existingStorage);

			storageRepo.save(existingStorage);

			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseStructure<StorageResponse>()
							.setStatus(HttpStatus.CREATED.value())
							.setMessage("Storage updates")
							.setData(storageMapper.mapToStorageResponse(existingStorage)));

		}).orElseThrow(() -> new StorageNotFoundByIdException("Storage not found"));

	}
}







