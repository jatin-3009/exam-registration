package com.project.exam_registration.repository;

import com.project.exam_registration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
