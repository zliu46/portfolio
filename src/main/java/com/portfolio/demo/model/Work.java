package com.portfolio.demo.model;

import java.util.List;

public class Work {
  private String role;
  private String company;
  private String location;
  private String dates;
  private List<String> bullets;

  public Work() {}
  public Work(String role, String company, String location, String dates, List<String> bullets) {
    this.role = role; this.company = company; this.location = location; this.dates = dates; this.bullets = bullets;
  }
  public String getRole() { return role; }
  public String getCompany() { return company; }
  public String getLocation() { return location; }
  public String getDates() { return dates; }
  public List<String> getBullets() { return bullets; }
}
