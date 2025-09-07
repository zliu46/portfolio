package com.portfolio.demo.controller;

import com.portfolio.demo.model.Project;
import com.portfolio.demo.repo.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectPageController {
  private final ProjectRepository repo;
  public ProjectPageController(ProjectRepository repo) { this.repo = repo; }

  @GetMapping("/{id}")
  public String detail(@PathVariable String id, Model model) {
    Project p = repo.findById(id);
    if (p == null) throw new ProjectNotFound(id);
    model.addAttribute("project", p);    // <-- attribute name = "project"
    return "project";                     // <-- templates/project.html
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ProjectNotFound.class)
  public String notFound(ProjectNotFound ex, Model model) {
    model.addAttribute("message", "Project not found: " + ex.id);
    return "project-404";
  }
  static class ProjectNotFound extends RuntimeException { final String id; ProjectNotFound(String id){this.id=id;} }
}
