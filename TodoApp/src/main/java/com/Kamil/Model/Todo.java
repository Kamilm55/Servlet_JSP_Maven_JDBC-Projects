package com.Kamil.Model;

import java.sql.Date;
import java.time.LocalDate;

public class Todo {
    private Long id;
    private String title;
    private String email;
    private String description;
    private LocalDate targetDate;
    private boolean status;

    public Todo() {}; // default constructor

    public Todo(Long id, String title, String email, String description, LocalDate targetDate, boolean status) {
        this.id = id;
        this.title = title;
        this.email = email;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    // // parameterized constructor without id parameter if we want ot set id own we can do this with setId method
    public Todo(String email,String title,  String description, LocalDate targetDate, boolean status) {
        this.title = title;
        this.email = email;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
