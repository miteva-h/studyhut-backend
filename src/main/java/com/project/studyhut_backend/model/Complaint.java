package com.project.studyhut_backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer complaintID;
    private LocalDateTime dateTimeCreated;
    private String content;
    private boolean isSolved;
    @ManyToOne
    private User user;

    public Complaint() {
    }

    public Complaint(LocalDateTime dateTimeCreated, String content, boolean isSolved, User user) {
        this.dateTimeCreated = dateTimeCreated;
        this.content = content;
        this.isSolved = isSolved;
        this.user = user;
    }

    public Integer getComplaintID() {
        return complaintID;
    }

    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
