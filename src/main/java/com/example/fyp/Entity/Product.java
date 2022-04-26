package com.example.fyp.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
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
