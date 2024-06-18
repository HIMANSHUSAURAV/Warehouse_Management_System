package com.jsp.warehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorageType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storageTypeId;
	private double lengthsInMeters;
	private double breadthInMeters;
	private double heightInMeters;
	private double capacityinWeight;
	private int unitsAvailable;

}




