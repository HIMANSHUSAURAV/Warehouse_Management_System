package com.jsp.warehouse.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.exception.WarehouseNotFoundByCityException;
import com.jsp.warehouse.exception.WarehouseNotFoundByIdException;
import com.jsp.warehouse.mapper.WarehouseMapper;
import com.jsp.warehouse.repo.AddressRepository;
import com.jsp.warehouse.repo.WarehouseRepo;
import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.WarehouseResponse;
import com.jsp.warehouse.service.WarehouseService;
import com.jsp.warehouse.utility.ResponseStructure;

@Service
public class WarehouseServiceImpl implements WarehouseService{

	@Autowired
	private WarehouseRepo warehouseRepo;

	@Autowired
	private WarehouseMapper warehouseMapper;
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(WarehouseRequest warehouseRequest) {

		Warehouse warehouse= warehouseMapper.mapToWarehouse(warehouseRequest,  new Warehouse()); 
		Warehouse saveW = warehouseRepo.save(warehouse); 

		return ResponseEntity.status(HttpStatus.CREATED) 
				.body(new ResponseStructure<WarehouseResponse>() 
						.setStatus(HttpStatus.CREATED.value()) 
						.setMessage("Warehouse created") 
						.setData(warehouseMapper.mapToWarehouseResponse(warehouse)));		
		
	}

	//updateWarehouse
	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse(WarehouseRequest warehouseRequest,
			int warehouseId) {

		return warehouseRepo.findById(warehouseId).map(existingWarehouse ->{
			warehouseMapper.mapToWarehouse(warehouseRequest, existingWarehouse);
			existingWarehouse = warehouseRepo.save(existingWarehouse);

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<WarehouseResponse>()
							.setStatus(HttpStatus.OK.value())
							.setMessage("WareHouse Updated")
							.setData(warehouseMapper.mapToWarehouseResponse(existingWarehouse)));
		}).orElseThrow(()-> new WarehouseNotFoundByIdException("wareHouse Not fouind"));

	}

	// find warehouse 
	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(int warehouseId) {
		return warehouseRepo.findById(warehouseId).
				<ResponseEntity<ResponseStructure<WarehouseResponse>>>map(warehouse->{

					return ResponseEntity.status(HttpStatus.FOUND)
							.body(new ResponseStructure<WarehouseResponse>()
									.setStatus(HttpStatus.FOUND.value())
									.setMessage("Warehouse Found")
									.setData(warehouseMapper.mapToWarehouseResponse(warehouse)));
				}).orElseThrow(()-> new WarehouseNotFoundByIdException("Warehouse not found by Id"));
	}

	// find warehouses 
	@Override
	public ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehouses() {

		List<WarehouseResponse> warehouseResponses = warehouseRepo.findAll()
				.stream()
				.map(warehouse -> warehouseMapper.mapToWarehouseResponse(warehouse))
				.toList();
				
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<WarehouseResponse>>()
						.setStatus(HttpStatus.FOUND.value())
						.setMessage("warehouse found")
						.setData(warehouseResponses));
	}
	
	//warehouse by city 
	@Override
	public ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehousesByCity(String city) {
		
		List<WarehouseResponse> addressResponse = addressRepository.findAllByCity(city).stream()
				.map(address -> warehouseMapper.mapToWarehouseAddress(address.getWarehouse(), address)).toList(); 

		if(addressResponse.isEmpty())
			throw new WarehouseNotFoundByCityException("City not found");

		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<WarehouseResponse>>()
						.setStatus(HttpStatus.FOUND.value())
						.setMessage("Warehouses Found by "+city)
						.setData(addressResponse));
	}

}




