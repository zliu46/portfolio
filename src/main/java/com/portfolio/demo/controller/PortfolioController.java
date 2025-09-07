package com.portfolio.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.demo.repo.ProjectRepository;


@Controller
public class PortfolioController {
    private final ProjectRepository repo;
    public PortfolioController(ProjectRepository repo) { this.repo = repo; }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("projects", repo.findAll());
        return "index";
    }
}


