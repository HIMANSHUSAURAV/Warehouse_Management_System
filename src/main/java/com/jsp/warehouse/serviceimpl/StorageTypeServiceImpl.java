package com.jsp.warehouse.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.StorageType;
import com.jsp.warehouse.exception.StorageTypeNotFoundByIdException;
import com.jsp.warehouse.mapper.StorageTypeMapper;
import com.jsp.warehouse.repo.StorageRepo;
import com.jsp.warehouse.repo.StorageTypeRepo;
import com.jsp.warehouse.requestdto.StorageTypeRequest;
import com.jsp.warehouse.responsedto.StorageTypeResponse;
import com.jsp.warehouse.service.StorageTypeService;
import com.jsp.warehouse.utility.ResponseStructure;

@Service
public class StorageTypeServiceImpl implements StorageTypeService {

	@Autowired
	private StorageTypeRepo storageTypeRepo;

	@Autowired
	private StorageTypeMapper storageTypeMapper;

	@Autowired
	private StorageRepo storageRepo;


	@Override
	public ResponseEntity<ResponseStructure<StorageTypeResponse>> addStorageType(
			StorageTypeRequest storageTypeRequest) {
		StorageType storageType =  storageTypeRepo.save(storageTypeMapper.mapToStorageType(storageTypeRequest,
				new StorageType()));

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<StorageTypeResponse>()
						.setStatus(HttpStatus.CREATED.value())
						.setMessage("Storage Type Created")
						.setData(storageTypeMapper.mapToStorageTypeResponse(storageType)));
	}


	@Override
	public ResponseEntity<ResponseStructure<StorageTypeResponse>> updateStorageType(int storageTypeId,
			StorageTypeRequest storageTypeRequest) {
		
	return storageTypeRepo.findById(storageTypeId).map(existingStorageType -> {
			
			existingStorageType = storageTypeMapper.mapToStorageType(storageTypeRequest, existingStorageType);
			 
			existingStorageType = storageTypeRepo.save(existingStorageType);
			
			
					return ResponseEntity.status(HttpStatus.CREATED)
							.body(new ResponseStructure<StorageTypeResponse>()
									.setStatus(HttpStatus.CREATED.value())
									.setMessage("Storage Type Created")
									.setData(storageTypeMapper.mapToStorageTypeResponse(existingStorageType)));	
					
		}).orElseThrow(()-> new StorageTypeNotFoundByIdException("storage not found"));
	}


	@Override
	public ResponseEntity<ResponseStructure<List<StorageTypeResponse>>> findStorageTypes() {
		
		List<StorageTypeResponse>  storageTypeResponses = storageTypeRepo.findAll()
				.stream().map(storageTypes -> storageTypeMapper.mapToStorageTypeResponse(storageTypes))
				.toList();
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<List<StorageTypeResponse>>()
						.setStatus(HttpStatus.CREATED.value())
						.setMessage("Storage Type Created")
						.setData(storageTypeResponses));	
	}
}






