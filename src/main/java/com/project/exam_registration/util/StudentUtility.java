package com.project.exam_registration.util;

import com.project.exam_registration.entity.Student;
import com.project.exam_registration.exception.StudentNotFoundException;
import com.project.exam_registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentUtility {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> fetchStudentsByIds(List<Long> studentIds) {
        List<Student> students = new ArrayList<>();
        for (Long id : studentIds) {
            Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
            students.add(student);
        }
        return students;
    }
}
