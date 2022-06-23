package com.example.fyp.Repository;

import com.example.fyp.Entity.InventoryManager;
import com.example.fyp.Entity.PurchaseManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseManagerRep extends JpaRepository<PurchaseManager,Integer> {

}
