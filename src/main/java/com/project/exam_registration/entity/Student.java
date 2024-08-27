package com.project.exam_registration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> exams;
}
