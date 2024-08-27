package com.project.exam_registration.controller;

import com.project.exam_registration.dto.CreateSubjectRequestDto;
import com.project.exam_registration.dto.UpdateSubjectRequestDto;
import com.project.exam_registration.entity.Subject;
import com.project.exam_registration.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    private static final String SUBJECT_API_ENDPOINT = "/subjects";

    @GetMapping(SUBJECT_API_ENDPOINT)
    public ResponseEntity<List<Subject>> getSubjects() {
        List<Subject> students = subjectService.getSubjects();
        return ResponseEntity.ok(students);
    }

    @PostMapping(SUBJECT_API_ENDPOINT)
    public ResponseEntity<String> createSubject(@Valid @RequestBody CreateSubjectRequestDto createSubjectRequestDto) {
        String id = subjectService.createSubject(createSubjectRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping(SUBJECT_API_ENDPOINT + "/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable("id") String id, @Valid @RequestBody UpdateSubjectRequestDto updateSubjectRequestDto) {
        Subject updateSubject = subjectService.updateSubject(id, updateSubjectRequestDto);
        return ResponseEntity.ok(updateSubject);
    }

    @DeleteMapping(SUBJECT_API_ENDPOINT + "/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") String id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
