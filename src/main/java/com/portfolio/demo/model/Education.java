package com.portfolio.demo.model;

public class Education {
    private String school;
    private String degree;
    private String location;
    private String dates;
    private String details;

    public Education() {}

    public Education(String school, String degree, String location, String dates, String details) {
        this.school = school;
        this.degree = degree;
        this.location = location;
        this.dates = dates;
        this.details = details;
    }

    public String getSchool() { return school; }
    public String getDegree() { return degree; }
    public String getLocation() { return location; }
    public String getDates() { return dates; }
    public String getDetails() { return details; }
}
