package com.example.fyp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {


    @RequestMapping(value = "/hello")
//    @GetMapping(value = "/hello")
    public String view()
    {
        return "index";
    }

}
