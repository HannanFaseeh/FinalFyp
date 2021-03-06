package com.example.fyp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    private int inventoryId;    //Foreign Key
    private int quantity;

}
