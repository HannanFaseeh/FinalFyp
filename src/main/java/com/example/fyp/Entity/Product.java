package com.example.fyp.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private int productId;
    private String name;
    private String company;
    private String batchNo;
    private double MRP ;
    private double PP;          //Purchase Price
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiry;

}
