package com.jsp.warehouse.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.Address;
import com.jsp.warehouse.entity.Warehouse;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	List<Address> findAllByCity(String city);
}
