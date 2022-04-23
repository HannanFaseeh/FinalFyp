package com.example.fyp.Repository;

import com.example.fyp.Entity.InventoryManager;
import com.example.fyp.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<Product,Integer> {
}
