package com.project.exam_registration.service;

import com.project.exam_registration.dto.CreateStudentRequestDto;
import com.project.exam_registration.dto.UpdateStudentRequestDto;
import com.project.exam_registration.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getStudents();

    Long createStudent(CreateStudentRequestDto createStudentRequestDto);

    Student updateStudent(String id, UpdateStudentRequestDto updateStudentRequestDto);

    void deleteStudent(Long id);
}
