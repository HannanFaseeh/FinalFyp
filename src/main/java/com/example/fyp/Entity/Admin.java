package com.example.fyp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Max(11)
    private String name;
    private String email;
    private String address;
    private String password;
    private String role;

    private String phone;

}
