package com.pixelweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String inde(Model model){
        model.addAttribute("date",new Date());
        model.addAttribute("usename","Sekhar");
        return "index";
    }
}
