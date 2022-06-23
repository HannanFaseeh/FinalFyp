package com.example.fyp.Controller;

import com.example.fyp.Entity.InventoryManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class AppController {
    @GetMapping(value = "/index")
    public String view(Model model)
    {
        /**/
        model.addAttribute("attr","hello");
        return "index";
    }
    @GetMapping(value = "/jugar")
    public String Myview(Model model)
    {

        System.out.println("Jugaar");

        // create student object to hold student form data
        InventoryManager manager = new InventoryManager();
        model.addAttribute("manager", manager);

        /**/
        return "jugaro";
    }
//    @GetMapping(value = "/Register")
//    public String Register()
//    {
//        return "RegisterPage";
//    }
//

    //Master Admin
    @GetMapping(value = "/Dashboard")
    public String Dashboard_view()
    {
        return "dashboard";
    }


    @GetMapping(value = "/MasterAdmin")
    public String Admin_view()
    {
        return "MasterAdmin";
    }

    @GetMapping(value = "/EmployeeDetails")
    public String EmployeeDetail()
    {
        return "EmployeeDetails";
    }

    //Inventory Manager

    @GetMapping(value = "/InventoryManager2")
    public String InventoryManager()
    {
        return "InventoryManager";
    }


    //Purchase Manager

    @GetMapping(value = "/PurchaseManager")
    public String PurchaseManager()
    {
        return "PurchaseManager";
    }
}