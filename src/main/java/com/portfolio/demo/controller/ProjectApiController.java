package com.portfolio.demo.controller;

import com.portfolio.demo.model.Project;
import com.portfolio.demo.repo.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectApiController {
  private final ProjectRepository repo;
  public ProjectApiController(ProjectRepository repo) { this.repo = repo; }

  @GetMapping
  public List<Project> all() { return repo.findAll(); }
}
