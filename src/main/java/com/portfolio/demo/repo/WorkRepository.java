package com.portfolio.demo.repo;

import com.portfolio.demo.model.Work;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class WorkRepository {
  private final List<Work> items = new ArrayList<>();

  @PostConstruct
  void seed() {
    items.add(new Work(
      "Back-end Developer",
      "REVATURE",
      "Remote",
      "May 2025 – Present",
      List.of(
        "Built backend APIs using Java, Spring Boot, JDBC",
        "Developed user/message endpoints with Spring MVC & JPA",
        "Created REST endpoints with custom validation and SQL",
        "Wrote integration tests with prebuilt models & SQL scripts"
      )
    ));
    items.add(new Work(
      "Game Operations Assistant",
      "Seattle University",
      "Seattle, WA",
      "Aug 2022 – Mar 2025",
      List.of(
        "Managed event logistics: setup, ticketing, guest services, crowd control",
        "Enforced venue policies and safety protocols",
        "Used Ticketmaster & W2W for staff scheduling and check-in/out",
        "Resolved attendee issues to ensure positive guest experience"
      )
    ));
  }

  public List<Work> findAll() { return Collections.unmodifiableList(items); }
}
