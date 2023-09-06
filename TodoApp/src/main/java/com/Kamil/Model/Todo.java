package com.Kamil.Model;

import java.time.LocalDate;

public class Todo {
    private Long id;
    private String title;
    private String username;
    private String description;
    private LocalDate targetDate;
    private boolean status;

    public Todo() {}; // default constructor

    // // parameterized constructor without id parameter if we want ot set id own we can do this with setId method
    public Todo(String title, String username, String description, LocalDate targetDate, boolean status) {
        this.title = title;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
