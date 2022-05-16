package com.example.fyp.Controller;

import com.example.fyp.Entity.Inventory;
import com.example.fyp.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;


    @GetMapping
    public List<Inventory> getManagers(){
        return  inventoryService.getInventorys();
    }
    @GetMapping(value = "/{id}")
    public Inventory getInventory(@PathVariable int id){
        return inventoryService.getInventory(id);}

    @PostMapping
    public ResponseEntity<?> addInventory(@Valid @RequestBody Inventory inventory, BindingResult result) {
        if (result.hasErrors()) {

            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
        }
        Inventory p = inventoryService.addInventory(inventory);
        return new ResponseEntity<Inventory>(p, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public Inventory updateInventory(@PathVariable int id, @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(id, inventory);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteInventory(@PathVariable int id){
        inventoryService.deleteInventory(id);

    }
}
