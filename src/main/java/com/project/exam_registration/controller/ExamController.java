package com.project.exam_registration.controller;

import com.project.exam_registration.dto.CreateExamRequestDto;
import com.project.exam_registration.dto.UpdateExamRequestDto;
import com.project.exam_registration.entity.Exam;
import com.project.exam_registration.service.ExamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class ExamController {
    @Autowired
    private ExamService examService;
    private static final String EXAM_API_ENDPOINT = "/exams";

    @GetMapping(EXAM_API_ENDPOINT)
    public ResponseEntity<List<Exam>> getExams() {
        List<Exam> students = examService.getExams();
        return ResponseEntity.ok(students);
    }

    @PostMapping(EXAM_API_ENDPOINT)
    public ResponseEntity<String> createExam(@Valid @RequestBody CreateExamRequestDto createExamRequestDto) {
        String id = examService.createExam(createExamRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping(EXAM_API_ENDPOINT + "/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable("id") String id, @Valid @RequestBody UpdateExamRequestDto updateExamRequestDto) {
        Exam updateExam = examService.updateExam(id, updateExamRequestDto);
        return ResponseEntity.ok(updateExam);
    }

    @DeleteMapping(EXAM_API_ENDPOINT + "/{id}")
    public ResponseEntity<String> deleteExam(@PathVariable("id") String id) {
        examService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }
}
