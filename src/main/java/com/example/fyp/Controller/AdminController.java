package com.example.fyp.Controller;

import com.example.fyp.Service.AdminService;
import com.example.fyp.Service.InventoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/admin")

@Controller
@RequestMapping(value = "")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    @Autowired
    private AdminService adminService;

}
