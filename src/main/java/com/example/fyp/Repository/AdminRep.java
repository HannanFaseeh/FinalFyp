package com.example.fyp.Repository;

import com.example.fyp.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRep extends JpaRepository<Admin,Integer> {

}
