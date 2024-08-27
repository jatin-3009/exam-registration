package com.project.exam_registration.service;

import com.project.exam_registration.dto.CreateStudentRequestDto;
import com.project.exam_registration.dto.UpdateStudentRequestDto;
import com.project.exam_registration.entity.Student;
import com.project.exam_registration.exception.StudentNotFoundException;
import com.project.exam_registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public String createStudent(CreateStudentRequestDto createStudentRequestDto) {
        return null;
    }

    @Override
    public Student updateStudent(String id, UpdateStudentRequestDto updateStudentRequestDto) {
        Long studentId = Long.parseLong(id);
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {

        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        return null;
    }

    @Override
    public void deleteStudent(String id) {
        Long studentId = Long.parseLong(id);
        studentRepository.deleteById(studentId);
    }
}
