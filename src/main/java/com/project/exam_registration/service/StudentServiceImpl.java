package com.project.exam_registration.service;

import com.project.exam_registration.dto.CreateStudentRequestDto;
import com.project.exam_registration.dto.UpdateStudentRequestDto;
import com.project.exam_registration.entity.Exam;
import com.project.exam_registration.entity.Student;
import com.project.exam_registration.entity.Subject;
import com.project.exam_registration.exception.StudentNotFoundException;
import com.project.exam_registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Long createStudent(CreateStudentRequestDto createStudentRequestDto) {
        String newName = createStudentRequestDto.getName();
        List<Subject> newSubjects = createStudentRequestDto.getSubjects();
        List<Exam> newExams = createStudentRequestDto.getExams();

        Student student = new Student();
        student.setName(newName);
        student.setSubjects(newSubjects);
        student.setExams(newExams);

        student = studentRepository.save(student);
        return student.getId();
    }

    @Override
    public Student updateStudent(String id, UpdateStudentRequestDto updateStudentRequestDto) {
        Long studentId = Long.parseLong(id);
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        String updatedName = updateStudentRequestDto.getName();
        List<Subject> updatedSubjects = updateStudentRequestDto.getSubjects();
        List<Exam> updatedExams = updateStudentRequestDto.getExams();

        if (updatedName != null && !updatedName.isBlank()) {
            student.setName(updatedName);
        }

        if (updatedSubjects != null) {
            student.setSubjects(updatedSubjects);
        }

        if (updatedExams != null) {
            student.setExams(updatedExams);
        }

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
