package com.example.fyp.Controller;

import com.example.fyp.Entity.InventoryManager;
import com.example.fyp.Service.InventoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
//@RequestMapping(value = "/inventoryManager")
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InventoryManagerController {
    @Autowired
    private InventoryManagerService inventoryManagerService;


    @GetMapping(value = "/InventoryManager")
    public List<InventoryManager> getManagers(){
        return  inventoryManagerService.getManagers();
    }
    @GetMapping(value = "/InventoryManager/{id}")
    public InventoryManager getManager(@PathVariable int id){
        return inventoryManagerService.getManager(id);}



    @GetMapping(value = "/registerr")
    public String RegisterManager(Model model) {
        System.out.println("Get Reg");

        // create student object to hold student form data
        InventoryManager manager = new InventoryManager();
        model.addAttribute("manager", manager);

        return "registrationn";
    }
    @GetMapping(value = "/indexxx")
    public String view(Model model)
    {
        /**/
        model.addAttribute("attr","hello");
        return "index";
    }


    @PostMapping("/registerr")
    public String saveStudent(@ModelAttribute("manger")  InventoryManager manager ) {
        System.out.println("Post Reg");

        inventoryManagerService.addManager(manager);

        System.out.println("Post Reg 2");

        return "redirect:/index";
    }

    @PutMapping(value = "/{id}")
    public InventoryManager updateManager(@PathVariable int id, @RequestBody InventoryManager inventoryManager) {
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

    @DeleteMapping(value = "/{id}")
    public void deleteManager(@PathVariable int id){
        inventoryManagerService.deleteManager(id);

    }

}