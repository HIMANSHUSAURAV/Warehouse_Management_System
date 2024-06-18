package com.jsp.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.Storage;

public interface StorageRepo extends JpaRepository<Storage, Integer>{

	
	Object findFirstByCapacityInWeightAndLengthInMetersAndBreadthInMetersAndHeightInMeters(int i, int j, int k, int l);

}
