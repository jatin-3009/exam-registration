package com.project.exam_registration.util;

import com.project.exam_registration.entity.Exam;
import com.project.exam_registration.exception.ExamNotFoundException;
import com.project.exam_registration.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExamUtility {
    @Autowired
    private ExamRepository examRepository;

    public List<Exam> fetchExamsByIds(List<Long> examIds) {
        List<Exam> exams = new ArrayList<>();
        for (Long id : examIds) {
            Exam exam = examRepository.findById(id).orElseThrow(() -> new ExamNotFoundException("Exam not found with id: " + id));
            exams.add(exam);
        }
        return exams;
    }
}
