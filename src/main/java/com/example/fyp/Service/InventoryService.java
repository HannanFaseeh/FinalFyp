package com.example.fyp.Service;

import com.example.fyp.Entity.Inventory;
import com.example.fyp.Repository.InventoryRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryRep inventoryRep;


    public List<Inventory> getInventorys() {return inventoryRep.findAll();}

    public Inventory getInventory(int id){
        Optional<Inventory> inventory = inventoryRep.findById(id);
        if(!inventory.isPresent()){
            //throw new NotFoundException("Inventory not found!");
        }
        return inventory.get();
    }

    public Inventory addInventory(Inventory inventory){
        inventoryRep.save(inventory);
        return inventory;
    }

    public Inventory updateInventory(int id,Inventory inventory){
        inventory.setInventoryId(id);
        inventoryRep.save(inventory);
        return inventory;
    }

    public void deleteInventory(int id){
        inventoryRep.deleteById(id);
    }
}
