package com.project.studyhut_backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postID;
    private String keywords;
    private String title;
    private String notes;
    private LocalDateTime dateTime;
    @ManyToOne
    private Course course;
    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String keywords, String title, String notes, LocalDateTime dateTime, Course course, User user) {
        this.keywords = keywords;
        this.title = title;
        this.notes = notes;
        this.dateTime = dateTime;
        this.course = course;
        this.user = user;
    }

    public Integer getPostID() {
        return postID;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
