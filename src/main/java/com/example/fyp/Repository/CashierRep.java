package com.example.fyp.Repository;

import com.example.fyp.Entity.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierRep extends JpaRepository<Cashier,Integer> {

}
