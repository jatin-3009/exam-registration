package com.project.exam_registration.service;

import com.project.exam_registration.dto.CreateExamRequestDto;
import com.project.exam_registration.dto.UpdateExamRequestDto;
import com.project.exam_registration.entity.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {
    List<Exam> getExams();

    String createExam(CreateExamRequestDto createExamRequestDto);

    Exam updateExam(String id, UpdateExamRequestDto updateExamRequestDto);

    void deleteExam(String id);
}
