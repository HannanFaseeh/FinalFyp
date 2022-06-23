package com.example.fyp.Controller;

import com.example.fyp.Entity.PurchaseManager;
import com.example.fyp.Service.PurchaseManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping(value = "/inventoryManager")
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseManagerController {
    @Autowired
    private PurchaseManagerService purchaseManagerService;


    @GetMapping(value = "/PurchaseManager")
    public List<PurchaseManager> getManagers(){
        return  purchaseManagerService.getManagers();
    }
    @GetMapping(value = "/PurchaseManager/{id}")
    public PurchaseManager getManager(@PathVariable int id){
        return purchaseManagerService.getManager(id);}

    @GetMapping(value = "/PurchaseManager/Register")
    public String RegisterManager(Model model) {
        System.out.println("Get Reg");

        // create student object to hold student form data
        PurchaseManager manager = new PurchaseManager();
        model.addAttribute("manager", manager);

        return "registrationn";
    }

    @PostMapping("/PurchaseManager/Register")
    public String saveStudent(@ModelAttribute("manger")  PurchaseManager manager ) {
        System.out.println("Post Reg");

        purchaseManagerService.addManager(manager);

        System.out.println("Post Reg 2");

        return "redirect:/index";
    }

    @PutMapping(value = "/PurchaseManager/{id}")
    public PurchaseManager updateManager(@PathVariable int id, @RequestBody PurchaseManager purchaseManager) {
        return purchaseManagerService.updateManager(id, purchaseManager);
    }

    @DeleteMapping(value = "/PurchaseManager/{id}")
    public void deleteManager(@PathVariable int id){
        purchaseManagerService.deleteManager(id);

    }

}