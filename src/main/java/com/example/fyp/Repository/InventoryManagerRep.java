package com.example.fyp.Repository;

import com.example.fyp.Entity.InventoryManager;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.function.Function;

@Repository
public interface InventoryManagerRep extends JpaRepository<InventoryManager,Integer> {

}
