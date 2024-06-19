package com.jsp.warehouse.entity;

import java.util.List;

import com.jsp.warehouse.enums.MaterialTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storageId;
	private String blockName;
	private String section;
	private double lengthInMeters;
	private double breadthInMeters;
	private double heightInMeters;
	private double capacityInWeight;
	private int sellerId;
	
	@Enumerated(EnumType.STRING)
	List<MaterialTypes> materialTypes;
	private double maxAdditionalWeight;
	private double availableArea;

	@ManyToOne
	private Warehouse wareHouse;
	
	@ManyToOne
	private StorageType storageType;
	
	  @ManyToMany
	private List<Inventory> inventories;
}



