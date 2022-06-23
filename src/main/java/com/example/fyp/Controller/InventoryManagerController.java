package com.example.fyp.Controller;

import com.example.fyp.Entity.InventoryManager;
import com.example.fyp.Service.InventoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InventoryManagerController {
    @Autowired
    private InventoryManagerService inventoryManagerService;


    @GetMapping(value = "/InventoryManager")
    public List<InventoryManager> getInventoryManagers(){
        return  inventoryManagerService.getManagers();
    }
    @GetMapping(value = "/InventoryManager/{id}")
    public InventoryManager getInventoryManager(@PathVariable int id){
        return inventoryManagerService.getManager(id);}



    @GetMapping(value = "/InventoryManager/registerr")
    public String RegisterInventoryManager(Model model) {
        System.out.println("Get Reg");
        // create student object to hold student form data
        InventoryManager manager = new InventoryManager();
        model.addAttribute("InventoryManager", manager);
        return "inventoryManager";
    }


    @PostMapping("/InventoryManager/registerr")
    public String saveInventoryManager(@ModelAttribute("manger")  InventoryManager manager ) {
        System.out.println("Post Reg");
        inventoryManagerService.addManager(manager);
        System.out.println("Post Reg 2");
        return "redirect:/index";
    }

    @PutMapping(value = "/InventoryManager/{id}")
    public InventoryManager updateInventoryManager(@PathVariable int id, @RequestBody InventoryManager inventoryManager) {
        return inventoryManagerService.updateManager(id, inventoryManager);
    }

//    @PostMapping
//    public ResponseEntity<?> addManager(@Valid @RequestBody InventoryManager inventoryManager, BindingResult result) {
//        if (result.hasErrors()) {
//
//            Map<String, String> errors = new HashMap<>();
//            for (FieldError error : result.getFieldErrors()) {
//                errors.put(error.getField(), error.getDefaultMessage());
//            }
//            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
//        }
//        InventoryManager p = inventoryManagerService.addManager(inventoryManager);
//        return new ResponseEntity<InventoryManager>(p, HttpStatus.CREATED);
//    }

    @DeleteMapping(value = "/InventoryManager/{id}")
    public void deleteInventoryManager(@PathVariable int id){
        inventoryManagerService.deleteManager(id);
    }

}