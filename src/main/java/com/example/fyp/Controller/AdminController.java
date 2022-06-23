//package com.example.fyp.Controller;
//
//import com.example.fyp.Entity.Admin;
//import com.example.fyp.Service.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
////@RestController
////@RequestMapping(value = "/Admin")
//@Controller
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class AdminController {
//    @Autowired
//    private AdminService adminService;
//
//
///*    @GetMapping(value = "/Admin")
//    public List<AdminService> getAdmin(){
//        return  adminService.getAdmin();
//    }*/
////    @GetMapping(value = "/Admin/{id}")
////    public Admin getAdmin(@PathVariable int id){
////        return adminService.getAdmin(id);}
//
//    @GetMapping(value = "/Admin")
//    public String RegisterAdmin(Model model) {
//        System.out.println("Get Reg");
//
//        // create student object to hold student form data
//        Admin admin = new Admin();
//        model.addAttribute("Admin", admin);
//
//        return "registration";
//    }
//
//    @PostMapping("/AdminRegister")
//    public String saveStudent(@ModelAttribute("Admin") Admin admin) {
//        System.out.println("Post Reg");
//
//        adminService.addAdmin(admin);
//
//        System.out.println("Post Reg 2");
//
//        return "redirect:/index";
//    }
//
////    @PutMapping(value = "/{id}")
////    public Admin updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
////        return adminService.updateAdmin(id,admin);
////    }
//
//    @DeleteMapping(value = "/{id}")
//    public void deleteAdmin(@PathVariable int id){
//        adminService.deleteAdmin(id);
//
//    }
//
//}