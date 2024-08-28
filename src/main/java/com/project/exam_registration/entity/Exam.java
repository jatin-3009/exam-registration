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
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue
    private Long Id;
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToMany(mappedBy = "exams", cascade = CascadeType.ALL)
    private List<Student> students;
}
