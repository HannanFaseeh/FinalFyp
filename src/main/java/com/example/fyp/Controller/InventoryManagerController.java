package com.example.fyp.Controller;

import com.example.fyp.Entity.InventoryManager;
import com.example.fyp.Service.InventoryManagerService;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InventoryManagerController {
    @Autowired
    private InventoryManagerService inventoryManagerService;


    @GetMapping
    public List<InventoryManager> getManagers(){
        return  inventoryManagerService.getManagers();
    }
    @GetMapping(value = "/{id}")
    public InventoryManager getManager(@PathVariable int id){
        return inventoryManagerService.getManager(id);}

    @PostMapping
    public ResponseEntity<?> addManager(@Valid @RequestBody InventoryManager inventoryManager, BindingResult result) {
        if (result.hasErrors()) {

           Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
        }
        InventoryManager p = inventoryManagerService.addManager(inventoryManager);
        return new ResponseEntity<InventoryManager>(p, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public InventoryManager updateManager(@PathVariable int id, @RequestBody InventoryManager inventoryManager) {
        return inventoryManagerService.updateManager(id, inventoryManager);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteManager(@PathVariable int id){
        inventoryManagerService.deleteManager(id);

    }

}
