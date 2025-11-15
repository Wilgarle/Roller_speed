package com.roller_speed_academy.v1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")

public class IndexController {
    
    @GetMapping
    public String home() {
        return "/home/index";
    }
    
    @GetMapping("/index")
    public String index() {
        return "/home/index";
    }  

    @GetMapping("/mision")
    public String mision() {
        return "/home/mision";
    }

    @GetMapping("/vision")
    public String vision() {
        return "/home/vision";
    }

    @GetMapping("/valores")
    public String valores() {
        return "/home/valores";
    }   

    @GetMapping("/servicios")
    public String servicios() {
        return "/home/servicios";
    }   

    @GetMapping("/eventos")
    public String eventos() {
        return "/home/eventos";
    }
    

    
}

