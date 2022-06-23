package com.example.fyp.Service;
import com.example.fyp.Entity.PurchaseManager;
import com.example.fyp.Exceptions.NotFoundException;
import com.example.fyp.Repository.PurchaseManagerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseManagerService {
    @Autowired
    private PurchaseManagerRep purchaseManagerRep;

    public List<PurchaseManager> getManagers(){return purchaseManagerRep.findAll();}

    public PurchaseManager getManager(int id){
        Optional<PurchaseManager> manager = purchaseManagerRep.findById(id);
        if(!manager.isPresent()){
            throw new NotFoundException("manager not found!");
        }
        return manager.get();
    }
    public PurchaseManager addManager(PurchaseManager manager){
        purchaseManagerRep.save(manager);
        return manager;
    }
    public PurchaseManager updateManager(int id,PurchaseManager manager){
        manager.setId(id);
        purchaseManagerRep.save(manager);
        return manager;
    }
    public void deleteManager(int id){
        purchaseManagerRep.deleteById(id);
    }
}
