package com.example.fyp.Controller;

import com.example.fyp.Entity.InventoryManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @GetMapping(value = "/index")
    public String view(Model model)
    {
        /**/
        model.addAttribute("attr","hello");
        return "index";
    }
//    @GetMapping(value = "/Register")
//    public String Register()
//    {
//        return "RegisterPage";
//    }
//


    @GetMapping(value = "/Dashboard")
    public String Dashboard_view()
    {
        return "dashboard";
    }




}