package com.jsp.warehouse.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Address;
import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.exception.AddressNotFoundByIdException;
import com.jsp.warehouse.exception.WarehouseNotFoundByIdException;
import com.jsp.warehouse.mapper.AddressMapper;
import com.jsp.warehouse.repo.AddressRepository;
import com.jsp.warehouse.repo.WarehouseRepo;
import com.jsp.warehouse.requestdto.AddressRequest;
import com.jsp.warehouse.responsedto.AddressResponse;
import com.jsp.warehouse.service.AddressService;
import com.jsp.warehouse.utility.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class AddressServiceImple implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private WarehouseRepo warehouseRepo;

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> addAddress(@Valid AddressRequest addressRequest,
			int warehouseId) {

		return warehouseRepo.findById(warehouseId).map(warehouse -> {

			Address address= addressMapper.mapToAddress(addressRequest, new Address());
			addressRepository.save(address);

			address.setWarehouse(warehouse);
			warehouseRepo.save(warehouse);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseStructure<AddressResponse>()
							.setStatus(HttpStatus.CREATED.value())
							.setMessage("Address created")
							.setData(addressMapper.mapToAddressResponse(address)));
		}).orElseThrow(()-> new WarehouseNotFoundByIdException("warehouse not found"));

	}

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(int addressId,
			AddressRequest addressRequest){


		return addressRepository.findById(addressId).map(exaddress ->{
			addressMapper.mapToAddress(addressRequest, exaddress);
			exaddress = addressRepository.save(exaddress);
			return  ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseStructure<AddressResponse>()
							.setStatus(HttpStatus.CREATED.value())
							.setMessage("Address Created")
							.setData(addressMapper.mapToAddressResponse(exaddress)));
		}).orElseThrow(()-> new AddressNotFoundByIdException("Address not found by the given id"));

	}

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> findAddress(int addressId) {
		return addressRepository.findById(addressId).map(address -> {

			return ResponseEntity.status(HttpStatus.FOUND)
					.body(new ResponseStructure<AddressResponse>()
							.setStatus(HttpStatus.FOUND.value())
							.setMessage("Address found ")
							.setData(addressMapper.mapToAddressResponse(address)));

		}).orElseThrow(() -> new AddressNotFoundByIdException("Address with ID not found"));


	}
}







