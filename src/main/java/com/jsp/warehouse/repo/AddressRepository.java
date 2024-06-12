package com.jsp.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
