package com.jsp.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.StorageType;

public interface StorageTypeRepo extends JpaRepository<StorageType, Integer> {
	
	 boolean existsByLengthInMetersAndBreadthInMetersAndHeightInMetersAndCapacityWeightInKg(
	            double lengthInMeters,
	            double breadthInMeters,
	            double heightInMeters,
	            double capacityWeightInKg);

}
