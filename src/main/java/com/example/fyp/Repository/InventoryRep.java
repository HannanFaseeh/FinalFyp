package com.example.fyp.Repository;

import com.example.fyp.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRep extends JpaRepository<Inventory,Integer> {
}
