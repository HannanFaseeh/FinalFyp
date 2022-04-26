package com.example.fyp.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

public class Sale {
    @Id
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private double bill ;                //Sale Bill
    private double discount;
    private double totalBill;            //Bill After Discounts

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cc_fk",referencedColumnName = "productId")
    private List<Product> productList;


}
