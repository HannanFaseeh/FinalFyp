package com.example.fyp.Service;
import com.example.fyp.Entity.InventoryManager;
import com.example.fyp.Exceptions.NotFoundException;
import com.example.fyp.Repository.InventoryManagerRep;
import com.example.fyp.Repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InventoryManagerService {
    @Autowired
    private InventoryManagerRep inventoryManagerRep;

    public List<InventoryManager> getManagers(){return inventoryManagerRep.findAll();}

    public InventoryManager getManager(int id){
        Optional<InventoryManager> manager = inventoryManagerRep.findById(id);
        if(!manager.isPresent()){
            throw new NotFoundException("manager not found!");
        }
        return manager.get();
    }
    public InventoryManager addManager(InventoryManager manager){
        inventoryManagerRep.save(manager);
        return manager;
    }
    public InventoryManager updateManager(int id,InventoryManager manager){
        manager.setId(id);
        inventoryManagerRep.save(manager);
        return manager;
    }
    public void deleteManager(int id){
        inventoryManagerRep.deleteById(id);
    }
}
