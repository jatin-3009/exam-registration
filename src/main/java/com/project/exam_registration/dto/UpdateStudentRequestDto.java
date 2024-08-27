package com.project.exam_registration.dto;

import com.project.exam_registration.entity.Exam;
import com.project.exam_registration.entity.Subject;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpdateStudentRequestDto {
    private String name;
    private List<Subject> subjects;
    private List<Exam> exams;
}
