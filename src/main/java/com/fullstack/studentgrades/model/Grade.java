package com.fullstack.studentgrades.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subject;
    private double score;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Constructors, getters, and setters
    public Grade() {}

    public Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    // id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // score
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // student
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
