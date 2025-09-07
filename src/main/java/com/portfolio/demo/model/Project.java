package com.portfolio.demo.model;

import java.util.List;

public class Project {
    private String id;
    private String title;
    private String subtitle;
    private Integer year;
    private String coverUrl;
    private List<String> tags;
    private List<String> roles;
    private String link;
    private String description; // <-- you declared this

    public Project() {}

    public Project(String id, String title, String subtitle, Integer year,
                   String coverUrl, List<String> tags, List<String> roles, String link) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.year = year;
        this.coverUrl = coverUrl;
        this.tags = tags;
        this.roles = roles;
        this.link = link;
    }

    // --- getters ---
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getSubtitle() { return subtitle; }
    public Integer getYear() { return year; }
    public String getCoverUrl() { return coverUrl; }
    public List<String> getTags() { return tags; }
    public List<String> getRoles() { return roles; }
    public String getLink() { return link; }
    public String getDescription() { return description; }  // <-- add this

    // --- setters (optional, but needed if you want to set description later) ---
    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }
    public void setYear(Integer year) { this.year = year; }
    public void setCoverUrl(String coverUrl) { this.coverUrl = coverUrl; }
    public void setTags(List<String> tags) { this.tags = tags; }
    public void setRoles(List<String> roles) { this.roles = roles; }
    public void setLink(String link) { this.link = link; }
    public void setDescription(String description) { this.description = description; } // <-- add this
}
