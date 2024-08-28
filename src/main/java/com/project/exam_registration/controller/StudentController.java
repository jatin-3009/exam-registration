package com.project.exam_registration.controller;

import com.project.exam_registration.dto.CreateStudentRequestDto;
import com.project.exam_registration.dto.UpdateStudentRequestDto;
import com.project.exam_registration.entity.Student;
import com.project.exam_registration.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    private static final String STUDENT_API_ENDPOINT = "/students";

    @GetMapping(STUDENT_API_ENDPOINT)
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping(STUDENT_API_ENDPOINT)
    public ResponseEntity<Long> createStudent(@Valid @RequestBody CreateStudentRequestDto createStudentRequestDto) {
        Long id = studentService.createStudent(createStudentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping(STUDENT_API_ENDPOINT + "/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") String id, @Valid @RequestBody UpdateStudentRequestDto updateStudentRequestDto) {
        Student updateStudent = studentService.updateStudent(id, updateStudentRequestDto);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping(STUDENT_API_ENDPOINT + "/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
