package com.example.fyp.Controller;


import com.example.fyp.Entity.InventoryManager;
import com.example.fyp.Entity.Sale;
import com.example.fyp.Service.SaleService;
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
@RequestMapping(value = "/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> getSales(){
        return  saleService.getSales();
    }
    @GetMapping(value = "/{id}")
    public Sale getSale(@PathVariable int id){
        return saleService.getSale(id);}


    @PostMapping
    public ResponseEntity<?> addSale(@Valid @RequestBody Sale sale, BindingResult result) {
        if (result.hasErrors()) {

            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
        }
        Sale p = saleService.addSale(sale);
        return new ResponseEntity<Sale>(p, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public Sale updateSale(@PathVariable int id, @RequestBody Sale sale ) {
        return saleService.updateSale(id, sale);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSale(@PathVariable int id){
        saleService.deleteSale(id);
    }

}

