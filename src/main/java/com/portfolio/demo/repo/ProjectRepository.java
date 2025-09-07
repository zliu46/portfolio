package com.portfolio.demo.repo;

import com.portfolio.demo.model.Project;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProjectRepository {
    private final List<Project> projects = new ArrayList<>();

    @PostConstruct
    void seed() {
        // --- Project 1 ---
        Project p1 = new Project(
            "p1",
            "Spring Social Media Blog API",
            "RESTful backend with user auth and CRUD",
            2025,
            "https://picsum.photos/800/600?random=101",
            List.of("Spring Boot", "Spring MVC", "Spring Data"),
            List.of("Backend"),
            "#"
        );
        p1.setDescription("""
            Built a microblog API with authentication, user management, and CRUD endpoints.
            Features: validation, error semantics, pagination, and integration tests with SQL.
        """);
        projects.add(p1);

        // --- Project 2 ---
        Project p2 = new Project(
            "p2",
            "Partners",
            "Task management app with AI integration",
            2025,
            "https://picsum.photos/800/600?random=102",
            List.of("Flutter", "Firebase", "Gemini API"),
            List.of("Full-stack"),
            "#"
        );
        p2.setDescription("""
            Cross-platform app for collaborative task management.
            Real-time sync with Firebase, AI-assisted suggestions, and push notifications.
        """);
        projects.add(p2);

        // --- Project 3 ---
        Project p3 = new Project(
            "p3",
            "GAN",
            "Real-time address search API",
            2024,
            "https://picsum.photos/800/600?random=103",
            List.of("ASP.NET Core", "Redis", "OAuth"),
            List.of("Backend", "DevOps"),
            "#"
        );
        p3.setDescription("""
            REST API for address search with caching and OAuth2 integration.
            Implemented Redis for performance and scalability.
        """);
        projects.add(p3);

        // --- Project 4 ---
        Project p4 = new Project(
            "p4",
            "Pawfect",
            "Pet adoption API with 100% test coverage",
            2023,
            "https://picsum.photos/800/600?random=104",
            List.of("ASP.NET Core", "C#", "Entity Framework"),
            List.of("Backend"),
            "#"
        );
        p4.setDescription("""
            Backend API for pet adoption platform with full test coverage.
            Features include pet search, user profiles, and adoption workflows.
        """);
        projects.add(p4);

        // --- Project 5 ---
        Project p5 = new Project(
            "p5",
            "SipTrip",
            "Discover and plan beverage tasting trips",
            2025,
            "https://picsum.photos/800/600?random=105", // or choose a custom image
            List.of("Figma", "UX Design", "Prototyping"),
            List.of("Frontend", "Web App"),
            "https://siptripapp.wixsite.com/siptrip"
        );
        p5.setDescription("""
            A web-based platform for exploring and planning beverage tasting trips. 
            Built with Wix, featuring modern responsive design, easy navigation, and curated trip content.
        """);
        projects.add(p5);

    }

    public List<Project> findAll() {
        return Collections.unmodifiableList(projects);
    }

    public Project findById(String id) {
        return projects.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
