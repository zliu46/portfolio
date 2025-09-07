package com.portfolio.demo.controller;

import com.portfolio.demo.model.Education;
import com.portfolio.demo.repo.EducationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationApiController {
    private final EducationRepository repo;

    public EducationApiController(EducationRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Education> all() {
        return repo.findAll();
    }
}
