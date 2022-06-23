package com.example.fyp.Controller;

import com.example.fyp.Entity.Accountant;
import com.example.fyp.Service.AccountantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountantController {
    @Autowired
    private AccountantService accountantService;


    //@GetMapping(value = "/Accountant")
    //public List<AccountantService> getAccountant(){
        //return  AccountantService.getaccountant();
    //}
    @GetMapping(value = "/Accountant/{id}")
    public Accountant getAccountant(@PathVariable int id){
        return accountantService.getAccountant(id);}

    @GetMapping(value = "/Accountant")
    public String RegisterAccountant(Model model) {
        System.out.println("Get Reg");

        // create student object to hold student form data
        Accountant accountant = new Accountant();
        model.addAttribute("Accountant", accountant);

        return "registrationn";
    }

    @PostMapping("/AccountantRegister")
    public String saveAccountant(@ModelAttribute("Accountant")  Accountant accountant ) {
        System.out.println("Post Reg");

        accountantService.addAccountant(accountant);

        System.out.println("Post Reg 2");

        return "redirect:/index";
    }

    @PutMapping(value = "/AccountantRegister/{id}")
    public Accountant updateAccountant(@PathVariable int id, @RequestBody Accountant accountant) {
        return accountantService.updateAccountant(id,accountant);
    }

    @DeleteMapping(value = "/AccountantRegister/{id}")
    public void deleteAccountant(@PathVariable int id){
        accountantService.deleteAccountant(id);
    }

}