package com.project.exam_registration.service;

import com.project.exam_registration.dto.CreateStudentRequestDto;
import com.project.exam_registration.dto.UpdateStudentRequestDto;
import com.project.exam_registration.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    String createStudent(CreateStudentRequestDto createStudentRequestDto);

    Student updateStudent(String id, UpdateStudentRequestDto updateStudentRequestDto);

    void deleteStudent(String id);
}
