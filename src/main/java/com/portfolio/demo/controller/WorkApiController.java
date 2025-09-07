package com.portfolio.demo.controller;

import com.portfolio.demo.model.Work;
import com.portfolio.demo.repo.WorkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class WorkApiController {
  private final WorkRepository repo;
  public WorkApiController(WorkRepository repo) { this.repo = repo; }

  @GetMapping
  public List<Work> all() { return repo.findAll(); }
}
