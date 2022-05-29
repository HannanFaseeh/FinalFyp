package com.example.fyp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin                           //extends InventoryManager
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Max(11)
    private String name;
    private String address;

    @Column(unique = true , nullable = false)
    private String email;
    @NotNull(message = "Name cann't be null")
    private String password;
    private String role;
    private String phone;

}
