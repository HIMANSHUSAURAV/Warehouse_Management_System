package com.jsp.warehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int warehouseId;
	private String warehousename;
	
	@OneToOne
	private Admin admin;

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehousename() {
		return warehousename;
	}

	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
