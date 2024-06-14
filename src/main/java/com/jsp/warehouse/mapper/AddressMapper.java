package com.jsp.warehouse.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Address;
import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.requestdto.AddressRequest;
import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.AddressResponse;

import jakarta.validation.Valid;

@Component
public class AddressMapper {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Address mapToAddress(AddressRequest addressRequest, Address address) {
		address.setAddressLine(addressRequest.getAddressLine());
		address.setCity(addressRequest.getCity());
		address.setPincode(addressRequest.getPincode());
		address.setCountry(addressRequest.getCountry());
		address.setState(addressRequest.getState());
		address.setLatitude(addressRequest.getLatitude());
		address.setLongitutde(addressRequest.getLongitude());
		return address;
	}
	
	public AddressResponse mapToAddressResponse(Address address) {
		return AddressResponse.builder()
				.addressId(address.getAddressId())
				.addressLine(address.getAddressLine())
				.city(address.getCity())
				.country(address.getCountry())
				.pincode(address.getPincode())
				.latitude(address.getLatitude())
				.longitutde(address.getLongitutde())
				.build();
	}

}




