package com.example.fyp.Repository;

import com.example.fyp.Entity.InventoryManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryManagerRep extends JpaRepository<InventoryManager,Integer> {
}
