package com.jsp.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

}
