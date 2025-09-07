package com.portfolio.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "Zhou Liu");
        // other attributes if you want to pass them to about.html
        return "about"; // this loads src/main/resources/templates/about.html
    }
}
