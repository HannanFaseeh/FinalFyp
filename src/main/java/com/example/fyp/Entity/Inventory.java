package com.example.fyp.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Inventory {

    @Id
    private int id;

    private int productId;    //Foreign Key
    private int quantity;

}
