package com.example.fyp.Controller;

import com.example.fyp.Entity.Cashier;
import com.example.fyp.Service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping(value = "/Cashier")
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CashierController {
    @Autowired
    private CashierService cashierService;


//    @GetMapping(value = "/Cashier")
//    public List<CashierService> getCashier(){
//        return  CashierService.getCashiers();
//    }
    @GetMapping(value = "/Cashier/{id}")
    public Cashier getCashier(@PathVariable int id){
        return cashierService.getCashier(id);}

    @GetMapping(value = "/Cashier")
    public String RegisterCashier(Model model) {
        System.out.println("Get Reg");

        // create student object to hold student form data
        Cashier Cashier = new Cashier();
        model.addAttribute("Cashier", Cashier);
        return "registrationn";
    }

    @PostMapping("/Cashier/Register")
    public String saveStudent(@ModelAttribute("Cashier")  Cashier cashier  ) {
        System.out.println("Post Reg");
        cashierService.addCashier(cashier);
        System.out.println("Post Reg 2");
        return "redirect:/index";
    }

    @PutMapping(value = "/Cashier/{id}")
    public Cashier updateCashier(@PathVariable int id, @RequestBody Cashier cashier) {
        return cashierService.updateCashier(id,cashier);
    }

    @DeleteMapping(value = "/Cashier/{id}")
    public void deleteCashier(@PathVariable int id){
        cashierService.deleteCashier(id);
    }

}