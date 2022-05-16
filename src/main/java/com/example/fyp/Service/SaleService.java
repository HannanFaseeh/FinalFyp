package com.example.fyp.Service;

import com.example.fyp.Entity.Sale;
import com.example.fyp.Repository.SaleRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRep saleRep;

    public List<Sale> getSales()
    {
        return saleRep.findAll();
    }

    public Sale getSale(int id){
        Optional<Sale> sale = saleRep.findById(id);
        if(!sale.isPresent()){
            //throw new NotFoundException("Sale not found!");
        }
        return sale.get();
    }

    public Sale addSale(Sale sale){
        saleRep.save(sale);
        return sale;
    }

    public Sale updateSale(int id,Sale sale){
        sale.setId(id);
        saleRep.save(sale);
        return sale;
    }

    public void deleteSale(int id){
        saleRep.deleteById(id);
    }
}
