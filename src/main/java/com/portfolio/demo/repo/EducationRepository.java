package com.portfolio.demo.repo;

import com.portfolio.demo.model.Education;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EducationRepository {
    private final List<Education> items = new ArrayList<>();

    @PostConstruct
    void seed() {
        items.add(new Education(
            "Seattle University",
            "Master of Science in Computer Science",
            "Seattle, WA",
            "2023 – 2025",
            "Graduated March 2025 with strong focus on backend systems, software engineering, and cloud applications."
        ));
        items.add(new Education(
            "University of [Your Undergrad]",
            "Bachelor of Science in [Your Major]",
            "[City, State/Country]",
            "2018 – 2022",
            "Coursework in algorithms, databases, and web development."
        ));
    }

    public List<Education> findAll() {
        return Collections.unmodifiableList(items);
    }
}
