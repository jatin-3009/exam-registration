package com.project.exam_registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException studentNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentNotFoundException.getMessage());
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleSubjectNotFound(SubjectNotFoundException subjectNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(subjectNotFoundException.getMessage());
    }

    @ExceptionHandler(ExamNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleStudentNotFound(ExamNotFoundException examNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(examNotFoundException.getMessage());
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<String> handleStudentNotFound(CustomException customException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customException.getMessage());
    }
}
