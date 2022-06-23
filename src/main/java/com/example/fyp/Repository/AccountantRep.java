package com.example.fyp.Repository;

import com.example.fyp.Entity.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountantRep extends JpaRepository<Accountant,Integer> {

}
