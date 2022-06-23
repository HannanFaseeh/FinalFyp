package com.example.fyp.Service;
import com.example.fyp.Entity.Accountant;
import com.example.fyp.Exceptions.NotFoundException;
import com.example.fyp.Repository.AccountantRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountantService {
    @Autowired
    private AccountantRep accountantRep;

    public List<Accountant> getAccountants(){return accountantRep.findAll();}

    public Accountant getAccountant(int id){
        Optional<Accountant> accountant = accountantRep.findById(id);
        if(!accountant.isPresent()){
            throw new NotFoundException("Accountant not found!");
        }
        return accountant.get();
    }
    public Accountant addAccountant(Accountant accountant){
        accountantRep.save(accountant);
        return accountant;
    }
    public Accountant updateAccountant(int id,Accountant accountant){
        accountant.setId(id);
        accountantRep.save(accountant);
        return accountant;
    }
    public void deleteAccountant(int id){
        accountantRep.deleteById(id);
    }
}
