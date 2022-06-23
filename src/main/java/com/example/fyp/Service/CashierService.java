package com.example.fyp.Service;
import com.example.fyp.Entity.Cashier;
import com.example.fyp.Exceptions.NotFoundException;
import com.example.fyp.Repository.CashierRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashierService {
    @Autowired
    private CashierRep cashierRep;

    public List<Cashier> getCashier(){return cashierRep.findAll();}

    public Cashier getCashier(int id){
        Optional<Cashier> cashier = cashierRep.findById(id);
        if(!cashier.isPresent()){
            throw new NotFoundException("Cashier not found!");
        }
        return cashier.get();
    }
    public Cashier addCashier(Cashier cashier){
        cashierRep.save(cashier);
        return cashier;
    }
    public Cashier updateCashier(int id,Cashier cashier){
        cashier.setId(id);
        cashierRep.save(cashier);
        return cashier;
    }
    public void deleteCashier(int id){
        cashierRep.deleteById(id);
    }
}
