package com.project.exam_registration.dto;

import com.project.exam_registration.entity.Exam;
import com.project.exam_registration.entity.Subject;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CreateStudentRequestDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private List<Subject> subjects;
    private List<Exam> exams;
}
